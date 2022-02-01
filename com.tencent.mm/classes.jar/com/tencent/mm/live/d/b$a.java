package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.x;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper$Companion;", "", "()V", "GROUP_CHATTING_ROLE_MANAGER", "", "GROUP_CHATTING_ROLE_NORMAL", "GROUP_CHATTING_ROLE_OWNER", "LIVE_COMPLAINT_SENCE_LIVE", "LIVE_COMPLAINT_SENCE_OTHER", "LIVE_ENTRANCE_SCENE_OTHER", "LIVE_ENTRANCE_SCENE_TOOLBAR", "LIVE_NOTIFICATION_SCENE_APPMSG", "LIVE_NOTIFICATION_SCENE_NAV_TIP", "LIVE_NOTIFICATION_SCENE_OTHER", "LIVE_ROLE_ANCHOR", "LIVE_ROLE_VISITOR", "REPORT_CAMERA_STATUS_BACK", "REPORT_CAMERA_STATUS_FRONT", "REPORT_CAMERA_STATUS_OTHER", "REPORT_SCREEN_ORIENTATION_LANDSCAPE", "REPORT_SCREEN_ORIENTATION_OTHER", "REPORT_SCREEN_ORIENTATION_PORTRAIT", "TAG", "", "getGroupChattingMemberCount", "roomId", "getGroupChattingRole", "userName", "getLiveRole", "anchorName", "plugin-logic_release"})
public final class b$a
{
  public static int at(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190423);
    k.h(paramString1, "userName");
    k.h(paramString2, "roomId");
    a locala = g.ab(c.class);
    k.g(locala, "MMKernel.service(IChatroomService::class.java)");
    paramString2 = ((c)locala).awK().xN(paramString2);
    if ((paramString2 != null) && (paramString2.aMU(paramString1) == true))
    {
      AppMethodBeat.o(190423);
      return 2;
    }
    if ((paramString2 != null) && (paramString2.xB(paramString1) == true))
    {
      AppMethodBeat.o(190423);
      return 1;
    }
    AppMethodBeat.o(190423);
    return 3;
  }
  
  public static int au(String paramString1, String paramString2)
  {
    AppMethodBeat.i(190424);
    k.h(paramString1, "userName");
    k.h(paramString2, "anchorName");
    if (k.g(paramString1, paramString2))
    {
      AppMethodBeat.o(190424);
      return 1;
    }
    AppMethodBeat.o(190424);
    return 2;
  }
  
  public static int ve(String paramString)
  {
    AppMethodBeat.i(190425);
    k.h(paramString, "roomId");
    a locala = g.ab(c.class);
    k.g(locala, "MMKernel.service(IChatroomService::class.java)");
    paramString = ((c)locala).awK().xN(paramString);
    if (paramString != null)
    {
      paramString = paramString.aDl();
      if (paramString != null)
      {
        int i = paramString.size();
        AppMethodBeat.o(190425);
        return i;
      }
    }
    AppMethodBeat.o(190425);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.d.b.a
 * JD-Core Version:    0.7.0.1
 */