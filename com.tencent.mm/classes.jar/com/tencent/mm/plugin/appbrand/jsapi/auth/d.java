package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;
import org.json.JSONObject;

class d
  extends com.tencent.mm.plugin.appbrand.utils.h<a>
  implements c, e
{
  private static final Map<String, d> jCP;
  private static final d jCQ;
  
  static
  {
    AppMethodBeat.i(46017);
    jCP = new android.support.v4.e.a();
    jCQ = new d()
    {
      protected final boolean aYl()
      {
        return true;
      }
    };
    AppMethodBeat.o(46017);
  }
  
  private d(AppBrandRuntime paramAppBrandRuntime) {}
  
  public static d ab(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(46009);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = jCQ;
      AppMethodBeat.o(46009);
      return paramAppBrandRuntime;
    }
    synchronized (jCP)
    {
      d locald2 = (d)jCP.get(paramAppBrandRuntime.mAppId);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(paramAppBrandRuntime);
        jCP.put(paramAppBrandRuntime.mAppId, locald1);
      }
      AppMethodBeat.o(46009);
      return locald1;
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(46012);
    ad.d(this.mName, "about to executeTask %s", new Object[] { parama.toString() });
    parama.aJQ();
    AppMethodBeat.o(46012);
  }
  
  public final void a(final h paramh, final com.tencent.mm.plugin.appbrand.jsapi.h paramh1, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46013);
    ad.i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", new Object[] { paramh.getName(), Integer.valueOf(paramInt), paramh1.getAppId() });
    super.cH(new a()
    {
      public final void aJQ()
      {
        AppMethodBeat.i(46007);
        ad.i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", new Object[] { d.this.mName });
        if (!paramh1.isRunning())
        {
          ad.e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", new Object[] { paramh.getName() });
          jdField_this.Wm(2);
          AppMethodBeat.o(46007);
          return;
        }
        paramh.a(paramh1, paramJSONObject, paramInt, new a(jdField_this));
        AppMethodBeat.o(46007);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(46008);
        String str = hashCode() + "|" + paramh.getName();
        AppMethodBeat.o(46008);
        return str;
      }
    });
    AppMethodBeat.o(46013);
  }
  
  public final void aYh()
  {
    AppMethodBeat.i(46011);
    Wm(2);
    AppMethodBeat.o(46011);
  }
  
  protected boolean aYl()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void aJQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.d
 * JD-Core Version:    0.7.0.1
 */