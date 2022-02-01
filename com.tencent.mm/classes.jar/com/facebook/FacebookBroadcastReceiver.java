package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FacebookBroadcastReceiver
  extends BroadcastReceiver
{
  protected void onFailedAppCall(String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(17010);
    paramContext = paramIntent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
    String str = paramIntent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
    if ((paramContext != null) && (str != null))
    {
      Bundle localBundle = paramIntent.getExtras();
      if (NativeProtocol.isErrorResult(paramIntent))
      {
        onFailedAppCall(paramContext, str, localBundle);
        AppMethodBeat.o(17010);
        return;
      }
      onSuccessfulAppCall(paramContext, str, localBundle);
    }
    AppMethodBeat.o(17010);
  }
  
  protected void onSuccessfulAppCall(String paramString1, String paramString2, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.FacebookBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */