package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public class LocalUsageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocalUsageInfo> CREATOR;
  public final int aDD;
  public final String appId;
  public final String cmD;
  public final long cnh;
  public final int hQh;
  public final String jPZ;
  public final boolean jQa;
  public final long jQb;
  public final boolean jQc;
  public final String jQd;
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
    this.hQh = paramParcel.readInt();
    this.aDD = paramParcel.readInt();
    this.nickname = paramParcel.readString();
    this.cmD = paramParcel.readString();
    this.jPZ = paramParcel.readString();
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.jQa = bool1;
      this.cnh = paramParcel.readLong();
      this.jQb = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jQc = bool1;
      this.jQd = paramParcel.readString();
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
    this.hQh = paramInt1;
    this.aDD = paramInt2;
    this.nickname = paramString3;
    this.cmD = paramString4;
    this.jPZ = paramString5;
    this.jQa = paramBoolean1;
    this.cnh = paramLong1;
    this.jQb = paramLong2;
    this.jQc = paramBoolean2;
    this.jQd = paramString6;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean f(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(153198);
    if (paramLocalUsageInfo == null)
    {
      AppMethodBeat.o(153198);
      return false;
    }
    if (bt.isNullOrNil(paramLocalUsageInfo.username))
    {
      AppMethodBeat.o(153198);
      return false;
    }
    if ((paramLocalUsageInfo.username.equals(this.username)) && (paramLocalUsageInfo.hQh == this.hQh))
    {
      AppMethodBeat.o(153198);
      return true;
    }
    AppMethodBeat.o(153198);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(153199);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hQh);
    paramParcel.writeInt(this.aDD);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.cmD);
    paramParcel.writeString(this.jPZ);
    if (this.jQa)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.cnh);
      paramParcel.writeLong(this.jQb);
      if (!this.jQc) {
        break label128;
      }
    }
    label128:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jQd);
      AppMethodBeat.o(153199);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo
 * JD-Core Version:    0.7.0.1
 */