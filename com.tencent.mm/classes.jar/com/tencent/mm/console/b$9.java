package com.tencent.mm.console;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.mm.R.l;

final class b$9
  implements DialogInterface.OnClickListener
{
  b$9(Context paramContext, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ClipboardManager)this.dAE.getSystemService("clipboard")).setText(this.doz);
    Toast.makeText(this.dAE, R.l.voip_get_key_copy_note, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.console.b.9
 * JD-Core Version:    0.7.0.1
 */