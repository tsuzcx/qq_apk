package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.d.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.ae;

final class b
  extends com.tencent.mm.plugin.appbrand.platform.window.a
{
  private final d.c mtQ;
  private int mtR;
  private WindowManager.LayoutParams mtS;
  
  b(final o paramo, d.b paramb)
  {
    super(paramo, paramb);
    AppMethodBeat.i(207971);
    this.mtQ = new d.c()
    {
      public final void a(e.b paramAnonymousb)
      {
        AppMethodBeat.i(207970);
        paramo.bxN().a(paramAnonymousb, null);
        AppMethodBeat.o(207970);
      }
    };
    AppMethodBeat.o(207971);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(207972);
    Activity localActivity = com.tencent.mm.sdk.f.a.jw(((o)this.jDa).mContext);
    AppMethodBeat.o(207972);
    return localActivity;
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(207974);
    super.O(paramView, paramInt);
    paramView = getActivity();
    ViewGroup localViewGroup;
    if (paramView != null)
    {
      localViewGroup = (ViewGroup)paramView.getWindow().getDecorView();
      if (this.mtz == null) {
        this.mtR = localViewGroup.getSystemUiVisibility();
      }
      if (d.lB(19))
      {
        localViewGroup.setSystemUiVisibility(2);
        if (this.mtz == null)
        {
          this.mtS = new WindowManager.LayoutParams();
          this.mtS.copyFrom(paramView.getWindow().getAttributes());
        }
        paramView.getWindow().addFlags(1024);
        if (Build.VERSION.SDK_INT >= 28) {
          paramView.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
        }
        rM(paramInt);
      }
    }
    for (;;)
    {
      bxA();
      this.mtz = null;
      AppMethodBeat.o(207974);
      return;
      localViewGroup.setSystemUiVisibility(4102);
      break;
      ae.e("Luggage.ActivityWindowFullscreenImpl", "enterFullscreen, get NULL activity");
      if (this.mtz == null)
      {
        this.mtS = null;
        this.mtR = 0;
      }
    }
  }
  
  public final boolean aYo()
  {
    AppMethodBeat.i(207975);
    boolean bool = this.mtA;
    if (super.aYo())
    {
      Activity localActivity = getActivity();
      if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed())) {
        ae.e("Luggage.ActivityWindowFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localActivity });
      }
      for (;;)
      {
        bxB();
        AppMethodBeat.o(207975);
        return true;
        ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.mtR);
        localActivity.getWindow().clearFlags(1024);
        if (this.mtS != null) {
          localActivity.getWindow().setAttributes(this.mtS);
        }
        this.mtQ.a(e.b.vh(-1));
      }
    }
    if (bool)
    {
      this.mtA = false;
      bxB();
      AppMethodBeat.o(207975);
      return true;
    }
    AppMethodBeat.o(207975);
    return false;
  }
  
  public final void rM(int paramInt)
  {
    AppMethodBeat.i(207973);
    this.mtA = true;
    switch (paramInt)
    {
    default: 
      this.mtQ.a(e.b.vh(9));
      AppMethodBeat.o(207973);
      return;
    case 90: 
      this.mtQ.a(e.b.vh(0));
      AppMethodBeat.o(207973);
      return;
    case -90: 
      this.mtQ.a(e.b.vh(8));
      AppMethodBeat.o(207973);
      return;
    }
    this.mtQ.a(e.b.vh(1));
    AppMethodBeat.o(207973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.b
 * JD-Core Version:    0.7.0.1
 */