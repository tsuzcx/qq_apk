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
  protected List<a> maf = new LinkedList();
  private int mag = 0;
  
  public abstract void O(MotionEvent paramMotionEvent);
  
  public final void a(a parama)
  {
    if (!this.maf.contains(parama)) {
      this.maf.add(parama);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ad.i("MicroMsg.HeaderAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) });
    if (paramBoolean1)
    {
      hq(paramBoolean2);
      if ((this.mag & 0x2) == 0) {}
    }
    label195:
    for (;;)
    {
      return;
      this.mag |= 0x2;
      this.mag &= 0xFFFFFFFB;
      label72:
      Iterator localIterator = this.maf.iterator();
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
            locala.brX();
            continue;
            hr(paramBoolean2);
            if ((this.mag & 0x4) != 0) {
              break;
            }
            this.mag |= 0x4;
            this.mag &= 0xFFFFFFFD;
            break label72;
          }
          locala.brW();
          continue;
        }
        if (paramBoolean2) {
          locala.uG(paramInt);
        } else {
          locala.uF(paramInt);
        }
      }
    }
  }
  
  public void b(long paramLong, int paramInt, boolean paramBoolean) {}
  
  public abstract void bro();
  
  public void brs() {}
  
  public abstract boolean bru();
  
  public abstract boolean brv();
  
  public abstract void g(View paramView1, View paramView2);
  
  public abstract int getAnimationScrollOffset();
  
  public abstract void hV();
  
  protected void hq(boolean paramBoolean) {}
  
  protected void hr(boolean paramBoolean) {}
  
  public abstract void hs(boolean paramBoolean);
  
  public abstract void onDestroy();
  
  public void onResume() {}
  
  public abstract void setActionBar(View paramView);
  
  public abstract void setActionBarUpdateCallback(a parama);
  
  public void setIsCurrentMainUI(boolean paramBoolean) {}
  
  public abstract void setStatusBarMaskView(View paramView);
  
  public abstract void setTabView(View paramView);
  
  public abstract void uA(int paramInt);
  
  public final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, 0);
  }
  
  public static abstract interface a
  {
    public abstract void brW();
    
    public abstract void brX();
    
    public abstract void uF(int paramInt);
    
    public abstract void uG(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.c
 * JD-Core Version:    0.7.0.1
 */