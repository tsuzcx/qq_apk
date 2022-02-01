package androidx.compose.ui.i;

import androidx.compose.ui.h.p;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/ComposeUiNode;", "", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public static final a aNC = a.aND;
  
  public abstract void a(p paramp);
  
  public abstract void setDensity(d paramd);
  
  public abstract void setLayoutDirection(n paramn);
  
  public abstract void setModifier(androidx.compose.ui.f paramf);
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/node/ComposeUiNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/ComposeUiNode;", "getConstructor", "()Lkotlin/jvm/functions/Function0;", "SetDensity", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "", "Lkotlin/ExtensionFunctionType;", "getSetDensity", "()Lkotlin/jvm/functions/Function2;", "SetLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getSetLayoutDirection", "SetMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getSetMeasurePolicy", "SetModifier", "Landroidx/compose/ui/Modifier;", "getSetModifier", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final kotlin.g.a.a<a> aNE;
    private static final m<a, androidx.compose.ui.f, ah> aNF;
    private static final m<a, d, ah> aNG;
    private static final m<a, p, ah> aNH;
    private static final m<a, n, ah> aNI;
    
    static
    {
      AppMethodBeat.i(204545);
      aND = new a();
      f.a locala = f.aOe;
      aNE = f.xM();
      aNF = (m)d.aNM;
      aNG = (m)a.aNJ;
      aNH = (m)c.aNL;
      aNI = (m)b.aNK;
      AppMethodBeat.o(204545);
    }
    
    public static kotlin.g.a.a<a> xb()
    {
      return aNE;
    }
    
    public static m<a, androidx.compose.ui.f, ah> xc()
    {
      return aNF;
    }
    
    public static m<a, d, ah> xd()
    {
      return aNG;
    }
    
    public static m<a, p, ah> xe()
    {
      return aNH;
    }
    
    public static m<a, n, ah> xf()
    {
      return aNI;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/node/ComposeUiNode;", "it", "Landroidx/compose/ui/unit/Density;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<a, d, ah>
    {
      public static final a aNJ;
      
      static
      {
        AppMethodBeat.i(204588);
        aNJ = new a();
        AppMethodBeat.o(204588);
      }
      
      a()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/node/ComposeUiNode;", "it", "Landroidx/compose/ui/unit/LayoutDirection;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements m<a, n, ah>
    {
      public static final b aNK;
      
      static
      {
        AppMethodBeat.i(204597);
        aNK = new b();
        AppMethodBeat.o(204597);
      }
      
      b()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/node/ComposeUiNode;", "it", "Landroidx/compose/ui/layout/MeasurePolicy;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements m<a, p, ah>
    {
      public static final c aNL;
      
      static
      {
        AppMethodBeat.i(204563);
        aNL = new c();
        AppMethodBeat.o(204563);
      }
      
      c()
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/node/ComposeUiNode;", "it", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements m<a, androidx.compose.ui.f, ah>
    {
      public static final d aNM;
      
      static
      {
        AppMethodBeat.i(204568);
        aNM = new d();
        AppMethodBeat.o(204568);
      }
      
      d()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.a
 * JD-Core Version:    0.7.0.1
 */