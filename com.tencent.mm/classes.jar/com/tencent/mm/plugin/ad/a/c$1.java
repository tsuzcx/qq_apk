package com.tencent.mm.plugin.ad.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.pluginsdk.m;

final class c$1
  implements DialogInterface.OnClickListener
{
  c$1(Intent paramIntent, h paramh, int paramInt1, int paramInt2, c.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.val$intent.putExtra("title", this.nkh.getTitle());
    this.val$intent.putExtra("rawUrl", this.nkh.Qf());
    if (this.nki == 2) {
      this.val$intent.putExtra("stastic_scene", 13);
    }
    for (;;)
    {
      this.val$intent.putExtra("pay_channel", c.wr(this.nkj));
      this.val$intent.putExtra("geta8key_session_id", this.nkh.Qn());
      this.val$intent.putExtra("geta8key_cookie", this.nkh.Qo());
      b.eUR.j(this.val$intent, this.nkk.getContext());
      return;
      if (this.nki == 1) {
        this.val$intent.putExtra("stastic_scene", 14);
      } else {
        this.val$intent.putExtra("stastic_scene", 11);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.a.c.1
 * JD-Core Version:    0.7.0.1
 */