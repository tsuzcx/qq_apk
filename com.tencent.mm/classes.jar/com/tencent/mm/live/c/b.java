package com.tencent.mm.live.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/ILiveStatus;", "", "getLiveRole", "", "registerPlugin", "", "plugin", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "LiveStatus", "plugin-logic_release"})
public abstract interface b
{
  public static final a FwH = a.FwI;
  
  public abstract void a(a parama);
  
  public abstract void a(c paramc, Bundle paramBundle);
  
  public abstract int getLiveRole();
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/ILiveStatus$Companion;", "", "()V", "LIVE_ROLE_ANCHOR", "", "LIVE_ROLE_REPLY", "LIVE_ROLE_VISITOR", "PARAM_IS_BAN_COMMENT", "", "PARAM_IS_ENTERING_COMMENT", "PARAM_LIVE_EXCEPTION_DESC", "PARAM_LIVE_EXCEPTION_ICON_RES", "PARAM_LIVE_EXCEPTION_TITLE", "PARAM_LIVE_HANGUP_SELF", "PARAM_LIVE_KICK_USERNAME", "PARAM_LIVE_LIKE_CONFETTI_X", "PARAM_LIVE_LIKE_CONFETTI_Y", "PARAM_LIVE_PUSH_URL", "PARAM_LIVE_TEST_ROOM_ID", "PARAM_LIVE_VERIFY_URL", "PARAM_LIVE_WXID", "PARAM_MEMBERS_PROFILE_NEED_NOTIFY_CLOSE", "PARAM_MEMBERS_PROFILE_USERNAME", "PARAM_START_LIVE_TITLE", "plugin-logic_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(202800);
      FwI = new a();
      AppMethodBeat.o(202800);
    }
  }
  
  @l(fvt={1, 1, 16})
  public static final class b {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "START_LIVE_VERIFY", "LIVE_VERIFY_SUCCESS", "START_FACE_VERIFY", "BEFORE_LIVE", "READY", "READY_CGI", "START_LIVE", "CLOSE_LIVE", "QUIT_LIVE", "SWITCH_CAMERA", "SHARE_LIVE", "LIVE_SCREEN", "LIVE_START_MIC_CGI", "LIVE_START_MIC_SDK", "LIVE_START_MIC_OTHER", "LIVE_START_MIC_PERMISSION_CLSOE", "LIVE_STOP_MIC", "LIVE_STOP_MIC_CGI", "LIVE_STOP_MIC_OTHER", "SHOW_MEMBERS_LIST", "HIDE_MEMBERS_LIST", "MINI_WINDOW", "MAXI_WINDOW", "MINI_WINDOW_PERMISSION", "LIVE_HAS_FINISHED", "LIVE_CHANGE_FINISHED", "DEBUG_ENTER", "RENDERING", "HIDE_SHARE_LIST", "POST_LIKE", "POST_MSG", "EXPOSE_LIVE", "ENTERING_COMMENT", "LIVE_STATUS_KICK_MEMBER", "LIVE_STATUS_EXPOSE_MEMBER", "LIVE_STATUS_SWITCH_VIDEO_MIC", "LIVE_STATUS_SWITCH_AUDIO_MIC", "LIVE_STATUS_VIDEO_MIC", "LIVE_STATUS_CLOSE_MEMBER_PROFILE", "LIVE_STATUS_OPEN_MEMBER_PROFILE", "LIVE_STATUS_VISITOR_KICKED", "LIVE_STATUS_RECONNECT", "LIVE_STATUS_DISCONNECT", "LIVE_STATUS_CONNECT_SUCC", "LIVE_STATUS_ANCHOR_EXCEPTION", "LIVE_START_LIVE_FAILED", "LIVE_START_LIVE_SUCCESS", "LIVE_READY_CANCEL_COUNTER", "LIVE_STATUS_ANCHOR_RECOVERY", "LIVE_STATUS_EXCEPTION", "LIVE_STATUS_JOIN_LIVE", "LIVE_STATUS_CREATE_LIVE", "LIVE_STATUS_FIRST_I_FRAME", "VISITOR_NOT_BIND_MOBILE", "VISITOR_COMMENT_ENTERING_OP", "LIVE_HAPPEN_VOIP_EVENT", "plugin-logic_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(202802);
      c localc1 = new c("UNKNOWN", 0);
      FwP = localc1;
      c localc2 = new c("START_LIVE_VERIFY", 1);
      FAO = localc2;
      c localc3 = new c("LIVE_VERIFY_SUCCESS", 2);
      FAP = localc3;
      c localc4 = new c("START_FACE_VERIFY", 3);
      FAQ = localc4;
      c localc5 = new c("BEFORE_LIVE", 4);
      FAS = localc5;
      c localc6 = new c("READY", 5);
      FAT = localc6;
      c localc7 = new c("READY_CGI", 6);
      FAU = localc7;
      c localc8 = new c("START_LIVE", 7);
      FAV = localc8;
      c localc9 = new c("CLOSE_LIVE", 8);
      FAW = localc9;
      c localc10 = new c("QUIT_LIVE", 9);
      FAX = localc10;
      c localc11 = new c("SWITCH_CAMERA", 10);
      FAY = localc11;
      c localc12 = new c("SHARE_LIVE", 11);
      FAZ = localc12;
      c localc13 = new c("LIVE_SCREEN", 12);
      FBa = localc13;
      c localc14 = new c("LIVE_START_MIC_CGI", 13);
      FBb = localc14;
      c localc15 = new c("LIVE_START_MIC_SDK", 14);
      FBc = localc15;
      c localc16 = new c("LIVE_START_MIC_OTHER", 15);
      FBd = localc16;
      c localc17 = new c("LIVE_START_MIC_PERMISSION_CLSOE", 16);
      FBe = localc17;
      c localc18 = new c("LIVE_STOP_MIC", 17);
      FBf = localc18;
      c localc19 = new c("LIVE_STOP_MIC_CGI", 18);
      FBg = localc19;
      c localc20 = new c("LIVE_STOP_MIC_OTHER", 19);
      FBh = localc20;
      c localc21 = new c("SHOW_MEMBERS_LIST", 20);
      FBi = localc21;
      c localc22 = new c("HIDE_MEMBERS_LIST", 21);
      FBj = localc22;
      c localc23 = new c("MINI_WINDOW", 22);
      FBk = localc23;
      c localc24 = new c("MAXI_WINDOW", 23);
      FBl = localc24;
      c localc25 = new c("MINI_WINDOW_PERMISSION", 24);
      FBm = localc25;
      c localc26 = new c("LIVE_HAS_FINISHED", 25);
      FBn = localc26;
      c localc27 = new c("LIVE_CHANGE_FINISHED", 26);
      FBo = localc27;
      c localc28 = new c("DEBUG_ENTER", 27);
      FBp = localc28;
      c localc29 = new c("RENDERING", 28);
      FBq = localc29;
      c localc30 = new c("HIDE_SHARE_LIST", 29);
      FBr = localc30;
      c localc31 = new c("POST_LIKE", 30);
      FBs = localc31;
      c localc32 = new c("POST_MSG", 31);
      FBt = localc32;
      c localc33 = new c("EXPOSE_LIVE", 32);
      FBu = localc33;
      c localc34 = new c("ENTERING_COMMENT", 33);
      FJZ = localc34;
      c localc35 = new c("LIVE_STATUS_KICK_MEMBER", 34);
      FLF = localc35;
      c localc36 = new c("LIVE_STATUS_EXPOSE_MEMBER", 35);
      FLG = localc36;
      c localc37 = new c("LIVE_STATUS_SWITCH_VIDEO_MIC", 36);
      Hbv = localc37;
      c localc38 = new c("LIVE_STATUS_SWITCH_AUDIO_MIC", 37);
      HRE = localc38;
      c localc39 = new c("LIVE_STATUS_VIDEO_MIC", 38);
      HRF = localc39;
      c localc40 = new c("LIVE_STATUS_CLOSE_MEMBER_PROFILE", 39);
      HRG = localc40;
      c localc41 = new c("LIVE_STATUS_OPEN_MEMBER_PROFILE", 40);
      HRH = localc41;
      c localc42 = new c("LIVE_STATUS_VISITOR_KICKED", 41);
      HRI = localc42;
      c localc43 = new c("LIVE_STATUS_RECONNECT", 42);
      HRJ = localc43;
      c localc44 = new c("LIVE_STATUS_DISCONNECT", 43);
      HRK = localc44;
      c localc45 = new c("LIVE_STATUS_CONNECT_SUCC", 44);
      HRL = localc45;
      c localc46 = new c("LIVE_STATUS_ANCHOR_EXCEPTION", 45);
      HRM = localc46;
      c localc47 = new c("LIVE_START_LIVE_FAILED", 46);
      HRN = localc47;
      c localc48 = new c("LIVE_START_LIVE_SUCCESS", 47);
      HRO = localc48;
      c localc49 = new c("LIVE_READY_CANCEL_COUNTER", 48);
      HRP = localc49;
      c localc50 = new c("LIVE_STATUS_ANCHOR_RECOVERY", 49);
      HRQ = localc50;
      c localc51 = new c("LIVE_STATUS_EXCEPTION", 50);
      HRR = localc51;
      c localc52 = new c("LIVE_STATUS_JOIN_LIVE", 51);
      HRS = localc52;
      c localc53 = new c("LIVE_STATUS_CREATE_LIVE", 52);
      HRT = localc53;
      c localc54 = new c("LIVE_STATUS_FIRST_I_FRAME", 53);
      HWJ = localc54;
      c localc55 = new c("VISITOR_NOT_BIND_MOBILE", 54);
      IIc = localc55;
      c localc56 = new c("VISITOR_COMMENT_ENTERING_OP", 55);
      IId = localc56;
      c localc57 = new c("LIVE_HAPPEN_VOIP_EVENT", 56);
      IIe = localc57;
      IIg = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8, localc9, localc10, localc11, localc12, localc13, localc14, localc15, localc16, localc17, localc18, localc19, localc20, localc21, localc22, localc23, localc24, localc25, localc26, localc27, localc28, localc29, localc30, localc31, localc32, localc33, localc34, localc35, localc36, localc37, localc38, localc39, localc40, localc41, localc42, localc43, localc44, localc45, localc46, localc47, localc48, localc49, localc50, localc51, localc52, localc53, localc54, localc55, localc56, localc57 };
      AppMethodBeat.o(202802);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.b
 * JD-Core Version:    0.7.0.1
 */