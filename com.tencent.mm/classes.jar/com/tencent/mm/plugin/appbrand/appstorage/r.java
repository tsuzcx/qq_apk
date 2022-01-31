package com.tencent.mm.plugin.appbrand.appstorage;

import a.a.e;
import a.f.a.b;
import a.f.a.m;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/appstorage/KVStorageUtil;", "", "()V", "INTERNAL_KEY_SEPARATOR", "", "MAX_STORAGE_ID", "", "NORMAL_KEY_SEPARATOR", "RET_GET_NO_SUCH_KEY", "", "[Ljava/lang/Object;", "TOTAL_DATA_SIZE_KEY", "TOTAL_STORAGE_ID_KEY", "addStorageId", "", "appId", "storageId", "getter", "Lkotlin/Function1;", "setter", "Lkotlin/Function2;", "calculateDataSize", "key", "data", "checkStorageIdInvalid", "", "generateInternalRecordKey", "generateRecordKey", "separator", "getAllStorageId", "", "getQuota", "removeStorageId", "removeStorageIdAll", "luggage-wechat-full-sdk_release"})
public final class r
{
  public static final Object[] hab;
  public static final r hac;
  
  static
  {
    AppMethodBeat.i(102467);
    hac = new r();
    hab = new Object[] { m.a.gZY };
    AppMethodBeat.o(102467);
  }
  
  public static final int L(int paramInt, String paramString)
  {
    AppMethodBeat.i(102466);
    a.f.b.j.q(paramString, "appId");
    if (a.f.b.j.e("wxGlobal", paramString))
    {
      paramInt = AppBrandGlobalSystemConfig.ayt().hhG;
      AppMethodBeat.o(102466);
      return paramInt;
    }
    if (paramInt == 0)
    {
      paramInt = com.tencent.mm.plugin.appbrand.config.j.Ac(paramString);
      AppMethodBeat.o(102466);
      return paramInt;
    }
    paramInt = com.tencent.mm.plugin.appbrand.config.j.Ad(paramString);
    AppMethodBeat.o(102466);
    return paramInt;
  }
  
  public static final void a(String paramString, int paramInt, b<? super String, String> paramb, m<? super String, ? super String, y> paramm)
  {
    AppMethodBeat.i(102463);
    a.f.b.j.q(paramString, "appId");
    a.f.b.j.q(paramb, "getter");
    a.f.b.j.q(paramm, "setter");
    paramb = a(paramString, paramb, paramm);
    if (e.contains(paramb, paramInt))
    {
      AppMethodBeat.o(102463);
      return;
    }
    paramb = new JSONArray((Collection)e.L(paramb));
    paramb.put(paramInt);
    paramString = bC(paramString, "@@@TOTAL@STORAGE@ID@@@");
    paramb = paramb.toString();
    a.f.b.j.p(paramb, "json.toString()");
    paramm.h(paramString, paramb);
    AppMethodBeat.o(102463);
  }
  
  public static final int[] a(String paramString, b<? super String, String> paramb, m<? super String, ? super String, y> paramm)
  {
    AppMethodBeat.i(102462);
    a.f.b.j.q(paramString, "appId");
    a.f.b.j.q(paramb, "getter");
    a.f.b.j.q(paramm, "setter");
    paramString = bC(paramString, "@@@TOTAL@STORAGE@ID@@@");
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102462);
      return new int[] { 0 };
    }
    paramString = (String)paramb.S(paramString);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102462);
      return new int[] { 0 };
    }
    paramString = new JSONArray(paramString);
    if (paramString.length() <= 0)
    {
      AppMethodBeat.o(102462);
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
    paramString = a.a.j.f((Collection)paramString);
    AppMethodBeat.o(102462);
    return paramString;
  }
  
  public static final void b(String paramString, int paramInt, b<? super String, String> paramb, m<? super String, ? super String, y> paramm)
  {
    AppMethodBeat.i(102464);
    a.f.b.j.q(paramString, "appId");
    a.f.b.j.q(paramb, "getter");
    a.f.b.j.q(paramm, "setter");
    paramb = e.O(a(paramString, paramb, paramm));
    paramb.remove(Integer.valueOf(paramInt));
    paramString = bC(paramString, "@@@TOTAL@STORAGE@ID@@@");
    paramb = new JSONArray((Collection)paramb).toString();
    a.f.b.j.p(paramb, "JSONArray(list).toString()");
    paramm.h(paramString, paramb);
    AppMethodBeat.o(102464);
  }
  
  public static final void b(String paramString, b<? super String, String> paramb, m<? super String, ? super String, y> paramm)
  {
    AppMethodBeat.i(102465);
    a.f.b.j.q(paramString, "appId");
    a.f.b.j.q(paramb, "getter");
    a.f.b.j.q(paramm, "setter");
    paramm.h(bC(paramString, "@@@TOTAL@STORAGE@ID@@@"), "");
    AppMethodBeat.o(102465);
  }
  
  public static final int bB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102459);
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
    AppMethodBeat.o(102459);
    return i + j;
  }
  
  private static String bC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102461);
    a.f.b.j.q(paramString1, "appId");
    a.f.b.j.q(paramString2, "key");
    paramString1 = c(0, paramString1, paramString2, "++");
    AppMethodBeat.o(102461);
    return paramString1;
  }
  
  public static final String c(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(102458);
    a.f.b.j.q(paramString1, "appId");
    a.f.b.j.q(paramString2, "key");
    a.f.b.j.q(paramString3, "separator");
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt > 0) {
      localStringBuilder.append(paramInt).append(paramString3);
    }
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    a.f.b.j.p(paramString1, "sb.toString()");
    AppMethodBeat.o(102458);
    return paramString1;
  }
  
  public static final String m(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(102460);
    a.f.b.j.q(paramString1, "appId");
    a.f.b.j.q(paramString2, "key");
    paramString1 = c(paramInt, paramString1, paramString2, "++");
    AppMethodBeat.o(102460);
    return paramString1;
  }
  
  public static final boolean nq(int paramInt)
  {
    if (paramInt < 0) {}
    while (paramInt > 1) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.r
 * JD-Core Version:    0.7.0.1
 */