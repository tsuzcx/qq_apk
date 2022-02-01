package com.tencent.mm.plugin.appbrand.page.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import java.util.concurrent.atomic.AtomicReference;

@TargetApi(21)
public class a
  extends b
{
  private int gQT = 0;
  
  protected a(z paramz)
  {
    super(paramz);
  }
  
  private void bwx()
  {
    AppMethodBeat.i(135310);
    this.mlA.set(c.b.mlB);
    if ((this.cls.getContext() instanceof Activity))
    {
      Window localWindow = ((Activity)this.cls.getContext()).getWindow();
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
  
  public void DN()
  {
    AppMethodBeat.i(135309);
    bwx();
    AppMethodBeat.o(135309);
  }
  
  public void DO()
  {
    AppMethodBeat.i(135311);
    this.mlA.set(c.b.mlC);
    Object localObject = com.tencent.mm.sdk.f.a.jw(this.cls.getContext());
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
  
  public void Dy()
  {
    AppMethodBeat.i(135312);
    super.Dy();
    switch (1.clu[((c.b)this.mlA.get()).ordinal()])
    {
    default: 
      AppMethodBeat.o(135312);
      return;
    case 1: 
      bwx();
      AppMethodBeat.o(135312);
      return;
    }
    DO();
    AppMethodBeat.o(135312);
  }
  
  public void u(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(207887);
    if (paramInt != this.gQT) {}
    for (int i = 1;; i = 0)
    {
      this.gQT = paramInt;
      if (2 != paramInt) {
        break label89;
      }
      Activity localActivity = this.cls.getActivity();
      if ((localActivity == null) || (Build.VERSION.SDK_INT < 24) || (!localActivity.isInMultiWindowMode()) || (localActivity.getRequestedOrientation() != 1)) {
        break;
      }
      AppMethodBeat.o(207887);
      return;
    }
    if (!paramBoolean) {
      DO();
    }
    AppMethodBeat.o(207887);
    return;
    label89:
    if (((i != 0) || (this.mlA.get() == c.b.mlB)) && (!paramBoolean)) {
      DN();
    }
    AppMethodBeat.o(207887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.a
 * JD-Core Version:    0.7.0.1
 */