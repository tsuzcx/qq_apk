package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterFeed;", "", "sessionId", "", "startExposureMs", "", "endExposureMs", "disAppearType", "", "itemExposureAreaWeigth", "", "screenExposureAreaWeigth", "contextId", "scene", "updateTimeMs", "itemExposureTimeMs", "isShowing", "", "x", "y", "height", "width", "position", "itemPosition", "itemPos", "itemArrayIndex", "feedId", "userName", "nickName", "commentCount", "likeCount", "itemBufffer", "(Ljava/lang/String;JJIFFLjava/lang/String;IJJZIIFFIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getCommentCount", "()I", "setCommentCount", "(I)V", "getContextId", "()Ljava/lang/String;", "setContextId", "(Ljava/lang/String;)V", "getDisAppearType", "setDisAppearType", "getEndExposureMs", "()J", "setEndExposureMs", "(J)V", "getFeedId", "setFeedId", "getHeight", "()F", "setHeight", "(F)V", "()Z", "setShowing", "(Z)V", "getItemArrayIndex", "setItemArrayIndex", "getItemBufffer", "setItemBufffer", "getItemExposureAreaWeigth", "setItemExposureAreaWeigth", "getItemExposureTimeMs", "setItemExposureTimeMs", "getItemPos", "setItemPos", "getItemPosition", "setItemPosition", "getLikeCount", "setLikeCount", "getNickName", "setNickName", "getPosition", "setPosition", "getScene", "setScene", "getScreenExposureAreaWeigth", "setScreenExposureAreaWeigth", "getSessionId", "setSessionId", "getStartExposureMs", "setStartExposureMs", "getUpdateTimeMs", "setUpdateTimeMs", "getUserName", "setUserName", "getWidth", "setWidth", "getX", "setX", "getY", "setY", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "plugin-expt_release"})
public final class i
{
  public String bVF = null;
  public boolean cNB = false;
  private int commentCount = 0;
  public String feedId = null;
  public float height = 0.0F;
  public int kd = -1;
  private int likeCount = 0;
  public int position = -1;
  public String rfA = null;
  public String rfB = null;
  int rfC = -1;
  public long rfX = 0L;
  public long rfY = 0L;
  public int rfZ = 0;
  public long rft = 0L;
  public float rfv = 0.0F;
  public float rfw = 0.0F;
  public long rga = 0L;
  public int rgb = -1;
  public int scene = 0;
  public String sessionId = null;
  String userName = null;
  public float width = 0.0F;
  public int x = 0;
  public int y = 0;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196608);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((!p.i(this.sessionId, paramObject.sessionId)) || (this.rfX != paramObject.rfX) || (this.rfY != paramObject.rfY) || (this.rfZ != paramObject.rfZ) || (Float.compare(this.rfv, paramObject.rfv) != 0) || (Float.compare(this.rfw, paramObject.rfw) != 0) || (!p.i(this.rfA, paramObject.rfA)) || (this.scene != paramObject.scene) || (this.rft != paramObject.rft) || (this.rga != paramObject.rga) || (this.cNB != paramObject.cNB) || (this.x != paramObject.x) || (this.y != paramObject.y) || (Float.compare(this.height, paramObject.height) != 0) || (Float.compare(this.width, paramObject.width) != 0) || (this.position != paramObject.position) || (this.kd != paramObject.kd) || (this.rgb != paramObject.rgb) || (this.rfC != paramObject.rfC) || (!p.i(this.feedId, paramObject.feedId)) || (!p.i(this.userName, paramObject.userName)) || (!p.i(this.bVF, paramObject.bVF)) || (this.commentCount != paramObject.commentCount) || (this.likeCount != paramObject.likeCount) || (!p.i(this.rfB, paramObject.rfB))) {}
      }
    }
    else
    {
      AppMethodBeat.o(196608);
      return true;
    }
    AppMethodBeat.o(196608);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196606);
    String str = "WaterFeed(sessionId=" + this.sessionId + ", startExposureMs=" + this.rfX + ", endExposureMs=" + this.rfY + ", disAppearType=" + this.rfZ + ", itemExposureAreaWeigth=" + this.rfv + ", screenExposureAreaWeigth=" + this.rfw + ", contextId=" + this.rfA + ", scene=" + this.scene + ", updateTimeMs=" + this.rft + ", itemExposureTimeMs=" + this.rga + ", isShowing=" + this.cNB + ", x=" + this.x + ", y=" + this.y + ", height=" + this.height + ", width=" + this.width + ", position=" + this.position + ", itemPosition=" + this.kd + ", itemPos=" + this.rgb + ", itemArrayIndex=" + this.rfC + ", feedId=" + this.feedId + ", userName=" + this.userName + ", nickName=" + this.bVF + ", commentCount=" + this.commentCount + ", likeCount=" + this.likeCount + ", itemBufffer=" + this.rfB + ")";
    AppMethodBeat.o(196606);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.i
 * JD-Core Version:    0.7.0.1
 */