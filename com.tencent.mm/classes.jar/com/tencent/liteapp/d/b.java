package com.tencent.liteapp.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class b
  implements d
{
  private int ehP;
  private final int[] ehQ;
  private final Rect ehR;
  private boolean ehS;
  private View ehT;
  public final LinkedHashSet<b> ehU;
  
  public b()
  {
    AppMethodBeat.i(219066);
    this.ehP = 0;
    this.ehQ = new int[2];
    this.ehR = new Rect();
    this.ehS = false;
    this.ehU = new LinkedHashSet();
    AppMethodBeat.o(219066);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(219085);
    if (this.ehT == null)
    {
      localObject = com.tencent.liteapp.b.efD;
      localObject = com.tencent.liteapp.b.a.getAppContext();
      AppMethodBeat.o(219085);
      return localObject;
    }
    Object localObject = this.ehT.getContext();
    AppMethodBeat.o(219085);
    return localObject;
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(219098);
    if (this.ehT == null) {}
    for (Object localObject = null; localObject == null; localObject = this.ehT.getRootView())
    {
      AppMethodBeat.o(219098);
      return 0;
    }
    localObject = this.ehR;
    s((Rect)localObject);
    if (z.au(this.ehT)) {}
    for (int i = this.ehT.getMeasuredHeight();; i = getContext().getResources().getDisplayMetrics().heightPixels)
    {
      int j = ((Rect)localObject).top;
      AppMethodBeat.o(219098);
      return i - j;
    }
  }
  
  private void s(Rect paramRect)
  {
    AppMethodBeat.i(219073);
    if (this.ehT != null)
    {
      this.ehT.getWindowVisibleDisplayFrame(paramRect);
      this.ehT.getLocationInWindow(this.ehQ);
      paramRect.top = this.ehQ[1];
    }
    AppMethodBeat.o(219073);
  }
  
  public final void cN(View paramView)
  {
    final boolean bool = false;
    AppMethodBeat.i(219119);
    this.ehT = paramView;
    paramView = this.ehR;
    s(paramView);
    int j = paramView.height();
    if (!f.bg(getContext())) {}
    for (final int i = f.bk(getContext());; i = 0)
    {
      i = Math.max(getFrameHeight() - j - i, 0);
      if (f.bg(getContext()))
      {
        int k = f.bk(getContext());
        if (getFrameHeight() - k > j) {
          bool = true;
        }
      }
      while (this.ehS != bool)
      {
        paramView = new a()
        {
          public final void a(b.b paramAnonymousb)
          {
            AppMethodBeat.i(219058);
            paramAnonymousb.e(bool, i);
            AppMethodBeat.o(219058);
          }
        };
        Iterator localIterator = ((LinkedHashSet)this.ehU.clone()).iterator();
        while (localIterator.hasNext()) {
          paramView.a((b)localIterator.next());
        }
        if (getFrameHeight() > j) {
          bool = true;
        }
      }
      this.ehS = bool;
      this.ehT = null;
      AppMethodBeat.o(219119);
      return;
    }
  }
  
  static abstract interface a
  {
    public abstract void a(b.b paramb);
  }
  
  public static abstract interface b
  {
    public abstract void e(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteapp.d.b
 * JD-Core Version:    0.7.0.1
 */