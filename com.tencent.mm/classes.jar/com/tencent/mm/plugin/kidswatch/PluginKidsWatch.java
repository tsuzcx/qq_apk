package com.tencent.mm.plugin.kidswatch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.kidswatch.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;

public class PluginKidsWatch
  extends f
  implements c, d, a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(251951);
    if (!paramg.aIE())
    {
      AppMethodBeat.o(251951);
      return;
    }
    Log.v("PluginKidsWatch", "configure");
    AppMethodBeat.o(251951);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(251950);
    dependsOn(v.class);
    AppMethodBeat.o(251950);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(251952);
    Log.v("PluginKidsWatch", "execute");
    AppMethodBeat.o(251952);
  }
  
  public void installed()
  {
    AppMethodBeat.i(251949);
    alias(a.class);
    AppMethodBeat.o(251949);
  }
  
  public void onAccountInitialized(f.c paramc) {}
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(251956);
    Log.v("PluginKidsWatch", "onAccountRelease");
    AppMethodBeat.o(251956);
  }
  
  public void onDataBaseClosed(h paramh1, h paramh2) {}
  
  public void onDataBaseOpened(h paramh1, h paramh2) {}
  
  public String toString()
  {
    return "plugin-welab";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.kidswatch.PluginKidsWatch
 * JD-Core Version:    0.7.0.1
 */