package com.tencent.mm.aj.c;

import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mm_compose/widget/TabPosition;", "", "left", "Landroidx/compose/ui/unit/Dp;", "width", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLeft-D9Ej5fM", "()F", "F", "right", "getRight-D9Ej5fM", "getWidth-D9Ej5fM", "equals", "", "other", "hashCode", "", "toString", "", "compose-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final float left;
  public final float width;
  
  private c(float paramFloat1, float paramFloat2)
  {
    this.left = paramFloat1;
    this.width = paramFloat2;
  }
  
  public final float byW()
  {
    AppMethodBeat.i(238788);
    float f = g.ai(this.left + this.width);
    AppMethodBeat.o(238788);
    return f;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(238796);
    if (this == paramObject)
    {
      AppMethodBeat.o(238796);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(238796);
      return false;
    }
    if (!g.G(this.left, ((c)paramObject).left))
    {
      AppMethodBeat.o(238796);
      return false;
    }
    if (!g.G(this.width, ((c)paramObject).width))
    {
      AppMethodBeat.o(238796);
      return false;
    }
    AppMethodBeat.o(238796);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(238801);
    int i = g.ah(this.left);
    int j = g.ah(this.width);
    AppMethodBeat.o(238801);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(238805);
    String str = "TabPosition(left=" + g.ak(this.left) + ", right=" + g.ak(byW()) + ", width=" + g.ak(this.width) + ')';
    AppMethodBeat.o(238805);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.c.c
 * JD-Core Version:    0.7.0.1
 */