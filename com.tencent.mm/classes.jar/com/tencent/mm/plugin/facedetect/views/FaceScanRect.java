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
import com.tencent.mm.sdk.platformtools.ac;

public class FaceScanRect
  extends RelativeLayout
{
  public View qEQ;
  private ImageView qER;
  private ImageView qES;
  private ImageView qET;
  private ImageView qEU;
  private ImageView qEV;
  private ImageView qEW;
  private ImageView qEX;
  private ImageView qEY;
  public ImageView[] qEZ;
  private ScaleAnimation qFa;
  private ScaleAnimation qFb;
  private ScaleAnimation qFc;
  private ScaleAnimation qFd;
  public TranslateAnimation qFe;
  private b qFf;
  private ViewGroup qFg;
  public View qFh;
  public FaceScanRect.a qFi;
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104189);
    this.qEQ = null;
    this.qER = null;
    this.qES = null;
    this.qET = null;
    this.qEU = null;
    this.qEV = null;
    this.qEW = null;
    this.qEX = null;
    this.qEY = null;
    this.qEZ = null;
    this.qFa = null;
    this.qFb = null;
    this.qFc = null;
    this.qFd = null;
    this.qFe = null;
    this.qFf = null;
    this.qFg = null;
    this.qFh = null;
    LayoutInflater.from(paramContext).inflate(2131493923, this, true);
    this.qEQ = findViewById(2131299716);
    this.qER = ((ImageView)findViewById(2131299714));
    this.qES = ((ImageView)findViewById(2131299715));
    this.qET = ((ImageView)findViewById(2131299711));
    this.qEU = ((ImageView)findViewById(2131299710));
    this.qEV = ((ImageView)findViewById(2131299713));
    this.qEW = ((ImageView)findViewById(2131299712));
    this.qEX = ((ImageView)findViewById(2131299708));
    this.qEY = ((ImageView)findViewById(2131299709));
    this.qFh = findViewById(2131299671);
    this.qFg = ((ViewGroup)findViewById(2131299661));
    this.qEZ = new ImageView[] { this.qER, this.qES, this.qET, this.qEU, this.qEV, this.qEW, this.qEX, this.qEY };
    this.qFi = FaceScanRect.a.qFl;
    this.qFe = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.qFe.setRepeatCount(-1);
    this.qFe.setRepeatMode(1);
    this.qFe.setDuration(1000L);
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
    ac.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    this.qFa = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
    this.qFa.setFillAfter(true);
    this.qFa.setDuration(1500L);
    this.qFa.setInterpolator(getContext(), 17563654);
    this.qFa.setAnimationListener(paramAnimationListener);
    this.qFb = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.qFb.setFillAfter(true);
    this.qFb.setDuration(1500L);
    this.qFb.setInterpolator(getContext(), 17563654);
    this.qFc = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 0.0F);
    this.qFc.setFillAfter(true);
    this.qFc.setDuration(1500L);
    this.qFc.setInterpolator(getContext(), 17563654);
    this.qFd = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 1.0F);
    this.qFd.setFillAfter(true);
    this.qFd.setDuration(1500L);
    this.qFd.setInterpolator(getContext(), 17563654);
    AppMethodBeat.o(104192);
  }
  
  private void coG()
  {
    AppMethodBeat.i(104190);
    this.qFh.setVisibility(8);
    this.qEQ.setBackground(null);
    this.qFh.clearAnimation();
    AppMethodBeat.o(104190);
  }
  
  public final void b(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(104191);
    if (this.qFi == FaceScanRect.a.qFk)
    {
      ac.w("MicroMsg.FaceScanRect", "hy: already closed");
      if (paramAnimationListener != null) {
        paramAnimationListener.onAnimationEnd(null);
      }
      AppMethodBeat.o(104191);
      return;
    }
    this.qFi = FaceScanRect.a.qFk;
    c(paramAnimationListener);
    this.qER.startAnimation(this.qFa);
    this.qEU.startAnimation(this.qFd);
    this.qEV.startAnimation(this.qFc);
    this.qEY.startAnimation(this.qFb);
    coG();
    paramAnimationListener = this.qEZ;
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
    return this.qFg;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104193);
    super.onMeasure(paramInt1, paramInt2);
    if (this.qFf != null) {
      this.qFf.con();
    }
    AppMethodBeat.o(104193);
  }
  
  public void setOnRefreshRectListener(b paramb)
  {
    this.qFf = paramb;
  }
  
  public static abstract interface b
  {
    public abstract void con();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceScanRect
 * JD-Core Version:    0.7.0.1
 */