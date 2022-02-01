package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Queue;

public class FirebaseInstanceIdService
  extends zzb
{
  protected final Intent f(Intent paramIntent)
  {
    AppMethodBeat.i(4146);
    paramIntent = (Intent)o.Yw().dDb.poll();
    AppMethodBeat.o(4146);
    return paramIntent;
  }
  
  public final void g(Intent paramIntent)
  {
    AppMethodBeat.i(4147);
    if ("com.google.firebase.iid.TOKEN_REFRESH".equals(paramIntent.getAction()))
    {
      onTokenRefresh();
      AppMethodBeat.o(4147);
      return;
    }
    String str = paramIntent.getStringExtra("CMD");
    if (str != null)
    {
      if (Log.isLoggable("FirebaseInstanceId", 3))
      {
        paramIntent = String.valueOf(paramIntent.getExtras());
        new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(paramIntent).length()).append("Received command: ").append(str).append(" - ").append(paramIntent);
      }
      if (("RST".equals(str)) || ("RST_FULL".equals(str)))
      {
        FirebaseInstanceId.Yh().Ym();
        AppMethodBeat.o(4147);
        return;
      }
      if ("SYNC".equals(str))
      {
        paramIntent = FirebaseInstanceId.Yh();
        FirebaseInstanceId.dCt.dC("");
        paramIntent.startSync();
      }
    }
    AppMethodBeat.o(4147);
  }
  
  public void onTokenRefresh() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceIdService
 * JD-Core Version:    0.7.0.1
 */