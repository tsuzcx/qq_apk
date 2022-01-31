package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.mm.h.a.fk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=32, fComment="checked", lastDate="20141016", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class ExtControlProviderAccountSync
  extends ExtContentProviderBase
{
  private static final UriMatcher jKj;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    jKj = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.plugin.ext.AccountSync", "accountSync", 1);
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
    y.d("MicroMsg.ExtControlAccountSyncProvider", "query()");
    a(paramUri, getContext(), jKj);
    if (paramUri == null)
    {
      qF(3);
      return null;
    }
    if ((bk.bl(this.jKd)) || (bk.bl(aNA())))
    {
      qF(3);
      return null;
    }
    if (!awd())
    {
      qF(1);
      return this.hSn;
    }
    if (!dc(getContext()))
    {
      y.w("MicroMsg.ExtControlAccountSyncProvider", "invalid appid ! return null");
      qF(2);
      return null;
    }
    switch (jKj.match(paramUri))
    {
    default: 
      qF(3);
      return null;
    }
    y.i("MicroMsg.ExtControlAccountSyncProvider", "startContactSync()");
    paramUri = new fk();
    if (a.udP.m(paramUri))
    {
      qF(0);
      return null;
    }
    y.e("MicroMsg.ExtControlAccountSyncProvider", "AccountHelper == null");
    qF(4);
    return null;
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