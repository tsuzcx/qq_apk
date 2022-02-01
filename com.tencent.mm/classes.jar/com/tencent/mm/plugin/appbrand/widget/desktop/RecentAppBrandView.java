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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentAppBrandView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private RecyclerView.a acW;
  private GestureDetector lsn;
  private int mWv;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b mXu;
  List<AppBrandDesktopView.c> mYL;
  List<AppBrandDesktopView.c> mYM;
  private ArrayList<RecyclerView.w> mYN;
  private GridLayoutManager mYO;
  private int mYP;
  private g mYQ;
  int mYR;
  boolean mYS;
  private b mYT;
  private int mYU;
  private int mYV;
  private boolean mYW;
  private boolean mYz;
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49684);
    this.mYL = new ArrayList();
    this.mYM = new ArrayList();
    this.mYN = new ArrayList();
    this.mWv = 0;
    this.acW = null;
    this.mYO = null;
    this.mYP = 0;
    this.mYR = 10;
    this.mYS = true;
    this.mYU = 1;
    this.mYV = 1;
    this.mYz = false;
    this.mYW = false;
    init(paramContext);
    AppMethodBeat.o(49684);
  }
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49685);
    this.mYL = new ArrayList();
    this.mYM = new ArrayList();
    this.mYN = new ArrayList();
    this.mWv = 0;
    this.acW = null;
    this.mYO = null;
    this.mYP = 0;
    this.mYR = 10;
    this.mYS = true;
    this.mYU = 1;
    this.mYV = 1;
    this.mYz = false;
    this.mYW = false;
    init(paramContext);
    AppMethodBeat.o(49685);
  }
  
  private void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(49691);
    if (paramBoolean == this.mYW)
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
        ad.i("MicroMsg.RecentAppBrandView", "alvinluo add pressed item");
        this.mYN.add(paramMotionEvent);
      }
    }
    for (;;)
    {
      this.mYW = paramBoolean;
      AppMethodBeat.o(49691);
      return;
      label85:
      ad.i("MicroMsg.RecentAppBrandView", "alvinluo remove pressed item");
      this.mYN.remove(paramMotionEvent);
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49689);
    this.mYO = new GridLayoutManager(b.getCompletelyCountPerPage(), 1);
    setLayoutManager(this.mYO);
    this.acW = new a();
    setAdapter(this.acW);
    this.lsn = new GestureDetector(paramContext, this);
    this.mYQ = new g();
    this.mYQ.acW = this.acW;
    setItemAnimator(this.mYQ);
    this.mYV = b.bCK();
    this.mYR = (this.mYV * b.getCompletelyCountPerPage() + 2);
    AppMethodBeat.o(49689);
  }
  
  public final void bDh()
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
    int i = this.mYL.size();
    AppMethodBeat.o(49697);
    return i;
  }
  
  public List<AppBrandDesktopView.c> getDataList()
  {
    return this.mYL;
  }
  
  public int getMaxShowItemCountIncludeMore()
  {
    AppMethodBeat.i(49687);
    int i = this.mYU;
    int j = b.getCompletelyCountPerPage();
    AppMethodBeat.o(49687);
    return i * j;
  }
  
  public int getShowCount()
  {
    AppMethodBeat.i(49696);
    int i = this.mYM.size();
    AppMethodBeat.o(49696);
    return i;
  }
  
  public int getShowLines()
  {
    return this.mYU;
  }
  
  public List<AppBrandDesktopView.c> getShowList()
  {
    return this.mYM;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49692);
    ad.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView onDown");
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    this.mYz = true;
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
      this.mYz = false;
      a(paramMotionEvent, true);
    }
    for (;;)
    {
      Object localObject = this.lsn;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.ahp(), "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.mq(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (this.mYz) {
        break;
      }
      AppMethodBeat.o(49690);
      return true;
      if (paramMotionEvent.getAction() != 2)
      {
        localObject = this.mYN.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((RecyclerView.w)((Iterator)localObject).next()).auu.setPressed(false);
        }
        this.mYN.clear();
      }
    }
    AppMethodBeat.o(49690);
    return false;
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    AppMethodBeat.i(49686);
    this.mYL = paramList;
    this.mYM.clear();
    wf(this.mYL.size());
    int i = this.mYU;
    int k = b.getCompletelyCountPerPage() * i;
    if (this.mYL.size() == k) {}
    for (i = k;; i = k - 1)
    {
      int j = 0;
      while ((j < this.mYL.size()) && (j < i))
      {
        this.mYM.add(this.mYL.get(j));
        j += 1;
      }
    }
    this.mYS = true;
    ad.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView mDataList: %d, showCount: %d, maxShowCount: %d", new Object[] { Integer.valueOf(this.mYL.size()), Integer.valueOf(this.mYM.size()), Integer.valueOf(k) });
    AppMethodBeat.o(49686);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.mWv = paramInt;
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.mYT = paramb;
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    this.mXu = paramb;
  }
  
  final void wf(int paramInt)
  {
    AppMethodBeat.i(49688);
    int k = b.getCompletelyCountPerPage();
    int j = paramInt / k;
    int i = j;
    if (paramInt % k != 0) {
      i = j + 1;
    }
    this.mYU = Math.min(this.mYV, i);
    ad.i("MicroMsg.RecentAppBrandView", "alvinluo configShowLines dataCount: %d, countPerLine: %d, currentShowLine: %d, maxShowLine: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(this.mYU), Integer.valueOf(this.mYV) });
    AppMethodBeat.o(49688);
  }
  
  public final AppBrandDesktopView.c wg(int paramInt)
  {
    AppMethodBeat.i(49698);
    AppBrandDesktopView.c localc = (AppBrandDesktopView.c)this.mYL.get(paramInt);
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