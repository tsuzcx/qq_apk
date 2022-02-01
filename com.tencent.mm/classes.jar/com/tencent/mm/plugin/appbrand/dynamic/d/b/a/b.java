package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements e<String>
{
  private String rmJ;
  
  public final boolean Zk(String paramString)
  {
    AppMethodBeat.i(121373);
    if (this.rmJ == null)
    {
      AppMethodBeat.o(121373);
      return true;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.hashCode() != this.rmJ.hashCode()))
    {
      AppMethodBeat.o(121373);
      return true;
    }
    AppMethodBeat.o(121373);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.dynamic.d.b.b paramb)
  {
    AppMethodBeat.i(121372);
    paramb.run();
    AppMethodBeat.o(121372);
  }
  
  public final void ad(Runnable paramRunnable)
  {
    AppMethodBeat.i(121374);
    paramRunnable.run();
    AppMethodBeat.o(121374);
  }
  
  public final void cnO() {}
  
  public final int cnP()
  {
    return 1;
  }
  
  public final void reset()
  {
    this.rmJ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b
 * JD-Core Version:    0.7.0.1
 */