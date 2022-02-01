package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import org.json.JSONArray;
import org.json.JSONException;

final class b
{
  static boolean Q(Intent paramIntent)
  {
    AppMethodBeat.i(48988);
    if (paramIntent == null)
    {
      AppMethodBeat.o(48988);
      return false;
    }
    String str1 = paramIntent.getStringExtra(a.nZT.Lb());
    int j = paramIntent.getIntExtra(a.nZU.Lb(), 0);
    String str2 = paramIntent.getStringExtra(a.nZV.Lb());
    String str3 = paramIntent.getStringExtra(a.nZW.Lb());
    String str4 = paramIntent.getStringExtra(a.nZX.Lb());
    a[] arrayOfa = a.values();
    int k = arrayOfa.length;
    int i = 0;
    while (i < k)
    {
      paramIntent.removeExtra(arrayOfa[i].Lb());
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
    paramIntent.putExtra(a.nZT.Lb(), paramString1);
    paramIntent.putExtra(a.nZU.Lb(), paramInt);
    paramIntent.putExtra(a.nZV.Lb(), paramString2);
    paramIntent.putExtra(a.nZW.Lb(), paramString3);
    paramIntent.putExtra(a.nZX.Lb(), paramString4);
    AppMethodBeat.o(48990);
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48991);
    if (!g.aAc())
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
      g.aAh().azQ().set(ar.a.NYh, paramString1);
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
    if ((paramOperateTask == null) || (!g.aAc()))
    {
      AppMethodBeat.o(48989);
      return false;
    }
    BannerModel localBannerModel = BannerModel.bYf();
    if (localBannerModel == null)
    {
      AppMethodBeat.o(48989);
      return false;
    }
    if ((localBannerModel.appId.equals(paramOperateTask.oap)) && (localBannerModel.iOo == paramOperateTask.oaq))
    {
      a(localBannerModel.appId, localBannerModel.iOo, localBannerModel.appName, localBannerModel.kVZ, paramOperateTask.oar);
      AppMethodBeat.o(48989);
      return true;
    }
    AppMethodBeat.o(48989);
    return false;
  }
  
  private static Object[] bXY()
  {
    AppMethodBeat.i(48992);
    if (!g.aAc())
    {
      AppMethodBeat.o(48992);
      return null;
    }
    try
    {
      String str1 = (String)g.aAh().azQ().get(ar.a.NYh, "");
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
      int j = a.nZY;
      if (i != j)
      {
        AppMethodBeat.o(48992);
        return null;
      }
      Object[] arrayOfObject = new Object[a.nZY];
      i = 0;
      while (i < a.nZY)
      {
        arrayOfObject[i] = localJSONArray.optString(i, "");
        i += 1;
      }
      arrayOfObject[a.nZU.ordinal()] = Integer.valueOf(Util.getInt((String)arrayOfObject[a.nZU.ordinal()], 0));
      AppMethodBeat.o(48992);
      return arrayOfObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(48992);
    }
    return null;
  }
  
  static BannerModel bXZ()
  {
    AppMethodBeat.i(48993);
    Object[] arrayOfObject = bXY();
    if (arrayOfObject == null)
    {
      AppMethodBeat.o(48993);
      return null;
    }
    BannerModel localBannerModel = new BannerModel();
    localBannerModel.appId = ((String)arrayOfObject[a.nZT.ordinal()]);
    localBannerModel.iOo = ((Integer)arrayOfObject[a.nZU.ordinal()]).intValue();
    localBannerModel.appName = ((String)arrayOfObject[a.nZV.ordinal()]);
    localBannerModel.kVZ = ((String)arrayOfObject[a.nZW.ordinal()]);
    localBannerModel.oax = ((String)arrayOfObject[a.nZX.ordinal()]);
    AppMethodBeat.o(48993);
    return localBannerModel;
  }
  
  static enum a
  {
    static final int nZY;
    
    static
    {
      AppMethodBeat.i(48987);
      nZT = new a("appId", 0);
      nZU = new a("versionType", 1);
      nZV = new a("appName", 2);
      nZW = new a("iconURL", 3);
      nZX = new a("customText", 4);
      nZZ = new a[] { nZT, nZU, nZV, nZW, nZX };
      nZY = values().length;
      AppMethodBeat.o(48987);
    }
    
    private a() {}
    
    public final String Lb()
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