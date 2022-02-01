package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.e;
import d.a.j;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appstorage/KVStorageUtil;", "", "()V", "INTERNAL_KEY_SEPARATOR", "", "MAX_STORAGE_ID", "", "NORMAL_KEY_SEPARATOR", "RET_GET_NO_SUCH_KEY", "", "[Ljava/lang/Object;", "TOTAL_DATA_SIZE_KEY", "TOTAL_STORAGE_ID_KEY", "addStorageId", "", "appId", "storageId", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "calculateDataSize", "key", "data", "checkStorageIdInvalid", "", "generateInternalRecordKey", "generateRecordKey", "separator", "getAllStorageId", "", "getQuota", "removeStorageId", "removeStorageIdAll", "luggage-wechat-full-sdk_release"})
public final class s
{
  public static final Object[] jtg;
  public static final s jth;
  
  static
  {
    AppMethodBeat.i(147897);
    jth = new s();
    jtg = new Object[] { o.a.jtc };
    AppMethodBeat.o(147897);
  }
  
  public static final int V(int paramInt, String paramString)
  {
    AppMethodBeat.i(147896);
    k.h(paramString, "appId");
    if (k.g("wxGlobal", paramString))
    {
      paramInt = AppBrandGlobalSystemConfig.bat().jCB;
      AppMethodBeat.o(147896);
      return paramInt;
    }
    if ((paramInt == 0) || (paramInt == 2))
    {
      paramInt = com.tencent.mm.plugin.appbrand.config.m.JW(paramString);
      AppMethodBeat.o(147896);
      return paramInt;
    }
    paramInt = com.tencent.mm.plugin.appbrand.config.m.JX(paramString);
    AppMethodBeat.o(147896);
    return paramInt;
  }
  
  public static final void a(String paramString, int paramInt, b<? super String, String> paramb, d.g.a.m<? super String, ? super String, y> paramm)
  {
    AppMethodBeat.i(147893);
    k.h(paramString, "appId");
    k.h(paramb, "getter");
    k.h(paramm, "setter");
    paramb = a(paramString, paramb, paramm);
    if (e.contains(paramb, paramInt))
    {
      AppMethodBeat.o(147893);
      return;
    }
    paramb = new JSONArray((Collection)e.N(paramb));
    paramb.put(paramInt);
    paramString = cp(paramString, "@@@TOTAL@STORAGE@ID@@@");
    paramb = paramb.toString();
    k.g(paramb, "json.toString()");
    paramm.n(paramString, paramb);
    AppMethodBeat.o(147893);
  }
  
  public static final int[] a(String paramString, b<? super String, String> paramb, d.g.a.m<? super String, ? super String, y> paramm)
  {
    AppMethodBeat.i(147892);
    k.h(paramString, "appId");
    k.h(paramb, "getter");
    k.h(paramm, "setter");
    paramString = cp(paramString, "@@@TOTAL@STORAGE@ID@@@");
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147892);
      return new int[] { 0 };
    }
    paramString = (String)paramb.ay(paramString);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147892);
      return new int[] { 0 };
    }
    paramString = new JSONArray(paramString);
    if (paramString.length() <= 0)
    {
      AppMethodBeat.o(147892);
      return new int[] { 0 };
    }
    int j = paramString.length();
    paramb = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      paramb.add(Integer.valueOf(paramString.getInt(i)));
      i += 1;
    }
    paramString = (List)paramb;
    if (!paramString.contains(Integer.valueOf(0))) {
      paramString.add(Integer.valueOf(0));
    }
    paramString = j.q((Collection)paramString);
    AppMethodBeat.o(147892);
    return paramString;
  }
  
  public static final void b(String paramString, int paramInt, b<? super String, String> paramb, d.g.a.m<? super String, ? super String, y> paramm)
  {
    AppMethodBeat.i(147894);
    k.h(paramString, "appId");
    k.h(paramb, "getter");
    k.h(paramm, "setter");
    paramb = e.Q(a(paramString, paramb, paramm));
    paramb.remove(Integer.valueOf(paramInt));
    paramString = cp(paramString, "@@@TOTAL@STORAGE@ID@@@");
    paramb = new JSONArray((Collection)paramb).toString();
    k.g(paramb, "JSONArray(list).toString()");
    paramm.n(paramString, paramb);
    AppMethodBeat.o(147894);
  }
  
  public static final void b(String paramString, b<? super String, String> paramb, d.g.a.m<? super String, ? super String, y> paramm)
  {
    AppMethodBeat.i(147895);
    k.h(paramString, "appId");
    k.h(paramb, "getter");
    k.h(paramm, "setter");
    paramm.n(cp(paramString, "@@@TOTAL@STORAGE@ID@@@"), "");
    AppMethodBeat.o(147895);
  }
  
  public static final String c(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147888);
    k.h(paramString1, "appId");
    k.h(paramString2, "key");
    k.h(paramString3, "separator");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(paramInt).append(paramString3);
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    k.g(paramString1, "sb.toString()");
    AppMethodBeat.o(147888);
    return paramString1;
  }
  
  public static final int co(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147889);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    int i = str.length();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    int j = paramString1.length();
    AppMethodBeat.o(147889);
    return i + j;
  }
  
  private static String cp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147891);
    k.h(paramString1, "appId");
    k.h(paramString2, "key");
    paramString1 = c(0, paramString1, paramString2, "++");
    AppMethodBeat.o(147891);
    return paramString1;
  }
  
  public static final String m(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147890);
    k.h(paramString1, "appId");
    k.h(paramString2, "key");
    paramString1 = c(paramInt, paramString1, paramString2, "++");
    AppMethodBeat.o(147890);
    return paramString1;
  }
  
  public static final boolean rv(int paramInt)
  {
    if (paramInt < 0) {}
    while (paramInt > 2) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.s
 * JD-Core Version:    0.7.0.1
 */