package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONObject;

public final class m
  extends j<k>
{
  public static final String[] fkl;
  
  static
  {
    AppMethodBeat.i(102104);
    fkl = new String[] { j.getCreateSQLs(k.gUb, "DevPkgLaunchExtInfo") };
    AppMethodBeat.o(102104);
  }
  
  public m(e parame)
  {
    super(parame, k.gUb, "DevPkgLaunchExtInfo", k.INDEX_CREATE);
  }
  
  public final String bm(String paramString, int paramInt)
  {
    AppMethodBeat.i(102103);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(102103);
      return "";
    }
    k localk = new k();
    localk.field_appId = paramString;
    localk.field_versionType = paramInt;
    if (super.get(localk, k.gUa))
    {
      paramString = localk.field_extJson;
      AppMethodBeat.o(102103);
      return paramString;
    }
    AppMethodBeat.o(102103);
    return "";
  }
  
  public final boolean n(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(102102);
    boolean bool;
    if (bo.isNullOrNil(paramString1))
    {
      bool = false;
      ab.i("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "appId:%s,versionType:%s,extInfo:%s", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
      if ((bool) && (TextUtils.isEmpty(paramString2))) {
        break label357;
      }
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramString2);
        if (paramString2 == null) {}
      }
      catch (Exception paramString2)
      {
        try
        {
          localObject = paramString2.optString("module_list");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            aw.awe();
            aw.g(paramString1, paramInt, (String)localObject);
          }
        }
        catch (Exception paramString2)
        {
          try
          {
            localObject = paramString2.optString("wxacode_lib_info_list");
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              aw.awe();
              aw.yB((String)localObject);
            }
          }
          catch (Exception paramString2)
          {
            try
            {
              paramString2 = paramString2.optString("without_lib_md5");
            }
            catch (Exception paramString2)
            {
              try
              {
                if (!bo.isNullOrNil(paramString2))
                {
                  aw.awe();
                  aw.b(paramString1, "__WITHOUT_CODELIB__", paramInt, paramString2);
                }
                AppMethodBeat.o(102102);
                return bool;
                Object localObject = new k();
                ((k)localObject).field_appId = paramString1;
                ((k)localObject).field_versionType = paramInt;
                if (super.get((c)localObject, k.gUa))
                {
                  ((k)localObject).field_extJson = bo.bf(paramString2, "{}");
                  bool = super.update((c)localObject, new String[0]);
                  break;
                }
                ((k)localObject).field_extJson = bo.bf(paramString2, "{}");
                bool = super.insert((c)localObject);
                break;
                paramString2 = paramString2;
                ab.e("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo parse failed, appId[%s], type[%d], e[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
                paramString2 = null;
                continue;
                localException1 = localException1;
                ab.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", localException1, "extract module_list with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
                continue;
                localException2 = localException2;
                ab.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", localException2, "extract wxacode_lib_info_list with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
                continue;
                paramString2 = paramString2;
                paramString2 = null;
                continue;
              }
              catch (Exception paramString2)
              {
                ab.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", paramString2, "extract without_lib_md5 with appId[%s], type[%d]", new Object[] { paramString1, Integer.valueOf(paramInt) });
                continue;
              }
            }
          }
        }
      }
      label357:
      paramString2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.m
 * JD-Core Version:    0.7.0.1
 */