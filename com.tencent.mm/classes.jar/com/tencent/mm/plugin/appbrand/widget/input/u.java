package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.z;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class u
  implements a
{
  private static Integer neX = null;
  private int neR;
  private final int[] neS;
  private final Rect neT;
  private boolean neU;
  private View neV;
  b neW;
  private final LinkedHashSet<c> neY;
  
  public u()
  {
    AppMethodBeat.i(131506);
    this.neR = 0;
    this.neS = new int[2];
    this.neT = new Rect();
    this.neU = false;
    this.neY = new LinkedHashSet();
    AppMethodBeat.o(131506);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(131511);
    Iterator localIterator = ((LinkedHashSet)this.neY.clone()).iterator();
    while (localIterator.hasNext()) {
      parama.c((c)localIterator.next());
    }
    AppMethodBeat.o(131511);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(131508);
    if (this.neV == null)
    {
      localContext = aj.getContext();
      AppMethodBeat.o(131508);
      return localContext;
    }
    Context localContext = this.neV.getContext();
    AppMethodBeat.o(131508);
    return localContext;
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(131509);
    if (this.neV == null) {}
    for (Object localObject = null; localObject == null; localObject = this.neV.getRootView())
    {
      AppMethodBeat.o(131509);
      return 0;
    }
    localObject = this.neT;
    getWindowVisibleDisplayFrame((Rect)localObject);
    if (t.ay(this.neV)) {}
    for (int i = this.neV.getMeasuredHeight();; i = getContext().getResources().getDisplayMetrics().heightPixels)
    {
      int j = ((Rect)localObject).top;
      AppMethodBeat.o(131509);
      return i - j;
    }
  }
  
  private void getWindowVisibleDisplayFrame(Rect paramRect)
  {
    AppMethodBeat.i(131507);
    if (this.neV != null)
    {
      this.neV.getWindowVisibleDisplayFrame(paramRect);
      this.neV.getLocationInWindow(this.neS);
      paramRect.top = this.neS[1];
    }
    AppMethodBeat.o(131507);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(131512);
    if ((paramc != null) && (!this.neY.contains(paramc))) {
      this.neY.add(paramc);
    }
    AppMethodBeat.o(131512);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(131513);
    if (paramc != null) {
      this.neY.remove(paramc);
    }
    AppMethodBeat.o(131513);
  }
  
  public final void dh(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(131510);
    this.neV = paramView;
    paramView = this.neT;
    getWindowVisibleDisplayFrame(paramView);
    int k = paramView.height();
    final boolean bool;
    if (this.neR == 0)
    {
      this.neR = k;
      if (getFrameHeight() <= k) {
        break label242;
      }
      bool = true;
      label53:
      if (this.neU == bool) {
        break label248;
      }
    }
    label242:
    label248:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        if (this.neW != null) {
          this.neW.bu(bool);
        }
        a(new a()
        {
          public final void c(u.c paramAnonymousc)
          {
            AppMethodBeat.i(131505);
            paramAnonymousc.bu(bool);
            AppMethodBeat.o(131505);
          }
        });
      }
      this.neU = bool;
      this.neR = k;
      this.neV = null;
      AppMethodBeat.o(131510);
      return;
      final int m = getFrameHeight() - k;
      if (m <= 0) {
        break;
      }
      paramView = getContext();
      if (m > 0)
      {
        if (neX == null) {
          neX = Integer.valueOf(z.iI(paramView));
        }
        if (neX.intValue() != m) {
          neX = Integer.valueOf(m);
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
              paramAnonymousc.gB(m);
            }
            AppMethodBeat.o(131504);
          }
        });
        if ((this.neW == null) || ((i == 0) && (this.neW.getHeight() == m))) {
          break;
        }
        this.neW.gB(m);
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
    public abstract void bu(boolean paramBoolean);
    
    public abstract void gB(int paramInt);
    
    public abstract int getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.u
 * JD-Core Version:    0.7.0.1
 */