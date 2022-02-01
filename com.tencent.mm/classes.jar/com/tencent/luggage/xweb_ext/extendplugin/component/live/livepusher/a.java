package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;", "leftBlusherPath", "", "leftBlusherPathMd5", "rightBlusherPath", "rightBlusherPathMd5", "faceModel", "", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAlpha", "()F", "getFaceModel", "()I", "getLeftBlusherPath", "()Ljava/lang/String;", "getLeftBlusherPathMd5", "getRightBlusherPath", "getRightBlusherPathMd5", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo$BlusherStickType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "getIdentityDesc", "hashCode", "toString", "BlusherStickType", "luggage-xweb-ext_release"})
public final class a
  implements h
{
  public final float alpha;
  public final a.a cFX;
  public final String cFY;
  private final String cFZ;
  public final String cGa;
  private final String cGb;
  public final int cGc;
  
  public a(float paramFloat, a.a parama, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    AppMethodBeat.i(215913);
    this.alpha = paramFloat;
    this.cFX = parama;
    this.cFY = paramString1;
    this.cFZ = paramString2;
    this.cGa = paramString3;
    this.cGb = paramString4;
    this.cGc = paramInt;
    AppMethodBeat.o(215913);
  }
  
  public final String Qc()
  {
    AppMethodBeat.i(215912);
    String str = "BlusherStickInfo(leftBlusherPath='" + this.cFY + "', leftBlusherPathMd5='" + this.cFZ + "', rightBlusherPath='" + this.cGa + "', rightBlusherPathMd5='" + this.cGb + '\'' + ")";
    AppMethodBeat.o(215912);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(215916);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((Float.compare(this.alpha, paramObject.alpha) != 0) || (!p.j(this.cFX, paramObject.cFX)) || (!p.j(this.cFY, paramObject.cFY)) || (!p.j(this.cFZ, paramObject.cFZ)) || (!p.j(this.cGa, paramObject.cGa)) || (!p.j(this.cGb, paramObject.cGb)) || (this.cGc != paramObject.cGc)) {}
      }
    }
    else
    {
      AppMethodBeat.o(215916);
      return true;
    }
    AppMethodBeat.o(215916);
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    AppMethodBeat.i(215915);
    int i1 = Float.floatToIntBits(this.alpha);
    Object localObject = this.cFX;
    int i;
    int j;
    label51:
    int k;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.cFY;
      if (localObject == null) {
        break label156;
      }
      j = localObject.hashCode();
      localObject = this.cFZ;
      if (localObject == null) {
        break label161;
      }
      k = localObject.hashCode();
      label68:
      localObject = this.cGa;
      if (localObject == null) {
        break label166;
      }
    }
    label156:
    label161:
    label166:
    for (int m = localObject.hashCode();; m = 0)
    {
      localObject = this.cGb;
      if (localObject != null) {
        n = localObject.hashCode();
      }
      int i2 = this.cGc;
      AppMethodBeat.o(215915);
      return ((m + (k + (j + (i + i1 * 31) * 31) * 31) * 31) * 31 + n) * 31 + i2;
      i = 0;
      break;
      j = 0;
      break label51;
      k = 0;
      break label68;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(215914);
    String str = "BlusherStickInfo(alpha=" + this.alpha + ", type=" + this.cFX + ", leftBlusherPath=" + this.cFY + ", leftBlusherPathMd5=" + this.cFZ + ", rightBlusherPath=" + this.cGa + ", rightBlusherPathMd5=" + this.cGb + ", faceModel=" + this.cGc + ")";
    AppMethodBeat.o(215914);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a
 * JD-Core Version:    0.7.0.1
 */