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
  public final int aAS;
  public final String appId;
  public final long cfT;
  public final String cfp;
  public final int gXn;
  public final String iVP;
  public final boolean iVQ;
  public final long iVR;
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
    this.gXn = paramParcel.readInt();
    this.aAS = paramParcel.readInt();
    this.nickname = paramParcel.readString();
    this.cfp = paramParcel.readString();
    this.iVP = paramParcel.readString();
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.iVQ = bool;
      this.cfT = paramParcel.readLong();
      this.iVR = paramParcel.readLong();
      AppMethodBeat.o(153200);
      return;
    }
  }
  
  public LocalUsageInfo(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    this.username = paramString1;
    this.appId = paramString2;
    this.gXn = paramInt1;
    this.aAS = paramInt2;
    this.nickname = paramString3;
    this.cfp = paramString4;
    this.iVP = paramString5;
    this.iVQ = paramBoolean;
    this.cfT = paramLong1;
    this.iVR = paramLong2;
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
    if ((paramLocalUsageInfo.username.equals(this.username)) && (paramLocalUsageInfo.gXn == this.gXn))
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
    paramParcel.writeInt(this.gXn);
    paramParcel.writeInt(this.aAS);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.cfp);
    paramParcel.writeString(this.iVP);
    if (this.iVQ) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeLong(this.cfT);
      paramParcel.writeLong(this.iVR);
      AppMethodBeat.o(153199);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo
 * JD-Core Version:    0.7.0.1
 */