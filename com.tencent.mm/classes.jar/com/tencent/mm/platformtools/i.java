package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.account.sdk.a;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;

public final class i
  extends c
{
  public i(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(final aa paramaa)
  {
    AppMethodBeat.i(127699);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleOpenUrl");
    final Activity localActivity = this.activity;
    k.b(this.activity, paramaa.content, "", this.activity.getString(r.j.confirm_dialog_ok), this.activity.getString(r.j.confirm_dialog_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(234021);
        paramAnonymousDialogInterface = new Intent();
        paramAnonymousDialogInterface.putExtra("rawUrl", paramaa.url);
        paramAnonymousDialogInterface.putExtra("showShare", false);
        paramAnonymousDialogInterface.putExtra("show_bottom", false);
        paramAnonymousDialogInterface.putExtra("needRedirect", false);
        paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
        paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.YxA);
        a.pFn.h(paramAnonymousDialogInterface, localActivity);
        AppMethodBeat.o(234021);
      }
    }, null);
    AppMethodBeat.o(127699);
    return true;
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(127700);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127700);
    return true;
  }
  
  public final boolean d(aa paramaa)
  {
    AppMethodBeat.i(127701);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127701);
    return true;
  }
  
  public final boolean e(aa paramaa)
  {
    AppMethodBeat.i(127702);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramaa.content, 0).show();
    AppMethodBeat.o(127702);
    return true;
  }
  
  public final boolean f(aa paramaa)
  {
    AppMethodBeat.i(234057);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleDoneBack");
    final Activity localActivity = this.activity;
    k.b(this.activity, paramaa.content, "", this.activity.getString(r.j.confirm_dialog_ok), this.activity.getString(r.j.confirm_dialog_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(234005);
        localActivity.finish();
        AppMethodBeat.o(234005);
      }
    }, null);
    AppMethodBeat.o(234057);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(127698);
    Log.i("MicroMsg.ErrorConfirmProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.i
 * JD-Core Version:    0.7.0.1
 */