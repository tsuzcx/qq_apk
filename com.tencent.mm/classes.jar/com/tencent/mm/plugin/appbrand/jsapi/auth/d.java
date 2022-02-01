package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.utils.i;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;
import org.json.JSONObject;

class d
  extends i<a>
  implements c, e
{
  private static final Map<String, d> kdl;
  private static final d kdm;
  
  static
  {
    AppMethodBeat.i(46017);
    kdl = new android.support.v4.e.a();
    kdm = new d()
    {
      protected final boolean bfi()
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
      paramAppBrandRuntime = kdm;
      AppMethodBeat.o(46009);
      return paramAppBrandRuntime;
    }
    synchronized (kdl)
    {
      d locald2 = (d)kdl.get(paramAppBrandRuntime.mAppId);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(paramAppBrandRuntime);
        kdl.put(paramAppBrandRuntime.mAppId, locald1);
      }
      AppMethodBeat.o(46009);
      return locald1;
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(46012);
    ac.d(this.mName, "about to executeTask %s", new Object[] { parama.toString() });
    parama.aQH();
    AppMethodBeat.o(46012);
  }
  
  public final void a(final h paramh, final com.tencent.mm.plugin.appbrand.jsapi.h paramh1, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46013);
    ac.i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", new Object[] { paramh.getName(), Integer.valueOf(paramInt), paramh1.getAppId() });
    super.cG(new a()
    {
      public final void aQH()
      {
        AppMethodBeat.i(46007);
        ac.i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", new Object[] { d.this.mName });
        if (!paramh1.isRunning())
        {
          ac.e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", new Object[] { paramh.getName() });
          jdField_this.Yv(2);
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
  
  public final void bfe()
  {
    AppMethodBeat.i(46011);
    Yv(2);
    AppMethodBeat.o(46011);
  }
  
  protected boolean bfi()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void aQH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.d
 * JD-Core Version:    0.7.0.1
 */