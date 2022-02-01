package com.tencent.mm.plugin.lite.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.liteapp.storage.WxaLiteAppBaselibInfo;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class LiteAppContentProvider
  extends ContentProvider
{
  public static final String AUTHORITY;
  private static final UriMatcher xPd;
  private g KbA;
  private i Kby;
  private e Kbz;
  
  static
  {
    AppMethodBeat.i(271307);
    AUTHORITY = WeChatAuthorities.AUTHORITIES_PLUGIN_LITE_LOGIC_LITEAPPINFO();
    UriMatcher localUriMatcher = new UriMatcher(-1);
    xPd = localUriMatcher;
    localUriMatcher.addURI(AUTHORITY, "LiteAppInfo", 1);
    AppMethodBeat.o(271307);
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    int k = 0;
    int j = 0;
    AppMethodBeat.i(271352);
    if ((!com.tencent.mm.kernel.h.baF().mDv) || (!com.tencent.mm.kernel.h.baC().aZN()))
    {
      Log.w("MicroMsg.LiteAppContentProvider", "kernel or account not init.");
      AppMethodBeat.o(271352);
      return null;
    }
    if (this.Kby == null) {
      this.Kby = new i(com.tencent.mm.kernel.h.baE().mCN);
    }
    if (this.Kbz == null) {
      this.Kbz = new e(com.tencent.mm.kernel.h.baE().mCN);
    }
    if (this.KbA == null) {
      this.KbA = new g(com.tencent.mm.kernel.h.baE().mCN);
    }
    Log.i("MicroMsg.LiteAppContentProvider", "call %s %s", new Object[] { paramString1, paramString2 });
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(271352);
        return null;
        if (paramString1.equals("getLiteAppInfo"))
        {
          i = 0;
          continue;
          if (paramString1.equals("removeLiteAppInfo"))
          {
            i = 1;
            continue;
            if (paramString1.equals("insertLiteAppInfo"))
            {
              i = 2;
              continue;
              if (paramString1.equals("getLiteAppList"))
              {
                i = 3;
                continue;
                if (paramString1.equals("insertLiteAppAuthInfo"))
                {
                  i = 4;
                  continue;
                  if (paramString1.equals("getLiteAppAuthInfo"))
                  {
                    i = 5;
                    continue;
                    if (paramString1.equals("getLiteAppBaselibInfo"))
                    {
                      i = 6;
                      continue;
                      if (paramString1.equals("getLatestLiteAppBaselibInfo"))
                      {
                        i = 7;
                        continue;
                        if (paramString1.equals("removeLiteAppBaselibInfo"))
                        {
                          i = 8;
                          continue;
                          if (paramString1.equals("insertLiteAppBaselibInfo"))
                          {
                            i = 9;
                            continue;
                            if (paramString1.equals("getLiteAppBaselibList")) {
                              i = 10;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    try
    {
      paramString1 = this.Kby.aKa(paramString2);
      if (paramString1 != null)
      {
        paramBundle = new Bundle();
        paramBundle.putParcelable("LiteApp", paramString1.fUr());
        AppMethodBeat.o(271352);
        return paramBundle;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.LiteAppContentProvider", "getLiteAppInfo failed. :%s", new Object[] { Util.stackTraceToString(paramString1) });
      Log.i("MicroMsg.LiteAppContentProvider", "null == info, appId:".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(271352);
      return null;
    }
    Log.i("MicroMsg.LiteAppInfoStorage", "remove liteapp: %s, ret:%d", new Object[] { paramString2, Integer.valueOf(this.Kby.db.delete("LiteAppInfo", "appId=?", new String[] { paramString2 })) });
    AppMethodBeat.o(271352);
    return null;
    paramString1 = (WxaLiteAppInfo)paramBundle.getParcelable("LiteApp");
    if (paramString1 == null)
    {
      AppMethodBeat.o(271352);
      return null;
    }
    paramString2 = new h();
    paramString2.field_appId = paramString1.appId;
    paramString2.field_signatureKey = paramString1.egI;
    paramString2.field_pkgType = paramString1.type;
    paramString2.field_pkgPath = paramString1.path;
    paramString2.field_patchId = paramString1.egJ;
    paramString2.field_updateTime = paramString1.egK;
    paramString2.field_url = paramString1.url;
    paramString2.field_md5 = paramString1.md5;
    paramString2.field_lastUseTime = paramString1.egL;
    paramString2.field_groupId = paramString1.groupId;
    if (this.Kby.aKa(paramString1.appId) == null) {
      this.Kby.a(paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(271352);
      return null;
      this.Kby.update(paramString2, new String[0]);
    }
    paramString2 = this.Kby.fUk();
    paramString1 = new ArrayList();
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      i = j;
      while (i < paramString2.size())
      {
        paramString1.add(((h)paramString2.get(i)).fUr());
        i += 1;
      }
    }
    paramString2 = new Bundle();
    if (!paramString1.isEmpty()) {
      paramString2.putParcelableArrayList("LiteAppList", paramString1);
    }
    AppMethodBeat.o(271352);
    return paramString2;
    paramString1 = paramBundle.getString("host");
    if (paramString1 == null)
    {
      AppMethodBeat.o(271352);
      return null;
    }
    paramString2 = new d();
    paramString2.field_host = paramString1;
    paramString2.field_param = paramBundle.getString("param");
    paramString2.field_paramMap = paramBundle.getString("paramMap");
    paramString2.field_headerMap = paramBundle.getString("headerMap");
    paramString2.field_updateTime = paramBundle.getLong("updateTime");
    if (this.Kbz.aJY(paramString1) == null) {
      this.Kbz.a(paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(271352);
      return null;
      this.Kbz.update(paramString2, new String[0]);
    }
    try
    {
      paramString1 = this.Kbz.aJY(paramString2);
      if (paramString1 != null)
      {
        paramString2 = new Bundle();
        paramString2.putString("host", paramString1.field_host);
        paramString2.putString("param", paramString1.field_param);
        paramString2.putString("paramMap", paramString1.field_paramMap);
        paramString2.putString("headerMap", paramString1.field_headerMap);
        paramString2.putLong("updateTime", paramString1.field_updateTime);
        AppMethodBeat.o(271352);
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.LiteAppContentProvider", "getLiteAppAuthInfo failed. :%s", new Object[] { Util.stackTraceToString(paramString1) });
      AppMethodBeat.o(271352);
      return null;
    }
    try
    {
      paramString1 = this.KbA.aJZ(paramString2);
      if (paramString1 != null)
      {
        paramBundle = new Bundle();
        paramBundle.putParcelable("LiteAppBaselib", paramString1.fUo());
        AppMethodBeat.o(271352);
        return paramBundle;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.LiteAppContentProvider", "getLiteAppBaselibInfo failed. :%s", new Object[] { Util.stackTraceToString(paramString1) });
      Log.i("MicroMsg.LiteAppContentProvider", "null == baselib, majorVersion:".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(271352);
      return null;
    }
    try
    {
      paramString1 = this.KbA.fUp();
      if (paramString1 != null)
      {
        paramString2 = new Bundle();
        paramString2.putParcelable("LiteAppBaselib", paramString1.fUo());
        AppMethodBeat.o(271352);
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      Log.e("MicroMsg.LiteAppContentProvider", "getLatestLiteAppBaselibInfo failed. :%s", new Object[] { Util.stackTraceToString(paramString1) });
      Log.i("MicroMsg.LiteAppContentProvider", "null == latestBaselib");
      AppMethodBeat.o(271352);
      return null;
    }
    Log.i("MicroMsg.LiteAppBaselibInfoStorage", "remove liteapp: %s, ret:%d", new Object[] { paramString2, Integer.valueOf(this.KbA.db.delete("LiteAppBaselibInfo", "majorVersion=?", new String[] { paramString2 })) });
    AppMethodBeat.o(271352);
    return null;
    paramBundle.setClassLoader(WxaLiteAppBaselibInfo.class.getClassLoader());
    paramString1 = (WxaLiteAppBaselibInfo)paramBundle.getParcelable("LiteAppBaselib");
    if (paramString1 == null)
    {
      AppMethodBeat.o(271352);
      return null;
    }
    paramString2 = new f();
    paramString2.field_majorVersion = paramString1.egH;
    paramString2.field_signatureKey = paramString1.egI;
    paramString2.field_pkgType = paramString1.type;
    paramString2.field_pkgPath = paramString1.path;
    paramString2.field_patchId = paramString1.egJ;
    paramString2.field_updateTime = paramString1.egK;
    paramString2.field_url = paramString1.url;
    paramString2.field_md5 = paramString1.md5;
    paramString2.field_lastUseTime = paramString1.egL;
    if (this.KbA.aJZ(paramString1.egH) == null) {
      this.KbA.a(paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(271352);
      return null;
      this.KbA.update(paramString2, new String[0]);
    }
    paramString2 = this.KbA.fUq();
    paramString1 = new ArrayList();
    if ((paramString2 != null) && (paramString2.size() > 0))
    {
      i = k;
      while (i < paramString2.size())
      {
        paramString1.add(((f)paramString2.get(i)).fUo());
        i += 1;
      }
    }
    paramString2 = new Bundle();
    if (!paramString1.isEmpty()) {
      paramString2.putParcelableArrayList("LiteAppBaselibList", paramString1);
    }
    AppMethodBeat.o(271352);
    return paramString2;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.LiteAppContentProvider
 * JD-Core Version:    0.7.0.1
 */