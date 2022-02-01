package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizFastRejectTool;", "", "()V", "KEY_MSG_ID", "", "KEY_MSG_RANK", "SCENE_BIZ_REJECT_PROFILE_SET", "", "TAG", "TYPE_BIZ_REJECT_TYPE_REJECT", "reportBizReject", "", "brandUserName", "actionTime", "", "scene", "sceneNote", "actionType", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a vFk;
  
  static
  {
    AppMethodBeat.i(6535);
    vFk = new a();
    AppMethodBeat.o(6535);
  }
  
  public static void v(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(301840);
    s.u(paramString, "brandUserName");
    h.OAn.b(17748, new Object[] { paramString, Long.valueOf(paramLong1), Integer.valueOf(0), Long.valueOf(paramLong2), Integer.valueOf(0) });
    AppMethodBeat.o(301840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a
 * JD-Core Version:    0.7.0.1
 */