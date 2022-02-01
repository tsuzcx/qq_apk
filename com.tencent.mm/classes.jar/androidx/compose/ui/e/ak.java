package androidx.compose.ui.e;

import androidx.compose.ui.d.a;
import androidx.compose.ui.d.g;
import androidx.compose.ui.d.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/Outline;", "", "()V", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "Generic", "Rectangle", "Rounded", "Landroidx/compose/ui/graphics/Outline$Rectangle;", "Landroidx/compose/ui/graphics/Outline$Rounded;", "Landroidx/compose/ui/graphics/Outline$Generic;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ak
{
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/Outline$Generic;", "Landroidx/compose/ui/graphics/Outline;", "path", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/Path;)V", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "getPath", "()Landroidx/compose/ui/graphics/Path;", "equals", "", "other", "", "hashCode", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends ak
  {
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      throw null;
    }
    
    public final int hashCode()
    {
      throw null;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/Outline$Rectangle;", "Landroidx/compose/ui/graphics/Outline;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;)V", "bounds", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "getRect", "equals", "", "other", "", "hashCode", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends ak
  {
    public final g axL;
    
    public b(g paramg)
    {
      super();
      AppMethodBeat.i(206000);
      this.axL = paramg;
      AppMethodBeat.o(206000);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206007);
      if (this == paramObject)
      {
        AppMethodBeat.o(206007);
        return true;
      }
      if (!(paramObject instanceof b))
      {
        AppMethodBeat.o(206007);
        return false;
      }
      if (!s.p(this.axL, ((b)paramObject).axL))
      {
        AppMethodBeat.o(206007);
        return false;
      }
      AppMethodBeat.o(206007);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206010);
      int i = this.axL.hashCode();
      AppMethodBeat.o(206010);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/Outline$Rounded;", "Landroidx/compose/ui/graphics/Outline;", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "(Landroidx/compose/ui/geometry/RoundRect;)V", "bounds", "Landroidx/compose/ui/geometry/Rect;", "getBounds", "()Landroidx/compose/ui/geometry/Rect;", "getRoundRect", "()Landroidx/compose/ui/geometry/RoundRect;", "roundRectPath", "Landroidx/compose/ui/graphics/Path;", "getRoundRectPath$ui_graphics_release", "()Landroidx/compose/ui/graphics/Path;", "equals", "", "other", "", "hashCode", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends ak
  {
    public final i axM;
    public final ao axN;
    
    public c(i parami)
    {
      super();
      AppMethodBeat.i(205997);
      this.axM = parami;
      parami = this.axM;
      int i;
      label73:
      label97:
      label103:
      int j;
      if (a.F(parami.avy) == a.F(parami.avx))
      {
        i = 1;
        if (i == 0) {
          break label237;
        }
        if (a.F(parami.avx) != a.F(parami.avw)) {
          break label227;
        }
        i = 1;
        if (i == 0) {
          break label237;
        }
        if (a.F(parami.avw) != a.F(parami.avv)) {
          break label232;
        }
        i = 1;
        if (i == 0) {
          break label237;
        }
        i = 1;
        if (a.G(parami.avy) != a.G(parami.avx)) {
          break label242;
        }
        j = 1;
        label123:
        if (j == 0) {
          break label257;
        }
        if (a.G(parami.avx) != a.G(parami.avw)) {
          break label247;
        }
        j = 1;
        label147:
        if (j == 0) {
          break label257;
        }
        if (a.G(parami.avw) != a.G(parami.avv)) {
          break label252;
        }
        j = 1;
        label171:
        if (j == 0) {
          break label257;
        }
        j = 1;
        label177:
        if ((i == 0) || (j == 0)) {
          break label262;
        }
        i = k;
        label188:
        if (i != 0) {
          break label267;
        }
        parami = m.sQ();
        parami.b(this.axM);
        ah localah = ah.aiuX;
      }
      for (;;)
      {
        this.axN = parami;
        AppMethodBeat.o(205997);
        return;
        i = 0;
        break;
        label227:
        i = 0;
        break label73;
        label232:
        i = 0;
        break label97;
        label237:
        i = 0;
        break label103;
        label242:
        j = 0;
        break label123;
        label247:
        j = 0;
        break label147;
        label252:
        j = 0;
        break label171;
        label257:
        j = 0;
        break label177;
        label262:
        i = 0;
        break label188;
        label267:
        parami = null;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(206001);
      if (this == paramObject)
      {
        AppMethodBeat.o(206001);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(206001);
        return false;
      }
      if (!s.p(this.axM, ((c)paramObject).axM))
      {
        AppMethodBeat.o(206001);
        return false;
      }
      AppMethodBeat.o(206001);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(206005);
      int i = this.axM.hashCode();
      AppMethodBeat.o(206005);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.ak
 * JD-Core Version:    0.7.0.1
 */