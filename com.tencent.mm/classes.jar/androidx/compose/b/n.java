package androidx.compose.b;

import androidx.compose.foundation.f.a.i;
import androidx.compose.foundation.f.a.j;
import androidx.compose.runtime.as;
import androidx.compose.runtime.at;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.q;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"MaterialTheme", "", "colors", "Landroidx/compose/material/Colors;", "typography", "Landroidx/compose/material/Typography;", "shapes", "Landroidx/compose/material/Shapes;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/Colors;Landroidx/compose/material/Typography;Landroidx/compose/material/Shapes;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final void a(a parama, final u paramu, final o paramo, final kotlin.g.a.m<? super h, ? super Integer, ah> paramm, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(201730);
    s.u(paramm, "content");
    h localh = paramh.by(-1505114095);
    final int i;
    if ((paramInt1 & 0xE) == 0) {
      if (((paramInt2 & 0x1) == 0) && (localh.G(parama))) {
        i = 4;
      }
    }
    label135:
    label1043:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      i = j;
      if ((paramInt1 & 0x70) == 0)
      {
        if (((paramInt2 & 0x2) == 0) && (localh.G(paramu)))
        {
          i = 32;
          label92:
          i = j | i;
        }
      }
      else
      {
        j = i;
        if ((paramInt1 & 0x380) == 0)
        {
          if (((paramInt2 & 0x4) != 0) || (!localh.G(paramo))) {
            break label932;
          }
          j = 256;
          j = i | j;
        }
        if ((paramInt2 & 0x8) == 0) {
          break label940;
        }
        i = 3072;
        label155:
        i |= j;
      }
      label932:
      label1067:
      for (;;)
      {
        if (((i & 0x16DB ^ 0x492) != 0) || (!localh.nZ())) {
          if (((paramInt1 & 0x1) == 0) || (localh.oa()))
          {
            localh.of();
            j = i;
            if ((paramInt2 & 0x1) != 0)
            {
              parama = m.aiH;
              parama = m.j(localh);
              j = i & 0xFFFFFFF1;
            }
            i = j;
            if ((paramInt2 & 0x2) != 0)
            {
              paramu = m.aiH;
              paramu = m.k(localh);
              i = j & 0xFFFFFF8F;
            }
            j = i;
            if ((paramInt2 & 0x4) != 0)
            {
              paramo = m.aiH;
              paramo = m.l(localh);
              j = i & 0xFFFFFC7F;
            }
            localh.og();
            i = j;
          }
        }
        label305:
        label1106:
        for (;;)
        {
          localh.bx(-3687241);
          Object localObject1 = localh.or();
          paramh = h.alD;
          paramh = (h)localObject1;
          if (localObject1 == h.a.ox())
          {
            paramh = a.a(parama, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, false, 8191);
            localh.F(paramh);
          }
          localh.od();
          b.a((a)paramh, parama);
          Object localObject3 = (a)paramh;
          Object localObject2 = androidx.compose.b.a.m.a(false, 0.0F, 0L, localh, 7);
          s.u(localObject3, "colors");
          localh.bx(35572393);
          long l2 = ((a)localObject3).nf();
          long l3 = ((a)localObject3).nj();
          localh.bx(35572910);
          long l1 = b.a((a)localObject3, l3);
          paramh = z.awK;
          label471:
          label476:
          float f1;
          float f2;
          if (l1 != z.sw())
          {
            j = 1;
            if (j == 0) {
              break label1043;
            }
            localh.od();
            paramh = c.air;
            l1 = z.g(l1, c.g(localh));
            paramh = z.ad(l2);
            localObject1 = z.ad(l3);
            Object localObject4 = z.ad(l1);
            localh.bx(-3686095);
            boolean bool1 = localh.G(paramh);
            boolean bool2 = localh.G(localObject1);
            boolean bool3 = localh.G(localObject4);
            localObject1 = localh.or();
            if (!(bool3 | bool1 | bool2))
            {
              paramh = h.alD;
              paramh = (h)localObject1;
              if (localObject1 != h.a.ox()) {}
            }
            else
            {
              long l4 = ((a)localObject3).nf();
              f1 = l.a(l2, 0.4F, l1, l3);
              f2 = l.a(l2, 0.2F, l1, l3);
              if (f1 < 4.5F) {
                break label1067;
              }
              f1 = 0.4F;
              paramh = new i(l4, z.g(l2, f1), (byte)0);
              localh.F(paramh);
            }
            localh.od();
            localObject1 = (i)paramh;
            localh.od();
            paramh = b.nt().N(localObject3);
            localObject3 = d.nu();
            localObject4 = c.air;
            localh.bx(-1305244065);
            f1 = c.a(1.0F, 0.87F, localh);
            localh.od();
            localObject3 = ((as)localObject3).N(Float.valueOf(f1));
            localObject2 = androidx.compose.foundation.m.mj().N(localObject2);
            localObject4 = androidx.compose.b.a.o.nI().N(k.aiG);
            at localat1 = p.ny().N(paramo);
            localObject1 = j.nd().N(localObject1);
            at localat2 = v.nB().N(paramu);
            kotlin.g.a.m localm = (kotlin.g.a.m)androidx.compose.runtime.c.c.a(localh, -819894159, new a(paramu, paramm, i));
            q.a(new at[] { paramh, localObject3, localObject2, localObject4, localat1, localObject1, localat2 }, localm, localh, 56);
          }
          for (;;)
          {
            paramh = localh.oh();
            if (paramh != null) {
              paramh.b((kotlin.g.a.m)new b(parama, paramu, paramo, paramm, paramInt1, paramInt2));
            }
            AppMethodBeat.o(201730);
            return;
            i = 2;
            break;
            i = 16;
            break label92;
            j = 128;
            break label135;
            if ((paramInt1 & 0x1C00) != 0) {
              break label1109;
            }
            if (localh.G(paramm))
            {
              i = 2048;
              break label155;
            }
            i = 1024;
            break label155;
            localh.oj();
            j = i;
            if ((paramInt2 & 0x1) != 0) {
              j = i & 0xFFFFFFF1;
            }
            i = j;
            if ((paramInt2 & 0x2) != 0) {
              i = j & 0xFFFFFF8F;
            }
            if ((paramInt2 & 0x4) == 0) {
              break label1106;
            }
            i &= 0xFFFFFC7F;
            break label305;
            j = 0;
            break label471;
            l1 = ((z)localh.a((androidx.compose.runtime.p)e.nv())).value;
            break label476;
            if (f2 < 4.5F)
            {
              f1 = 0.2F;
              break label645;
            }
            f1 = l.b(l2, l1, l3);
            break label645;
            localh.oi();
          }
        }
        label940:
        label1109:
        i = j;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    a(u paramu, kotlin.g.a.m<? super h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    b(a parama, u paramu, o paramo, kotlin.g.a.m<? super h, ? super Integer, ah> paramm, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.n
 * JD-Core Version:    0.7.0.1
 */