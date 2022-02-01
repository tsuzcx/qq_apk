package com.google.android.gms.measurement;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.internal.measurement.zzgl;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class AppMeasurementContentProvider
  extends ContentProvider
{
  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    AppMethodBeat.i(87665);
    super.attachInfo(paramContext, paramProviderInfo);
    if ("com.google.android.gms.measurement.google_measurement_service".equals(paramProviderInfo.authority))
    {
      paramContext = new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
      AppMethodBeat.o(87665);
      throw paramContext;
    }
    AppMethodBeat.o(87665);
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
    AppMethodBeat.i(87664);
    zzgl.zzg(getContext());
    AppMethodBeat.o(87664);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementContentProvider
 * JD-Core Version:    0.7.0.1
 */