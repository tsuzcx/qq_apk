package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class d
  extends LinearLayout
  implements h
{
  private Context context;
  private ImageView kVX;
  double kVY;
  double kVZ;
  Marker kVc;
  double kWa;
  double kWb;
  float kWc;
  float kWd;
  private float kWe;
  boolean kWf;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(146555);
    this.kVY = -1.0D;
    this.kVZ = -1.0D;
    this.kWa = -1.0D;
    this.kWb = -1.0D;
    this.kWc = 900.0F;
    this.kWd = 900.0F;
    this.kWe = 0.0F;
    this.context = paramContext;
    this.kVX = ((ImageView)View.inflate(this.context, 2131493686, this).findViewById(2131306053));
    this.kVX.requestFocus();
    AppMethodBeat.o(146555);
  }
  
  private void aA(float paramFloat)
  {
    AppMethodBeat.i(146557);
    if (this.kVc != null)
    {
      ae.v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", new Object[] { Float.valueOf(paramFloat) });
      this.kVc.setRotation(paramFloat);
    }
    AppMethodBeat.o(146557);
  }
  
  private float getHeading()
  {
    if (this.kWf) {
      return this.kWc;
    }
    return this.kWe;
  }
  
  public final void H(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146556);
    this.kWe = paramFloat2;
    aA(getHeading());
    AppMethodBeat.o(146556);
  }
  
  public final double getLatitude()
  {
    return this.kVY;
  }
  
  public final double getLongitude()
  {
    return this.kVZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.d
 * JD-Core Version:    0.7.0.1
 */