package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.luggage.h.a.b;
import com.tencent.luggage.h.a.c;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends LinearLayout
  implements g, h
{
  private Context context;
  private ImageView guM;
  private double guN = -1.0D;
  private double guO = -1.0D;
  private double guP = -1.0D;
  private double guQ = -1.0D;
  private float guR = 900.0F;
  private float guS = 900.0F;
  private float guT = 0.0F;
  private boolean guU;
  Marker guj;
  
  public d(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.guM = ((ImageView)View.inflate(this.context, a.c.default_tencent_map_location_point, this).findViewById(a.b.tp_location_point));
    this.guM.requestFocus();
  }
  
  private float getHeading()
  {
    if (this.guU) {
      return this.guR;
    }
    return this.guT;
  }
  
  public final void G(float paramFloat1, float paramFloat2)
  {
    this.guT = paramFloat2;
    paramFloat1 = getHeading();
    if (this.guj != null)
    {
      y.d("MicroMsg.AppbrandMapLocationPoint", "updateRotation rotation:%f", new Object[] { Float.valueOf(paramFloat1) });
      this.guj.setRotation(paramFloat1);
    }
  }
  
  public final void a(double paramDouble1, double paramDouble2, String paramString, double paramDouble3)
  {
    if ((this.guP == -1.0D) && (this.guQ == -1.0D))
    {
      this.guP = paramDouble1;
      this.guN = paramDouble1;
      this.guQ = paramDouble2;
      this.guO = paramDouble2;
      if ((this.guP != -1.0D) && (this.guQ != -1.0D)) {
        this.guU = e.a(this.guQ, this.guP, paramDouble2, paramDouble1, paramString, paramDouble3);
      }
      if ((this.guS != 900.0F) && (this.guR != 900.0F)) {
        break label180;
      }
      float f = (float)e.f(paramDouble1, paramDouble2);
      this.guR = f;
      this.guS = f;
    }
    for (;;)
    {
      if (this.guj != null) {
        this.guj.setPosition(new LatLng(paramDouble1, paramDouble2));
      }
      return;
      this.guP = this.guN;
      this.guQ = this.guO;
      this.guO = paramDouble2;
      this.guN = paramDouble1;
      break;
      label180:
      this.guS = this.guR;
      this.guR = ((float)e.f(paramDouble1, paramDouble2));
    }
  }
  
  public final double getLatitude()
  {
    return this.guN;
  }
  
  public final double getLongitude()
  {
    return this.guO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.d
 * JD-Core Version:    0.7.0.1
 */