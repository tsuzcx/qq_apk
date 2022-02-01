package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.protocal.protobuf.dqh;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  private static f jkC;
  Map<String, b> jkD;
  private IPCRunCgi.a jkE;
  
  static
  {
    AppMethodBeat.i(121172);
    jkC = new f();
    AppMethodBeat.o(121172);
  }
  
  public f()
  {
    AppMethodBeat.i(121166);
    this.jkD = new ConcurrentHashMap();
    this.jkE = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(121163);
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0)) {
          ad.e("MicroMsg.DynamicPageViewStateMonitor", "widget alarm cgi fail, msg[%s]", new Object[] { paramAnonymousString });
        }
        AppMethodBeat.o(121163);
      }
    };
    AppMethodBeat.o(121166);
  }
  
  public static void GU(String paramString)
  {
    AppMethodBeat.i(121168);
    Bundle localBundle = new Bundle();
    paramString = GV(paramString);
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", 2109);
    h.a(i.aVi().GW(paramString), localBundle, a.class, null);
    AppMethodBeat.o(121168);
  }
  
  private static String GV(String paramString)
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
  
  public static f aVg()
  {
    return jkC;
  }
  
  public static void o(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121169);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpenWeappFial", true);
    localBundle.putInt("widgetState", paramInt);
    localBundle.putString("appid", paramString1);
    localBundle.putString("sceneNote", paramString2);
    h.a(i.aVi().GW(GV(paramString2)), localBundle, a.class, null);
    AppMethodBeat.o(121169);
  }
  
  public final boolean GT(String paramString)
  {
    AppMethodBeat.i(176167);
    if (!this.jkD.containsKey(paramString))
    {
      ad.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", new Object[] { paramString });
      AppMethodBeat.o(176167);
      return false;
    }
    b localb = (b)this.jkD.get(paramString);
    Object localObject1 = "";
    try
    {
      localObject2 = localb.jkH.toString();
      localObject1 = localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2;
      label69:
      break label69;
    }
    ad.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", new Object[] { localObject1 });
    if (localb.jkH.size() <= 0)
    {
      AppMethodBeat.o(176167);
      return true;
    }
    localObject1 = new b.a();
    ((b.a)localObject1).funcId = 2653;
    ((b.a)localObject1).uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
    localObject2 = new dqh();
    ((dqh)localObject2).dlB = u.vd(paramString);
    ((dqh)localObject2).id = localb.cIB;
    ((dqh)localObject2).EGc = localb.jkH;
    ((dqh)localObject2).query = localb.query;
    ((b.a)localObject1).gUU = ((a)localObject2);
    ((b.a)localObject1).gUV = new dqi();
    IPCRunCgi.a(((b.a)localObject1).atI(), this.jkE);
    AppMethodBeat.o(176167);
    return true;
  }
  
  public final boolean br(String paramString, int paramInt)
  {
    AppMethodBeat.i(121167);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121167);
      return false;
    }
    if (!this.jkD.containsKey(paramString))
    {
      ad.w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", new Object[] { paramString });
      AppMethodBeat.o(121167);
      return false;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      boolean bool = ((b)this.jkD.get(paramString)).jkH.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(121167);
      return bool;
      j.aVk().L(paramString, 628, 9);
    }
  }
  
  public static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static final class b
  {
    String appId;
    int cIB;
    String jkG;
    LinkedList<Integer> jkH;
    String query;
    
    public b(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      AppMethodBeat.i(121165);
      this.cIB = 0;
      this.jkG = "";
      this.appId = "";
      this.query = "";
      this.jkH = new LinkedList();
      this.jkG = paramString1;
      this.appId = paramString2;
      this.cIB = paramInt;
      this.query = paramString3;
      AppMethodBeat.o(121165);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f
 * JD-Core Version:    0.7.0.1
 */