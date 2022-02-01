package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "", "sessionId", "", "startExposureMs", "", "endExposureMs", "disAppearType", "", "itemExposureAreaWeigth", "", "screenExposureAreaWeigth", "contextId", "scene", "updateTimeMs", "itemExposureTimeMs", "isShowing", "", "x", "y", "height", "width", "position", "itemPosition", "itemPos", "itemArrayIndex", "feedId", "userName", "nickName", "commentCount", "likeCount", "itemBufffer", "(Ljava/lang/String;JJIFFLjava/lang/String;IJJZIIFFIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getCommentCount", "()I", "setCommentCount", "(I)V", "getContextId", "()Ljava/lang/String;", "setContextId", "(Ljava/lang/String;)V", "getDisAppearType", "setDisAppearType", "getEndExposureMs", "()J", "setEndExposureMs", "(J)V", "getFeedId", "setFeedId", "getHeight", "()F", "setHeight", "(F)V", "()Z", "setShowing", "(Z)V", "getItemArrayIndex", "setItemArrayIndex", "getItemBufffer", "setItemBufffer", "getItemExposureAreaWeigth", "setItemExposureAreaWeigth", "getItemExposureTimeMs", "setItemExposureTimeMs", "getItemPos", "setItemPos", "getItemPosition", "setItemPosition", "getLikeCount", "setLikeCount", "getNickName", "setNickName", "getPosition", "setPosition", "getScene", "setScene", "getScreenExposureAreaWeigth", "setScreenExposureAreaWeigth", "getSessionId", "setSessionId", "getStartExposureMs", "setStartExposureMs", "getUpdateTimeMs", "setUpdateTimeMs", "getUserName", "setUserName", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-expt_release"})
public final class i
{
  private int commentCount = 0;
  public boolean ddZ = false;
  public String feedId = null;
  public float height = 0.0F;
  public int kf = -1;
  private int likeCount = 0;
  public String nickName = null;
  public int position = -1;
  public long sGJ = 0L;
  public float sGL = 0.0F;
  public float sGM = 0.0F;
  public String sGQ = null;
  public String sGR = null;
  int sGS = -1;
  public long sHt = 0L;
  public long sHu = 0L;
  public int sHv = 0;
  public long sHw = 0L;
  public int sHx = -1;
  public int scene = 0;
  public String sessionId = null;
  String userName = null;
  public float width = 0.0F;
  public int x = 0;
  public int y = 0;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221100);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((!p.j(this.sessionId, paramObject.sessionId)) || (this.sHt != paramObject.sHt) || (this.sHu != paramObject.sHu) || (this.sHv != paramObject.sHv) || (Float.compare(this.sGL, paramObject.sGL) != 0) || (Float.compare(this.sGM, paramObject.sGM) != 0) || (!p.j(this.sGQ, paramObject.sGQ)) || (this.scene != paramObject.scene) || (this.sGJ != paramObject.sGJ) || (this.sHw != paramObject.sHw) || (this.ddZ != paramObject.ddZ) || (this.x != paramObject.x) || (this.y != paramObject.y) || (Float.compare(this.height, paramObject.height) != 0) || (Float.compare(this.width, paramObject.width) != 0) || (this.position != paramObject.position) || (this.kf != paramObject.kf) || (this.sHx != paramObject.sHx) || (this.sGS != paramObject.sGS) || (!p.j(this.feedId, paramObject.feedId)) || (!p.j(this.userName, paramObject.userName)) || (!p.j(this.nickName, paramObject.nickName)) || (this.commentCount != paramObject.commentCount) || (this.likeCount != paramObject.likeCount) || (!p.j(this.sGR, paramObject.sGR))) {}
      }
    }
    else
    {
      AppMethodBeat.o(221100);
      return true;
    }
    AppMethodBeat.o(221100);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221098);
    String str = "WaterFeed(sessionId=" + this.sessionId + ", startExposureMs=" + this.sHt + ", endExposureMs=" + this.sHu + ", disAppearType=" + this.sHv + ", itemExposureAreaWeigth=" + this.sGL + ", screenExposureAreaWeigth=" + this.sGM + ", contextId=" + this.sGQ + ", scene=" + this.scene + ", updateTimeMs=" + this.sGJ + ", itemExposureTimeMs=" + this.sHw + ", isShowing=" + this.ddZ + ", x=" + this.x + ", y=" + this.y + ", height=" + this.height + ", width=" + this.width + ", position=" + this.position + ", itemPosition=" + this.kf + ", itemPos=" + this.sHx + ", itemArrayIndex=" + this.sGS + ", feedId=" + this.feedId + ", userName=" + this.userName + ", nickName=" + this.nickName + ", commentCount=" + this.commentCount + ", likeCount=" + this.likeCount + ", itemBufffer=" + this.sGR + ")";
    AppMethodBeat.o(221098);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.i
 * JD-Core Version:    0.7.0.1
 */