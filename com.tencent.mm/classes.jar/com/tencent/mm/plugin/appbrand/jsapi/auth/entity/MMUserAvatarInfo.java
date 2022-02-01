package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.protocal.protobuf.dip;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "avatar_info", "Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;)V", "avatar_limit", "", "getAvatar_limit", "()I", "setAvatar_limit", "(I)V", "avatar_list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "getAvatar_list", "()Ljava/util/ArrayList;", "setAvatar_list", "(Ljava/util/ArrayList;)V", "avatar_wording", "", "getAvatar_wording", "()Ljava/lang/String;", "setAvatar_wording", "(Ljava/lang/String;)V", "default_avatar_id", "getDefault_avatar_id", "setDefault_avatar_id", "default_headimg_fileid", "getDefault_headimg_fileid", "setDefault_headimg_fileid", "default_headimg_url", "getDefault_headimg_url", "setDefault_headimg_url", "is_ban_modify_avatar", "", "()Z", "set_ban_modify_avatar", "(Z)V", "limit_wording", "getLimit_wording", "setLimit_wording", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "MMUserAvatarItem", "plugin-appbrand-integration_release"})
public final class MMUserAvatarInfo
  implements Parcelable
{
  public static final a CREATOR;
  ArrayList<MMUserAvatarItem> jED;
  boolean jEE;
  int jEF;
  public int jEG;
  private String jEH;
  private String jEI;
  String jEJ;
  String jEK;
  
  static
  {
    AppMethodBeat.i(50456);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(50456);
  }
  
  protected MMUserAvatarInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(50454);
    this.jED = new ArrayList();
    ArrayList localArrayList2 = paramParcel.readArrayList(MMUserAvatarItem.class.getClassLoader());
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    this.jED = localArrayList1;
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jEE = bool;
      this.jEF = paramParcel.readInt();
      this.jEG = paramParcel.readInt();
      this.jEH = paramParcel.readString();
      this.jEI = paramParcel.readString();
      this.jEJ = paramParcel.readString();
      this.jEK = paramParcel.readString();
      AppMethodBeat.o(50454);
      return;
    }
  }
  
  public MMUserAvatarInfo(dio paramdio)
  {
    AppMethodBeat.i(50455);
    this.jED = new ArrayList();
    Iterator localIterator = paramdio.DRp.iterator();
    while (localIterator.hasNext())
    {
      dip localdip = (dip)localIterator.next();
      ArrayList localArrayList = this.jED;
      if (localArrayList == null) {
        k.fvU();
      }
      k.g(localdip, "item");
      localArrayList.add(new MMUserAvatarItem(localdip));
    }
    this.jEE = paramdio.jEE;
    this.jEF = paramdio.jEF;
    this.jEG = paramdio.jEG;
    this.jEH = paramdio.jEH;
    this.jEI = paramdio.jEI;
    this.jEJ = paramdio.jEJ;
    this.jEK = paramdio.jEK;
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
    paramParcel.writeList((List)this.jED);
    if (this.jEE) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.jEF);
      paramParcel.writeInt(this.jEG);
      paramParcel.writeString(this.jEH);
      paramParcel.writeString(this.jEI);
      paramParcel.writeString(this.jEJ);
      paramParcel.writeString(this.jEK);
      AppMethodBeat.o(50453);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "item", "Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;)V", "avatarurl", "", "getAvatarurl", "()Ljava/lang/String;", "setAvatarurl", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "id", "", "getId", "()I", "setId", "(I)V", "nickname", "getNickname", "setNickname", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-appbrand-integration_release"})
  public static final class MMUserAvatarItem
    implements Parcelable
  {
    public static final a CREATOR;
    String desc;
    int id;
    String jEL;
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
      this.jEL = "";
      this.id = paramParcel.readInt();
      String str = paramParcel.readString();
      k.g(str, "`in`.readString()");
      this.nickname = str;
      str = paramParcel.readString();
      k.g(str, "`in`.readString()");
      this.jEL = str;
      this.desc = paramParcel.readString();
      AppMethodBeat.o(50450);
    }
    
    public MMUserAvatarItem(dip paramdip)
    {
      AppMethodBeat.i(50451);
      this.nickname = "";
      this.jEL = "";
      this.id = paramdip.id;
      String str = paramdip.nickname;
      k.g(str, "item.nickname");
      this.nickname = str;
      str = paramdip.jEL;
      k.g(str, "item.avatarurl");
      this.jEL = str;
      this.desc = paramdip.desc;
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
      paramParcel.writeString(this.jEL);
      paramParcel.writeString(this.desc);
      AppMethodBeat.o(50449);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "plugin-appbrand-integration_release"})
    public static final class a
      implements Parcelable.Creator<MMUserAvatarInfo.MMUserAvatarItem>
    {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "plugin-appbrand-integration_release"})
  public static final class a
    implements Parcelable.Creator<MMUserAvatarInfo>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo
 * JD-Core Version:    0.7.0.1
 */