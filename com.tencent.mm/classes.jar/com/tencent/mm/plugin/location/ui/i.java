package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.c;
import com.tencent.mm.bi.d;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bd.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public final class i
  implements com.tencent.mm.al.g, d
{
  private Activity activity;
  private List<String> dqB;
  Button sSB;
  public VolumeMeter sSC;
  RelativeLayout sSD;
  private boolean sSE;
  private String sSF;
  String sSG;
  private String sSH;
  boolean sSI;
  int sSJ;
  private long sSK;
  long sSL;
  av sSM;
  av sSN;
  private av sSO;
  public c sSP;
  public a sSQ;
  final av sSR;
  private boolean sSS;
  
  public i(Activity paramActivity, Button paramButton)
  {
    AppMethodBeat.i(55940);
    this.sSE = true;
    this.dqB = new LinkedList();
    this.sSI = false;
    this.sSJ = 0;
    this.sSK = 500L;
    this.sSL = 0L;
    this.sSM = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55932);
        ad.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
        i.this.cJT();
        AppMethodBeat.o(55932);
        return false;
      }
    }, false);
    this.sSN = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55933);
        ad.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
        i.a(i.this);
        AppMethodBeat.o(55933);
        return false;
      }
    }, false);
    this.sSO = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55934);
        i.this.display();
        AppMethodBeat.o(55934);
        return false;
      }
    }, false);
    this.sSR = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55936);
        if (i.this.sSJ == 3) {}
        for (int i = i.this.sSP.aBW();; i = i.this.sSP.aBX())
        {
          i locali = i.this;
          float f2 = i;
          float f1 = f2;
          if (f2 < 10.0F) {
            f1 = 10.0F;
          }
          f2 = f1;
          if (f1 > 100.0F) {
            f2 = 100.0F;
          }
          locali.sSC.setVolume(f2 / 100.0F);
          locali.sSC.invalidate();
          AppMethodBeat.o(55936);
          return true;
          if (bt.isNullOrNil(i.this.sSG))
          {
            AppMethodBeat.o(55936);
            return false;
          }
        }
      }
    }, true);
    this.sSS = true;
    this.activity = paramActivity;
    this.sSB = paramButton;
    this.sSD = ((RelativeLayout)this.activity.findViewById(2131306632));
    this.sSD.setVisibility(8);
    this.sSC = ((VolumeMeter)this.sSD.findViewById(2131306633));
    this.sSC.setArchView(this.sSB);
    paramActivity = this.sSC;
    if (paramActivity.sTz == null) {
      paramActivity.sTz = new ap("VolumeMeter_handler");
    }
    this.sSP = com.tencent.mm.bi.g.hxw;
    if (this.sSP == null) {
      ad.e("MicroMsg.TalkMgr", "cannot get talkroom server");
    }
    AppMethodBeat.o(55940);
  }
  
  public static void cJU()
  {
    AppMethodBeat.i(55944);
    vj localvj = new vj();
    localvj.dAP.dAS = true;
    com.tencent.mm.sdk.b.a.ESL.l(localvj);
    com.tencent.mm.plugin.audio.c.a.bvv();
    AppMethodBeat.o(55944);
  }
  
  public final void aCb()
  {
    AppMethodBeat.i(55945);
    this.sSE = false;
    this.sSB.setEnabled(true);
    display();
    AppMethodBeat.o(55945);
  }
  
  public final void aCc()
  {
    AppMethodBeat.i(55947);
    if (this.sSJ != 1)
    {
      AppMethodBeat.o(55947);
      return;
    }
    this.sSJ = 5;
    if (bt.aS(this.sSL) < this.sSK)
    {
      ad.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
      av localav = this.sSM;
      long l = this.sSK - bt.aS(this.sSL);
      localav.av(l, l);
      AppMethodBeat.o(55947);
      return;
    }
    cJT();
    AppMethodBeat.o(55947);
  }
  
  public final void aCd() {}
  
  public final void aCe()
  {
    AppMethodBeat.i(55951);
    display();
    AppMethodBeat.o(55951);
  }
  
  public final void aCf()
  {
    AppMethodBeat.i(55952);
    display();
    AppMethodBeat.o(55952);
  }
  
  public final void aCg() {}
  
  public final void bn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55950);
    ad.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    if (this.sSE)
    {
      AppMethodBeat.o(55950);
      return;
    }
    AppMethodBeat.o(55950);
  }
  
  public final void cJS()
  {
    AppMethodBeat.i(55941);
    this.sSH = this.activity.getIntent().getStringExtra("map_talker_name");
    this.sSP.a(this);
    ad.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[] { this.sSH });
    final String str = this.sSH;
    this.sSF = str;
    List localList;
    if (!bt.isNullOrNil(this.sSF))
    {
      if (!w.pF(str)) {
        break label151;
      }
      localList = com.tencent.mm.model.q.rW(str);
      if (localList != null) {
        break label143;
      }
      ar.a.gMW.aB(str, "");
    }
    for (;;)
    {
      new ap(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55937);
          i.this.sSP.al(str, 1);
          AppMethodBeat.o(55937);
        }
      });
      this.sSB.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(55939);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(55939);
            return false;
            i.this.sSI = true;
            i.this.sSD.setVisibility(0);
            i.this.sSC.reset();
            paramAnonymousView = i.this.sSC;
            if (!paramAnonymousView.sTv)
            {
              paramAnonymousView.hcP = true;
              paramAnonymousView.cKa();
            }
            i.this.sSB.setPressed(true);
            if (i.this.sSI)
            {
              bd.a(aj.getContext(), 2131764377, new bd.a()
              {
                public final void onCompletion()
                {
                  AppMethodBeat.i(55938);
                  ad.i("MicroMsg.TalkMgr", "play press sound end");
                  AppMethodBeat.o(55938);
                }
              });
              i.this.sSJ = 1;
              ad.i("MicroMsg.TalkMgr", "micBtn pressed down");
              i.this.sSL = bt.GC();
              i.this.sSP.aBY();
              i.this.display();
              continue;
              if (i.this.sSI)
              {
                continue;
                i.this.sSB.setPressed(false);
                i.this.sSD.setVisibility(8);
                i.this.sSC.reset();
                i.this.sSC.hcP = false;
                if (i.this.sSI)
                {
                  i.this.sSI = false;
                  if (i.this.sSJ == 5)
                  {
                    ad.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                    i.this.sSM.stopTimer();
                    i.this.sSN.stopTimer();
                  }
                  i.this.sSJ = 0;
                  i.this.sSR.stopTimer();
                  i.this.sSP.aBZ();
                  bd.az(aj.getContext(), 2131764380);
                  i.this.display();
                  if (i.this.sSQ != null) {
                    i.this.sSQ.cJQ();
                  }
                }
              }
            }
          }
        }
      });
      AppMethodBeat.o(55941);
      return;
      label143:
      this.dqB = localList;
      continue;
      label151:
      this.dqB.clear();
      this.dqB.add(str);
      this.dqB.add(u.aqG());
    }
  }
  
  final void cJT()
  {
    AppMethodBeat.i(55942);
    if (this.sSJ != 5)
    {
      AppMethodBeat.o(55942);
      return;
    }
    this.sSM.stopTimer();
    display();
    bd.a(aj.getContext(), 2131764373, new bd.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(55935);
        i.this.sSN.stopTimer();
        i.a(i.this);
        AppMethodBeat.o(55935);
      }
    });
    this.sSN.av(1000L, 1000L);
    AppMethodBeat.o(55942);
  }
  
  final void display()
  {
    AppMethodBeat.i(55943);
    if (this.sSE)
    {
      AppMethodBeat.o(55943);
      return;
    }
    if (com.tencent.mm.bi.g.hxw.aCa())
    {
      ad.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
      if (this.sSQ != null)
      {
        this.sSQ.afc(null);
        this.sSQ.cJQ();
      }
    }
    switch (this.sSJ)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55943);
      return;
      ad.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[] { this.sSG });
      if (this.sSQ != null)
      {
        if (!bt.isNullOrNil(this.sSG))
        {
          this.sSQ.afc(this.sSG);
          AppMethodBeat.o(55943);
          return;
        }
        this.sSQ.afc(null);
        AppMethodBeat.o(55943);
        return;
        ad.d("MicroMsg.TalkMgr", "seize, state seizing");
        if (this.sSQ != null)
        {
          this.sSQ.cJR();
          AppMethodBeat.o(55943);
          return;
          ad.d("MicroMsg.TalkMgr", "seize, state success or prepare");
          if (this.sSQ != null)
          {
            this.sSQ.cJP();
            AppMethodBeat.o(55943);
            return;
            ad.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[] { this.sSG });
            if ((this.sSQ != null) && (!bt.isNullOrNil(this.sSG)))
            {
              this.sSQ.afd(this.sSG);
              AppMethodBeat.o(55943);
              return;
              ad.d("MicroMsg.TalkMgr", "seize time out");
            }
          }
        }
      }
    }
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void oQ(int paramInt)
  {
    AppMethodBeat.i(55948);
    ad.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.sSJ != 3)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
    for (this.sSJ = 4;; this.sSJ = 2)
    {
      display();
      bd.a(aj.getContext(), null);
      AppMethodBeat.o(55948);
      return;
      if (this.sSJ != 1)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn) {}
  
  public final void r(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55946);
    ad.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[] { paramString });
    com.tencent.mm.plugin.location.model.n.cJq().FF(3);
    this.activity.finish();
    AppMethodBeat.o(55946);
  }
  
  public final void zy(String paramString)
  {
    AppMethodBeat.i(55949);
    ad.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[] { paramString });
    this.sSG = paramString;
    display();
    if (!bt.isNullOrNil(paramString))
    {
      bd.az(aj.getContext(), 2131764376);
      this.sSR.av(100L, 100L);
      AppMethodBeat.o(55949);
      return;
    }
    this.sSR.stopTimer();
    AppMethodBeat.o(55949);
  }
  
  public static abstract interface a
  {
    public abstract void afc(String paramString);
    
    public abstract void afd(String paramString);
    
    public abstract void cJP();
    
    public abstract void cJQ();
    
    public abstract void cJR();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.i
 * JD-Core Version:    0.7.0.1
 */