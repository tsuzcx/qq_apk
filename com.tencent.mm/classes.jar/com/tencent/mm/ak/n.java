package com.tencent.mm.ak;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.h.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class n
  implements com.tencent.mm.al.g
{
  private Context context;
  private ProgressDialog gUr;
  private Runnable gUs;
  private Runnable gUt;
  private String path;
  
  public n(Context paramContext, String paramString)
  {
    AppMethodBeat.i(150310);
    this.gUs = null;
    this.gUt = null;
    this.context = paramContext;
    this.path = paramString;
    this.gUr = null;
    com.tencent.mm.kernel.g.aeS().a(157, this);
    AppMethodBeat.o(150310);
  }
  
  public final boolean D(Runnable paramRunnable)
  {
    AppMethodBeat.i(150311);
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.gUs = paramRunnable;
      Object localObject = this.context;
      this.context.getString(2131755906);
      this.gUr = h.b((Context)localObject, this.context.getString(2131763488), true, null);
      localObject = new m(this.path);
      com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject, 0);
      if (paramRunnable != null) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.valueOf(bool) });
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
      this.gUs = paramRunnable1;
      this.gUt = paramRunnable2;
      paramRunnable1 = new m(this.path);
      com.tencent.mm.kernel.g.aeS().a(paramRunnable1, 0);
      ad.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(150312);
      return true;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(150313);
    ad.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    com.tencent.mm.kernel.g.aeS().b(157, this);
    if ((this.gUr != null) && (this.gUr.isShowing()) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {}
    try
    {
      this.gUr.dismiss();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Toast.makeText(this.context, 2131763487, 0).show();
        if (this.gUs != null) {
          new ap(Looper.getMainLooper()).post(this.gUs);
        }
        AppMethodBeat.o(150313);
        return;
      }
    }
    catch (IllegalArgumentException paramn)
    {
      for (;;)
      {
        ad.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + paramn.getMessage());
      }
      if (this.gUt != null) {
        new ap(Looper.getMainLooper()).post(this.gUt);
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = a.oG(paramString);
        if (paramString != null)
        {
          paramString.a(this.context, null, null);
          AppMethodBeat.o(150313);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -4))
      {
        Toast.makeText(this.context, 2131757743, 0).show();
        AppMethodBeat.o(150313);
        return;
      }
      Toast.makeText(this.context, 2131763486, 0).show();
      AppMethodBeat.o(150313);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.n
 * JD-Core Version:    0.7.0.1
 */