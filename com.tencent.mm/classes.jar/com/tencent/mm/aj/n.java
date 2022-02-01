package com.tencent.mm.aj;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class n
  implements i
{
  private Context context;
  private ProgressDialog iLh;
  private Runnable iLi;
  private Runnable iLj;
  private String path;
  
  public n(Context paramContext, String paramString)
  {
    AppMethodBeat.i(150310);
    this.iLi = null;
    this.iLj = null;
    this.context = paramContext;
    this.path = paramString;
    this.iLh = null;
    g.azz().a(157, this);
    AppMethodBeat.o(150310);
  }
  
  public final boolean G(Runnable paramRunnable)
  {
    AppMethodBeat.i(150311);
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.iLi = paramRunnable;
      Object localObject = this.context;
      this.context.getString(2131755998);
      this.iLh = h.a((Context)localObject, this.context.getString(2131765673), true, null);
      localObject = new m(1, this.path);
      g.azz().a((q)localObject, 0);
      if (paramRunnable != null) {
        break label132;
      }
    }
    label132:
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
      this.iLi = paramRunnable1;
      this.iLj = paramRunnable2;
      paramRunnable1 = new m(1, this.path, (byte)0);
      g.azz().a(paramRunnable1, 0);
      Log.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(150312);
      return true;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150313);
    Log.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    g.azz().b(157, this);
    if ((this.iLh != null) && (this.iLh.isShowing()) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {}
    try
    {
      this.iLh.dismiss();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Toast.makeText(this.context, 2131765672, 0).show();
        if (this.iLi != null) {
          new MMHandler(Looper.getMainLooper()).post(this.iLi);
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
      if (this.iLj != null) {
        new MMHandler(Looper.getMainLooper()).post(this.iLj);
      }
      if ((paramInt1 == 4) && ((paramInt2 == -100) || (paramInt2 == -2023)))
      {
        AppMethodBeat.o(150313);
        return;
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = a.Dk(paramString);
        if (paramString != null)
        {
          paramString.a(this.context, null, null);
          AppMethodBeat.o(150313);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -4))
      {
        Toast.makeText(this.context, 2131757980, 0).show();
        AppMethodBeat.o(150313);
        return;
      }
      Toast.makeText(this.context, 2131765671, 0).show();
      AppMethodBeat.o(150313);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aj.n
 * JD-Core Version:    0.7.0.1
 */