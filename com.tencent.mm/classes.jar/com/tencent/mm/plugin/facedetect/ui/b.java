package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public final class b
  extends a
{
  private Button mkO;
  private Button mkS;
  private TextView mkU;
  private TextView mmA;
  private TextView mmB;
  private ViewGroup mmr;
  private ImageView mms;
  private RelativeLayout mmt;
  private RelativeLayout mmu;
  private RelativeLayout mmv;
  private ImageView mmw;
  private ImageView mmx;
  private ImageView mmy;
  private TextView mmz;
  
  b(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    super(paramFaceDetectPrepareUI);
  }
  
  public final void K(Bitmap paramBitmap)
  {
    AppMethodBeat.i(511);
    this.mms.setImageBitmap(paramBitmap);
    AppMethodBeat.o(511);
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(513);
    if (this.mmr.getVisibility() == 0)
    {
      AppMethodBeat.o(513);
      return true;
    }
    AppMethodBeat.o(513);
    return false;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(509);
    ab.i("MicroMsg.FaceReflectJumper", "show config: %s", new Object[] { paramc });
    this.mmr.setVisibility(0);
    if (paramc.mmM)
    {
      if (paramc.mnc != null) {
        this.mkS.setOnClickListener(paramc.mnc);
      }
      this.mkS.setVisibility(0);
      if (!bo.isNullOrNil(paramc.mmV)) {
        this.mkS.setText(paramc.mmV);
      }
      if (!paramc.mmJ) {
        break label267;
      }
      if (paramc.mmZ != null) {
        this.mkO.setOnClickListener(paramc.mmZ);
      }
      this.mkO.setVisibility(0);
      if (!bo.isNullOrNil(paramc.mmT)) {
        this.mkO.setText(paramc.mmT);
      }
      label137:
      if (!paramc.mmP) {
        break label279;
      }
      if (paramc.mnb != null)
      {
        this.mkU.setClickable(true);
        this.mkU.setOnClickListener(paramc.mnb);
      }
      this.mkU.setVisibility(0);
      if (!bo.isNullOrNil(paramc.mmX)) {
        this.mkU.setText(paramc.mmX);
      }
      label199:
      if (paramc.mmR != null) {
        this.mms.setImageBitmap(paramc.mmR);
      }
      switch (paramc.status)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(509);
      return;
      this.mkS.setVisibility(8);
      break;
      label267:
      this.mkO.setVisibility(8);
      break label137;
      label279:
      this.mkU.setVisibility(8);
      break label199;
      if (!bo.isNullOrNil(paramc.mmS)) {
        this.mmz.setText(paramc.mmS);
      }
      ab.i("MicroMsg.FaceReflectJumper", "checking animation");
      this.mmt.setVisibility(0);
      this.mmu.setVisibility(8);
      this.mmv.setVisibility(8);
      this.mmw.post(new b.1(this));
      AppMethodBeat.o(509);
      return;
      if (!bo.isNullOrNil(paramc.mmS)) {
        this.mmA.setText(paramc.mmS);
      }
      ab.i("MicroMsg.FaceReflectJumper", "check success animation");
      this.mmx.clearAnimation();
      this.mmt.setVisibility(8);
      this.mmu.setVisibility(0);
      this.mmt.setVisibility(8);
      this.mmv.setVisibility(8);
      this.mmy.setScaleX(0.0F);
      this.mmy.setScaleY(0.0F);
      this.mmy.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
      AppMethodBeat.o(509);
      return;
      if (!bo.isNullOrNil(paramc.mmS)) {
        this.mmB.setText(paramc.mmS);
      }
      ab.i("MicroMsg.FaceReflectJumper", "check failed animation");
      this.mmu.setVisibility(8);
      this.mmt.setVisibility(8);
      this.mmv.setVisibility(0);
      this.mmx.clearAnimation();
      this.mmt.setVisibility(8);
    }
  }
  
  public final void create()
  {
    AppMethodBeat.i(508);
    synchronized ((FaceDetectPrepareUI)this.mkX.get())
    {
      if (this.mkX.get() != null)
      {
        this.mmr = ((ViewGroup)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823927));
        this.mms = ((ImageView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823928));
        this.mmt = ((RelativeLayout)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823867));
        this.mmu = ((RelativeLayout)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823863));
        this.mmv = ((RelativeLayout)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823858));
        this.mmw = ((ImageView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823869));
        this.mmx = ((ImageView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823868));
        this.mmy = ((ImageView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823865));
        this.mkS = ((Button)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823931));
        this.mkO = ((Button)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823929));
        this.mkU = ((TextView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823930));
        this.mmz = ((TextView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823870));
        this.mmA = ((TextView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823866));
        this.mmB = ((TextView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823860));
        this.mmr.setVisibility(8);
      }
      AppMethodBeat.o(508);
      return;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(510);
    ab.b("MicroMsg.FaceReflectJumper", "dismiss jumper", new Object[0]);
    if (this.mkX.get() != null) {
      ((FaceDetectPrepareUI)this.mkX.get()).runOnUiThread(new b.2(this));
    }
    AppMethodBeat.o(510);
  }
  
  public final void resetAll()
  {
    AppMethodBeat.i(512);
    this.mmt.setVisibility(8);
    this.mmu.setVisibility(8);
    this.mmv.setVisibility(8);
    this.mkS.setVisibility(8);
    this.mkU.setVisibility(8);
    this.mkO.setVisibility(8);
    AppMethodBeat.o(512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.b
 * JD-Core Version:    0.7.0.1
 */