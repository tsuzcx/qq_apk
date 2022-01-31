package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderAccountSync
  extends ExtContentProviderBase
{
  private static final UriMatcher meo;
  
  static
  {
    AppMethodBeat.i(20342);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    meo = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.AccountSync", "accountSync", 1);
    AppMethodBeat.o(20342);
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
    AppMethodBeat.i(20341);
    ab.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
    a(paramUri, getContext(), meo);
    if (paramUri == null)
    {
      vA(3);
      AppMethodBeat.o(20341);
      return null;
    }
    if ((bo.isNullOrNil(this.mei)) || (bo.isNullOrNil(btD())))
    {
      vA(3);
      AppMethodBeat.o(20341);
      return null;
    }
    if (!aVH())
    {
      vA(1);
      paramUri = this.jLW;
      AppMethodBeat.o(20341);
      return paramUri;
    }
    if (!dO(getContext()))
    {
      ab.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
      vA(2);
      AppMethodBeat.o(20341);
      return null;
    }
    switch (meo.match(paramUri))
    {
    default: 
      vA(3);
      AppMethodBeat.o(20341);
      return null;
    }
    ab.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
    paramUri = new fn();
    if (a.ymk.l(paramUri)) {
      vA(0);
    }
    for (;;)
    {
      AppMethodBeat.o(20341);
      return null;
      ab.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
      vA(4);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderAccountSync
 * JD-Core Version:    0.7.0.1
 */