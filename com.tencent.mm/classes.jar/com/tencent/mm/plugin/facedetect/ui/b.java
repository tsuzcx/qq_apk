package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import java.lang.ref.WeakReference;

public final class b
  extends a
{
  private Button pRD;
  private TextView pRF;
  private Button pRz;
  private ViewGroup pTc;
  private ImageView pTd;
  private RelativeLayout pTe;
  private RelativeLayout pTf;
  private RelativeLayout pTg;
  private ImageView pTh;
  private ImageView pTi;
  private ImageView pTj;
  private TextView pTk;
  private TextView pTl;
  private TextView pTm;
  
  b(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    super(paramFaceDetectPrepareUI);
  }
  
  public final void V(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104030);
    this.pTd.setImageBitmap(paramBitmap);
    AppMethodBeat.o(104030);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(104028);
    ad.i("MicroMsg.FaceReflectJumper", "show config: %s", new Object[] { paramc });
    this.pTc.setVisibility(0);
    if (paramc.pTy)
    {
      if (paramc.pTN != null) {
        this.pRD.setOnClickListener(paramc.pTN);
      }
      this.pRD.setVisibility(0);
      if (!bt.isNullOrNil(paramc.hJD)) {
        this.pRD.setText(paramc.hJD);
      }
      if (!paramc.pTv) {
        break label266;
      }
      if (paramc.pTK != null) {
        this.pRz.setOnClickListener(paramc.pTK);
      }
      this.pRz.setVisibility(0);
      if (!bt.isNullOrNil(paramc.pTF)) {
        this.pRz.setText(paramc.pTF);
      }
      label136:
      if (!paramc.pTB) {
        break label278;
      }
      if (paramc.pTM != null)
      {
        this.pRF.setClickable(true);
        this.pRF.setOnClickListener(paramc.pTM);
      }
      this.pRF.setVisibility(0);
      if (!bt.isNullOrNil(paramc.pTI)) {
        this.pRF.setText(paramc.pTI);
      }
      label198:
      if (paramc.pTD != null) {
        this.pTd.setImageBitmap(paramc.pTD);
      }
      switch (paramc.status)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(104028);
      return;
      this.pRD.setVisibility(8);
      break;
      label266:
      this.pRz.setVisibility(8);
      break label136;
      label278:
      this.pRF.setVisibility(8);
      break label198;
      if (!bt.isNullOrNil(paramc.pTE)) {
        this.pTk.setText(paramc.pTE);
      }
      ad.i("MicroMsg.FaceReflectJumper", "checking animation");
      this.pTe.setVisibility(0);
      this.pTf.setVisibility(8);
      this.pTg.setVisibility(8);
      this.pTh.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104025);
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, b.a(b.this).getHeight());
          localTranslateAnimation.setDuration(2000L);
          localTranslateAnimation.setRepeatMode(2);
          localTranslateAnimation.setRepeatCount(-1);
          ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 1.0F, 1.0F, 1, 0.5F, 1, 0.5F);
          localScaleAnimation.setDuration(1000L);
          localScaleAnimation.setRepeatMode(2);
          localScaleAnimation.setRepeatCount(-1);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation(localTranslateAnimation);
          localAnimationSet.addAnimation(localScaleAnimation);
          localAnimationSet.setRepeatCount(-1);
          b.b(b.this).startAnimation(localAnimationSet);
          AppMethodBeat.o(104025);
        }
      });
      AppMethodBeat.o(104028);
      return;
      if (!bt.isNullOrNil(paramc.pTE)) {
        this.pTl.setText(paramc.pTE);
      }
      ad.i("MicroMsg.FaceReflectJumper", "check success animation");
      this.pTi.clearAnimation();
      this.pTe.setVisibility(8);
      this.pTf.setVisibility(0);
      this.pTe.setVisibility(8);
      this.pTg.setVisibility(8);
      this.pTj.setScaleX(0.0F);
      this.pTj.setScaleY(0.0F);
      this.pTj.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
      AppMethodBeat.o(104028);
      return;
      if (!bt.isNullOrNil(paramc.pTE)) {
        this.pTm.setText(paramc.pTE);
      }
      ad.i("MicroMsg.FaceReflectJumper", "check failed animation");
      this.pTf.setVisibility(8);
      this.pTe.setVisibility(8);
      this.pTg.setVisibility(0);
      this.pTi.clearAnimation();
      this.pTe.setVisibility(8);
    }
  }
  
  public final boolean bcB()
  {
    AppMethodBeat.i(104032);
    if (this.pTc.getVisibility() == 0)
    {
      AppMethodBeat.o(104032);
      return true;
    }
    AppMethodBeat.o(104032);
    return false;
  }
  
  public final void cgu()
  {
    AppMethodBeat.i(104031);
    if (this.pTe != null) {
      this.pTe.setVisibility(8);
    }
    if (this.pTf != null) {
      this.pTf.setVisibility(8);
    }
    if (this.pTg != null) {
      this.pTg.setVisibility(8);
    }
    if (this.pRD != null) {
      this.pRD.setVisibility(8);
    }
    if (this.pRF != null) {
      this.pRF.setVisibility(8);
    }
    if (this.pRz != null) {
      this.pRz.setVisibility(8);
    }
    AppMethodBeat.o(104031);
  }
  
  public final void create()
  {
    try
    {
      AppMethodBeat.i(104027);
      FaceDetectPrepareUI localFaceDetectPrepareUI = (FaceDetectPrepareUI)this.pRI.get();
      if (localFaceDetectPrepareUI != null)
      {
        this.pTc = ((ViewGroup)localFaceDetectPrepareUI.findViewById(2131303923));
        this.pTd = ((ImageView)localFaceDetectPrepareUI.findViewById(2131301243));
        this.pTe = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299731));
        this.pTf = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299732));
        this.pTg = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299730));
        this.pTh = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299673));
        this.pTi = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299670));
        this.pTj = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299680));
        this.pRD = ((Button)localFaceDetectPrepareUI.findViewById(2131301245));
        if (ai.aF(localFaceDetectPrepareUI))
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.pRD.getLayoutParams();
          localLayoutParams.topMargin = ai.aE(localFaceDetectPrepareUI);
          this.pRD.setLayoutParams(localLayoutParams);
        }
        this.pRz = ((Button)localFaceDetectPrepareUI.findViewById(2131299668));
        this.pRF = ((TextView)localFaceDetectPrepareUI.findViewById(2131303922));
        this.pTk = ((TextView)localFaceDetectPrepareUI.findViewById(2131299672));
        this.pTl = ((TextView)localFaceDetectPrepareUI.findViewById(2131299681));
        this.pTm = ((TextView)localFaceDetectPrepareUI.findViewById(2131299678));
        if (this.pTc != null) {
          this.pTc.setVisibility(8);
        }
      }
      AppMethodBeat.o(104027);
      return;
    }
    finally {}
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(104029);
    ad.m("MicroMsg.FaceReflectJumper", "dismiss jumper", new Object[0]);
    if (this.pRI.get() != null) {
      ((FaceDetectPrepareUI)this.pRI.get()).runOnUiThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104026);
          if (b.c(b.this) != null) {
            b.c(b.this).setVisibility(4);
          }
          AppMethodBeat.o(104026);
        }
      });
    }
    AppMethodBeat.o(104029);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.b
 * JD-Core Version:    0.7.0.1
 */