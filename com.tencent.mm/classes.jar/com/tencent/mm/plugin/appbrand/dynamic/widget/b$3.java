package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.ui.base.AuthorizeItemListView;

final class b$3
  implements DialogInterface.OnDismissListener
{
  b$3(b paramb) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (this.fXZ.fXT != null) {
      this.fXZ.fXT.setAdapter(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.widget.b.3
 * JD-Core Version:    0.7.0.1
 */