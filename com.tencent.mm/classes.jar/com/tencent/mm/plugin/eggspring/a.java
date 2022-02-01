package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "", "()V", "aid", "", "Ljava/lang/Integer;", "chatRoomId", "", "chattingType", "keyWord", "senderType", "timeStamp", "", "Ljava/lang/Long;", "userName", "eggRpt", "", "action", "keyWords", "initEggRptMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isGroup", "", "name", "luckyBagRptAction", "luckyBagRptLoadingTimeMs", "timeMs", "luckyBagRptVideoInfo", "duration", "count", "sum", "setLuckyBagRptAid", "(Ljava/lang/Integer;)V", "Companion", "SingletonHolder", "plugin-eggspring_release"})
public final class a
{
  private static final a oVh;
  public static final a.a oVi;
  private String hPI;
  private Integer oVc;
  private String oVd;
  public Long oVe;
  private Integer oVf;
  public Integer oVg;
  private String userName;
  
  static
  {
    AppMethodBeat.i(162208);
    oVi = new a.a((byte)0);
    b localb = b.oVk;
    oVh = b.cbb();
    AppMethodBeat.o(162208);
  }
  
  public final void Ba(int paramInt)
  {
    AppMethodBeat.i(162205);
    aI(paramInt, this.hPI);
    AppMethodBeat.o(162205);
  }
  
  public final void Bb(int paramInt)
  {
    AppMethodBeat.i(162207);
    h.wUl.f(18916, new Object[] { this.oVe, this.oVg, Integer.valueOf(paramInt) });
    AppMethodBeat.o(162207);
  }
  
  public final void a(bo parambo, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(162204);
    k.h(parambo, "msg");
    k.h(paramString1, "name");
    k.h(paramString2, "keyWord");
    if (parambo.TB() == 1)
    {
      parambo = Integer.valueOf(1);
      this.oVc = parambo;
      if (!paramBoolean) {
        break label95;
      }
      this.oVd = paramString1;
      this.userName = "";
    }
    for (this.oVf = Integer.valueOf(2);; this.oVf = Integer.valueOf(1))
    {
      this.hPI = paramString2;
      this.oVe = Long.valueOf(ce.azH());
      AppMethodBeat.o(162204);
      return;
      parambo = Integer.valueOf(2);
      break;
      label95:
      this.userName = paramString1;
      this.oVd = "";
    }
  }
  
  public final void aI(int paramInt, String paramString)
  {
    AppMethodBeat.i(162206);
    h.wUl.f(18914, new Object[] { paramString, this.oVc, this.userName, this.oVd, this.oVe, this.oVf, Integer.valueOf(paramInt) });
    AppMethodBeat.o(162206);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "getHolder", "()Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "plugin-eggspring_release"})
  static final class b
  {
    private static final a oVj;
    public static final b oVk;
    
    static
    {
      AppMethodBeat.i(162203);
      oVk = new b();
      oVj = new a((byte)0);
      AppMethodBeat.o(162203);
    }
    
    public static a cbb()
    {
      return oVj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.a
 * JD-Core Version:    0.7.0.1
 */