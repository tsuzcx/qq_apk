package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizFastRejectTool;", "", "()V", "KEY_MSG_ID", "", "KEY_MSG_RANK", "SCENE_BIZ_REJECT_PROFILE_SET", "", "TAG", "TYPE_BIZ_REJECT_TYPE_REJECT", "reportBizReject", "", "brandUserName", "actionTime", "", "scene", "sceneNote", "actionType", "plugin-brandservice_release"})
public final class a
{
  public static final a oaa;
  
  static
  {
    AppMethodBeat.i(6535);
    oaa = new a();
    AppMethodBeat.o(6535);
  }
  
  public static void r(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(209672);
    p.h(paramString, "brandUserName");
    g.yhR.f(17748, new Object[] { paramString, Long.valueOf(paramLong1), Integer.valueOf(0), Long.valueOf(paramLong2), Integer.valueOf(0) });
    AppMethodBeat.o(209672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a
 * JD-Core Version:    0.7.0.1
 */