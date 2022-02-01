package com.tencent.mm.plugin.finder.live.model.context;

import androidx.lifecycle.af;
import androidx.lifecycle.ah;
import androidx.lifecycle.ah.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.ui.component.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveContext;", "tag", "", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "business", "T", "Landroidx/lifecycle/ViewModel;", "bu", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public static final a.a CMm;
  private static a CMn;
  private final String tag;
  
  static
  {
    AppMethodBeat.i(359746);
    CMm = new a.a((byte)0);
    CMn = new a("from LivingBuContext");
    AppMethodBeat.o(359746);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(359721);
    this.tag = paramString;
    AppMethodBeat.o(359721);
  }
  
  public final <T extends af> T business(Class<T> paramClass)
  {
    AppMethodBeat.i(359754);
    s.u(paramClass, "bu");
    paramClass = a.a.a((f)this).q(paramClass);
    s.s(paramClass, "of(this).get(bu)");
    AppMethodBeat.o(359754);
    return paramClass;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(359760);
    String str = this.tag + '_' + business(e.class);
    AppMethodBeat.o(359760);
    return str;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/model/context/LiveBuContext$Companion$of$1", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a$a
    extends ah.d
  {
    a$a(f paramf) {}
    
    public final <T extends af> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(359740);
      s.u(paramClass, "modelClass");
      if (c.class.isAssignableFrom(paramClass)) {
        try
        {
          af localaf = (af)paramClass.getConstructor(new Class[] { a.class }).newInstance(new Object[] { (a)this.CMo });
          AppMethodBeat.o(359740);
          return localaf;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)localNoSuchMethodException);
          AppMethodBeat.o(359740);
          throw paramClass;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)localIllegalAccessException);
          AppMethodBeat.o(359740);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)localInstantiationException);
          AppMethodBeat.o(359740);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = new RuntimeException(s.X("Cannot create an instance of ", paramClass), (Throwable)localInvocationTargetException);
          AppMethodBeat.o(359740);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(359740);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.context.a
 * JD-Core Version:    0.7.0.1
 */