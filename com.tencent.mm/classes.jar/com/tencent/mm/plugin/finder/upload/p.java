package com.tencent.mm.plugin.finder.upload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjk;
import java.util.ArrayList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/HoldingPostData;", "", "mediaType", "", "description", "", "localContent", "Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "location", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "extendedReading", "Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "originalFlag", "refFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "isFromCamera", "", "videoPathBeforeCut", "atContactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderAtContact;", "isLongVideo", "isNewsFeed", "fromAppInfo", "Lcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;", "remoteUrl", "paramsJson", "sdkShareType", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "(ILjava/lang/String;Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;Lcom/tencent/mm/protocal/protobuf/FinderLocation;Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;ILcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;ZLjava/lang/String;Ljava/util/ArrayList;ZZLcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;)V", "getActivityEvent", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "getAtContactList", "()Ljava/util/ArrayList;", "getDescription", "()Ljava/lang/String;", "getExtendedReading", "()Lcom/tencent/mm/protocal/protobuf/FinderExtendedReading;", "getFromAppInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderFromAppInfo;", "()Z", "getLocalContent", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderContent;", "getLocation", "()Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "getMediaType", "()I", "getOriginalFlag", "getParamsJson", "getRefFeed", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRemoteUrl", "getSdkShareType", "getVideoPathBeforeCut", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-finder_release"})
public final class p
{
  final String description;
  public final boolean isLongVideo;
  final axt location;
  public final int mediaType;
  final int originalFlag;
  public final int sdkShareType;
  final String tsW;
  final String tsX;
  final boolean vTA;
  final String vTB;
  final ArrayList<cjj> vTC;
  final boolean vTD;
  final arm vTE;
  final azs vTF;
  final cjk vTx;
  final aqp vTy;
  final azy vTz;
  
  public p(int paramInt1, String paramString1, cjk paramcjk, axt paramaxt, aqp paramaqp, int paramInt2, azy paramazy, boolean paramBoolean1, String paramString2, ArrayList<cjj> paramArrayList, boolean paramBoolean2, boolean paramBoolean3, arm paramarm, String paramString3, String paramString4, int paramInt3, azs paramazs)
  {
    AppMethodBeat.i(253135);
    this.mediaType = paramInt1;
    this.description = paramString1;
    this.vTx = paramcjk;
    this.location = paramaxt;
    this.vTy = paramaqp;
    this.originalFlag = paramInt2;
    this.vTz = paramazy;
    this.vTA = paramBoolean1;
    this.vTB = paramString2;
    this.vTC = paramArrayList;
    this.isLongVideo = paramBoolean2;
    this.vTD = paramBoolean3;
    this.vTE = paramarm;
    this.tsW = paramString3;
    this.tsX = paramString4;
    this.sdkShareType = paramInt3;
    this.vTF = paramazs;
    AppMethodBeat.o(253135);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(253138);
    if (this != paramObject)
    {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if ((this.mediaType != paramObject.mediaType) || (!kotlin.g.b.p.j(this.description, paramObject.description)) || (!kotlin.g.b.p.j(this.vTx, paramObject.vTx)) || (!kotlin.g.b.p.j(this.location, paramObject.location)) || (!kotlin.g.b.p.j(this.vTy, paramObject.vTy)) || (this.originalFlag != paramObject.originalFlag) || (!kotlin.g.b.p.j(this.vTz, paramObject.vTz)) || (this.vTA != paramObject.vTA) || (!kotlin.g.b.p.j(this.vTB, paramObject.vTB)) || (!kotlin.g.b.p.j(this.vTC, paramObject.vTC)) || (this.isLongVideo != paramObject.isLongVideo) || (this.vTD != paramObject.vTD) || (!kotlin.g.b.p.j(this.vTE, paramObject.vTE)) || (!kotlin.g.b.p.j(this.tsW, paramObject.tsW)) || (!kotlin.g.b.p.j(this.tsX, paramObject.tsX)) || (this.sdkShareType != paramObject.sdkShareType) || (!kotlin.g.b.p.j(this.vTF, paramObject.vTF))) {}
      }
    }
    else
    {
      AppMethodBeat.o(253138);
      return true;
    }
    AppMethodBeat.o(253138);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(253136);
    String str = "HoldingPostData(mediaType=" + this.mediaType + ", description=" + this.description + ", localContent=" + this.vTx + ", location=" + this.location + ", extendedReading=" + this.vTy + ", originalFlag=" + this.originalFlag + ", refFeed=" + this.vTz + ", isFromCamera=" + this.vTA + ", videoPathBeforeCut=" + this.vTB + ", atContactList=" + this.vTC + ", isLongVideo=" + this.isLongVideo + ", isNewsFeed=" + this.vTD + ", fromAppInfo=" + this.vTE + ", remoteUrl=" + this.tsW + ", paramsJson=" + this.tsX + ", sdkShareType=" + this.sdkShareType + ", activityEvent=" + this.vTF + ")";
    AppMethodBeat.o(253136);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.p
 * JD-Core Version:    0.7.0.1
 */