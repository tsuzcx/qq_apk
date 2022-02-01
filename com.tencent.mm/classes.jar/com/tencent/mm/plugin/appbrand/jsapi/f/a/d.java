package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class d
  extends LinearLayout
  implements h
{
  private Context context;
  Marker kvx;
  private ImageView kwi;
  double kwj;
  double kwk;
  double kwl;
  double kwm;
  float kwn;
  float kwo;
  private float kwp;
  boolean kwq;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(146555);
    this.kwj = -1.0D;
    this.kwk = -1.0D;
    this.kwl = -1.0D;
    this.kwm = -1.0D;
    this.kwn = 900.0F;
    this.kwo = 900.0F;
    this.kwp = 0.0F;
    this.context = paramContext;
    this.kwi = ((ImageView)View.inflate(this.context, 2131493686, this).findViewById(2131306053));
    this.kwi.requestFocus();
    AppMethodBeat.o(146555);
  }
  
  private void ax(float paramFloat)
  {
    AppMethodBeat.i(146557);
    if (this.kvx != null)
    {
      ac.v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", new Object[] { Float.valueOf(paramFloat) });
      this.kvx.setRotation(paramFloat);
    }
    AppMethodBeat.o(146557);
  }
  
  private float getHeading()
  {
    if (this.kwq) {
      return this.kwn;
    }
    return this.kwp;
  }
  
  public final void G(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146556);
    this.kwp = paramFloat2;
    ax(getHeading());
    AppMethodBeat.o(146556);
  }
  
  public final double getLatitude()
  {
    return this.kwj;
  }
  
  public final double getLongitude()
  {
    return this.kwk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.d
 * JD-Core Version:    0.7.0.1
 */