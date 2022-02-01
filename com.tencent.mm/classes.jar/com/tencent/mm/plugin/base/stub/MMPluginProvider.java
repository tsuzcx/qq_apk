package com.tencent.mm.plugin.base.stub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

@JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.PROVIDERCHECK})
public class MMPluginProvider
  extends ContentProvider
{
  private static final UriMatcher nmo;
  private c nmn;
  
  static
  {
    AppMethodBeat.i(22173);
    UriMatcher localUriMatcher = new UriMatcher(-1);
    nmo = localUriMatcher;
    localUriMatcher.addURI("com.tencent.mm.sdk.plugin.provider", "sharedpref", 2);
    AppMethodBeat.o(22173);
  }
  
  public MMPluginProvider()
  {
    AppMethodBeat.i(22166);
    this.nmn = new c();
    AppMethodBeat.o(22166);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(22170);
    ac.v("MicroMsg.MMPluginProvider", "plugin delete".concat(String.valueOf(paramUri)));
    switch (nmo.match(paramUri))
    {
    default: 
      ac.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(22170);
      return 0;
    }
    AppMethodBeat.o(22170);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    AppMethodBeat.i(22167);
    switch (nmo.match(paramUri))
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
    ac.v("MicroMsg.MMPluginProvider", "plugin insert".concat(String.valueOf(paramUri)));
    switch (nmo.match(paramUri))
    {
    default: 
      ac.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(22169);
      return null;
    }
    AppMethodBeat.o(22169);
    return null;
  }
  
  public boolean onCreate()
  {
    AppMethodBeat.i(22168);
    ac.i("MicroMsg.MMPluginProvider", "onCreate");
    this.nmn.em(getContext());
    AppMethodBeat.o(22168);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(22171);
    ac.i("MicroMsg.MMPluginProvider", "plugin query".concat(String.valueOf(paramUri)));
    switch (nmo.match(paramUri))
    {
    default: 
      ac.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(22171);
      return null;
    }
    paramUri = c.b(paramArrayOfString1, paramArrayOfString2);
    AppMethodBeat.o(22171);
    return paramUri;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(22172);
    ac.d("MicroMsg.MMPluginProvider", "plugin update".concat(String.valueOf(paramUri)));
    switch (nmo.match(paramUri))
    {
    default: 
      ac.e("MicroMsg.MMPluginProvider", "Unknown URI ".concat(String.valueOf(paramUri)));
      AppMethodBeat.o(22172);
      return 0;
    }
    AppMethodBeat.o(22172);
    return 0;
  }
  
  protected static abstract class a
  {
    private Context context = null;
    
    public boolean em(Context paramContext)
    {
      this.context = paramContext;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.MMPluginProvider
 * JD-Core Version:    0.7.0.1
 */