package androidx.startup;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.Class<+Landroidx.startup.b<*>;>;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a
{
  private static volatile a ccG;
  private static final Object sLock;
  final Map<Class<?>, Object> ccH;
  final Set<Class<? extends b<?>>> ccI;
  final Context mContext;
  
  static
  {
    AppMethodBeat.i(192381);
    sLock = new Object();
    AppMethodBeat.o(192381);
  }
  
  private a(Context paramContext)
  {
    AppMethodBeat.i(192369);
    this.mContext = paramContext.getApplicationContext();
    this.ccI = new HashSet();
    this.ccH = new HashMap();
    AppMethodBeat.o(192369);
  }
  
  public static a au(Context paramContext)
  {
    AppMethodBeat.i(192375);
    if (ccG == null) {}
    synchronized (sLock)
    {
      if (ccG == null) {
        ccG = new a(paramContext);
      }
      paramContext = ccG;
      AppMethodBeat.o(192375);
      return paramContext;
    }
  }
  
  final <T> T a(Class<? extends b<?>> paramClass, Set<Class<?>> paramSet)
  {
    AppMethodBeat.i(192390);
    synchronized (sLock)
    {
      boolean bool = androidx.k.a.isEnabled();
      if (bool) {}
      try
      {
        androidx.k.a.ax(paramClass.getSimpleName());
        if (paramSet.contains(paramClass))
        {
          paramClass = new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[] { paramClass.getName() }));
          AppMethodBeat.o(192390);
          throw paramClass;
        }
      }
      finally
      {
        androidx.k.a.DS();
        AppMethodBeat.o(192390);
      }
    }
    Object localObject1;
    if (!this.ccH.containsKey(paramClass))
    {
      paramSet.add(paramClass);
      try
      {
        localObject1 = (b)paramClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        Object localObject3 = ((b)localObject1).IM();
        if (!((List)localObject3).isEmpty())
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            Class localClass = (Class)((Iterator)localObject3).next();
            if (!this.ccH.containsKey(localClass)) {
              a(localClass, paramSet);
            }
          }
        }
        localObject1 = ((b)localObject1).aq(this.mContext);
      }
      finally
      {
        paramClass = new d(paramClass);
        AppMethodBeat.o(192390);
      }
      paramSet.remove(paramClass);
      this.ccH.put(paramClass, localObject1);
    }
    for (paramClass = (Class<? extends b<?>>)localObject1;; paramClass = this.ccH.get(paramClass))
    {
      androidx.k.a.DS();
      AppMethodBeat.o(192390);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.startup.a
 * JD-Core Version:    0.7.0.1
 */