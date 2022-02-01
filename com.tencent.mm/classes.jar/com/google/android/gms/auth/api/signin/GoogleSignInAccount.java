package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator="GoogleSignInAccountCreator")
public class GoogleSignInAccount
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR;
  @VisibleForTesting
  public static Clock sClock;
  @SafeParcelable.VersionField(id=1)
  private final int versionCode;
  @SafeParcelable.Field(getter="getId", id=2)
  private String zze;
  @SafeParcelable.Field(getter="getIdToken", id=3)
  private String zzf;
  @SafeParcelable.Field(getter="getEmail", id=4)
  private String zzg;
  @SafeParcelable.Field(getter="getDisplayName", id=5)
  private String zzh;
  @SafeParcelable.Field(getter="getPhotoUrl", id=6)
  private Uri zzi;
  @SafeParcelable.Field(getter="getServerAuthCode", id=7)
  private String zzj;
  @SafeParcelable.Field(getter="getExpirationTimeSecs", id=8)
  private long zzk;
  @SafeParcelable.Field(getter="getObfuscatedIdentifier", id=9)
  private String zzl;
  @SafeParcelable.Field(id=10)
  private List<Scope> zzm;
  @SafeParcelable.Field(getter="getGivenName", id=11)
  private String zzn;
  @SafeParcelable.Field(getter="getFamilyName", id=12)
  private String zzo;
  private Set<Scope> zzp;
  
  static
  {
    AppMethodBeat.i(10837);
    CREATOR = new GoogleSignInAccountCreator();
    sClock = DefaultClock.getInstance();
    AppMethodBeat.o(10837);
  }
  
  @SafeParcelable.Constructor
  GoogleSignInAccount(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3, @SafeParcelable.Param(id=5) String paramString4, @SafeParcelable.Param(id=6) Uri paramUri, @SafeParcelable.Param(id=7) String paramString5, @SafeParcelable.Param(id=8) long paramLong, @SafeParcelable.Param(id=9) String paramString6, @SafeParcelable.Param(id=10) List<Scope> paramList, @SafeParcelable.Param(id=11) String paramString7, @SafeParcelable.Param(id=12) String paramString8)
  {
    AppMethodBeat.i(10824);
    this.zzp = new HashSet();
    this.versionCode = paramInt;
    this.zze = paramString1;
    this.zzf = paramString2;
    this.zzg = paramString3;
    this.zzh = paramString4;
    this.zzi = paramUri;
    this.zzj = paramString5;
    this.zzk = paramLong;
    this.zzl = paramString6;
    this.zzm = paramList;
    this.zzn = paramString7;
    this.zzo = paramString8;
    AppMethodBeat.o(10824);
  }
  
  public static GoogleSignInAccount create(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, Long paramLong, String paramString5, Set<Scope> paramSet)
  {
    AppMethodBeat.i(10820);
    paramString1 = create(paramString1, paramString2, paramString3, paramString4, null, null, paramUri, paramLong, paramString5, paramSet);
    AppMethodBeat.o(10820);
    return paramString1;
  }
  
  public static GoogleSignInAccount create(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri, Long paramLong, String paramString7, Set<Scope> paramSet)
  {
    AppMethodBeat.i(10819);
    Long localLong = paramLong;
    if (paramLong == null) {
      localLong = Long.valueOf(sClock.currentTimeMillis() / 1000L);
    }
    paramString1 = new GoogleSignInAccount(3, paramString1, paramString2, paramString3, paramString4, paramUri, null, localLong.longValue(), Preconditions.checkNotEmpty(paramString7), new ArrayList((Collection)Preconditions.checkNotNull(paramSet)), paramString5, paramString6);
    AppMethodBeat.o(10819);
    return paramString1;
  }
  
  public static GoogleSignInAccount createDefault()
  {
    AppMethodBeat.i(10822);
    GoogleSignInAccount localGoogleSignInAccount = zza(new Account("<<default account>>", "com.google"), new HashSet());
    AppMethodBeat.o(10822);
    return localGoogleSignInAccount;
  }
  
  public static GoogleSignInAccount fromAccountAndScopes(Account paramAccount, Scope paramScope, Scope... paramVarArgs)
  {
    AppMethodBeat.i(10821);
    Preconditions.checkNotNull(paramAccount);
    Preconditions.checkNotNull(paramScope);
    HashSet localHashSet = new HashSet();
    localHashSet.add(paramScope);
    localHashSet.addAll(Arrays.asList(paramVarArgs));
    paramAccount = zza(paramAccount, localHashSet);
    AppMethodBeat.o(10821);
    return paramAccount;
  }
  
  public static GoogleSignInAccount fromJsonString(String paramString)
  {
    AppMethodBeat.i(10818);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(10818);
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = Uri.parse(paramString);; paramString = null)
    {
      long l = Long.parseLong(localJSONObject.getString("expirationTime"));
      HashSet localHashSet = new HashSet();
      JSONArray localJSONArray = localJSONObject.getJSONArray("grantedScopes");
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        localHashSet.add(new Scope(localJSONArray.getString(i)));
        i += 1;
      }
      paramString = create(localJSONObject.optString("id"), localJSONObject.optString("tokenId", null), localJSONObject.optString("email", null), localJSONObject.optString("displayName", null), localJSONObject.optString("givenName", null), localJSONObject.optString("familyName", null), paramString, Long.valueOf(l), localJSONObject.getString("obfuscatedIdentifier"), localHashSet).setServerAuthCode(localJSONObject.optString("serverAuthCode", null));
      AppMethodBeat.o(10818);
      return paramString;
    }
  }
  
  private static GoogleSignInAccount zza(Account paramAccount, Set<Scope> paramSet)
  {
    AppMethodBeat.i(10823);
    paramAccount = create(null, null, paramAccount.name, null, null, null, null, Long.valueOf(0L), paramAccount.name, paramSet);
    AppMethodBeat.o(10823);
    return paramAccount;
  }
  
  private final JSONObject zza()
  {
    AppMethodBeat.i(10835);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (getId() != null) {
        localJSONObject.put("id", getId());
      }
      if (getIdToken() != null) {
        localJSONObject.put("tokenId", getIdToken());
      }
      if (getEmail() != null) {
        localJSONObject.put("email", getEmail());
      }
      if (getDisplayName() != null) {
        localJSONObject.put("displayName", getDisplayName());
      }
      if (getGivenName() != null) {
        localJSONObject.put("givenName", getGivenName());
      }
      if (getFamilyName() != null) {
        localJSONObject.put("familyName", getFamilyName());
      }
      if (getPhotoUrl() != null) {
        localJSONObject.put("photoUrl", getPhotoUrl().toString());
      }
      if (getServerAuthCode() != null) {
        localJSONObject.put("serverAuthCode", getServerAuthCode());
      }
      localJSONObject.put("expirationTime", this.zzk);
      localJSONObject.put("obfuscatedIdentifier", getObfuscatedIdentifier());
      JSONArray localJSONArray = new JSONArray();
      Scope[] arrayOfScope = (Scope[])this.zzm.toArray(new Scope[this.zzm.size()]);
      Arrays.sort(arrayOfScope, zza.zzq);
      int j = arrayOfScope.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(arrayOfScope[i].getScopeUri());
        i += 1;
      }
      localJSONObject.put("grantedScopes", localJSONArray);
      AppMethodBeat.o(10835);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      RuntimeException localRuntimeException = new RuntimeException(localJSONException);
      AppMethodBeat.o(10835);
      throw localRuntimeException;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(10832);
    if (paramObject == this)
    {
      AppMethodBeat.o(10832);
      return true;
    }
    if (!(paramObject instanceof GoogleSignInAccount))
    {
      AppMethodBeat.o(10832);
      return false;
    }
    paramObject = (GoogleSignInAccount)paramObject;
    if ((paramObject.getObfuscatedIdentifier().equals(getObfuscatedIdentifier())) && (paramObject.getRequestedScopes().equals(getRequestedScopes())))
    {
      AppMethodBeat.o(10832);
      return true;
    }
    AppMethodBeat.o(10832);
    return false;
  }
  
  public Account getAccount()
  {
    AppMethodBeat.i(10825);
    if (this.zzg == null)
    {
      AppMethodBeat.o(10825);
      return null;
    }
    Account localAccount = new Account(this.zzg, "com.google");
    AppMethodBeat.o(10825);
    return localAccount;
  }
  
  public String getDisplayName()
  {
    return this.zzh;
  }
  
  public String getEmail()
  {
    return this.zzg;
  }
  
  public long getExpirationTimeSecs()
  {
    return this.zzk;
  }
  
  public String getFamilyName()
  {
    return this.zzo;
  }
  
  public String getGivenName()
  {
    return this.zzn;
  }
  
  public Set<Scope> getGrantedScopes()
  {
    AppMethodBeat.i(10828);
    HashSet localHashSet = new HashSet(this.zzm);
    AppMethodBeat.o(10828);
    return localHashSet;
  }
  
  public String getId()
  {
    return this.zze;
  }
  
  public String getIdToken()
  {
    return this.zzf;
  }
  
  public String getObfuscatedIdentifier()
  {
    return this.zzl;
  }
  
  public Uri getPhotoUrl()
  {
    return this.zzi;
  }
  
  public Set<Scope> getRequestedScopes()
  {
    AppMethodBeat.i(10829);
    HashSet localHashSet = new HashSet(this.zzm);
    localHashSet.addAll(this.zzp);
    AppMethodBeat.o(10829);
    return localHashSet;
  }
  
  public String getServerAuthCode()
  {
    return this.zzj;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(10831);
    int i = getObfuscatedIdentifier().hashCode();
    int j = getRequestedScopes().hashCode();
    AppMethodBeat.o(10831);
    return (i + 527) * 31 + j;
  }
  
  public boolean isExpired()
  {
    AppMethodBeat.i(10827);
    if (sClock.currentTimeMillis() / 1000L >= this.zzk - 300L)
    {
      AppMethodBeat.o(10827);
      return true;
    }
    AppMethodBeat.o(10827);
    return false;
  }
  
  public GoogleSignInAccount requestExtraScopes(Scope... paramVarArgs)
  {
    AppMethodBeat.i(10826);
    if (paramVarArgs != null) {
      Collections.addAll(this.zzp, paramVarArgs);
    }
    AppMethodBeat.o(10826);
    return this;
  }
  
  public GoogleSignInAccount setServerAuthCode(String paramString)
  {
    this.zzj = paramString;
    return this;
  }
  
  public String toJson()
  {
    AppMethodBeat.i(10833);
    String str = zza().toString();
    AppMethodBeat.o(10833);
    return str;
  }
  
  public String toJsonForStorage()
  {
    AppMethodBeat.i(10834);
    Object localObject = zza();
    ((JSONObject)localObject).remove("serverAuthCode");
    localObject = ((JSONObject)localObject).toString();
    AppMethodBeat.o(10834);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10830);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getIdToken(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getEmail(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getDisplayName(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, getPhotoUrl(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 7, getServerAuthCode(), false);
    SafeParcelWriter.writeLong(paramParcel, 8, getExpirationTimeSecs());
    SafeParcelWriter.writeString(paramParcel, 9, getObfuscatedIdentifier(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 10, this.zzm, false);
    SafeParcelWriter.writeString(paramParcel, 11, getGivenName(), false);
    SafeParcelWriter.writeString(paramParcel, 12, getFamilyName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(10830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInAccount
 * JD-Core Version:    0.7.0.1
 */