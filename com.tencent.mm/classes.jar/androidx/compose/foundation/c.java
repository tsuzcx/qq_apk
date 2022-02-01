package androidx.compose.foundation;

import androidx.compose.ui.e.af;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.b.a;
import androidx.compose.ui.e.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/BorderCache;", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "borderPath", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;Landroidx/compose/ui/graphics/Path;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "obtainPath", "toString", "", "drawBorderCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "borderSize", "Landroidx/compose/ui/unit/IntSize;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawBorderCache-EMwLDEs", "(Landroidx/compose/ui/draw/CacheDrawScope;JILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/ImageBitmap;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c
{
  af XS = null;
  u XT = null;
  a XU = null;
  ao XV = null;
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203618);
    if (this == paramObject)
    {
      AppMethodBeat.o(203618);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(203618);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.XS, paramObject.XS))
    {
      AppMethodBeat.o(203618);
      return false;
    }
    if (!s.p(this.XT, paramObject.XT))
    {
      AppMethodBeat.o(203618);
      return false;
    }
    if (!s.p(this.XU, paramObject.XU))
    {
      AppMethodBeat.o(203618);
      return false;
    }
    if (!s.p(this.XV, paramObject.XV))
    {
      AppMethodBeat.o(203618);
      return false;
    }
    AppMethodBeat.o(203618);
    return true;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(203610);
    int i;
    int j;
    label26:
    int k;
    if (this.XS == null)
    {
      i = 0;
      if (this.XT != null) {
        break label76;
      }
      j = 0;
      if (this.XU != null) {
        break label87;
      }
      k = 0;
      label35:
      if (this.XV != null) {
        break label98;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(203610);
      return (k + (j + i * 31) * 31) * 31 + m;
      i = this.XS.hashCode();
      break;
      label76:
      j = this.XT.hashCode();
      break label26;
      label87:
      k = this.XU.hashCode();
      break label35;
      label98:
      m = this.XV.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203601);
    String str = "BorderCache(imageBitmap=" + this.XS + ", canvas=" + this.XT + ", canvasDrawScope=" + this.XU + ", borderPath=" + this.XV + ')';
    AppMethodBeat.o(203601);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c
 * JD-Core Version:    0.7.0.1
 */