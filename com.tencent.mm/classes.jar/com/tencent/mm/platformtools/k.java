package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.account.a.a;
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
  
  public final boolean b(final ae paramae)
  {
    AppMethodBeat.i(127699);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleOpenUrl");
    final Activity localActivity = this.activity;
    h.c(this.activity, paramae.content, "", this.activity.getString(2131757787), this.activity.getString(2131757785), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(196837);
        paramAnonymousDialogInterface = new Intent();
        paramAnonymousDialogInterface.putExtra("rawUrl", paramae.url);
        paramAnonymousDialogInterface.putExtra("showShare", false);
        paramAnonymousDialogInterface.putExtra("show_bottom", false);
        paramAnonymousDialogInterface.putExtra("needRedirect", false);
        paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
        a.jRt.i(paramAnonymousDialogInterface, localActivity);
        AppMethodBeat.o(196837);
      }
    }, null);
    AppMethodBeat.o(127699);
    return true;
  }
  
  public final boolean c(ae paramae)
  {
    AppMethodBeat.i(127700);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleIgnore");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127700);
    return true;
  }
  
  public final boolean d(ae paramae)
  {
    AppMethodBeat.i(127701);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleFalseLast");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127701);
    return true;
  }
  
  public final boolean e(ae paramae)
  {
    AppMethodBeat.i(127702);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleFalseCancel");
    Toast.makeText(this.activity, paramae.content, 0).show();
    AppMethodBeat.o(127702);
    return true;
  }
  
  public final boolean f(ae paramae)
  {
    AppMethodBeat.i(196839);
    Log.d("MicroMsg.ErrorConfirmProcessor", "handleDoneBack");
    final Activity localActivity = this.activity;
    h.c(this.activity, paramae.content, "", this.activity.getString(2131757787), this.activity.getString(2131757785), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(196838);
        localActivity.finish();
        AppMethodBeat.o(196838);
      }
    }, null);
    AppMethodBeat.o(196839);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127698);
    Log.i("MicroMsg.ErrorConfirmProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.platformtools.k
 * JD-Core Version:    0.7.0.1
 */