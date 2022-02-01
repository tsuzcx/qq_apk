package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.aw;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveConstants;", "", "()V", "AnchorErrStastus", "ChatRoomLiveFlag", "Companion", "Confetti", "FinderLiveMsgTypeExtraKey", "LiveConfigBitSet", "LiveMsgType", "LiveStatus", "Log", "MMKV", "MenuItem", "RequestCode", "TestMMKV", "ThresHold", "TimeOut", "TrtcRole", "UIRouter", "emMMFinderLiveScene", "plugin-logic_release"})
public final class l
{
  private static final String kug;
  private static final String kuh;
  private static final int kui = 5;
  public static final a kuj;
  
  static
  {
    AppMethodBeat.i(189236);
    kuj = new a((byte)0);
    kug = "https://" + WeChatHosts.domainString(b.h.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&liveroomid=%s";
    kuh = "https://" + WeChatHosts.domainString(b.h.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=live_forensic/index";
    kui = 5;
    AppMethodBeat.o(189236);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveConstants$Companion;", "", "()V", "ExposeH5Url", "", "getExposeH5Url", "()Ljava/lang/String;", "SHARE_RETRY_MAX_COUNT", "", "getSHARE_RETRY_MAX_COUNT", "()I", "VISITOR_GUIDE_URL", "getVISITOR_GUIDE_URL", "plugin-logic_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveConstants$Confetti;", "", "()V", "CONFETTI_SIZE", "", "getCONFETTI_SIZE", "()I", "HIGH_LIGHT_CONFETTI_SIZE", "getHIGH_LIGHT_CONFETTI_SIZE", "plugin-logic_release"})
  public static final class b
  {
    private static final int kuk;
    private static final int kul;
    public static final b kum;
    
    static
    {
      AppMethodBeat.i(196557);
      kum = new b();
      kuk = aw.fromDPToPix(MMApplicationContext.getContext(), 40);
      kul = aw.fromDPToPix(MMApplicationContext.getContext(), 48);
      AppMethodBeat.o(196557);
    }
    
    public static int aNC()
    {
      return kuk;
    }
    
    public static int aND()
    {
      return kul;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveConstants$MMKV;", "", "()V", "ANCHOR_VERIFY", "", "getANCHOR_VERIFY", "()Ljava/lang/String;", "KEY_ANCHOR_LIVE_ID", "getKEY_ANCHOR_LIVE_ID", "KEY_VISITOR_MIC_DIALOG", "getKEY_VISITOR_MIC_DIALOG", "TAG_LIVE_CORE", "getTAG_LIVE_CORE", "plugin-logic_release"})
  public static final class e
  {
    private static final String kuA = "key_visitor_mic_dialog";
    public static final e kuB;
    private static final String kux = "tag_live_core";
    private static final String kuy = "key_anchor_live_id";
    private static final String kuz = "anchor_verify";
    
    static
    {
      AppMethodBeat.i(200984);
      kuB = new e();
      kux = "tag_live_core";
      kuy = "key_anchor_live_id";
      kuz = "anchor_verify";
      kuA = "key_visitor_mic_dialog";
      AppMethodBeat.o(200984);
    }
    
    public static String aNJ()
    {
      return kux;
    }
    
    public static String aNK()
    {
      return kuz;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveConstants$MenuItem;", "", "()V", "MENU_BAN_COMMENT", "", "getMENU_BAN_COMMENT", "()I", "MENU_QUIT_LIVE", "getMENU_QUIT_LIVE", "MENU_QUIT_LIVE_BUT_NOT_CLOSE", "getMENU_QUIT_LIVE_BUT_NOT_CLOSE", "plugin-logic_release"})
  public static final class f
  {
    private static final int kuC = 0;
    private static final int kuD = 1;
    private static final int kuE = 2;
    public static final f kuF;
    
    static
    {
      AppMethodBeat.i(191554);
      kuF = new f();
      kuD = 1;
      kuE = 2;
      AppMethodBeat.o(191554);
    }
    
    public static int aNL()
    {
      return kuC;
    }
    
    public static int aNM()
    {
      return kuD;
    }
    
    public static int aNN()
    {
      return kuE;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveConstants$TestMMKV;", "", "()V", "TEST_MMKV_LIVE_FACE_VERIFY", "", "getTEST_MMKV_LIVE_FACE_VERIFY", "()Ljava/lang/String;", "TEST_MMKV_LIVE_SKIP_MOBILE_VERIFY", "getTEST_MMKV_LIVE_SKIP_MOBILE_VERIFY", "plugin-logic_release"})
  public static final class g
  {
    private static final String kuG = "test_mmkv_live_face_verify";
    private static final String kuH = "test_mmkv_live_skip_mobile_verify";
    public static final g kuI;
    
    static
    {
      AppMethodBeat.i(200268);
      kuI = new g();
      kuG = "test_mmkv_live_face_verify";
      kuH = "test_mmkv_live_skip_mobile_verify";
      AppMethodBeat.o(200268);
    }
    
    public static String aNO()
    {
      return kuG;
    }
    
    public static String aNP()
    {
      return kuH;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveConstants$TimeOut;", "", "()V", "GET_MESSAGE_TIMEOUT", "", "getGET_MESSAGE_TIMEOUT", "()J", "REPLAY_TIMEOUT", "getREPLAY_TIMEOUT", "plugin-logic_release"})
  public static final class h
  {
    private static final long kuJ = 604800000L;
    private static final long kuK = 5000L;
    public static final h kuL;
    
    static
    {
      AppMethodBeat.i(188772);
      kuL = new h();
      kuJ = 604800000L;
      kuK = 5000L;
      AppMethodBeat.o(188772);
    }
    
    public static long aNQ()
    {
      return kuK;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveConstants$TrtcRole;", "", "()V", "TRTC_ROLE_ANCHOR", "", "getTRTC_ROLE_ANCHOR", "()I", "TRTC_ROLE_AUDIENCE", "getTRTC_ROLE_AUDIENCE", "plugin-logic_release"})
  public static final class i
  {
    private static final int kuM = 0;
    private static final int kuN = 1;
    public static final i kuO;
    
    static
    {
      AppMethodBeat.i(189019);
      kuO = new i();
      kuN = 1;
      AppMethodBeat.o(189019);
    }
    
    public static int aNR()
    {
      return kuM;
    }
    
    public static int aNS()
    {
      return kuN;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/model/LiveConstants$UIRouter;", "", "()V", "ROUTER_TO_ANCHOR_LIVE", "", "getROUTER_TO_ANCHOR_LIVE", "()I", "ROUTER_TO_REPLAY_LIVE", "getROUTER_TO_REPLAY_LIVE", "ROUTER_TO_VISITOR_LIVE", "getROUTER_TO_VISITOR_LIVE", "plugin-logic_release"})
  public static final class j
  {
    private static final int kuP = 0;
    private static final int kuQ = 1;
    private static final int kuR = 2;
    public static final j kuS;
    
    static
    {
      AppMethodBeat.i(190373);
      kuS = new j();
      kuQ = 1;
      kuR = 2;
      AppMethodBeat.o(190373);
    }
    
    public static int aNT()
    {
      return kuP;
    }
    
    public static int aNU()
    {
      return kuQ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.l
 * JD-Core Version:    0.7.0.1
 */