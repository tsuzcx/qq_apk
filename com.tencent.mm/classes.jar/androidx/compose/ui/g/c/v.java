package androidx.compose.ui.g.c;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.d.e;
import androidx.compose.ui.d.e.a;
import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerInteropFilter;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "()V", "disallowIntercept", "", "getDisallowIntercept$ui_release", "()Z", "setDisallowIntercept$ui_release", "(Z)V", "onTouchEvent", "Lkotlin/Function1;", "Landroid/view/MotionEvent;", "getOnTouchEvent", "()Lkotlin/jvm/functions/Function1;", "setOnTouchEvent", "(Lkotlin/jvm/functions/Function1;)V", "pointerInputFilter", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "getPointerInputFilter", "()Landroidx/compose/ui/input/pointer/PointerInputFilter;", "value", "Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "requestDisallowInterceptTouchEvent", "getRequestDisallowInterceptTouchEvent", "()Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;", "setRequestDisallowInterceptTouchEvent", "(Landroidx/compose/ui/input/pointer/RequestDisallowInterceptTouchEvent;)V", "DispatchToViewState", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
  implements t
{
  public b<? super MotionEvent, Boolean> aLA;
  public aa aLB;
  boolean aLC;
  private final s aLc;
  
  public v()
  {
    AppMethodBeat.i(205925);
    this.aLc = ((s)new b(this));
    AppMethodBeat.o(205925);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(205948);
    paramf = t.a.a((t)this, paramf);
    AppMethodBeat.o(205948);
    return paramf;
  }
  
  public final <R> R a(R paramR, kotlin.g.a.m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(205935);
    paramR = t.a.a((t)this, paramR, paramm);
    AppMethodBeat.o(205935);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(205946);
    boolean bool = t.a.a((t)this, paramb);
    AppMethodBeat.o(205946);
    return bool;
  }
  
  public final <R> R b(R paramR, kotlin.g.a.m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(205940);
    paramR = t.a.b((t)this, paramR, paramm);
    AppMethodBeat.o(205940);
    return paramR;
  }
  
  public final s wq()
  {
    return this.aLc;
  }
  
  public final b<MotionEvent, Boolean> wr()
  {
    AppMethodBeat.i(205928);
    b localb = this.aLA;
    if (localb != null)
    {
      AppMethodBeat.o(205928);
      return localb;
    }
    kotlin.g.b.s.bIx("onTouchEvent");
    AppMethodBeat.o(205928);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "", "(Ljava/lang/String;I)V", "Unknown", "Dispatching", "NotDispatching", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  static enum a
  {
    static
    {
      AppMethodBeat.i(205820);
      aLD = new a("Unknown", 0);
      aLE = new a("Dispatching", 1);
      aLF = new a("NotDispatching", 2);
      aLG = new a[] { aLD, aLE, aLF };
      AppMethodBeat.o(205820);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/ui/input/pointer/PointerInteropFilter$pointerInputFilter$1", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "state", "Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "dispatchToView", "", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onCancel", "onPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "reset", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends s
  {
    private v.a aLH = v.a.aLD;
    
    b(v paramv) {}
    
    private final void a(i parami)
    {
      Object localObject1 = null;
      int j = 0;
      AppMethodBeat.i(205772);
      Object localObject2 = parami.alK;
      int m = ((List)localObject2).size() - 1;
      if (m >= 0) {}
      int k;
      label146:
      label169:
      label182:
      label334:
      for (int i = 0;; i = k)
      {
        k = i + 1;
        if (j.h((m)((List)localObject2).get(i)))
        {
          i = 1;
          if (i == 0) {
            break label182;
          }
          if (this.aLH != v.a.aLE) {
            break label169;
          }
          localObject2 = this.ahy;
          if (localObject2 != null) {
            break label123;
          }
        }
        for (;;)
        {
          if (localObject1 != null) {
            break label146;
          }
          parami = (Throwable)new IllegalStateException("layoutCoordinates not set".toString());
          AppMethodBeat.o(205772);
          throw parami;
          if (k <= m) {
            break label334;
          }
          i = 0;
          break;
          label123:
          localObject1 = e.avo;
          localObject1 = e.N(((androidx.compose.ui.h.j)localObject2).av(e.su()));
        }
        x.b(parami, ((e)localObject1).avp, (b)new a(this.aLI));
        this.aLH = v.a.aLF;
        AppMethodBeat.o(205772);
        return;
        localObject1 = this.ahy;
        if (localObject1 == null) {}
        for (localObject1 = null; localObject1 == null; localObject1 = e.N(((androidx.compose.ui.h.j)localObject1).av(e.su())))
        {
          parami = (Throwable)new IllegalStateException("layoutCoordinates not set".toString());
          AppMethodBeat.o(205772);
          throw parami;
          e.a locala = e.avo;
        }
        x.a(parami, ((e)localObject1).avp, (b)new b(this, this.aLI));
        if (this.aLH == v.a.aLE)
        {
          k = ((List)localObject2).size() - 1;
          if (k < 0) {}
        }
        for (i = j;; i = j)
        {
          j = i + 1;
          j.k((m)((List)localObject2).get(i));
          if (j > k)
          {
            AppMethodBeat.o(205772);
            return;
          }
        }
      }
    }
    
    private final void reset()
    {
      this.aLH = v.a.aLD;
      this.aLI.aLC = false;
    }
    
    public final void a(i parami, k paramk, long paramLong)
    {
      int j = 1;
      AppMethodBeat.i(205779);
      kotlin.g.b.s.u(parami, "pointerEvent");
      kotlin.g.b.s.u(paramk, "pass");
      List localList = parami.alK;
      int m;
      if (!this.aLI.aLC)
      {
        m = localList.size() - 1;
        if (m < 0) {
          break label239;
        }
      }
      int k;
      label269:
      for (int i = 0;; i = k)
      {
        k = i + 1;
        m localm = (m)localList.get(i);
        if ((j.b(localm)) || (j.d(localm)))
        {
          i = 1;
          if (i == 0) {
            break label232;
          }
          i = 1;
          label102:
          if (i == 0) {
            break label245;
          }
          i = 1;
          label110:
          if (this.aLH != v.a.aLF)
          {
            if ((paramk == k.aLi) && (i != 0)) {
              a(parami);
            }
            if ((paramk == k.aLk) && (i == 0)) {
              a(parami);
            }
          }
          if (paramk == k.aLk)
          {
            m = localList.size() - 1;
            i = j;
            if (m < 0) {}
          }
        }
        for (i = 0;; i = k)
        {
          k = i + 1;
          if (!j.d((m)localList.get(i))) {
            i = 0;
          }
          label232:
          label239:
          label245:
          do
          {
            if (i != 0) {
              reset();
            }
            AppMethodBeat.o(205779);
            return;
            i = 0;
            break;
            if (k <= m) {
              break label269;
            }
            i = 0;
            break label102;
            i = 0;
            break label110;
            i = j;
          } while (k > m);
        }
      }
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(205787);
      if (this.aLH == v.a.aLE)
      {
        long l = SystemClock.uptimeMillis();
        b localb = (b)new c(this.aLI);
        kotlin.g.b.s.u(localb, "block");
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        localMotionEvent.setSource(0);
        kotlin.g.b.s.s(localMotionEvent, "motionEvent");
        localb.invoke(localMotionEvent);
        localMotionEvent.recycle();
        reset();
      }
      AppMethodBeat.o(205787);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "motionEvent", "Landroid/view/MotionEvent;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements b<MotionEvent, ah>
    {
      a(v paramv)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "motionEvent", "Landroid/view/MotionEvent;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements b<MotionEvent, ah>
    {
      b(v.b paramb, v paramv)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "motionEvent", "Landroid/view/MotionEvent;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements b<MotionEvent, ah>
    {
      c(v paramv)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.v
 * JD-Core Version:    0.7.0.1
 */