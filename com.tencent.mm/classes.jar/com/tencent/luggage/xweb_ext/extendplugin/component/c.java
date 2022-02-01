package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.jsapi.w.b;
import com.tencent.mm.plugin.appbrand.jsapi.w.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.g;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c<OriginVideoContainer extends g, PipVideoContainer extends View>
  implements p<OriginVideoContainer, PipVideoContainer>
{
  private final a exC;
  
  protected c(a parama)
  {
    this.exC = parama;
  }
  
  public final b fP(final String paramString)
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
          public final b.a atC()
          {
            return paramString;
          }
          
          public final Boolean atD()
          {
            return this.exM;
          }
        };
        paramString = b.a.abu(paramString);
        break;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.AbsXWebPipInfoProvider#" + this.exC.getId(), paramString, "getPipExtra fail", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.c
 * JD-Core Version:    0.7.0.1
 */