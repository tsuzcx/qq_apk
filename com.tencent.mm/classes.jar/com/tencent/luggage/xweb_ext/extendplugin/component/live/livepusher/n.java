package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "color", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "faceModel", "", "mouthShape", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;)V", "getAlpha", "()F", "getColor", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "getFaceModel", "()I", "getMouthShape", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getIdentityDesc", "", "hashCode", "toString", "Color", "LipStickType", "MouthShape", "luggage-xweb-ext_release"})
public final class n
  implements h
{
  public final float alpha;
  public final a cGU;
  public final n.b cGV;
  public final n.c cGW;
  public final int cGc;
  
  public n(float paramFloat, a parama, n.b paramb, int paramInt, n.c paramc)
  {
    AppMethodBeat.i(215962);
    this.alpha = paramFloat;
    this.cGU = parama;
    this.cGV = paramb;
    this.cGc = paramInt;
    this.cGW = paramc;
    AppMethodBeat.o(215962);
  }
  
  public final String Qc()
  {
    return "LipStickInfo()";
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(215965);
    if (this != paramObject)
    {
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if ((Float.compare(this.alpha, paramObject.alpha) != 0) || (!p.j(this.cGU, paramObject.cGU)) || (!p.j(this.cGV, paramObject.cGV)) || (this.cGc != paramObject.cGc) || (!p.j(this.cGW, paramObject.cGW))) {}
      }
    }
    else
    {
      AppMethodBeat.o(215965);
      return true;
    }
    AppMethodBeat.o(215965);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(215964);
    int m = Float.floatToIntBits(this.alpha);
    Object localObject = this.cGU;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.cGV;
      if (localObject == null) {
        break label107;
      }
    }
    label107:
    for (int j = localObject.hashCode();; j = 0)
    {
      int n = this.cGc;
      localObject = this.cGW;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(215964);
      return ((j + (i + m * 31) * 31) * 31 + n) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(215963);
    String str = "LipStickInfo(alpha=" + this.alpha + ", color=" + this.cGU + ", type=" + this.cGV + ", faceModel=" + this.cGc + ", mouthShape=" + this.cGW + ")";
    AppMethodBeat.o(215963);
    return str;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "", "colorR", "", "colorG", "colorB", "(III)V", "getColorB", "()I", "getColorG", "getColorR", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-xweb-ext_release"})
  public static final class a
  {
    public final int cGX;
    public final int cGY;
    public final int cGZ;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.cGX = paramInt1;
      this.cGY = paramInt2;
      this.cGZ = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.cGX != paramObject.cGX) || (this.cGY != paramObject.cGY) || (this.cGZ != paramObject.cGZ)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return (this.cGX * 31 + this.cGY) * 31 + this.cGZ;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(215954);
      String str = "Color(colorR=" + this.cGX + ", colorG=" + this.cGY + ", colorB=" + this.cGZ + ")";
      AppMethodBeat.o(215954);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n
 * JD-Core Version:    0.7.0.1
 */