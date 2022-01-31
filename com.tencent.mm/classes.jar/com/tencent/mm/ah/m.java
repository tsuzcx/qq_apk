package com.tencent.mm.ah;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import junit.framework.Assert;

public final class m
  implements f
{
  private Context context;
  private ProgressDialog fsw;
  private Runnable fsx;
  private Runnable fsy;
  private String path;
  
  public m(Context paramContext, String paramString)
  {
    AppMethodBeat.i(77946);
    this.fsx = null;
    this.fsy = null;
    this.context = paramContext;
    this.path = paramString;
    this.fsw = null;
    g.Rc().a(157, this);
    AppMethodBeat.o(77946);
  }
  
  public final boolean a(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(77948);
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.fsx = paramRunnable1;
      this.fsy = paramRunnable2;
      paramRunnable1 = new l(this.path);
      g.Rc().a(paramRunnable1, 0);
      ab.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.FALSE });
      AppMethodBeat.o(77948);
      return true;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(77949);
    ab.i("MicroMsg.ProcessUploadHDHeadImg", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    g.Rc().b(157, this);
    if ((this.fsw != null) && (this.fsw.isShowing()) && ((this.context instanceof Activity)) && (!((Activity)this.context).isFinishing())) {}
    try
    {
      this.fsw.dismiss();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Toast.makeText(this.context, 2131303505, 0).show();
        if (this.fsx != null) {
          new ak(Looper.getMainLooper()).post(this.fsx);
        }
        AppMethodBeat.o(77949);
        return;
      }
    }
    catch (IllegalArgumentException paramm)
    {
      for (;;)
      {
        ab.e("MicroMsg.ProcessUploadHDHeadImg", "dismiss dialog err" + paramm.getMessage());
      }
      if (this.fsy != null) {
        new ak(Looper.getMainLooper()).post(this.fsy);
      }
      if ((paramString != null) && (paramString.length() > 0))
      {
        paramString = a.kO(paramString);
        if (paramString != null)
        {
          paramString.a(this.context, null, null);
          AppMethodBeat.o(77949);
          return;
        }
      }
      if ((paramInt1 == 4) && (paramInt2 == -4))
      {
        Toast.makeText(this.context, 2131298682, 0).show();
        AppMethodBeat.o(77949);
        return;
      }
      Toast.makeText(this.context, 2131303504, 0).show();
      AppMethodBeat.o(77949);
    }
  }
  
  public final boolean v(Runnable paramRunnable)
  {
    AppMethodBeat.i(77947);
    if ((this.context != null) && (this.path != null) && (this.path.length() > 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.fsx = paramRunnable;
      Object localObject = this.context;
      this.context.getString(2131297087);
      this.fsw = h.b((Context)localObject, this.context.getString(2131303506), true, null);
      localObject = new l(this.path);
      g.Rc().a((com.tencent.mm.ai.m)localObject, 0);
      if (paramRunnable != null) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.ProcessUploadHDHeadImg", "post is null ? %B", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(77947);
      return true;
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ah.m
 * JD-Core Version:    0.7.0.1
 */