package com.tencent.mm.modelavatar;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.broadcast.a;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.report.service.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.k;
import junit.framework.Assert;

public final class o
  implements com.tencent.mm.am.h
{
  private Context context;
  private boolean igu;
  private ProgressDialog osY;
  private Runnable osZ;
  private Runnable ota;
  private String path;
  
  public o(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(231332);
    this.osZ = null;
    this.ota = null;
    this.context = paramContext;
    this.path = paramString;
    this.osY = null;
    this.igu = paramBoolean;
    com.tencent.mm.kernel.h.aZW().a(157, this);
    AppMethodBeat.o(231332);
  }
  
  public final boolean L(Runnable paramRunnable)
  {
    AppMethodBeat.i(150311);
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.osZ = paramRunnable;
      Object localObject = this.context;
      this.context.getString(c.h.app_tip);
      this.osY = k.a((Context)localObject, this.context.getString(c.h.settings_uploading_hd_avatar), true, null);
      localObject = new n(1, this.path);
      com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
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
      this.osZ = paramRunnable1;
      this.ota = paramRunnable2;
      paramRunnable1 = new n(1, this.path, (byte)0);
      com.tencent.mm.kernel.h.aZW().a(paramRunnable1, 0);
      Log.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(150312);
      return true;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(150313);
    Log.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    com.tencent.mm.kernel.h.aZW().b(157, this);
    if ((this.osY != null) && (this.osY.isShowing()) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {}
    try
    {
      this.osY.dismiss();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Toast.makeText(this.context, c.h.settings_upload_hd_avatar_success, 0).show();
        if (this.osZ != null) {
          new MMHandler(Looper.getMainLooper()).post(this.osZ);
        }
        if (this.igu)
        {
          paramInt1 = 1;
          l.kK(paramInt1, 2);
          AppMethodBeat.o(150313);
          return;
        }
      }
    }
    catch (IllegalArgumentException paramp)
    {
      for (;;)
      {
        Log.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + paramp.getMessage());
        continue;
        paramInt1 = 4;
      }
      if (this.ota != null) {
        new MMHandler(Looper.getMainLooper()).post(this.ota);
      }
      if ((paramInt1 == 4) && ((paramInt2 == -100) || (paramInt2 == -2023)))
      {
        AppMethodBeat.o(150313);
        return;
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = a.CH(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.o
 * JD-Core Version:    0.7.0.1
 */