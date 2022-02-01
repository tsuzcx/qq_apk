package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "", "()V", "mGestureExecListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1;", "mGestureListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1;", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onTouchEvent", "", "onTouchEventViewName", "", "callback", "", "methodName", "type", "resId", "idHex", "gestureMonitor", "listener", "Companion", "plugin-expt_release"})
public final class a
{
  private static boolean sAw;
  public static final a.a sAx;
  public c sAr;
  private int sAs;
  private String sAt;
  public final b sAu;
  public final c sAv;
  
  static
  {
    AppMethodBeat.i(220754);
    sAx = new a.a((byte)0);
    AppMethodBeat.o(220754);
  }
  
  public a()
  {
    AppMethodBeat.i(220753);
    this.sAs = -1;
    this.sAu = new b(this);
    this.sAv = new c(this);
    AppMethodBeat.o(220753);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.b
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject)
    {
      AppMethodBeat.i(220751);
      if (a.a(this.sAy) == 0) {
        if (!(paramObject instanceof Boolean)) {
          break label55;
        }
      }
      label55:
      for (paramString1 = (Boolean)paramObject; paramString1 != null; paramString1 = null)
      {
        paramString1.booleanValue();
        paramString2 = a.sAx;
        a.mb(paramString1.booleanValue());
        AppMethodBeat.o(220751);
        return;
      }
      AppMethodBeat.o(220751);
    }
    
    public final void c(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220750);
      paramObject = this.sAy;
      if (paramArrayOfObject != null) {}
      for (paramString4 = paramArrayOfObject[0]; paramString4 == null; paramString4 = null)
      {
        paramString1 = new t("null cannot be cast to non-null type android.view.MotionEvent");
        AppMethodBeat.o(220750);
        throw paramString1;
      }
      a.a(paramObject, ((MotionEvent)paramString4).getAction());
      if (a.a(this.sAy) == 0)
      {
        a.a(this.sAy, paramString1);
        if (paramString1 == null) {
          break label150;
        }
        paramString1 = Boolean.valueOf(n.a((CharSequence)paramString1, (CharSequence)"$OnTouchListener", false));
        paramString4 = a.sAx;
        if ((paramString1 == null) || (!paramString1.booleanValue()) || (!p.j(paramString2, "onTouch")) || (!p.j(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z"))) {
          break label155;
        }
      }
      label150:
      label155:
      for (boolean bool = true;; bool = false)
      {
        a.mb(bool);
        AppMethodBeat.o(220750);
        return;
        paramString1 = null;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220752);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label46;
        }
      }
      label46:
      for (int i = 1; (i != 0) || (!(paramObject instanceof View)); i = 0)
      {
        paramString1 = a.sAx;
        a.mb(false);
        AppMethodBeat.o(220752);
        return;
      }
      paramString1 = g.sBf;
      paramString1 = g.a.dL((View)paramObject);
      if (paramString1 == null)
      {
        paramString1 = a.sAx;
        a.mb(false);
        AppMethodBeat.o(220752);
        return;
      }
      if (((View)paramObject).getId() == -1)
      {
        paramString1 = g.sBf;
        paramString1 = g.a.dM((View)paramObject);
      }
      if (((View)paramObject).getId() == -1) {
        paramString3 = paramString1;
      }
      for (;;)
      {
        paramArrayOfObject = this.sAy;
        paramObject = ((View)paramObject).getClass().getName();
        p.g(paramObject, "caller.javaClass.name");
        a.a(paramArrayOfObject, paramString2, paramObject, paramString1, paramString3);
        AppMethodBeat.o(220752);
        return;
        paramString3 = com.tencent.mm.plugin.expt.hellhound.core.b.toHexString(((View)paramObject).getId());
        p.g(paramString3, "HellhoundUtil.toHexString(caller.id)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.a
 * JD-Core Version:    0.7.0.1
 */