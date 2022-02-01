package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dod;
import com.tencent.mm.protocal.protobuf.doe;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "avatar_info", "Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;)V", "avatar_limit", "", "getAvatar_limit", "()I", "setAvatar_limit", "(I)V", "avatar_list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "getAvatar_list", "()Ljava/util/ArrayList;", "setAvatar_list", "(Ljava/util/ArrayList;)V", "avatar_wording", "", "getAvatar_wording", "()Ljava/lang/String;", "setAvatar_wording", "(Ljava/lang/String;)V", "default_avatar_id", "getDefault_avatar_id", "setDefault_avatar_id", "default_headimg_fileid", "getDefault_headimg_fileid", "setDefault_headimg_fileid", "default_headimg_url", "getDefault_headimg_url", "setDefault_headimg_url", "is_ban_modify_avatar", "", "()Z", "set_ban_modify_avatar", "(Z)V", "limit_wording", "getLimit_wording", "setLimit_wording", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "MMUserAvatarItem", "plugin-appbrand-integration_release"})
public final class MMUserAvatarInfo
  implements Parcelable
{
  public static final a CREATOR;
  ArrayList<MMUserAvatarItem> kfa;
  boolean kfb;
  int kfc;
  public int kfd;
  private String kfe;
  private String kff;
  String kfg;
  String kfh;
  
  static
  {
    AppMethodBeat.i(50456);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(50456);
  }
  
  protected MMUserAvatarInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(50454);
    this.kfa = new ArrayList();
    ArrayList localArrayList2 = paramParcel.readArrayList(MMUserAvatarItem.class.getClassLoader());
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    this.kfa = localArrayList1;
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.kfb = bool;
      this.kfc = paramParcel.readInt();
      this.kfd = paramParcel.readInt();
      this.kfe = paramParcel.readString();
      this.kff = paramParcel.readString();
      this.kfg = paramParcel.readString();
      this.kfh = paramParcel.readString();
      AppMethodBeat.o(50454);
      return;
    }
  }
  
  public MMUserAvatarInfo(dod paramdod)
  {
    AppMethodBeat.i(50455);
    this.kfa = new ArrayList();
    Iterator localIterator = paramdod.FnH.iterator();
    while (localIterator.hasNext())
    {
      doe localdoe = (doe)localIterator.next();
      ArrayList localArrayList = this.kfa;
      if (localArrayList == null) {
        k.fOy();
      }
      k.g(localdoe, "item");
      localArrayList.add(new MMUserAvatarItem(localdoe));
    }
    this.kfb = paramdod.kfb;
    this.kfc = paramdod.kfc;
    this.kfd = paramdod.kfd;
    this.kfe = paramdod.kfe;
    this.kff = paramdod.kff;
    this.kfg = paramdod.kfg;
    this.kfh = paramdod.kfh;
    AppMethodBeat.o(50455);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50453);
    k.h(paramParcel, "dest");
    paramParcel.writeList((List)this.kfa);
    if (this.kfb) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.kfc);
      paramParcel.writeInt(this.kfd);
      paramParcel.writeString(this.kfe);
      paramParcel.writeString(this.kff);
      paramParcel.writeString(this.kfg);
      paramParcel.writeString(this.kfh);
      AppMethodBeat.o(50453);
      return;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "item", "Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;)V", "avatarurl", "", "getAvatarurl", "()Ljava/lang/String;", "setAvatarurl", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "id", "", "getId", "()I", "setId", "(I)V", "nickname", "getNickname", "setNickname", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  public static final class MMUserAvatarItem
    implements Parcelable
  {
    public static final a CREATOR;
    String desc;
    int id;
    String kfi;
    String nickname;
    
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
      this.kfi = "";
      this.id = paramParcel.readInt();
      String str = paramParcel.readString();
      k.g(str, "`in`.readString()");
      this.nickname = str;
      str = paramParcel.readString();
      k.g(str, "`in`.readString()");
      this.kfi = str;
      this.desc = paramParcel.readString();
      AppMethodBeat.o(50450);
    }
    
    public MMUserAvatarItem(doe paramdoe)
    {
      AppMethodBeat.i(50451);
      this.nickname = "";
      this.kfi = "";
      this.id = paramdoe.id;
      String str = paramdoe.nickname;
      k.g(str, "item.nickname");
      this.nickname = str;
      str = paramdoe.kfi;
      k.g(str, "item.avatarurl");
      this.kfi = str;
      this.desc = paramdoe.desc;
      AppMethodBeat.o(50451);
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(50449);
      k.h(paramParcel, "dest");
      paramParcel.writeInt(this.id);
      paramParcel.writeString(this.nickname);
      paramParcel.writeString(this.kfi);
      paramParcel.writeString(this.desc);
      AppMethodBeat.o(50449);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<MMUserAvatarInfo.MMUserAvatarItem>
    {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<MMUserAvatarInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo
 * JD-Core Version:    0.7.0.1
 */