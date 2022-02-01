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
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.Log;

public class FaceScanRect
  extends RelativeLayout
{
  public View zYR;
  private ImageView zYS;
  private ImageView zYT;
  private ImageView zYU;
  private ImageView zYV;
  private ImageView zYW;
  private ImageView zYX;
  private ImageView zYY;
  private ImageView zYZ;
  public ImageView[] zZa;
  private ScaleAnimation zZb;
  private ScaleAnimation zZc;
  private ScaleAnimation zZd;
  private ScaleAnimation zZe;
  public TranslateAnimation zZf;
  private b zZg;
  private ViewGroup zZh;
  public View zZi;
  public a zZj;
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104189);
    this.zYR = null;
    this.zYS = null;
    this.zYT = null;
    this.zYU = null;
    this.zYV = null;
    this.zYW = null;
    this.zYX = null;
    this.zYY = null;
    this.zYZ = null;
    this.zZa = null;
    this.zZb = null;
    this.zZc = null;
    this.zZd = null;
    this.zZe = null;
    this.zZf = null;
    this.zZg = null;
    this.zZh = null;
    this.zZi = null;
    LayoutInflater.from(paramContext).inflate(a.g.face_scan_rect, this, true);
    this.zYR = findViewById(a.e.face_scan_rect_parent);
    this.zYS = ((ImageView)findViewById(a.e.face_rect_top_left));
    this.zYT = ((ImageView)findViewById(a.e.face_rect_top_right));
    this.zYU = ((ImageView)findViewById(a.e.face_rect_left_top));
    this.zYV = ((ImageView)findViewById(a.e.face_rect_left_bottom));
    this.zYW = ((ImageView)findViewById(a.e.face_rect_right_top));
    this.zYX = ((ImageView)findViewById(a.e.face_rect_right_bottom));
    this.zYY = ((ImageView)findViewById(a.e.face_rect_bottom_left));
    this.zYZ = ((ImageView)findViewById(a.e.face_rect_bottom_right));
    this.zZi = findViewById(a.e.face_detect_scan_line);
    this.zZh = ((ViewGroup)findViewById(a.e.face_center_hint));
    this.zZa = new ImageView[] { this.zYS, this.zYT, this.zYU, this.zYV, this.zYW, this.zYX, this.zYY, this.zYZ };
    this.zZj = a.zZm;
    this.zZf = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.zZf.setRepeatCount(-1);
    this.zZf.setRepeatMode(1);
    this.zZf.setDuration(1000L);
    AppMethodBeat.o(104189);
  }
  
  private void c(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(104192);
    int i = getWidth();
    int j = getHeight();
    int k = getResources().getDimensionPixelSize(a.c.face_rect_green_string_length);
    int m = getResources().getDimensionPixelSize(a.c.face_rect_white_string_length);
    float f1 = (i - k * 2 - m * 2 + m) / m;
    float f2 = (j - k * 2 - m * 2 + m) / m;
    Log.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    this.zZb = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
    this.zZb.setFillAfter(true);
    this.zZb.setDuration(1500L);
    this.zZb.setInterpolator(getContext(), 17563654);
    this.zZb.setAnimationListener(paramAnimationListener);
    this.zZc = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.zZc.setFillAfter(true);
    this.zZc.setDuration(1500L);
    this.zZc.setInterpolator(getContext(), 17563654);
    this.zZd = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 0.0F);
    this.zZd.setFillAfter(true);
    this.zZd.setDuration(1500L);
    this.zZd.setInterpolator(getContext(), 17563654);
    this.zZe = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 1.0F);
    this.zZe.setFillAfter(true);
    this.zZe.setDuration(1500L);
    this.zZe.setInterpolator(getContext(), 17563654);
    AppMethodBeat.o(104192);
  }
  
  private void dPN()
  {
    AppMethodBeat.i(104190);
    this.zZi.setVisibility(8);
    this.zYR.setBackground(null);
    this.zZi.clearAnimation();
    AppMethodBeat.o(104190);
  }
  
  public final void b(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(104191);
    if (this.zZj == a.zZl)
    {
      Log.w("MicroMsg.FaceScanRect", "hy: already closed");
      if (paramAnimationListener != null) {
        paramAnimationListener.onAnimationEnd(null);
      }
      AppMethodBeat.o(104191);
      return;
    }
    this.zZj = a.zZl;
    c(paramAnimationListener);
    this.zYS.startAnimation(this.zZb);
    this.zYV.startAnimation(this.zZe);
    this.zYW.startAnimation(this.zZd);
    this.zYZ.startAnimation(this.zZc);
    dPN();
    paramAnimationListener = this.zZa;
    int j = paramAnimationListener.length;
    int i = 0;
    while (i < j)
    {
      paramAnimationListener[i].setBackgroundColor(getResources().getColor(a.b.face_white_string_transparent));
      i += 1;
    }
    AppMethodBeat.o(104191);
  }
  
  public ViewGroup getCenterHintHolder()
  {
    return this.zZh;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104193);
    super.onMeasure(paramInt1, paramInt2);
    if (this.zZg != null) {
      this.zZg.onRefresh();
    }
    AppMethodBeat.o(104193);
  }
  
  public void setOnRefreshRectListener(b paramb)
  {
    this.zZg = paramb;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(104188);
      zZk = new a("OPENED", 0);
      zZl = new a("CLOSED", 1);
      zZm = new a("INIT", 2);
      zZn = new a[] { zZk, zZl, zZm };
      AppMethodBeat.o(104188);
    }
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void onRefresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceScanRect
 * JD-Core Version:    0.7.0.1
 */