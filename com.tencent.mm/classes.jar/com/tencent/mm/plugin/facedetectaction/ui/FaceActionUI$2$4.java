package com.tencent.mm.plugin.facedetectaction.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FaceActionUI$2$4
  implements Runnable
{
  FaceActionUI$2$4(FaceActionUI.2 param2, String paramString, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if (!bk.bl(this.jWZ))
    {
      FaceActionUI.g(this.jWX.jWU).setText(this.jWZ);
      FaceActionUI.h(this.jWX.jWU);
      if (this.jXa != 1) {
        break label202;
      }
      FaceActionUI.i(this.jWX.jWU).setText(a.i.face_try);
      FaceActionUI.i(this.jWX.jWU).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          y.i("MicroMsg.FaceActionUI", "click retry");
          FaceActionUI.j(FaceActionUI.2.4.this.jWX.jWU);
        }
      });
    }
    for (;;)
    {
      FaceActionUI.f(this.jWX.jWU).clearAnimation();
      FaceActionUI localFaceActionUI = this.jWX.jWU;
      localFaceActionUI.jWD.setVisibility(8);
      localFaceActionUI.jRZ.setVisibility(0);
      localFaceActionUI.jSb.clearAnimation();
      localFaceActionUI.jWH.setVisibility(0);
      localFaceActionUI.jRX.setVisibility(8);
      d.jWf.mStatus = 3;
      if (bk.bl(d.jWf.bXB)) {
        this.jWX.jWU.u("fail", this.jXb, "");
      }
      return;
      FaceActionUI.g(this.jWX.jWU).setText(a.i.face_action_upload_failed_tips);
      break;
      label202:
      FaceActionUI.i(this.jWX.jWU).setText(a.i.face_severe_error_main_btn);
      FaceActionUI.i(this.jWX.jWU).setOnClickListener(new FaceActionUI.2.4.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.2.4
 * JD-Core Version:    0.7.0.1
 */