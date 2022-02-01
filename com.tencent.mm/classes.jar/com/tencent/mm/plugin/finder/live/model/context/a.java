package com.tencent.mm.plugin.finder.live.model.context;

import androidx.lifecycle.ab;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.y.b;
import androidx.lifecycle.y.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveContext;", "tag", "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "toString", "Companion", "plugin-finder-base_release"})
public final class a
  extends b
{
  private static a ykq;
  public static final a ykr;
  private final String tag;
  
  static
  {
    AppMethodBeat.i(263238);
    ykr = new a((byte)0);
    ykq = new a("from LivingBuContext");
    AppMethodBeat.o(263238);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(263235);
    this.tag = paramString;
    AppMethodBeat.o(263235);
  }
  
  public final <T extends x> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(263231);
    p.k(paramClass, "bu");
    paramClass = a.a((c)this).i(paramClass);
    p.j(paramClass, "of(this).get(bu)");
    AppMethodBeat.o(263231);
    return paramClass;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(263233);
    String str = this.tag + '_' + (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
    AppMethodBeat.o(263233);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext$Companion;", "", "()V", "value", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "LivingBuContext", "getLivingBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "setLivingBuContext", "(Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;)V", "of", "Landroidx/lifecycle/ViewModelProvider;", "owner", "Lcom/tencent/mm/ui/component/IModel;", "plugin-finder-base_release"})
  public static final class a
  {
    public static y a(c paramc)
    {
      AppMethodBeat.i(259608);
      p.k(paramc, "owner");
      paramc = new y((ab)paramc, (y.b)new a(paramc));
      AppMethodBeat.o(259608);
      return paramc;
    }
    
    public static void j(a parama)
    {
      AppMethodBeat.i(259607);
      a.i(parama);
      p.j("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
      Log.i("LivingBuContext", "LivingBuContext set value " + parama + ' ' + "");
      AppMethodBeat.o(259607);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/model/context/LiveBuContext$Companion$of$1", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-finder-base_release"})
    public static final class a
      extends y.c
    {
      a(c paramc) {}
      
      public final <T extends x> T create(Class<T> paramClass)
      {
        AppMethodBeat.i(262409);
        p.k(paramClass, "modelClass");
        if (com.tencent.mm.plugin.finder.live.viewmodel.data.business.a.class.isAssignableFrom(paramClass)) {
          try
          {
            Object localObject = paramClass.getConstructor(new Class[] { a.class });
            localc = this.yks;
            if (localc == null)
            {
              localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.context.LiveBuContext");
              AppMethodBeat.o(262409);
              throw ((Throwable)localObject);
            }
          }
          catch (NoSuchMethodException localNoSuchMethodException)
          {
            c localc;
            paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localNoSuchMethodException);
            AppMethodBeat.o(262409);
            throw paramClass;
            x localx = (x)localNoSuchMethodException.newInstance(new Object[] { (a)localc });
            AppMethodBeat.o(262409);
            return localx;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localIllegalAccessException);
            AppMethodBeat.o(262409);
            throw paramClass;
          }
          catch (InstantiationException localInstantiationException)
          {
            paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInstantiationException);
            AppMethodBeat.o(262409);
            throw paramClass;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            paramClass = (Throwable)new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), (Throwable)localInvocationTargetException);
            AppMethodBeat.o(262409);
            throw paramClass;
          }
        }
        paramClass = super.create(paramClass);
        AppMethodBeat.o(262409);
        return paramClass;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.context.a
 * JD-Core Version:    0.7.0.1
 */