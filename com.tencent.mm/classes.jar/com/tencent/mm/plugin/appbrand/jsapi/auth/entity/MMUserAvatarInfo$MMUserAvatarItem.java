package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fus;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "item", "Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;)V", "avatarurl", "", "getAvatarurl", "()Ljava/lang/String;", "setAvatarurl", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "id", "", "getId", "()I", "setId", "(I)V", "nickname", "getNickname", "setNickname", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMUserAvatarInfo$MMUserAvatarItem
  implements Parcelable
{
  public static final a CREATOR;
  String desc;
  int id;
  String nickname;
  String rHi;
  
  static
  {
    AppMethodBeat.i(50452);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(50452);
  }
  
  protected MMUserAvatarInfo$MMUserAvatarItem(Parcel paramParcel)
  {
    AppMethodBeat.i(50450);
    this.nickname = "";
    this.rHi = "";
    this.id = paramParcel.readInt();
    this.nickname = String.valueOf(paramParcel.readString());
    this.rHi = String.valueOf(paramParcel.readString());
    this.desc = paramParcel.readString();
    AppMethodBeat.o(50450);
  }
  
  public MMUserAvatarInfo$MMUserAvatarItem(fus paramfus)
  {
    AppMethodBeat.i(50451);
    this.nickname = "";
    this.rHi = "";
    this.id = paramfus.id;
    String str = paramfus.nickname;
    s.s(str, "item.nickname");
    this.nickname = str;
    str = paramfus.rHi;
    s.s(str, "item.avatarurl");
    this.rHi = str;
    this.desc = paramfus.desc;
    AppMethodBeat.o(50451);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50449);
    s.u(paramParcel, "dest");
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.rHi);
    paramParcel.writeString(this.desc);
    AppMethodBeat.o(50449);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<MMUserAvatarInfo.MMUserAvatarItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo.MMUserAvatarItem
 * JD-Core Version:    0.7.0.1
 */