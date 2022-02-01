package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.protocal.protobuf.edp;
import com.tencent.mm.protocal.protobuf.edq;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  private static f kiq;
  Map<String, b> kir;
  private IPCRunCgi.a kis;
  
  static
  {
    AppMethodBeat.i(121172);
    kiq = new f();
    AppMethodBeat.o(121172);
  }
  
  public f()
  {
    AppMethodBeat.i(121166);
    this.kir = new ConcurrentHashMap();
    this.kis = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(121163);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          ae.e("MicroMsg.DynamicPageViewStateMonitor", "widget alarm cgi fail, msg[%s]", new Object[] { paramAnonymousString });
        }
        AppMethodBeat.o(121163);
      }
    };
    AppMethodBeat.o(121166);
  }
  
  public static void Pa(String paramString)
  {
    AppMethodBeat.i(121168);
    Bundle localBundle = new Bundle();
    paramString = Pb(paramString);
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", 2109);
    h.a(i.bgs().Pc(paramString), localBundle, a.class, null);
    AppMethodBeat.o(121168);
  }
  
  private static String Pb(String paramString)
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
  
  public static f bgq()
  {
    return kiq;
  }
  
  public static void n(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121169);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpenWeappFial", true);
    localBundle.putInt("widgetState", paramInt);
    localBundle.putString("appid", paramString1);
    localBundle.putString("sceneNote", paramString2);
    h.a(i.bgs().Pc(Pb(paramString2)), localBundle, a.class, null);
    AppMethodBeat.o(121169);
  }
  
  public final boolean OZ(String paramString)
  {
    AppMethodBeat.i(176167);
    if (!this.kir.containsKey(paramString))
    {
      ae.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", new Object[] { paramString });
      AppMethodBeat.o(176167);
      return false;
    }
    b localb = (b)this.kir.get(paramString);
    Object localObject1 = "";
    try
    {
      localObject2 = localb.kiv.toString();
      localObject1 = localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2;
      label69:
      break label69;
    }
    ae.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", new Object[] { localObject1 });
    if (localb.kiv.size() <= 0)
    {
      AppMethodBeat.o(176167);
      return true;
    }
    localObject1 = new b.a();
    ((b.a)localObject1).funcId = 2653;
    ((b.a)localObject1).uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
    localObject2 = new edp();
    ((edp)localObject2).dwb = u.CK(paramString);
    ((edp)localObject2).id = localb.cRx;
    ((edp)localObject2).IiB = localb.kiv;
    ((edp)localObject2).query = localb.query;
    ((b.a)localObject1).hQF = ((a)localObject2);
    ((b.a)localObject1).hQG = new edq();
    IPCRunCgi.a(((b.a)localObject1).aDS(), this.kis);
    AppMethodBeat.o(176167);
    return true;
  }
  
  public final boolean bA(String paramString, int paramInt)
  {
    AppMethodBeat.i(121167);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121167);
      return false;
    }
    if (!this.kir.containsKey(paramString))
    {
      ae.w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", new Object[] { paramString });
      AppMethodBeat.o(121167);
      return false;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      boolean bool = ((b)this.kir.get(paramString)).kiv.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(121167);
      return bool;
      j.bgu().M(paramString, 628, 9);
    }
  }
  
  public static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static final class b
  {
    String appId;
    int cRx;
    String kiu;
    LinkedList<Integer> kiv;
    String query;
    
    public b(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      AppMethodBeat.i(121165);
      this.cRx = 0;
      this.kiu = "";
      this.appId = "";
      this.query = "";
      this.kiv = new LinkedList();
      this.kiu = paramString1;
      this.appId = paramString2;
      this.cRx = paramInt;
      this.query = paramString3;
      AppMethodBeat.o(121165);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f
 * JD-Core Version:    0.7.0.1
 */