package com.tencent.mm.live.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/ILiveStatus;", "", "getLiveRole", "", "registerPlugin", "", "plugin", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "LiveStatus", "plugin-logic_release"})
public abstract interface b
{
  public static final b.a gRk = b.a.gRl;
  
  public abstract void a(a parama);
  
  public abstract void a(c paramc, Bundle paramBundle);
  
  public abstract int getLiveRole();
  
  @l(gfx={1, 1, 16})
  public static final class b {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "START_LIVE_VERIFY", "LIVE_VERIFY_SUCCESS", "START_FACE_VERIFY", "LIVE_FACE_VERIFY_NEED_BIND_BANKCARD", "BEFORE_LIVE", "READY", "READY_CGI", "START_LIVE", "CLOSE_LIVE", "QUIT_LIVE", "SWITCH_CAMERA", "SHARE_LIVE", "LIVE_SCREEN", "LIVE_START_MIC_CGI", "LIVE_START_MIC_SDK", "LIVE_START_MIC_OTHER", "LIVE_START_MIC_PERMISSION_CLSOE", "LIVE_STOP_MIC", "LIVE_STOP_MIC_CGI", "LIVE_STOP_MIC_OTHER", "SHOW_MEMBERS_LIST", "HIDE_MEMBERS_LIST", "MINI_WINDOW", "MAXI_WINDOW", "MINI_WINDOW_PERMISSION", "MINI_WINDOW_REFUSE", "MINI_WINDOW_CANCEL", "LIVE_HAS_FINISHED", "LIVE_CHANGE_FINISHED", "DEBUG_ENTER", "RENDERING", "HIDE_SHARE_LIST", "POST_LIKE", "POST_MSG", "EXPOSE_LIVE", "ENTERING_COMMENT", "LIVE_STATUS_KICK_MEMBER", "LIVE_STATUS_EXPOSE_MEMBER", "LIVE_STATUS_SWITCH_VIDEO_MIC", "LIVE_STATUS_SWITCH_AUDIO_MIC", "LIVE_STATUS_VIDEO_MIC", "LIVE_STATUS_CLOSE_MEMBER_PROFILE", "LIVE_STATUS_OPEN_MEMBER_PROFILE", "LIVE_STATUS_VISITOR_KICKED", "LIVE_STATUS_RECONNECT", "LIVE_STATUS_DISCONNECT", "LIVE_STATUS_CONNECT_SUCC", "LIVE_STATUS_ANCHOR_EXCEPTION", "LIVE_START_LIVE_FAILED", "LIVE_START_LIVE_SUCCESS", "LIVE_READY_CANCEL_COUNTER", "LIVE_STATUS_ANCHOR_RECOVERY", "LIVE_STATUS_EXCEPTION", "LIVE_STATUS_JOIN_LIVE", "LIVE_STATUS_CREATE_LIVE", "LIVE_STATUS_FIRST_I_FRAME", "VISITOR_NOT_BIND_MOBILE", "VISITOR_COMMENT_ENTERING_OP", "LIVE_HAPPEN_VOIP_EVENT", "LIVE_ORIENTATION_CHANGE", "LIVE_STATUS_COMMENT_LAYOUT_UPDATE", "plugin-logic_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(212289);
      c localc1 = new c("UNKNOWN", 0);
      gRm = localc1;
      c localc2 = new c("START_LIVE_VERIFY", 1);
      gRn = localc2;
      c localc3 = new c("LIVE_VERIFY_SUCCESS", 2);
      gRo = localc3;
      c localc4 = new c("START_FACE_VERIFY", 3);
      gRp = localc4;
      c localc5 = new c("LIVE_FACE_VERIFY_NEED_BIND_BANKCARD", 4);
      gRq = localc5;
      c localc6 = new c("BEFORE_LIVE", 5);
      gRr = localc6;
      c localc7 = new c("READY", 6);
      gRs = localc7;
      c localc8 = new c("READY_CGI", 7);
      gRt = localc8;
      c localc9 = new c("START_LIVE", 8);
      gRu = localc9;
      c localc10 = new c("CLOSE_LIVE", 9);
      gRv = localc10;
      c localc11 = new c("QUIT_LIVE", 10);
      gRw = localc11;
      c localc12 = new c("SWITCH_CAMERA", 11);
      gRx = localc12;
      c localc13 = new c("SHARE_LIVE", 12);
      gRy = localc13;
      c localc14 = new c("LIVE_SCREEN", 13);
      gRz = localc14;
      c localc15 = new c("LIVE_START_MIC_CGI", 14);
      gRA = localc15;
      c localc16 = new c("LIVE_START_MIC_SDK", 15);
      gRB = localc16;
      c localc17 = new c("LIVE_START_MIC_OTHER", 16);
      gRC = localc17;
      c localc18 = new c("LIVE_START_MIC_PERMISSION_CLSOE", 17);
      gRD = localc18;
      c localc19 = new c("LIVE_STOP_MIC", 18);
      gRE = localc19;
      c localc20 = new c("LIVE_STOP_MIC_CGI", 19);
      gRF = localc20;
      c localc21 = new c("LIVE_STOP_MIC_OTHER", 20);
      gRG = localc21;
      c localc22 = new c("SHOW_MEMBERS_LIST", 21);
      gRH = localc22;
      c localc23 = new c("HIDE_MEMBERS_LIST", 22);
      gRI = localc23;
      c localc24 = new c("MINI_WINDOW", 23);
      gRJ = localc24;
      c localc25 = new c("MAXI_WINDOW", 24);
      gRK = localc25;
      c localc26 = new c("MINI_WINDOW_PERMISSION", 25);
      gRL = localc26;
      c localc27 = new c("MINI_WINDOW_REFUSE", 26);
      gRM = localc27;
      c localc28 = new c("MINI_WINDOW_CANCEL", 27);
      gRN = localc28;
      c localc29 = new c("LIVE_HAS_FINISHED", 28);
      gRO = localc29;
      c localc30 = new c("LIVE_CHANGE_FINISHED", 29);
      gRP = localc30;
      c localc31 = new c("DEBUG_ENTER", 30);
      gRQ = localc31;
      c localc32 = new c("RENDERING", 31);
      gRR = localc32;
      c localc33 = new c("HIDE_SHARE_LIST", 32);
      gRS = localc33;
      c localc34 = new c("POST_LIKE", 33);
      gRT = localc34;
      c localc35 = new c("POST_MSG", 34);
      gRU = localc35;
      c localc36 = new c("EXPOSE_LIVE", 35);
      gRV = localc36;
      c localc37 = new c("ENTERING_COMMENT", 36);
      gRW = localc37;
      c localc38 = new c("LIVE_STATUS_KICK_MEMBER", 37);
      gRX = localc38;
      c localc39 = new c("LIVE_STATUS_EXPOSE_MEMBER", 38);
      gRY = localc39;
      c localc40 = new c("LIVE_STATUS_SWITCH_VIDEO_MIC", 39);
      gRZ = localc40;
      c localc41 = new c("LIVE_STATUS_SWITCH_AUDIO_MIC", 40);
      gSa = localc41;
      c localc42 = new c("LIVE_STATUS_VIDEO_MIC", 41);
      gSb = localc42;
      c localc43 = new c("LIVE_STATUS_CLOSE_MEMBER_PROFILE", 42);
      gSc = localc43;
      c localc44 = new c("LIVE_STATUS_OPEN_MEMBER_PROFILE", 43);
      gSd = localc44;
      c localc45 = new c("LIVE_STATUS_VISITOR_KICKED", 44);
      gSe = localc45;
      c localc46 = new c("LIVE_STATUS_RECONNECT", 45);
      gSf = localc46;
      c localc47 = new c("LIVE_STATUS_DISCONNECT", 46);
      gSg = localc47;
      c localc48 = new c("LIVE_STATUS_CONNECT_SUCC", 47);
      gSh = localc48;
      c localc49 = new c("LIVE_STATUS_ANCHOR_EXCEPTION", 48);
      gSi = localc49;
      c localc50 = new c("LIVE_START_LIVE_FAILED", 49);
      gSj = localc50;
      c localc51 = new c("LIVE_START_LIVE_SUCCESS", 50);
      gSk = localc51;
      c localc52 = new c("LIVE_READY_CANCEL_COUNTER", 51);
      gSl = localc52;
      c localc53 = new c("LIVE_STATUS_ANCHOR_RECOVERY", 52);
      gSm = localc53;
      c localc54 = new c("LIVE_STATUS_EXCEPTION", 53);
      gSn = localc54;
      c localc55 = new c("LIVE_STATUS_JOIN_LIVE", 54);
      gSo = localc55;
      c localc56 = new c("LIVE_STATUS_CREATE_LIVE", 55);
      gSp = localc56;
      c localc57 = new c("LIVE_STATUS_FIRST_I_FRAME", 56);
      gSq = localc57;
      c localc58 = new c("VISITOR_NOT_BIND_MOBILE", 57);
      gSr = localc58;
      c localc59 = new c("VISITOR_COMMENT_ENTERING_OP", 58);
      gSs = localc59;
      c localc60 = new c("LIVE_HAPPEN_VOIP_EVENT", 59);
      gSt = localc60;
      c localc61 = new c("LIVE_ORIENTATION_CHANGE", 60);
      gSu = localc61;
      c localc62 = new c("LIVE_STATUS_COMMENT_LAYOUT_UPDATE", 61);
      gSv = localc62;
      gSw = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8, localc9, localc10, localc11, localc12, localc13, localc14, localc15, localc16, localc17, localc18, localc19, localc20, localc21, localc22, localc23, localc24, localc25, localc26, localc27, localc28, localc29, localc30, localc31, localc32, localc33, localc34, localc35, localc36, localc37, localc38, localc39, localc40, localc41, localc42, localc43, localc44, localc45, localc46, localc47, localc48, localc49, localc50, localc51, localc52, localc53, localc54, localc55, localc56, localc57, localc58, localc59, localc60, localc61, localc62 };
      AppMethodBeat.o(212289);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.b
 * JD-Core Version:    0.7.0.1
 */