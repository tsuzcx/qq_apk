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
    AppMethodBeat.i(262101);
    if (!paramg.bbA())
    {
      AppMethodBeat.o(262101);
      return;
    }
    Log.v("PluginKidsWatch", "configure");
    AppMethodBeat.o(262101);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(262097);
    dependsOn(v.class);
    AppMethodBeat.o(262097);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(262104);
    Log.v("PluginKidsWatch", "execute");
    AppMethodBeat.o(262104);
  }
  
  public void installed()
  {
    AppMethodBeat.i(262091);
    alias(a.class);
    AppMethodBeat.o(262091);
  }
  
  public void onAccountInitialized(f.c paramc) {}
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(262130);
    Log.v("PluginKidsWatch", "onAccountRelease");
    AppMethodBeat.o(262130);
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