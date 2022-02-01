package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

class AccessTokenCache
{
  static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
  private final SharedPreferences sharedPreferences;
  private LegacyTokenHelper tokenCachingStrategy;
  private final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;
  
  public AccessTokenCache()
  {
    this(FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new SharedPreferencesTokenCachingStrategyFactory());
    AppMethodBeat.i(16977);
    AppMethodBeat.o(16977);
  }
  
  AccessTokenCache(SharedPreferences paramSharedPreferences, SharedPreferencesTokenCachingStrategyFactory paramSharedPreferencesTokenCachingStrategyFactory)
  {
    this.sharedPreferences = paramSharedPreferences;
    this.tokenCachingStrategyFactory = paramSharedPreferencesTokenCachingStrategyFactory;
  }
  
  private AccessToken getCachedAccessToken()
  {
    AppMethodBeat.i(16982);
    Object localObject = this.sharedPreferences.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
    if (localObject != null) {
      try
      {
        localObject = AccessToken.createFromJSONObject(new JSONObject((String)localObject));
        AppMethodBeat.o(16982);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        AppMethodBeat.o(16982);
        return null;
      }
    }
    AppMethodBeat.o(16982);
    return null;
  }
  
  private AccessToken getLegacyAccessToken()
  {
    AppMethodBeat.i(16984);
    Object localObject2 = null;
    Bundle localBundle = getTokenCachingStrategy().load();
    Object localObject1 = localObject2;
    if (localBundle != null)
    {
      localObject1 = localObject2;
      if (LegacyTokenHelper.hasTokenInformation(localBundle)) {
        localObject1 = AccessToken.createFromLegacyCache(localBundle);
      }
    }
    AppMethodBeat.o(16984);
    return localObject1;
  }
  
  private LegacyTokenHelper getTokenCachingStrategy()
  {
    AppMethodBeat.i(16985);
    if (this.tokenCachingStrategy == null) {}
    try
    {
      if (this.tokenCachingStrategy == null) {
        this.tokenCachingStrategy = this.tokenCachingStrategyFactory.create();
      }
      LegacyTokenHelper localLegacyTokenHelper = this.tokenCachingStrategy;
      AppMethodBeat.o(16985);
      return localLegacyTokenHelper;
    }
    finally
    {
      AppMethodBeat.o(16985);
    }
  }
  
  private boolean hasCachedAccessToken()
  {
    AppMethodBeat.i(16981);
    boolean bool = this.sharedPreferences.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    AppMethodBeat.o(16981);
    return bool;
  }
  
  private boolean shouldCheckLegacyToken()
  {
    AppMethodBeat.i(16983);
    boolean bool = FacebookSdk.isLegacyTokenUpgradeSupported();
    AppMethodBeat.o(16983);
    return bool;
  }
  
  public void clear()
  {
    AppMethodBeat.i(16980);
    this.sharedPreferences.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
    if (shouldCheckLegacyToken()) {
      getTokenCachingStrategy().clear();
    }
    AppMethodBeat.o(16980);
  }
  
  public AccessToken load()
  {
    AppMethodBeat.i(16978);
    Object localObject = null;
    if (hasCachedAccessToken()) {
      localObject = getCachedAccessToken();
    }
    for (;;)
    {
      AppMethodBeat.o(16978);
      return localObject;
      if (shouldCheckLegacyToken())
      {
        AccessToken localAccessToken = getLegacyAccessToken();
        localObject = localAccessToken;
        if (localAccessToken != null)
        {
          save(localAccessToken);
          getTokenCachingStrategy().clear();
          localObject = localAccessToken;
        }
      }
    }
  }
  
  public void save(AccessToken paramAccessToken)
  {
    AppMethodBeat.i(16979);
    Validate.notNull(paramAccessToken, "accessToken");
    try
    {
      paramAccessToken = paramAccessToken.toJSONObject();
      this.sharedPreferences.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", paramAccessToken.toString()).apply();
      AppMethodBeat.o(16979);
      return;
    }
    catch (JSONException paramAccessToken)
    {
      AppMethodBeat.o(16979);
    }
  }
  
  static class SharedPreferencesTokenCachingStrategyFactory
  {
    public LegacyTokenHelper create()
    {
      AppMethodBeat.i(16976);
      LegacyTokenHelper localLegacyTokenHelper = new LegacyTokenHelper(FacebookSdk.getApplicationContext());
      AppMethodBeat.o(16976);
      return localLegacyTokenHelper;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.AccessTokenCache
 * JD-Core Version:    0.7.0.1
 */