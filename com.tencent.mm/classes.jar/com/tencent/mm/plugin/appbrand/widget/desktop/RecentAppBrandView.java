package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentAppBrandView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private RecyclerView.a acW;
  private GestureDetector lwM;
  private int nbB;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b ncB;
  private boolean ndG;
  List<AppBrandDesktopView.c> ndS;
  List<AppBrandDesktopView.c> ndT;
  private ArrayList<RecyclerView.w> ndU;
  private GridLayoutManager ndV;
  private int ndW;
  private g ndX;
  int ndY;
  boolean ndZ;
  private b nea;
  private int neb;
  private int nec;
  private boolean ned;
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49684);
    this.ndS = new ArrayList();
    this.ndT = new ArrayList();
    this.ndU = new ArrayList();
    this.nbB = 0;
    this.acW = null;
    this.ndV = null;
    this.ndW = 0;
    this.ndY = 10;
    this.ndZ = true;
    this.neb = 1;
    this.nec = 1;
    this.ndG = false;
    this.ned = false;
    init(paramContext);
    AppMethodBeat.o(49684);
  }
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49685);
    this.ndS = new ArrayList();
    this.ndT = new ArrayList();
    this.ndU = new ArrayList();
    this.nbB = 0;
    this.acW = null;
    this.ndV = null;
    this.ndW = 0;
    this.ndY = 10;
    this.ndZ = true;
    this.neb = 1;
    this.nec = 1;
    this.ndG = false;
    this.ned = false;
    init(paramContext);
    AppMethodBeat.o(49685);
  }
  
  private void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(49691);
    if (paramBoolean == this.ned)
    {
      AppMethodBeat.o(49691);
      return;
    }
    paramMotionEvent = o(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      paramMotionEvent = bu(paramMotionEvent);
      if (paramMotionEvent != null)
      {
        paramMotionEvent.auu.setPressed(paramBoolean);
        if (!paramBoolean) {
          break label85;
        }
        ae.i("MicroMsg.RecentAppBrandView", "alvinluo add pressed item");
        this.ndU.add(paramMotionEvent);
      }
    }
    for (;;)
    {
      this.ned = paramBoolean;
      AppMethodBeat.o(49691);
      return;
      label85:
      ae.i("MicroMsg.RecentAppBrandView", "alvinluo remove pressed item");
      this.ndU.remove(paramMotionEvent);
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49689);
    this.ndV = new GridLayoutManager(b.getCompletelyCountPerPage(), 1);
    setLayoutManager(this.ndV);
    this.acW = new a();
    setAdapter(this.acW);
    this.lwM = new GestureDetector(paramContext, this);
    this.ndX = new g();
    this.ndX.acW = this.acW;
    setItemAnimator(this.ndX);
    this.nec = b.bDC();
    this.ndY = (this.nec * b.getCompletelyCountPerPage() + 2);
    AppMethodBeat.o(49689);
  }
  
  public final void bDZ()
  {
    AppMethodBeat.i(49695);
    if (kW())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49678);
          if (RecentAppBrandView.this.getAdapter() != null) {
            RecentAppBrandView.this.getAdapter().asY.notifyChanged();
          }
          AppMethodBeat.o(49678);
        }
      });
      AppMethodBeat.o(49695);
      return;
    }
    if (getAdapter() != null) {
      getAdapter().asY.notifyChanged();
    }
    AppMethodBeat.o(49695);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(49697);
    int i = this.ndS.size();
    AppMethodBeat.o(49697);
    return i;
  }
  
  public List<AppBrandDesktopView.c> getDataList()
  {
    return this.ndS;
  }
  
  public int getMaxShowItemCountIncludeMore()
  {
    AppMethodBeat.i(49687);
    int i = this.neb;
    int j = b.getCompletelyCountPerPage();
    AppMethodBeat.o(49687);
    return i * j;
  }
  
  public int getShowCount()
  {
    AppMethodBeat.i(49696);
    int i = this.ndT.size();
    AppMethodBeat.o(49696);
    return i;
  }
  
  public int getShowLines()
  {
    return this.neb;
  }
  
  public List<AppBrandDesktopView.c> getShowList()
  {
    return this.ndT;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49692);
    ae.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView onDown");
    AppMethodBeat.o(49692);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49694);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    this.ndG = true;
    a(paramMotionEvent, false);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(49694);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49693);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    paramMotionEvent = o(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      paramMotionEvent = bu(paramMotionEvent);
      if (paramMotionEvent != null) {
        paramMotionEvent.auu.performClick();
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(49693);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49690);
    if (paramMotionEvent.getAction() == 0)
    {
      this.ndG = false;
      a(paramMotionEvent, true);
    }
    for (;;)
    {
      Object localObject = this.lwM;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.ahE(), "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.mt(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (this.ndG) {
        break;
      }
      AppMethodBeat.o(49690);
      return true;
      if (paramMotionEvent.getAction() != 2)
      {
        localObject = this.ndU.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((RecyclerView.w)((Iterator)localObject).next()).auu.setPressed(false);
        }
        this.ndU.clear();
      }
    }
    AppMethodBeat.o(49690);
    return false;
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    AppMethodBeat.i(49686);
    this.ndS = paramList;
    this.ndT.clear();
    wk(this.ndS.size());
    int i = this.neb;
    int k = b.getCompletelyCountPerPage() * i;
    if (this.ndS.size() == k) {}
    for (i = k;; i = k - 1)
    {
      int j = 0;
      while ((j < this.ndS.size()) && (j < i))
      {
        this.ndT.add(this.ndS.get(j));
        j += 1;
      }
    }
    this.ndZ = true;
    ae.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView mDataList: %d, showCount: %d, maxShowCount: %d", new Object[] { Integer.valueOf(this.ndS.size()), Integer.valueOf(this.ndT.size()), Integer.valueOf(k) });
    AppMethodBeat.o(49686);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.nbB = paramInt;
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.nea = paramb;
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    this.ncB = paramb;
  }
  
  final void wk(int paramInt)
  {
    AppMethodBeat.i(49688);
    int k = b.getCompletelyCountPerPage();
    int j = paramInt / k;
    int i = j;
    if (paramInt % k != 0) {
      i = j + 1;
    }
    this.neb = Math.min(this.nec, i);
    ae.i("MicroMsg.RecentAppBrandView", "alvinluo configShowLines dataCount: %d, countPerLine: %d, currentShowLine: %d, maxShowLine: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(this.neb), Integer.valueOf(this.nec) });
    AppMethodBeat.o(49688);
  }
  
  public final AppBrandDesktopView.c wl(int paramInt)
  {
    AppMethodBeat.i(49698);
    AppBrandDesktopView.c localc = (AppBrandDesktopView.c)this.ndS.get(paramInt);
    AppMethodBeat.o(49698);
    return localc;
  }
  
  final class a
    extends RecyclerView.a<f>
  {
    a() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(49681);
      int i = RecentAppBrandView.d(RecentAppBrandView.this).size();
      AppMethodBeat.o(49681);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(49680);
      paramInt = RecentAppBrandView.a(RecentAppBrandView.this, paramInt).type;
      AppMethodBeat.o(49680);
      return paramInt;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(RecyclerView.w paramw, AppBrandDesktopView.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView
 * JD-Core Version:    0.7.0.1
 */