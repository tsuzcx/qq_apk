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
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelappbrand.a.b.p;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.recent.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentAppBrandView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private RecyclerView.a adj;
  private GestureDetector mDJ;
  private int omS;
  private g onJ;
  private boolean ooU;
  List<AppBrandDesktopView.c> opg;
  List<AppBrandDesktopView.c> oph;
  private ArrayList<RecyclerView.v> opi;
  private GridLayoutManager opj;
  private int opk;
  private e opl;
  int opm;
  boolean opn;
  private b opo;
  private int opp;
  private int opq;
  private boolean opr;
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49684);
    this.opg = new ArrayList();
    this.oph = new ArrayList();
    this.opi = new ArrayList();
    this.omS = 0;
    this.adj = null;
    this.opj = null;
    this.opk = 0;
    this.opm = 10;
    this.opn = true;
    this.opp = 3;
    this.opq = 3;
    this.ooU = false;
    this.opr = false;
    init(paramContext);
    AppMethodBeat.o(49684);
  }
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49685);
    this.opg = new ArrayList();
    this.oph = new ArrayList();
    this.opi = new ArrayList();
    this.omS = 0;
    this.adj = null;
    this.opj = null;
    this.opk = 0;
    this.opm = 10;
    this.opn = true;
    this.opp = 3;
    this.opq = 3;
    this.ooU = false;
    this.opr = false;
    init(paramContext);
    AppMethodBeat.o(49685);
  }
  
  private void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(49691);
    if (paramBoolean == this.opr)
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
        paramMotionEvent.aus.setPressed(paramBoolean);
        if (!paramBoolean) {
          break label85;
        }
        Log.i("MicroMsg.RecentAppBrandView", "alvinluo add pressed item");
        this.opi.add(paramMotionEvent);
      }
    }
    for (;;)
    {
      this.opr = paramBoolean;
      AppMethodBeat.o(49691);
      return;
      label85:
      Log.i("MicroMsg.RecentAppBrandView", "alvinluo remove pressed item");
      this.opi.remove(paramMotionEvent);
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49689);
    this.opj = new GridLayoutManager(a.getCompletelyCountPerPage(), 1);
    setLayoutManager(this.opj);
    this.adj = new a();
    setAdapter(this.adj);
    this.mDJ = new GestureDetector(paramContext, this);
    this.opl = new e();
    this.opl.adj = this.adj;
    setItemAnimator(this.opl);
    this.opq = a.cal();
    this.opm = (this.opq * a.getCompletelyCountPerPage() + 2);
    AppMethodBeat.o(49689);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public final void cax()
  {
    AppMethodBeat.i(49695);
    if (ld())
    {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49678);
          if (RecentAppBrandView.this.getAdapter() != null) {
            RecentAppBrandView.this.getAdapter().atj.notifyChanged();
          }
          AppMethodBeat.o(49678);
        }
      });
      AppMethodBeat.o(49695);
      return;
    }
    if (getAdapter() != null) {
      getAdapter().atj.notifyChanged();
    }
    AppMethodBeat.o(49695);
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(49697);
    int i = this.opg.size();
    AppMethodBeat.o(49697);
    return i;
  }
  
  public List<AppBrandDesktopView.c> getDataList()
  {
    return this.opg;
  }
  
  public int getMaxShowItemCountIncludeMore()
  {
    AppMethodBeat.i(49687);
    int i = this.opp;
    int j = a.getCompletelyCountPerPage();
    AppMethodBeat.o(49687);
    return i * j;
  }
  
  public int getShowCount()
  {
    AppMethodBeat.i(49696);
    int i = this.oph.size();
    AppMethodBeat.o(49696);
    return i;
  }
  
  public int getShowLines()
  {
    return this.opp;
  }
  
  public List<AppBrandDesktopView.c> getShowList()
  {
    return this.oph;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(49692);
    Log.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView onDown");
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
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    this.ooU = true;
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
    b localb = new b();
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    paramMotionEvent = o(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      paramMotionEvent = bu(paramMotionEvent);
      if (paramMotionEvent != null) {
        paramMotionEvent.aus.performClick();
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
      this.ooU = false;
      a(paramMotionEvent, true);
    }
    for (;;)
    {
      Object localObject = this.mDJ;
      paramMotionEvent = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, paramMotionEvent.axQ(), "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)paramMotionEvent.pG(0)), "com/tencent/mm/plugin/appbrand/widget/desktop/RecentAppBrandView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      if (this.ooU) {
        break;
      }
      AppMethodBeat.o(49690);
      return true;
      if (paramMotionEvent.getAction() != 2)
      {
        localObject = this.opi.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((RecyclerView.v)((Iterator)localObject).next()).aus.setPressed(false);
        }
        this.opi.clear();
      }
    }
    AppMethodBeat.o(49690);
    return false;
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    AppMethodBeat.i(49686);
    this.opg = paramList;
    this.oph.clear();
    zV(this.opg.size());
    int i = this.opp;
    int k = a.getCompletelyCountPerPage() * i;
    if (this.opg.size() == k) {}
    for (i = k;; i = k - 1)
    {
      int j = 0;
      while ((j < this.opg.size()) && (j < i))
      {
        this.oph.add(this.opg.get(j));
        j += 1;
      }
    }
    this.opn = true;
    Log.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView mDataList: %d, showCount: %d, maxShowCount: %d", new Object[] { Integer.valueOf(this.opg.size()), Integer.valueOf(this.oph.size()), Integer.valueOf(k) });
    AppMethodBeat.o(49686);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.omS = paramInt;
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.opo = paramb;
  }
  
  public void setReporter(g paramg)
  {
    this.onJ = paramg;
  }
  
  final void zV(int paramInt)
  {
    AppMethodBeat.i(49688);
    int k = a.getCompletelyCountPerPage();
    int j = paramInt / k;
    int i = j;
    if (paramInt % k != 0) {
      i = j + 1;
    }
    this.opp = Math.min(this.opq, i);
    Log.i("MicroMsg.RecentAppBrandView", "alvinluo configShowLines dataCount: %d, countPerLine: %d, currentShowLine: %d, maxShowLine: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(this.opp), Integer.valueOf(this.opq) });
    AppMethodBeat.o(49688);
  }
  
  public final AppBrandDesktopView.c zW(int paramInt)
  {
    AppMethodBeat.i(49698);
    AppBrandDesktopView.c localc = (AppBrandDesktopView.c)this.opg.get(paramInt);
    AppMethodBeat.o(49698);
    return localc;
  }
  
  final class a
    extends RecyclerView.a<d>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView
 * JD-Core Version:    0.7.0.1
 */