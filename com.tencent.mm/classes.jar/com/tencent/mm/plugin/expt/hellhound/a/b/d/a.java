package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "", "height", "", "width", "sessionId", "", "clickFeedId", "nickName", "scene", "", "updateTimeMs", "", "clickTimeMs", "itemExposureAreaWeigth", "screenExposureAreaWeigth", "itemDirection", "itemIndex", "shotScreenJson", "contextId", "itemBufffer", "itemArrayIndex", "position", "(FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJFFIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getClickFeedId", "()Ljava/lang/String;", "setClickFeedId", "(Ljava/lang/String;)V", "getClickTimeMs", "()J", "setClickTimeMs", "(J)V", "getContextId", "setContextId", "getHeight", "()F", "setHeight", "(F)V", "getItemArrayIndex", "()I", "setItemArrayIndex", "(I)V", "getItemBufffer", "setItemBufffer", "getItemDirection", "setItemDirection", "getItemExposureAreaWeigth", "setItemExposureAreaWeigth", "getItemIndex", "setItemIndex", "getNickName", "setNickName", "getPosition", "setPosition", "getScene", "setScene", "getScreenExposureAreaWeigth", "setScreenExposureAreaWeigth", "getSessionId", "setSessionId", "getShotScreenJson", "setShotScreenJson", "getUpdateTimeMs", "setUpdateTimeMs", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-expt_release"})
public final class a
{
  public String KHY = null;
  public long KHZ = 0L;
  public long KIa = 0L;
  public float KIb = 0.0F;
  public float KIc = 0.0F;
  public int KId = 0;
  public int KIe = 0;
  public String KIf = null;
  public String KIg = null;
  public int KIh = 0;
  public String bNK = null;
  public float height = 0.0F;
  public int position = 0;
  public String qwV = null;
  public int scene = 0;
  public String sessionId = null;
  public float width = 0.0F;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205265);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Float.compare(this.height, paramObject.height) != 0) || (Float.compare(this.width, paramObject.width) != 0) || (!k.g(this.sessionId, paramObject.sessionId)) || (!k.g(this.KHY, paramObject.KHY)) || (!k.g(this.bNK, paramObject.bNK)) || (this.scene != paramObject.scene) || (this.KHZ != paramObject.KHZ) || (this.KIa != paramObject.KIa) || (Float.compare(this.KIb, paramObject.KIb) != 0) || (Float.compare(this.KIc, paramObject.KIc) != 0) || (this.KId != paramObject.KId) || (this.KIe != paramObject.KIe) || (!k.g(this.KIf, paramObject.KIf)) || (!k.g(this.qwV, paramObject.qwV)) || (!k.g(this.KIg, paramObject.KIg)) || (this.KIh != paramObject.KIh) || (this.position != paramObject.position)) {}
      }
    }
    else
    {
      AppMethodBeat.o(205265);
      return true;
    }
    AppMethodBeat.o(205265);
    return false;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(205264);
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
      str = this.KHY;
      if (str == null) {
        break label319;
      }
      j = str.hashCode();
      str = this.bNK;
      if (str == null) {
        break label324;
      }
      k = str.hashCode();
      i4 = this.scene;
      long l = this.KHZ;
      i5 = (int)(l ^ l >>> 32);
      l = this.KIa;
      i6 = (int)(l ^ l >>> 32);
      i7 = Float.floatToIntBits(this.KIb);
      i8 = Float.floatToIntBits(this.KIc);
      i9 = this.KId;
      i10 = this.KIe;
      str = this.KIf;
      if (str == null) {
        break label329;
      }
      m = str.hashCode();
      label165:
      str = this.qwV;
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
      str = this.KIg;
      if (str != null) {
        i1 = str.hashCode();
      }
      int i11 = this.KIh;
      int i12 = this.position;
      AppMethodBeat.o(205264);
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
    AppMethodBeat.i(205263);
    String str = "ClickFeed(height=" + this.height + ", width=" + this.width + ", sessionId=" + this.sessionId + ", clickFeedId=" + this.KHY + ", nickName=" + this.bNK + ", scene=" + this.scene + ", updateTimeMs=" + this.KHZ + ", clickTimeMs=" + this.KIa + ", itemExposureAreaWeigth=" + this.KIb + ", screenExposureAreaWeigth=" + this.KIc + ", itemDirection=" + this.KId + ", itemIndex=" + this.KIe + ", shotScreenJson=" + this.KIf + ", contextId=" + this.qwV + ", itemBufffer=" + this.KIg + ", itemArrayIndex=" + this.KIh + ", position=" + this.position + ")";
    AppMethodBeat.o(205263);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.a
 * JD-Core Version:    0.7.0.1
 */