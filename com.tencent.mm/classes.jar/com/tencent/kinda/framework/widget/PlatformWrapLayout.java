package com.tencent.kinda.framework.widget;

import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.animate.KindaAnimatorViewProxy;
import com.tencent.kinda.framework.widget.base.MMKViewLayout;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class PlatformWrapLayout
  extends MMKViewLayout
{
  public PlatformWrapLayout(YogaLayout paramYogaLayout)
  {
    AppMethodBeat.i(144612);
    setView(paramYogaLayout);
    AppMethodBeat.o(144612);
  }
  
  private Object unwrapProxyObj(Object paramObject)
  {
    AppMethodBeat.i(144614);
    if ((paramObject instanceof Proxy)) {
      try
      {
        InvocationHandler localInvocationHandler = Proxy.getInvocationHandler(paramObject);
        if ((localInvocationHandler instanceof KindaAnimatorViewProxy))
        {
          paramObject = ((KindaAnimatorViewProxy)localInvocationHandler).getTarget();
          AppMethodBeat.o(144614);
          return paramObject;
        }
      }
      catch (Exception paramObject)
      {
        AppMethodBeat.o(144614);
        return Integer.valueOf(0);
      }
    }
    AppMethodBeat.o(144614);
    return paramObject;
  }
  
  public void addView(KView paramKView)
  {
    AppMethodBeat.i(144613);
    Object localObject = unwrapProxyObj(paramKView);
    ab.i("MMKViewLayout", "PlatformWrapLayout addView: %s %s", new Object[] { paramKView, localObject });
    if (localObject != null) {
      paramKView = (KView)localObject;
    }
    for (;;)
    {
      super.addView(paramKView);
      AppMethodBeat.o(144613);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.PlatformWrapLayout
 * JD-Core Version:    0.7.0.1
 */