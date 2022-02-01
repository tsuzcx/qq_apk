package androidx.compose.ui.e;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import androidx.compose.ui.d.e;
import androidx.compose.ui.d.f;
import androidx.compose.ui.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "Landroidx/compose/ui/geometry/Size;", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  extends aw
{
  private final List<z> axG;
  private final List<Float> axH;
  private final long axI;
  private final int axJ;
  private final long start;
  
  private ai(List<z> paramList, List<Float> paramList1, long paramLong1, long paramLong2, int paramInt)
  {
    this.axG = paramList;
    this.axH = paramList1;
    this.start = paramLong1;
    this.axI = paramLong2;
    this.axJ = paramInt;
  }
  
  public final Shader X(long paramLong)
  {
    int j = 1;
    AppMethodBeat.i(206289);
    int i;
    if (e.F(this.start) == (1.0F / 1.0F))
    {
      i = 1;
      if (i == 0) {
        break label205;
      }
      f1 = k.Q(paramLong);
      label34:
      if (e.G(this.start) != (1.0F / 1.0F)) {
        break label216;
      }
      i = 1;
      label50:
      if (i == 0) {
        break label222;
      }
      f2 = k.R(paramLong);
      label61:
      if (e.F(this.axI) != (1.0F / 1.0F)) {
        break label234;
      }
      i = 1;
      label77:
      if (i == 0) {
        break label240;
      }
      f3 = k.Q(paramLong);
      label88:
      if (e.G(this.axI) != (1.0F / 1.0F)) {
        break label252;
      }
      i = j;
      label105:
      if (i == 0) {
        break label258;
      }
    }
    Object localObject2;
    Object localObject1;
    long l;
    label258:
    for (float f4 = k.R(paramLong);; f4 = e.G(this.axI))
    {
      localObject2 = this.axG;
      localObject1 = this.axH;
      paramLong = f.x(f1, f2);
      l = f.x(f3, f4);
      i = this.axJ;
      s.u(localObject2, "colors");
      s.u(localObject2, "colors");
      if (localObject1 != null) {
        break label270;
      }
      if (((List)localObject2).size() >= 2) {
        break label306;
      }
      localObject1 = new IllegalArgumentException("colors must have length of at least 2 if colorStops is omitted.");
      AppMethodBeat.o(206289);
      throw ((Throwable)localObject1);
      i = 0;
      break;
      label205:
      f1 = e.F(this.start);
      break label34;
      label216:
      i = 0;
      break label50;
      label222:
      f2 = e.G(this.start);
      break label61;
      label234:
      i = 0;
      break label77;
      label240:
      f3 = e.F(this.axI);
      break label88;
      label252:
      i = 0;
      break label105;
    }
    label270:
    if (((List)localObject2).size() != ((List)localObject1).size())
    {
      localObject1 = new IllegalArgumentException("colors and colorStops arguments must have equal length.");
      AppMethodBeat.o(206289);
      throw ((Throwable)localObject1);
    }
    label306:
    float f1 = e.F(paramLong);
    float f2 = e.G(paramLong);
    float f3 = e.F(l);
    f4 = e.G(l);
    int[] arrayOfInt = n.P((List)localObject2);
    if (localObject1 == null)
    {
      localObject2 = null;
      localObject1 = bd.ayy;
      if (bd.C(i, bd.tT())) {
        break label453;
      }
      localObject1 = bd.ayy;
      if (!bd.C(i, bd.tU())) {
        break label429;
      }
      localObject1 = Shader.TileMode.REPEAT;
    }
    for (;;)
    {
      localObject1 = (Shader)new LinearGradient(f1, f2, f3, f4, arrayOfInt, (float[])localObject2, (Shader.TileMode)localObject1);
      AppMethodBeat.o(206289);
      return localObject1;
      localObject2 = p.H((Collection)localObject1);
      break;
      label429:
      localObject1 = bd.ayy;
      if (bd.C(i, bd.tV())) {
        localObject1 = Shader.TileMode.MIRROR;
      } else {
        label453:
        localObject1 = Shader.TileMode.CLAMP;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206296);
    if (this == paramObject)
    {
      AppMethodBeat.o(206296);
      return true;
    }
    if (!(paramObject instanceof ai))
    {
      AppMethodBeat.o(206296);
      return false;
    }
    if (!s.p(this.axG, ((ai)paramObject).axG))
    {
      AppMethodBeat.o(206296);
      return false;
    }
    if (!s.p(this.axH, ((ai)paramObject).axH))
    {
      AppMethodBeat.o(206296);
      return false;
    }
    if (!e.e(this.start, ((ai)paramObject).start))
    {
      AppMethodBeat.o(206296);
      return false;
    }
    if (!e.e(this.axI, ((ai)paramObject).axI))
    {
      AppMethodBeat.o(206296);
      return false;
    }
    if (!bd.C(this.axJ, ((ai)paramObject).axJ))
    {
      AppMethodBeat.o(206296);
      return false;
    }
    AppMethodBeat.o(206296);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(206304);
    int j = this.axG.hashCode();
    List localList = this.axH;
    if (localList == null) {}
    for (int i = 0;; i = localList.hashCode())
    {
      int k = e.I(this.start);
      int m = e.I(this.axI);
      int n = bd.cG(this.axJ);
      AppMethodBeat.o(206304);
      return (((i + j * 31) * 31 + k) * 31 + m) * 31 + n;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206308);
    String str1;
    if (f.O(this.start))
    {
      str1 = "start=" + e.H(this.start) + ", ";
      if (!f.O(this.axI)) {
        break label159;
      }
    }
    label159:
    for (String str2 = "end=" + e.H(this.axI) + ", ";; str2 = "")
    {
      str1 = "LinearGradient(colors=" + this.axG + ", stops=" + this.axH + ", " + str1 + str2 + "tileMode=" + bd.cJ(this.axJ) + ')';
      AppMethodBeat.o(206308);
      return str1;
      str1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.ai
 * JD-Core Version:    0.7.0.1
 */