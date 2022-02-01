package com.tencent.mm.plugin.finder.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class FinderMediaCropUI$z
  implements Runnable
{
  FinderMediaCropUI$z(FinderMediaCropUI paramFinderMediaCropUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(167380);
    Object localObject = FinderMediaCropUI.d(this.qMY);
    if (localObject != null) {
      ((Dialog)localObject).show();
    }
    for (;;)
    {
      ad.d("Finder.MediaCropUI", "tipDialog is show!");
      AppMethodBeat.o(167380);
      return;
      localObject = this.qMY;
      Context localContext = (Context)localObject;
      ((FinderMediaCropUI)localObject).getString(2131755906);
      FinderMediaCropUI.a((FinderMediaCropUI)localObject, (Dialog)h.b(localContext, ((FinderMediaCropUI)localObject).getString(2131755936), false, (DialogInterface.OnCancelListener)a.qNw));
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public static final a qNw;
    
    static
    {
      AppMethodBeat.i(167379);
      qNw = new a();
      AppMethodBeat.o(167379);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderMediaCropUI.z
 * JD-Core Version:    0.7.0.1
 */