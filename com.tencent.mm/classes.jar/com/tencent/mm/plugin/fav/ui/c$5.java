package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.ui.widget.snackbar.b;

final class c$5
  implements DialogInterface.OnClickListener
{
  c$5(DialogInterface.OnClickListener paramOnClickListener, Fragment paramFragment, a.b paramb, a.c paramc, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(73981);
    paramDialogInterface.dismiss();
    if (this.mwj != null) {
      this.mwj.onClick(paramDialogInterface, -2);
    }
    if (this.val$fragment != null)
    {
      paramDialogInterface = this.val$fragment.getView();
      if ((this.val$fragment instanceof MMFragment)) {
        paramDialogInterface = ((MMFragment)this.val$fragment).getContentView();
      }
      b.a(this.val$fragment.getContext(), paramDialogInterface, this.val$fragment.getActivity().getString(2131299764), this.val$fragment.getActivity().getString(2131299681), this.mwk, this.mwl);
      AppMethodBeat.o(73981);
      return;
    }
    b.a(this.val$activity, this.val$activity.getString(2131299764), this.val$activity.getString(2131299681), this.mwk, this.mwl);
    AppMethodBeat.o(73981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.5
 * JD-Core Version:    0.7.0.1
 */