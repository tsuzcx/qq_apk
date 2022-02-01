package com.facebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AccessToken
  implements Parcelable
{
  public static final String ACCESS_TOKEN_KEY = "access_token";
  private static final String APPLICATION_ID_KEY = "application_id";
  public static final Parcelable.Creator<AccessToken> CREATOR;
  private static final int CURRENT_JSON_FORMAT = 1;
  public static final String DATA_ACCESS_EXPIRATION_TIME = "data_access_expiration_time";
  private static final String DECLINED_PERMISSIONS_KEY = "declined_permissions";
  private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE;
  private static final Date DEFAULT_EXPIRATION_TIME;
  private static final Date DEFAULT_LAST_REFRESH_TIME;
  private static final String EXPIRES_AT_KEY = "expires_at";
  public static final String EXPIRES_IN_KEY = "expires_in";
  private static final String LAST_REFRESH_KEY = "last_refresh";
  private static final Date MAX_DATE;
  private static final String PERMISSIONS_KEY = "permissions";
  private static final String SOURCE_KEY = "source";
  private static final String TOKEN_KEY = "token";
  public static final String USER_ID_KEY = "user_id";
  private static final String VERSION_KEY = "version";
  private final String applicationId;
  private final Date dataAccessExpirationTime;
  private final Set<String> declinedPermissions;
  private final Date expires;
  private final Date lastRefresh;
  private final Set<String> permissions;
  private final AccessTokenSource source;
  private final String token;
  private final String userId;
  
  static
  {
    AppMethodBeat.i(16975);
    Date localDate = new Date(9223372036854775807L);
    MAX_DATE = localDate;
    DEFAULT_EXPIRATION_TIME = localDate;
    DEFAULT_LAST_REFRESH_TIME = new Date();
    DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    CREATOR = new Parcelable.Creator()
    {
      public final AccessToken createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(16946);
        paramAnonymousParcel = new AccessToken(paramAnonymousParcel);
        AppMethodBeat.o(16946);
        return paramAnonymousParcel;
      }
      
      public final AccessToken[] newArray(int paramAnonymousInt)
      {
        return new AccessToken[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(16975);
  }
  
  AccessToken(Parcel paramParcel)
  {
    AppMethodBeat.i(16972);
    this.expires = new Date(paramParcel.readLong());
    ArrayList localArrayList = new ArrayList();
    paramParcel.readStringList(localArrayList);
    this.permissions = Collections.unmodifiableSet(new HashSet(localArrayList));
    localArrayList.clear();
    paramParcel.readStringList(localArrayList);
    this.declinedPermissions = Collections.unmodifiableSet(new HashSet(localArrayList));
    this.token = paramParcel.readString();
    this.source = AccessTokenSource.valueOf(paramParcel.readString());
    this.lastRefresh = new Date(paramParcel.readLong());
    this.applicationId = paramParcel.readString();
    this.userId = paramParcel.readString();
    this.dataAccessExpirationTime = new Date(paramParcel.readLong());
    AppMethodBeat.o(16972);
  }
  
  public AccessToken(String paramString1, String paramString2, String paramString3, Collection<String> paramCollection1, Collection<String> paramCollection2, AccessTokenSource paramAccessTokenSource, Date paramDate1, Date paramDate2, Date paramDate3)
  {
    AppMethodBeat.i(16949);
    Validate.notNullOrEmpty(paramString1, "accessToken");
    Validate.notNullOrEmpty(paramString2, "applicationId");
    Validate.notNullOrEmpty(paramString3, "userId");
    if (paramDate1 != null)
    {
      this.expires = paramDate1;
      if (paramCollection1 == null) {
        break label162;
      }
      paramCollection1 = new HashSet(paramCollection1);
      label55:
      this.permissions = Collections.unmodifiableSet(paramCollection1);
      if (paramCollection2 == null) {
        break label174;
      }
      paramCollection1 = new HashSet(paramCollection2);
      label80:
      this.declinedPermissions = Collections.unmodifiableSet(paramCollection1);
      this.token = paramString1;
      if (paramAccessTokenSource == null) {
        break label186;
      }
      label99:
      this.source = paramAccessTokenSource;
      if (paramDate2 == null) {
        break label194;
      }
      label110:
      this.lastRefresh = paramDate2;
      this.applicationId = paramString2;
      this.userId = paramString3;
      if ((paramDate3 == null) || (paramDate3.getTime() == 0L)) {
        break label202;
      }
    }
    for (;;)
    {
      this.dataAccessExpirationTime = paramDate3;
      AppMethodBeat.o(16949);
      return;
      paramDate1 = DEFAULT_EXPIRATION_TIME;
      break;
      label162:
      paramCollection1 = new HashSet();
      break label55;
      label174:
      paramCollection1 = new HashSet();
      break label80;
      label186:
      paramAccessTokenSource = DEFAULT_ACCESS_TOKEN_SOURCE;
      break label99;
      label194:
      paramDate2 = DEFAULT_LAST_REFRESH_TIME;
      break label110;
      label202:
      paramDate3 = DEFAULT_EXPIRATION_TIME;
    }
  }
  
  private void appendPermissions(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(16971);
    paramStringBuilder.append(" permissions:");
    if (this.permissions == null)
    {
      paramStringBuilder.append("null");
      AppMethodBeat.o(16971);
      return;
    }
    paramStringBuilder.append("[");
    paramStringBuilder.append(TextUtils.join(", ", this.permissions));
    paramStringBuilder.append("]");
    AppMethodBeat.o(16971);
  }
  
  static AccessToken createExpired(AccessToken paramAccessToken)
  {
    AppMethodBeat.i(16962);
    paramAccessToken = new AccessToken(paramAccessToken.token, paramAccessToken.applicationId, paramAccessToken.getUserId(), paramAccessToken.getPermissions(), paramAccessToken.getDeclinedPermissions(), paramAccessToken.source, new Date(), new Date(), paramAccessToken.dataAccessExpirationTime);
    AppMethodBeat.o(16962);
    return paramAccessToken;
  }
  
  private static AccessToken createFromBundle(List<String> paramList, Bundle paramBundle, AccessTokenSource paramAccessTokenSource, Date paramDate, String paramString)
  {
    AppMethodBeat.i(16969);
    String str1 = paramBundle.getString("access_token");
    paramDate = Utility.getBundleLongAsDate(paramBundle, "expires_in", paramDate);
    String str2 = paramBundle.getString("user_id");
    paramBundle = Utility.getBundleLongAsDate(paramBundle, "data_access_expiration_time", new Date(0L));
    if ((Utility.isNullOrEmpty(str1)) || (paramDate == null))
    {
      AppMethodBeat.o(16969);
      return null;
    }
    paramList = new AccessToken(str1, paramString, str2, paramList, null, paramAccessTokenSource, paramDate, new Date(), paramBundle);
    AppMethodBeat.o(16969);
    return paramList;
  }
  
  static AccessToken createFromJSONObject(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(16968);
    if (paramJSONObject.getInt("version") > 1)
    {
      paramJSONObject = new FacebookException("Unknown AccessToken serialization format.");
      AppMethodBeat.o(16968);
      throw paramJSONObject;
    }
    String str1 = paramJSONObject.getString("token");
    Date localDate1 = new Date(paramJSONObject.getLong("expires_at"));
    JSONArray localJSONArray1 = paramJSONObject.getJSONArray("permissions");
    JSONArray localJSONArray2 = paramJSONObject.getJSONArray("declined_permissions");
    Date localDate2 = new Date(paramJSONObject.getLong("last_refresh"));
    AccessTokenSource localAccessTokenSource = AccessTokenSource.valueOf(paramJSONObject.getString("source"));
    String str2 = paramJSONObject.getString("application_id");
    String str3 = paramJSONObject.getString("user_id");
    paramJSONObject = new Date(paramJSONObject.getLong("data_access_expiration_time"));
    paramJSONObject = new AccessToken(str1, str2, str3, Utility.jsonArrayToStringList(localJSONArray1), Utility.jsonArrayToStringList(localJSONArray2), localAccessTokenSource, localDate1, localDate2, paramJSONObject);
    AppMethodBeat.o(16968);
    return paramJSONObject;
  }
  
  static AccessToken createFromLegacyCache(Bundle paramBundle)
  {
    AppMethodBeat.i(16963);
    List localList1 = getPermissionsFromBundle(paramBundle, "com.facebook.TokenCachingStrategy.Permissions");
    List localList2 = getPermissionsFromBundle(paramBundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
    String str2 = LegacyTokenHelper.getApplicationId(paramBundle);
    String str1 = str2;
    if (Utility.isNullOrEmpty(str2)) {
      str1 = FacebookSdk.getApplicationId();
    }
    str2 = LegacyTokenHelper.getToken(paramBundle);
    Object localObject = Utility.awaitGetGraphMeRequestWithCache(str2);
    try
    {
      localObject = ((JSONObject)localObject).getString("id");
      paramBundle = new AccessToken(str2, str1, (String)localObject, localList1, localList2, LegacyTokenHelper.getSource(paramBundle), LegacyTokenHelper.getDate(paramBundle, "com.facebook.TokenCachingStrategy.ExpirationDate"), LegacyTokenHelper.getDate(paramBundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"), null);
      AppMethodBeat.o(16963);
      return paramBundle;
    }
    catch (JSONException paramBundle)
    {
      AppMethodBeat.o(16963);
    }
    return null;
  }
  
  public static void createFromNativeLinkingIntent(Intent paramIntent, final String paramString, final AccessTokenCreationCallback paramAccessTokenCreationCallback)
  {
    AppMethodBeat.i(16957);
    Validate.notNull(paramIntent, "intent");
    if (paramIntent.getExtras() == null)
    {
      paramAccessTokenCreationCallback.onError(new FacebookException("No extras found on intent"));
      AppMethodBeat.o(16957);
      return;
    }
    paramIntent = new Bundle(paramIntent.getExtras());
    String str1 = paramIntent.getString("access_token");
    if ((str1 == null) || (str1.isEmpty()))
    {
      paramAccessTokenCreationCallback.onError(new FacebookException("No access token found on intent"));
      AppMethodBeat.o(16957);
      return;
    }
    String str2 = paramIntent.getString("user_id");
    if ((str2 == null) || (str2.isEmpty()))
    {
      Utility.getGraphMeRequestWithCacheAsync(str1, new Utility.GraphMeRequestWithCacheCallback()
      {
        public final void onFailure(FacebookException paramAnonymousFacebookException)
        {
          AppMethodBeat.i(16945);
          paramAccessTokenCreationCallback.onError(paramAnonymousFacebookException);
          AppMethodBeat.o(16945);
        }
        
        public final void onSuccess(JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(16944);
          try
          {
            paramAnonymousJSONObject = paramAnonymousJSONObject.getString("id");
            this.val$extras.putString("user_id", paramAnonymousJSONObject);
            paramAccessTokenCreationCallback.onSuccess(AccessToken.access$000(null, this.val$extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), paramString));
            AppMethodBeat.o(16944);
            return;
          }
          catch (JSONException paramAnonymousJSONObject)
          {
            paramAccessTokenCreationCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
            AppMethodBeat.o(16944);
          }
        }
      });
      AppMethodBeat.o(16957);
      return;
    }
    paramAccessTokenCreationCallback.onSuccess(createFromBundle(null, paramIntent, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), paramString));
    AppMethodBeat.o(16957);
  }
  
  @SuppressLint({"FieldGetter"})
  static AccessToken createFromRefresh(AccessToken paramAccessToken, Bundle paramBundle)
  {
    AppMethodBeat.i(16961);
    if ((paramAccessToken.source != AccessTokenSource.FACEBOOK_APPLICATION_WEB) && (paramAccessToken.source != AccessTokenSource.FACEBOOK_APPLICATION_NATIVE) && (paramAccessToken.source != AccessTokenSource.FACEBOOK_APPLICATION_SERVICE))
    {
      paramAccessToken = new FacebookException("Invalid token source: " + paramAccessToken.source);
      AppMethodBeat.o(16961);
      throw paramAccessToken;
    }
    Date localDate = Utility.getBundleLongAsDate(paramBundle, "expires_in", new Date(0L));
    String str = paramBundle.getString("access_token");
    paramBundle = Utility.getBundleLongAsDate(paramBundle, "data_access_expiration_time", new Date(0L));
    if (Utility.isNullOrEmpty(str))
    {
      AppMethodBeat.o(16961);
      return null;
    }
    paramAccessToken = new AccessToken(str, paramAccessToken.applicationId, paramAccessToken.getUserId(), paramAccessToken.getPermissions(), paramAccessToken.getDeclinedPermissions(), paramAccessToken.source, localDate, new Date(), paramBundle);
    AppMethodBeat.o(16961);
    return paramAccessToken;
  }
  
  static void expireCurrentAccessToken()
  {
    AppMethodBeat.i(16953);
    AccessToken localAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
    if (localAccessToken != null) {
      setCurrentAccessToken(createExpired(localAccessToken));
    }
    AppMethodBeat.o(16953);
  }
  
  public static AccessToken getCurrentAccessToken()
  {
    AppMethodBeat.i(16950);
    AccessToken localAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
    AppMethodBeat.o(16950);
    return localAccessToken;
  }
  
  static List<String> getPermissionsFromBundle(Bundle paramBundle, String paramString)
  {
    AppMethodBeat.i(16964);
    paramBundle = paramBundle.getStringArrayList(paramString);
    if (paramBundle == null) {}
    for (paramBundle = Collections.emptyList();; paramBundle = Collections.unmodifiableList(new ArrayList(paramBundle)))
    {
      AppMethodBeat.o(16964);
      return paramBundle;
    }
  }
  
  public static boolean isCurrentAccessTokenActive()
  {
    AppMethodBeat.i(16951);
    AccessToken localAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
    if ((localAccessToken != null) && (!localAccessToken.isExpired()))
    {
      AppMethodBeat.o(16951);
      return true;
    }
    AppMethodBeat.o(16951);
    return false;
  }
  
  public static boolean isDataAccessActive()
  {
    AppMethodBeat.i(16952);
    AccessToken localAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
    if ((localAccessToken != null) && (!localAccessToken.isDataAccessExpired()))
    {
      AppMethodBeat.o(16952);
      return true;
    }
    AppMethodBeat.o(16952);
    return false;
  }
  
  public static void refreshCurrentAccessTokenAsync()
  {
    AppMethodBeat.i(16955);
    AccessTokenManager.getInstance().refreshCurrentAccessToken(null);
    AppMethodBeat.o(16955);
  }
  
  public static void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback paramAccessTokenRefreshCallback)
  {
    AppMethodBeat.i(16956);
    AccessTokenManager.getInstance().refreshCurrentAccessToken(paramAccessTokenRefreshCallback);
    AppMethodBeat.o(16956);
  }
  
  public static void setCurrentAccessToken(AccessToken paramAccessToken)
  {
    AppMethodBeat.i(16954);
    AccessTokenManager.getInstance().setCurrentAccessToken(paramAccessToken);
    AppMethodBeat.o(16954);
  }
  
  private String tokenToString()
  {
    AppMethodBeat.i(16970);
    if (this.token == null)
    {
      AppMethodBeat.o(16970);
      return "null";
    }
    if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS))
    {
      String str = this.token;
      AppMethodBeat.o(16970);
      return str;
    }
    AppMethodBeat.o(16970);
    return "ACCESS_TOKEN_REMOVED";
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(16959);
    if (this == paramObject)
    {
      AppMethodBeat.o(16959);
      return true;
    }
    if (!(paramObject instanceof AccessToken))
    {
      AppMethodBeat.o(16959);
      return false;
    }
    paramObject = (AccessToken)paramObject;
    if ((this.expires.equals(paramObject.expires)) && (this.permissions.equals(paramObject.permissions)) && (this.declinedPermissions.equals(paramObject.declinedPermissions)) && (this.token.equals(paramObject.token)) && (this.source == paramObject.source) && (this.lastRefresh.equals(paramObject.lastRefresh))) {
      if (this.applicationId == null)
      {
        if (paramObject.applicationId != null) {}
      }
      else {
        while (this.applicationId.equals(paramObject.applicationId))
        {
          if ((!this.userId.equals(paramObject.userId)) || (!this.dataAccessExpirationTime.equals(paramObject.dataAccessExpirationTime))) {
            break;
          }
          AppMethodBeat.o(16959);
          return true;
        }
      }
    }
    AppMethodBeat.o(16959);
    return false;
  }
  
  public final String getApplicationId()
  {
    return this.applicationId;
  }
  
  public final Date getDataAccessExpirationTime()
  {
    return this.dataAccessExpirationTime;
  }
  
  public final Set<String> getDeclinedPermissions()
  {
    return this.declinedPermissions;
  }
  
  public final Date getExpires()
  {
    return this.expires;
  }
  
  public final Date getLastRefresh()
  {
    return this.lastRefresh;
  }
  
  public final Set<String> getPermissions()
  {
    return this.permissions;
  }
  
  public final AccessTokenSource getSource()
  {
    return this.source;
  }
  
  public final String getToken()
  {
    return this.token;
  }
  
  public final String getUserId()
  {
    return this.userId;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(16960);
    int j = this.expires.hashCode();
    int k = this.permissions.hashCode();
    int m = this.declinedPermissions.hashCode();
    int n = this.token.hashCode();
    int i1 = this.source.hashCode();
    int i2 = this.lastRefresh.hashCode();
    if (this.applicationId == null) {}
    for (int i = 0;; i = this.applicationId.hashCode())
    {
      int i3 = this.userId.hashCode();
      int i4 = this.dataAccessExpirationTime.hashCode();
      AppMethodBeat.o(16960);
      return ((i + ((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + i3) * 31 + i4;
    }
  }
  
  public final boolean isDataAccessExpired()
  {
    AppMethodBeat.i(16966);
    boolean bool = new Date().after(this.dataAccessExpirationTime);
    AppMethodBeat.o(16966);
    return bool;
  }
  
  public final boolean isExpired()
  {
    AppMethodBeat.i(16965);
    boolean bool = new Date().after(this.expires);
    AppMethodBeat.o(16965);
    return bool;
  }
  
  final JSONObject toJSONObject()
  {
    AppMethodBeat.i(16967);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("version", 1);
    localJSONObject.put("token", this.token);
    localJSONObject.put("expires_at", this.expires.getTime());
    localJSONObject.put("permissions", new JSONArray(this.permissions));
    localJSONObject.put("declined_permissions", new JSONArray(this.declinedPermissions));
    localJSONObject.put("last_refresh", this.lastRefresh.getTime());
    localJSONObject.put("source", this.source.name());
    localJSONObject.put("application_id", this.applicationId);
    localJSONObject.put("user_id", this.userId);
    localJSONObject.put("data_access_expiration_time", this.dataAccessExpirationTime.getTime());
    AppMethodBeat.o(16967);
    return localJSONObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(16958);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{AccessToken");
    ((StringBuilder)localObject).append(" token:").append(tokenToString());
    appendPermissions((StringBuilder)localObject);
    ((StringBuilder)localObject).append("}");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(16958);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(16973);
    paramParcel.writeLong(this.expires.getTime());
    paramParcel.writeStringList(new ArrayList(this.permissions));
    paramParcel.writeStringList(new ArrayList(this.declinedPermissions));
    paramParcel.writeString(this.token);
    paramParcel.writeString(this.source.name());
    paramParcel.writeLong(this.lastRefresh.getTime());
    paramParcel.writeString(this.applicationId);
    paramParcel.writeString(this.userId);
    paramParcel.writeLong(this.dataAccessExpirationTime.getTime());
    AppMethodBeat.o(16973);
  }
  
  public static abstract interface AccessTokenCreationCallback
  {
    public abstract void onError(FacebookException paramFacebookException);
    
    public abstract void onSuccess(AccessToken paramAccessToken);
  }
  
  public static abstract interface AccessTokenRefreshCallback
  {
    public abstract void OnTokenRefreshFailed(FacebookException paramFacebookException);
    
    public abstract void OnTokenRefreshed(AccessToken paramAccessToken);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.AccessToken
 * JD-Core Version:    0.7.0.1
 */