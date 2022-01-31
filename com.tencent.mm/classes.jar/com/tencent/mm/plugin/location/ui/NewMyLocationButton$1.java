package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.plugin.k.b;
import com.tencent.mm.plugin.k.d;
import com.tencent.mm.sdk.platformtools.ak;

final class NewMyLocationButton$1
  implements b.a
{
  NewMyLocationButton$1(NewMyLocationButton paramNewMyLocationButton) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    AppMethodBeat.i(113462);
    if (!paramBoolean)
    {
      AppMethodBeat.o(113462);
      return false;
    }
    NewMyLocationButton.a(this.ocE).setVisibility(8);
    NewMyLocationButton.b(this.ocE).setVisibility(0);
    if ((NewMyLocationButton.c(this.ocE) != null) && (NewMyLocationButton.d(this.ocE)))
    {
      NewMyLocationButton.c(this.ocE).getIController().setCenter(paramFloat2, paramFloat1);
      if (NewMyLocationButton.c(this.ocE).getZoomLevel() < 16) {
        NewMyLocationButton.c(this.ocE).getIController().setZoom(16);
      }
    }
    new ak(Looper.getMainLooper()).post(new NewMyLocationButton.1.1(this));
    AppMethodBeat.o(113462);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.NewMyLocationButton.1
 * JD-Core Version:    0.7.0.1
 */