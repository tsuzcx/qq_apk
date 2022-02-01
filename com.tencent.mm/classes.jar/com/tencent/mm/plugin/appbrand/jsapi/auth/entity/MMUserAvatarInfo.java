package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eyy;
import com.tencent.mm.protocal.protobuf.eyz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "avatar_info", "Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;)V", "avatar_limit", "", "getAvatar_limit", "()I", "setAvatar_limit", "(I)V", "avatar_list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "getAvatar_list", "()Ljava/util/ArrayList;", "setAvatar_list", "(Ljava/util/ArrayList;)V", "avatar_wording", "", "getAvatar_wording", "()Ljava/lang/String;", "setAvatar_wording", "(Ljava/lang/String;)V", "default_avatar_id", "getDefault_avatar_id", "setDefault_avatar_id", "default_headimg_fileid", "getDefault_headimg_fileid", "setDefault_headimg_fileid", "default_headimg_url", "getDefault_headimg_url", "setDefault_headimg_url", "is_ban_modify_avatar", "", "()Z", "set_ban_modify_avatar", "(Z)V", "limit_wording", "getLimit_wording", "setLimit_wording", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "MMUserAvatarItem", "plugin-appbrand-integration_release"})
public final class MMUserAvatarInfo
  implements Parcelable
{
  public static final a CREATOR;
  ArrayList<MMUserAvatarItem> oDN;
  boolean oDO;
  int oDP;
  public int oDQ;
  private String oDR;
  private String oDS;
  String oDT;
  String oDU;
  
  static
  {
    AppMethodBeat.i(50456);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(50456);
  }
  
  protected MMUserAvatarInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(50454);
    this.oDN = new ArrayList();
    ArrayList localArrayList2 = paramParcel.readArrayList(MMUserAvatarItem.class.getClassLoader());
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    this.oDN = localArrayList1;
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.oDO = bool;
      this.oDP = paramParcel.readInt();
      this.oDQ = paramParcel.readInt();
      this.oDR = paramParcel.readString();
      this.oDS = paramParcel.readString();
      this.oDT = paramParcel.readString();
      this.oDU = paramParcel.readString();
      AppMethodBeat.o(50454);
      return;
    }
  }
  
  public MMUserAvatarInfo(eyy parameyy)
  {
    AppMethodBeat.i(50455);
    this.oDN = new ArrayList();
    Iterator localIterator = parameyy.TLd.iterator();
    while (localIterator.hasNext())
    {
      eyz localeyz = (eyz)localIterator.next();
      ArrayList localArrayList = this.oDN;
      if (localArrayList == null) {
        p.iCn();
      }
      p.j(localeyz, "item");
      localArrayList.add(new MMUserAvatarItem(localeyz));
    }
    this.oDO = parameyy.oDO;
    this.oDP = parameyy.oDP;
    this.oDQ = parameyy.oDQ;
    this.oDR = parameyy.oDR;
    this.oDS = parameyy.oDS;
    this.oDT = parameyy.oDT;
    this.oDU = parameyy.oDU;
    AppMethodBeat.o(50455);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50453);
    p.k(paramParcel, "dest");
    paramParcel.writeList((List)this.oDN);
    if (this.oDO) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.oDP);
      paramParcel.writeInt(this.oDQ);
      paramParcel.writeString(this.oDR);
      paramParcel.writeString(this.oDS);
      paramParcel.writeString(this.oDT);
      paramParcel.writeString(this.oDU);
      AppMethodBeat.o(50453);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "item", "Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;)V", "avatarurl", "", "getAvatarurl", "()Ljava/lang/String;", "setAvatarurl", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "id", "", "getId", "()I", "setId", "(I)V", "nickname", "getNickname", "setNickname", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  public static final class MMUserAvatarItem
    implements Parcelable
  {
    public static final a CREATOR;
    String desc;
    int id;
    String nickname;
    String oDV;
    
    static
    {
      AppMethodBeat.i(50452);
      CREATOR = new a((byte)0);
      AppMethodBeat.o(50452);
    }
    
    protected MMUserAvatarItem(Parcel paramParcel)
    {
      AppMethodBeat.i(50450);
      this.nickname = "";
      this.oDV = "";
      this.id = paramParcel.readInt();
      this.nickname = String.valueOf(paramParcel.readString());
      this.oDV = String.valueOf(paramParcel.readString());
      this.desc = paramParcel.readString();
      AppMethodBeat.o(50450);
    }
    
    public MMUserAvatarItem(eyz parameyz)
    {
      AppMethodBeat.i(50451);
      this.nickname = "";
      this.oDV = "";
      this.id = parameyz.id;
      String str = parameyz.nickname;
      p.j(str, "item.nickname");
      this.nickname = str;
      str = parameyz.oDV;
      p.j(str, "item.avatarurl");
      this.oDV = str;
      this.desc = parameyz.desc;
      AppMethodBeat.o(50451);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50449);
      p.k(paramParcel, "dest");
      paramParcel.writeInt(this.id);
      paramParcel.writeString(this.nickname);
      paramParcel.writeString(this.oDV);
      paramParcel.writeString(this.desc);
      AppMethodBeat.o(50449);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<MMUserAvatarInfo.MMUserAvatarItem>
    {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<MMUserAvatarInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo
 * JD-Core Version:    0.7.0.1
 */