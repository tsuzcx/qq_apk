package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback;", "", "()V", "mGestureExecListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1;", "mGestureListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1;", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "onTouchEvent", "", "onTouchEventViewName", "", "callback", "", "methodName", "type", "resId", "idHex", "gestureMonitor", "listener", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a zCn;
  private static boolean zCt;
  public c zCo;
  private int zCp;
  private String zCq;
  public final b zCr;
  public final c zCs;
  
  static
  {
    AppMethodBeat.i(300103);
    zCn = new a.a((byte)0);
    AppMethodBeat.o(300103);
  }
  
  public a()
  {
    AppMethodBeat.i(300070);
    this.zCp = -1;
    this.zCr = new b(this);
    this.zCs = new c(this);
    AppMethodBeat.o(300070);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureExecListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodExecListener;", "runOnEnter", "", "innerClassName", "", "innerMethodName", "innerMethodDesc", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.b
  {
    b(a parama) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(300059);
      if (a.a(this.zCu) == 0)
      {
        if ((paramObject2 instanceof Boolean)) {}
        for (paramString1 = (Boolean)paramObject2; paramString1 == null; paramString1 = null)
        {
          AppMethodBeat.o(300059);
          return;
        }
        paramString1.booleanValue();
        paramString2 = a.zCn;
        a.oN(paramString1.booleanValue());
      }
      AppMethodBeat.o(300059);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300054);
      paramObject = this.zCu;
      if (paramArrayOfObject == null) {}
      for (paramString4 = null; paramString4 == null; paramString4 = paramArrayOfObject[0])
      {
        paramString1 = new NullPointerException("null cannot be cast to non-null type android.view.MotionEvent");
        AppMethodBeat.o(300054);
        throw paramString1;
      }
      a.a(paramObject, ((MotionEvent)paramString4).getAction());
      if (a.a(this.zCu) == 0)
      {
        a.a(this.zCu, paramString1);
        if (paramString1 != null) {
          break label135;
        }
        paramString1 = null;
        paramString4 = a.zCn;
        if ((paramString1 == null) || (!paramString1.booleanValue()) || (!s.p(paramString2, "onTouch")) || (!s.p(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z"))) {
          break label154;
        }
      }
      label135:
      label154:
      for (boolean bool = true;; bool = false)
      {
        a.oN(bool);
        AppMethodBeat.o(300054);
        return;
        paramString1 = Boolean.valueOf(n.i((CharSequence)paramString1, (CharSequence)"$OnTouchListener"));
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/GestureCallback$mGestureListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements d
  {
    c(a parama) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300068);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label46;
        }
      }
      label46:
      for (int i = 1; (i != 0) || (!(paramObject instanceof View)); i = 0)
      {
        paramString1 = a.zCn;
        a.oN(false);
        AppMethodBeat.o(300068);
        return;
      }
      paramString1 = g.zDb;
      paramString1 = g.a.fd((View)paramObject);
      if (paramString1 == null)
      {
        paramString1 = a.zCn;
        a.oN(false);
        AppMethodBeat.o(300068);
        return;
      }
      if (((View)paramObject).getId() == -1)
      {
        paramString1 = g.zDb;
        paramString1 = g.a.fe((View)paramObject);
      }
      if (((View)paramObject).getId() == -1) {
        paramString3 = paramString1;
      }
      for (;;)
      {
        paramArrayOfObject = this.zCu;
        paramObject = paramObject.getClass().getName();
        s.s(paramObject, "caller.javaClass.name");
        a.a(paramArrayOfObject, paramString2, paramObject, paramString1, paramString3);
        AppMethodBeat.o(300068);
        return;
        paramString3 = com.tencent.mm.plugin.expt.hellhound.core.b.Lx(((View)paramObject).getId());
        s.s(paramString3, "toHexString(caller.id)");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.a
 * JD-Core Version:    0.7.0.1
 */