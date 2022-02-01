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
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.bc.c;
import com.tencent.mm.bc.d;
import com.tencent.mm.bc.g;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.location.model.SubCoreLocation;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.List;

public final class i
  implements h, d
{
  private Button KfY;
  public VolumeMeter KfZ;
  private RelativeLayout Kga;
  private boolean Kgb;
  private String Kgc;
  private String Kgd;
  private String Kge;
  private boolean Kgf;
  private int Kgg;
  private long Kgh;
  private long Kgi;
  private MTimerHandler Kgj;
  private MTimerHandler Kgk;
  private MTimerHandler Kgl;
  public c Kgm;
  public a Kgn;
  private final MTimerHandler Kgo;
  private boolean Kgp;
  public Activity activity;
  private List<String> hSb;
  
  public i(Activity paramActivity, Button paramButton)
  {
    AppMethodBeat.i(55940);
    this.Kgb = true;
    this.hSb = new LinkedList();
    this.Kgf = false;
    this.Kgg = 0;
    this.Kgh = 500L;
    this.Kgi = 0L;
    this.Kgj = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.Kgk = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.Kgl = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55934);
        i.c(i.this);
        AppMethodBeat.o(55934);
        return false;
      }
    }, false);
    this.Kgo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55936);
        if (i.e(i.this) == 3) {}
        for (int i = i.f(i.this).bNq();; i = i.f(i.this).bNr())
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
    this.Kgp = true;
    this.activity = paramActivity;
    this.KfY = paramButton;
    this.Kga = ((RelativeLayout)this.activity.findViewById(a.e.volume_layout));
    this.Kga.setVisibility(8);
    this.KfZ = ((VolumeMeter)this.Kga.findViewById(a.e.volume_meter));
    this.KfZ.setArchView(this.KfY);
    paramActivity = this.KfZ;
    if (paramActivity.KgU == null) {
      paramActivity.KgU = new MMHandler("VolumeMeter_handler");
    }
    this.Kgm = g.oXM;
    if (this.Kgm == null) {
      Log.e("MicroMsg.TalkMgr", "cannot get talkroom server");
    }
    AppMethodBeat.o(55940);
  }
  
  private void fVg()
  {
    AppMethodBeat.i(55942);
    if (this.Kgg != 5)
    {
      AppMethodBeat.o(55942);
      return;
    }
    this.Kgj.stopTimer();
    fVh();
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
    this.Kgk.startTimer(1000L);
    AppMethodBeat.o(55942);
  }
  
  private void fVh()
  {
    AppMethodBeat.i(55943);
    if (this.Kgb)
    {
      AppMethodBeat.o(55943);
      return;
    }
    if (g.oXM.bNu())
    {
      Log.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
      if (this.Kgn != null)
      {
        this.Kgn.aKm(null);
        this.Kgn.fVd();
      }
    }
    switch (this.Kgg)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55943);
      return;
      Log.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[] { this.Kgd });
      if (this.Kgn != null)
      {
        if (!Util.isNullOrNil(this.Kgd))
        {
          this.Kgn.aKm(this.Kgd);
          AppMethodBeat.o(55943);
          return;
        }
        this.Kgn.aKm(null);
        AppMethodBeat.o(55943);
        return;
        Log.d("MicroMsg.TalkMgr", "seize, state seizing");
        if (this.Kgn != null)
        {
          this.Kgn.fVe();
          AppMethodBeat.o(55943);
          return;
          Log.d("MicroMsg.TalkMgr", "seize, state success or prepare");
          if (this.Kgn != null)
          {
            this.Kgn.fVc();
            AppMethodBeat.o(55943);
            return;
            Log.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[] { this.Kgd });
            if ((this.Kgn != null) && (!Util.isNullOrNil(this.Kgd)))
            {
              this.Kgn.aKn(this.Kgd);
              AppMethodBeat.o(55943);
              return;
              Log.d("MicroMsg.TalkMgr", "seize time out");
            }
          }
        }
      }
    }
  }
  
  public static void fVi()
  {
    AppMethodBeat.i(55944);
    aaq localaaq = new aaq();
    localaaq.ieg.iej = true;
    localaaq.publish();
    a.cTP();
    AppMethodBeat.o(55944);
  }
  
  public final void Pw(String paramString)
  {
    AppMethodBeat.i(55949);
    Log.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[] { paramString });
    this.Kgd = paramString;
    fVh();
    if (!Util.isNullOrNil(paramString))
    {
      PlaySound.play(MMApplicationContext.getContext(), a.i.talkroom_othersbegin);
      this.Kgo.startTimer(100L);
      AppMethodBeat.o(55949);
      return;
    }
    this.Kgo.stopTimer();
    AppMethodBeat.o(55949);
  }
  
  public final void bNv()
  {
    AppMethodBeat.i(55945);
    this.Kgb = false;
    this.KfY.setEnabled(true);
    fVh();
    AppMethodBeat.o(55945);
  }
  
  public final void bNw()
  {
    AppMethodBeat.i(55947);
    if (this.Kgg != 1)
    {
      AppMethodBeat.o(55947);
      return;
    }
    this.Kgg = 5;
    if (Util.ticksToNow(this.Kgi) < this.Kgh)
    {
      Log.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
      this.Kgj.startTimer(this.Kgh - Util.ticksToNow(this.Kgi));
      AppMethodBeat.o(55947);
      return;
    }
    fVg();
    AppMethodBeat.o(55947);
  }
  
  public final void bNx() {}
  
  public final void bNy()
  {
    AppMethodBeat.i(55951);
    fVh();
    AppMethodBeat.o(55951);
  }
  
  public final void bNz()
  {
    AppMethodBeat.i(55952);
    fVh();
    AppMethodBeat.o(55952);
  }
  
  public final void bP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55950);
    Log.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    if (this.Kgb)
    {
      AppMethodBeat.o(55950);
      return;
    }
    AppMethodBeat.o(55950);
  }
  
  public final void fVf()
  {
    AppMethodBeat.i(55941);
    this.Kge = this.activity.getIntent().getStringExtra("map_talker_name");
    this.Kgm.a(this);
    Log.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[] { this.Kge });
    final String str = this.Kge;
    this.Kgc = str;
    List localList;
    if (!Util.isNullOrNil(this.Kgc))
    {
      if (!au.bwE(str)) {
        break label153;
      }
      localList = v.Il(str);
      if (localList != null) {
        break label145;
      }
      az.a.okP.aZ(str, "");
    }
    for (;;)
    {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55937);
          i.f(i.this).ba(str, 1);
          AppMethodBeat.o(55937);
        }
      });
      this.KfY.setOnTouchListener(new View.OnTouchListener()
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
            i.a(i.this, i.fVj());
            i.h(i.this).setVisibility(0);
            i.i(i.this).reset();
            paramAnonymousView = i.i(i.this);
            if (!paramAnonymousView.KgQ)
            {
              paramAnonymousView.oCI = true;
              paramAnonymousView.fVo();
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
              i.f(i.this).bNs();
              i.c(i.this);
              continue;
              if ((i.k(i.this)) && (i.fVj()))
              {
                continue;
                i.j(i.this).setPressed(false);
                i.h(i.this).setVisibility(8);
                i.i(i.this).reset();
                i.i(i.this).oCI = false;
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
                  i.f(i.this).bNt();
                  PlaySound.play(MMApplicationContext.getContext(), a.i.talkroom_up);
                  i.c(i.this);
                  if (i.n(i.this) != null) {
                    i.n(i.this).fVd();
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
      this.hSb = localList;
      continue;
      label153:
      this.hSb.clear();
      this.hSb.add(str);
      this.hSb.add(z.bAM());
    }
  }
  
  public final void k(int paramInt1, int paramInt2, String paramString) {}
  
  public final void onReconnect() {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp) {}
  
  public final void w(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55946);
    Log.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[] { paramString });
    SubCoreLocation.fUB().ZC(3);
    this.activity.finish();
    AppMethodBeat.o(55946);
  }
  
  public final void wZ(int paramInt)
  {
    AppMethodBeat.i(55948);
    Log.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.Kgg != 3)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
    for (this.Kgg = 4;; this.Kgg = 2)
    {
      fVh();
      PlaySound.play(MMApplicationContext.getContext(), a.i.talkroom_sasasa, true, null);
      AppMethodBeat.o(55948);
      return;
      if (this.Kgg != 1)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aKm(String paramString);
    
    public abstract void aKn(String paramString);
    
    public abstract void fVc();
    
    public abstract void fVd();
    
    public abstract void fVe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.i
 * JD-Core Version:    0.7.0.1
 */