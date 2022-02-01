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
  private int gOl = 0;
  
  protected a(aa paramaa)
  {
    super(paramaa);
  }
  
  private void bvG()
  {
    AppMethodBeat.i(135310);
    this.mgB.set(c.b.mgC);
    if ((this.clq.getContext() instanceof Activity))
    {
      Window localWindow = ((Activity)this.clq.getContext()).getWindow();
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
  
  public void DK()
  {
    AppMethodBeat.i(135309);
    bvG();
    AppMethodBeat.o(135309);
  }
  
  public void DL()
  {
    AppMethodBeat.i(135311);
    this.mgB.set(c.b.mgD);
    Object localObject = com.tencent.mm.sdk.f.a.jq(this.clq.getContext());
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
  
  public void Dv()
  {
    AppMethodBeat.i(135312);
    super.Dv();
    switch (1.cls[((c.b)this.mgB.get()).ordinal()])
    {
    default: 
      AppMethodBeat.o(135312);
      return;
    case 1: 
      bvG();
      AppMethodBeat.o(135312);
      return;
    }
    DL();
    AppMethodBeat.o(135312);
  }
  
  public void t(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(197346);
    if (paramInt != this.gOl) {}
    for (int i = 1;; i = 0)
    {
      this.gOl = paramInt;
      if (2 != paramInt) {
        break label89;
      }
      Activity localActivity = this.clq.getActivity();
      if ((localActivity == null) || (Build.VERSION.SDK_INT < 24) || (!localActivity.isInMultiWindowMode()) || (localActivity.getRequestedOrientation() != 1)) {
        break;
      }
      AppMethodBeat.o(197346);
      return;
    }
    if (!paramBoolean) {
      DL();
    }
    AppMethodBeat.o(197346);
    return;
    label89:
    if (((i != 0) || (this.mgB.get() == c.b.mgC)) && (!paramBoolean)) {
      DK();
    }
    AppMethodBeat.o(197346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.a
 * JD-Core Version:    0.7.0.1
 */