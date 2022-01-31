package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends LinearLayout
  implements h
{
  private Context context;
  private ImageView hPH;
  double hPI;
  double hPJ;
  double hPK;
  double hPL;
  float hPM;
  float hPN;
  private float hPO;
  boolean hPP;
  Marker hPb;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51235);
    this.hPI = -1.0D;
    this.hPJ = -1.0D;
    this.hPK = -1.0D;
    this.hPL = -1.0D;
    this.hPM = 900.0F;
    this.hPN = 900.0F;
    this.hPO = 0.0F;
    this.context = paramContext;
    this.hPH = ((ImageView)View.inflate(this.context, 2130969298, this).findViewById(2131823362));
    this.hPH.requestFocus();
    AppMethodBeat.o(51235);
  }
  
  private void au(float paramFloat)
  {
    AppMethodBeat.i(51237);
    if (this.hPb != null)
    {
      ab.v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", new Object[] { Float.valueOf(paramFloat) });
      this.hPb.setRotation(paramFloat);
    }
    AppMethodBeat.o(51237);
  }
  
  private float getHeading()
  {
    if (this.hPP) {
      return this.hPM;
    }
    return this.hPO;
  }
  
  public final void N(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(51236);
    this.hPO = paramFloat2;
    au(getHeading());
    AppMethodBeat.o(51236);
  }
  
  public final double getLatitude()
  {
    return this.hPI;
  }
  
  public final double getLongitude()
  {
    return this.hPJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.d
 * JD-Core Version:    0.7.0.1
 */