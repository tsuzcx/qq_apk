package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.downloader_app.b.i;

final class a$2
  implements DialogInterface.OnClickListener
{
  a$2(a parama, Bundle paramBundle, Context paramContext, i parami) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("download_params", this.gBV);
    paramDialogInterface.putExtra("Contact_User", "downloaderapp");
    d.b(this.val$context, "profile", ".ui.ContactInfoUI", paramDialogInterface);
    if (this.iRu != null) {
      this.iRu.aGo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.a.2
 * JD-Core Version:    0.7.0.1
 */