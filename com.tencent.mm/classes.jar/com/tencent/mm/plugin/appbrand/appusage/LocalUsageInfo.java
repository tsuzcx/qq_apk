package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public class LocalUsageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocalUsageInfo> CREATOR;
  public final int aDD;
  public final String appId;
  public final String cmF;
  public final long cnj;
  public final int hSZ;
  public final String jTr;
  public final boolean jTs;
  public final long jTt;
  public final boolean jTu;
  public final String jTv;
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
    this.hSZ = paramParcel.readInt();
    this.aDD = paramParcel.readInt();
    this.nickname = paramParcel.readString();
    this.cmF = paramParcel.readString();
    this.jTr = paramParcel.readString();
    if (paramParcel.readByte() > 0)
    {
      bool1 = true;
      this.jTs = bool1;
      this.cnj = paramParcel.readLong();
      this.jTt = paramParcel.readLong();
      if (paramParcel.readByte() <= 0) {
        break label130;
      }
    }
    label130:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jTu = bool1;
      this.jTv = paramParcel.readString();
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
    this.hSZ = paramInt1;
    this.aDD = paramInt2;
    this.nickname = paramString3;
    this.cmF = paramString4;
    this.jTr = paramString5;
    this.jTs = paramBoolean1;
    this.cnj = paramLong1;
    this.jTt = paramLong2;
    this.jTu = paramBoolean2;
    this.jTv = paramString6;
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
    if (bu.isNullOrNil(paramLocalUsageInfo.username))
    {
      AppMethodBeat.o(153198);
      return false;
    }
    if ((paramLocalUsageInfo.username.equals(this.username)) && (paramLocalUsageInfo.hSZ == this.hSZ))
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
    paramParcel.writeInt(this.hSZ);
    paramParcel.writeInt(this.aDD);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.cmF);
    paramParcel.writeString(this.jTr);
    if (this.jTs)
    {
      paramInt = 1;
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.cnj);
      paramParcel.writeLong(this.jTt);
      if (!this.jTu) {
        break label128;
      }
    }
    label128:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.jTv);
      AppMethodBeat.o(153199);
      return;
      paramInt = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo
 * JD-Core Version:    0.7.0.1
 */