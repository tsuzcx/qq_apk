package com.tencent.mm.plugin.appbrand.page.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Priority", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface e<T extends AppBrandRuntime>
{
  public abstract boolean a(T paramT, String paramString, Runnable paramRunnable);
  
  public abstract a cGt();
  
  public abstract i cGu();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "", "priority", "", "(I)V", "getPriority", "()I", "PriorityInterceptSilent", "PriorityInterceptWithConfirm", "PriorityLow", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority$PriorityLow;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority$PriorityInterceptWithConfirm;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority$PriorityInterceptSilent;", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract class a
  {
    public final int priority;
    
    private a(int paramInt)
    {
      this.priority = paramInt;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority$PriorityInterceptSilent;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "()V", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends e.a
    {
      public static final a tCR;
      
      static
      {
        AppMethodBeat.i(325078);
        tCR = new a();
        AppMethodBeat.o(325078);
      }
      
      private a()
      {
        super((byte)0);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority$PriorityInterceptWithConfirm;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "()V", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      extends e.a
    {
      public static final b tCS;
      
      static
      {
        AppMethodBeat.i(325084);
        tCS = new b();
        AppMethodBeat.o(325084);
      }
      
      private b()
      {
        super((byte)0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.b.e
 * JD-Core Version:    0.7.0.1
 */