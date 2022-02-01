package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.sdk.platformtools.Log;

public final class FaceActionUI$2
  implements Runnable
{
  public FaceActionUI$2(FaceActionUI paramFaceActionUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(262629);
    Log.i("MicroMsg.FaceActionUI", "openCameraPreviewFailedAnimation");
    FaceActionUI.f(this.AaH).setText(a.i.face_open_camera_preview_error);
    FaceActionUI.h(this.AaH).setText(a.i.face_severe_error_main_btn);
    FaceActionUI.h(this.AaH).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(262605);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$10$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.FaceActionUI", "click finish");
        FaceActionUI.2.this.AaH.f("fail", 90016, "", "");
        a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$10$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(262605);
      }
    });
    FaceActionUI.r(this.AaH).setVisibility(8);
    FaceActionUI.s(this.AaH).setVisibility(0);
    FaceActionUI.e(this.AaH).clearAnimation();
    FaceActionUI.t(this.AaH).setVisibility(0);
    FaceActionUI.u(this.AaH).setVisibility(8);
    AppMethodBeat.o(262629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2
 * JD-Core Version:    0.7.0.1
 */