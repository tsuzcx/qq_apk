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
  private static Integer mcA = null;
  private final LinkedHashSet<c> mcB;
  private int mcu;
  private final int[] mcv;
  private final Rect mcw;
  private boolean mcx;
  private View mcy;
  b mcz;
  
  public u()
  {
    AppMethodBeat.i(131506);
    this.mcu = 0;
    this.mcv = new int[2];
    this.mcw = new Rect();
    this.mcx = false;
    this.mcB = new LinkedHashSet();
    AppMethodBeat.o(131506);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(131511);
    Iterator localIterator = ((LinkedHashSet)this.mcB.clone()).iterator();
    while (localIterator.hasNext()) {
      parama.c((c)localIterator.next());
    }
    AppMethodBeat.o(131511);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(131508);
    if (this.mcy == null)
    {
      localContext = aj.getContext();
      AppMethodBeat.o(131508);
      return localContext;
    }
    Context localContext = this.mcy.getContext();
    AppMethodBeat.o(131508);
    return localContext;
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(131509);
    if (this.mcy == null) {}
    for (Object localObject = null; localObject == null; localObject = this.mcy.getRootView())
    {
      AppMethodBeat.o(131509);
      return 0;
    }
    localObject = this.mcw;
    getWindowVisibleDisplayFrame((Rect)localObject);
    if (t.ay(this.mcy)) {}
    for (int i = this.mcy.getMeasuredHeight();; i = getContext().getResources().getDisplayMetrics().heightPixels)
    {
      int j = ((Rect)localObject).top;
      AppMethodBeat.o(131509);
      return i - j;
    }
  }
  
  private void getWindowVisibleDisplayFrame(Rect paramRect)
  {
    AppMethodBeat.i(131507);
    if (this.mcy != null)
    {
      this.mcy.getWindowVisibleDisplayFrame(paramRect);
      this.mcy.getLocationInWindow(this.mcv);
      paramRect.top = this.mcv[1];
    }
    AppMethodBeat.o(131507);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(131512);
    if ((paramc != null) && (!this.mcB.contains(paramc))) {
      this.mcB.add(paramc);
    }
    AppMethodBeat.o(131512);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(131513);
    if (paramc != null) {
      this.mcB.remove(paramc);
    }
    AppMethodBeat.o(131513);
  }
  
  public final void dd(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(131510);
    this.mcy = paramView;
    paramView = this.mcw;
    getWindowVisibleDisplayFrame(paramView);
    int k = paramView.height();
    final boolean bool;
    if (this.mcu == 0)
    {
      this.mcu = k;
      if (getFrameHeight() <= k) {
        break label242;
      }
      bool = true;
      label53:
      if (this.mcx == bool) {
        break label248;
      }
    }
    label242:
    label248:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        if (this.mcz != null) {
          this.mcz.bu(bool);
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
      this.mcx = bool;
      this.mcu = k;
      this.mcy = null;
      AppMethodBeat.o(131510);
      return;
      final int m = getFrameHeight() - k;
      if (m <= 0) {
        break;
      }
      paramView = getContext();
      if (m > 0)
      {
        if (mcA == null) {
          mcA = Integer.valueOf(z.in(paramView));
        }
        if (mcA.intValue() != m) {
          mcA = Integer.valueOf(m);
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
              paramAnonymousc.gM(m);
            }
            AppMethodBeat.o(131504);
          }
        });
        if ((this.mcz == null) || ((i == 0) && (this.mcz.getHeight() == m))) {
          break;
        }
        this.mcz.gM(m);
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
    
    public abstract void gM(int paramInt);
    
    public abstract int getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.u
 * JD-Core Version:    0.7.0.1
 */