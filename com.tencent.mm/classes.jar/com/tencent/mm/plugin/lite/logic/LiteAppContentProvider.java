package com.tencent.mm.plugin.lite.logic;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.d.c;
import com.tencent.mm.plugin.lite.d.d;
import com.tencent.mm.plugin.lite.d.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.List;

public class LiteAppContentProvider
  extends ContentProvider
{
  private static final UriMatcher pMX;
  private f vkw;
  private d vkx;
  
  static
  {
    AppMethodBeat.i(217789);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    pMX = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.lite.logic.LiteAppInfo", "LiteAppInfo", 1);
    AppMethodBeat.o(217789);
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(217788);
    if ((!g.ajS().gED) || (!g.ajP().aiZ()))
    {
      ae.w("MicroMsg.LiteAppContentProvider", "kernel or account not init.");
      AppMethodBeat.o(217788);
      return null;
    }
    if (this.vkw == null) {
      this.vkw = new f(g.ajR().gDX);
    }
    if (this.vkx == null) {
      this.vkx = new d(g.ajR().gDX);
    }
    ae.i("MicroMsg.LiteAppContentProvider", "call %s %s", new Object[] { paramString1, paramString2 });
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(217788);
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
                  if (paramString1.equals("getLiteAppAuthInfo")) {
                    i = 5;
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
      paramString1 = this.vkw.apC(paramString2);
      if (paramString1 != null)
      {
        paramBundle = new Bundle();
        paramBundle.putString("appId", paramString1.field_appId);
        paramBundle.putString("patchId", paramString1.field_patchId);
        paramBundle.putString("signatureKey", paramString1.field_signatureKey);
        paramBundle.putString("pkgType", paramString1.field_pkgType);
        paramBundle.putString("pkgPath", paramString1.field_pkgPath);
        paramBundle.putLong("updateTime", paramString1.field_updateTime);
        AppMethodBeat.o(217788);
        return paramBundle;
      }
    }
    catch (Exception paramString1)
    {
      ae.e("MicroMsg.LiteAppContentProvider", "getLiteAppInfo failed. :%s", new Object[] { bu.o(paramString1) });
      ae.i("MicroMsg.LiteAppContentProvider", "null == info, appId:".concat(String.valueOf(paramString2)));
      AppMethodBeat.o(217788);
      return null;
    }
    ae.i("MicroMsg.LiteAppInfoStorage", "remove liteapp: %s, ret:%d", new Object[] { paramString2, Integer.valueOf(this.vkw.db.delete("LiteAppInfo", "appId=?", new String[] { paramString2 })) });
    AppMethodBeat.o(217788);
    return null;
    paramString1 = paramBundle.getString("appId");
    if (paramString1 == null)
    {
      AppMethodBeat.o(217788);
      return null;
    }
    paramString2 = new com.tencent.mm.plugin.lite.d.e();
    paramString2.field_appId = paramString1;
    paramString2.field_signatureKey = paramBundle.getString("signatureKey");
    paramString2.field_pkgType = paramBundle.getString("pkgType");
    paramString2.field_pkgPath = paramBundle.getString("pkgPath");
    paramString2.field_patchId = paramBundle.getString("patchId");
    paramString2.field_updateTime = paramBundle.getLong("updateTime");
    if (this.vkw.apC(paramString1) == null) {
      this.vkw.d(paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(217788);
      return null;
      this.vkw.update(paramString2, new String[0]);
    }
    paramString2 = this.vkw.diE();
    paramString1 = new ArrayList();
    if (paramString2.size() > 0)
    {
      i = 0;
      while (i < paramString2.size())
      {
        paramBundle = (com.tencent.mm.plugin.lite.d.e)paramString2.get(i);
        paramString1.add(new ParcelableLiteAppInfo(paramBundle.field_appId, paramBundle.field_signatureKey, paramBundle.field_pkgPath, paramBundle.field_pkgType, paramBundle.field_patchId, paramBundle.field_updateTime));
        i += 1;
      }
    }
    paramString2 = new Bundle();
    paramString2.putParcelableArrayList("result", paramString1);
    AppMethodBeat.o(217788);
    return paramString2;
    paramString1 = paramBundle.getString("host");
    if (paramString1 == null)
    {
      AppMethodBeat.o(217788);
      return null;
    }
    paramString2 = new c();
    paramString2.field_host = paramString1;
    paramString2.field_param = paramBundle.getString("param");
    paramString2.field_paramMap = paramBundle.getString("paramMap");
    paramString2.field_headerMap = paramBundle.getString("headerMap");
    paramString2.field_updateTime = paramBundle.getLong("updateTime");
    if (this.vkx.apD(paramString1) == null) {
      this.vkx.a(paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(217788);
      return null;
      this.vkx.update(paramString2, new String[0]);
    }
    try
    {
      paramString1 = this.vkx.apD(paramString2);
      if (paramString1 != null)
      {
        paramString2 = new Bundle();
        paramString2.putString("host", paramString1.field_host);
        paramString2.putString("param", paramString1.field_param);
        paramString2.putString("paramMap", paramString1.field_paramMap);
        paramString2.putString("headerMap", paramString1.field_headerMap);
        paramString2.putLong("updateTime", paramString1.field_updateTime);
        AppMethodBeat.o(217788);
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      ae.e("MicroMsg.LiteAppContentProvider", "getLiteAppAuthInfo failed. :%s", new Object[] { bu.o(paramString1) });
      AppMethodBeat.o(217788);
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.LiteAppContentProvider
 * JD-Core Version:    0.7.0.1
 */