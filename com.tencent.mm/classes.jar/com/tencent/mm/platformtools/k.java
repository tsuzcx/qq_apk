package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.account.sdk.a;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public final class k
  extends c
{
  public k(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(final ad paramad)
  {
    AppMethodBeat.i(127699);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleOpenUrl");
    final Activity localActivity = this.activity;
    h.c(this.activity, paramad.content, "", this.activity.getString(r.j.confirm_dialog_ok), this.activity.getString(r.j.confirm_dialog_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(216070);
        paramAnonymousDialogInterface = new Intent();
        paramAnonymousDialogInterface.putExtra("rawUrl", paramad.url);
        paramAnonymousDialogInterface.putExtra("showShare", false);
        paramAnonymousDialogInterface.putExtra("show_bottom", false);
        paramAnonymousDialogInterface.putExtra("needRedirect", false);
        paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
        paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.RAX);
        a.mIG.h(paramAnonymousDialogInterface, localActivity);
        AppMethodBeat.o(216070);
      }
    }, null);
    AppMethodBeat.o(127699);
    return true;
  }
  
  public final boolean c(ad paramad)
  {
    AppMethodBeat.i(127700);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127700);
    return true;
  }
  
  public final boolean d(ad paramad)
  {
    AppMethodBeat.i(127701);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127701);
    return true;
  }
  
  public final boolean e(ad paramad)
  {
    AppMethodBeat.i(127702);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramad.content, 0).show();
    AppMethodBeat.o(127702);
    return true;
  }
  
  public final boolean f(ad paramad)
  {
    AppMethodBeat.i(222093);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleDoneBack");
    final Activity localActivity = this.activity;
    h.c(this.activity, paramad.content, "", this.activity.getString(r.j.confirm_dialog_ok), this.activity.getString(r.j.confirm_dialog_cancel), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(216928);
        localActivity.finish();
        AppMethodBeat.o(216928);
      }
    }, null);
    AppMethodBeat.o(222093);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127698);
    Log.i("MicroMsg.ErrorConfirmProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.k
 * JD-Core Version:    0.7.0.1
 */