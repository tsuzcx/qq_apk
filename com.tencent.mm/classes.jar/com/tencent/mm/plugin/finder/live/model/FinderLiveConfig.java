package com.tencent.mm.plugin.finder.live.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axk;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "bindShop", "", "getBindShop", "()Z", "setBindShop", "(Z)V", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "curPos", "getCurPos", "setCurPos", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getFinderLiveNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setFinderLiveNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "lastChosenTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLastChosenTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setLastChosenTagInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "liveConfigList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/api/LiveConfig;", "Lkotlin/collections/ArrayList;", "getLiveConfigList", "()Ljava/util/ArrayList;", "setLiveConfigList", "(Ljava/util/ArrayList;)V", "pullMoreType", "getPullMoreType", "setPullMoreType", "sourceType", "getSourceType", "setSourceType", "tabType", "getTabType", "setTabType", "tagInfo", "Ljava/util/LinkedList;", "getTagInfo", "()Ljava/util/LinkedList;", "setTagInfo", "(Ljava/util/LinkedList;)V", "visitorWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getVisitorWhiteList", "setVisitorWhiteList", "curLiveConfig", "describeContents", "getLiveIdList", "", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "plugin-finder_release"})
public final class FinderLiveConfig
  implements Parcelable
{
  public static final a CREATOR;
  public int dLS;
  public int sourceType;
  public int tCE;
  public LinkedList<avh> ueu;
  public int uis;
  public boolean uit;
  public ArrayList<LiveConfig> uiu;
  public awt uiv;
  public LinkedList<axk> uiw;
  public axk uix;
  public int uiy;
  
  static
  {
    AppMethodBeat.i(246084);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(246084);
  }
  
  public FinderLiveConfig()
  {
    AppMethodBeat.i(246082);
    this.dLS = -1;
    this.uiu = new ArrayList();
    this.sourceType = -1;
    this.uiy = -1;
    AppMethodBeat.o(246082);
  }
  
  public FinderLiveConfig(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(246083);
    this.uis = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.uit = bool;
      this.dLS = paramParcel.readInt();
      this.tCE = paramParcel.readInt();
      paramParcel.readTypedList((List)this.uiu, LiveConfig.CREATOR);
      this.sourceType = paramParcel.readInt();
      this.uiy = paramParcel.readInt();
      AppMethodBeat.o(246083);
      return;
      bool = false;
    }
  }
  
  private final String dfv()
  {
    AppMethodBeat.i(246081);
    int j = this.uiu.size();
    if (j <= 0)
    {
      AppMethodBeat.o(246081);
      return "empty";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < j)
    {
      localObject1 = new StringBuilder("live_").append(i).append(":username:");
      Object localObject2 = this.uiu.get(i);
      p.g(localObject2, "liveConfigList[index]");
      localObject1 = ((StringBuilder)localObject1).append(((LiveConfig)localObject2).aBG()).append(",liveId:");
      localObject2 = this.uiu.get(i);
      p.g(localObject2, "liveConfigList[index]");
      localObject2 = ((StringBuilder)localObject1).append(((LiveConfig)localObject2).getLiveId()).append(",sessionBuffer:");
      localObject1 = (LiveConfig)this.uiu.get(i);
      if (localObject1 != null) {}
      for (localObject1 = ((LiveConfig)localObject1).getSessionBuffer();; localObject1 = null)
      {
        localStringBuilder.append((String)localObject1 + ';');
        i += 1;
        break;
      }
    }
    Object localObject1 = localStringBuilder.toString();
    p.g(localObject1, "sb.toString()");
    AppMethodBeat.o(246081);
    return localObject1;
  }
  
  public final void ac(ArrayList<LiveConfig> paramArrayList)
  {
    AppMethodBeat.i(246077);
    p.h(paramArrayList, "<set-?>");
    this.uiu = paramArrayList;
    AppMethodBeat.o(246077);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final LiveConfig dfu()
  {
    AppMethodBeat.i(246078);
    LiveConfig localLiveConfig = (LiveConfig)j.L((List)this.uiu, this.uis);
    AppMethodBeat.o(246078);
    return localLiveConfig;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246080);
    Object localObject = new StringBuilder("FinderLiveConfig:").append("[tabType:" + this.dLS + ",commentScene:" + this.tCE + ",curPos:" + this.uis + ",bindShop:" + this.uit + ",data:" + dfv() + ']');
    p.g(localObject, "StringBuilder(\"FinderLiv…ata:${getLiveIdList()}]\")");
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(246080);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(246079);
    if (paramParcel != null) {
      paramParcel.writeInt(this.uis);
    }
    if (paramParcel != null) {
      if (!this.uit) {
        break label106;
      }
    }
    label106:
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if (paramParcel != null) {
        paramParcel.writeInt(this.dLS);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.tCE);
      }
      if (paramParcel != null) {
        paramParcel.writeTypedList((List)this.uiu);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.sourceType);
      }
      if (paramParcel == null) {
        break;
      }
      paramParcel.writeInt(this.uiy);
      AppMethodBeat.o(246079);
      return;
    }
    AppMethodBeat.o(246079);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "()V", "PULL_MORE_TYPE_SIMILAR", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "plugin-finder_release"})
  public static final class a
    implements Parcelable.Creator<FinderLiveConfig>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.FinderLiveConfig
 * JD-Core Version:    0.7.0.1
 */