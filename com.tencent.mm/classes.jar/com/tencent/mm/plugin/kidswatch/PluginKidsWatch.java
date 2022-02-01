package com.tencent.mm.plugin.kidswatch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.kidswatch.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;

public class PluginKidsWatch
  extends f
  implements c, d, a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(256391);
    if (!paramg.aBb())
    {
      AppMethodBeat.o(256391);
      return;
    }
    Log.v("PluginKidsWatch", "configure");
    AppMethodBeat.o(256391);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(256390);
    dependsOn(s.class);
    AppMethodBeat.o(256390);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(256392);
    Log.v("PluginKidsWatch", "execute");
    AppMethodBeat.o(256392);
  }
  
  public void installed()
  {
    AppMethodBeat.i(256389);
    alias(a.class);
    AppMethodBeat.o(256389);
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(256393);
    Log.v("PluginKidsWatch", "onAccountRelease");
    AppMethodBeat.o(256393);
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