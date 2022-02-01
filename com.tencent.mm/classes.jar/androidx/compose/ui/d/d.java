package androidx.compose.ui.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/geometry/MutableRect;", "", "left", "", "top", "right", "bottom", "(FFFF)V", "getBottom", "()F", "setBottom", "(F)V", "height", "getHeight", "isEmpty", "", "()Z", "getLeft", "setLeft", "getRight", "setRight", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "getTop", "setTop", "width", "getWidth", "contains", "offset", "Landroidx/compose/ui/geometry/Offset;", "contains-k-4lQ0M", "(J)Z", "intersect", "", "set", "toString", "", "ui-geometry_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public float bottom = 0.0F;
  public float left = 0.0F;
  public float right = 0.0F;
  public float top = 0.0F;
  
  public final boolean isEmpty()
  {
    return (this.left >= this.right) || (this.top >= this.bottom);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205541);
    String str = "MutableRect(" + c.I(this.left) + ", " + c.I(this.top) + ", " + c.I(this.right) + ", " + c.I(this.bottom) + ')';
    AppMethodBeat.o(205541);
    return str;
  }
  
  public final void w(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205535);
    this.left = Math.max(0.0F, this.left);
    this.top = Math.max(0.0F, this.top);
    this.right = Math.min(paramFloat1, this.right);
    this.bottom = Math.min(paramFloat2, this.bottom);
    AppMethodBeat.o(205535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d.d
 * JD-Core Version:    0.7.0.1
 */