package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "uin", "", "(J)V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getter", "Lkotlin/Function1;", "", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "Companion", "StorageInfo", "luggage-wechat-full-sdk_release"})
public final class h
  implements p
{
  private static final Map<Long, h> kSk;
  public static final a kSl;
  private final b<String, String> kRJ;
  private final m<String, String, x> kRK;
  private MultiProcessMMKV kSj;
  
  static
  {
    AppMethodBeat.i(147886);
    kSl = new a((byte)0);
    kSk = (Map)new LinkedHashMap();
    AppMethodBeat.o(147886);
  }
  
  private h(long paramLong)
  {
    AppMethodBeat.i(147885);
    Log.i("AppBrandMMKVStorage", "getMMKV uin:".concat(String.valueOf(paramLong)));
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("AppBrandMMKVStorage".concat(String.valueOf(paramLong)));
    kotlin.g.b.p.g(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(NAME + uin)");
    this.kSj = localMultiProcessMMKV;
    this.kRJ = ((b)new d(this));
    this.kRK = ((m)new f(this));
    AppMethodBeat.o(147885);
  }
  
  private int[] VK(String paramString)
  {
    AppMethodBeat.i(147884);
    kotlin.g.b.p.h(paramString, "appId");
    paramString = t.a(paramString, this.kRJ, this.kRK);
    AppMethodBeat.o(147884);
    return paramString;
  }
  
  private final int VM(String paramString)
  {
    AppMethodBeat.i(147872);
    String str = this.kSj.getString(paramString, "");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    try
    {
      i = Integer.parseInt(VT(paramString).kSm);
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
  
  private static b VT(String paramString)
  {
    AppMethodBeat.i(147874);
    paramString = (CharSequence)paramString;
    paramString = ((Collection)new k("#").q(paramString, 3)).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
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
  
  private final int aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(147879);
    paramString = t.c(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    paramInt = Util.getInt(this.kSj.getString(paramString, ""), 0);
    AppMethodBeat.o(147879);
    return paramInt;
  }
  
  private void d(String paramString, b<? super String, x> paramb)
  {
    AppMethodBeat.i(147880);
    kotlin.g.b.p.h(paramString, "appId");
    kotlin.g.b.p.h(paramb, "block");
    k localk = new k("^([1-9]\\d*__)?" + paramString + "__.+$");
    paramString = this.kSj.allKeys();
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
        kotlin.g.b.p.g(localObject, "key");
        if (localk.aJ((CharSequence)localObject)) {
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
    this.kSj.putString(paramString, String.valueOf(paramInt2));
    AppMethodBeat.o(147870);
  }
  
  private final int h(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147871);
    paramInt2 = Math.max(0, aa(paramInt1, paramString) + paramInt2);
    g(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(147871);
    return paramInt2;
  }
  
  private final boolean i(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147883);
    if (aa(paramInt1, paramString) + paramInt2 >= t.ab(paramInt1, paramString))
    {
      AppMethodBeat.o(147883);
      return true;
    }
    AppMethodBeat.o(147883);
    return false;
  }
  
  private static String s(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(147873);
    paramString1 = paramString2 + "#" + paramInt + "#" + paramString1;
    AppMethodBeat.o(147873);
    return paramString1;
  }
  
  public final void VJ(String paramString)
  {
    AppMethodBeat.i(147877);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147877);
      return;
    }
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    int[] arrayOfInt = VK(paramString);
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      g(arrayOfInt[i], paramString, 0);
      i += 1;
    }
    d(paramString, (b)new c(this));
    t.b(paramString, this.kRJ, this.kRK);
    AppMethodBeat.o(147877);
  }
  
  public final int VL(String paramString)
  {
    AppMethodBeat.i(147882);
    kotlin.g.b.p.h(paramString, "appId");
    int[] arrayOfInt = t.a(paramString, this.kRJ, this.kRK);
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = aa(arrayOfInt[j], paramString);
      j += 1;
    }
    AppMethodBeat.o(147882);
    return i;
  }
  
  public final int VU(String paramString)
  {
    AppMethodBeat.i(147881);
    kotlin.g.b.p.h(paramString, "appId");
    z.d locald = new z.d();
    locald.SYE = 0;
    d(paramString, (b)new h.e(locald));
    int i = locald.SYE;
    AppMethodBeat.o(147881);
    return i;
  }
  
  public final void Y(int paramInt, String paramString)
  {
    AppMethodBeat.i(147876);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147876);
      return;
    }
    if (paramInt == 0) {}
    for (String str = kotlin.g.b.p.I(paramString, "__");; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.kSj.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        kotlin.g.b.p.g(arrayOfString2, "key");
        if (n.J(arrayOfString2, str, false)) {
          this.kSj.remove(arrayOfString2);
        }
        i += 1;
      }
    }
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    g(paramInt, paramString, 0);
    t.b(paramString, paramInt, this.kRJ, this.kRK);
    AppMethodBeat.o(147876);
  }
  
  public final Object[] Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(147878);
    if (paramString == null)
    {
      paramString = (List)v.SXr;
      AppMethodBeat.o(147878);
      return new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(0) };
    }
    List localList = (List)new ArrayList();
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.kSj.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        kotlin.g.b.p.g(arrayOfString2, "key");
        if (n.J(arrayOfString2, str, false)) {
          localList.add(n.j(arrayOfString2, str, "", false));
        }
        i += 1;
      }
    }
    int i = aa(paramInt, paramString);
    paramInt = t.ab(paramInt, paramString);
    AppMethodBeat.o(147878);
    return new Object[] { localList, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final p.a c(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(147869);
    kotlin.g.b.p.h(paramString4, "dataType");
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = p.a.kSR;
      AppMethodBeat.o(147869);
      return paramString1;
    }
    if (paramString1 == null) {
      kotlin.g.b.p.hyc();
    }
    if (paramString2 == null) {
      kotlin.g.b.p.hyc();
    }
    String str = t.c(paramInt, paramString1, paramString2, "__");
    int j = VM(str);
    int i = t.cF(paramString2, paramString3);
    j = i - j;
    if (i(paramInt, paramString1, j))
    {
      paramString1 = p.a.kST;
      AppMethodBeat.o(147869);
      return paramString1;
    }
    this.kSj.putString(str, s(paramString3, paramString4, i));
    h(paramInt, paramString1, j);
    t.a(paramString1, paramInt, this.kRJ, this.kRK);
    paramString1 = p.a.kSP;
    AppMethodBeat.o(147869);
    return paramString1;
  }
  
  public final Object[] l(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147868);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = p.a.kSR;
      AppMethodBeat.o(147868);
      return new Object[] { paramString1 };
    }
    if (paramString1 == null) {
      kotlin.g.b.p.hyc();
    }
    if (paramString2 == null) {
      kotlin.g.b.p.hyc();
    }
    paramString1 = t.c(paramInt, paramString1, paramString2, "__");
    paramString2 = this.kSj.getString(paramString1, "");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    Object localObject = VT(paramString1);
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
      if (((CharSequence)((b)localObject).kSm).length() != 0) {
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
      paramString1 = p.a.kSP;
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
    paramString1 = t.kSW;
    AppMethodBeat.o(147868);
    return paramString1;
  }
  
  public final p.a m(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147875);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = p.a.kSR;
      AppMethodBeat.o(147875);
      return paramString1;
    }
    if (paramString1 == null) {
      kotlin.g.b.p.hyc();
    }
    if (paramString2 == null) {
      kotlin.g.b.p.hyc();
    }
    paramString2 = t.c(paramInt, paramString1, paramString2, "__");
    int i = h(paramInt, paramString1, -VM(paramString2));
    this.kSj.remove(paramString2);
    if (i <= 0) {
      t.b(paramString1, paramInt, this.kRJ, this.kRK);
    }
    paramString1 = p.a.kSP;
    AppMethodBeat.o(147875);
    return paramString1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$Companion;", "", "()V", "CACHE", "", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "TAG", "obtain", "uin", "onAccountRelease", "", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static h AY(long paramLong)
    {
      AppMethodBeat.i(147862);
      synchronized (h.bxp())
      {
        if (!h.bxp().keySet().contains(Long.valueOf(paramLong))) {
          h.bxp().put(Long.valueOf(paramLong), new h(paramLong, (byte)0));
        }
        x localx = x.SXb;
        ??? = h.bxp().get(Long.valueOf(paramLong));
        if (??? == null) {
          kotlin.g.b.p.hyc();
        }
        ??? = (h)???;
        AppMethodBeat.o(147862);
        return ???;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "", "data", "", "type", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSize", "getType", "isEmpty", "", "luggage-wechat-full-sdk_release"})
  public static final class b
  {
    final String data;
    final String kSm;
    final String type;
    
    public b(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(147863);
      this.data = paramString1;
      this.type = paramString2;
      this.kSm = paramString3;
      AppMethodBeat.o(147863);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "key", "", "invoke"})
  static final class c
    extends q
    implements b<String, x>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "key", "invoke"})
  static final class d
    extends q
    implements b<String, String>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "key", "", "value", "invoke"})
  static final class f
    extends q
    implements m<String, String, x>
  {
    f(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.h
 * JD-Core Version:    0.7.0.1
 */