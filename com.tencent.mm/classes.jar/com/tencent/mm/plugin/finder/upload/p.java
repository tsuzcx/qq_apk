package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.asl;
import com.tencent.mm.protocal.protobuf.ati;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.csf;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "", "mediaType", "", "description", "", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "isLongVideo", "isNewsFeed", "fromAppInfo", "Lcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;", "remoteUrl", "paramsJson", "sdkShareType", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;ILcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;ZLjava/lang/String;Ljava/util/ArrayList;ZZLcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;)V", "getActivityEvent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "getAtContactList", "()Ljava/util/ArrayList;", "getDescription", "()Ljava/lang/String;", "getExtendedReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "getFromAppInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;", "()Z", "getLocalContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getMediaType", "()I", "getOriginalFlag", "getParamsJson", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRemoteUrl", "getSdkShareType", "getVideoPathBeforeCut", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class p
{
  final csf ABa;
  final asl ABb;
  final bge ABc;
  final boolean ABd;
  final String ABe;
  final ArrayList<cse> ABf;
  final boolean ABg;
  final ati ABh;
  final bfv ABi;
  final String description;
  public final boolean isLongVideo;
  final bdm location;
  public final int mediaType;
  final int originalFlag;
  public final int sdkShareType;
  final String xaL;
  final String xaM;
  
  public p(int paramInt1, String paramString1, csf paramcsf, bdm parambdm, asl paramasl, int paramInt2, bge parambge, boolean paramBoolean1, String paramString2, ArrayList<cse> paramArrayList, boolean paramBoolean2, boolean paramBoolean3, ati paramati, String paramString3, String paramString4, int paramInt3, bfv parambfv)
  {
    AppMethodBeat.i(278760);
    this.mediaType = paramInt1;
    this.description = paramString1;
    this.ABa = paramcsf;
    this.location = parambdm;
    this.ABb = paramasl;
    this.originalFlag = paramInt2;
    this.ABc = parambge;
    this.ABd = paramBoolean1;
    this.ABe = paramString2;
    this.ABf = paramArrayList;
    this.isLongVideo = paramBoolean2;
    this.ABg = paramBoolean3;
    this.ABh = paramati;
    this.xaL = paramString3;
    this.xaM = paramString4;
    this.sdkShareType = paramInt3;
    this.ABi = parambfv;
    AppMethodBeat.o(278760);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(278764);
    if (this != paramObject)
    {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if ((this.mediaType != paramObject.mediaType) || (!kotlin.g.b.p.h(this.description, paramObject.description)) || (!kotlin.g.b.p.h(this.ABa, paramObject.ABa)) || (!kotlin.g.b.p.h(this.location, paramObject.location)) || (!kotlin.g.b.p.h(this.ABb, paramObject.ABb)) || (this.originalFlag != paramObject.originalFlag) || (!kotlin.g.b.p.h(this.ABc, paramObject.ABc)) || (this.ABd != paramObject.ABd) || (!kotlin.g.b.p.h(this.ABe, paramObject.ABe)) || (!kotlin.g.b.p.h(this.ABf, paramObject.ABf)) || (this.isLongVideo != paramObject.isLongVideo) || (this.ABg != paramObject.ABg) || (!kotlin.g.b.p.h(this.ABh, paramObject.ABh)) || (!kotlin.g.b.p.h(this.xaL, paramObject.xaL)) || (!kotlin.g.b.p.h(this.xaM, paramObject.xaM)) || (this.sdkShareType != paramObject.sdkShareType) || (!kotlin.g.b.p.h(this.ABi, paramObject.ABi))) {}
      }
    }
    else
    {
      AppMethodBeat.o(278764);
      return true;
    }
    AppMethodBeat.o(278764);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(278762);
    String str = "HoldingPostData(mediaType=" + this.mediaType + ", description=" + this.description + ", localContent=" + this.ABa + ", location=" + this.location + ", extendedReading=" + this.ABb + ", originalFlag=" + this.originalFlag + ", refFeed=" + this.ABc + ", isFromCamera=" + this.ABd + ", videoPathBeforeCut=" + this.ABe + ", atContactList=" + this.ABf + ", isLongVideo=" + this.isLongVideo + ", isNewsFeed=" + this.ABg + ", fromAppInfo=" + this.ABh + ", remoteUrl=" + this.xaL + ", paramsJson=" + this.xaM + ", sdkShareType=" + this.sdkShareType + ", activityEvent=" + this.ABi + ")";
    AppMethodBeat.o(278762);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.p
 * JD-Core Version:    0.7.0.1
 */