package com.tencent.mm.live.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/ILiveStatus;", "", "getLiveRole", "", "registerPlugin", "", "plugin", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "LiveStatus", "plugin-logic_release"})
public abstract interface b
{
  public static final a hLr = a.hLs;
  
  public abstract int getLiveRole();
  
  public abstract void registerPlugin(a parama);
  
  public abstract void statusChange(c paramc, Bundle paramBundle);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/ILiveStatus$Companion;", "", "()V", "LIVE_ROLE_ANCHOR", "", "LIVE_ROLE_REPLY", "LIVE_ROLE_VISITOR", "PARAM_ENTER_COMMENT_AT_NAME", "", "PARAM_FINDER_LIVE_ALERT_DIALOG_CONTENT", "PARAM_FINDER_LIVE_ALERT_DIALOG_TITLE", "PARAM_FINDER_LIVE_AUTO_INPUT_MSG", "PARAM_FINDER_LIVE_AVATAR", "PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", "PARAM_FINDER_LIVE_COMMENT", "PARAM_FINDER_LIVE_COMMENT_MOVE_DISTANCE", "PARAM_FINDER_LIVE_COMMENT_SEQ", "PARAM_FINDER_LIVE_CONTACT_SCENE", "PARAM_FINDER_LIVE_ERROR_CODE", "PARAM_FINDER_LIVE_ERROR_PAGE", "PARAM_FINDER_LIVE_FACE_VERIFY_URL", "PARAM_FINDER_LIVE_FORCE_TASK", "PARAM_FINDER_LIVE_GIFT_ID", "PARAM_FINDER_LIVE_GIFT_UPDATE_WECOIN", "PARAM_FINDER_LIVE_HEAD_URL", "PARAM_FINDER_LIVE_ID", "PARAM_FINDER_LIVE_LINK_MIC_ENABLE", "PARAM_FINDER_LIVE_LINK_MIC_TYPE", "PARAM_FINDER_LIVE_LINK_NICKNAME", "PARAM_FINDER_LIVE_LINK_STATUS", "PARAM_FINDER_LIVE_LINK_USERNAME", "PARAM_FINDER_LIVE_LIVE_FINISH_IF_CLOSE_LIVE", "PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL", "PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS", "PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", "PARAM_FINDER_LIVE_MEMBER_LIST_AUTOREFRESH_VALUE", "PARAM_FINDER_LIVE_NICE_NAME", "PARAM_FINDER_LIVE_POST_AFTER_FACE_VERIFY", "PARAM_FINDER_LIVE_ROOM_MODE", "PARAM_FINDER_LIVE_SCREEN_CLEAR", "PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", "PARAM_FINDER_LIVE_TOP_COMMENT", "PARAM_FINDER_LIVE_URL", "PARAM_FINDER_LIVE_USERNAME", "PARAM_IS_BAN_COMMENT", "PARAM_IS_ENTERING_COMMENT", "PARAM_KEY_POST_OBJECT_DESC", "PARAM_LIVE_COMMENT_OFFSET_HEIGHT", "PARAM_LIVE_EXCEPTION_DESC", "PARAM_LIVE_EXCEPTION_ICON_RES", "PARAM_LIVE_EXCEPTION_TITLE", "PARAM_LIVE_FACE_VERIFY_ERROR", "PARAM_LIVE_GIFT_INFO", "PARAM_LIVE_GIFT_IS_FORCE_REPLACE", "PARAM_LIVE_GIFT_PREVIEW_BOTTOM_MARGIN", "PARAM_LIVE_GIFT_PREVIEW_POS", "PARAM_LIVE_GIFT_PREVIEW_SIZE", "PARAM_LIVE_GIFT_REWARD_COUNT", "PARAM_LIVE_HANGUP_SELF", "PARAM_LIVE_KICK_USERNAME", "PARAM_LIVE_LIKE_CONFETTI_X", "PARAM_LIVE_LIKE_CONFETTI_Y", "PARAM_LIVE_MINI_WINDOW_AUTO", "PARAM_LIVE_MINI_WINDOW_GENERATE_TYPE", "PARAM_LIVE_MINI_WINDOW_OP_TYPE", "PARAM_LIVE_PRECIOUS_GIFT_DURATION", "PARAM_LIVE_PUSH_URL", "PARAM_LIVE_START_BY_ORIENTATION_CHANGE", "PARAM_LIVE_TEST_ROOM_ID", "PARAM_LIVE_WXID", "PARAM_MEMBERS_PROFILE_NEED_NOTIFY_CLOSE", "PARAM_MEMBERS_PROFILE_USERMSG", "PARAM_MEMBERS_PROFILE_USERNAME", "PARAM_START_LIVE_TITLE", "plugin-logic_release"})
  public static final class a
  {
    static
    {
      AppMethodBeat.i(207869);
      hLs = new a();
      AppMethodBeat.o(207869);
    }
  }
  
