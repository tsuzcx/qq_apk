package com.tencent.mm.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.aq;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveConstants;", "", "()V", "AnchorErrStastus", "Companion", "Confetti", "LiveConfigBitSet", "LiveMsgType", "LiveStatus", "Log", "MMKV", "MenuItem", "RequestCode", "TestMMKV", "ThresHold", "TimeOut", "TrtcRole", "UIRouter", "plugin-logic_release"})
public final class f
{
  private static final String gMS = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&liveroomid=%s";
  private static final String gMT = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=live_forensic/index";
  private static final int gMU = 5;
  public static final f.a gMV;
  
  static
  {
    AppMethodBeat.i(212049);
    gMV = new f.a((byte)0);
    gMS = "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d&liveid=%s&liveidentityid=%s&liveroomid=%s";
    gMT = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/newreadtemplate?t=live_forensic/index";
    gMU = 5;
    AppMethodBeat.o(212049);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveConstants$Confetti;", "", "()V", "CONFETTI_SIZE", "", "getCONFETTI_SIZE", "()I", "plugin-logic_release"})
  public static final class b
  {
    private static final int gMW;
    public static final b gMX;
    
    static
    {
      AppMethodBeat.i(212040);
      gMX = new b();
      gMW = aq.fromDPToPix(aj.getContext(), 40);
      AppMethodBeat.o(212040);
    }
    
    public static int amW()
    {
      return gMW;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/model/LiveConstants$MenuItem;", "", "()V", "MENU_BAN_COMMENT", "", "getMENU_BAN_COMMENT", "()I", "MENU_QUIT_LIVE", "getMENU_QUIT_LIVE", "plugin-logic_release"})
  public static final class f
  {
    private static final int gNm = 0;
    private static final int gNn = 1;
    public static final f gNo;
    
    static
    {
      AppMethodBeat.i(212044);
      gNo = new f();
      gNn = 1;
      AppMethodBeat.o(212044);
    }
    
    public static int and()
    {
      return gNm;
    }
    
    public static int ane()
    {
      return gNn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.f
 * JD-Core Version:    0.7.0.1
 */