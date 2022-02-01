package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "", "height", "", "width", "sessionId", "", "clickFeedId", "nickName", "scene", "", "updateTimeMs", "", "clickTimeMs", "itemExposureAreaWeigth", "screenExposureAreaWeigth", "itemDirection", "itemIndex", "shotScreenJson", "contextId", "itemBufffer", "itemArrayIndex", "position", "(FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJFFIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getClickFeedId", "()Ljava/lang/String;", "setClickFeedId", "(Ljava/lang/String;)V", "getClickTimeMs", "()J", "setClickTimeMs", "(J)V", "getContextId", "setContextId", "getHeight", "()F", "setHeight", "(F)V", "getItemArrayIndex", "()I", "setItemArrayIndex", "(I)V", "getItemBufffer", "setItemBufffer", "getItemDirection", "setItemDirection", "getItemExposureAreaWeigth", "setItemExposureAreaWeigth", "getItemIndex", "setItemIndex", "getNickName", "setNickName", "getPosition", "setPosition", "getScene", "setScene", "getScreenExposureAreaWeigth", "setScreenExposureAreaWeigth", "getSessionId", "setSessionId", "getShotScreenJson", "setShotScreenJson", "getUpdateTimeMs", "setUpdateTimeMs", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-expt_release"})
public final class a
{
  public String bVF = null;
  public float height = 0.0F;
  public int position = 0;
  public String qXm = null;
  public long qXn = 0L;
  public long qXo = 0L;
  public float qXp = 0.0F;
  public float qXq = 0.0F;
  public int qXr = 0;
  public int qXs = 0;
  public String qXt = null;
  public String qXu = null;
  public String qXv = null;
  public int qXw = 0;
  public int scene = 0;
  public String sessionId = null;
  public float width = 0.0F;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(210870);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Float.compare(this.height, paramObject.height) != 0) || (Float.compare(this.width, paramObject.width) != 0) || (!p.i(this.sessionId, paramObject.sessionId)) || (!p.i(this.qXm, paramObject.qXm)) || (!p.i(this.bVF, paramObject.bVF)) || (this.scene != paramObject.scene) || (this.qXn != paramObject.qXn) || (this.qXo != paramObject.qXo) || (Float.compare(this.qXp, paramObject.qXp) != 0) || (Float.compare(this.qXq, paramObject.qXq) != 0) || (this.qXr != paramObject.qXr) || (this.qXs != paramObject.qXs) || (!p.i(this.qXt, paramObject.qXt)) || (!p.i(this.qXu, paramObject.qXu)) || (!p.i(this.qXv, paramObject.qXv)) || (this.qXw != paramObject.qXw) || (this.position != paramObject.position)) {}
      }
    }
    else
    {
      AppMethodBeat.o(210870);
      return true;
    }
    AppMethodBeat.o(210870);
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(210869);
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
      str = this.qXm;
      if (str == null) {
        break label319;
      }
      j = str.hashCode();
      str = this.bVF;
      if (str == null) {
        break label324;
      }
      k = str.hashCode();
      i4 = this.scene;
      long l = this.qXn;
      i5 = (int)(l ^ l >>> 32);
      l = this.qXo;
      i6 = (int)(l ^ l >>> 32);
      i7 = Float.floatToIntBits(this.qXp);
      i8 = Float.floatToIntBits(this.qXq);
      i9 = this.qXr;
      i10 = this.qXs;
      str = this.qXt;
      if (str == null) {
        break label329;
      }
      m = str.hashCode();
      label165:
      str = this.qXu;
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
      str = this.qXv;
      if (str != null) {
        i1 = str.hashCode();
      }
      int i11 = this.qXw;
      int i12 = this.position;
      AppMethodBeat.o(210869);
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
    AppMethodBeat.i(210868);
    String str = "ClickFeed(height=" + this.height + ", width=" + this.width + ", sessionId=" + this.sessionId + ", clickFeedId=" + this.qXm + ", nickName=" + this.bVF + ", scene=" + this.scene + ", updateTimeMs=" + this.qXn + ", clickTimeMs=" + this.qXo + ", itemExposureAreaWeigth=" + this.qXp + ", screenExposureAreaWeigth=" + this.qXq + ", itemDirection=" + this.qXr + ", itemIndex=" + this.qXs + ", shotScreenJson=" + this.qXt + ", contextId=" + this.qXu + ", itemBufffer=" + this.qXv + ", itemArrayIndex=" + this.qXw + ", position=" + this.position + ")";
    AppMethodBeat.o(210868);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.a
 * JD-Core Version:    0.7.0.1
 */