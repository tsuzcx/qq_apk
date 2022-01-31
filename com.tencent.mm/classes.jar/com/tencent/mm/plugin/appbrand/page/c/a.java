package com.tencent.mm.plugin.appbrand.page.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(21)
public class a
  extends b
{
  private int iAy = 0;
  
  protected a(v paramv)
  {
    super(paramv);
  }
  
  private void aKg()
  {
    AppMethodBeat.i(87366);
    this.iAz.set(c.b.iAA);
    if ((this.bCg.getContext() instanceof Activity))
    {
      Window localWindow = ((Activity)this.bCg.getContext()).getWindow();
      if (localWindow == null)
      {
        AppMethodBeat.o(87366);
        return;
      }
      View localView = localWindow.getDecorView();
      localWindow.clearFlags(1024);
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFFB);
    }
    AppMethodBeat.o(87366);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    AppMethodBeat.i(87369);
    if (paramInt != this.iAy) {}
    for (int i = 1;; i = 0)
    {
      this.iAy = paramInt;
      if (2 != paramInt) {
        break label84;
      }
      Activity localActivity = com.tencent.mm.sdk.f.a.hr(this.bCg.mContext);
      if ((localActivity == null) || (Build.VERSION.SDK_INT < 24) || (!localActivity.isInMultiWindowMode()) || (localActivity.getRequestedOrientation() != 1)) {
        break;
      }
      AppMethodBeat.o(87369);
      return;
    }
    vK();
    AppMethodBeat.o(87369);
    return;
    label84:
    if ((i != 0) || (this.iAz.get() == c.b.iAA)) {
      vJ();
    }
    AppMethodBeat.o(87369);
  }
  
  public void vJ()
  {
    AppMethodBeat.i(87365);
    aKg();
    AppMethodBeat.o(87365);
  }
  
  public void vK()
  {
    AppMethodBeat.i(87367);
    this.iAz.set(c.b.iAB);
    Object localObject = com.tencent.mm.sdk.f.a.hr(this.bCg.getContext());
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (!((Activity)localObject).isDestroyed()))
    {
      localObject = ((Activity)localObject).getWindow();
      if (localObject == null)
      {
        AppMethodBeat.o(87367);
        return;
      }
      ((Window)localObject).addFlags(1024);
      localObject = ((Window)localObject).getDecorView();
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x4 | 0x100);
    }
    AppMethodBeat.o(87367);
  }
  
  public void vu()
  {
    AppMethodBeat.i(87368);
    super.vu();
    switch (a.1.bCi[((c.b)this.iAz.get()).ordinal()])
    {
    default: 
      AppMethodBeat.o(87368);
      return;
    case 1: 
      aKg();
      AppMethodBeat.o(87368);
      return;
    }
    vK();
    AppMethodBeat.o(87368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.a
 * JD-Core Version:    0.7.0.1
 */