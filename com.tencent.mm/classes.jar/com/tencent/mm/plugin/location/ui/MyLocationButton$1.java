package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ak;

final class MyLocationButton$1
  implements b.a
{
  MyLocationButton$1(MyLocationButton paramMyLocationButton) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(113448);
    if (!paramBoolean)
    {
      AppMethodBeat.o(113448);
      return false;
    }
    MyLocationButton.a(this.ock).setVisibility(8);
    MyLocationButton.b(this.ock).setVisibility(0);
    if ((MyLocationButton.c(this.ock) != null) && (MyLocationButton.d(this.ock)))
    {
      MyLocationButton.c(this.ock).getIController().setCenter(paramFloat2, paramFloat1);
      if (MyLocationButton.c(this.ock).getZoomLevel() < 16) {
        MyLocationButton.c(this.ock).getIController().setZoom(16);
      }
    }
    new ak(Looper.getMainLooper()).post(new MyLocationButton.1.1(this));
    AppMethodBeat.o(113448);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.MyLocationButton.1
 * JD-Core Version:    0.7.0.1
 */