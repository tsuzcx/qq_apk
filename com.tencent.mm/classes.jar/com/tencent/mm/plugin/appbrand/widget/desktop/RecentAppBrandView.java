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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentAppBrandView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private RecyclerView.a abe;
  private GestureDetector kVo;
  private int mvQ;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b mwQ;
  private boolean mxR;
  List<AppBrandDesktopView.c> myd;
  List<AppBrandDesktopView.c> mye;
  private ArrayList<RecyclerView.w> myf;
  private GridLayoutManager myg;
  private int myh;
  private f myi;
  int myj;
  boolean myk;
  private b myl;
  private int mym;
  private int myn;
  private boolean myo;
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49684);
    this.myd = new ArrayList();
    this.mye = new ArrayList();
    this.myf = new ArrayList();
    this.mvQ = 0;
    this.abe = null;
    this.myg = null;
    this.myh = 0;
    this.myj = 10;
    this.myk = true;
    this.mym = 1;
    this.myn = 1;
    this.mxR = false;
    this.myo = false;
    init(paramContext);
    AppMethodBeat.o(49684);
  }
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49685);
    this.myd = new ArrayList();
    this.mye = new ArrayList();
    this.myf = new ArrayList();
    this.mvQ = 0;
    this.abe = null;
    this.myg = null;
    this.myh = 0;
    this.myj = 10;
    this.myk = true;
    this.mym = 1;
    this.myn = 1;
    this.mxR = false;
    this.myo = false;
    init(paramContext);
    AppMethodBeat.o(49685);
  }
  
  private void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(49691);
    if (paramBoolean == this.myo)
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
        paramMotionEvent.asD.setPressed(paramBoolean);
        if (!paramBoolean) {
          break label85;
        }
        ac.i("MicroMsg.RecentAppBrandView", "alvinluo add pressed item");
        this.myf.add(paramMotionEvent);
      }
    }
    for (;;)
    {
      this.myo = paramBoolean;
      AppMethodBeat.o(49691);
      return;
      label85:
      ac.i("MicroMsg.RecentAppBrandView", "alvinluo remove pressed item");
      this.myf.remove(paramMotionEvent);
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49689);
    this.myg = new GridLayoutManager(b.getCompletelyCountPerPage(), 1);
    setLayoutManager(this.myg);
    this.abe = new a();
    setAdapter(this.abe);
    this.kVo = new GestureDetector(paramContext, this);
    this.myi = new f();
    this.myi.abe = this.abe;
    setItemAnimator(this.myi);
    this.myn = b.byF();
    this.myj = (this.myn * b.getCompletelyCountPerPage() + 2);
    AppMethodBeat.o(49689);
  }
  
  public final void bzd()
  {
    AppMethodBeat.i(49695);
    if (kG())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49678);
          if (RecentAppBrandView.this.getAdapter() != null) {
            RecentAppBrandView.this.getAdapter().arg.notifyChanged();
          }
          AppMethodBeat.o(49678);
        }
      });
      AppMethodBeat.o(49695);
      return;
    }
    if (getAdapter() != null) {
      getAdapter().arg.notifyChanged();
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
    int i = this.myd.size();
    AppMethodBeat.o(49697);
    return i;
  }
  
  public List<AppBrandDesktopView.c> getDataList()
  {
    return this.myd;
  }
  
  public int getMaxShowItemCountIncludeMore()
  {
    AppMethodBeat.i(49687);
    int i = this.mym;
    int j = b.getCompletelyCountPerPage();
    AppMethodBeat.o(49687);
    return i * j;
  }
  
  public int getShowCount()
  {
    AppMethodBeat.i(49696);
    int i = this.mye.size();
    AppMethodBeat.o(49696);
    return i;
  }
  
  public int getShowLines()
  {
    return this.mym;
  }
  
  public List<AppBrandDesktopView.c> getShowList()
  {
    return this.mye;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49692);
    ac.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView onDown");
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
    this.mxR = true;
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
        paramMotionEvent.asD.performClick();
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
      this.mxR = false;
      a(paramMotionEvent, true);
    }
    for (;;)
    {
      this.kVo.onTouchEvent(paramMotionEvent);
      if (this.mxR) {
        break;
      }
      AppMethodBeat.o(49690);
      return true;
      if (paramMotionEvent.getAction() != 2)
      {
        Iterator localIterator = this.myf.iterator();
        while (localIterator.hasNext()) {
          ((RecyclerView.w)localIterator.next()).asD.setPressed(false);
        }
        this.myf.clear();
      }
    }
    AppMethodBeat.o(49690);
    return false;
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    AppMethodBeat.i(49686);
    this.myd = paramList;
    this.mye.clear();
    vz(this.myd.size());
    int i = this.mym;
    int k = b.getCompletelyCountPerPage() * i;
    if (this.myd.size() == k) {}
    for (i = k;; i = k - 1)
    {
      int j = 0;
      while ((j < this.myd.size()) && (j < i))
      {
        this.mye.add(this.myd.get(j));
        j += 1;
      }
    }
    this.myk = true;
    ac.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView mDataList: %d, showCount: %d, maxShowCount: %d", new Object[] { Integer.valueOf(this.myd.size()), Integer.valueOf(this.mye.size()), Integer.valueOf(k) });
    AppMethodBeat.o(49686);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.mvQ = paramInt;
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.myl = paramb;
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    this.mwQ = paramb;
  }
  
  public final AppBrandDesktopView.c vA(int paramInt)
  {
    AppMethodBeat.i(49698);
    AppBrandDesktopView.c localc = (AppBrandDesktopView.c)this.myd.get(paramInt);
    AppMethodBeat.o(49698);
    return localc;
  }
  
  final void vz(int paramInt)
  {
    AppMethodBeat.i(49688);
    int k = b.getCompletelyCountPerPage();
    int j = paramInt / k;
    int i = j;
    if (paramInt % k != 0) {
      i = j + 1;
    }
    this.mym = Math.min(this.myn, i);
    ac.i("MicroMsg.RecentAppBrandView", "alvinluo configShowLines dataCount: %d, countPerLine: %d, currentShowLine: %d, maxShowLine: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(this.mym), Integer.valueOf(this.myn) });
    AppMethodBeat.o(49688);
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
    public abstract void a(RecyclerView.w paramw, AppBrandDesktopView.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView
 * JD-Core Version:    0.7.0.1
 */