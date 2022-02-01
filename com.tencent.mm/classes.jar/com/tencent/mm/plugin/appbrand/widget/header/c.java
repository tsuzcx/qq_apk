package com.tencent.mm.plugin.appbrand.widget.header;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class c
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  protected List<a> nhO = new LinkedList();
  private int nhP = 0;
  
  public abstract void I(MotionEvent paramMotionEvent);
  
  public final void a(a parama)
  {
    if (!this.nhO.contains(parama)) {
      this.nhO.add(parama);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ae.i("MicroMsg.HeaderAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) });
    if (paramBoolean1)
    {
      hW(paramBoolean2);
      if ((this.nhP & 0x2) == 0) {}
    }
    label195:
    for (;;)
    {
      return;
      this.nhP |= 0x2;
      this.nhP &= 0xFFFFFFFB;
      label72:
      Iterator localIterator = this.nhO.iterator();
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
            locala.bDS();
            continue;
            hX(paramBoolean2);
            if ((this.nhP & 0x4) != 0) {
              break;
            }
            this.nhP |= 0x4;
            this.nhP &= 0xFFFFFFFD;
            break label72;
          }
          locala.bDR();
          continue;
        }
        if (paramBoolean2) {
          locala.wi(paramInt);
        } else {
          locala.wh(paramInt);
        }
      }
    }
  }
  
  public void b(long paramLong, int paramInt, boolean paramBoolean) {}
  
  public abstract void bDl();
  
  public void bDp() {}
  
  public abstract boolean bDr();
  
  public abstract boolean bDs();
  
  public abstract void g(View paramView1, View paramView2);
  
  public abstract int getAnimationScrollOffset();
  
  protected void hW(boolean paramBoolean) {}
  
  protected void hX(boolean paramBoolean) {}
  
  public abstract void hY(boolean paramBoolean);
  
  public abstract void iv();
  
  public abstract void onDestroy();
  
  public void onResume() {}
  
  public abstract void setActionBar(View paramView);
  
  public abstract void setActionBarUpdateCallback(a parama);
  
  public void setIsCurrentMainUI(boolean paramBoolean) {}
  
  public abstract void setStatusBarMaskView(View paramView);
  
  public abstract void setTabView(View paramView);
  
  public abstract void wc(int paramInt);
  
  public final void z(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, 0);
  }
  
  public static abstract interface a
  {
    public abstract void bDR();
    
    public abstract void bDS();
    
    public abstract void wh(int paramInt);
    
    public abstract void wi(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.c
 * JD-Core Version:    0.7.0.1
 */