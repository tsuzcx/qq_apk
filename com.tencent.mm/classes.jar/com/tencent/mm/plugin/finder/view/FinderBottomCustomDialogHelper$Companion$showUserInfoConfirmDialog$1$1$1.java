package com.tencent.mm.plugin.finder.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.af;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
final class FinderBottomCustomDialogHelper$Companion$showUserInfoConfirmDialog$1$1$1
  implements DialogInterface.OnDismissListener
{
  public static final 1 INSTANCE;
  
  static
  {
    AppMethodBeat.i(254635);
    INSTANCE = new 1();
    AppMethodBeat.o(254635);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(254634);
    paramDialogInterface = k.vkd;
    k.a(s.af.vqo);
    AppMethodBeat.o(254634);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderBottomCustomDialogHelper.Companion.showUserInfoConfirmDialog.1.1.1
 * JD-Core Version:    0.7.0.1
 */