package com.tencent.mm.kernel.mvvm;

import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.ak;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/kernel/mvvm/PluginComponent;", "Landroidx/lifecycle/ViewModel;", "plugin", "Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;", "(Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;)V", "getPlugin", "()Lcom/tencent/mm/kernel/mvvm/MvvmPlugin;", "onAccountInit", "", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountInitAfter", "onAccountInitBefore", "onAccountRelease", "Companion", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public class e
  extends af
{
  public static final a mFB;
  private final MvvmPlugin mFC;
  
  static
  {
    AppMethodBeat.i(235284);
    mFB = new a((byte)0);
    AppMethodBeat.o(235284);
  }
  
  public e(MvvmPlugin paramMvvmPlugin)
  {
    AppMethodBeat.i(235277);
    this.mFC = paramMvvmPlugin;
    AppMethodBeat.o(235277);
  }
  
  public static final <T extends e> T a(a parama, Class<T> paramClass)
  {
    AppMethodBeat.i(235281);
    parama = a.a(parama, paramClass);
    AppMethodBeat.o(235281);
    return parama;
  }
  
  public void bbx() {}
  
  public final MvvmPlugin bby()
  {
    return this.mFC;
  }
  
  public void bbz() {}
  
  public void onAccountRelease() {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/kernel/mvvm/PluginComponent$Companion;", "", "()V", "get", "T", "P", "Lcom/tencent/mm/kernel/mvvm/IMvvmPlugin;", "Lcom/tencent/mm/kernel/mvvm/PluginComponent;", "()Lcom/tencent/mm/kernel/mvvm/PluginComponent;", "plugin", "modelClass", "Ljava/lang/Class;", "(Lcom/tencent/mm/kernel/mvvm/IMvvmPlugin;Ljava/lang/Class;)Lcom/tencent/mm/kernel/mvvm/PluginComponent;", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T extends e> T a(a parama, Class<T> paramClass)
    {
      AppMethodBeat.i(235272);
      s.u(parama, "plugin");
      s.u(paramClass, "modelClass");
      h.baC().aZJ();
      if (!e.class.isAssignableFrom(paramClass))
      {
        parama = new IllegalArgumentException(s.X(parama.getClass().getName(), " must extends MvvmPlugin"));
        AppMethodBeat.o(235272);
        throw parama;
      }
      parama = new ah((ak)parama, (ah.b)new a(parama)).q(paramClass);
      s.s(parama, "plugin : IMvvmPlugin, mo…       }).get(modelClass)");
      parama = (e)parama;
      AppMethodBeat.o(235272);
      return parama;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/kernel/mvvm/PluginComponent$Companion$get$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ah.b
    {
      a(a parama) {}
      
      public final <T extends af> T create(Class<T> paramClass)
      {
        AppMethodBeat.i(235271);
        s.u(paramClass, "modelClass");
        paramClass = (af)paramClass.getConstructor(new Class[] { MvvmPlugin.class }).newInstance(new Object[] { this.mFE });
        AppMethodBeat.o(235271);
        return paramClass;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.kernel.mvvm.e
 * JD-Core Version:    0.7.0.1
 */