package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
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
  private RecyclerView.a aaj;
  private GestureDetector ktZ;
  private int lTO;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b lUO;
  private boolean lVP;
  List<AppBrandDesktopView.c> lWb;
  List<AppBrandDesktopView.c> lWc;
  private ArrayList<RecyclerView.v> lWd;
  private GridLayoutManager lWe;
  private int lWf;
  private f lWg;
  int lWh;
  boolean lWi;
  private b lWj;
  private int lWk;
  private int lWl;
  private boolean lWm;
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49684);
    this.lWb = new ArrayList();
    this.lWc = new ArrayList();
    this.lWd = new ArrayList();
    this.lTO = 0;
    this.aaj = null;
    this.lWe = null;
    this.lWf = 0;
    this.lWh = 10;
    this.lWi = true;
    this.lWk = 1;
    this.lWl = 1;
    this.lVP = false;
    this.lWm = false;
    init(paramContext);
    AppMethodBeat.o(49684);
  }
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49685);
    this.lWb = new ArrayList();
    this.lWc = new ArrayList();
    this.lWd = new ArrayList();
    this.lTO = 0;
    this.aaj = null;
    this.lWe = null;
    this.lWf = 0;
    this.lWh = 10;
    this.lWi = true;
    this.lWk = 1;
    this.lWl = 1;
    this.lVP = false;
    this.lWm = false;
    init(paramContext);
    AppMethodBeat.o(49685);
  }
  
  private void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(49691);
    if (paramBoolean == this.lWm)
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
        paramMotionEvent.arI.setPressed(paramBoolean);
        if (!paramBoolean) {
          break label85;
        }
        ad.i("MicroMsg.RecentAppBrandView", "alvinluo add pressed item");
        this.lWd.add(paramMotionEvent);
      }
    }
    for (;;)
    {
      this.lWm = paramBoolean;
      AppMethodBeat.o(49691);
      return;
      label85:
      ad.i("MicroMsg.RecentAppBrandView", "alvinluo remove pressed item");
      this.lWd.remove(paramMotionEvent);
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49689);
    this.lWe = new GridLayoutManager(b.getCompletelyCountPerPage(), 1);
    setLayoutManager(this.lWe);
    this.aaj = new a();
    setAdapter(this.aaj);
    this.ktZ = new GestureDetector(paramContext, this);
    this.lWg = new f();
    this.lWg.aaj = this.aaj;
    setItemAnimator(this.lWg);
    this.lWl = b.brF();
    this.lWh = (this.lWl * b.getCompletelyCountPerPage() + 2);
    AppMethodBeat.o(49689);
  }
  
  public final void bsd()
  {
    AppMethodBeat.i(49695);
    if (ky())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49678);
          if (RecentAppBrandView.this.getAdapter() != null) {
            RecentAppBrandView.this.getAdapter().aql.notifyChanged();
          }
          AppMethodBeat.o(49678);
        }
      });
      AppMethodBeat.o(49695);
      return;
    }
    if (getAdapter() != null) {
      getAdapter().aql.notifyChanged();
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
    int i = this.lWb.size();
    AppMethodBeat.o(49697);
    return i;
  }
  
  public List<AppBrandDesktopView.c> getDataList()
  {
    return this.lWb;
  }
  
  public int getMaxShowItemCountIncludeMore()
  {
    AppMethodBeat.i(49687);
    int i = this.lWk;
    int j = b.getCompletelyCountPerPage();
    AppMethodBeat.o(49687);
    return i * j;
  }
  
  public int getShowCount()
  {
    AppMethodBeat.i(49696);
    int i = this.lWc.size();
    AppMethodBeat.o(49696);
    return i;
  }
  
  public int getShowLines()
  {
    return this.lWk;
  }
  
  public List<AppBrandDesktopView.c> getShowList()
  {
    return this.lWc;
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
    this.lVP = true;
    a(paramMotionEvent, false);
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
    paramMotionEvent = o(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      paramMotionEvent = bu(paramMotionEvent);
      if (paramMotionEvent != null) {
        paramMotionEvent.arI.performClick();
      }
    }
    AppMethodBeat.o(49693);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49690);
    if (paramMotionEvent.getAction() == 0)
    {
      this.lVP = false;
      a(paramMotionEvent, true);
    }
    for (;;)
    {
      this.ktZ.onTouchEvent(paramMotionEvent);
      if (this.lVP) {
        break;
      }
      AppMethodBeat.o(49690);
      return true;
      if (paramMotionEvent.getAction() != 2)
      {
        Iterator localIterator = this.lWd.iterator();
        while (localIterator.hasNext()) {
          ((RecyclerView.v)localIterator.next()).arI.setPressed(false);
        }
        this.lWd.clear();
      }
    }
    AppMethodBeat.o(49690);
    return false;
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    AppMethodBeat.i(49686);
    this.lWb = paramList;
    this.lWc.clear();
    uI(this.lWb.size());
    int i = this.lWk;
    int k = b.getCompletelyCountPerPage() * i;
    if (this.lWb.size() == k) {}
    for (i = k;; i = k - 1)
    {
      int j = 0;
      while ((j < this.lWb.size()) && (j < i))
      {
        this.lWc.add(this.lWb.get(j));
        j += 1;
      }
    }
    this.lWi = true;
    ad.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView mDataList: %d, showCount: %d, maxShowCount: %d", new Object[] { Integer.valueOf(this.lWb.size()), Integer.valueOf(this.lWc.size()), Integer.valueOf(k) });
    AppMethodBeat.o(49686);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.lTO = paramInt;
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.lWj = paramb;
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    this.lUO = paramb;
  }
  
  final void uI(int paramInt)
  {
    AppMethodBeat.i(49688);
    int k = b.getCompletelyCountPerPage();
    int j = paramInt / k;
    int i = j;
    if (paramInt % k != 0) {
      i = j + 1;
    }
    this.lWk = Math.min(this.lWl, i);
    ad.i("MicroMsg.RecentAppBrandView", "alvinluo configShowLines dataCount: %d, countPerLine: %d, currentShowLine: %d, maxShowLine: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(this.lWk), Integer.valueOf(this.lWl) });
    AppMethodBeat.o(49688);
  }
  
  public final AppBrandDesktopView.c uJ(int paramInt)
  {
    AppMethodBeat.i(49698);
    AppBrandDesktopView.c localc = (AppBrandDesktopView.c)this.lWb.get(paramInt);
    AppMethodBeat.o(49698);
    return localc;
  }
  
  final class a
    extends RecyclerView.a<e>
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
    public abstract void a(RecyclerView.v paramv, AppBrandDesktopView.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView
 * JD-Core Version:    0.7.0.1
 */