package com.tencent.mm.plugin.finder.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "atTime", "", "getAtTime", "()J", "setAtTime", "(J)V", "authInfoByteArray", "", "getAuthInfoByteArray", "()[B", "setAuthInfoByteArray", "([B)V", "avatarUrl", "", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "nickname", "getNickname", "setNickname", "username", "getUsername", "setUsername", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LocalFinderAtContactParcel
  implements Parcelable
{
  public static final a CREATOR;
  byte[] GlA;
  long GlB;
  String nVM;
  String nickname;
  String username;
  
  static
  {
    AppMethodBeat.i(333082);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(333082);
  }
  
  public LocalFinderAtContactParcel() {}
  
  public LocalFinderAtContactParcel(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(333072);
    this.username = paramParcel.readString();
    this.nVM = paramParcel.readString();
    this.nickname = paramParcel.readString();
    this.GlA = paramParcel.createByteArray();
    this.GlB = paramParcel.readLong();
    AppMethodBeat.o(333072);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(333097);
    s.u(paramParcel, "parcel");
    paramParcel.writeString(this.username);
    paramParcel.writeString(this.nVM);
    paramParcel.writeString(this.nickname);
    paramParcel.writeByteArray(this.GlA);
    paramParcel.writeLong(this.GlB);
    AppMethodBeat.o(333097);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/utils/LocalFinderAtContactParcel;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<LocalFinderAtContactParcel>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.LocalFinderAtContactParcel
 * JD-Core Version:    0.7.0.1
 */