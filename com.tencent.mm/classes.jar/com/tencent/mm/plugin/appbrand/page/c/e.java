package com.tencent.mm.plugin.appbrand.page.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor;", "T", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "", "getTypePageNavigateBackInterceptor", "Lcom/tencent/mm/plugin/appbrand/page/navigation/TypePageNavigateBackInterceptor;", "intercept", "", "runtime", "scene", "", "continueNavigateBack", "Ljava/lang/Runnable;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/Runnable;)Z", "priority", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "Priority", "luggage-wxa-app_release"})
public abstract interface e<T extends AppBrandRuntime>
{
  public abstract boolean a(T paramT, String paramString, Runnable paramRunnable);
  
  public abstract a bvE();
  
  public abstract h bvF();
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "", "priority", "", "(I)V", "getPriority", "()I", "PriorityInterceptSilent", "PriorityInterceptWithConfirm", "PriorityLow", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority$PriorityLow;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority$PriorityInterceptWithConfirm;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority$PriorityInterceptSilent;", "luggage-wxa-app_release"})
  public static abstract class a
  {
    public final int priority;
    
    private a(int paramInt)
    {
      this.priority = paramInt;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority$PriorityInterceptSilent;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "()V", "luggage-wxa-app_release"})
    public static final class a
      extends e.a
    {
      public static final a mgs;
      
      static
      {
        AppMethodBeat.i(197516);
        mgs = new a();
        AppMethodBeat.o(197516);
      }
      
      private a()
      {
        super((byte)0);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority$PriorityInterceptWithConfirm;", "Lcom/tencent/mm/plugin/appbrand/page/navigation/IAppBrandPageNavigateBackInterceptor$Priority;", "()V", "luggage-wxa-app_release"})
    public static final class b
      extends e.a
    {
      public static final b mgt;
      
      static
      {
        AppMethodBeat.i(197517);
        mgt = new b();
        AppMethodBeat.o(197517);
      }
      
      private b()
      {
        super((byte)0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.e
 * JD-Core Version:    0.7.0.1
 */