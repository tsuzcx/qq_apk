package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class b$e
  implements DialogInterface.OnCancelListener
{
  b$e(b paramb) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(152802);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(152802);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      ab.e(this.kfC.TAG, "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(152802);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.b.e
 * JD-Core Version:    0.7.0.1
 */