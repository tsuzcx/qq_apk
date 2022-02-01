package com.tencent.mm.plugin.flash;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flash.c.b;

final class FaceFlashUI$1
  implements DialogInterface.OnClickListener
{
  FaceFlashUI$1(Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(198154);
    b.s("msgVerify", "camera or mic 正在被占用");
    b.epM().gmH = 1;
    b.Ss(90033);
    this.fgc.setResult(1, FaceFlashUI.aHb("finish by voip call"));
    this.fgc.finish();
    AppMethodBeat.o(198154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.FaceFlashUI.1
 * JD-Core Version:    0.7.0.1
 */