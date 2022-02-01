package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
  extends LinearLayout
  implements h
{
  private Context context;
  Marker maj;
  private ImageView mbg;
  double mbh;
  double mbi;
  double mbj;
  double mbk;
  float mbl;
  float mbm;
  private float mbn;
  boolean mbo;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(146555);
    this.mbh = -1.0D;
    this.mbi = -1.0D;
    this.mbj = -1.0D;
    this.mbk = -1.0D;
    this.mbl = 900.0F;
    this.mbm = 900.0F;
    this.mbn = 0.0F;
    this.context = paramContext;
    this.mbg = ((ImageView)View.inflate(this.context, 2131493817, this).findViewById(2131309376));
    this.mbg.requestFocus();
    AppMethodBeat.o(146555);
  }
  
  private void aK(float paramFloat)
  {
    AppMethodBeat.i(146557);
    if (this.maj != null)
    {
      Log.v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", new Object[] { Float.valueOf(paramFloat) });
      this.maj.setRotation(paramFloat);
    }
    AppMethodBeat.o(146557);
  }
  
  private float getHeading()
  {
    if (this.mbo) {
      return this.mbl;
    }
    return this.mbn;
  }
  
  public final void L(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146556);
    this.mbn = paramFloat2;
    aK(getHeading());
    AppMethodBeat.o(146556);
  }
  
  public final double getLatitude()
  {
    return this.mbh;
  }
  
  public final double getLongitude()
  {
    return this.mbi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.a.d
 * JD-Core Version:    0.7.0.1
 */