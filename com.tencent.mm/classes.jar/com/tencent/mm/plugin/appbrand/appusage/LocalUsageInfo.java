package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class LocalUsageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocalUsageInfo> CREATOR;
  public final String appId;
  public final long bDL;
  public final int bDc;
  public final String bDi;
  public final String hcN;
  public final boolean hcO;
  public final long hcP;
  public final int hcr;
  public final String nickname;
  public final String username;
  
  static
  {
    AppMethodBeat.i(114912);
    CREATOR = new LocalUsageInfo.1();
    AppMethodBeat.o(114912);
  }
  
  private LocalUsageInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(114911);
    this.username = paramParcel.readString();
    this.appId = paramParcel.readString();
    this.hcr = paramParcel.readInt();
    this.bDc = paramParcel.readInt();
    this.nickname = paramParcel.readString();
    this.bDi = paramParcel.readString();
    this.hcN = paramParcel.readString();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hcO = bool;
      this.bDL = paramParcel.readLong();
      this.hcP = paramParcel.readLong();
      AppMethodBeat.o(114911);
      return;
    }
  }
  
  public LocalUsageInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.hcr = paramInt1;
    this.bDc = paramInt2;
    this.nickname = paramString3;
    this.bDi = paramString4;
    this.hcN = paramString5;
    this.hcO = paramBoolean;
    this.bDL = paramLong1;
    this.hcP = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean e(LocalUsageInfo paramLocalUsageInfo)
  {
    AppMethodBeat.i(114909);
    if (paramLocalUsageInfo == null)
    {
      AppMethodBeat.o(114909);
      return false;
    }
    if (bo.isNullOrNil(paramLocalUsageInfo.username))
    {
      AppMethodBeat.o(114909);
      return false;
    }
    if ((paramLocalUsageInfo.username.equals(this.username)) && (paramLocalUsageInfo.hcr == this.hcr))
    {
      AppMethodBeat.o(114909);
      return true;
    }
    AppMethodBeat.o(114909);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(114910);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hcr);
    paramParcel.writeInt(this.bDc);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.bDi);
    paramParcel.writeString(this.hcN);
    if (this.hcO) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.bDL);
      paramParcel.writeLong(this.hcP);
      AppMethodBeat.o(114910);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo
 * JD-Core Version:    0.7.0.1
 */