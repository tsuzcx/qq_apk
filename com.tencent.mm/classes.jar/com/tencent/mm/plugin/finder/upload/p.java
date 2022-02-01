package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.ayb;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.djh;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "", "mediaType", "", "description", "", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "isLongVideo", "isNewsFeed", "fromAppInfo", "Lcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;", "remoteUrl", "paramsJson", "sdkShareType", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "draftFinderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "videoTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "reportInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGeneralReportInfo;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;IZLjava/lang/String;Ljava/util/ArrayList;ZZLcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/util/LinkedList;Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;Lcom/tencent/mm/protocal/protobuf/FinderGeneralReportInfo;)V", "getActivityEvent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "getAtContactList", "()Ljava/util/ArrayList;", "getDescription", "()Ljava/lang/String;", "draftEventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getDraftEventInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "setDraftEventInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;)V", "getDraftFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getExtendedReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "getFromAppInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;", "()Z", "getJumpInfoList", "()Ljava/util/LinkedList;", "getLocalContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getMediaType", "()I", "getOriginalFlag", "getParamsJson", "getRemoteUrl", "getReportInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderGeneralReportInfo;", "setReportInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderGeneralReportInfo;)V", "getSdkShareType", "getVideoPathBeforeCut", "getVideoTemplateInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  public final String AyS;
  public final String AyT;
  public ayb GcA;
  public awt GcB;
  public final djh Gcp;
  public final axa Gcq;
  public final boolean Gcr;
  public final String Gcs;
  public final ArrayList<djg> Gct;
  public final boolean Gcu;
  public final axw Gcv;
  public final brg Gcw;
  public final FinderItem Gcx;
  public final LinkedList<FinderJumpInfo> Gcy;
  public final byy Gcz;
  public final String description;
  public final boolean isLongVideo;
  public final boi location;
  public final int mediaType;
  public final int originalFlag;
  public final int sdkShareType;
  
  public p(int paramInt1, String paramString1, djh paramdjh, boi paramboi, axa paramaxa, int paramInt2, boolean paramBoolean1, String paramString2, ArrayList<djg> paramArrayList, boolean paramBoolean2, boolean paramBoolean3, axw paramaxw, String paramString3, String paramString4, int paramInt3, brg parambrg, FinderItem paramFinderItem, LinkedList<FinderJumpInfo> paramLinkedList, byy parambyy, ayb paramayb)
  {
    AppMethodBeat.i(342964);
    this.mediaType = paramInt1;
    this.description = paramString1;
    this.Gcp = paramdjh;
    this.location = paramboi;
    this.Gcq = paramaxa;
    this.originalFlag = paramInt2;
    this.Gcr = paramBoolean1;
    this.Gcs = paramString2;
    this.Gct = paramArrayList;
    this.isLongVideo = paramBoolean2;
    this.Gcu = paramBoolean3;
    this.Gcv = paramaxw;
    this.AyS = paramString3;
    this.AyT = paramString4;
    this.sdkShareType = paramInt3;
    this.Gcw = parambrg;
    this.Gcx = paramFinderItem;
    this.Gcy = paramLinkedList;
    this.Gcz = parambyy;
    this.GcA = paramayb;
    AppMethodBeat.o(342964);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(342977);
    if (this == paramObject)
    {
      AppMethodBeat.o(342977);
      return true;
    }
    if (!(paramObject instanceof p))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    paramObject = (p)paramObject;
    if (this.mediaType != paramObject.mediaType)
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.description, paramObject.description))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.Gcp, paramObject.Gcp))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.location, paramObject.location))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.Gcq, paramObject.Gcq))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (this.originalFlag != paramObject.originalFlag)
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (this.Gcr != paramObject.Gcr)
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.Gcs, paramObject.Gcs))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.Gct, paramObject.Gct))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (this.isLongVideo != paramObject.isLongVideo)
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (this.Gcu != paramObject.Gcu)
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.Gcv, paramObject.Gcv))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.AyS, paramObject.AyS))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.AyT, paramObject.AyT))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (this.sdkShareType != paramObject.sdkShareType)
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.Gcw, paramObject.Gcw))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.Gcx, paramObject.Gcx))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.Gcy, paramObject.Gcy))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.Gcz, paramObject.Gcz))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    if (!s.p(this.GcA, paramObject.GcA))
    {
      AppMethodBeat.o(342977);
      return false;
    }
    AppMethodBeat.o(342977);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(342967);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HoldingPostData(mediaType=").append(this.mediaType).append(", description=").append(this.description).append(", localContent=").append(this.Gcp).append(", location=").append(this.location).append(", extendedReading=").append(this.Gcq).append(", originalFlag=").append(this.originalFlag).append(", isFromCamera=").append(this.Gcr).append(", videoPathBeforeCut=").append(this.Gcs).append(", atContactList=").append(this.Gct).append(", isLongVideo=").append(this.isLongVideo).append(", isNewsFeed=").append(this.Gcu).append(", fromAppInfo=");
    ((StringBuilder)localObject).append(this.Gcv).append(", remoteUrl=").append(this.AyS).append(", paramsJson=").append(this.AyT).append(", sdkShareType=").append(this.sdkShareType).append(", activityEvent=").append(this.Gcw).append(", draftFinderItem=").append(this.Gcx).append(", jumpInfoList=").append(this.Gcy).append(", videoTemplateInfo=").append(this.Gcz).append(", reportInfo=").append(this.GcA).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(342967);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.p
 * JD-Core Version:    0.7.0.1
 */