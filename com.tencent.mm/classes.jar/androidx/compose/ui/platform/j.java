package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import androidx.compose.runtime.aa;
import androidx.compose.runtime.an;
import androidx.compose.runtime.as;
import androidx.compose.runtime.at;
import androidx.compose.runtime.ba;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.c.c;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.y;
import androidx.savedstate.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"LocalConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroid/content/res/Configuration;", "getLocalConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalContext", "Landroid/content/Context;", "getLocalContext", "LocalLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getLocalLifecycleOwner", "LocalSavedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "getLocalSavedStateRegistryOwner", "LocalView", "Landroid/view/View;", "getLocalView", "ProvideAndroidCompositionLocals", "", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "noLocalProvidedFor", "", "name", "", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  private static final as<Configuration> aSJ;
  private static final as<Context> aSK;
  private static final as<androidx.lifecycle.q> aSL;
  private static final as<d> aSM;
  private static final as<View> aSN;
  
  static
  {
    AppMethodBeat.i(206945);
    aSJ = androidx.compose.runtime.q.a(bj.qj(), (a)a.aSO);
    aSK = androidx.compose.runtime.q.e((a)b.aSP);
    aSL = androidx.compose.runtime.q.e((a)c.aSQ);
    aSM = androidx.compose.runtime.q.e((a)d.aSR);
    aSN = androidx.compose.runtime.q.e((a)e.aSS);
    AppMethodBeat.o(206945);
  }
  
  public static final void a(AndroidComposeView paramAndroidComposeView, final m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, androidx.compose.runtime.h paramh, final int paramInt)
  {
    AppMethodBeat.i(206928);
    s.u(paramAndroidComposeView, "owner");
    s.u(paramm, "content");
    androidx.compose.runtime.h localh = paramh.by(-340663392);
    Object localObject2 = paramAndroidComposeView.getContext();
    localh.bx(-3687241);
    Object localObject1 = localh.or();
    paramh = androidx.compose.runtime.h.alD;
    paramh = (androidx.compose.runtime.h)localObject1;
    if (localObject1 == h.a.ox())
    {
      paramh = bj.b(((Context)localObject2).getResources().getConfiguration(), bj.qj());
      localh.F(paramh);
    }
    localh.od();
    Object localObject3 = (an)paramh;
    localh.bx(-3686930);
    boolean bool = localh.G(localObject3);
    paramh = localh.or();
    if (!bool)
    {
      localObject1 = androidx.compose.runtime.h.alD;
      if (paramh != h.a.ox()) {}
    }
    else
    {
      paramh = (b)new f((an)localObject3);
      localh.F(paramh);
    }
    for (;;)
    {
      localh.od();
      paramAndroidComposeView.setConfigurationChangeObserver((b)paramh);
      localh.bx(-3687241);
      localObject1 = localh.or();
      paramh = androidx.compose.runtime.h.alD;
      paramh = (androidx.compose.runtime.h)localObject1;
      if (localObject1 == h.a.ox())
      {
        s.s(localObject2, "context");
        paramh = new p((Context)localObject2);
        localh.F(paramh);
      }
      localh.od();
      localObject4 = (p)paramh;
      localObject5 = paramAndroidComposeView.getViewTreeOwners();
      if (localObject5 != null) {
        break;
      }
      paramAndroidComposeView = new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
      AppMethodBeat.o(206928);
      throw paramAndroidComposeView;
    }
    localh.bx(-3687241);
    localObject1 = localh.or();
    paramh = androidx.compose.runtime.h.alD;
    paramh = (androidx.compose.runtime.h)localObject1;
    if (localObject1 == h.a.ox())
    {
      paramh = x.a((View)paramAndroidComposeView, ((AndroidComposeView.b)localObject5).aRQ);
      localh.F(paramh);
    }
    localh.od();
    paramh = (w)paramh;
    aa.a(ah.aiuX, (b)new g(paramh), localh);
    localObject1 = aSJ;
    localObject3 = (Configuration)((bm)localObject3).getValue();
    s.s(localObject3, "configuration");
    localObject1 = ((as)localObject1).N(localObject3);
    localObject3 = aSK;
    s.s(localObject2, "context");
    localObject2 = ((as)localObject3).N(localObject2);
    localObject3 = aSL.N(((AndroidComposeView.b)localObject5).lifecycleOwner);
    Object localObject5 = aSM.N(((AndroidComposeView.b)localObject5).aRQ);
    paramh = androidx.compose.runtime.e.h.rd().N(paramh);
    at localat = aSN.N(paramAndroidComposeView.getView());
    Object localObject4 = (m)c.a(localh, -819894248, new h(paramAndroidComposeView, (p)localObject4, paramm, paramInt));
    androidx.compose.runtime.q.a(new at[] { localObject1, localObject2, localObject3, localObject5, paramh, localat }, (m)localObject4, localh, 56);
    paramh = localh.oh();
    if (paramh != null) {
      paramh.b((m)new i(paramAndroidComposeView, paramm, paramInt));
    }
    AppMethodBeat.o(206928);
  }
  
  public static final as<Context> yJ()
  {
    return aSK;
  }
  
  public static final as<androidx.lifecycle.q> yK()
  {
    return aSL;
  }
  
  public static final as<View> yL()
  {
    return aSN;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/content/res/Configuration;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Configuration>
  {
    public static final a aSO;
    
    static
    {
      AppMethodBeat.i(206637);
      aSO = new a();
      AppMethodBeat.o(206637);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/content/Context;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Context>
  {
    public static final b aSP;
    
    static
    {
      AppMethodBeat.i(206638);
      aSP = new b();
      AppMethodBeat.o(206638);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/lifecycle/LifecycleOwner;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<androidx.lifecycle.q>
  {
    public static final c aSQ;
    
    static
    {
      AppMethodBeat.i(206636);
      aSQ = new c();
      AppMethodBeat.o(206636);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/savedstate/SavedStateRegistryOwner;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<d>
  {
    public static final d aSR;
    
    static
    {
      AppMethodBeat.i(206634);
      aSR = new d();
      AppMethodBeat.o(206634);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<View>
  {
    public static final e aSS;
    
    static
    {
      AppMethodBeat.i(206626);
      aSS = new e();
      AppMethodBeat.o(206626);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<Configuration, ah>
  {
    f(an<Configuration> paraman)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements b<y, androidx.compose.runtime.x>
  {
    g(w paramw)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements androidx.compose.runtime.x
    {
      public a(w paramw) {}
      
      public final void dispose()
      {
        AppMethodBeat.i(206640);
        this.aSV.aUb.invoke();
        AppMethodBeat.o(206640);
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    h(AndroidComposeView paramAndroidComposeView, p paramp, m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements m<androidx.compose.runtime.h, Integer, ah>
  {
    i(AndroidComposeView paramAndroidComposeView, m<? super androidx.compose.runtime.h, ? super Integer, ah> paramm, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.j
 * JD-Core Version:    0.7.0.1
 */