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
  private static long pQb = 500L;
  private boolean pQc;
  private boolean pQd;
  private View pQe;
  private View pQf;
  private String pQg;
  private long pQh;
  private final Object pQi;
  private Timer pQj;
  private volatile boolean pQk;
  private Animation pQl;
  private volatile boolean pQm;
  private volatile boolean pQn;
  
  public c(String paramString, long paramLong)
  {
    AppMethodBeat.i(103819);
    this.pQc = false;
    this.pQd = false;
    this.pQe = null;
    this.pQf = null;
    this.pQi = new Object();
    this.pQj = null;
    this.pQk = false;
    this.pQm = false;
    this.pQn = false;
    this.pQg = paramString;
    this.pQh = paramLong;
    this.pQl = AnimationUtils.loadAnimation(aj.getContext(), 2130772144);
    AppMethodBeat.o(103819);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(103822);
    this.pQe = LayoutInflater.from(paramContext).inflate(2131493907, paramViewGroup1);
    this.pQf = LayoutInflater.from(paramContext).inflate(2131493908, paramViewGroup2);
    this.pQf.setVisibility(4);
    if (cgm() != null) {
      cgm().setText(this.pQg);
    }
    long l = this.pQh;
    ad.i(TAG, "hy: starting tween timer: tween: %d", new Object[] { Long.valueOf(l) });
    if (this.pQj != null) {
      this.pQj.cancel();
    }
    this.pQj = new Timer("FaceDetect_hint", true);
    this.pQk = true;
    this.pQj.scheduleAtFixedRate(new TimerTask()
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
              if (c.this.cgm() != null) {
                c.this.cgm().startAnimation(c.d(c.this));
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
    if ((this.pQc) && (paramFaceCharacteristicsResult != null) && (paramFaceCharacteristicsResult.errCode == 18))
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
      this.pQc = true;
      if (!this.pQm)
      {
        bd.az(aj.getContext(), 2131762119);
        paramFaceCharacteristicsResult = (TextView)this.pQe.findViewById(2131300745);
        Animation localAnimation1 = AnimationUtils.loadAnimation(aj.getContext(), 2130772040);
        Animation localAnimation2 = AnimationUtils.loadAnimation(aj.getContext(), 2130772047);
        localAnimation1.setDuration(pQb);
        localAnimation2.setDuration(pQb);
        paramFaceCharacteristicsResult.startAnimation(localAnimation1);
        paramFaceCharacteristicsResult.setVisibility(4);
        this.pQf.setVisibility(0);
        this.pQf.startAnimation(localAnimation2);
        this.pQf.findViewById(2131299694).setOnClickListener(new c.1(this));
        this.pQm = true;
        AppMethodBeat.o(103824);
        return true;
      }
    }
    AppMethodBeat.o(103824);
    return false;
  }
  
  public final boolean cgh()
  {
    return (this.pQc) && (this.pQd);
  }
  
  public final boolean cgi()
  {
    return false;
  }
  
  public final void cgj()
  {
    AppMethodBeat.i(103825);
    this.pQk = false;
    if (this.pQj != null) {
      this.pQj.cancel();
    }
    this.pQc = false;
    this.pQm = false;
    this.pQn = false;
    this.pQd = false;
    AppMethodBeat.o(103825);
  }
  
  public final b.b cgk()
  {
    AppMethodBeat.i(103826);
    if (this.pQc)
    {
      localb = new b.b(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(103826);
      return localb;
    }
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(103826);
    return localb;
  }
  
  public final b.a cgl()
  {
    AppMethodBeat.i(103827);
    if ((this.pQc) && (!this.pQn))
    {
      this.pQn = true;
      b.a locala = new b.a();
      AppMethodBeat.o(103827);
      return locala;
    }
    AppMethodBeat.o(103827);
    return null;
  }
  
  public final TextView cgm()
  {
    AppMethodBeat.i(103820);
    TextView localTextView;
    if ((!this.pQc) && (this.pQe != null))
    {
      localTextView = (TextView)this.pQe.findViewById(2131300745);
      AppMethodBeat.o(103820);
      return localTextView;
    }
    if ((this.pQc) && (this.pQf != null))
    {
      localTextView = (TextView)this.pQf.findViewById(2131300745);
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
    if (cgm() == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d(str, bool);
      if (cgm() != null) {
        break;
      }
      AppMethodBeat.o(103821);
      return;
    }
    cgm().setText(paramString);
    AppMethodBeat.o(103821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c
 * JD-Core Version:    0.7.0.1
 */