package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.jsapi.q.b;
import com.tencent.mm.plugin.appbrand.jsapi.q.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class c<OriginVideoContainer extends g, PipVideoContainer extends View>
  implements p<OriginVideoContainer, PipVideoContainer>
{
  private final a cru;
  
  protected c(a parama)
  {
    this.cru = parama;
  }
  
  public final b dx(final String paramString)
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
          public final b.a FO()
          {
            return paramString;
          }
          
          public final Boolean FP()
          {
            return this.crE;
          }
        };
        paramString = b.a.Rc(paramString);
        break;
      }
      return null;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.AppBrand.AbsXWebPipInfoProvider#" + this.cru.getId(), paramString, "getPipExtra fail", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.c
 * JD-Core Version:    0.7.0.1
 */