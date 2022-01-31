package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzdy
{
  private final zzgl zzacw;
  private String zzadl;
  private String zzadm;
  private String zzadn;
  private String zzado;
  private long zzadp;
  private long zzadq;
  private long zzadr;
  private long zzads;
  private String zzadt;
  private long zzadu;
  private long zzadv;
  private boolean zzadw;
  private long zzadx;
  private boolean zzady;
  private boolean zzadz;
  private long zzaea;
  private long zzaeb;
  private long zzaec;
  private long zzaed;
  private long zzaee;
  private long zzaef;
  private String zzaeg;
  private boolean zzaeh;
  private long zzaei;
  private long zzaej;
  private String zzth;
  private final String zzti;
  
  zzdy(zzgl paramzzgl, String paramString)
  {
    AppMethodBeat.i(68525);
    Preconditions.checkNotNull(paramzzgl);
    Preconditions.checkNotEmpty(paramString);
    this.zzacw = paramzzgl;
    this.zzti = paramString;
    this.zzacw.zzab();
    AppMethodBeat.o(68525);
  }
  
  public final String getAppInstanceId()
  {
    AppMethodBeat.i(68528);
    this.zzacw.zzab();
    String str = this.zzadl;
    AppMethodBeat.o(68528);
    return str;
  }
  
  public final String getGmpAppId()
  {
    AppMethodBeat.i(68530);
    this.zzacw.zzab();
    String str = this.zzadm;
    AppMethodBeat.o(68530);
    return str;
  }
  
  public final boolean isMeasurementEnabled()
  {
    AppMethodBeat.i(68550);
    this.zzacw.zzab();
    boolean bool = this.zzadw;
    AppMethodBeat.o(68550);
    return bool;
  }
  
  public final void setAppVersion(String paramString)
  {
    AppMethodBeat.i(68541);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzth, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzth = paramString;
      AppMethodBeat.o(68541);
      return;
    }
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(68551);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadw != paramBoolean) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadw = paramBoolean;
      AppMethodBeat.o(68551);
      return;
    }
  }
  
  public final void zzaa(long paramLong)
  {
    AppMethodBeat.i(68575);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadx != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadx = paramLong;
      AppMethodBeat.o(68575);
      return;
    }
  }
  
  public final String zzag()
  {
    AppMethodBeat.i(68540);
    this.zzacw.zzab();
    String str = this.zzth;
    AppMethodBeat.o(68540);
    return str;
  }
  
  public final String zzah()
  {
    AppMethodBeat.i(68527);
    this.zzacw.zzab();
    String str = this.zzti;
    AppMethodBeat.o(68527);
    return str;
  }
  
  public final void zzal(String paramString)
  {
    AppMethodBeat.i(68529);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzadl, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadl = paramString;
      AppMethodBeat.o(68529);
      return;
    }
  }
  
  public final void zzam(String paramString)
  {
    AppMethodBeat.i(68531);
    this.zzacw.zzab();
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzadm, str)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadm = str;
      AppMethodBeat.o(68531);
      return;
    }
  }
  
  public final void zzan(String paramString)
  {
    AppMethodBeat.i(68533);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzadn, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadn = paramString;
      AppMethodBeat.o(68533);
      return;
    }
  }
  
  public final void zzao(String paramString)
  {
    AppMethodBeat.i(68535);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzado, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzado = paramString;
      AppMethodBeat.o(68535);
      return;
    }
  }
  
  public final void zzap(String paramString)
  {
    AppMethodBeat.i(68545);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzadt, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadt = paramString;
      AppMethodBeat.o(68545);
      return;
    }
  }
  
  public final void zzaq(String paramString)
  {
    AppMethodBeat.i(68573);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzaeg, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaeg = paramString;
      AppMethodBeat.o(68573);
      return;
    }
  }
  
  public final void zzd(boolean paramBoolean)
  {
    AppMethodBeat.i(68577);
    this.zzacw.zzab();
    if (this.zzady != paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzaeh = bool;
      this.zzady = paramBoolean;
      AppMethodBeat.o(68577);
      return;
    }
  }
  
  public final void zze(boolean paramBoolean)
  {
    AppMethodBeat.i(68579);
    this.zzacw.zzab();
    if (this.zzadz != paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzaeh = bool;
      this.zzadz = paramBoolean;
      AppMethodBeat.o(68579);
      return;
    }
  }
  
  public final void zzgh()
  {
    AppMethodBeat.i(68526);
    this.zzacw.zzab();
    this.zzaeh = false;
    AppMethodBeat.o(68526);
  }
  
  public final String zzgi()
  {
    AppMethodBeat.i(68532);
    this.zzacw.zzab();
    String str = this.zzadn;
    AppMethodBeat.o(68532);
    return str;
  }
  
  public final String zzgj()
  {
    AppMethodBeat.i(68534);
    this.zzacw.zzab();
    String str = this.zzado;
    AppMethodBeat.o(68534);
    return str;
  }
  
  public final long zzgk()
  {
    AppMethodBeat.i(68536);
    this.zzacw.zzab();
    long l = this.zzadq;
    AppMethodBeat.o(68536);
    return l;
  }
  
  public final long zzgl()
  {
    AppMethodBeat.i(68538);
    this.zzacw.zzab();
    long l = this.zzadr;
    AppMethodBeat.o(68538);
    return l;
  }
  
  public final long zzgm()
  {
    AppMethodBeat.i(68542);
    this.zzacw.zzab();
    long l = this.zzads;
    AppMethodBeat.o(68542);
    return l;
  }
  
  public final String zzgn()
  {
    AppMethodBeat.i(68544);
    this.zzacw.zzab();
    String str = this.zzadt;
    AppMethodBeat.o(68544);
    return str;
  }
  
  public final long zzgo()
  {
    AppMethodBeat.i(68546);
    this.zzacw.zzab();
    long l = this.zzadu;
    AppMethodBeat.o(68546);
    return l;
  }
  
  public final long zzgp()
  {
    AppMethodBeat.i(68548);
    this.zzacw.zzab();
    long l = this.zzadv;
    AppMethodBeat.o(68548);
    return l;
  }
  
  public final long zzgq()
  {
    AppMethodBeat.i(68553);
    this.zzacw.zzab();
    long l = this.zzadp;
    AppMethodBeat.o(68553);
    return l;
  }
  
  public final long zzgr()
  {
    AppMethodBeat.i(68554);
    this.zzacw.zzab();
    long l = this.zzaei;
    AppMethodBeat.o(68554);
    return l;
  }
  
  public final long zzgs()
  {
    AppMethodBeat.i(68556);
    this.zzacw.zzab();
    long l = this.zzaej;
    AppMethodBeat.o(68556);
    return l;
  }
  
  public final void zzgt()
  {
    AppMethodBeat.i(68558);
    this.zzacw.zzab();
    long l2 = this.zzadp + 1L;
    long l1 = l2;
    if (l2 > 2147483647L)
    {
      this.zzacw.zzge().zzip().zzg("Bundle index overflow. appId", zzfg.zzbm(this.zzti));
      l1 = 0L;
    }
    this.zzaeh = true;
    this.zzadp = l1;
    AppMethodBeat.o(68558);
  }
  
  public final long zzgu()
  {
    AppMethodBeat.i(68559);
    this.zzacw.zzab();
    long l = this.zzaea;
    AppMethodBeat.o(68559);
    return l;
  }
  
  public final long zzgv()
  {
    AppMethodBeat.i(68561);
    this.zzacw.zzab();
    long l = this.zzaeb;
    AppMethodBeat.o(68561);
    return l;
  }
  
  public final long zzgw()
  {
    AppMethodBeat.i(68563);
    this.zzacw.zzab();
    long l = this.zzaec;
    AppMethodBeat.o(68563);
    return l;
  }
  
  public final long zzgx()
  {
    AppMethodBeat.i(68565);
    this.zzacw.zzab();
    long l = this.zzaed;
    AppMethodBeat.o(68565);
    return l;
  }
  
  public final long zzgy()
  {
    AppMethodBeat.i(68567);
    this.zzacw.zzab();
    long l = this.zzaef;
    AppMethodBeat.o(68567);
    return l;
  }
  
  public final long zzgz()
  {
    AppMethodBeat.i(68569);
    this.zzacw.zzab();
    long l = this.zzaee;
    AppMethodBeat.o(68569);
    return l;
  }
  
  public final String zzha()
  {
    AppMethodBeat.i(68571);
    this.zzacw.zzab();
    String str = this.zzaeg;
    AppMethodBeat.o(68571);
    return str;
  }
  
  public final String zzhb()
  {
    AppMethodBeat.i(68572);
    this.zzacw.zzab();
    String str = this.zzaeg;
    zzaq(null);
    AppMethodBeat.o(68572);
    return str;
  }
  
  public final long zzhc()
  {
    AppMethodBeat.i(68574);
    this.zzacw.zzab();
    long l = this.zzadx;
    AppMethodBeat.o(68574);
    return l;
  }
  
  public final boolean zzhd()
  {
    AppMethodBeat.i(68576);
    this.zzacw.zzab();
    boolean bool = this.zzady;
    AppMethodBeat.o(68576);
    return bool;
  }
  
  public final boolean zzhe()
  {
    AppMethodBeat.i(68578);
    this.zzacw.zzab();
    boolean bool = this.zzadz;
    AppMethodBeat.o(68578);
    return bool;
  }
  
  public final void zzm(long paramLong)
  {
    AppMethodBeat.i(68537);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadq != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadq = paramLong;
      AppMethodBeat.o(68537);
      return;
    }
  }
  
  public final void zzn(long paramLong)
  {
    AppMethodBeat.i(68539);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadr != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadr = paramLong;
      AppMethodBeat.o(68539);
      return;
    }
  }
  
  public final void zzo(long paramLong)
  {
    AppMethodBeat.i(68543);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzads != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzads = paramLong;
      AppMethodBeat.o(68543);
      return;
    }
  }
  
  public final void zzp(long paramLong)
  {
    AppMethodBeat.i(68547);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadu != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadu = paramLong;
      AppMethodBeat.o(68547);
      return;
    }
  }
  
  public final void zzq(long paramLong)
  {
    AppMethodBeat.i(68549);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadv != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadv = paramLong;
      AppMethodBeat.o(68549);
      return;
    }
  }
  
  public final void zzr(long paramLong)
  {
    boolean bool1 = true;
    AppMethodBeat.i(68552);
    boolean bool2;
    if (paramLong >= 0L)
    {
      bool2 = true;
      Preconditions.checkArgument(bool2);
      this.zzacw.zzab();
      bool2 = this.zzaeh;
      if (this.zzadp == paramLong) {
        break label70;
      }
    }
    for (;;)
    {
      this.zzaeh = (bool2 | bool1);
      this.zzadp = paramLong;
      AppMethodBeat.o(68552);
      return;
      bool2 = false;
      break;
      label70:
      bool1 = false;
    }
  }
  
  public final void zzs(long paramLong)
  {
    AppMethodBeat.i(68555);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaei != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaei = paramLong;
      AppMethodBeat.o(68555);
      return;
    }
  }
  
  public final void zzt(long paramLong)
  {
    AppMethodBeat.i(68557);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaej != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaej = paramLong;
      AppMethodBeat.o(68557);
      return;
    }
  }
  
  public final void zzu(long paramLong)
  {
    AppMethodBeat.i(68560);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaea != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaea = paramLong;
      AppMethodBeat.o(68560);
      return;
    }
  }
  
  public final void zzv(long paramLong)
  {
    AppMethodBeat.i(68562);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaeb != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaeb = paramLong;
      AppMethodBeat.o(68562);
      return;
    }
  }
  
  public final void zzw(long paramLong)
  {
    AppMethodBeat.i(68564);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaec != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaec = paramLong;
      AppMethodBeat.o(68564);
      return;
    }
  }
  
  public final void zzx(long paramLong)
  {
    AppMethodBeat.i(68566);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaed != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaed = paramLong;
      AppMethodBeat.o(68566);
      return;
    }
  }
  
  public final void zzy(long paramLong)
  {
    AppMethodBeat.i(68568);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaef != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaef = paramLong;
      AppMethodBeat.o(68568);
      return;
    }
  }
  
  public final void zzz(long paramLong)
  {
    AppMethodBeat.i(68570);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaee != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaee = paramLong;
      AppMethodBeat.o(68570);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdy
 * JD-Core Version:    0.7.0.1
 */