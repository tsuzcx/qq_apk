package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.eor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "avatar_info", "Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;)V", "avatar_limit", "", "getAvatar_limit", "()I", "setAvatar_limit", "(I)V", "avatar_list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "getAvatar_list", "()Ljava/util/ArrayList;", "setAvatar_list", "(Ljava/util/ArrayList;)V", "avatar_wording", "", "getAvatar_wording", "()Ljava/lang/String;", "setAvatar_wording", "(Ljava/lang/String;)V", "default_avatar_id", "getDefault_avatar_id", "setDefault_avatar_id", "default_headimg_fileid", "getDefault_headimg_fileid", "setDefault_headimg_fileid", "default_headimg_url", "getDefault_headimg_url", "setDefault_headimg_url", "is_ban_modify_avatar", "", "()Z", "set_ban_modify_avatar", "(Z)V", "limit_wording", "getLimit_wording", "setLimit_wording", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "MMUserAvatarItem", "plugin-appbrand-integration_release"})
public final class MMUserAvatarInfo
  implements Parcelable
{
  public static final MMUserAvatarInfo.a CREATOR;
  ArrayList<MMUserAvatarInfo.MMUserAvatarItem> lHE;
  boolean lHF;
  int lHG;
  public int lHH;
  private String lHI;
  private String lHJ;
  String lHK;
  String lHL;
  
  static
  {
    AppMethodBeat.i(50456);
    CREATOR = new MMUserAvatarInfo.a((byte)0);
    AppMethodBeat.o(50456);
  }
  
  protected MMUserAvatarInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(50454);
    this.lHE = new ArrayList();
    ArrayList localArrayList2 = paramParcel.readArrayList(MMUserAvatarInfo.MMUserAvatarItem.class.getClassLoader());
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    this.lHE = localArrayList1;
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.lHF = bool;
      this.lHG = paramParcel.readInt();
      this.lHH = paramParcel.readInt();
      this.lHI = paramParcel.readString();
      this.lHJ = paramParcel.readString();
      this.lHK = paramParcel.readString();
      this.lHL = paramParcel.readString();
      AppMethodBeat.o(50454);
      return;
    }
  }
  
  public MMUserAvatarInfo(eoq parameoq)
  {
    AppMethodBeat.i(50455);
    this.lHE = new ArrayList();
    Iterator localIterator = parameoq.Mzx.iterator();
    while (localIterator.hasNext())
    {
      eor localeor = (eor)localIterator.next();
      ArrayList localArrayList = this.lHE;
      if (localArrayList == null) {
        p.hyc();
      }
      p.g(localeor, "item");
      localArrayList.add(new MMUserAvatarInfo.MMUserAvatarItem(localeor));
    }
    this.lHF = parameoq.lHF;
    this.lHG = parameoq.lHG;
    this.lHH = parameoq.lHH;
    this.lHI = parameoq.lHI;
    this.lHJ = parameoq.lHJ;
    this.lHK = parameoq.lHK;
    this.lHL = parameoq.lHL;
    AppMethodBeat.o(50455);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50453);
    p.h(paramParcel, "dest");
    paramParcel.writeList((List)this.lHE);
    if (this.lHF) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.lHG);
      paramParcel.writeInt(this.lHH);
      paramParcel.writeString(this.lHI);
      paramParcel.writeString(this.lHJ);
      paramParcel.writeString(this.lHK);
      paramParcel.writeString(this.lHL);
      AppMethodBeat.o(50453);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo
 * JD-Core Version:    0.7.0.1
 */