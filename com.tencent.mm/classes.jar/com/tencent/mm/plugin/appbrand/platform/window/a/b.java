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
  private final d.c tLu;
  private int tLv;
  private int tLw;
  private WindowManager.LayoutParams tLx;
  
  b(final o paramo, d.b paramb)
  {
    super(paramo, paramb);
    AppMethodBeat.i(317533);
    this.tLw = -1;
    this.tLu = new d.c()
    {
      public final void a(e.b paramAnonymousb)
      {
        AppMethodBeat.i(317525);
        paramo.cIb().a(paramAnonymousb, null);
        AppMethodBeat.o(317525);
      }
    };
    AppMethodBeat.o(317533);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(317536);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(((o)this.qwF).mContext);
    AppMethodBeat.o(317536);
    return localActivity;
  }
  
  public final void T(View paramView, int paramInt)
  {
    AppMethodBeat.i(317541);
    super.T(paramView, paramInt);
    paramView = getActivity();
    ViewGroup localViewGroup;
    if (paramView != null)
    {
      localViewGroup = (ViewGroup)paramView.getWindow().getDecorView();
      if (this.tLd == null) {
        this.tLv = localViewGroup.getSystemUiVisibility();
      }
      if (d.rc(19))
      {
        localViewGroup.setSystemUiVisibility(2);
        if (this.tLd == null)
        {
          this.tLx = new WindowManager.LayoutParams();
          this.tLx.copyFrom(paramView.getWindow().getAttributes());
        }
        paramView.getWindow().addFlags(1024);
        if (Build.VERSION.SDK_INT >= 28) {
          paramView.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
        }
        if (this.tLd == null) {
          this.tLw = paramView.getRequestedOrientation();
        }
        zb(paramInt);
      }
    }
    for (;;)
    {
      cHO();
      this.tLd = null;
      AppMethodBeat.o(317541);
      return;
      localViewGroup.setSystemUiVisibility(4102);
      break;
      Log.e("Luggage.ActivityWindowFullscreenImpl", "enterFullscreen, get NULL activity");
      if (this.tLd == null)
      {
        this.tLw = -1;
        this.tLx = null;
        this.tLv = 0;
      }
    }
  }
  
  public final boolean cdL()
  {
    AppMethodBeat.i(317545);
    boolean bool = this.tLe;
    if (super.cdL())
    {
      Activity localActivity = getActivity();
      if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed())) {
        Log.e("Luggage.ActivityWindowFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localActivity });
      }
      for (;;)
      {
        cHP();
        AppMethodBeat.o(317545);
        return true;
        ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.tLv);
        localActivity.getWindow().clearFlags(1024);
        if (this.tLx != null) {
          localActivity.getWindow().setAttributes(this.tLx);
        }
        this.tLu.a(e.b.CV(this.tLw));
        this.tLw = -1;
      }
    }
    if (bool)
    {
      this.tLe = false;
      cHP();
      AppMethodBeat.o(317545);
      return true;
    }
    AppMethodBeat.o(317545);
    return false;
  }
  
  public final void zb(int paramInt)
  {
    AppMethodBeat.i(317538);
    this.tLe = true;
    switch (paramInt)
    {
    default: 
      this.tLu.a(e.b.CV(9));
      AppMethodBeat.o(317538);
      return;
    case 90: 
      this.tLu.a(e.b.CV(0));
      AppMethodBeat.o(317538);
      return;
    case -90: 
      this.tLu.a(e.b.CV(8));
      AppMethodBeat.o(317538);
      return;
    }
    this.tLu.a(e.b.CV(1));
    AppMethodBeat.o(317538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.b
 * JD-Core Version:    0.7.0.1
 */