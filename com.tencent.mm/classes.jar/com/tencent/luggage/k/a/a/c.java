package com.tencent.luggage.k.a.a;

import android.view.View;
import com.tencent.luggage.k.a.b.a;
import com.tencent.mm.ac.i;
import com.tencent.mm.plugin.appbrand.jsapi.o.b;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.h;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class c<OriginVideoContainer extends h, PipVideoContainer extends View>
  implements o<OriginVideoContainer, PipVideoContainer>
{
  private final a cjD;
  
  protected c(a parama)
  {
    this.cjD = parama;
  }
  
  public final b cE(final String paramString)
  {
    try
    {
      paramString = new i(paramString);
      final b.a locala = com.tencent.mm.plugin.appbrand.jsapi.o.c.a(paramString);
      if (paramString.has("pictureInPictureShowProgress")) {}
      for (paramString = Boolean.valueOf(paramString.optBoolean("pictureInPictureShowProgress", false));; paramString = null)
      {
        paramString = new b()
        {
          public final b.a EG()
          {
            return locala;
          }
          
          public final Boolean EH()
          {
            return paramString;
          }
        };
        return paramString;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.AppBrand.AbsXWebPipInfoProvider#" + this.cjD.getId(), paramString, "getPipExtra fail", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.c
 * JD-Core Version:    0.7.0.1
 */