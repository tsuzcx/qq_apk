package androidx.compose.ui.platform;

import androidx.compose.runtime.as;
import androidx.compose.runtime.at;
import androidx.compose.runtime.h;
import androidx.compose.runtime.q;
import androidx.compose.ui.a.g;
import androidx.compose.ui.c.c;
import androidx.compose.ui.i.y;
import androidx.compose.ui.m.b.c.a;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"LocalAccessibilityManager", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/platform/AccessibilityManager;", "getLocalAccessibilityManager", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalAutofill", "Landroidx/compose/ui/autofill/Autofill;", "getLocalAutofill$annotations", "()V", "getLocalAutofill", "LocalAutofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getLocalAutofillTree$annotations", "getLocalAutofillTree", "LocalClipboardManager", "Landroidx/compose/ui/platform/ClipboardManager;", "getLocalClipboardManager", "LocalDensity", "Landroidx/compose/ui/unit/Density;", "getLocalDensity", "LocalFocusManager", "Landroidx/compose/ui/focus/FocusManager;", "getLocalFocusManager", "LocalFontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getLocalFontLoader", "LocalHapticFeedback", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getLocalHapticFeedback", "LocalLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLocalLayoutDirection", "LocalTextInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getLocalTextInputService", "LocalTextToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getLocalTextToolbar", "LocalUriHandler", "Landroidx/compose/ui/platform/UriHandler;", "getLocalUriHandler", "LocalViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getLocalViewConfiguration", "LocalWindowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getLocalWindowInfo", "ProvideCommonCompositionLocals", "", "owner", "Landroidx/compose/ui/node/Owner;", "uriHandler", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/node/Owner;Landroidx/compose/ui/platform/UriHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "noLocalProvidedFor", "", "name", "", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class u
{
  private static final as<s> aTA;
  private static final as<d> aTB;
  private static final as<c> aTC;
  private static final as<c.a> aTD;
  private static final as<androidx.compose.ui.f.a> aTE;
  private static final as<n> aTF;
  private static final as<androidx.compose.ui.m.c.s> aTG;
  private static final as<ao> aTH;
  private static final as<aq> aTI;
  private static final as<av> aTJ;
  private static final as<ba> aTK;
  private static final as<b> aTx;
  private static final as<androidx.compose.ui.a.b> aTy;
  private static final as<g> aTz;
  
  static
  {
    AppMethodBeat.i(206873);
    aTx = q.e((kotlin.g.a.a)a.aTL);
    aTy = q.e((kotlin.g.a.a)b.aTM);
    aTz = q.e((kotlin.g.a.a)c.aTN);
    aTA = q.e((kotlin.g.a.a)d.aTO);
    aTB = q.e((kotlin.g.a.a)e.aTP);
    aTC = q.e((kotlin.g.a.a)f.aTQ);
    aTD = q.e((kotlin.g.a.a)g.aTR);
    aTE = q.e((kotlin.g.a.a)h.aTS);
    aTF = q.e((kotlin.g.a.a)i.aTT);
    aTG = q.e((kotlin.g.a.a)j.aTU);
    aTH = q.e((kotlin.g.a.a)k.aTV);
    aTI = q.e((kotlin.g.a.a)l.aTW);
    aTJ = q.e((kotlin.g.a.a)m.aTX);
    aTK = q.e((kotlin.g.a.a)n.aTY);
    AppMethodBeat.o(206873);
  }
  
  public static final void a(y paramy, final aq paramaq, final m<? super h, ? super Integer, ah> paramm, h paramh, final int paramInt)
  {
    AppMethodBeat.i(206854);
    kotlin.g.b.s.u(paramy, "owner");
    kotlin.g.b.s.u(paramaq, "uriHandler");
    kotlin.g.b.s.u(paramm, "content");
    paramh = paramh.by(1527606823);
    if ((paramInt & 0xE) == 0) {
      if (paramh.G(paramy)) {
        i = 4;
      }
    }
    for (int i = paramInt | i;; i = paramInt)
    {
      int j = i;
      if ((paramInt & 0x70) == 0)
      {
        if (paramh.G(paramaq))
        {
          j = 32;
          label86:
          j = i | j;
        }
      }
      else
      {
        if ((paramInt & 0x380) != 0) {
          break label447;
        }
        if (!paramh.G(paramm)) {
          break label430;
        }
        i = 256;
        label117:
        i |= j;
      }
      for (;;)
      {
        if (((i & 0x2DB ^ 0x92) != 0) || (!paramh.nZ())) {
          q.a(new at[] { aTx.N(paramy.getAccessibilityManager()), aTy.N(paramy.getAutofill()), aTz.N(paramy.getAutofillTree()), aTA.N(paramy.getClipboardManager()), aTB.N(paramy.getDensity()), aTC.N(paramy.getFocusManager()), aTD.N(paramy.getFontLoader()), aTE.N(paramy.getHapticFeedBack()), aTF.N(paramy.getLayoutDirection()), aTG.N(paramy.getTextInputService()), aTH.N(paramy.getTextToolbar()), aTI.N(paramaq), aTJ.N(paramy.getViewConfiguration()), aTK.N(paramy.getWindowInfo()) }, paramm, paramh, i >> 3 & 0x70 | 0x8);
        }
        for (;;)
        {
          paramh = paramh.oh();
          if (paramh != null) {
            paramh.b((m)new o(paramy, paramaq, paramm, paramInt));
          }
          AppMethodBeat.o(206854);
          return;
          i = 2;
          break;
          j = 16;
          break label86;
          label430:
          i = 128;
          break label117;
          paramh.oi();
        }
        label447:
        i = j;
      }
    }
  }
  
  public static final as<d> yU()
  {
    return aTB;
  }
  
  public static final as<c.a> yV()
  {
    return aTD;
  }
  
  public static final as<n> yW()
  {
    return aTF;
  }
  
  public static final as<av> yX()
  {
    return aTJ;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/platform/AccessibilityManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<b>
  {
    public static final a aTL;
    
    static
    {
      AppMethodBeat.i(206709);
      aTL = new a();
      AppMethodBeat.o(206709);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/autofill/Autofill;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<androidx.compose.ui.a.b>
  {
    public static final b aTM;
    
    static
    {
      AppMethodBeat.i(206706);
      aTM = new b();
      AppMethodBeat.o(206706);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/autofill/AutofillTree;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<g>
  {
    public static final c aTN;
    
    static
    {
      AppMethodBeat.i(206701);
      aTN = new c();
      AppMethodBeat.o(206701);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/platform/ClipboardManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<s>
  {
    public static final d aTO;
    
    static
    {
      AppMethodBeat.i(206702);
      aTO = new d();
      AppMethodBeat.o(206702);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/Density;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.a<d>
  {
    public static final e aTP;
    
    static
    {
      AppMethodBeat.i(206708);
      aTP = new e();
      AppMethodBeat.o(206708);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/focus/FocusManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<c>
  {
    public static final f aTQ;
    
    static
    {
      AppMethodBeat.i(206697);
      aTQ = new f();
      AppMethodBeat.o(206697);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/text/font/Font$ResourceLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<c.a>
  {
    public static final g aTR;
    
    static
    {
      AppMethodBeat.i(206700);
      aTR = new g();
      AppMethodBeat.o(206700);
    }
    
    g()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<androidx.compose.ui.f.a>
  {
    public static final h aTS;
    
    static
    {
      AppMethodBeat.i(206696);
      aTS = new h();
      AppMethodBeat.o(206696);
    }
    
    h()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/unit/LayoutDirection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<n>
  {
    public static final i aTT;
    
    static
    {
      AppMethodBeat.i(206690);
      aTT = new i();
      AppMethodBeat.o(206690);
    }
    
    i()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/text/input/TextInputService;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<androidx.compose.ui.m.c.s>
  {
    public static final j aTU;
    
    static
    {
      AppMethodBeat.i(206689);
      aTU = new j();
      AppMethodBeat.o(206689);
    }
    
    j()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/platform/TextToolbar;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ao>
  {
    public static final k aTV;
    
    static
    {
      AppMethodBeat.i(206685);
      aTV = new k();
      AppMethodBeat.o(206685);
    }
    
    k()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/platform/UriHandler;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<aq>
  {
    public static final l aTW;
    
    static
    {
      AppMethodBeat.i(206679);
      aTW = new l();
      AppMethodBeat.o(206679);
    }
    
    l()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/platform/ViewConfiguration;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<av>
  {
    public static final m aTX;
    
    static
    {
      AppMethodBeat.i(206677);
      aTX = new m();
      AppMethodBeat.o(206677);
    }
    
    m()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/platform/WindowInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ba>
  {
    public static final n aTY;
    
    static
    {
      AppMethodBeat.i(206670);
      aTY = new n();
      AppMethodBeat.o(206670);
    }
    
    n()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements m<h, Integer, ah>
  {
    o(y paramy, aq paramaq, m<? super h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.u
 * JD-Core Version:    0.7.0.1
 */