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
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "uin", "", "(J)V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getter", "Lkotlin/Function1;", "", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "Companion", "StorageInfo", "luggage-wechat-full-sdk_release"})
public final class g
  implements q
{
  private static final Map<Long, g> nMo;
  public static final a nMp;
  private final b<String, String> nLR;
  private final m<String, String, x> nLS;
  private MultiProcessMMKV nMn;
  
  static
  {
    AppMethodBeat.i(147886);
    nMp = new a((byte)0);
    nMo = (Map)new LinkedHashMap();
    AppMethodBeat.o(147886);
  }
  
  private g(long paramLong)
  {
    AppMethodBeat.i(147885);
    Log.i("AppBrandMMKVStorage", "getMMKV uin:".concat(String.valueOf(paramLong)));
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("AppBrandMMKVStorage".concat(String.valueOf(paramLong)));
    p.j(localMultiProcessMMKV, "MultiProcessMMKV.getMMKV(NAME + uin)");
    this.nMn = localMultiProcessMMKV;
    this.nLR = ((b)new d(this));
    this.nLS = ((m)new f(this));
    AppMethodBeat.o(147885);
  }
  
  private final int ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(147879);
    paramString = v.c(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    paramInt = Util.getInt(this.nMn.getString(paramString, ""), 0);
    AppMethodBeat.o(147879);
    return paramInt;
  }
  
  private static g.b adE(String paramString)
  {
    AppMethodBeat.i(147874);
    paramString = (CharSequence)paramString;
    paramString = ((Collection)new k("#").u(paramString, 3)).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(147874);
      throw paramString;
    }
    paramString = (String[])paramString;
    if (paramString.length == 3)
    {
      paramString = new g.b(paramString[2], paramString[0], paramString[1]);
      AppMethodBeat.o(147874);
      return paramString;
    }
    paramString = new g.b("", "", "");
    AppMethodBeat.o(147874);
    return paramString;
  }
  
  private int[] adv(String paramString)
  {
    AppMethodBeat.i(147884);
    p.k(paramString, "appId");
    paramString = v.a(paramString, this.nLR, this.nLS);
    AppMethodBeat.o(147884);
    return paramString;
  }
  
  private final int adx(String paramString)
  {
    AppMethodBeat.i(147872);
    String str = this.nMn.getString(paramString, "");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    try
    {
      i = Integer.parseInt(adE(paramString).nMq);
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
  
  private void d(String paramString, b<? super String, x> paramb)
  {
    AppMethodBeat.i(147880);
    p.k(paramString, "appId");
    p.k(paramb, "block");
    k localk = new k("^([1-9]\\d*__)?" + paramString + "__.+$");
    paramString = this.nMn.allKeys();
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
        p.j(localObject, "key");
        if (localk.aY((CharSequence)localObject)) {
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
    paramString = v.c(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    this.nMn.putString(paramString, String.valueOf(paramInt2));
    AppMethodBeat.o(147870);
  }
  
  private final int h(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147871);
    paramInt2 = Math.max(0, ac(paramInt1, paramString) + paramInt2);
    g(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(147871);
    return paramInt2;
  }
  
  private final boolean i(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147883);
    if (ac(paramInt1, paramString) + paramInt2 >= v.ad(paramInt1, paramString))
    {
      AppMethodBeat.o(147883);
      return true;
    }
    AppMethodBeat.o(147883);
    return false;
  }
  
  private static String v(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(147873);
    paramString1 = paramString2 + "#" + paramInt + "#" + paramString1;
    AppMethodBeat.o(147873);
    return paramString1;
  }
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(147876);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147876);
      return;
    }
    if (paramInt == 0) {}
    for (String str = p.I(paramString, "__");; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.nMn.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        p.j(arrayOfString2, "key");
        if (n.M(arrayOfString2, str, false)) {
          this.nMn.remove(arrayOfString2);
        }
        i += 1;
      }
    }
    if (paramString == null) {
      p.iCn();
    }
    g(paramInt, paramString, 0);
    v.b(paramString, paramInt, this.nLR, this.nLS);
    AppMethodBeat.o(147876);
  }
  
  public final Object[] ab(int paramInt, String paramString)
  {
    AppMethodBeat.i(147878);
    if (paramString == null)
    {
      paramString = (List)kotlin.a.v.aaAd;
      AppMethodBeat.o(147878);
      return new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(0) };
    }
    List localList = (List)new ArrayList();
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.nMn.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        p.j(arrayOfString2, "key");
        if (n.M(arrayOfString2, str, false)) {
          localList.add(n.l(arrayOfString2, str, "", false));
        }
        i += 1;
      }
    }
    int i = ac(paramInt, paramString);
    paramInt = v.ad(paramInt, paramString);
    AppMethodBeat.o(147878);
    return new Object[] { localList, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final int adF(String paramString)
  {
    AppMethodBeat.i(147881);
    p.k(paramString, "appId");
    aa.d locald = new aa.d();
    locald.aaBA = 0;
    d(paramString, (b)new g.e(locald));
    int i = locald.aaBA;
    AppMethodBeat.o(147881);
    return i;
  }
  
  public final void adu(String paramString)
  {
    AppMethodBeat.i(147877);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147877);
      return;
    }
    if (paramString == null) {
      p.iCn();
    }
    int[] arrayOfInt = adv(paramString);
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      g(arrayOfInt[i], paramString, 0);
      i += 1;
    }
    d(paramString, (b)new c(this));
    v.b(paramString, this.nLR, this.nLS);
    AppMethodBeat.o(147877);
  }
  
  public final int adw(String paramString)
  {
    AppMethodBeat.i(147882);
    p.k(paramString, "appId");
    int[] arrayOfInt = v.a(paramString, this.nLR, this.nLS);
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = ac(arrayOfInt[j], paramString);
      j += 1;
    }
    AppMethodBeat.o(147882);
    return i;
  }
  
  public final q.a d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(147869);
    p.k(paramString4, "dataType");
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = q.a.nNp;
      AppMethodBeat.o(147869);
      return paramString1;
    }
    if (paramString1 == null) {
      p.iCn();
    }
    if (paramString2 == null) {
      p.iCn();
    }
    String str = v.c(paramInt, paramString1, paramString2, "__");
    int j = adx(str);
    int i = v.cP(paramString2, paramString3);
    j = i - j;
    if (i(paramInt, paramString1, j))
    {
      paramString1 = q.a.nNr;
      AppMethodBeat.o(147869);
      return paramString1;
    }
    this.nMn.putString(str, v(paramString3, paramString4, i));
    h(paramInt, paramString1, j);
    v.a(paramString1, paramInt, this.nLR, this.nLS);
    paramString1 = q.a.nNn;
    AppMethodBeat.o(147869);
    return paramString1;
  }
  
  public final Object[] l(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147868);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = q.a.nNp;
      AppMethodBeat.o(147868);
      return new Object[] { paramString1 };
    }
    if (paramString1 == null) {
      p.iCn();
    }
    if (paramString2 == null) {
      p.iCn();
    }
    paramString1 = v.c(paramInt, paramString1, paramString2, "__");
    paramString2 = this.nMn.getString(paramString1, "");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    Object localObject = adE(paramString1);
    if (((CharSequence)((g.b)localObject).data).length() == 0)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label217;
      }
      if (((CharSequence)((g.b)localObject).type).length() != 0) {
        break label207;
      }
      paramInt = 1;
      label129:
      if (paramInt == 0) {
        break label217;
      }
      if (((CharSequence)((g.b)localObject).nMq).length() != 0) {
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
      paramString1 = q.a.nNn;
      paramString2 = ((g.b)localObject).data;
      localObject = ((g.b)localObject).type;
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
    paramString1 = v.nNu;
    AppMethodBeat.o(147868);
    return paramString1;
  }
  
  public final q.a m(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147875);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = q.a.nNp;
      AppMethodBeat.o(147875);
      return paramString1;
    }
    if (paramString1 == null) {
      p.iCn();
    }
    if (paramString2 == null) {
      p.iCn();
    }
    paramString2 = v.c(paramInt, paramString1, paramString2, "__");
    int i = h(paramInt, paramString1, -adx(paramString2));
    this.nMn.remove(paramString2);
    if (i <= 0) {
      v.b(paramString1, paramInt, this.nLR, this.nLS);
    }
    paramString1 = q.a.nNn;
    AppMethodBeat.o(147875);
    return paramString1;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$Companion;", "", "()V", "CACHE", "", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "TAG", "obtain", "uin", "onAccountRelease", "", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static g Hk(long paramLong)
    {
      AppMethodBeat.i(147862);
      synchronized (g.bIz())
      {
        if (!g.bIz().keySet().contains(Long.valueOf(paramLong))) {
          g.bIz().put(Long.valueOf(paramLong), new g(paramLong, (byte)0));
        }
        x localx = x.aazN;
        ??? = g.bIz().get(Long.valueOf(paramLong));
        if (??? == null) {
          p.iCn();
        }
        ??? = (g)???;
        AppMethodBeat.o(147862);
        return ???;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "key", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements b<String, x>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "key", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements b<String, String>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "key", "", "value", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements m<String, String, x>
  {
    f(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.g
 * JD-Core Version:    0.7.0.1
 */