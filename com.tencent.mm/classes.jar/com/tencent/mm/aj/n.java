package com.tencent.mm.aj;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class n
  implements f
{
  private Context context;
  private ProgressDialog hQb;
  private Runnable hQc;
  private Runnable hQd;
  private String path;
  
  public n(Context paramContext, String paramString)
  {
    AppMethodBeat.i(150310);
    this.hQc = null;
    this.hQd = null;
    this.context = paramContext;
    this.path = paramString;
    this.hQb = null;
    g.ajj().a(157, this);
    AppMethodBeat.o(150310);
  }
  
  public final boolean C(Runnable paramRunnable)
  {
    AppMethodBeat.i(150311);
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.hQc = paramRunnable;
      Object localObject = this.context;
      this.context.getString(2131755906);
      this.hQb = h.b((Context)localObject, this.context.getString(2131763488), true, null);
      localObject = new m(this.path);
      g.ajj().a((com.tencent.mm.ak.n)localObject, 0);
      if (paramRunnable != null) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.valueOf(bool) });
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
      this.hQc = paramRunnable1;
      this.hQd = paramRunnable2;
      paramRunnable1 = new m(this.path);
      g.ajj().a(paramRunnable1, 0);
      ae.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(150312);
      return true;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(150313);
    ae.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    g.ajj().b(157, this);
    if ((this.hQb != null) && (this.hQb.isShowing()) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {}
    try
    {
      this.hQb.dismiss();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Toast.makeText(this.context, 2131763487, 0).show();
        if (this.hQc != null) {
          new aq(Looper.getMainLooper()).post(this.hQc);
        }
        AppMethodBeat.o(150313);
        return;
      }
    }
    catch (IllegalArgumentException paramn)
    {
      for (;;)
      {
        ae.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + paramn.getMessage());
      }
      if (this.hQd != null) {
        new aq(Looper.getMainLooper()).post(this.hQd);
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = a.uU(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.n
 * JD-Core Version:    0.7.0.1
 */