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
import com.tencent.mm.bh.c;
import com.tencent.mm.bh.d;
import com.tencent.mm.bh.g;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.location.model.n;
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
  implements com.tencent.mm.ak.i, d
{
  private Activity activity;
  private List<String> dSU;
  private boolean yJA;
  private String yJB;
  String yJC;
  private String yJD;
  boolean yJE;
  int yJF;
  private long yJG;
  long yJH;
  MTimerHandler yJI;
  MTimerHandler yJJ;
  private MTimerHandler yJK;
  public c yJL;
  public a yJM;
  final MTimerHandler yJN;
  private boolean yJO;
  Button yJx;
  public VolumeMeter yJy;
  RelativeLayout yJz;
  
  public i(Activity paramActivity, Button paramButton)
  {
    AppMethodBeat.i(55940);
    this.yJA = true;
    this.dSU = new LinkedList();
    this.yJE = false;
    this.yJF = 0;
    this.yJG = 500L;
    this.yJH = 0L;
    this.yJI = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55932);
        Log.i("MicroMsg.TalkMgr", "onSeizeMicSuccess expired to execute");
        i.this.edu();
        AppMethodBeat.o(55932);
        return false;
      }
    }, false);
    this.yJJ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55933);
        Log.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
        i.a(i.this);
        AppMethodBeat.o(55933);
        return false;
      }
    }, false);
    this.yJK = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55934);
        i.this.display();
        AppMethodBeat.o(55934);
        return false;
      }
    }, false);
    this.yJN = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(55936);
        if (i.this.yJF == 3) {}
        for (int i = i.this.yJL.bgu();; i = i.this.yJL.bgv())
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
          locali.yJy.setVolume(f2 / 100.0F);
          locali.yJy.invalidate();
          AppMethodBeat.o(55936);
          return true;
          if (Util.isNullOrNil(i.this.yJC))
          {
            AppMethodBeat.o(55936);
            return false;
          }
        }
      }
    }, true);
    this.yJO = true;
    this.activity = paramActivity;
    this.yJx = paramButton;
    this.yJz = ((RelativeLayout)this.activity.findViewById(2131310092));
    this.yJz.setVisibility(8);
    this.yJy = ((VolumeMeter)this.yJz.findViewById(2131310093));
    this.yJy.setArchView(this.yJx);
    paramActivity = this.yJy;
    if (paramActivity.yKv == null) {
      paramActivity.yKv = new MMHandler("VolumeMeter_handler");
    }
    this.yJL = g.jpz;
    if (this.yJL == null) {
      Log.e("MicroMsg.TalkMgr", "cannot get talkroom server");
    }
    AppMethodBeat.o(55940);
  }
  
  public static void edv()
  {
    AppMethodBeat.i(55944);
    xq localxq = new xq();
    localxq.edR.edU = true;
    EventCenter.instance.publish(localxq);
    a.cdV();
    AppMethodBeat.o(55944);
  }
  
  public final void PX(String paramString)
  {
    AppMethodBeat.i(55949);
    Log.d("MicroMsg.TalkMgr", "onCurMember change %s", new Object[] { paramString });
    this.yJC = paramString;
    display();
    if (!Util.isNullOrNil(paramString))
    {
      PlaySound.play(MMApplicationContext.getContext(), 2131766637);
      this.yJN.startTimer(100L);
      AppMethodBeat.o(55949);
      return;
    }
    this.yJN.stopTimer();
    AppMethodBeat.o(55949);
  }
  
  public final void bA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55950);
    Log.i("MicroMsg.TalkMgr", "add %s,  del %s", new Object[] { paramString1, paramString2 });
    if (this.yJA)
    {
      AppMethodBeat.o(55950);
      return;
    }
    AppMethodBeat.o(55950);
  }
  
  public final void bgA()
  {
    AppMethodBeat.i(55947);
    if (this.yJF != 1)
    {
      AppMethodBeat.o(55947);
      return;
    }
    this.yJF = 5;
    if (Util.ticksToNow(this.yJH) < this.yJG)
    {
      Log.i("MicroMsg.TalkMgr", "onSeizeMicSuccess waiting to execute");
      this.yJI.startTimer(this.yJG - Util.ticksToNow(this.yJH));
      AppMethodBeat.o(55947);
      return;
    }
    edu();
    AppMethodBeat.o(55947);
  }
  
  public final void bgB() {}
  
  public final void bgC()
  {
    AppMethodBeat.i(55951);
    display();
    AppMethodBeat.o(55951);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(55952);
    display();
    AppMethodBeat.o(55952);
  }
  
  public final void bgE() {}
  
  public final void bgz()
  {
    AppMethodBeat.i(55945);
    this.yJA = false;
    this.yJx.setEnabled(true);
    display();
    AppMethodBeat.o(55945);
  }
  
  final void display()
  {
    AppMethodBeat.i(55943);
    if (this.yJA)
    {
      AppMethodBeat.o(55943);
      return;
    }
    if (g.jpz.bgy())
    {
      Log.d("MicroMsg.TalkMgr", "talkRoomServer pausing");
      if (this.yJM != null)
      {
        this.yJM.aDh(null);
        this.yJM.edr();
      }
    }
    switch (this.yJF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(55943);
      return;
      Log.d("MicroMsg.TalkMgr", "seize, state_idle, curUsername = %s", new Object[] { this.yJC });
      if (this.yJM != null)
      {
        if (!Util.isNullOrNil(this.yJC))
        {
          this.yJM.aDh(this.yJC);
          AppMethodBeat.o(55943);
          return;
        }
        this.yJM.aDh(null);
        AppMethodBeat.o(55943);
        return;
        Log.d("MicroMsg.TalkMgr", "seize, state seizing");
        if (this.yJM != null)
        {
          this.yJM.eds();
          AppMethodBeat.o(55943);
          return;
          Log.d("MicroMsg.TalkMgr", "seize, state success or prepare");
          if (this.yJM != null)
          {
            this.yJM.edq();
            AppMethodBeat.o(55943);
            return;
            Log.d("MicroMsg.TalkMgr", "seize error, curUsername = %s", new Object[] { this.yJC });
            if ((this.yJM != null) && (!Util.isNullOrNil(this.yJC)))
            {
              this.yJM.aDi(this.yJC);
              AppMethodBeat.o(55943);
              return;
              Log.d("MicroMsg.TalkMgr", "seize time out");
            }
          }
        }
      }
    }
  }
  
  public final void edt()
  {
    AppMethodBeat.i(55941);
    this.yJD = this.activity.getIntent().getStringExtra("map_talker_name");
    this.yJL.a(this);
    Log.d("MicroMsg.TalkMgr", "talkRoomName %s ", new Object[] { this.yJD });
    final String str = this.yJD;
    this.yJB = str;
    List localList;
    if (!Util.isNullOrNil(this.yJB))
    {
      if (!ab.Eq(str)) {
        break label153;
      }
      localList = v.Ic(str);
      if (localList != null) {
        break label145;
      }
      ay.a.iDq.aL(str, "");
    }
    for (;;)
    {
      new MMHandler(Looper.getMainLooper()).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55937);
          i.this.yJL.aw(str, 1);
          AppMethodBeat.o(55937);
        }
      });
      this.yJx.setOnTouchListener(new View.OnTouchListener()
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
            i.this.yJE = true;
            i.this.yJz.setVisibility(0);
            i.this.yJy.reset();
            paramAnonymousView = i.this.yJy;
            if (!paramAnonymousView.yKr)
            {
              paramAnonymousView.iTN = true;
              paramAnonymousView.edB();
            }
            i.this.yJx.setPressed(true);
            if (i.this.yJE)
            {
              PlaySound.play(MMApplicationContext.getContext(), 2131766638, new PlaySound.OnPlayCompletionListener()
              {
                public final void onCompletion()
                {
                  AppMethodBeat.i(55938);
                  Log.i("MicroMsg.TalkMgr", "play press sound end");
                  AppMethodBeat.o(55938);
                }
              });
              i.this.yJF = 1;
              Log.i("MicroMsg.TalkMgr", "micBtn pressed down");
              i.this.yJH = Util.currentTicks();
              i.this.yJL.bgw();
              i.this.display();
              continue;
              if (i.this.yJE)
              {
                continue;
                i.this.yJx.setPressed(false);
                i.this.yJz.setVisibility(8);
                i.this.yJy.reset();
                i.this.yJy.iTN = false;
                if (i.this.yJE)
                {
                  i.this.yJE = false;
                  if (i.this.yJF == 5)
                  {
                    Log.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                    i.this.yJI.stopTimer();
                    i.this.yJJ.stopTimer();
                  }
                  i.this.yJF = 0;
                  i.this.yJN.stopTimer();
                  i.this.yJL.bgx();
                  PlaySound.play(MMApplicationContext.getContext(), 2131766641);
                  i.this.display();
                  if (i.this.yJM != null) {
                    i.this.yJM.edr();
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
      this.dSU = localList;
      continue;
      label153:
      this.dSU.clear();
      this.dSU.add(str);
      this.dSU.add(z.aTY());
    }
  }
  
  final void edu()
  {
    AppMethodBeat.i(55942);
    if (this.yJF != 5)
    {
      AppMethodBeat.o(55942);
      return;
    }
    this.yJI.stopTimer();
    display();
    PlaySound.play(MMApplicationContext.getContext(), 2131766634, new PlaySound.OnPlayCompletionListener()
    {
      public final void onCompletion()
      {
        AppMethodBeat.i(55935);
        i.this.yJJ.stopTimer();
        i.a(i.this);
        AppMethodBeat.o(55935);
      }
    });
    this.yJJ.startTimer(1000L);
    AppMethodBeat.o(55942);
  }
  
  public final void j(int paramInt1, int paramInt2, String paramString) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq) {}
  
  public final void s(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(55946);
    Log.f("MicroMsg.TalkMgr", "onInitFailed %s", new Object[] { paramString });
    n.ecR().Px(3);
    this.activity.finish();
    AppMethodBeat.o(55946);
  }
  
  public final void ua(int paramInt)
  {
    AppMethodBeat.i(55948);
    Log.i("MicroMsg.TalkMgr", "onSeizeMicFailed");
    if (paramInt == 340) {
      if (this.yJF != 3)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
    for (this.yJF = 4;; this.yJF = 2)
    {
      display();
      PlaySound.play(MMApplicationContext.getContext(), 2131766640, true, null);
      AppMethodBeat.o(55948);
      return;
      if (this.yJF != 1)
      {
        AppMethodBeat.o(55948);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aDh(String paramString);
    
    public abstract void aDi(String paramString);
    
    public abstract void edq();
    
    public abstract void edr();
    
    public abstract void eds();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.i
 * JD-Core Version:    0.7.0.1
 */