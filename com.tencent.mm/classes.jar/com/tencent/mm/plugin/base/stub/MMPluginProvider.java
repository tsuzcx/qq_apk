package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.y;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class MMPluginProvider
  extends ContentProvider
{
  private static final UriMatcher hRS;
  private c hRR = new c();
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    hRS = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.sdk.plugin.provider", "sharedpref", 2);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    y.v("MicroMsg.MMPluginProvider", "plugin delete" + paramUri);
    switch (hRS.match(paramUri))
    {
    default: 
      y.e("MicroMsg.MMPluginProvider", "Unknown URI " + paramUri);
      return 0;
    }
    return c.avY();
  }
  
  public String getType(Uri paramUri)
  {
    switch (hRS.match(paramUri))
    {
    }
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    y.v("MicroMsg.MMPluginProvider", "plugin insert" + paramUri);
    switch (hRS.match(paramUri))
    {
    default: 
      y.e("MicroMsg.MMPluginProvider", "Unknown URI " + paramUri);
      return null;
    }
    return c.avX();
  }
  
  public boolean onCreate()
  {
    this.hRR.cN(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    y.i("MicroMsg.MMPluginProvider", "plugin query" + paramUri);
    switch (hRS.match(paramUri))
    {
    default: 
      y.e("MicroMsg.MMPluginProvider", "Unknown URI " + paramUri);
      return null;
    }
    return c.a(paramArrayOfString1, paramArrayOfString2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    y.d("MicroMsg.MMPluginProvider", "plugin update" + paramUri);
    switch (hRS.match(paramUri))
    {
    default: 
      y.e("MicroMsg.MMPluginProvider", "Unknown URI " + paramUri);
      return 0;
    }
    return c.avZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.MMPluginProvider
 * JD-Core Version:    0.7.0.1
 */