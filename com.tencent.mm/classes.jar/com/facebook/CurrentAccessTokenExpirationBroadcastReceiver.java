package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class CurrentAccessTokenExpirationBroadcastReceiver
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(71573);
    if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(paramIntent.getAction())) {
      AccessTokenManager.getInstance().currentAccessTokenChanged();
    }
    AppMethodBeat.o(71573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.CurrentAccessTokenExpirationBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */