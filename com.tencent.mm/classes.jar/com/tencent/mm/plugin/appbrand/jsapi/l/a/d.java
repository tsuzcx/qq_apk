package com.tencent.mm.plugin.appbrand.jsapi.l.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.luggage.h.a.b;
import com.tencent.luggage.h.a.c;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends LinearLayout
  implements h
{
  private Context context;
  private ImageView oYX;
  double oYY;
  double oYZ;
  Marker oYb;
  double oZa;
  double oZb;
  float oZc;
  float oZd;
  private float oZe;
  boolean oZf;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(146555);
    this.oYY = -1.0D;
    this.oYZ = -1.0D;
    this.oZa = -1.0D;
    this.oZb = -1.0D;
    this.oZc = 900.0F;
    this.oZd = 900.0F;
    this.oZe = 0.0F;
    this.context = paramContext;
    this.oYX = ((ImageView)View.inflate(this.context, a.c.default_tencent_map_location_point, this).findViewById(a.b.tp_location_point));
    this.oYX.requestFocus();
    AppMethodBeat.o(146555);
  }
  
  private void aK(float paramFloat)
  {
    AppMethodBeat.i(146557);
    if (this.oYb != null)
    {
      Log.v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", new Object[] { Float.valueOf(paramFloat) });
      this.oYb.setRotation(paramFloat);
    }
    AppMethodBeat.o(146557);
  }
  
  private float getHeading()
  {
    if (this.oZf) {
      return this.oZc;
    }
    return this.oZe;
  }
  
  public final void M(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146556);
    this.oZe = paramFloat2;
    aK(getHeading());
    AppMethodBeat.o(146556);
  }
  
  public final double getLatitude()
  {
    return this.oYY;
  }
  
  public final double getLongitude()
  {
    return this.oYZ;
  }
  
  public final Marker getRealMarker()
  {
    return this.oYb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a.d
 * JD-Core Version:    0.7.0.1
 */