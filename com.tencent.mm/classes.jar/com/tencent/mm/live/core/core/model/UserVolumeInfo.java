package com.tencent.mm.live.core.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/UserVolumeInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "userId", "", "volume", "", "(Ljava/lang/String;I)V", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getVolume", "()I", "setVolume", "(I)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class UserVolumeInfo
  implements Parcelable
{
  public static final a CREATOR;
  public String userId;
  public int volume;
  
  static
  {
    AppMethodBeat.i(247969);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(247969);
  }
  
  private UserVolumeInfo(byte paramByte)
  {
    this();
  }
  
  public UserVolumeInfo(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(247959);
    String str2 = paramParcel.readString();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    this.userId = str1;
    this.volume = paramParcel.readInt();
    AppMethodBeat.o(247959);
  }
  
  public UserVolumeInfo(String paramString, int paramInt)
  {
    AppMethodBeat.i(247944);
    this.userId = paramString;
    this.volume = paramInt;
    AppMethodBeat.o(247944);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(247978);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.userId);
    paramParcel.writeInt(this.volume);
    AppMethodBeat.o(247978);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/core/model/UserVolumeInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/live/core/core/model/UserVolumeInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/live/core/core/model/UserVolumeInfo;", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<UserVolumeInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.model.UserVolumeInfo
 * JD-Core Version:    0.7.0.1
 */