package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.api.b.a;
import com.tencent.mm.sdk.platformtools.y;

public class PluginMMSight
  extends f
  implements a
{
  public void execute(g paramg)
  {
    if (paramg != null) {
      y.i("MicroMsg.PluginMMSight", "execute, process: %s", new Object[] { paramg.dIA });
    }
    com.tencent.mm.plugin.mmsight.api.b.mfI = new b.a();
    com.tencent.mm.plugin.mmsight.api.MMSightRecordView.mfH = new com.tencent.mm.plugin.api.recordView.e();
    com.tencent.mm.plugin.mmsight.api.a.mfF = new com.tencent.mm.plugin.api.a();
    pin(new p(e.class));
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