package com.tencent.mm.live.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.storage.aj;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper;", "", "()V", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a nkK;
  
  static
  {
    AppMethodBeat.i(245965);
    nkK = new a((byte)0);
    AppMethodBeat.o(245965);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper$Companion;", "", "()V", "GROUP_CHATTING_ROLE_MANAGER", "", "GROUP_CHATTING_ROLE_NORMAL", "GROUP_CHATTING_ROLE_OWNER", "LIVE_COMPLAINT_SENCE_LIVE", "LIVE_COMPLAINT_SENCE_OTHER", "LIVE_ENTRANCE_SCENE_OTHER", "LIVE_ENTRANCE_SCENE_TOOLBAR", "LIVE_NOTIFICATION_SCENE_APPMSG", "LIVE_NOTIFICATION_SCENE_NAV_TIP", "LIVE_NOTIFICATION_SCENE_OTHER", "LIVE_ROLE_ANCHOR", "LIVE_ROLE_VISITOR", "REPORT_CAMERA_STATUS_BACK", "REPORT_CAMERA_STATUS_FRONT", "REPORT_CAMERA_STATUS_OTHER", "REPORT_SCREEN_ORIENTATION_LANDSCAPE", "REPORT_SCREEN_ORIENTATION_OTHER", "REPORT_SCREEN_ORIENTATION_PORTRAIT", "TAG", "", "getGroupChattingMemberCount", "roomId", "getGroupChattingRole", "userName", "getLiveRole", "anchorName", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int GB(String paramString)
    {
      AppMethodBeat.i(245976);
      s.u(paramString, "roomId");
      paramString = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(245976);
        return 0;
      }
      paramString = paramString.bHw();
      if (paramString == null)
      {
        AppMethodBeat.o(245976);
        return 0;
      }
      int i = paramString.size();
      AppMethodBeat.o(245976);
      return i;
    }
    
    public static int aJ(String paramString1, String paramString2)
    {
      AppMethodBeat.i(245969);
      s.u(paramString1, "userName");
      s.u(paramString2, "roomId");
      paramString2 = ((com.tencent.mm.plugin.chatroom.a.b)h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(paramString2);
      if ((paramString2 != null) && (paramString2.bvK(paramString1) == true)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(245969);
        return 2;
      }
      if ((paramString2 != null) && (paramString2.Jf(paramString1) == true)) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(245969);
        return 1;
      }
      AppMethodBeat.o(245969);
      return 3;
    }
    
    public static int aK(String paramString1, String paramString2)
    {
      AppMethodBeat.i(245973);
      s.u(paramString1, "userName");
      s.u(paramString2, "anchorName");
      if (s.p(paramString1, paramString2))
      {
        AppMethodBeat.o(245973);
        return 1;
      }
      AppMethodBeat.o(245973);
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.b
 * JD-Core Version:    0.7.0.1
 */