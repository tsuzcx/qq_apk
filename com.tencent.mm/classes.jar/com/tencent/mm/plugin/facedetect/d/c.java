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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.be;
import java.util.Timer;
import java.util.TimerTask;

public final class c
  implements b
{
  private static String TAG = "MicroMsg.NormalFaceMotion";
  private static long rqC = 500L;
  private boolean rqD;
  private boolean rqE;
  private View rqF;
  private View rqG;
  private String rqH;
  private long rqI;
  private final Object rqJ;
  private Timer rqK;
  private volatile boolean rqL;
  private Animation rqM;
  private volatile boolean rqN;
  private volatile boolean rqO;
  
  public c(String paramString, long paramLong)
  {
    AppMethodBeat.i(103819);
    this.rqD = false;
    this.rqE = false;
    this.rqF = null;
    this.rqG = null;
    this.rqJ = new Object();
    this.rqK = null;
    this.rqL = false;
    this.rqN = false;
    this.rqO = false;
    this.rqH = paramString;
    this.rqI = paramLong;
    this.rqM = AnimationUtils.loadAnimation(ak.getContext(), 2130772144);
    AppMethodBeat.o(103819);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(103822);
    this.rqF = LayoutInflater.from(paramContext).inflate(2131493907, paramViewGroup1);
    this.rqG = LayoutInflater.from(paramContext).inflate(2131493908, paramViewGroup2);
    this.rqG.setVisibility(4);
    if (cuZ() != null) {
      cuZ().setText(this.rqH);
    }
    long l = this.rqI;
    ae.i(TAG, "hy: starting tween timer: tween: %d", new Object[] { Long.valueOf(l) });
    if (this.rqK != null) {
      this.rqK.cancel();
    }
    this.rqK = new Timer("FaceDetect_hint", true);
    this.rqL = true;
    this.rqK.scheduleAtFixedRate(new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(103818);
        synchronized (c.b(c.this))
        {
          if (!c.c(c.this))
          {
            ae.w(c.TAG, "hy: already stopped");
            cancel();
          }
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103817);
              if (c.this.cuZ() != null) {
                c.this.cuZ().startAnimation(c.d(c.this));
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
    if ((this.rqD) && (paramFaceCharacteristicsResult != null) && (paramFaceCharacteristicsResult.errCode == 18))
    {
      ae.d(TAG, "hy: ignore too active");
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
      this.rqD = true;
      if (!this.rqN)
      {
        be.aI(ak.getContext(), 2131762119);
        paramFaceCharacteristicsResult = (TextView)this.rqF.findViewById(2131300745);
        Animation localAnimation1 = AnimationUtils.loadAnimation(ak.getContext(), 2130772040);
        Animation localAnimation2 = AnimationUtils.loadAnimation(ak.getContext(), 2130772047);
        localAnimation1.setDuration(rqC);
        localAnimation2.setDuration(rqC);
        paramFaceCharacteristicsResult.startAnimation(localAnimation1);
        paramFaceCharacteristicsResult.setVisibility(4);
        this.rqG.setVisibility(0);
        this.rqG.startAnimation(localAnimation2);
        this.rqG.findViewById(2131299694).setOnClickListener(new c.1(this));
        this.rqN = true;
        AppMethodBeat.o(103824);
        return true;
      }
    }
    AppMethodBeat.o(103824);
    return false;
  }
  
  public final boolean cuU()
  {
    return (this.rqD) && (this.rqE);
  }
  
  public final boolean cuV()
  {
    return false;
  }
  
  public final void cuW()
  {
    AppMethodBeat.i(103825);
    this.rqL = false;
    if (this.rqK != null) {
      this.rqK.cancel();
    }
    this.rqD = false;
    this.rqN = false;
    this.rqO = false;
    this.rqE = false;
    AppMethodBeat.o(103825);
  }
  
  public final b.b cuX()
  {
    AppMethodBeat.i(103826);
    if (this.rqD)
    {
      localb = new b.b(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(103826);
      return localb;
    }
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(103826);
    return localb;
  }
  
  public final b.a cuY()
  {
    AppMethodBeat.i(103827);
    if ((this.rqD) && (!this.rqO))
    {
      this.rqO = true;
      b.a locala = new b.a();
      AppMethodBeat.o(103827);
      return locala;
    }
    AppMethodBeat.o(103827);
    return null;
  }
  
  public final TextView cuZ()
  {
    AppMethodBeat.i(103820);
    TextView localTextView;
    if ((!this.rqD) && (this.rqF != null))
    {
      localTextView = (TextView)this.rqF.findViewById(2131300745);
      AppMethodBeat.o(103820);
      return localTextView;
    }
    if ((this.rqD) && (this.rqG != null))
    {
      localTextView = (TextView)this.rqG.findViewById(2131300745);
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
    if (cuZ() == null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.d(str, bool);
      if (cuZ() != null) {
        break;
      }
      AppMethodBeat.o(103821);
      return;
    }
    cuZ().setText(paramString);
    AppMethodBeat.o(103821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c
 * JD-Core Version:    0.7.0.1
 */