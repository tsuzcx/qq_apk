package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
  extends AbstractSafeParcelable
  implements Api.ApiOptions.Optional, ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;
  public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  public static final Scope SCOPE_EMAIL;
  public static final Scope SCOPE_GAMES;
  public static final Scope SCOPE_GAMES_LITE;
  public static final Scope SCOPE_OPEN_ID;
  public static final Scope SCOPE_PROFILE;
  private static Comparator<Scope> zzaa;
  private final int versionCode;
  private final ArrayList<Scope> zzr;
  private Account zzs;
  private boolean zzt;
  private final boolean zzu;
  private final boolean zzv;
  private String zzw;
  private String zzx;
  private ArrayList<GoogleSignInOptionsExtensionParcelable> zzy;
  private Map<Integer, GoogleSignInOptionsExtensionParcelable> zzz;
  
  static
  {
    AppMethodBeat.i(10871);
    SCOPE_PROFILE = new Scope("profile");
    SCOPE_EMAIL = new Scope("email");
    SCOPE_OPEN_ID = new Scope("openid");
    SCOPE_GAMES_LITE = new Scope("https://www.googleapis.com/auth/games_lite");
    SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
    DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(SCOPE_GAMES_LITE, new Scope[0]).build();
    CREATOR = new GoogleSignInOptionsCreator();
    zzaa = new zzb();
    AppMethodBeat.o(10871);
  }
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, ArrayList<GoogleSignInOptionsExtensionParcelable> paramArrayList1)
  {
    this(paramInt, paramArrayList, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2, zza(paramArrayList1));
    AppMethodBeat.i(10858);
    AppMethodBeat.o(10858);
  }
  
  private GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, Map<Integer, GoogleSignInOptionsExtensionParcelable> paramMap)
  {
    AppMethodBeat.i(10859);
    this.versionCode = paramInt;
    this.zzr = paramArrayList;
    this.zzs = paramAccount;
    this.zzt = paramBoolean1;
    this.zzu = paramBoolean2;
    this.zzv = paramBoolean3;
    this.zzw = paramString1;
    this.zzx = paramString2;
    this.zzy = new ArrayList(paramMap.values());
    this.zzz = paramMap;
    AppMethodBeat.o(10859);
  }
  
  public static GoogleSignInOptions fromJsonString(String paramString)
  {
    AppMethodBeat.i(10857);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(10857);
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    HashSet localHashSet = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new Scope(paramString.getString(i)));
      i += 1;
    }
    paramString = localJSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = new Account(paramString, "com.google");; paramString = null)
    {
      paramString = new GoogleSignInOptions(3, new ArrayList(localHashSet), paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), localJSONObject.optString("serverClientId", null), localJSONObject.optString("hostedDomain", null), new HashMap());
      AppMethodBeat.o(10857);
      return paramString;
    }
  }
  
  private static Map<Integer, GoogleSignInOptionsExtensionParcelable> zza(List<GoogleSignInOptionsExtensionParcelable> paramList)
  {
    AppMethodBeat.i(10864);
    HashMap localHashMap = new HashMap();
    if (paramList == null)
    {
      AppMethodBeat.o(10864);
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GoogleSignInOptionsExtensionParcelable localGoogleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable)paramList.next();
      localHashMap.put(Integer.valueOf(localGoogleSignInOptionsExtensionParcelable.getType()), localGoogleSignInOptionsExtensionParcelable);
    }
    AppMethodBeat.o(10864);
    return localHashMap;
  }
  
  private final JSONObject zza()
  {
    AppMethodBeat.i(10869);
    JSONObject localJSONObject = new JSONObject();
    RuntimeException localRuntimeException;
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(this.zzr, zzaa);
      ArrayList localArrayList = (ArrayList)this.zzr;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = localArrayList.get(i);
        i += 1;
        localJSONArray.put(((Scope)localObject).getScopeUri());
      }
      localRuntimeException.put("scopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      localRuntimeException = new RuntimeException(localJSONException);
      AppMethodBeat.o(10869);
      throw localRuntimeException;
    }
    if (this.zzs != null) {
      localRuntimeException.put("accountName", this.zzs.name);
    }
    localRuntimeException.put("idTokenRequested", this.zzt);
    localRuntimeException.put("forceCodeForRefreshToken", this.zzv);
    localRuntimeException.put("serverAuthRequested", this.zzu);
    if (!TextUtils.isEmpty(this.zzw)) {
      localRuntimeException.put("serverClientId", this.zzw);
    }
    if (!TextUtils.isEmpty(this.zzx)) {
      localRuntimeException.put("hostedDomain", this.zzx);
    }
    AppMethodBeat.o(10869);
    return localRuntimeException;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(10866);
    if (paramObject == null)
    {
      AppMethodBeat.o(10866);
      return false;
    }
    try
    {
      paramObject = (GoogleSignInOptions)paramObject;
      if (this.zzy.size() <= 0)
      {
        int i = paramObject.zzy.size();
        if (i <= 0) {}
      }
      else
      {
        AppMethodBeat.o(10866);
        return false;
      }
      boolean bool;
      if (this.zzr.size() == paramObject.getScopes().size())
      {
        bool = this.zzr.containsAll(paramObject.getScopes());
        if (bool) {}
      }
      else
      {
        AppMethodBeat.o(10866);
        return false;
      }
      if (this.zzs == null)
      {
        if (paramObject.getAccount() != null) {
          break label185;
        }
        if (!TextUtils.isEmpty(this.zzw)) {
          break label193;
        }
        if (!TextUtils.isEmpty(paramObject.getServerClientId())) {
          break label185;
        }
      }
      for (;;)
      {
        if ((this.zzv == paramObject.isForceCodeForRefreshToken()) && (this.zzt == paramObject.isIdTokenRequested()) && (this.zzu == paramObject.isServerAuthCodeRequested()))
        {
          AppMethodBeat.o(10866);
          return true;
          bool = this.zzs.equals(paramObject.getAccount());
          if (bool) {
            break;
          }
        }
        label185:
        label193:
        do
        {
          AppMethodBeat.o(10866);
          return false;
          bool = this.zzw.equals(paramObject.getServerClientId());
        } while (!bool);
      }
      return false;
    }
    catch (ClassCastException paramObject)
    {
      AppMethodBeat.o(10866);
    }
  }
  
  public Account getAccount()
  {
    return this.zzs;
  }
  
  public GoogleSignInOptionsExtensionParcelable getExtension(int paramInt)
  {
    AppMethodBeat.i(10863);
    GoogleSignInOptionsExtensionParcelable localGoogleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable)this.zzz.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(10863);
    return localGoogleSignInOptionsExtensionParcelable;
  }
  
  public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions()
  {
    return this.zzy;
  }
  
  public String getHostedDomain()
  {
    return this.zzx;
  }
  
  public Scope[] getScopeArray()
  {
    AppMethodBeat.i(10861);
    Scope[] arrayOfScope = (Scope[])this.zzr.toArray(new Scope[this.zzr.size()]);
    AppMethodBeat.o(10861);
    return arrayOfScope;
  }
  
  public ArrayList<Scope> getScopes()
  {
    AppMethodBeat.i(10860);
    ArrayList localArrayList = new ArrayList(this.zzr);
    AppMethodBeat.o(10860);
    return localArrayList;
  }
  
  public String getServerClientId()
  {
    return this.zzw;
  }
  
  public boolean hasExtension(int paramInt)
  {
    AppMethodBeat.i(10862);
    boolean bool = this.zzz.containsKey(Integer.valueOf(paramInt));
    AppMethodBeat.o(10862);
    return bool;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(10867);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = (ArrayList)this.zzr;
    int j = localArrayList2.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = localArrayList2.get(i);
      i += 1;
      localArrayList1.add(((Scope)localObject).getScopeUri());
    }
    Collections.sort(localArrayList1);
    i = new HashAccumulator().addObject(localArrayList1).addObject(this.zzs).addObject(this.zzw).addBoolean(this.zzv).addBoolean(this.zzt).addBoolean(this.zzu).hash();
    AppMethodBeat.o(10867);
    return i;
  }
  
  public boolean isForceCodeForRefreshToken()
  {
    return this.zzv;
  }
  
  public boolean isIdTokenRequested()
  {
    return this.zzt;
  }
  
  public boolean isServerAuthCodeRequested()
  {
    return this.zzu;
  }
  
  public String toJson()
  {
    AppMethodBeat.i(10868);
    String str = zza().toString();
    AppMethodBeat.o(10868);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(10865);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getScopes(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getAccount(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, isIdTokenRequested());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isServerAuthCodeRequested());
    SafeParcelWriter.writeBoolean(paramParcel, 6, isForceCodeForRefreshToken());
    SafeParcelWriter.writeString(paramParcel, 7, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 8, getHostedDomain(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 9, getExtensions(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    AppMethodBeat.o(10865);
  }
  
  public static final class Builder
  {
    private Set<Scope> mScopes;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zzab;
    private Account zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private String zzw;
    private String zzx;
    
    public Builder()
    {
      AppMethodBeat.i(10841);
      this.mScopes = new HashSet();
      this.zzab = new HashMap();
      AppMethodBeat.o(10841);
    }
    
    public Builder(GoogleSignInOptions paramGoogleSignInOptions)
    {
      AppMethodBeat.i(10842);
      this.mScopes = new HashSet();
      this.zzab = new HashMap();
      Preconditions.checkNotNull(paramGoogleSignInOptions);
      this.mScopes = new HashSet(GoogleSignInOptions.zza(paramGoogleSignInOptions));
      this.zzu = GoogleSignInOptions.zzb(paramGoogleSignInOptions);
      this.zzv = GoogleSignInOptions.zzc(paramGoogleSignInOptions);
      this.zzt = GoogleSignInOptions.zzd(paramGoogleSignInOptions);
      this.zzw = GoogleSignInOptions.zze(paramGoogleSignInOptions);
      this.zzs = GoogleSignInOptions.zzf(paramGoogleSignInOptions);
      this.zzx = GoogleSignInOptions.zzg(paramGoogleSignInOptions);
      this.zzab = GoogleSignInOptions.zzb(GoogleSignInOptions.zzh(paramGoogleSignInOptions));
      AppMethodBeat.o(10842);
    }
    
    private final String zza(String paramString)
    {
      AppMethodBeat.i(10856);
      Preconditions.checkNotEmpty(paramString);
      if ((this.zzw == null) || (this.zzw.equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "two different server client ids provided");
        AppMethodBeat.o(10856);
        return paramString;
      }
    }
    
    public final Builder addExtension(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
    {
      AppMethodBeat.i(10854);
      if (this.zzab.containsKey(Integer.valueOf(paramGoogleSignInOptionsExtension.getExtensionType())))
      {
        paramGoogleSignInOptionsExtension = new IllegalStateException("Only one extension per type may be added");
        AppMethodBeat.o(10854);
        throw paramGoogleSignInOptionsExtension;
      }
      if (paramGoogleSignInOptionsExtension.getImpliedScopes() != null) {
        this.mScopes.addAll(paramGoogleSignInOptionsExtension.getImpliedScopes());
      }
      this.zzab.put(Integer.valueOf(paramGoogleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(paramGoogleSignInOptionsExtension));
      AppMethodBeat.o(10854);
      return this;
    }
    
    public final GoogleSignInOptions build()
    {
      AppMethodBeat.i(10855);
      if ((this.mScopes.contains(GoogleSignInOptions.SCOPE_GAMES)) && (this.mScopes.contains(GoogleSignInOptions.SCOPE_GAMES_LITE))) {
        this.mScopes.remove(GoogleSignInOptions.SCOPE_GAMES_LITE);
      }
      if ((this.zzt) && ((this.zzs == null) || (!this.mScopes.isEmpty()))) {
        requestId();
      }
      GoogleSignInOptions localGoogleSignInOptions = new GoogleSignInOptions(3, new ArrayList(this.mScopes), this.zzs, this.zzt, this.zzu, this.zzv, this.zzw, this.zzx, this.zzab, null);
      AppMethodBeat.o(10855);
      return localGoogleSignInOptions;
    }
    
    public final Builder requestEmail()
    {
      AppMethodBeat.i(10844);
      this.mScopes.add(GoogleSignInOptions.SCOPE_EMAIL);
      AppMethodBeat.o(10844);
      return this;
    }
    
    public final Builder requestId()
    {
      AppMethodBeat.i(10843);
      this.mScopes.add(GoogleSignInOptions.SCOPE_OPEN_ID);
      AppMethodBeat.o(10843);
      return this;
    }
    
    public final Builder requestIdToken(String paramString)
    {
      AppMethodBeat.i(10847);
      this.zzt = true;
      this.zzw = zza(paramString);
      AppMethodBeat.o(10847);
      return this;
    }
    
    public final Builder requestPhatIdToken(String paramString)
    {
      AppMethodBeat.i(10848);
      paramString = requestIdToken(paramString).requestProfile().requestEmail();
      AppMethodBeat.o(10848);
      return paramString;
    }
    
    public final Builder requestProfile()
    {
      AppMethodBeat.i(10845);
      this.mScopes.add(GoogleSignInOptions.SCOPE_PROFILE);
      AppMethodBeat.o(10845);
      return this;
    }
    
    public final Builder requestScopes(Scope paramScope, Scope... paramVarArgs)
    {
      AppMethodBeat.i(10846);
      this.mScopes.add(paramScope);
      this.mScopes.addAll(Arrays.asList(paramVarArgs));
      AppMethodBeat.o(10846);
      return this;
    }
    
    public final Builder requestServerAuthCode(String paramString)
    {
      AppMethodBeat.i(10849);
      paramString = requestServerAuthCode(paramString, false);
      AppMethodBeat.o(10849);
      return paramString;
    }
    
    public final Builder requestServerAuthCode(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(10850);
      this.zzu = true;
      this.zzw = zza(paramString);
      this.zzv = paramBoolean;
      AppMethodBeat.o(10850);
      return this;
    }
    
    public final Builder setAccount(Account paramAccount)
    {
      AppMethodBeat.i(10852);
      this.zzs = ((Account)Preconditions.checkNotNull(paramAccount));
      AppMethodBeat.o(10852);
      return this;
    }
    
    public final Builder setAccountName(String paramString)
    {
      AppMethodBeat.i(10851);
      this.zzs = new Account(Preconditions.checkNotEmpty(paramString), "com.google");
      AppMethodBeat.o(10851);
      return this;
    }
    
    public final Builder setHostedDomain(String paramString)
    {
      AppMethodBeat.i(10853);
      this.zzx = Preconditions.checkNotEmpty(paramString);
      AppMethodBeat.o(10853);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInOptions
 * JD-Core Version:    0.7.0.1
 */