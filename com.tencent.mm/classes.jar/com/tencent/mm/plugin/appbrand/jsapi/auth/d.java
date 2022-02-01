package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Map;
import org.json.JSONObject;

class d
  extends j<a>
  implements c, e
{
  private static final Map<String, d> kBa;
  private static final d kBb;
  
  static
  {
    AppMethodBeat.i(46017);
    kBa = new android.support.v4.e.a();
    kBb = new d()
    {
      protected final boolean bju()
      {
        return true;
      }
    };
    AppMethodBeat.o(46017);
  }
  
  private d(AppBrandRuntime paramAppBrandRuntime) {}
  
  public static d U(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(46009);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = kBb;
      AppMethodBeat.o(46009);
      return paramAppBrandRuntime;
    }
    synchronized (kBa)
    {
      d locald2 = (d)kBa.get(paramAppBrandRuntime.mAppId);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(paramAppBrandRuntime);
        kBa.put(paramAppBrandRuntime.mAppId, locald1);
      }
      AppMethodBeat.o(46009);
      return locald1;
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(46012);
    ae.d(this.mName, "about to executeTask %s", new Object[] { parama.toString() });
    parama.aUs();
    AppMethodBeat.o(46012);
  }
  
  public final void a(final i parami, final com.tencent.mm.plugin.appbrand.d paramd, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(220783);
    ae.i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", new Object[] { parami.getName(), Integer.valueOf(paramInt), paramd.getAppId() });
    super.cJ(new a()
    {
      public final void aUs()
      {
        AppMethodBeat.i(46007);
        ae.i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", new Object[] { d.this.mName });
        if (!paramd.isRunning())
        {
          ae.e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", new Object[] { parami.getName() });
          jdField_this.abg(2);
          AppMethodBeat.o(46007);
          return;
        }
        parami.a(paramd, paramJSONObject, paramInt, new a(jdField_this));
        AppMethodBeat.o(46007);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(46008);
        String str = hashCode() + "|" + parami.getName();
        AppMethodBeat.o(46008);
        return str;
      }
    });
    AppMethodBeat.o(220783);
  }
  
  public final void bjq()
  {
    AppMethodBeat.i(46011);
    abg(2);
    AppMethodBeat.o(46011);
  }
  
  protected boolean bju()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void aUs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.d
 * JD-Core Version:    0.7.0.1
 */