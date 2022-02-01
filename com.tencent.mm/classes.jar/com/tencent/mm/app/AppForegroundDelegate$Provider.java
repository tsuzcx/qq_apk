package com.tencent.mm.app;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppForegroundDelegate$Provider
  extends ContentProvider
{
  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(131758);
    if (paramString1.equals("isAppForeground"))
    {
      paramString1 = new Bundle();
      paramString1.putString("com.tencent.mm.AppForegroundDelegate.ACTIVITY_NAME", AppForegroundDelegate.a(AppForegroundDelegate.cKE).cKU.activity);
      paramString1.putBoolean("isAppForeground", AppForegroundDelegate.c(AppForegroundDelegate.cKE));
      AppMethodBeat.o(131758);
      return paramString1;
    }
    paramString1 = super.call(paramString1, paramString2, paramBundle);
    AppMethodBeat.o(131758);
    return paramString1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.AppForegroundDelegate.Provider
 * JD-Core Version:    0.7.0.1
 */