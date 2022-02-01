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
import com.tencent.mm.sdk.platformtools.Log;

public final class FaceActionUI$2
  implements Runnable
{
  public FaceActionUI$2(FaceActionUI paramFaceActionUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(186393);
    Log.i("MicroMsg.FaceActionUI", "openCameraPreviewFailedAnimation");
    FaceActionUI.f(this.sYw).setText(2131759067);
    FaceActionUI.h(this.sYw).setText(2131759081);
    FaceActionUI.h(this.sYw).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(186392);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$10$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.FaceActionUI", "click finish");
        FaceActionUI.2.this.sYw.g("fail", 90016, "", "");
        a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceActionUI$10$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(186392);
      }
    });
    FaceActionUI.r(this.sYw).setVisibility(8);
    FaceActionUI.s(this.sYw).setVisibility(0);
    FaceActionUI.e(this.sYw).clearAnimation();
    FaceActionUI.t(this.sYw).setVisibility(0);
    FaceActionUI.u(this.sYw).setVisibility(8);
    AppMethodBeat.o(186393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2
 * JD-Core Version:    0.7.0.1
 */