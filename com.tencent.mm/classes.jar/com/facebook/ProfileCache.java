package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

final class ProfileCache
{
  static final String CACHED_PROFILE_KEY = "com.facebook.ProfileManager.CachedProfile";
  static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
  private final SharedPreferences sharedPreferences;
  
  ProfileCache()
  {
    AppMethodBeat.i(71821);
    this.sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
    AppMethodBeat.o(71821);
  }
  
  final void clear()
  {
    AppMethodBeat.i(71824);
    this.sharedPreferences.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    AppMethodBeat.o(71824);
  }
  
  final Profile load()
  {
    AppMethodBeat.i(71822);
    Object localObject = this.sharedPreferences.getString("com.facebook.ProfileManager.CachedProfile", null);
    if (localObject != null) {
      try
      {
        localObject = new Profile(new JSONObject((String)localObject));
        AppMethodBeat.o(71822);
        return localObject;
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(71822);
    return null;
  }
  
  final void save(Profile paramProfile)
  {
    AppMethodBeat.i(71823);
    Validate.notNull(paramProfile, "profile");
    paramProfile = paramProfile.toJSONObject();
    if (paramProfile != null) {
      this.sharedPreferences.edit().putString("com.facebook.ProfileManager.CachedProfile", paramProfile.toString()).apply();
    }
    AppMethodBeat.o(71823);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.ProfileCache
 * JD-Core Version:    0.7.0.1
 */