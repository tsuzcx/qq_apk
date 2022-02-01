package androidx.compose.ui.m;

import androidx.compose.ui.m.f.b;
import androidx.compose.ui.n.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/TextLayoutResult;", "", "layoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "multiParagraph", "Landroidx/compose/ui/text/MultiParagraph;", "size", "Landroidx/compose/ui/unit/IntSize;", "(Landroidx/compose/ui/text/TextLayoutInput;Landroidx/compose/ui/text/MultiParagraph;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "didOverflowHeight", "", "getDidOverflowHeight", "()Z", "didOverflowWidth", "getDidOverflowWidth", "firstBaseline", "", "getFirstBaseline", "()F", "hasVisualOverflow", "getHasVisualOverflow", "lastBaseline", "getLastBaseline", "getLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "lineCount", "", "getLineCount", "()I", "getMultiParagraph", "()Landroidx/compose/ui/text/MultiParagraph;", "placeholderRects", "", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "getSize-YbymL2g", "()J", "J", "copy", "copy-O0kMr_c", "(Landroidx/compose/ui/text/TextLayoutInput;J)Landroidx/compose/ui/text/TextLayoutResult;", "equals", "other", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBottom", "lineIndex", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "getWordBoundary", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "hashCode", "isLineEllipsized", "toString", "", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public final List<androidx.compose.ui.d.g> aYQ;
  public final p bav;
  public final d baw;
  public final float bax;
  public final float bay;
  public final long size;
  
  private q(p paramp, d paramd, long paramLong)
  {
    AppMethodBeat.i(204958);
    this.bav = paramp;
    this.baw = paramd;
    this.size = paramLong;
    paramp = this.baw;
    if (paramp.aYR.isEmpty())
    {
      f1 = 0.0F;
      this.bax = f1;
      paramp = this.baw;
      if (!paramp.aYR.isEmpty()) {
        break label123;
      }
    }
    for (float f1 = f2;; f1 = paramp.aYY.AI() + paramp.top)
    {
      this.bay = f1;
      this.aYQ = this.baw.aYQ;
      AppMethodBeat.o(204958);
      return;
      f1 = ((i)paramp.aYR.get(0)).aYY.AH();
      break;
      label123:
      paramp = (i)kotlin.a.p.oM(paramp.aYR);
    }
  }
  
  public final int aM(long paramLong)
  {
    AppMethodBeat.i(205015);
    int i = this.baw.aM(paramLong);
    AppMethodBeat.o(205015);
    return i;
  }
  
  public final int ag(float paramFloat)
  {
    AppMethodBeat.i(205001);
    int i = this.baw.ag(paramFloat);
    AppMethodBeat.o(205001);
    return i;
  }
  
  public final b dh(int paramInt)
  {
    AppMethodBeat.i(205009);
    b localb = this.baw.dh(paramInt);
    AppMethodBeat.o(205009);
    return localb;
  }
  
  public final int di(int paramInt)
  {
    AppMethodBeat.i(204993);
    paramInt = this.baw.di(paramInt);
    AppMethodBeat.o(204993);
    return paramInt;
  }
  
  public final float dj(int paramInt)
  {
    AppMethodBeat.i(204989);
    float f = this.baw.dj(paramInt);
    AppMethodBeat.o(204989);
    return f;
  }
  
  public final int dk(int paramInt)
  {
    AppMethodBeat.i(204970);
    paramInt = this.baw.dk(paramInt);
    AppMethodBeat.o(204970);
    return paramInt;
  }
  
  public final int dp(int paramInt)
  {
    AppMethodBeat.i(204980);
    Object localObject = this.baw;
    ((d)localObject).dm(paramInt);
    int i = g.i(((d)localObject).aYR, paramInt);
    localObject = (i)((d)localObject).aYR.get(i);
    paramInt = ((i)localObject).aYY.o(paramInt - ((i)localObject).aYZ, false);
    i = ((i)localObject).startIndex;
    AppMethodBeat.o(204980);
    return i + paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205027);
    if (this == paramObject)
    {
      AppMethodBeat.o(205027);
      return true;
    }
    if (!(paramObject instanceof q))
    {
      AppMethodBeat.o(205027);
      return false;
    }
    if (!s.p(this.bav, ((q)paramObject).bav))
    {
      AppMethodBeat.o(205027);
      return false;
    }
    if (!s.p(this.baw, ((q)paramObject).baw))
    {
      AppMethodBeat.o(205027);
      return false;
    }
    if (!l.e(this.size, ((q)paramObject).size))
    {
      AppMethodBeat.o(205027);
      return false;
    }
    if (this.bax == ((q)paramObject).bax) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(205027);
      return false;
    }
    if (this.bay == ((q)paramObject).bay) {}
    for (i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(205027);
      return false;
    }
    if (!s.p(this.aYQ, ((q)paramObject).aYQ))
    {
      AppMethodBeat.o(205027);
      return false;
    }
    AppMethodBeat.o(205027);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205032);
    int i = this.bav.hashCode();
    int j = this.baw.hashCode();
    int k = l.I(this.size);
    int m = Float.floatToIntBits(this.bax);
    int n = Float.floatToIntBits(this.bay);
    int i1 = this.aYQ.hashCode();
    AppMethodBeat.o(205032);
    return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205038);
    String str = "TextLayoutResult(layoutInput=" + this.bav + ", multiParagraph=" + this.baw + ", size=" + l.H(this.size) + ", firstBaseline=" + this.bax + ", lastBaseline=" + this.bay + ", placeholderRects=" + this.aYQ + ')';
    AppMethodBeat.o(205038);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.q
 * JD-Core Version:    0.7.0.1
 */