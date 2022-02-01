package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "", "()V", "appId", "", "chatRoomId", "chattingType", "", "Ljava/lang/Integer;", "keyWord", "senderType", "timeStamp", "", "Ljava/lang/Long;", "userName", "eggRpt", "", "action", "keyWords", "initEggRptMsg", "isSend", "", "isGroup", "name", "luckyBagRptAcceptedMoney", "amount", "luckyBagRptAction", "luckyBagRptLoadingTimeMs", "timeMs", "luckyBagRptVideoInfo", "videoDuration", "playCount", "playDuration", "setAppId", "Companion", "SingletonHolder", "plugin-eggspring_release"})
public final class c
{
  private static final c qUN;
  public static final c.a qUO;
  public String appId;
  public String jgR;
  public Integer qUJ;
  public String qUK;
  public Long qUL;
  public Integer qUM;
  public String userName;
  
  static
  {
    AppMethodBeat.i(162208);
    qUO = new c.a((byte)0);
    b localb = b.qUQ;
    qUN = b.cEI();
    AppMethodBeat.o(162208);
  }
  
  public final void FE(int paramInt)
  {
    AppMethodBeat.i(162205);
    aP(paramInt, this.jgR);
    AppMethodBeat.o(162205);
  }
  
  public final void FF(int paramInt)
  {
    AppMethodBeat.i(162207);
    h.CyF.a(18916, new Object[] { this.qUL, "", Integer.valueOf(paramInt), "", "", "", "", "", this.appId });
    AppMethodBeat.o(162207);
  }
  
  public final void aP(int paramInt, String paramString)
  {
    AppMethodBeat.i(162206);
    h.CyF.a(18914, new Object[] { paramString, this.qUJ, this.userName, this.qUK, this.qUL, this.qUM, Integer.valueOf(paramInt) });
    AppMethodBeat.o(162206);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "getHolder", "()Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "plugin-eggspring_release"})
  static final class b
  {
    private static final c qUP;
    public static final b qUQ;
    
    static
    {
      AppMethodBeat.i(162203);
      qUQ = new b();
      qUP = new c((byte)0);
      AppMethodBeat.o(162203);
    }
    
    public static c cEI()
    {
      return qUP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.c
 * JD-Core Version:    0.7.0.1
 */