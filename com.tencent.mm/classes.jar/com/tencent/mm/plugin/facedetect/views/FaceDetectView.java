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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.c.a.c;

public class FaceDetectView
  extends RelativeLayout
{
  public static long moZ = 100L;
  public static int mpa = 1;
  public volatile boolean eRq;
  public boolean isPaused;
  public long mij;
  private TextView mlU;
  public String mlq;
  public FaceDetectCameraView moJ;
  public FaceDetectDecorView moK;
  public ViewGroup moL;
  public ViewGroup moM;
  private a moN;
  public b moO;
  public boolean moP;
  public boolean moQ;
  public String moR;
  public boolean moS;
  public boolean moT;
  public long moU;
  private long moV;
  private final int moW;
  private Animation moX;
  private View moY;
  
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
    AppMethodBeat.i(625);
    this.moJ = null;
    this.moK = null;
    this.mlU = null;
    this.moL = null;
    this.moM = null;
    this.moN = null;
    this.moP = false;
    this.eRq = false;
    this.isPaused = false;
    this.moQ = false;
    this.moR = ah.getContext().getString(2131304061);
    this.moS = true;
    this.moT = false;
    this.mij = -1L;
    this.moU = -1L;
    this.moV = -1L;
    this.moW = 1500;
    this.moY = null;
    paramContext = LayoutInflater.from(paramContext).inflate(2130970906, null, false);
    addView(paramContext);
    this.moJ = ((FaceDetectCameraView)paramContext.findViewById(2131828210));
    this.moK = ((FaceDetectDecorView)paramContext.findViewById(2131828212));
    this.moY = paramContext.findViewById(2131828211);
    this.moJ.mnZ = new FaceDetectView.1(this);
    paramContext = getContext();
    if (paramContext == null)
    {
      ab.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
      paramContext = null;
    }
    for (;;)
    {
      this.moX = paramContext;
      AppMethodBeat.o(625);
      return;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2131034132);
      paramContext.setInterpolator(new c());
    }
  }
  
  private void Nt(String paramString)
  {
    AppMethodBeat.i(628);
    if (bo.nullAsNil(paramString).equals(this.mlU.getText().toString()))
    {
      ab.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
      AppMethodBeat.o(628);
      return;
    }
    this.mlU.setText(paramString);
    this.mlU.setVisibility(0);
    this.mlU.setAnimation(this.moX);
    AppMethodBeat.o(628);
  }
  
  private void bvz()
  {
    AppMethodBeat.i(627);
    this.mlU.setText("");
    this.mlU.setVisibility(4);
    AppMethodBeat.o(627);
  }
  
  public int getCameraBestHeight()
  {
    AppMethodBeat.i(633);
    int i = this.moJ.getEncodeVideoBestSize().y;
    AppMethodBeat.o(633);
    return i;
  }
  
  public int getCameraBestWidth()
  {
    AppMethodBeat.i(632);
    int i = this.moJ.getEncodeVideoBestSize().x;
    AppMethodBeat.o(632);
    return i;
  }
  
  public int getCameraPreivewWidth()
  {
    AppMethodBeat.i(630);
    int i = this.moJ.mop.getPreviewWidth();
    AppMethodBeat.o(630);
    return i;
  }
  
  public int getCameraPreviewHeight()
  {
    AppMethodBeat.i(631);
    int i = this.moJ.mop.getPreviewHeight();
    AppMethodBeat.o(631);
    return i;
  }
  
  public int getCameraRotation()
  {
    AppMethodBeat.i(629);
    int i = this.moJ.mop.getRotation();
    AppMethodBeat.o(629);
    return i;
  }
  
  public b.b getCurrentMotionCancelInfo()
  {
    AppMethodBeat.i(634);
    if (this.moO != null)
    {
      localb = this.moO.buQ();
      AppMethodBeat.o(634);
      return localb;
    }
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(634);
    return localb;
  }
  
  public Bitmap getPreviewBm()
  {
    AppMethodBeat.i(636);
    Bitmap localBitmap = this.moJ.getBitmap();
    AppMethodBeat.o(636);
    return localBitmap;
  }
  
  public final void ht(boolean paramBoolean)
  {
    AppMethodBeat.i(635);
    if (this.moO != null) {
      this.moO.buP();
    }
    if (!this.eRq)
    {
      this.eRq = true;
      if (paramBoolean) {
        if (this.moJ != null) {
          f.S(new FaceDetectView.5(this));
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.moQ = false;
        bvz();
        AppMethodBeat.o(635);
        return;
        if (this.moJ != null) {
          this.moJ.bvt();
        }
      }
    }
    ab.w("MicroMsg.FaceDetectView", "hy: already end");
    AppMethodBeat.o(635);
  }
  
  public final void o(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(626);
    if (paramBoolean)
    {
      d.post(new FaceDetectView.2(this, paramString), "face_detect_set_backgroud");
      AppMethodBeat.o(626);
      return;
    }
    paramString = new AlphaAnimation(1.0F, 0.0F);
    paramString.setInterpolator(new LinearInterpolator());
    paramString.setDuration(500L);
    paramString.setFillAfter(true);
    this.moY.startAnimation(paramString);
    AppMethodBeat.o(626);
  }
  
  public void setBusinessTip(String paramString)
  {
    this.mlq = paramString;
  }
  
  public void setCallback(a parama)
  {
    this.moN = parama;
  }
  
  public void setErrTextView(TextView paramTextView)
  {
    this.mlU = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView
 * JD-Core Version:    0.7.0.1
 */