package com.tencent.mm.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.h;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveConstants;", "", "()V", "AnchorErrStastus", "ChatRoomLiveFlag", "Companion", "Confetti", "FinderLiveMsgTypeExtraKey", "LiveConfigBitSet", "LiveMsgType", "LiveStatus", "Log", "MMKV", "MenuItem", "RequestCode", "TestMMKV", "ThresHold", "TimeOut", "TrtcRole", "UIRouter", "emMMFinderLiveScene", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l.a mYb;
  private static final String mYc;
  private static final String mYd;
  private static final int mYe;
  
  static
  {
    AppMethodBeat.i(246583);
    mYb = new l.a((byte)0);
    mYc = "https://" + WeChatHosts.domainString(b.h.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&liveroomid=%s";
    mYd = "https://" + WeChatHosts.domainString(b.h.host_support_weixin_qq_com) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=live_forensic/index";
    mYe = 5;
    AppMethodBeat.o(246583);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveConstants$MMKV;", "", "()V", "ANCHOR_VERIFY", "", "getANCHOR_VERIFY", "()Ljava/lang/String;", "KEY_ANCHOR_LIVE_ID", "getKEY_ANCHOR_LIVE_ID", "KEY_VISITOR_MIC_DIALOG", "getKEY_VISITOR_MIC_DIALOG", "TAG_LIVE_CORE", "getTAG_LIVE_CORE", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
  {
    public static final e mYs;
    private static final String mYt;
    private static final String mYu;
    private static final String mYv;
    private static final String mYw;
    
    static
    {
      AppMethodBeat.i(246631);
      mYs = new e();
      mYt = "tag_live_core";
      mYu = "key_anchor_live_id";
      mYv = "anchor_verify";
      mYw = "key_visitor_mic_dialog";
      AppMethodBeat.o(246631);
    }
    
    public static String bhu()
    {
      return mYt;
    }
    
    public static String bhv()
    {
      return mYv;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveConstants$TestMMKV;", "", "()V", "TEST_MMKV_LIVE_FACE_VERIFY", "", "getTEST_MMKV_LIVE_FACE_VERIFY", "()Ljava/lang/String;", "TEST_MMKV_LIVE_SKIP_MOBILE_VERIFY", "getTEST_MMKV_LIVE_SKIP_MOBILE_VERIFY", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
  {
    public static final g mYB;
    private static final String mYC;
    private static final String mYD;
    
    static
    {
      AppMethodBeat.i(246651);
      mYB = new g();
      mYC = "test_mmkv_live_face_verify";
      mYD = "test_mmkv_live_skip_mobile_verify";
      AppMethodBeat.o(246651);
    }
    
    public static String bhA()
    {
      return mYD;
    }
    
    public static String bhz()
    {
      return mYC;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/live/model/LiveConstants$UIRouter;", "", "()V", "ROUTER_TO_ANCHOR_LIVE", "", "getROUTER_TO_ANCHOR_LIVE", "()I", "ROUTER_TO_REPLAY_LIVE", "getROUTER_TO_REPLAY_LIVE", "ROUTER_TO_VISITOR_LIVE", "getROUTER_TO_VISITOR_LIVE", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
  {
    public static final j mYK;
    private static final int mYL = 0;
    private static final int mYM;
    private static final int mYN;
    
    static
    {
      AppMethodBeat.i(246639);
      mYK = new j();
      mYM = 1;
      mYN = 2;
      AppMethodBeat.o(246639);
    }
    
    public static int bhE()
    {
      return mYL;
    }
    
    public static int bhF()
    {
      return mYM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.model.l
 * JD-Core Version:    0.7.0.1
 */