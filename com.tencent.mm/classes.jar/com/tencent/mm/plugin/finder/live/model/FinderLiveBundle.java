package com.tencent.mm.plugin.finder.live.model;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bfh;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bno;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "bindShop", "", "getBindShop", "()Z", "setBindShop", "(Z)V", "byPassInfo", "Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;", "getByPassInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;", "setByPassInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;)V", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "contextId", "", "getContextId", "()Ljava/lang/String;", "setContextId", "(Ljava/lang/String;)V", "curPos", "getCurPos", "setCurPos", "ecSource", "getEcSource", "setEcSource", "enterScene", "getEnterScene", "setEnterScene", "entranceReportInfo", "Landroid/os/Bundle;", "getEntranceReportInfo", "()Landroid/os/Bundle;", "setEntranceReportInfo", "(Landroid/os/Bundle;)V", "exportIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getExportIdList", "()Ljava/util/ArrayList;", "exportIdMap", "Ljava/util/HashMap;", "", "getExportIdMap", "()Ljava/util/HashMap;", "setExportIdMap", "(Ljava/util/HashMap;)V", "extFlag", "getExtFlag", "setExtFlag", "finderLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getFinderLiveNoticeInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "setFinderLiveNoticeInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;)V", "finderLiveTaskInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLocalTaskInfo;", "getFinderLiveTaskInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLocalTaskInfo;", "setFinderLiveTaskInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLocalTaskInfo;)V", "lastChosenTagInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "getLastChosenTagInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "setLastChosenTagInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "getLbsTabTipsInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "setLbsTabTipsInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;)V", "liveConfigList", "Lcom/tencent/mm/live/api/LiveConfig;", "getLiveConfigList", "setLiveConfigList", "(Ljava/util/ArrayList;)V", "luckyMoneyConfig", "", "getLuckyMoneyConfig", "()[B", "setLuckyMoneyConfig", "([B)V", "maxVisibleRoomCount", "getMaxVisibleRoomCount", "setMaxVisibleRoomCount", "maxVisibleUserCount", "getMaxVisibleUserCount", "setMaxVisibleUserCount", "nicknameOption", "getNicknameOption", "setNicknameOption", "pullMoreType", "getPullMoreType", "setPullMoreType", "secondaryDeviceFlag", "getSecondaryDeviceFlag", "setSecondaryDeviceFlag", "squareExtraInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;", "getSquareExtraInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;", "setSquareExtraInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;)V", "tabType", "getTabType", "setTabType", "tagInfo", "Ljava/util/LinkedList;", "getTagInfo", "()Ljava/util/LinkedList;", "setTagInfo", "(Ljava/util/LinkedList;)V", "targetFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTargetFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setTargetFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "visitorWhiteList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "getVisitorWhiteList", "setVisitorWhiteList", "checkBizInfoIntent", "", "intent", "Landroid/content/Intent;", "liveId", "checkByPassInfoFromIntent", "checkPullMoreTypeFromIntent", "checkSquareExtraInfoFromIntent", "curLiveConfig", "describeContents", "getLiveIdList", "toString", "writeToParcel", "dest", "flags", "CREATOR", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveBundle
  implements Parcelable
{
  public static final a CREATOR;
  public bcl ACt;
  public avb ACu;
  public int AJo;
  public LinkedList<bfh> BpY;
  public bkk Bpo;
  public int CEY;
  public boolean CEZ;
  public ArrayList<LiveConfig> CFa;
  public biz CFb;
  public int CFc;
  public LinkedList<bno> CFd;
  public bno CFe;
  public int CFf;
  public int CFg;
  public int CFh;
  public byte[] CFi;
  public FinderObject CFj;
  public final ArrayList<String> CFk;
  public HashMap<Long, String> CFl;
  public bmx CFm;
  public Bundle CFn;
  String ecSource;
  public int enterScene;
  public int extFlag;
  public int hJx;
  private String mIU;
  public String zIO;
  
  static
  {
    AppMethodBeat.i(359775);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(359775);
  }
  
  public FinderLiveBundle()
  {
    AppMethodBeat.i(359738);
    this.hJx = -1;
    this.CFa = new ArrayList();
    this.CFc = -1;
    this.CFf = -1;
    this.CFk = new ArrayList();
    this.CFl = new HashMap();
    this.mIU = "";
    this.ecSource = "";
    AppMethodBeat.o(359738);
  }
  
  public FinderLiveBundle(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(359756);
    this.CEY = paramParcel.readInt();
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (paramParcel.readInt() == 1)
    {
      bool = true;
      this.CEZ = bool;
      this.hJx = paramParcel.readInt();
      this.AJo = paramParcel.readInt();
      paramParcel.readTypedList((List)this.CFa, LiveConfig.CREATOR);
      this.CFc = paramParcel.readInt();
      this.CFf = paramParcel.readInt();
      this.CFg = paramParcel.readInt();
      this.CFh = paramParcel.readInt();
      localObject2 = paramParcel.readString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.mIU = ((String)localObject1);
      localObject2 = paramParcel.readString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      this.ecSource = ((String)localObject1);
      i = paramParcel.readInt();
      if (i > 0) {
        break label277;
      }
      localObject1 = null;
      label166:
      this.ACt = ((bcl)localObject1);
      this.zIO = paramParcel.readString();
      i = paramParcel.readInt();
      if (i > 0) {
        break label313;
      }
      localObject1 = null;
      label192:
      this.CFj = ((FinderObject)localObject1);
      i = paramParcel.readInt();
      if (i > 0) {
        break label349;
      }
      localObject1 = null;
    }
    for (;;)
    {
      this.ACu = ((avb)localObject1);
      this.enterScene = paramParcel.readInt();
      paramParcel.readStringList((List)this.CFk);
      localObject1 = paramParcel.readHashMap(getClass().getClassLoader());
      if (localObject1 == null)
      {
        paramParcel = new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.Long, kotlin.String>");
        AppMethodBeat.o(359756);
        throw paramParcel;
        bool = false;
        break;
        label277:
        localObject2 = new byte[i];
        paramParcel.readByteArray((byte[])localObject2);
        localObject1 = new bcl();
        ((bcl)localObject1).parseFrom((byte[])localObject2);
        localObject2 = ah.aiuX;
        break label166;
        label313:
        localObject2 = new byte[i];
        paramParcel.readByteArray((byte[])localObject2);
        localObject1 = new FinderObject();
        ((FinderObject)localObject1).parseFrom((byte[])localObject2);
        localObject2 = ah.aiuX;
        break label192;
        label349:
        localObject2 = new byte[i];
        paramParcel.readByteArray((byte[])localObject2);
        localObject1 = new avb();
        a locala2 = (a)localObject1;
        try
        {
          locala2.parseFrom((byte[])localObject2);
          localObject2 = ah.aiuX;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException2 });
          }
        }
      }
    }
    this.CFl = ((HashMap)localObject1);
    int i = paramParcel.readInt();
    if (i <= 0) {
      paramParcel = locala1;
    }
    for (;;)
    {
      this.CFm = paramParcel;
      AppMethodBeat.o(359756);
      return;
      localObject1 = new byte[i];
      paramParcel.readByteArray((byte[])localObject1);
      paramParcel = new bmx();
      locala1 = (a)paramParcel;
      try
      {
        locala1.parseFrom((byte[])localObject1);
        localObject1 = ah.aiuX;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException1 });
        }
      }
    }
  }
  
  private final String ekD()
  {
    AppMethodBeat.i(359766);
    int i = this.CFa.size();
    if (i <= 0)
    {
      AppMethodBeat.o(359766);
      return "empty";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("count:" + i + ' ');
    Object localObject = (Iterable)this.CFa;
    i = 0;
    Iterator localIterator = ((Iterable)localObject).iterator();
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      LiveConfig localLiveConfig = (LiveConfig)localObject;
      StringBuilder localStringBuilder = new StringBuilder("##live_").append(i).append(":username:");
      if (localLiveConfig == null)
      {
        localObject = null;
        label141:
        localStringBuilder = localStringBuilder.append(localObject).append(",liveId:");
        if (localLiveConfig != null) {
          break label281;
        }
        localObject = null;
        label162:
        localStringBuilder = localStringBuilder.append(localObject).append(", nick:");
        if (localLiveConfig != null) {
          break label293;
        }
        localObject = null;
        label183:
        localStringBuilder = localStringBuilder.append(localObject).append(" desc:");
        if (localLiveConfig != null) {
          break label302;
        }
        localObject = null;
        label204:
        localStringBuilder = localStringBuilder.append(localObject).append(" sessionBuffer:");
        if (localLiveConfig != null) {
          break label311;
        }
        localObject = null;
        label225:
        localStringBuilder = localStringBuilder.append(localObject).append("...,streamUrl:");
        if (localLiveConfig != null) {
          break label336;
        }
      }
      label281:
      label293:
      label302:
      label311:
      label336:
      for (localObject = null;; localObject = localLiveConfig.mIE)
      {
        localStringBuffer.append(localObject + ';');
        i += 1;
        break;
        localObject = localLiveConfig.mIC;
        break label141;
        localObject = Long.valueOf(localLiveConfig.liveId);
        break label162;
        localObject = localLiveConfig.mIU;
        break label183;
        localObject = localLiveConfig.desc;
        break label204;
        localObject = localLiveConfig.sessionBuffer;
        if (localObject == null)
        {
          localObject = null;
          break label225;
        }
        localObject = d.av((String)localObject, 10);
        break label225;
      }
    }
    localObject = localStringBuffer.toString();
    s.s(localObject, "StringBuffer().also {\n  …   }\n        }.toString()");
    AppMethodBeat.o(359766);
    return localObject;
  }
  
  public final void ag(ArrayList<LiveConfig> paramArrayList)
  {
    AppMethodBeat.i(359784);
    s.u(paramArrayList, "<set-?>");
    this.CFa = paramArrayList;
    AppMethodBeat.o(359784);
  }
  
  public final void av(Intent paramIntent)
  {
    AppMethodBeat.i(359815);
    int i;
    if (paramIntent == null)
    {
      i = 0;
      if (paramIntent != null) {
        break label68;
      }
      paramIntent = "";
    }
    for (;;)
    {
      Object localObject = new avb();
      ((avb)localObject).ZFr = i;
      ((avb)localObject).ZFs = b.bsj(paramIntent);
      paramIntent = ah.aiuX;
      this.ACu = ((avb)localObject);
      AppMethodBeat.o(359815);
      return;
      i = paramIntent.getIntExtra("key_enter_live_param_by_pass_type", 0);
      break;
      label68:
      localObject = paramIntent.getStringExtra("key_enter_live_param_by_pass_info");
      paramIntent = (Intent)localObject;
      if (localObject == null) {
        paramIntent = "";
      }
    }
  }
  
  public final void awv(String paramString)
  {
    AppMethodBeat.i(359793);
    s.u(paramString, "<set-?>");
    this.mIU = paramString;
    AppMethodBeat.o(359793);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final LiveConfig ekC()
  {
    AppMethodBeat.i(359807);
    LiveConfig localLiveConfig = (LiveConfig)p.ae((List)this.CFa, this.CEY);
    AppMethodBeat.o(359807);
    return localLiveConfig;
  }
  
  public final void setEcSource(String paramString)
  {
    AppMethodBeat.i(359800);
    s.u(paramString, "<set-?>");
    this.ecSource = paramString;
    AppMethodBeat.o(359800);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(359837);
    String str = "FinderLiveConfig:" + new StringBuilder("[tabType:").append(this.hJx).append(",commentScene:").append(this.AJo).append(",curPos:").append(this.CEY).append(",bindShop:").append(this.CEZ).append(",nicknameOption:").append(this.mIU).append(", dataList:").append(ekD()).append(",pullMoreType:").append(this.CFf).toString();
    s.s(str, "sb.toString()");
    AppMethodBeat.o(359837);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(359825);
    if (paramParcel != null) {
      paramParcel.writeInt(this.CEY);
    }
    if (paramParcel != null)
    {
      if (this.CEZ)
      {
        paramInt = 1;
        paramParcel.writeInt(paramInt);
      }
    }
    else
    {
      if (paramParcel != null) {
        paramParcel.writeInt(this.hJx);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.AJo);
      }
      if (paramParcel != null) {
        paramParcel.writeTypedList((List)this.CFa);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.CFc);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.CFf);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.CFg);
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.CFh);
      }
      String str;
      if (paramParcel != null)
      {
        str = this.mIU;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramParcel.writeString((String)localObject);
      }
      if (paramParcel != null)
      {
        str = this.ecSource;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramParcel.writeString((String)localObject);
      }
      if (paramParcel != null)
      {
        localObject = this.ACt;
        if (localObject != null) {
          break label337;
        }
        localObject = null;
        label190:
        if (localObject == null) {
          paramParcel.writeInt(0);
        }
      }
      if (paramParcel != null) {
        paramParcel.writeString(this.zIO);
      }
      if (paramParcel != null)
      {
        localObject = this.CFj;
        if (localObject != null) {
          break label360;
        }
        localObject = null;
        label226:
        if (localObject == null) {
          paramParcel.writeInt(0);
        }
      }
      if (paramParcel != null)
      {
        localObject = this.ACu;
        if (localObject != null) {
          break label383;
        }
        localObject = null;
        label250:
        if (localObject == null) {
          paramParcel.writeInt(0);
        }
      }
      if (paramParcel != null) {
        paramParcel.writeInt(this.enterScene);
      }
      if (paramParcel != null) {
        paramParcel.writeStringList((List)this.CFk);
      }
      if (paramParcel != null) {
        paramParcel.writeMap((Map)this.CFl);
      }
      if (paramParcel != null)
      {
        localObject = this.CFm;
        if (localObject != null) {
          break label406;
        }
      }
    }
    for (Object localObject = null;; localObject = ah.aiuX)
    {
      if (localObject == null) {
        paramParcel.writeInt(0);
      }
      AppMethodBeat.o(359825);
      return;
      paramInt = 0;
      break;
      label337:
      localObject = ((bcl)localObject).toByteArray();
      paramParcel.writeInt(localObject.length);
      paramParcel.writeByteArray((byte[])localObject);
      localObject = ah.aiuX;
      break label190;
      label360:
      localObject = ((FinderObject)localObject).toByteArray();
      paramParcel.writeInt(localObject.length);
      paramParcel.writeByteArray((byte[])localObject);
      localObject = ah.aiuX;
      break label226;
      label383:
      localObject = ((avb)localObject).toByteArray();
      paramParcel.writeInt(localObject.length);
      paramParcel.writeByteArray((byte[])localObject);
      localObject = ah.aiuX;
      break label250;
      label406:
      localObject = ((bmx)localObject).toByteArray();
      paramParcel.writeInt(localObject.length);
      paramParcel.writeByteArray((byte[])localObject);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "()V", "PULL_MORE_TYPE_SIMILAR", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<FinderLiveBundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.FinderLiveBundle
 * JD-Core Version:    0.7.0.1
 */