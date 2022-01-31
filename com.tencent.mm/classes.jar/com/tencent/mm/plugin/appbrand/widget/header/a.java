package com.tencent.mm.plugin.appbrand.widget.header;

import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class a
  implements View.OnTouchListener, AbsListView.OnScrollListener
{
  protected List<a.a> hsO = new LinkedList();
  private int hsP = 0;
  
  public final void a(a.a parama)
  {
    if (!this.hsO.contains(parama)) {
      this.hsO.add(parama);
    }
  }
  
  public abstract void ard();
  
  public abstract void ce(View paramView);
  
  public abstract void cf(View paramView);
  
  public final void s(boolean paramBoolean1, boolean paramBoolean2)
  {
    y.i("alvinluo", "alvinluo notifyCallback isOpen: %b, isDrag: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if (paramBoolean1) {
      if ((this.hsP & 0x2) == 0) {}
    }
    label173:
    for (;;)
    {
      return;
      this.hsP |= 0x2;
      this.hsP &= 0xFFFFFFFB;
      label60:
      Iterator localIterator = this.hsO.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label173;
        }
        a.a locala = (a.a)localIterator.next();
        if (paramBoolean1)
        {
          if (paramBoolean2)
          {
            locala.aru();
            continue;
            if ((this.hsP & 0x4) != 0) {
              break;
            }
            this.hsP |= 0x4;
            this.hsP &= 0xFFFFFFFD;
            break label60;
          }
          locala.arr();
          continue;
        }
        if (paramBoolean2) {
          locala.art();
        } else {
          locala.ars();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.a
 * JD-Core Version:    0.7.0.1
 */