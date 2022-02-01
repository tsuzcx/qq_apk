package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.protocal.protobuf.fin;
import com.tencent.mm.protocal.protobuf.fio;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  private static f ogK;
  Map<String, b> ogL;
  private IPCRunCgi.a ogM;
  
  static
  {
    AppMethodBeat.i(121172);
    ogK = new f();
    AppMethodBeat.o(121172);
  }
  
  public f()
  {
    AppMethodBeat.i(121166);
    this.ogL = new ConcurrentHashMap();
    this.ogM = new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd)
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
  
  public static void afZ(String paramString)
  {
    AppMethodBeat.i(121168);
    Bundle localBundle = new Bundle();
    paramString = aga(paramString);
    localBundle.putString("id", paramString);
    localBundle.putInt("widgetState", 2109);
    com.tencent.mm.ipcinvoker.j.a(i.bNh().agb(paramString), localBundle, a.class, null);
    AppMethodBeat.o(121168);
  }
  
  private static String aga(String paramString)
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
  
  public static f bNf()
  {
    return ogK;
  }
  
  public static void o(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(121169);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOpenWeappFial", true);
    localBundle.putInt("widgetState", paramInt);
    localBundle.putString("appid", paramString1);
    localBundle.putString("sceneNote", paramString2);
    com.tencent.mm.ipcinvoker.j.a(i.bNh().agb(aga(paramString2)), localBundle, a.class, null);
    AppMethodBeat.o(121169);
  }
  
  public final boolean afY(String paramString)
  {
    AppMethodBeat.i(176167);
    if (!this.ogL.containsKey(paramString))
    {
      Log.w("MicroMsg.DynamicPageViewStateMonitor", "OnDettach but no keylist found, widgetId[%s]", new Object[] { paramString });
      AppMethodBeat.o(176167);
      return false;
    }
    b localb = (b)this.ogL.get(paramString);
    Object localObject1 = "";
    try
    {
      localObject2 = localb.ogP.toString();
      localObject1 = localObject2;
    }
    catch (NullPointerException localNullPointerException)
    {
      Object localObject2;
      label69:
      break label69;
    }
    Log.i("MicroMsg.DynamicPageViewStateMonitor", "OnDettach ready to report keyList[%s]", new Object[] { localObject1 });
    if (localb.ogP.size() <= 0)
    {
      AppMethodBeat.o(176167);
      return true;
    }
    localObject1 = new d.a();
    ((d.a)localObject1).funcId = 2653;
    ((d.a)localObject1).uri = "/cgi-bin/mmux-bin/wxaapp/wxaapp_widgetalarm";
    localObject2 = new fin();
    ((fin)localObject2).appid = u.SO(paramString);
    ((fin)localObject2).id = localb.serviceType;
    ((fin)localObject2).UIo = localb.ogP;
    ((fin)localObject2).query = localb.query;
    ((d.a)localObject1).lBU = ((a)localObject2);
    ((d.a)localObject1).lBV = new fio();
    IPCRunCgi.a(((d.a)localObject1).bgN(), this.ogM);
    AppMethodBeat.o(176167);
    return true;
  }
  
  public final boolean ca(String paramString, int paramInt)
  {
    AppMethodBeat.i(121167);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(121167);
      return false;
    }
    if (!this.ogL.containsKey(paramString))
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
      boolean bool = ((b)this.ogL.get(paramString)).ogP.add(Integer.valueOf(paramInt));
      AppMethodBeat.o(121167);
      return bool;
      j.bNj().P(paramString, 628, 9);
    }
  }
  
  public static class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  public static final class b
  {
    String appId;
    String ogO;
    LinkedList<Integer> ogP;
    String query;
    int serviceType;
    
    public b(String paramString1, String paramString2, int paramInt, String paramString3)
    {
      AppMethodBeat.i(121165);
      this.serviceType = 0;
      this.ogO = "";
      this.appId = "";
      this.query = "";
      this.ogP = new LinkedList();
      this.ogO = paramString1;
      this.appId = paramString2;
      this.serviceType = paramInt;
      this.query = paramString3;
      AppMethodBeat.o(121165);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.f
 * JD-Core Version:    0.7.0.1
 */