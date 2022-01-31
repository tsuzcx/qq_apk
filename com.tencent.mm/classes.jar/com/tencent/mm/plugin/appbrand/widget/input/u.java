package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.t;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.d.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public final class u
  implements a
{
  private static Integer jmK = null;
  private int jmE;
  private final int[] jmF;
  private final Rect jmG;
  private boolean jmH;
  private View jmI;
  b jmJ;
  private final Set<u.c> jmL;
  
  public u()
  {
    AppMethodBeat.i(77430);
    this.jmE = 0;
    this.jmF = new int[2];
    this.jmG = new Rect();
    this.jmH = false;
    this.jmL = new LinkedHashSet();
    AppMethodBeat.o(77430);
  }
  
  private void a(u.a parama)
  {
    AppMethodBeat.i(77435);
    Iterator localIterator = this.jmL.iterator();
    while (localIterator.hasNext()) {
      parama.c((u.c)localIterator.next());
    }
    AppMethodBeat.o(77435);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(77432);
    if (this.jmI == null)
    {
      localContext = ah.getContext();
      AppMethodBeat.o(77432);
      return localContext;
    }
    Context localContext = this.jmI.getContext();
    AppMethodBeat.o(77432);
    return localContext;
  }
  
  private int getFrameHeight()
  {
    AppMethodBeat.i(77433);
    if (this.jmI == null) {}
    for (Object localObject = null; localObject == null; localObject = this.jmI.getRootView())
    {
      AppMethodBeat.o(77433);
      return 0;
    }
    localObject = this.jmG;
    getWindowVisibleDisplayFrame((Rect)localObject);
    if (t.as(this.jmI)) {}
    for (int i = this.jmI.getMeasuredHeight();; i = getContext().getResources().getDisplayMetrics().heightPixels)
    {
      int j = ((Rect)localObject).top;
      AppMethodBeat.o(77433);
      return i - j;
    }
  }
  
  private void getWindowVisibleDisplayFrame(Rect paramRect)
  {
    AppMethodBeat.i(77431);
    if (this.jmI != null)
    {
      this.jmI.getWindowVisibleDisplayFrame(paramRect);
      this.jmI.getLocationInWindow(this.jmF);
      paramRect.top = this.jmF[1];
    }
    AppMethodBeat.o(77431);
  }
  
  public final void a(u.c paramc)
  {
    AppMethodBeat.i(77436);
    if (paramc != null) {
      this.jmL.add(paramc);
    }
    AppMethodBeat.o(77436);
  }
  
  public final void b(u.c paramc)
  {
    AppMethodBeat.i(77437);
    if (paramc != null) {
      this.jmL.remove(paramc);
    }
    AppMethodBeat.o(77437);
  }
  
  public final void cN(View paramView)
  {
    int j = 1;
    AppMethodBeat.i(77434);
    this.jmI = paramView;
    paramView = this.jmG;
    getWindowVisibleDisplayFrame(paramView);
    int k = paramView.height();
    boolean bool;
    if (this.jmE == 0)
    {
      this.jmE = k;
      if (getFrameHeight() <= k) {
        break label242;
      }
      bool = true;
      label53:
      if (this.jmH == bool) {
        break label248;
      }
    }
    label242:
    label248:
    for (int i = j;; i = 0)
    {
      if (i != 0)
      {
        if (this.jmJ != null) {
          this.jmJ.bc(bool);
        }
        a(new u.2(this, bool));
      }
      this.jmH = bool;
      this.jmE = k;
      this.jmI = null;
      AppMethodBeat.o(77434);
      return;
      int m = getFrameHeight() - k;
      if (m <= 0) {
        break;
      }
      paramView = getContext();
      if (m > 0)
      {
        if (jmK == null) {
          jmK = Integer.valueOf(x.gL(paramView));
        }
        if (jmK.intValue() != m) {
          jmK = Integer.valueOf(m);
        }
      }
      for (i = 1;; i = 0)
      {
        a(new u.1(this, m));
        if ((this.jmJ == null) || ((i == 0) && (this.jmJ.getHeight() == m))) {
          break;
        }
        this.jmJ.fu(m);
        break;
      }
      bool = false;
      break label53;
    }
  }
  
  static abstract interface b
    extends u.c
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.u
 * JD-Core Version:    0.7.0.1
 */