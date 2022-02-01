package androidx.compose.ui.m;

import androidx.compose.ui.m.b.c.a;
import androidx.compose.ui.m.e.c;
import androidx.compose.ui.n.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.o;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "Landroidx/compose/ui/text/ParagraphIntrinsics;", "annotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;)V", "getAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "infoList", "Landroidx/compose/ui/text/ParagraphIntrinsicInfo;", "getInfoList$ui_text_release", "()Ljava/util/List;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "maxIntrinsicWidth$delegate", "Lkotlin/Lazy;", "minIntrinsicWidth", "getMinIntrinsicWidth", "minIntrinsicWidth$delegate", "getPlaceholders", "resolveTextDirection", "Landroidx/compose/ui/text/ParagraphStyle;", "defaultStyle", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements k
{
  public final a aYS;
  private final kotlin.j aYT;
  private final kotlin.j aYU;
  final List<j> aYV;
  final List<a.a<Object>> ahr;
  
  public e(a parama, u paramu, List<a.a<Object>> paramList, d paramd, c.a parama1)
  {
    AppMethodBeat.i(204890);
    this.aYS = parama;
    this.ahr = paramList;
    this.aYT = kotlin.k.a(o.aiuH, (kotlin.g.a.a)new b(this));
    this.aYU = kotlin.k.a(o.aiuH, (kotlin.g.a.a)new a(this));
    l locall = paramu.AS();
    a locala = this.aYS;
    List localList1 = b.a(locala, locall);
    ArrayList localArrayList = new ArrayList(localList1.size());
    int i = 0;
    int k = localList1.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      parama = localList1.get(i);
      Collection localCollection = (Collection)localArrayList;
      a.a locala1 = (a.a)parama;
      Object localObject = b.b(locala, locala1.start, locala1.end);
      paramList = (l)locala1.aYG;
      if (paramList.aZd == null)
      {
        parama = null;
        if (parama != null) {
          break label462;
        }
        parama = locall.aZd;
        parama = new l(paramList.aZc, parama, paramList.aZe, paramList.aZf, (byte)0);
      }
      label462:
      for (;;)
      {
        paramList = ((a)localObject).text;
        s.u(parama, "other");
        parama = new u(paramu.AR(), paramu.AS().a(parama));
        localObject = ((a)localObject).aYD;
        List localList2 = f.f(this.ahr, locala1.start, locala1.end);
        s.u(paramList, "text");
        s.u(parama, "style");
        s.u(localObject, "spanStyles");
        s.u(localList2, "placeholders");
        s.u(paramd, "density");
        s.u(parama1, "resourceLoader");
        s.u(paramList, "text");
        s.u(parama, "style");
        s.u(localObject, "spanStyles");
        s.u(localList2, "placeholders");
        s.u(paramd, "density");
        s.u(parama1, "resourceLoader");
        localCollection.add(new j((k)new c(paramList, parama, (List)localObject, localList2, new androidx.compose.ui.m.e.f(parama1), paramd), locala1.start, locala1.end));
        if (j <= k) {
          break label465;
        }
        this.aYV = ((List)localArrayList);
        AppMethodBeat.o(204890);
        return;
        parama = paramList;
        break;
      }
      label465:
      i = j;
    }
  }
  
  public final float AF()
  {
    AppMethodBeat.i(204895);
    float f = ((Number)this.aYT.getValue()).floatValue();
    AppMethodBeat.o(204895);
    return f;
  }
  
  public final float AG()
  {
    AppMethodBeat.i(204898);
    float f = ((Number)this.aYU.getValue()).floatValue();
    AppMethodBeat.o(204898);
    return f;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Float>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<Float>
  {
    b(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.e
 * JD-Core Version:    0.7.0.1
 */