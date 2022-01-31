package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class MMPluginProvider
  extends ContentProvider
{
  private static final UriMatcher jLx;
  private c jLw;
  
  static
  {
    AppMethodBeat.i(18118);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    jLx = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.sdk.plugin.provider", "sharedpref", 2);
    AppMethodBeat.o(18118);
  }
  
  public MMPluginProvider()
  {
    AppMethodBeat.i(18111);
    this.jLw = new c();
    AppMethodBeat.o(18111);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(18115);
    ab.v("MicroMsg.MMPluginProvider", "plugin delete".concat(String.valueOf(paramUri)));
    switch (jLx.match(paramUri))
    {
    default: 
      ab.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(18115);
      return 0;
    }
    AppMethodBeat.o(18115);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    AppMethodBeat.i(18112);
    switch (jLx.match(paramUri))
    {
    default: 
      AppMethodBeat.o(18112);
      return null;
    }
    AppMethodBeat.o(18112);
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(18114);
    ab.v("MicroMsg.MMPluginProvider", "plugin insert".concat(String.valueOf(paramUri)));
    switch (jLx.match(paramUri))
    {
    default: 
      ab.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(18114);
      return null;
    }
    AppMethodBeat.o(18114);
    return null;
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(18113);
    ab.i("MicroMsg.MMPluginProvider", "onCreate");
    this.jLw.dy(getContext());
    AppMethodBeat.o(18113);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(18116);
    ab.i("MicroMsg.MMPluginProvider", "plugin query".concat(String.valueOf(paramUri)));
    switch (jLx.match(paramUri))
    {
    default: 
      ab.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(18116);
      return null;
    }
    paramUri = c.a(paramArrayOfString1, paramArrayOfString2);
    AppMethodBeat.o(18116);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(18117);
    ab.d("MicroMsg.MMPluginProvider", "plugin update".concat(String.valueOf(paramUri)));
    switch (jLx.match(paramUri))
    {
    default: 
      ab.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(18117);
      return 0;
    }
    AppMethodBeat.o(18117);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.MMPluginProvider
 * JD-Core Version:    0.7.0.1
 */