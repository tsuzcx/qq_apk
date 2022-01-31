package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.api.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public class PluginMMSight
  extends f
  implements a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(76426);
    if (paramg != null) {
      ab.i("MicroMsg.PluginMMSight", "execute, process: %s", new Object[] { paramg.mProcessName });
    }
    com.tencent.mm.plugin.mmsight.api.b.oGi = new b.a();
    com.tencent.mm.plugin.mmsight.api.MMSightRecordView.oGh = new com.tencent.mm.plugin.api.recordView.e();
    com.tencent.mm.plugin.mmsight.api.a.oGf = new com.tencent.mm.plugin.api.a();
    pin(new q(e.class));
    AppMethodBeat.o(76426);
  }
  
  public String name()
  {
    return "plugin-mmsight";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.PluginMMSight
 * JD-Core Version:    0.7.0.1
 */