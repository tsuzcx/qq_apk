package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderAccountSync
  extends ExtContentProviderBase
{
  private static final UriMatcher qtG;
  
  static
  {
    AppMethodBeat.i(24421);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    qtG = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.AccountSync", "accountSync", 1);
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
    ac.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
    a(paramUri, getContext(), qtG);
    if (paramUri == null)
    {
      CN(3);
      AppMethodBeat.o(24420);
      return null;
    }
    if ((bs.isNullOrNil(this.qtA)) || (bs.isNullOrNil(cmE())))
    {
      CN(3);
      AppMethodBeat.o(24420);
      return null;
    }
    if (!bIc())
    {
      CN(1);
      paramUri = this.nng;
      AppMethodBeat.o(24420);
      return paramUri;
    }
    if (!eG(getContext()))
    {
      ac.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
      CN(2);
      AppMethodBeat.o(24420);
      return null;
    }
    switch (qtG.match(paramUri))
    {
    default: 
      CN(3);
      AppMethodBeat.o(24420);
      return null;
    }
    ac.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
    paramUri = new fu();
    if (a.GpY.l(paramUri)) {
      CN(0);
    }
    for (;;)
    {
      AppMethodBeat.o(24420);
      return null;
      ac.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
      CN(4);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderAccountSync
 * JD-Core Version:    0.7.0.1
 */