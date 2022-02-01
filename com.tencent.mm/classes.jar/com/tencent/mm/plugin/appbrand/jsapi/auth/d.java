package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c.a;
import com.tencent.mm.plugin.appbrand.utils.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;

class d
  extends j<a>
  implements c, e
{
  private static final Map<String, d> lFs;
  private static final d lFt;
  
  static
  {
    AppMethodBeat.i(46017);
    lFs = new android.support.v4.e.a();
    lFt = new d()
    {
      protected final boolean bEI()
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
      paramAppBrandRuntime = lFt;
      AppMethodBeat.o(46009);
      return paramAppBrandRuntime;
    }
    synchronized (lFs)
    {
      d locald2 = (d)lFs.get(paramAppBrandRuntime.mAppId);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(paramAppBrandRuntime);
        lFs.put(paramAppBrandRuntime.mAppId, locald1);
      }
      AppMethodBeat.o(46009);
      return locald1;
    }
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(46012);
    Log.d(getName(), "about to executeTask %s", new Object[] { parama.toString() });
    parama.bpf();
    AppMethodBeat.o(46012);
  }
  
  public final void a(final i parami, final com.tencent.mm.plugin.appbrand.d paramd, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(229890);
    Log.i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", new Object[] { parami.getName(), Integer.valueOf(paramInt), paramd.getAppId() });
    super.cQ(new a()
    {
      public final void bpf()
      {
        AppMethodBeat.i(46007);
        Log.i("MicroMsg.AppBrandAuthJsApiQueue", "about to call AuthInvoke, api[%s]", new Object[] { d.this.getName() });
        if (!paramd.isRunning())
        {
          Log.e("MicroMsg.AppBrandAuthJsApiQueue", "doAuth but component not running, api = %s", new Object[] { parami.getName() });
          jdField_this.sendMessage(2);
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
    try
    {
      paramJSONObject.put("queueLength", this.ogP.size());
      AppMethodBeat.o(229890);
      return;
    }
    catch (JSONException parami)
    {
      AppMethodBeat.o(229890);
    }
  }
  
  public final void bEE()
  {
    AppMethodBeat.i(46011);
    sendMessage(2);
    AppMethodBeat.o(46011);
  }
  
  protected boolean bEI()
  {
    return false;
  }
  
  static abstract interface a
  {
    public abstract void bpf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.d
 * JD-Core Version:    0.7.0.1
 */