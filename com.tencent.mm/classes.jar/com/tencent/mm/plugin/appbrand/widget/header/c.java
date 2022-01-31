package com.tencent.mm.plugin.appbrand.widget.header;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class c
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  protected List<c.a> jks = new LinkedList();
  private int jkt = 0;
  
  public abstract void J(MotionEvent paramMotionEvent);
  
  public final void a(c.a parama)
  {
    if (!this.jks.contains(parama)) {
      this.jks.add(parama);
    }
  }
  
  public abstract void aOR();
  
  public void aOV() {}
  
  public abstract boolean aOX();
  
  public abstract boolean aOY();
  
  public final void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    ab.i("MicroMsg.HeaderAnimController", "alvinluo notifyCallback isOpen: %b, isDrag: %b, reason: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) });
    if (paramBoolean1)
    {
      fc(paramBoolean2);
      if ((this.jkt & 0x2) == 0) {}
    }
    label195:
    for (;;)
    {
      return;
      this.jkt |= 0x2;
      this.jkt &= 0xFFFFFFFB;
      label72:
      Iterator localIterator = this.jks.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label195;
        }
        c.a locala = (c.a)localIterator.next();
        if (paramBoolean1)
        {
          if (paramBoolean2)
          {
            locala.aPy();
            continue;
            fd(paramBoolean2);
            if ((this.jkt & 0x4) != 0) {
              break;
            }
            this.jkt |= 0x4;
            this.jkt &= 0xFFFFFFFD;
            break label72;
          }
          locala.aPx();
          continue;
        }
        if (paramBoolean2) {
          locala.qc(paramInt);
        } else {
          locala.qb(paramInt);
        }
      }
    }
  }
  
  public void c(long paramLong, int paramInt, boolean paramBoolean) {}
  
  public abstract void e(View paramView1, View paramView2);
  
  protected void fc(boolean paramBoolean) {}
  
  protected void fd(boolean paramBoolean) {}
  
  public abstract void fe(boolean paramBoolean);
  
  public abstract void gA();
  
  public abstract int getAnimationScrollOffset();
  
  public abstract void onDestroy();
  
  public void onResume() {}
  
  public abstract void pW(int paramInt);
  
  public final void s(boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramBoolean1, paramBoolean2, 0);
  }
  
  public abstract void setActionBar(View paramView);
  
  public abstract void setActionBarUpdateCallback(a parama);
  
  public void setIsCurrentMainUI(boolean paramBoolean) {}
  
  public abstract void setStatusBarMaskView(View paramView);
  
  public abstract void setTabView(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.c
 * JD-Core Version:    0.7.0.1
 */