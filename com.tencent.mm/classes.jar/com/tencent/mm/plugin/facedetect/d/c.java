package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import java.util.Timer;
import java.util.TimerTask;

public final class c
  implements b
{
  private static String TAG = "MicroMsg.NormalFaceMotion";
  private static long sRZ = 500L;
  private boolean sSa;
  private boolean sSb;
  private View sSc;
  private View sSd;
  private String sSe;
  private long sSf;
  private final Object sSg;
  private Timer sSh;
  private volatile boolean sSi;
  private Animation sSj;
  private volatile boolean sSk;
  private volatile boolean sSl;
  
  public c(String paramString, long paramLong)
  {
    AppMethodBeat.i(103819);
    this.sSa = false;
    this.sSb = false;
    this.sSc = null;
    this.sSd = null;
    this.sSg = new Object();
    this.sSh = null;
    this.sSi = false;
    this.sSk = false;
    this.sSl = false;
    this.sSe = paramString;
    this.sSf = paramLong;
    this.sSj = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130772169);
    AppMethodBeat.o(103819);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(103822);
    this.sSc = LayoutInflater.from(paramContext).inflate(2131494074, paramViewGroup1);
    this.sSd = LayoutInflater.from(paramContext).inflate(2131494075, paramViewGroup2);
    this.sSd.setVisibility(4);
    if (cTv() != null) {
      cTv().setText(this.sSe);
    }
    long l = this.sSf;
    Log.i(TAG, "hy: starting tween timer: tween: %d", new Object[] { Long.valueOf(l) });
    if (this.sSh != null) {
      this.sSh.cancel();
    }
    this.sSh = new Timer("FaceDetect_hint", true);
    this.sSi = true;
    this.sSh.scheduleAtFixedRate(new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(103818);
        synchronized (c.b(c.this))
        {
          if (!c.c(c.this))
          {
            Log.w(c.TAG, "hy: already stopped");
            cancel();
          }
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103817);
              if (c.this.cTv() != null) {
                c.this.cTv().startAnimation(c.d(c.this));
              }
              AppMethodBeat.o(103817);
            }
          });
          AppMethodBeat.o(103818);
          return;
        }
      }
    }, 0L, l);
    AppMethodBeat.o(103822);
  }
  
  public final boolean a(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    AppMethodBeat.i(103823);
    if ((this.sSa) && (paramFaceCharacteristicsResult != null) && (paramFaceCharacteristicsResult.errCode == 18))
    {
      Log.d(TAG, "hy: ignore too active");
      AppMethodBeat.o(103823);
      return true;
    }
    AppMethodBeat.o(103823);
    return false;
  }
  
  public final boolean b(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    AppMethodBeat.i(103824);
    if (paramFaceCharacteristicsResult.errCode == -1)
    {
      this.sSa = true;
      if (!this.sSk)
      {
        PlaySound.play(MMApplicationContext.getContext(), 2131764140);
        paramFaceCharacteristicsResult = (TextView)this.sSc.findViewById(2131302333);
        Animation localAnimation1 = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130772050);
        Animation localAnimation2 = AnimationUtils.loadAnimation(MMApplicationContext.getContext(), 2130772059);
        localAnimation1.setDuration(sRZ);
        localAnimation2.setDuration(sRZ);
        paramFaceCharacteristicsResult.startAnimation(localAnimation1);
        paramFaceCharacteristicsResult.setVisibility(4);
        this.sSd.setVisibility(0);
        this.sSd.startAnimation(localAnimation2);
        this.sSd.findViewById(2131300356).setOnClickListener(new c.1(this));
        this.sSk = true;
        AppMethodBeat.o(103824);
        return true;
      }
    }
    AppMethodBeat.o(103824);
    return false;
  }
  
  public final boolean cTq()
  {
    return (this.sSa) && (this.sSb);
  }
  
  public final boolean cTr()
  {
    return false;
  }
  
  public final void cTs()
  {
    AppMethodBeat.i(103825);
    this.sSi = false;
    if (this.sSh != null) {
      this.sSh.cancel();
    }
    this.sSa = false;
    this.sSk = false;
    this.sSl = false;
    this.sSb = false;
    AppMethodBeat.o(103825);
  }
  
  public final b.b cTt()
  {
    AppMethodBeat.i(103826);
    if (this.sSa)
    {
      localb = new b.b(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(103826);
      return localb;
    }
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(103826);
    return localb;
  }
  
  public final b.a cTu()
  {
    AppMethodBeat.i(103827);
    if ((this.sSa) && (!this.sSl))
    {
      this.sSl = true;
      b.a locala = new b.a();
      AppMethodBeat.o(103827);
      return locala;
    }
    AppMethodBeat.o(103827);
    return null;
  }
  
  public final TextView cTv()
  {
    AppMethodBeat.i(103820);
    TextView localTextView;
    if ((!this.sSa) && (this.sSc != null))
    {
      localTextView = (TextView)this.sSc.findViewById(2131302333);
      AppMethodBeat.o(103820);
      return localTextView;
    }
    if ((this.sSa) && (this.sSd != null))
    {
      localTextView = (TextView)this.sSd.findViewById(2131302333);
      AppMethodBeat.o(103820);
      return localTextView;
    }
    AppMethodBeat.o(103820);
    return null;
  }
  
  public final void setBusinessTip(String paramString)
  {
    AppMethodBeat.i(103821);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("getHintMsgTv() == null : ");
    if (cTv() == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d(str, bool);
      if (cTv() != null) {
        break;
      }
      AppMethodBeat.o(103821);
      return;
    }
    cTv().setText(paramString);
    AppMethodBeat.o(103821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c
 * JD-Core Version:    0.7.0.1
 */