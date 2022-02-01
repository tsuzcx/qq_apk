package com.tencent.mm.plugin.finder.viewmodel.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderHorizontalVideoPreviewUIC$AnimInfo;", "", "scale", "", "translationX", "translationY", "rotation", "(FFFF)V", "getRotation", "()F", "getScale", "getTranslationX", "getTranslationY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag$a
{
  final float ayc;
  final float ayd;
  final float rotation;
  final float scale;
  
  public ag$a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.scale = paramFloat1;
    this.ayc = paramFloat2;
    this.ayd = paramFloat3;
    this.rotation = paramFloat4;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(337494);
    if (this == paramObject)
    {
      AppMethodBeat.o(337494);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(337494);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(Float.valueOf(this.scale), Float.valueOf(paramObject.scale)))
    {
      AppMethodBeat.o(337494);
      return false;
    }
    if (!s.p(Float.valueOf(this.ayc), Float.valueOf(paramObject.ayc)))
    {
      AppMethodBeat.o(337494);
      return false;
    }
    if (!s.p(Float.valueOf(this.ayd), Float.valueOf(paramObject.ayd)))
    {
      AppMethodBeat.o(337494);
      return false;
    }
    if (!s.p(Float.valueOf(this.rotation), Float.valueOf(paramObject.rotation)))
    {
      AppMethodBeat.o(337494);
      return false;
    }
    AppMethodBeat.o(337494);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(337488);
    int i = Float.floatToIntBits(this.scale);
    int j = Float.floatToIntBits(this.ayc);
    int k = Float.floatToIntBits(this.ayd);
    int m = Float.floatToIntBits(this.rotation);
    AppMethodBeat.o(337488);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(337482);
    String str = "scale=" + this.scale + " translationX=" + this.ayc + " translationY=" + this.ayd + " rotation=" + this.rotation;
    AppMethodBeat.o(337482);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ag.a
 * JD-Core Version:    0.7.0.1
 */