package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzd();
  private final long mTimeout;
  private final long zzaHD;
  private int zzaHE;
  private final String zzaHF;
  private final String zzaHG;
  private final String zzaHH;
  private final int zzaHI;
  private final List<String> zzaHJ;
  private final String zzaHK;
  private final long zzaHL;
  private int zzaHM;
  private final String zzaHN;
  private final float zzaHO;
  private long zzaHP;
  final int zzaiI;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this.zzaiI = paramInt1;
    this.zzaHD = paramLong1;
    this.zzaHE = paramInt2;
    this.zzaHF = paramString1;
    this.zzaHG = paramString3;
    this.zzaHH = paramString5;
    this.zzaHI = paramInt3;
    this.zzaHP = -1L;
    this.zzaHJ = paramList;
    this.zzaHK = paramString2;
    this.zzaHL = paramLong2;
    this.zzaHM = paramInt4;
    this.zzaHN = paramString4;
    this.zzaHO = paramFloat;
    this.mTimeout = paramLong3;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5)
  {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5);
  }
  
  public final int getEventType()
  {
    return this.zzaHE;
  }
  
  public final long getTimeMillis()
  {
    return this.zzaHD;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public final long zzyK()
  {
    return this.zzaHP;
  }
  
  public final String zzyL()
  {
    String str5 = String.valueOf("\t");
    String str6 = String.valueOf(zzyM());
    String str7 = String.valueOf("\t");
    int i = zzyP();
    String str8 = String.valueOf("\t");
    String str1;
    String str9;
    int j;
    String str10;
    String str2;
    label76:
    String str11;
    String str3;
    label94:
    String str12;
    float f;
    String str13;
    if (zzyQ() == null)
    {
      str1 = "";
      str9 = String.valueOf("\t");
      j = zzyT();
      str10 = String.valueOf("\t");
      if (zzyN() != null) {
        break label345;
      }
      str2 = "";
      str11 = String.valueOf("\t");
      if (zzyU() != null) {
        break label354;
      }
      str3 = "";
      str12 = String.valueOf("\t");
      f = zzyV();
      str13 = String.valueOf("\t");
      if (zzyO() != null) {
        break label363;
      }
    }
    label345:
    label354:
    label363:
    for (String str4 = "";; str4 = zzyO())
    {
      return String.valueOf(str5).length() + 37 + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str1).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str2).length() + String.valueOf(str11).length() + String.valueOf(str3).length() + String.valueOf(str12).length() + String.valueOf(str13).length() + String.valueOf(str4).length() + str5 + str6 + str7 + i + str8 + str1 + str9 + j + str10 + str2 + str11 + str3 + str12 + f + str13 + str4;
      str1 = TextUtils.join(",", zzyQ());
      break;
      str2 = zzyN();
      break label76;
      str3 = zzyU();
      break label94;
    }
  }
  
  public final String zzyM()
  {
    return this.zzaHF;
  }
  
  public final String zzyN()
  {
    return this.zzaHG;
  }
  
  public final String zzyO()
  {
    return this.zzaHH;
  }
  
  public final int zzyP()
  {
    return this.zzaHI;
  }
  
  public final List<String> zzyQ()
  {
    return this.zzaHJ;
  }
  
  public final String zzyR()
  {
    return this.zzaHK;
  }
  
  public final long zzyS()
  {
    return this.zzaHL;
  }
  
  public final int zzyT()
  {
    return this.zzaHM;
  }
  
  public final String zzyU()
  {
    return this.zzaHN;
  }
  
  public final float zzyV()
  {
    return this.zzaHO;
  }
  
  public final long zzyW()
  {
    return this.mTimeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.stats.WakeLockEvent
 * JD-Core Version:    0.7.0.1
 */