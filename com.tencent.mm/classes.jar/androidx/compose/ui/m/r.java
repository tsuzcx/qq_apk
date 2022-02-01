package androidx.compose.ui.m;

import androidx.compose.ui.d.e;
import androidx.compose.ui.d.g;
import androidx.compose.ui.e.ax;
import androidx.compose.ui.e.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final r baz;
  
  static
  {
    AppMethodBeat.i(204953);
    baz = new r();
    AppMethodBeat.o(204953);
  }
  
  public static void a(androidx.compose.ui.e.u paramu, q paramq)
  {
    int j = 0;
    AppMethodBeat.i(204950);
    s.u(paramu, "canvas");
    s.u(paramq, "textLayoutResult");
    int i;
    label79:
    label87:
    Object localObject1;
    label120:
    Object localObject2;
    if (androidx.compose.ui.n.l.bi(paramq.size) < paramq.baw.width)
    {
      i = 1;
      if (i == 0)
      {
        if ((!paramq.baw.aYO) && (androidx.compose.ui.n.l.bj(paramq.size) >= paramq.baw.height)) {
          break label348;
        }
        i = 1;
        if (i == 0) {
          break label354;
        }
      }
      i = 1;
      if (i == 0) {
        break label360;
      }
      i = paramq.bav.ahp;
      localObject1 = androidx.compose.ui.m.f.h.beA;
      if (!androidx.compose.ui.m.f.h.C(i, androidx.compose.ui.m.f.h.Cd())) {
        break label360;
      }
      i = 1;
      if (i != 0)
      {
        float f1 = androidx.compose.ui.n.l.bi(paramq.size);
        float f2 = androidx.compose.ui.n.l.bj(paramq.size);
        localObject1 = e.avo;
        localObject1 = androidx.compose.ui.d.h.h(e.su(), androidx.compose.ui.d.l.z(f1, f2));
        paramu.sz();
        localObject2 = y.awI;
        paramu.a((g)localObject1, y.tu());
      }
    }
    for (;;)
    {
      int k;
      try
      {
        localObject2 = paramq.baw;
        long l = paramq.bav.ahn.ayn;
        localObject1 = paramq.bav.ahn.bau;
        paramq = paramq.bav.ahn.bat;
        s.u(paramu, "canvas");
        paramu.sz();
        localObject2 = ((d)localObject2).aYR;
        int m = ((List)localObject2).size() - 1;
        if (m >= 0)
        {
          k = j + 1;
          i locali = (i)((List)localObject2).get(j);
          locali.aYY.a(paramu, l, (ax)localObject1, paramq);
          paramu.A(0.0F, locali.aYY.getHeight());
          if (k <= m) {
            break label385;
          }
        }
        paramu.restore();
        return;
      }
      finally
      {
        if (i == 0) {
          continue;
        }
        paramu.restore();
        AppMethodBeat.o(204950);
      }
      i = 0;
      break;
      label348:
      i = 0;
      break label79;
      label354:
      i = 0;
      break label87;
      label360:
      i = 0;
      break label120;
      label385:
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.r
 * JD-Core Version:    0.7.0.1
 */