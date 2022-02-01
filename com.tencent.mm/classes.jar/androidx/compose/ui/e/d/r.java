package androidx.compose.ui.e.d;

import androidx.compose.runtime.ba;
import androidx.compose.runtime.c.c;
import androidx.compose.runtime.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"RootGroupName", "", "RenderVectorGroup", "", "group", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "overrides", "", "Landroidx/compose/ui/graphics/vector/VectorOverride;", "(Landroidx/compose/ui/graphics/vector/VectorGroup;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)V", "rememberVectorPainter", "Landroidx/compose/ui/graphics/vector/VectorPainter;", "image", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/VectorPainter;", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "name", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "rememberVectorPainter-mlNsNFs", "(FFFFLjava/lang/String;JILkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/vector/VectorPainter;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final void a(m paramm, final Map<String, ? extends p> paramMap, final h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(206382);
    kotlin.g.b.s.u(paramm, "group");
    h localh = paramh.by(-326287540);
    int i;
    if ((paramInt2 & 0x1) != 0)
    {
      i = 6;
      i |= paramInt1;
    }
    for (;;)
    {
      int j = i;
      if ((paramInt2 & 0x2) != 0) {
        j = i | 0x10;
      }
      if ((((paramInt2 ^ 0xFFFFFFFF) & 0x2) != 0) || ((j & 0x5B ^ 0x12) != 0) || (!localh.nZ()))
      {
        label127:
        Iterator localIterator;
        if (((paramInt1 & 0x1) == 0) || (localh.oa()))
        {
          localh.of();
          if ((paramInt2 & 0x2) != 0) {
            paramMap = ak.kkZ();
          }
          localh.og();
          localIterator = paramm.iterator();
        }
        for (;;)
        {
          label133:
          paramh = paramMap;
          if (!localIterator.hasNext()) {
            break label693;
          }
          o localo = (o)localIterator.next();
          if ((localo instanceof s))
          {
            localh.bx(-326287363);
            paramh = (p)paramMap.get(((s)localo).name);
            if (paramh == null) {
              paramh = (p)a.aAI;
            }
            for (;;)
            {
              l.a(paramh.Q(((s)localo).aBl), ((s)localo).aBm, ((s)localo).name, paramh.a(((s)localo).aBj), paramh.T(((s)localo).aBk), paramh.b(((s)localo).aBp), paramh.Z(((s)localo).aBn), paramh.aa(((s)localo).aBo), ((s)localo).aBq, ((s)localo).aBr, ((s)localo).aBs, paramh.af(((s)localo).aBt), paramh.ad(((s)localo).aBu), paramh.ae(((s)localo).aBv), localh, 8, 0, 0);
              localh.od();
              break label133;
              if ((paramInt1 & 0xE) != 0) {
                break label732;
              }
              if (localh.G(paramm))
              {
                i = 4;
                break;
              }
              i = 2;
              break;
              localh.oj();
              break label127;
            }
          }
          if ((localo instanceof m))
          {
            localh.bx(-326286219);
            paramh = (p)paramMap.get(((m)localo).name);
            if (paramh == null) {
              paramh = (p)a.aAI;
            }
            for (;;)
            {
              String str = ((m)localo).name;
              float f1 = paramh.W(((m)localo).rotation);
              float f2 = paramh.X(((m)localo).scaleX);
              float f3 = paramh.Y(((m)localo).scaleY);
              float f4 = paramh.ab(((m)localo).ayc);
              float f5 = paramh.ac(((m)localo).ayd);
              l.a(str, f1, paramh.U(((m)localo).aAU), paramh.V(((m)localo).aAV), f2, f3, f4, f5, paramh.Q(((m)localo).aAP), (kotlin.g.a.m)c.a(localh, -819898735, new a(localo, paramMap)), localh, 939524096, 0);
              localh.od();
              break;
            }
          }
          localh.bx(-326285376);
          localh.od();
        }
      }
      localh.oi();
      paramh = paramMap;
      label693:
      paramMap = localh.oh();
      if (paramMap != null) {
        paramMap.b((kotlin.g.a.m)new b(paramm, paramh, paramInt1, paramInt2));
      }
      AppMethodBeat.o(206382);
      return;
      label732:
      i = paramInt1;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    a(o paramo, Map<String, ? extends p> paramMap)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    b(m paramm, Map<String, ? extends p> paramMap, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public c(q paramq, long paramLong, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements kotlin.g.a.r<Float, Float, h, Integer, ah>
  {
    public d(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.r
 * JD-Core Version:    0.7.0.1
 */