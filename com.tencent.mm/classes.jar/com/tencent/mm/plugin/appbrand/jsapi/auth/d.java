package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.utils.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class d
  extends l<a>
  implements c, e
{
  private static final Map<String, d> oAT;
  private static final d oAU;
  
  static
  {
    AppMethodBeat.i(46017);
    oAT = new androidx.b.a();
    oAU = new d()
    {
      protected final boolean bQi()
      {
        return true;
      }
    };
    AppMethodBeat.o(46017);
  }
  
  private d(AppBrandRuntime paramAppBrandRuntime) {}
  
  public static d W(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(46009);
    if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.ntU.get()))
    {
      paramAppBrandRuntime = oAU;
      AppMethodBeat.o(46009);
      return paramAppBrandRuntime;
    }
    synchronized (oAT)
    {
      d locald2 = (d)oAT.get(paramAppBrandRuntime.mAppId);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(paramAppBrandRuntime);
        oAT.put(paramAppBrandRuntime.mAppId, locald1);
      }
      AppMethodBeat.o(46009);
      return locald1;
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(46012);
    Log.d(getName(), "about to executeTask %s", new Object[] { parama.toString() });
    parama.bzr();
    AppMethodBeat.o(46012);
  }
  
  public final void a(final i parami, final g paramg, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(234567);
    Log.i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", new Object[] { parami.getName(), Integer.valueOf(paramInt), paramg.getAppId() });
    try
    {
      paramJSONObject.put("queueLength", cmg());
      label49:
      super.cR(new a()
      {
        public final void bzr()
        {
          AppMethodBeat.i(46007);
          Log.i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", new Object[] { d.this.getName() });
          if (!paramg.isRunning())
          {
            Log.e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", new Object[] { parami.getName() });
            jdField_this.sendMessage(2);
            AppMethodBeat.o(46007);
            return;
          }
          parami.a(paramg, paramJSONObject, paramInt, new a(jdField_this));
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
      AppMethodBeat.o(234567);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label49;
    }
  }
  
  public final void bQe()
  {
    AppMethodBeat.i(46011);
    sendMessage(2);
    AppMethodBeat.o(46011);
  }
  
  protected boolean bQi()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void bzr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.d
 * JD-Core Version:    0.7.0.1
 */