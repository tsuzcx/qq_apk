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
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.sdk.platformtools.y;

public class FaceScanRect
  extends RelativeLayout
{
  private ViewGroup jVA = null;
  public View jVB = null;
  public FaceScanRect.a jVC;
  public View jVk = null;
  private ImageView jVl = null;
  private ImageView jVm = null;
  private ImageView jVn = null;
  private ImageView jVo = null;
  private ImageView jVp = null;
  private ImageView jVq = null;
  private ImageView jVr = null;
  private ImageView jVs = null;
  public ImageView[] jVt = null;
  private ScaleAnimation jVu = null;
  private ScaleAnimation jVv = null;
  private ScaleAnimation jVw = null;
  private ScaleAnimation jVx = null;
  public TranslateAnimation jVy = null;
  private FaceScanRect.b jVz = null;
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(a.g.face_scan_rect, this, true);
    this.jVk = findViewById(a.e.face_scan_rect_parent);
    this.jVl = ((ImageView)findViewById(a.e.face_rect_top_left));
    this.jVm = ((ImageView)findViewById(a.e.face_rect_top_right));
    this.jVn = ((ImageView)findViewById(a.e.face_rect_left_top));
    this.jVo = ((ImageView)findViewById(a.e.face_rect_left_bottom));
    this.jVp = ((ImageView)findViewById(a.e.face_rect_right_top));
    this.jVq = ((ImageView)findViewById(a.e.face_rect_right_bottom));
    this.jVr = ((ImageView)findViewById(a.e.face_rect_bottom_left));
    this.jVs = ((ImageView)findViewById(a.e.face_rect_bottom_right));
    this.jVB = findViewById(a.e.face_detect_scan_line);
    this.jVA = ((ViewGroup)findViewById(a.e.face_center_hint));
    this.jVt = new ImageView[] { this.jVl, this.jVm, this.jVn, this.jVo, this.jVp, this.jVq, this.jVr, this.jVs };
    this.jVC = FaceScanRect.a.jVF;
    this.jVy = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.jVy.setRepeatCount(-1);
    this.jVy.setRepeatMode(1);
    this.jVy.setDuration(1000L);
  }
  
  public final void b(Animation.AnimationListener paramAnimationListener)
  {
    if (this.jVC == FaceScanRect.a.jVE)
    {
      y.w("MicroMsg.FaceScanRect", "hy: already closed");
      if (paramAnimationListener != null) {
        paramAnimationListener.onAnimationEnd(null);
      }
    }
    for (;;)
    {
      return;
      this.jVC = FaceScanRect.a.jVE;
      int i = getWidth();
      int j = getHeight();
      int k = getResources().getDimensionPixelSize(a.c.face_rect_green_string_length);
      int m = getResources().getDimensionPixelSize(a.c.face_rect_white_string_length);
      float f1 = (i - k * 2 - m * 2 + m) / m;
      float f2 = (j - k * 2 - m * 2 + m) / m;
      y.i("MicroMsg.FaceScanRect", "hy: horizontalScale : %f, verticalScale : %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
      this.jVu = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
      this.jVu.setFillAfter(true);
      this.jVu.setDuration(1500L);
      this.jVu.setInterpolator(getContext(), 17563654);
      this.jVu.setAnimationListener(paramAnimationListener);
      this.jVv = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
      this.jVv.setFillAfter(true);
      this.jVv.setDuration(1500L);
      this.jVv.setInterpolator(getContext(), 17563654);
      this.jVw = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 0.0F);
      this.jVw.setFillAfter(true);
      this.jVw.setDuration(1500L);
      this.jVw.setInterpolator(getContext(), 17563654);
      this.jVx = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 1.0F);
      this.jVx.setFillAfter(true);
      this.jVx.setDuration(1500L);
      this.jVx.setInterpolator(getContext(), 17563654);
      this.jVl.startAnimation(this.jVu);
      this.jVo.startAnimation(this.jVx);
      this.jVp.startAnimation(this.jVw);
      this.jVs.startAnimation(this.jVv);
      this.jVB.setVisibility(8);
      this.jVk.setBackground(null);
      this.jVB.clearAnimation();
      paramAnimationListener = this.jVt;
      j = paramAnimationListener.length;
      i = 0;
      while (i < j)
      {
        paramAnimationListener[i].setBackgroundColor(getResources().getColor(a.b.face_white_string_transparent));
        i += 1;
      }
    }
  }
  
  public ViewGroup getCenterHintHolder()
  {
    return this.jVA;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jVz != null) {
      this.jVz.aPg();
    }
  }
  
  public void setOnRefreshRectListener(FaceScanRect.b paramb)
  {
    this.jVz = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceScanRect
 * JD-Core Version:    0.7.0.1
 */