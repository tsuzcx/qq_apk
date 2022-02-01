package androidx.compose.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/TransitionData;", "", "fade", "Landroidx/compose/animation/Fade;", "slide", "Landroidx/compose/animation/Slide;", "changeSize", "Landroidx/compose/animation/ChangeSize;", "(Landroidx/compose/animation/Fade;Landroidx/compose/animation/Slide;Landroidx/compose/animation/ChangeSize;)V", "getChangeSize", "()Landroidx/compose/animation/ChangeSize;", "getFade", "()Landroidx/compose/animation/Fade;", "getSlide", "()Landroidx/compose/animation/Slide;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  final p TQ;
  final s TR;
  final e TS;
  
  public w()
  {
    this(null, null, null, 7);
  }
  
  public w(p paramp, s params, e parame)
  {
    this.TQ = paramp;
    this.TR = params;
    this.TS = parame;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203147);
    if (this == paramObject)
    {
      AppMethodBeat.o(203147);
      return true;
    }
    if (!(paramObject instanceof w))
    {
      AppMethodBeat.o(203147);
      return false;
    }
    paramObject = (w)paramObject;
    if (!kotlin.g.b.s.p(this.TQ, paramObject.TQ))
    {
      AppMethodBeat.o(203147);
      return false;
    }
    if (!kotlin.g.b.s.p(this.TR, paramObject.TR))
    {
      AppMethodBeat.o(203147);
      return false;
    }
    if (!kotlin.g.b.s.p(this.TS, paramObject.TS))
    {
      AppMethodBeat.o(203147);
      return false;
    }
    AppMethodBeat.o(203147);
    return true;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(203139);
    int i;
    int j;
    if (this.TQ == null)
    {
      i = 0;
      if (this.TR != null) {
        break label60;
      }
      j = 0;
      label25:
      if (this.TS != null) {
        break label71;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(203139);
      return (j + i * 31) * 31 + k;
      i = this.TQ.hashCode();
      break;
      label60:
      j = this.TR.hashCode();
      break label25;
      label71:
      k = this.TS.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203130);
    String str = "TransitionData(fade=" + this.TQ + ", slide=" + this.TR + ", changeSize=" + this.TS + ')';
    AppMethodBeat.o(203130);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.w
 * JD-Core Version:    0.7.0.1
 */