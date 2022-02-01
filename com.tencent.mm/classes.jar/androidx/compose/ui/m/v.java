package androidx.compose.ui.m;

import androidx.compose.ui.e.ax;
import androidx.compose.ui.e.z;
import androidx.compose.ui.m.b.h;
import androidx.compose.ui.m.b.i;
import androidx.compose.ui.m.f.a;
import androidx.compose.ui.m.f.c;
import androidx.compose.ui.m.f.f;
import androidx.compose.ui.n.n;
import androidx.compose.ui.n.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"DefaultBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultColor", "DefaultFontSize", "Landroidx/compose/ui/unit/TextUnit;", "DefaultLetterSpacing", "DefaultLineHeight", "lerp", "Landroidx/compose/ui/text/TextStyle;", "start", "stop", "fraction", "", "resolveDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "resolveTextDirection", "Landroidx/compose/ui/text/style/TextDirection;", "layoutDirection", "textDirection", "resolveTextDirection-Yj3eThk", "(Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/style/TextDirection;)I", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class v
{
  private static final long baD;
  private static final long baE;
  private static final long baF;
  private static final long baG;
  private static final long baH;
  
  static
  {
    AppMethodBeat.i(204945);
    baD = androidx.compose.ui.n.p.dG(14);
    baE = androidx.compose.ui.n.p.dG(0);
    Object localObject = z.awK;
    baF = z.tz();
    localObject = o.beS;
    baG = o.sw();
    localObject = z.awK;
    baH = z.tv();
    AppMethodBeat.o(204945);
  }
  
  public static final u a(u paramu, n paramn)
  {
    AppMethodBeat.i(204940);
    s.u(paramu, "style");
    s.u(paramn, "direction");
    long l1 = paramu.ayn;
    Object localObject1 = z.awK;
    int i;
    label43:
    long l2;
    label58:
    label79:
    Object localObject2;
    label99:
    androidx.compose.ui.m.b.g localg;
    label125:
    h localh;
    Object localObject3;
    label174:
    long l3;
    label189:
    Object localObject4;
    float f;
    label209:
    a locala;
    label236:
    Object localObject5;
    label257:
    long l4;
    Object localObject6;
    label279:
    label283:
    Object localObject7;
    Object localObject8;
    label353:
    androidx.compose.ui.m.f.e locale;
    boolean bool;
    if (l1 != z.sw())
    {
      i = 1;
      if (i == 0) {
        break label444;
      }
      if (!androidx.compose.ui.n.p.bq(paramu.bai)) {
        break label452;
      }
      l2 = baD;
      localObject1 = paramu.baj;
      if (localObject1 != null) {
        break label461;
      }
      localObject1 = i.bcc;
      localObject1 = i.Bk();
      localObject2 = paramu.bak;
      if (localObject2 != null) {
        break label464;
      }
      localObject2 = androidx.compose.ui.m.b.g.bbW;
      i = androidx.compose.ui.m.b.g.Bd();
      localg = androidx.compose.ui.m.b.g.dx(i);
      localObject2 = paramu.bal;
      if (localObject2 != null) {
        break label473;
      }
      localObject2 = h.bbZ;
      i = h.Bf();
      localh = h.dy(i);
      localObject3 = paramu.bam;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = androidx.compose.ui.m.b.d.bbP;
        localObject2 = (androidx.compose.ui.m.b.d)androidx.compose.ui.m.b.d.Bc();
      }
      localObject3 = paramu.ban;
      if (localObject3 != null) {
        break label482;
      }
      localObject3 = "";
      if (!androidx.compose.ui.n.p.bq(paramu.bao)) {
        break label485;
      }
      l3 = baE;
      localObject4 = paramu.bap;
      if (localObject4 != null) {
        break label494;
      }
      localObject4 = a.bdZ;
      f = a.BO();
      locala = a.aj(f);
      localObject4 = paramu.baq;
      if (localObject4 != null) {
        break label503;
      }
      localObject4 = f.beu;
      localObject4 = f.Cb();
      localObject5 = paramu.bar;
      if (localObject5 != null) {
        break label506;
      }
      localObject5 = androidx.compose.ui.m.d.e.bdD;
      localObject5 = androidx.compose.ui.m.d.e.a.BL();
      l4 = paramu.bas;
      localObject6 = z.awK;
      if (l4 == z.sw()) {
        break label509;
      }
      i = 1;
      if (i == 0) {
        break label514;
      }
      localObject7 = paramu.bat;
      localObject6 = localObject7;
      if (localObject7 == null)
      {
        localObject6 = androidx.compose.ui.m.f.d.bek;
        localObject6 = androidx.compose.ui.m.f.d.BT();
      }
      localObject8 = paramu.bau;
      localObject7 = localObject8;
      if (localObject8 == null)
      {
        localObject7 = ax.aym;
        localObject7 = ax.tN();
      }
      localObject8 = paramu.aZc;
      if (localObject8 != null) {
        break label522;
      }
      localObject8 = c.beg;
      i = c.BR();
      localObject8 = c.dD(i);
      locale = paramu.aZd;
      s.u(paramn, "layoutDirection");
      androidx.compose.ui.m.f.e.a locala1 = androidx.compose.ui.m.f.e.beo;
      i = androidx.compose.ui.m.f.e.BY();
      if (locale != null) {
        break label531;
      }
      bool = false;
    }
    for (;;)
    {
      if (bool) {
        switch (a.$EnumSwitchMapping$0[paramn.ordinal()])
        {
        default: 
          paramu = new kotlin.p();
          AppMethodBeat.o(204940);
          throw paramu;
          i = 0;
          break;
          l1 = baH;
          break label43;
          l2 = paramu.bai;
          break label58;
          break label79;
          i = ((androidx.compose.ui.m.b.g)localObject2).value;
          break label99;
          i = ((h)localObject2).value;
          break label125;
          break label174;
          l3 = paramu.bao;
          break label189;
          f = ((a)localObject4).bby;
          break label209;
          break label236;
          break label257;
          i = 0;
          break label279;
          l4 = baF;
          break label283;
          i = ((c)localObject8).value;
          break label353;
          bool = androidx.compose.ui.m.f.e.C(locale.value, i);
          break;
        case 1: 
          label444:
          label452:
          label461:
          label464:
          label473:
          label482:
          label485:
          label494:
          label503:
          label506:
          label509:
          paramn = androidx.compose.ui.m.f.e.beo;
          label514:
          label522:
          label531:
          i = androidx.compose.ui.m.f.e.BZ();
          locale = androidx.compose.ui.m.f.e.dE(i);
          if (!androidx.compose.ui.n.p.bq(paramu.aZe)) {
            break label738;
          }
        }
      }
    }
    label738:
    for (long l5 = baG;; l5 = paramu.aZe)
    {
      paramn = paramu.aZf;
      paramu = paramn;
      if (paramn == null)
      {
        paramu = androidx.compose.ui.m.f.g.bew;
        paramu = androidx.compose.ui.m.f.g.Cc();
      }
      paramu = new u(l1, l2, (i)localObject1, localg, localh, (androidx.compose.ui.m.b.d)localObject2, (String)localObject3, l3, locala, (f)localObject4, (androidx.compose.ui.m.d.e)localObject5, l4, (androidx.compose.ui.m.f.d)localObject6, (ax)localObject7, (c)localObject8, locale, l5, paramu, (byte)0);
      AppMethodBeat.o(204940);
      return paramu;
      paramn = androidx.compose.ui.m.f.e.beo;
      i = androidx.compose.ui.m.f.e.Ca();
      break;
      if (locale == null) {
        switch (a.$EnumSwitchMapping$0[paramn.ordinal()])
        {
        default: 
          paramu = new kotlin.p();
          AppMethodBeat.o(204940);
          throw paramu;
        case 1: 
          paramn = androidx.compose.ui.m.f.e.beo;
          i = androidx.compose.ui.m.f.e.BW();
          break;
        case 2: 
          paramn = androidx.compose.ui.m.f.e.beo;
          i = androidx.compose.ui.m.f.e.BX();
          break;
        }
      }
      i = locale.value;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.v
 * JD-Core Version:    0.7.0.1
 */