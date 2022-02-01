package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderAccountSync
  extends ExtContentProviderBase
{
  private static final UriMatcher rdu;
  
  static
  {
    AppMethodBeat.i(24421);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    rdu = localUriMatcher;
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
    ad.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
    a(paramUri, getContext(), rdu);
    if (paramUri == null)
    {
      DF(3);
      AppMethodBeat.o(24420);
      return null;
    }
    if ((bt.isNullOrNil(this.rdo)) || (bt.isNullOrNil(csj())))
    {
      DF(3);
      AppMethodBeat.o(24420);
      return null;
    }
    if (!bMn())
    {
      DF(1);
      paramUri = this.nNT;
      AppMethodBeat.o(24420);
      return paramUri;
    }
    if (!eG(getContext()))
    {
      ad.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
      DF(2);
      AppMethodBeat.o(24420);
      return null;
    }
    switch (rdu.match(paramUri))
    {
    default: 
      DF(3);
      AppMethodBeat.o(24420);
      return null;
    }
    ad.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
    paramUri = new fx();
    if (a.IbL.l(paramUri)) {
      DF(0);
    }
    for (;;)
    {
      AppMethodBeat.o(24420);
      return null;
      ad.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
      DF(4);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.provider.ExtControlProviderAccountSync
 * JD-Core Version:    0.7.0.1
 */