package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class b
  extends a
{
  private Button jQt;
  private Button jQx;
  private TextView jQz;
  private ViewGroup jRV;
  private ImageView jRW;
  private RelativeLayout jRX;
  private RelativeLayout jRY;
  private RelativeLayout jRZ;
  private ImageView jSa;
  private ImageView jSb;
  private ImageView jSc;
  private TextView jSd;
  private TextView jSe;
  private TextView jSf;
  
  b(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    super(paramFaceDetectPrepareUI);
  }
  
  public final void a(d paramd)
  {
    y.i("MicroMsg.FaceReflectJumper", "show config: %s", new Object[] { paramd });
    this.jRV.setVisibility(0);
    if (paramd.jSq)
    {
      if (paramd.jSG != null) {
        this.jQx.setOnClickListener(paramd.jSG);
      }
      this.jQx.setVisibility(0);
      if (!bk.bl(paramd.jSz)) {
        this.jQx.setText(paramd.jSz);
      }
      label77:
      if (!paramd.jSn) {
        break label253;
      }
      if (paramd.jSD != null) {
        this.jQt.setOnClickListener(paramd.jSD);
      }
      this.jQt.setVisibility(0);
      if (!bk.bl(paramd.jSx)) {
        this.jQt.setText(paramd.jSx);
      }
      label131:
      if (!paramd.jSt) {
        break label265;
      }
      if (paramd.jSF != null)
      {
        this.jQz.setClickable(true);
        this.jQz.setOnClickListener(paramd.jSF);
      }
      this.jQz.setVisibility(0);
      if (!bk.bl(paramd.jSB)) {
        this.jQz.setText(paramd.jSB);
      }
    }
    for (;;)
    {
      if (paramd.jSv != null) {
        this.jRW.setImageBitmap(paramd.jSv);
      }
      switch (paramd.status)
      {
      default: 
        return;
        this.jQx.setVisibility(8);
        break label77;
        label253:
        this.jQt.setVisibility(8);
        break label131;
        label265:
        this.jQz.setVisibility(8);
      }
    }
    if (!bk.bl(paramd.jSw)) {
      this.jSd.setText(paramd.jSw);
    }
    y.i("MicroMsg.FaceReflectJumper", "checking animation");
    this.jRX.setVisibility(0);
    this.jRY.setVisibility(8);
    this.jRZ.setVisibility(8);
    this.jSa.post(new b.1(this));
    return;
    if (!bk.bl(paramd.jSw)) {
      this.jSe.setText(paramd.jSw);
    }
    y.i("MicroMsg.FaceReflectJumper", "check success animation");
    this.jSb.clearAnimation();
    this.jRX.setVisibility(8);
    this.jRY.setVisibility(0);
    this.jRX.setVisibility(8);
    this.jRZ.setVisibility(8);
    this.jSc.setScaleX(0.0F);
    this.jSc.setScaleY(0.0F);
    this.jSc.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
    return;
    if (!bk.bl(paramd.jSw)) {
      this.jSf.setText(paramd.jSw);
    }
    y.i("MicroMsg.FaceReflectJumper", "check failed animation");
    this.jRY.setVisibility(8);
    this.jRX.setVisibility(8);
    this.jRZ.setVisibility(0);
    this.jSb.clearAnimation();
    this.jRX.setVisibility(8);
  }
  
  public final void aOW()
  {
    this.jRX.setVisibility(8);
    this.jRY.setVisibility(8);
    this.jRZ.setVisibility(8);
    this.jQx.setVisibility(8);
    this.jQz.setVisibility(8);
    this.jQt.setVisibility(8);
  }
  
  public final boolean akH()
  {
    return this.jRV.getVisibility() == 0;
  }
  
  public final void create()
  {
    synchronized ((FaceDetectPrepareUI)this.jQC.get())
    {
      if (this.jQC.get() != null)
      {
        this.jRV = ((ViewGroup)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.reflect_jumper_root));
        this.jRW = ((ImageView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.jumper_background));
        this.jRX = ((RelativeLayout)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.face_upload_layout));
        this.jRY = ((RelativeLayout)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.face_upload_success_layout));
        this.jRZ = ((RelativeLayout)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.face_upload_failed_layout));
        this.jSa = ((ImageView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.face_detect_upload));
        this.jSb = ((ImageView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.face_detect_scan));
        this.jSc = ((ImageView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.face_detect_upload_success_right));
        this.jQx = ((Button)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.jumper_reflect_left_btn));
        this.jQt = ((Button)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.face_detect_reflect_upload_main_btn));
        this.jQz = ((TextView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.reflect_feedback_tv));
        this.jSd = ((TextView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.face_detect_up_load_tips));
        this.jSe = ((TextView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.face_detect_upload_sucess_tips));
        this.jSf = ((TextView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.face_detect_upload_failed_tips));
        this.jRV.setVisibility(8);
      }
      return;
    }
  }
  
  public final void dismiss()
  {
    y.l("MicroMsg.FaceReflectJumper", "dismiss jumper", new Object[0]);
    this.jRV.setVisibility(4);
  }
  
  public final void z(Bitmap paramBitmap)
  {
    this.jRW.setImageBitmap(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.b
 * JD-Core Version:    0.7.0.1
 */