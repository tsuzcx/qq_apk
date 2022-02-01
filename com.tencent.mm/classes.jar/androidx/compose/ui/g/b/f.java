package androidx.compose.ui.g.b;

import androidx.compose.runtime.h;
import androidx.compose.ui.f.c;
import androidx.compose.ui.f.c.a;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"nestedScroll", "Landroidx/compose/ui/Modifier;", "connection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final androidx.compose.ui.f a(androidx.compose.ui.f paramf, final a parama, final d paramd)
  {
    AppMethodBeat.i(205724);
    s.u(paramf, "<this>");
    s.u(parama, "connection");
    if (ab.zi()) {}
    for (b localb = (b)new a(parama, paramd);; localb = ab.zh())
    {
      paramf = androidx.compose.ui.e.a(paramf, localb, (q)new b(paramd, parama));
      AppMethodBeat.o(205724);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends u
    implements b<ad, ah>
  {
    public a(a parama, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements q<androidx.compose.ui.f, h, Integer, androidx.compose.ui.f>
  {
    b(d paramd, a parama)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
      implements e
    {
      private final d aKH;
      private final a aKI;
      
      a(d paramd, a parama, aq paramaq)
      {
        AppMethodBeat.i(205725);
        paramd = this.aKJ;
        paramd.aKA = this.aKK;
        parama = ah.aiuX;
        this.aKH = paramd;
        this.aKI = this.aKG;
        AppMethodBeat.o(205725);
      }
      
      public final androidx.compose.ui.f a(androidx.compose.ui.f paramf)
      {
        AppMethodBeat.i(205757);
        e locale = (e)this;
        s.u(locale, "this");
        s.u(paramf, "other");
        paramf = f.c.a.a((f.c)locale, paramf);
        AppMethodBeat.o(205757);
        return paramf;
      }
      
      public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
      {
        AppMethodBeat.i(205739);
        e locale = (e)this;
        s.u(locale, "this");
        s.u(paramm, "operation");
        paramR = f.c.a.a((f.c)locale, paramR, paramm);
        AppMethodBeat.o(205739);
        return paramR;
      }
      
      public final boolean a(b<? super f.c, Boolean> paramb)
      {
        AppMethodBeat.i(205752);
        e locale = (e)this;
        s.u(locale, "this");
        s.u(paramb, "predicate");
        boolean bool = f.c.a.a((f.c)locale, paramb);
        AppMethodBeat.o(205752);
        return bool;
      }
      
      public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
      {
        AppMethodBeat.i(205745);
        e locale = (e)this;
        s.u(locale, "this");
        s.u(paramm, "operation");
        paramR = f.c.a.b((f.c)locale, paramR, paramm);
        AppMethodBeat.o(205745);
        return paramR;
      }
      
      public final d we()
      {
        return this.aKH;
      }
      
      public final a wf()
      {
        return this.aKI;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.b.f
 * JD-Core Version:    0.7.0.1
 */