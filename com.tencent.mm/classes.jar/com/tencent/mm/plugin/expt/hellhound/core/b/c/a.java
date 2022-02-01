package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "", "()V", "mGestureExecListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1;", "mGestureListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1;", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onTouchEvent", "", "onTouchEventViewName", "", "callback", "", "methodName", "type", "resId", "idHex", "gestureMonitor", "listener", "Companion", "plugin-expt_release"})
public final class a
{
  private static boolean qSh;
  public static final a.a qSi;
  public c qSc;
  private int qSd;
  private String qSe;
  public final b qSf;
  public final c qSg;
  
  static
  {
    AppMethodBeat.i(210639);
    qSi = new a.a((byte)0);
    AppMethodBeat.o(210639);
  }
  
  public a()
  {
    AppMethodBeat.i(210638);
    this.qSd = -1;
    this.qSf = new b(this);
    this.qSg = new c(this);
    AppMethodBeat.o(210638);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.b
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject)
    {
      AppMethodBeat.i(210636);
      if (a.a(this.qSj) == 0) {
        if (!(paramObject instanceof Boolean)) {
          break label55;
        }
      }
      label55:
      for (paramString1 = (Boolean)paramObject; paramString1 != null; paramString1 = null)
      {
        paramString1.booleanValue();
        paramString2 = a.qSi;
        a.kX(paramString1.booleanValue());
        AppMethodBeat.o(210636);
        return;
      }
      AppMethodBeat.o(210636);
    }
    
    public final void c(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210635);
      paramObject = this.qSj;
      if (paramArrayOfObject != null) {}
      for (paramString4 = paramArrayOfObject[0]; paramString4 == null; paramString4 = null)
      {
        paramString1 = new v("null cannot be cast to non-null type android.view.MotionEvent");
        AppMethodBeat.o(210635);
        throw paramString1;
      }
      a.a(paramObject, ((MotionEvent)paramString4).getAction());
      if (a.a(this.qSj) == 0)
      {
        a.a(this.qSj, paramString1);
        if (paramString1 == null) {
          break label150;
        }
        paramString1 = Boolean.valueOf(n.a((CharSequence)paramString1, (CharSequence)"$OnTouchListener", false));
        paramString4 = a.qSi;
        if ((paramString1 == null) || (!paramString1.booleanValue()) || (!p.i(paramString2, "onTouch")) || (!p.i(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z"))) {
          break label155;
        }
      }
      label150:
      label155:
      for (boolean bool = true;; bool = false)
      {
        a.kX(bool);
        AppMethodBeat.o(210635);
        return;
        paramString1 = null;
        break;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210637);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label46;
        }
      }
      label46:
      for (int i = 1; (i != 0) || (!(paramObject instanceof View)); i = 0)
      {
        paramString1 = a.qSi;
        a.kX(false);
        AppMethodBeat.o(210637);
        return;
      }
      paramString1 = g.qSQ;
      paramString1 = g.a.dT((View)paramObject);
      if (paramString1 == null)
      {
        paramString1 = a.qSi;
        a.kX(false);
        AppMethodBeat.o(210637);
        return;
      }
      if (((View)paramObject).getId() == -1)
      {
        paramString1 = g.qSQ;
        paramString1 = g.a.dU((View)paramObject);
      }
      if (((View)paramObject).getId() == -1) {
        paramString3 = paramString1;
      }
      for (;;)
      {
        paramArrayOfObject = this.qSj;
        paramObject = ((View)paramObject).getClass().getName();
        p.g(paramObject, "caller.javaClass.name");
        a.a(paramArrayOfObject, paramString2, paramObject, paramString1, paramString3);
        AppMethodBeat.o(210637);
        return;
        paramString3 = com.tencent.mm.plugin.expt.hellhound.core.b.toHexString(((View)paramObject).getId());
        p.g(paramString3, "HellhoundUtil.toHexString(caller.id)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.a
 * JD-Core Version:    0.7.0.1
 */