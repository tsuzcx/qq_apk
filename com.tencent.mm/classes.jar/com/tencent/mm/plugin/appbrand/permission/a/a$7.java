package com.tencent.mm.plugin.appbrand.permission.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g.c;
import java.util.Set;

final class a$7
  extends g.c
{
  a$7(String paramString) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(192298);
    a.TT(this.val$appId);
    a.bwe().remove(this.val$appId);
    AppMethodBeat.o(192298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.a.7
 * JD-Core Version:    0.7.0.1
 */