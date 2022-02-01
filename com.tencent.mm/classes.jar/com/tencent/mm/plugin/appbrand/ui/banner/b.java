package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONArray;
import org.json.JSONException;

final class b
{
  static boolean O(Intent paramIntent)
  {
    AppMethodBeat.i(48988);
    if (paramIntent == null)
    {
      AppMethodBeat.o(48988);
      return false;
    }
    String str1 = paramIntent.getStringExtra(a.rbE.key());
    int j = paramIntent.getIntExtra(a.rbF.key(), 0);
    String str2 = paramIntent.getStringExtra(a.rbG.key());
    String str3 = paramIntent.getStringExtra(a.rbH.key());
    String str4 = paramIntent.getStringExtra(a.rbI.key());
    a[] arrayOfa = a.values();
    int k = arrayOfa.length;
    int i = 0;
    while (i < k)
    {
      paramIntent.removeExtra(arrayOfa[i].key());
      i += 1;
    }
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
    {
      AppMethodBeat.o(48988);
      return false;
    }
    a(str1, j, str2, str3, str4);
    AppMethodBeat.o(48988);
    return true;
  }
  
  static void a(Intent paramIntent, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48990);
    if (paramIntent == null)
    {
      AppMethodBeat.o(48990);
      return;
    }
    paramIntent.putExtra(a.rbE.key(), paramString1);
    paramIntent.putExtra(a.rbF.key(), paramInt);
    paramIntent.putExtra(a.rbG.key(), paramString2);
    paramIntent.putExtra(a.rbH.key(), paramString3);
    paramIntent.putExtra(a.rbI.key(), paramString4);
    AppMethodBeat.o(48990);
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48991);
    if (!h.aHB())
    {
      AppMethodBeat.o(48991);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString1);
    localJSONArray.put(String.valueOf(paramInt));
    localJSONArray.put(paramString2);
    localJSONArray.put(paramString3);
    localJSONArray.put(Util.nullAsNil(paramString4));
    paramString1 = localJSONArray.toString();
    try
    {
      h.aHG().aHp().set(ar.a.Vmh, paramString1);
      return;
    }
    finally
    {
      AppMethodBeat.o(48991);
    }
  }
  
  static boolean a(AppBrandStickyBannerLogic.OperateTask paramOperateTask)
  {
    AppMethodBeat.i(48989);
    if ((paramOperateTask == null) || (!h.aHB()))
    {
      AppMethodBeat.o(48989);
      return false;
    }
    BannerModel localBannerModel = BannerModel.ckQ();
    if (localBannerModel == null)
    {
      AppMethodBeat.o(48989);
      return false;
    }
    if ((localBannerModel.appId.equals(paramOperateTask.rbU)) && (localBannerModel.cBU == paramOperateTask.rbV))
    {
      a(localBannerModel.appId, localBannerModel.cBU, localBannerModel.appName, localBannerModel.nQm, paramOperateTask.rbW);
      AppMethodBeat.o(48989);
      return true;
    }
    AppMethodBeat.o(48989);
    return false;
  }
  
  private static Object[] ckJ()
  {
    AppMethodBeat.i(48992);
    if (!h.aHB())
    {
      AppMethodBeat.o(48992);
      return null;
    }
    try
    {
      String str1 = (String)h.aHG().aHp().get(ar.a.Vmh, "");
      if (Util.isNullOrNil(str1))
      {
        AppMethodBeat.o(48992);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(48992);
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(str2);
      int i = localJSONArray.length();
      int j = a.rbJ;
      if (i != j)
      {
        AppMethodBeat.o(48992);
        return null;
      }
      Object[] arrayOfObject = new Object[a.rbJ];
      i = 0;
      while (i < a.rbJ)
      {
        arrayOfObject[i] = localJSONArray.optString(i, "");
        i += 1;
      }
      arrayOfObject[a.rbF.ordinal()] = Integer.valueOf(Util.getInt((String)arrayOfObject[a.rbF.ordinal()], 0));
      AppMethodBeat.o(48992);
      return arrayOfObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(48992);
    }
    return null;
  }
  
  static BannerModel ckK()
  {
    AppMethodBeat.i(48993);
    Object[] arrayOfObject = ckJ();
    if (arrayOfObject == null)
    {
      AppMethodBeat.o(48993);
      return null;
    }
    BannerModel localBannerModel = new BannerModel();
    localBannerModel.appId = ((String)arrayOfObject[a.rbE.ordinal()]);
    localBannerModel.cBU = ((Integer)arrayOfObject[a.rbF.ordinal()]).intValue();
    localBannerModel.appName = ((String)arrayOfObject[a.rbG.ordinal()]);
    localBannerModel.nQm = ((String)arrayOfObject[a.rbH.ordinal()]);
    localBannerModel.rcc = ((String)arrayOfObject[a.rbI.ordinal()]);
    AppMethodBeat.o(48993);
    return localBannerModel;
  }
  
  static enum a
  {
    static final int rbJ;
    
    static
    {
      AppMethodBeat.i(48987);
      rbE = new a("appId", 0);
      rbF = new a("versionType", 1);
      rbG = new a("appName", 2);
      rbH = new a("iconURL", 3);
      rbI = new a("customText", 4);
      rbK = new a[] { rbE, rbF, rbG, rbH, rbI };
      rbJ = values().length;
      AppMethodBeat.o(48987);
    }
    
    private a() {}
    
    public final String key()
    {
      AppMethodBeat.i(48986);
      String str = "appbrand_top_banner_in_chatting_extra_key_" + name();
      AppMethodBeat.o(48986);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.b
 * JD-Core Version:    0.7.0.1
 */