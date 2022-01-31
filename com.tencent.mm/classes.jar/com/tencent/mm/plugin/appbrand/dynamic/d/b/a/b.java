package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  implements e<String>
{
  private String hpR;
  
  public final boolean Bl(String paramString)
  {
    AppMethodBeat.i(10893);
    if (this.hpR == null)
    {
      AppMethodBeat.o(10893);
      return true;
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.hashCode() != this.hpR.hashCode()))
    {
      AppMethodBeat.o(10893);
      return true;
    }
    AppMethodBeat.o(10893);
    return false;
  }
  
  public final void E(Runnable paramRunnable)
  {
    AppMethodBeat.i(10894);
    paramRunnable.run();
    AppMethodBeat.o(10894);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.dynamic.d.b.b paramb)
  {
    AppMethodBeat.i(10892);
    paramb.run();
    AppMethodBeat.o(10892);
  }
  
  public final void azT() {}
  
  public final int azU()
  {
    return 1;
  }
  
  public final void reset()
  {
    this.hpR = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.b.a.b
 * JD-Core Version:    0.7.0.1
 */