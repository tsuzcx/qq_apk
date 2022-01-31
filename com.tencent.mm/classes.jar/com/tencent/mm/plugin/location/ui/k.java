package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bg.c;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.n;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.ay.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class k
  implements f, com.tencent.mm.bg.d
{
  private Activity activity;
  private List<String> cAs;
  Button odO;
  public VolumeMeter odP;
  RelativeLayout odQ;
  private boolean odR;
  private String odS;
  String odT;
  private String odU;
  boolean odV;
  int odW;
  private long odX;
  long odY;
  ap odZ;
  ap oea;
  private ap oeb;
  public c oec;
  public k.a oed;
  final ap oee;
  private boolean oef;
  
  public k(Activity paramActivity, Button paramButton)
  {
    AppMethodBeat.i(113538);
    this.odR = true;
    this.cAs = new LinkedList();
    this.odV = false;
    this.odW = 0;
    this.odX = 500L;
    this.odY = 0L;
    this.odZ = new ap(new k.1(this), false);
    this.oea = new ap(new k.2(this), false);
    this.oeb = new ap(new k.3(this), false);
    this.oee = new ap(new k.5(this), true);
    this.oef = true;
    this.activity = paramActivity;
    this.odO = paramButton;
    this.odQ = ((RelativeLayout)this.activity.findViewById(2131824810));
    this.odQ.setVisibility(8);
    this.odP = ((VolumeMeter)this.odQ.findViewById(2131824811));
    this.odP.setArchView(this.odO);
    paramActivity = this.odP;
    if (paramActivity.oeM == null) {
      com.tencent.mm.sdk.g.d.a(new VolumeMeter.1(paramActivity), "VolumeMeter_handler", 1).start();
    }
    this.oec = com.tencent.mm.bg.g.fUN;
    if (this.oec == null) {
      ab.e("MicroMsg.TalkMgr", "cannot get talkroom server");
    }
    AppMethodBeat.o(113538);
  }
  
  public static void bLT()
  {
    AppMethodBeat.i(113542);
    tl localtl = new tl();
    localtl.cJT.cJW = true;
    a.ymk.l(localtl);
    com.tencent.mm.compatible.b.g.KC().setMode(0);
    AppMethodBeat.o(113542);
  }
  
  public final void aX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113548);
    ab.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    if (this.odR)
    {
      AppMethodBeat.o(113548);
      return;
    }
    AppMethodBeat.o(113548);
  }
  
  public final void akV()
  {
    AppMethodBeat.i(113543);
    this.odR = false;
    this.odO.setEnabled(true);
    display();
    AppMethodBeat.o(113543);
  }
  
  public final void akW()
  {
    AppMethodBeat.i(113545);
    if (this.odW != 1)
    {
      AppMethodBeat.o(113545);
      return;
    }
    this.odW = 5;
    if (bo.av(this.odY) < this.odX)
    {
      ab.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
      ap localap = this.odZ;
      long l = this.odX - bo.av(this.odY);
      localap.ag(l, l);
      AppMethodBeat.o(113545);
      return;
    }
    bLS();
    AppMethodBeat.o(113545);
  }
  
  public final void akX() {}
  
  public final void akY()
  {
    AppMethodBeat.i(113549);
    display();
    AppMethodBeat.o(113549);
  }
  
  public final void akZ()
  {
    AppMethodBeat.i(113550);
    display();
    AppMethodBeat.o(113550);
  }
  
  public final void ala() {}
  
  public final void bLR()
  {
    AppMethodBeat.i(113539);
    this.odU = this.activity.getIntent().getStringExtra("map_talker_name");
    this.oec.a(this);
    ab.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[] { this.odU });
    String str = this.odU;
    this.odS = str;
    List localList;
    if (!bo.isNullOrNil(this.odS))
    {
      if (!t.lA(str)) {
        break label153;
      }
      localList = n.nt(str);
      if (localList != null) {
        break label145;
      }
      ao.a.flI.am(str, "");
    }
    for (;;)
    {
      new ak(Looper.getMainLooper()).post(new k.6(this, str));
      this.odO.setOnTouchListener(new k.7(this));
      AppMethodBeat.o(113539);
      return;
      label145:
      this.cAs = localList;
      continue;
      label153:
      this.cAs.clear();
      this.cAs.add(str);
      this.cAs.add(r.Zn());
    }
  }
  
  final void bLS()
  {
    AppMethodBeat.i(113540);
    if (this.odW != 5)
    {
      AppMethodBeat.o(113540);
      return;
    }
    this.odZ.stopTimer();
    display();
    ay.a(ah.getContext(), 2131304253, new ay.a()
    {
      public final void Es()
      {
        AppMethodBeat.i(113533);
        k.this.oea.stopTimer();
        k.a(k.this);
        AppMethodBeat.o(113533);
      }
    });
    this.oea.ag(1000L, 1000L);
    AppMethodBeat.o(113540);
  }
  
  final void display()
  {
    AppMethodBeat.i(113541);
    if (this.odR)
    {
      AppMethodBeat.o(113541);
      return;
    }
    if (com.tencent.mm.bg.g.fUN.akU())
    {
      ab.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
      if (this.oed != null)
      {
        this.oed.Si(null);
        this.oed.bLP();
      }
    }
    switch (this.odW)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113541);
      return;
      ab.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[] { this.odT });
      if (this.oed != null)
      {
        if (!bo.isNullOrNil(this.odT))
        {
          this.oed.Si(this.odT);
          AppMethodBeat.o(113541);
          return;
        }
        this.oed.Si(null);
        AppMethodBeat.o(113541);
        return;
        ab.d("MicroMsg.TalkMgr", "seize, state seizing");
        if (this.oed != null)
        {
          this.oed.bLQ();
          AppMethodBeat.o(113541);
          return;
          ab.d("MicroMsg.TalkMgr", "seize, state success or prepare");
          if (this.oed != null)
          {
            this.oed.bLO();
            AppMethodBeat.o(113541);
            return;
            ab.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[] { this.odT });
            if ((this.oed != null) && (!bo.isNullOrNil(this.odT)))
            {
              this.oed.Sj(this.odT);
              AppMethodBeat.o(113541);
              return;
              ab.d("MicroMsg.TalkMgr", "seize time out");
            }
          }
        }
      }
    }
  }
  
  public final void i(int paramInt1, int paramInt2, String paramString) {}
  
  public final void mh(int paramInt)
  {
    AppMethodBeat.i(113546);
    ab.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.odW != 3)
      {
        AppMethodBeat.o(113546);
        return;
      }
    }
    for (this.odW = 4;; this.odW = 2)
    {
      display();
      ay.a(ah.getContext(), null);
      AppMethodBeat.o(113546);
      return;
      if (this.odW != 1)
      {
        AppMethodBeat.o(113546);
        return;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm) {}
  
  public final void t(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(113544);
    ab.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[] { paramString });
    l.bLr().yb(3);
    this.activity.finish();
    AppMethodBeat.o(113544);
  }
  
  public final void uM(String paramString)
  {
    AppMethodBeat.i(113547);
    ab.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[] { paramString });
    this.odT = paramString;
    display();
    if (!bo.isNullOrNil(paramString))
    {
      ay.ax(ah.getContext(), 2131304256);
      this.oee.ag(100L, 100L);
      AppMethodBeat.o(113547);
      return;
    }
    this.oee.stopTimer();
    AppMethodBeat.o(113547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k
 * JD-Core Version:    0.7.0.1
 */