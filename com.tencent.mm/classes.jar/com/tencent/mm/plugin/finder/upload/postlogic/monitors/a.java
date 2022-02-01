package com.tencent.mm.plugin.finder.upload.postlogic.monitors;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.postlogic.base.e;
import com.tencent.mm.plugin.finder.upload.postlogic.base.h;
import com.tencent.mm.plugin.finder.upload.postlogic.c;
import com.tencent.mm.plugin.finder.upload.postlogic.finderstage.b;
import com.tencent.mm.plugin.finder.upload.postlogic.finderstage.d;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postlogic/monitors/StageCostTimeStatMonitor;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/StageCostTimeMonitor;", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/StageRecord;", "()V", "TAG", "", "genStageRecord", "stageFinish", "", "stage", "Lcom/tencent/mm/plugin/finder/upload/postlogic/base/Stage;", "costTime", "", "isSucc", "", "record", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.finder.upload.postlogic.base.f<h>
{
  private final String TAG = "Finder.StageCostTimeStatMonitor";
  
  public final void a(e parame, long paramLong, h paramh)
  {
    AppMethodBeat.i(343272);
    s.u(parame, "stage");
    s.u(paramh, "record");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("stageFinish, stage:");
    c localc = c.GdI;
    Log.i(str, c.a(parame) + ", enterTime:" + paramh.enterTime + ", exitTime:" + paramh.GdW);
    if ((parame instanceof d)) {
      paramh = ((d)parame).Ged;
    }
    for (;;)
    {
      if (paramh != null)
      {
        paramh = paramh.field_reportObject;
        if (paramh != null)
        {
          paramh.postTaskCost += (int)paramLong;
          if ((parame instanceof b)) {
            paramh.mediaProcessCost += (int)paramLong;
          }
          if ((parame instanceof com.tencent.mm.plugin.finder.upload.postlogic.finderstage.f)) {
            paramh.uploadCost += (int)paramLong;
          }
        }
      }
      AppMethodBeat.o(343272);
      return;
      if ((parame instanceof b)) {
        paramh = ((b)parame).Ged;
      } else if ((parame instanceof com.tencent.mm.plugin.finder.upload.postlogic.finderstage.f)) {
        paramh = ((com.tencent.mm.plugin.finder.upload.postlogic.finderstage.f)parame).Ged;
      } else {
        paramh = null;
      }
    }
  }
  
  public final h fes()
  {
    AppMethodBeat.i(343267);
    h localh = new h();
    AppMethodBeat.o(343267);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postlogic.monitors.a
 * JD-Core Version:    0.7.0.1
 */