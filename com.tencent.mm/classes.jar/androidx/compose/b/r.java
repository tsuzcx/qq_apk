package androidx.compose.b;

import androidx.compose.a.a.aa;
import androidx.compose.a.a.aj;
import androidx.compose.a.a.at.b;
import androidx.compose.a.a.au;
import androidx.compose.a.a.aw;
import androidx.compose.foundation.k;
import androidx.compose.runtime.as;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "Tab", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class r
{
  private static final float aiX;
  private static final float aiY;
  private static final float aiZ;
  private static final float aja;
  private static final float ajb;
  private static final long ajc;
  private static final float ajd;
  
  static
  {
    AppMethodBeat.i(201789);
    aiX = androidx.compose.ui.n.g.ai(48.0F);
    aiY = androidx.compose.ui.n.g.ai(72.0F);
    aiZ = androidx.compose.ui.n.g.ai(16.0F);
    aja = androidx.compose.ui.n.g.ai(14.0F);
    ajb = androidx.compose.ui.n.g.ai(6.0F);
    ajc = androidx.compose.ui.n.p.dG(20);
    ajd = androidx.compose.ui.n.g.ai(8.0F);
    AppMethodBeat.o(201789);
  }
  
  private static final void a(long paramLong1, long paramLong2, final boolean paramBoolean, kotlin.g.a.m<? super h, ? super Integer, ah> paramm, h paramh, final int paramInt)
  {
    AppMethodBeat.i(201766);
    h localh = paramh.by(-1597696775);
    int i;
    if ((paramInt & 0xE) == 0) {
      if (localh.y(paramLong1)) {
        i = 4;
      }
    }
    for (int j = paramInt | i;; j = paramInt)
    {
      i = j;
      if ((paramInt & 0x70) == 0)
      {
        if (localh.y(paramLong2))
        {
          i = 32;
          label72:
          i = j | i;
        }
      }
      else
      {
        j = i;
        if ((paramInt & 0x380) == 0)
        {
          if (!localh.am(paramBoolean)) {
            break label615;
          }
          j = 256;
          label109:
          j = i | j;
        }
        if ((paramInt & 0x1C00) != 0) {
          break label659;
        }
        if (!localh.G(paramm)) {
          break label623;
        }
        i = 2048;
        label142:
        i |= j;
      }
      for (;;)
      {
        long l;
        if (((i & 0x16DB ^ 0x492) != 0) || (!localh.nZ()))
        {
          androidx.compose.a.a.at localat = au.c(Boolean.valueOf(paramBoolean), localh, i >> 6 & 0xE);
          kotlin.g.a.q localq = (kotlin.g.a.q)d.ajj;
          localh.bx(-1462136984);
          boolean bool = ((Boolean)localat.lO()).booleanValue();
          localh.bx(-2026688550);
          if (bool)
          {
            l = paramLong1;
            label239:
            localh.od();
            androidx.compose.ui.e.a.c localc = z.Y(l);
            localh.bx(-3686930);
            bool = localh.G(localc);
            Object localObject = localh.or();
            if (!bool)
            {
              paramh = h.alD;
              paramh = (h)localObject;
              if (localObject != h.a.ox()) {}
            }
            else
            {
              paramh = (aw)androidx.compose.a.f.a(z.awK).invoke(localc);
              localh.F(paramh);
            }
            localh.od();
            paramh = (aw)paramh;
            localh.bx(1847721878);
            bool = ((Boolean)localat.Wd.lN()).booleanValue();
            localh.bx(-2026688550);
            if (!bool) {
              break label637;
            }
            l = paramLong1;
            label387:
            localh.od();
            localObject = z.ad(l);
            bool = ((Boolean)localat.lO()).booleanValue();
            localh.bx(-2026688550);
            if (!bool) {
              break label643;
            }
            l = paramLong1;
            label431:
            localh.od();
            paramh = au.a(localat, localObject, z.ad(l), (aa)localq.invoke(localat.lR(), localh, Integer.valueOf(0)), paramh, "ColorAnimation", localh);
            localh.od();
            localh.od();
            androidx.compose.runtime.q.a(new androidx.compose.runtime.at[] { e.nv().N(z.ad(z.g(d(paramh), 1.0F))), d.nu().N(Float.valueOf(z.ac(d(paramh)))) }, paramm, localh, i >> 6 & 0x70 | 0x8);
          }
        }
        for (;;)
        {
          paramh = localh.oh();
          if (paramh != null) {
            paramh.b((kotlin.g.a.m)new c(paramLong1, paramLong2, paramBoolean, paramm, paramInt));
          }
          AppMethodBeat.o(201766);
          return;
          i = 2;
          break;
          i = 16;
          break label72;
          label615:
          j = 128;
          break label109;
          label623:
          i = 1024;
          break label142;
          l = paramLong2;
          break label239;
          label637:
          l = paramLong2;
          break label387;
          label643:
          l = paramLong2;
          break label431;
          localh.oi();
        }
        label659:
        i = j;
      }
    }
  }
  
  public static final void a(final boolean paramBoolean1, final a<ah> parama, final androidx.compose.ui.f paramf, final boolean paramBoolean2, final androidx.compose.foundation.b.e parame, final long paramLong1, long paramLong2, final kotlin.g.a.q<? super androidx.compose.foundation.c.g, ? super h, ? super Integer, ah> paramq, h paramh, int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(201756);
    s.u(parama, "onClick");
    s.u(paramq, "content");
    h localh = paramh.by(-226843966);
    int i;
    if ((paramInt2 & 0x1) != 0) {
      i = 6;
    }
    label62:
    label69:
    label81:
    label88:
    label101:
    label744:
    for (final int j = paramInt1 | i;; j = paramInt1)
    {
      if ((paramInt2 & 0x2) != 0)
      {
        i = 48;
        i = j | i;
        if ((paramInt2 & 0x4) == 0) {
          break label664;
        }
        j = 384;
        j = i | j;
        if ((paramInt2 & 0x8) == 0) {
          break label704;
        }
        i = 3072;
        i = j | i;
        label108:
        if ((paramInt2 & 0x10) == 0) {
          break label744;
        }
        j = 24576;
        label121:
        j = i | j;
        i = j;
        if ((0x70000 & paramInt1) == 0)
        {
          if (((paramInt2 & 0x20) != 0) || (!localh.y(paramLong1))) {
            break label785;
          }
          i = 131072;
          i = j | i;
        }
        j = i;
        if ((0x380000 & paramInt1) == 0)
        {
          if (((paramInt2 & 0x40) != 0) || (!localh.y(paramLong2))) {
            break label793;
          }
          j = 1048576;
          j = i | j;
        }
        if ((paramInt2 & 0x80) == 0) {
          break label801;
        }
        i = 12582912;
      }
      label232:
      for (i = j | i;; i = j)
      {
        if (((0x16DB6DB & i ^ 0x492492) != 0) || (!localh.nZ())) {
          if (((paramInt1 & 0x1) == 0) || (localh.oa()))
          {
            localh.of();
            if ((paramInt2 & 0x4) != 0) {
              paramf = (androidx.compose.ui.f)androidx.compose.ui.f.aud;
            }
            if ((paramInt2 & 0x8) != 0) {
              paramBoolean2 = true;
            }
            if ((paramInt2 & 0x10) != 0)
            {
              localh.bx(-3687241);
              paramh = localh.or();
              parame = h.alD;
              parame = paramh;
              if (paramh == h.a.ox())
              {
                parame = androidx.compose.foundation.b.d.ms();
                localh.F(parame);
              }
              localh.od();
              parame = (androidx.compose.foundation.b.e)parame;
            }
            if ((paramInt2 & 0x20) == 0) {
              break label897;
            }
            paramLong1 = ((z)localh.a((androidx.compose.runtime.p)e.nv())).value;
            i = 0xFFF8FFFF & i;
          }
        }
        for (;;)
        {
          j = i;
          if ((paramInt2 & 0x40) != 0)
          {
            paramh = c.air;
            paramLong2 = z.g(paramLong1, c.g(localh));
            j = i & 0xFFC7FFFF;
          }
          localh.og();
          label894:
          for (;;)
          {
            a(paramLong1, paramLong2, paramBoolean1, (kotlin.g.a.m)androidx.compose.runtime.c.c.a(localh, -819900563, new a(paramf, paramBoolean1, parame, androidx.compose.b.a.m.a(true, 0.0F, paramLong1, localh, 2), paramBoolean2, parama, paramq, j)), localh, j >> 15 & 0xE | 0xC00 | j >> 15 & 0x70 | j << 6 & 0x380);
            for (;;)
            {
              paramh = localh.oh();
              if (paramh != null) {
                paramh.b((kotlin.g.a.m)new b(paramBoolean1, parama, paramf, paramBoolean2, parame, paramLong1, paramLong2, paramq, paramInt1, paramInt2));
              }
              AppMethodBeat.o(201756);
              return;
              if ((paramInt1 & 0xE) != 0) {
                break label907;
              }
              if (localh.am(paramBoolean1))
              {
                i = 4;
                break;
              }
              i = 2;
              break;
              i = j;
              if ((paramInt1 & 0x70) != 0) {
                break label69;
              }
              if (localh.G(parama))
              {
                i = 32;
                break label62;
              }
              i = 16;
              break label62;
              j = i;
              if ((paramInt1 & 0x380) != 0) {
                break label88;
              }
              if (localh.G(paramf))
              {
                j = 256;
                break label81;
              }
              j = 128;
              break label81;
              i = j;
              if ((paramInt1 & 0x1C00) != 0) {
                break label108;
              }
              if (localh.am(paramBoolean2))
              {
                i = 2048;
                break label101;
              }
              i = 1024;
              break label101;
              j = i;
              if ((0xE000 & paramInt1) != 0) {
                break label128;
              }
              if (localh.G(parame))
              {
                j = 16384;
                break label121;
              }
              j = 8192;
              break label121;
              i = 65536;
              break label166;
              j = 524288;
              break label211;
              if ((0x1C00000 & paramInt1) != 0) {
                break label900;
              }
              if (localh.G(paramq))
              {
                i = 8388608;
                break label232;
              }
              i = 4194304;
              break label232;
              localh.oj();
              j = i;
              if ((paramInt2 & 0x20) != 0) {
                j = i & 0xFFF8FFFF;
              }
              if ((paramInt2 & 0x40) == 0) {
                break label894;
              }
              j &= 0xFFC7FFFF;
              break label463;
              localh.oi();
            }
          }
        }
      }
    }
  }
  
  private static final long d(bm<z> parambm)
  {
    AppMethodBeat.i(201773);
    long l = ((z)parambm.getValue()).value;
    AppMethodBeat.o(201773);
    return l;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    a(androidx.compose.ui.f paramf, boolean paramBoolean1, androidx.compose.foundation.b.e parame, k paramk, boolean paramBoolean2, a<ah> parama, kotlin.g.a.q<? super androidx.compose.foundation.c.g, ? super h, ? super Integer, ah> paramq, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    b(boolean paramBoolean1, a<ah> parama, androidx.compose.ui.f paramf, boolean paramBoolean2, androidx.compose.foundation.b.e parame, long paramLong1, long paramLong2, kotlin.g.a.q<? super androidx.compose.foundation.c.g, ? super h, ? super Integer, ah> paramq, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.m<h, Integer, ah>
  {
    c(long paramLong1, long paramLong2, boolean paramBoolean, kotlin.g.a.m<? super h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.q<at.b<Boolean>, h, Integer, aa<z>>
  {
    public static final d ajj;
    
    static
    {
      AppMethodBeat.i(201654);
      ajj = new d();
      AppMethodBeat.o(201654);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.r
 * JD-Core Version:    0.7.0.1
 */