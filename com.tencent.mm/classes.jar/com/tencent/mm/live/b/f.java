package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveConstants;", "", "()V", "AnchorErrStastus", "Companion", "Confetti", "LiveConfigBitSet", "LiveMsgType", "LiveStatus", "Log", "MMKV", "MenuItem", "RequestCode", "TestMMKV", "ThresHold", "TimeOut", "TrtcRole", "UIRouter", "plugin-logic_release"})
public final class f
{
  private static final String gth = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&liveroomid=%s";
  private static final String gti = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=live_forensic/index";
  private static final int gtj = 5;
  public static final a gtk;
  
  static
  {
    AppMethodBeat.i(189763);
    gtk = new a((byte)0);
    gth = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&liveroomid=%s";
    gti = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=live_forensic/index";
    gtj = 5;
    AppMethodBeat.o(189763);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveConstants$Companion;", "", "()V", "ExposeH5Url", "", "getExposeH5Url", "()Ljava/lang/String;", "SHARE_RETRY_MAX_COUNT", "", "getSHARE_RETRY_MAX_COUNT", "()I", "VISITOR_GUIDE_URL", "getVISITOR_GUIDE_URL", "plugin-logic_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/model/LiveConstants$TimeOut;", "", "()V", "GET_MESSAGE_TIMEOUT", "", "getGET_MESSAGE_TIMEOUT", "()J", "REPLAY_TIMEOUT", "getREPLAY_TIMEOUT", "plugin-logic_release"})
  public static final class h
  {
    private static final long gtH = 604800000L;
    private static final long gtI = 5000L;
    public static final h gtJ;
    
    static
    {
      AppMethodBeat.i(189760);
      gtJ = new h();
      gtH = 604800000L;
      gtI = 5000L;
      AppMethodBeat.o(189760);
    }
    
    public static long akv()
    {
      return gtI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.b.f
 * JD-Core Version:    0.7.0.1
 */