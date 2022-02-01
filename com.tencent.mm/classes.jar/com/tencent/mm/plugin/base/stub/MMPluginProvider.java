package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatAuthorities;

public class MMPluginProvider
  extends ContentProvider
{
  private static final UriMatcher thH;
  private c vrf;
  
  static
  {
    AppMethodBeat.i(22173);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    thH = localUriMatcher;
    localUriMatcher.addURI(WeChatAuthorities.AUTHORITIES_SDK_PLUGIN_PROVIDER(), "sharedpref", 2);
    AppMethodBeat.o(22173);
  }
  
  public MMPluginProvider()
  {
    AppMethodBeat.i(22166);
    this.vrf = new c();
    AppMethodBeat.o(22166);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(22170);
    Log.v("MicroMsg.MMPluginProvider", "plugin delete".concat(String.valueOf(paramUri)));
    switch (thH.match(paramUri))
    {
    default: 
      Log.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(22170);
      return 0;
    }
    int i = c.cZU();
    AppMethodBeat.o(22170);
    return i;
  }
  
  public String getType(Uri paramUri)
  {
    AppMethodBeat.i(22167);
    switch (thH.match(paramUri))
    {
    default: 
      AppMethodBeat.o(22167);
      return null;
    }
    AppMethodBeat.o(22167);
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(22169);
    Log.v("MicroMsg.MMPluginProvider", "plugin insert".concat(String.valueOf(paramUri)));
    switch (thH.match(paramUri))
    {
    default: 
      Log.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(22169);
      return null;
    }
    paramUri = c.cZT();
    AppMethodBeat.o(22169);
    return paramUri;
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(22168);
    Log.i("MicroMsg.MMPluginProvider", "onCreate");
    this.vrf.fH(getContext());
    AppMethodBeat.o(22168);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(22171);
    Log.i("MicroMsg.MMPluginProvider", "plugin query".concat(String.valueOf(paramUri)));
    switch (thH.match(paramUri))
    {
    default: 
      Log.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(22171);
      return null;
    }
    paramUri = c.c(paramArrayOfString1, paramArrayOfString2);
    AppMethodBeat.o(22171);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(22172);
    Log.d("MicroMsg.MMPluginProvider", "plugin update".concat(String.valueOf(paramUri)));
    switch (thH.match(paramUri))
    {
    default: 
      Log.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(22172);
      return 0;
    }
    int i = c.cZV();
    AppMethodBeat.o(22172);
    return i;
  }
  
  protected static abstract class a
  {
    private Context context = null;
    
    public boolean fH(Context paramContext)
    {
      this.context = paramContext;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.MMPluginProvider
 * JD-Core Version:    0.7.0.1
 */