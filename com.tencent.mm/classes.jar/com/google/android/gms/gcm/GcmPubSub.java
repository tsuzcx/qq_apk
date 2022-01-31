package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GcmPubSub
{
  private static GcmPubSub zzbgr;
  private static final Pattern zzbgt = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
  private InstanceID zzbgs;
  
  private GcmPubSub(Context paramContext)
  {
    this.zzbgs = InstanceID.getInstance(paramContext);
  }
  
  public static GcmPubSub getInstance(Context paramContext)
  {
    try
    {
      if (zzbgr == null) {
        zzbgr = new GcmPubSub(paramContext);
      }
      paramContext = zzbgr;
      return paramContext;
    }
    finally {}
  }
  
  public void subscribe(String paramString1, String paramString2, Bundle paramBundle)
  {
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      paramString1 = String.valueOf(paramString1);
      if (paramString1.length() != 0) {}
      for (paramString1 = "Invalid appInstanceToken: ".concat(paramString1);; paramString1 = new String("Invalid appInstanceToken: ")) {
        throw new IllegalArgumentException(paramString1);
      }
    }
    if ((paramString2 == null) || (!zzbgt.matcher(paramString2).matches()))
    {
      paramString1 = String.valueOf(paramString2);
      if (paramString1.length() != 0) {}
      for (paramString1 = "Invalid topic name: ".concat(paramString1);; paramString1 = new String("Invalid topic name: ")) {
        throw new IllegalArgumentException(paramString1);
      }
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("gcm.topic", paramString2);
    this.zzbgs.getToken(paramString1, paramString2, localBundle);
  }
  
  public void unsubscribe(String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("gcm.topic", paramString2);
    this.zzbgs.zzb(paramString1, paramString2, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.gcm.GcmPubSub
 * JD-Core Version:    0.7.0.1
 */