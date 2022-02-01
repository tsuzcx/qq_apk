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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import java.util.Timer;
import java.util.TimerTask;

public final class c
  implements b
{
  private static String TAG = "MicroMsg.NormalFaceMotion";
  private static long riy = 500L;
  private boolean riA;
  private View riB;
  private View riC;
  private String riD;
  private long riE;
  private final Object riF;
  private Timer riG;
  private volatile boolean riH;
  private Animation riI;
  private volatile boolean riJ;
  private volatile boolean riK;
  private boolean riz;
  
  public c(String paramString, long paramLong)
  {
    AppMethodBeat.i(103819);
    this.riz = false;
    this.riA = false;
    this.riB = null;
    this.riC = null;
    this.riF = new Object();
    this.riG = null;
    this.riH = false;
    this.riJ = false;
    this.riK = false;
    this.riD = paramString;
    this.riE = paramLong;
    this.riI = AnimationUtils.loadAnimation(aj.getContext(), 2130772144);
    AppMethodBeat.o(103819);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(103822);
    this.riB = LayoutInflater.from(paramContext).inflate(2131493907, paramViewGroup1);
    this.riC = LayoutInflater.from(paramContext).inflate(2131493908, paramViewGroup2);
    this.riC.setVisibility(4);
    if (cty() != null) {
      cty().setText(this.riD);
    }
    long l = this.riE;
    ad.i(TAG, "hy: starting tween timer: tween: %d", new Object[] { Long.valueOf(l) });
    if (this.riG != null) {
      this.riG.cancel();
    }
    this.riG = new Timer("FaceDetect_hint", true);
    this.riH = true;
    this.riG.scheduleAtFixedRate(new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(103818);
        synchronized (c.b(c.this))
        {
          if (!c.c(c.this))
          {
            ad.w(c.TAG, "hy: already stopped");
            cancel();
          }
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103817);
              if (c.this.cty() != null) {
                c.this.cty().startAnimation(c.d(c.this));
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
    if ((this.riz) && (paramFaceCharacteristicsResult != null) && (paramFaceCharacteristicsResult.errCode == 18))
    {
      ad.d(TAG, "hy: ignore too active");
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
      this.riz = true;
      if (!this.riJ)
      {
        bd.aI(aj.getContext(), 2131762119);
        paramFaceCharacteristicsResult = (TextView)this.riB.findViewById(2131300745);
        Animation localAnimation1 = AnimationUtils.loadAnimation(aj.getContext(), 2130772040);
        Animation localAnimation2 = AnimationUtils.loadAnimation(aj.getContext(), 2130772047);
        localAnimation1.setDuration(riy);
        localAnimation2.setDuration(riy);
        paramFaceCharacteristicsResult.startAnimation(localAnimation1);
        paramFaceCharacteristicsResult.setVisibility(4);
        this.riC.setVisibility(0);
        this.riC.startAnimation(localAnimation2);
        this.riC.findViewById(2131299694).setOnClickListener(new c.1(this));
        this.riJ = true;
        AppMethodBeat.o(103824);
        return true;
      }
    }
    AppMethodBeat.o(103824);
    return false;
  }
  
  public final boolean ctt()
  {
    return (this.riz) && (this.riA);
  }
  
  public final boolean ctu()
  {
    return false;
  }
  
  public final void ctv()
  {
    AppMethodBeat.i(103825);
    this.riH = false;
    if (this.riG != null) {
      this.riG.cancel();
    }
    this.riz = false;
    this.riJ = false;
    this.riK = false;
    this.riA = false;
    AppMethodBeat.o(103825);
  }
  
  public final b.b ctw()
  {
    AppMethodBeat.i(103826);
    if (this.riz)
    {
      localb = new b.b(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(103826);
      return localb;
    }
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(103826);
    return localb;
  }
  
  public final b.a ctx()
  {
    AppMethodBeat.i(103827);
    if ((this.riz) && (!this.riK))
    {
      this.riK = true;
      b.a locala = new b.a();
      AppMethodBeat.o(103827);
      return locala;
    }
    AppMethodBeat.o(103827);
    return null;
  }
  
  public final TextView cty()
  {
    AppMethodBeat.i(103820);
    TextView localTextView;
    if ((!this.riz) && (this.riB != null))
    {
      localTextView = (TextView)this.riB.findViewById(2131300745);
      AppMethodBeat.o(103820);
      return localTextView;
    }
    if ((this.riz) && (this.riC != null))
    {
      localTextView = (TextView)this.riC.findViewById(2131300745);
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
    if (cty() == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d(str, bool);
      if (cty() != null) {
        break;
      }
      AppMethodBeat.o(103821);
      return;
    }
    cty().setText(paramString);
    AppMethodBeat.o(103821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c
 * JD-Core Version:    0.7.0.1
 */