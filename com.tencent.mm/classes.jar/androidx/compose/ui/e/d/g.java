package androidx.compose.ui.e.d;

import androidx.compose.ui.e.ao;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.k.e;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathParser;", "", "()V", "ctrlPoint", "Landroidx/compose/ui/graphics/vector/PathParser$PathPoint;", "currentPoint", "nodes", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "reflectiveCtrlPoint", "segmentPoint", "addNode", "", "cmd", "", "args", "", "addPathNodes", "", "arcToBezier", "p", "Landroidx/compose/ui/graphics/Path;", "cx", "", "cy", "a", "b", "e1x", "e1y", "theta", "start", "sweep", "clear", "close", "target", "copyOfRange", "original", "", "end", "drawArc", "x0", "y0", "x1", "y1", "isMoreThanHalf", "", "isPositiveArc", "extract", "s", "", "result", "Landroidx/compose/ui/graphics/vector/PathParser$ExtractFloatResult;", "getFloats", "nextStart", "parsePathString", "pathData", "toNodes", "toPath", "arcTo", "Landroidx/compose/ui/graphics/vector/PathNode$ArcTo;", "curveTo", "Landroidx/compose/ui/graphics/vector/PathNode$CurveTo;", "horizontalTo", "Landroidx/compose/ui/graphics/vector/PathNode$HorizontalTo;", "lineTo", "Landroidx/compose/ui/graphics/vector/PathNode$LineTo;", "moveTo", "Landroidx/compose/ui/graphics/vector/PathNode$MoveTo;", "quadTo", "Landroidx/compose/ui/graphics/vector/PathNode$QuadTo;", "reflectiveCurveTo", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveCurveTo;", "prevIsCurve", "reflectiveQuadTo", "Landroidx/compose/ui/graphics/vector/PathNode$ReflectiveQuadTo;", "prevIsQuad", "relativeArcTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeArcTo;", "relativeCurveTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeCurveTo;", "relativeHorizontalTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeHorizontalTo;", "relativeLineTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeLineTo;", "relativeMoveTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeMoveTo;", "relativeQuadTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeQuadTo;", "relativeReflectiveCurveTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveCurveTo;", "relativeReflectiveQuadTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeReflectiveQuadTo;", "relativeVerticalTo", "Landroidx/compose/ui/graphics/vector/PathNode$RelativeVerticalTo;", "toRadians", "", "verticalTo", "Landroidx/compose/ui/graphics/vector/PathNode$VerticalTo;", "ExtractFloatResult", "PathPoint", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private final g.b aBY;
  private final g.b aBZ;
  private final g.b aCa;
  private final g.b aCb;
  final List<f> nodes;
  
  public g()
  {
    AppMethodBeat.i(206444);
    this.nodes = ((List)new ArrayList());
    this.aBY = new g.b((byte)0);
    this.aBZ = new g.b((byte)0);
    this.aCa = new g.b((byte)0);
    this.aCb = new g.b((byte)0);
    AppMethodBeat.o(206444);
  }
  
  private static void a(ao paramao, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
  {
    AppMethodBeat.i(206625);
    int j = (int)Math.ceil(Math.abs(4.0D * paramDouble9 / 3.141592653589793D));
    double d6 = Math.cos(paramDouble7);
    double d7 = Math.sin(paramDouble7);
    paramDouble7 = Math.cos(paramDouble8);
    double d2 = Math.sin(paramDouble8);
    double d1 = -paramDouble3 * d6 * d2 - paramDouble4 * d7 * paramDouble7;
    d2 = paramDouble7 * (paramDouble4 * d6) + d2 * (-paramDouble3 * d7);
    double d8 = paramDouble9 / j;
    int i = 0;
    if (j > 0)
    {
      paramDouble9 = paramDouble8;
      paramDouble8 = paramDouble6;
      paramDouble7 = paramDouble5;
      paramDouble6 = d1;
      paramDouble5 = d2;
    }
    for (;;)
    {
      i += 1;
      double d3 = paramDouble9 + d8;
      double d5 = Math.sin(d3);
      double d9 = Math.cos(d3);
      d1 = paramDouble3 * d6 * d9 + paramDouble1 - paramDouble4 * d7 * d5;
      d2 = paramDouble4 * d6 * d5 + (paramDouble3 * d7 * d9 + paramDouble2);
      double d4 = -paramDouble3 * d6 * d5 - paramDouble4 * d7 * d9;
      d5 = d9 * (paramDouble4 * d6) + d5 * (-paramDouble3 * d7);
      d9 = Math.tan((d3 - paramDouble9) / 2.0D);
      paramDouble9 = Math.sin(d3 - paramDouble9);
      paramDouble9 = (Math.sqrt(d9 * (3.0D * d9) + 4.0D) - 1.0D) * paramDouble9 / 3.0D;
      paramao.b((float)(paramDouble6 * paramDouble9 + paramDouble7), (float)(paramDouble8 + paramDouble5 * paramDouble9), (float)(d1 - paramDouble9 * d4), (float)(d2 - paramDouble9 * d5), (float)d1, (float)d2);
      if (i >= j)
      {
        AppMethodBeat.o(206625);
        return;
      }
      paramDouble5 = d5;
      paramDouble6 = d4;
      paramDouble9 = d3;
      paramDouble8 = d2;
      paramDouble7 = d1;
    }
  }
  
  private static void a(ao paramao, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(206616);
    double d1 = paramDouble5;
    paramDouble5 = paramDouble6;
    paramDouble6 = d1;
    double d2;
    double d3;
    double d4;
    double d6;
    double d7;
    double d5;
    double d11;
    double d10;
    double d9;
    double d8;
    double d13;
    for (;;)
    {
      d2 = o(paramDouble7);
      d3 = Math.cos(d2);
      d4 = Math.sin(d2);
      d6 = (paramDouble1 * d3 + paramDouble2 * d4) / paramDouble6;
      d7 = (-paramDouble1 * d4 + paramDouble2 * d3) / paramDouble5;
      d1 = (paramDouble3 * d3 + paramDouble4 * d4) / paramDouble6;
      d5 = (-paramDouble3 * d4 + paramDouble4 * d3) / paramDouble5;
      d11 = d6 - d1;
      d10 = d7 - d5;
      d9 = (d6 + d1) / 2.0D;
      d8 = (d7 + d5) / 2.0D;
      double d12 = d11 * d11 + d10 * d10;
      if (d12 == 0.0D) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(206616);
        return;
      }
      d13 = 1.0D / d12 - 0.25D;
      if (d13 >= 0.0D) {
        break;
      }
      float f = (float)(Math.sqrt(d12) / 1.99999D);
      paramDouble6 *= f;
      paramDouble5 *= f;
    }
    paramDouble4 = Math.sqrt(d13);
    paramDouble3 = d11 * paramDouble4;
    paramDouble4 = d10 * paramDouble4;
    if (paramBoolean1 == paramBoolean2)
    {
      paramDouble7 = d9 - paramDouble4;
      paramDouble4 = paramDouble3 + d8;
      d6 = Math.atan2(d7 - paramDouble4, d6 - paramDouble7);
      d1 = Math.atan2(d5 - paramDouble4, d1 - paramDouble7) - d6;
      if (d1 < 0.0D) {
        break label410;
      }
      paramBoolean1 = true;
      label309:
      paramDouble3 = d1;
      if (paramBoolean2 != paramBoolean1) {
        if (d1 <= 0.0D) {
          break label416;
        }
      }
    }
    label410:
    label416:
    for (paramDouble3 = d1 - 6.283185307179586D;; paramDouble3 = d1 + 6.283185307179586D)
    {
      paramDouble7 *= paramDouble6;
      paramDouble4 *= paramDouble5;
      a(paramao, paramDouble7 * d3 - paramDouble4 * d4, paramDouble7 * d4 + d3 * paramDouble4, paramDouble6, paramDouble5, paramDouble1, paramDouble2, d2, d6, paramDouble3);
      AppMethodBeat.o(206616);
      return;
      paramDouble7 = paramDouble4 + d9;
      paramDouble4 = d8 - paramDouble3;
      break;
      paramBoolean1 = false;
      break label309;
    }
  }
  
  private final void a(f.a parama, ao paramao)
  {
    AppMethodBeat.i(206610);
    a(paramao, this.aBY.x, this.aBY.y, parama.aBL, parama.aBM, parama.aBG, parama.aBH, parama.aBI, parama.aBJ, parama.aBK);
    this.aBY.x = parama.aBL;
    this.aBY.y = parama.aBM;
    this.aBZ.x = this.aBY.x;
    this.aBZ.y = this.aBY.y;
    AppMethodBeat.o(206610);
  }
  
  private final void a(f.c paramc, ao paramao)
  {
    AppMethodBeat.i(206535);
    paramao.b(paramc.x1, paramc.y1, paramc.x2, paramc.y2, paramc.x3, paramc.y3);
    this.aBZ.x = paramc.x2;
    this.aBZ.y = paramc.y2;
    this.aBY.x = paramc.x3;
    this.aBY.y = paramc.y3;
    AppMethodBeat.o(206535);
  }
  
  private final void a(f.d paramd, ao paramao)
  {
    AppMethodBeat.i(206513);
    paramao.D(paramd.x, this.aBY.y);
    this.aBY.x = paramd.x;
    AppMethodBeat.o(206513);
  }
  
  private final void a(f.e parame, ao paramao)
  {
    AppMethodBeat.i(206494);
    paramao.D(parame.x, parame.y);
    this.aBY.x = parame.x;
    this.aBY.y = parame.y;
    AppMethodBeat.o(206494);
  }
  
  private final void a(f.f paramf, ao paramao)
  {
    AppMethodBeat.i(206474);
    this.aBY.x = paramf.x;
    this.aBY.y = paramf.y;
    paramao.B(paramf.x, paramf.y);
    this.aCa.x = this.aBY.x;
    this.aCa.y = this.aBY.y;
    AppMethodBeat.o(206474);
  }
  
  private final void a(f.g paramg, ao paramao)
  {
    AppMethodBeat.i(206575);
    paramao.b(paramg.x1, paramg.y1, paramg.x2, paramg.y2);
    this.aBZ.x = paramg.x1;
    this.aBZ.y = paramg.y1;
    this.aBY.x = paramg.x2;
    this.aBY.y = paramg.y2;
    AppMethodBeat.o(206575);
  }
  
  private final void a(f.h paramh, boolean paramBoolean, ao paramao)
  {
    AppMethodBeat.i(206559);
    if (paramBoolean) {
      this.aCb.x = (this.aBY.x * 2.0F - this.aBZ.x);
    }
    for (this.aCb.y = (this.aBY.y * 2.0F - this.aBZ.y);; this.aCb.y = this.aBY.y)
    {
      paramao.b(this.aCb.x, this.aCb.y, paramh.x1, paramh.y1, paramh.x2, paramh.y2);
      this.aBZ.x = paramh.x1;
      this.aBZ.y = paramh.y1;
      this.aBY.x = paramh.x2;
      this.aBY.y = paramh.y2;
      AppMethodBeat.o(206559);
      return;
      this.aCb.x = this.aBY.x;
    }
  }
  
  private final void a(f.i parami, boolean paramBoolean, ao paramao)
  {
    AppMethodBeat.i(206595);
    if (paramBoolean) {
      this.aCb.x = (this.aBY.x * 2.0F - this.aBZ.x);
    }
    for (this.aCb.y = (this.aBY.y * 2.0F - this.aBZ.y);; this.aCb.y = this.aBY.y)
    {
      paramao.b(this.aCb.x, this.aCb.y, parami.x, parami.y);
      this.aBZ.x = this.aCb.x;
      this.aBZ.y = this.aCb.y;
      this.aBY.x = parami.x;
      this.aBY.y = parami.y;
      AppMethodBeat.o(206595);
      return;
      this.aCb.x = this.aBY.x;
    }
  }
  
  private final void a(f.j paramj, ao paramao)
  {
    AppMethodBeat.i(206601);
    float f1 = paramj.aBO + this.aBY.x;
    float f2 = paramj.aBP + this.aBY.y;
    a(paramao, this.aBY.x, this.aBY.y, f1, f2, paramj.aBG, paramj.aBH, paramj.aBI, paramj.aBJ, paramj.aBK);
    this.aBY.x = f1;
    this.aBY.y = f2;
    this.aBZ.x = this.aBY.x;
    this.aBZ.y = this.aBY.y;
    AppMethodBeat.o(206601);
  }
  
  private final void a(f.k paramk, ao paramao)
  {
    AppMethodBeat.i(206533);
    paramao.c(paramk.aBQ, paramk.aBR, paramk.aBS, paramk.aBT, paramk.aBU, paramk.aBV);
    this.aBZ.x = (this.aBY.x + paramk.aBS);
    this.aBZ.y = (this.aBY.y + paramk.aBT);
    paramao = this.aBY;
    paramao.x += paramk.aBU;
    paramao = this.aBY;
    paramao.y += paramk.aBV;
    AppMethodBeat.o(206533);
  }
  
  private final void a(f.l paraml, ao paramao)
  {
    AppMethodBeat.i(206500);
    paramao.E(paraml.aBW, 0.0F);
    paramao = this.aBY;
    paramao.x += paraml.aBW;
    AppMethodBeat.o(206500);
  }
  
  private final void a(f.m paramm, ao paramao)
  {
    AppMethodBeat.i(206487);
    paramao.E(paramm.aBW, paramm.aBX);
    paramao = this.aBY;
    paramao.x += paramm.aBW;
    paramao = this.aBY;
    paramao.y += paramm.aBX;
    AppMethodBeat.o(206487);
  }
  
  private final void a(f.n paramn, ao paramao)
  {
    AppMethodBeat.i(206461);
    g.b localb = this.aBY;
    localb.x += paramn.aBW;
    localb = this.aBY;
    localb.y += paramn.aBX;
    paramao.C(paramn.aBW, paramn.aBX);
    this.aCa.x = this.aBY.x;
    this.aCa.y = this.aBY.y;
    AppMethodBeat.o(206461);
  }
  
  private final void a(f.o paramo, ao paramao)
  {
    AppMethodBeat.i(206566);
    paramao.c(paramo.aBQ, paramo.aBR, paramo.aBS, paramo.aBT);
    this.aBZ.x = (this.aBY.x + paramo.aBQ);
    this.aBZ.y = (this.aBY.y + paramo.aBR);
    paramao = this.aBY;
    paramao.x += paramo.aBQ;
    paramao = this.aBY;
    paramao.y += paramo.aBR;
    AppMethodBeat.o(206566);
  }
  
  private final void a(f.p paramp, boolean paramBoolean, ao paramao)
  {
    AppMethodBeat.i(206550);
    if (paramBoolean)
    {
      this.aCb.x = (this.aBY.x - this.aBZ.x);
      this.aCb.y = (this.aBY.y - this.aBZ.y);
    }
    for (;;)
    {
      paramao.c(this.aCb.x, this.aCb.y, paramp.aBQ, paramp.aBR, paramp.aBS, paramp.aBT);
      this.aBZ.x = (this.aBY.x + paramp.aBQ);
      this.aBZ.y = (this.aBY.y + paramp.aBR);
      paramao = this.aBY;
      paramao.x += paramp.aBS;
      paramao = this.aBY;
      paramao.y += paramp.aBT;
      AppMethodBeat.o(206550);
      return;
      this.aCb.reset();
    }
  }
  
  private final void a(f.q paramq, boolean paramBoolean, ao paramao)
  {
    AppMethodBeat.i(206585);
    if (paramBoolean)
    {
      this.aCb.x = (this.aBY.x - this.aBZ.x);
      this.aCb.y = (this.aBY.y - this.aBZ.y);
    }
    for (;;)
    {
      paramao.c(this.aCb.x, this.aCb.y, paramq.aBW, paramq.aBX);
      this.aBZ.x = (this.aBY.x + this.aCb.x);
      this.aBZ.y = (this.aBY.y + this.aCb.y);
      paramao = this.aBY;
      paramao.x += paramq.aBW;
      paramao = this.aBY;
      paramao.y += paramq.aBX;
      AppMethodBeat.o(206585);
      return;
      this.aCb.reset();
    }
  }
  
  private final void a(f.r paramr, ao paramao)
  {
    AppMethodBeat.i(206522);
    paramao.E(0.0F, paramr.aBX);
    paramao = this.aBY;
    paramao.y += paramr.aBX;
    AppMethodBeat.o(206522);
  }
  
  private final void a(f.s params, ao paramao)
  {
    AppMethodBeat.i(206527);
    paramao.D(this.aBY.x, params.y);
    this.aBY.y = params.y;
    AppMethodBeat.o(206527);
  }
  
  private final void c(ao paramao)
  {
    AppMethodBeat.i(206455);
    this.aBY.x = this.aCa.x;
    this.aBY.y = this.aCa.y;
    this.aBZ.x = this.aCa.x;
    this.aBZ.y = this.aCa.y;
    paramao.close();
    paramao.B(this.aBY.x, this.aBY.y);
    AppMethodBeat.o(206455);
  }
  
  private static double o(double paramDouble)
  {
    return paramDouble / 180.0D * 3.141592653589793D;
  }
  
  public final g R(List<? extends f> paramList)
  {
    AppMethodBeat.i(206645);
    s.u(paramList, "nodes");
    this.nodes.addAll((Collection)paramList);
    AppMethodBeat.o(206645);
    return this;
  }
  
  final void a(char paramChar, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206672);
    List localList = this.nodes;
    s.u(paramArrayOfFloat, "args");
    int i;
    if (paramChar == 'z')
    {
      i = 1;
      if (i == 0) {
        break label77;
      }
      paramArrayOfFloat = p.listOf(f.b.aBN);
    }
    for (;;)
    {
      localList.addAll((Collection)paramArrayOfFloat);
      AppMethodBeat.o(206672);
      return;
      if (paramChar == 'Z')
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label77:
      Object localObject1;
      Object localObject2;
      Object localObject3;
      float[] arrayOfFloat;
      if (paramChar == 'm')
      {
        localObject1 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 2), 2);
        localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          i = ((ah)localObject3).Zo();
          arrayOfFloat = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 2)));
          localObject1 = (f)new f.n(arrayOfFloat[0], arrayOfFloat[1]);
          if (i > 0) {
            localObject1 = (f)new f.m(arrayOfFloat[0], arrayOfFloat[1]);
          }
          ((Collection)localObject2).add(localObject1);
        }
        paramArrayOfFloat = (List)localObject2;
      }
      else if (paramChar == 'M')
      {
        localObject1 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 2), 2);
        localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
        localObject3 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          i = ((ah)localObject3).Zo();
          arrayOfFloat = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 2)));
          localObject1 = (f)new f.f(arrayOfFloat[0], arrayOfFloat[1]);
          if (i > 0) {
            localObject1 = (f)new f.e(arrayOfFloat[0], arrayOfFloat[1]);
          }
          ((Collection)localObject2).add(localObject1);
        }
        paramArrayOfFloat = (List)localObject2;
      }
      else if (paramChar == 'l')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 2), 2);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 2)));
          ((Collection)localObject1).add((f)new f.m(localObject3[0], localObject3[1]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'L')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 2), 2);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 2)));
          ((Collection)localObject1).add((f)new f.e(localObject3[0], localObject3[1]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'h')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 1), 1);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          ((Collection)localObject1).add((f)new f.l(p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 1)))[0]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'H')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 1), 1);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          ((Collection)localObject1).add((f)new f.d(p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 1)))[0]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'v')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 1), 1);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          ((Collection)localObject1).add((f)new f.r(p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 1)))[0]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'V')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 1), 1);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          ((Collection)localObject1).add((f)new f.s(p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 1)))[0]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'c')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 6), 6);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 6)));
          ((Collection)localObject1).add((f)new f.k(localObject3[0], localObject3[1], localObject3[2], localObject3[3], localObject3[4], localObject3[5]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'C')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 6), 6);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 6)));
          ((Collection)localObject1).add((f)new f.c(localObject3[0], localObject3[1], localObject3[2], localObject3[3], localObject3[4], localObject3[5]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 's')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 4), 4);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 4)));
          ((Collection)localObject1).add((f)new f.p(localObject3[0], localObject3[1], localObject3[2], localObject3[3]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'S')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 4), 4);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 4)));
          ((Collection)localObject1).add((f)new f.h(localObject3[0], localObject3[1], localObject3[2], localObject3[3]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'q')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 4), 4);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 4)));
          ((Collection)localObject1).add((f)new f.o(localObject3[0], localObject3[1], localObject3[2], localObject3[3]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'Q')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 4), 4);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 4)));
          ((Collection)localObject1).add((f)new f.g(localObject3[0], localObject3[1], localObject3[2], localObject3[3]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 't')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 2), 2);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 2)));
          ((Collection)localObject1).add((f)new f.q(localObject3[0], localObject3[1]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else if (paramChar == 'T')
      {
        localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 2), 2);
        localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((ah)localObject2).Zo();
          localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 2)));
          ((Collection)localObject1).add((f)new f.i(localObject3[0], localObject3[1]));
        }
        paramArrayOfFloat = (List)localObject1;
      }
      else
      {
        float f1;
        float f2;
        float f3;
        boolean bool1;
        label2498:
        boolean bool2;
        if (paramChar == 'a')
        {
          localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 7), 7);
          localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            i = ((ah)localObject2).Zo();
            localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 7)));
            f1 = localObject3[0];
            f2 = localObject3[1];
            f3 = localObject3[2];
            if (Float.compare(localObject3[3], 0.0F) != 0)
            {
              bool1 = true;
              if (Float.compare(localObject3[4], 0.0F) == 0) {
                break label2557;
              }
            }
            label2557:
            for (bool2 = true;; bool2 = false)
            {
              ((Collection)localObject1).add((f)new f.j(f1, f2, f3, bool1, bool2, localObject3[5], localObject3[6]));
              break;
              bool1 = false;
              break label2498;
            }
          }
          paramArrayOfFloat = (List)localObject1;
        }
        else
        {
          if (paramChar != 'A') {
            break label2779;
          }
          localObject2 = (Iterable)kotlin.k.k.a((e)new kotlin.k.g(0, paramArrayOfFloat.length - 7), 7);
          localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            i = ((ah)localObject2).Zo();
            localObject3 = p.H((Collection)kotlin.a.k.a(paramArrayOfFloat, kotlin.k.k.qt(i, i + 7)));
            f1 = localObject3[0];
            f2 = localObject3[1];
            f3 = localObject3[2];
            if (Float.compare(localObject3[3], 0.0F) != 0)
            {
              bool1 = true;
              label2705:
              if (Float.compare(localObject3[4], 0.0F) == 0) {
                break label2764;
              }
            }
            label2764:
            for (bool2 = true;; bool2 = false)
            {
              ((Collection)localObject1).add((f)new f.a(f1, f2, f3, bool1, bool2, localObject3[5], localObject3[6]));
              break;
              bool1 = false;
              break label2705;
            }
          }
          paramArrayOfFloat = (List)localObject1;
        }
      }
    }
    label2779:
    paramArrayOfFloat = new IllegalArgumentException(s.X("Unknown command for: ", Character.valueOf(paramChar)));
    AppMethodBeat.o(206672);
    throw paramArrayOfFloat;
  }
  
  public final ao b(ao paramao)
  {
    AppMethodBeat.i(206650);
    s.u(paramao, "target");
    paramao.reset();
    this.aBY.reset();
    this.aBZ.reset();
    this.aCa.reset();
    this.aCb.reset();
    Object localObject1 = null;
    List localList = this.nodes;
    int k = localList.size() - 1;
    int i;
    if (k >= 0) {
      i = 0;
    }
    for (;;)
    {
      int j = i + 1;
      f localf = (f)localList.get(i);
      if (localObject1 == null) {
        localObject1 = localf;
      }
      for (;;)
      {
        if ((localf instanceof f.b)) {
          c(paramao);
        }
        while (j > k)
        {
          AppMethodBeat.o(206650);
          return paramao;
          if ((localf instanceof f.n))
          {
            a((f.n)localf, paramao);
          }
          else if ((localf instanceof f.f))
          {
            a((f.f)localf, paramao);
          }
          else if ((localf instanceof f.m))
          {
            a((f.m)localf, paramao);
          }
          else if ((localf instanceof f.e))
          {
            a((f.e)localf, paramao);
          }
          else if ((localf instanceof f.l))
          {
            a((f.l)localf, paramao);
          }
          else if ((localf instanceof f.d))
          {
            a((f.d)localf, paramao);
          }
          else if ((localf instanceof f.r))
          {
            a((f.r)localf, paramao);
          }
          else if ((localf instanceof f.s))
          {
            a((f.s)localf, paramao);
          }
          else if ((localf instanceof f.k))
          {
            a((f.k)localf, paramao);
          }
          else if ((localf instanceof f.c))
          {
            a((f.c)localf, paramao);
          }
          else
          {
            Object localObject2;
            if ((localf instanceof f.p))
            {
              localObject2 = (f.p)localf;
              s.checkNotNull(localObject1);
              a((f.p)localObject2, localObject1.aBE, paramao);
            }
            else if ((localf instanceof f.h))
            {
              localObject2 = (f.h)localf;
              s.checkNotNull(localObject1);
              a((f.h)localObject2, localObject1.aBE, paramao);
            }
            else if ((localf instanceof f.o))
            {
              a((f.o)localf, paramao);
            }
            else if ((localf instanceof f.g))
            {
              a((f.g)localf, paramao);
            }
            else if ((localf instanceof f.q))
            {
              localObject2 = (f.q)localf;
              s.checkNotNull(localObject1);
              a((f.q)localObject2, localObject1.aBF, paramao);
            }
            else if ((localf instanceof f.i))
            {
              localObject2 = (f.i)localf;
              s.checkNotNull(localObject1);
              a((f.i)localObject2, localObject1.aBF, paramao);
            }
            else if ((localf instanceof f.j))
            {
              a((f.j)localf, paramao);
            }
            else if ((localf instanceof f.a))
            {
              a((f.a)localf, paramao);
            }
          }
        }
      }
      i = j;
      localObject1 = localf;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(206635);
    this.nodes.clear();
    AppMethodBeat.o(206635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.g
 * JD-Core Version:    0.7.0.1
 */