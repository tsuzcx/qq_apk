package com.facebook.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class FacebookInitProvider
  extends ContentProvider
{
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(17716);
    TAG = FacebookInitProvider.class.getSimpleName();
    AppMethodBeat.o(17716);
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public final String getType(Uri paramUri)
  {
    return null;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(17715);
    try
    {
      FacebookSdk.sdkInitialize(getContext());
      label13:
      AppMethodBeat.o(17715);
      return false;
    }
    catch (Exception localException)
    {
      break label13;
    }
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.internal.FacebookInitProvider
 * JD-Core Version:    0.7.0.1
 */