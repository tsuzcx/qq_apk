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
    AppMethodBeat.i(71825);
    Validate.notNull(paramd, "localBroadcastManager");
    Validate.notNull(paramProfileCache, "profileCache");
    this.localBroadcastManager = paramd;
    this.profileCache = paramProfileCache;
    AppMethodBeat.o(71825);
  }
  
  static ProfileManager getInstance()
  {
    AppMethodBeat.i(71826);
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new ProfileManager(d.R(FacebookSdk.getApplicationContext()), new ProfileCache());
      }
      ProfileManager localProfileManager = instance;
      AppMethodBeat.o(71826);
      return localProfileManager;
    }
    finally
    {
      AppMethodBeat.o(71826);
    }
  }
  
  private void sendCurrentProfileChangedBroadcast(Profile paramProfile1, Profile paramProfile2)
  {
    AppMethodBeat.i(71830);
    Intent localIntent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
    localIntent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", paramProfile1);
    localIntent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", paramProfile2);
    this.localBroadcastManager.c(localIntent);
    AppMethodBeat.o(71830);
  }
  
  private void setCurrentProfile(Profile paramProfile, boolean paramBoolean)
  {
    AppMethodBeat.i(71829);
    Profile localProfile = this.currentProfile;
    this.currentProfile = paramProfile;
    if (paramBoolean)
    {
      if (paramProfile == null) {
        break label51;
      }
      this.profileCache.save(paramProfile);
    }
    for (;;)
    {
      if (!Utility.areObjectsEqual(localProfile, paramProfile)) {
        sendCurrentProfileChangedBroadcast(localProfile, paramProfile);
      }
      AppMethodBeat.o(71829);
      return;
      label51:
      this.profileCache.clear();
    }
  }
  
  final Profile getCurrentProfile()
  {
    return this.currentProfile;
  }
  
  final boolean loadCurrentProfile()
  {
    AppMethodBeat.i(71827);
    Profile localProfile = this.profileCache.load();
    if (localProfile != null)
    {
      setCurrentProfile(localProfile, false);
      AppMethodBeat.o(71827);
      return true;
    }
    AppMethodBeat.o(71827);
    return false;
  }
  
  final void setCurrentProfile(Profile paramProfile)
  {
    AppMethodBeat.i(71828);
    setCurrentProfile(paramProfile, true);
    AppMethodBeat.o(71828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.ProfileManager
 * JD-Core Version:    0.7.0.1
 */