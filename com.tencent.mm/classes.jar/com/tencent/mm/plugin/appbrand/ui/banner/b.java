package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import org.json.JSONArray;
import org.json.JSONException;

final class b
{
  static boolean P(Intent paramIntent)
  {
    AppMethodBeat.i(48988);
    if (paramIntent == null)
    {
      AppMethodBeat.o(48988);
      return false;
    }
    String str1 = paramIntent.getStringExtra(a.lFi.AL());
    int j = paramIntent.getIntExtra(a.lFj.AL(), 0);
    String str2 = paramIntent.getStringExtra(a.lFk.AL());
    String str3 = paramIntent.getStringExtra(a.lFl.AL());
    String str4 = paramIntent.getStringExtra(a.lFm.AL());
    a[] arrayOfa = a.values();
    int k = arrayOfa.length;
    int i = 0;
    while (i < k)
    {
      paramIntent.removeExtra(arrayOfa[i].AL());
      i += 1;
    }
    if ((bt.isNullOrNil(str1)) || (bt.isNullOrNil(str2)))
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
    paramIntent.putExtra(a.lFi.AL(), paramString1);
    paramIntent.putExtra(a.lFj.AL(), paramInt);
    paramIntent.putExtra(a.lFk.AL(), paramString2);
    paramIntent.putExtra(a.lFl.AL(), paramString3);
    paramIntent.putExtra(a.lFm.AL(), paramString4);
    AppMethodBeat.o(48990);
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48991);
    if (!g.afw())
    {
      AppMethodBeat.o(48991);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString1);
    localJSONArray.put(String.valueOf(paramInt));
    localJSONArray.put(paramString2);
    localJSONArray.put(paramString3);
    localJSONArray.put(bt.nullAsNil(paramString4));
    paramString1 = localJSONArray.toString();
    try
    {
      g.afB().afk().set(ae.a.FlB, paramString1);
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
    if ((paramOperateTask == null) || (!g.afw()))
    {
      AppMethodBeat.o(48989);
      return false;
    }
    BannerModel localBannerModel = BannerModel.bpf();
    if (localBannerModel == null)
    {
      AppMethodBeat.o(48989);
      return false;
    }
    if ((localBannerModel.appId.equals(paramOperateTask.lFE)) && (localBannerModel.gXn == paramOperateTask.lFF))
    {
      a(localBannerModel.appId, localBannerModel.gXn, localBannerModel.appName, localBannerModel.iVP, paramOperateTask.lFG);
      AppMethodBeat.o(48989);
      return true;
    }
    AppMethodBeat.o(48989);
    return false;
  }
  
  private static Object[] boX()
  {
    AppMethodBeat.i(48992);
    if (!g.afw())
    {
      AppMethodBeat.o(48992);
      return null;
    }
    try
    {
      String str1 = (String)g.afB().afk().get(ae.a.FlB, "");
      if (bt.isNullOrNil(str1))
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
      int j = a.lFn;
      if (i != j)
      {
        AppMethodBeat.o(48992);
        return null;
      }
      Object[] arrayOfObject = new Object[a.lFn];
      i = 0;
      while (i < a.lFn)
      {
        arrayOfObject[i] = localJSONArray.optString(i, "");
        i += 1;
      }
      arrayOfObject[a.lFj.ordinal()] = Integer.valueOf(bt.getInt((String)arrayOfObject[a.lFj.ordinal()], 0));
      AppMethodBeat.o(48992);
      return arrayOfObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(48992);
    }
    return null;
  }
  
  static BannerModel boY()
  {
    AppMethodBeat.i(48993);
    Object[] arrayOfObject = boX();
    if (arrayOfObject == null)
    {
      AppMethodBeat.o(48993);
      return null;
    }
    BannerModel localBannerModel = new BannerModel();
    localBannerModel.appId = ((String)arrayOfObject[a.lFi.ordinal()]);
    localBannerModel.gXn = ((Integer)arrayOfObject[a.lFj.ordinal()]).intValue();
    localBannerModel.appName = ((String)arrayOfObject[a.lFk.ordinal()]);
    localBannerModel.iVP = ((String)arrayOfObject[a.lFl.ordinal()]);
    localBannerModel.lFM = ((String)arrayOfObject[a.lFm.ordinal()]);
    AppMethodBeat.o(48993);
    return localBannerModel;
  }
  
  static enum a
  {
    static final int lFn;
    
    static
    {
      AppMethodBeat.i(48987);
      lFi = new a("appId", 0);
      lFj = new a("versionType", 1);
      lFk = new a("appName", 2);
      lFl = new a("iconURL", 3);
      lFm = new a("customText", 4);
      lFo = new a[] { lFi, lFj, lFk, lFl, lFm };
      lFn = values().length;
      AppMethodBeat.o(48987);
    }
    
    private a() {}
    
    public final String AL()
    {
      AppMethodBeat.i(48986);
      String str = "appbrand_top_banner_in_chatting_extra_key_" + name();
      AppMethodBeat.o(48986);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.b
 * JD-Core Version:    0.7.0.1
 */