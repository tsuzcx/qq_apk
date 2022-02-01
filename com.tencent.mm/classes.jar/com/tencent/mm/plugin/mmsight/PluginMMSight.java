package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.api.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public class PluginMMSight
  extends f
  implements a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(89314);
    if (paramg != null) {
      ad.i("MicroMsg.PluginMMSight", "execute, process: %s", new Object[] { paramg.mProcessName });
    }
    com.tencent.mm.plugin.mmsight.api.b.vMU = new b.a();
    com.tencent.mm.plugin.mmsight.api.MMSightRecordView.vMT = new com.tencent.mm.plugin.api.recordView.e();
    com.tencent.mm.plugin.mmsight.api.a.vMR = new com.tencent.mm.plugin.api.a();
    if ((paramg != null) && (paramg.akw())) {
      pin(new t(e.class));
    }
    AppMethodBeat.o(89314);
  }
  
  public String name()
  {
    return "plugin-mmsight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.PluginMMSight
 * JD-Core Version:    0.7.0.1
 */