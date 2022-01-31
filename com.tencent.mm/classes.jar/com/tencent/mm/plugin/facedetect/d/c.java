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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.Timer;

public final class c
  implements b
{
  private static String TAG = "MicroMsg.NormalFaceMotion";
  private static long mjq = 500L;
  private Animation mjA;
  private volatile boolean mjB;
  private volatile boolean mjC;
  private boolean mjr;
  private boolean mjs;
  private View mjt;
  private View mju;
  private String mjv;
  private long mjw;
  private final Object mjx;
  private Timer mjy;
  private volatile boolean mjz;
  
  public c(String paramString, long paramLong)
  {
    AppMethodBeat.i(300);
    this.mjr = false;
    this.mjs = false;
    this.mjt = null;
    this.mju = null;
    this.mjx = new Object();
    this.mjy = null;
    this.mjz = false;
    this.mjB = false;
    this.mjC = false;
    this.mjv = paramString;
    this.mjw = paramLong;
    this.mjA = AnimationUtils.loadAnimation(ah.getContext(), 2131034266);
    AppMethodBeat.o(300);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(303);
    this.mjt = LayoutInflater.from(paramContext).inflate(2130969494, paramViewGroup1);
    this.mju = LayoutInflater.from(paramContext).inflate(2130969495, paramViewGroup2);
    this.mju.setVisibility(4);
    if (buS() != null) {
      buS().setText(this.mjv);
    }
    long l = this.mjw;
    ab.i(TAG, "hy: starting tween timer: tween: %d", new Object[] { Long.valueOf(l) });
    if (this.mjy != null) {
      this.mjy.cancel();
    }
    this.mjy = new Timer("FaceDetect_hint", true);
    this.mjz = true;
    this.mjy.scheduleAtFixedRate(new c.2(this), 0L, l);
    AppMethodBeat.o(303);
  }
  
  public final boolean a(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    AppMethodBeat.i(304);
    if ((this.mjr) && (paramFaceCharacteristicsResult != null) && (paramFaceCharacteristicsResult.errCode == 18))
    {
      ab.d(TAG, "hy: ignore too active");
      AppMethodBeat.o(304);
      return true;
    }
    AppMethodBeat.o(304);
    return false;
  }
  
  public final boolean b(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    AppMethodBeat.i(305);
    if (paramFaceCharacteristicsResult.errCode == -1)
    {
      this.mjr = true;
      if (!this.mjB)
      {
        ay.ax(ah.getContext(), 2131302240);
        paramFaceCharacteristicsResult = (TextView)this.mjt.findViewById(2131823891);
        Animation localAnimation1 = AnimationUtils.loadAnimation(ah.getContext(), 2131034174);
        Animation localAnimation2 = AnimationUtils.loadAnimation(ah.getContext(), 2131034181);
        localAnimation1.setDuration(mjq);
        localAnimation2.setDuration(mjq);
        paramFaceCharacteristicsResult.startAnimation(localAnimation1);
        paramFaceCharacteristicsResult.setVisibility(4);
        this.mju.setVisibility(0);
        this.mju.startAnimation(localAnimation2);
        this.mju.findViewById(2131823892).setOnClickListener(new c.1(this));
        this.mjB = true;
        AppMethodBeat.o(305);
        return true;
      }
    }
    AppMethodBeat.o(305);
    return false;
  }
  
  public final boolean buN()
  {
    return (this.mjr) && (this.mjs);
  }
  
  public final boolean buO()
  {
    return false;
  }
  
  public final void buP()
  {
    AppMethodBeat.i(306);
    this.mjz = false;
    if (this.mjy != null) {
      this.mjy.cancel();
    }
    this.mjr = false;
    this.mjB = false;
    this.mjC = false;
    this.mjs = false;
    AppMethodBeat.o(306);
  }
  
  public final b.b buQ()
  {
    AppMethodBeat.i(307);
    if (this.mjr)
    {
      localb = new b.b(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(307);
      return localb;
    }
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(307);
    return localb;
  }
  
  public final b.a buR()
  {
    AppMethodBeat.i(308);
    if ((this.mjr) && (!this.mjC))
    {
      this.mjC = true;
      b.a locala = new b.a();
      AppMethodBeat.o(308);
      return locala;
    }
    AppMethodBeat.o(308);
    return null;
  }
  
  public final TextView buS()
  {
    AppMethodBeat.i(301);
    TextView localTextView;
    if ((!this.mjr) && (this.mjt != null))
    {
      localTextView = (TextView)this.mjt.findViewById(2131823891);
      AppMethodBeat.o(301);
      return localTextView;
    }
    if ((this.mjr) && (this.mju != null))
    {
      localTextView = (TextView)this.mju.findViewById(2131823891);
      AppMethodBeat.o(301);
      return localTextView;
    }
    AppMethodBeat.o(301);
    return null;
  }
  
  public final void setBusinessTip(String paramString)
  {
    AppMethodBeat.i(302);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("getHintMsgTv() == null : ");
    if (buS() == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d(str, bool);
      if (buS() != null) {
        break;
      }
      AppMethodBeat.o(302);
      return;
    }
    buS().setText(paramString);
    AppMethodBeat.o(302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.c
 * JD-Core Version:    0.7.0.1
 */