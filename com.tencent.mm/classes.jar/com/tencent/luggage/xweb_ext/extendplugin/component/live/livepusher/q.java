package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IResInfo;", "alpha", "", "color", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$Color;", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$LipStickType;", "faceModel", "", "mouthShape", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$MouthShape;", "(FLcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$Color;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$LipStickType;ILcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$MouthShape;)V", "getAlpha", "()F", "getColor", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$Color;", "getFaceModel", "()I", "getMouthShape", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$MouthShape;", "getType", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$LipStickType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "getIdentityDesc", "", "hashCode", "toString", "Color", "LipStickType", "MouthShape", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  implements i
{
  public final float alpha;
  public final a eAX;
  public final q.b eAY;
  public final q.c eAZ;
  public final int eAs;
  
  public q(float paramFloat, a parama, q.b paramb, int paramInt, q.c paramc)
  {
    AppMethodBeat.i(220803);
    this.alpha = paramFloat;
    this.eAX = parama;
    this.eAY = paramb;
    this.eAs = paramInt;
    this.eAZ = paramc;
    AppMethodBeat.o(220803);
  }
  
  public final String aui()
  {
    return "LipStickInfoV2()";
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(220840);
    if (this == paramObject)
    {
      AppMethodBeat.o(220840);
      return true;
    }
    if (!(paramObject instanceof q))
    {
      AppMethodBeat.o(220840);
      return false;
    }
    paramObject = (q)paramObject;
    if (!s.p(Float.valueOf(this.alpha), Float.valueOf(paramObject.alpha)))
    {
      AppMethodBeat.o(220840);
      return false;
    }
    if (!s.p(this.eAX, paramObject.eAX))
    {
      AppMethodBeat.o(220840);
      return false;
    }
    if (this.eAY != paramObject.eAY)
    {
      AppMethodBeat.o(220840);
      return false;
    }
    if (this.eAs != paramObject.eAs)
    {
      AppMethodBeat.o(220840);
      return false;
    }
    if (this.eAZ != paramObject.eAZ)
    {
      AppMethodBeat.o(220840);
      return false;
    }
    AppMethodBeat.o(220840);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(220827);
    int i = Float.floatToIntBits(this.alpha);
    int j = this.eAX.hashCode();
    int k = this.eAY.hashCode();
    int m = this.eAs;
    int n = this.eAZ.hashCode();
    AppMethodBeat.o(220827);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220820);
    String str = "LipStickInfoV2(alpha=" + this.alpha + ", color=" + this.eAX + ", type=" + this.eAY + ", faceModel=" + this.eAs + ", mouthShape=" + this.eAZ + ')';
    AppMethodBeat.o(220820);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfoV2$Color;", "", "colorR", "", "colorG", "colorB", "(III)V", "getColorB", "()I", "getColorG", "getColorR", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public final int eBa;
    public final int eBb;
    public final int eBc;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.eBa = paramInt1;
      this.eBb = paramInt2;
      this.eBc = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.eBa != paramObject.eBa) {
          return false;
        }
        if (this.eBb != paramObject.eBb) {
          return false;
        }
      } while (this.eBc == paramObject.eBc);
      return false;
    }
    
    public final int hashCode()
    {
      return (this.eBa * 31 + this.eBb) * 31 + this.eBc;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(220726);
      String str = "Color(colorR=" + this.eBa + ", colorG=" + this.eBb + ", colorB=" + this.eBc + ')';
      AppMethodBeat.o(220726);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.q
 * JD-Core Version:    0.7.0.1
 */