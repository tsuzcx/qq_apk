package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.ah;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper;", "", "()V", "Companion", "plugin-logic_release"})
public final class b
{
  public static final a hTK;
  
  static
  {
    AppMethodBeat.i(208305);
    hTK = new a((byte)0);
    AppMethodBeat.o(208305);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper$Companion;", "", "()V", "GROUP_CHATTING_ROLE_MANAGER", "", "GROUP_CHATTING_ROLE_NORMAL", "GROUP_CHATTING_ROLE_OWNER", "LIVE_COMPLAINT_SENCE_LIVE", "LIVE_COMPLAINT_SENCE_OTHER", "LIVE_ENTRANCE_SCENE_OTHER", "LIVE_ENTRANCE_SCENE_TOOLBAR", "LIVE_NOTIFICATION_SCENE_APPMSG", "LIVE_NOTIFICATION_SCENE_NAV_TIP", "LIVE_NOTIFICATION_SCENE_OTHER", "LIVE_ROLE_ANCHOR", "LIVE_ROLE_VISITOR", "REPORT_CAMERA_STATUS_BACK", "REPORT_CAMERA_STATUS_FRONT", "REPORT_CAMERA_STATUS_OTHER", "REPORT_SCREEN_ORIENTATION_LANDSCAPE", "REPORT_SCREEN_ORIENTATION_OTHER", "REPORT_SCREEN_ORIENTATION_PORTRAIT", "TAG", "", "getGroupChattingMemberCount", "roomId", "getGroupChattingRole", "userName", "getLiveRole", "anchorName", "plugin-logic_release"})
  public static final class a
  {
    public static int Hd(String paramString)
    {
      AppMethodBeat.i(208304);
      p.h(paramString, "roomId");
      a locala = g.af(c.class);
      p.g(locala, "MMKernel.service(IChatroomService::class.java)");
      paramString = ((c)locala).aSX().Kd(paramString);
      if (paramString != null)
      {
        paramString = paramString.bax();
        if (paramString != null)
        {
          int i = paramString.size();
          AppMethodBeat.o(208304);
          return i;
        }
      }
      AppMethodBeat.o(208304);
      return 0;
    }
    
    public static int ax(String paramString1, String paramString2)
    {
      AppMethodBeat.i(208302);
      p.h(paramString1, "userName");
      p.h(paramString2, "roomId");
      a locala = g.af(c.class);
      p.g(locala, "MMKernel.service(IChatroomService::class.java)");
      paramString2 = ((c)locala).aSX().Kd(paramString2);
      if ((paramString2 != null) && (paramString2.bjf(paramString1) == true))
      {
        AppMethodBeat.o(208302);
        return 2;
      }
      if ((paramString2 != null) && (paramString2.JO(paramString1) == true))
      {
        AppMethodBeat.o(208302);
        return 1;
      }
      AppMethodBeat.o(208302);
      return 3;
    }
    
    public static int ay(String paramString1, String paramString2)
    {
      AppMethodBeat.i(208303);
      p.h(paramString1, "userName");
      p.h(paramString2, "anchorName");
      if (p.j(paramString1, paramString2))
      {
        AppMethodBeat.o(208303);
        return 1;
      }
      AppMethodBeat.o(208303);
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.live.d.b
 * JD-Core Version:    0.7.0.1
 */