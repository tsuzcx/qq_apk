package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "", "()V", "mArgsOnTouchRef", "Ljava/lang/ref/WeakReference;", "", "mClickDown", "", "mImageViewClickListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1;", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "mTouchPair", "Landroid/util/Pair;", "", "mViewOpListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1;", "callback", "", "view", "Landroid/view/View;", "className", "caller", "eventId", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewEventId;", "imageViewMonitor", "viewOpMonitor", "listener", "viewOpMonitor$plugin_expt_release", "Companion", "plugin-expt_release"})
public final class f
{
  public static final f.a sBd;
  private WeakReference<Object[]> sAY;
  private Pair<String, String> sAZ;
  public c sAr;
  public final c sBa;
  private boolean sBb;
  public final b sBc;
  
  static
  {
    AppMethodBeat.i(220781);
    sBd = new f.a((byte)0);
    AppMethodBeat.o(220781);
  }
  
  public f()
  {
    AppMethodBeat.i(220780);
    this.sBa = new c(this);
    this.sBc = new b(this);
    AppMethodBeat.o(220780);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(220777);
      if (!f.c(this.sBe))
      {
        AppMethodBeat.o(220777);
        return;
      }
      if ((paramObject1 == null) || (!(paramObject1 instanceof View)))
      {
        AppMethodBeat.o(220777);
        return;
      }
      if ((paramObject2 == null) || (!(paramObject2 instanceof Boolean)) || (!((Boolean)paramObject2).booleanValue()))
      {
        AppMethodBeat.o(220777);
        return;
      }
      f.a(this.sBe, false);
      f.a(this.sBe, (View)paramObject1, paramString1, paramObject1, d.sAE);
      AppMethodBeat.o(220777);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(220776);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label30;
        }
      }
      label30:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(220776);
        return;
      }
      if (!(paramArrayOfObject[0] instanceof MotionEvent))
      {
        AppMethodBeat.o(220776);
        return;
      }
      paramString1 = paramArrayOfObject[0];
      if (paramString1 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type android.view.MotionEvent");
        AppMethodBeat.o(220776);
        throw paramString1;
      }
      paramString1 = (MotionEvent)paramString1;
      paramString2 = this.sBe;
      if (paramString1.getAction() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        f.a(paramString2, bool);
        AppMethodBeat.o(220776);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(220779);
      if (((p.j(paramString2, "onTouch") ^ true)) || ((p.j(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z") ^ true)))
      {
        AppMethodBeat.o(220779);
        return;
      }
      paramString2 = f.a(this.sBe);
      if (paramString2 != null) {}
      for (paramString2 = (Object[])paramString2.get(); paramString2 == null; paramString2 = null)
      {
        AppMethodBeat.o(220779);
        return;
      }
      View localView;
      label240:
      boolean bool;
      if ((paramString2.length >= 2) && ((paramString2[1] instanceof MotionEvent)))
      {
        paramString3 = paramString2[1];
        if (paramString3 == null)
        {
          paramString1 = new t("null cannot be cast to non-null type android.view.MotionEvent");
          AppMethodBeat.o(220779);
          throw paramString1;
        }
        if (((MotionEvent)paramString3).getAction() != 1)
        {
          AppMethodBeat.o(220779);
          return;
        }
        if (!(paramString2[0] instanceof View))
        {
          AppMethodBeat.o(220779);
          return;
        }
        paramString3 = paramString2[0];
        paramString2 = paramString3;
        if (!(paramString3 instanceof View)) {
          paramString2 = null;
        }
        localView = (View)paramString2;
        if (localView == null)
        {
          AppMethodBeat.o(220779);
          return;
        }
        if ((paramObject2 != null) && ((paramObject2 instanceof Boolean)) && (((Boolean)paramObject2).booleanValue()))
        {
          paramObject2 = this.sBe;
          String str = localView.getClass().getName();
          if (paramObject1 != null)
          {
            paramString2 = paramObject1.getClass();
            if (paramString2 != null)
            {
              paramString3 = paramString2.getName();
              paramString2 = paramString3;
              if (paramString3 != null) {
                break label240;
              }
            }
          }
          paramString2 = paramString1;
          f.a(paramObject2, new Pair(str, paramString2));
          f.a(this.sBe, localView, paramString1, paramObject1, d.sAE);
          AppMethodBeat.o(220779);
          return;
        }
        bool = localView.hasOnClickListeners();
        if ((!(localView instanceof AdapterView)) || (((AdapterView)localView).getOnItemClickListener() == null)) {
          break label336;
        }
      }
      label336:
      for (int i = 1;; i = 0)
      {
        if ((!bool) && (i == 0)) {
          f.a(this.sBe, localView, paramString1, paramObject1, d.sAE);
        }
        AppMethodBeat.o(220779);
        return;
      }
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      Object localObject2 = null;
      AppMethodBeat.i(220778);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(220778);
        return;
      }
      if (!(paramArrayOfObject[0] instanceof View))
      {
        AppMethodBeat.o(220778);
        return;
      }
      Object localObject3 = paramArrayOfObject[0];
      Object localObject1 = localObject3;
      if (!(localObject3 instanceof View)) {
        localObject1 = null;
      }
      localObject3 = (View)localObject1;
      if (localObject3 == null)
      {
        AppMethodBeat.o(220778);
        return;
      }
      f.a(this.sBe, null);
      if ((p.j(paramString2, "onTouch")) && (p.j(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z")))
      {
        if ((paramArrayOfObject.length >= 2) && ((paramArrayOfObject[1] instanceof MotionEvent)))
        {
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.view.MotionEvent");
            AppMethodBeat.o(220778);
            throw paramString1;
          }
          if (((MotionEvent)paramString1).getAction() == 1)
          {
            f.a(this.sBe, new WeakReference(paramArrayOfObject));
            AppMethodBeat.o(220778);
          }
        }
      }
      else
      {
        if ((p.j(paramString2, "onClick")) && (p.j(paramString3, "(Landroid/view/View;)V")))
        {
          paramString2 = f.b(this.sBe);
          if (paramString2 != null)
          {
            paramString2 = (String)paramString2.first;
            paramString3 = f.b(this.sBe);
            if (paramString3 == null) {
              break label333;
            }
          }
          label333:
          for (paramString3 = (String)paramString3.second;; paramString3 = null)
          {
            if ((paramString2 == null) || (!p.j(paramString2, localObject3.getClass().getName())) || (paramString3 == null)) {
              break label338;
            }
            if (!p.j(paramString3, paramString1))
            {
              paramString2 = localObject2;
              if (paramObject != null)
              {
                paramArrayOfObject = paramObject.getClass();
                paramString2 = localObject2;
                if (paramArrayOfObject != null) {
                  paramString2 = paramArrayOfObject.getName();
                }
              }
              if (!p.j(paramString3, paramString2)) {
                break label338;
              }
            }
            AppMethodBeat.o(220778);
            return;
            paramString2 = null;
            break;
          }
          label338:
          f.a(this.sBe, (View)localObject3, paramString1, paramObject, d.sAF);
          AppMethodBeat.o(220778);
          return;
        }
        localObject1 = d.sAF;
        if ((p.j("onDrag", paramString2)) && (p.j("(Landroid/view/View;Landroid/view/DragEvent;)Z", paramString3))) {
          paramArrayOfObject = d.sAL;
        }
        for (;;)
        {
          paramString2 = a.sAx;
          if (!a.cOn()) {
            break;
          }
          Log.w("HABBYGE-MALI.ViewOpCallback", "gGestureFirst=TRUE");
          paramString1 = a.sAx;
          a.mb(false);
          AppMethodBeat.o(220778);
          return;
          if ((p.j("onLongClick", paramString2)) && (p.j("(Landroid/view/View;)Z", paramString3)))
          {
            paramArrayOfObject = d.sAG;
          }
          else if ((p.j("onKey", paramString2)) && (p.j("(Landroid/view/View;ILandroid/view/KeyEvent;)Z", paramString3)))
          {
            paramArrayOfObject = d.sAM;
          }
          else if ((p.j("onHover", paramString2)) && (p.j("(Landroid/view/View;Landroid/view/MotionEvent;)Z", paramString3)))
          {
            paramArrayOfObject = d.sAN;
          }
          else if ((p.j("onItemClick", paramString2)) && (p.j("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
          {
            paramArrayOfObject = d.sAI;
          }
          else if ((p.j("onItemLongClick", paramString2)) && (p.j("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
          {
            paramArrayOfObject = d.sAJ;
          }
          else if ((p.j("onItemSelected", paramString2)) && (p.j("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
          {
            paramArrayOfObject = d.sAK;
          }
          else
          {
            paramArrayOfObject = (Object[])localObject1;
            if (p.j("onTouchEvent", paramString2))
            {
              paramArrayOfObject = (Object[])localObject1;
              if (p.j("(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", paramString3)) {
                paramArrayOfObject = d.sAE;
              }
            }
          }
        }
        f.a(this.sBe, (View)localObject3, paramString1, paramObject, paramArrayOfObject);
      }
      AppMethodBeat.o(220778);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.f
 * JD-Core Version:    0.7.0.1
 */