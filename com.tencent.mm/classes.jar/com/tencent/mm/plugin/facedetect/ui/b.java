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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import java.lang.ref.WeakReference;

public final class b
  extends a
{
  private ViewGroup gJt;
  private Button rsa;
  private Button rse;
  private TextView rsg;
  private ImageView rtE;
  private RelativeLayout rtF;
  private RelativeLayout rtG;
  private RelativeLayout rtH;
  private ImageView rtI;
  private ImageView rtJ;
  private ImageView rtK;
  private TextView rtL;
  private TextView rtM;
  private TextView rtN;
  
  b(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    super(paramFaceDetectPrepareUI);
  }
  
  public final void W(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104030);
    this.rtE.setImageBitmap(paramBitmap);
    AppMethodBeat.o(104030);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(104028);
    ae.i("MicroMsg.FaceReflectJumper", "show config: %s", new Object[] { paramc });
    this.gJt.setVisibility(0);
    if (paramc.rtY)
    {
      if (paramc.run != null) {
        this.rse.setOnClickListener(paramc.run);
      }
      this.rse.setVisibility(0);
      if (!bu.isNullOrNil(paramc.iGl)) {
        this.rse.setText(paramc.iGl);
      }
      if (!paramc.rtV) {
        break label266;
      }
      if (paramc.ruk != null) {
        this.rsa.setOnClickListener(paramc.ruk);
      }
      this.rsa.setVisibility(0);
      if (!bu.isNullOrNil(paramc.ruf)) {
        this.rsa.setText(paramc.ruf);
      }
      label136:
      if (!paramc.rub) {
        break label278;
      }
      if (paramc.rum != null)
      {
        this.rsg.setClickable(true);
        this.rsg.setOnClickListener(paramc.rum);
      }
      this.rsg.setVisibility(0);
      if (!bu.isNullOrNil(paramc.rui)) {
        this.rsg.setText(paramc.rui);
      }
      label198:
      if (paramc.rud != null) {
        this.rtE.setImageBitmap(paramc.rud);
      }
      switch (paramc.status)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(104028);
      return;
      this.rse.setVisibility(8);
      break;
      label266:
      this.rsa.setVisibility(8);
      break label136;
      label278:
      this.rsg.setVisibility(8);
      break label198;
      if (!bu.isNullOrNil(paramc.rue)) {
        this.rtL.setText(paramc.rue);
      }
      ae.i("MicroMsg.FaceReflectJumper", "checking animation");
      this.rtF.setVisibility(0);
      this.rtG.setVisibility(8);
      this.rtH.setVisibility(8);
      this.rtI.post(new Runnable()
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
      if (!bu.isNullOrNil(paramc.rue)) {
        this.rtM.setText(paramc.rue);
      }
      ae.i("MicroMsg.FaceReflectJumper", "check success animation");
      this.rtJ.clearAnimation();
      this.rtF.setVisibility(8);
      this.rtG.setVisibility(0);
      this.rtF.setVisibility(8);
      this.rtH.setVisibility(8);
      this.rtK.setScaleX(0.0F);
      this.rtK.setScaleY(0.0F);
      this.rtK.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
      AppMethodBeat.o(104028);
      return;
      if (!bu.isNullOrNil(paramc.rue)) {
        this.rtN.setText(paramc.rue);
      }
      ae.i("MicroMsg.FaceReflectJumper", "check failed animation");
      this.rtG.setVisibility(8);
      this.rtF.setVisibility(8);
      this.rtH.setVisibility(0);
      this.rtJ.clearAnimation();
      this.rtF.setVisibility(8);
    }
  }
  
  public final boolean bnS()
  {
    AppMethodBeat.i(104032);
    if (this.gJt.getVisibility() == 0)
    {
      AppMethodBeat.o(104032);
      return true;
    }
    AppMethodBeat.o(104032);
    return false;
  }
  
  public final void create()
  {
    try
    {
      AppMethodBeat.i(104027);
      FaceDetectPrepareUI localFaceDetectPrepareUI = (FaceDetectPrepareUI)this.rsj.get();
      if (localFaceDetectPrepareUI != null)
      {
        this.gJt = ((ViewGroup)localFaceDetectPrepareUI.findViewById(2131303923));
        this.rtE = ((ImageView)localFaceDetectPrepareUI.findViewById(2131301243));
        this.rtF = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299731));
        this.rtG = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299732));
        this.rtH = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299730));
        this.rtI = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299673));
        this.rtJ = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299670));
        this.rtK = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299680));
        this.rse = ((Button)localFaceDetectPrepareUI.findViewById(2131301245));
        if (al.aH(localFaceDetectPrepareUI))
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rse.getLayoutParams();
          localLayoutParams.topMargin = al.aG(localFaceDetectPrepareUI);
          this.rse.setLayoutParams(localLayoutParams);
        }
        this.rsa = ((Button)localFaceDetectPrepareUI.findViewById(2131299668));
        this.rsg = ((TextView)localFaceDetectPrepareUI.findViewById(2131303922));
        this.rtL = ((TextView)localFaceDetectPrepareUI.findViewById(2131299672));
        this.rtM = ((TextView)localFaceDetectPrepareUI.findViewById(2131299681));
        this.rtN = ((TextView)localFaceDetectPrepareUI.findViewById(2131299678));
        if (this.gJt != null) {
          this.gJt.setVisibility(8);
        }
      }
      AppMethodBeat.o(104027);
      return;
    }
    finally {}
  }
  
  public final void cvh()
  {
    AppMethodBeat.i(104031);
    if (this.rtF != null) {
      this.rtF.setVisibility(8);
    }
    if (this.rtG != null) {
      this.rtG.setVisibility(8);
    }
    if (this.rtH != null) {
      this.rtH.setVisibility(8);
    }
    if (this.rse != null) {
      this.rse.setVisibility(8);
    }
    if (this.rsg != null) {
      this.rsg.setVisibility(8);
    }
    if (this.rsa != null) {
      this.rsa.setVisibility(8);
    }
    AppMethodBeat.o(104031);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(104029);
    ae.m("MicroMsg.FaceReflectJumper", "dismiss jumper", new Object[0]);
    if (this.rsj.get() != null) {
      ((FaceDetectPrepareUI)this.rsj.get()).runOnUiThread(new Runnable()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.b
 * JD-Core Version:    0.7.0.1
 */