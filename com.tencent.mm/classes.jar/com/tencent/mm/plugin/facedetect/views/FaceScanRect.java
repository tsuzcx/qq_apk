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
import com.tencent.mm.sdk.platformtools.ae;

public class FaceScanRect
  extends RelativeLayout
{
  public View rwL;
  private ImageView rwM;
  private ImageView rwN;
  private ImageView rwO;
  private ImageView rwP;
  private ImageView rwQ;
  private ImageView rwR;
  private ImageView rwS;
  private ImageView rwT;
  public ImageView[] rwU;
  private ScaleAnimation rwV;
  private ScaleAnimation rwW;
  private ScaleAnimation rwX;
  private ScaleAnimation rwY;
  public TranslateAnimation rwZ;
  private FaceScanRect.b rxa;
  private ViewGroup rxb;
  public View rxc;
  public a rxd;
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104189);
    this.rwL = null;
    this.rwM = null;
    this.rwN = null;
    this.rwO = null;
    this.rwP = null;
    this.rwQ = null;
    this.rwR = null;
    this.rwS = null;
    this.rwT = null;
    this.rwU = null;
    this.rwV = null;
    this.rwW = null;
    this.rwX = null;
    this.rwY = null;
    this.rwZ = null;
    this.rxa = null;
    this.rxb = null;
    this.rxc = null;
    LayoutInflater.from(paramContext).inflate(2131493923, this, true);
    this.rwL = findViewById(2131299716);
    this.rwM = ((ImageView)findViewById(2131299714));
    this.rwN = ((ImageView)findViewById(2131299715));
    this.rwO = ((ImageView)findViewById(2131299711));
    this.rwP = ((ImageView)findViewById(2131299710));
    this.rwQ = ((ImageView)findViewById(2131299713));
    this.rwR = ((ImageView)findViewById(2131299712));
    this.rwS = ((ImageView)findViewById(2131299708));
    this.rwT = ((ImageView)findViewById(2131299709));
    this.rxc = findViewById(2131299671);
    this.rxb = ((ViewGroup)findViewById(2131299661));
    this.rwU = new ImageView[] { this.rwM, this.rwN, this.rwO, this.rwP, this.rwQ, this.rwR, this.rwS, this.rwT };
    this.rxd = a.rxg;
    this.rwZ = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.rwZ.setRepeatCount(-1);
    this.rwZ.setRepeatMode(1);
    this.rwZ.setDuration(1000L);
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
    ae.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    this.rwV = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
    this.rwV.setFillAfter(true);
    this.rwV.setDuration(1500L);
    this.rwV.setInterpolator(getContext(), 17563654);
    this.rwV.setAnimationListener(paramAnimationListener);
    this.rwW = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.rwW.setFillAfter(true);
    this.rwW.setDuration(1500L);
    this.rwW.setInterpolator(getContext(), 17563654);
    this.rwX = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 0.0F);
    this.rwX.setFillAfter(true);
    this.rwX.setDuration(1500L);
    this.rwX.setInterpolator(getContext(), 17563654);
    this.rwY = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 1.0F);
    this.rwY.setFillAfter(true);
    this.rwY.setDuration(1500L);
    this.rwY.setInterpolator(getContext(), 17563654);
    AppMethodBeat.o(104192);
  }
  
  private void cvM()
  {
    AppMethodBeat.i(104190);
    this.rxc.setVisibility(8);
    this.rwL.setBackground(null);
    this.rxc.clearAnimation();
    AppMethodBeat.o(104190);
  }
  
  public final void b(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(104191);
    if (this.rxd == a.rxf)
    {
      ae.w("MicroMsg.FaceScanRect", "hy: already closed");
      if (paramAnimationListener != null) {
        paramAnimationListener.onAnimationEnd(null);
      }
      AppMethodBeat.o(104191);
      return;
    }
    this.rxd = a.rxf;
    c(paramAnimationListener);
    this.rwM.startAnimation(this.rwV);
    this.rwP.startAnimation(this.rwY);
    this.rwQ.startAnimation(this.rwX);
    this.rwT.startAnimation(this.rwW);
    cvM();
    paramAnimationListener = this.rwU;
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
    return this.rxb;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104193);
    super.onMeasure(paramInt1, paramInt2);
    if (this.rxa != null) {
      this.rxa.cvt();
    }
    AppMethodBeat.o(104193);
  }
  
  public void setOnRefreshRectListener(FaceScanRect.b paramb)
  {
    this.rxa = paramb;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(104188);
      rxe = new a("OPENED", 0);
      rxf = new a("CLOSED", 1);
      rxg = new a("INIT", 2);
      rxh = new a[] { rxe, rxf, rxg };
      AppMethodBeat.o(104188);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceScanRect
 * JD-Core Version:    0.7.0.1
 */