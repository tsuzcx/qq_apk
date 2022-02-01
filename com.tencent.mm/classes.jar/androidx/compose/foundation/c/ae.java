package androidx.compose.foundation.c;

import androidx.compose.runtime.ba;
import androidx.compose.runtime.bc;
import androidx.compose.runtime.br;
import androidx.compose.runtime.g;
import androidx.compose.runtime.h;
import androidx.compose.ui.f;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.i.a.a;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Spacer", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "foundation-layout_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ae
{
  public static final void b(f paramf, h paramh, final int paramInt)
  {
    AppMethodBeat.i(203799);
    s.u(paramf, "modifier");
    paramh = paramh.by(220050211);
    int i;
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramf))
      {
        i = 4;
        i |= paramInt;
      }
    }
    for (;;)
    {
      if (((i & 0xB ^ 0x2) != 0) || (!paramh.nZ()))
      {
        Object localObject3 = (androidx.compose.ui.h.p)a.aec;
        paramh.bx(1376089335);
        Object localObject1 = (androidx.compose.ui.n.d)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yU());
        n localn = (n)paramh.a((androidx.compose.runtime.p)androidx.compose.ui.platform.u.yW());
        Object localObject2 = androidx.compose.ui.i.a.aNC;
        Object localObject4 = a.a.xb();
        localObject2 = androidx.compose.ui.h.m.i(paramf);
        i = (i << 3 & 0x70) << 9 & 0x1C00;
        if (!(paramh.nX() instanceof androidx.compose.runtime.d)) {
          g.nW();
        }
        paramh.ol();
        if (paramh.nY())
        {
          paramh.a((kotlin.g.a.a)localObject4);
          label179:
          paramh.op();
          s.u(paramh, "composer");
          localObject4 = androidx.compose.ui.i.a.aNC;
          br.a(paramh, localObject3, a.a.xe());
          localObject3 = androidx.compose.ui.i.a.aNC;
          br.a(paramh, localObject1, a.a.xd());
          localObject1 = androidx.compose.ui.i.a.aNC;
          br.a(paramh, localn, a.a.xf());
          paramh.oq();
          s.u(paramh, "composer");
          ((kotlin.g.a.q)localObject2).invoke(bc.p(paramh), paramh, Integer.valueOf(i >> 3 & 0x70));
          paramh.bx(2058660585);
          paramh.bx(348366449);
          if (((i >> 9 & 0xE & 0xB ^ 0x2) == 0) && (paramh.nZ())) {
            paramh.oi();
          }
          paramh.od();
          paramh.od();
          paramh.on();
          paramh.od();
        }
      }
      for (;;)
      {
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new b(paramf, paramInt));
        }
        AppMethodBeat.o(203799);
        return;
        i = 2;
        break;
        paramh.om();
        break label179;
        paramh.oi();
      }
      i = paramInt;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    implements androidx.compose.ui.h.p
  {
    public static final a aec;
    
    static
    {
      AppMethodBeat.i(203796);
      aec = new a();
      AppMethodBeat.o(203796);
    }
    
    public final androidx.compose.ui.h.q a(r paramr, List<? extends o> paramList, long paramLong)
    {
      int j = 0;
      AppMethodBeat.i(203801);
      s.u(paramr, "$this$Layout");
      s.u(paramList, "$noName_0");
      if (androidx.compose.ui.n.b.aZ(paramLong)) {}
      for (int i = androidx.compose.ui.n.b.aU(paramLong);; i = 0)
      {
        if (androidx.compose.ui.n.b.ba(paramLong)) {
          j = androidx.compose.ui.n.b.aW(paramLong);
        }
        paramr = r.a.a(paramr, i, j, (kotlin.g.a.b)ae.a.a.aed);
        AppMethodBeat.o(203801);
        return paramr;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    b(f paramf, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.ae
 * JD-Core Version:    0.7.0.1
 */