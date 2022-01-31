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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentAppBrandView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private RecyclerView.a Tg;
  private GestureDetector idY;
  private int jdO;
  private b jeK;
  private boolean jfJ;
  List<AppBrandDesktopView.c> jfV;
  List<AppBrandDesktopView.c> jfW;
  private ArrayList<RecyclerView.v> jfX;
  private GridLayoutManager jfY;
  private int jfZ;
  private f jga;
  int jgb;
  boolean jgc;
  private b jgd;
  private boolean jge;
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133936);
    this.jfV = new ArrayList();
    this.jfW = new ArrayList();
    this.jfX = new ArrayList();
    this.jdO = 0;
    this.Tg = null;
    this.jfY = null;
    this.jfZ = 0;
    this.jgb = 10;
    this.jgc = true;
    this.jfJ = false;
    this.jge = false;
    init(paramContext);
    AppMethodBeat.o(133936);
  }
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133937);
    this.jfV = new ArrayList();
    this.jfW = new ArrayList();
    this.jfX = new ArrayList();
    this.jdO = 0;
    this.Tg = null;
    this.jfY = null;
    this.jfZ = 0;
    this.jgb = 10;
    this.jgc = true;
    this.jfJ = false;
    this.jge = false;
    init(paramContext);
    AppMethodBeat.o(133937);
  }
  
  private void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    AppMethodBeat.i(133941);
    if (paramBoolean == this.jge)
    {
      AppMethodBeat.o(133941);
      return;
    }
    paramMotionEvent = x(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      paramMotionEvent = bo(paramMotionEvent);
      if (paramMotionEvent != null)
      {
        paramMotionEvent.aku.setPressed(paramBoolean);
        if (!paramBoolean) {
          break label85;
        }
        ab.i("MicroMsg.RecentAppBrandView", "alvinluo add pressed item");
        this.jfX.add(paramMotionEvent);
      }
    }
    for (;;)
    {
      this.jge = paramBoolean;
      AppMethodBeat.o(133941);
      return;
      label85:
      ab.i("MicroMsg.RecentAppBrandView", "alvinluo remove pressed item");
      this.jfX.remove(paramMotionEvent);
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(133939);
    this.jfY = new GridLayoutManager(4, (byte)0);
    setLayoutManager(this.jfY);
    this.Tg = new RecentAppBrandView.a(this);
    setAdapter(this.Tg);
    this.idY = new GestureDetector(paramContext, this);
    this.jga = new f();
    this.jga.Tg = this.Tg;
    setItemAnimator(this.jga);
    AppMethodBeat.o(133939);
  }
  
  public final void aPD()
  {
    AppMethodBeat.i(133945);
    if (jd())
    {
      post(new RecentAppBrandView.1(this));
      AppMethodBeat.o(133945);
      return;
    }
    if (getAdapter() != null) {
      getAdapter().ajb.notifyChanged();
    }
    AppMethodBeat.o(133945);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(133947);
    int i = this.jfV.size();
    AppMethodBeat.o(133947);
    return i;
  }
  
  public List<AppBrandDesktopView.c> getDataList()
  {
    return this.jfV;
  }
  
  public int getShowCount()
  {
    AppMethodBeat.i(133946);
    int i = this.jfW.size();
    AppMethodBeat.o(133946);
    return i;
  }
  
  public List<AppBrandDesktopView.c> getShowList()
  {
    return this.jfW;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(133942);
    ab.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView onDown");
    AppMethodBeat.o(133942);
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
    AppMethodBeat.i(133944);
    this.jfJ = true;
    a(paramMotionEvent, false);
    AppMethodBeat.o(133944);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(133943);
    paramMotionEvent = x(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      paramMotionEvent = bo(paramMotionEvent);
      if (paramMotionEvent != null) {
        paramMotionEvent.aku.performClick();
      }
    }
    AppMethodBeat.o(133943);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(133940);
    if (paramMotionEvent.getAction() == 0)
    {
      this.jfJ = false;
      a(paramMotionEvent, true);
    }
    for (;;)
    {
      this.idY.onTouchEvent(paramMotionEvent);
      if (this.jfJ) {
        break;
      }
      AppMethodBeat.o(133940);
      return true;
      if (paramMotionEvent.getAction() != 2)
      {
        Iterator localIterator = this.jfX.iterator();
        while (localIterator.hasNext()) {
          ((RecyclerView.v)localIterator.next()).aku.setPressed(false);
        }
        this.jfX.clear();
      }
    }
    AppMethodBeat.o(133940);
    return false;
  }
  
  public final AppBrandDesktopView.c qe(int paramInt)
  {
    AppMethodBeat.i(133948);
    AppBrandDesktopView.c localc = (AppBrandDesktopView.c)this.jfV.get(paramInt);
    AppMethodBeat.o(133948);
    return localc;
  }
  
  public void setDataList(List<AppBrandDesktopView.c> paramList)
  {
    int i = 4;
    AppMethodBeat.i(133938);
    this.jfV = paramList;
    this.jfW.clear();
    if (this.jfV.size() == 4) {}
    for (;;)
    {
      int j = 0;
      while ((j < this.jfV.size()) && (j < i))
      {
        this.jfW.add(this.jfV.get(j));
        j += 1;
      }
      i = 3;
    }
    this.jgc = true;
    ab.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView mDataList: %d, showList: %d", new Object[] { Integer.valueOf(this.jfV.size()), Integer.valueOf(this.jfW.size()) });
    AppMethodBeat.o(133938);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.jdO = paramInt;
  }
  
  public void setOnItemClickListener(b paramb)
  {
    this.jgd = paramb;
  }
  
  public void setReporter(b paramb)
  {
    this.jeK = paramb;
  }
  
  public static abstract interface b
  {
    public abstract void a(RecyclerView.v paramv, AppBrandDesktopView.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView
 * JD-Core Version:    0.7.0.1
 */