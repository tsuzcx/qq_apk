package com.tencent.mm.plugin.ad.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.br.d;

final class c$3
  implements DialogInterface.OnClickListener
{
  c$3(c.a parama, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    d.b(this.nkk.getContext(), "freewifi", ".ui.FreeWifiEntryUI", this.dAd);
    this.nkk.im(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.a.c.3
 * JD-Core Version:    0.7.0.1
 */