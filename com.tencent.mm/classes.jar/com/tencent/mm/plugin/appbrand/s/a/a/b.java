package com.tencent.mm.plugin.appbrand.s.a.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.s.a.d.b;
import com.tencent.mm.plugin.appbrand.s.a.d.c;
import com.tencent.mm.plugin.appbrand.s.a.e.b;
import com.tencent.mm.sdk.platformtools.ad;

final class b
  extends com.tencent.mm.plugin.appbrand.s.a.a
{
  private final d.c lmX;
  private int lmY;
  private int lmZ;
  private WindowManager.LayoutParams lna;
  
  b(final o paramo, d.b paramb)
  {
    super(paramo, paramb);
    AppMethodBeat.i(194520);
    this.lmX = new d.c()
    {
      public final void a(e.b paramAnonymousb)
      {
        AppMethodBeat.i(194519);
        paramo.aMI().a(paramAnonymousb, null);
        AppMethodBeat.o(194519);
      }
    };
    AppMethodBeat.o(194520);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(194521);
    Activity localActivity = com.tencent.mm.sdk.f.a.iV(((o)this.iGU).mContext);
    AppMethodBeat.o(194521);
    return localActivity;
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(194523);
    super.O(paramView, paramInt);
    paramView = getActivity();
    ViewGroup localViewGroup;
    if (paramView != null)
    {
      localViewGroup = (ViewGroup)paramView.getWindow().getDecorView();
      if (this.lmJ == null) {
        this.lmY = localViewGroup.getSystemUiVisibility();
      }
      if (d.lg(19))
      {
        localViewGroup.setSystemUiVisibility(2);
        if (this.lmJ == null)
        {
          this.lna = new WindowManager.LayoutParams();
          this.lna.copyFrom(paramView.getWindow().getAttributes());
        }
        paramView.getWindow().addFlags(1024);
        if (Build.VERSION.SDK_INT >= 28) {
          paramView.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
        }
        if (this.lmJ == null) {
          this.lmZ = paramView.getRequestedOrientation();
        }
        qw(paramInt);
      }
    }
    for (;;)
    {
      blJ();
      this.lmJ = null;
      AppMethodBeat.o(194523);
      return;
      localViewGroup.setSystemUiVisibility(4102);
      break;
      ad.e("Luggage.ActivityWindowFullscreenImpl", "enterFullscreen, get NULL activity");
      if (this.lmJ == null)
      {
        this.lmZ = -1;
        this.lna = null;
        this.lmY = 0;
      }
    }
  }
  
  public final boolean aNT()
  {
    AppMethodBeat.i(194524);
    boolean bool = this.lmK;
    if (super.aNT())
    {
      Activity localActivity = getActivity();
      if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed())) {
        ad.e("Luggage.ActivityWindowFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localActivity });
      }
      for (;;)
      {
        blK();
        AppMethodBeat.o(194524);
        return true;
        ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.lmY);
        localActivity.getWindow().clearFlags(1024);
        if (this.lna != null) {
          localActivity.getWindow().setAttributes(this.lna);
        }
        this.lmX.a(e.b.tG(this.lmZ));
      }
    }
    if (bool)
    {
      this.lmK = false;
      blK();
      AppMethodBeat.o(194524);
      return true;
    }
    AppMethodBeat.o(194524);
    return false;
  }
  
  public final void qw(int paramInt)
  {
    AppMethodBeat.i(194522);
    this.lmK = true;
    switch (paramInt)
    {
    default: 
      this.lmX.a(e.b.tG(9));
      AppMethodBeat.o(194522);
      return;
    case 90: 
      this.lmX.a(e.b.tG(0));
      AppMethodBeat.o(194522);
      return;
    case -90: 
      this.lmX.a(e.b.tG(8));
      AppMethodBeat.o(194522);
      return;
    }
    this.lmX.a(e.b.tG(1));
    AppMethodBeat.o(194522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.a.b
 * JD-Core Version:    0.7.0.1
 */