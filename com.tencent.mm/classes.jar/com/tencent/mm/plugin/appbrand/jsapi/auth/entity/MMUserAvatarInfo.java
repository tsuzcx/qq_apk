package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fur;
import com.tencent.mm.protocal.protobuf.fus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "avatar_info", "Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;)V", "scopeDesc", "", "bottom_desc", "item_title", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "avatar_limit", "", "getAvatar_limit", "()I", "setAvatar_limit", "(I)V", "avatar_list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/MMUserAvatarInfo$MMUserAvatarItem;", "getAvatar_list", "()Ljava/util/ArrayList;", "setAvatar_list", "(Ljava/util/ArrayList;)V", "avatar_wording", "getAvatar_wording", "()Ljava/lang/String;", "setAvatar_wording", "(Ljava/lang/String;)V", "getBottom_desc", "setBottom_desc", "default_avatar_id", "getDefault_avatar_id", "setDefault_avatar_id", "default_headimg_fileid", "getDefault_headimg_fileid", "setDefault_headimg_fileid", "default_headimg_url", "getDefault_headimg_url", "setDefault_headimg_url", "is_ban_modify_avatar", "", "()Z", "set_ban_modify_avatar", "(Z)V", "getItem_title", "setItem_title", "limit_wording", "getLimit_wording", "setLimit_wording", "scope_sec_desc", "getScope_sec_desc", "setScope_sec_desc", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "MMUserAvatarItem", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMUserAvatarInfo
  implements Parcelable
{
  public static final MMUserAvatarInfo.a CREATOR;
  ArrayList<MMUserAvatarInfo.MMUserAvatarItem> rGX;
  boolean rGY;
  int rGZ;
  public int rHa;
  private String rHb;
  private String rHc;
  String rHd;
  String rHe;
  public String rHf;
  public String rHg;
  public String rHh;
  
  static
  {
    AppMethodBeat.i(50456);
    CREATOR = new MMUserAvatarInfo.a((byte)0);
    AppMethodBeat.o(50456);
  }
  
  protected MMUserAvatarInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(50454);
    this.rGX = new ArrayList();
    ArrayList localArrayList2 = paramParcel.readArrayList(MMUserAvatarInfo.MMUserAvatarItem.class.getClassLoader());
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    this.rGX = localArrayList1;
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.rGY = bool;
      this.rGZ = paramParcel.readInt();
      this.rHa = paramParcel.readInt();
      this.rHb = paramParcel.readString();
      this.rHc = paramParcel.readString();
      this.rHd = paramParcel.readString();
      this.rHe = paramParcel.readString();
      this.rHf = paramParcel.readString();
      this.rHg = paramParcel.readString();
      this.rHh = paramParcel.readString();
      AppMethodBeat.o(50454);
      return;
    }
  }
  
  public MMUserAvatarInfo(fur paramfur)
  {
    this(paramfur, "", "", "");
    AppMethodBeat.i(50455);
    AppMethodBeat.o(50455);
  }
  
  public MMUserAvatarInfo(fur paramfur, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(326958);
    this.rGX = new ArrayList();
    Iterator localIterator = paramfur.abaX.iterator();
    while (localIterator.hasNext())
    {
      fus localfus = (fus)localIterator.next();
      ArrayList localArrayList = this.rGX;
      s.checkNotNull(localArrayList);
      s.s(localfus, "item");
      localArrayList.add(new MMUserAvatarInfo.MMUserAvatarItem(localfus));
    }
    this.rGY = paramfur.rGY;
    this.rGZ = paramfur.rGZ;
    this.rHa = paramfur.rHa;
    this.rHb = paramfur.rHb;
    this.rHc = paramfur.rHc;
    this.rHd = paramfur.rHd;
    this.rHe = paramfur.rHe;
    paramfur = paramString2;
    if (paramString2 == null) {
      paramfur = "";
    }
    this.rHf = paramfur;
    paramfur = paramString1;
    if (paramString1 == null) {
      paramfur = "";
    }
    this.rHg = paramfur;
    paramfur = paramString3;
    if (paramString3 == null) {
      paramfur = "";
    }
    this.rHh = paramfur;
    AppMethodBeat.o(326958);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(50453);
    s.u(paramParcel, "dest");
    paramParcel.writeList((List)this.rGX);
    if (this.rGY) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeInt(this.rGZ);
      paramParcel.writeInt(this.rHa);
      paramParcel.writeString(this.rHb);
      paramParcel.writeString(this.rHc);
      paramParcel.writeString(this.rHd);
      paramParcel.writeString(this.rHe);
      paramParcel.writeString(this.rHf);
      paramParcel.writeString(this.rHg);
      paramParcel.writeString(this.rHh);
      AppMethodBeat.o(50453);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo
 * JD-Core Version:    0.7.0.1
 */