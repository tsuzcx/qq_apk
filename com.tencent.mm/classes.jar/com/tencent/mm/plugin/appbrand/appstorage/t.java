package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.e;
import d.a.j;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appstorage/KVStorageUtil;", "", "()V", "INTERNAL_KEY_SEPARATOR", "", "MAX_STORAGE_ID", "", "NORMAL_KEY_SEPARATOR", "RET_GET_NO_SUCH_KEY", "", "[Ljava/lang/Object;", "TOTAL_DATA_SIZE_KEY", "TOTAL_STORAGE_ID_KEY", "addStorageId", "", "appId", "storageId", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "calculateDataSize", "key", "data", "checkStorageIdInvalid", "", "generateInternalRecordKey", "generateRecordKey", "separator", "getAllStorageId", "", "getQuota", "removeStorageId", "removeStorageIdAll", "luggage-wechat-full-sdk_release"})
public final class t
{
  public static final Object[] jQn;
  public static final t jQo;
  
  static
  {
    AppMethodBeat.i(147897);
    jQo = new t();
    jQn = new Object[] { p.a.jQj };
    AppMethodBeat.o(147897);
  }
  
  public static final int X(int paramInt, String paramString)
  {
    AppMethodBeat.i(147896);
    p.h(paramString, "appId");
    if (p.i("wxGlobal", paramString))
    {
      paramInt = AppBrandGlobalSystemConfig.bez().jZM;
      AppMethodBeat.o(147896);
      return paramInt;
    }
    if ((paramInt == 0) || (paramInt == 2))
    {
      paramInt = com.tencent.mm.plugin.appbrand.config.m.NX(paramString);
      AppMethodBeat.o(147896);
      return paramInt;
    }
    paramInt = com.tencent.mm.plugin.appbrand.config.m.NY(paramString);
    AppMethodBeat.o(147896);
    return paramInt;
  }
  
  public static final void a(String paramString, int paramInt, b<? super String, String> paramb, d.g.a.m<? super String, ? super String, z> paramm)
  {
    AppMethodBeat.i(147893);
    p.h(paramString, "appId");
    p.h(paramb, "getter");
    p.h(paramm, "setter");
    paramb = a(paramString, paramb, paramm);
    if (e.contains(paramb, paramInt))
    {
      AppMethodBeat.o(147893);
      return;
    }
    paramb = new JSONArray((Collection)e.O(paramb));
    paramb.put(paramInt);
    paramString = cs(paramString, "@@@TOTAL@STORAGE@ID@@@");
    paramb = paramb.toString();
    p.g(paramb, "json.toString()");
    paramm.p(paramString, paramb);
    AppMethodBeat.o(147893);
  }
  
  public static final int[] a(String paramString, b<? super String, String> paramb, d.g.a.m<? super String, ? super String, z> paramm)
  {
    AppMethodBeat.i(147892);
    p.h(paramString, "appId");
    p.h(paramb, "getter");
    p.h(paramm, "setter");
    paramString = cs(paramString, "@@@TOTAL@STORAGE@ID@@@");
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147892);
      return new int[] { 0 };
    }
    paramString = (String)paramb.invoke(paramString);
    if (bu.isNullOrNil(paramString))
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
    paramString = j.r((Collection)paramString);
    AppMethodBeat.o(147892);
    return paramString;
  }
  
  public static final void b(String paramString, int paramInt, b<? super String, String> paramb, d.g.a.m<? super String, ? super String, z> paramm)
  {
    AppMethodBeat.i(147894);
    p.h(paramString, "appId");
    p.h(paramb, "getter");
    p.h(paramm, "setter");
    paramb = e.R(a(paramString, paramb, paramm));
    paramb.remove(Integer.valueOf(paramInt));
    paramString = cs(paramString, "@@@TOTAL@STORAGE@ID@@@");
    paramb = new JSONArray((Collection)paramb).toString();
    p.g(paramb, "JSONArray(list).toString()");
    paramm.p(paramString, paramb);
    AppMethodBeat.o(147894);
  }
  
  public static final void b(String paramString, b<? super String, String> paramb, d.g.a.m<? super String, ? super String, z> paramm)
  {
    AppMethodBeat.i(147895);
    p.h(paramString, "appId");
    p.h(paramb, "getter");
    p.h(paramm, "setter");
    paramm.p(cs(paramString, "@@@TOTAL@STORAGE@ID@@@"), "");
    AppMethodBeat.o(147895);
  }
  
  public static final String c(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147888);
    p.h(paramString1, "appId");
    p.h(paramString2, "key");
    p.h(paramString3, "separator");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(paramInt).append(paramString3);
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    p.g(paramString1, "sb.toString()");
    AppMethodBeat.o(147888);
    return paramString1;
  }
  
  public static final int cr(String paramString1, String paramString2)
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
  
  private static String cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147891);
    p.h(paramString1, "appId");
    p.h(paramString2, "key");
    paramString1 = c(0, paramString1, paramString2, "++");
    AppMethodBeat.o(147891);
    return paramString1;
  }
  
  public static final String m(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147890);
    p.h(paramString1, "appId");
    p.h(paramString2, "key");
    paramString1 = c(paramInt, paramString1, paramString2, "++");
    AppMethodBeat.o(147890);
    return paramString1;
  }
  
  public static final boolean rY(int paramInt)
  {
    if (paramInt < 0) {}
    while (paramInt > 2) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.t
 * JD-Core Version:    0.7.0.1
 */