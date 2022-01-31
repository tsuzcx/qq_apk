package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import com.tencent.mm.ui.widget.snackbar.b;

final class c$5
  implements DialogInterface.OnClickListener
{
  c$5(DialogInterface.OnClickListener paramOnClickListener, Fragment paramFragment, a.b paramb, a.c paramc, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.kbN != null) {
      this.kbN.onClick(paramDialogInterface, -2);
    }
    if (this.val$fragment != null)
    {
      b.a(this.val$fragment, this.val$fragment.getActivity().getString(n.i.favorite_ok), this.val$fragment.getActivity().getString(n.i.favorite_add_tag_tips), this.kbO, this.kbP);
      return;
    }
    b.a(this.val$activity, this.val$activity.getString(n.i.favorite_ok), this.val$activity.getString(n.i.favorite_add_tag_tips), this.kbO, this.kbP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.c.5
 * JD-Core Version:    0.7.0.1
 */