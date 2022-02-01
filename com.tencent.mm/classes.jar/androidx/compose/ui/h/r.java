package androidx.compose.ui.h;

import androidx.compose.ui.n.d;
import androidx.compose.ui.n.d.a;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface r
  extends i
{
  public abstract q a(int paramInt1, int paramInt2, Map<a, Integer> paramMap, b<? super x.a, ah> paramb);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static float a(r paramr, int paramInt)
    {
      AppMethodBeat.i(205719);
      s.u(paramr, "this");
      paramr = (i)paramr;
      s.u(paramr, "this");
      float f = d.a.a((d)paramr, paramInt);
      AppMethodBeat.o(205719);
      return f;
    }
    
    public static float a(r paramr, long paramLong)
    {
      AppMethodBeat.i(205714);
      s.u(paramr, "this");
      paramr = (i)paramr;
      s.u(paramr, "this");
      float f = d.a.a((d)paramr, paramLong);
      AppMethodBeat.o(205714);
      return f;
    }
    
    public static int a(r paramr, float paramFloat)
    {
      AppMethodBeat.i(205701);
      s.u(paramr, "this");
      paramr = (i)paramr;
      s.u(paramr, "this");
      int i = d.a.b((d)paramr, paramFloat);
      AppMethodBeat.o(205701);
      return i;
    }
    
    public static q a(final r paramr, int paramInt1, final int paramInt2, final Map<a, Integer> paramMap, final b<? super x.a, ah> paramb)
    {
      AppMethodBeat.i(205685);
      s.u(paramr, "this");
      s.u(paramMap, "alignmentLines");
      s.u(paramb, "placementBlock");
      paramr = (q)new a(paramInt1, paramInt2, paramMap, paramr, paramb);
      AppMethodBeat.o(205685);
      return paramr;
    }
    
    public static float b(r paramr, float paramFloat)
    {
      AppMethodBeat.i(205705);
      s.u(paramr, "this");
      paramr = (i)paramr;
      s.u(paramr, "this");
      paramFloat = d.a.a((d)paramr, paramFloat);
      AppMethodBeat.o(205705);
      return paramFloat;
    }
    
    public static long c(r paramr, float paramFloat)
    {
      AppMethodBeat.i(205710);
      s.u(paramr, "this");
      paramr = (i)paramr;
      s.u(paramr, "this");
      long l = d.a.c((d)paramr, paramFloat);
      AppMethodBeat.o(205710);
      return l;
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/ui/layout/MeasureScope$layout$1", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "width", "getWidth", "placeChildren", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements q
    {
      private final Map<a, Integer> aMO;
      private final int height;
      private final int width;
      
      a(int paramInt1, int paramInt2, Map<a, Integer> paramMap, r paramr, b<? super x.a, ah> paramb)
      {
        AppMethodBeat.i(205688);
        this.width = this.aMP;
        this.height = paramInt2;
        this.aMO = paramMap;
        AppMethodBeat.o(205688);
      }
      
      public final int getHeight()
      {
        return this.height;
      }
      
      public final int getWidth()
      {
        return this.width;
      }
      
      public final Map<a, Integer> wL()
      {
        return this.aMO;
      }
      
      public final void wM()
      {
        AppMethodBeat.i(205708);
        x.a.a locala1 = x.a.aMX;
        int i = this.aMP;
        n localn = paramr.getLayoutDirection();
        b localb = paramb;
        Object localObject = x.a.aMX;
        int j = x.a.a.wV();
        localObject = x.a.aMX;
        localObject = x.a.a.wW();
        x.a.a locala2 = x.a.aMX;
        x.a.cP(i);
        locala2 = x.a.aMX;
        x.a.d(localn);
        localb.invoke(locala1);
        locala1 = x.a.aMX;
        x.a.cP(j);
        locala1 = x.a.aMX;
        x.a.d((n)localObject);
        AppMethodBeat.o(205708);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.r
 * JD-Core Version:    0.7.0.1
 */