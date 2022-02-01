package androidx.compose.ui.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"findParagraphByIndex", "", "paragraphInfoList", "", "Landroidx/compose/ui/text/ParagraphInfo;", "index", "findParagraphByLineIndex", "lineIndex", "findParagraphByY", "y", "", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final int b(List<i> paramList, float paramFloat)
  {
    AppMethodBeat.i(204873);
    s.u(paramList, "paragraphInfoList");
    int i = p.d(paramList, (b)new c(paramFloat));
    AppMethodBeat.o(204873);
    return i;
  }
  
  public static final int h(List<i> paramList, int paramInt)
  {
    AppMethodBeat.i(204865);
    s.u(paramList, "paragraphInfoList");
    paramInt = p.d(paramList, (b)new a(paramInt));
    AppMethodBeat.o(204865);
    return paramInt;
  }
  
  public static final int i(List<i> paramList, int paramInt)
  {
    AppMethodBeat.i(204880);
    s.u(paramList, "paragraphInfoList");
    paramInt = p.d(paramList, (b)new b(paramInt));
    AppMethodBeat.o(204880);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "paragraphInfo", "Landroidx/compose/ui/text/ParagraphInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<i, Integer>
  {
    a(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "paragraphInfo", "Landroidx/compose/ui/text/ParagraphInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<i, Integer>
  {
    b(int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "paragraphInfo", "Landroidx/compose/ui/text/ParagraphInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<i, Integer>
  {
    c(float paramFloat)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.g
 * JD-Core Version:    0.7.0.1
 */