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
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "uin", "", "storageFileNamePrefix", "", "(JLjava/lang/String;)V", "<set-?>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "MMKV", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "dataSize", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "Companion", "StorageInfo", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements v
{
  private static final Map<Long, l> qLS;
  public static final a qMo;
  private final b<String, String> qLU;
  private final m<String, String, ah> qLV;
  MultiProcessMMKV qMp;
  
  static
  {
    AppMethodBeat.i(147886);
    qMo = new a((byte)0);
    qLS = (Map)new LinkedHashMap();
    AppMethodBeat.o(147886);
  }
  
  public l(long paramLong, String paramString)
  {
    AppMethodBeat.i(323266);
    Log.i("AppBrandMMKVStorage", s.X("getMMKV uin:", Long.valueOf(paramLong)));
    int i;
    if (((CharSequence)paramString).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label114;
      }
      paramString = MultiProcessMMKV.getMMKV(s.X(paramString, Long.valueOf(paramLong)));
      s.s(paramString, "{\n            MultiProce…mePrefix + uin)\n        }");
    }
    for (;;)
    {
      this.qMp = paramString;
      this.qLU = ((b)new d(this));
      this.qLV = ((m)new f(this));
      AppMethodBeat.o(323266);
      return;
      i = 0;
      break;
      label114:
      paramString = MultiProcessMMKV.getMMKV(s.X("AppBrandMMKVStorage", Long.valueOf(paramLong)));
      s.s(paramString, "{\n            MultiProce…MKV(NAME + uin)\n        }");
    }
  }
  
  private static String B(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(147873);
    paramString1 = paramString2 + '#' + paramInt + '#' + paramString1;
    AppMethodBeat.o(147873);
    return paramString1;
  }
  
  private final int VY(String paramString)
  {
    AppMethodBeat.i(147872);
    String str = this.qMp.getString(paramString, "");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    try
    {
      i = Integer.parseInt(Wf(paramString).qMq);
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
  
  private static l.b Wf(String paramString)
  {
    AppMethodBeat.i(147874);
    paramString = (CharSequence)paramString;
    paramString = ((Collection)new k("#").o(paramString, 3)).toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(147874);
      throw paramString;
    }
    paramString = (String[])paramString;
    if (paramString.length == 3)
    {
      paramString = new l.b(paramString[2], paramString[0], paramString[1]);
      AppMethodBeat.o(147874);
      return paramString;
    }
    paramString = new l.b("", "", "");
    AppMethodBeat.o(147874);
    return paramString;
  }
  
  private final int ak(int paramInt, String paramString)
  {
    AppMethodBeat.i(147879);
    paramString = aa.c(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    paramInt = Util.getInt(this.qMp.getString(paramString, ""), 0);
    AppMethodBeat.o(147879);
    return paramInt;
  }
  
  private void d(String paramString, b<? super String, ah> paramb)
  {
    AppMethodBeat.i(147880);
    s.u(paramString, "appId");
    s.u(paramb, "block");
    k localk = new k("^([1-9]\\d*__)?" + paramString + "__.+$");
    paramString = this.qMp.allKeys();
    int j;
    int i;
    if (paramString == null)
    {
      paramString = new String[0];
      j = paramString.length;
      i = 0;
    }
    label133:
    for (;;)
    {
      if (i < j)
      {
        Object localObject = paramString[i];
        i += 1;
        s.s(localObject, "key");
        if (!localk.bm((CharSequence)localObject)) {
          break label133;
        }
        paramb.invoke(localObject);
        continue;
        break;
      }
      AppMethodBeat.o(147880);
      return;
    }
  }
  
  private final void g(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147870);
    paramString = aa.c(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    this.qMp.putString(paramString, String.valueOf(paramInt2));
    AppMethodBeat.o(147870);
  }
  
  private final int h(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147871);
    paramInt2 = Math.max(0, ak(paramInt1, paramString) + paramInt2);
    g(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(147871);
    return paramInt2;
  }
  
  private final boolean i(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147883);
    if (ak(paramInt1, paramString) + paramInt2 >= aa.al(paramInt1, paramString))
    {
      AppMethodBeat.o(147883);
      return true;
    }
    AppMethodBeat.o(147883);
    return false;
  }
  
  public static final l jA(long paramLong)
  {
    AppMethodBeat.i(323286);
    l locall = a.jA(paramLong);
    AppMethodBeat.o(323286);
    return locall;
  }
  
  public final int VT(String paramString)
  {
    AppMethodBeat.i(147882);
    s.u(paramString, "appId");
    int[] arrayOfInt = aa.a(paramString, this.qLU, this.qLV);
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = ak(m, paramString) + i)
    {
      m = arrayOfInt[j];
      j += 1;
    }
    AppMethodBeat.o(147882);
    return i;
  }
  
  public final void VW(String paramString)
  {
    AppMethodBeat.i(147877);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147877);
      return;
    }
    s.checkNotNull(paramString);
    int[] arrayOfInt = VX(paramString);
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      i += 1;
      g(k, paramString, 0);
    }
    d(paramString, (b)new c(this));
    aa.b(paramString, this.qLU, this.qLV);
    AppMethodBeat.o(147877);
  }
  
  public final int[] VX(String paramString)
  {
    AppMethodBeat.i(147884);
    s.u(paramString, "appId");
    paramString = aa.a(paramString, this.qLU, this.qLV);
    AppMethodBeat.o(147884);
    return paramString;
  }
  
  public final int Wg(String paramString)
  {
    AppMethodBeat.i(147881);
    s.u(paramString, "appId");
    ah.d locald = new ah.d();
    d(paramString, (b)new l.e(locald));
    int i = locald.aixb;
    AppMethodBeat.o(147881);
    return i;
  }
  
  public final v.a a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(323290);
    s.u(paramString4, "dataType");
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = v.a.qNi;
      AppMethodBeat.o(323290);
      return paramString1;
    }
    s.checkNotNull(paramString1);
    s.checkNotNull(paramString2);
    paramString2 = aa.c(paramInt1, paramString1, paramString2, "__");
    int i = paramInt2 - VY(paramString2);
    if (i(paramInt1, paramString1, i))
    {
      paramString1 = v.a.qNk;
      AppMethodBeat.o(323290);
      return paramString1;
    }
    this.qMp.putString(paramString2, B(paramString3, paramString4, paramInt2));
    h(paramInt1, paramString1, i);
    aa.a(paramString1, paramInt1, this.qLU, this.qLV);
    paramString1 = v.a.qNg;
    AppMethodBeat.o(323290);
    return paramString1;
  }
  
  public final void ai(int paramInt, String paramString)
  {
    AppMethodBeat.i(147876);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147876);
      return;
    }
    if (paramInt == 0) {}
    for (String str = s.X(paramString, "__");; str = paramInt + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.qMp.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int k = arrayOfString1.length;
      int i = 0;
      while (i < k)
      {
        arrayOfString2 = arrayOfString1[i];
        int j = i + 1;
        s.s(arrayOfString2, "key");
        i = j;
        if (n.U(arrayOfString2, str, false))
        {
          this.qMp.remove(arrayOfString2);
          i = j;
        }
      }
    }
    s.checkNotNull(paramString);
    g(paramInt, paramString, 0);
    aa.b(paramString, paramInt, this.qLU, this.qLV);
    AppMethodBeat.o(147876);
  }
  
  public final Object[] aj(int paramInt, String paramString)
  {
    AppMethodBeat.i(147878);
    if (paramString == null)
    {
      paramString = (List)ab.aivy;
      AppMethodBeat.o(147878);
      return new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(0) };
    }
    List localList = (List)new ArrayList();
    if (paramInt == 0) {}
    for (String str = s.X(paramString, "__");; str = paramInt + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.qMp.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int k = arrayOfString1.length;
      i = 0;
      while (i < k)
      {
        arrayOfString2 = arrayOfString1[i];
        int j = i + 1;
        s.s(arrayOfString2, "key");
        i = j;
        if (n.U(arrayOfString2, str, false))
        {
          localList.add(n.bV(arrayOfString2, str, ""));
          i = j;
        }
      }
    }
    int i = ak(paramInt, paramString);
    paramInt = aa.al(paramInt, paramString);
    AppMethodBeat.o(147878);
    return new Object[] { localList, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final v.a d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(147869);
    s.u(paramString4, "dataType");
    paramString1 = a(paramInt, paramString1, paramString2, paramString3, paramString4, aa.dg(paramString2, paramString3));
    AppMethodBeat.o(147869);
    return paramString1;
  }
  
  public final v.a o(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147875);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = v.a.qNi;
      AppMethodBeat.o(147875);
      return paramString1;
    }
    s.checkNotNull(paramString1);
    s.checkNotNull(paramString2);
    paramString2 = aa.c(paramInt, paramString1, paramString2, "__");
    int i = h(paramInt, paramString1, -VY(paramString2));
    this.qMp.remove(paramString2);
    if (i <= 0) {
      aa.b(paramString1, paramInt, this.qLU, this.qLV);
    }
    paramString1 = v.a.qNg;
    AppMethodBeat.o(147875);
    return paramString1;
  }
  
  public final Object[] p(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147868);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = v.a.qNi;
      AppMethodBeat.o(147868);
      return new Object[] { paramString1 };
    }
    s.checkNotNull(paramString1);
    s.checkNotNull(paramString2);
    paramString1 = aa.c(paramInt, paramString1, paramString2, "__");
    paramString2 = this.qMp.getString(paramString1, "");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    Object localObject = Wf(paramString1);
    if (((CharSequence)((l.b)localObject).data).length() == 0)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label211;
      }
      if (((CharSequence)((l.b)localObject).type).length() != 0) {
        break label201;
      }
      paramInt = 1;
      label123:
      if (paramInt == 0) {
        break label211;
      }
      if (((CharSequence)((l.b)localObject).qMq).length() != 0) {
        break label206;
      }
      paramInt = 1;
      label145:
      if (paramInt == 0) {
        break label211;
      }
    }
    label201:
    label206:
    label211:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label216;
      }
      paramString1 = v.a.qNg;
      paramString2 = ((l.b)localObject).data;
      localObject = ((l.b)localObject).type;
      AppMethodBeat.o(147868);
      return new Object[] { paramString1, paramString2, localObject };
      paramInt = 0;
      break;
      paramInt = 0;
      break label123;
      paramInt = 0;
      break label145;
    }
    label216:
    paramString1 = aa.qNo;
    AppMethodBeat.o(147868);
    return paramString1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$Companion;", "", "()V", "CACHE", "", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "TAG", "obtain", "uin", "onAccountRelease", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static l jA(long paramLong)
    {
      AppMethodBeat.i(147862);
      synchronized (l.chW())
      {
        if (!l.chW().keySet().contains(Long.valueOf(paramLong))) {
          l.chW().put(Long.valueOf(paramLong), new l(paramLong));
        }
        ah localah = ah.aiuX;
        ??? = l.chW().get(Long.valueOf(paramLong));
        s.checkNotNull(???);
        ??? = (l)???;
        AppMethodBeat.o(147862);
        return ???;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "key", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<String, ah>
  {
    c(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "key"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<String, String>
  {
    d(l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "key", "", "value"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<String, String, ah>
  {
    f(l paraml)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.l
 * JD-Core Version:    0.7.0.1
 */