package com.tencent.mm.dynamicbackground.model;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.w;

@Metadata(bv={1, 0, 2}, d1={""}, d2={"Lcom/tencent/mm/dynamicbackground/model/DefaultDynamicBgServiceImpl;", "Lcom/tencent/mm/dynamicbackground/model/DynamicBgService;", "()V", "isEnable", "", "getDisplayRealSize", "Landroid/graphics/Point;", "context", "Landroid/content/Context;", "getSleepTimeInMsPerFrame", "", "isEnableNativeDynamicBackground", "isInitCrash", "loadDynamicBgLibrary", "", "markDrawEndPoint", "markDrawStartPoint", "markWillCrash", "needMarkDrawPoint", "onInitCrash", "onInitEnd", "onInitStart", "setEnableNativeDynamicBackground", "enable", "willCrash", "Companion", "dynamicbg_release"}, k=1, mv={1, 1, 11})
public final class a
  implements c
{
  public static final a.a mbl;
  private boolean egk = true;
  
  static
  {
    AppMethodBeat.i(103076);
    mbl = new a.a((byte)0);
    AppMethodBeat.o(103076);
  }
  
  public final boolean aTo()
  {
    return this.egk;
  }
  
  public final void aTp()
  {
    this.egk = false;
  }
  
  public final void aTq()
  {
    AppMethodBeat.i(103075);
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG("dynamicBg");
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/dynamicbackground/model/DefaultDynamicBgServiceImpl", "loadDynamicBgLibrary", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    System.loadLibrary((String)locala.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/dynamicbackground/model/DefaultDynamicBgServiceImpl", "loadDynamicBgLibrary", "()V", "java/lang/System_EXEC_", "loadLibrary", "(Ljava/lang/String;)V");
    AppMethodBeat.o(103075);
  }
  
  public final boolean aTr()
  {
    return false;
  }
  
  public final void aTs() {}
  
  public final void aTt() {}
  
  public final void aTu() {}
  
  public final boolean aTv()
  {
    return false;
  }
  
  public final boolean aTw()
  {
    return false;
  }
  
  public final void aTx() {}
  
  public final void aTy() {}
  
  public final float aTz()
  {
    return 16.0F;
  }
  
  public final Point bf(Context paramContext)
  {
    AppMethodBeat.i(103074);
    s.t(paramContext, "context");
    Point localPoint = new Point();
    paramContext = paramContext.getSystemService("window");
    if (paramContext == null)
    {
      paramContext = new w("null cannot be cast to non-null type android.view.WindowManager");
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
          localObject1 = new w("null cannot be cast to non-null type kotlin.Int");
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
        localObject2 = new w("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(103074);
        throw ((Throwable)localObject2);
      }
      localPoint.y = ((Integer)localObject2).intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.dynamicbackground.model.a
 * JD-Core Version:    0.7.0.1
 */