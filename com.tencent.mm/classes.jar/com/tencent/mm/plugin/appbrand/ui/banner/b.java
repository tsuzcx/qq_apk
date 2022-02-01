package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
    String str1 = paramIntent.getStringExtra(a.mHC.BM());
    int j = paramIntent.getIntExtra(a.mHD.BM(), 0);
    String str2 = paramIntent.getStringExtra(a.mHE.BM());
    String str3 = paramIntent.getStringExtra(a.mHF.BM());
    String str4 = paramIntent.getStringExtra(a.mHG.BM());
    a[] arrayOfa = a.values();
    int k = arrayOfa.length;
    int i = 0;
    while (i < k)
    {
      paramIntent.removeExtra(arrayOfa[i].BM());
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
    paramIntent.putExtra(a.mHC.BM(), paramString1);
    paramIntent.putExtra(a.mHD.BM(), paramInt);
    paramIntent.putExtra(a.mHE.BM(), paramString2);
    paramIntent.putExtra(a.mHF.BM(), paramString3);
    paramIntent.putExtra(a.mHG.BM(), paramString4);
    AppMethodBeat.o(48990);
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48991);
    if (!g.ajx())
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
      g.ajC().ajl().set(al.a.IvI, paramString1);
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
    if ((paramOperateTask == null) || (!g.ajx()))
    {
      AppMethodBeat.o(48989);
      return false;
    }
    BannerModel localBannerModel = BannerModel.bAg();
    if (localBannerModel == null)
    {
      AppMethodBeat.o(48989);
      return false;
    }
    if ((localBannerModel.appId.equals(paramOperateTask.mHY)) && (localBannerModel.hQh == paramOperateTask.mHZ))
    {
      a(localBannerModel.appId, localBannerModel.hQh, localBannerModel.appName, localBannerModel.jPZ, paramOperateTask.mIa);
      AppMethodBeat.o(48989);
      return true;
    }
    AppMethodBeat.o(48989);
    return false;
  }
  
  private static Object[] bzY()
  {
    AppMethodBeat.i(48992);
    if (!g.ajx())
    {
      AppMethodBeat.o(48992);
      return null;
    }
    try
    {
      String str1 = (String)g.ajC().ajl().get(al.a.IvI, "");
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
      int j = a.mHH;
      if (i != j)
      {
        AppMethodBeat.o(48992);
        return null;
      }
      Object[] arrayOfObject = new Object[a.mHH];
      i = 0;
      while (i < a.mHH)
      {
        arrayOfObject[i] = localJSONArray.optString(i, "");
        i += 1;
      }
      arrayOfObject[a.mHD.ordinal()] = Integer.valueOf(bt.getInt((String)arrayOfObject[a.mHD.ordinal()], 0));
      AppMethodBeat.o(48992);
      return arrayOfObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(48992);
    }
    return null;
  }
  
  static BannerModel bzZ()
  {
    AppMethodBeat.i(48993);
    Object[] arrayOfObject = bzY();
    if (arrayOfObject == null)
    {
      AppMethodBeat.o(48993);
      return null;
    }
    BannerModel localBannerModel = new BannerModel();
    localBannerModel.appId = ((String)arrayOfObject[a.mHC.ordinal()]);
    localBannerModel.hQh = ((Integer)arrayOfObject[a.mHD.ordinal()]).intValue();
    localBannerModel.appName = ((String)arrayOfObject[a.mHE.ordinal()]);
    localBannerModel.jPZ = ((String)arrayOfObject[a.mHF.ordinal()]);
    localBannerModel.mIh = ((String)arrayOfObject[a.mHG.ordinal()]);
    AppMethodBeat.o(48993);
    return localBannerModel;
  }
  
  static enum a
  {
    static final int mHH;
    
    static
    {
      AppMethodBeat.i(48987);
      mHC = new a("appId", 0);
      mHD = new a("versionType", 1);
      mHE = new a("appName", 2);
      mHF = new a("iconURL", 3);
      mHG = new a("customText", 4);
      mHI = new a[] { mHC, mHD, mHE, mHF, mHG };
      mHH = values().length;
      AppMethodBeat.o(48987);
    }
    
    private a() {}
    
    public final String BM()
    {
      AppMethodBeat.i(48986);
      String str = "appbrand_top_banner_in_chatting_extra_key_" + name();
      AppMethodBeat.o(48986);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.b
 * JD-Core Version:    0.7.0.1
 */