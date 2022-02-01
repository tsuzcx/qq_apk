package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bc;
import java.util.Timer;
import java.util.TimerTask;

public final class c
  implements b
{
  private static String TAG = "MicroMsg.NormalFaceMotion";
  private static long qyJ = 500L;
  private boolean qyK;
  private boolean qyL;
  private View qyM;
  private View qyN;
  private String qyO;
  private long qyP;
  private final Object qyQ;
  private Timer qyR;
  private volatile boolean qyS;
  private Animation qyT;
  private volatile boolean qyU;
  private volatile boolean qyV;
  
  public c(String paramString, long paramLong)
  {
    AppMethodBeat.i(103819);
    this.qyK = false;
    this.qyL = false;
    this.qyM = null;
    this.qyN = null;
    this.qyQ = new Object();
    this.qyR = null;
    this.qyS = false;
    this.qyU = false;
    this.qyV = false;
    this.qyO = paramString;
    this.qyP = paramLong;
    this.qyT = AnimationUtils.loadAnimation(ai.getContext(), 2130772144);
    AppMethodBeat.o(103819);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(103822);
    this.qyM = LayoutInflater.from(paramContext).inflate(2131493907, paramViewGroup1);
    this.qyN = LayoutInflater.from(paramContext).inflate(2131493908, paramViewGroup2);
    this.qyN.setVisibility(4);
    if (cnT() != null) {
      cnT().setText(this.qyO);
    }
    long l = this.qyP;
    ac.i(TAG, "hy: starting tween timer: tween: %d", new Object[] { Long.valueOf(l) });
    if (this.qyR != null) {
      this.qyR.cancel();
    }
    this.qyR = new Timer("FaceDetect_hint", true);
    this.qyS = true;
    this.qyR.scheduleAtFixedRate(new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(103818);
        synchronized (c.b(c.this))
        {
          if (!c.c(c.this))
          {
            ac.w(c.TAG, "hy: already stopped");
            cancel();
          }
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(103817);
              if (c.this.cnT() != null) {
                c.this.cnT().startAnimation(c.d(c.this));
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
    if ((this.qyK) && (paramFaceCharacteristicsResult != null) && (paramFaceCharacteristicsResult.errCode == 18))
    {
      ac.d(TAG, "hy: ignore too active");
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
      this.qyK = true;
      if (!this.qyU)
      {
        bc.aF(ai.getContext(), 2131762119);
        paramFaceCharacteristicsResult = (TextView)this.qyM.findViewById(2131300745);
        Animation localAnimation1 = AnimationUtils.loadAnimation(ai.getContext(), 2130772040);
        Animation localAnimation2 = AnimationUtils.loadAnimation(ai.getContext(), 2130772047);
        localAnimation1.setDuration(qyJ);
        localAnimation2.setDuration(qyJ);
        paramFaceCharacteristicsResult.startAnimation(localAnimation1);
        paramFaceCharacteristicsResult.setVisibility(4);
        this.qyN.setVisibility(0);
        this.qyN.startAnimation(localAnimation2);
        this.qyN.findViewById(2131299694).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(103816);
            c.a(c.this);
            AppMethodBeat.o(103816);
          }
        });
        this.qyU = true;
        AppMethodBeat.o(103824);
        return true;
      }
    }
    AppMethodBeat.o(103824);
    return false;
  }
  
  public final boolean cnO()
  {
    return (this.qyK) && (this.qyL);
  }
  
  public final boolean cnP()
  {
    return false;
  }
  
  public final void cnQ()
  {
    AppMethodBeat.i(103825);
    this.qyS = false;
    if (this.qyR != null) {
      this.qyR.cancel();
    }
    this.qyK = false;
    this.qyU = false;
    this.qyV = false;
    this.qyL = false;
    AppMethodBeat.o(103825);
  }
  
  public final b.b cnR()
  {
    AppMethodBeat.i(103826);
    if (this.qyK)
    {
      localb = new b.b(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(103826);
      return localb;
    }
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(103826);
    return localb;
  }
  
  public final b.a cnS()
  {
    AppMethodBeat.i(103827);
    if ((this.qyK) && (!this.qyV))
    {
      this.qyV = true;
      b.a locala = new b.a();
      AppMethodBeat.o(103827);
      return locala;
    }
    AppMethodBeat.o(103827);
    return null;
  }
  
  public final TextView cnT()
  {
    AppMethodBeat.i(103820);
    TextView localTextView;
    if ((!this.qyK) && (this.qyM != null))
    {
      localTextView = (TextView)this.qyM.findViewById(2131300745);
      AppMethodBeat.o(103820);
      return localTextView;
    }
    if ((this.qyK) && (this.qyN != null))
    {
      localTextView = (TextView)this.qyN.findViewById(2131300745);
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
    if (cnT() == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d(str, bool);
      if (cnT() != null) {
        break;
      }
      AppMethodBeat.o(103821);
      return;
    }
    cnT().setText(paramString);
    AppMethodBeat.o(103821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c
 * JD-Core Version:    0.7.0.1
 */