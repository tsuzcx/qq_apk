package com.tencent.liteapp.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.liteapp.a;
import com.tencent.liteapp.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class b
  implements c
{
  private int crS;
  private final int[] crT;
  private final Rect crU;
  private boolean crV;
  private View crW;
  private b crX;
  public final LinkedHashSet<c> crY;
  
  public b()
  {
    AppMethodBeat.i(197799);
    this.crS = 0;
    this.crT = new int[2];
    this.crU = new Rect();
    this.crV = false;
    this.crY = new LinkedHashSet();
    AppMethodBeat.o(197799);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(197803);
    Iterator localIterator = ((LinkedHashSet)this.crY.clone()).iterator();
    while (localIterator.hasNext()) {
      parama.a((c)localIterator.next());
    }
    AppMethodBeat.o(197803);
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(197801);
    if (this.crW == null) {}
    for (Object localObject = null; localObject == null; localObject = this.crW.getRootView())
    {
      AppMethodBeat.o(197801);
      return 0;
    }
    Rect localRect = this.crU;
    getWindowVisibleDisplayFrame(localRect);
    int i;
    if (u.az(this.crW))
    {
      i = this.crW.getMeasuredHeight();
      int j = localRect.top;
      AppMethodBeat.o(197801);
      return i - j;
    }
    if (this.crW == null) {
      localObject = a.cqJ;
    }
    for (localObject = a.a.getAppContext();; localObject = this.crW.getContext())
    {
      i = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
      break;
    }
  }
  
  private void getWindowVisibleDisplayFrame(Rect paramRect)
  {
    AppMethodBeat.i(197800);
    if (this.crW != null)
    {
      this.crW.getWindowVisibleDisplayFrame(paramRect);
      this.crW.getLocationInWindow(this.crT);
      paramRect.top = this.crT[1];
    }
    AppMethodBeat.o(197800);
  }
  
  public final void bZ(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(197802);
    this.crW = paramView;
    paramView = this.crU;
    getWindowVisibleDisplayFrame(paramView);
    int j = paramView.height();
    final boolean bool;
    if (this.crS == 0)
    {
      this.crS = j;
      if (getFrameHeight() <= j) {
        break label179;
      }
      bool = true;
      label50:
      if (this.crV == bool) {
        break label185;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (this.crX != null) {
          this.crX.bQ(bool);
        }
        a(new a()
        {
          public final void a(b.c paramAnonymousc)
          {
            AppMethodBeat.i(197798);
            paramAnonymousc.bQ(bool);
            AppMethodBeat.o(197798);
          }
        });
      }
      this.crV = bool;
      this.crS = j;
      this.crW = null;
      AppMethodBeat.o(197802);
      return;
      final int k = getFrameHeight() - j;
      if (k <= 0) {
        break;
      }
      a(new a()
      {
        public final void a(b.c paramAnonymousc)
        {
          AppMethodBeat.i(197797);
          if (paramAnonymousc.getHeight() != k) {
            paramAnonymousc.hF(k);
          }
          AppMethodBeat.o(197797);
        }
      });
      if ((this.crX == null) || (this.crX.getHeight() == k)) {
        break;
      }
      this.crX.hF(k);
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
    public abstract void bQ(boolean paramBoolean);
    
    public abstract int getHeight();
    
    public abstract void hF(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteapp.d.b
 * JD-Core Version:    0.7.0.1
 */