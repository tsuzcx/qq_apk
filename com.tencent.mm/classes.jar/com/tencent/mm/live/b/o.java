package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveConstants;", "", "()V", "AnchorErrStastus", "ChatRoomLiveFlag", "Companion", "Confetti", "FinderLiveMsgType", "LiveConfigBitSet", "LiveMsgType", "LiveStatus", "Log", "MMKV", "MenuItem", "RequestCode", "TestMMKV", "ThresHold", "TimeOut", "TrtcRole", "UIRouter", "emMMFinderLiveAppMsgType", "emMMFinderLiveScene", "plugin-logic_release"})
public final class o
{
  private static final String hGi;
  private static final String hGj;
  private static final int hGk = 5;
  public static final a hGl;
  
  static
  {
    AppMethodBeat.i(207607);
    hGl = new a((byte)0);
    hGi = "https://" + WeChatHosts.domainString(2131761748) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&liveroomid=%s";
    hGj = "https://" + WeChatHosts.domainString(2131761742) + "/cgi-bin/mmsupport-bin/newreadtemplate?t=live_forensic/index";
    hGk = 5;
    AppMethodBeat.o(207607);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveConstants$Companion;", "", "()V", "ExposeH5Url", "", "getExposeH5Url", "()Ljava/lang/String;", "SHARE_RETRY_MAX_COUNT", "", "getSHARE_RETRY_MAX_COUNT", "()I", "VISITOR_GUIDE_URL", "getVISITOR_GUIDE_URL", "plugin-logic_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveConstants$LiveStatus;", "", "()V", "MM_LIVE_STATUS_END", "", "getMM_LIVE_STATUS_END", "()I", "MM_LIVE_STATUS_OPEN", "getMM_LIVE_STATUS_OPEN", "MM_LIVE_STATUS_REPLAY", "getMM_LIVE_STATUS_REPLAY", "MM_LIVE_STATUS_REPLAY_END", "getMM_LIVE_STATUS_REPLAY_END", "MM_LIVE_STATUS_REPLAY_SEND_MSG", "getMM_LIVE_STATUS_REPLAY_SEND_MSG", "plugin-logic_release"})
  public static final class e
  {
    private static final int hGM = 1;
    private static final int hGN = 2;
    private static final int hGO = 3;
    private static final int hGP = 4;
    private static final int hGQ = 5;
    public static final e hGR;
    
    static
    {
      AppMethodBeat.i(207598);
      hGR = new e();
      hGM = 1;
      hGN = 2;
      hGO = 3;
      hGP = 4;
      hGQ = 5;
      AppMethodBeat.o(207598);
    }
    
    public static int aFA()
    {
      return hGP;
    }
    
    public static int aFB()
    {
      return hGQ;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/model/LiveConstants$UIRouter;", "", "()V", "ROUTER_TO_ANCHOR_LIVE", "", "getROUTER_TO_ANCHOR_LIVE", "()I", "ROUTER_TO_REPLAY_LIVE", "getROUTER_TO_REPLAY_LIVE", "ROUTER_TO_VISITOR_LIVE", "getROUTER_TO_VISITOR_LIVE", "plugin-logic_release"})
  public static final class k
  {
    private static final int hHk = 0;
    private static final int hHl = 1;
    private static final int hHm = 2;
    public static final k hHn;
    
    static
    {
      AppMethodBeat.i(207604);
      hHn = new k();
      hHl = 1;
      hHm = 2;
      AppMethodBeat.o(207604);
    }
    
    public static int aFM()
    {
      return hHk;
    }
    
    public static int aFN()
    {
      return hHl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.b.o
 * JD-Core Version:    0.7.0.1
 */