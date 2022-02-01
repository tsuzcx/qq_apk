package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.ac;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper$Companion;", "", "()V", "GROUP_CHATTING_ROLE_MANAGER", "", "GROUP_CHATTING_ROLE_NORMAL", "GROUP_CHATTING_ROLE_OWNER", "LIVE_COMPLAINT_SENCE_LIVE", "LIVE_COMPLAINT_SENCE_OTHER", "LIVE_ENTRANCE_SCENE_OTHER", "LIVE_ENTRANCE_SCENE_TOOLBAR", "LIVE_NOTIFICATION_SCENE_APPMSG", "LIVE_NOTIFICATION_SCENE_NAV_TIP", "LIVE_NOTIFICATION_SCENE_OTHER", "LIVE_ROLE_ANCHOR", "LIVE_ROLE_VISITOR", "REPORT_CAMERA_STATUS_BACK", "REPORT_CAMERA_STATUS_FRONT", "REPORT_CAMERA_STATUS_OTHER", "REPORT_SCREEN_ORIENTATION_LANDSCAPE", "REPORT_SCREEN_ORIENTATION_OTHER", "REPORT_SCREEN_ORIENTATION_PORTRAIT", "TAG", "", "getGroupChattingMemberCount", "roomId", "getGroupChattingRole", "userName", "getLiveRole", "anchorName", "plugin-logic_release"})
public final class b$a
{
  public static int av(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216341);
    p.h(paramString1, "userName");
    p.h(paramString2, "roomId");
    a locala = g.ab(c.class);
    p.g(locala, "MMKernel.service(IChatroomService::class.java)");
    paramString2 = ((c)locala).azP().Bx(paramString2);
    if ((paramString2 != null) && (paramString2.aUg(paramString1) == true))
    {
      AppMethodBeat.o(216341);
      return 2;
    }
    if ((paramString2 != null) && (paramString2.Bj(paramString1) == true))
    {
      AppMethodBeat.o(216341);
      return 1;
    }
    AppMethodBeat.o(216341);
    return 3;
  }
  
  public static int aw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216342);
    p.h(paramString1, "userName");
    p.h(paramString2, "anchorName");
    if (p.i(paramString1, paramString2))
    {
      AppMethodBeat.o(216342);
      return 1;
    }
    AppMethodBeat.o(216342);
    return 2;
  }
  
  public static int yE(String paramString)
  {
    AppMethodBeat.i(216343);
    p.h(paramString, "roomId");
    a locala = g.ab(c.class);
    p.g(locala, "MMKernel.service(IChatroomService::class.java)");
    paramString = ((c)locala).azP().Bx(paramString);
    if (paramString != null)
    {
      paramString = paramString.aGE();
      if (paramString != null)
      {
        int i = paramString.size();
        AppMethodBeat.o(216343);
        return i;
      }
    }
    AppMethodBeat.o(216343);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.d.b.a
 * JD-Core Version:    0.7.0.1
 */