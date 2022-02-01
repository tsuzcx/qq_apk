package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback;", "", "()V", "mArgsOnTouchRef", "Ljava/lang/ref/WeakReference;", "", "mClickDown", "", "mHellEventListeners", "", "Lcom/tencent/mm/plugin/expt/api/IHellhoundService$IHellEventListener;", "mImageViewClickListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1;", "mListener", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/IViewOpListener;", "mTouchPair", "Landroid/util/Pair;", "", "mViewOpListener", "com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1;", "callback", "", "view", "Landroid/view/View;", "className", "caller", "eventId", "Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewEventId;", "imageViewMonitor", "registerHellEventListener", "listener", "registerHellEventListener$plugin_expt_release", "unregisterHellEventListener", "unregisterHellEventListener$plugin_expt_release", "viewOpMonitor", "viewOpMonitor$plugin_expt_release", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f.a zCU;
  public List<e.d> zBA;
  private WeakReference<Object[]> zCV;
  private Pair<String, String> zCW;
  public final c zCX;
  private boolean zCY;
  public final b zCZ;
  public c zCo;
  
  static
  {
    AppMethodBeat.i(300095);
    zCU = new f.a((byte)0);
    AppMethodBeat.o(300095);
  }
  
  public f()
  {
    AppMethodBeat.i(300072);
    this.zBA = ((List)new ArrayList());
    this.zCX = new c(this);
    this.zCZ = new b(this);
    AppMethodBeat.o(300072);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mImageViewClickListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.hellhoundlib.a.d
  {
    b(f paramf) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(300051);
      if (!f.c(this.zDa))
      {
        AppMethodBeat.o(300051);
        return;
      }
      if ((paramObject1 == null) || (!(paramObject1 instanceof View)))
      {
        AppMethodBeat.o(300051);
        return;
      }
      if ((paramObject2 == null) || (!(paramObject2 instanceof Boolean)) || (!((Boolean)paramObject2).booleanValue()))
      {
        AppMethodBeat.o(300051);
        return;
      }
      f.a(this.zDa, false);
      f.a(this.zDa, (View)paramObject1, paramString1, paramObject1, d.zCA);
      AppMethodBeat.o(300051);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(300047);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label30;
        }
      }
      label30:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(300047);
        return;
      }
      if (!(paramArrayOfObject[0] instanceof MotionEvent))
      {
        AppMethodBeat.o(300047);
        return;
      }
      paramString1 = (MotionEvent)paramArrayOfObject[0];
      paramString2 = this.zDa;
      if (paramString1.getAction() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        f.a(paramString2, bool);
        AppMethodBeat.o(300047);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewOpCallback$mViewOpListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.hellhoundlib.a.d
  {
    c(f paramf) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2)
    {
      f localf = null;
      AppMethodBeat.i(300074);
      if ((!s.p(paramString2, "onTouch")) || (!s.p(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z")))
      {
        AppMethodBeat.o(300074);
        return;
      }
      paramString2 = f.b(this.zDa);
      if (paramString2 == null) {}
      for (paramString2 = null; paramString2 == null; paramString2 = (Object[])paramString2.get())
      {
        AppMethodBeat.o(300074);
        return;
      }
      boolean bool;
      if ((paramString2.length >= 2) && ((paramString2[1] instanceof MotionEvent)))
      {
        paramString3 = paramString2[1];
        if (paramString3 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type android.view.MotionEvent");
          AppMethodBeat.o(300074);
          throw paramString1;
        }
        if (((MotionEvent)paramString3).getAction() != 1)
        {
          AppMethodBeat.o(300074);
          return;
        }
        if (!(paramString2[0] instanceof View))
        {
          AppMethodBeat.o(300074);
          return;
        }
        paramString2 = paramString2[0];
        paramString3 = localf;
        if ((paramString2 instanceof View)) {
          paramString3 = (View)paramString2;
        }
        if (paramString3 == null)
        {
          AppMethodBeat.o(300074);
          return;
        }
        if ((paramObject2 != null) && ((paramObject2 instanceof Boolean)) && (((Boolean)paramObject2).booleanValue()))
        {
          localf = this.zDa;
          String str = paramString3.getClass().getName();
          if (paramObject1 == null) {
            paramString2 = paramString1;
          }
          for (;;)
          {
            f.a(localf, new Pair(str, paramString2));
            f.a(this.zDa, paramString3, paramString1, paramObject1, d.zCA);
            AppMethodBeat.o(300074);
            return;
            paramString2 = paramObject1.getClass();
            if (paramString2 == null)
            {
              paramString2 = paramString1;
            }
            else
            {
              paramObject2 = paramString2.getName();
              paramString2 = paramObject2;
              if (paramObject2 == null) {
                paramString2 = paramString1;
              }
            }
          }
        }
        bool = paramString3.hasOnClickListeners();
        if ((!(paramString3 instanceof AdapterView)) || (((AdapterView)paramString3).getOnItemClickListener() == null)) {
          break label339;
        }
      }
      label339:
      for (int i = 1;; i = 0)
      {
        if ((!bool) && (i == 0)) {
          f.a(this.zDa, paramString3, paramString1, paramObject1, d.zCA);
        }
        AppMethodBeat.o(300074);
        return;
      }
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      d locald = null;
      AppMethodBeat.i(300065);
      if (paramArrayOfObject != null) {
        if (paramArrayOfObject.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(300065);
        return;
      }
      View localView;
      if ((paramArrayOfObject[0] instanceof View))
      {
        localView = (View)paramArrayOfObject[0];
        if (localView == null) {
          AppMethodBeat.o(300065);
        }
      }
      else
      {
        i = paramArrayOfObject.length - 1;
        if (i < 0) {}
      }
      for (;;)
      {
        int j = i - 1;
        if ((paramArrayOfObject[i] instanceof View))
        {
          localView = (View)paramArrayOfObject[i];
          break;
        }
        if (j < 0)
        {
          localView = null;
          break;
          f.a(this.zDa, null);
          if ((s.p(paramString2, "onTouch")) && (s.p(paramString3, "(Landroid/view/View;Landroid/view/MotionEvent;)Z")))
          {
            if ((paramArrayOfObject.length >= 2) && ((paramArrayOfObject[1] instanceof MotionEvent)) && (((MotionEvent)paramArrayOfObject[1]).getAction() == 1))
            {
              f.a(this.zDa, new WeakReference(paramArrayOfObject));
              AppMethodBeat.o(300065);
            }
          }
          else
          {
            if ((s.p(paramString2, "onClick")) && (s.p(paramString3, "(Landroid/view/View;)V")))
            {
              paramString2 = f.a(this.zDa);
              if (paramString2 == null)
              {
                paramString2 = null;
                paramString3 = f.a(this.zDa);
                if (paramString3 != null) {
                  break label311;
                }
                paramString3 = null;
                label247:
                if ((paramString2 == null) || (!s.p(paramString2, localView.getClass().getName())) || (paramString3 == null)) {
                  break label346;
                }
                if (!s.p(paramString3, paramString1))
                {
                  if (paramObject != null) {
                    break label322;
                  }
                  paramString2 = locald;
                }
              }
              for (;;)
              {
                if (!s.p(paramString3, paramString2)) {
                  break label346;
                }
                AppMethodBeat.o(300065);
                return;
                paramString2 = (String)paramString2.first;
                break;
                label311:
                paramString3 = (String)paramString3.second;
                break label247;
                label322:
                paramArrayOfObject = paramObject.getClass();
                paramString2 = locald;
                if (paramArrayOfObject != null) {
                  paramString2 = paramArrayOfObject.getName();
                }
              }
              label346:
              f.a(this.zDa, localView, paramString1, paramObject, d.zCB);
              AppMethodBeat.o(300065);
              return;
            }
            locald = d.zCB;
            if ((s.p("onDrag", paramString2)) && (s.p("(Landroid/view/View;Landroid/view/DragEvent;)Z", paramString3))) {
              paramArrayOfObject = d.zCH;
            }
            for (;;)
            {
              paramString2 = a.zCn;
              if (!a.dJL()) {
                break;
              }
              Log.w("HABBYGE-MALI.ViewOpCallback", "gGestureFirst=TRUE");
              paramString1 = a.zCn;
              a.oN(false);
              AppMethodBeat.o(300065);
              return;
              if ((s.p("onLongClick", paramString2)) && (s.p("(Landroid/view/View;)Z", paramString3)))
              {
                paramArrayOfObject = d.zCC;
              }
              else if ((s.p("onKey", paramString2)) && (s.p("(Landroid/view/View;ILandroid/view/KeyEvent;)Z", paramString3)))
              {
                paramArrayOfObject = d.zCI;
              }
              else if ((s.p("onHover", paramString2)) && (s.p("(Landroid/view/View;Landroid/view/MotionEvent;)Z", paramString3)))
              {
                paramArrayOfObject = d.zCJ;
              }
              else if ((s.p("onItemClick", paramString2)) && (s.p("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
              {
                paramArrayOfObject = d.zCE;
              }
              else if ((s.p("onItemLongClick", paramString2)) && (s.p("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
              {
                paramArrayOfObject = d.zCF;
              }
              else if ((s.p("onItemSelected", paramString2)) && (s.p("(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", paramString3)))
              {
                paramArrayOfObject = d.zCG;
              }
              else
              {
                paramArrayOfObject = locald;
                if (s.p("onTouchEvent", paramString2))
                {
                  paramArrayOfObject = locald;
                  if (s.p("(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", paramString3)) {
                    paramArrayOfObject = d.zCA;
                  }
                }
              }
            }
            if (localView != null) {
              f.a(this.zDa, localView, paramString1, paramObject, paramArrayOfObject);
            }
          }
          AppMethodBeat.o(300065);
          return;
        }
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.c.f
 * JD-Core Version:    0.7.0.1
 */