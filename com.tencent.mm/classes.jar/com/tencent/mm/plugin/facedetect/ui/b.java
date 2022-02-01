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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import java.lang.ref.WeakReference;

public final class b
  extends a
{
  private ViewGroup gnb;
  private Button qAh;
  private Button qAl;
  private TextView qAn;
  private ImageView qBJ;
  private RelativeLayout qBK;
  private RelativeLayout qBL;
  private RelativeLayout qBM;
  private ImageView qBN;
  private ImageView qBO;
  private ImageView qBP;
  private TextView qBQ;
  private TextView qBR;
  private TextView qBS;
  
  b(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    super(paramFaceDetectPrepareUI);
  }
  
  public final void V(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104030);
    this.qBJ.setImageBitmap(paramBitmap);
    AppMethodBeat.o(104030);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(104028);
    ac.i("MicroMsg.FaceReflectJumper", "show config: %s", new Object[] { paramc });
    this.gnb.setVisibility(0);
    if (paramc.qCd)
    {
      if (paramc.qCs != null) {
        this.qAl.setOnClickListener(paramc.qCs);
      }
      this.qAl.setVisibility(0);
      if (!bs.isNullOrNil(paramc.ikb)) {
        this.qAl.setText(paramc.ikb);
      }
      if (!paramc.qCa) {
        break label266;
      }
      if (paramc.qCp != null) {
        this.qAh.setOnClickListener(paramc.qCp);
      }
      this.qAh.setVisibility(0);
      if (!bs.isNullOrNil(paramc.qCk)) {
        this.qAh.setText(paramc.qCk);
      }
      label136:
      if (!paramc.qCg) {
        break label278;
      }
      if (paramc.qCr != null)
      {
        this.qAn.setClickable(true);
        this.qAn.setOnClickListener(paramc.qCr);
      }
      this.qAn.setVisibility(0);
      if (!bs.isNullOrNil(paramc.qCn)) {
        this.qAn.setText(paramc.qCn);
      }
      label198:
      if (paramc.qCi != null) {
        this.qBJ.setImageBitmap(paramc.qCi);
      }
      switch (paramc.status)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(104028);
      return;
      this.qAl.setVisibility(8);
      break;
      label266:
      this.qAh.setVisibility(8);
      break label136;
      label278:
      this.qAn.setVisibility(8);
      break label198;
      if (!bs.isNullOrNil(paramc.qCj)) {
        this.qBQ.setText(paramc.qCj);
      }
      ac.i("MicroMsg.FaceReflectJumper", "checking animation");
      this.qBK.setVisibility(0);
      this.qBL.setVisibility(8);
      this.qBM.setVisibility(8);
      this.qBN.post(new Runnable()
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
      if (!bs.isNullOrNil(paramc.qCj)) {
        this.qBR.setText(paramc.qCj);
      }
      ac.i("MicroMsg.FaceReflectJumper", "check success animation");
      this.qBO.clearAnimation();
      this.qBK.setVisibility(8);
      this.qBL.setVisibility(0);
      this.qBK.setVisibility(8);
      this.qBM.setVisibility(8);
      this.qBP.setScaleX(0.0F);
      this.qBP.setScaleY(0.0F);
      this.qBP.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
      AppMethodBeat.o(104028);
      return;
      if (!bs.isNullOrNil(paramc.qCj)) {
        this.qBS.setText(paramc.qCj);
      }
      ac.i("MicroMsg.FaceReflectJumper", "check failed animation");
      this.qBL.setVisibility(8);
      this.qBK.setVisibility(8);
      this.qBM.setVisibility(0);
      this.qBO.clearAnimation();
      this.qBK.setVisibility(8);
    }
  }
  
  public final boolean bjw()
  {
    AppMethodBeat.i(104032);
    if (this.gnb.getVisibility() == 0)
    {
      AppMethodBeat.o(104032);
      return true;
    }
    AppMethodBeat.o(104032);
    return false;
  }
  
  public final void cob()
  {
    AppMethodBeat.i(104031);
    if (this.qBK != null) {
      this.qBK.setVisibility(8);
    }
    if (this.qBL != null) {
      this.qBL.setVisibility(8);
    }
    if (this.qBM != null) {
      this.qBM.setVisibility(8);
    }
    if (this.qAl != null) {
      this.qAl.setVisibility(8);
    }
    if (this.qAn != null) {
      this.qAn.setVisibility(8);
    }
    if (this.qAh != null) {
      this.qAh.setVisibility(8);
    }
    AppMethodBeat.o(104031);
  }
  
  public final void create()
  {
    try
    {
      AppMethodBeat.i(104027);
      FaceDetectPrepareUI localFaceDetectPrepareUI = (FaceDetectPrepareUI)this.qAq.get();
      if (localFaceDetectPrepareUI != null)
      {
        this.gnb = ((ViewGroup)localFaceDetectPrepareUI.findViewById(2131303923));
        this.qBJ = ((ImageView)localFaceDetectPrepareUI.findViewById(2131301243));
        this.qBK = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299731));
        this.qBL = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299732));
        this.qBM = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299730));
        this.qBN = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299673));
        this.qBO = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299670));
        this.qBP = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299680));
        this.qAl = ((Button)localFaceDetectPrepareUI.findViewById(2131301245));
        if (aj.aG(localFaceDetectPrepareUI))
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.qAl.getLayoutParams();
          localLayoutParams.topMargin = aj.aF(localFaceDetectPrepareUI);
          this.qAl.setLayoutParams(localLayoutParams);
        }
        this.qAh = ((Button)localFaceDetectPrepareUI.findViewById(2131299668));
        this.qAn = ((TextView)localFaceDetectPrepareUI.findViewById(2131303922));
        this.qBQ = ((TextView)localFaceDetectPrepareUI.findViewById(2131299672));
        this.qBR = ((TextView)localFaceDetectPrepareUI.findViewById(2131299681));
        this.qBS = ((TextView)localFaceDetectPrepareUI.findViewById(2131299678));
        if (this.gnb != null) {
          this.gnb.setVisibility(8);
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
    ac.m("MicroMsg.FaceReflectJumper", "dismiss jumper", new Object[0]);
    if (this.qAq.get() != null) {
      ((FaceDetectPrepareUI)this.qAq.get()).runOnUiThread(new Runnable()
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