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
import com.tencent.mm.al.f;
import com.tencent.mm.bi.c;
import com.tencent.mm.bi.d;
import com.tencent.mm.bi.g;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
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
  implements f, d
{
  private Activity activity;
  private List<String> dAa;
  private String vdA;
  String vdB;
  private String vdC;
  boolean vdD;
  int vdE;
  private long vdF;
  long vdG;
  av vdH;
  av vdI;
  private av vdJ;
  public c vdK;
  public a vdL;
  final av vdM;
  private boolean vdN;
  Button vdw;
  public VolumeMeter vdx;
  RelativeLayout vdy;
  private boolean vdz;
  
  public i(Activity paramActivity, Button paramButton)
  {
    AppMethodBeat.i(55940);
    this.vdz = true;
    this.dAa = new LinkedList();
    this.vdD = false;
    this.vdE = 0;
    this.vdF = 500L;
    this.vdG = 0L;
    this.vdH = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55932);
        ad.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
        i.this.dgK();
        AppMethodBeat.o(55932);
        return false;
      }
    }, false);
    this.vdI = new av(new av.a()
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
    this.vdJ = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55934);
        i.this.display();
        AppMethodBeat.o(55934);
        return false;
      }
    }, false);
    this.vdM = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55936);
        if (i.this.vdE == 3) {}
        for (int i = i.this.vdK.aLW();; i = i.this.vdK.aLX())
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
          locali.vdx.setVolume(f2 / 100.0F);
          locali.vdx.invalidate();
          AppMethodBeat.o(55936);
          return true;
          if (bt.isNullOrNil(i.this.vdB))
          {
            AppMethodBeat.o(55936);
            return false;
          }
        }
      }
    }, true);
    this.vdN = true;
    this.activity = paramActivity;
    this.vdw = paramButton;
    this.vdy = ((RelativeLayout)this.activity.findViewById(2131306632));
    this.vdy.setVisibility(8);
    this.vdx = ((VolumeMeter)this.vdy.findViewById(2131306633));
    this.vdx.setArchView(this.vdw);
    paramActivity = this.vdx;
    if (paramActivity.vev == null) {
      paramActivity.vev = new ap("VolumeMeter_handler");
    }
    this.vdK = g.irt;
    if (this.vdK == null) {
      ad.e("MicroMsg.TalkMgr", "cannot get talkroom server");
    }
    AppMethodBeat.o(55940);
  }
  
  public static void dgL()
  {
    AppMethodBeat.i(55944);
    wm localwm = new wm();
    localwm.dKN.dKQ = true;
    com.tencent.mm.sdk.b.a.IbL.l(localwm);
    com.tencent.mm.plugin.audio.c.a.bGw();
    AppMethodBeat.o(55944);
  }
  
  public final void GI(String paramString)
  {
    AppMethodBeat.i(55949);
    ad.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[] { paramString });
    this.vdB = paramString;
    display();
    if (!bt.isNullOrNil(paramString))
    {
      bd.aI(aj.getContext(), 2131764376);
      this.vdM.az(100L, 100L);
      AppMethodBeat.o(55949);
      return;
    }
    this.vdM.stopTimer();
    AppMethodBeat.o(55949);
  }
  
  public final void aMb()
  {
    AppMethodBeat.i(55945);
    this.vdz = false;
    this.vdw.setEnabled(true);
    display();
    AppMethodBeat.o(55945);
  }
  
  public final void aMc()
  {
    AppMethodBeat.i(55947);
    if (this.vdE != 1)
    {
      AppMethodBeat.o(55947);
      return;
    }
    this.vdE = 5;
    if (bt.aO(this.vdG) < this.vdF)
    {
      ad.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
      av localav = this.vdH;
      long l = this.vdF - bt.aO(this.vdG);
      localav.az(l, l);
      AppMethodBeat.o(55947);
      return;
    }
    dgK();
    AppMethodBeat.o(55947);
  }
  
  public final void aMd() {}
  
  public final void aMe()
  {
    AppMethodBeat.i(55951);
    display();
    AppMethodBeat.o(55951);
  }
  
  public final void aMf()
  {
    AppMethodBeat.i(55952);
    display();
    AppMethodBeat.o(55952);
  }
  
  public final void aMg() {}
  
  public final void bw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55950);
    ad.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    if (this.vdz)
    {
      AppMethodBeat.o(55950);
      return;
    }
    AppMethodBeat.o(55950);
  }
  
  public final void dgJ()
  {
    AppMethodBeat.i(55941);
    this.vdC = this.activity.getIntent().getStringExtra("map_talker_name");
    this.vdK.a(this);
    ad.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[] { this.vdC });
    final String str = this.vdC;
    this.vdA = str;
    List localList;
    if (!bt.isNullOrNil(this.vdA))
    {
      if (!w.vF(str)) {
        break label153;
      }
      localList = com.tencent.mm.model.q.yQ(str);
      if (localList != null) {
        break label145;
      }
      as.a.hFO.aI(str, "");
    }
    for (;;)
    {
      new ap(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55937);
          i.this.vdK.ar(str, 1);
          AppMethodBeat.o(55937);
        }
      });
      this.vdw.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(55939);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/location/ui/TalkMgr$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/location/ui/TalkMgr$7", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(55939);
            return false;
            i.this.vdD = true;
            i.this.vdy.setVisibility(0);
            i.this.vdx.reset();
            paramAnonymousView = i.this.vdx;
            if (!paramAnonymousView.veq)
            {
              paramAnonymousView.hVX = true;
              paramAnonymousView.dgR();
            }
            i.this.vdw.setPressed(true);
            if (i.this.vdD)
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
              i.this.vdE = 1;
              ad.i("MicroMsg.TalkMgr", "micBtn pressed down");
              i.this.vdG = bt.HI();
              i.this.vdK.aLY();
              i.this.display();
              continue;
              if (i.this.vdD)
              {
                continue;
                i.this.vdw.setPressed(false);
                i.this.vdy.setVisibility(8);
                i.this.vdx.reset();
                i.this.vdx.hVX = false;
                if (i.this.vdD)
                {
                  i.this.vdD = false;
                  if (i.this.vdE == 5)
                  {
                    ad.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                    i.this.vdH.stopTimer();
                    i.this.vdI.stopTimer();
                  }
                  i.this.vdE = 0;
                  i.this.vdM.stopTimer();
                  i.this.vdK.aLZ();
                  bd.aI(aj.getContext(), 2131764380);
                  i.this.display();
                  if (i.this.vdL != null) {
                    i.this.vdL.dgH();
                  }
                }
              }
            }
          }
        }
      });
      AppMethodBeat.o(55941);
      return;
      label145:
      this.dAa = localList;
      continue;
      label153:
      this.dAa.clear();
      this.dAa.add(str);
      this.dAa.add(u.aAm());
    }
  }
  
  final void dgK()
  {
    AppMethodBeat.i(55942);
    if (this.vdE != 5)
    {
      AppMethodBeat.o(55942);
      return;
    }
    this.vdH.stopTimer();
    display();
    bd.a(aj.getContext(), 2131764373, new bd.a()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(55935);
        i.this.vdI.stopTimer();
        i.a(i.this);
        AppMethodBeat.o(55935);
      }
    });
    this.vdI.az(1000L, 1000L);
    AppMethodBeat.o(55942);
  }
  
  final void display()
  {
    AppMethodBeat.i(55943);
    if (this.vdz)
    {
      AppMethodBeat.o(55943);
      return;
    }
    if (g.irt.aMa())
    {
      ad.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
      if (this.vdL != null)
      {
        this.vdL.aoJ(null);
        this.vdL.dgH();
      }
    }
    switch (this.vdE)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55943);
      return;
      ad.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[] { this.vdB });
      if (this.vdL != null)
      {
        if (!bt.isNullOrNil(this.vdB))
        {
          this.vdL.aoJ(this.vdB);
          AppMethodBeat.o(55943);
          return;
        }
        this.vdL.aoJ(null);
        AppMethodBeat.o(55943);
        return;
        ad.d("MicroMsg.TalkMgr", "seize, state seizing");
        if (this.vdL != null)
        {
          this.vdL.dgI();
          AppMethodBeat.o(55943);
          return;
          ad.d("MicroMsg.TalkMgr", "seize, state success or prepare");
          if (this.vdL != null)
          {
            this.vdL.dgG();
            AppMethodBeat.o(55943);
            return;
            ad.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[] { this.vdB });
            if ((this.vdL != null) && (!bt.isNullOrNil(this.vdB)))
            {
              this.vdL.aoK(this.vdB);
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
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn) {}
  
  public final void qh(int paramInt)
  {
    AppMethodBeat.i(55948);
    ad.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.vdE != 3)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
    for (this.vdE = 4;; this.vdE = 2)
    {
      display();
      bd.a(aj.getContext(), null);
      AppMethodBeat.o(55948);
      return;
      if (this.vdE != 1)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
  }
  
  public final void s(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55946);
    ad.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[] { paramString });
    com.tencent.mm.plugin.location.model.n.dgh().IW(3);
    this.activity.finish();
    AppMethodBeat.o(55946);
  }
  
  public static abstract interface a
  {
    public abstract void aoJ(String paramString);
    
    public abstract void aoK(String paramString);
    
    public abstract void dgG();
    
    public abstract void dgH();
    
    public abstract void dgI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.i
 * JD-Core Version:    0.7.0.1
 */