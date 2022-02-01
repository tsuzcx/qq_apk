package com.tencent.mm.plugin.appbrand.page.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(21)
public class a
  extends b
{
  private int lgU = 0;
  
  protected a(aa paramaa)
  {
    super(paramaa);
  }
  
  private void bkN()
  {
    AppMethodBeat.i(135310);
    this.lgV.set(c.b.lgW);
    if ((this.cec.getContext() instanceof Activity))
    {
      Window localWindow = ((Activity)this.cec.getContext()).getWindow();
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
  
  public void CH()
  {
    AppMethodBeat.i(135309);
    bkN();
    AppMethodBeat.o(135309);
  }
  
  public void CI()
  {
    AppMethodBeat.i(135311);
    this.lgV.set(c.b.lgX);
    Object localObject = com.tencent.mm.sdk.f.a.iV(this.cec.getContext());
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
  
  public void Cs()
  {
    AppMethodBeat.i(135312);
    super.Cs();
    switch (1.cee[((c.b)this.lgV.get()).ordinal()])
    {
    default: 
      AppMethodBeat.o(135312);
      return;
    case 1: 
      bkN();
      AppMethodBeat.o(135312);
      return;
    }
    CI();
    AppMethodBeat.o(135312);
  }
  
  public void t(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(194514);
    if (paramInt != this.lgU) {}
    for (int i = 1;; i = 0)
    {
      this.lgU = paramInt;
      if (2 != paramInt) {
        break label89;
      }
      Activity localActivity = this.cec.getActivity();
      if ((localActivity == null) || (Build.VERSION.SDK_INT < 24) || (!localActivity.isInMultiWindowMode()) || (localActivity.getRequestedOrientation() != 1)) {
        break;
      }
      AppMethodBeat.o(194514);
      return;
    }
    if (!paramBoolean) {
      CI();
    }
    AppMethodBeat.o(194514);
    return;
    label89:
    if (((i != 0) || (this.lgV.get() == c.b.lgW)) && (!paramBoolean)) {
      CH();
    }
    AppMethodBeat.o(194514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.a
 * JD-Core Version:    0.7.0.1
 */