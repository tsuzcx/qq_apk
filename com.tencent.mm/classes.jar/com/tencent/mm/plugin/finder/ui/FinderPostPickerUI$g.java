package com.tencent.mm.plugin.finder.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class FinderPostPickerUI$g
  implements Runnable
{
  FinderPostPickerUI$g(FinderPostPickerUI paramFinderPostPickerUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(167490);
    Object localObject = FinderPostPickerUI.e(this.rJF);
    if (localObject != null)
    {
      ((Dialog)localObject).show();
      AppMethodBeat.o(167490);
      return;
    }
    localObject = this.rJF;
    Context localContext = (Context)localObject;
    ((FinderPostPickerUI)localObject).getString(2131755906);
    FinderPostPickerUI.a((FinderPostPickerUI)localObject, (Dialog)h.b(localContext, ((FinderPostPickerUI)localObject).getString(2131755936), false, (DialogInterface.OnCancelListener)a.rJJ));
    AppMethodBeat.o(167490);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public static final a rJJ;
    
    static
    {
      AppMethodBeat.i(167489);
      rJJ = new a();
      AppMethodBeat.o(167489);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderPostPickerUI.g
 * JD-Core Version:    0.7.0.1
 */