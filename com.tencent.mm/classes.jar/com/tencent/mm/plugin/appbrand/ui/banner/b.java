package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
    String str1 = paramIntent.getStringExtra(a.mhc.Ap());
    int j = paramIntent.getIntExtra(a.mhd.Ap(), 0);
    String str2 = paramIntent.getStringExtra(a.mhe.Ap());
    String str3 = paramIntent.getStringExtra(a.mhf.Ap());
    String str4 = paramIntent.getStringExtra(a.mhg.Ap());
    a[] arrayOfa = a.values();
    int k = arrayOfa.length;
    int i = 0;
    while (i < k)
    {
      paramIntent.removeExtra(arrayOfa[i].Ap());
      i += 1;
    }
    if ((bs.isNullOrNil(str1)) || (bs.isNullOrNil(str2)))
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
    paramIntent.putExtra(a.mhc.Ap(), paramString1);
    paramIntent.putExtra(a.mhd.Ap(), paramInt);
    paramIntent.putExtra(a.mhe.Ap(), paramString2);
    paramIntent.putExtra(a.mhf.Ap(), paramString3);
    paramIntent.putExtra(a.mhg.Ap(), paramString4);
    AppMethodBeat.o(48990);
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48991);
    if (!g.agM())
    {
      AppMethodBeat.o(48991);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString1);
    localJSONArray.put(String.valueOf(paramInt));
    localJSONArray.put(paramString2);
    localJSONArray.put(paramString3);
    localJSONArray.put(bs.nullAsNil(paramString4));
    paramString1 = localJSONArray.toString();
    try
    {
      g.agR().agA().set(ah.a.GJq, paramString1);
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
    if ((paramOperateTask == null) || (!g.agM()))
    {
      AppMethodBeat.o(48989);
      return false;
    }
    BannerModel localBannerModel = BannerModel.bwa();
    if (localBannerModel == null)
    {
      AppMethodBeat.o(48989);
      return false;
    }
    if ((localBannerModel.appId.equals(paramOperateTask.mhy)) && (localBannerModel.hxM == paramOperateTask.mhz))
    {
      a(localBannerModel.appId, localBannerModel.hxM, localBannerModel.appName, localBannerModel.jwf, paramOperateTask.mhA);
      AppMethodBeat.o(48989);
      return true;
    }
    AppMethodBeat.o(48989);
    return false;
  }
  
  private static Object[] bvS()
  {
    AppMethodBeat.i(48992);
    if (!g.agM())
    {
      AppMethodBeat.o(48992);
      return null;
    }
    try
    {
      String str1 = (String)g.agR().agA().get(ah.a.GJq, "");
      if (bs.isNullOrNil(str1))
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
      int j = a.mhh;
      if (i != j)
      {
        AppMethodBeat.o(48992);
        return null;
      }
      Object[] arrayOfObject = new Object[a.mhh];
      i = 0;
      while (i < a.mhh)
      {
        arrayOfObject[i] = localJSONArray.optString(i, "");
        i += 1;
      }
      arrayOfObject[a.mhd.ordinal()] = Integer.valueOf(bs.getInt((String)arrayOfObject[a.mhd.ordinal()], 0));
      AppMethodBeat.o(48992);
      return arrayOfObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(48992);
    }
    return null;
  }
  
  static BannerModel bvT()
  {
    AppMethodBeat.i(48993);
    Object[] arrayOfObject = bvS();
    if (arrayOfObject == null)
    {
      AppMethodBeat.o(48993);
      return null;
    }
    BannerModel localBannerModel = new BannerModel();
    localBannerModel.appId = ((String)arrayOfObject[a.mhc.ordinal()]);
    localBannerModel.hxM = ((Integer)arrayOfObject[a.mhd.ordinal()]).intValue();
    localBannerModel.appName = ((String)arrayOfObject[a.mhe.ordinal()]);
    localBannerModel.jwf = ((String)arrayOfObject[a.mhf.ordinal()]);
    localBannerModel.mhG = ((String)arrayOfObject[a.mhg.ordinal()]);
    AppMethodBeat.o(48993);
    return localBannerModel;
  }
  
  static enum a
  {
    static final int mhh;
    
    static
    {
      AppMethodBeat.i(48987);
      mhc = new a("appId", 0);
      mhd = new a("versionType", 1);
      mhe = new a("appName", 2);
      mhf = new a("iconURL", 3);
      mhg = new a("customText", 4);
      mhi = new a[] { mhc, mhd, mhe, mhf, mhg };
      mhh = values().length;
      AppMethodBeat.o(48987);
    }
    
    private a() {}
    
    public final String Ap()
    {
      AppMethodBeat.i(48986);
      String str = "appbrand_top_banner_in_chatting_extra_key_" + name();
      AppMethodBeat.o(48986);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.b
 * JD-Core Version:    0.7.0.1
 */