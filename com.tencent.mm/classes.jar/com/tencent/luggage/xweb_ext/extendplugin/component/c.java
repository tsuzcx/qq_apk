package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.mm.ad.i;
import com.tencent.mm.plugin.appbrand.jsapi.t.b;
import com.tencent.mm.plugin.appbrand.jsapi.t.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c<OriginVideoContainer extends g, PipVideoContainer extends View>
  implements p<OriginVideoContainer, PipVideoContainer>
{
  private final a cEr;
  
  protected c(a parama)
  {
    this.cEr = parama;
  }
  
  public final b es(final String paramString)
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
          public final b.a SX()
          {
            return paramString;
          }
          
          public final Boolean SY()
          {
            return this.cEB;
          }
        };
        paramString = b.a.aiw(paramString);
        break;
      }
      return null;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.AbsXWebPipInfoProvider#" + this.cEr.getId(), paramString, "getPipExtra fail", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.c
 * JD-Core Version:    0.7.0.1
 */