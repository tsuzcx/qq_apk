package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class u
  implements a
{
  private static Integer nkf = null;
  private int njZ;
  private final int[] nka;
  private final Rect nkb;
  private boolean nkc;
  private View nkd;
  b nke;
  private final LinkedHashSet<c> nkg;
  
  public u()
  {
    AppMethodBeat.i(131506);
    this.njZ = 0;
    this.nka = new int[2];
    this.nkb = new Rect();
    this.nkc = false;
    this.nkg = new LinkedHashSet();
    AppMethodBeat.o(131506);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(131511);
    Iterator localIterator = ((LinkedHashSet)this.nkg.clone()).iterator();
    while (localIterator.hasNext()) {
      parama.c((c)localIterator.next());
    }
    AppMethodBeat.o(131511);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(131508);
    if (this.nkd == null)
    {
      localContext = ak.getContext();
      AppMethodBeat.o(131508);
      return localContext;
    }
    Context localContext = this.nkd.getContext();
    AppMethodBeat.o(131508);
    return localContext;
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(131509);
    if (this.nkd == null) {}
    for (Object localObject = null; localObject == null; localObject = this.nkd.getRootView())
    {
      AppMethodBeat.o(131509);
      return 0;
    }
    localObject = this.nkb;
    getWindowVisibleDisplayFrame((Rect)localObject);
    if (t.ay(this.nkd)) {}
    for (int i = this.nkd.getMeasuredHeight();; i = getContext().getResources().getDisplayMetrics().heightPixels)
    {
      int j = ((Rect)localObject).top;
      AppMethodBeat.o(131509);
      return i - j;
    }
  }
  
  private void getWindowVisibleDisplayFrame(Rect paramRect)
  {
    AppMethodBeat.i(131507);
    if (this.nkd != null)
    {
      this.nkd.getWindowVisibleDisplayFrame(paramRect);
      this.nkd.getLocationInWindow(this.nka);
      paramRect.top = this.nka[1];
    }
    AppMethodBeat.o(131507);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(131512);
    if ((paramc != null) && (!this.nkg.contains(paramc))) {
      this.nkg.add(paramc);
    }
    AppMethodBeat.o(131512);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(131513);
    if (paramc != null) {
      this.nkg.remove(paramc);
    }
    AppMethodBeat.o(131513);
  }
  
  public final void dh(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(131510);
    this.nkd = paramView;
    paramView = this.nkb;
    getWindowVisibleDisplayFrame(paramView);
    int k = paramView.height();
    final boolean bool;
    if (this.njZ == 0)
    {
      this.njZ = k;
      if (getFrameHeight() <= k) {
        break label242;
      }
      bool = true;
      label53:
      if (this.nkc == bool) {
        break label248;
      }
    }
    label242:
    label248:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        if (this.nke != null) {
          this.nke.bu(bool);
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
      this.nkc = bool;
      this.njZ = k;
      this.nkd = null;
      AppMethodBeat.o(131510);
      return;
      final int m = getFrameHeight() - k;
      if (m <= 0) {
        break;
      }
      paramView = getContext();
      if (m > 0)
      {
        if (nkf == null) {
          nkf = Integer.valueOf(aa.iN(paramView));
        }
        if (nkf.intValue() != m) {
          nkf = Integer.valueOf(m);
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
        if ((this.nke == null) || ((i == 0) && (this.nke.getHeight() == m))) {
          break;
        }
        this.nke.gB(m);
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