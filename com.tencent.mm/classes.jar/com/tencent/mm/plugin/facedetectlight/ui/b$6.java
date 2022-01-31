package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$6
  implements Runnable
{
  b$6(b paramb, double paramDouble) {}
  
  public final void run()
  {
    AppMethodBeat.i(765);
    ab.d("MicroMsg.FaceReflectCam", "reset ratio");
    int i = this.mrQ.mrH.getContext().getResources().getDisplayMetrics().widthPixels;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mrQ.mrH.getLayoutParams();
    localLayoutParams.width = ((int)(i * 0.7D));
    localLayoutParams.height = ((int)(localLayoutParams.width * this.mrT));
    localLayoutParams.addRule(13, -1);
    this.mrQ.mrH.setLayoutParams(localLayoutParams);
    this.mrQ.mrH.setAspectRatio(this.mrT);
    ab.d("MicroMsg.FaceReflectCam", "after reset ratio=" + this.mrQ.mrH.getmAspectRatio());
    AppMethodBeat.o(765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.6
 * JD-Core Version:    0.7.0.1
 */