package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveCameraOptBeautyPowerfulDetailsView$EffectInfo;", "", "beautyId", "", "title", "", "(ILjava/lang/String;)V", "getBeautyId", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class FinderLiveCameraOptBeautyPowerfulDetailsView$d
{
  final String title;
  public final int yTn;
  
  public FinderLiveCameraOptBeautyPowerfulDetailsView$d(int paramInt, String paramString)
  {
    AppMethodBeat.i(255057);
    this.yTn = paramInt;
    this.title = paramString;
    AppMethodBeat.o(255057);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(255063);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.yTn != paramObject.yTn) || (!p.h(this.title, paramObject.title))) {}
      }
    }
    else
    {
      AppMethodBeat.o(255063);
      return true;
    }
    AppMethodBeat.o(255063);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(255061);
    int j = this.yTn;
    String str = this.title;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(255061);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(255058);
    String str = "EffectInfo(beautyId=" + this.yTn + ", title=" + this.title + ")";
    AppMethodBeat.o(255058);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveCameraOptBeautyPowerfulDetailsView.d
 * JD-Core Version:    0.7.0.1
 */