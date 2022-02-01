package androidx.compose.ui.e.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "", "name", "", "defaultWidth", "Landroidx/compose/ui/unit/Dp;", "defaultHeight", "viewportWidth", "", "viewportHeight", "tintColor", "Landroidx/compose/ui/graphics/Color;", "tintBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "(Ljava/lang/String;FFFFJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "currentGroup", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "getCurrentGroup", "()Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "F", "isConsumed", "", "nodes", "Landroidx/compose/ui/graphics/vector/Stack;", "Ljava/util/ArrayList;", "root", "I", "J", "addGroup", "rotate", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "addPath", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "addPath-oIyEayM", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFF)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "build", "Landroidx/compose/ui/graphics/vector/ImageVector;", "clearGroup", "ensureNotConsumed", "", "asVectorGroup", "Landroidx/compose/ui/graphics/vector/VectorGroup;", "GroupParams", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
{
  public static final int Ue = 8;
  private final float aAY;
  private final float aAZ;
  private final float aBa;
  private final float aBb;
  private final long aBd;
  private final int aBe;
  private final ArrayList<a> aBf;
  private a aBg;
  private boolean aBh;
  private final String name;
  
  private d$a(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, long paramLong, int paramInt)
  {
    AppMethodBeat.i(206359);
    this.name = paramString;
    this.aAY = paramFloat1;
    this.aAZ = paramFloat2;
    this.aBa = paramFloat3;
    this.aBb = paramFloat4;
    this.aBd = paramLong;
    this.aBe = paramInt;
    paramString = new ArrayList();
    s.u(paramString, "backing");
    this.aBf = paramString;
    this.aBg = new a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, null, null, 1023);
    h.b(this.aBf, this.aBg);
    AppMethodBeat.o(206359);
  }
  
  private static m a(a parama)
  {
    AppMethodBeat.i(206369);
    parama = new m(parama.name, parama.aBi, parama.aAU, parama.aAV, parama.scaleX, parama.scaleY, parama.ayc, parama.ayd, parama.aAP, parama.aAO);
    AppMethodBeat.o(206369);
    return parama;
  }
  
  public final a a(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, List<? extends f> paramList)
  {
    AppMethodBeat.i(206375);
    s.u(paramString, "name");
    s.u(paramList, "clipPathData");
    uU();
    paramString = new a(paramString, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, paramFloat7, paramList, null, 512);
    h.b(this.aBf, paramString);
    AppMethodBeat.o(206375);
    return this;
  }
  
  public final a uR()
  {
    AppMethodBeat.i(206373);
    Object localObject = this.aBf;
    s.u(localObject, "arg0");
    localObject = (a)((ArrayList)localObject).get(h.b((ArrayList)localObject) - 1);
    AppMethodBeat.o(206373);
    return localObject;
  }
  
  public final a uS()
  {
    AppMethodBeat.i(206376);
    uU();
    Object localObject = this.aBf;
    s.u(localObject, "arg0");
    localObject = (a)((ArrayList)localObject).remove(h.b((ArrayList)localObject) - 1);
    uR().aAO.add(a((a)localObject));
    AppMethodBeat.o(206376);
    return this;
  }
  
  public final d uT()
  {
    AppMethodBeat.i(206380);
    uU();
    while (h.b(this.aBf) > 1) {
      uS();
    }
    d locald = new d(this.name, this.aAY, this.aAZ, this.aBa, this.aBb, a(this.aBg), this.aBd, this.aBe, (byte)0);
    this.aBh = true;
    AppMethodBeat.o(206380);
    return locald;
  }
  
  public final void uU()
  {
    AppMethodBeat.i(206384);
    if (!this.aBh) {}
    for (int i = 1; i == 0; i = 0)
    {
      Throwable localThrowable = (Throwable)new IllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector".toString());
      AppMethodBeat.o(206384);
      throw localThrowable;
    }
    AppMethodBeat.o(206384);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/ImageVector$Builder$GroupParams;", "", "name", "", "rotate", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "", "Landroidx/compose/ui/graphics/vector/VectorNode;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getClipPathData", "setClipPathData", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getPivotX", "()F", "setPivotX", "(F)V", "getPivotY", "setPivotY", "getRotate", "setRotate", "getScaleX", "setScaleX", "getScaleY", "setScaleY", "getTranslationX", "setTranslationX", "getTranslationY", "setTranslationY", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public List<o> aAO;
    List<? extends f> aAP;
    float aAU;
    float aAV;
    float aBi;
    float ayc;
    float ayd;
    String name;
    float scaleX;
    float scaleY;
    
    public a()
    {
      this(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, null, null, 1023);
    }
    
    private a(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, List<? extends f> paramList, List<o> paramList1)
    {
      AppMethodBeat.i(206445);
      this.name = paramString;
      this.aBi = paramFloat1;
      this.aAU = paramFloat2;
      this.aAV = paramFloat3;
      this.scaleX = paramFloat4;
      this.scaleY = paramFloat5;
      this.ayc = paramFloat6;
      this.ayd = paramFloat7;
      this.aAP = paramList;
      this.aAO = paramList1;
      AppMethodBeat.o(206445);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.compose.ui.e.d.d.a
 * JD-Core Version:    0.7.0.1
 */