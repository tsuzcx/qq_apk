package com.tencent.mm.plugin.finder.live.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.ayj;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.protocal.protobuf.bda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "bindShop", "", "getBindShop", "()Z", "setBindShop", "(Z)V", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "contextId", "", "getContextId", "()Ljava/lang/String;", "setContextId", "(Ljava/lang/String;)V", "curPos", "getCurPos", "setCurPos", "extFlag", "getExtFlag", "setExtFlag", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getFinderLiveNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setFinderLiveNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "finderLiveTaskInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLocalTaskInfo;", "getFinderLiveTaskInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLocalTaskInfo;", "setFinderLiveTaskInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLocalTaskInfo;)V", "lastChosenTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLastChosenTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setLastChosenTagInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "getLbsTabTipsInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "setLbsTabTipsInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;)V", "liveConfigList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/api/LiveConfig;", "Lkotlin/collections/ArrayList;", "getLiveConfigList", "()Ljava/util/ArrayList;", "setLiveConfigList", "(Ljava/util/ArrayList;)V", "luckyMoneyConfig", "", "getLuckyMoneyConfig", "()[B", "setLuckyMoneyConfig", "([B)V", "maxVisibleRoomCount", "getMaxVisibleRoomCount", "setMaxVisibleRoomCount", "maxVisibleUserCount", "getMaxVisibleUserCount", "setMaxVisibleUserCount", "nicknameOption", "getNicknameOption", "setNicknameOption", "pullMoreType", "getPullMoreType", "setPullMoreType", "secondaryDeviceFlag", "getSecondaryDeviceFlag", "setSecondaryDeviceFlag", "tabType", "getTabType", "setTabType", "tagInfo", "Ljava/util/LinkedList;", "getTagInfo", "()Ljava/util/LinkedList;", "setTagInfo", "(Ljava/util/LinkedList;)V", "targetFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTargetFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setTargetFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "visitorWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getVisitorWhiteList", "setVisitorWhiteList", "checkPullMoreTypeFromIntent", "", "intent", "Landroid/content/Intent;", "curLiveConfig", "describeContents", "getLiveIdList", "toString", "writeToParcel", "dest", "flags", "CREATOR", "plugin-finder-base_release"})
public final class FinderLiveBundle
  implements Parcelable
{
  public static final a CREATOR;
  public int extFlag;
  public int fEH;
  private String kiv;
  public String wmL;
  public bbh xPy;
  public LinkedList<ayj> xQn;
  public awq xdb;
  public int xkX;
  public int yeA;
  public boolean yeB;
  public ArrayList<LiveConfig> yeC;
  public bai yeD;
  public int yeE;
  public LinkedList<bda> yeF;
  public bda yeG;
  public int yeH;
  public int yeI;
  public int yeJ;
  public byte[] yeK;
  public FinderObject yeL;
  
  static
  {
    AppMethodBeat.i(259578);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(259578);
  }
  
  public FinderLiveBundle()
  {
    AppMethodBeat.i(259574);
    this.fEH = -1;
    this.yeC = new ArrayList();
    this.yeE = -1;
    this.yeH = -1;
    this.kiv = "";
    AppMethodBeat.o(259574);
  }
  
  public FinderLiveBundle(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(259576);
    this.yeA = paramParcel.readInt();
    Object localObject3;
    Object localObject1;
    int i;
    if (paramParcel.readInt() == 1)
    {
      this.yeB = bool;
      this.fEH = paramParcel.readInt();
      this.xkX = paramParcel.readInt();
      paramParcel.readTypedList((List)this.yeC, LiveConfig.CREATOR);
      this.yeE = paramParcel.readInt();
      this.yeH = paramParcel.readInt();
      this.yeI = paramParcel.readInt();
      this.yeJ = paramParcel.readInt();
      localObject3 = paramParcel.readString();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
      this.kiv = ((String)localObject1);
      i = paramParcel.readInt();
      if (i > 0) {
        break label182;
      }
      localObject1 = null;
      label140:
      this.xdb = ((awq)localObject1);
      this.wmL = paramParcel.readString();
      i = paramParcel.readInt();
      if (i > 0) {
        break label213;
      }
      paramParcel = localObject2;
    }
    for (;;)
    {
      this.yeL = paramParcel;
      AppMethodBeat.o(259576);
      return;
      bool = false;
      break;
      label182:
      localObject3 = new byte[i];
      paramParcel.readByteArray((byte[])localObject3);
      localObject1 = new awq();
      ((awq)localObject1).parseFrom((byte[])localObject3);
      break label140;
      label213:
      localObject1 = new byte[i];
      paramParcel.readByteArray((byte[])localObject1);
      paramParcel = new FinderObject();
      paramParcel.parseFrom((byte[])localObject1);
    }
  }
  
  private final String dyl()
  {
    AppMethodBeat.i(259571);
    int i = this.yeC.size();
    if (i <= 0)
    {
      AppMethodBeat.o(259571);
      return "empty";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("count:" + i + ' ');
    Object localObject = (Iterable)this.yeC;
    i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      LiveConfig localLiveConfig = (LiveConfig)localObject;
      StringBuilder localStringBuilder = new StringBuilder("##live_").append(i).append(":username:");
      if (localLiveConfig != null)
      {
        localObject = localLiveConfig.aJk();
        label143:
        localStringBuilder = localStringBuilder.append((String)localObject).append(",liveId:");
        if (localLiveConfig == null) {
          break label316;
        }
        localObject = Long.valueOf(localLiveConfig.getLiveId());
        label171:
        localStringBuilder = localStringBuilder.append(((Long)localObject).longValue()).append(", nick:");
        if (localLiveConfig == null) {
          break label321;
        }
        localObject = localLiveConfig.aJs();
        label199:
        localStringBuilder = localStringBuilder.append((String)localObject).append(" desc:");
        if (localLiveConfig == null) {
          break label326;
        }
        localObject = localLiveConfig.getDesc();
        label224:
        localStringBuilder = localStringBuilder.append((String)localObject).append(" sessionBuffer:");
        if (localLiveConfig == null) {
          break label331;
        }
        localObject = localLiveConfig.getSessionBuffer();
        if (localObject == null) {
          break label331;
        }
        localObject = d.am((String)localObject, 10);
        label260:
        localStringBuilder = localStringBuilder.append((String)localObject).append("...,streamUrl:");
        if (localLiveConfig == null) {
          break label336;
        }
      }
      label316:
      label321:
      label326:
      label331:
      label336:
      for (localObject = localLiveConfig.aJl();; localObject = null)
      {
        localStringBuffer.append((String)localObject + ';');
        i += 1;
        break;
        localObject = null;
        break label143;
        localObject = null;
        break label171;
        localObject = null;
        break label199;
        localObject = null;
        break label224;
        localObject = null;
        break label260;
      }
    }
    localObject = localStringBuffer.toString();
    p.j(localObject, "StringBuffer().also {\n  …   }\n        }.toString()");
    AppMethodBeat.o(259571);
    return localObject;
  }
  
  public final void aCa(String paramString)
  {
    AppMethodBeat.i(259557);
    p.k(paramString, "<set-?>");
    this.kiv = paramString;
    AppMethodBeat.o(259557);
  }
  
  public final void ae(ArrayList<LiveConfig> paramArrayList)
  {
    AppMethodBeat.i(259555);
    p.k(paramArrayList, "<set-?>");
    this.yeC = paramArrayList;
    AppMethodBeat.o(259555);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final LiveConfig dyk()
  {
    AppMethodBeat.i(259560);
    LiveConfig localLiveConfig = (LiveConfig)j.M((List)this.yeC, this.yeA);
    AppMethodBeat.o(259560);
    return localLiveConfig;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(259568);
    Object localObject = new StringBuilder("FinderLiveConfig:").append("[tabType:" + this.fEH + ",commentScene:" + this.xkX + ",curPos:" + this.yeA + ",bindShop:" + this.yeB + ",nicknameOption:" + this.kiv + " dataList:" + dyl() + ",pullMoreType:" + this.yeH + ']');
    p.j(localObject, "StringBuilder(\"FinderLiv…reType:${pullMoreType}]\")");
    localObject = ((StringBuilder)localObject).toString();
    p.j(localObject, "sb.toString()");
    AppMethodBeat.o(259568);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(259564);
    if (paramParcel != null) {
      paramParcel.writeInt(this.yeA);
    }
    Object localObject;
    if (paramParcel != null)
    {
      if (this.yeB)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
      }
    }
    else
    {
      if (paramParcel != null) {
        paramParcel.writeInt(this.fEH);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.xkX);
      }
      if (paramParcel != null) {
        paramParcel.writeTypedList((List)this.yeC);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.yeE);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.yeH);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.yeI);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.yeJ);
      }
      if (paramParcel != null)
      {
        String str = this.kiv;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramParcel.writeString((String)localObject);
      }
      if (paramParcel != null)
      {
        localObject = this.xdb;
        if (localObject == null) {
          break label231;
        }
        localObject = ((awq)localObject).toByteArray();
        paramParcel.writeInt(localObject.length);
        paramParcel.writeByteArray((byte[])localObject);
      }
    }
    for (;;)
    {
      if (paramParcel != null) {
        paramParcel.writeString(this.wmL);
      }
      if (paramParcel == null) {
        break label244;
      }
      localObject = this.yeL;
      if (localObject == null) {
        break label239;
      }
      localObject = ((FinderObject)localObject).toByteArray();
      paramParcel.writeInt(localObject.length);
      paramParcel.writeByteArray((byte[])localObject);
      AppMethodBeat.o(259564);
      return;
      paramInt = 0;
      break;
      label231:
      paramParcel.writeInt(0);
    }
    label239:
    paramParcel.writeInt(0);
    label244:
    AppMethodBeat.o(259564);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "()V", "PULL_MORE_TYPE_SIMILAR", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "plugin-finder-base_release"})
  public static final class a
    implements Parcelable.Creator<FinderLiveBundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.FinderLiveBundle
 * JD-Core Version:    0.7.0.1
 */