package androidx.compose.ui.i;

import androidx.compose.runtime.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSet;", "postponedMeasureRequests", "", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/DepthSortedSet;Ljava/util/List;)V", "assertConsistent", "", "isTreeConsistent", "", "node", "logTree", "", "nodeToString", "consistentLayoutState", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  private final f aLw;
  private final c aPD;
  private final List<f> aPE;
  
  public k(f paramf, c paramc, List<f> paramList)
  {
    AppMethodBeat.i(204508);
    this.aLw = paramf;
    this.aPD = paramc;
    this.aPE = paramList;
    AppMethodBeat.o(204508);
  }
  
  private static final void a(k paramk, StringBuilder paramStringBuilder, f paramf, int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(204525);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramf);
    ((StringBuilder)localObject).append("[" + paramf.aOn + ']');
    if (!paramf.aOw) {
      ((StringBuilder)localObject).append("[!isPlaced]");
    }
    ((StringBuilder)localObject).append("[measuredByParent=" + paramf.aOA + ']');
    if (!paramk.s(paramf)) {
      ((StringBuilder)localObject).append("[INCONSISTENT]");
    }
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "with(StringBuilder()) {\n…     toString()\n        }");
    int j;
    int i;
    int m;
    if (((CharSequence)localObject).length() > 0)
    {
      j = 1;
      i = paramInt;
      if (j != 0)
      {
        if (paramInt > 0)
        {
          i = 0;
          do
          {
            j = i + 1;
            paramStringBuilder.append("..");
            i = j;
          } while (j < paramInt);
        }
        localObject = paramStringBuilder.append((String)localObject);
        s.s(localObject, "append(value)");
        s.s(((StringBuilder)localObject).append('\n'), "append('\\n')");
        i = paramInt + 1;
      }
      paramf = paramf.xt();
      m = paramf.size() - 1;
      if (m < 0) {}
    }
    for (paramInt = k;; paramInt = j)
    {
      j = paramInt + 1;
      a(paramk, paramStringBuilder, (f)paramf.get(paramInt), i);
      if (j > m)
      {
        AppMethodBeat.o(204525);
        return;
        j = 0;
        break;
      }
    }
  }
  
  private final boolean r(f paramf)
  {
    AppMethodBeat.i(204514);
    if (!s(paramf))
    {
      AppMethodBeat.o(204514);
      return false;
    }
    paramf = paramf.xr().qp();
    int k = paramf.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      if (!r((f)paramf.get(i)))
      {
        AppMethodBeat.o(204514);
        return false;
      }
      if (j > k)
      {
        AppMethodBeat.o(204514);
        return true;
      }
    }
  }
  
  private final boolean s(f paramf)
  {
    AppMethodBeat.i(204519);
    Object localObject = paramf.xu();
    int i;
    if (!paramf.aOw)
    {
      if (paramf.aOx == 2147483647) {
        break label205;
      }
      if ((localObject == null) || (((f)localObject).aOw != true)) {
        break label74;
      }
      i = 1;
    }
    while (i != 0) {
      if ((paramf.aOn == f.d.aOO) && (this.aPE.contains(paramf)))
      {
        AppMethodBeat.o(204519);
        return true;
        label74:
        i = 0;
      }
      else
      {
        if (localObject == null) {
          localObject = null;
        }
        while (paramf.aOn == f.d.aOO) {
          if ((this.aPD.c(paramf)) || (localObject == f.d.aOO) || (localObject == f.d.aOP))
          {
            AppMethodBeat.o(204519);
            return true;
            localObject = ((f)localObject).aOn;
          }
          else
          {
            AppMethodBeat.o(204519);
            return false;
          }
        }
        if (paramf.aOn == f.d.aOQ)
        {
          if ((this.aPD.c(paramf)) || (localObject == f.d.aOO) || (localObject == f.d.aOQ) || (localObject == f.d.aOP) || (localObject == f.d.aOR))
          {
            AppMethodBeat.o(204519);
            return true;
          }
          AppMethodBeat.o(204519);
          return false;
        }
      }
    }
    label205:
    AppMethodBeat.o(204519);
    return true;
  }
  
  public final void yc()
  {
    AppMethodBeat.i(204530);
    if (!r(this.aLw)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Object localObject = new StringBuilder();
      StringBuilder localStringBuilder = ((StringBuilder)localObject).append("Tree state:");
      s.s(localStringBuilder, "append(value)");
      s.s(localStringBuilder.append('\n'), "append('\\n')");
      a(this, (StringBuilder)localObject, this.aLw, 0);
      localObject = ((StringBuilder)localObject).toString();
      s.s(localObject, "stringBuilder.toString()");
      System.out.println(localObject);
      localObject = new IllegalStateException("Inconsistency found!");
      AppMethodBeat.o(204530);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(204530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.k
 * JD-Core Version:    0.7.0.1
 */