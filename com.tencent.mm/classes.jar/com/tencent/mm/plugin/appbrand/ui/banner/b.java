package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import org.json.JSONArray;
import org.json.JSONException;

final class b
{
  static void a(Intent paramIntent, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent.putExtra(b.a.hfu.pU(), paramString1);
    paramIntent.putExtra(b.a.hfv.pU(), paramInt);
    paramIntent.putExtra(b.a.hfw.pU(), paramString2);
    paramIntent.putExtra(b.a.hfx.pU(), paramString3);
    paramIntent.putExtra(b.a.hfy.pU(), paramString4);
  }
  
  private static void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    if (!g.DK()) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(paramString1);
    localJSONArray.put(String.valueOf(paramInt));
    localJSONArray.put(paramString2);
    localJSONArray.put(paramString3);
    localJSONArray.put(bk.pm(paramString4));
    paramString1 = localJSONArray.toString();
    try
    {
      g.DP().Dz().c(ac.a.utf, paramString1);
      return;
    }
    finally {}
  }
  
  static boolean a(AppBrandStickyBannerLogic.OperateTask paramOperateTask)
  {
    if ((paramOperateTask == null) || (!g.DK())) {}
    BannerModel localBannerModel;
    do
    {
      return false;
      localBannerModel = BannerModel.apA();
    } while ((localBannerModel == null) || (!localBannerModel.appId.equals(paramOperateTask.gwN)) || (localBannerModel.fJy != paramOperateTask.hfQ));
    a(localBannerModel.appId, localBannerModel.fJy, localBannerModel.appName, localBannerModel.fJY, paramOperateTask.hfR);
    return true;
  }
  
  private static Object[] aps()
  {
    if (!g.DK()) {
      return null;
    }
    try
    {
      String str1 = (String)g.DP().Dz().get(ac.a.utf, "");
      if (bk.bl(str1)) {
        return null;
      }
    }
    finally {}
    try
    {
      JSONArray localJSONArray = new JSONArray(str2);
      if (localJSONArray.length() != b.a.hfz) {
        return null;
      }
      Object[] arrayOfObject = new Object[b.a.hfz];
      int i = 0;
      while (i < b.a.hfz)
      {
        arrayOfObject[i] = localJSONArray.optString(i, "");
        i += 1;
      }
      arrayOfObject[b.a.hfv.ordinal()] = Integer.valueOf(bk.getInt((String)arrayOfObject[b.a.hfv.ordinal()], 0));
      return arrayOfObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  static BannerModel apt()
  {
    Object[] arrayOfObject = aps();
    if (arrayOfObject == null) {
      return null;
    }
    BannerModel localBannerModel = new BannerModel();
    localBannerModel.appId = ((String)arrayOfObject[b.a.hfu.ordinal()]);
    localBannerModel.fJy = ((Integer)arrayOfObject[b.a.hfv.ordinal()]).intValue();
    localBannerModel.appName = ((String)arrayOfObject[b.a.hfw.ordinal()]);
    localBannerModel.fJY = ((String)arrayOfObject[b.a.hfx.ordinal()]);
    localBannerModel.hfX = ((String)arrayOfObject[b.a.hfy.ordinal()]);
    return localBannerModel;
  }
  
  static boolean t(Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str1;
    int j;
    String str2;
    String str3;
    String str4;
    do
    {
      return false;
      str1 = paramIntent.getStringExtra(b.a.hfu.pU());
      j = paramIntent.getIntExtra(b.a.hfv.pU(), 0);
      str2 = paramIntent.getStringExtra(b.a.hfw.pU());
      str3 = paramIntent.getStringExtra(b.a.hfx.pU());
      str4 = paramIntent.getStringExtra(b.a.hfy.pU());
      b.a[] arrayOfa = b.a.values();
      int k = arrayOfa.length;
      int i = 0;
      while (i < k)
      {
        paramIntent.removeExtra(arrayOfa[i].pU());
        i += 1;
      }
    } while ((bk.bl(str1)) || (bk.bl(str2)));
    a(str1, j, str2, str3, str4);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.b
 * JD-Core Version:    0.7.0.1
 */