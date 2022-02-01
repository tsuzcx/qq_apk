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
import com.tencent.mm.sdk.platformtools.ad;

final class b
  extends com.tencent.mm.plugin.appbrand.r.a.a
{
  private final d.c moP;
  private int moQ;
  private WindowManager.LayoutParams moR;
  
  b(final o paramo, d.b paramb)
  {
    super(paramo, paramb);
    AppMethodBeat.i(197430);
    this.moP = new d.c()
    {
      public final void a(e.b paramAnonymousb)
      {
        AppMethodBeat.i(197429);
        paramo.aWF().a(paramAnonymousb, null);
        AppMethodBeat.o(197429);
      }
    };
    AppMethodBeat.o(197430);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(197431);
    Activity localActivity = com.tencent.mm.sdk.f.a.jq(((o)this.jzX).mContext);
    AppMethodBeat.o(197431);
    return localActivity;
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(197433);
    super.O(paramView, paramInt);
    paramView = getActivity();
    ViewGroup localViewGroup;
    if (paramView != null)
    {
      localViewGroup = (ViewGroup)paramView.getWindow().getDecorView();
      if (this.moB == null) {
        this.moQ = localViewGroup.getSystemUiVisibility();
      }
      if (d.lz(19))
      {
        localViewGroup.setSystemUiVisibility(2);
        if (this.moB == null)
        {
          this.moR = new WindowManager.LayoutParams();
          this.moR.copyFrom(paramView.getWindow().getAttributes());
        }
        paramView.getWindow().addFlags(1024);
        if (Build.VERSION.SDK_INT >= 28) {
          paramView.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
        }
        rK(paramInt);
      }
    }
    for (;;)
    {
      bwJ();
      this.moB = null;
      AppMethodBeat.o(197433);
      return;
      localViewGroup.setSystemUiVisibility(4102);
      break;
      ad.e("Luggage.ActivityWindowFullscreenImpl", "enterFullscreen, get NULL activity");
      if (this.moB == null)
      {
        this.moR = null;
        this.moQ = 0;
      }
    }
  }
  
  public final boolean aXV()
  {
    AppMethodBeat.i(197434);
    boolean bool = this.moC;
    if (super.aXV())
    {
      Activity localActivity = getActivity();
      if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed())) {
        ad.e("Luggage.ActivityWindowFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localActivity });
      }
      for (;;)
      {
        bwK();
        AppMethodBeat.o(197434);
        return true;
        ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.moQ);
        localActivity.getWindow().clearFlags(1024);
        if (this.moR != null) {
          localActivity.getWindow().setAttributes(this.moR);
        }
        this.moP.a(e.b.vc(-1));
      }
    }
    if (bool)
    {
      this.moC = false;
      bwK();
      AppMethodBeat.o(197434);
      return true;
    }
    AppMethodBeat.o(197434);
    return false;
  }
  
  public final void rK(int paramInt)
  {
    AppMethodBeat.i(197432);
    this.moC = true;
    switch (paramInt)
    {
    default: 
      this.moP.a(e.b.vc(9));
      AppMethodBeat.o(197432);
      return;
    case 90: 
      this.moP.a(e.b.vc(0));
      AppMethodBeat.o(197432);
      return;
    case -90: 
      this.moP.a(e.b.vc(8));
      AppMethodBeat.o(197432);
      return;
    }
    this.moP.a(e.b.vc(1));
    AppMethodBeat.o(197432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.a.b
 * JD-Core Version:    0.7.0.1
 */