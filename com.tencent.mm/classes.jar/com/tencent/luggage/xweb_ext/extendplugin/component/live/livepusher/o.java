package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "color", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "faceModel", "", "mouthShape", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;)V", "getAlpha", "()F", "getColor", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "getFaceModel", "()I", "getMouthShape", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$MouthShape;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getIdentityDesc", "", "hashCode", "toString", "Color", "LipStickType", "MouthShape", "luggage-xweb-ext_release"})
public final class o
  implements h
{
  public final float alpha;
  public final int cGI;
  public final a cHA;
  public final o.b cHB;
  public final o.c cHC;
  
  public o(float paramFloat, a parama, o.b paramb, int paramInt, o.c paramc)
  {
    AppMethodBeat.i(224378);
    this.alpha = paramFloat;
    this.cHA = parama;
    this.cHB = paramb;
    this.cGI = paramInt;
    this.cHC = paramc;
    AppMethodBeat.o(224378);
  }
  
  public final String TD()
  {
    return "LipStickInfo()";
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(224384);
    if (this != paramObject)
    {
      if ((paramObject instanceof o))
      {
        paramObject = (o)paramObject;
        if ((Float.compare(this.alpha, paramObject.alpha) != 0) || (!p.h(this.cHA, paramObject.cHA)) || (!p.h(this.cHB, paramObject.cHB)) || (this.cGI != paramObject.cGI) || (!p.h(this.cHC, paramObject.cHC))) {}
      }
    }
    else
    {
      AppMethodBeat.o(224384);
      return true;
    }
    AppMethodBeat.o(224384);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(224383);
    int m = Float.floatToIntBits(this.alpha);
    Object localObject = this.cHA;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.cHB;
      if (localObject == null) {
        break label107;
      }
    }
    label107:
    for (int j = localObject.hashCode();; j = 0)
    {
      int n = this.cGI;
      localObject = this.cHC;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(224383);
      return ((j + (i + m * 31) * 31) * 31 + n) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(224381);
    String str = "LipStickInfo(alpha=" + this.alpha + ", color=" + this.cHA + ", type=" + this.cHB + ", faceModel=" + this.cGI + ", mouthShape=" + this.cHC + ")";
    AppMethodBeat.o(224381);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$Color;", "", "colorR", "", "colorG", "colorB", "(III)V", "getColorB", "()I", "getColorG", "getColorR", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-xweb-ext_release"})
  public static final class a
  {
    public final int cHD;
    public final int cHE;
    public final int cHF;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.cHD = paramInt1;
      this.cHE = paramInt2;
      this.cHF = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.cHD != paramObject.cHD) || (this.cHE != paramObject.cHE) || (this.cHF != paramObject.cHF)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return (this.cHD * 31 + this.cHE) * 31 + this.cHF;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(222779);
      String str = "Color(colorR=" + this.cHD + ", colorG=" + this.cHE + ", colorB=" + this.cHF + ")";
      AppMethodBeat.o(222779);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o
 * JD-Core Version:    0.7.0.1
 */