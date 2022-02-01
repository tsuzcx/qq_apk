package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.protocal.protobuf.exx;
import com.tencent.mm.protocal.protobuf.exy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  private static f llY;
  Map<String, b> llZ;
  private IPCRunCgi.a lma;
  
  static
  {
    AppMethodBeat.i(121172);
    llY = new f();
    AppMethodBeat.o(121172);
  }
  
  public f()
  {
    AppMethodBeat.i(121166);
    this.llZ = new ConcurrentHashMap();
    this.lma = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(121163);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          Log.e("MicroMsg.DynamicPageViewStateMonitor", "widget alarm cgi fail, msg[%s]", new Object[] { paramAnonymousString });
        }
        AppMethodBeat.o(121163);
      }
    };
    AppMethodBeat.o(121166);
  }
  
  public static void Yl(String paramString)
  {
    AppMethodBeat.i(121168);
    Bundle localBundle = new Bundle();
    paramString = Ym(paramString);
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", 2109);
    h.a(i.bBL().Yn(paramString), localBundle, a.class, null);
    AppMethodBeat.o(121168);
  }
  
  private static String Ym(String paramString)
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
  
  public static f bBJ()
  {
    return llY;
  }
  
  public static void o(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121169);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpenWeappFial", true);
    localBundle.putInt("widgetState", paramInt);
    localBundle.putString("appid", paramString1);
    localBundle.putString("sceneNote", paramString2);
    h.a(i.bBL().Yn(Ym(paramString2)), localBundle, a.class, null);
    AppMethodBeat.o(121169);
  }
  
  public final boolean Yk(String paramString)
  {
    AppMethodBeat.i(176167);
    if (!this.llZ.containsKey(paramString))
    {
      Log.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", new Object[] { paramString });
      AppMethodBeat.o(176167);
      return false;
    }
    b localb = (b)this.llZ.get(paramString);
    Object localObject1 = "";
    try
    {
      localObject2 = localb.lmd.toString();
      localObject1 = localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2;
      label69:
      break label69;
    }
    Log.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", new Object[] { localObject1 });
    if (localb.lmd.size() <= 0)
    {
      AppMethodBeat.o(176167);
      return true;
    }
    localObject1 = new d.a();
    ((d.a)localObject1).funcId = 2653;
    ((d.a)localObject1).uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
    localObject2 = new exx();
    ((exx)localObject2).dNI = u.Lv(paramString);
    ((exx)localObject2).id = localb.serviceType;
    ((exx)localObject2).Nvf = localb.lmd;
    ((exx)localObject2).query = localb.query;
    ((d.a)localObject1).iLN = ((a)localObject2);
    ((d.a)localObject1).iLO = new exy();
    IPCRunCgi.a(((d.a)localObject1).aXF(), this.lma);
    AppMethodBeat.o(176167);
    return true;
  }
  
  public final boolean bF(String paramString, int paramInt)
  {
    AppMethodBeat.i(121167);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121167);
      return false;
    }
    if (!this.llZ.containsKey(paramString))
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
      boolean bool = ((b)this.llZ.get(paramString)).lmd.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(121167);
      return bool;
      j.bBN().P(paramString, 628, 9);
    }
  }
  
  public static class a
    implements b<Bundle, Bundle>
  {}
  
  public static final class b
  {
    String appId;
    String lmc;
    LinkedList<Integer> lmd;
    String query;
    int serviceType;
    
    public b(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      AppMethodBeat.i(121165);
      this.serviceType = 0;
      this.lmc = "";
      this.appId = "";
      this.query = "";
      this.lmd = new LinkedList();
      this.lmc = paramString1;
      this.appId = paramString2;
      this.serviceType = paramInt;
      this.query = paramString3;
      AppMethodBeat.o(121165);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f
 * JD-Core Version:    0.7.0.1
 */