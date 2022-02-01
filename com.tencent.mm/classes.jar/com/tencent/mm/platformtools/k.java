package com.tencent.mm.platformtools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.account.ui.r.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class k
  extends c
{
  public k(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public final boolean b(aa paramaa)
  {
    AppMethodBeat.i(127709);
    Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleOpenUrl");
    com.tencent.mm.ui.base.k.a(this.activity, paramaa.content, "", this.activity.getString(r.j.app_i_known), null);
    AppMethodBeat.o(127709);
    return true;
  }
  
  public final boolean c(aa paramaa)
  {
    AppMethodBeat.i(127710);
    Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleIgnore");
    com.tencent.mm.ui.base.k.a(this.activity, paramaa.content, "", this.activity.getString(r.j.app_i_known), null);
    AppMethodBeat.o(127710);
    return true;
  }
  
  public final boolean d(aa paramaa)
  {
    AppMethodBeat.i(127711);
    Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseLast");
    com.tencent.mm.ui.base.k.a(this.activity, paramaa.content, "", this.activity.getString(r.j.app_i_known), null);
    AppMethodBeat.o(127711);
    return true;
  }
  
  public final boolean e(aa paramaa)
  {
    AppMethodBeat.i(127712);
    Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleFalseCancel");
    com.tencent.mm.ui.base.k.a(this.activity, paramaa.content, "", this.activity.getString(r.j.app_i_known), null);
    AppMethodBeat.o(127712);
    return true;
  }
  
  public final boolean f(aa paramaa)
  {
    AppMethodBeat.i(234055);
    Log.d("MicroMsg.ErrorMsgBoxProcessor", "handleDoneBack");
    final Activity localActivity = this.activity;
    com.tencent.mm.ui.base.k.a(this.activity, paramaa.content, "", this.activity.getString(r.j.app_i_known), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(234002);
        localActivity.finish();
        AppMethodBeat.o(234002);
      }
    });
    AppMethodBeat.o(234055);
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(127708);
    Log.i("MicroMsg.ErrorMsgBoxProcessor", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    AppMethodBeat.o(127708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.k
 * JD-Core Version:    0.7.0.1
 */