package com.tencent.mm.plugin.livebase.a;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livebase/coroutine/LifecycleScopeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "uicScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getUicScope", "()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "uicScope$delegate", "Lkotlin/Lazy;", "plugin-livebase_release"})
public final class a
  extends UIComponent
{
  private final f Ehj;
  private final String TAG;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(187609);
    this.TAG = "MicroMsg.Mvvm.LifecycleScopeUIC";
    this.Ehj = g.ar((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(187609);
  }
  
  public final LifecycleScope eLM()
  {
    AppMethodBeat.i(187608);
    LifecycleScope localLifecycleScope = (LifecycleScope)this.Ehj.getValue();
    AppMethodBeat.o(187608);
    return localLifecycleScope;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<LifecycleScope>
  {
    a(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.livebase.a.a
 * JD-Core Version:    0.7.0.1
 */