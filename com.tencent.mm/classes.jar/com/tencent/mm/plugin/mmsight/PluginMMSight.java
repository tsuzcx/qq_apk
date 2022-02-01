package com.tencent.mm.plugin.mmsight;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.api.c;
import com.tencent.mm.plugin.api.d.a;
import com.tencent.mm.sdk.platformtools.Log;

public class PluginMMSight
  extends f
  implements a
{
  public void execute(g paramg)
  {
    AppMethodBeat.i(89314);
    if (paramg != null) {
      Log.i("MicroMsg.PluginMMSight", "execute, process: %s", new Object[] { paramg.mProcessName });
    }
    com.tencent.mm.plugin.mmsight.api.b.KUm = new d.a();
    com.tencent.mm.plugin.mmsight.api.MMSightRecordView.KUl = new com.tencent.mm.plugin.api.recordView.e();
    com.tencent.mm.plugin.mmsight.api.a.KUj = new c();
    if ((paramg != null) && (paramg.bbA())) {
      pin(new y(e.class));
    }
    AppMethodBeat.o(89314);
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