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
    AppMethodBeat.i(17257);
    this.sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
    AppMethodBeat.o(17257);
  }
  
  final void clear()
  {
    AppMethodBeat.i(17260);
    this.sharedPreferences.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    AppMethodBeat.o(17260);
  }
  
  final Profile load()
  {
    AppMethodBeat.i(17258);
    Object localObject = this.sharedPreferences.getString("com.facebook.ProfileManager.CachedProfile", null);
    if (localObject != null) {
      try
      {
        localObject = new Profile(new JSONObject((String)localObject));
        AppMethodBeat.o(17258);
        return localObject;
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(17258);
    return null;
  }
  
  final void save(Profile paramProfile)
  {
    AppMethodBeat.i(17259);
    Validate.notNull(paramProfile, "profile");
    paramProfile = paramProfile.toJSONObject();
    if (paramProfile != null) {
      this.sharedPreferences.edit().putString("com.facebook.ProfileManager.CachedProfile", paramProfile.toString()).apply();
    }
    AppMethodBeat.o(17259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.ProfileCache
 * JD-Core Version:    0.7.0.1
 */