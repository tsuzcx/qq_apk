package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class LocalUsageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocalUsageInfo> CREATOR;
  public final String appId;
  public final int appVersion;
  public final String cyB;
  public final long czf;
  public final int iOo;
  public final String kVZ;
  public final boolean kWa;
  public final long kWb;
  public final boolean kWc;
  public final String kWd;
  public final String nickname;
  public final String username;
  
  static
  {
    AppMethodBeat.i(153201);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(153201);
  }
  
  private LocalUsageInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(153200);
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.iOo = paramParcel.readInt();
    this.appVersion = paramParcel.readInt();
    this.nickname = paramParcel.readString();
    this.cyB = paramParcel.readString();
    this.kVZ = paramParcel.readString();
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.kWa = bool1;
      this.czf = paramParcel.readLong();
      this.kWb = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.kWc = bool1;
      this.kWd = paramParcel.readString();
      AppMethodBeat.o(153200);
      return;
      bool1 = false;
      break;
    }
  }
  
  public LocalUsageInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    this(paramString1, paramString2, paramInt1, paramInt2, paramString3, paramString4, paramString5, false, paramLong, 0L, false, "");
  }
  
  public LocalUsageInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2, String paramString6)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.iOo = paramInt1;
    this.appVersion = paramInt2;
    this.nickname = paramString3;
    this.cyB = paramString4;
    this.kVZ = paramString5;
    this.kWa = paramBoolean1;
    this.czf = paramLong1;
    this.kWb = paramLong2;
    this.kWc = paramBoolean2;
    this.kWd = paramString6;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(153199);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.iOo);
    paramParcel.writeInt(this.appVersion);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.cyB);
    paramParcel.writeString(this.kVZ);
    if (this.kWa)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.czf);
      paramParcel.writeLong(this.kWb);
      if (!this.kWc) {
        break label128;
      }
    }
    label128:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.kWd);
      AppMethodBeat.o(153199);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo
 * JD-Core Version:    0.7.0.1
 */