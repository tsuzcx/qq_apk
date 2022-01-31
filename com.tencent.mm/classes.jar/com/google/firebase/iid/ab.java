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
  private final a beW;
  private final f beX;
  private final FirebaseInstanceId bfN;
  final m bgm;
  private final ScheduledThreadPoolExecutor bgn;
  
  ab(a parama, FirebaseInstanceId paramFirebaseInstanceId, f paramf)
  {
    AppMethodBeat.i(108794);
    this.beW = parama;
    this.bfN = paramFirebaseInstanceId;
    this.beX = paramf;
    this.bgm = new m(parama.getApplicationContext(), paramf);
    this.bgn = new ScheduledThreadPoolExecutor(1);
    AppMethodBeat.o(108794);
  }
  
  final Bundle c(String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(108796);
    paramBundle.putString("scope", paramString2);
    paramBundle.putString("sender", paramString1);
    paramBundle.putString("subtype", paramString1);
    paramBundle.putString("appid", FirebaseInstanceId.zzf());
    paramBundle.putString("gmp_app_id", this.beW.rA().zzs);
    paramBundle.putString("gmsv", Integer.toString(this.beX.rY()));
    paramBundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
    paramBundle.putString("app_ver", this.beX.rW());
    paramBundle.putString("app_ver_name", this.beX.rX());
    paramBundle.putString("cliv", "fiid-12451000");
    AppMethodBeat.o(108796);
    return paramBundle;
  }
  
  final String h(Bundle paramBundle)
  {
    AppMethodBeat.i(108797);
    if (paramBundle == null)
    {
      paramBundle = new IOException("SERVICE_NOT_AVAILABLE");
      AppMethodBeat.o(108797);
      throw paramBundle;
    }
    String str = paramBundle.getString("registration_id");
    if (str != null)
    {
      AppMethodBeat.o(108797);
      return str;
    }
    str = paramBundle.getString("unregistered");
    if (str != null)
    {
      AppMethodBeat.o(108797);
      return str;
    }
    str = paramBundle.getString("error");
    if ("RST".equals(str))
    {
      this.bfN.rQ();
      paramBundle = new IOException("INSTANCE_ID_RESET");
      AppMethodBeat.o(108797);
      throw paramBundle;
    }
    if (str != null)
    {
      paramBundle = new IOException(str);
      AppMethodBeat.o(108797);
      throw paramBundle;
    }
    paramBundle = String.valueOf(paramBundle);
    new StringBuilder(String.valueOf(paramBundle).length() + 21).append("Unexpected response: ").append(paramBundle);
    new Throwable();
    paramBundle = new IOException("SERVICE_NOT_AVAILABLE");
    AppMethodBeat.o(108797);
    throw paramBundle;
  }
  
  public final Task<String> p(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108795);
    Bundle localBundle = new Bundle();
    c(paramString1, paramString2, localBundle);
    paramString1 = new TaskCompletionSource();
    this.bgn.execute(new ac(this, localBundle, paramString1));
    paramString1 = paramString1.getTask().continueWith(this.bgn, new ad(this));
    AppMethodBeat.o(108795);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.ab
 * JD-Core Version:    0.7.0.1
 */