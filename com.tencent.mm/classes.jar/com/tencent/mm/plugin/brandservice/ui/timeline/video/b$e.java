package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class b$e
  implements DialogInterface.OnCancelListener
{
  b$e(b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(7069);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(7069);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Log.e(this.pHD.TAG, "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(7069);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b.e
 * JD-Core Version:    0.7.0.1
 */