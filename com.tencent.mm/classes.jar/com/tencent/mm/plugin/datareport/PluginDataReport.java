package com.tencent.mm.plugin.datareport;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.datareport.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.List;

public class PluginDataReport
  extends f
  implements com.tencent.mm.kernel.api.c, b
{
  private void startDataReport()
  {
    AppMethodBeat.i(262816);
    com.tencent.mm.plugin.datareport.g.a.dtv().a(new com.tencent.mm.plugin.datareport.g.b.b());
    com.tencent.mm.plugin.datareport.g.a.dtv().startMonitor();
    a locala = a.dtn();
    ??? = new a.a((byte)0);
    Object localObject3 = new com.tencent.mm.plugin.datareport.c.b();
    ((a.a)???).cQ.add(localObject3);
    ((a.a)???).xgS = new com.tencent.mm.plugin.datareport.c.c();
    ((a.a)???).xgT = new com.tencent.mm.plugin.datareport.e.a();
    ??? = new com.tencent.mm.plugin.datareport.c.a((a.a)???, (byte)0);
    locala.xga = ((com.tencent.mm.plugin.datareport.c.a)???);
    localObject3 = ((com.tencent.mm.plugin.datareport.c.a)???).cQ;
    if ((localObject3 != null) && (((List)localObject3).size() > 0)) {}
    synchronized (locala.cQ)
    {
      locala.cQ.addAll((Collection)localObject3);
      a.dtn().A("sdk_version", "1.0.0");
      a.dtn().A("process_id", Integer.valueOf(Process.myPid()));
      a.dtn().A("process_name", ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName);
      AppMethodBeat.o(262816);
      return;
    }
  }
  
  public void dependency()
  {
    AppMethodBeat.i(262854);
    dependsOn(com.tencent.mm.plugin.expt.a.class);
    AppMethodBeat.o(262854);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(262837);
    Log.d("PluginDataReport", "[execute] [%d] [%s]", new Object[] { Integer.valueOf(hashCode()), ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mProcessName });
    com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.datareport.a.b.class, a.dtn());
    if (a.dtn().dto()) {
      startDataReport();
    }
    AppMethodBeat.o(262837);
  }
  
  public void installed()
  {
    AppMethodBeat.i(262843);
    alias(b.class);
    AppMethodBeat.o(262843);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(262824);
    Log.i("PluginDataReport", "PluginDataReport onAccountInitialized [%d]", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(262824);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(262831);
    Log.i("PluginDataReport", "PluginDataReport onAccountRelease [%d]", new Object[] { Integer.valueOf(hashCode()) });
    AppMethodBeat.o(262831);
  }
  
  public String toString()
  {
    return "plugin-data-report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.PluginDataReport
 * JD-Core Version:    0.7.0.1
 */