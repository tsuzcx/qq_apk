package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.b;
import d.g.a.m;
import d.g.b.v.c;
import d.n.n;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "uin", "", "(J)V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getter", "Lkotlin/Function1;", "", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "Companion", "StorageInfo", "luggage-wechat-full-sdk_release"})
public final class h
  implements o
{
  private static final Map<Long, h> iSl;
  public static final a iSm;
  private final b<String, String> iRK;
  private final m<String, String, y> iRL;
  private ax iSk;
  
  static
  {
    AppMethodBeat.i(147886);
    iSm = new a((byte)0);
    iSl = (Map)new LinkedHashMap();
    AppMethodBeat.o(147886);
  }
  
  private h(long paramLong)
  {
    AppMethodBeat.i(147885);
    ad.i("AppBrandMMKVStorage", "getMMKV uin:".concat(String.valueOf(paramLong)));
    ax localax = ax.aFC("AppBrandMMKVStorage".concat(String.valueOf(paramLong)));
    d.g.b.k.g(localax, "MultiProcessMMKV.getMMKV(NAME + uin)");
    this.iSk = localax;
    this.iRK = ((b)new d(this));
    this.iRL = ((m)new f(this));
    AppMethodBeat.o(147885);
  }
  
  private int[] ED(String paramString)
  {
    AppMethodBeat.i(147884);
    d.g.b.k.h(paramString, "appId");
    paramString = s.a(paramString, this.iRK, this.iRL);
    AppMethodBeat.o(147884);
    return paramString;
  }
  
  private final int EF(String paramString)
  {
    AppMethodBeat.i(147872);
    String str = this.iSk.getString(paramString, "");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    try
    {
      i = Integer.parseInt(EM(paramString).iSn);
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
  
  private static b EM(String paramString)
  {
    AppMethodBeat.i(147874);
    paramString = (CharSequence)paramString;
    paramString = ((Collection)new d.n.k("#").r(paramString, 3)).toArray(new String[0]);
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
  
  private final int T(int paramInt, String paramString)
  {
    AppMethodBeat.i(147879);
    paramString = s.c(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    paramInt = bt.getInt(this.iSk.getString(paramString, ""), 0);
    AppMethodBeat.o(147879);
    return paramInt;
  }
  
  private void c(String paramString, b<? super String, y> paramb)
  {
    AppMethodBeat.i(147880);
    d.g.b.k.h(paramString, "appId");
    d.g.b.k.h(paramb, "block");
    d.n.k localk = new d.n.k("^([1-9]\\d*__)?" + paramString + "__.+$");
    paramString = this.iSk.allKeys();
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
        d.g.b.k.g(localObject, "key");
        if (localk.aA((CharSequence)localObject)) {
          paramb.aA(localObject);
        }
        i += 1;
      }
      AppMethodBeat.o(147880);
      return;
    }
  }
  
  private final void f(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147870);
    paramString = s.c(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    this.iSk.putString(paramString, String.valueOf(paramInt2));
    AppMethodBeat.o(147870);
  }
  
  private final int g(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147871);
    paramInt2 = Math.max(0, T(paramInt1, paramString) + paramInt2);
    f(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(147871);
    return paramInt2;
  }
  
  private final boolean h(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(147883);
    if (T(paramInt1, paramString) + paramInt2 >= s.U(paramInt1, paramString))
    {
      AppMethodBeat.o(147883);
      return true;
    }
    AppMethodBeat.o(147883);
    return false;
  }
  
  private static String r(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(147873);
    paramString1 = paramString2 + "#" + paramInt + "#" + paramString1;
    AppMethodBeat.o(147873);
    return paramString1;
  }
  
  public final void EC(String paramString)
  {
    AppMethodBeat.i(147877);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147877);
      return;
    }
    if (paramString == null) {
      d.g.b.k.fvU();
    }
    int[] arrayOfInt = ED(paramString);
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      f(arrayOfInt[i], paramString, 0);
      i += 1;
    }
    c(paramString, (b)new c(this));
    s.b(paramString, this.iRK, this.iRL);
    AppMethodBeat.o(147877);
  }
  
  public final int EE(String paramString)
  {
    AppMethodBeat.i(147882);
    d.g.b.k.h(paramString, "appId");
    int[] arrayOfInt = s.a(paramString, this.iRK, this.iRL);
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = T(arrayOfInt[j], paramString);
      j += 1;
    }
    AppMethodBeat.o(147882);
    return i;
  }
  
  public final int EN(String paramString)
  {
    AppMethodBeat.i(147881);
    d.g.b.k.h(paramString, "appId");
    v.c localc = new v.c();
    localc.Jhu = 0;
    c(paramString, (b)new e(localc));
    int i = localc.Jhu;
    AppMethodBeat.o(147881);
    return i;
  }
  
  public final void R(int paramInt, String paramString)
  {
    AppMethodBeat.i(147876);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147876);
      return;
    }
    if (paramInt == 0) {}
    for (String str = d.g.b.k.C(paramString, "__");; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.iSk.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        d.g.b.k.g(arrayOfString2, "key");
        if (n.mA(arrayOfString2, str)) {
          this.iSk.remove(arrayOfString2);
        }
        i += 1;
      }
    }
    if (paramString == null) {
      d.g.b.k.fvU();
    }
    f(paramInt, paramString, 0);
    s.b(paramString, paramInt, this.iRK, this.iRL);
    AppMethodBeat.o(147876);
  }
  
  public final Object[] S(int paramInt, String paramString)
  {
    AppMethodBeat.i(147878);
    if (paramString == null)
    {
      paramString = (List)d.a.v.Jgl;
      AppMethodBeat.o(147878);
      return new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(0) };
    }
    List localList = (List)new ArrayList();
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.iSk.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        d.g.b.k.g(arrayOfString2, "key");
        if (n.mA(arrayOfString2, str)) {
          localList.add(n.h(arrayOfString2, str, "", false));
        }
        i += 1;
      }
    }
    int i = T(paramInt, paramString);
    paramInt = s.U(paramInt, paramString);
    AppMethodBeat.o(147878);
    return new Object[] { localList, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final o.a c(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(147869);
    d.g.b.k.h(paramString4, "dataType");
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      paramString1 = o.a.iSQ;
      AppMethodBeat.o(147869);
      return paramString1;
    }
    if (paramString1 == null) {
      d.g.b.k.fvU();
    }
    if (paramString2 == null) {
      d.g.b.k.fvU();
    }
    String str = s.c(paramInt, paramString1, paramString2, "__");
    int j = EF(str);
    int i = s.cf(paramString2, paramString3);
    j = i - j;
    if (h(paramInt, paramString1, j))
    {
      paramString1 = o.a.iSS;
      AppMethodBeat.o(147869);
      return paramString1;
    }
    this.iSk.putString(str, r(paramString3, paramString4, i));
    g(paramInt, paramString1, j);
    s.a(paramString1, paramInt, this.iRK, this.iRL);
    paramString1 = o.a.iSO;
    AppMethodBeat.o(147869);
    return paramString1;
  }
  
  public final Object[] l(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147868);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      paramString1 = o.a.iSQ;
      AppMethodBeat.o(147868);
      return new Object[] { paramString1 };
    }
    if (paramString1 == null) {
      d.g.b.k.fvU();
    }
    if (paramString2 == null) {
      d.g.b.k.fvU();
    }
    paramString1 = s.c(paramInt, paramString1, paramString2, "__");
    paramString2 = this.iSk.getString(paramString1, "");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    Object localObject = EM(paramString1);
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
      if (((CharSequence)((b)localObject).iSn).length() != 0) {
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
      paramString1 = o.a.iSO;
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
    paramString1 = s.iSV;
    AppMethodBeat.o(147868);
    return paramString1;
  }
  
  public final o.a m(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147875);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      paramString1 = o.a.iSQ;
      AppMethodBeat.o(147875);
      return paramString1;
    }
    if (paramString1 == null) {
      d.g.b.k.fvU();
    }
    if (paramString2 == null) {
      d.g.b.k.fvU();
    }
    paramString2 = s.c(paramInt, paramString1, paramString2, "__");
    int i = g(paramInt, paramString1, -EF(paramString2));
    this.iSk.remove(paramString2);
    if (i <= 0) {
      s.b(paramString1, paramInt, this.iRK, this.iRL);
    }
    paramString1 = o.a.iSO;
    AppMethodBeat.o(147875);
    return paramString1;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$Companion;", "", "()V", "CACHE", "", "", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "NAME", "", "NORMAL_VALUE_TYPE_SEPARATOR", "TAG", "obtain", "uin", "onAccountRelease", "", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static h mS(long paramLong)
    {
      AppMethodBeat.i(147862);
      synchronized (h.aRf())
      {
        if (!h.aRf().keySet().contains(Long.valueOf(paramLong))) {
          h.aRf().put(Long.valueOf(paramLong), new h(paramLong, (byte)0));
        }
        y localy = y.JfV;
        ??? = h.aRf().get(Long.valueOf(paramLong));
        if (??? == null) {
          d.g.b.k.fvU();
        }
        ??? = (h)???;
        AppMethodBeat.o(147862);
        return ???;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "", "data", "", "type", "size", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSize", "getType", "isEmpty", "", "luggage-wechat-full-sdk_release"})
  public static final class b
  {
    final String data;
    final String iSn;
    final String type;
    
    public b(String paramString1, String paramString2, String paramString3)
    {
      AppMethodBeat.i(147863);
      this.data = paramString1;
      this.type = paramString2;
      this.iSn = paramString3;
      AppMethodBeat.o(147863);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "key", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements b<String, y>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "key", "invoke"})
  static final class d
    extends d.g.b.l
    implements b<String, String>
  {
    d(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements b<String, y>
  {
    e(v.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "", "key", "", "value", "invoke"})
  static final class f
    extends d.g.b.l
    implements m<String, String, y>
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