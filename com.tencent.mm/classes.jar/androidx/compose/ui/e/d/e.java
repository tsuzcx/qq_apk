package androidx.compose.ui.e.d;

import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.ar;
import androidx.compose.ui.e.b.e.b;
import androidx.compose.ui.e.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/PathComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "()V", "value", "Landroidx/compose/ui/graphics/Brush;", "fill", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "setFill", "(Landroidx/compose/ui/graphics/Brush;)V", "", "fillAlpha", "getFillAlpha", "()F", "setFillAlpha", "(F)V", "isPathDirty", "", "isStrokeDirty", "isTrimPathDirty", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "parser", "Landroidx/compose/ui/graphics/vector/PathParser;", "path", "Landroidx/compose/ui/graphics/Path;", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathData", "getPathData", "()Ljava/util/List;", "setPathData", "(Ljava/util/List;)V", "Landroidx/compose/ui/graphics/PathFillType;", "pathFillType", "getPathFillType-Rg-k1Os", "()I", "setPathFillType-oQ8Xj4U", "(I)V", "I", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "pathMeasure$delegate", "Lkotlin/Lazy;", "renderPath", "stroke", "getStroke", "setStroke", "strokeAlpha", "getStrokeAlpha", "setStrokeAlpha", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineCap", "getStrokeLineCap-KaPHkGw", "setStrokeLineCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineJoin", "getStrokeLineJoin-LxFBmk8", "setStrokeLineJoin-Ww9F2mQ", "strokeLineMiter", "getStrokeLineMiter", "setStrokeLineMiter", "strokeLineWidth", "getStrokeLineWidth", "setStrokeLineWidth", "strokeStyle", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "trimPathEnd", "getTrimPathEnd", "setTrimPathEnd", "trimPathOffset", "getTrimPathOffset", "setTrimPathOffset", "trimPathStart", "getTrimPathStart", "setTrimPathStart", "toString", "updatePath", "", "updateRenderPath", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends i
{
  private final g aAS;
  private final ao aBA;
  final ao aBB;
  private final kotlin.j aBC;
  androidx.compose.ui.e.s aBj;
  float aBk;
  List<? extends f> aBl;
  int aBm;
  float aBn;
  float aBo;
  androidx.compose.ui.e.s aBp;
  int aBq;
  int aBr;
  float aBs;
  float aBt;
  float aBu;
  float aBv;
  boolean aBw;
  boolean aBx;
  boolean aBy;
  private androidx.compose.ui.e.b.j aBz;
  String name;
  
  public e()
  {
    super((byte)0);
    AppMethodBeat.i(206462);
    this.name = "";
    this.aBk = 1.0F;
    this.aBl = n.uX();
    this.aBm = n.va();
    this.aBn = 1.0F;
    this.aBq = n.uY();
    this.aBr = n.uZ();
    this.aBs = 4.0F;
    this.aBu = 1.0F;
    this.aBw = true;
    this.aBx = true;
    this.aBy = true;
    this.aBA = m.sQ();
    this.aBB = m.sQ();
    this.aBC = k.a(o.aiuH, (a)a.aBD);
    this.aAS = new g();
    AppMethodBeat.o(206462);
  }
  
  private final ar uV()
  {
    AppMethodBeat.i(206472);
    ar localar = (ar)this.aBC.getValue();
    AppMethodBeat.o(206472);
    return localar;
  }
  
  private final void uW()
  {
    int j = 1;
    AppMethodBeat.i(206491);
    this.aBB.reset();
    if (this.aBt == 0.0F)
    {
      i = 1;
      if (i == 0) {
        break label99;
      }
      if (this.aBu != 1.0F) {
        break label93;
      }
    }
    label93:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label99;
      }
      ao localao1 = this.aBB;
      ao localao2 = this.aBA;
      androidx.compose.ui.d.e.a locala = androidx.compose.ui.d.e.avo;
      localao1.a(localao2, androidx.compose.ui.d.e.su());
      AppMethodBeat.o(206491);
      return;
      i = 0;
      break;
    }
    label99:
    uV().a(this.aBA);
    float f1 = uV().sP();
    float f2 = (this.aBt + this.aBv) % 1.0F * f1;
    float f3 = (this.aBu + this.aBv) % 1.0F * f1;
    if (f2 > f3)
    {
      uV().a(f2, f1, this.aBB);
      uV().a(0.0F, f3, this.aBB);
      AppMethodBeat.o(206491);
      return;
    }
    uV().a(f2, f3, this.aBB);
    AppMethodBeat.o(206491);
  }
  
  public final void c(androidx.compose.ui.e.b.e parame)
  {
    AppMethodBeat.i(206496);
    kotlin.g.b.s.u(parame, "<this>");
    if (this.aBw)
    {
      this.aAS.clear();
      this.aBA.reset();
      this.aAS.R(this.aBl).b(this.aBA);
      uW();
    }
    for (;;)
    {
      this.aBw = false;
      this.aBy = false;
      Object localObject = this.aBj;
      if (localObject != null) {
        e.b.a(parame, this.aBB, (androidx.compose.ui.e.s)localObject, this.aBk, null, 0, 56);
      }
      androidx.compose.ui.e.s locals = this.aBp;
      if (locals != null)
      {
        androidx.compose.ui.e.b.j localj = this.aBz;
        if (!this.aBx)
        {
          localObject = localj;
          if (localj != null) {}
        }
        else
        {
          localObject = new androidx.compose.ui.e.b.j(this.aBo, this.aBs, this.aBq, this.aBr, 16);
          this.aBz = ((androidx.compose.ui.e.b.j)localObject);
          this.aBx = false;
        }
        e.b.a(parame, this.aBB, locals, this.aBn, (androidx.compose.ui.e.b.f)localObject, 0, 48);
      }
      AppMethodBeat.o(206496);
      return;
      if (this.aBy) {
        uW();
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(206505);
    String str = this.aBA.toString();
    AppMethodBeat.o(206505);
    return str;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/graphics/PathMeasure;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ar>
  {
    public static final a aBD;
    
    static
    {
      AppMethodBeat.i(206378);
      aBD = new a();
      AppMethodBeat.o(206378);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.e
 * JD-Core Version:    0.7.0.1
 */