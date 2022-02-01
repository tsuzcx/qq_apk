package androidx.compose.foundation.lazy;

import androidx.compose.foundation.a.i;
import androidx.compose.foundation.b.e;
import androidx.compose.foundation.c.a.d;
import androidx.compose.foundation.c.a.l;
import androidx.compose.foundation.c.t;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.a.b;
import androidx.compose.ui.a.c;
import androidx.compose.ui.h.ag;
import androidx.compose.ui.h.q;
import androidx.compose.ui.h.x;
import androidx.compose.ui.n.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.d.g;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"MaxItemsToRetainForReuse", "", "LazyList", "", "stateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "(Landroidx/compose/runtime/State;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final void a(final bm<? extends n> parambm, final androidx.compose.ui.f paramf, final aa paramaa, final t paramt, final boolean paramBoolean1, final boolean paramBoolean2, final i parami, final a.b paramb, final a.l paraml, final a.c paramc, final a.d paramd, h paramh, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(204240);
    kotlin.g.b.s.u(parambm, "stateOfItemsProvider");
    kotlin.g.b.s.u(paramf, "modifier");
    kotlin.g.b.s.u(paramaa, "state");
    kotlin.g.b.s.u(paramt, "contentPadding");
    kotlin.g.b.s.u(parami, "flingBehavior");
    h localh = paramh.by(-908839593);
    int i;
    if ((paramInt3 & 0x1) != 0) {
      i = 6;
    }
    label135:
    label142:
    label154:
    label161:
    label173:
    label180:
    label193:
    label200:
    label1225:
    label1228:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      if ((paramInt3 & 0x2) != 0)
      {
        i = 48;
        label76:
        i = j | i;
        label83:
        if ((paramInt3 & 0x4) == 0) {
          break label820;
        }
        j = 384;
        label95:
        j = i | j;
        label102:
        if ((paramInt3 & 0x8) == 0) {
          break label860;
        }
        i = 3072;
        label115:
        i = j | i;
        label122:
        if ((paramInt3 & 0x10) == 0) {
          break label900;
        }
        j = 24576;
        j = i | j;
        if ((paramInt3 & 0x20) == 0) {
          break label940;
        }
        i = 196608;
        i = j | i;
        if ((paramInt3 & 0x40) == 0) {
          break label978;
        }
        j = 1572864;
        j = i | j;
        if ((paramInt3 & 0x80) == 0) {
          break label1016;
        }
        i = 12582912;
        i = j | i;
        if ((paramInt3 & 0x100) == 0) {
          break label1055;
        }
        j = 100663296;
        label213:
        j = i | j;
        label220:
        if ((paramInt3 & 0x200) == 0) {
          break label1096;
        }
        i = 805306368;
        label233:
        j |= i;
      }
      for (;;)
      {
        if ((paramInt3 & 0x400) != 0)
        {
          i = 6;
          label253:
          i |= paramInt2;
        }
        for (;;)
        {
          if (((0x5B6DB6DB & j ^ 0x12492492) != 0) || ((i & 0xB ^ 0x2) != 0) || (!localh.nZ()))
          {
            if ((paramInt3 & 0x80) == 0) {
              break label1215;
            }
            paramb = null;
          }
          for (;;)
          {
            if ((paramInt3 & 0x100) != 0) {
              paraml = null;
            }
            for (;;)
            {
              if ((paramInt3 & 0x200) != 0) {
                paramc = null;
              }
              for (;;)
              {
                if ((paramInt3 & 0x400) != 0) {
                  paramd = null;
                }
                for (;;)
                {
                  label361:
                  boolean bool;
                  if (localh.a((p)androidx.compose.ui.platform.u.yW()) == androidx.compose.ui.n.n.beQ)
                  {
                    i = 1;
                    if ((paramBoolean2) || (i == 0)) {
                      break label1171;
                    }
                    bool = paramBoolean1;
                    label375:
                    final k localk = l.a(parambm, paramaa, localh);
                    localh.bx(-3687241);
                    Object localObject = localh.or();
                    paramh = h.alD;
                    paramh = (h)localObject;
                    if (localObject == h.a.ox())
                    {
                      paramh = new androidx.compose.ui.h.af(2);
                      localh.F(paramh);
                    }
                    localh.od();
                    androidx.compose.ui.h.af localaf = (androidx.compose.ui.h.af)paramh;
                    v.a(paramaa, parambm, localk, localaf, localh, j >> 6 & 0xE | 0x200 | j << 3 & 0x70 | androidx.compose.ui.h.af.Ue << 9);
                    localh.bx(-723524056);
                    localh.bx(-3687241);
                    localObject = localh.or();
                    paramh = h.alD;
                    paramh = (h)localObject;
                    if (localObject == h.a.ox())
                    {
                      paramh = new androidx.compose.runtime.r(androidx.compose.runtime.aa.a((kotlin.d.f)g.aiwf, localh));
                      localh.F(paramh);
                    }
                    localh.od();
                    paramh = ((androidx.compose.runtime.r)paramh).coroutineScope;
                    localh.od();
                    localObject = ae.a(paramf, parambm, paramaa, paramh, paramBoolean2);
                    if (!paramBoolean2) {
                      break label1188;
                    }
                    paramh = androidx.compose.foundation.a.k.aaT;
                    label609:
                    e locale = paramaa.ZC;
                    androidx.compose.ui.h.ae.a(localaf, androidx.compose.foundation.c.r.a(androidx.compose.foundation.r.a(androidx.compose.foundation.a.r.a((androidx.compose.ui.f)localObject, (androidx.compose.foundation.a.s)paramaa, paramh, bool, parami, locale), paramBoolean2), paramt).a((androidx.compose.ui.f)paramaa.afZ), (m)new a(paramBoolean2, parambm, paramaa, localk, paramt, paraml, paramd, paramBoolean1, paramb, paramc), localh, androidx.compose.ui.h.af.Ue, 0);
                  }
                  for (;;)
                  {
                    paramh = localh.oh();
                    if (paramh != null) {
                      paramh.b((m)new b(parambm, paramf, paramaa, paramt, paramBoolean1, paramBoolean2, parami, paramb, paraml, paramc, paramd, paramInt1, paramInt2, paramInt3));
                    }
                    AppMethodBeat.o(204240);
                    return;
                    if ((paramInt1 & 0xE) != 0) {
                      break label1228;
                    }
                    if (localh.G(parambm))
                    {
                      i = 4;
                      break;
                    }
                    i = 2;
                    break;
                    i = j;
                    if ((paramInt1 & 0x70) != 0) {
                      break label83;
                    }
                    if (localh.G(paramf))
                    {
                      i = 32;
                      break label76;
                    }
                    i = 16;
                    break label76;
                    j = i;
                    if ((paramInt1 & 0x380) != 0) {
                      break label102;
                    }
                    if (localh.G(paramaa))
                    {
                      j = 256;
                      break label95;
                    }
                    j = 128;
                    break label95;
                    label860:
                    i = j;
                    if ((paramInt1 & 0x1C00) != 0) {
                      break label122;
                    }
                    if (localh.G(paramt))
                    {
                      i = 2048;
                      break label115;
                    }
                    i = 1024;
                    break label115;
                    j = i;
                    if ((0xE000 & paramInt1) != 0) {
                      break label142;
                    }
                    if (localh.am(paramBoolean1))
                    {
                      j = 16384;
                      break label135;
                    }
                    j = 8192;
                    break label135;
                    i = j;
                    if ((0x70000 & paramInt1) != 0) {
                      break label161;
                    }
                    if (localh.am(paramBoolean2))
                    {
                      i = 131072;
                      break label154;
                    }
                    i = 65536;
                    break label154;
                    label978:
                    j = i;
                    if ((0x380000 & paramInt1) != 0) {
                      break label180;
                    }
                    if (localh.G(parami))
                    {
                      j = 1048576;
                      break label173;
                    }
                    j = 524288;
                    break label173;
                    label1016:
                    i = j;
                    if ((0x1C00000 & paramInt1) != 0) {
                      break label200;
                    }
                    if (localh.G(paramb))
                    {
                      i = 8388608;
                      break label193;
                    }
                    i = 4194304;
                    break label193;
                    j = i;
                    if ((0xE000000 & paramInt1) != 0) {
                      break label220;
                    }
                    if (localh.G(paraml))
                    {
                      j = 67108864;
                      break label213;
                    }
                    j = 33554432;
                    break label213;
                    if ((0x70000000 & paramInt1) != 0) {
                      break label1225;
                    }
                    if (localh.G(paramc))
                    {
                      i = 536870912;
                      break label233;
                    }
                    i = 268435456;
                    break label233;
                    if ((paramInt2 & 0xE) != 0) {
                      break label1218;
                    }
                    if (localh.G(paramd))
                    {
                      i = 4;
                      break label253;
                    }
                    i = 2;
                    break label253;
                    i = 0;
                    break label361;
                    if (!paramBoolean1)
                    {
                      bool = true;
                      break label375;
                    }
                    bool = false;
                    break label375;
                    paramh = androidx.compose.foundation.a.k.aaU;
                    break label609;
                    localh.oi();
                  }
                }
              }
            }
          }
          i = paramInt2;
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements m<ag, b, q>
  {
    a(boolean paramBoolean1, bm<? extends n> parambm, aa paramaa, k paramk, t paramt, a.l paraml, a.d paramd, boolean paramBoolean2, a.b paramb, a.c paramc)
    {
      super();
    }
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    static final class a
      implements af
    {
      a(int paramInt1, int paramInt2, boolean paramBoolean1, a.b paramb, a.c paramc, ag paramag, boolean paramBoolean2, int paramInt3, int paramInt4) {}
      
      public final ac a(int paramInt, Object paramObject, x[] paramArrayOfx)
      {
        AppMethodBeat.i(204298);
        kotlin.g.b.s.u(paramObject, "key");
        kotlin.g.b.s.u(paramArrayOfx, "placeables");
        if (paramInt == this.aeN - 1) {}
        for (int i = 0;; i = this.aeO)
        {
          paramObject = new ac(paramInt, paramArrayOfx, this.Zt, this.aex, this.aez, this.aeP.getLayoutDirection(), this.aew, this.aeQ, this.aeR, i, paramObject);
          AppMethodBeat.o(204298);
          return paramObject;
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements m<h, Integer, ah>
  {
    b(bm<? extends n> parambm, androidx.compose.ui.f paramf, aa paramaa, t paramt, boolean paramBoolean1, boolean paramBoolean2, i parami, a.b paramb, a.l paraml, a.c paramc, a.d paramd, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.o
 * JD-Core Version:    0.7.0.1
 */