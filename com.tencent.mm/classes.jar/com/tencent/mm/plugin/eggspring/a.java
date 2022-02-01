package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.bu;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "", "()V", "aid", "", "Ljava/lang/Integer;", "chatRoomId", "", "chattingType", "keyWord", "senderType", "timeStamp", "", "Ljava/lang/Long;", "userName", "eggRpt", "", "action", "keyWords", "initEggRptMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isGroup", "", "name", "luckyBagRptAction", "luckyBagRptLoadingTimeMs", "timeMs", "luckyBagRptVideoInfo", "duration", "count", "sum", "setLuckyBagRptAid", "(Ljava/lang/Integer;)V", "Companion", "SingletonHolder", "plugin-eggspring_release"})
public final class a
{
  private static final a pyR;
  public static final a.a pyS;
  private String iiW;
  private Integer pyM;
  private String pyN;
  public Long pyO;
  private Integer pyP;
  public Integer pyQ;
  private String userName;
  
  static
  {
    AppMethodBeat.i(162208);
    pyS = new a.a((byte)0);
    b localb = b.pyU;
    pyR = b.cfF();
    AppMethodBeat.o(162208);
  }
  
  public final void BI(int paramInt)
  {
    AppMethodBeat.i(162205);
    aL(paramInt, this.iiW);
    AppMethodBeat.o(162205);
  }
  
  public final void BJ(int paramInt)
  {
    AppMethodBeat.i(162207);
    g.yhR.f(18916, new Object[] { this.pyO, this.pyQ, Integer.valueOf(paramInt) });
    AppMethodBeat.o(162207);
  }
  
  public final void a(bu parambu, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(162204);
    p.h(parambu, "msg");
    p.h(paramString1, "name");
    p.h(paramString2, "keyWord");
    if (parambu.VR() == 1)
    {
      parambu = Integer.valueOf(1);
      this.pyM = parambu;
      if (!paramBoolean) {
        break label95;
      }
      this.pyN = paramString1;
      this.userName = "";
    }
    for (this.pyP = Integer.valueOf(2);; this.pyP = Integer.valueOf(1))
    {
      this.iiW = paramString2;
      this.pyO = Long.valueOf(cf.aCK());
      AppMethodBeat.o(162204);
      return;
      parambu = Integer.valueOf(2);
      break;
      label95:
      this.userName = paramString1;
      this.pyN = "";
    }
  }
  
  public final void aL(int paramInt, String paramString)
  {
    AppMethodBeat.i(162206);
    g.yhR.f(18914, new Object[] { paramString, this.pyM, this.userName, this.pyN, this.pyO, this.pyP, Integer.valueOf(paramInt) });
    AppMethodBeat.o(162206);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "getHolder", "()Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "plugin-eggspring_release"})
  static final class b
  {
    private static final a pyT;
    public static final b pyU;
    
    static
    {
      AppMethodBeat.i(162203);
      pyU = new b();
      pyT = new a((byte)0);
      AppMethodBeat.o(162203);
    }
    
    public static a cfF()
    {
      return pyT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.a
 * JD-Core Version:    0.7.0.1
 */