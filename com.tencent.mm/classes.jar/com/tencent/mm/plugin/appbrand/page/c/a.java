package com.tencent.mm.plugin.appbrand.page.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(21)
public class a
  extends b
{
  private int kwr = 0;
  
  protected a(ad paramad)
  {
    super(paramad);
  }
  
  private void cfI()
  {
    AppMethodBeat.i(135310);
    this.qya.set(c.b.qyb);
    if ((this.cvV.getContext() instanceof Activity))
    {
      Window localWindow = ((Activity)this.cvV.getContext()).getWindow();
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
  
  public void PN()
  {
    AppMethodBeat.i(135312);
    super.PN();
    switch (1.cvX[((c.b)this.qya.get()).ordinal()])
    {
    default: 
      AppMethodBeat.o(135312);
      return;
    case 1: 
      cfI();
      AppMethodBeat.o(135312);
      return;
    }
    Qc();
    AppMethodBeat.o(135312);
  }
  
  public void Qb()
  {
    AppMethodBeat.i(135309);
    cfI();
    AppMethodBeat.o(135309);
  }
  
  public void Qc()
  {
    AppMethodBeat.i(135311);
    this.qya.set(c.b.qyc);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.cvV.getContext());
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
  
  public void x(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(245565);
    if (paramInt != this.kwr) {}
    for (int i = 1;; i = 0)
    {
      this.kwr = paramInt;
      if (2 != paramInt) {
        break label89;
      }
      Activity localActivity = this.cvV.getActivity();
      if ((localActivity == null) || (Build.VERSION.SDK_INT < 24) || (!localActivity.isInMultiWindowMode()) || (localActivity.getRequestedOrientation() != 1)) {
        break;
      }
      AppMethodBeat.o(245565);
      return;
    }
    if (!paramBoolean) {
      Qc();
    }
    AppMethodBeat.o(245565);
    return;
    label89:
    if (((i != 0) || (this.qya.get() == c.b.qyb)) && (!paramBoolean)) {
      Qb();
    }
    AppMethodBeat.o(245565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.a
 * JD-Core Version:    0.7.0.1
 */