package com.tencent.mm.ag;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class m
  implements f
{
  private Context context;
  private ProgressDialog ecf;
  private Runnable ecg = null;
  private Runnable ech = null;
  private String path;
  
  public m(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.path = paramString;
    this.ecf = null;
    g.Dk().a(157, this);
  }
  
  public final boolean a(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.ecg = paramRunnable1;
      this.ech = paramRunnable2;
      paramRunnable1 = new l(1, this.path);
      g.Dk().a(paramRunnable1, 0);
      y.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.valueOf(false) });
      return true;
    }
  }
  
  public final boolean b(int paramInt, Runnable paramRunnable)
  {
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.ecg = paramRunnable;
      Object localObject = this.context;
      this.context.getString(a.h.app_tip);
      this.ecf = h.b((Context)localObject, this.context.getString(a.h.settings_uploading_hd_avatar), true, null);
      localObject = new l(paramInt, this.path);
      g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
      if (paramRunnable != null) {
        break label128;
      }
    }
    label128:
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.valueOf(bool) });
      return true;
      bool = false;
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    g.Dk().b(157, this);
    if ((this.ecf != null) && (this.ecf.isShowing()) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {}
    try
    {
      this.ecf.dismiss();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Toast.makeText(this.context, a.h.settings_upload_hd_avatar_success, 0).show();
        if (this.ecg != null) {
          new ah(Looper.getMainLooper()).post(this.ecg);
        }
        return;
      }
    }
    catch (IllegalArgumentException paramm)
    {
      for (;;)
      {
        y.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + paramm.getMessage());
      }
      if (this.ech != null) {
        new ah(Looper.getMainLooper()).post(this.ech);
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = a.eI(paramString);
        if (paramString != null)
        {
          paramString.a(this.context, null, null);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -4))
      {
        Toast.makeText(this.context, a.h.contact_info_no_user, 0).show();
        return;
      }
      Toast.makeText(this.context, a.h.settings_upload_hd_avatar_fail, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ag.m
 * JD-Core Version:    0.7.0.1
 */