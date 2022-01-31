package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.ah;

final class NewMyLocationButton$1
  implements a.a
{
  NewMyLocationButton$1(NewMyLocationButton paramNewMyLocationButton) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return false;
    }
    NewMyLocationButton.a(this.lFr).setVisibility(8);
    NewMyLocationButton.b(this.lFr).setVisibility(0);
    if ((NewMyLocationButton.c(this.lFr) != null) && (NewMyLocationButton.d(this.lFr)))
    {
      NewMyLocationButton.c(this.lFr).getIController().setCenter(paramFloat2, paramFloat1);
      if (NewMyLocationButton.c(this.lFr).getZoomLevel() < 16) {
        NewMyLocationButton.c(this.lFr).getIController().setZoom(16);
      }
    }
    new ah(Looper.getMainLooper()).post(new NewMyLocationButton.1.1(this));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.NewMyLocationButton.1
 * JD-Core Version:    0.7.0.1
 */