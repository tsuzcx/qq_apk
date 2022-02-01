package com.tencent.liteapp.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class b
  implements c
{
  private int cpY;
  private final int[] cpZ;
  private final Rect cqa;
  private boolean cqb;
  private View cqc;
  private b cqd;
  public final LinkedHashSet<c> cqe;
  
  public b()
  {
    AppMethodBeat.i(258826);
    this.cpY = 0;
    this.cpZ = new int[2];
    this.cqa = new Rect();
    this.cqb = false;
    this.cqe = new LinkedHashSet();
    AppMethodBeat.o(258826);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(258833);
    Iterator localIterator = ((LinkedHashSet)this.cqe.clone()).iterator();
    while (localIterator.hasNext()) {
      parama.a((c)localIterator.next());
    }
    AppMethodBeat.o(258833);
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(258829);
    if (this.cqc == null) {}
    for (Object localObject = null; localObject == null; localObject = this.cqc.getRootView())
    {
      AppMethodBeat.o(258829);
      return 0;
    }
    Rect localRect = this.cqa;
    m(localRect);
    int i;
    if (w.ah(this.cqc))
    {
      i = this.cqc.getMeasuredHeight();
      int j = localRect.top;
      AppMethodBeat.o(258829);
      return i - j;
    }
    if (this.cqc == null) {
      localObject = com.tencent.liteapp.b.cox;
    }
    for (localObject = com.tencent.liteapp.b.a.getAppContext();; localObject = this.cqc.getContext())
    {
      i = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
      break;
    }
  }
  
  private void m(Rect paramRect)
  {
    AppMethodBeat.i(258827);
    if (this.cqc != null)
    {
      this.cqc.getWindowVisibleDisplayFrame(paramRect);
      this.cqc.getLocationInWindow(this.cpZ);
      paramRect.top = this.cpZ[1];
    }
    AppMethodBeat.o(258827);
  }
  
  public final void cr(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(258831);
    this.cqc = paramView;
    paramView = this.cqa;
    m(paramView);
    int j = paramView.height();
    final boolean bool;
    if (this.cpY == 0)
    {
      this.cpY = j;
      if (getFrameHeight() <= j) {
        break label179;
      }
      bool = true;
      label50:
      if (this.cqb == bool) {
        break label185;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.cqd != null) {
          this.cqd.ca(bool);
        }
        a(new a()
        {
          public final void a(b.c paramAnonymousc)
          {
            AppMethodBeat.i(258823);
            paramAnonymousc.ca(bool);
            AppMethodBeat.o(258823);
          }
        });
      }
      this.cqb = bool;
      this.cpY = j;
      this.cqc = null;
      AppMethodBeat.o(258831);
      return;
      final int k = getFrameHeight() - j;
      if (k <= 0) {
        break;
      }
      a(new a()
      {
        public final void a(b.c paramAnonymousc)
        {
          AppMethodBeat.i(258819);
          if (paramAnonymousc.getHeight() != k) {
            paramAnonymousc.iF(k);
          }
          AppMethodBeat.o(258819);
        }
      });
      if ((this.cqd == null) || (this.cqd.getHeight() == k)) {
        break;
      }
      this.cqd.iF(k);
      break;
      label179:
      bool = false;
      break label50;
      label185:
      i = 0;
    }
  }
  
  static abstract interface a
  {
    public abstract void a(b.c paramc);
  }
  
  static abstract interface b
    extends b.c
  {}
  
  public static abstract interface c
  {
    public abstract void ca(boolean paramBoolean);
    
    public abstract int getHeight();
    
    public abstract void iF(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteapp.d.b
 * JD-Core Version:    0.7.0.1
 */