package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public class LocalUsageInfo
  implements Parcelable
{
  public static final Parcelable.Creator<LocalUsageInfo> CREATOR;
  public final int aBM;
  public final String appId;
  public final long ccQ;
  public final String ccm;
  public final int hxM;
  public final String jwf;
  public final boolean jwg;
  public final long jwh;
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
    this.hxM = paramParcel.readInt();
    this.aBM = paramParcel.readInt();
    this.nickname = paramParcel.readString();
    this.ccm = paramParcel.readString();
    this.jwf = paramParcel.readString();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jwg = bool;
      this.ccQ = paramParcel.readLong();
      this.jwh = paramParcel.readLong();
      AppMethodBeat.o(153200);
      return;
    }
  }
  
  public LocalUsageInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.hxM = paramInt1;
    this.aBM = paramInt2;
    this.nickname = paramString3;
    this.ccm = paramString4;
    this.jwf = paramString5;
    this.jwg = paramBoolean;
    this.ccQ = paramLong1;
    this.jwh = paramLong2;
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
    if (bs.isNullOrNil(paramLocalUsageInfo.username))
    {
      AppMethodBeat.o(153198);
      return false;
    }
    if ((paramLocalUsageInfo.username.equals(this.username)) && (paramLocalUsageInfo.hxM == this.hxM))
    {
      AppMethodBeat.o(153198);
      return true;
    }
    AppMethodBeat.o(153198);
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(153199);
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.hxM);
    paramParcel.writeInt(this.aBM);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.ccm);
    paramParcel.writeString(this.jwf);
    if (this.jwg) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.ccQ);
      paramParcel.writeLong(this.jwh);
      AppMethodBeat.o(153199);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo
 * JD-Core Version:    0.7.0.1
 */