  @l(hxD={1, 1, 16})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "", "(Ljava/lang/String;I)V", "UNKNOWN", "START_LIVE_VERIFY", "LIVE_VERIFY_SUCCESS", "START_FACE_VERIFY", "LIVE_FACE_VERIFY_NEED_BIND_BANKCARD", "BEFORE_LIVE", "READY", "READY_CGI", "START_LIVE", "CLOSE_LIVE", "QUIT_LIVE", "SWITCH_CAMERA", "SHARE_LIVE", "LIVE_SCREEN", "LIVE_START_MIC_CGI", "LIVE_START_MIC_SDK", "LIVE_START_MIC_OTHER", "LIVE_START_MIC_PERMISSION_CLSOE", "LIVE_STOP_MIC", "LIVE_STOP_MIC_CGI", "LIVE_STOP_MIC_OTHER", "SHOW_MEMBERS_LIST", "HIDE_MEMBERS_LIST", "MINI_WINDOW", "MAXI_WINDOW", "MINI_WINDOW_PERMISSION", "MINI_WINDOW_REFUSE", "MINI_WINDOW_CANCEL", "LIVE_HAS_FINISHED", "LIVE_CHANGE_FINISHED", "DEBUG_ENTER", "RENDERING", "HIDE_SHARE_LIST", "POST_LIKE", "POST_MSG", "EXPOSE_LIVE", "ENTERING_COMMENT", "LIVE_STATUS_KICK_MEMBER", "LIVE_STATUS_EXPOSE_MEMBER", "LIVE_STATUS_SWITCH_VIDEO_MIC", "LIVE_STATUS_SWITCH_AUDIO_MIC", "LIVE_STATUS_VIDEO_MIC", "LIVE_STATUS_CLOSE_MEMBER_PROFILE", "LIVE_STATUS_OPEN_MEMBER_PROFILE", "LIVE_STATUS_VISITOR_KICKED", "LIVE_STATUS_VISITOR_PRIVATE_PERMISSION", "LIVE_STATUS_RECONNECT", "LIVE_STATUS_DISCONNECT", "LIVE_STATUS_CONNECT_SUCC", "LIVE_STATUS_ANCHOR_EXCEPTION", "LIVE_START_LIVE_FAILED", "LIVE_START_LIVE_SUCCESS", "LIVE_READY_CANCEL_COUNTER", "LIVE_STATUS_ANCHOR_RECOVERY", "LIVE_STATUS_EXCEPTION", "LIVE_STATUS_JOIN_LIVE", "LIVE_STATUS_CREATE_LIVE", "LIVE_STATUS_FIRST_I_FRAME", "VISITOR_NOT_BIND_MOBILE", "VISITOR_COMMENT_ENTERING_OP", "LIVE_HAPPEN_VOIP_EVENT", "LIVE_ORIENTATION_CHANGE", "LIVE_STATUS_COMMENT_LAYOUT_UPDATE", "LIVE_STATUS_RESOLUTION", "LIVE_MIRROR_ACTION_EVENT", "LIVE_EVENT_SHOW_GIFT_PANEL", "LIVE_EVENT_HIDE_GIFT_PANEL", "LIVE_EVENT_PREVIEW_GIFT", "LIVE_EVENT_SEND_GIFT", "LIVE_EVENT_SHOW_FULL_SCREEN_GIFT", "LIVE_EVENT_HIDE_FULL_SCREEN_GIFT", "LIVE_EVENT_GIFT_UPDATE_WECOIN", "LIVE_EVENT_GIFT_SHOW_SEND_BTN", "LIVE_EVENT_GIFT_HIDE_SEND_BTN", "FINDER_LIVE_MIC_PANEL_DISPLAY", "FINDER_LIVE_LINK_MIC_APPLY", "FINDER_LIVE_LINK_MIC_ACCEPT", "FINDER_LIVE_LINK_MIC_CLOSE", "FINDER_LIVE_MEMBER_CONTENT", "FINDER_LIVE_MEMBERS_LOADING", "FINDER_LIVE_MEMBERS_AUTO_REFRESH", "FINDER_LIVE_APPLY_LINK_EXPOSED", "FINDER_LIVE_LINK_DISPLAY_STATUS_PANEL", "FINDER_LIVE_LINK_DISPLAY_NOTIFY_PANEL", "FINDER_LIVE_SHOPPING_LIST_SHOW", "FINDER_LIVE_SHOPPING_LIST_HIDE", "FINDER_LIVE_SHOPPING_PROMOTING", "FINDER_LIVE_SHOPPING_REFRESH", "FINDER_LIVE_COMMENT_MOVE", "FINDER_LIVE_FACE_VERIFY", "FINDER_LIVE_LINK_INVITE", "FINDER_LIVE_FORCE_QUIT", "FINDER_LIVE_UPDATE_LIVE_MSG", "FINDER_LIVE_AUTO_INPUT_COMMENT", "FINDER_LIVE_COMMENT_REAL_NAME", "FINDER_LIVE_COMMENT_BACKOFF", "FINDER_LIVE_CLEAR_SCREEN", "FINDER_LIVE_IDLE", "FINDER_LIVE_MORE_ACTION_SHOW", "FINDER_LIVE_MORE_ACTION_HIDE", "FINDER_LIVE_STATISTC_EVENT", "FINDER_LIVE_TOP_COMMENNT", "FINDER_LIVE_MSG_ACTION_SHEET", "FINDER_LIVE_POST_PORTRAIT_ACTION", "FINDER_LIVE_RESET_POST_PORTRAIT_ACTION", "FINDER_LIVE_POST_LANDSCAPE_ACTION", "FINDER_LIVE_RESET_POST_LANDSCAPE_ACTION", "FINDER_LIVE_RESET_POST_ACTION", "FINDER_LIVE_SHOW_CAMERA_OPT_SHEET", "FINDER_LIVE_HIDE_CAMERA_OPT_SHEET", "FINDER_LIVE_CREATE_ERROR_PAGE", "FINDER_LIVE_CREATE_LOTTERY_SUCCESS", "FINDER_LIVE_CANCEL_LOTTERY_SUCCESS", "FINDER_LIVE_LOTTERY_BUBBLE_SHOW", "FINDER_LIVE_LOTTERY_BUBBLE_HIDE", "FINDER_LIVE_LOTTERY_CARD_SHOW", "FINDER_LIVE_LOTTERY_CARD_HIDE", "FINDER_LIVE_LOTTERY_UPDATE", "FINDER_LIVE_LOTTERY_UPDATE_COUNTDOWN", "FINDER_LIVE_LIKE_SHAKE", "FINDER_LIVE_SHOW_ALERT_DIALOG", "FINDER_LIVE_POST_HL_LIKE", "FINDER_LIVE_LINK_MIC_VISITOR_REQUEST", "FINDER_LIVE_LINK_MIC_SHOW_APPLY_LIST", "FINDER_LIVE_LINK_MIC_HIDE_APPLY_LIST", "FINDER_LIVE_LINK_MIC_ANCHOR_ACCEPT", "FINDER_LIVE_LINK_MIC_HANGUP_LINK", "FINDER_LIVE_LINK_MIC_ADD_BOTTOM_BAR", "FINDER_LIVE_LINK_MIC_REMOVE_BOTTOM_BAR", "FINDER_LIVE_LINK_MIC_ANCHOR_SETTING", "FINDER_LIVE_LINK_MIC_SHOW_APPLY_LICENSE", "FINDER_LIVE_LINK_MIC_HIDE_APPLY_LICENSE", "FINDER_LIVE_LINK_MIC_CHECKED", "FINDER_LIVE_SHOW_EXPLAIN_WECOIN_HOT", "FINDER_LIVE_HIDE_EXPLAIN_WECOIN_HOT", "plugin-logic_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(207871);
      c localc1 = new c("UNKNOWN", 0);
      hLt = localc1;
      c localc2 = new c("START_LIVE_VERIFY", 1);
      hLu = localc2;
      c localc3 = new c("LIVE_VERIFY_SUCCESS", 2);
      hLv = localc3;
      c localc4 = new c("START_FACE_VERIFY", 3);
      hLw = localc4;
      c localc5 = new c("LIVE_FACE_VERIFY_NEED_BIND_BANKCARD", 4);
      hLx = localc5;
      c localc6 = new c("BEFORE_LIVE", 5);
      hLy = localc6;
      c localc7 = new c("READY", 6);
      hLz = localc7;
      c localc8 = new c("READY_CGI", 7);
      hLA = localc8;
      c localc9 = new c("START_LIVE", 8);
      hLB = localc9;
      c localc10 = new c("CLOSE_LIVE", 9);
      hLC = localc10;
      c localc11 = new c("QUIT_LIVE", 10);
      hLD = localc11;
      c localc12 = new c("SWITCH_CAMERA", 11);
      hLE = localc12;
      c localc13 = new c("SHARE_LIVE", 12);
      hLF = localc13;
      c localc14 = new c("LIVE_SCREEN", 13);
      hLG = localc14;
      c localc15 = new c("LIVE_START_MIC_CGI", 14);
      hLH = localc15;
      c localc16 = new c("LIVE_START_MIC_SDK", 15);
      hLI = localc16;
      c localc17 = new c("LIVE_START_MIC_OTHER", 16);
      hLJ = localc17;
      c localc18 = new c("LIVE_START_MIC_PERMISSION_CLSOE", 17);
      hLK = localc18;
      c localc19 = new c("LIVE_STOP_MIC", 18);
      hLL = localc19;
      c localc20 = new c("LIVE_STOP_MIC_CGI", 19);
      hLM = localc20;
      c localc21 = new c("LIVE_STOP_MIC_OTHER", 20);
      hLN = localc21;
      c localc22 = new c("SHOW_MEMBERS_LIST", 21);
      hLO = localc22;
      c localc23 = new c("HIDE_MEMBERS_LIST", 22);
      hLP = localc23;
      c localc24 = new c("MINI_WINDOW", 23);
      hLQ = localc24;
      c localc25 = new c("MAXI_WINDOW", 24);
      hLR = localc25;
      c localc26 = new c("MINI_WINDOW_PERMISSION", 25);
      hLS = localc26;
      c localc27 = new c("MINI_WINDOW_REFUSE", 26);
      hLT = localc27;
      c localc28 = new c("MINI_WINDOW_CANCEL", 27);
      hLU = localc28;
      c localc29 = new c("LIVE_HAS_FINISHED", 28);
      hLV = localc29;
      c localc30 = new c("LIVE_CHANGE_FINISHED", 29);
      hLW = localc30;
      c localc31 = new c("DEBUG_ENTER", 30);
      hLX = localc31;
      c localc32 = new c("RENDERING", 31);
      hLY = localc32;
      c localc33 = new c("HIDE_SHARE_LIST", 32);
      hLZ = localc33;
      c localc34 = new c("POST_LIKE", 33);
      hMa = localc34;
      c localc35 = new c("POST_MSG", 34);
      hMb = localc35;
      c localc36 = new c("EXPOSE_LIVE", 35);
      hMc = localc36;
      c localc37 = new c("ENTERING_COMMENT", 36);
      hMd = localc37;
      c localc38 = new c("LIVE_STATUS_KICK_MEMBER", 37);
      hMe = localc38;
      c localc39 = new c("LIVE_STATUS_EXPOSE_MEMBER", 38);
      hMf = localc39;
      c localc40 = new c("LIVE_STATUS_SWITCH_VIDEO_MIC", 39);
      hMg = localc40;
      c localc41 = new c("LIVE_STATUS_SWITCH_AUDIO_MIC", 40);
      hMh = localc41;
      c localc42 = new c("LIVE_STATUS_VIDEO_MIC", 41);
      hMi = localc42;
      c localc43 = new c("LIVE_STATUS_CLOSE_MEMBER_PROFILE", 42);
      hMj = localc43;
      c localc44 = new c("LIVE_STATUS_OPEN_MEMBER_PROFILE", 43);
      hMk = localc44;
      c localc45 = new c("LIVE_STATUS_VISITOR_KICKED", 44);
      hMl = localc45;
      c localc46 = new c("LIVE_STATUS_VISITOR_PRIVATE_PERMISSION", 45);
      hMm = localc46;
      c localc47 = new c("LIVE_STATUS_RECONNECT", 46);
      hMn = localc47;
      c localc48 = new c("LIVE_STATUS_DISCONNECT", 47);
      hMo = localc48;
      c localc49 = new c("LIVE_STATUS_CONNECT_SUCC", 48);
      hMp = localc49;
      c localc50 = new c("LIVE_STATUS_ANCHOR_EXCEPTION", 49);
      hMq = localc50;
      c localc51 = new c("LIVE_START_LIVE_FAILED", 50);
      hMr = localc51;
      c localc52 = new c("LIVE_START_LIVE_SUCCESS", 51);
      hMs = localc52;
      c localc53 = new c("LIVE_READY_CANCEL_COUNTER", 52);
      hMt = localc53;
      c localc54 = new c("LIVE_STATUS_ANCHOR_RECOVERY", 53);
      hMu = localc54;
      c localc55 = new c("LIVE_STATUS_EXCEPTION", 54);
      hMv = localc55;
      c localc56 = new c("LIVE_STATUS_JOIN_LIVE", 55);
      hMw = localc56;
      c localc57 = new c("LIVE_STATUS_CREATE_LIVE", 56);
      hMx = localc57;
      c localc58 = new c("LIVE_STATUS_FIRST_I_FRAME", 57);
      hMy = localc58;
      c localc59 = new c("VISITOR_NOT_BIND_MOBILE", 58);
      hMz = localc59;
      c localc60 = new c("VISITOR_COMMENT_ENTERING_OP", 59);
      hMA = localc60;
      c localc61 = new c("LIVE_HAPPEN_VOIP_EVENT", 60);
      hMB = localc61;
      c localc62 = new c("LIVE_ORIENTATION_CHANGE", 61);
      hMC = localc62;
      c localc63 = new c("LIVE_STATUS_COMMENT_LAYOUT_UPDATE", 62);
      hMD = localc63;
      c localc64 = new c("LIVE_STATUS_RESOLUTION", 63);
      hME = localc64;
      c localc65 = new c("LIVE_MIRROR_ACTION_EVENT", 64);
      hMF = localc65;
      c localc66 = new c("LIVE_EVENT_SHOW_GIFT_PANEL", 65);
      hMG = localc66;
      c localc67 = new c("LIVE_EVENT_HIDE_GIFT_PANEL", 66);
      hMH = localc67;
      c localc68 = new c("LIVE_EVENT_PREVIEW_GIFT", 67);
      hMI = localc68;
      c localc69 = new c("LIVE_EVENT_SEND_GIFT", 68);
      hMJ = localc69;
      c localc70 = new c("LIVE_EVENT_SHOW_FULL_SCREEN_GIFT", 69);
      hMK = localc70;
      c localc71 = new c("LIVE_EVENT_HIDE_FULL_SCREEN_GIFT", 70);
      hML = localc71;
      c localc72 = new c("LIVE_EVENT_GIFT_UPDATE_WECOIN", 71);
      hMM = localc72;
      c localc73 = new c("LIVE_EVENT_GIFT_SHOW_SEND_BTN", 72);
      hMN = localc73;
      c localc74 = new c("LIVE_EVENT_GIFT_HIDE_SEND_BTN", 73);
      hMO = localc74;
      c localc75 = new c("FINDER_LIVE_MIC_PANEL_DISPLAY", 74);
      hMP = localc75;
      c localc76 = new c("FINDER_LIVE_LINK_MIC_APPLY", 75);
      hMQ = localc76;
      c localc77 = new c("FINDER_LIVE_LINK_MIC_ACCEPT", 76);
      hMR = localc77;
      c localc78 = new c("FINDER_LIVE_LINK_MIC_CLOSE", 77);
      hMS = localc78;
      c localc79 = new c("FINDER_LIVE_MEMBER_CONTENT", 78);
      hMT = localc79;
      c localc80 = new c("FINDER_LIVE_MEMBERS_LOADING", 79);
      hMU = localc80;
      c localc81 = new c("FINDER_LIVE_MEMBERS_AUTO_REFRESH", 80);
      hMV = localc81;
      c localc82 = new c("FINDER_LIVE_APPLY_LINK_EXPOSED", 81);
      hMW = localc82;
      c localc83 = new c("FINDER_LIVE_LINK_DISPLAY_STATUS_PANEL", 82);
      hMX = localc83;
      c localc84 = new c("FINDER_LIVE_LINK_DISPLAY_NOTIFY_PANEL", 83);
      hMY = localc84;
      c localc85 = new c("FINDER_LIVE_SHOPPING_LIST_SHOW", 84);
      hMZ = localc85;
      c localc86 = new c("FINDER_LIVE_SHOPPING_LIST_HIDE", 85);
      hNa = localc86;
      c localc87 = new c("FINDER_LIVE_SHOPPING_PROMOTING", 86);
      hNb = localc87;
      c localc88 = new c("FINDER_LIVE_SHOPPING_REFRESH", 87);
      hNc = localc88;
      c localc89 = new c("FINDER_LIVE_COMMENT_MOVE", 88);
      hNd = localc89;
      c localc90 = new c("FINDER_LIVE_FACE_VERIFY", 89);
      hNe = localc90;
      c localc91 = new c("FINDER_LIVE_LINK_INVITE", 90);
      hNf = localc91;
      c localc92 = new c("FINDER_LIVE_FORCE_QUIT", 91);
      hNg = localc92;
      c localc93 = new c("FINDER_LIVE_UPDATE_LIVE_MSG", 92);
      hNh = localc93;
      c localc94 = new c("FINDER_LIVE_AUTO_INPUT_COMMENT", 93);
      hNi = localc94;
      c localc95 = new c("FINDER_LIVE_COMMENT_REAL_NAME", 94);
      hNj = localc95;
      c localc96 = new c("FINDER_LIVE_COMMENT_BACKOFF", 95);
      hNk = localc96;
      c localc97 = new c("FINDER_LIVE_CLEAR_SCREEN", 96);
      hNl = localc97;
      c localc98 = new c("FINDER_LIVE_IDLE", 97);
      hNm = localc98;
      c localc99 = new c("FINDER_LIVE_MORE_ACTION_SHOW", 98);
      hNn = localc99;
      c localc100 = new c("FINDER_LIVE_MORE_ACTION_HIDE", 99);
      hNo = localc100;
      c localc101 = new c("FINDER_LIVE_STATISTC_EVENT", 100);
      hNp = localc101;
      c localc102 = new c("FINDER_LIVE_TOP_COMMENNT", 101);
      hNq = localc102;
      c localc103 = new c("FINDER_LIVE_MSG_ACTION_SHEET", 102);
      hNr = localc103;
      c localc104 = new c("FINDER_LIVE_POST_PORTRAIT_ACTION", 103);
      hNs = localc104;
      c localc105 = new c("FINDER_LIVE_RESET_POST_PORTRAIT_ACTION", 104);
      hNt = localc105;
      c localc106 = new c("FINDER_LIVE_POST_LANDSCAPE_ACTION", 105);
      hNu = localc106;
      c localc107 = new c("FINDER_LIVE_RESET_POST_LANDSCAPE_ACTION", 106);
      hNv = localc107;
      c localc108 = new c("FINDER_LIVE_RESET_POST_ACTION", 107);
      hNw = localc108;
      c localc109 = new c("FINDER_LIVE_SHOW_CAMERA_OPT_SHEET", 108);
      hNx = localc109;
      c localc110 = new c("FINDER_LIVE_HIDE_CAMERA_OPT_SHEET", 109);
      hNy = localc110;
      c localc111 = new c("FINDER_LIVE_CREATE_ERROR_PAGE", 110);
      hNz = localc111;
      c localc112 = new c("FINDER_LIVE_CREATE_LOTTERY_SUCCESS", 111);
      hNA = localc112;
      c localc113 = new c("FINDER_LIVE_CANCEL_LOTTERY_SUCCESS", 112);
      hNB = localc113;
      c localc114 = new c("FINDER_LIVE_LOTTERY_BUBBLE_SHOW", 113);
      hNC = localc114;
      c localc115 = new c("FINDER_LIVE_LOTTERY_BUBBLE_HIDE", 114);
      hND = localc115;
      c localc116 = new c("FINDER_LIVE_LOTTERY_CARD_SHOW", 115);
      hNE = localc116;
      c localc117 = new c("FINDER_LIVE_LOTTERY_CARD_HIDE", 116);
      hNF = localc117;
      c localc118 = new c("FINDER_LIVE_LOTTERY_UPDATE", 117);
      hNG = localc118;
      c localc119 = new c("FINDER_LIVE_LOTTERY_UPDATE_COUNTDOWN", 118);
      hNH = localc119;
      c localc120 = new c("FINDER_LIVE_LIKE_SHAKE", 119);
      hNI = localc120;
      c localc121 = new c("FINDER_LIVE_SHOW_ALERT_DIALOG", 120);
      hNJ = localc121;
      c localc122 = new c("FINDER_LIVE_POST_HL_LIKE", 121);
      hNK = localc122;
      c localc123 = new c("FINDER_LIVE_LINK_MIC_VISITOR_REQUEST", 122);
      hNL = localc123;
      c localc124 = new c("FINDER_LIVE_LINK_MIC_SHOW_APPLY_LIST", 123);
      hNM = localc124;
      c localc125 = new c("FINDER_LIVE_LINK_MIC_HIDE_APPLY_LIST", 124);
      hNN = localc125;
      c localc126 = new c("FINDER_LIVE_LINK_MIC_ANCHOR_ACCEPT", 125);
      hNO = localc126;
      c localc127 = new c("FINDER_LIVE_LINK_MIC_HANGUP_LINK", 126);
      hNP = localc127;
      c localc128 = new c("FINDER_LIVE_LINK_MIC_ADD_BOTTOM_BAR", 127);
      hNQ = localc128;
      c localc129 = new c("FINDER_LIVE_LINK_MIC_REMOVE_BOTTOM_BAR", 128);
      hNR = localc129;
      c localc130 = new c("FINDER_LIVE_LINK_MIC_ANCHOR_SETTING", 129);
      hNS = localc130;
      c localc131 = new c("FINDER_LIVE_LINK_MIC_SHOW_APPLY_LICENSE", 130);
      hNT = localc131;
      c localc132 = new c("FINDER_LIVE_LINK_MIC_HIDE_APPLY_LICENSE", 131);
      hNU = localc132;
      c localc133 = new c("FINDER_LIVE_LINK_MIC_CHECKED", 132);
      hNV = localc133;
      c localc134 = new c("FINDER_LIVE_SHOW_EXPLAIN_WECOIN_HOT", 133);
      hNW = localc134;
      c localc135 = new c("FINDER_LIVE_HIDE_EXPLAIN_WECOIN_HOT", 134);
      hNX = localc135;
      hNY = new c[] { localc1, localc2, localc3, localc4, localc5, localc6, localc7, localc8, localc9, localc10, localc11, localc12, localc13, localc14, localc15, localc16, localc17, localc18, localc19, localc20, localc21, localc22, localc23, localc24, localc25, localc26, localc27, localc28, localc29, localc30, localc31, localc32, localc33, localc34, localc35, localc36, localc37, localc38, localc39, localc40, localc41, localc42, localc43, localc44, localc45, localc46, localc47, localc48, localc49, localc50, localc51, localc52, localc53, localc54, localc55, localc56, localc57, localc58, localc59, localc60, localc61, localc62, localc63, localc64, localc65, localc66, localc67, localc68, localc69, localc70, localc71, localc72, localc73, localc74, localc75, localc76, localc77, localc78, localc79, localc80, localc81, localc82, localc83, localc84, localc85, localc86, localc87, localc88, localc89, localc90, localc91, localc92, localc93, localc94, localc95, localc96, localc97, localc98, localc99, localc100, localc101, localc102, localc103, localc104, localc105, localc106, localc107, localc108, localc109, localc110, localc111, localc112, localc113, localc114, localc115, localc116, localc117, localc118, localc119, localc120, localc121, localc122, localc123, localc124, localc125, localc126, localc127, localc128, localc129, localc130, localc131, localc132, localc133, localc134, localc135 };
      AppMethodBeat.o(207871);
    }
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.b
 * JD-Core Version:    0.7.0.1
 */