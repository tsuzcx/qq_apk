package com.tencent.mm.plugin.finder.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.ui.MMActivity;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
public final class FinderGlobalLocationVM$f
  implements DialogInterface.OnClickListener
{
  public FinderGlobalLocationVM$f(MMActivity paramMMActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(204361);
    paramDialogInterface = d.rxr;
    d.V((Context)this.rte, 3);
    AppMethodBeat.o(204361);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM.f
 * JD-Core Version:    0.7.0.1
 */