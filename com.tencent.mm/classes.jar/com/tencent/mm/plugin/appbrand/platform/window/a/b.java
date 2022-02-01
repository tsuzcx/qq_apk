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
  private final d.c qGI;
  private int qGJ;
  private int qGK;
  private WindowManager.LayoutParams qGL;
  
  b(final o paramo, d.b paramb)
  {
    super(paramo, paramb);
    AppMethodBeat.i(243689);
    this.qGK = -1;
    this.qGI = new d.c()
    {
      public final void a(e.b paramAnonymousb)
      {
        AppMethodBeat.i(246482);
        paramo.che().a(paramAnonymousb, null);
        AppMethodBeat.o(246482);
      }
    };
    AppMethodBeat.o(243689);
  }
  
  private Activity getActivity()
  {
    AppMethodBeat.i(243690);
    Activity localActivity = AndroidContextUtil.castActivityOrNull(((o)this.nxr).mContext);
    AppMethodBeat.o(243690);
    return localActivity;
  }
  
  public final void O(View paramView, int paramInt)
  {
    AppMethodBeat.i(243693);
    super.O(paramView, paramInt);
    paramView = getActivity();
    ViewGroup localViewGroup;
    if (paramView != null)
    {
      localViewGroup = (ViewGroup)paramView.getWindow().getDecorView();
      if (this.qGr == null) {
        this.qGJ = localViewGroup.getSystemUiVisibility();
      }
      if (d.qW(19))
      {
        localViewGroup.setSystemUiVisibility(2);
        if (this.qGr == null)
        {
          this.qGL = new WindowManager.LayoutParams();
          this.qGL.copyFrom(paramView.getWindow().getAttributes());
        }
        paramView.getWindow().addFlags(1024);
        if (Build.VERSION.SDK_INT >= 28) {
          paramView.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
        }
        if (this.qGr == null) {
          this.qGK = paramView.getRequestedOrientation();
        }
        yS(paramInt);
      }
    }
    for (;;)
    {
      cgQ();
      this.qGr = null;
      AppMethodBeat.o(243693);
      return;
      localViewGroup.setSystemUiVisibility(4102);
      break;
      Log.e("Luggage.ActivityWindowFullscreenImpl", "enterFullscreen, get NULL activity");
      if (this.qGr == null)
      {
        this.qGK = -1;
        this.qGL = null;
        this.qGJ = 0;
      }
    }
  }
  
  public final boolean bEz()
  {
    AppMethodBeat.i(243695);
    boolean bool = this.qGs;
    if (super.bEz())
    {
      Activity localActivity = getActivity();
      if ((localActivity == null) || (localActivity.isFinishing()) || (localActivity.isDestroyed())) {
        Log.e("Luggage.ActivityWindowFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localActivity });
      }
      for (;;)
      {
        cgR();
        AppMethodBeat.o(243695);
        return true;
        ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.qGJ);
        localActivity.getWindow().clearFlags(1024);
        if (this.qGL != null) {
          localActivity.getWindow().setAttributes(this.qGL);
        }
        this.qGI.a(e.b.CE(this.qGK));
        this.qGK = -1;
      }
    }
    if (bool)
    {
      this.qGs = false;
      cgR();
      AppMethodBeat.o(243695);
      return true;
    }
    AppMethodBeat.o(243695);
    return false;
  }
  
  public final void yS(int paramInt)
  {
    AppMethodBeat.i(243691);
    this.qGs = true;
    switch (paramInt)
    {
    default: 
      this.qGI.a(e.b.CE(9));
      AppMethodBeat.o(243691);
      return;
    case 90: 
      this.qGI.a(e.b.CE(0));
      AppMethodBeat.o(243691);
      return;
    case -90: 
      this.qGI.a(e.b.CE(8));
      AppMethodBeat.o(243691);
      return;
    }
    this.qGI.a(e.b.CE(1));
    AppMethodBeat.o(243691);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.a.b
 * JD-Core Version:    0.7.0.1
 */