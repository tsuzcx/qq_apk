package com.tencent.mm.am;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.h.a;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import junit.framework.Assert;

public final class o
  implements i
{
  private Context context;
  private ProgressDialog lBo;
  private Runnable lBp;
  private Runnable lBq;
  private String path;
  
  public o(Context paramContext, String paramString)
  {
    AppMethodBeat.i(150310);
    this.lBp = null;
    this.lBq = null;
    this.context = paramContext;
    this.path = paramString;
    this.lBo = null;
    com.tencent.mm.kernel.h.aGY().a(157, this);
    AppMethodBeat.o(150310);
  }
  
  public final boolean G(Runnable paramRunnable)
  {
    AppMethodBeat.i(150311);
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.lBp = paramRunnable;
      Object localObject = this.context;
      this.context.getString(c.h.app_tip);
      this.lBo = com.tencent.mm.ui.base.h.a((Context)localObject, this.context.getString(c.h.settings_uploading_hd_avatar), true, null);
      localObject = new n(1, this.path);
      com.tencent.mm.kernel.h.aGY().a((q)localObject, 0);
      if (paramRunnable != null) {
        break label134;
      }
    }
    label134:
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(150311);
      return true;
      bool = false;
      break;
    }
  }
  
  public final boolean a(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(150312);
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.lBp = paramRunnable1;
      this.lBq = paramRunnable2;
      paramRunnable1 = new n(1, this.path, (byte)0);
      com.tencent.mm.kernel.h.aGY().a(paramRunnable1, 0);
      Log.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(150312);
      return true;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150313);
    Log.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    com.tencent.mm.kernel.h.aGY().b(157, this);
    if ((this.lBo != null) && (this.lBo.isShowing()) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {}
    try
    {
      this.lBo.dismiss();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Toast.makeText(this.context, c.h.settings_upload_hd_avatar_success, 0).show();
        if (this.lBp != null) {
          new MMHandler(Looper.getMainLooper()).post(this.lBp);
        }
        AppMethodBeat.o(150313);
        return;
      }
    }
    catch (IllegalArgumentException paramq)
    {
      for (;;)
      {
        Log.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + paramq.getMessage());
      }
      if (this.lBq != null) {
        new MMHandler(Looper.getMainLooper()).post(this.lBq);
      }
      if ((paramInt1 == 4) && ((paramInt2 == -100) || (paramInt2 == -2023)))
      {
        AppMethodBeat.o(150313);
        return;
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = a.Kb(paramString);
        if (paramString != null)
        {
          paramString.a(this.context, null, null);
          AppMethodBeat.o(150313);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -4))
      {
        Toast.makeText(this.context, c.h.contact_info_no_user, 0).show();
        AppMethodBeat.o(150313);
        return;
      }
      Toast.makeText(this.context, c.h.settings_upload_hd_avatar_fail, 0).show();
      AppMethodBeat.o(150313);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.o
 * JD-Core Version:    0.7.0.1
 */