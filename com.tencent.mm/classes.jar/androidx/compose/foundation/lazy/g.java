package androidx.compose.foundation.lazy;

import androidx.compose.foundation.a.i;
import androidx.compose.foundation.a.q;
import androidx.compose.foundation.c.a.d;
import androidx.compose.foundation.c.a.l;
import androidx.compose.foundation.c.r;
import androidx.compose.foundation.c.t;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.a.a;
import androidx.compose.ui.a.b;
import androidx.compose.ui.a.c;
import androidx.compose.ui.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"LazyColumn", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyRow", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberStateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "items", "T", "", "key", "Lkotlin/ParameterName;", "name", "item", "", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "foundation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class g
{
  private static final bm<n> a(b<? super w, ah> paramb, h paramh)
  {
    AppMethodBeat.i(204217);
    paramh.bx(-1542792672);
    bm localbm = bj.b(paramb, paramh);
    paramh.bx(-3687241);
    Object localObject = paramh.or();
    paramb = h.alD;
    paramb = localObject;
    if (localObject == h.a.ox())
    {
      paramb = bj.f((kotlin.g.a.a)new c(localbm));
      paramh.F(paramb);
    }
    paramh.od();
    paramb = (bm)paramb;
    paramh.od();
    AppMethodBeat.o(204217);
    return paramb;
  }
  
  public static final void a(f paramf, final aa paramaa, final t paramt, final boolean paramBoolean, final a.d paramd, final a.c paramc, final i parami, final b<? super w, ah> paramb, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(204207);
    s.u(paramb, "content");
    h localh = paramh.by(1356352169);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label158:
    label681:
    label825:
    label838:
    label966:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      i = j;
      if ((paramInt1 & 0x70) == 0)
      {
        if (((paramInt2 & 0x2) == 0) && (localh.G(paramaa)))
        {
          i = 32;
          label75:
          i = j | i;
        }
      }
      else
      {
        if ((paramInt2 & 0x4) == 0) {
          break label681;
        }
        j = 384;
        label94:
        j = i | j;
        label101:
        if ((paramInt2 & 0x8) == 0) {
          break label721;
        }
        i = 3072;
        label114:
        i = j | i;
        label121:
        j = i;
        if ((0xE000 & paramInt1) == 0)
        {
          if (((paramInt2 & 0x10) != 0) || (!localh.G(paramd))) {
            break label761;
          }
          j = 16384;
          j = i | j;
        }
        i = j;
        if ((0x70000 & paramInt1) == 0)
        {
          if (((paramInt2 & 0x20) != 0) || (!localh.G(paramc))) {
            break label769;
          }
          i = 131072;
          label201:
          i = j | i;
        }
        j = i;
        if ((0x380000 & paramInt1) == 0)
        {
          if (((paramInt2 & 0x40) != 0) || (!localh.G(parami))) {
            break label776;
          }
          j = 1048576;
          label244:
          j = i | j;
        }
        if ((paramInt2 & 0x80) == 0) {
          break label784;
        }
        i = 12582912;
        i = j | i;
        if (((0x16DB6DB & i ^ 0x492492) == 0) && (localh.nZ())) {
          break label927;
        }
        if (((paramInt1 & 0x1) != 0) && (!localh.oa())) {
          break label838;
        }
        localh.of();
        if ((paramInt2 & 0x1) != 0) {
          paramf = (f)f.aud;
        }
        j = i;
        if ((paramInt2 & 0x2) != 0)
        {
          paramaa = ab.f(localh);
          j = i & 0xFFFFFF8F;
        }
        if ((paramInt2 & 0x4) != 0) {
          paramt = r.C(androidx.compose.ui.n.g.ai(0.0F));
        }
        if ((paramInt2 & 0x8) != 0) {
          paramBoolean = false;
        }
        i = j;
        if ((paramInt2 & 0x10) != 0)
        {
          if (paramBoolean) {
            break label825;
          }
          paramd = androidx.compose.foundation.c.a.abN;
          paramd = androidx.compose.foundation.c.a.mt();
          i = j & 0xFFFF1FFF;
        }
        if ((paramInt2 & 0x20) == 0) {
          break label963;
        }
        paramc = androidx.compose.ui.a.atD;
        paramc = a.a.sb();
        i = 0xFFF8FFFF & i;
      }
      for (;;)
      {
        j = i;
        if ((paramInt2 & 0x40) != 0)
        {
          parami = q.abg;
          parami = q.e(localh);
          j = i & 0xFFC7FFFF;
        }
        localh.og();
        i = j;
        paramh = parami;
        parami = paramd;
        paramd = paramh;
        o.a(a(paramb, localh), paramf, paramaa, paramt, paramBoolean, false, paramd, null, null, paramc, parami, localh, 0x30000 | i << 3 & 0x70 | i << 3 & 0x380 | i << 3 & 0x1C00 | 0xE000 & i << 3 | 0x380000 & i | 0x70000000 & i << 12, i >> 12 & 0xE, 384);
        paramh = parami;
        parami = paramd;
        paramd = paramh;
        label590:
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((m)new b(paramf, paramaa, paramt, paramBoolean, paramd, paramc, parami, paramb, paramInt1, paramInt2));
        }
        AppMethodBeat.o(204207);
        return;
        if ((paramInt1 & 0xE) != 0) {
          break label966;
        }
        if (localh.G(paramf))
        {
          i = 4;
          break;
        }
        i = 2;
        break;
        i = 16;
        break label75;
        j = i;
        if ((paramInt1 & 0x380) != 0) {
          break label101;
        }
        if (localh.G(paramt))
        {
          j = 256;
          break label94;
        }
        j = 128;
        break label94;
        label721:
        i = j;
        if ((paramInt1 & 0x1C00) != 0) {
          break label121;
        }
        if (localh.am(paramBoolean))
        {
          i = 2048;
          break label114;
        }
        i = 1024;
        break label114;
        label761:
        j = 8192;
        break label158;
        i = 65536;
        break label201;
        j = 524288;
        break label244;
        i = j;
        if ((0x1C00000 & paramInt1) != 0) {
          break label271;
        }
        if (localh.G(paramb))
        {
          i = 8388608;
          break label264;
        }
        i = 4194304;
        break label264;
        paramd = androidx.compose.foundation.c.a.abN;
        paramd = androidx.compose.foundation.c.a.mu();
        break label405;
        localh.oj();
        if ((paramInt2 & 0x2) != 0) {}
        for (j = i & 0xFFFFFF8F;; j = i)
        {
          i = j;
          if ((paramInt2 & 0x10) != 0) {
            i = j & 0xFFFF1FFF;
          }
          j = i;
          if ((paramInt2 & 0x20) != 0) {
            j = i & 0xFFF8FFFF;
          }
          if ((paramInt2 & 0x40) != 0)
          {
            i = j & 0xFFC7FFFF;
            paramh = paramd;
            paramd = parami;
            parami = paramh;
            break;
            localh.oi();
            break label590;
          }
          i = j;
          paramh = paramd;
          paramd = parami;
          parami = paramh;
          break;
        }
      }
    }
  }
  
  public static final void a(f paramf, final aa paramaa, final t paramt, final boolean paramBoolean, final a.l paraml, final a.b paramb, final i parami, final b<? super w, ah> paramb1, h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(204214);
    s.u(paramb1, "content");
    h localh = paramh.by(-750323803);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label77:
    label973:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      i = j;
      if ((paramInt1 & 0x70) == 0)
      {
        if (((paramInt2 & 0x2) == 0) && (localh.G(paramaa)))
        {
          i = 32;
          i = j | i;
        }
      }
      else
      {
        if ((paramInt2 & 0x4) == 0) {
          break label688;
        }
        j = 384;
        label96:
        j = i | j;
        label103:
        if ((paramInt2 & 0x8) == 0) {
          break label728;
        }
        i = 3072;
        label116:
        i = j | i;
        label123:
        j = i;
        if ((0xE000 & paramInt1) == 0)
        {
          if (((paramInt2 & 0x10) != 0) || (!localh.G(paraml))) {
            break label768;
          }
          j = 16384;
          j = i | j;
        }
        i = j;
        if ((0x70000 & paramInt1) == 0)
        {
          if (((paramInt2 & 0x20) != 0) || (!localh.G(paramb))) {
            break label776;
          }
          i = 131072;
          i = j | i;
        }
        j = i;
        if ((0x380000 & paramInt1) == 0)
        {
          if (((paramInt2 & 0x40) != 0) || (!localh.G(parami))) {
            break label783;
          }
          j = 1048576;
          label246:
          j = i | j;
        }
        if ((paramInt2 & 0x80) == 0) {
          break label791;
        }
        i = 12582912;
        i = j | i;
        if (((0x16DB6DB & i ^ 0x492492) == 0) && (localh.nZ())) {
          break label934;
        }
        if (((paramInt1 & 0x1) != 0) && (!localh.oa())) {
          break label845;
        }
        localh.of();
        if ((paramInt2 & 0x1) != 0) {
          paramf = (f)f.aud;
        }
        j = i;
        if ((paramInt2 & 0x2) != 0)
        {
          paramaa = ab.f(localh);
          j = i & 0xFFFFFF8F;
        }
        if ((paramInt2 & 0x4) != 0) {
          paramt = r.C(androidx.compose.ui.n.g.ai(0.0F));
        }
        if ((paramInt2 & 0x8) != 0) {
          paramBoolean = false;
        }
        i = j;
        if ((paramInt2 & 0x10) != 0)
        {
          if (paramBoolean) {
            break label832;
          }
          paraml = androidx.compose.foundation.c.a.abN;
          paraml = androidx.compose.foundation.c.a.mw();
          i = j & 0xFFFF1FFF;
        }
        if ((paramInt2 & 0x20) == 0) {
          break label970;
        }
        paramb = androidx.compose.ui.a.atD;
        paramb = a.a.sd();
        i = 0xFFF8FFFF & i;
      }
      for (;;)
      {
        j = i;
        if ((paramInt2 & 0x40) != 0)
        {
          parami = q.abg;
          parami = q.e(localh);
          j = i & 0xFFC7FFFF;
        }
        localh.og();
        i = j;
        paramh = parami;
        parami = paraml;
        paraml = paramh;
        o.a(a(paramb1, localh), paramf, paramaa, paramt, paramBoolean, true, paraml, paramb, parami, null, null, localh, i << 12 & 0xE000000 | 0x30000 | i << 3 & 0x70 | i << 3 & 0x380 | i << 3 & 0x1C00 | 0xE000 & i << 3 | 0x380000 & i | 0x1C00000 & i << 6, 0, 1536);
        paramh = parami;
        parami = paraml;
        paraml = paramh;
        label596:
        paramh = localh.oh();
        if (paramh != null) {
          paramh.b((m)new a(paramf, paramaa, paramt, paramBoolean, paraml, paramb, parami, paramb1, paramInt1, paramInt2));
        }
        AppMethodBeat.o(204214);
        return;
        if ((paramInt1 & 0xE) != 0) {
          break label973;
        }
        if (localh.G(paramf))
        {
          i = 4;
          break;
        }
        i = 2;
        break;
        i = 16;
        break label77;
        j = i;
        if ((paramInt1 & 0x380) != 0) {
          break label103;
        }
        if (localh.G(paramt))
        {
          j = 256;
          break label96;
        }
        j = 128;
        break label96;
        label728:
        i = j;
        if ((paramInt1 & 0x1C00) != 0) {
          break label123;
        }
        if (localh.am(paramBoolean))
        {
          i = 2048;
          break label116;
        }
        i = 1024;
        break label116;
        j = 8192;
        break label160;
        i = 65536;
        break label203;
        j = 524288;
        break label246;
        i = j;
        if ((0x1C00000 & paramInt1) != 0) {
          break label273;
        }
        if (localh.G(paramb1))
        {
          i = 8388608;
          break label266;
        }
        i = 4194304;
        break label266;
        paraml = androidx.compose.foundation.c.a.abN;
        paraml = androidx.compose.foundation.c.a.mx();
        break label407;
        localh.oj();
        if ((paramInt2 & 0x2) != 0) {}
        for (j = i & 0xFFFFFF8F;; j = i)
        {
          i = j;
          if ((paramInt2 & 0x10) != 0) {
            i = j & 0xFFFF1FFF;
          }
          j = i;
          if ((paramInt2 & 0x20) != 0) {
            j = i & 0xFFF8FFFF;
          }
          if ((paramInt2 & 0x40) != 0)
          {
            i = j & 0xFFC7FFFF;
            paramh = paraml;
            paraml = parami;
            parami = paramh;
            break;
            localh.oi();
            break label596;
          }
          i = j;
          paramh = paraml;
          paraml = parami;
          parami = paramh;
          break;
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<h, Integer, ah>
  {
    a(f paramf, aa paramaa, t paramt, boolean paramBoolean, a.l paraml, a.b paramb, i parami, b<? super w, ah> paramb1, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<h, Integer, ah>
  {
    b(f paramf, aa paramaa, t paramt, boolean paramBoolean, a.d paramd, a.c paramc, i parami, b<? super w, ah> paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<x>
  {
    c(bm<? extends b<? super w, ah>> parambm)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.g
 * JD-Core Version:    0.7.0.1
 */