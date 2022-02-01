package com.facebook;

import android.content.Intent;
import android.support.v4.content.d;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ProfileManager
{
  public static final String ACTION_CURRENT_PROFILE_CHANGED = "com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED";
  public static final String EXTRA_NEW_PROFILE = "com.facebook.sdk.EXTRA_NEW_PROFILE";
  public static final String EXTRA_OLD_PROFILE = "com.facebook.sdk.EXTRA_OLD_PROFILE";
  private static volatile ProfileManager instance;
  private Profile currentProfile;
  private final d localBroadcastManager;
  private final ProfileCache profileCache;
  
  ProfileManager(d paramd, ProfileCache paramProfileCache)
  {
    AppMethodBeat.i(17261);
    Validate.notNull(paramd, "localBroadcastManager");
    Validate.notNull(paramProfileCache, "profileCache");
    this.localBroadcastManager = paramd;
    this.profileCache = paramProfileCache;
    AppMethodBeat.o(17261);
  }
  
  static ProfileManager getInstance()
  {
    AppMethodBeat.i(17262);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new ProfileManager(d.U(FacebookSdk.getApplicationContext()), new ProfileCache());
      }
      ProfileManager localProfileManager = instance;
      AppMethodBeat.o(17262);
      return localProfileManager;
    }
    finally
    {
      AppMethodBeat.o(17262);
    }
  }
  
  private void sendCurrentProfileChangedBroadcast(Profile paramProfile1, Profile paramProfile2)
  {
    AppMethodBeat.i(17266);
    Intent localIntent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
    localIntent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", paramProfile1);
    localIntent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", paramProfile2);
    this.localBroadcastManager.b(localIntent);
    AppMethodBeat.o(17266);
  }
  
  private void setCurrentProfile(Profile paramProfile, boolean paramBoolean)
  {
    AppMethodBeat.i(17265);
    Profile localProfile = this.currentProfile;
    this.currentProfile = paramProfile;
    if (paramBoolean)
    {
      if (paramProfile == null) {
        break label53;
      }
      this.profileCache.save(paramProfile);
    }
    for (;;)
    {
      if (!Utility.areObjectsEqual(localProfile, paramProfile)) {
        sendCurrentProfileChangedBroadcast(localProfile, paramProfile);
      }
      AppMethodBeat.o(17265);
      return;
      label53:
      this.profileCache.clear();
    }
  }
  
  final Profile getCurrentProfile()
  {
    return this.currentProfile;
  }
  
  final boolean loadCurrentProfile()
  {
    AppMethodBeat.i(17263);
    Profile localProfile = this.profileCache.load();
    if (localProfile != null)
    {
      setCurrentProfile(localProfile, false);
      AppMethodBeat.o(17263);
      return true;
    }
    AppMethodBeat.o(17263);
    return false;
  }
  
  final void setCurrentProfile(Profile paramProfile)
  {
    AppMethodBeat.i(17264);
    setCurrentProfile(paramProfile, true);
    AppMethodBeat.o(17264);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.ProfileManager
 * JD-Core Version:    0.7.0.1
 */