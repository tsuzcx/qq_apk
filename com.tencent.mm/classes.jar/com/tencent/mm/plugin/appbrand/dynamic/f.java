package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.protocal.protobuf.gfa;
import com.tencent.mm.protocal.protobuf.gfb;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  private static f rko;
  Map<String, b> rkp;
  private IPCRunCgi.a rkq;
  
  static
  {
    AppMethodBeat.i(121172);
    rko = new f();
    AppMethodBeat.o(121172);
  }
  
  public f()
  {
    AppMethodBeat.i(121166);
    this.rkp = new ConcurrentHashMap();
    this.rkq = new f.1(this);
    AppMethodBeat.o(121166);
  }
  
  public static void YV(String paramString)
  {
    AppMethodBeat.i(121168);
    Bundle localBundle = new Bundle();
    paramString = YW(paramString);
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", 2109);
    com.tencent.mm.ipcinvoker.j.a(i.cnw().YX(paramString), localBundle, a.class, null);
    AppMethodBeat.o(121168);
  }
  
  private static String YW(String paramString)
  {
    AppMethodBeat.i(121170);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121170);
      return "";
    }
    paramString = Pattern.compile(":widgetId=.*:").matcher(paramString);
    if (paramString.matches())
    {
      paramString = paramString.group();
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = paramString.substring(paramString.indexOf("=") + 1, paramString.lastIndexOf(":"));
        AppMethodBeat.o(121170);
        return paramString;
      }
    }
    AppMethodBeat.o(121170);
    return "";
  }
  
  public static f cnu()
  {
    return rko;
  }
  
  public static void r(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121169);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpenWeappFial", true);
    localBundle.putInt("widgetState", paramInt);
    localBundle.putString("appid", paramString1);
    localBundle.putString("sceneNote", paramString2);
    com.tencent.mm.ipcinvoker.j.a(i.cnw().YX(YW(paramString2)), localBundle, a.class, null);
    AppMethodBeat.o(121169);
  }
  
  public final boolean YU(String paramString)
  {
    AppMethodBeat.i(176167);
    if (!this.rkp.containsKey(paramString))
    {
      Log.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", new Object[] { paramString });
      AppMethodBeat.o(176167);
      return false;
    }
    b localb = (b)this.rkp.get(paramString);
    Object localObject1 = "";
    try
    {
      localObject2 = localb.rkt.toString();
      localObject1 = localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2;
      label69:
      break label69;
    }
    Log.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", new Object[] { localObject1 });
    if (localb.rkt.size() <= 0)
    {
      AppMethodBeat.o(176167);
      return true;
    }
    localObject1 = new c.a();
    ((c.a)localObject1).funcId = 2653;
    ((c.a)localObject1).uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
    localObject2 = new gfa();
    ((gfa)localObject2).appid = u.KQ(paramString);
    ((gfa)localObject2).id = localb.serviceType;
    ((gfa)localObject2).accx = localb.rkt;
    ((gfa)localObject2).query = localb.query;
    ((c.a)localObject1).otE = ((a)localObject2);
    ((c.a)localObject1).otF = new gfb();
    IPCRunCgi.a(((c.a)localObject1).bEF(), this.rkq);
    AppMethodBeat.o(176167);
    return true;
  }
  
  public final boolean cx(String paramString, int paramInt)
  {
    AppMethodBeat.i(121167);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121167);
      return false;
    }
    if (!this.rkp.containsKey(paramString))
    {
      Log.w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", new Object[] { paramString });
      AppMethodBeat.o(121167);
      return false;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      boolean bool = ((b)this.rkp.get(paramString)).rkt.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(121167);
      return bool;
      j.cny().T(paramString, 628, 9);
    }
  }
  
  public static class a
    implements d<Bundle, Bundle>
  {}
  
  public static final class b
  {
    String appId;
    String query;
    String rks;
    LinkedList<Integer> rkt;
    int serviceType;
    
    public b(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      AppMethodBeat.i(121165);
      this.serviceType = 0;
      this.rks = "";
      this.appId = "";
      this.query = "";
      this.rkt = new LinkedList();
      this.rks = paramString1;
      this.appId = paramString2;
      this.serviceType = paramInt;
      this.query = paramString3;
      AppMethodBeat.o(121165);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f
 * JD-Core Version:    0.7.0.1
 */