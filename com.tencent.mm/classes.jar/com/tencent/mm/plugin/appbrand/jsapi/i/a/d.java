package com.tencent.mm.plugin.appbrand.jsapi.i.a;

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
  Marker kRu;
  private ImageView kSo;
  double kSp;
  double kSq;
  double kSr;
  double kSs;
  float kSt;
  float kSu;
  private float kSv;
  boolean kSw;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(146555);
    this.kSp = -1.0D;
    this.kSq = -1.0D;
    this.kSr = -1.0D;
    this.kSs = -1.0D;
    this.kSt = 900.0F;
    this.kSu = 900.0F;
    this.kSv = 0.0F;
    this.context = paramContext;
    this.kSo = ((ImageView)View.inflate(this.context, 2131493686, this).findViewById(2131306053));
    this.kSo.requestFocus();
    AppMethodBeat.o(146555);
  }
  
  private void aA(float paramFloat)
  {
    AppMethodBeat.i(146557);
    if (this.kRu != null)
    {
      ad.v("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", new Object[] { Float.valueOf(paramFloat) });
      this.kRu.setRotation(paramFloat);
    }
    AppMethodBeat.o(146557);
  }
  
  private float getHeading()
  {
    if (this.kSw) {
      return this.kSt;
    }
    return this.kSv;
  }
  
  public final void H(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(146556);
    this.kSv = paramFloat2;
    aA(getHeading());
    AppMethodBeat.o(146556);
  }
  
  public final double getLatitude()
  {
    return this.kSp;
  }
  
  public final double getLongitude()
  {
    return this.kSq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.d
 * JD-Core Version:    0.7.0.1
 */