package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.f.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class u
  implements a
{
  private static Integer uHb = null;
  private int ehP;
  private final int[] ehQ;
  private final Rect ehR;
  private boolean ehS;
  private View ehT;
  private final LinkedHashSet<c> ehU;
  public int uGY;
  ap uGZ;
  b uHa;
  
  u()
  {
    AppMethodBeat.i(131506);
    this.uGY = 1;
    this.ehP = 0;
    this.ehQ = new int[2];
    this.ehR = new Rect();
    this.ehS = false;
    this.ehU = new LinkedHashSet();
    AppMethodBeat.o(131506);
  }
  
  private static boolean Z(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(324542);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(324542);
      return false;
    }
    if (uHb == null) {
      uHb = Integer.valueOf(KeyBoardUtil.getValidPanelHeight(paramContext));
    }
    if (uHb.intValue() != paramInt)
    {
      uHb = Integer.valueOf(paramInt);
      AppMethodBeat.o(324542);
      return true;
    }
    AppMethodBeat.o(324542);
    return false;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(131511);
    Iterator localIterator = ((LinkedHashSet)this.ehU.clone()).iterator();
    while (localIterator.hasNext()) {
      parama.c((c)localIterator.next());
    }
    AppMethodBeat.o(131511);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(131508);
    if (this.ehT == null)
    {
      localContext = MMApplicationContext.getContext();
      AppMethodBeat.o(131508);
      return localContext;
    }
    Context localContext = this.ehT.getContext();
    AppMethodBeat.o(131508);
    return localContext;
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(131509);
    if (this.ehT == null) {}
    for (Object localObject = null; localObject == null; localObject = this.ehT.getRootView())
    {
      AppMethodBeat.o(131509);
      return 0;
    }
    localObject = this.ehR;
    s((Rect)localObject);
    if (z.au(this.ehT)) {}
    for (int i = this.ehT.getMeasuredHeight();; i = getContext().getResources().getDisplayMetrics().heightPixels)
    {
      int j = ((Rect)localObject).top;
      AppMethodBeat.o(131509);
      return i - j;
    }
  }
  
  public static int getValidPanelHeight(Context paramContext)
  {
    AppMethodBeat.i(324546);
    if (uHb == null) {
      uHb = Integer.valueOf(KeyBoardUtil.getValidPanelHeight(paramContext));
    }
    int i = uHb.intValue();
    AppMethodBeat.o(324546);
    return i;
  }
  
  private void lE(boolean paramBoolean)
  {
    AppMethodBeat.i(324538);
    if (this.uHa != null) {
      this.uHa.cK(paramBoolean);
    }
    AppMethodBeat.o(324538);
  }
  
  private void s(Rect paramRect)
  {
    AppMethodBeat.i(131507);
    if (this.ehT != null)
    {
      this.ehT.getWindowVisibleDisplayFrame(paramRect);
      this.ehT.getLocationInWindow(this.ehQ);
      paramRect.top = this.ehQ[1];
    }
    AppMethodBeat.o(131507);
  }
  
  public final void Ep(int paramInt)
  {
    AppMethodBeat.i(324575);
    this.uGY = paramInt;
    switch (this.uGY)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(324575);
      return;
      if (this.uGZ != null)
      {
        this.uGZ.close();
        this.uGZ.cRO();
        AppMethodBeat.o(324575);
        return;
        if (this.uGZ == null)
        {
          this.uGY = 1;
          AppMethodBeat.o(324575);
          return;
        }
        this.uGZ.cRN();
        this.uGZ.start();
      }
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(131512);
    if ((paramc != null) && (!this.ehU.contains(paramc))) {
      this.ehU.add(paramc);
    }
    AppMethodBeat.o(131512);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(131513);
    if (paramc != null) {
      this.ehU.remove(paramc);
    }
    AppMethodBeat.o(131513);
  }
  
  public final void cN(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(131510);
    this.ehT = paramView;
    if (1 != this.uGY)
    {
      AppMethodBeat.o(131510);
      return;
    }
    paramView = this.ehR;
    s(paramView);
    int j = paramView.height();
    if (this.ehP == 0) {
      this.ehP = j;
    }
    final int k = getFrameHeight() - j;
    final boolean bool;
    if (k > 0)
    {
      bool = Z(getContext(), k);
      a(new a()
      {
        public final void c(u.c paramAnonymousc)
        {
          AppMethodBeat.i(131504);
          if (paramAnonymousc.getHeight() != k) {
            paramAnonymousc.mo(k);
          }
          AppMethodBeat.o(131504);
        }
      });
      if ((this.uHa != null) && ((bool) || (this.uHa.getHeight() != k))) {
        this.uHa.mo(k);
      }
    }
    if (getFrameHeight() > j)
    {
      bool = true;
      if (this.ehS == bool) {
        break label200;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        lE(bool);
        a(new a()
        {
          public final void c(u.c paramAnonymousc)
          {
            AppMethodBeat.i(131505);
            paramAnonymousc.cK(bool);
            AppMethodBeat.o(131505);
          }
        });
      }
      this.ehS = bool;
      this.ehP = j;
      this.ehT = null;
      AppMethodBeat.o(131510);
      return;
      bool = false;
      break;
      label200:
      i = 0;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(324583);
    if (this.uGZ != null)
    {
      this.uGZ.close();
      this.uGZ.cRO();
      this.uGZ.uJd = null;
    }
    AppMethodBeat.o(324583);
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
    public abstract void cK(boolean paramBoolean);
    
    public abstract int getHeight();
    
    public abstract void mo(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.u
 * JD-Core Version:    0.7.0.1
 */