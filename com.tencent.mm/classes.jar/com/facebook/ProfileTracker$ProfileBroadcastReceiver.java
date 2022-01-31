package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ProfileTracker$ProfileBroadcastReceiver
  extends BroadcastReceiver
{
  private ProfileTracker$ProfileBroadcastReceiver(ProfileTracker paramProfileTracker) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(71831);
    if ("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED".equals(paramIntent.getAction()))
    {
      paramContext = (Profile)paramIntent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_PROFILE");
      paramIntent = (Profile)paramIntent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_PROFILE");
      this.this$0.onCurrentProfileChanged(paramContext, paramIntent);
    }
    AppMethodBeat.o(71831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.ProfileTracker.ProfileBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */