package com.tencent.mm.plugin.finder.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class FinderCropAvatarUI$k
  implements Runnable
{
  FinderCropAvatarUI$k(FinderCropAvatarUI paramFinderCropAvatarUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(167210);
    Object localObject = FinderCropAvatarUI.h(this.qMa);
    if (localObject != null)
    {
      ((Dialog)localObject).show();
      AppMethodBeat.o(167210);
      return;
    }
    localObject = this.qMa;
    Context localContext = (Context)localObject;
    ((FinderCropAvatarUI)localObject).getString(2131755906);
    FinderCropAvatarUI.a((FinderCropAvatarUI)localObject, (Dialog)h.b(localContext, ((FinderCropAvatarUI)localObject).getString(2131755936), false, (DialogInterface.OnCancelListener)a.qMe));
    AppMethodBeat.o(167210);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
  static final class a
    implements DialogInterface.OnCancelListener
  {
    public static final a qMe;
    
    static
    {
      AppMethodBeat.i(167209);
      qMe = new a();
      AppMethodBeat.o(167209);
    }
    
    public final void onCancel(DialogInterface paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI.k
 * JD-Core Version:    0.7.0.1
 */