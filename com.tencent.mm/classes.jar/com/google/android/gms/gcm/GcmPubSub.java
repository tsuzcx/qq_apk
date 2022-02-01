package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public class GcmPubSub
{
  private static GcmPubSub zzn;
  private static final Pattern zzp;
  private InstanceID zzo;
  
  static
  {
    AppMethodBeat.i(3627);
    zzp = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
    AppMethodBeat.o(3627);
  }
  
  private GcmPubSub(Context paramContext)
  {
    AppMethodBeat.i(3623);
    this.zzo = InstanceID.getInstance(paramContext);
    AppMethodBeat.o(3623);
  }
  
  @Deprecated
  public static GcmPubSub getInstance(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(3624);
      if (zzn == null)
      {
        GoogleCloudMessaging.zze(paramContext);
        zzn = new GcmPubSub(paramContext);
      }
      paramContext = zzn;
      AppMethodBeat.o(3624);
      return paramContext;
    }
    finally {}
  }
  
  @Deprecated
  public void subscribe(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(3625);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      paramString1 = String.valueOf(paramString1);
      if (paramString1.length() != 0) {}
      for (paramString1 = "Invalid appInstanceToken: ".concat(paramString1);; paramString1 = new String("Invalid appInstanceToken: "))
      {
        paramString1 = new IllegalArgumentException(paramString1);
        AppMethodBeat.o(3625);
        throw paramString1;
      }
    }
    if ((paramString2 == null) || (!zzp.matcher(paramString2).matches()))
    {
      paramString1 = String.valueOf(paramString2);
      if (paramString1.length() != 0) {}
      for (paramString1 = "Invalid topic name: ".concat(paramString1);; paramString1 = new String("Invalid topic name: "))
      {
        paramString1 = new IllegalArgumentException(paramString1);
        AppMethodBeat.o(3625);
        throw paramString1;
      }
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("gcm.topic", paramString2);
    this.zzo.getToken(paramString1, paramString2, localBundle);
    AppMethodBeat.o(3625);
  }
  
  @Deprecated
  public void unsubscribe(String paramString1, String paramString2)
  {
    AppMethodBeat.i(3626);
    Bundle localBundle = new Bundle();
    localBundle.putString("gcm.topic", paramString2);
    this.zzo.zzd(paramString1, paramString2, localBundle);
    AppMethodBeat.o(3626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmPubSub
 * JD-Core Version:    0.7.0.1
 */