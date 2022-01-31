package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzgj
{
  public static IntentFilter zza(String paramString, Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(71370);
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
    AppMethodBeat.o(71370);
    return paramString;
  }
  
  public static IntentFilter zzc(String paramString)
  {
    AppMethodBeat.i(71369);
    paramString = new IntentFilter(paramString);
    paramString.addDataScheme("wear");
    paramString.addDataAuthority("*", null);
    AppMethodBeat.o(71369);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzgj
 * JD-Core Version:    0.7.0.1
 */