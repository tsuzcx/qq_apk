package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ac.a.a;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.c.a.c;

public class FaceDetectView
  extends RelativeLayout
{
  public static long jUG = 100L;
  public static int jUH = 1;
  public volatile boolean inQ = false;
  public boolean isPaused = false;
  public long jNX = -1L;
  private TextView jRy = null;
  public boolean jUA = false;
  public long jUB = -1L;
  private long jUC = -1L;
  private final int jUD = 1500;
  private Animation jUE;
  private View jUF = null;
  public FaceDetectCameraView jUq = null;
  public FaceDetectDecorView jUr = null;
  public ViewGroup jUs = null;
  public ViewGroup jUt = null;
  private a jUu = null;
  public b jUv;
  public boolean jUw = false;
  public boolean jUx = false;
  public String jUy = ae.getContext().getString(a.i.soter_face_err_msg_ok);
  public boolean jUz = true;
  
  public FaceDetectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private FaceDetectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = LayoutInflater.from(paramContext).inflate(a.g.soter_face_detect_view, null, false);
    addView(paramContext);
    this.jUq = ((FaceDetectCameraView)paramContext.findViewById(a.e.camera_view));
    this.jUr = ((FaceDetectDecorView)paramContext.findViewById(a.e.helper_view));
    this.jUF = paramContext.findViewById(a.e.gauss_blur_view);
    this.jUq.jTF = new FaceDetectView.1(this);
    paramContext = getContext();
    if (paramContext == null)
    {
      y.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
      paramContext = null;
    }
    for (;;)
    {
      this.jUE = paramContext;
      return;
      paramContext = AnimationUtils.loadAnimation(paramContext, a.a.anim_shake);
      paramContext.setInterpolator(new c());
    }
  }
  
  private void Cs(String paramString)
  {
    if (bk.pm(paramString).equals(this.jRy.getText().toString()))
    {
      y.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
      return;
    }
    this.jRy.setText(paramString);
    this.jRy.setVisibility(0);
    this.jRy.setAnimation(this.jUE);
  }
  
  private void aPu()
  {
    this.jRy.setText("");
    this.jRy.setVisibility(4);
  }
  
  public final void fQ(boolean paramBoolean)
  {
    if (this.jUv != null) {
      this.jUv.aOL();
    }
    if (!this.inQ)
    {
      this.inQ = true;
      if (paramBoolean) {
        if (this.jUq != null) {
          f.J(new FaceDetectView.5(this));
        }
      }
      for (;;)
      {
        y.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.jUx = false;
        aPu();
        return;
        if (this.jUq != null)
        {
          this.jUq.aPo();
          f.jNM.jNN.jPP.aOw();
        }
      }
    }
    y.w("MicroMsg.FaceDetectView", "hy: already end");
  }
  
  public int getCameraBestHeight()
  {
    return this.jUq.getEncodeVideoBestSize().y;
  }
  
  public int getCameraBestWidth()
  {
    return this.jUq.getEncodeVideoBestSize().x;
  }
  
  public int getCameraPreivewWidth()
  {
    return this.jUq.jTW.getPreviewWidth();
  }
  
  public int getCameraPreviewHeight()
  {
    return this.jUq.jTW.getPreviewHeight();
  }
  
  public int getCameraRotation()
  {
    return this.jUq.jTW.getRotation();
  }
  
  public b.b getCurrentMotionCancelInfo()
  {
    if (this.jUv != null) {
      return this.jUv.aOM();
    }
    return new b.b(90004, "user cancelled in processing");
  }
  
  public Bitmap getPreviewBm()
  {
    return this.jUq.getBitmap();
  }
  
  public final void j(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      e.post(new FaceDetectView.2(this, paramString), "face_detect_set_backgroud");
      return;
    }
    paramString = new AlphaAnimation(1.0F, 0.0F);
    paramString.setInterpolator(new LinearInterpolator());
    paramString.setDuration(500L);
    paramString.setFillAfter(true);
    this.jUF.startAnimation(paramString);
  }
  
  public void setCallback(a parama)
  {
    this.jUu = parama;
  }
  
  public void setErrTextView(TextView paramTextView)
  {
    this.jRy = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView
 * JD-Core Version:    0.7.0.1
 */