package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class u
  implements a
{
  private static Integer mEy = null;
  private int mEs;
  private final int[] mEt;
  private final Rect mEu;
  private boolean mEv;
  private View mEw;
  b mEx;
  private final LinkedHashSet<c> mEz;
  
  public u()
  {
    AppMethodBeat.i(131506);
    this.mEs = 0;
    this.mEt = new int[2];
    this.mEu = new Rect();
    this.mEv = false;
    this.mEz = new LinkedHashSet();
    AppMethodBeat.o(131506);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(131511);
    Iterator localIterator = ((LinkedHashSet)this.mEz.clone()).iterator();
    while (localIterator.hasNext()) {
      parama.c((c)localIterator.next());
    }
    AppMethodBeat.o(131511);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(131508);
    if (this.mEw == null)
    {
      localContext = ai.getContext();
      AppMethodBeat.o(131508);
      return localContext;
    }
    Context localContext = this.mEw.getContext();
    AppMethodBeat.o(131508);
    return localContext;
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(131509);
    if (this.mEw == null) {}
    for (Object localObject = null; localObject == null; localObject = this.mEw.getRootView())
    {
      AppMethodBeat.o(131509);
      return 0;
    }
    localObject = this.mEu;
    getWindowVisibleDisplayFrame((Rect)localObject);
    if (t.ay(this.mEw)) {}
    for (int i = this.mEw.getMeasuredHeight();; i = getContext().getResources().getDisplayMetrics().heightPixels)
    {
      int j = ((Rect)localObject).top;
      AppMethodBeat.o(131509);
      return i - j;
    }
  }
  
  private void getWindowVisibleDisplayFrame(Rect paramRect)
  {
    AppMethodBeat.i(131507);
    if (this.mEw != null)
    {
      this.mEw.getWindowVisibleDisplayFrame(paramRect);
      this.mEw.getLocationInWindow(this.mEt);
      paramRect.top = this.mEt[1];
    }
    AppMethodBeat.o(131507);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(131512);
    if ((paramc != null) && (!this.mEz.contains(paramc))) {
      this.mEz.add(paramc);
    }
    AppMethodBeat.o(131512);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(131513);
    if (paramc != null) {
      this.mEz.remove(paramc);
    }
    AppMethodBeat.o(131513);
  }
  
  public final void df(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(131510);
    this.mEw = paramView;
    paramView = this.mEu;
    getWindowVisibleDisplayFrame(paramView);
    int k = paramView.height();
    final boolean bool;
    if (this.mEs == 0)
    {
      this.mEs = k;
      if (getFrameHeight() <= k) {
        break label242;
      }
      bool = true;
      label53:
      if (this.mEv == bool) {
        break label248;
      }
    }
    label242:
    label248:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        if (this.mEx != null) {
          this.mEx.bt(bool);
        }
        a(new a()
        {
          public final void c(u.c paramAnonymousc)
          {
            AppMethodBeat.i(131505);
            paramAnonymousc.bt(bool);
            AppMethodBeat.o(131505);
          }
        });
      }
      this.mEv = bool;
      this.mEs = k;
      this.mEw = null;
      AppMethodBeat.o(131510);
      return;
      final int m = getFrameHeight() - k;
      if (m <= 0) {
        break;
      }
      paramView = getContext();
      if (m > 0)
      {
        if (mEy == null) {
          mEy = Integer.valueOf(y.iy(paramView));
        }
        if (mEy.intValue() != m) {
          mEy = Integer.valueOf(m);
        }
      }
      for (i = 1;; i = 0)
      {
        a(new a()
        {
          public final void c(u.c paramAnonymousc)
          {
            AppMethodBeat.i(131504);
            if (paramAnonymousc.getHeight() != m) {
              paramAnonymousc.gw(m);
            }
            AppMethodBeat.o(131504);
          }
        });
        if ((this.mEx == null) || ((i == 0) && (this.mEx.getHeight() == m))) {
          break;
        }
        this.mEx.gw(m);
        break;
      }
      bool = false;
      break label53;
    }
  }
  
  static abstract interface a
  {
    public abstract void c(u.c paramc);
  }
  
  static abstract interface b
    extends u.c
  {}
  
  public static abstract interface c
  {
    public abstract void bt(boolean paramBoolean);
    
    public abstract int getHeight();
    
    public abstract void gw(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.u
 * JD-Core Version:    0.7.0.1
 */