package com.tencent.mm.plugin.appbrand.page.c;

import android.app.Activity;
import com.tencent.luggage.sdk.config.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicReference;

public class b
  implements c
{
  protected final ac cxn;
  protected final AtomicReference<c.b> nvY;
  
  b(ac paramac)
  {
    AppMethodBeat.i(135314);
    this.nvY = new AtomicReference();
    this.nvY.set(c.b.nvZ);
    this.cxn = paramac;
    AppMethodBeat.o(135314);
  }
  
  public void MV()
  {
    AppMethodBeat.i(135316);
    if ((this.cxn.kEb instanceof o))
    {
      Activity localActivity = AndroidContextUtil.castActivityOrNull(((o)this.cxn.kEb).mContext);
      if (localActivity == null)
      {
        AppMethodBeat.o(135316);
        return;
      }
      if (((a)this.cxn.av(a.class)).cyh)
      {
        y.x(localActivity, true);
        AppMethodBeat.o(135316);
        return;
      }
      y.x(localActivity, false);
    }
    AppMethodBeat.o(135316);
  }
  
  public void Nj() {}
  
  public void Nk() {}
  
  public final c.b Nl()
  {
    AppMethodBeat.i(135315);
    c.b localb = (c.b)this.nvY.get();
    AppMethodBeat.o(135315);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.b
 * JD-Core Version:    0.7.0.1
 */