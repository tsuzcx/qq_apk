package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mm.bf.c;
import com.tencent.mm.bf.d;
import com.tencent.mm.bf.g;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

public final class k
  implements com.tencent.mm.ah.f, d
{
  private Activity activity;
  private List<String> bSN = new LinkedList();
  Button lGB;
  public VolumeMeter lGC;
  RelativeLayout lGD;
  private boolean lGE = true;
  private String lGF;
  String lGG;
  private String lGH;
  boolean lGI = false;
  int lGJ = 0;
  private long lGK = 500L;
  long lGL = 0L;
  am lGM = new am(new k.1(this), false);
  am lGN = new am(new k.2(this), false);
  private am lGO = new am(new k.3(this), false);
  public c lGP;
  public k.a lGQ;
  final am lGR = new am(new k.5(this), true);
  private boolean lGS = true;
  
  public k(Activity paramActivity, Button paramButton)
  {
    this.activity = paramActivity;
    this.lGB = paramButton;
    this.lGD = ((RelativeLayout)this.activity.findViewById(a.e.volume_layout));
    this.lGD.setVisibility(8);
    this.lGC = ((VolumeMeter)this.lGD.findViewById(a.e.volume_meter));
    this.lGC.setArchView(this.lGB);
    paramActivity = this.lGC;
    if (paramActivity.lHz == null) {
      e.c(new VolumeMeter.1(paramActivity), "VolumeMeter_handler", 1).start();
    }
    this.lGP = g.eEW;
    if (this.lGP == null) {
      y.e("MicroMsg.TalkMgr", "cannot get talkroom server");
    }
  }
  
  public static void beA()
  {
    ru localru = new ru();
    localru.cbq.cbt = true;
    a.udP.m(localru);
    com.tencent.mm.compatible.b.f.yi().setMode(0);
  }
  
  public final void RM()
  {
    this.lGE = false;
    this.lGB.setEnabled(true);
    bez();
  }
  
  public final void RN()
  {
    if (this.lGJ != 1) {
      return;
    }
    this.lGJ = 5;
    if (bk.cp(this.lGL) < this.lGK)
    {
      y.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
      am localam = this.lGM;
      long l = this.lGK - bk.cp(this.lGL);
      localam.S(l, l);
      return;
    }
    bey();
  }
  
  public final void RO() {}
  
  public final void RP()
  {
    bez();
  }
  
  public final void RQ()
  {
    bez();
  }
  
  public final void RR() {}
  
  public final void aE(String paramString1, String paramString2)
  {
    y.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    if (this.lGE) {}
  }
  
  public final void bex()
  {
    this.lGH = this.activity.getIntent().getStringExtra("map_talker_name");
    this.lGP.a(this);
    y.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[] { this.lGH });
    String str = this.lGH;
    this.lGF = str;
    List localList;
    if (!bk.bl(this.lGF))
    {
      if (!s.fn(str)) {
        break label141;
      }
      localList = com.tencent.mm.model.m.gK(str);
      if (localList != null) {
        break label133;
      }
      am.a.dVy.V(str, "");
    }
    for (;;)
    {
      new ah(Looper.getMainLooper()).post(new k.6(this, str));
      this.lGB.setOnTouchListener(new k.7(this));
      return;
      label133:
      this.bSN = localList;
      continue;
      label141:
      this.bSN.clear();
      this.bSN.add(str);
      this.bSN.add(q.Gj());
    }
  }
  
  final void bey()
  {
    if (this.lGJ != 5) {
      return;
    }
    this.lGM.stopTimer();
    bez();
    au.b(ae.getContext(), a.h.talkroom_begin, new au.a()
    {
      public final void ug()
      {
        k.this.lGN.stopTimer();
        k.a(k.this);
      }
    });
    this.lGN.S(1000L, 1000L);
  }
  
  final void bez()
  {
    if (this.lGE) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (g.eEW.RL())
            {
              y.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
              if (this.lGQ != null)
              {
                this.lGQ.GF(null);
                this.lGQ.bev();
              }
            }
            switch (this.lGJ)
            {
            default: 
              return;
            case 0: 
              y.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[] { this.lGG });
            }
          } while (this.lGQ == null);
          if (!bk.bl(this.lGG))
          {
            this.lGQ.GF(this.lGG);
            return;
          }
          this.lGQ.GF(null);
          return;
          y.d("MicroMsg.TalkMgr", "seize, state seizing");
        } while (this.lGQ == null);
        this.lGQ.bew();
        return;
        y.d("MicroMsg.TalkMgr", "seize, state success or prepare");
      } while (this.lGQ == null);
      this.lGQ.beu();
      return;
      y.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[] { this.lGG });
    } while ((this.lGQ == null) || (bk.bl(this.lGG)));
    this.lGQ.GG(this.lGG);
    return;
    y.d("MicroMsg.TalkMgr", "seize time out");
  }
  
  public final void e(int paramInt1, int paramInt2, String paramString) {}
  
  public final void i(String paramString, int paramInt1, int paramInt2)
  {
    y.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[] { paramString });
    l.bdX().sY(3);
    this.activity.finish();
  }
  
  public final void jp(int paramInt)
  {
    y.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.lGJ != 3) {
        return;
      }
    }
    for (this.lGJ = 4;; this.lGJ = 2)
    {
      bez();
      au.a(ae.getContext(), a.h.talkroom_sasasa, null);
      return;
      if (this.lGJ != 1) {
        break;
      }
    }
  }
  
  public final void ny(String paramString)
  {
    y.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[] { paramString });
    this.lGG = paramString;
    bez();
    if (!bk.bl(paramString))
    {
      au.G(ae.getContext(), a.h.talkroom_othersbegin);
      this.lGR.S(100L, 100L);
      return;
    }
    this.lGR.stopTimer();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k
 * JD-Core Version:    0.7.0.1
 */