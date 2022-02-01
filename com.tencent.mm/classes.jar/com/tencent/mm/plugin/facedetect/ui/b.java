package com.tencent.mm.plugin.facedetect.ui;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import java.lang.ref.WeakReference;

public final class b
  extends a
{
  private ViewGroup gGK;
  private Button rjW;
  private Button rka;
  private TextView rkc;
  private RelativeLayout rlA;
  private RelativeLayout rlB;
  private RelativeLayout rlC;
  private ImageView rlD;
  private ImageView rlE;
  private ImageView rlF;
  private TextView rlG;
  private TextView rlH;
  private TextView rlI;
  private ImageView rlz;
  
  b(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    super(paramFaceDetectPrepareUI);
  }
  
  public final void V(Bitmap paramBitmap)
  {
    AppMethodBeat.i(104030);
    this.rlz.setImageBitmap(paramBitmap);
    AppMethodBeat.o(104030);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(104028);
    ad.i("MicroMsg.FaceReflectJumper", "show config: %s", new Object[] { paramc });
    this.gGK.setVisibility(0);
    if (paramc.rlT)
    {
      if (paramc.rmi != null) {
        this.rka.setOnClickListener(paramc.rmi);
      }
      this.rka.setVisibility(0);
      if (!bt.isNullOrNil(paramc.iDs)) {
        this.rka.setText(paramc.iDs);
      }
      if (!paramc.rlQ) {
        break label266;
      }
      if (paramc.rmf != null) {
        this.rjW.setOnClickListener(paramc.rmf);
      }
      this.rjW.setVisibility(0);
      if (!bt.isNullOrNil(paramc.rma)) {
        this.rjW.setText(paramc.rma);
      }
      label136:
      if (!paramc.rlW) {
        break label278;
      }
      if (paramc.rmh != null)
      {
        this.rkc.setClickable(true);
        this.rkc.setOnClickListener(paramc.rmh);
      }
      this.rkc.setVisibility(0);
      if (!bt.isNullOrNil(paramc.rmd)) {
        this.rkc.setText(paramc.rmd);
      }
      label198:
      if (paramc.rlY != null) {
        this.rlz.setImageBitmap(paramc.rlY);
      }
      switch (paramc.status)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(104028);
      return;
      this.rka.setVisibility(8);
      break;
      label266:
      this.rjW.setVisibility(8);
      break label136;
      label278:
      this.rkc.setVisibility(8);
      break label198;
      if (!bt.isNullOrNil(paramc.rlZ)) {
        this.rlG.setText(paramc.rlZ);
      }
      ad.i("MicroMsg.FaceReflectJumper", "checking animation");
      this.rlA.setVisibility(0);
      this.rlB.setVisibility(8);
      this.rlC.setVisibility(8);
      this.rlD.post(new b.1(this));
      AppMethodBeat.o(104028);
      return;
      if (!bt.isNullOrNil(paramc.rlZ)) {
        this.rlH.setText(paramc.rlZ);
      }
      ad.i("MicroMsg.FaceReflectJumper", "check success animation");
      this.rlE.clearAnimation();
      this.rlA.setVisibility(8);
      this.rlB.setVisibility(0);
      this.rlA.setVisibility(8);
      this.rlC.setVisibility(8);
      this.rlF.setScaleX(0.0F);
      this.rlF.setScaleY(0.0F);
      this.rlF.animate().scaleX(1.0F).scaleY(1.0F).setDuration(800L);
      AppMethodBeat.o(104028);
      return;
      if (!bt.isNullOrNil(paramc.rlZ)) {
        this.rlI.setText(paramc.rlZ);
      }
      ad.i("MicroMsg.FaceReflectJumper", "check failed animation");
      this.rlB.setVisibility(8);
      this.rlA.setVisibility(8);
      this.rlC.setVisibility(0);
      this.rlE.clearAnimation();
      this.rlA.setVisibility(8);
    }
  }
  
  public final boolean bni()
  {
    AppMethodBeat.i(104032);
    if (this.gGK.getVisibility() == 0)
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
      FaceDetectPrepareUI localFaceDetectPrepareUI = (FaceDetectPrepareUI)this.rkf.get();
      if (localFaceDetectPrepareUI != null)
      {
        this.gGK = ((ViewGroup)localFaceDetectPrepareUI.findViewById(2131303923));
        this.rlz = ((ImageView)localFaceDetectPrepareUI.findViewById(2131301243));
        this.rlA = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299731));
        this.rlB = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299732));
        this.rlC = ((RelativeLayout)localFaceDetectPrepareUI.findViewById(2131299730));
        this.rlD = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299673));
        this.rlE = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299670));
        this.rlF = ((ImageView)localFaceDetectPrepareUI.findViewById(2131299680));
        this.rka = ((Button)localFaceDetectPrepareUI.findViewById(2131301245));
        if (al.aG(localFaceDetectPrepareUI))
        {
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.rka.getLayoutParams();
          localLayoutParams.topMargin = al.aF(localFaceDetectPrepareUI);
          this.rka.setLayoutParams(localLayoutParams);
        }
        this.rjW = ((Button)localFaceDetectPrepareUI.findViewById(2131299668));
        this.rkc = ((TextView)localFaceDetectPrepareUI.findViewById(2131303922));
        this.rlG = ((TextView)localFaceDetectPrepareUI.findViewById(2131299672));
        this.rlH = ((TextView)localFaceDetectPrepareUI.findViewById(2131299681));
        this.rlI = ((TextView)localFaceDetectPrepareUI.findViewById(2131299678));
        if (this.gGK != null) {
          this.gGK.setVisibility(8);
        }
      }
      AppMethodBeat.o(104027);
      return;
    }
    finally {}
  }
  
  public final void ctG()
  {
    AppMethodBeat.i(104031);
    if (this.rlA != null) {
      this.rlA.setVisibility(8);
    }
    if (this.rlB != null) {
      this.rlB.setVisibility(8);
    }
    if (this.rlC != null) {
      this.rlC.setVisibility(8);
    }
    if (this.rka != null) {
      this.rka.setVisibility(8);
    }
    if (this.rkc != null) {
      this.rkc.setVisibility(8);
    }
    if (this.rjW != null) {
      this.rjW.setVisibility(8);
    }
    AppMethodBeat.o(104031);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(104029);
    ad.m("MicroMsg.FaceReflectJumper", "dismiss jumper", new Object[0]);
    if (this.rkf.get() != null) {
      ((FaceDetectPrepareUI)this.rkf.get()).runOnUiThread(new Runnable()
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