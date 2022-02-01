package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class d
  extends p<a>
  implements c, e
{
  private static final Map<String, d> rEI;
  private static final c rEJ;
  
  static
  {
    AppMethodBeat.i(46017);
    rEI = new androidx.b.a();
    rEJ = new c()
    {
      public final void execute(j paramAnonymousj, dh<g> paramAnonymousdh) {}
    };
    AppMethodBeat.o(46017);
  }
  
  private d(AppBrandRuntime paramAppBrandRuntime) {}
  
  public static c ad(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(326879);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.qsE.get()) || (paramAppBrandRuntime.ccV))
    {
      paramAppBrandRuntime = rEJ;
      AppMethodBeat.o(326879);
      return paramAppBrandRuntime;
    }
    synchronized (rEI)
    {
      d locald2 = (d)rEI.get(paramAppBrandRuntime.mAppId);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(paramAppBrandRuntime);
        rEI.put(paramAppBrandRuntime.mAppId, locald1);
      }
      AppMethodBeat.o(326879);
      return locald1;
    }
  }
  
  public final void execute(final j paramj, final dh<g> paramdh)
  {
    AppMethodBeat.i(326914);
    final g localg = (g)paramdh.rBv;
    JSONObject localJSONObject = paramdh.rmi;
    int i = paramdh.ror;
    Log.i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", new Object[] { paramj.getName(), Integer.valueOf(i), localg.getAppId() });
    try
    {
      localJSONObject.put("queueLength", cNA());
      label70:
      super.en(new a()
      {
        public final void bXX()
        {
          AppMethodBeat.i(46007);
          Log.i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", new Object[] { d.this.getName() });
          if (!localg.isRunning())
          {
            Log.e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", new Object[] { paramj.getName() });
            jdField_this.onAuthResult();
            AppMethodBeat.o(46007);
            return;
          }
          paramj.a(paramdh, new a(jdField_this));
          AppMethodBeat.o(46007);
        }
        
        public final String toString()
        {
          AppMethodBeat.i(46008);
          String str = hashCode() + "|" + paramj.getName();
          AppMethodBeat.o(46008);
          return str;
        }
      });
      AppMethodBeat.o(326914);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label70;
    }
  }
  
  public final void onAuthResult()
  {
    AppMethodBeat.i(46011);
    sendMessage(2);
    AppMethodBeat.o(46011);
  }
  
  static abstract interface a
  {
    public abstract void bXX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.d
 * JD-Core Version:    0.7.0.1
 */