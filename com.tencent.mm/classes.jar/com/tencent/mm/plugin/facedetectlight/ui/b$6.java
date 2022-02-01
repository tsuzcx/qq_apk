package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class b$6
  implements Runnable
{
  b$6(b paramb, double paramDouble) {}
  
  public final void run()
  {
    AppMethodBeat.i(104287);
    ac.d("MicroMsg.FaceReflectCam", "reset ratio");
    int i = this.qGZ.qGQ.getContext().getResources().getDisplayMetrics().widthPixels;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.qGZ.qGQ.getLayoutParams();
    localLayoutParams.width = ((int)(i * 0.7D));
    localLayoutParams.height = ((int)(localLayoutParams.width * this.qHd));
    localLayoutParams.addRule(13, -1);
    this.qGZ.qGQ.setLayoutParams(localLayoutParams);
    this.qGZ.qGQ.setAspectRatio(this.qHd);
    ac.d("MicroMsg.FaceReflectCam", "after reset ratio=" + this.qGZ.qGQ.getmAspectRatio());
    AppMethodBeat.o(104287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.6
 * JD-Core Version:    0.7.0.1
 */