package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eor;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "item", "Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;)V", "avatarurl", "", "getAvatarurl", "()Ljava/lang/String;", "setAvatarurl", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "id", "", "getId", "()I", "setId", "(I)V", "nickname", "getNickname", "setNickname", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
public final class MMUserAvatarInfo$MMUserAvatarItem
  implements Parcelable
{
  public static final a CREATOR;
  String desc;
  int id;
  String lHM;
  String nickname;
  
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
    this.lHM = "";
    this.id = paramParcel.readInt();
    this.nickname = String.valueOf(paramParcel.readString());
    this.lHM = String.valueOf(paramParcel.readString());
    this.desc = paramParcel.readString();
    AppMethodBeat.o(50450);
  }
  
  public MMUserAvatarInfo$MMUserAvatarItem(eor parameor)
  {
    AppMethodBeat.i(50451);
    this.nickname = "";
    this.lHM = "";
    this.id = parameor.id;
    String str = parameor.nickname;
    p.g(str, "item.nickname");
    this.nickname = str;
    str = parameor.lHM;
    p.g(str, "item.avatarurl");
    this.lHM = str;
    this.desc = parameor.desc;
    AppMethodBeat.o(50451);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50449);
    p.h(paramParcel, "dest");
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.nickname);
    paramParcel.writeString(this.lHM);
    paramParcel.writeString(this.desc);
    AppMethodBeat.o(50449);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<MMUserAvatarInfo.MMUserAvatarItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo.MMUserAvatarItem
 * JD-Core Version:    0.7.0.1
 */