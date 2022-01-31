package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.ah;

final class MyLocationButton$1
  implements a.a
{
  MyLocationButton$1(MyLocationButton paramMyLocationButton) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return false;
    }
    MyLocationButton.a(this.lEW).setVisibility(8);
    MyLocationButton.b(this.lEW).setVisibility(0);
    if ((MyLocationButton.c(this.lEW) != null) && (MyLocationButton.d(this.lEW)))
    {
      MyLocationButton.c(this.lEW).getIController().setCenter(paramFloat2, paramFloat1);
      if (MyLocationButton.c(this.lEW).getZoomLevel() < 16) {
        MyLocationButton.c(this.lEW).getIController().setZoom(16);
      }
    }
    new ah(Looper.getMainLooper()).post(new MyLocationButton.1.1(this));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.MyLocationButton.1
 * JD-Core Version:    0.7.0.1
 */