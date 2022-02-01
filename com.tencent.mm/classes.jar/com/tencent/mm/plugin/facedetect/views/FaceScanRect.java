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
  public View wCG;
  private ImageView wCH;
  private ImageView wCI;
  private ImageView wCJ;
  private ImageView wCK;
  private ImageView wCL;
  private ImageView wCM;
  private ImageView wCN;
  private ImageView wCO;
  public ImageView[] wCP;
  private ScaleAnimation wCQ;
  private ScaleAnimation wCR;
  private ScaleAnimation wCS;
  private ScaleAnimation wCT;
  public TranslateAnimation wCU;
  private b wCV;
  private ViewGroup wCW;
  public View wCX;
  public a wCY;
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceScanRect(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104189);
    this.wCG = null;
    this.wCH = null;
    this.wCI = null;
    this.wCJ = null;
    this.wCK = null;
    this.wCL = null;
    this.wCM = null;
    this.wCN = null;
    this.wCO = null;
    this.wCP = null;
    this.wCQ = null;
    this.wCR = null;
    this.wCS = null;
    this.wCT = null;
    this.wCU = null;
    this.wCV = null;
    this.wCW = null;
    this.wCX = null;
    LayoutInflater.from(paramContext).inflate(a.g.face_scan_rect, this, true);
    this.wCG = findViewById(a.e.face_scan_rect_parent);
    this.wCH = ((ImageView)findViewById(a.e.face_rect_top_left));
    this.wCI = ((ImageView)findViewById(a.e.face_rect_top_right));
    this.wCJ = ((ImageView)findViewById(a.e.face_rect_left_top));
    this.wCK = ((ImageView)findViewById(a.e.face_rect_left_bottom));
    this.wCL = ((ImageView)findViewById(a.e.face_rect_right_top));
    this.wCM = ((ImageView)findViewById(a.e.face_rect_right_bottom));
    this.wCN = ((ImageView)findViewById(a.e.face_rect_bottom_left));
    this.wCO = ((ImageView)findViewById(a.e.face_rect_bottom_right));
    this.wCX = findViewById(a.e.face_detect_scan_line);
    this.wCW = ((ViewGroup)findViewById(a.e.face_center_hint));
    this.wCP = new ImageView[] { this.wCH, this.wCI, this.wCJ, this.wCK, this.wCL, this.wCM, this.wCN, this.wCO };
    this.wCY = a.wDb;
    this.wCU = new TranslateAnimation(2, 0.0F, 2, 1.0F, 2, 0.0F, 2, 0.0F);
    this.wCU.setRepeatCount(-1);
    this.wCU.setRepeatMode(1);
    this.wCU.setDuration(1000L);
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
    this.wCQ = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 0.0F, 1, 0.0F);
    this.wCQ.setFillAfter(true);
    this.wCQ.setDuration(1500L);
    this.wCQ.setInterpolator(getContext(), 17563654);
    this.wCQ.setAnimationListener(paramAnimationListener);
    this.wCR = new ScaleAnimation(1.0F, f1, 1.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.wCR.setFillAfter(true);
    this.wCR.setDuration(1500L);
    this.wCR.setInterpolator(getContext(), 17563654);
    this.wCS = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 0.0F);
    this.wCS.setFillAfter(true);
    this.wCS.setDuration(1500L);
    this.wCS.setInterpolator(getContext(), 17563654);
    this.wCT = new ScaleAnimation(1.0F, 1.0F, 1.0F, f2, 1, 0.0F, 1, 1.0F);
    this.wCT.setFillAfter(true);
    this.wCT.setDuration(1500L);
    this.wCT.setInterpolator(getContext(), 17563654);
    AppMethodBeat.o(104192);
  }
  
  private void djc()
  {
    AppMethodBeat.i(104190);
    this.wCX.setVisibility(8);
    this.wCG.setBackground(null);
    this.wCX.clearAnimation();
    AppMethodBeat.o(104190);
  }
  
  public final void b(Animation.AnimationListener paramAnimationListener)
  {
    AppMethodBeat.i(104191);
    if (this.wCY == a.wDa)
    {
      Log.w("MicroMsg.FaceScanRect", "hy: already closed");
      if (paramAnimationListener != null) {
        paramAnimationListener.onAnimationEnd(null);
      }
      AppMethodBeat.o(104191);
      return;
    }
    this.wCY = a.wDa;
    c(paramAnimationListener);
    this.wCH.startAnimation(this.wCQ);
    this.wCK.startAnimation(this.wCT);
    this.wCL.startAnimation(this.wCS);
    this.wCO.startAnimation(this.wCR);
    djc();
    paramAnimationListener = this.wCP;
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
    return this.wCW;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(104193);
    super.onMeasure(paramInt1, paramInt2);
    if (this.wCV != null) {
      this.wCV.onRefresh();
    }
    AppMethodBeat.o(104193);
  }
  
  public void setOnRefreshRectListener(b paramb)
  {
    this.wCV = paramb;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(104188);
      wCZ = new a("OPENED", 0);
      wDa = new a("CLOSED", 1);
      wDb = new a("INIT", 2);
      wDc = new a[] { wCZ, wDa, wDb };
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