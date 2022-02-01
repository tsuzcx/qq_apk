package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import org.json.JSONArray;
import org.json.JSONException;

final class b
{
  static boolean R(Intent paramIntent)
  {
    AppMethodBeat.i(48988);
    if (paramIntent == null)
    {
      AppMethodBeat.o(48988);
      return false;
    }
    String str1 = paramIntent.getStringExtra(a.mMG.BN());
    int j = paramIntent.getIntExtra(a.mMH.BN(), 0);
    String str2 = paramIntent.getStringExtra(a.mMI.BN());
    String str3 = paramIntent.getStringExtra(a.mMJ.BN());
    String str4 = paramIntent.getStringExtra(a.mMK.BN());
    a[] arrayOfa = a.values();
    int k = arrayOfa.length;
    int i = 0;
    while (i < k)
    {
      paramIntent.removeExtra(arrayOfa[i].BN());
      i += 1;
    }
    if ((bu.isNullOrNil(str1)) || (bu.isNullOrNil(str2)))
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
    paramIntent.putExtra(a.mMG.BN(), paramString1);
    paramIntent.putExtra(a.mMH.BN(), paramInt);
    paramIntent.putExtra(a.mMI.BN(), paramString2);
    paramIntent.putExtra(a.mMJ.BN(), paramString3);
    paramIntent.putExtra(a.mMK.BN(), paramString4);
    AppMethodBeat.o(48990);
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48991);
    if (!g.ajM())
    {
      AppMethodBeat.o(48991);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString1);
    localJSONArray.put(String.valueOf(paramInt));
    localJSONArray.put(paramString2);
    localJSONArray.put(paramString3);
    localJSONArray.put(bu.nullAsNil(paramString4));
    paramString1 = localJSONArray.toString();
    try
    {
      g.ajR().ajA().set(am.a.IQg, paramString1);
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
    if ((paramOperateTask == null) || (!g.ajM()))
    {
      AppMethodBeat.o(48989);
      return false;
    }
    BannerModel localBannerModel = BannerModel.bBb();
    if (localBannerModel == null)
    {
      AppMethodBeat.o(48989);
      return false;
    }
    if ((localBannerModel.appId.equals(paramOperateTask.mNc)) && (localBannerModel.hSZ == paramOperateTask.mNd))
    {
      a(localBannerModel.appId, localBannerModel.hSZ, localBannerModel.appName, localBannerModel.jTr, paramOperateTask.mNe);
      AppMethodBeat.o(48989);
      return true;
    }
    AppMethodBeat.o(48989);
    return false;
  }
  
  private static Object[] bAT()
  {
    AppMethodBeat.i(48992);
    if (!g.ajM())
    {
      AppMethodBeat.o(48992);
      return null;
    }
    try
    {
      String str1 = (String)g.ajR().ajA().get(am.a.IQg, "");
      if (bu.isNullOrNil(str1))
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
      int j = a.mML;
      if (i != j)
      {
        AppMethodBeat.o(48992);
        return null;
      }
      Object[] arrayOfObject = new Object[a.mML];
      i = 0;
      while (i < a.mML)
      {
        arrayOfObject[i] = localJSONArray.optString(i, "");
        i += 1;
      }
      arrayOfObject[a.mMH.ordinal()] = Integer.valueOf(bu.getInt((String)arrayOfObject[a.mMH.ordinal()], 0));
      AppMethodBeat.o(48992);
      return arrayOfObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(48992);
    }
    return null;
  }
  
  static BannerModel bAU()
  {
    AppMethodBeat.i(48993);
    Object[] arrayOfObject = bAT();
    if (arrayOfObject == null)
    {
      AppMethodBeat.o(48993);
      return null;
    }
    BannerModel localBannerModel = new BannerModel();
    localBannerModel.appId = ((String)arrayOfObject[a.mMG.ordinal()]);
    localBannerModel.hSZ = ((Integer)arrayOfObject[a.mMH.ordinal()]).intValue();
    localBannerModel.appName = ((String)arrayOfObject[a.mMI.ordinal()]);
    localBannerModel.jTr = ((String)arrayOfObject[a.mMJ.ordinal()]);
    localBannerModel.mNk = ((String)arrayOfObject[a.mMK.ordinal()]);
    AppMethodBeat.o(48993);
    return localBannerModel;
  }
  
  static enum a
  {
    static final int mML;
    
    static
    {
      AppMethodBeat.i(48987);
      mMG = new a("appId", 0);
      mMH = new a("versionType", 1);
      mMI = new a("appName", 2);
      mMJ = new a("iconURL", 3);
      mMK = new a("customText", 4);
      mMM = new a[] { mMG, mMH, mMI, mMJ, mMK };
      mML = values().length;
      AppMethodBeat.o(48987);
    }
    
    private a() {}
    
    public final String BN()
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