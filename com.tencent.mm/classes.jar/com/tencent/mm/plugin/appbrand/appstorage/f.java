package com.tencent.mm.plugin.appbrand.appstorage;

import a.f.a.b;
import a.f.b.j;
import a.f.b.u.c;
import a.l;
import a.l.k;
import a.v;
import a.y;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage;", "uin", "", "(J)V", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getter", "Lkotlin/Function1;", "", "setter", "Lkotlin/Function2;", "", "appendTotalDataSize", "", "storageId", "appId", "size", "clear", "clearAll", "generateValue", "data", "dataType", "get", "", "", "key", "(ILjava/lang/String;Ljava/lang/String;)[Ljava/lang/Object;", "getAllStorageId", "", "getDataSize", "recordKey", "getQuota", "getTotalDataSize", "getTotalDataSizeAll", "info", "(ILjava/lang/String;)[Ljava/lang/Object;", "keys", "block", "keysSize", "remove", "Lcom/tencent/mm/plugin/appbrand/appstorage/IAppBrandKVStorage$ErrorType;", "set", "setTotalDataSize", "splitValue", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandMMKVStorage$StorageInfo;", "str", "willReachQuota", "", "Companion", "StorageInfo", "luggage-wechat-full-sdk_release"})
public final class f
  implements m
{
  private static final Map<Long, f> gZw;
  public static final f.a gZx;
  private final b<String, String> gYY;
  private final a.f.a.m<String, String, y> gYZ;
  private as gZv;
  
  static
  {
    AppMethodBeat.i(102456);
    gZx = new f.a((byte)0);
    gZw = (Map)new LinkedHashMap();
    AppMethodBeat.o(102456);
  }
  
  private f(long paramLong)
  {
    AppMethodBeat.i(141003);
    d.i("AppBrandMMKVStorage", "getMMKV uin:".concat(String.valueOf(paramLong)));
    as localas = as.apq("AppBrandMMKVStorage".concat(String.valueOf(paramLong)));
    j.p(localas, "MultiProcessMMKV.getMMKV(NAME + uin)");
    this.gZv = localas;
    this.gYY = ((b)new f.d(this));
    this.gYZ = ((a.f.a.m)new f.f(this));
    AppMethodBeat.o(141003);
  }
  
  private final int K(int paramInt, String paramString)
  {
    AppMethodBeat.i(102452);
    paramString = r.c(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    paramInt = bo.getInt(this.gZv.getString(paramString, ""), 0);
    AppMethodBeat.o(102452);
    return paramInt;
  }
  
  private void a(String paramString, b<? super String, y> paramb)
  {
    AppMethodBeat.i(102453);
    j.q(paramString, "appId");
    j.q(paramb, "block");
    k localk = new k("^([1-9]\\d*__)?" + paramString + "__.+$");
    paramString = this.gZv.allKeys();
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
        j.p(localObject, "key");
        if (localk.ao((CharSequence)localObject)) {
          paramb.S(localObject);
        }
        i += 1;
      }
      AppMethodBeat.o(102453);
      return;
    }
  }
  
  private final void e(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(102444);
    paramString = r.c(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    this.gZv.putString(paramString, String.valueOf(paramInt2));
    AppMethodBeat.o(102444);
  }
  
  private final int f(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(102445);
    paramInt2 = Math.max(0, K(paramInt1, paramString) + paramInt2);
    e(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(102445);
    return paramInt2;
  }
  
  private final boolean g(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(141001);
    if (K(paramInt1, paramString) + paramInt2 >= r.L(paramInt1, paramString))
    {
      AppMethodBeat.o(141001);
      return true;
    }
    AppMethodBeat.o(141001);
    return false;
  }
  
  private static String l(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(141000);
    paramString1 = paramString2 + "#" + paramInt + "#" + paramString1;
    AppMethodBeat.o(141000);
    return paramString1;
  }
  
  private int[] yS(String paramString)
  {
    AppMethodBeat.i(141002);
    j.q(paramString, "appId");
    paramString = r.a(paramString, this.gYY, this.gYZ);
    AppMethodBeat.o(141002);
    return paramString;
  }
  
  private final int yU(String paramString)
  {
    AppMethodBeat.i(102446);
    String str = this.gZv.getString(paramString, "");
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    try
    {
      i = Integer.parseInt(zb(paramString).size);
      AppMethodBeat.o(102446);
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
  
  private static f.b zb(String paramString)
  {
    AppMethodBeat.i(102447);
    paramString = (CharSequence)paramString;
    paramString = (Collection)new k("#").s(paramString, 3);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type java.util.Collection<T>");
      AppMethodBeat.o(102447);
      throw paramString;
    }
    paramString = paramString.toArray(new String[0]);
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(102447);
      throw paramString;
    }
    paramString = (String[])paramString;
    if (paramString.length == 3)
    {
      paramString = new f.b(paramString[2], paramString[0], paramString[1]);
      AppMethodBeat.o(102447);
      return paramString;
    }
    paramString = new f.b("", "", "");
    AppMethodBeat.o(102447);
    return paramString;
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(102449);
    j.q(paramString, "appId");
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.gZv.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        j.p(arrayOfString2, "key");
        if (a.l.m.jw(arrayOfString2, str)) {
          this.gZv.remove(arrayOfString2);
        }
        i += 1;
      }
    }
    e(paramInt, paramString, 0);
    r.b(paramString, paramInt, this.gYY, this.gYZ);
    AppMethodBeat.o(102449);
  }
  
  public final Object[] J(int paramInt, String paramString)
  {
    AppMethodBeat.i(102451);
    j.q(paramString, "appId");
    List localList = (List)new ArrayList();
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = String.valueOf(paramInt) + "__" + paramString + "__")
    {
      String[] arrayOfString2 = this.gZv.allKeys();
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null) {
        arrayOfString1 = new String[0];
      }
      int j = arrayOfString1.length;
      i = 0;
      while (i < j)
      {
        arrayOfString2 = arrayOfString1[i];
        j.p(arrayOfString2, "key");
        if (a.l.m.jw(arrayOfString2, str)) {
          localList.add(a.l.m.h(arrayOfString2, str, "", false));
        }
        i += 1;
      }
    }
    int i = K(paramInt, paramString);
    paramInt = r.L(paramInt, paramString);
    AppMethodBeat.o(102451);
    return new Object[] { localList, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final m.a b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(102443);
    j.q(paramString1, "appId");
    j.q(paramString2, "key");
    j.q(paramString4, "dataType");
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      paramString1 = m.a.gZX;
      AppMethodBeat.o(102443);
      return paramString1;
    }
    String str = r.c(paramInt, paramString1, paramString2, "__");
    int j = yU(str);
    int i = r.bB(paramString2, paramString3);
    j = i - j;
    if (g(paramInt, paramString1, j))
    {
      paramString1 = m.a.gZZ;
      AppMethodBeat.o(102443);
      return paramString1;
    }
    this.gZv.putString(str, l(paramString3, paramString4, i));
    f(paramInt, paramString1, j);
    r.a(paramString1, paramInt, this.gYY, this.gYZ);
    paramString1 = m.a.gZV;
    AppMethodBeat.o(102443);
    return paramString1;
  }
  
  public final Object[] k(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(102442);
    j.q(paramString1, "appId");
    j.q(paramString2, "key");
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      paramString1 = m.a.gZX;
      AppMethodBeat.o(102442);
      return new Object[] { paramString1 };
    }
    paramString1 = r.c(paramInt, paramString1, paramString2, "__");
    paramString2 = this.gZv.getString(paramString1, "");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    Object localObject = zb(paramString1);
    if (((CharSequence)((f.b)localObject).data).length() == 0)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label215;
      }
      if (((CharSequence)((f.b)localObject).type).length() != 0) {
        break label205;
      }
      paramInt = 1;
      label127:
      if (paramInt == 0) {
        break label215;
      }
      if (((CharSequence)((f.b)localObject).size).length() != 0) {
        break label210;
      }
      paramInt = 1;
      label149:
      if (paramInt == 0) {
        break label215;
      }
    }
    label205:
    label210:
    label215:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label220;
      }
      paramString1 = m.a.gZV;
      paramString2 = ((f.b)localObject).data;
      localObject = ((f.b)localObject).type;
      AppMethodBeat.o(102442);
      return new Object[] { paramString1, paramString2, localObject };
      paramInt = 0;
      break;
      paramInt = 0;
      break label127;
      paramInt = 0;
      break label149;
    }
    label220:
    paramString1 = r.hab;
    AppMethodBeat.o(102442);
    return paramString1;
  }
  
  public final m.a l(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(102448);
    j.q(paramString1, "appId");
    j.q(paramString2, "key");
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      paramString1 = m.a.gZX;
      AppMethodBeat.o(102448);
      return paramString1;
    }
    paramString2 = r.c(paramInt, paramString1, paramString2, "__");
    int i = f(paramInt, paramString1, -yU(paramString2));
    this.gZv.remove(paramString2);
    if (i <= 0) {
      r.b(paramString1, paramInt, this.gYY, this.gYZ);
    }
    paramString1 = m.a.gZV;
    AppMethodBeat.o(102448);
    return paramString1;
  }
  
  public final void yR(String paramString)
  {
    AppMethodBeat.i(102450);
    j.q(paramString, "appId");
    int[] arrayOfInt = yS(paramString);
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      e(arrayOfInt[i], paramString, 0);
      i += 1;
    }
    a(paramString, (b)new f.c(this));
    r.b(paramString, this.gYY, this.gYZ);
    AppMethodBeat.o(102450);
  }
  
  public final int yT(String paramString)
  {
    AppMethodBeat.i(102455);
    j.q(paramString, "appId");
    int[] arrayOfInt = r.a(paramString, this.gYY, this.gYZ);
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = K(arrayOfInt[j], paramString);
      j += 1;
    }
    AppMethodBeat.o(102455);
    return i;
  }
  
  public final int zc(String paramString)
  {
    AppMethodBeat.i(102454);
    j.q(paramString, "appId");
    u.c localc = new u.c();
    localc.BNp = 0;
    a(paramString, (b)new f.e(localc));
    int i = localc.BNp;
    AppMethodBeat.o(102454);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.f
 * JD-Core Version:    0.7.0.1
 */