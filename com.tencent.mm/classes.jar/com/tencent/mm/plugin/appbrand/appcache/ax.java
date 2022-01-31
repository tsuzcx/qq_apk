package com.tencent.mm.plugin.appbrand.appcache;

import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.IWxaFileSystemWithModularizing;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class ax
{
  private static final Map<i, ax> gWM;
  private static final ax gWN;
  private final u gWO;
  private final LinkedList<o> gWP;
  private final String mAppId;
  
  static
  {
    AppMethodBeat.i(86830);
    gWM = new HashMap();
    gWN = new ax.1();
    AppMethodBeat.o(86830);
  }
  
  private ax(final i parami)
  {
    AppMethodBeat.i(86825);
    this.gWP = new LinkedList();
    if (parami == null)
    {
      this.gWO = null;
      this.mAppId = null;
      AppMethodBeat.o(86825);
      return;
    }
    this.mAppId = parami.mAppId;
    this.gWO = new u(parami.wY().hiX);
    this.gWO.avC();
    e.a(this.mAppId, new e.c()
    {
      public final void onDestroy()
      {
        AppMethodBeat.i(86811);
        e.b(ax.a(ax.this), this);
        synchronized (ax.awf())
        {
          ax.awf().remove(parami);
          ax.b(ax.this);
          AppMethodBeat.o(86811);
          return;
        }
      }
    });
    AppMethodBeat.o(86825);
  }
  
  public static void a(i arg0, o paramo)
  {
    AppMethodBeat.i(86823);
    ax localax = r(???);
    synchronized (localax.gWP)
    {
      paramo.init();
      localax.gWP.addFirst(paramo);
      AppMethodBeat.o(86823);
      return;
    }
  }
  
  public static String c(i parami, String paramString)
  {
    AppMethodBeat.i(86818);
    parami = bo.nullAsNil((String)r(parami).e(paramString, String.class));
    AppMethodBeat.o(86818);
    return parami;
  }
  
  public static boolean d(i parami, String paramString)
  {
    AppMethodBeat.i(86819);
    parami = f(parami, paramString);
    if (parami != null)
    {
      bo.b(parami);
      AppMethodBeat.o(86819);
      return true;
    }
    AppMethodBeat.o(86819);
    return false;
  }
  
  public static WebResourceResponse e(i parami, String paramString)
  {
    AppMethodBeat.i(86820);
    parami = (WebResourceResponse)r(parami).e(paramString, WebResourceResponse.class);
    AppMethodBeat.o(86820);
    return parami;
  }
  
  public static InputStream f(i parami, String paramString)
  {
    AppMethodBeat.i(86821);
    parami = (InputStream)r(parami).e(paramString, InputStream.class);
    AppMethodBeat.o(86821);
    return parami;
  }
  
  public static String g(i parami, String paramString)
  {
    AppMethodBeat.i(86822);
    if (yC(paramString))
    {
      AppMethodBeat.o(86822);
      return null;
    }
    parami = parami.wX();
    if ((parami instanceof t))
    {
      parami = ((IWxaFileSystemWithModularizing)((t)parami).Y(IWxaFileSystemWithModularizing.class)).findAppropriateModuleInfo(paramString);
      if (parami != null)
      {
        parami = w.a(parami, paramString);
        AppMethodBeat.o(86822);
        return parami;
      }
    }
    AppMethodBeat.o(86822);
    return null;
  }
  
  public static void p(i parami)
  {
    AppMethodBeat.i(86816);
    parami = r(parami);
    if ((parami != null) && (parami.gWO != null)) {
      parami.gWO.avC();
    }
    AppMethodBeat.o(86816);
  }
  
  public static u q(i parami)
  {
    AppMethodBeat.i(86817);
    parami = r(parami).gWO;
    AppMethodBeat.o(86817);
    return parami;
  }
  
  private static ax r(i parami)
  {
    AppMethodBeat.i(86824);
    if ((parami == null) || (parami.mFinished))
    {
      parami = gWN;
      AppMethodBeat.o(86824);
      return parami;
    }
    synchronized (gWM)
    {
      ax localax2 = (ax)gWM.get(parami);
      ax localax1 = localax2;
      if (localax2 == null)
      {
        localax1 = new ax(parami);
        gWM.put(parami, localax1);
      }
      AppMethodBeat.o(86824);
      return localax1;
    }
  }
  
  private static boolean yC(String paramString)
  {
    AppMethodBeat.i(86827);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(86827);
      return true;
    }
    if (com.tencent.luggage.g.h.x(paramString, "about:blank"))
    {
      AppMethodBeat.o(86827);
      return true;
    }
    if (d.Fl(paramString))
    {
      AppMethodBeat.o(86827);
      return true;
    }
    if (URLUtil.isFileUrl(paramString))
    {
      AppMethodBeat.o(86827);
      return true;
    }
    AppMethodBeat.o(86827);
    return false;
  }
  
  private InputStream yD(String paramString)
  {
    AppMethodBeat.i(86828);
    synchronized (this.gWP)
    {
      Iterator localIterator = this.gWP.iterator();
      while (localIterator.hasNext())
      {
        InputStream localInputStream = ((o)localIterator.next()).openRead(paramString);
        if (localInputStream != null)
        {
          AppMethodBeat.o(86828);
          return localInputStream;
        }
      }
      ??? = this.gWO.findAppropriateModuleInfo(paramString);
      if (??? == null)
      {
        AppMethodBeat.o(86828);
        return null;
      }
    }
    paramString = ((ao)???).yw(paramString);
    AppMethodBeat.o(86828);
    return paramString;
  }
  
  protected <T> T e(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(86826);
    if (yC(paramString))
    {
      AppMethodBeat.o(86826);
      return null;
    }
    paramString = k.zl(paramString);
    if (paramString.startsWith("/__APP__")) {
      paramString = k.zl(paramString.substring(8));
    }
    for (;;)
    {
      long l = System.currentTimeMillis();
      Object localObject = yD(paramString);
      if (localObject != null) {}
      for (localObject = ((ax.b)ax.b.a.gWS.get(paramClass)).c(paramString, (InputStream)localObject);; localObject = null)
      {
        String str = this.mAppId;
        if (localObject == null) {}
        for (boolean bool = true;; bool = false)
        {
          ab.i("MicroMsg.WxaPkgRuntimeReader", "openRead, appId = %s, reqURL = %s, null(%B), type = %s, cost = %dms", new Object[] { str, paramString, Boolean.valueOf(bool), paramClass.getName(), Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(86826);
          return localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax
 * JD-Core Version:    0.7.0.1
 */