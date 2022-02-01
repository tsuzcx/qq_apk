package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.b;
import d.g.a.m;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "uin", "", "(J)V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getter", "Lkotlin/Function1;", "", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "Companion", "StorageInfo", "luggage-wechat-full-sdk_release"})
public final class h
  implements p
{
  private static final Map<Long, h> jPC;
  public static final a jPD;
  private ay jPB;
  private final b<String, String> jPb;
  private final m<String, String, z> jPc;
  
  static
  {
    AppMethodBeat.i(147886);
    jPD = new a((byte)0);
    jPC = (Map)new LinkedHashMap();
    AppMethodBeat.o(147886);
  }
  
  private h(long paramLong)
  {
    AppMethodBeat.i(147885);
    ae.i("AppBrandMMKVStorage", "getMMKV uin:".concat(String.valueOf(paramLong)));
    ay localay = ay.aRW("AppBrandMMKVStorage".concat(String.valueOf(paramLong)));
    d.g.b.p.g(localay, "MultiProcessMMKV.getMMKV(NAME + uin)");
    this.jPB = localay;
    this.jPb = ((b)new d(this));
    this.jPc = ((m)new f(this));
    AppMethodBeat.o(147885);
  }
  
  private int[] MB(String paramString)
  {
    AppMethodBeat.i(147884);
    d.g.b.p.h(paramString, "appId");
    paramString = t.a(paramString, this.jPb, this.jPc);
    AppMethodBeat.o(147884);
    return paramString;
  }
  
  private final int MD(String paramString)
  {
    AppMethodBeat.i(147872);
    String str = this.jPB.getString(paramString, "");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    try
    {
      i = Integer.parseInt(MK(paramString).jPE);
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
  
  private static b MK(String paramString)
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
    paramString = t.c(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    paramInt = bu.getInt(this.jPB.getString(paramString, ""), 0);
    AppMethodBeat.o(147879);
    return paramInt;
  }
  
  private void d(String paramString, b<? super String, z> paramb)
  {
    AppMethodBeat.i(147880);
    d.g.b.p.h(paramString, "appId");
    d.g.b.p.h(paramb, "block");
    k localk = new k("^([1-9]\\d*__)?" + paramString + "__.+$");
    paramString = this.jPB.allKeys();
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
        d.g.b.p.g(localObject, "key");
        if (localk.aB((CharSequence)localObject)) {
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
    paramString = t.c(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    this.jPB.putString(paramString, String.valueOf(paramInt2));
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
    if (W(paramInt1, paramString) + paramInt2 >= t.X(paramInt1, paramString))
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
  
  public final void MA(String paramString)
  {
    AppMethodBeat.i(147877);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147877);
      return;
    }
    if (paramString == null) {
      d.g.b.p.gkB();
    }
    int[] arrayOfInt = MB(paramString);
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      g(arrayOfInt[i], paramString, 0);
      i += 1;
    }
    d(paramString, (b)new c(this));
    t.b(paramString, this.jPb, this.jPc);
    AppMethodBeat.o(147877);
  }
  
  public final int MC(String paramString)
  {
    AppMethodBeat.i(147882);
    d.g.b.p.h(paramString, "appId");
    int[] arrayOfInt = t.a(paramString, this.jPb, this.jPc);
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
  
  public final int ML(String paramString)
  {
    AppMethodBeat.i(147881);
    d.g.b.p.h(paramString, "appId");
    y.d locald = new y.d();
    locald.NiW = 0;
    d(paramString, (b)new e(locald));
    int i = locald.NiW;
    AppMethodBeat.o(147881);
    return i;
  }
  
  public final void U(int paramInt, String paramString)
  {
    AppMethodBeat.i(147876);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147876);
      return;
    }
    if (paramInt == 0) {}
    for (String str = d.g.b.p.C(paramString, "__");; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.jPB.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        d.g.b.p.g(arrayOfString2, "key");
        if (n.nF(arrayOfString2, str)) {
          this.jPB.remove(arrayOfString2);
        }
        i += 1;
      }
    }
    if (paramString == null) {
      d.g.b.p.gkB();
    }
    g(paramInt, paramString, 0);
    t.b(paramString, paramInt, this.jPb, this.jPc);
    AppMethodBeat.o(147876);
  }
  
  public final Object[] V(int paramInt, String paramString)
  {
    AppMethodBeat.i(147878);
    if (paramString == null)
    {
      paramString = (List)d.a.v.NhH;
      AppMethodBeat.o(147878);
      return new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(0) };
    }
    List localList = (List)new ArrayList();
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.jPB.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        d.g.b.p.g(arrayOfString2, "key");
        if (n.nF(arrayOfString2, str)) {
          localList.add(n.h(arrayOfString2, str, "", false));
        }
        i += 1;
      }
    }
    int i = W(paramInt, paramString);
    paramInt = t.X(paramInt, paramString);
    AppMethodBeat.o(147878);
    return new Object[] { localList, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final p.a c(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(147869);
    d.g.b.p.h(paramString4, "dataType");
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      paramString1 = p.a.jQi;
      AppMethodBeat.o(147869);
      return paramString1;
    }
    if (paramString1 == null) {
      d.g.b.p.gkB();
    }
    if (paramString2 == null) {
      d.g.b.p.gkB();
    }
    String str = t.c(paramInt, paramString1, paramString2, "__");
    int j = MD(str);
    int i = t.cr(paramString2, paramString3);
    j = i - j;
    if (i(paramInt, paramString1, j))
    {
      paramString1 = p.a.jQk;
      AppMethodBeat.o(147869);
      return paramString1;
    }
    this.jPB.putString(str, t(paramString3, paramString4, i));
    h(paramInt, paramString1, j);
    t.a(paramString1, paramInt, this.jPb, this.jPc);
    paramString1 = p.a.jQg;
    AppMethodBeat.o(147869);
    return paramString1;
  }
  
  public final Object[] k(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147868);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      paramString1 = p.a.jQi;
      AppMethodBeat.o(147868);
      return new Object[] { paramString1 };
    }
    if (paramString1 == null) {
      d.g.b.p.gkB();
    }
    if (paramString2 == null) {
      d.g.b.p.gkB();
    }
    paramString1 = t.c(paramInt, paramString1, paramString2, "__");
    paramString2 = this.jPB.getString(paramString1, "");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    Object localObject = MK(paramString1);
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
      if (((CharSequence)((b)localObject).jPE).length() != 0) {
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
      paramString1 = p.a.jQg;
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
    paramString1 = t.jQn;
    AppMethodBeat.o(147868);
    return paramString1;
  }
  
  public final p.a l(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147875);
    if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
    {
      paramString1 = p.a.jQi;
      AppMethodBeat.o(147875);
      return paramString1;
    }
    if (paramString1 == null) {
      d.g.b.p.gkB();
    }
    if (paramString2 == null) {
      d.g.b.p.gkB();
    }
    paramString2 = t.c(paramInt, paramString1, paramString2, "__");
    int i = h(paramInt, paramString1, -MD(paramString2));
    this.jPB.remove(paramString2);
    if (i <= 0) {
      t.b(paramString1, paramInt, this.jPb, this.jPc);
    }
    paramString1 = p.a.jQg;
    AppMethodBeat.o(147875);
    return paramString1;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$Companion;", "", "()V", "CACHE", "", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "TAG", "obtain", "uin", "onAccountRelease", "", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static h sS(long paramLong)
    {
      AppMethodBeat.i(147862);
      synchronized (h.bca())
      {
        if (!h.bca().keySet().contains(Long.valueOf(paramLong))) {
          h.bca().put(Long.valueOf(paramLong), new h(paramLong, (byte)0));
        }
        z localz = z.Nhr;
        ??? = h.bca().get(Long.valueOf(paramLong));
        if (??? == null) {
          d.g.b.p.gkB();
        }
        ??? = (h)???;
        AppMethodBeat.o(147862);
        return ???;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "", "data", "", "type", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSize", "getType", "isEmpty", "", "luggage-wechat-full-sdk_release"})
  public static final class b
  {
    final String data;
    final String jPE;
    final String type;
    
    public b(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(147863);
      this.data = paramString1;
      this.type = paramString2;
      this.jPE = paramString3;
      AppMethodBeat.o(147863);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "key", "", "invoke"})
  static final class c
    extends q
    implements b<String, z>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "key", "invoke"})
  static final class d
    extends q
    implements b<String, String>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends q
    implements b<String, z>
  {
    e(y.d paramd)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "key", "", "value", "invoke"})
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