package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
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
    String str1 = paramIntent.getStringExtra(a.uht.key());
    int j = paramIntent.getIntExtra(a.uhu.key(), 0);
    String str2 = paramIntent.getStringExtra(a.uhv.key());
    String str3 = paramIntent.getStringExtra(a.uhw.key());
    String str4 = paramIntent.getStringExtra(a.uhx.key());
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
    b(str1, j, str2, str3, str4);
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
    paramIntent.putExtra(a.uht.key(), paramString1);
    paramIntent.putExtra(a.uhu.key(), paramInt);
    paramIntent.putExtra(a.uhv.key(), paramString2);
    paramIntent.putExtra(a.uhw.key(), paramString3);
    paramIntent.putExtra(a.uhx.key(), paramString4);
    AppMethodBeat.o(48990);
  }
  
  static boolean a(AppBrandStickyBannerLogic.OperateTask paramOperateTask)
  {
    AppMethodBeat.i(48989);
    if ((paramOperateTask == null) || (!h.baz()))
    {
      AppMethodBeat.o(48989);
      return false;
    }
    BannerModel localBannerModel = BannerModel.cMe();
    if (localBannerModel == null)
    {
      AppMethodBeat.o(48989);
      return false;
    }
    if ((localBannerModel.appId.equals(paramOperateTask.uhJ)) && (localBannerModel.euz == paramOperateTask.uhK))
    {
      b(localBannerModel.appId, localBannerModel.euz, localBannerModel.appName, localBannerModel.qQb, paramOperateTask.uhL);
      AppMethodBeat.o(48989);
      return true;
    }
    AppMethodBeat.o(48989);
    return false;
  }
  
  private static void b(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(48991);
    if (!h.baz())
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
      h.baE().ban().set(at.a.acNC, paramString1);
      return;
    }
    finally
    {
      AppMethodBeat.o(48991);
    }
  }
  
  static void cLX()
  {
    AppMethodBeat.i(322753);
    try
    {
      h.baE().ban().set(at.a.acNC, "");
      return;
    }
    finally
    {
      AppMethodBeat.o(322753);
    }
  }
  
  private static Object[] cLY()
  {
    AppMethodBeat.i(48992);
    if (!h.baz())
    {
      AppMethodBeat.o(48992);
      return null;
    }
    try
    {
      String str1 = (String)h.baE().ban().get(at.a.acNC, "");
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
      int j = a.uhy;
      if (i != j)
      {
        AppMethodBeat.o(48992);
        return null;
      }
      Object[] arrayOfObject = new Object[a.uhy];
      i = 0;
      while (i < a.uhy)
      {
        arrayOfObject[i] = localJSONArray.optString(i, "");
        i += 1;
      }
      arrayOfObject[a.uhu.ordinal()] = Integer.valueOf(Util.getInt((String)arrayOfObject[a.uhu.ordinal()], 0));
      AppMethodBeat.o(48992);
      return arrayOfObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(48992);
    }
    return null;
  }
  
  static BannerModel cLZ()
  {
    AppMethodBeat.i(48993);
    Object[] arrayOfObject = cLY();
    if (arrayOfObject == null)
    {
      AppMethodBeat.o(48993);
      return null;
    }
    BannerModel localBannerModel = new BannerModel();
    localBannerModel.appId = ((String)arrayOfObject[a.uht.ordinal()]);
    localBannerModel.euz = ((Integer)arrayOfObject[a.uhu.ordinal()]).intValue();
    localBannerModel.appName = ((String)arrayOfObject[a.uhv.ordinal()]);
    localBannerModel.qQb = ((String)arrayOfObject[a.uhw.ordinal()]);
    localBannerModel.uhR = ((String)arrayOfObject[a.uhx.ordinal()]);
    AppMethodBeat.o(48993);
    return localBannerModel;
  }
  
  static enum a
  {
    static final int uhy;
    
    static
    {
      AppMethodBeat.i(48987);
      uht = new a("appId", 0);
      uhu = new a("versionType", 1);
      uhv = new a("appName", 2);
      uhw = new a("iconURL", 3);
      uhx = new a("customText", 4);
      uhz = new a[] { uht, uhu, uhv, uhw, uhx };
      uhy = values().length;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.banner.b
 * JD-Core Version:    0.7.0.1
 */