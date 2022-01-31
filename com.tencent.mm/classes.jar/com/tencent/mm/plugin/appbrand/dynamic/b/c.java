package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.model.u.b;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.e.a;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;

final class c
  implements e
{
  public final Bitmap a(d paramd, String paramString)
  {
    return a(paramd, paramString, null);
  }
  
  public final Bitmap a(final d paramd, final String paramString, final Rect paramRect, final e.a parama)
  {
    paramRect = paramd.dIV.getString("id", "");
    if (paramString.startsWith("wxfile://"))
    {
      paramd = AppBrandLocalMediaObjectManager.getItemByLocalId(paramRect, paramString);
      if ((paramd == null) || (TextUtils.isEmpty(paramd.dXY))) {
        return null;
      }
      paramString = paramd.dXY;
      paramd = paramString;
      if (!paramString.startsWith("file://")) {
        paramd = "file://" + paramString;
      }
      return b.JD().a(paramd, null);
    }
    Bitmap localBitmap;
    if ((paramString.startsWith("https://")) || (paramString.startsWith("http://")))
    {
      localBitmap = b.JD().a(paramString, null);
      if (localBitmap == null)
      {
        b.JD().a(new b.h()
        {
          public final void JG() {}
          
          public final void JH()
          {
            Bundle localBundle = new Bundle();
            localBundle.putString("id", paramRect);
            localBundle.putInt("widgetState", 2103);
            f.a(i.aeX().sX(paramRect), localBundle, f.a.class, null);
          }
          
          public final void p(Bitmap paramAnonymousBitmap)
          {
            if ((parama == null) || (paramAnonymousBitmap == null) || (paramAnonymousBitmap.isRecycled())) {
              return;
            }
            parama.a(paramd);
          }
          
          public final String pU()
          {
            return "WxaWidgetIcon";
          }
        }, paramString, null, null);
        return localBitmap;
      }
    }
    else
    {
      return a.bo(paramRect, paramString);
    }
    return localBitmap;
  }
  
  public final Bitmap a(d paramd, String paramString, e.a parama)
  {
    return a(paramd, paramString, null, parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.b.c
 * JD-Core Version:    0.7.0.1
 */