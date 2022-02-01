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
  private b pWA;
  private ViewGroup pWB;
  public View pWC;
  public FaceScanRect.a pWD;
  public View pWl;
  private ImageView pWm;
  private ImageView pWn;
  private ImageView pWo;
  private ImageView pWp;
  private ImageView pWq;
  private ImageView pWr;
  private ImageView pWs;
  private ImageView pWt;
  public ImageView[] pWu;
  private ScaleAnimation pWv;
  private ScaleAnimation pWw;
  private ScaleAnimation pWx;
  private ScaleAnimation pWy;
  public TranslateAnimation pWz;
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104189);
    this.pWl = null;
    this.pWm = null;
    this.pWn = null;
    this.pWo = null;
    this.pWp = null;
    this.pWq = null;
    this.pWr = null;
    this.pWs = null;
    this.pWt = null;
    this.pWu = null;
    this.pWv = null;
    this.pWw = null;
    this.pWx = null;
    this.pWy = null;
    this.pWz = null;
    this.pWA = null;
    this.pWB = null;
    this.pWC = null;
    LayoutInflater.from(paramContext).inflate(2131493923, this, true);
    this.pWl = findViewById(2131299716);
    this.pWm = ((ImageView)findViewById(2131299714));
    this.pWn = ((ImageView)findViewById(2131299715));
    this.pWo = ((ImageView)findViewById(2131299711));
    this.pWp = ((ImageView)findViewById(2131299710));
    this.pWq = ((ImageView)findViewById(2131299713));
    this.pWr = ((ImageView)findViewById(2131299712));
    this.pWs = ((ImageView)findViewById(2131299708));
    this.pWt = ((ImageView)findViewById(2131299709));
    this.pWC = findViewById(2131299671);
    this.pWB = ((ViewGroup)findViewById(2131299661));
    this.pWu = new ImageView[] { this.pWm, this.pWn, this.pWo, this.pWp, this.pWq, this.pWr, this.pWs, this.pWt };
    this.pWD = FaceScanRect.a.pWG;
    this.pWz = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.pWz.setRepeatCount(-1);
    this.pWz.setRepeatMode(1);
    this.pWz.setDuration(1000L);
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
    this.pWv = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
    this.pWv.setFillAfter(true);
    this.pWv.setDuration(1500L);
    this.pWv.setInterpolator(getContext(), 17563654);
    this.pWv.setAnimationListener(paramAnimationListener);
    this.pWw = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.pWw.setFillAfter(true);
    this.pWw.setDuration(1500L);
    this.pWw.setInterpolator(getContext(), 17563654);
    this.pWx = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 0.0F);
    this.pWx.setFillAfter(true);
    this.pWx.setDuration(1500L);
    this.pWx.setInterpolator(getContext(), 17563654);
    this.pWy = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 1.0F);
    this.pWy.setFillAfter(true);
    this.pWy.setDuration(1500L);
    this.pWy.setInterpolator(getContext(), 17563654);
    AppMethodBeat.o(104192);
  }
  
  private void cgZ()
  {
    AppMethodBeat.i(104190);
    this.pWC.setVisibility(8);
    this.pWl.setBackground(null);
    this.pWC.clearAnimation();
    AppMethodBeat.o(104190);
  }
  
  public final void b(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(104191);
    if (this.pWD == FaceScanRect.a.pWF)
    {
      ad.w("MicroMsg.FaceScanRect", "hy: already closed");
      if (paramAnimationListener != null) {
        paramAnimationListener.onAnimationEnd(null);
      }
      AppMethodBeat.o(104191);
      return;
    }
    this.pWD = FaceScanRect.a.pWF;
    c(paramAnimationListener);
    this.pWm.startAnimation(this.pWv);
    this.pWp.startAnimation(this.pWy);
    this.pWq.startAnimation(this.pWx);
    this.pWt.startAnimation(this.pWw);
    cgZ();
    paramAnimationListener = this.pWu;
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
    return this.pWB;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104193);
    super.onMeasure(paramInt1, paramInt2);
    if (this.pWA != null) {
      this.pWA.cgG();
    }
    AppMethodBeat.o(104193);
  }
  
  public void setOnRefreshRectListener(b paramb)
  {
    this.pWA = paramb;
  }
  
  public static abstract interface b
  {
    public abstract void cgG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceScanRect
 * JD-Core Version:    0.7.0.1
 */