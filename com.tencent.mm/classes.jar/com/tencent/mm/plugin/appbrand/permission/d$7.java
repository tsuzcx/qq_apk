package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e.c;
import java.util.Set;

final class d$7
  extends e.c
{
  d$7(String paramString) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(156383);
    d.Ey(this.val$appId);
    d.aKt().remove(this.val$appId);
    AppMethodBeat.o(156383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d.7
 * JD-Core Version:    0.7.0.1
 */