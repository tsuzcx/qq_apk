package com.tencent.mm.live.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.storage.w;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper;", "", "()V", "Companion", "plugin-logic_release"})
public final class b
{
  public static final a KxV;
  
  static
  {
    AppMethodBeat.i(203185);
    KxV = new a((byte)0);
    AppMethodBeat.o(203185);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/report/LiveKvStatReportHelper$Companion;", "", "()V", "GROUP_CHATTING_ROLE_MANAGER", "", "GROUP_CHATTING_ROLE_NORMAL", "GROUP_CHATTING_ROLE_OWNER", "LIVE_COMPLAINT_SENCE_LIVE", "LIVE_COMPLAINT_SENCE_OTHER", "LIVE_ENTRANCE_SCENE_OTHER", "LIVE_ENTRANCE_SCENE_TOOLBAR", "LIVE_NOTIFICATION_SCENE_APPMSG", "LIVE_NOTIFICATION_SCENE_NAV_TIP", "LIVE_NOTIFICATION_SCENE_OTHER", "LIVE_ROLE_ANCHOR", "LIVE_ROLE_VISITOR", "REPORT_CAMERA_STATUS_BACK", "REPORT_CAMERA_STATUS_FRONT", "REPORT_CAMERA_STATUS_OTHER", "REPORT_SCREEN_ORIENTATION_LANDSCAPE", "REPORT_SCREEN_ORIENTATION_OTHER", "REPORT_SCREEN_ORIENTATION_PORTRAIT", "TAG", "", "getGroupChattingMemberCount", "roomId", "getGroupChattingRole", "userName", "getLiveRole", "anchorName", "plugin-logic_release"})
  public static final class a
  {
    public static int aUw(String paramString)
    {
      AppMethodBeat.i(203184);
      k.h(paramString, "roomId");
      a locala = g.ab(c.class);
      k.g(locala, "MMKernel.service(IChatroomService::class.java)");
      paramString = ((c)locala).apV().tH(paramString);
      k.g(paramString, "MMKernel.service(IChatro…oomMembersStg.get(roomId)");
      int i = paramString.awt().size();
      AppMethodBeat.o(203184);
      return i;
    }
    
    public static int cc(String paramString1, String paramString2)
    {
      AppMethodBeat.i(203182);
      k.h(paramString1, "userName");
      k.h(paramString2, "roomId");
      a locala = g.ab(c.class);
      k.g(locala, "MMKernel.service(IChatroomService::class.java)");
      paramString2 = ((c)locala).apV().tH(paramString2);
      if ((paramString2 != null) && (paramString2.aHz(paramString1) == true))
      {
        AppMethodBeat.o(203182);
        return 2;
      }
      if ((paramString2 != null) && (paramString2.ty(paramString1) == true))
      {
        AppMethodBeat.o(203182);
        return 1;
      }
      AppMethodBeat.o(203182);
      return 3;
    }
    
    public static int fR(String paramString1, String paramString2)
    {
      AppMethodBeat.i(203183);
      k.h(paramString1, "userName");
      k.h(paramString2, "anchorName");
      if (k.g(paramString1, paramString2))
      {
        AppMethodBeat.o(203183);
        return 1;
      }
      AppMethodBeat.o(203183);
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.d.b
 * JD-Core Version:    0.7.0.1
 */