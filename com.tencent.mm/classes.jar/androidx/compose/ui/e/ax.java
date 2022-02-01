package androidx.compose.ui.e;

import androidx.compose.ui.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/Shadow;", "", "color", "Landroidx/compose/ui/graphics/Color;", "offset", "Landroidx/compose/ui/geometry/Offset;", "blurRadius", "", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBlurRadius$annotations", "()V", "getBlurRadius", "()F", "getColor-0d7_KjU$annotations", "getColor-0d7_KjU", "()J", "J", "getOffset-F1C5BW0$annotations", "getOffset-F1C5BW0", "copy", "copy-qcb84PM", "(JJF)Landroidx/compose/ui/graphics/Shadow;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
{
  public static final ax.a aym;
  private static final ax ayp;
  public final long ayn;
  public final float ayo;
  public final long offset;
  
  static
  {
    AppMethodBeat.i(206164);
    aym = new ax.a((byte)0);
    ayp = new ax(0L, 0L, 0.0F, 7);
    AppMethodBeat.o(206164);
  }
  
  private ax(long paramLong1, long paramLong2, float paramFloat)
  {
    this.ayn = paramLong1;
    this.offset = paramLong2;
    this.ayo = paramFloat;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206176);
    if (this == paramObject)
    {
      AppMethodBeat.o(206176);
      return true;
    }
    if (!(paramObject instanceof ax))
    {
      AppMethodBeat.o(206176);
      return false;
    }
    if (!z.e(this.ayn, ((ax)paramObject).ayn))
    {
      AppMethodBeat.o(206176);
      return false;
    }
    if (!e.e(this.offset, ((ax)paramObject).offset))
    {
      AppMethodBeat.o(206176);
      return false;
    }
    if (this.ayo == ((ax)paramObject).ayo) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206176);
      return false;
    }
    AppMethodBeat.o(206176);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206180);
    int i = z.I(this.ayn);
    int j = e.I(this.offset);
    int k = Float.floatToIntBits(this.ayo);
    AppMethodBeat.o(206180);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206183);
    String str = "Shadow(color=" + z.H(this.ayn) + ", offset=" + e.H(this.offset) + ", blurRadius=" + this.ayo + ')';
    AppMethodBeat.o(206183);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.ax
 * JD-Core Version:    0.7.0.1
 */