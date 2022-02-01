package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.e.a;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class u
  implements a
{
  private static Integer rvV = null;
  private int cpY;
  private final int[] cpZ;
  private final Rect cqa;
  private boolean cqb;
  private View cqc;
  private final LinkedHashSet<c> cqe;
  public int rvS;
  ap rvT;
  b rvU;
  
  u()
  {
    AppMethodBeat.i(131506);
    this.rvS = 1;
    this.cpY = 0;
    this.cpZ = new int[2];
    this.cqa = new Rect();
    this.cqb = false;
    this.cqe = new LinkedHashSet();
    AppMethodBeat.o(131506);
  }
  
  private static boolean T(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(230546);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(230546);
      return false;
    }
    if (rvV == null) {
      rvV = Integer.valueOf(KeyBoardUtil.getValidPanelHeight(paramContext));
    }
    if (rvV.intValue() != paramInt)
    {
      rvV = Integer.valueOf(paramInt);
      AppMethodBeat.o(230546);
      return true;
    }
    AppMethodBeat.o(230546);
    return false;
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(131511);
    Iterator localIterator = ((LinkedHashSet)this.cqe.clone()).iterator();
    while (localIterator.hasNext()) {
      parama.c((c)localIterator.next());
    }
    AppMethodBeat.o(131511);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(131508);
    if (this.cqc == null)
    {
      localContext = MMApplicationContext.getContext();
      AppMethodBeat.o(131508);
      return localContext;
    }
    Context localContext = this.cqc.getContext();
    AppMethodBeat.o(131508);
    return localContext;
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(131509);
    if (this.cqc == null) {}
    for (Object localObject = null; localObject == null; localObject = this.cqc.getRootView())
    {
      AppMethodBeat.o(131509);
      return 0;
    }
    localObject = this.cqa;
    m((Rect)localObject);
    if (w.ah(this.cqc)) {}
    for (int i = this.cqc.getMeasuredHeight();; i = getContext().getResources().getDisplayMetrics().heightPixels)
    {
      int j = ((Rect)localObject).top;
      AppMethodBeat.o(131509);
      return i - j;
    }
  }
  
  public static int getValidPanelHeight(Context paramContext)
  {
    AppMethodBeat.i(230547);
    if (rvV == null) {
      rvV = Integer.valueOf(KeyBoardUtil.getValidPanelHeight(paramContext));
    }
    int i = rvV.intValue();
    AppMethodBeat.o(230547);
    return i;
  }
  
  private void ks(boolean paramBoolean)
  {
    AppMethodBeat.i(230542);
    if (this.rvU != null) {
      this.rvU.ca(paramBoolean);
    }
    AppMethodBeat.o(230542);
  }
  
  private void m(Rect paramRect)
  {
    AppMethodBeat.i(131507);
    if (this.cqc != null)
    {
      this.cqc.getWindowVisibleDisplayFrame(paramRect);
      this.cqc.getLocationInWindow(this.cpZ);
      paramRect.top = this.cpZ[1];
    }
    AppMethodBeat.o(131507);
  }
  
  public final void DP(int paramInt)
  {
    AppMethodBeat.i(230544);
    this.rvS = paramInt;
    switch (this.rvS)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(230544);
      return;
      if (this.rvT != null)
      {
        this.rvT.close();
        this.rvT.cpl();
        AppMethodBeat.o(230544);
        return;
        if (this.rvT == null)
        {
          this.rvS = 1;
          AppMethodBeat.o(230544);
          return;
        }
        this.rvT.cpk();
        this.rvT.start();
      }
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(131512);
    if ((paramc != null) && (!this.cqe.contains(paramc))) {
      this.cqe.add(paramc);
    }
    AppMethodBeat.o(131512);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(131513);
    if (paramc != null) {
      this.cqe.remove(paramc);
    }
    AppMethodBeat.o(131513);
  }
  
  public final void cr(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(131510);
    this.cqc = paramView;
    if (1 != this.rvS)
    {
      AppMethodBeat.o(131510);
      return;
    }
    paramView = this.cqa;
    m(paramView);
    int j = paramView.height();
    if (this.cpY == 0) {
      this.cpY = j;
    }
    final int k = getFrameHeight() - j;
    final boolean bool;
    if (k > 0)
    {
      bool = T(getContext(), k);
      a(new a()
      {
        public final void c(u.c paramAnonymousc)
        {
          AppMethodBeat.i(131504);
          if (paramAnonymousc.getHeight() != k) {
            paramAnonymousc.iF(k);
          }
          AppMethodBeat.o(131504);
        }
      });
      if ((this.rvU != null) && ((bool) || (this.rvU.getHeight() != k))) {
        this.rvU.iF(k);
      }
    }
    if (getFrameHeight() > j)
    {
      bool = true;
      if (this.cqb == bool) {
        break label200;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        ks(bool);
        a(new a()
        {
          public final void c(u.c paramAnonymousc)
          {
            AppMethodBeat.i(131505);
            paramAnonymousc.ca(bool);
            AppMethodBeat.o(131505);
          }
        });
      }
      this.cqb = bool;
      this.cpY = j;
      this.cqc = null;
      AppMethodBeat.o(131510);
      return;
      bool = false;
      break;
      label200:
      i = 0;
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
    public abstract void ca(boolean paramBoolean);
    
    public abstract int getHeight();
    
    public abstract void iF(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.u
 * JD-Core Version:    0.7.0.1
 */