package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.d.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class u
  implements a
{
  private static Integer otI = null;
  private int crS;
  private final int[] crT;
  private final Rect crU;
  private boolean crV;
  private View crW;
  private final LinkedHashSet<c> crY;
  b otH;
  
  public u()
  {
    AppMethodBeat.i(131506);
    this.crS = 0;
    this.crT = new int[2];
    this.crU = new Rect();
    this.crV = false;
    this.crY = new LinkedHashSet();
    AppMethodBeat.o(131506);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(131511);
    Iterator localIterator = ((LinkedHashSet)this.crY.clone()).iterator();
    while (localIterator.hasNext()) {
      parama.c((c)localIterator.next());
    }
    AppMethodBeat.o(131511);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(131508);
    if (this.crW == null)
    {
      localContext = MMApplicationContext.getContext();
      AppMethodBeat.o(131508);
      return localContext;
    }
    Context localContext = this.crW.getContext();
    AppMethodBeat.o(131508);
    return localContext;
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(131509);
    if (this.crW == null) {}
    for (Object localObject = null; localObject == null; localObject = this.crW.getRootView())
    {
      AppMethodBeat.o(131509);
      return 0;
    }
    localObject = this.crU;
    getWindowVisibleDisplayFrame((Rect)localObject);
    if (android.support.v4.view.u.az(this.crW)) {}
    for (int i = this.crW.getMeasuredHeight();; i = getContext().getResources().getDisplayMetrics().heightPixels)
    {
      int j = ((Rect)localObject).top;
      AppMethodBeat.o(131509);
      return i - j;
    }
  }
  
  private void getWindowVisibleDisplayFrame(Rect paramRect)
  {
    AppMethodBeat.i(131507);
    if (this.crW != null)
    {
      this.crW.getWindowVisibleDisplayFrame(paramRect);
      this.crW.getLocationInWindow(this.crT);
      paramRect.top = this.crT[1];
    }
    AppMethodBeat.o(131507);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(131512);
    if ((paramc != null) && (!this.crY.contains(paramc))) {
      this.crY.add(paramc);
    }
    AppMethodBeat.o(131512);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(131513);
    if (paramc != null) {
      this.crY.remove(paramc);
    }
    AppMethodBeat.o(131513);
  }
  
  public final void bZ(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(131510);
    this.crW = paramView;
    paramView = this.crU;
    getWindowVisibleDisplayFrame(paramView);
    int k = paramView.height();
    if (this.crS == 0) {
      this.crS = k;
    }
    final int m = getFrameHeight() - k;
    if (m > 0)
    {
      paramView = getContext();
      if (m <= 0) {
        break label234;
      }
      if (otI == null) {
        otI = Integer.valueOf(KeyBoardUtil.getValidPanelHeight(paramView));
      }
      if (otI.intValue() == m) {
        break label234;
      }
      otI = Integer.valueOf(m);
      i = 1;
      a(new a()
      {
        public final void c(u.c paramAnonymousc)
        {
          AppMethodBeat.i(131504);
          if (paramAnonymousc.getHeight() != m) {
            paramAnonymousc.hF(m);
          }
          AppMethodBeat.o(131504);
        }
      });
      if ((this.otH != null) && ((i != 0) || (this.otH.getHeight() != m))) {
        this.otH.hF(m);
      }
    }
    final boolean bool;
    if (getFrameHeight() > k)
    {
      bool = true;
      label164:
      if (this.crV == bool) {
        break label245;
      }
    }
    label234:
    label245:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        if (this.otH != null) {
          this.otH.bQ(bool);
        }
        a(new a()
        {
          public final void c(u.c paramAnonymousc)
          {
            AppMethodBeat.i(131505);
            paramAnonymousc.bQ(bool);
            AppMethodBeat.o(131505);
          }
        });
      }
      this.crV = bool;
      this.crS = k;
      this.crW = null;
      AppMethodBeat.o(131510);
      return;
      i = 0;
      break;
      bool = false;
      break label164;
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
    public abstract void bQ(boolean paramBoolean);
    
    public abstract int getHeight();
    
    public abstract void hF(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.u
 * JD-Core Version:    0.7.0.1
 */