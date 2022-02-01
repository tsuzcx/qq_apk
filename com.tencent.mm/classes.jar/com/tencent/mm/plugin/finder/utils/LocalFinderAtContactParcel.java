package com.tencent.mm.plugin.finder.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "atTime", "", "getAtTime", "()J", "setAtTime", "(J)V", "authInfoByteArray", "", "getAuthInfoByteArray", "()[B", "setAuthInfoByteArray", "([B)V", "avatarUrl", "", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "nickname", "getNickname", "setNickname", "username", "getUsername", "setUsername", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-finder_release"})
public final class LocalFinderAtContactParcel
  implements Parcelable
{
  public static final a CREATOR;
  String kog;
  String nickname;
  String username;
  byte[] wak;
  long wal;
  
  static
  {
    AppMethodBeat.i(253797);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(253797);
  }
  
  public LocalFinderAtContactParcel() {}
  
  public LocalFinderAtContactParcel(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(253796);
    this.username = paramParcel.readString();
    this.kog = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.wak = paramParcel.createByteArray();
    this.wal = paramParcel.readLong();
    AppMethodBeat.o(253796);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(253795);
    p.h(paramParcel, "parcel");
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.kog);
    paramParcel.writeString(this.nickname);
    paramParcel.writeByteArray(this.wak);
    paramParcel.writeLong(this.wal);
    AppMethodBeat.o(253795);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "plugin-finder_release"})
  public static final class a
    implements Parcelable.Creator<LocalFinderAtContactParcel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.LocalFinderAtContactParcel
 * JD-Core Version:    0.7.0.1
 */