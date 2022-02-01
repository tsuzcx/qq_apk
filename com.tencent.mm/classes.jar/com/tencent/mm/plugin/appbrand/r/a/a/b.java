package com.tencent.mm.plugin.appbrand.r.a.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.r.a.d.b;
import com.tencent.mm.plugin.appbrand.r.a.d.c;
import com.tencent.mm.plugin.appbrand.r.a.e.b;
import com.tencent.mm.sdk.platformtools.ac;

final class b
  extends com.tencent.mm.plugin.appbrand.r.a.a
{
  private final d.c lOZ;
  private int lPa;
  private int lPb;
  private WindowManager.LayoutParams lPc;
  
  b(final o paramo, d.b paramb)
  {
    super(paramo, paramb);
    AppMethodBeat.i(193510);
    this.lOZ = new d.c()
    {
      public final void a(e.b paramAnonymousb)
      {
        AppMethodBeat.i(193509);
        paramo.aTy().a(paramAnonymousb, null);
        AppMethodBeat.o(193509);
      }
    };
    AppMethodBeat.o(193510);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(193511);
    Activity localActivity = com.tencent.mm.sdk.f.a.jg(((o)this.jgX).mContext);
    AppMethodBeat.o(193511);
    return localActivity;
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(193513);
    super.O(paramView, paramInt);
    paramView = getActivity();
    ViewGroup localViewGroup;
    if (paramView != null)
    {
      localViewGroup = (ViewGroup)paramView.getWindow().getDecorView();
      if (this.lOL == null) {
        this.lPa = localViewGroup.getSystemUiVisibility();
      }
      if (d.la(19))
      {
        localViewGroup.setSystemUiVisibility(2);
        if (this.lOL == null)
        {
          this.lPc = new WindowManager.LayoutParams();
          this.lPc.copyFrom(paramView.getWindow().getAttributes());
        }
        paramView.getWindow().addFlags(1024);
        if (Build.VERSION.SDK_INT >= 28) {
          paramView.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
        }
        if (this.lOL == null) {
          this.lPb = paramView.getRequestedOrientation();
        }
        rj(paramInt);
      }
    }
    for (;;)
    {
      bsF();
      this.lOL = null;
      AppMethodBeat.o(193513);
      return;
      localViewGroup.setSystemUiVisibility(4102);
      break;
      ac.e("Luggage.ActivityWindowFullscreenImpl", "enterFullscreen, get NULL activity");
      if (this.lOL == null)
      {
        this.lPb = -1;
        this.lPc = null;
        this.lPa = 0;
      }
    }
  }
  
  public final boolean aUJ()
  {
    AppMethodBeat.i(193514);
    boolean bool = this.lOM;
    if (super.aUJ())
    {
      Activity localActivity = getActivity();
      if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed())) {
        ac.e("Luggage.ActivityWindowFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localActivity });
      }
      for (;;)
      {
        bsG();
        AppMethodBeat.o(193514);
        return true;
        ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.lPa);
        localActivity.getWindow().clearFlags(1024);
        if (this.lPc != null) {
          localActivity.getWindow().setAttributes(this.lPc);
        }
        this.lOZ.a(e.b.uy(this.lPb));
      }
    }
    if (bool)
    {
      this.lOM = false;
      bsG();
      AppMethodBeat.o(193514);
      return true;
    }
    AppMethodBeat.o(193514);
    return false;
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(193512);
    this.lOM = true;
    switch (paramInt)
    {
    default: 
      this.lOZ.a(e.b.uy(9));
      AppMethodBeat.o(193512);
      return;
    case 90: 
      this.lOZ.a(e.b.uy(0));
      AppMethodBeat.o(193512);
      return;
    case -90: 
      this.lOZ.a(e.b.uy(8));
      AppMethodBeat.o(193512);
      return;
    }
    this.lOZ.a(e.b.uy(1));
    AppMethodBeat.o(193512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.b
 * JD-Core Version:    0.7.0.1
 */