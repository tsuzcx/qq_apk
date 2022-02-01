package com.tencent.mm.plugin.flash.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.flash.c.b;

final class FaceFlashActionUI$1
  implements DialogInterface.OnClickListener
{
  FaceFlashActionUI$1(Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(198531);
    b.s("msgVerify", "camera or mic 正在被占用");
    b.epN().gmH = 1;
    b.St(90033);
    this.fgc.setResult(1, FaceFlashActionUI.aHb("finish by voip call"));
    this.fgc.finish();
    AppMethodBeat.o(198531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.action.FaceFlashActionUI.1
 * JD-Core Version:    0.7.0.1
 */