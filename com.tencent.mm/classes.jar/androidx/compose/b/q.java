package androidx.compose.b;

import androidx.compose.foundation.b.d;
import androidx.compose.foundation.k;
import androidx.compose.runtime.as;
import androidx.compose.runtime.at;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.c.c;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.e.au;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.e.z;
import androidx.compose.ui.f;
import androidx.compose.ui.g.c.ac;
import androidx.compose.ui.k.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "border", "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Surface-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "clickAndSemanticsModifier", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class q
{
  static final void a(f paramf1, final ay paramay, final long paramLong1, long paramLong2, final androidx.compose.foundation.e parame, final float paramFloat, final f paramf2, final kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(201762);
    paramh = paramh.by(-750961937);
    final int i;
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramf1)) {
        i = 4;
      }
    }
    for (int j = paramInt | i;; j = paramInt)
    {
      i = j;
      label72:
      label108:
      label251:
      final long l;
      if ((paramInt & 0x70) == 0)
      {
        if (paramh.G(paramay))
        {
          i = 32;
          i = j | i;
        }
      }
      else
      {
        j = i;
        if ((paramInt & 0x380) == 0)
        {
          if (!paramh.y(paramLong1)) {
            break label569;
          }
          j = 256;
          j = i | j;
        }
        i = j;
        if ((paramInt & 0x1C00) == 0)
        {
          if (!paramh.y(paramLong2)) {
            break label577;
          }
          i = 2048;
          label145:
          i = j | i;
        }
        j = i;
        if ((0xE000 & paramInt) == 0)
        {
          if (!paramh.G(parame)) {
            break label585;
          }
          j = 16384;
          label181:
          j = i | j;
        }
        i = j;
        if ((0x70000 & paramInt) == 0)
        {
          if (!paramh.H(paramFloat)) {
            break label593;
          }
          i = 131072;
          label216:
          i = j | i;
        }
        j = i;
        if ((0x380000 & paramInt) == 0)
        {
          if (!paramh.G(paramf2)) {
            break label600;
          }
          j = 1048576;
          j = i | j;
        }
        i = j;
        if ((0x1C00000 & paramInt) == 0)
        {
          if (!paramh.G(paramm)) {
            break label607;
          }
          i = 8388608;
          label286:
          i = j | i;
        }
        if (((0x16DB6DB & i ^ 0x492492) == 0) && (paramh.nZ())) {
          break label636;
        }
        Object localObject1 = (h)paramh.a((p)i.nw());
        float f = androidx.compose.ui.n.g.ai(((androidx.compose.ui.n.g)paramh.a((p)i.nx())).value + paramFloat);
        Object localObject2 = m.aiH;
        if ((!z.e(paramLong1, m.j(paramh).nk())) || (localObject1 == null)) {
          break label614;
        }
        paramh.bx(-750961487);
        l = ((h)localObject1).a(paramLong1, f, paramh, i >> 6 & 0xE);
        paramh.od();
        label422:
        localObject1 = e.nv().N(z.ad(paramLong2));
        localObject2 = i.nx().N(androidx.compose.ui.n.g.al(f));
        kotlin.g.a.m localm = (kotlin.g.a.m)c.a(paramh, -819902387, new e(paramf1, paramFloat, paramay, parame, l, paramf2, paramm, i));
        androidx.compose.runtime.q.a(new at[] { localObject1, localObject2 }, localm, paramh, 56);
      }
      for (;;)
      {
        paramh = paramh.oh();
        if (paramh != null) {
          paramh.b((kotlin.g.a.m)new f(paramf1, paramay, paramLong1, paramLong2, parame, paramFloat, paramf2, paramm, paramInt));
        }
        AppMethodBeat.o(201762);
        return;
        i = 2;
        break;
        i = 16;
        break label72;
        label569:
        j = 128;
        break label108;
        label577:
        i = 1024;
        break label145;
        label585:
        j = 8192;
        break label181;
        label593:
        i = 65536;
        break label216;
        label600:
        j = 524288;
        break label251;
        label607:
        i = 4194304;
        break label286;
        label614:
        paramh.bx(-750961417);
        paramh.od();
        l = paramLong1;
        break label422;
        label636:
        paramh.oi();
      }
    }
  }
  
  public static final void a(f paramf, final ay paramay, final long paramLong1, long paramLong2, final androidx.compose.foundation.e parame, float paramFloat, final kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, androidx.compose.runtime.h paramh, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(201738);
    s.u(paramm, "content");
    paramh = paramh.by(-750968235);
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label772:
    label775:
    for (int i = paramInt1 | i;; i = paramInt1)
    {
      int j;
      if ((paramInt2 & 0x2) != 0)
      {
        j = 48;
        label52:
        j = i | j;
        label59:
        int k = j;
        if ((paramInt1 & 0x380) == 0)
        {
          if (((paramInt2 & 0x4) != 0) || (!paramh.y(paramLong1))) {
            break label582;
          }
          i = 256;
          label95:
          k = j | i;
        }
        i = k;
        if ((paramInt1 & 0x1C00) == 0)
        {
          if (((paramInt2 & 0x8) != 0) || (!paramh.y(paramLong2))) {
            break label590;
          }
          i = 2048;
          label140:
          i = k | i;
        }
        if ((paramInt2 & 0x10) == 0) {
          break label598;
        }
        j = 24576;
        label160:
        j = i | j;
        label167:
        if ((paramInt2 & 0x20) == 0) {
          break label638;
        }
        i = 196608;
        label179:
        i = j | i;
        label186:
        if ((paramInt2 & 0x40) == 0) {
          break label676;
        }
        j = 1572864;
        label198:
        i |= j;
      }
      for (;;)
      {
        if (((0x2DB6DB & i ^ 0x92492) != 0) || (!paramh.nZ())) {
          if (((paramInt1 & 0x1) == 0) || (paramh.oa()))
          {
            paramh.of();
            if ((paramInt2 & 0x1) != 0) {
              paramf = (f)f.aud;
            }
            if ((paramInt2 & 0x2) != 0) {
              paramay = au.tM();
            }
            j = i;
            if ((paramInt2 & 0x4) != 0)
            {
              m localm = m.aiH;
              paramLong1 = m.j(paramh).nk();
              j = i & 0xFFFFFC7F;
            }
            i = j;
            if ((paramInt2 & 0x8) != 0)
            {
              paramLong2 = b.a(paramLong1, paramh);
              i = j & 0xFFFFE3FF;
            }
            if ((paramInt2 & 0x10) != 0) {
              parame = null;
            }
            if ((paramInt2 & 0x20) != 0) {
              paramFloat = androidx.compose.ui.n.g.ai(0.0F);
            }
            paramh.og();
          }
        }
        for (;;)
        {
          label368:
          a(paramf, paramay, paramLong1, paramLong2, parame, paramFloat, ac.a(n.a((f)f.aud, false, (kotlin.g.a.b)q.a.aiR), ah.aiuX, (kotlin.g.a.m)new q.b(null)), paramm, paramh, i << 3 & 0x1C00000 | i & 0xE | i & 0x70 | i & 0x380 | i & 0x1C00 | 0xE000 & i | 0x70000 & i);
          for (;;)
          {
            paramh = paramh.oh();
            if (paramh != null) {
              paramh.b((kotlin.g.a.m)new c(paramf, paramay, paramLong1, paramLong2, parame, paramFloat, paramm, paramInt1, paramInt2));
            }
            AppMethodBeat.o(201738);
            return;
            if ((paramInt1 & 0xE) != 0) {
              break label775;
            }
            if (paramh.G(paramf))
            {
              i = 4;
              break;
            }
            i = 2;
            break;
            j = i;
            if ((paramInt1 & 0x70) != 0) {
              break label59;
            }
            if (paramh.G(paramay))
            {
              j = 32;
              break label52;
            }
            j = 16;
            break label52;
            label582:
            i = 128;
            break label95;
            label590:
            i = 1024;
            break label140;
            label598:
            j = i;
            if ((0xE000 & paramInt1) != 0) {
              break label167;
            }
            if (paramh.G(parame))
            {
              j = 16384;
              break label160;
            }
            j = 8192;
            break label160;
            label638:
            i = j;
            if ((0x70000 & paramInt1) != 0) {
              break label186;
            }
            if (paramh.H(paramFloat))
            {
              i = 131072;
              break label179;
            }
            i = 65536;
            break label179;
            label676:
            if ((0x380000 & paramInt1) != 0) {
              break label772;
            }
            if (paramh.G(paramm))
            {
              j = 1048576;
              break label198;
            }
            j = 524288;
            break label198;
            paramh.oj();
            j = i;
            if ((paramInt2 & 0x4) != 0) {
              j = i & 0xFFFFFC7F;
            }
            if ((paramInt2 & 0x8) == 0) {
              break label765;
            }
            i = j & 0xFFFFE3FF;
            break label368;
            paramh.oi();
          }
          label765:
          i = j;
        }
      }
    }
  }
  
  public static final void a(kotlin.g.a.a<ah> parama, final f paramf, final ay paramay, final long paramLong1, long paramLong2, final androidx.compose.foundation.e parame, float paramFloat, final androidx.compose.foundation.b.e parame1, final k paramk, final boolean paramBoolean, final String paramString, final androidx.compose.ui.k.g paramg, final kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, androidx.compose.runtime.h paramh, final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(201751);
    s.u(parama, "onClick");
    s.u(paramm, "content");
    androidx.compose.runtime.h localh = paramh.by(-750962995);
    int i;
    if ((paramInt3 & 0x1) != 0) {
      i = 6;
    }
    label168:
    label1450:
    for (int j = paramInt1 | i;; j = paramInt1)
    {
      label61:
      label68:
      label80:
      label87:
      int k;
      if ((paramInt3 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt3 & 0x4) == 0) {
          break label973;
        }
        j = 384;
        j = i | j;
        k = j;
        if ((paramInt1 & 0x1C00) == 0)
        {
          if (((paramInt3 & 0x8) != 0) || (!localh.y(paramLong1))) {
            break label1013;
          }
          i = 2048;
          label124:
          k = j | i;
        }
        i = k;
        if ((0xE000 & paramInt1) == 0)
        {
          if (((paramInt3 & 0x10) != 0) || (!localh.y(paramLong2))) {
            break label1021;
          }
          i = 16384;
          i = k | i;
        }
        if ((paramInt3 & 0x20) == 0) {
          break label1029;
        }
        j = 196608;
        label187:
        j = i | j;
        label194:
        if ((paramInt3 & 0x40) == 0) {
          break label1067;
        }
        i = 1572864;
        label206:
        i = j | i;
        label213:
        if ((paramInt3 & 0x80) == 0) {
          break label1105;
        }
        j = 12582912;
        label227:
        j = i | j;
        label234:
        i = j;
        if ((0xE000000 & paramInt1) == 0)
        {
          if (((paramInt3 & 0x100) != 0) || (!localh.G(paramk))) {
            break label1143;
          }
          i = 67108864;
          i = j | i;
        }
        if ((paramInt3 & 0x200) == 0) {
          break label1151;
        }
        j = 805306368;
        i |= j;
      }
      label1067:
      for (;;)
      {
        if ((paramInt3 & 0x400) != 0) {
          j = 6;
        }
        label314:
        for (j = paramInt2 | j;; j = paramInt2)
        {
          if ((paramInt3 & 0x800) != 0)
          {
            k = 48;
            label334:
            k = j | k;
            label341:
            if ((paramInt3 & 0x1000) == 0) {
              break label1258;
            }
            j = 384;
            label355:
            k |= j;
          }
          for (;;)
          {
            if (((0x5B6DB6DB & i ^ 0x12492492) != 0) || ((k & 0x2DB ^ 0x92) != 0) || (!localh.nZ())) {
              if (((paramInt1 & 0x1) == 0) || (localh.oa()))
              {
                localh.of();
                if ((paramInt3 & 0x2) != 0) {
                  paramf = (f)f.aud;
                }
                if ((paramInt3 & 0x4) != 0) {
                  paramay = au.tM();
                }
                if ((paramInt3 & 0x8) == 0) {
                  break label1430;
                }
                paramh = m.aiH;
                paramLong1 = m.j(localh).nk();
              }
            }
            for (j = i & 0xFFFFE3FF;; j = i)
            {
              i = j;
              if ((paramInt3 & 0x10) != 0)
              {
                paramLong2 = b.a(paramLong1, localh);
                i = j & 0xFFFF1FFF;
              }
              if ((paramInt3 & 0x20) != 0) {
                parame = null;
              }
              if ((paramInt3 & 0x40) != 0) {
                paramFloat = androidx.compose.ui.n.g.ai(0.0F);
              }
              if ((paramInt3 & 0x80) != 0)
              {
                localh.bx(-3687241);
                paramh = localh.or();
                parame1 = androidx.compose.runtime.h.alD;
                parame1 = paramh;
                if (paramh == h.a.ox())
                {
                  parame1 = d.ms();
                  localh.F(parame1);
                }
                localh.od();
                parame1 = (androidx.compose.foundation.b.e)parame1;
              }
              j = i;
              if ((paramInt3 & 0x100) != 0)
              {
                paramk = (k)localh.a((p)androidx.compose.foundation.m.mj());
                j = i & 0xF1FFFFFF;
              }
              if ((paramInt3 & 0x200) != 0) {
                paramBoolean = true;
              }
              if ((paramInt3 & 0x400) != 0) {
                paramString = null;
              }
              if ((paramInt3 & 0x800) != 0) {
                paramg = null;
              }
              localh.og();
              i = j;
              paramh = paramString;
              Object localObject = paramk;
              androidx.compose.foundation.b.e locale = parame1;
              paramString = parame;
              parame1 = paramay;
              paramk = paramh;
              parame = (androidx.compose.foundation.e)localObject;
              paramay = locale;
              a(paramf, parame1, paramLong1, paramLong2, paramString, paramFloat, androidx.compose.foundation.g.a((f)f.aud, paramay, parame, paramBoolean, paramk, paramg, parama), paramm, localh, i >> 3 & 0xE | i >> 3 & 0x70 | i >> 3 & 0x380 | i >> 3 & 0x1C00 | 0xE000 & i >> 3 | 0x70000 & i >> 3 | 0x1C00000 & k << 15);
              paramh = paramString;
              localObject = parame1;
              paramString = paramk;
              paramk = parame;
              parame1 = paramay;
              parame = paramh;
              paramay = (ay)localObject;
              label839:
              paramh = localh.oh();
              if (paramh != null) {
                paramh.b((kotlin.g.a.m)new d(parama, paramf, paramay, paramLong1, paramLong2, parame, paramFloat, parame1, paramk, paramBoolean, paramString, paramg, paramm, paramInt1, paramInt2, paramInt3));
              }
              AppMethodBeat.o(201751);
              return;
              if ((paramInt1 & 0xE) != 0) {
                break label1450;
              }
              if (localh.G(parama))
              {
                i = 4;
                break;
              }
              i = 2;
              break;
              i = j;
              if ((paramInt1 & 0x70) != 0) {
                break label68;
              }
              if (localh.G(paramf))
              {
                i = 32;
                break label61;
              }
              i = 16;
              break label61;
              label973:
              j = i;
              if ((paramInt1 & 0x380) != 0) {
                break label87;
              }
              if (localh.G(paramay))
              {
                j = 256;
                break label80;
              }
              j = 128;
              break label80;
              label1013:
              i = 1024;
              break label124;
              label1021:
              i = 8192;
              break label168;
              j = i;
              if ((0x70000 & paramInt1) != 0) {
                break label194;
              }
              if (localh.G(parame))
              {
                j = 131072;
                break label187;
              }
              j = 65536;
              break label187;
              i = j;
              if ((0x380000 & paramInt1) != 0) {
                break label213;
              }
              if (localh.H(paramFloat))
              {
                i = 1048576;
                break label206;
              }
              i = 524288;
              break label206;
              label1105:
              j = i;
              if ((0x1C00000 & paramInt1) != 0) {
                break label234;
              }
              if (localh.G(parame1))
              {
                j = 8388608;
                break label227;
              }
              j = 4194304;
              break label227;
              label1143:
              i = 33554432;
              break label273;
              label1151:
              if ((0x70000000 & paramInt1) != 0) {
                break label1447;
              }
              if (localh.am(paramBoolean))
              {
                j = 536870912;
                break label294;
              }
              j = 268435456;
              break label294;
              if ((paramInt2 & 0xE) != 0) {
                break label1440;
              }
              if (localh.G(paramString))
              {
                j = 4;
                break label314;
              }
              j = 2;
              break label314;
              k = j;
              if ((paramInt2 & 0x70) != 0) {
                break label341;
              }
              if (localh.G(paramg))
              {
                k = 32;
                break label334;
              }
              k = 16;
              break label334;
              label1258:
              if ((paramInt2 & 0x380) != 0) {
                break label1437;
              }
              if (localh.G(paramm))
              {
                j = 256;
                break label355;
              }
              j = 128;
              break label355;
              localh.oj();
              if ((paramInt3 & 0x8) != 0) {
                i &= 0xFFFFE3FF;
              }
              for (;;)
              {
                j = i;
                if ((paramInt3 & 0x10) != 0) {
                  j = i & 0xFFFF1FFF;
                }
                if ((paramInt3 & 0x100) != 0)
                {
                  i = j & 0xF1FFFFFF;
                  localObject = parame1;
                  paramh = parame;
                  parame1 = paramay;
                  paramay = (ay)localObject;
                  parame = paramk;
                  paramk = paramString;
                  paramString = paramh;
                  break;
                  localh.oi();
                  break label839;
                }
                i = j;
                localObject = parame1;
                paramh = parame;
                parame1 = paramay;
                paramay = (ay)localObject;
                parame = paramk;
                paramk = paramString;
                paramString = paramh;
                break;
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    c(f paramf, ay paramay, long paramLong1, long paramLong2, androidx.compose.foundation.e parame, float paramFloat, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    d(kotlin.g.a.a<ah> parama, f paramf, ay paramay, long paramLong1, long paramLong2, androidx.compose.foundation.e parame, float paramFloat, androidx.compose.foundation.b.e parame1, k paramk, boolean paramBoolean, String paramString, androidx.compose.ui.k.g paramg, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt1, int paramInt2, int paramInt3)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    e(f paramf1, float paramFloat, ay paramay, androidx.compose.foundation.e parame, long paramLong, f paramf2, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.m<androidx.compose.runtime.h, Integer, ah>
  {
    f(f paramf1, ay paramay, long paramLong1, long paramLong2, androidx.compose.foundation.e parame, float paramFloat, f paramf2, kotlin.g.a.m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.q
 * JD-Core Version:    0.7.0.1
 */