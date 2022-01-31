package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbaj;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzg
{
  private final Set<Scope> zzaFA;
  private final Map<Api<?>, zzg.zza> zzaFB;
  private final zzbaj zzaFC;
  private Integer zzaFD;
  private final Account zzahh;
  private final String zzaiq;
  private final Set<Scope> zzazd;
  private final int zzazf;
  private final View zzazg;
  private final String zzazh;
  
  public zzg(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zzg.zza> paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzbaj paramzzbaj)
  {
    this.zzahh = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      this.zzazd = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      this.zzaFB = paramAccount;
      this.zzazg = paramView;
      this.zzazf = paramInt;
      this.zzaiq = paramString1;
      this.zzazh = paramString2;
      this.zzaFC = paramzzbaj;
      paramAccount = new HashSet(this.zzazd);
      paramSet = this.zzaFB.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(((zzg.zza)paramSet.next()).zzakq);
      }
    }
    this.zzaFA = Collections.unmodifiableSet(paramAccount);
  }
  
  public static zzg zzaS(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).zzvp();
  }
  
  public final Account getAccount()
  {
    return this.zzahh;
  }
  
  @Deprecated
  public final String getAccountName()
  {
    if (this.zzahh != null) {
      return this.zzahh.name;
    }
    return null;
  }
  
  public final Set<Scope> zzc(Api<?> paramApi)
  {
    paramApi = (zzg.zza)this.zzaFB.get(paramApi);
    if ((paramApi == null) || (paramApi.zzakq.isEmpty())) {
      return this.zzazd;
    }
    HashSet localHashSet = new HashSet(this.zzazd);
    localHashSet.addAll(paramApi.zzakq);
    return localHashSet;
  }
  
  public final void zzc(Integer paramInteger)
  {
    this.zzaFD = paramInteger;
  }
  
  public final Account zzxB()
  {
    if (this.zzahh != null) {
      return this.zzahh;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public final int zzxK()
  {
    return this.zzazf;
  }
  
  public final Set<Scope> zzxL()
  {
    return this.zzazd;
  }
  
  public final Set<Scope> zzxM()
  {
    return this.zzaFA;
  }
  
  public final Map<Api<?>, zzg.zza> zzxN()
  {
    return this.zzaFB;
  }
  
  public final String zzxO()
  {
    return this.zzaiq;
  }
  
  public final String zzxP()
  {
    return this.zzazh;
  }
  
  public final View zzxQ()
  {
    return this.zzazg;
  }
  
  public final zzbaj zzxR()
  {
    return this.zzaFC;
  }
  
  public final Integer zzxS()
  {
    return this.zzaFD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzg
 * JD-Core Version:    0.7.0.1
 */