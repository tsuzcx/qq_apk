package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class MPWriteCommentLayout$i
  implements DialogInterface.OnCancelListener
{
  public static final i khP;
  
  static
  {
    AppMethodBeat.i(152921);
    khP = new i();
    AppMethodBeat.o(152921);
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(152920);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(152920);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      MPWriteCommentLayout.b localb = MPWriteCommentLayout.khu;
      ab.e(MPWriteCommentLayout.access$getTAG$cp(), "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(152920);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.MPWriteCommentLayout.i
 * JD-Core Version:    0.7.0.1
 */