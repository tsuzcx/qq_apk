package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class r$18
  implements r.b
{
  private boolean iwC = false;
  private boolean iwD = false;
  private boolean qM = false;
  
  r$18(r paramr, String paramString, bf parambf) {}
  
  public final void aJf()
  {
    this.iwD = true;
  }
  
  public final void cancel()
  {
    this.qM = true;
  }
  
  public final void proceed()
  {
    AppMethodBeat.i(87095);
    if (this.qM)
    {
      AppMethodBeat.o(87095);
      return;
    }
    if (r.b(this.iwq) == null)
    {
      ab.w("MicroMsg.AppBrandPageContainer", "attempt to proceed but destroyed, url[%s], type[%s]", new Object[] { this.iwE, this.iwF });
      AppMethodBeat.o(87095);
      return;
    }
    if (!this.iwC)
    {
      r.a(this.iwq, this.iwE, this.iwF, this.iwD);
      this.iwC = true;
    }
    AppMethodBeat.o(87095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.r.18
 * JD-Core Version:    0.7.0.1
 */