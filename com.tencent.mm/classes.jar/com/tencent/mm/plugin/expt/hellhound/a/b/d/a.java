package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "", "height", "", "width", "sessionId", "", "clickFeedId", "nickName", "scene", "", "updateTimeMs", "", "clickTimeMs", "itemExposureAreaWeigth", "screenExposureAreaWeigth", "itemDirection", "itemIndex", "shotScreenJson", "contextId", "itemBufffer", "itemArrayIndex", "position", "(FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJFFIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getClickFeedId", "()Ljava/lang/String;", "setClickFeedId", "(Ljava/lang/String;)V", "getClickTimeMs", "()J", "setClickTimeMs", "(J)V", "getContextId", "setContextId", "getHeight", "()F", "setHeight", "(F)V", "getItemArrayIndex", "()I", "setItemArrayIndex", "(I)V", "getItemBufffer", "setItemBufffer", "getItemDirection", "setItemDirection", "getItemExposureAreaWeigth", "setItemExposureAreaWeigth", "getItemIndex", "setItemIndex", "getNickName", "setNickName", "getPosition", "setPosition", "getScene", "setScene", "getScreenExposureAreaWeigth", "setScreenExposureAreaWeigth", "getSessionId", "setSessionId", "getShotScreenJson", "setShotScreenJson", "getUpdateTimeMs", "setUpdateTimeMs", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-expt_release"})
public final class a
{
  public float height = 0.0F;
  public String nickName = null;
  public int position = 0;
  public String sGI = null;
  public long sGJ = 0L;
  public long sGK = 0L;
  public float sGL = 0.0F;
  public float sGM = 0.0F;
  public int sGN = 0;
  public int sGO = 0;
  public String sGP = null;
  public String sGQ = null;
  public String sGR = null;
  public int sGS = 0;
  public int scene = 0;
  public String sessionId = null;
  public float width = 0.0F;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(221033);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Float.compare(this.height, paramObject.height) != 0) || (Float.compare(this.width, paramObject.width) != 0) || (!p.j(this.sessionId, paramObject.sessionId)) || (!p.j(this.sGI, paramObject.sGI)) || (!p.j(this.nickName, paramObject.nickName)) || (this.scene != paramObject.scene) || (this.sGJ != paramObject.sGJ) || (this.sGK != paramObject.sGK) || (Float.compare(this.sGL, paramObject.sGL) != 0) || (Float.compare(this.sGM, paramObject.sGM) != 0) || (this.sGN != paramObject.sGN) || (this.sGO != paramObject.sGO) || (!p.j(this.sGP, paramObject.sGP)) || (!p.j(this.sGQ, paramObject.sGQ)) || (!p.j(this.sGR, paramObject.sGR)) || (this.sGS != paramObject.sGS) || (this.position != paramObject.position)) {}
      }
    }
    else
    {
      AppMethodBeat.o(221033);
      return true;
    }
    AppMethodBeat.o(221033);
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(221032);
    int i2 = Float.floatToIntBits(this.height);
    int i3 = Float.floatToIntBits(this.width);
    String str = this.sessionId;
    int i;
    int j;
    label60:
    int k;
    label77:
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int m;
    if (str != null)
    {
      i = str.hashCode();
      str = this.sGI;
      if (str == null) {
        break label319;
      }
      j = str.hashCode();
      str = this.nickName;
      if (str == null) {
        break label324;
      }
      k = str.hashCode();
      i4 = this.scene;
      long l = this.sGJ;
      i5 = (int)(l ^ l >>> 32);
      l = this.sGK;
      i6 = (int)(l ^ l >>> 32);
      i7 = Float.floatToIntBits(this.sGL);
      i8 = Float.floatToIntBits(this.sGM);
      i9 = this.sGN;
      i10 = this.sGO;
      str = this.sGP;
      if (str == null) {
        break label329;
      }
      m = str.hashCode();
      label165:
      str = this.sGQ;
      if (str == null) {
        break label335;
      }
    }
    label319:
    label324:
    label329:
    label335:
    for (int n = str.hashCode();; n = 0)
    {
      str = this.sGR;
      if (str != null) {
        i1 = str.hashCode();
      }
      int i11 = this.sGS;
      int i12 = this.position;
      AppMethodBeat.o(221032);
      return (((n + (m + ((((((((k + (j + (i + (i2 * 31 + i3) * 31) * 31) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31) * 31) * 31 + i1) * 31 + i11) * 31 + i12;
      i = 0;
      break;
      j = 0;
      break label60;
      k = 0;
      break label77;
      m = 0;
      break label165;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(221031);
    String str = "ClickFeed(height=" + this.height + ", width=" + this.width + ", sessionId=" + this.sessionId + ", clickFeedId=" + this.sGI + ", nickName=" + this.nickName + ", scene=" + this.scene + ", updateTimeMs=" + this.sGJ + ", clickTimeMs=" + this.sGK + ", itemExposureAreaWeigth=" + this.sGL + ", screenExposureAreaWeigth=" + this.sGM + ", itemDirection=" + this.sGN + ", itemIndex=" + this.sGO + ", shotScreenJson=" + this.sGP + ", contextId=" + this.sGQ + ", itemBufffer=" + this.sGR + ", itemArrayIndex=" + this.sGS + ", position=" + this.position + ")";
    AppMethodBeat.o(221031);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.a
 * JD-Core Version:    0.7.0.1
 */