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
import com.tencent.mm.bj.c;
import com.tencent.mm.bj.d;
import com.tencent.mm.bj.g;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class i
  implements com.tencent.mm.an.i, d
{
  private long EnA;
  private MTimerHandler EnB;
  private MTimerHandler EnC;
  private MTimerHandler EnD;
  public c EnE;
  public a EnF;
  private final MTimerHandler EnG;
  private boolean EnH;
  private Button Enq;
  public VolumeMeter Enr;
  private RelativeLayout Ens;
  private boolean Ent;
  private String Enu;
  private String Env;
  private String Enw;
  private boolean Enx;
  private int Eny;
  private long Enz;
  private Activity activity;
  private List<String> fMr;
  
  public i(Activity paramActivity, Button paramButton)
  {
    AppMethodBeat.i(55940);
    this.Ent = true;
    this.fMr = new LinkedList();
    this.Enx = false;
    this.Eny = 0;
    this.Enz = 500L;
    this.EnA = 0L;
    this.EnB = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55932);
        Log.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
        i.a(i.this);
        AppMethodBeat.o(55932);
        return false;
      }
    }, false);
    this.EnC = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55933);
        Log.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
        i.b(i.this);
        AppMethodBeat.o(55933);
        return false;
      }
    }, false);
    this.EnD = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55934);
        i.c(i.this);
        AppMethodBeat.o(55934);
        return false;
      }
    }, false);
    this.EnG = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55936);
        if (i.e(i.this) == 3) {}
        for (int i = i.f(i.this).bpK();; i = i.f(i.this).bpL())
        {
          i.a(i.this, i);
          AppMethodBeat.o(55936);
          return true;
          if (Util.isNullOrNil(i.g(i.this)))
          {
            AppMethodBeat.o(55936);
            return false;
          }
        }
      }
    }, true);
    this.EnH = true;
    this.activity = paramActivity;
    this.Enq = paramButton;
    this.Ens = ((RelativeLayout)this.activity.findViewById(a.e.volume_layout));
    this.Ens.setVisibility(8);
    this.Enr = ((VolumeMeter)this.Ens.findViewById(a.e.volume_meter));
    this.Enr.setArchView(this.Enq);
    paramActivity = this.Enr;
    if (paramActivity.Eoo == null) {
      paramActivity.Eoo = new MMHandler("VolumeMeter_handler");
    }
    this.EnE = g.meU;
    if (this.EnE == null) {
      Log.e("MicroMsg.TalkMgr", "cannot get talkroom server");
    }
    AppMethodBeat.o(55940);
  }
  
  private void eMN()
  {
    AppMethodBeat.i(55942);
    if (this.Eny != 5)
    {
      AppMethodBeat.o(55942);
      return;
    }
    this.EnB.stopTimer();
    eMO();
    PlaySound.play(MMApplicationContext.getContext(), a.i.talkroom_begin, new PlaySound.OnPlayCompletionListener()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(55935);
        i.d(i.this).stopTimer();
        i.b(i.this);
        AppMethodBeat.o(55935);
      }
    });
    this.EnC.startTimer(1000L);
    AppMethodBeat.o(55942);
  }
  
  private void eMO()
  {
    AppMethodBeat.i(55943);
    if (this.Ent)
    {
      AppMethodBeat.o(55943);
      return;
    }
    if (g.meU.bpO())
    {
      Log.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
      if (this.EnF != null)
      {
        this.EnF.aNr(null);
        this.EnF.eMK();
      }
    }
    switch (this.Eny)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55943);
      return;
      Log.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[] { this.Env });
      if (this.EnF != null)
      {
        if (!Util.isNullOrNil(this.Env))
        {
          this.EnF.aNr(this.Env);
          AppMethodBeat.o(55943);
          return;
        }
        this.EnF.aNr(null);
        AppMethodBeat.o(55943);
        return;
        Log.d("MicroMsg.TalkMgr", "seize, state seizing");
        if (this.EnF != null)
        {
          this.EnF.eML();
          AppMethodBeat.o(55943);
          return;
          Log.d("MicroMsg.TalkMgr", "seize, state success or prepare");
          if (this.EnF != null)
          {
            this.EnF.eMJ();
            AppMethodBeat.o(55943);
            return;
            Log.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[] { this.Env });
            if ((this.EnF != null) && (!Util.isNullOrNil(this.Env)))
            {
              this.EnF.aNs(this.Env);
              AppMethodBeat.o(55943);
              return;
              Log.d("MicroMsg.TalkMgr", "seize time out");
            }
          }
        }
      }
    }
  }
  
  public static void eMP()
  {
    AppMethodBeat.i(55944);
    yx localyx = new yx();
    localyx.fYg.fYj = true;
    EventCenter.instance.publish(localyx);
    a.crg();
    AppMethodBeat.o(55944);
  }
  
  public final void Xu(String paramString)
  {
    AppMethodBeat.i(55949);
    Log.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[] { paramString });
    this.Env = paramString;
    eMO();
    if (!Util.isNullOrNil(paramString))
    {
      PlaySound.play(MMApplicationContext.getContext(), a.i.talkroom_othersbegin);
      this.EnG.startTimer(100L);
      AppMethodBeat.o(55949);
      return;
    }
    this.EnG.stopTimer();
    AppMethodBeat.o(55949);
  }
  
  public final void aFx() {}
  
  public final void bD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55950);
    Log.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    if (this.Ent)
    {
      AppMethodBeat.o(55950);
      return;
    }
    AppMethodBeat.o(55950);
  }
  
  public final void bpP()
  {
    AppMethodBeat.i(55945);
    this.Ent = false;
    this.Enq.setEnabled(true);
    eMO();
    AppMethodBeat.o(55945);
  }
  
  public final void bpQ()
  {
    AppMethodBeat.i(55947);
    if (this.Eny != 1)
    {
      AppMethodBeat.o(55947);
      return;
    }
    this.Eny = 5;
    if (Util.ticksToNow(this.EnA) < this.Enz)
    {
      Log.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
      this.EnB.startTimer(this.Enz - Util.ticksToNow(this.EnA));
      AppMethodBeat.o(55947);
      return;
    }
    eMN();
    AppMethodBeat.o(55947);
  }
  
  public final void bpR() {}
  
  public final void bpS()
  {
    AppMethodBeat.i(55951);
    eMO();
    AppMethodBeat.o(55951);
  }
  
  public final void bpT()
  {
    AppMethodBeat.i(55952);
    eMO();
    AppMethodBeat.o(55952);
  }
  
  public final void eMM()
  {
    AppMethodBeat.i(55941);
    this.Enw = this.activity.getIntent().getStringExtra("map_talker_name");
    this.EnE.a(this);
    Log.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[] { this.Enw });
    final String str = this.Enw;
    this.Enu = str;
    List localList;
    if (!Util.isNullOrNil(this.Enu))
    {
      if (!ab.Lj(str)) {
        break label153;
      }
      localList = v.Ps(str);
      if (localList != null) {
        break label145;
      }
      az.a.ltq.aP(str, "");
    }
    for (;;)
    {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55937);
          i.f(i.this).aO(str, 1);
          AppMethodBeat.o(55937);
        }
      });
      this.Enq.setOnTouchListener(new View.OnTouchListener()
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
            i.a(i.this, i.eMQ());
            i.h(i.this).setVisibility(0);
            i.i(i.this).reset();
            paramAnonymousView = i.i(i.this);
            if (!paramAnonymousView.Eok)
            {
              paramAnonymousView.lKg = true;
              paramAnonymousView.eMV();
            }
            i.j(i.this).setPressed(true);
            if (i.k(i.this))
            {
              PlaySound.play(MMApplicationContext.getContext(), a.i.talkroom_press, new PlaySound.OnPlayCompletionListener()
              {
                public final void onCompletion()
                {
                  AppMethodBeat.i(55938);
                  Log.i("MicroMsg.TalkMgr", "play press sound end");
                  AppMethodBeat.o(55938);
                }
              });
              i.a(i.this, 1);
              Log.i("MicroMsg.TalkMgr", "micBtn pressed down");
              i.a(i.this, Util.currentTicks());
              i.f(i.this).bpM();
              i.c(i.this);
              continue;
              if (i.k(i.this))
              {
                i.eMQ();
                continue;
                i.j(i.this).setPressed(false);
                i.h(i.this).setVisibility(8);
                i.i(i.this).reset();
                i.i(i.this).lKg = false;
                if (i.k(i.this))
                {
                  i.a(i.this, false);
                  if (i.e(i.this) == 5)
                  {
                    Log.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                    i.l(i.this).stopTimer();
                    i.d(i.this).stopTimer();
                  }
                  i.a(i.this, 0);
                  i.m(i.this).stopTimer();
                  i.f(i.this).bpN();
                  PlaySound.play(MMApplicationContext.getContext(), a.i.talkroom_up);
                  i.c(i.this);
                  if (i.n(i.this) != null) {
                    i.n(i.this).eMK();
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
      this.fMr = localList;
      continue;
      label153:
      this.fMr.clear();
      this.fMr.add(str);
      this.fMr.add(z.bcZ());
    }
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq) {}
  
  public final void t(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55946);
    Log.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[] { paramString });
    n.eMj().VG(3);
    this.activity.finish();
    AppMethodBeat.o(55946);
  }
  
  public final void wZ(int paramInt)
  {
    AppMethodBeat.i(55948);
    Log.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.Eny != 3)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
    for (this.Eny = 4;; this.Eny = 2)
    {
      eMO();
      PlaySound.play(MMApplicationContext.getContext(), a.i.talkroom_sasasa, true, null);
      AppMethodBeat.o(55948);
      return;
      if (this.Eny != 1)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aNr(String paramString);
    
    public abstract void aNs(String paramString);
    
    public abstract void eMJ();
    
    public abstract void eMK();
    
    public abstract void eML();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.i
 * JD-Core Version:    0.7.0.1
 */