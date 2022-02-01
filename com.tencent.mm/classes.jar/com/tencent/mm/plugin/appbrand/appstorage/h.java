package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.d;
import d.l;
import d.n.k;
import d.n.n;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "uin", "", "(J)V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getter", "Lkotlin/Function1;", "", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "Companion", "StorageInfo", "luggage-wechat-full-sdk_release"})
public final class h
  implements o
{
  private static final Map<Long, h> jMq;
  public static final a jMr;
  private final b<String, String> jLP;
  private final m<String, String, z> jLQ;
  private ax jMp;
  
  static
  {
    AppMethodBeat.i(147886);
    jMr = new a((byte)0);
    jMq = (Map)new LinkedHashMap();
    AppMethodBeat.o(147886);
  }
  
  private h(long paramLong)
  {
    AppMethodBeat.i(147885);
    ad.i("AppBrandMMKVStorage", "getMMKV uin:".concat(String.valueOf(paramLong)));
    ax localax = ax.aQz("AppBrandMMKVStorage".concat(String.valueOf(paramLong)));
    p.g(localax, "MultiProcessMMKV.getMMKV(NAME + uin)");
    this.jMp = localax;
    this.jLP = ((b)new d(this));
    this.jLQ = ((m)new f(this));
    AppMethodBeat.o(147885);
  }
  
  private int[] LX(String paramString)
  {
    AppMethodBeat.i(147884);
    p.h(paramString, "appId");
    paramString = s.a(paramString, this.jLP, this.jLQ);
    AppMethodBeat.o(147884);
    return paramString;
  }
  
  private final int LZ(String paramString)
  {
    AppMethodBeat.i(147872);
    String str = this.jMp.getString(paramString, "");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    try
    {
      i = Integer.parseInt(Mg(paramString).jMs);
      AppMethodBeat.o(147872);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        int i = 0;
      }
    }
  }
  
  private static b Mg(String paramString)
  {
    AppMethodBeat.i(147874);
    paramString = (CharSequence)paramString;
    paramString = ((Collection)new k("#").q(paramString, 3)).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(147874);
      throw paramString;
    }
    paramString = (String[])paramString;
    if (paramString.length == 3)
    {
      paramString = new b(paramString[2], paramString[0], paramString[1]);
      AppMethodBeat.o(147874);
      return paramString;
    }
    paramString = new b("", "", "");
    AppMethodBeat.o(147874);
    return paramString;
  }
  
  private final int W(int paramInt, String paramString)
  {
    AppMethodBeat.i(147879);
    paramString = s.c(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    paramInt = bt.getInt(this.jMp.getString(paramString, ""), 0);
    AppMethodBeat.o(147879);
    return paramInt;
  }
  
  private void d(String paramString, b<? super String, z> paramb)
  {
    AppMethodBeat.i(147880);
    p.h(paramString, "appId");
    p.h(paramb, "block");
    k localk = new k("^([1-9]\\d*__)?" + paramString + "__.+$");
    paramString = this.jMp.allKeys();
    if (paramString == null) {
      paramString = new String[0];
    }
    for (;;)
    {
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        p.g(localObject, "key");
        if (localk.aC((CharSequence)localObject)) {
          paramb.invoke(localObject);
        }
        i += 1;
      }
      AppMethodBeat.o(147880);
      return;
    }
  }
  
  private final void g(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147870);
    paramString = s.c(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    this.jMp.putString(paramString, String.valueOf(paramInt2));
    AppMethodBeat.o(147870);
  }
  
  private final int h(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147871);
    paramInt2 = Math.max(0, W(paramInt1, paramString) + paramInt2);
    g(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(147871);
    return paramInt2;
  }
  
  private final boolean i(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147883);
    if (W(paramInt1, paramString) + paramInt2 >= s.X(paramInt1, paramString))
    {
      AppMethodBeat.o(147883);
      return true;
    }
    AppMethodBeat.o(147883);
    return false;
  }
  
  private static String t(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(147873);
    paramString1 = paramString2 + "#" + paramInt + "#" + paramString1;
    AppMethodBeat.o(147873);
    return paramString1;
  }
  
  public final void LW(String paramString)
  {
    AppMethodBeat.i(147877);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147877);
      return;
    }
    if (paramString == null) {
      p.gfZ();
    }
    int[] arrayOfInt = LX(paramString);
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      g(arrayOfInt[i], paramString, 0);
      i += 1;
    }
    d(paramString, (b)new c(this));
    s.b(paramString, this.jLP, this.jLQ);
    AppMethodBeat.o(147877);
  }
  
  public final int LY(String paramString)
  {
    AppMethodBeat.i(147882);
    p.h(paramString, "appId");
    int[] arrayOfInt = s.a(paramString, this.jLP, this.jLQ);
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = W(arrayOfInt[j], paramString);
      j += 1;
    }
    AppMethodBeat.o(147882);
    return i;
  }
  
  public final int Mh(String paramString)
  {
    AppMethodBeat.i(147881);
    p.h(paramString, "appId");
    y.d locald = new y.d();
    locald.MLT = 0;
    d(paramString, (b)new e(locald));
    int i = locald.MLT;
    AppMethodBeat.o(147881);
    return i;
  }
  
  public final void U(int paramInt, String paramString)
  {
    AppMethodBeat.i(147876);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147876);
      return;
    }
    if (paramInt == 0) {}
    for (String str = p.C(paramString, "__");; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.jMp.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        p.g(arrayOfString2, "key");
        if (n.nz(arrayOfString2, str)) {
          this.jMp.remove(arrayOfString2);
        }
        i += 1;
      }
    }
    if (paramString == null) {
      p.gfZ();
    }
    g(paramInt, paramString, 0);
    s.b(paramString, paramInt, this.jLP, this.jLQ);
    AppMethodBeat.o(147876);
  }
  
  public final Object[] V(int paramInt, String paramString)
  {
    AppMethodBeat.i(147878);
    if (paramString == null)
    {
      paramString = (List)d.a.v.MKE;
      AppMethodBeat.o(147878);
      return new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(0) };
    }
    List localList = (List)new ArrayList();
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.jMp.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        p.g(arrayOfString2, "key");
        if (n.nz(arrayOfString2, str)) {
          localList.add(n.h(arrayOfString2, str, "", false));
        }
        i += 1;
      }
    }
    int i = W(paramInt, paramString);
    paramInt = s.X(paramInt, paramString);
    AppMethodBeat.o(147878);
    return new Object[] { localList, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final o.a c(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(147869);
    p.h(paramString4, "dataType");
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      paramString1 = o.a.jMV;
      AppMethodBeat.o(147869);
      return paramString1;
    }
    if (paramString1 == null) {
      p.gfZ();
    }
    if (paramString2 == null) {
      p.gfZ();
    }
    String str = s.c(paramInt, paramString1, paramString2, "__");
    int j = LZ(str);
    int i = s.cq(paramString2, paramString3);
    j = i - j;
    if (i(paramInt, paramString1, j))
    {
      paramString1 = o.a.jMX;
      AppMethodBeat.o(147869);
      return paramString1;
    }
    this.jMp.putString(str, t(paramString3, paramString4, i));
    h(paramInt, paramString1, j);
    s.a(paramString1, paramInt, this.jLP, this.jLQ);
    paramString1 = o.a.jMT;
    AppMethodBeat.o(147869);
    return paramString1;
  }
  
  public final Object[] k(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147868);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      paramString1 = o.a.jMV;
      AppMethodBeat.o(147868);
      return new Object[] { paramString1 };
    }
    if (paramString1 == null) {
      p.gfZ();
    }
    if (paramString2 == null) {
      p.gfZ();
    }
    paramString1 = s.c(paramInt, paramString1, paramString2, "__");
    paramString2 = this.jMp.getString(paramString1, "");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    Object localObject = Mg(paramString1);
    if (((CharSequence)((b)localObject).data).length() == 0)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label217;
      }
      if (((CharSequence)((b)localObject).type).length() != 0) {
        break label207;
      }
      paramInt = 1;
      label129:
      if (paramInt == 0) {
        break label217;
      }
      if (((CharSequence)((b)localObject).jMs).length() != 0) {
        break label212;
      }
      paramInt = 1;
      label151:
      if (paramInt == 0) {
        break label217;
      }
    }
    label207:
    label212:
    label217:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label222;
      }
      paramString1 = o.a.jMT;
      paramString2 = ((b)localObject).data;
      localObject = ((b)localObject).type;
      AppMethodBeat.o(147868);
      return new Object[] { paramString1, paramString2, localObject };
      paramInt = 0;
      break;
      paramInt = 0;
      break label129;
      paramInt = 0;
      break label151;
    }
    label222:
    paramString1 = s.jNa;
    AppMethodBeat.o(147868);
    return paramString1;
  }
  
  public final o.a l(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147875);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      paramString1 = o.a.jMV;
      AppMethodBeat.o(147875);
      return paramString1;
    }
    if (paramString1 == null) {
      p.gfZ();
    }
    if (paramString2 == null) {
      p.gfZ();
    }
    paramString2 = s.c(paramInt, paramString1, paramString2, "__");
    int i = h(paramInt, paramString1, -LZ(paramString2));
    this.jMp.remove(paramString2);
    if (i <= 0) {
      s.b(paramString1, paramInt, this.jLP, this.jLQ);
    }
    paramString1 = o.a.jMT;
    AppMethodBeat.o(147875);
    return paramString1;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$Companion;", "", "()V", "CACHE", "", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "TAG", "obtain", "uin", "onAccountRelease", "", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static h sF(long paramLong)
    {
      AppMethodBeat.i(147862);
      synchronized (h.bby())
      {
        if (!h.bby().keySet().contains(Long.valueOf(paramLong))) {
          h.bby().put(Long.valueOf(paramLong), new h(paramLong, (byte)0));
        }
        z localz = z.MKo;
        ??? = h.bby().get(Long.valueOf(paramLong));
        if (??? == null) {
          p.gfZ();
        }
        ??? = (h)???;
        AppMethodBeat.o(147862);
        return ???;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "", "data", "", "type", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSize", "getType", "isEmpty", "", "luggage-wechat-full-sdk_release"})
  public static final class b
  {
    final String data;
    final String jMs;
    final String type;
    
    public b(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(147863);
      this.data = paramString1;
      this.type = paramString2;
      this.jMs = paramString3;
      AppMethodBeat.o(147863);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "key", "", "invoke"})
  static final class c
    extends q
    implements b<String, z>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "key", "invoke"})
  static final class d
    extends q
    implements b<String, String>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements b<String, z>
  {
    e(y.d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "", "key", "", "value", "invoke"})
  static final class f
    extends q
    implements m<String, String, z>
  {
    f(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.h
 * JD-Core Version:    0.7.0.1
 */