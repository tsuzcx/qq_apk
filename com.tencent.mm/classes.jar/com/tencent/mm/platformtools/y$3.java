package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;

final class y$3
  implements DialogInterface.OnClickListener
{
  y$3(String paramString, Context paramContext) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(127742);
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("rawUrl", this.jNG);
    paramDialogInterface.putExtra("showShare", false);
    paramDialogInterface.putExtra("show_bottom", false);
    paramDialogInterface.putExtra("needRedirect", false);
    paramDialogInterface.putExtra("neverGetA8Key", true);
    paramDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
    paramDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
    a.jRt.i(paramDialogInterface, this.val$context);
    AppMethodBeat.o(127742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.y.3
 * JD-Core Version:    0.7.0.1
 */