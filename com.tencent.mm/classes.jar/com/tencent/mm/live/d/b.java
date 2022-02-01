package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.storage.ah;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper;", "", "()V", "Companion", "plugin-logic_release"})
public final class b
{
  public static final a kIh;
  
  static
  {
    AppMethodBeat.i(199293);
    kIh = new a((byte)0);
    AppMethodBeat.o(199293);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper$Companion;", "", "()V", "GROUP_CHATTING_ROLE_MANAGER", "", "GROUP_CHATTING_ROLE_NORMAL", "GROUP_CHATTING_ROLE_OWNER", "LIVE_COMPLAINT_SENCE_LIVE", "LIVE_COMPLAINT_SENCE_OTHER", "LIVE_ENTRANCE_SCENE_OTHER", "LIVE_ENTRANCE_SCENE_TOOLBAR", "LIVE_NOTIFICATION_SCENE_APPMSG", "LIVE_NOTIFICATION_SCENE_NAV_TIP", "LIVE_NOTIFICATION_SCENE_OTHER", "LIVE_ROLE_ANCHOR", "LIVE_ROLE_VISITOR", "REPORT_CAMERA_STATUS_BACK", "REPORT_CAMERA_STATUS_FRONT", "REPORT_CAMERA_STATUS_OTHER", "REPORT_SCREEN_ORIENTATION_LANDSCAPE", "REPORT_SCREEN_ORIENTATION_OTHER", "REPORT_SCREEN_ORIENTATION_PORTRAIT", "TAG", "", "getGroupChattingMemberCount", "roomId", "getGroupChattingRole", "userName", "getLiveRole", "anchorName", "plugin-logic_release"})
  public static final class a
  {
    public static int Oo(String paramString)
    {
      AppMethodBeat.i(196590);
      p.k(paramString, "roomId");
      a locala = h.ae(com.tencent.mm.plugin.chatroom.a.b.class);
      p.j(locala, "MMKernel.service(IChatroomService::class.java)");
      paramString = ((com.tencent.mm.plugin.chatroom.a.b)locala).bbV().Rw(paramString);
      if (paramString != null)
      {
        paramString = paramString.bjL();
        if (paramString != null)
        {
          int i = paramString.size();
          AppMethodBeat.o(196590);
          return i;
        }
      }
      AppMethodBeat.o(196590);
      return 0;
    }
    
    public static int aA(String paramString1, String paramString2)
    {
      AppMethodBeat.i(196587);
      p.k(paramString1, "userName");
      p.k(paramString2, "roomId");
      a locala = h.ae(com.tencent.mm.plugin.chatroom.a.b.class);
      p.j(locala, "MMKernel.service(IChatroomService::class.java)");
      paramString2 = ((com.tencent.mm.plugin.chatroom.a.b)locala).bbV().Rw(paramString2);
      if ((paramString2 != null) && (paramString2.bvA(paramString1) == true))
      {
        AppMethodBeat.o(196587);
        return 2;
      }
      if ((paramString2 != null) && (paramString2.Rh(paramString1) == true))
      {
        AppMethodBeat.o(196587);
        return 1;
      }
      AppMethodBeat.o(196587);
      return 3;
    }
    
    public static int aB(String paramString1, String paramString2)
    {
      AppMethodBeat.i(196589);
      p.k(paramString1, "userName");
      p.k(paramString2, "anchorName");
      if (p.h(paramString1, paramString2))
      {
        AppMethodBeat.o(196589);
        return 1;
      }
      AppMethodBeat.o(196589);
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.d.b
 * JD-Core Version:    0.7.0.1
 */