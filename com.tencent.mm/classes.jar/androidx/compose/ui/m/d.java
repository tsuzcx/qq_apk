package androidx.compose.ui.m;

import androidx.compose.ui.d.f;
import androidx.compose.ui.m.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/MultiParagraph;", "", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "ellipsis", "", "width", "", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;IZFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "intrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;IZF)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "firstBaseline", "getFirstBaseline", "()F", "height", "getHeight", "getIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "lastBaseline", "getLastBaseline", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "paragraphInfoList", "Landroidx/compose/ui/text/ParagraphInfo;", "getParagraphInfoList$ui_text_release", "()Ljava/util/List;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "getWidth", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBottom", "lineIndex", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "isLineEllipsized", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "color", "Landroidx/compose/ui/graphics/Color;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "requireIndexInRange", "requireIndexInRangeInclusiveEnd", "requireLineIndexInRange", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public final e aYN;
  final boolean aYO;
  public final int aYP;
  final List<androidx.compose.ui.d.g> aYQ;
  public final List<i> aYR;
  public final float height;
  private final int maxLines;
  public final float width;
  
  public d(e parame, int paramInt, boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(204964);
    this.aYN = parame;
    this.maxLines = paramInt;
    float f1 = 0.0F;
    paramInt = 0;
    Object localObject1 = (List)new ArrayList();
    parame = this.aYN.aYV;
    int m = parame.size() - 1;
    int i;
    int k;
    Object localObject2;
    Object localObject3;
    int j;
    float f2;
    if (m >= 0)
    {
      i = 0;
      k = i + 1;
      localObject2 = (j)parame.get(i);
      localObject3 = ((j)localObject2).aZb;
      j = this.maxLines;
      s.u(localObject3, "paragraphIntrinsics");
      s.u(localObject3, "paragraphIntrinsics");
      localObject3 = (h)new androidx.compose.ui.m.e.b((c)localObject3, j - paramInt, paramBoolean, paramFloat);
      f2 = f1 + ((h)localObject3).getHeight();
      j = paramInt + ((h)localObject3).getLineCount();
      ((List)localObject1).add(new i((h)localObject3, ((j)localObject2).startIndex, ((j)localObject2).endIndex, paramInt, j, f1, f2));
      if ((((h)localObject3).AJ()) || ((j == this.maxLines) && (i != p.oE(this.aYN.aYV)))) {
        paramBoolean = true;
      }
    }
    for (;;)
    {
      this.height = f2;
      this.aYP = j;
      this.aYO = paramBoolean;
      this.aYR = ((List)localObject1);
      this.width = paramFloat;
      localObject2 = new ArrayList(((List)localObject1).size());
      paramInt = 0;
      k = ((List)localObject1).size() - 1;
      label294:
      List localList;
      ArrayList localArrayList;
      if (k >= 0)
      {
        i = paramInt + 1;
        localObject3 = (i)((List)localObject1).get(paramInt);
        localList = ((i)localObject3).aYY.AK();
        localArrayList = new ArrayList(localList.size());
        paramInt = 0;
        m = localList.size() - 1;
        if (m < 0) {}
      }
      for (;;)
      {
        j = paramInt + 1;
        parame = localList.get(paramInt);
        Collection localCollection = (Collection)localArrayList;
        parame = (androidx.compose.ui.d.g)parame;
        if (parame == null) {}
        for (parame = null;; parame = ((i)localObject3).h(parame))
        {
          localCollection.add(parame);
          if (j <= m) {
            break label577;
          }
          parame = (Iterable)localArrayList;
          p.a((Collection)localObject2, parame);
          if (i <= k) {
            break label571;
          }
          localObject1 = (List)localObject2;
          parame = (e)localObject1;
          if (((List)localObject1).size() >= this.aYN.ahr.size()) {
            break label560;
          }
          parame = (Collection)localObject1;
          i = this.aYN.ahr.size() - ((List)localObject1).size();
          localObject1 = new ArrayList(i);
          paramInt = 0;
          while (paramInt < i)
          {
            ((ArrayList)localObject1).add(null);
            paramInt += 1;
          }
          if (k <= m) {
            break label583;
          }
          paramBoolean = false;
          break;
        }
        parame = p.b(parame, (Iterable)localObject1);
        label560:
        this.aYQ = parame;
        AppMethodBeat.o(204964);
        return;
        label571:
        paramInt = i;
        break label294;
        label577:
        paramInt = j;
      }
      label583:
      i = k;
      paramInt = j;
      f1 = f2;
      break;
      paramBoolean = false;
      j = 0;
      f2 = 0.0F;
    }
  }
  
  private final void dl(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(204972);
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt <= this.aYN.aYS.text.length()) {
        i = 1;
      }
    }
    if (i == 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException(("offset(" + paramInt + ") is out of bounds [0, " + this.aYN.aYS.length() + ']').toString());
      AppMethodBeat.o(204972);
      throw localThrowable;
    }
    AppMethodBeat.o(204972);
  }
  
  public final int aM(long paramLong)
  {
    AppMethodBeat.i(204991);
    if (androidx.compose.ui.d.e.G(paramLong) <= 0.0F) {
      i = 0;
    }
    i locali;
    for (;;)
    {
      locali = (i)this.aYR.get(i);
      if (locali.getLength() != 0) {
        break;
      }
      i = Math.max(0, locali.startIndex - 1);
      AppMethodBeat.o(204991);
      return i;
      if (androidx.compose.ui.d.e.G(paramLong) >= this.height) {
        i = p.oE(this.aYR);
      } else {
        i = g.b(this.aYR, androidx.compose.ui.d.e.G(paramLong));
      }
    }
    int i = locali.aYY.aM(f.x(androidx.compose.ui.d.e.F(paramLong), androidx.compose.ui.d.e.G(paramLong) - locali.top));
    int j = locali.startIndex;
    AppMethodBeat.o(204991);
    return j + i;
  }
  
  public final int ag(float paramFloat)
  {
    AppMethodBeat.i(204983);
    if (paramFloat <= 0.0F) {
      i = 0;
    }
    i locali;
    for (;;)
    {
      locali = (i)this.aYR.get(i);
      if (locali.getLength() != 0) {
        break;
      }
      i = Math.max(0, locali.startIndex - 1);
      AppMethodBeat.o(204983);
      return i;
      if (paramFloat >= this.height) {
        i = p.oE(this.aYR);
      } else {
        i = g.b(this.aYR, paramFloat);
      }
    }
    int i = locali.aYY.ag(paramFloat - locali.top);
    int j = locali.aYZ;
    AppMethodBeat.o(204983);
    return j + i;
  }
  
  public final androidx.compose.ui.m.f.b dh(int paramInt)
  {
    AppMethodBeat.i(204999);
    dl(paramInt);
    if (paramInt == this.aYN.aYS.length()) {}
    for (int i = p.oE(this.aYR);; i = g.h(this.aYR, paramInt))
    {
      Object localObject = (i)this.aYR.get(i);
      localObject = ((i)localObject).aYY.dh(((i)localObject).jdMethod_do(paramInt));
      AppMethodBeat.o(204999);
      return localObject;
    }
  }
  
  public final int di(int paramInt)
  {
    AppMethodBeat.i(205008);
    dl(paramInt);
    if (paramInt == this.aYN.aYS.length()) {}
    for (int i = p.oE(this.aYR);; i = g.h(this.aYR, paramInt))
    {
      i locali = (i)this.aYR.get(i);
      paramInt = locali.aYY.di(locali.jdMethod_do(paramInt));
      i = locali.aYZ;
      AppMethodBeat.o(205008);
      return i + paramInt;
    }
  }
  
  public final float dj(int paramInt)
  {
    AppMethodBeat.i(205017);
    dm(paramInt);
    int i = g.i(this.aYR, paramInt);
    i locali = (i)this.aYR.get(i);
    float f1 = locali.aYY.dj(paramInt - locali.aYZ);
    float f2 = locali.top;
    AppMethodBeat.o(205017);
    return f2 + f1;
  }
  
  public final int dk(int paramInt)
  {
    AppMethodBeat.i(205025);
    dm(paramInt);
    int i = g.i(this.aYR, paramInt);
    i locali = (i)this.aYR.get(i);
    paramInt = locali.aYY.dk(paramInt - locali.aYZ);
    i = locali.startIndex;
    AppMethodBeat.o(205025);
    return i + paramInt;
  }
  
  final void dm(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(205030);
    int i = j;
    if (paramInt >= 0)
    {
      i = j;
      if (paramInt < this.aYP) {
        i = 1;
      }
    }
    if (i == 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException(("lineIndex(" + paramInt + ") is out of bounds [0, " + paramInt + ')').toString());
      AppMethodBeat.o(205030);
      throw localThrowable;
    }
    AppMethodBeat.o(205030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.d
 * JD-Core Version:    0.7.0.1
 */