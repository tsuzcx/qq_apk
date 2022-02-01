package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.ao;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants;", "", "()V", "AnchorErrStastus", "Companion", "Confetti", "LiveConfigBitSet", "LiveMsgType", "LiveStatus", "Log", "MMKV", "MenuItem", "TestMMKV", "TimeOut", "TrtcRole", "UIRouter", "plugin-logic_release"})
public final class e
{
  private static final String qYk = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&liveroomid=%s";
  private static final String qYl = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=live_forensic/index";
  public static final a qYm;
  
  static
  {
    AppMethodBeat.i(202588);
    qYm = new a((byte)0);
    qYk = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&liveroomid=%s";
    qYl = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=live_forensic/index";
    AppMethodBeat.o(202588);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants$Companion;", "", "()V", "ExposeH5Url", "", "getExposeH5Url", "()Ljava/lang/String;", "VISITOR_GUIDE_URL", "getVISITOR_GUIDE_URL", "plugin-logic_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants$Confetti;", "", "()V", "CONFETTI_SIZE", "", "getCONFETTI_SIZE", "()I", "plugin-logic_release"})
  public static final class b
  {
    private static final int qYn;
    public static final b qYo;
    
    static
    {
      AppMethodBeat.i(202579);
      qYo = new b();
      qYn = ao.fromDPToPix(aj.getContext(), 32);
      AppMethodBeat.o(202579);
    }
    
    public static int elZ()
    {
      return qYn;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants$LiveMsgType;", "", "()V", "MM_LIVE_SYS_MSG", "", "getMM_LIVE_SYS_MSG", "()I", "MM_LIVE_TEXT_MSG", "getMM_LIVE_TEXT_MSG", "plugin-logic_release"})
  public static final class c
  {
    private static final int qYp = 1;
    private static final int qYq = 10001;
    public static final c qYs;
    
    static
    {
      AppMethodBeat.i(202580);
      qYs = new c();
      qYp = 1;
      qYq = 10001;
      AppMethodBeat.o(202580);
    }
    
    public static int ema()
    {
      return qYp;
    }
    
    public static int emb()
    {
      return qYq;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants$LiveStatus;", "", "()V", "MM_LIVE_STATUS_END", "", "getMM_LIVE_STATUS_END", "()I", "MM_LIVE_STATUS_OPEN", "getMM_LIVE_STATUS_OPEN", "MM_LIVE_STATUS_REPLAY", "getMM_LIVE_STATUS_REPLAY", "MM_LIVE_STATUS_REPLAY_END", "getMM_LIVE_STATUS_REPLAY_END", "MM_LIVE_STATUS_REPLAY_SEND_MSG", "getMM_LIVE_STATUS_REPLAY_SEND_MSG", "plugin-logic_release"})
  public static final class d
  {
    private static final int qZR = 1;
    private static final int qZT = 2;
    private static final int raB = 3;
    private static final int raC = 4;
    private static final int raD = 5;
    public static final d raJ;
    
    static
    {
      AppMethodBeat.i(202581);
      raJ = new d();
      qZR = 1;
      qZT = 2;
      raB = 3;
      raC = 4;
      raD = 5;
      AppMethodBeat.o(202581);
    }
    
    public static int emd()
    {
      return raC;
    }
    
    public static int eni()
    {
      return raD;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants$MMKV;", "", "()V", "ANCHOR_VERIFY", "", "getANCHOR_VERIFY", "()Ljava/lang/String;", "KEY_ANCHOR_LIVE_ID", "getKEY_ANCHOR_LIVE_ID", "KEY_VISITOR_MIC_DIALOG", "getKEY_VISITOR_MIC_DIALOG", "TAG_LIVE_CORE", "getTAG_LIVE_CORE", "plugin-logic_release"})
  public static final class e
  {
    private static final String rBi = "anchor_verify";
    private static final String rBk = "key_visitor_mic_dialog";
    public static final e rBl;
    private static final String raK = "tag_live_core";
    private static final String rdq = "key_anchor_live_id";
    
    static
    {
      AppMethodBeat.i(202582);
      rBl = new e();
      raK = "tag_live_core";
      rdq = "key_anchor_live_id";
      rBi = "anchor_verify";
      rBk = "key_visitor_mic_dialog";
      AppMethodBeat.o(202582);
    }
    
    public static String equ()
    {
      return raK;
    }
    
    public static String eqv()
    {
      return rdq;
    }
    
    public static String eqw()
    {
      return rBi;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants$MenuItem;", "", "()V", "MENU_BAN_COMMENT", "", "getMENU_BAN_COMMENT", "()I", "MENU_QUIT_LIVE", "getMENU_QUIT_LIVE", "plugin-logic_release"})
  public static final class f
  {
    private static final int rBm = 0;
    public static final f rDA;
    private static final int rDi = 1;
    
    static
    {
      AppMethodBeat.i(202583);
      rDA = new f();
      rDi = 1;
      AppMethodBeat.o(202583);
    }
    
    public static int eNb()
    {
      return rDi;
    }
    
    public static int euW()
    {
      return rBm;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants$TestMMKV;", "", "()V", "TEST_MMKV_LIVE_FACE_VERIFY", "", "getTEST_MMKV_LIVE_FACE_VERIFY", "()Ljava/lang/String;", "TEST_MMKV_LIVE_SKIP_MOBILE_VERIFY", "getTEST_MMKV_LIVE_SKIP_MOBILE_VERIFY", "plugin-logic_release"})
  public static final class g
  {
    private static final String rFv = "test_mmkv_live_face_verify";
    private static final String rFy = "test_mmkv_live_skip_mobile_verify";
    public static final g rFz;
    
    static
    {
      AppMethodBeat.i(202584);
      rFz = new g();
      rFv = "test_mmkv_live_face_verify";
      rFy = "test_mmkv_live_skip_mobile_verify";
      AppMethodBeat.o(202584);
    }
    
    public static String eNc()
    {
      return rFv;
    }
    
    public static String eNd()
    {
      return rFy;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants$TimeOut;", "", "()V", "GET_MESSAGE_TIMEOUT", "", "getGET_MESSAGE_TIMEOUT", "()J", "REPLAY_TIMEOUT", "getREPLAY_TIMEOUT", "plugin-logic_release"})
  public static final class h
  {
    private static final long rFA = 604800000L;
    private static final long rFC = 5000L;
    public static final h rFD;
    
    static
    {
      AppMethodBeat.i(202585);
      rFD = new h();
      rFA = 604800000L;
      rFC = 5000L;
      AppMethodBeat.o(202585);
    }
    
    public static long eNw()
    {
      return rFC;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants$TrtcRole;", "", "()V", "TRTC_ROLE_ANCHOR", "", "getTRTC_ROLE_ANCHOR", "()I", "TRTC_ROLE_AUDIENCE", "getTRTC_ROLE_AUDIENCE", "plugin-logic_release"})
  public static final class i
  {
    private static final int rFE = 0;
    private static final int rFF = 1;
    public static final i rFG;
    
    static
    {
      AppMethodBeat.i(202586);
      rFG = new i();
      rFF = 1;
      AppMethodBeat.o(202586);
    }
    
    public static int eNx()
    {
      return rFE;
    }
    
    public static int eNy()
    {
      return rFF;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/model/LiveConstants$UIRouter;", "", "()V", "ROUTER_TO_ANCHOR_LIVE", "", "getROUTER_TO_ANCHOR_LIVE", "()I", "ROUTER_TO_REPLAY_LIVE", "getROUTER_TO_REPLAY_LIVE", "ROUTER_TO_VISITOR_LIVE", "getROUTER_TO_VISITOR_LIVE", "plugin-logic_release"})
  public static final class j
  {
    private static final int rFH = 0;
    private static final int rFI = 1;
    private static final int rFJ = 2;
    public static final j rFK;
    
    static
    {
      AppMethodBeat.i(202587);
      rFK = new j();
      rFI = 1;
      rFJ = 2;
      AppMethodBeat.o(202587);
    }
    
    public static int eNA()
    {
      return rFI;
    }
    
    public static int eNz()
    {
      return rFH;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.b.e
 * JD-Core Version:    0.7.0.1
 */