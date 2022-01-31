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
import com.tencent.mm.sdk.platformtools.ab;

public class FaceScanRect
  extends RelativeLayout
{
  public View mpC;
  private ImageView mpD;
  private ImageView mpE;
  private ImageView mpF;
  private ImageView mpG;
  private ImageView mpH;
  private ImageView mpI;
  private ImageView mpJ;
  private ImageView mpK;
  public ImageView[] mpL;
  private ScaleAnimation mpM;
  private ScaleAnimation mpN;
  private ScaleAnimation mpO;
  private ScaleAnimation mpP;
  public TranslateAnimation mpQ;
  private FaceScanRect.b mpR;
  private ViewGroup mpS;
  public View mpT;
  public FaceScanRect.a mpU;
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(665);
    this.mpC = null;
    this.mpD = null;
    this.mpE = null;
    this.mpF = null;
    this.mpG = null;
    this.mpH = null;
    this.mpI = null;
    this.mpJ = null;
    this.mpK = null;
    this.mpL = null;
    this.mpM = null;
    this.mpN = null;
    this.mpO = null;
    this.mpP = null;
    this.mpQ = null;
    this.mpR = null;
    this.mpS = null;
    this.mpT = null;
    LayoutInflater.from(paramContext).inflate(2130969510, this, true);
    this.mpC = findViewById(2131823932);
    this.mpD = ((ImageView)findViewById(2131823934));
    this.mpE = ((ImageView)findViewById(2131823935));
    this.mpF = ((ImageView)findViewById(2131823938));
    this.mpG = ((ImageView)findViewById(2131823939));
    this.mpH = ((ImageView)findViewById(2131823940));
    this.mpI = ((ImageView)findViewById(2131823941));
    this.mpJ = ((ImageView)findViewById(2131823936));
    this.mpK = ((ImageView)findViewById(2131823937));
    this.mpT = findViewById(2131823933);
    this.mpS = ((ViewGroup)findViewById(2131823942));
    this.mpL = new ImageView[] { this.mpD, this.mpE, this.mpF, this.mpG, this.mpH, this.mpI, this.mpJ, this.mpK };
    this.mpU = FaceScanRect.a.mpX;
    this.mpQ = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.mpQ.setRepeatCount(-1);
    this.mpQ.setRepeatMode(1);
    this.mpQ.setDuration(1000L);
    AppMethodBeat.o(665);
  }
  
  private void bvE()
  {
    AppMethodBeat.i(666);
    this.mpT.setVisibility(8);
    this.mpC.setBackground(null);
    this.mpT.clearAnimation();
    AppMethodBeat.o(666);
  }
  
  private void c(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(668);
    int i = getWidth();
    int j = getHeight();
    int k = getResources().getDimensionPixelSize(2131428414);
    int m = getResources().getDimensionPixelSize(2131428415);
    float f1 = (i - k * 2 - m * 2 + m) / m;
    float f2 = (j - k * 2 - m * 2 + m) / m;
    ab.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    this.mpM = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
    this.mpM.setFillAfter(true);
    this.mpM.setDuration(1500L);
    this.mpM.setInterpolator(getContext(), 17563654);
    this.mpM.setAnimationListener(paramAnimationListener);
    this.mpN = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.mpN.setFillAfter(true);
    this.mpN.setDuration(1500L);
    this.mpN.setInterpolator(getContext(), 17563654);
    this.mpO = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 0.0F);
    this.mpO.setFillAfter(true);
    this.mpO.setDuration(1500L);
    this.mpO.setInterpolator(getContext(), 17563654);
    this.mpP = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 1.0F);
    this.mpP.setFillAfter(true);
    this.mpP.setDuration(1500L);
    this.mpP.setInterpolator(getContext(), 17563654);
    AppMethodBeat.o(668);
  }
  
  public final void b(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(667);
    if (this.mpU == FaceScanRect.a.mpW)
    {
      ab.w("MicroMsg.FaceScanRect", "hy: already closed");
      if (paramAnimationListener != null) {
        paramAnimationListener.onAnimationEnd(null);
      }
      AppMethodBeat.o(667);
      return;
    }
    this.mpU = FaceScanRect.a.mpW;
    c(paramAnimationListener);
    this.mpD.startAnimation(this.mpM);
    this.mpG.startAnimation(this.mpP);
    this.mpH.startAnimation(this.mpO);
    this.mpK.startAnimation(this.mpN);
    bvE();
    paramAnimationListener = this.mpL;
    int j = paramAnimationListener.length;
    int i = 0;
    while (i < j)
    {
      paramAnimationListener[i].setBackgroundColor(getResources().getColor(2131690043));
      i += 1;
    }
    AppMethodBeat.o(667);
  }
  
  public ViewGroup getCenterHintHolder()
  {
    return this.mpS;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(669);
    super.onMeasure(paramInt1, paramInt2);
    if (this.mpR != null) {
      this.mpR.bvl();
    }
    AppMethodBeat.o(669);
  }
  
  public void setOnRefreshRectListener(FaceScanRect.b paramb)
  {
    this.mpR = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceScanRect
 * JD-Core Version:    0.7.0.1
 */