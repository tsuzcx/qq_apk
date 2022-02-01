package com.tencent.mm.plugin.finder.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "atTime", "", "getAtTime", "()J", "setAtTime", "(J)V", "authInfoByteArray", "", "getAuthInfoByteArray", "()[B", "setAuthInfoByteArray", "([B)V", "avatarUrl", "", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "nickname", "getNickname", "setNickname", "username", "getUsername", "setUsername", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-finder_release"})
public final class LocalFinderAtContactParcel
  implements Parcelable
{
  public static final a CREATOR;
  byte[] Lby;
  long Lbz;
  String itN;
  String nickname;
  String username;
  
  static
  {
    AppMethodBeat.i(199684);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(199684);
  }
  
  public LocalFinderAtContactParcel() {}
  
  public LocalFinderAtContactParcel(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(199683);
    this.username = paramParcel.readString();
    this.itN = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.Lby = paramParcel.createByteArray();
    this.Lbz = paramParcel.readLong();
    AppMethodBeat.o(199683);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(199682);
    k.h(paramParcel, "parcel");
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.itN);
    paramParcel.writeString(this.nickname);
    paramParcel.writeByteArray(this.Lby);
    paramParcel.writeLong(this.Lbz);
    AppMethodBeat.o(199682);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "plugin-finder_release"})
  public static final class a
    implements Parcelable.Creator<LocalFinderAtContactParcel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.LocalFinderAtContactParcel
 * JD-Core Version:    0.7.0.1
 */