package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import org.json.JSONArray;
import org.json.JSONException;

final class b
{
  static boolean L(Intent paramIntent)
  {
    AppMethodBeat.i(133269);
    if (paramIntent == null)
    {
      AppMethodBeat.o(133269);
      return false;
    }
    String str1 = paramIntent.getStringExtra(b.a.iQI.tX());
    int j = paramIntent.getIntExtra(b.a.iQJ.tX(), 0);
    String str2 = paramIntent.getStringExtra(b.a.iQK.tX());
    String str3 = paramIntent.getStringExtra(b.a.iQL.tX());
    String str4 = paramIntent.getStringExtra(b.a.iQM.tX());
    b.a[] arrayOfa = b.a.values();
    int k = arrayOfa.length;
    int i = 0;
    while (i < k)
    {
      paramIntent.removeExtra(arrayOfa[i].tX());
      i += 1;
    }
    if ((bo.isNullOrNil(str1)) || (bo.isNullOrNil(str2)))
    {
      AppMethodBeat.o(133269);
      return false;
    }
    a(str1, j, str2, str3, str4);
    AppMethodBeat.o(133269);
    return true;
  }
  
  static void a(Intent paramIntent, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(133271);
    if (paramIntent == null)
    {
      AppMethodBeat.o(133271);
      return;
    }
    paramIntent.putExtra(b.a.iQI.tX(), paramString1);
    paramIntent.putExtra(b.a.iQJ.tX(), paramInt);
    paramIntent.putExtra(b.a.iQK.tX(), paramString2);
    paramIntent.putExtra(b.a.iQL.tX(), paramString3);
    paramIntent.putExtra(b.a.iQM.tX(), paramString4);
    AppMethodBeat.o(133271);
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(133272);
    if (!g.RG())
    {
      AppMethodBeat.o(133272);
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString1);
    localJSONArray.put(String.valueOf(paramInt));
    localJSONArray.put(paramString2);
    localJSONArray.put(paramString3);
    localJSONArray.put(bo.nullAsNil(paramString4));
    paramString1 = localJSONArray.toString();
    try
    {
      g.RL().Ru().set(ac.a.yDf, paramString1);
      return;
    }
    finally
    {
      AppMethodBeat.o(133272);
    }
  }
  
  static boolean a(AppBrandStickyBannerLogic.OperateTask paramOperateTask)
  {
    AppMethodBeat.i(133270);
    if ((paramOperateTask == null) || (!g.RG()))
    {
      AppMethodBeat.o(133270);
      return false;
    }
    BannerModel localBannerModel = BannerModel.aMQ();
    if (localBannerModel == null)
    {
      AppMethodBeat.o(133270);
      return false;
    }
    if ((localBannerModel.appId.equals(paramOperateTask.hSW)) && (localBannerModel.hcr == paramOperateTask.iRe))
    {
      a(localBannerModel.appId, localBannerModel.hcr, localBannerModel.appName, localBannerModel.hcN, paramOperateTask.iRf);
      AppMethodBeat.o(133270);
      return true;
    }
    AppMethodBeat.o(133270);
    return false;
  }
  
  private static Object[] aMI()
  {
    AppMethodBeat.i(133273);
    if (!g.RG())
    {
      AppMethodBeat.o(133273);
      return null;
    }
    try
    {
      String str1 = (String)g.RL().Ru().get(ac.a.yDf, "");
      if (bo.isNullOrNil(str1))
      {
        AppMethodBeat.o(133273);
        return null;
      }
    }
    finally
    {
      AppMethodBeat.o(133273);
    }
    try
    {
      JSONArray localJSONArray = new JSONArray(str2);
      int i = localJSONArray.length();
      int j = b.a.iQN;
      if (i != j)
      {
        AppMethodBeat.o(133273);
        return null;
      }
      Object[] arrayOfObject = new Object[b.a.iQN];
      i = 0;
      while (i < b.a.iQN)
      {
        arrayOfObject[i] = localJSONArray.optString(i, "");
        i += 1;
      }
      arrayOfObject[b.a.iQJ.ordinal()] = Integer.valueOf(bo.getInt((String)arrayOfObject[b.a.iQJ.ordinal()], 0));
      AppMethodBeat.o(133273);
      return arrayOfObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(133273);
    }
    return null;
  }
  
  static BannerModel aMJ()
  {
    AppMethodBeat.i(133274);
    Object[] arrayOfObject = aMI();
    if (arrayOfObject == null)
    {
      AppMethodBeat.o(133274);
      return null;
    }
    BannerModel localBannerModel = new BannerModel();
    localBannerModel.appId = ((String)arrayOfObject[b.a.iQI.ordinal()]);
    localBannerModel.hcr = ((Integer)arrayOfObject[b.a.iQJ.ordinal()]).intValue();
    localBannerModel.appName = ((String)arrayOfObject[b.a.iQK.ordinal()]);
    localBannerModel.hcN = ((String)arrayOfObject[b.a.iQL.ordinal()]);
    localBannerModel.iRl = ((String)arrayOfObject[b.a.iQM.ordinal()]);
    AppMethodBeat.o(133274);
    return localBannerModel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.b
 * JD-Core Version:    0.7.0.1
 */