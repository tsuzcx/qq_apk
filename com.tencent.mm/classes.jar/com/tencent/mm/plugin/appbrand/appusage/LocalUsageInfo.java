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
  public final String epy;
  public final long eqh;
  public final int euz;
  public final String nickname;
  public final String qQb;
  public final boolean qQc;
  public final long qQd;
  public final boolean qQe;
  public final String qQf;
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
    this.euz = paramParcel.readInt();
    this.appVersion = paramParcel.readInt();
    this.nickname = paramParcel.readString();
    this.epy = paramParcel.readString();
    this.qQb = paramParcel.readString();
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.qQc = bool1;
      this.eqh = paramParcel.readLong();
      this.qQd = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.qQe = bool1;
      this.qQf = paramParcel.readString();
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
    this.euz = paramInt1;
    this.appVersion = paramInt2;
    this.nickname = paramString3;
    this.epy = paramString4;
    this.qQb = paramString5;
    this.qQc = paramBoolean1;
    this.eqh = paramLong1;
    this.qQd = paramLong2;
    this.qQe = paramBoolean2;
    this.qQf = paramString6;
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
    paramParcel.writeInt(this.euz);
    paramParcel.writeInt(this.appVersion);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.epy);
    paramParcel.writeString(this.qQb);
    if (this.qQc)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.eqh);
      paramParcel.writeLong(this.qQd);
      if (!this.qQe) {
        break label128;
      }
    }
    label128:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.qQf);
      AppMethodBeat.o(153199);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo
 * JD-Core Version:    0.7.0.1
 */