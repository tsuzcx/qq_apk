package com.tencent.mm.plugin.appbrand.widget.header;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class c
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  protected List<a> ncF = new LinkedList();
  private int ncG = 0;
  
  public abstract void K(MotionEvent paramMotionEvent);
  
  public final void a(a parama)
  {
    if (!this.ncF.contains(parama)) {
      this.ncF.add(parama);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ad.i("MicroMsg.HeaderAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) });
    if (paramBoolean1)
    {
      hY(paramBoolean2);
      if ((this.ncG & 0x2) == 0) {}
    }
    label195:
    for (;;)
    {
      return;
      this.ncG |= 0x2;
      this.ncG &= 0xFFFFFFFB;
      label72:
      Iterator localIterator = this.ncF.iterator();
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
            locala.bDa();
            continue;
            hZ(paramBoolean2);
            if ((this.ncG & 0x4) != 0) {
              break;
            }
            this.ncG |= 0x4;
            this.ncG &= 0xFFFFFFFD;
            break label72;
          }
          locala.bCZ();
          continue;
        }
        if (paramBoolean2) {
          locala.wd(paramInt);
        } else {
          locala.wc(paramInt);
        }
      }
    }
  }
  
  public void b(long paramLong, int paramInt, boolean paramBoolean) {}
  
  public abstract boolean bCA();
  
  public abstract void bCt();
  
  public void bCx() {}
  
  public abstract boolean bCz();
  
  public abstract void g(View paramView1, View paramView2);
  
  public abstract int getAnimationScrollOffset();
  
  protected void hY(boolean paramBoolean) {}
  
  protected void hZ(boolean paramBoolean) {}
  
  public abstract void ia(boolean paramBoolean);
  
  public abstract void iv();
  
  public abstract void onDestroy();
  
  public void onResume() {}
  
  public abstract void setActionBar(View paramView);
  
  public abstract void setActionBarUpdateCallback(a parama);
  
  public void setIsCurrentMainUI(boolean paramBoolean) {}
  
  public abstract void setStatusBarMaskView(View paramView);
  
  public abstract void setTabView(View paramView);
  
  public abstract void vX(int paramInt);
  
  public final void z(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, 0);
  }
  
  public static abstract interface a
  {
    public abstract void bCZ();
    
    public abstract void bDa();
    
    public abstract void wc(int paramInt);
    
    public abstract void wd(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.c
 * JD-Core Version:    0.7.0.1
 */