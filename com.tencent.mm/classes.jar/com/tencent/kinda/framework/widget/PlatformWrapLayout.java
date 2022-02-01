package com.tencent.kinda.framework.widget;

import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.animate.KindaAnimatorViewProxy;
import com.tencent.kinda.framework.widget.base.MMKViewLayout;
import com.tencent.kinda.gen.KView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class PlatformWrapLayout
  extends MMKViewLayout
{
  public PlatformWrapLayout(YogaLayout paramYogaLayout)
  {
    AppMethodBeat.i(18724);
    setView(paramYogaLayout);
    AppMethodBeat.o(18724);
  }
  
  private Object unwrapProxyObj(Object paramObject)
  {
    AppMethodBeat.i(18726);
    if ((paramObject instanceof Proxy)) {
      try
      {
        InvocationHandler localInvocationHandler = Proxy.getInvocationHandler(paramObject);
        if ((localInvocationHandler instanceof KindaAnimatorViewProxy))
        {
          paramObject = ((KindaAnimatorViewProxy)localInvocationHandler).getTarget();
          AppMethodBeat.o(18726);
          return paramObject;
        }
      }
      catch (Exception paramObject)
      {
        AppMethodBeat.o(18726);
        return Integer.valueOf(0);
      }
    }
    AppMethodBeat.o(18726);
    return paramObject;
  }
  
  public void addView(KView paramKView)
  {
    AppMethodBeat.i(18725);
    Object localObject = unwrapProxyObj(paramKView);
    ac.i("MMKViewLayout", "PlatformWrapLayout addView: %s %s", new Object[] { paramKView, localObject });
    if (localObject != null) {
      paramKView = (KView)localObject;
    }
    for (;;)
    {
      super.addView(paramKView);
      AppMethodBeat.o(18725);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.PlatformWrapLayout
 * JD-Core Version:    0.7.0.1
 */