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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "", "()V", "mArgsOnTouchRef", "Ljava/lang/ref/WeakReference;", "", "mClickDown", "", "mImageViewClickListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1;", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "mTouchPair", "Landroid/util/Pair;", "", "mViewOpListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1;", "callback", "", "view", "Landroid/view/View;", "className", "caller", "eventId", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewEventId;", "imageViewMonitor", "viewOpMonitor", "listener", "viewOpMonitor$plugin_expt_release", "Companion", "plugin-expt_release"})
public final class f
{
  public static final f.a wgX;
  private WeakReference<Object[]> wgS;
  private Pair<String, String> wgT;
  public final c wgU;
  private boolean wgV;
  public final b wgW;
  public c wgl;
  
  static
  {
    AppMethodBeat.i(255811);
    wgX = new f.a((byte)0);
    AppMethodBeat.o(255811);
  }
  
  public f()
  {
    AppMethodBeat.i(255810);
    this.wgU = new c(this);
    this.wgW = new b(this);
    AppMethodBeat.o(255810);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(252340);
      if (!f.c(this.wgY))
      {
        AppMethodBeat.o(252340);
        return;
      }
      if ((paramObject1 == null) || (!(paramObject1 instanceof View)))
      {
        AppMethodBeat.o(252340);
        return;
      }
      if ((paramObject2 == null) || (!(paramObject2 instanceof Boolean)) || (!((Boolean)paramObject2).booleanValue()))
      {
        AppMethodBeat.o(252340);
        return;
      }
      f.a(this.wgY, false);
      f.a(this.wgY, (View)paramObject1, paramString1, paramObject1, d.wgy);
      AppMethodBeat.o(252340);
    }
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(252339);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label30;
        }
      }
      label30:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(252339);
        return;
      }
      if (!(paramArrayOfObject[0] instanceof MotionEvent))
      {
        AppMethodBeat.o(252339);
        return;
      }
      paramString1 = paramArrayOfObject[0];
      if (paramString1 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type android.view.MotionEvent");
        AppMethodBeat.o(252339);
        throw paramString1;
      }
      paramString1 = (MotionEvent)paramString1;
      paramString2 = this.wgY;
      if (paramString1.getAction() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        f.a(paramString2, bool);
        AppMethodBeat.o(252339);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements com.tencent.mm.hellhoundlib.a.d
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(251711);
      if (((p.h(paramString2, "onTouch") ^ true)) || ((p.h(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z") ^ true)))
      {
        AppMethodBeat.o(251711);
        return;
      }
      paramString2 = f.a(this.wgY);
      if (paramString2 != null) {}
      for (paramString2 = (Object[])paramString2.get(); paramString2 == null; paramString2 = null)
      {
        AppMethodBeat.o(251711);
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
          AppMethodBeat.o(251711);
          throw paramString1;
        }
        if (((MotionEvent)paramString3).getAction() != 1)
        {
          AppMethodBeat.o(251711);
          return;
        }
        if (!(paramString2[0] instanceof View))
        {
          AppMethodBeat.o(251711);
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
          AppMethodBeat.o(251711);
          return;
        }
        if ((paramObject2 != null) && ((paramObject2 instanceof Boolean)) && (((Boolean)paramObject2).booleanValue()))
        {
          paramObject2 = this.wgY;
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
          f.a(this.wgY, localView, paramString1, paramObject1, d.wgy);
          AppMethodBeat.o(251711);
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
          f.a(this.wgY, localView, paramString1, paramObject1, d.wgy);
        }
        AppMethodBeat.o(251711);
        return;
      }
    }
    
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      Object localObject2 = null;
      AppMethodBeat.i(251708);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(251708);
        return;
      }
      if (!(paramArrayOfObject[0] instanceof View))
      {
        AppMethodBeat.o(251708);
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
        AppMethodBeat.o(251708);
        return;
      }
      f.a(this.wgY, null);
      if ((p.h(paramString2, "onTouch")) && (p.h(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z")))
      {
        if ((paramArrayOfObject.length >= 2) && ((paramArrayOfObject[1] instanceof MotionEvent)))
        {
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new t("null cannot be cast to non-null type android.view.MotionEvent");
            AppMethodBeat.o(251708);
            throw paramString1;
          }
          if (((MotionEvent)paramString1).getAction() == 1)
          {
            f.a(this.wgY, new WeakReference(paramArrayOfObject));
            AppMethodBeat.o(251708);
          }
        }
      }
      else
      {
        if ((p.h(paramString2, "onClick")) && (p.h(paramString3, "(Landroid/view/View;)V")))
        {
          paramString2 = f.b(this.wgY);
          if (paramString2 != null)
          {
            paramString2 = (String)paramString2.first;
            paramString3 = f.b(this.wgY);
            if (paramString3 == null) {
              break label333;
            }
          }
          label333:
          for (paramString3 = (String)paramString3.second;; paramString3 = null)
          {
            if ((paramString2 == null) || (!p.h(paramString2, localObject3.getClass().getName())) || (paramString3 == null)) {
              break label338;
            }
            if (!p.h(paramString3, paramString1))
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
              if (!p.h(paramString3, paramString2)) {
                break label338;
              }
            }
            AppMethodBeat.o(251708);
            return;
            paramString2 = null;
            break;
          }
          label338:
          f.a(this.wgY, (View)localObject3, paramString1, paramObject, d.wgz);
          AppMethodBeat.o(251708);
          return;
        }
        localObject1 = d.wgz;
        if ((p.h("onDrag", paramString2)) && (p.h("(Landroid/view/View;Landroid/view/DragEvent;)Z", paramString3))) {
          paramArrayOfObject = d.wgF;
        }
        for (;;)
        {
          paramString2 = a.wgr;
          if (!a.ddf()) {
            break;
          }
          Log.w("HABBYGE-MALI.ViewOpCallback", "gGestureFirst=TRUE");
          paramString1 = a.wgr;
          a.nn(false);
          AppMethodBeat.o(251708);
          return;
          if ((p.h("onLongClick", paramString2)) && (p.h("(Landroid/view/View;)Z", paramString3)))
          {
            paramArrayOfObject = d.wgA;
          }
          else if ((p.h("onKey", paramString2)) && (p.h("(Landroid/view/View;ILandroid/view/KeyEvent;)Z", paramString3)))
          {
            paramArrayOfObject = d.wgG;
          }
          else if ((p.h("onHover", paramString2)) && (p.h("(Landroid/view/View;Landroid/view/MotionEvent;)Z", paramString3)))
          {
            paramArrayOfObject = d.wgH;
          }
          else if ((p.h("onItemClick", paramString2)) && (p.h("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
          {
            paramArrayOfObject = d.wgC;
          }
          else if ((p.h("onItemLongClick", paramString2)) && (p.h("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
          {
            paramArrayOfObject = d.wgD;
          }
          else if ((p.h("onItemSelected", paramString2)) && (p.h("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
          {
            paramArrayOfObject = d.wgE;
          }
          else
          {
            paramArrayOfObject = (Object[])localObject1;
            if (p.h("onTouchEvent", paramString2))
            {
              paramArrayOfObject = (Object[])localObject1;
              if (p.h("(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", paramString3)) {
                paramArrayOfObject = d.wgy;
              }
            }
          }
        }
        f.a(this.wgY, (View)localObject3, paramString1, paramObject, paramArrayOfObject);
      }
      AppMethodBeat.o(251708);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.f
 * JD-Core Version:    0.7.0.1
 */