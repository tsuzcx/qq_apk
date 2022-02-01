package com.tencent.mm.plugin.expt.hellhound.ext.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "", "sessionId", "", "startExposureMs", "", "endExposureMs", "disAppearType", "", "itemExposureAreaWeigth", "", "screenExposureAreaWeigth", "contextId", "scene", "updateTimeMs", "itemExposureTimeMs", "isShowing", "", "x", "y", "height", "width", "position", "itemPosition", "itemPos", "itemArrayIndex", "feedId", "userName", "nickName", "commentCount", "likeCount", "itemBufffer", "(Ljava/lang/String;JJIFFLjava/lang/String;IJJZIIFFIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getCommentCount", "()I", "setCommentCount", "(I)V", "getContextId", "()Ljava/lang/String;", "setContextId", "(Ljava/lang/String;)V", "getDisAppearType", "setDisAppearType", "getEndExposureMs", "()J", "setEndExposureMs", "(J)V", "getFeedId", "setFeedId", "getHeight", "()F", "setHeight", "(F)V", "()Z", "setShowing", "(Z)V", "getItemArrayIndex", "setItemArrayIndex", "getItemBufffer", "setItemBufffer", "getItemExposureAreaWeigth", "setItemExposureAreaWeigth", "getItemExposureTimeMs", "setItemExposureTimeMs", "getItemPos", "setItemPos", "getItemPosition", "setItemPosition", "getLikeCount", "setLikeCount", "getNickName", "setNickName", "getPosition", "setPosition", "getScene", "setScene", "getScreenExposureAreaWeigth", "setScreenExposureAreaWeigth", "getSessionId", "setSessionId", "getStartExposureMs", "setStartExposureMs", "getUpdateTimeMs", "setUpdateTimeMs", "getUserName", "setUserName", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  private int commentCount = 0;
  public int dpP = -1;
  public String feedId = null;
  public boolean fhR = false;
  public float height = 0.0F;
  private int likeCount = 0;
  public String nickName = null;
  public int position = -1;
  public int scene = 0;
  public String sessionId = null;
  String userName = null;
  public float width = 0.0F;
  public int x = 0;
  public int y = 0;
  public long zIH = 0L;
  public float zIJ = 0.0F;
  public float zIK = 0.0F;
  public String zIO = null;
  public String zIP = null;
  int zIQ = -1;
  public long zJr = 0L;
  public long zJs = 0L;
  public int zJt = 0;
  public long zJu = 0L;
  public int zJv = -1;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(300365);
    if (this == paramObject)
    {
      AppMethodBeat.o(300365);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    paramObject = (i)paramObject;
    if (!s.p(this.sessionId, paramObject.sessionId))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.zJr != paramObject.zJr)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.zJs != paramObject.zJs)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.zJt != paramObject.zJt)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (!s.p(Float.valueOf(this.zIJ), Float.valueOf(paramObject.zIJ)))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (!s.p(Float.valueOf(this.zIK), Float.valueOf(paramObject.zIK)))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (!s.p(this.zIO, paramObject.zIO))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.scene != paramObject.scene)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.zIH != paramObject.zIH)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.zJu != paramObject.zJu)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.fhR != paramObject.fhR)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.x != paramObject.x)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.y != paramObject.y)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (!s.p(Float.valueOf(this.height), Float.valueOf(paramObject.height)))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (!s.p(Float.valueOf(this.width), Float.valueOf(paramObject.width)))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.position != paramObject.position)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.dpP != paramObject.dpP)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.zJv != paramObject.zJv)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.zIQ != paramObject.zIQ)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (!s.p(this.feedId, paramObject.feedId))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (!s.p(this.userName, paramObject.userName))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (!s.p(this.nickName, paramObject.nickName))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.commentCount != paramObject.commentCount)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (this.likeCount != paramObject.likeCount)
    {
      AppMethodBeat.o(300365);
      return false;
    }
    if (!s.p(this.zIP, paramObject.zIP))
    {
      AppMethodBeat.o(300365);
      return false;
    }
    AppMethodBeat.o(300365);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(300344);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WaterFeed(sessionId=").append(this.sessionId).append(", startExposureMs=").append(this.zJr).append(", endExposureMs=").append(this.zJs).append(", disAppearType=").append(this.zJt).append(", itemExposureAreaWeigth=").append(this.zIJ).append(", screenExposureAreaWeigth=").append(this.zIK).append(", contextId=").append(this.zIO).append(", scene=").append(this.scene).append(", updateTimeMs=").append(this.zIH).append(", itemExposureTimeMs=").append(this.zJu).append(", isShowing=").append(this.fhR).append(", x=");
    ((StringBuilder)localObject).append(this.x).append(", y=").append(this.y).append(", height=").append(this.height).append(", width=").append(this.width).append(", position=").append(this.position).append(", itemPosition=").append(this.dpP).append(", itemPos=").append(this.zJv).append(", itemArrayIndex=").append(this.zIQ).append(", feedId=").append(this.feedId).append(", userName=").append(this.userName).append(", nickName=").append(this.nickName).append(", commentCount=").append(this.commentCount);
    ((StringBuilder)localObject).append(", likeCount=").append(this.likeCount).append(", itemBufffer=").append(this.zIP).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(300344);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.d.i
 * JD-Core Version:    0.7.0.1
 */