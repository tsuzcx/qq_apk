package com.tencent.mm.plugin.dbbackup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.vfs.e;

final class c$6
  implements DialogInterface.OnClickListener
{
  c$6(c paramc, String paramString, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    e.K(this.iMA, true);
    Toast.makeText(this.val$context, "Corruption test database cleared.", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.c.6
 * JD-Core Version:    0.7.0.1
 */