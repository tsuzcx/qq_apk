package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import org.json.JSONArray;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/KVStorageUtil;", "", "()V", "INTERNAL_KEY_SEPARATOR", "", "MAX_STORAGE_ID", "", "NORMAL_KEY_SEPARATOR", "RET_GET_NO_SUCH_KEY", "", "[Ljava/lang/Object;", "TOTAL_DATA_SIZE_KEY", "TOTAL_STORAGE_ID_KEY", "addStorageId", "", "appId", "storageId", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "calculateDataSize", "key", "data", "checkStorageIdInvalid", "", "generateInternalRecordKey", "generateRecordKey", "separator", "getAllStorageId", "", "getQuota", "removeStorageId", "removeStorageIdAll", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final aa qNn;
  public static final Object[] qNo;
  
  static
  {
    AppMethodBeat.i(147897);
    qNn = new aa();
    qNo = new Object[] { v.a.qNj };
    AppMethodBeat.o(147897);
  }
  
  public static final void a(String paramString, int paramInt, b<? super String, String> paramb, m<? super String, ? super String, ah> paramm)
  {
    AppMethodBeat.i(147893);
    s.u(paramString, "appId");
    s.u(paramb, "getter");
    s.u(paramm, "setter");
    paramb = a(paramString, paramb, paramm);
    if (k.contains(paramb, paramInt))
    {
      AppMethodBeat.o(147893);
      return;
    }
    paramb = new JSONArray((Collection)k.Y(paramb));
    paramb.put(paramInt);
    paramString = dh(paramString, "@@@TOTAL@STORAGE@ID@@@");
    paramb = paramb.toString();
    s.s(paramb, "json.toString()");
    paramm.invoke(paramString, paramb);
    AppMethodBeat.o(147893);
  }
  
  public static final int[] a(String paramString, b<? super String, String> paramb, m<? super String, ? super String, ah> paramm)
  {
    AppMethodBeat.i(147892);
    s.u(paramString, "appId");
    s.u(paramb, "getter");
    s.u(paramm, "setter");
    paramString = dh(paramString, "@@@TOTAL@STORAGE@ID@@@");
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(147892);
      return new int[] { 0 };
    }
    paramString = (String)paramb.invoke(paramString);
    if (Util.isNullOrNil(paramString))
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
    paramString = kotlin.a.p.I((Collection)paramString);
    AppMethodBeat.o(147892);
    return paramString;
  }
  
  public static final int al(int paramInt, String paramString)
  {
    AppMethodBeat.i(147896);
    s.u(paramString, "appId");
    if (s.p("wxGlobal", paramString))
    {
      paramInt = AppBrandGlobalSystemConfig.ckD().qWO;
      AppMethodBeat.o(147896);
      return paramInt;
    }
    if ((paramInt == 0) || (paramInt == 2))
    {
      paramInt = com.tencent.mm.plugin.appbrand.config.p.Xu(paramString);
      AppMethodBeat.o(147896);
      return paramInt;
    }
    paramInt = com.tencent.mm.plugin.appbrand.config.p.Xv(paramString);
    AppMethodBeat.o(147896);
    return paramInt;
  }
  
  public static final void b(String paramString, int paramInt, b<? super String, String> paramb, m<? super String, ? super String, ah> paramm)
  {
    AppMethodBeat.i(147894);
    s.u(paramString, "appId");
    s.u(paramb, "getter");
    s.u(paramm, "setter");
    paramb = k.af(a(paramString, paramb, paramm));
    paramb.remove(Integer.valueOf(paramInt));
    paramString = dh(paramString, "@@@TOTAL@STORAGE@ID@@@");
    paramb = new JSONArray((Collection)paramb).toString();
    s.s(paramb, "JSONArray(list).toString()");
    paramm.invoke(paramString, paramb);
    AppMethodBeat.o(147894);
  }
  
  public static final void b(String paramString, b<? super String, String> paramb, m<? super String, ? super String, ah> paramm)
  {
    AppMethodBeat.i(147895);
    s.u(paramString, "appId");
    s.u(paramb, "getter");
    s.u(paramm, "setter");
    paramm.invoke(dh(paramString, "@@@TOTAL@STORAGE@ID@@@"), "");
    AppMethodBeat.o(147895);
  }
  
  public static final String c(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(147888);
    s.u(paramString1, "appId");
    s.u(paramString2, "key");
    s.u(paramString3, "separator");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(paramInt).append(paramString3);
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    s.s(paramString1, "sb.toString()");
    AppMethodBeat.o(147888);
    return paramString1;
  }
  
  public static final int dg(String paramString1, String paramString2)
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
  
  private static String dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147891);
    s.u(paramString1, "appId");
    s.u(paramString2, "key");
    paramString1 = c(0, paramString1, paramString2, "++");
    AppMethodBeat.o(147891);
    return paramString1;
  }
  
  public static final String q(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(147890);
    s.u(paramString1, "appId");
    s.u(paramString2, "key");
    paramString1 = c(paramInt, paramString1, paramString2, "++");
    AppMethodBeat.o(147890);
    return paramString1;
  }
  
  public static final boolean zs(int paramInt)
  {
    if (paramInt < 0) {}
    while (paramInt > 2) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.aa
 * JD-Core Version:    0.7.0.1
 */