package androidx.compose.ui.c;

import androidx.compose.runtime.a.e;
import androidx.compose.ui.i.j;
import androidx.compose.ui.i.o;
import androidx.compose.ui.i.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"FOCUS_TAG", "", "getFOCUS_TAG", "()Ljava/lang/String;", "findFocusableChildren", "", "Landroidx/compose/ui/node/LayoutNode;", "focusableChildren", "", "Landroidx/compose/ui/node/ModifiedFocusNode;", "searchChildrenForFocusNode", "queue", "Landroidx/compose/runtime/collection/MutableVector;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final String auS = "Compose Focus";
  
  private static o a(androidx.compose.ui.i.f paramf, e<androidx.compose.ui.i.f> parame)
  {
    AppMethodBeat.i(204362);
    s.u(paramf, "<this>");
    s.u(parame, "queue");
    paramf = paramf.xr();
    int j = paramf.size;
    int i;
    if (j > 0)
    {
      paramf = paramf.aqq;
      i = 0;
    }
    for (;;)
    {
      androidx.compose.ui.i.f localf = (androidx.compose.ui.i.f)paramf[i];
      o localo = localf.aOD.aPZ.xk();
      if (localo != null)
      {
        AppMethodBeat.o(204362);
        return localo;
      }
      parame.add(localf);
      i += 1;
      if (i >= j)
      {
        while (parame.qn())
        {
          paramf = a((androidx.compose.ui.i.f)parame.removeAt(0), parame);
          if (paramf != null)
          {
            AppMethodBeat.o(204362);
            return paramf;
          }
        }
        AppMethodBeat.o(204362);
        return null;
      }
    }
  }
  
  public static final void a(androidx.compose.ui.i.f paramf, List<o> paramList)
  {
    AppMethodBeat.i(204360);
    s.u(paramf, "<this>");
    s.u(paramList, "focusableChildren");
    Object localObject = paramf.aOD.aPZ.xk();
    int i;
    int k;
    if (localObject == null)
    {
      localObject = null;
      if (localObject == null)
      {
        paramf = paramf.xr().qp();
        i = 0;
        k = paramf.size() - 1;
        if (k < 0) {}
      }
    }
    for (;;)
    {
      int j = i + 1;
      a((androidx.compose.ui.i.f)paramf.get(i), paramList);
      if (j > k)
      {
        AppMethodBeat.o(204360);
        return;
        localObject = Boolean.valueOf(paramList.add(localObject));
        break;
      }
      i = j;
    }
  }
  
  public static final String sr()
  {
    return auS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.c.f
 * JD-Core Version:    0.7.0.1
 */