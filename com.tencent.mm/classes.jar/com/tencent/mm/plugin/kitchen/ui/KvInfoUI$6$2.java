package com.tencent.mm.plugin.kitchen.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.mm.plugin.kitchen.b.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class KvInfoUI$6$2
  implements DialogInterface.OnClickListener
{
  KvInfoUI$6$2(KvInfoUI.6 param6, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      ((ClipboardManager)ae.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("kv_info", this.lAE));
      Toast.makeText(this.lAD.lAA.mController.uMN, this.lAD.lAA.mController.uMN.getString(b.d.app_copy_ok), 0).show();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.KvInfoUI", "copy error [%s]", new Object[] { paramDialogInterface.toString() });
      Toast.makeText(this.lAD.lAA.mController.uMN, "copy failure", 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.6.2
 * JD-Core Version:    0.7.0.1
 */