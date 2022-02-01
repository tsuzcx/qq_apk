package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class k
  extends c<y>
{
  private static final int CTRL_INDEX = 120;
  private static final String NAME = "getImageInfo";
  private static final Collection<b> sgR;
  
  static
  {
    AppMethodBeat.i(139879);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new a((byte)0));
    localLinkedList.add(new d((byte)0));
    sgR = Collections.unmodifiableCollection(localLinkedList);
    AppMethodBeat.o(139879);
  }
  
  static final class a
    implements k.b
  {
    public final com.tencent.mm.vending.j.a j(AppBrandRuntime paramAppBrandRuntime, String paramString)
    {
      AppMethodBeat.i(139873);
      paramAppBrandRuntime = paramAppBrandRuntime.getFileSystem().Wm(paramString);
      if (paramAppBrandRuntime == null)
      {
        AppMethodBeat.o(139873);
        return null;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(ah.v(paramAppBrandRuntime.jKT()), localOptions);
      paramString = new k.c((byte)0);
      paramString.width = localOptions.outWidth;
      paramString.height = localOptions.outHeight;
      paramString.type = com.tencent.luggage.e.a.a.b(localOptions);
      if (com.tencent.luggage.e.a.a.a(localOptions)) {}
      for (paramAppBrandRuntime = com.tencent.luggage.e.a.a.mp(com.tencent.luggage.e.a.a.getExifOrientation(ah.v(paramAppBrandRuntime.jKT())));; paramAppBrandRuntime = "up")
      {
        paramString.euP = paramAppBrandRuntime;
        paramAppBrandRuntime = com.tencent.mm.vending.j.a.U(k.e.sgX, paramString);
        AppMethodBeat.o(139873);
        return paramAppBrandRuntime;
      }
    }
  }
  
  static abstract interface b
  {
    public abstract com.tencent.mm.vending.j.a j(AppBrandRuntime paramAppBrandRuntime, String paramString);
  }
  
  static final class c
  {
    public String euP;
    public int height;
    public String type;
    public int width;
  }
  
  static final class d
    implements k.b
  {
    public final com.tencent.mm.vending.j.a j(AppBrandRuntime paramAppBrandRuntime, String paramString)
    {
      AppMethodBeat.i(139874);
      paramString = bl.f(paramAppBrandRuntime, paramString);
      k.c localc;
      boolean bool;
      if (paramString != null)
      {
        paramString.mark(0);
        paramAppBrandRuntime = new BitmapFactory.Options();
        paramAppBrandRuntime.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(paramString, new Rect(), paramAppBrandRuntime);
        localc = new k.c((byte)0);
        localc.width = paramAppBrandRuntime.outWidth;
        localc.height = paramAppBrandRuntime.outHeight;
        localc.type = com.tencent.luggage.e.a.a.b(paramAppBrandRuntime);
        bool = com.tencent.luggage.e.a.a.a(paramAppBrandRuntime);
      }
      try
      {
        paramString.reset();
        label92:
        if (bool) {}
        for (paramAppBrandRuntime = com.tencent.luggage.e.a.a.mp(com.tencent.luggage.e.a.a.v(paramString));; paramAppBrandRuntime = "up")
        {
          localc.euP = paramAppBrandRuntime;
          Util.qualityClose(paramString);
          paramAppBrandRuntime = com.tencent.mm.vending.j.a.U(k.e.sgX, localc);
          AppMethodBeat.o(139874);
          return paramAppBrandRuntime;
        }
        paramAppBrandRuntime = com.tencent.mm.vending.j.a.gT(k.e.sgV);
        AppMethodBeat.o(139874);
        return paramAppBrandRuntime;
      }
      catch (IOException paramAppBrandRuntime)
      {
        break label92;
      }
    }
  }
  
  static enum e
  {
    static
    {
      AppMethodBeat.i(139877);
      sgV = new e("FILE_NOT_FOUND", 0);
      sgW = new e("UNKNOWN_FAIL", 1);
      sgX = new e("RESOLVED", 2);
      sgY = new e[] { sgV, sgW, sgX };
      AppMethodBeat.o(139877);
    }
    
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.k
 * JD-Core Version:    0.7.0.1
 */