package com.tencent.mm.dynamicbackground.model;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.reflect.Method;

@l(gjZ={1, 1, 11}, gka={""}, gkb={"Lcom/tencent/mm/dynamicbackground/model/DefaultDynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "isEnable", "", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "dynamicbg_release"})
public final class a
  implements c
{
  public static final a.a ghN;
  private boolean cNF = true;
  
  static
  {
    AppMethodBeat.i(103076);
    ghN = new a.a((byte)0);
    AppMethodBeat.o(103076);
  }
  
  public final boolean adU()
  {
    return this.cNF;
  }
  
  public final void adV()
  {
    this.cNF = false;
  }
  
  public final void adW()
  {
    AppMethodBeat.i(103075);
    System.loadLibrary("dynamicBg");
    AppMethodBeat.o(103075);
  }
  
  public final boolean adX()
  {
    return false;
  }
  
  public final void adY() {}
  
  public final void adZ() {}
  
  public final void aea() {}
  
  public final boolean aeb()
  {
    return false;
  }
  
  public final boolean aec()
  {
    return false;
  }
  
  public final void aed() {}
  
  public final void aee() {}
  
  public final float aef()
  {
    return 16.0F;
  }
  
  public final Point ck(Context paramContext)
  {
    AppMethodBeat.i(103074);
    p.h(paramContext, "context");
    Point localPoint = new Point();
    paramContext = paramContext.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(103074);
      throw paramContext;
    }
    paramContext = ((WindowManager)paramContext).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17) {
      paramContext.getRealSize(localPoint);
    }
    for (;;)
    {
      AppMethodBeat.o(103074);
      return localPoint;
      Object localObject3;
      if (Build.VERSION.SDK_INT >= 14)
      {
        try
        {
          Object localObject1 = Display.class.getMethod("getRawHeight", new Class[0]);
          localObject3 = Display.class.getMethod("getRawWidth", new Class[0]).invoke(paramContext, new Object[0]);
          if (localObject3 != null) {
            break label149;
          }
          localObject1 = new v("null cannot be cast to non-null type kotlin.Int");
          AppMethodBeat.o(103074);
          throw ((Throwable)localObject1);
        }
        catch (Exception localException) {}
      }
      else
      {
        paramContext.getSize(localPoint);
        continue;
      }
      label149:
      localPoint.x = ((Integer)localObject3).intValue();
      Object localObject2 = localException.invoke(paramContext, new Object[0]);
      if (localObject2 == null)
      {
        localObject2 = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(103074);
        throw ((Throwable)localObject2);
      }
      localPoint.y = ((Integer)localObject2).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.a
 * JD-Core Version:    0.7.0.1
 */