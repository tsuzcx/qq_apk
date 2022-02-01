package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "", "()V", "mArgsOnTouchRef", "Ljava/lang/ref/WeakReference;", "", "mClickDown", "", "mImageViewClickListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1;", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "mTouchPair", "Landroid/util/Pair;", "", "mViewOpListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1;", "callback", "", "view", "Landroid/view/View;", "className", "caller", "eventId", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewEventId;", "imageViewMonitor", "viewOpMonitor", "listener", "viewOpMonitor$plugin_expt_release", "Companion", "plugin-expt_release"})
public final class f
{
  public static final f.a qSO;
  private WeakReference<Object[]> qSJ;
  private Pair<String, String> qSK;
  public final c qSL;
  private boolean qSM;
  public final b qSN;
  public c qSc;
  
  static
  {
    AppMethodBeat.i(210666);
    qSO = new f.a((byte)0);
    AppMethodBeat.o(210666);
  }
  
  public f()
  {
    AppMethodBeat.i(210665);
    this.qSL = new c(this);
    this.qSN = new b(this);
    AppMethodBeat.o(210665);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(210662);
      if (!f.c(this.qSP))
      {
        AppMethodBeat.o(210662);
        return;
      }
      if ((paramObject1 == null) || (!(paramObject1 instanceof View)))
      {
        AppMethodBeat.o(210662);
        return;
      }
      if ((paramObject2 == null) || (!(paramObject2 instanceof Boolean)) || (!((Boolean)paramObject2).booleanValue()))
      {
        AppMethodBeat.o(210662);
        return;
      }
      f.a(this.qSP, false);
      f.a(this.qSP, (View)paramObject1, paramString1, paramObject1, d.qSp);
      AppMethodBeat.o(210662);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210661);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label30;
        }
      }
      label30:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(210661);
        return;
      }
      if (!(paramArrayOfObject[0] instanceof MotionEvent))
      {
        AppMethodBeat.o(210661);
        return;
      }
      paramString1 = paramArrayOfObject[0];
      if (paramString1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type android.view.MotionEvent");
        AppMethodBeat.o(210661);
        throw paramString1;
      }
      paramString1 = (MotionEvent)paramString1;
      paramString2 = this.qSP;
      if (paramString1.getAction() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        f.a(paramString2, bool);
        AppMethodBeat.o(210661);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class c
    implements com.tencent.mm.hellhoundlib.a.c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(210664);
      if (((p.i(paramString2, "onTouch") ^ true)) || ((p.i(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z") ^ true)))
      {
        AppMethodBeat.o(210664);
        return;
      }
      paramString2 = f.a(this.qSP);
      if (paramString2 != null) {}
      for (paramString2 = (Object[])paramString2.get(); paramString2 == null; paramString2 = null)
      {
        AppMethodBeat.o(210664);
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
          paramString1 = new v("null cannot be cast to non-null type android.view.MotionEvent");
          AppMethodBeat.o(210664);
          throw paramString1;
        }
        if (((MotionEvent)paramString3).getAction() != 1)
        {
          AppMethodBeat.o(210664);
          return;
        }
        if (!(paramString2[0] instanceof View))
        {
          AppMethodBeat.o(210664);
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
          AppMethodBeat.o(210664);
          return;
        }
        if ((paramObject2 != null) && ((paramObject2 instanceof Boolean)) && (((Boolean)paramObject2).booleanValue()))
        {
          paramObject2 = this.qSP;
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
          f.a(this.qSP, localView, paramString1, paramObject1, d.qSp);
          AppMethodBeat.o(210664);
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
          f.a(this.qSP, localView, paramString1, paramObject1, d.qSp);
        }
        AppMethodBeat.o(210664);
        return;
      }
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      Object localObject2 = null;
      AppMethodBeat.i(210663);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(210663);
        return;
      }
      if (!(paramArrayOfObject[0] instanceof View))
      {
        AppMethodBeat.o(210663);
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
        AppMethodBeat.o(210663);
        return;
      }
      f.a(this.qSP, null);
      if ((p.i(paramString2, "onTouch")) && (p.i(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z")))
      {
        if ((paramArrayOfObject.length >= 2) && ((paramArrayOfObject[1] instanceof MotionEvent)))
        {
          paramString1 = paramArrayOfObject[1];
          if (paramString1 == null)
          {
            paramString1 = new v("null cannot be cast to non-null type android.view.MotionEvent");
            AppMethodBeat.o(210663);
            throw paramString1;
          }
          if (((MotionEvent)paramString1).getAction() == 1)
          {
            f.a(this.qSP, new WeakReference(paramArrayOfObject));
            AppMethodBeat.o(210663);
          }
        }
      }
      else
      {
        if ((p.i(paramString2, "onClick")) && (p.i(paramString3, "(Landroid/view/View;)V")))
        {
          paramString2 = f.b(this.qSP);
          if (paramString2 != null)
          {
            paramString2 = (String)paramString2.first;
            paramString3 = f.b(this.qSP);
            if (paramString3 == null) {
              break label333;
            }
          }
          label333:
          for (paramString3 = (String)paramString3.second;; paramString3 = null)
          {
            if ((paramString2 == null) || (!p.i(paramString2, localObject3.getClass().getName())) || (paramString3 == null)) {
              break label338;
            }
            if (!p.i(paramString3, paramString1))
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
              if (!p.i(paramString3, paramString2)) {
                break label338;
              }
            }
            AppMethodBeat.o(210663);
            return;
            paramString2 = null;
            break;
          }
          label338:
          f.a(this.qSP, (View)localObject3, paramString1, paramObject, d.qSq);
          AppMethodBeat.o(210663);
          return;
        }
        localObject1 = d.qSq;
        if ((p.i("onDrag", paramString2)) && (p.i("(Landroid/view/View;Landroid/view/DragEvent;)Z", paramString3))) {
          paramArrayOfObject = d.qSw;
        }
        for (;;)
        {
          paramString2 = a.qSi;
          if (!a.cos()) {
            break;
          }
          ad.w("HABBYGE-MALI.ViewOpCallback", "gGestureFirst=TRUE");
          paramString1 = a.qSi;
          a.kX(false);
          AppMethodBeat.o(210663);
          return;
          if ((p.i("onLongClick", paramString2)) && (p.i("(Landroid/view/View;)Z", paramString3)))
          {
            paramArrayOfObject = d.qSr;
          }
          else if ((p.i("onKey", paramString2)) && (p.i("(Landroid/view/View;ILandroid/view/KeyEvent;)Z", paramString3)))
          {
            paramArrayOfObject = d.qSx;
          }
          else if ((p.i("onHover", paramString2)) && (p.i("(Landroid/view/View;Landroid/view/MotionEvent;)Z", paramString3)))
          {
            paramArrayOfObject = d.qSy;
          }
          else if ((p.i("onItemClick", paramString2)) && (p.i("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
          {
            paramArrayOfObject = d.qSt;
          }
          else if ((p.i("onItemLongClick", paramString2)) && (p.i("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
          {
            paramArrayOfObject = d.qSu;
          }
          else if ((p.i("onItemSelected", paramString2)) && (p.i("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
          {
            paramArrayOfObject = d.qSv;
          }
          else
          {
            paramArrayOfObject = (Object[])localObject1;
            if (p.i("onTouchEvent", paramString2))
            {
              paramArrayOfObject = (Object[])localObject1;
              if (p.i("(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", paramString3)) {
                paramArrayOfObject = d.qSp;
              }
            }
          }
        }
        f.a(this.qSP, (View)localObject3, paramString1, paramObject, paramArrayOfObject);
      }
      AppMethodBeat.o(210663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.f
 * JD-Core Version:    0.7.0.1
 */