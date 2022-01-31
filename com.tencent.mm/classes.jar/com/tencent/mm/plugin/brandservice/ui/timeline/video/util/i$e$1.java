package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.l;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.ui.widget.b.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "i", "", "onClick"})
final class i$e$1
  implements DialogInterface.OnClickListener
{
  i$e$1(i.e parame) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(152976);
    if (paramDialogInterface == null) {}
    for (paramDialogInterface = "";; paramDialogInterface = ((c)paramDialogInterface).dOY())
    {
      Object localObject = this.kiN.kiJ.aZT();
      if (localObject == null) {
        break;
      }
      localObject = ((TmplShareWebViewToolUI)localObject).uQS;
      if (localObject == null) {
        break;
      }
      ((d)localObject).o(1, paramDialogInterface, 0);
      AppMethodBeat.o(152976);
      return;
    }
    AppMethodBeat.o(152976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.i.e.1
 * JD-Core Version:    0.7.0.1
 */