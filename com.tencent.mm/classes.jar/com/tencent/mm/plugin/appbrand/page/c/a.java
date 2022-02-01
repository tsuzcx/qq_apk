package com.tencent.mm.plugin.appbrand.page.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(21)
public class a
  extends b
{
  private int hIX = 0;
  
  protected a(ac paramac)
  {
    super(paramac);
  }
  
  private void bSF()
  {
    AppMethodBeat.i(135310);
    this.nvY.set(c.b.nvZ);
    if ((this.cxn.getContext() instanceof Activity))
    {
      Window localWindow = ((Activity)this.cxn.getContext()).getWindow();
      if (localWindow == null)
      {
        AppMethodBeat.o(135310);
        return;
      }
      View localView = localWindow.getDecorView();
      localWindow.clearFlags(1024);
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFB);
    }
    AppMethodBeat.o(135310);
  }
  
  public void MV()
  {
    AppMethodBeat.i(135312);
    super.MV();
    switch (1.cxp[((c.b)this.nvY.get()).ordinal()])
    {
    default: 
      AppMethodBeat.o(135312);
      return;
    case 1: 
      bSF();
      AppMethodBeat.o(135312);
      return;
    }
    Nk();
    AppMethodBeat.o(135312);
  }
  
  public void Nj()
  {
    AppMethodBeat.i(135309);
    bSF();
    AppMethodBeat.o(135309);
  }
  
  public void Nk()
  {
    AppMethodBeat.i(135311);
    this.nvY.set(c.b.nwa);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.cxn.getContext());
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (!((Activity)localObject).isDestroyed()))
    {
      localObject = ((Activity)localObject).getWindow();
      if (localObject == null)
      {
        AppMethodBeat.o(135311);
        return;
      }
      ((Window)localObject).addFlags(1024);
      localObject = ((Window)localObject).getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x4 | 0x100);
    }
    AppMethodBeat.o(135311);
  }
  
  public void u(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(219489);
    if (paramInt != this.hIX) {}
    for (int i = 1;; i = 0)
    {
      this.hIX = paramInt;
      if (2 != paramInt) {
        break label89;
      }
      Activity localActivity = this.cxn.getActivity();
      if ((localActivity == null) || (Build.VERSION.SDK_INT < 24) || (!localActivity.isInMultiWindowMode()) || (localActivity.getRequestedOrientation() != 1)) {
        break;
      }
      AppMethodBeat.o(219489);
      return;
    }
    if (!paramBoolean) {
      Nk();
    }
    AppMethodBeat.o(219489);
    return;
    label89:
    if (((i != 0) || (this.nvY.get() == c.b.nvZ)) && (!paramBoolean)) {
      Nj();
    }
    AppMethodBeat.o(219489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.a
 * JD-Core Version:    0.7.0.1
 */