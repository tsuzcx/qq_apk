package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import java.util.Map;

final class j$1
  extends g.c
{
  j$1(String paramString) {}
  
  public final void a(g.d paramd)
  {
    AppMethodBeat.i(196080);
    j.bO(this.val$appId, 2);
    AppMethodBeat.o(196080);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(196082);
    j.bO(this.val$appId, 5);
    j.access$000().remove(this.val$appId);
    g.b(this.val$appId, this);
    AppMethodBeat.o(196082);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(196081);
    j.bO(this.val$appId, 3);
    AppMethodBeat.o(196081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.j.1
 * JD-Core Version:    0.7.0.1
 */