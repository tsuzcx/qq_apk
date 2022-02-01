package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
final class AppBrandUserInfoAuthorizeUI$j
  implements DialogInterface.OnCancelListener
{
  AppBrandUserInfoAuthorizeUI$j(a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(180673);
    this.mfu.invoke();
    AppMethodBeat.o(180673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUserInfoAuthorizeUI.j
 * JD-Core Version:    0.7.0.1
 */