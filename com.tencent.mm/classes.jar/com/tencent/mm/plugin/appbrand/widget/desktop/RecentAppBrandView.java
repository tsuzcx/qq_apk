package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentAppBrandView
  extends RecyclerView
  implements GestureDetector.OnGestureListener
{
  private GestureDetector gEU;
  private List<AppBrandDesktopView.a> heL = new ArrayList();
  private boolean hqZ = false;
  private ArrayList<RecyclerView.v> hra = new ArrayList();
  private int hrb = 0;
  private boolean hrc = false;
  
  public RecentAppBrandView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public RecentAppBrandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    if (paramBoolean == this.hrc) {
      return;
    }
    paramMotionEvent = y(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      paramMotionEvent = be(paramMotionEvent);
      if (paramMotionEvent != null)
      {
        paramMotionEvent.aie.setPressed(paramBoolean);
        if (!paramBoolean) {
          break label70;
        }
        y.i("MicroMsg.RecentAppBrandView", "alvinluo add pressed item");
        this.hra.add(paramMotionEvent);
      }
    }
    for (;;)
    {
      this.hrc = paramBoolean;
      return;
      label70:
      y.i("MicroMsg.RecentAppBrandView", "alvinluo remove pressed item");
      this.hra.remove(paramMotionEvent);
    }
  }
  
  private void init(Context paramContext)
  {
    setLayoutManager(new GridLayoutManager());
    setAdapter(new RecentAppBrandView.a(this));
    this.gEU = new GestureDetector(paramContext, this);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    y.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView onDown");
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
    this.hqZ = true;
    a(paramMotionEvent, false);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = y(paramMotionEvent.getX(), paramMotionEvent.getY());
    if (paramMotionEvent != null)
    {
      paramMotionEvent = be(paramMotionEvent);
      if (paramMotionEvent != null) {
        paramMotionEvent.aie.performClick();
      }
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    y.i("MicroMsg.RecentAppBrandView", "alvinluo onTouchEvent %d", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    if (paramMotionEvent.getAction() == 0)
    {
      this.hqZ = false;
      a(paramMotionEvent, true);
    }
    for (;;)
    {
      this.gEU.onTouchEvent(paramMotionEvent);
      if (this.hqZ) {
        break;
      }
      return true;
      if (paramMotionEvent.getAction() != 2)
      {
        y.i("MicroMsg.RecentAppBrandView", "alvinluo resetAllItems: %d", new Object[] { Integer.valueOf(this.hra.size()) });
        Iterator localIterator = this.hra.iterator();
        while (localIterator.hasNext()) {
          ((RecyclerView.v)localIterator.next()).aie.setPressed(false);
        }
        this.hra.clear();
      }
    }
    return false;
  }
  
  public void setDataList(List<AppBrandDesktopView.a> paramList)
  {
    this.heL = paramList;
  }
  
  public void setItemPadding(int paramInt)
  {
    this.hrb = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView
 * JD-Core Version:    0.7.0.1
 */