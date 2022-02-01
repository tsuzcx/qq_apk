package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class FaceScanRect
  extends RelativeLayout
{
  public View roH;
  private ImageView roI;
  private ImageView roJ;
  private ImageView roK;
  private ImageView roL;
  private ImageView roM;
  private ImageView roN;
  private ImageView roO;
  private ImageView roP;
  public ImageView[] roQ;
  private ScaleAnimation roR;
  private ScaleAnimation roS;
  private ScaleAnimation roT;
  private ScaleAnimation roU;
  public TranslateAnimation roV;
  private b roW;
  private ViewGroup roX;
  public View roY;
  public FaceScanRect.a roZ;
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104189);
    this.roH = null;
    this.roI = null;
    this.roJ = null;
    this.roK = null;
    this.roL = null;
    this.roM = null;
    this.roN = null;
    this.roO = null;
    this.roP = null;
    this.roQ = null;
    this.roR = null;
    this.roS = null;
    this.roT = null;
    this.roU = null;
    this.roV = null;
    this.roW = null;
    this.roX = null;
    this.roY = null;
    LayoutInflater.from(paramContext).inflate(2131493923, this, true);
    this.roH = findViewById(2131299716);
    this.roI = ((ImageView)findViewById(2131299714));
    this.roJ = ((ImageView)findViewById(2131299715));
    this.roK = ((ImageView)findViewById(2131299711));
    this.roL = ((ImageView)findViewById(2131299710));
    this.roM = ((ImageView)findViewById(2131299713));
    this.roN = ((ImageView)findViewById(2131299712));
    this.roO = ((ImageView)findViewById(2131299708));
    this.roP = ((ImageView)findViewById(2131299709));
    this.roY = findViewById(2131299671);
    this.roX = ((ViewGroup)findViewById(2131299661));
    this.roQ = new ImageView[] { this.roI, this.roJ, this.roK, this.roL, this.roM, this.roN, this.roO, this.roP };
    this.roZ = FaceScanRect.a.rpc;
    this.roV = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.roV.setRepeatCount(-1);
    this.roV.setRepeatMode(1);
    this.roV.setDuration(1000L);
    AppMethodBeat.o(104189);
  }
  
  private void c(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(104192);
    int i = getWidth();
    int j = getHeight();
    int k = getResources().getDimensionPixelSize(2131166280);
    int m = getResources().getDimensionPixelSize(2131166281);
    float f1 = (i - k * 2 - m * 2 + m) / m;
    float f2 = (j - k * 2 - m * 2 + m) / m;
    ad.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    this.roR = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
    this.roR.setFillAfter(true);
    this.roR.setDuration(1500L);
    this.roR.setInterpolator(getContext(), 17563654);
    this.roR.setAnimationListener(paramAnimationListener);
    this.roS = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.roS.setFillAfter(true);
    this.roS.setDuration(1500L);
    this.roS.setInterpolator(getContext(), 17563654);
    this.roT = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 0.0F);
    this.roT.setFillAfter(true);
    this.roT.setDuration(1500L);
    this.roT.setInterpolator(getContext(), 17563654);
    this.roU = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 1.0F);
    this.roU.setFillAfter(true);
    this.roU.setDuration(1500L);
    this.roU.setInterpolator(getContext(), 17563654);
    AppMethodBeat.o(104192);
  }
  
  private void cul()
  {
    AppMethodBeat.i(104190);
    this.roY.setVisibility(8);
    this.roH.setBackground(null);
    this.roY.clearAnimation();
    AppMethodBeat.o(104190);
  }
  
  public final void b(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(104191);
    if (this.roZ == FaceScanRect.a.rpb)
    {
      ad.w("MicroMsg.FaceScanRect", "hy: already closed");
      if (paramAnimationListener != null) {
        paramAnimationListener.onAnimationEnd(null);
      }
      AppMethodBeat.o(104191);
      return;
    }
    this.roZ = FaceScanRect.a.rpb;
    c(paramAnimationListener);
    this.roI.startAnimation(this.roR);
    this.roL.startAnimation(this.roU);
    this.roM.startAnimation(this.roT);
    this.roP.startAnimation(this.roS);
    cul();
    paramAnimationListener = this.roQ;
    int j = paramAnimationListener.length;
    int i = 0;
    while (i < j)
    {
      paramAnimationListener[i].setBackgroundColor(getResources().getColor(2131100343));
      i += 1;
    }
    AppMethodBeat.o(104191);
  }
  
  public ViewGroup getCenterHintHolder()
  {
    return this.roX;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104193);
    super.onMeasure(paramInt1, paramInt2);
    if (this.roW != null) {
      this.roW.ctS();
    }
    AppMethodBeat.o(104193);
  }
  
  public void setOnRefreshRectListener(b paramb)
  {
    this.roW = paramb;
  }
  
  public static abstract interface b
  {
    public abstract void ctS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceScanRect
 * JD-Core Version:    0.7.0.1
 */