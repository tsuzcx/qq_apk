package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FirebaseInitProvider
  extends ContentProvider
{
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    AppMethodBeat.i(10637);
    Preconditions.checkNotNull(paramProviderInfo, "FirebaseInitProvider ProviderInfo cannot be null.");
    if ("com.google.firebase.firebaseinitprovider".equals(paramProviderInfo.authority))
    {
      paramContext = new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
      AppMethodBeat.o(10637);
      throw paramContext;
    }
    super.attachInfo(paramContext, paramProviderInfo);
    AppMethodBeat.o(10637);
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
    AppMethodBeat.i(10638);
    a.ac(getContext());
    AppMethodBeat.o(10638);
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.firebase.provider.FirebaseInitProvider
 * JD-Core Version:    0.7.0.1
 */