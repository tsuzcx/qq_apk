package com.tencent.luggage.k.a.a;

import android.view.View;
import com.tencent.luggage.k.a.b.a;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.jsapi.n.b;
import com.tencent.mm.plugin.appbrand.jsapi.n.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.g;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class c<OriginVideoContainer extends g, PipVideoContainer extends View>
  implements l<OriginVideoContainer, PipVideoContainer>
{
  private final a cgz;
  
  protected c(a parama)
  {
    this.cgz = parama;
  }
  
  public final b ct(final String paramString)
  {
    try
    {
      Object localObject = new i(paramString);
      paramString = ((i)localObject).optString("pictureInPictureMode", null);
      if (paramString == null)
      {
        paramString = null;
        if (!((i)localObject).has("pictureInPictureShowProgress")) {
          break label62;
        }
      }
      label62:
      for (localObject = Boolean.valueOf(((i)localObject).optBoolean("pictureInPictureShowProgress", false));; localObject = null)
      {
        new b()
        {
          public final b.a Ei()
          {
            return paramString;
          }
          
          public final Boolean Ej()
          {
            return this.cgJ;
          }
        };
        paramString = b.a.MW(paramString);
        break;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ac.printErrStackTrace("MicroMsg.AppBrand.AbsXWebPipInfoProvider#" + this.cgz.getId(), paramString, "getPipExtra fail", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.a.c
 * JD-Core Version:    0.7.0.1
 */