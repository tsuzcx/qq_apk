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
  private int guA = 0;
  
  protected a(aa paramaa)
  {
    super(paramaa);
  }
  
  private void brC()
  {
    AppMethodBeat.i(135310);
    this.lGO.set(c.b.lGP);
    if ((this.caZ.getContext() instanceof Activity))
    {
      Window localWindow = ((Activity)this.caZ.getContext()).getWindow();
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
  
  public void BW()
  {
    AppMethodBeat.i(135312);
    super.BW();
    switch (1.cbb[((c.b)this.lGO.get()).ordinal()])
    {
    default: 
      AppMethodBeat.o(135312);
      return;
    case 1: 
      brC();
      AppMethodBeat.o(135312);
      return;
    }
    Cm();
    AppMethodBeat.o(135312);
  }
  
  public void Cl()
  {
    AppMethodBeat.i(135309);
    brC();
    AppMethodBeat.o(135309);
  }
  
  public void Cm()
  {
    AppMethodBeat.i(135311);
    this.lGO.set(c.b.lGQ);
    Object localObject = com.tencent.mm.sdk.f.a.jg(this.caZ.getContext());
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
    AppMethodBeat.i(193429);
    if (paramInt != this.guA) {}
    for (int i = 1;; i = 0)
    {
      this.guA = paramInt;
      if (2 != paramInt) {
        break label89;
      }
      Activity localActivity = this.caZ.getActivity();
      if ((localActivity == null) || (Build.VERSION.SDK_INT < 24) || (!localActivity.isInMultiWindowMode()) || (localActivity.getRequestedOrientation() != 1)) {
        break;
      }
      AppMethodBeat.o(193429);
      return;
    }
    if (!paramBoolean) {
      Cm();
    }
    AppMethodBeat.o(193429);
    return;
    label89:
    if (((i != 0) || (this.lGO.get() == c.b.lGP)) && (!paramBoolean)) {
      Cl();
    }
    AppMethodBeat.o(193429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.a
 * JD-Core Version:    0.7.0.1
 */