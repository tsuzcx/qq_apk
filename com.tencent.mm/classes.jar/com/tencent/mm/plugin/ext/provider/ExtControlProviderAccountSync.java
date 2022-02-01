package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;

public class ExtControlProviderAccountSync
  extends ExtContentProviderBase
{
  private static final UriMatcher zPg;
  
  static
  {
    AppMethodBeat.i(24421);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    zPg = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_PLUGIN_EXT_ACCOUNTSYNC(), "accountSync", 1);
    AppMethodBeat.o(24421);
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
    AppMethodBeat.i(24420);
    Log.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
    a(paramUri, getContext(), zPg);
    if (paramUri == null)
    {
      Mm(3);
      AppMethodBeat.o(24420);
      return null;
    }
    if ((Util.isNullOrNil(this.zPa)) || (Util.isNullOrNil(dOe())))
    {
      Mm(3);
      AppMethodBeat.o(24420);
      return null;
    }
    if (!dak())
    {
      Mm(1);
      paramUri = this.vsh;
      AppMethodBeat.o(24420);
      return paramUri;
    }
    if (!gh(getContext()))
    {
      Log.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
      Mm(2);
      AppMethodBeat.o(24420);
      return null;
    }
    switch (zPg.match(paramUri))
    {
    default: 
      Mm(3);
      AppMethodBeat.o(24420);
      return null;
    }
    Log.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
    if (new gt().publish()) {
      Mm(0);
    }
    for (;;)
    {
      AppMethodBeat.o(24420);
      return null;
      Log.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
      Mm(4);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderAccountSync
 * JD-Core Version:    0.7.0.1
 */