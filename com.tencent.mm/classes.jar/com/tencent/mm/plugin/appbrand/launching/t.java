package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t
  extends MAutoStorage<r>
{
  public static final String[] nVW;
  
  static
  {
    AppMethodBeat.i(146069);
    nVW = new String[] { MAutoStorage.getCreateSQLs(r.DB_INFO, "DevPkgLaunchExtInfo") };
    AppMethodBeat.o(146069);
  }
  
  public t(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, r.DB_INFO, "DevPkgLaunchExtInfo", r.INDEX_CREATE);
  }
  
  public final boolean D(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(146067);
    boolean bool = d(paramString1, paramInt, paramString2, true);
    AppMethodBeat.o(146067);
    return bool;
  }
  
  public final String cR(String paramString, int paramInt)
  {
    AppMethodBeat.i(146068);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146068);
      return "";
    }
    r localr = new r();
    localr.field_appId = paramString;
    localr.field_versionType = paramInt;
    if (super.get(localr, r.qDJ))
    {
      paramString = localr.field_extJson;
      AppMethodBeat.o(146068);
      return paramString;
    }
    AppMethodBeat.o(146068);
    return "";
  }
  
  public final boolean d(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(182793);
    boolean bool;
    if (Util.isNullOrNil(paramString1))
    {
      bool = false;
      Log.i("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo() appId:%s,versionType:%s,ret:%b,updatePkgManifests:%b,extInfo:%s", new Object[] { paramString1, Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramString2 });
      if ((bool) && (paramBoolean) && (TextUtils.isEmpty(paramString2))) {
        break label405;
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        if (paramString2 == null) {}
      }
      catch (Exception localException3)
      {
        try
        {
          localObject1 = paramString2.optJSONArray("module_list");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            bk.cha();
            bk.t(paramString1, paramInt, ((JSONArray)localObject1).toString());
          }
        }
        catch (Exception localException3)
        {
          try
          {
            localObject1 = paramString2.optString("without_lib_md5");
          }
          catch (Exception localException3)
          {
            try
            {
              if (!Util.isNullOrNil((String)localObject1))
              {
                bk.cha();
                bk.b(paramString1, "__WITHOUT_PLUGINCODE__", paramInt, (String)localObject1);
              }
            }
            catch (Exception localException3)
            {
              try
              {
                paramString2 = paramString2.optString("widget_list");
                if (!TextUtils.isEmpty(paramString2))
                {
                  bk.cha();
                  bk.c(paramString1, "", paramInt, paramString2);
                }
                AppMethodBeat.o(182793);
                return bool;
                Object localObject1 = new r();
                ((r)localObject1).field_appId = paramString1;
                ((r)localObject1).field_versionType = paramInt;
                if (super.get((IAutoDBItem)localObject1, r.qDJ))
                {
                  ((r)localObject1).field_extJson = Util.nullAs(paramString2, "{}");
                  bool = super.update((IAutoDBItem)localObject1, new String[0]);
                  break;
                }
                ((r)localObject1).field_extJson = Util.nullAs(paramString2, "{}");
                bool = super.insert((IAutoDBItem)localObject1);
                break;
                paramString2 = paramString2;
                Log.e("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo parse failed, appId[%s], type[%d], e[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
                paramString2 = null;
                continue;
                bk.cha();
                bk.bD(paramString1, paramInt);
                continue;
                localException1 = localException1;
                Log.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", localException1, "extract module_list with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
                continue;
                localException2 = localException2;
                Object localObject2 = null;
                continue;
                localException3 = localException3;
                Log.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", localException3, "extract withoutLibMd5 with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
                continue;
              }
              catch (Exception paramString2)
              {
                Log.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", paramString2, "extract widget_list with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
                continue;
              }
            }
          }
        }
      }
      label405:
      paramString2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.t
 * JD-Core Version:    0.7.0.1
 */