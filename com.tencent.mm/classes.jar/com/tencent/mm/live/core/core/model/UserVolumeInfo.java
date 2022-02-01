package com.tencent.mm.live.core.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/UserVolumeInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "userId", "", "volume", "", "(Ljava/lang/String;I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getVolume", "()I", "setVolume", "(I)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-core_release"})
public final class UserVolumeInfo
  implements Parcelable
{
  public static final a CREATOR;
  public String userId;
  public int volume;
  
  static
  {
    AppMethodBeat.i(200301);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(200301);
  }
  
  private UserVolumeInfo(byte paramByte)
  {
    this();
  }
  
  public UserVolumeInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(200298);
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.userId = str1;
    this.volume = paramParcel.readInt();
    AppMethodBeat.o(200298);
  }
  
  public UserVolumeInfo(String paramString, int paramInt)
  {
    AppMethodBeat.i(200291);
    this.userId = paramString;
    this.volume = paramInt;
    AppMethodBeat.o(200291);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(200288);
    p.k(paramParcel, "parcel");
    paramParcel.writeString(this.userId);
    paramParcel.writeInt(this.volume);
    AppMethodBeat.o(200288);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/model/UserVolumeInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/live/core/core/model/UserVolumeInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/live/core/core/model/UserVolumeInfo;", "plugin-core_release"})
  public static final class a
    implements Parcelable.Creator<UserVolumeInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.UserVolumeInfo
 * JD-Core Version:    0.7.0.1
 */