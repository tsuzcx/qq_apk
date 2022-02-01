package com.tencent.mm.plugin.appbrand.widget.header;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class c
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  protected List<a> mCf = new LinkedList();
  private int mCg = 0;
  
  public abstract void M(MotionEvent paramMotionEvent);
  
  public final void a(a parama)
  {
    if (!this.mCf.contains(parama)) {
      this.mCf.add(parama);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ac.i("MicroMsg.HeaderAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) });
    if (paramBoolean1)
    {
      hO(paramBoolean2);
      if ((this.mCg & 0x2) == 0) {}
    }
    label195:
    for (;;)
    {
      return;
      this.mCg |= 0x2;
      this.mCg &= 0xFFFFFFFB;
      label72:
      Iterator localIterator = this.mCf.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label195;
        }
        a locala = (a)localIterator.next();
        if (paramBoolean1)
        {
          if (paramBoolean2)
          {
            locala.byX();
            continue;
            hP(paramBoolean2);
            if ((this.mCg & 0x4) != 0) {
              break;
            }
            this.mCg |= 0x4;
            this.mCg &= 0xFFFFFFFD;
            break label72;
          }
          locala.byW();
          continue;
        }
        if (paramBoolean2) {
          locala.vx(paramInt);
        } else {
          locala.vw(paramInt);
        }
      }
    }
  }
  
  public void b(long paramLong, int paramInt, boolean paramBoolean) {}
  
  public abstract void byo();
  
  public void bys() {}
  
  public abstract boolean byu();
  
  public abstract boolean byv();
  
  public abstract void g(View paramView1, View paramView2);
  
  public abstract int getAnimationScrollOffset();
  
  protected void hO(boolean paramBoolean) {}
  
  protected void hP(boolean paramBoolean) {}
  
  public abstract void hQ(boolean paramBoolean);
  
  public abstract void ie();
  
  public abstract void onDestroy();
  
  public void onResume() {}
  
  public abstract void setActionBar(View paramView);
  
  public abstract void setActionBarUpdateCallback(a parama);
  
  public void setIsCurrentMainUI(boolean paramBoolean) {}
  
  public abstract void setStatusBarMaskView(View paramView);
  
  public abstract void setTabView(View paramView);
  
  public abstract void vr(int paramInt);
  
  public final void z(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, 0);
  }
  
  public static abstract interface a
  {
    public abstract void byW();
    
    public abstract void byX();
    
    public abstract void vw(int paramInt);
    
    public abstract void vx(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.c
 * JD-Core Version:    0.7.0.1
 */