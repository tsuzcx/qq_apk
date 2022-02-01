package androidx.compose.ui.m.e;

import android.graphics.Canvas;
import android.graphics.Paint.FontMetricsInt;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import androidx.compose.ui.d.e;
import androidx.compose.ui.d.g;
import androidx.compose.ui.e.ax;
import androidx.compose.ui.m.a.b.f;
import androidx.compose.ui.m.a.n;
import androidx.compose.ui.m.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.o;
import kotlin.p;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/platform/AndroidParagraph;", "Landroidx/compose/ui/text/Paragraph;", "text", "", "style", "Landroidx/compose/ui/text/TextStyle;", "spanStyles", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "placeholders", "Landroidx/compose/ui/text/Placeholder;", "maxLines", "", "ellipsis", "", "width", "", "typefaceAdapter", "Landroidx/compose/ui/text/platform/TypefaceAdapter;", "density", "Landroidx/compose/ui/unit/Density;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Ljava/util/List;IZFLandroidx/compose/ui/text/platform/TypefaceAdapter;Landroidx/compose/ui/unit/Density;)V", "paragraphIntrinsics", "Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "(Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;IZF)V", "charSequence", "", "getCharSequence$ui_text_release$annotations", "()V", "getCharSequence$ui_text_release", "()Ljava/lang/CharSequence;", "didExceedMaxLines", "getDidExceedMaxLines", "()Z", "getEllipsis", "firstBaseline", "getFirstBaseline", "()F", "height", "getHeight", "lastBaseline", "getLastBaseline", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "lineCount", "getLineCount", "()I", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "getParagraphIntrinsics", "()Landroidx/compose/ui/text/platform/AndroidParagraphIntrinsics;", "placeholderRects", "Landroidx/compose/ui/geometry/Rect;", "getPlaceholderRects", "()Ljava/util/List;", "textLocale", "Ljava/util/Locale;", "getTextLocale$ui_text_release$annotations", "getTextLocale$ui_text_release", "()Ljava/util/Locale;", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getTextPaint$ui_text_release$annotations", "getTextPaint$ui_text_release", "()Landroidx/compose/ui/text/platform/AndroidTextPaint;", "getWidth", "wordBoundary", "Landroidx/compose/ui/text/android/selection/WordBoundary;", "getWordBoundary", "()Landroidx/compose/ui/text/android/selection/WordBoundary;", "wordBoundary$delegate", "Lkotlin/Lazy;", "getBidiRunDirection", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "offset", "getBoundingBox", "getCursorRect", "getHorizontalPosition", "usePrimaryDirection", "getLineBottom", "lineIndex", "getLineEnd", "visibleEnd", "getLineForOffset", "getLineForVerticalPosition", "vertical", "getLineHeight", "getLineLeft", "getLineRight", "getLineStart", "getLineTop", "getLineWidth", "getOffsetForPosition", "position", "Landroidx/compose/ui/geometry/Offset;", "getOffsetForPosition-k-4lQ0M", "(J)I", "getParagraphDirection", "getPathForRange", "Landroidx/compose/ui/graphics/Path;", "start", "end", "Landroidx/compose/ui/text/TextRange;", "getWordBoundary--jx7JFs", "(I)J", "isEllipsisApplied", "isEllipsisApplied$ui_text_release", "isLineEllipsized", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "color", "Landroidx/compose/ui/graphics/Color;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "paint-RPmYEkk", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;)V", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements h
{
  private final List<g> aYQ;
  final c bdG;
  private final boolean bdH;
  final n bdI;
  private final j bdJ;
  private final int maxLines;
  private final float width;
  
  public b(c paramc, int paramInt, boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(205390);
    this.bdG = paramc;
    this.maxLines = paramInt;
    this.bdH = paramBoolean;
    this.width = paramFloat;
    if (this.maxLines > 0) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      paramc = (Throwable)new IllegalArgumentException("maxLines should be greater than 0".toString());
      AppMethodBeat.o(205390);
      throw paramc;
    }
    if (this.width >= 0.0F) {}
    for (paramInt = 1; paramInt == 0; paramInt = 0)
    {
      paramc = (Throwable)new IllegalArgumentException("width should not be negative".toString());
      AppMethodBeat.o(205390);
      throw paramc;
    }
    paramc = this.bdG.ahn;
    Object localObject1 = paramc.aZc;
    Object localObject2 = androidx.compose.ui.m.f.c.beg;
    paramInt = androidx.compose.ui.m.f.c.sj();
    label156:
    int i;
    label177:
    label184:
    label195:
    int j;
    int k;
    Object localObject3;
    if (localObject1 == null)
    {
      paramBoolean = false;
      if (!paramBoolean) {
        break label343;
      }
      paramInt = 3;
      paramc = paramc.aZc;
      localObject1 = androidx.compose.ui.m.f.c.beg;
      i = androidx.compose.ui.m.f.c.BQ();
      if (paramc != null) {
        break label495;
      }
      paramBoolean = false;
      if (!paramBoolean) {
        break label508;
      }
      i = 1;
      if (!this.bdH) {
        break label514;
      }
      paramc = TextUtils.TruncateAt.END;
      localObject1 = this.bdG.bbw;
      paramFloat = this.width;
      localObject2 = this.bdG.bdM;
      j = this.bdG.bdN;
      k = this.maxLines;
      localObject3 = this.bdG.bbs;
      this.bdI = new n((CharSequence)localObject1, paramFloat, (TextPaint)localObject2, paramInt, paramc, j, k, i, (androidx.compose.ui.m.a.c)localObject3, (byte)0);
      localObject1 = this.bdG.bbw;
      if ((localObject1 instanceof Spanned)) {
        break label519;
      }
    }
    for (paramc = (List)ab.aivy;; paramc = (List)localObject3)
    {
      this.aYQ = paramc;
      this.bdJ = k.a(o.aiuH, (kotlin.g.a.a)new b(this));
      AppMethodBeat.o(205390);
      return;
      paramBoolean = androidx.compose.ui.m.f.c.C(((androidx.compose.ui.m.f.c)localObject1).value, paramInt);
      break;
      label343:
      localObject2 = androidx.compose.ui.m.f.c.beg;
      paramInt = androidx.compose.ui.m.f.c.sk();
      if (localObject1 == null) {}
      for (paramBoolean = false;; paramBoolean = androidx.compose.ui.m.f.c.C(((androidx.compose.ui.m.f.c)localObject1).value, paramInt))
      {
        if (!paramBoolean) {
          break label381;
        }
        paramInt = 4;
        break;
      }
      label381:
      localObject2 = androidx.compose.ui.m.f.c.beg;
      paramInt = androidx.compose.ui.m.f.c.BP();
      if (localObject1 == null) {}
      for (paramBoolean = false;; paramBoolean = androidx.compose.ui.m.f.c.C(((androidx.compose.ui.m.f.c)localObject1).value, paramInt))
      {
        if (!paramBoolean) {
          break label419;
        }
        paramInt = 2;
        break;
      }
      label419:
      localObject2 = androidx.compose.ui.m.f.c.beg;
      paramInt = androidx.compose.ui.m.f.c.BR();
      if (localObject1 == null)
      {
        paramBoolean = false;
        label435:
        if (paramBoolean) {
          break label490;
        }
        localObject2 = androidx.compose.ui.m.f.c.beg;
        paramInt = androidx.compose.ui.m.f.c.BS();
        if (localObject1 != null) {
          break label477;
        }
      }
      label477:
      for (paramBoolean = false;; paramBoolean = androidx.compose.ui.m.f.c.C(((androidx.compose.ui.m.f.c)localObject1).value, paramInt))
      {
        if (!paramBoolean) {
          break label490;
        }
        paramInt = 1;
        break;
        paramBoolean = androidx.compose.ui.m.f.c.C(((androidx.compose.ui.m.f.c)localObject1).value, paramInt);
        break label435;
      }
      label490:
      paramInt = 0;
      break label156;
      label495:
      paramBoolean = androidx.compose.ui.m.f.c.C(paramc.value, i);
      break label177;
      label508:
      i = 0;
      break label184;
      label514:
      paramc = null;
      break label195;
      label519:
      localObject2 = ((Spanned)localObject1).getSpans(0, ((CharSequence)localObject1).length(), f.class);
      s.s(localObject2, "getSpans(0, length, PlaceholderSpan::class.java)");
      localObject3 = (Collection)new ArrayList(localObject2.length);
      k = localObject2.length;
      paramInt = 0;
      if (paramInt < k)
      {
        f localf = (f)localObject2[paramInt];
        int n = ((Spanned)localObject1).getSpanStart(localf);
        j = ((Spanned)localObject1).getSpanEnd(localf);
        int m = this.bdI.di(n);
        if ((this.bdI.bbt.getEllipsisCount(m) > 0) && (j > this.bdI.bbt.getEllipsisStart(m)))
        {
          i = 1;
          label661:
          if (j <= this.bdI.dt(m)) {
            break label712;
          }
        }
        label712:
        for (j = 1;; j = 0)
        {
          if ((i == 0) && (j == 0)) {
            break label718;
          }
          paramc = null;
          ((Collection)localObject3).add(paramc);
          paramInt += 1;
          break;
          i = 0;
          break label661;
        }
        label718:
        if (this.bdI.bbt.isRtlCharAt(n)) {}
        for (paramc = androidx.compose.ui.m.f.b.bee;; paramc = androidx.compose.ui.m.f.b.bed) {
          switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
          {
          default: 
            paramc = new p();
            AppMethodBeat.o(205390);
            throw paramc;
          }
        }
        float f2;
        for (float f1 = dC(n);; f1 = dC(n) - localf.Ba())
        {
          f2 = localf.Ba();
          paramc = this.bdI;
          switch (localf.bbE)
          {
          default: 
            paramc = new IllegalStateException("unexpected verticalAlignment");
            AppMethodBeat.o(205390);
            throw paramc;
          }
        }
        paramFloat = paramc.ds(m) - localf.Bb();
        for (;;)
        {
          paramc = new g(f1, paramFloat, f1 + f2, paramFloat + localf.Bb());
          break;
          paramFloat = paramc.dj(m);
          continue;
          paramFloat = paramc.dr(m) - localf.Bb();
          continue;
          paramFloat = paramc.dj(m);
          paramFloat = (paramc.dr(m) + paramFloat - localf.Bb()) / 2.0F;
          continue;
          paramFloat = localf.AZ().ascent;
          paramFloat = paramc.ds(m) + paramFloat;
          continue;
          paramFloat = localf.AZ().descent;
          paramFloat = paramc.ds(m) + paramFloat - localf.Bb();
          continue;
          Paint.FontMetricsInt localFontMetricsInt = localf.AZ();
          i = localFontMetricsInt.ascent;
          paramFloat = (localFontMetricsInt.descent + i - localf.Bb()) / 2;
          paramFloat = paramc.ds(m) + paramFloat;
        }
      }
    }
  }
  
  private float dC(int paramInt)
  {
    AppMethodBeat.i(205397);
    float f = this.bdI.dv(paramInt);
    AppMethodBeat.o(205397);
    return f;
  }
  
  public final float AH()
  {
    AppMethodBeat.i(205407);
    float f = this.bdI.ds(0);
    AppMethodBeat.o(205407);
    return f;
  }
  
  public final float AI()
  {
    AppMethodBeat.i(205415);
    if (this.maxLines < this.bdI.aYP)
    {
      f = this.bdI.ds(this.maxLines - 1);
      AppMethodBeat.o(205415);
      return f;
    }
    float f = this.bdI.ds(this.bdI.aYP - 1);
    AppMethodBeat.o(205415);
    return f;
  }
  
  public final boolean AJ()
  {
    return this.bdI.aYO;
  }
  
  public final List<g> AK()
  {
    return this.aYQ;
  }
  
  public final void a(androidx.compose.ui.e.u paramu, long paramLong, ax paramax, androidx.compose.ui.m.f.d paramd)
  {
    AppMethodBeat.i(205473);
    s.u(paramu, "canvas");
    this.bdG.bdM.W(paramLong);
    this.bdG.bdM.a(paramax);
    this.bdG.bdM.a(paramd);
    paramu = androidx.compose.ui.e.c.a(paramu);
    if (this.bdI.aYO)
    {
      paramu.save();
      paramu.clipRect(0.0F, 0.0F, this.width, getHeight());
    }
    paramax = this.bdI;
    s.u(paramu, "canvas");
    paramax.bbt.draw(paramu);
    if (this.bdI.aYO) {
      paramu.restore();
    }
    AppMethodBeat.o(205473);
  }
  
  public final int aM(long paramLong)
  {
    AppMethodBeat.i(205444);
    int i = this.bdI.du((int)e.G(paramLong));
    n localn = this.bdI;
    float f = e.F(paramLong);
    i = localn.bbt.getOffsetForHorizontal(i, f);
    AppMethodBeat.o(205444);
    return i;
  }
  
  public final int ag(float paramFloat)
  {
    AppMethodBeat.i(205436);
    int i = this.bdI.du((int)paramFloat);
    AppMethodBeat.o(205436);
    return i;
  }
  
  public final androidx.compose.ui.m.f.b dh(int paramInt)
  {
    AppMethodBeat.i(205468);
    paramInt = this.bdI.di(paramInt);
    if (this.bdI.bbt.getParagraphDirection(paramInt) == 1)
    {
      localb = androidx.compose.ui.m.f.b.bed;
      AppMethodBeat.o(205468);
      return localb;
    }
    androidx.compose.ui.m.f.b localb = androidx.compose.ui.m.f.b.bee;
    AppMethodBeat.o(205468);
    return localb;
  }
  
  public final int di(int paramInt)
  {
    AppMethodBeat.i(205463);
    paramInt = this.bdI.di(paramInt);
    AppMethodBeat.o(205463);
    return paramInt;
  }
  
  public final float dj(int paramInt)
  {
    AppMethodBeat.i(205453);
    float f = this.bdI.dj(paramInt);
    AppMethodBeat.o(205453);
    return f;
  }
  
  public final int dk(int paramInt)
  {
    AppMethodBeat.i(205456);
    paramInt = this.bdI.bbt.getLineStart(paramInt);
    AppMethodBeat.o(205456);
    return paramInt;
  }
  
  public final g dn(int paramInt)
  {
    AppMethodBeat.i(205449);
    float f1 = this.bdI.dv(paramInt);
    float f2 = this.bdI.dv(paramInt + 1);
    paramInt = this.bdI.di(paramInt);
    g localg = new g(f1, this.bdI.dj(paramInt), f2, this.bdI.dr(paramInt));
    AppMethodBeat.o(205449);
    return localg;
  }
  
  public final float getHeight()
  {
    AppMethodBeat.i(205404);
    n localn = this.bdI;
    if (localn.aYO) {}
    for (int i = localn.bbt.getLineBottom(localn.aYP - 1);; i = localn.bbt.getHeight())
    {
      float f = i;
      AppMethodBeat.o(205404);
      return f;
    }
  }
  
  public final int getLineCount()
  {
    return this.bdI.aYP;
  }
  
  public final int o(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(205458);
    paramInt = this.bdI.dt(paramInt);
    AppMethodBeat.o(205458);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/text/android/selection/WordBoundary;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<androidx.compose.ui.m.a.a.a>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.e.b
 * JD-Core Version:    0.7.0.1
 */