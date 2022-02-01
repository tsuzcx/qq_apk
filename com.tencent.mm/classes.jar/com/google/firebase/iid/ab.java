package com.google.firebase.iid;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.a;
import com.google.firebase.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

final class ab
  implements ae
{
  private final a bIN;
  private final f bIO;
  private final FirebaseInstanceId bJD;
  final m bKc;
  private final ScheduledThreadPoolExecutor bKd;
  
  ab(a parama, FirebaseInstanceId paramFirebaseInstanceId, f paramf)
  {
    AppMethodBeat.i(4230);
    this.bIN = parama;
    this.bJD = paramFirebaseInstanceId;
    this.bIO = paramf;
    this.bKc = new m(parama.getApplicationContext(), paramf);
    this.bKd = new ScheduledThreadPoolExecutor(1);
    AppMethodBeat.o(4230);
  }
  
  final Bundle c(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(4232);
    paramBundle.putString("scope", paramString2);
    paramBundle.putString("sender", paramString1);
    paramBundle.putString("subtype", paramString1);
    paramBundle.putString("appid", FirebaseInstanceId.zzf());
    paramBundle.putString("gmp_app_id", this.bIN.yl().zzs);
    paramBundle.putString("gmsv", Integer.toString(this.bIO.yJ()));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", this.bIO.yH());
    paramBundle.putString("app_ver_name", this.bIO.yI());
    paramBundle.putString("cliv", "fiid-12451000");
    AppMethodBeat.o(4232);
    return paramBundle;
  }
  
  final String l(Bundle paramBundle)
  {
    AppMethodBeat.i(4233);
    if (paramBundle == null)
    {
      paramBundle = new IOException("SERVICE_NOT_AVAILABLE");
      AppMethodBeat.o(4233);
      throw paramBundle;
    }
    String str = paramBundle.getString("registration_id");
    if (str != null)
    {
      AppMethodBeat.o(4233);
      return str;
    }
    str = paramBundle.getString("unregistered");
    if (str != null)
    {
      AppMethodBeat.o(4233);
      return str;
    }
    str = paramBundle.getString("error");
    if ("RST".equals(str))
    {
      this.bJD.yB();
      paramBundle = new IOException("INSTANCE_ID_RESET");
      AppMethodBeat.o(4233);
      throw paramBundle;
    }
    if (str != null)
    {
      paramBundle = new IOException(str);
      AppMethodBeat.o(4233);
      throw paramBundle;
    }
    paramBundle = String.valueOf(paramBundle);
    new StringBuilder(String.valueOf(paramBundle).length() + 21).append("Unexpected response: ").append(paramBundle);
    new Throwable();
    paramBundle = new IOException("SERVICE_NOT_AVAILABLE");
    AppMethodBeat.o(4233);
    throw paramBundle;
  }
  
  public final Task<String> u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4231);
    Bundle localBundle = new Bundle();
    c(paramString1, paramString2, localBundle);
    paramString1 = new TaskCompletionSource();
    this.bKd.execute(new ac(this, localBundle, paramString1));
    paramString1 = paramString1.getTask().continueWith(this.bKd, new ad(this));
    AppMethodBeat.o(4231);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.ab
 * JD-Core Version:    0.7.0.1
 */