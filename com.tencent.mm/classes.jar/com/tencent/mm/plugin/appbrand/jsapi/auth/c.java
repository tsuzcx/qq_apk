package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import org.json.JSONObject;

class c
  extends com.tencent.mm.plugin.appbrand.t.h<c.a>
  implements b, d
{
  private static final Map<String, c> hDk;
  private static final c hDl;
  
  static
  {
    AppMethodBeat.i(130828);
    hDk = new a();
    hDl = new c.1();
    AppMethodBeat.o(130828);
  }
  
  private c(i parami) {}
  
  public static c y(i parami)
  {
    AppMethodBeat.i(130820);
    if ((parami == null) || (parami.mFinished))
    {
      parami = hDl;
      AppMethodBeat.o(130820);
      return parami;
    }
    synchronized (hDk)
    {
      c localc2 = (c)hDk.get(parami.mAppId);
      c localc1 = localc2;
      if (localc2 == null)
      {
        localc1 = new c(parami);
        hDk.put(parami.mAppId, localc1);
      }
      AppMethodBeat.o(130820);
      return localc1;
    }
  }
  
  protected final void a(c.a parama)
  {
    AppMethodBeat.i(130823);
    ab.d(this.mName, "about to executeTask %s", new Object[] { parama.toString() });
    parama.arq();
    AppMethodBeat.o(130823);
  }
  
  public final void a(f paramf, com.tencent.mm.plugin.appbrand.jsapi.h paramh, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(130824);
    ab.i("MicroMsg.AppBrandAuthJsApiQueue", "execute name[%s], callbackId[%d], appId[%s]", new Object[] { paramf.getName(), Integer.valueOf(paramInt), paramh.getAppId() });
    super.bu(new c.3(this, paramh, paramf, this, paramJSONObject, paramInt));
    AppMethodBeat.o(130824);
  }
  
  public final void aBV()
  {
    AppMethodBeat.i(130822);
    sendMessage(2);
    AppMethodBeat.o(130822);
  }
  
  protected boolean aBW()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.c
 * JD-Core Version:    0.7.0.1
 */