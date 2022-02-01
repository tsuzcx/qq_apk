package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class j
  extends c<v>
{
  private static final int CTRL_INDEX = 120;
  private static final String NAME = "getImageInfo";
  private static final Collection<b> pbD;
  
  static
  {
    AppMethodBeat.i(139879);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new a((byte)0));
    localLinkedList.add(new d((byte)0));
    pbD = Collections.unmodifiableCollection(localLinkedList);
    AppMethodBeat.o(139879);
  }
  
  static final class a
    implements j.b
  {
    public final com.tencent.mm.vending.j.a j(AppBrandRuntime paramAppBrandRuntime, String paramString)
    {
      AppMethodBeat.i(139873);
      paramAppBrandRuntime = paramAppBrandRuntime.getFileSystem().adL(paramString);
      if (paramAppBrandRuntime == null)
      {
        AppMethodBeat.o(139873);
        return null;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramAppBrandRuntime.bOF(), localOptions);
      paramString = new j.c((byte)0);
      paramString.width = localOptions.outWidth;
      paramString.height = localOptions.outHeight;
      paramString.type = com.tencent.luggage.e.a.a.b(localOptions);
      if (com.tencent.luggage.e.a.a.a(localOptions)) {}
      for (paramAppBrandRuntime = com.tencent.luggage.e.a.a.iN(com.tencent.luggage.e.a.a.getExifOrientation(paramAppBrandRuntime.bOF()));; paramAppBrandRuntime = "up")
      {
        paramString.cCi = paramAppBrandRuntime;
        paramAppBrandRuntime = com.tencent.mm.vending.j.a.J(j.e.pbJ, paramString);
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
    public String cCi;
    public int height;
    public String type;
    public int width;
  }
  
  static final class d
    implements j.b
  {
    public final com.tencent.mm.vending.j.a j(AppBrandRuntime paramAppBrandRuntime, String paramString)
    {
      AppMethodBeat.i(139874);
      paramString = bl.f(paramAppBrandRuntime, paramString);
      j.c localc;
      boolean bool;
      if (paramString != null)
      {
        paramString.mark(0);
        paramAppBrandRuntime = new BitmapFactory.Options();
        paramAppBrandRuntime.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(paramString, new Rect(), paramAppBrandRuntime);
        localc = new j.c((byte)0);
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
        for (paramAppBrandRuntime = com.tencent.luggage.e.a.a.iN(com.tencent.luggage.e.a.a.k(paramString));; paramAppBrandRuntime = "up")
        {
          localc.cCi = paramAppBrandRuntime;
          Util.qualityClose(paramString);
          paramAppBrandRuntime = com.tencent.mm.vending.j.a.J(j.e.pbJ, localc);
          AppMethodBeat.o(139874);
          return paramAppBrandRuntime;
        }
        paramAppBrandRuntime = com.tencent.mm.vending.j.a.ev(j.e.pbH);
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
      pbH = new e("FILE_NOT_FOUND", 0);
      pbI = new e("UNKNOWN_FAIL", 1);
      pbJ = new e("RESOLVED", 2);
      pbK = new e[] { pbH, pbI, pbJ };
      AppMethodBeat.o(139877);
    }
    
    private e() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.j
 * JD-Core Version:    0.7.0.1
 */