package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class d
  extends LinearLayout
  implements h
{
  private Context context;
  Marker jUM;
  double jVA;
  float jVB;
  float jVC;
  private float jVD;
  boolean jVE;
  private ImageView jVw;
  double jVx;
  double jVy;
  double jVz;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(146555);
    this.jVx = -1.0D;
    this.jVy = -1.0D;
    this.jVz = -1.0D;
    this.jVA = -1.0D;
    this.jVB = 900.0F;
    this.jVC = 900.0F;
    this.jVD = 0.0F;
    this.context = paramContext;
    this.jVw = ((ImageView)View.inflate(this.context, 2131493686, this).findViewById(2131306053));
    this.jVw.requestFocus();
    AppMethodBeat.o(146555);
  }
  
  private void at(float paramFloat)
  {
    AppMethodBeat.i(146557);
    if (this.jUM != null)
    {
      ad.v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", new Object[] { Float.valueOf(paramFloat) });
      this.jUM.setRotation(paramFloat);
    }
    AppMethodBeat.o(146557);
  }
  
  private float getHeading()
  {
    if (this.jVE) {
      return this.jVB;
    }
    return this.jVD;
  }
  
  public final void D(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146556);
    this.jVD = paramFloat2;
    at(getHeading());
    AppMethodBeat.o(146556);
  }
  
  public final double getLatitude()
  {
    return this.jVx;
  }
  
  public final double getLongitude()
  {
    return this.jVy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.d
 * JD-Core Version:    0.7.0.1
 */