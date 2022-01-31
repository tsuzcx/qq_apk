package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Looper;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.HashMap;
import java.util.Map;

public class ak
  extends u<r>
{
  public static final int CTRL_INDEX = 466;
  public static final String NAME = "getMenuButtonBoundingClientRect";
  
  static Map<String, Object> a(d paramd)
  {
    AppMethodBeat.i(140099);
    if ((paramd instanceof r)) {}
    for (paramd = ((r)paramd).getCurrentPageView(); paramd == null; paramd = null)
    {
      paramd = new IllegalStateException("fail:page don't exist");
      AppMethodBeat.o(140099);
      throw paramd;
    }
    int[] arrayOfInt = new int[2];
    paramd.getActionBar().getCapsuleView().getLocationInWindow(arrayOfInt);
    int i = g.pN(paramd.getActionBar().getCapsuleView().getWidth());
    int j = g.pN(paramd.getActionBar().getCapsuleView().getHeight());
    int k = g.pN(arrayOfInt[1]);
    int m = g.pN(arrayOfInt[0]);
    if (m == 0)
    {
      AppMethodBeat.o(140099);
      return null;
    }
    paramd = new HashMap();
    paramd.put("width", Integer.valueOf(i));
    paramd.put("height", Integer.valueOf(j));
    paramd.put("top", Integer.valueOf(k));
    paramd.put("right", Integer.valueOf(m + i));
    paramd.put("bottom", Integer.valueOf(k + j));
    paramd.put("left", Integer.valueOf(m));
    AppMethodBeat.o(140099);
    return paramd;
  }
  
  public String h(r paramr)
  {
    AppMethodBeat.i(114326);
    paramr = (String)i(paramr).first;
    AppMethodBeat.o(114326);
    return paramr;
  }
  
  protected final Pair<String, ak.a> i(r paramr)
  {
    AppMethodBeat.i(114327);
    try
    {
      Object localObject = a(paramr);
      if (localObject != null)
      {
        localObject = j("ok", (Map)localObject);
        ab.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getMenuButtonBoundingClientRect: return on JSThread appId[%s] ret[%s]", new Object[] { paramr.getAppId(), localObject });
        paramr = Pair.create(localObject, ak.a.hxN);
        AppMethodBeat.o(114327);
        return paramr;
      }
      localObject = new ak.1(this, paramr);
      String str = (String)((bj)localObject).b(new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper()));
      ab.i("MicroMsg.JsApiGetMenuButtonBoundingClientRect", "getMenuButtonBoundingClientRect: try again on UiThread appId[%s] ret[%s]", new Object[] { paramr.getAppId(), localObject });
      paramr = Pair.create(str, ak.a.hxO);
      AppMethodBeat.o(114327);
      return paramr;
    }
    catch (Exception paramr)
    {
      paramr = Pair.create(j(paramr.getMessage(), null), ak.a.hxN);
      AppMethodBeat.o(114327);
    }
    return paramr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ak
 * JD-Core Version:    0.7.0.1
 */