package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.luggage.i.a.b;
import com.tencent.luggage.i.a.c;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends LinearLayout
  implements h
{
  private Context context;
  Marker sdB;
  double seA;
  double seB;
  double seC;
  double seD;
  float seE;
  float seF;
  private float seG;
  boolean seH;
  private ImageView sez;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(146555);
    this.seA = -1.0D;
    this.seB = -1.0D;
    this.seC = -1.0D;
    this.seD = -1.0D;
    this.seE = 900.0F;
    this.seF = 900.0F;
    this.seG = 0.0F;
    this.context = paramContext;
    this.sez = ((ImageView)View.inflate(this.context, a.c.default_tencent_map_location_point, this).findViewById(a.b.tp_location_point));
    this.sez.requestFocus();
    AppMethodBeat.o(146555);
  }
  
  private void bI(float paramFloat)
  {
    AppMethodBeat.i(146557);
    if (this.sdB != null)
    {
      Log.v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", new Object[] { Float.valueOf(paramFloat) });
      this.sdB.setRotation(paramFloat);
    }
    AppMethodBeat.o(146557);
  }
  
  private float getHeading()
  {
    if (this.seH) {
      return this.seE;
    }
    return this.seG;
  }
  
  public final void aq(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146556);
    this.seG = paramFloat2;
    bI(getHeading());
    AppMethodBeat.o(146556);
  }
  
  public final double getLatitude()
  {
    return this.seA;
  }
  
  public final double getLongitude()
  {
    return this.seB;
  }
  
  public final Marker getRealMarker()
  {
    return this.sdB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.d
 * JD-Core Version:    0.7.0.1
 */