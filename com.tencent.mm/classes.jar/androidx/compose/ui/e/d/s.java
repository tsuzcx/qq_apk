package androidx.compose.ui.e.d;

import androidx.compose.ui.e.aq;
import androidx.compose.ui.e.bb;
import androidx.compose.ui.e.bc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ai;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/VectorPath;", "Landroidx/compose/ui/graphics/vector/VectorNode;", "name", "", "pathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "(Ljava/lang/String;Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFill", "()Landroidx/compose/ui/graphics/Brush;", "getFillAlpha", "()F", "getName", "()Ljava/lang/String;", "getPathData", "()Ljava/util/List;", "getPathFillType-Rg-k1Os", "()I", "I", "getStroke", "getStrokeAlpha", "getStrokeLineCap-KaPHkGw", "getStrokeLineJoin-LxFBmk8", "getStrokeLineMiter", "getStrokeLineWidth", "getTrimPathEnd", "getTrimPathOffset", "getTrimPathStart", "equals", "", "other", "", "hashCode", "", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends o
{
  final androidx.compose.ui.e.s aBj;
  final float aBk;
  final List<f> aBl;
  final int aBm;
  final float aBn;
  final float aBo;
  final androidx.compose.ui.e.s aBp;
  final int aBq;
  final int aBr;
  final float aBs;
  final float aBt;
  final float aBu;
  final float aBv;
  final String name;
  
  private s(String paramString, List<? extends f> paramList, int paramInt1, androidx.compose.ui.e.s params1, float paramFloat1, androidx.compose.ui.e.s params2, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    super((byte)0);
    this.name = paramString;
    this.aBl = paramList;
    this.aBm = paramInt1;
    this.aBj = params1;
    this.aBk = paramFloat1;
    this.aBp = params2;
    this.aBn = paramFloat2;
    this.aBo = paramFloat3;
    this.aBq = paramInt2;
    this.aBr = paramInt3;
    this.aBs = paramFloat4;
    this.aBt = paramFloat5;
    this.aBu = paramFloat6;
    this.aBv = paramFloat7;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206396);
    if (this == paramObject)
    {
      AppMethodBeat.o(206396);
      return true;
    }
    if ((paramObject == null) || (!kotlin.g.b.s.p(ai.cz(getClass()), ai.cz(paramObject.getClass()))))
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (!kotlin.g.b.s.p(this.name, ((s)paramObject).name))
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (!kotlin.g.b.s.p(this.aBj, ((s)paramObject).aBj))
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (this.aBk == ((s)paramObject).aBk) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (!kotlin.g.b.s.p(this.aBp, ((s)paramObject).aBp))
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (this.aBn == ((s)paramObject).aBn) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (this.aBo == ((s)paramObject).aBo) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (!bb.C(this.aBq, ((s)paramObject).aBq))
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (!bc.C(this.aBr, ((s)paramObject).aBr))
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (this.aBs == ((s)paramObject).aBs) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (this.aBt == ((s)paramObject).aBt) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (this.aBu == ((s)paramObject).aBu) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (this.aBv == ((s)paramObject).aBv) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (!aq.C(this.aBm, ((s)paramObject).aBm))
    {
      AppMethodBeat.o(206396);
      return false;
    }
    if (!kotlin.g.b.s.p(this.aBl, ((s)paramObject).aBl))
    {
      AppMethodBeat.o(206396);
      return false;
    }
    AppMethodBeat.o(206396);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(206402);
    int k = this.name.hashCode();
    int m = this.aBl.hashCode();
    androidx.compose.ui.e.s locals = this.aBj;
    int i;
    int n;
    if (locals == null)
    {
      i = 0;
      n = Float.floatToIntBits(this.aBk);
      locals = this.aBp;
      if (locals != null) {
        break label230;
      }
    }
    for (;;)
    {
      int i1 = Float.floatToIntBits(this.aBn);
      int i2 = Float.floatToIntBits(this.aBo);
      int i3 = bb.cG(this.aBq);
      int i4 = bc.cG(this.aBr);
      int i5 = Float.floatToIntBits(this.aBs);
      int i6 = Float.floatToIntBits(this.aBt);
      int i7 = Float.floatToIntBits(this.aBu);
      int i8 = Float.floatToIntBits(this.aBv);
      int i9 = aq.cG(this.aBm);
      AppMethodBeat.o(206402);
      return (((((((((((i + (k * 31 + m) * 31) * 31 + n) * 31 + j) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9;
      i = locals.hashCode();
      break;
      label230:
      j = locals.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.s
 * JD-Core Version:    0.7.0.1
 */