package com.tencent.mm.plugin.expt.hellhound.ext.b.d;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/ClickFeed;", "", "height", "", "width", "sessionId", "", "clickFeedId", "nickName", "scene", "", "updateTimeMs", "", "clickTimeMs", "itemExposureAreaWeigth", "screenExposureAreaWeigth", "itemDirection", "itemIndex", "shotScreenJson", "contextId", "itemBufffer", "itemArrayIndex", "position", "(FFLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJFFIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getClickFeedId", "()Ljava/lang/String;", "setClickFeedId", "(Ljava/lang/String;)V", "getClickTimeMs", "()J", "setClickTimeMs", "(J)V", "getContextId", "setContextId", "getHeight", "()F", "setHeight", "(F)V", "getItemArrayIndex", "()I", "setItemArrayIndex", "(I)V", "getItemBufffer", "setItemBufffer", "getItemDirection", "setItemDirection", "getItemExposureAreaWeigth", "setItemExposureAreaWeigth", "getItemIndex", "setItemIndex", "getNickName", "setNickName", "getPosition", "setPosition", "getScene", "setScene", "getScreenExposureAreaWeigth", "setScreenExposureAreaWeigth", "getSessionId", "setSessionId", "getShotScreenJson", "setShotScreenJson", "getUpdateTimeMs", "setUpdateTimeMs", "getWidth", "setWidth", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public float height = 0.0F;
  public String nickName = null;
  public int position = 0;
  public int scene = 0;
  public String sessionId = null;
  public float width = 0.0F;
  public String zIG = null;
  public long zIH = 0L;
  public long zII = 0L;
  public float zIJ = 0.0F;
  public float zIK = 0.0F;
  public int zIL = 0;
  public int zIM = 0;
  public String zIN = null;
  public String zIO = null;
  public String zIP = null;
  public int zIQ = 0;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(300335);
    if (this == paramObject)
    {
      AppMethodBeat.o(300335);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(Float.valueOf(this.height), Float.valueOf(paramObject.height)))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (!s.p(Float.valueOf(this.width), Float.valueOf(paramObject.width)))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (!s.p(this.sessionId, paramObject.sessionId))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (!s.p(this.zIG, paramObject.zIG))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (!s.p(this.nickName, paramObject.nickName))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (this.scene != paramObject.scene)
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (this.zIH != paramObject.zIH)
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (this.zII != paramObject.zII)
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (!s.p(Float.valueOf(this.zIJ), Float.valueOf(paramObject.zIJ)))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (!s.p(Float.valueOf(this.zIK), Float.valueOf(paramObject.zIK)))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (this.zIL != paramObject.zIL)
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (this.zIM != paramObject.zIM)
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (!s.p(this.zIN, paramObject.zIN))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (!s.p(this.zIO, paramObject.zIO))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (!s.p(this.zIP, paramObject.zIP))
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (this.zIQ != paramObject.zIQ)
    {
      AppMethodBeat.o(300335);
      return false;
    }
    if (this.position != paramObject.position)
    {
      AppMethodBeat.o(300335);
      return false;
    }
    AppMethodBeat.o(300335);
    return true;
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    AppMethodBeat.i(300326);
    int i2 = Float.floatToIntBits(this.height);
    int i3 = Float.floatToIntBits(this.width);
    int i;
    int j;
    label44:
    int k;
    label53:
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int m;
    label117:
    int n;
    if (this.sessionId == null)
    {
      i = 0;
      if (this.zIG != null) {
        break label258;
      }
      j = 0;
      if (this.nickName != null) {
        break label269;
      }
      k = 0;
      i4 = this.scene;
      i5 = q.a..ExternalSyntheticBackport0.m(this.zIH);
      i6 = q.a..ExternalSyntheticBackport0.m(this.zII);
      i7 = Float.floatToIntBits(this.zIJ);
      i8 = Float.floatToIntBits(this.zIK);
      i9 = this.zIL;
      i10 = this.zIM;
      if (this.zIN != null) {
        break label280;
      }
      m = 0;
      if (this.zIO != null) {
        break label292;
      }
      n = 0;
      label127:
      if (this.zIP != null) {
        break label304;
      }
    }
    for (;;)
    {
      int i11 = this.zIQ;
      int i12 = this.position;
      AppMethodBeat.o(300326);
      return (((n + (m + ((((((((k + (j + (i + (i2 * 31 + i3) * 31) * 31) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31) * 31) * 31 + i1) * 31 + i11) * 31 + i12;
      i = this.sessionId.hashCode();
      break;
      label258:
      j = this.zIG.hashCode();
      break label44;
      label269:
      k = this.nickName.hashCode();
      break label53;
      label280:
      m = this.zIN.hashCode();
      break label117;
      label292:
      n = this.zIO.hashCode();
      break label127;
      label304:
      i1 = this.zIP.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(300321);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ClickFeed(height=").append(this.height).append(", width=").append(this.width).append(", sessionId=").append(this.sessionId).append(", clickFeedId=").append(this.zIG).append(", nickName=").append(this.nickName).append(", scene=").append(this.scene).append(", updateTimeMs=").append(this.zIH).append(", clickTimeMs=").append(this.zII).append(", itemExposureAreaWeigth=").append(this.zIJ).append(", screenExposureAreaWeigth=").append(this.zIK).append(", itemDirection=").append(this.zIL).append(", itemIndex=");
    ((StringBuilder)localObject).append(this.zIM).append(", shotScreenJson=").append(this.zIN).append(", contextId=").append(this.zIO).append(", itemBufffer=").append(this.zIP).append(", itemArrayIndex=").append(this.zIQ).append(", position=").append(this.position).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(300321);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.d.a
 * JD-Core Version:    0.7.0.1
 */