package com.tencent.mm.plugin.finder.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class FinderMediaCropUI$ab
  implements Runnable
{
  FinderMediaCropUI$ab(FinderMediaCropUI paramFinderMediaCropUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(167380);
    Object localObject = FinderMediaCropUI.e(this.rIw);
    if (localObject != null) {
      ((Dialog)localObject).show();
    }
    for (;;)
    {
      ac.d("Finder.MediaCropUI", "tipDialog is show!");
      AppMethodBeat.o(167380);
      return;
      localObject = this.rIw;
      Context localContext = (Context)localObject;
      ((FinderMediaCropUI)localObject).getString(2131755906);
      FinderMediaCropUI.a((FinderMediaCropUI)localObject, (Dialog)h.b(localContext, ((FinderMediaCropUI)localObject).getString(2131755936), false, (DialogInterface.OnCancelListener)a.rIU));
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public static final a rIU;
    
    static
    {
      AppMethodBeat.i(167379);
      rIU = new a();
      AppMethodBeat.o(167379);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.ab
 * JD-Core Version:    0.7.0.1
 */