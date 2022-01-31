package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import java.util.UUID;

public class zztg
  extends zzsa
{
  private SharedPreferences zzagD;
  private long zzagE;
  private long zzagF = -1L;
  private final zza zzagG = new zza("monitoring", zznT().zzpz(), null);
  
  protected zztg(zzsc paramzzsc)
  {
    super(paramzzsc);
  }
  
  public void zzcb(String paramString)
  {
    zzmR();
    zzob();
    SharedPreferences.Editor localEditor = this.zzagD.edit();
    if (TextUtils.isEmpty(paramString)) {
      localEditor.remove("installation_campaign");
    }
    for (;;)
    {
      if (!localEditor.commit()) {
        zzbS("Failed to commit campaign data");
      }
      return;
      localEditor.putString("installation_campaign", paramString);
    }
  }
  
  protected void zzmS()
  {
    this.zzagD = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
  }
  
  public long zzqe()
  {
    zzmR();
    zzob();
    long l;
    if (this.zzagE == 0L)
    {
      l = this.zzagD.getLong("first_run", 0L);
      if (l == 0L) {
        break label46;
      }
    }
    for (this.zzagE = l;; this.zzagE = l)
    {
      return this.zzagE;
      label46:
      l = zznR().currentTimeMillis();
      SharedPreferences.Editor localEditor = this.zzagD.edit();
      localEditor.putLong("first_run", l);
      if (!localEditor.commit()) {
        zzbS("Failed to commit first run time");
      }
    }
  }
  
  public zztj zzqf()
  {
    return new zztj(zznR(), zzqe());
  }
  
  public long zzqg()
  {
    zzmR();
    zzob();
    if (this.zzagF == -1L) {
      this.zzagF = this.zzagD.getLong("last_dispatch", 0L);
    }
    return this.zzagF;
  }
  
  public void zzqh()
  {
    zzmR();
    zzob();
    long l = zznR().currentTimeMillis();
    SharedPreferences.Editor localEditor = this.zzagD.edit();
    localEditor.putLong("last_dispatch", l);
    localEditor.apply();
    this.zzagF = l;
  }
  
  public String zzqi()
  {
    zzmR();
    zzob();
    String str = this.zzagD.getString("installation_campaign", null);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str;
  }
  
  public zza zzqj()
  {
    return this.zzagG;
  }
  
  public final class zza
  {
    private final String mName;
    private final long zzagH;
    
    private zza(String paramString, long paramLong)
    {
      zzac.zzdr(paramString);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzac.zzax(bool);
        this.mName = paramString;
        this.zzagH = paramLong;
        return;
      }
    }
    
    private void zzqk()
    {
      long l = zztg.this.zznR().currentTimeMillis();
      SharedPreferences.Editor localEditor = zztg.zza(zztg.this).edit();
      localEditor.remove(zzqp());
      localEditor.remove(zzqq());
      localEditor.putLong(zzqo(), l);
      localEditor.commit();
    }
    
    private long zzql()
    {
      long l = zzqn();
      if (l == 0L) {
        return 0L;
      }
      return Math.abs(l - zztg.this.zznR().currentTimeMillis());
    }
    
    private long zzqn()
    {
      return zztg.zza(zztg.this).getLong(zzqo(), 0L);
    }
    
    private String zzqo()
    {
      return String.valueOf(this.mName).concat(":start");
    }
    
    private String zzqp()
    {
      return String.valueOf(this.mName).concat(":count");
    }
    
    public final void zzcc(String paramString)
    {
      if (zzqn() == 0L) {
        zzqk();
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      for (;;)
      {
        try
        {
          long l = zztg.zza(zztg.this).getLong(zzqp(), 0L);
          if (l <= 0L)
          {
            paramString = zztg.zza(zztg.this).edit();
            paramString.putString(zzqq(), str);
            paramString.putLong(zzqp(), 1L);
            paramString.apply();
            return;
          }
          if ((UUID.randomUUID().getLeastSignificantBits() & 0xFFFFFFFF) < 9223372036854775807L / (l + 1L))
          {
            i = 1;
            paramString = zztg.zza(zztg.this).edit();
            if (i != 0) {
              paramString.putString(zzqq(), str);
            }
            paramString.putLong(zzqp(), l + 1L);
            paramString.apply();
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final Pair<String, Long> zzqm()
    {
      long l = zzql();
      if (l < this.zzagH) {}
      String str;
      do
      {
        return null;
        if (l > this.zzagH * 2L)
        {
          zzqk();
          return null;
        }
        str = zztg.zza(zztg.this).getString(zzqq(), null);
        l = zztg.zza(zztg.this).getLong(zzqp(), 0L);
        zzqk();
      } while ((str == null) || (l <= 0L));
      return new Pair(str, Long.valueOf(l));
    }
    
    protected final String zzqq()
    {
      return String.valueOf(this.mName).concat(":value");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.internal.zztg
 * JD-Core Version:    0.7.0.1
 */