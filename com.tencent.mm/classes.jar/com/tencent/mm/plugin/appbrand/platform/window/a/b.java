package com.tencent.mm.plugin.appbrand.platform.window.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.platform.window.a;
import com.tencent.mm.plugin.appbrand.platform.window.d.b;
import com.tencent.mm.plugin.appbrand.platform.window.d.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

final class b
  extends a
{
  private int nEA;
  private WindowManager.LayoutParams nEB;
  private final d.c nEy;
  private int nEz;
  
  b(final o paramo, d.b paramb)
  {
    super(paramo, paramb);
    AppMethodBeat.i(219575);
    this.nEA = -1;
    this.nEy = new d.c()
    {
      public final void a(e.b paramAnonymousb)
      {
        AppMethodBeat.i(219574);
        paramo.bTY().a(paramAnonymousb, null);
        AppMethodBeat.o(219574);
      }
    };
    AppMethodBeat.o(219575);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(219576);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(((o)this.kEb).mContext);
    AppMethodBeat.o(219576);
    return localActivity;
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(219578);
    super.N(paramView, paramInt);
    paramView = getActivity();
    ViewGroup localViewGroup;
    if (paramView != null)
    {
      localViewGroup = (ViewGroup)paramView.getWindow().getDecorView();
      if (this.nEh == null) {
        this.nEz = localViewGroup.getSystemUiVisibility();
      }
      if (d.oE(19))
      {
        localViewGroup.setSystemUiVisibility(2);
        if (this.nEh == null)
        {
          this.nEB = new WindowManager.LayoutParams();
          this.nEB.copyFrom(paramView.getWindow().getAttributes());
        }
        paramView.getWindow().addFlags(1024);
        if (Build.VERSION.SDK_INT >= 28) {
          paramView.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
        }
        if (this.nEh == null) {
          this.nEA = paramView.getRequestedOrientation();
        }
        vH(paramInt);
      }
    }
    for (;;)
    {
      bTL();
      this.nEh = null;
      AppMethodBeat.o(219578);
      return;
      localViewGroup.setSystemUiVisibility(4102);
      break;
      Log.e("Luggage.ActivityWindowFullscreenImpl", "enterFullscreen, get NULL activity");
      if (this.nEh == null)
      {
        this.nEA = -1;
        this.nEB = null;
        this.nEz = 0;
      }
    }
  }
  
  public final boolean btC()
  {
    AppMethodBeat.i(219579);
    boolean bool = this.nEi;
    if (super.btC())
    {
      Activity localActivity = getActivity();
      if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed())) {
        Log.e("Luggage.ActivityWindowFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localActivity });
      }
      for (;;)
      {
        bTM();
        AppMethodBeat.o(219579);
        return true;
        ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.nEz);
        localActivity.getWindow().clearFlags(1024);
        if (this.nEB != null) {
          localActivity.getWindow().setAttributes(this.nEB);
        }
        this.nEy.a(e.b.yZ(this.nEA));
        this.nEA = -1;
      }
    }
    if (bool)
    {
      this.nEi = false;
      bTM();
      AppMethodBeat.o(219579);
      return true;
    }
    AppMethodBeat.o(219579);
    return false;
  }
  
  public final void vH(int paramInt)
  {
    AppMethodBeat.i(219577);
    this.nEi = true;
    switch (paramInt)
    {
    default: 
      this.nEy.a(e.b.yZ(9));
      AppMethodBeat.o(219577);
      return;
    case 90: 
      this.nEy.a(e.b.yZ(0));
      AppMethodBeat.o(219577);
      return;
    case -90: 
      this.nEy.a(e.b.yZ(8));
      AppMethodBeat.o(219577);
      return;
    }
    this.nEy.a(e.b.yZ(1));
    AppMethodBeat.o(219577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.b
 * JD-Core Version:    0.7.0.1
 */