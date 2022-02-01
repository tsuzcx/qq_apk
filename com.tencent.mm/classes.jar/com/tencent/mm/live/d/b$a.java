package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.ab;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper$Companion;", "", "()V", "GROUP_CHATTING_ROLE_MANAGER", "", "GROUP_CHATTING_ROLE_NORMAL", "GROUP_CHATTING_ROLE_OWNER", "LIVE_COMPLAINT_SENCE_LIVE", "LIVE_COMPLAINT_SENCE_OTHER", "LIVE_ENTRANCE_SCENE_OTHER", "LIVE_ENTRANCE_SCENE_TOOLBAR", "LIVE_NOTIFICATION_SCENE_APPMSG", "LIVE_NOTIFICATION_SCENE_NAV_TIP", "LIVE_NOTIFICATION_SCENE_OTHER", "LIVE_ROLE_ANCHOR", "LIVE_ROLE_VISITOR", "REPORT_CAMERA_STATUS_BACK", "REPORT_CAMERA_STATUS_FRONT", "REPORT_CAMERA_STATUS_OTHER", "REPORT_SCREEN_ORIENTATION_LANDSCAPE", "REPORT_SCREEN_ORIENTATION_OTHER", "REPORT_SCREEN_ORIENTATION_PORTRAIT", "TAG", "", "getGroupChattingMemberCount", "roomId", "getGroupChattingRole", "userName", "getLiveRole", "anchorName", "plugin-logic_release"})
public final class b$a
{
  public static int au(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212713);
    p.h(paramString1, "userName");
    p.h(paramString2, "roomId");
    a locala = g.ab(c.class);
    p.g(locala, "MMKernel.service(IChatroomService::class.java)");
    paramString2 = ((c)locala).azz().AN(paramString2);
    if ((paramString2 != null) && (paramString2.aSH(paramString1) == true))
    {
      AppMethodBeat.o(212713);
      return 2;
    }
    if ((paramString2 != null) && (paramString2.Az(paramString1) == true))
    {
      AppMethodBeat.o(212713);
      return 1;
    }
    AppMethodBeat.o(212713);
    return 3;
  }
  
  public static int av(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212714);
    p.h(paramString1, "userName");
    p.h(paramString2, "anchorName");
    if (p.i(paramString1, paramString2))
    {
      AppMethodBeat.o(212714);
      return 1;
    }
    AppMethodBeat.o(212714);
    return 2;
  }
  
  public static int xU(String paramString)
  {
    AppMethodBeat.i(212715);
    p.h(paramString, "roomId");
    a locala = g.ab(c.class);
    p.g(locala, "MMKernel.service(IChatroomService::class.java)");
    paramString = ((c)locala).azz().AN(paramString);
    if (paramString != null)
    {
      paramString = paramString.aGo();
      if (paramString != null)
      {
        int i = paramString.size();
        AppMethodBeat.o(212715);
        return i;
      }
    }
    AppMethodBeat.o(212715);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.d.b.a
 * JD-Core Version:    0.7.0.1
 */