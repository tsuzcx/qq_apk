package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class zze
  implements Runnable
{
  private static final Logger zzer;
  private final StatusPendingResult zzes;
  private final String zzz;
  
  static
  {
    AppMethodBeat.i(50420);
    zzer = new Logger("RevokeAccessOperation", new String[0]);
    AppMethodBeat.o(50420);
  }
  
  private zze(String paramString)
  {
    AppMethodBeat.i(50417);
    Preconditions.checkNotEmpty(paramString);
    this.zzz = paramString;
    this.zzes = new StatusPendingResult(null);
    AppMethodBeat.o(50417);
  }
  
  public static PendingResult<Status> zzg(String paramString)
  {
    AppMethodBeat.i(50419);
    if (paramString == null)
    {
      paramString = PendingResults.immediateFailedResult(new Status(4), null);
      AppMethodBeat.o(50419);
      return paramString;
    }
    paramString = new zze(paramString);
    new Thread(paramString).start();
    paramString = paramString.zzes;
    AppMethodBeat.o(50419);
    return paramString;
  }
  
  public final void run()
  {
    AppMethodBeat.i(50418);
    Object localObject1 = Status.RESULT_INTERNAL_ERROR;
    for (;;)
    {
      try
      {
        localObject2 = String.valueOf("https://accounts.google.com/o/oauth2/revoke?token=");
        localObject3 = String.valueOf(this.zzz);
        if (((String)localObject3).length() != 0)
        {
          localObject2 = ((String)localObject2).concat((String)localObject3);
          localObject2 = (HttpURLConnection)new URL((String)localObject2).openConnection();
          ((HttpURLConnection)localObject2).setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
          i = ((HttpURLConnection)localObject2).getResponseCode();
          if (i != 200) {
            continue;
          }
          localObject2 = Status.RESULT_SUCCESS;
          localObject1 = localObject2;
        }
      }
      catch (IOException localIOException1)
      {
        Object localObject2;
        int i;
        localObject3 = zzer;
        String str1 = String.valueOf(localIOException1.toString());
        if (str1.length() != 0)
        {
          str1 = "IOException when revoking access: ".concat(str1);
          ((Logger)localObject3).e(str1, new Object[0]);
          continue;
          zzer.e("Unable to revoke access!", new Object[0]);
          continue;
        }
        str1 = new String("IOException when revoking access: ");
        continue;
      }
      catch (Exception localException1)
      {
        Object localObject3 = zzer;
        String str2 = String.valueOf(localException1.toString());
        if (str2.length() != 0)
        {
          str2 = "Exception when revoking access: ".concat(str2);
          ((Logger)localObject3).e(str2, new Object[0]);
          continue;
        }
        str2 = new String("Exception when revoking access: ");
        continue;
      }
      try
      {
        zzer.d(26 + "Response Code: " + i, new Object[0]);
        this.zzes.setResult((Result)localObject1);
        AppMethodBeat.o(50418);
        return;
      }
      catch (Exception localException2)
      {
        continue;
      }
      catch (IOException localIOException2)
      {
        continue;
      }
      localObject2 = new String((String)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zze
 * JD-Core Version:    0.7.0.1
 */