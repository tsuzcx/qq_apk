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
    AppMethodBeat.i(1048);
    Preconditions.checkNotNull(paramzzgl);
    Preconditions.checkNotEmpty(paramString);
    this.zzacw = paramzzgl;
    this.zzti = paramString;
    this.zzacw.zzab();
    AppMethodBeat.o(1048);
  }
  
  public final String getAppInstanceId()
  {
    AppMethodBeat.i(1051);
    this.zzacw.zzab();
    String str = this.zzadl;
    AppMethodBeat.o(1051);
    return str;
  }
  
  public final String getGmpAppId()
  {
    AppMethodBeat.i(1053);
    this.zzacw.zzab();
    String str = this.zzadm;
    AppMethodBeat.o(1053);
    return str;
  }
  
  public final boolean isMeasurementEnabled()
  {
    AppMethodBeat.i(1073);
    this.zzacw.zzab();
    boolean bool = this.zzadw;
    AppMethodBeat.o(1073);
    return bool;
  }
  
  public final void setAppVersion(String paramString)
  {
    AppMethodBeat.i(1064);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzth, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzth = paramString;
      AppMethodBeat.o(1064);
      return;
    }
  }
  
  public final void setMeasurementEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(1074);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadw != paramBoolean) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadw = paramBoolean;
      AppMethodBeat.o(1074);
      return;
    }
  }
  
  public final void zzaa(long paramLong)
  {
    AppMethodBeat.i(1098);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadx != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadx = paramLong;
      AppMethodBeat.o(1098);
      return;
    }
  }
  
  public final String zzag()
  {
    AppMethodBeat.i(1063);
    this.zzacw.zzab();
    String str = this.zzth;
    AppMethodBeat.o(1063);
    return str;
  }
  
  public final String zzah()
  {
    AppMethodBeat.i(1050);
    this.zzacw.zzab();
    String str = this.zzti;
    AppMethodBeat.o(1050);
    return str;
  }
  
  public final void zzal(String paramString)
  {
    AppMethodBeat.i(1052);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzadl, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadl = paramString;
      AppMethodBeat.o(1052);
      return;
    }
  }
  
  public final void zzam(String paramString)
  {
    AppMethodBeat.i(1054);
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
      AppMethodBeat.o(1054);
      return;
    }
  }
  
  public final void zzan(String paramString)
  {
    AppMethodBeat.i(1056);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzadn, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadn = paramString;
      AppMethodBeat.o(1056);
      return;
    }
  }
  
  public final void zzao(String paramString)
  {
    AppMethodBeat.i(1058);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzado, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzado = paramString;
      AppMethodBeat.o(1058);
      return;
    }
  }
  
  public final void zzap(String paramString)
  {
    AppMethodBeat.i(1068);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzadt, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadt = paramString;
      AppMethodBeat.o(1068);
      return;
    }
  }
  
  public final void zzaq(String paramString)
  {
    AppMethodBeat.i(1096);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (!zzka.zzs(this.zzaeg, paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaeg = paramString;
      AppMethodBeat.o(1096);
      return;
    }
  }
  
  public final void zzd(boolean paramBoolean)
  {
    AppMethodBeat.i(1100);
    this.zzacw.zzab();
    if (this.zzady != paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzaeh = bool;
      this.zzady = paramBoolean;
      AppMethodBeat.o(1100);
      return;
    }
  }
  
  public final void zze(boolean paramBoolean)
  {
    AppMethodBeat.i(1102);
    this.zzacw.zzab();
    if (this.zzadz != paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzaeh = bool;
      this.zzadz = paramBoolean;
      AppMethodBeat.o(1102);
      return;
    }
  }
  
  public final void zzgh()
  {
    AppMethodBeat.i(1049);
    this.zzacw.zzab();
    this.zzaeh = false;
    AppMethodBeat.o(1049);
  }
  
  public final String zzgi()
  {
    AppMethodBeat.i(1055);
    this.zzacw.zzab();
    String str = this.zzadn;
    AppMethodBeat.o(1055);
    return str;
  }
  
  public final String zzgj()
  {
    AppMethodBeat.i(1057);
    this.zzacw.zzab();
    String str = this.zzado;
    AppMethodBeat.o(1057);
    return str;
  }
  
  public final long zzgk()
  {
    AppMethodBeat.i(1059);
    this.zzacw.zzab();
    long l = this.zzadq;
    AppMethodBeat.o(1059);
    return l;
  }
  
  public final long zzgl()
  {
    AppMethodBeat.i(1061);
    this.zzacw.zzab();
    long l = this.zzadr;
    AppMethodBeat.o(1061);
    return l;
  }
  
  public final long zzgm()
  {
    AppMethodBeat.i(1065);
    this.zzacw.zzab();
    long l = this.zzads;
    AppMethodBeat.o(1065);
    return l;
  }
  
  public final String zzgn()
  {
    AppMethodBeat.i(1067);
    this.zzacw.zzab();
    String str = this.zzadt;
    AppMethodBeat.o(1067);
    return str;
  }
  
  public final long zzgo()
  {
    AppMethodBeat.i(1069);
    this.zzacw.zzab();
    long l = this.zzadu;
    AppMethodBeat.o(1069);
    return l;
  }
  
  public final long zzgp()
  {
    AppMethodBeat.i(1071);
    this.zzacw.zzab();
    long l = this.zzadv;
    AppMethodBeat.o(1071);
    return l;
  }
  
  public final long zzgq()
  {
    AppMethodBeat.i(1076);
    this.zzacw.zzab();
    long l = this.zzadp;
    AppMethodBeat.o(1076);
    return l;
  }
  
  public final long zzgr()
  {
    AppMethodBeat.i(1077);
    this.zzacw.zzab();
    long l = this.zzaei;
    AppMethodBeat.o(1077);
    return l;
  }
  
  public final long zzgs()
  {
    AppMethodBeat.i(1079);
    this.zzacw.zzab();
    long l = this.zzaej;
    AppMethodBeat.o(1079);
    return l;
  }
  
  public final void zzgt()
  {
    AppMethodBeat.i(1081);
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
    AppMethodBeat.o(1081);
  }
  
  public final long zzgu()
  {
    AppMethodBeat.i(1082);
    this.zzacw.zzab();
    long l = this.zzaea;
    AppMethodBeat.o(1082);
    return l;
  }
  
  public final long zzgv()
  {
    AppMethodBeat.i(1084);
    this.zzacw.zzab();
    long l = this.zzaeb;
    AppMethodBeat.o(1084);
    return l;
  }
  
  public final long zzgw()
  {
    AppMethodBeat.i(1086);
    this.zzacw.zzab();
    long l = this.zzaec;
    AppMethodBeat.o(1086);
    return l;
  }
  
  public final long zzgx()
  {
    AppMethodBeat.i(1088);
    this.zzacw.zzab();
    long l = this.zzaed;
    AppMethodBeat.o(1088);
    return l;
  }
  
  public final long zzgy()
  {
    AppMethodBeat.i(1090);
    this.zzacw.zzab();
    long l = this.zzaef;
    AppMethodBeat.o(1090);
    return l;
  }
  
  public final long zzgz()
  {
    AppMethodBeat.i(1092);
    this.zzacw.zzab();
    long l = this.zzaee;
    AppMethodBeat.o(1092);
    return l;
  }
  
  public final String zzha()
  {
    AppMethodBeat.i(1094);
    this.zzacw.zzab();
    String str = this.zzaeg;
    AppMethodBeat.o(1094);
    return str;
  }
  
  public final String zzhb()
  {
    AppMethodBeat.i(1095);
    this.zzacw.zzab();
    String str = this.zzaeg;
    zzaq(null);
    AppMethodBeat.o(1095);
    return str;
  }
  
  public final long zzhc()
  {
    AppMethodBeat.i(1097);
    this.zzacw.zzab();
    long l = this.zzadx;
    AppMethodBeat.o(1097);
    return l;
  }
  
  public final boolean zzhd()
  {
    AppMethodBeat.i(1099);
    this.zzacw.zzab();
    boolean bool = this.zzady;
    AppMethodBeat.o(1099);
    return bool;
  }
  
  public final boolean zzhe()
  {
    AppMethodBeat.i(1101);
    this.zzacw.zzab();
    boolean bool = this.zzadz;
    AppMethodBeat.o(1101);
    return bool;
  }
  
  public final void zzm(long paramLong)
  {
    AppMethodBeat.i(1060);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadq != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadq = paramLong;
      AppMethodBeat.o(1060);
      return;
    }
  }
  
  public final void zzn(long paramLong)
  {
    AppMethodBeat.i(1062);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadr != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadr = paramLong;
      AppMethodBeat.o(1062);
      return;
    }
  }
  
  public final void zzo(long paramLong)
  {
    AppMethodBeat.i(1066);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzads != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzads = paramLong;
      AppMethodBeat.o(1066);
      return;
    }
  }
  
  public final void zzp(long paramLong)
  {
    AppMethodBeat.i(1070);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadu != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadu = paramLong;
      AppMethodBeat.o(1070);
      return;
    }
  }
  
  public final void zzq(long paramLong)
  {
    AppMethodBeat.i(1072);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzadv != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzadv = paramLong;
      AppMethodBeat.o(1072);
      return;
    }
  }
  
  public final void zzr(long paramLong)
  {
    boolean bool1 = true;
    AppMethodBeat.i(1075);
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
      AppMethodBeat.o(1075);
      return;
      bool2 = false;
      break;
      label70:
      bool1 = false;
    }
  }
  
  public final void zzs(long paramLong)
  {
    AppMethodBeat.i(1078);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaei != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaei = paramLong;
      AppMethodBeat.o(1078);
      return;
    }
  }
  
  public final void zzt(long paramLong)
  {
    AppMethodBeat.i(1080);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaej != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaej = paramLong;
      AppMethodBeat.o(1080);
      return;
    }
  }
  
  public final void zzu(long paramLong)
  {
    AppMethodBeat.i(1083);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaea != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaea = paramLong;
      AppMethodBeat.o(1083);
      return;
    }
  }
  
  public final void zzv(long paramLong)
  {
    AppMethodBeat.i(1085);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaeb != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaeb = paramLong;
      AppMethodBeat.o(1085);
      return;
    }
  }
  
  public final void zzw(long paramLong)
  {
    AppMethodBeat.i(1087);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaec != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaec = paramLong;
      AppMethodBeat.o(1087);
      return;
    }
  }
  
  public final void zzx(long paramLong)
  {
    AppMethodBeat.i(1089);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaed != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaed = paramLong;
      AppMethodBeat.o(1089);
      return;
    }
  }
  
  public final void zzy(long paramLong)
  {
    AppMethodBeat.i(1091);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaef != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaef = paramLong;
      AppMethodBeat.o(1091);
      return;
    }
  }
  
  public final void zzz(long paramLong)
  {
    AppMethodBeat.i(1093);
    this.zzacw.zzab();
    boolean bool2 = this.zzaeh;
    if (this.zzaee != paramLong) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.zzaeh = (bool1 | bool2);
      this.zzaee = paramLong;
      AppMethodBeat.o(1093);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzdy
 * JD-Core Version:    0.7.0.1
 */