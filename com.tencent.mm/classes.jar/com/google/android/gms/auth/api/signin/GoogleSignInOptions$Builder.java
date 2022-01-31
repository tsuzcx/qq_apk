package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class GoogleSignInOptions$Builder
{
  private Account zzahh;
  private boolean zzajv;
  private String zzajw;
  private boolean zzakl;
  private boolean zzakm;
  private String zzakn;
  private Set<Scope> zzakq = new HashSet();
  private Map<Integer, zzg> zzakr = new HashMap();
  
  public GoogleSignInOptions$Builder() {}
  
  public GoogleSignInOptions$Builder(GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzac.zzw(paramGoogleSignInOptions);
    this.zzakq = new HashSet(GoogleSignInOptions.zzb(paramGoogleSignInOptions));
    this.zzakl = GoogleSignInOptions.zzc(paramGoogleSignInOptions);
    this.zzakm = GoogleSignInOptions.zzd(paramGoogleSignInOptions);
    this.zzajv = GoogleSignInOptions.zze(paramGoogleSignInOptions);
    this.zzajw = GoogleSignInOptions.zzf(paramGoogleSignInOptions);
    this.zzahh = GoogleSignInOptions.zzg(paramGoogleSignInOptions);
    this.zzakn = GoogleSignInOptions.zzh(paramGoogleSignInOptions);
    this.zzakr = GoogleSignInOptions.zzy(GoogleSignInOptions.zzi(paramGoogleSignInOptions));
  }
  
  private String zzcy(String paramString)
  {
    zzac.zzdr(paramString);
    if ((this.zzajw == null) || (this.zzajw.equals(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      zzac.zzb(bool, "two different server client ids provided");
      return paramString;
    }
  }
  
  public final Builder addExtension(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    if (this.zzakr.containsKey(Integer.valueOf(1))) {
      throw new IllegalStateException("Only one extension per type may be added");
    }
    this.zzakr.put(Integer.valueOf(1), new zzg(paramGoogleSignInOptionsExtension));
    return this;
  }
  
  public final GoogleSignInOptions build()
  {
    if ((this.zzajv) && ((this.zzahh == null) || (!this.zzakq.isEmpty()))) {
      requestId();
    }
    return new GoogleSignInOptions(3, new ArrayList(this.zzakq), this.zzahh, this.zzajv, this.zzakl, this.zzakm, this.zzajw, this.zzakn, this.zzakr, null);
  }
  
  public final Builder requestEmail()
  {
    this.zzakq.add(GoogleSignInOptions.zzaki);
    return this;
  }
  
  public final Builder requestId()
  {
    this.zzakq.add(GoogleSignInOptions.zzakj);
    return this;
  }
  
  public final Builder requestIdToken(String paramString)
  {
    this.zzajv = true;
    this.zzajw = zzcy(paramString);
    return this;
  }
  
  public final Builder requestProfile()
  {
    this.zzakq.add(GoogleSignInOptions.zzakh);
    return this;
  }
  
  public final Builder requestScopes(Scope paramScope, Scope... paramVarArgs)
  {
    this.zzakq.add(paramScope);
    this.zzakq.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public final Builder requestServerAuthCode(String paramString)
  {
    return requestServerAuthCode(paramString, false);
  }
  
  public final Builder requestServerAuthCode(String paramString, boolean paramBoolean)
  {
    this.zzakl = true;
    this.zzajw = zzcy(paramString);
    this.zzakm = paramBoolean;
    return this;
  }
  
  public final Builder setAccountName(String paramString)
  {
    this.zzahh = new Account(zzac.zzdr(paramString), "com.google");
    return this;
  }
  
  public final Builder setHostedDomain(String paramString)
  {
    this.zzakn = zzac.zzdr(paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder
 * JD-Core Version:    0.7.0.1
 */