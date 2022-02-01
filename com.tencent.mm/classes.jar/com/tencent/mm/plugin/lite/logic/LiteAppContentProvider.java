package com.tencent.mm.plugin.lite.logic;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.d.b;
import com.tencent.mm.plugin.lite.d.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public class LiteAppContentProvider
  extends ContentProvider
{
  private static final UriMatcher pGt;
  private c uYH;
  
  static
  {
    AppMethodBeat.i(217176);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    pGt = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.lite.logic.LiteAppInfo", "LiteAppInfo", 1);
    AppMethodBeat.o(217176);
  }
  
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(217175);
    if ((!g.ajD().gBW) || (!g.ajA().aiK()))
    {
      ad.w("MicroMsg.LiteAppContentProvider", "kernel or account not init.");
      AppMethodBeat.o(217175);
      return null;
    }
    if (this.uYH == null) {
      this.uYH = new c(g.ajC().gBq);
    }
    ad.i("MicroMsg.LiteAppContentProvider", "call %s %s", new Object[] { paramString1, paramString2 });
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(217175);
        return null;
        if (paramString1.equals("getLiteAppInfo"))
        {
          i = 0;
          continue;
          if (paramString1.equals("insertLiteAppInfo")) {
            i = 1;
          }
        }
        break;
      }
    }
    try
    {
      paramString1 = this.uYH.aoy(paramString2);
      if (paramString1 != null)
      {
        paramString2 = new Bundle();
        new HashMap();
        paramString2.putString("appId", paramString1.field_appId);
        paramString2.putString("patchId", paramString1.field_patchId);
        paramString2.putString("signatureKey", paramString1.field_signatureKey);
        paramString2.putString("pkgType", paramString1.field_pkgType);
        paramString2.putString("pkgPath", paramString1.field_pkgPath);
        paramString2.putLong("updateTime", paramString1.field_updateTime);
        AppMethodBeat.o(217175);
        return paramString2;
      }
    }
    catch (Exception paramString1)
    {
      ad.e("MicroMsg.LiteAppContentProvider", "getLiteAppInfo failed. :%s", new Object[] { bt.n(paramString1) });
      AppMethodBeat.o(217175);
      return null;
    }
    paramString1 = paramBundle.getString("appId");
    if (paramString1 == null)
    {
      AppMethodBeat.o(217175);
      return null;
    }
    paramString2 = new b();
    paramString2.field_appId = paramString1;
    paramString2.field_signatureKey = paramBundle.getString("signatureKey");
    paramString2.field_pkgType = paramBundle.getString("pkgType");
    paramString2.field_pkgPath = paramBundle.getString("pkgPath");
    paramString2.field_patchId = paramBundle.getString("patchId");
    paramString2.field_updateTime = paramBundle.getLong("updateTime");
    if (this.uYH.aoy(paramString1) == null) {
      this.uYH.d(paramString2);
    }
    for (;;)
    {
      AppMethodBeat.o(217175);
      return null;
      this.uYH.update(paramString2, new String[0]);
    }
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
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.LiteAppContentProvider
 * JD-Core Version:    0.7.0.1
 */