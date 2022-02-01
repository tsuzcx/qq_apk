package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t
  extends j<r>
{
  public static final String[] hlS;
  
  static
  {
    AppMethodBeat.i(146069);
    hlS = new String[] { j.getCreateSQLs(r.jmW, "DevPkgLaunchExtInfo") };
    AppMethodBeat.o(146069);
  }
  
  public t(e parame)
  {
    super(parame, r.jmW, "DevPkgLaunchExtInfo", r.INDEX_CREATE);
  }
  
  public final boolean a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(182793);
    boolean bool;
    if (bs.isNullOrNil(paramString1))
    {
      bool = false;
      ac.i("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo() appId:%s,versionType:%s,ret:%b,updatePkgManifests:%b,extInfo:%s", new Object[] { paramString1, Integer.valueOf(paramInt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), paramString2 });
      if ((bool) && (paramBoolean) && (TextUtils.isEmpty(paramString2))) {
        break label459;
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        if (paramString2 == null) {}
      }
      catch (Exception localException4)
      {
        try
        {
          localObject1 = paramString2.optJSONArray("module_list");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            bd.aXn();
            bd.k(paramString1, paramInt, ((JSONArray)localObject1).toString());
          }
        }
        catch (Exception localException4)
        {
          try
          {
            localObject1 = paramString2.optString("separated_plugin_list");
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              bd.aXn();
              bd.Il((String)localObject1);
            }
          }
          catch (Exception localException4)
          {
            try
            {
              localObject1 = paramString2.optString("without_lib_md5");
            }
            catch (Exception localException4)
            {
              try
              {
                if (!bs.isNullOrNil((String)localObject1))
                {
                  bd.aXn();
                  bd.b(paramString1, "__WITHOUT_PLUGINCODE__", paramInt, (String)localObject1);
                }
              }
              catch (Exception localException4)
              {
                try
                {
                  paramString2 = paramString2.optString("widget_list");
                  if (!TextUtils.isEmpty(paramString2))
                  {
                    bd.aXn();
                    bd.c(paramString1, "", paramInt, paramString2);
                  }
                  AppMethodBeat.o(182793);
                  return bool;
                  Object localObject1 = new r();
                  ((r)localObject1).field_appId = paramString1;
                  ((r)localObject1).field_versionType = paramInt;
                  if (super.get((c)localObject1, r.jlk))
                  {
                    ((r)localObject1).field_extJson = bs.bG(paramString2, "{}");
                    bool = super.update((c)localObject1, new String[0]);
                    break;
                  }
                  ((r)localObject1).field_extJson = bs.bG(paramString2, "{}");
                  bool = super.insert((c)localObject1);
                  break;
                  paramString2 = paramString2;
                  ac.e("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo parse failed, appId[%s], type[%d], e[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
                  paramString2 = null;
                  continue;
                  bd.aXn();
                  bd.aL(paramString1, paramInt);
                  continue;
                  localException1 = localException1;
                  ac.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", localException1, "extract module_list with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
                  continue;
                  localException2 = localException2;
                  ac.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", localException2, "extract separated_plugin_list with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
                  continue;
                  localException3 = localException3;
                  Object localObject2 = null;
                  continue;
                  localException4 = localException4;
                  ac.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", localException4, "extract withoutLibMd5 with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
                  continue;
                }
                catch (Exception paramString2)
                {
                  ac.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", paramString2, "extract widget_list with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
                  continue;
                }
              }
            }
          }
        }
      }
      label459:
      paramString2 = null;
    }
  }
  
  public final String bK(String paramString, int paramInt)
  {
    AppMethodBeat.i(146068);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(146068);
      return "";
    }
    r localr = new r();
    localr.field_appId = paramString;
    localr.field_versionType = paramInt;
    if (super.get(localr, r.jlk))
    {
      paramString = localr.field_extJson;
      AppMethodBeat.o(146068);
      return paramString;
    }
    AppMethodBeat.o(146068);
    return "";
  }
  
  public final boolean s(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(146067);
    boolean bool = a(paramString1, paramInt, paramString2, true);
    AppMethodBeat.o(146067);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.t
 * JD-Core Version:    0.7.0.1
 */