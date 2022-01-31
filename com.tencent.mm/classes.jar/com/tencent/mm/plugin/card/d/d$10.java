package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.y;

final class d$10
  implements DialogInterface.OnClickListener
{
  d$10(Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("key_from_scene", 22);
    paramDialogInterface.putExtra("key_home_page_from_scene", 1);
    d.b(this.val$context, "card", ".ui.CardHomePageUI", paramDialogInterface);
    y.i("MicroMsg.CardDialogHelper", "enter to cardhome");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.d.10
 * JD-Core Version:    0.7.0.1
 */