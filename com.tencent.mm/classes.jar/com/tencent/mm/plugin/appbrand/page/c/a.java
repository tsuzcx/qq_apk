package com.tencent.mm.plugin.appbrand.page.c;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicReference;

public class a
  extends b
{
  private int mZT = 0;
  
  protected a(ad paramad)
  {
    super(paramad);
  }
  
  private void cGv()
  {
    AppMethodBeat.i(135310);
    this.tDa.set(c.b.tDb);
    if ((this.enT.getContext() instanceof Activity))
    {
      Window localWindow = ((Activity)this.enT.getContext()).getWindow();
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
  
  public void apW()
  {
    AppMethodBeat.i(135312);
    super.apW();
    switch (1.enV[((c.b)this.tDa.get()).ordinal()])
    {
    default: 
      AppMethodBeat.o(135312);
      return;
    case 1: 
      cGv();
      AppMethodBeat.o(135312);
      return;
    }
    aqm();
    AppMethodBeat.o(135312);
  }
  
  public void aql()
  {
    AppMethodBeat.i(135309);
    cGv();
    AppMethodBeat.o(135309);
  }
  
  public void aqm()
  {
    AppMethodBeat.i(135311);
    this.tDa.set(c.b.tDc);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.enT.getContext());
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
  
  public void v(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(324885);
    if (paramInt != this.mZT) {}
    for (int i = 1;; i = 0)
    {
      this.mZT = paramInt;
      if (2 != paramInt) {
        break label89;
      }
      Activity localActivity = this.enT.getActivity();
      if ((localActivity == null) || (Build.VERSION.SDK_INT < 24) || (!localActivity.isInMultiWindowMode()) || (localActivity.getRequestedOrientation() != 1)) {
        break;
      }
      AppMethodBeat.o(324885);
      return;
    }
    if (!paramBoolean) {
      aqm();
    }
    AppMethodBeat.o(324885);
    return;
    label89:
    if (((i != 0) || (this.tDa.get() == c.b.tDb)) && (!paramBoolean)) {
      aql();
    }
    AppMethodBeat.o(324885);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.a
 * JD-Core Version:    0.7.0.1
 */