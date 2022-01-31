package com.tencent.mm.permission;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.e.d;

final class PermissionWarningDialog$3
  implements e.d
{
  PermissionWarningDialog$3(PermissionWarningDialog paramPermissionWarningDialog) {}
  
  public final void b(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      y.i("MicroMsg.PermissionWarningDialog", "set MicroPhone unmute.");
      ((AudioManager)ae.getContext().getSystemService("audio")).setMicrophoneMute(false);
    }
    this.eQW.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.permission.PermissionWarningDialog.3
 * JD-Core Version:    0.7.0.1
 */