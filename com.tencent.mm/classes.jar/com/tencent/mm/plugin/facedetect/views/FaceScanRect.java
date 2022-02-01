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
import com.tencent.mm.sdk.platformtools.Log;

public class FaceScanRect
  extends RelativeLayout
{
  public View sWI;
  private ImageView sWJ;
  private ImageView sWK;
  private ImageView sWL;
  private ImageView sWM;
  private ImageView sWN;
  private ImageView sWO;
  private ImageView sWP;
  private ImageView sWQ;
  public ImageView[] sWR;
  private ScaleAnimation sWS;
  private ScaleAnimation sWT;
  private ScaleAnimation sWU;
  private ScaleAnimation sWV;
  public TranslateAnimation sWW;
  private b sWX;
  private ViewGroup sWY;
  public View sWZ;
  public a sXa;
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104189);
    this.sWI = null;
    this.sWJ = null;
    this.sWK = null;
    this.sWL = null;
    this.sWM = null;
    this.sWN = null;
    this.sWO = null;
    this.sWP = null;
    this.sWQ = null;
    this.sWR = null;
    this.sWS = null;
    this.sWT = null;
    this.sWU = null;
    this.sWV = null;
    this.sWW = null;
    this.sWX = null;
    this.sWY = null;
    this.sWZ = null;
    LayoutInflater.from(paramContext).inflate(2131494091, this, true);
    this.sWI = findViewById(2131300382);
    this.sWJ = ((ImageView)findViewById(2131300380));
    this.sWK = ((ImageView)findViewById(2131300381));
    this.sWL = ((ImageView)findViewById(2131300377));
    this.sWM = ((ImageView)findViewById(2131300376));
    this.sWN = ((ImageView)findViewById(2131300379));
    this.sWO = ((ImageView)findViewById(2131300378));
    this.sWP = ((ImageView)findViewById(2131300374));
    this.sWQ = ((ImageView)findViewById(2131300375));
    this.sWZ = findViewById(2131300323);
    this.sWY = ((ViewGroup)findViewById(2131300312));
    this.sWR = new ImageView[] { this.sWJ, this.sWK, this.sWL, this.sWM, this.sWN, this.sWO, this.sWP, this.sWQ };
    this.sXa = a.sXd;
    this.sWW = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.sWW.setRepeatCount(-1);
    this.sWW.setRepeatMode(1);
    this.sWW.setDuration(1000L);
    AppMethodBeat.o(104189);
  }
  
  private void c(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(104192);
    int i = getWidth();
    int j = getHeight();
    int k = getResources().getDimensionPixelSize(2131166327);
    int m = getResources().getDimensionPixelSize(2131166328);
    float f1 = (i - k * 2 - m * 2 + m) / m;
    float f2 = (j - k * 2 - m * 2 + m) / m;
    Log.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    this.sWS = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
    this.sWS.setFillAfter(true);
    this.sWS.setDuration(1500L);
    this.sWS.setInterpolator(getContext(), 17563654);
    this.sWS.setAnimationListener(paramAnimationListener);
    this.sWT = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.sWT.setFillAfter(true);
    this.sWT.setDuration(1500L);
    this.sWT.setInterpolator(getContext(), 17563654);
    this.sWU = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 0.0F);
    this.sWU.setFillAfter(true);
    this.sWU.setDuration(1500L);
    this.sWU.setInterpolator(getContext(), 17563654);
    this.sWV = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 1.0F);
    this.sWV.setFillAfter(true);
    this.sWV.setDuration(1500L);
    this.sWV.setInterpolator(getContext(), 17563654);
    AppMethodBeat.o(104192);
  }
  
  private void cTW()
  {
    AppMethodBeat.i(104190);
    this.sWZ.setVisibility(8);
    this.sWI.setBackground(null);
    this.sWZ.clearAnimation();
    AppMethodBeat.o(104190);
  }
  
  public final void b(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(104191);
    if (this.sXa == a.sXc)
    {
      Log.w("MicroMsg.FaceScanRect", "hy: already closed");
      if (paramAnimationListener != null) {
        paramAnimationListener.onAnimationEnd(null);
      }
      AppMethodBeat.o(104191);
      return;
    }
    this.sXa = a.sXc;
    c(paramAnimationListener);
    this.sWJ.startAnimation(this.sWS);
    this.sWM.startAnimation(this.sWV);
    this.sWN.startAnimation(this.sWU);
    this.sWQ.startAnimation(this.sWT);
    cTW();
    paramAnimationListener = this.sWR;
    int j = paramAnimationListener.length;
    int i = 0;
    while (i < j)
    {
      paramAnimationListener[i].setBackgroundColor(getResources().getColor(2131100378));
      i += 1;
    }
    AppMethodBeat.o(104191);
  }
  
  public ViewGroup getCenterHintHolder()
  {
    return this.sWY;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104193);
    super.onMeasure(paramInt1, paramInt2);
    if (this.sWX != null) {
      this.sWX.onRefresh();
    }
    AppMethodBeat.o(104193);
  }
  
  public void setOnRefreshRectListener(b paramb)
  {
    this.sWX = paramb;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(104188);
      sXb = new a("OPENED", 0);
      sXc = new a("CLOSED", 1);
      sXd = new a("INIT", 2);
      sXe = new a[] { sXb, sXc, sXd };
      AppMethodBeat.o(104188);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceScanRect
 * JD-Core Version:    0.7.0.1
 */