package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;
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
  extends zza
  implements Api.ApiOptions.Optional, ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzb();
  public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  public static final Scope SCOPE_GAMES;
  private static Comparator<Scope> zzakg = new GoogleSignInOptions.1();
  public static final Scope zzakh = new Scope("profile");
  public static final Scope zzaki = new Scope("email");
  public static final Scope zzakj = new Scope("openid");
  final int versionCode;
  private Account zzahh;
  private boolean zzajv;
  private String zzajw;
  private final ArrayList<Scope> zzakk;
  private final boolean zzakl;
  private final boolean zzakm;
  private String zzakn;
  private ArrayList<zzg> zzako;
  private Map<Integer, zzg> zzakp;
  
  static
  {
    SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
    DEFAULT_SIGN_IN = new GoogleSignInOptions.Builder().requestId().requestProfile().build();
    DEFAULT_GAMES_SIGN_IN = new GoogleSignInOptions.Builder().requestScopes(SCOPE_GAMES, new Scope[0]).build();
  }
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, ArrayList<zzg> paramArrayList1)
  {
    this(paramInt, paramArrayList, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2, zzx(paramArrayList1));
  }
  
  private GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, Map<Integer, zzg> paramMap)
  {
    this.versionCode = paramInt;
    this.zzakk = paramArrayList;
    this.zzahh = paramAccount;
    this.zzajv = paramBoolean1;
    this.zzakl = paramBoolean2;
    this.zzakm = paramBoolean3;
    this.zzajw = paramString1;
    this.zzakn = paramString2;
    this.zzako = new ArrayList(paramMap.values());
    this.zzakp = paramMap;
  }
  
  public static GoogleSignInOptions zzcx(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
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
    for (paramString = new Account(paramString, "com.google");; paramString = null) {
      return new GoogleSignInOptions(3, new ArrayList(localHashSet), paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), localJSONObject.optString("serverClientId", null), localJSONObject.optString("hostedDomain", null), new HashMap());
    }
  }
  
  private JSONObject zzri()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(this.zzakk, zzakg);
      Iterator localIterator = this.zzakk.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Scope)localIterator.next()).zzvt());
      }
      localJSONException.put("scopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    if (this.zzahh != null) {
      localJSONException.put("accountName", this.zzahh.name);
    }
    localJSONException.put("idTokenRequested", this.zzajv);
    localJSONException.put("forceCodeForRefreshToken", this.zzakm);
    localJSONException.put("serverAuthRequested", this.zzakl);
    if (!TextUtils.isEmpty(this.zzajw)) {
      localJSONException.put("serverClientId", this.zzajw);
    }
    if (!TextUtils.isEmpty(this.zzakn)) {
      localJSONException.put("hostedDomain", this.zzakn);
    }
    return localJSONException;
  }
  
  private static Map<Integer, zzg> zzx(List<zzg> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzg localzzg = (zzg)paramList.next();
      localHashMap.put(Integer.valueOf(localzzg.getType()), localzzg);
    }
    return localHashMap;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (GoogleSignInOptions)paramObject;
        if ((this.zzako.size() > 0) || (paramObject.zzako.size() > 0) || (this.zzakk.size() != paramObject.zzrj().size()) || (!this.zzakk.containsAll(paramObject.zzrj()))) {
          continue;
        }
        if (this.zzahh == null)
        {
          if (paramObject.getAccount() != null) {
            continue;
          }
          label76:
          if (!TextUtils.isEmpty(this.zzajw)) {
            break label148;
          }
          if (!TextUtils.isEmpty(paramObject.getServerClientId())) {
            continue;
          }
        }
        while ((this.zzakm == paramObject.zzrl()) && (this.zzajv == paramObject.isIdTokenRequested()) && (this.zzakl == paramObject.zzrk()))
        {
          return true;
          if (!this.zzahh.equals(paramObject.getAccount())) {
            break;
          }
          break label76;
          label148:
          boolean bool = this.zzajw.equals(paramObject.getServerClientId());
          if (!bool) {
            break;
          }
        }
        return false;
      }
      catch (ClassCastException paramObject) {}
    }
  }
  
  public Account getAccount()
  {
    return this.zzahh;
  }
  
  public Scope[] getScopeArray()
  {
    return (Scope[])this.zzakk.toArray(new Scope[this.zzakk.size()]);
  }
  
  public String getServerClientId()
  {
    return this.zzajw;
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzakk.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Scope)localIterator.next()).zzvt());
    }
    Collections.sort(localArrayList);
    return new zzh().zzq(localArrayList).zzq(this.zzahh).zzq(this.zzajw).zzae(this.zzakm).zzae(this.zzajv).zzae(this.zzakl).zzru();
  }
  
  public boolean isIdTokenRequested()
  {
    return this.zzajv;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzrg()
  {
    return zzri().toString();
  }
  
  public ArrayList<Scope> zzrj()
  {
    return new ArrayList(this.zzakk);
  }
  
  public boolean zzrk()
  {
    return this.zzakl;
  }
  
  public boolean zzrl()
  {
    return this.zzakm;
  }
  
  public String zzrm()
  {
    return this.zzakn;
  }
  
  public ArrayList<zzg> zzrn()
  {
    return this.zzako;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInOptions
 * JD-Core Version:    0.7.0.1
 */