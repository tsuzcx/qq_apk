package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "", "()V", "mGestureExecListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1;", "mGestureListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1;", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onTouchEvent", "", "onTouchEventViewName", "", "callback", "", "methodName", "type", "resId", "idHex", "gestureMonitor", "listener", "Companion", "plugin-expt_release"})
public final class a
{
  private static boolean wgq;
  public static final a.a wgr;
  public c wgl;
  private int wgm;
  private String wgn;
  public final b wgo;
  public final c wgp;
  
  static
  {
    AppMethodBeat.i(254081);
    wgr = new a.a((byte)0);
    AppMethodBeat.o(254081);
  }
  
  public a()
  {
    AppMethodBeat.i(254078);
    this.wgm = -1;
    this.wgo = new b(this);
    this.wgp = new c(this);
    AppMethodBeat.o(254078);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.b
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject)
    {
      AppMethodBeat.i(252158);
      if (a.a(this.wgs) == 0) {
        if (!(paramObject instanceof Boolean)) {
          break label55;
        }
      }
      label55:
      for (paramString1 = (Boolean)paramObject; paramString1 != null; paramString1 = null)
      {
        paramString1.booleanValue();
        paramString2 = a.wgr;
        a.nn(paramString1.booleanValue());
        AppMethodBeat.o(252158);
        return;
      }
      AppMethodBeat.o(252158);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(252156);
      paramObject = this.wgs;
      if (paramArrayOfObject != null) {}
      for (paramString4 = paramArrayOfObject[0]; paramString4 == null; paramString4 = null)
      {
        paramString1 = new t("null cannot be cast to non-null type android.view.MotionEvent");
        AppMethodBeat.o(252156);
        throw paramString1;
      }
      a.a(paramObject, ((MotionEvent)paramString4).getAction());
      if (a.a(this.wgs) == 0)
      {
        a.a(this.wgs, paramString1);
        if (paramString1 == null) {
          break label150;
        }
        paramString1 = Boolean.valueOf(n.a((CharSequence)paramString1, (CharSequence)"$OnTouchListener", false));
        paramString4 = a.wgr;
        if ((paramString1 == null) || (!paramString1.booleanValue()) || (!p.h(paramString2, "onTouch")) || (!p.h(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z"))) {
          break label155;
        }
      }
      label150:
      label155:
      for (boolean bool = true;; bool = false)
      {
        a.nn(bool);
        AppMethodBeat.o(252156);
        return;
        paramString1 = null;
        break;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(256497);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label46;
        }
      }
      label46:
      for (int i = 1; (i != 0) || (!(paramObject instanceof View)); i = 0)
      {
        paramString1 = a.wgr;
        a.nn(false);
        AppMethodBeat.o(256497);
        return;
      }
      paramString1 = g.wgZ;
      paramString1 = g.a.ej((View)paramObject);
      if (paramString1 == null)
      {
        paramString1 = a.wgr;
        a.nn(false);
        AppMethodBeat.o(256497);
        return;
      }
      if (((View)paramObject).getId() == -1)
      {
        paramString1 = g.wgZ;
        paramString1 = g.a.ek((View)paramObject);
      }
      if (((View)paramObject).getId() == -1) {
        paramString3 = paramString1;
      }
      for (;;)
      {
        paramArrayOfObject = this.wgs;
        paramObject = ((View)paramObject).getClass().getName();
        p.j(paramObject, "caller.javaClass.name");
        a.a(paramArrayOfObject, paramString2, paramObject, paramString1, paramString3);
        AppMethodBeat.o(256497);
        return;
        paramString3 = com.tencent.mm.plugin.expt.hellhound.core.b.Kx(((View)paramObject).getId());
        p.j(paramString3, "HellhoundUtil.toHexString(caller.id)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.a
 * JD-Core Version:    0.7.0.1
 */