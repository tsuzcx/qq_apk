package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Map;
import org.json.JSONObject;

class d
  extends com.tencent.mm.plugin.appbrand.utils.i<a>
  implements c, e
{
  private static final Map<String, d> kxL;
  private static final d kxM;
  
  static
  {
    AppMethodBeat.i(46017);
    kxL = new android.support.v4.e.a();
    kxM = new d()
    {
      protected final boolean biL()
      {
        return true;
      }
    };
    AppMethodBeat.o(46017);
  }
  
  private d(AppBrandRuntime paramAppBrandRuntime) {}
  
  public static d V(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(46009);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.isDestroyed()))
    {
      paramAppBrandRuntime = kxM;
      AppMethodBeat.o(46009);
      return paramAppBrandRuntime;
    }
    synchronized (kxL)
    {
      d locald2 = (d)kxL.get(paramAppBrandRuntime.mAppId);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(paramAppBrandRuntime);
        kxL.put(paramAppBrandRuntime.mAppId, locald1);
      }
      AppMethodBeat.o(46009);
      return locald1;
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(46012);
    ad.d(this.mName, "about to executeTask %s", new Object[] { parama.toString() });
    parama.aTT();
    AppMethodBeat.o(46012);
  }
  
  public final void a(final i parami, final com.tencent.mm.plugin.appbrand.d paramd, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(192211);
    ad.i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", new Object[] { parami.getName(), Integer.valueOf(paramInt), paramd.getAppId() });
    super.cI(new a()
    {
      public final void aTT()
      {
        AppMethodBeat.i(46007);
        ad.i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", new Object[] { d.this.mName });
        if (!paramd.isRunning())
        {
          ad.e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", new Object[] { parami.getName() });
          jdField_this.aaA(2);
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
    AppMethodBeat.o(192211);
  }
  
  public final void biH()
  {
    AppMethodBeat.i(46011);
    aaA(2);
    AppMethodBeat.o(46011);
  }
  
  protected boolean biL()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void aTT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.d
 * JD-Core Version:    0.7.0.1
 */