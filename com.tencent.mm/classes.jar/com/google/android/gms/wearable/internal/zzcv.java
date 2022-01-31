package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;

public final class zzcv
{
  public static IntentFilter zza(String paramString, Uri paramUri, int paramInt)
  {
    paramString = new IntentFilter(paramString);
    if (paramUri.getScheme() != null) {
      paramString.addDataScheme(paramUri.getScheme());
    }
    if (paramUri.getAuthority() != null) {
      paramString.addDataAuthority(paramUri.getAuthority(), Integer.toString(paramUri.getPort()));
    }
    if (paramUri.getPath() != null) {
      paramString.addDataPath(paramUri.getPath(), paramInt);
    }
    return paramString;
  }
  
  public static IntentFilter zzip(String paramString)
  {
    paramString = new IntentFilter(paramString);
    paramString.addDataScheme("wear");
    paramString.addDataAuthority("*", null);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzcv
 * JD-Core Version:    0.7.0.1
 */