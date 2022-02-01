package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.bv;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "", "()V", "aid", "", "Ljava/lang/Integer;", "chatRoomId", "", "chattingType", "keyWord", "senderType", "timeStamp", "", "Ljava/lang/Long;", "userName", "eggRpt", "", "action", "keyWords", "initEggRptMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isGroup", "", "name", "luckyBagRptAction", "luckyBagRptLoadingTimeMs", "timeMs", "luckyBagRptVideoInfo", "duration", "count", "sum", "setLuckyBagRptAid", "(Ljava/lang/Integer;)V", "Companion", "SingletonHolder", "plugin-eggspring_release"})
public final class a
{
  private static final a pFv;
  public static final a.a pFw;
  private String ilP;
  private Integer pFq;
  private String pFr;
  public Long pFs;
  private Integer pFt;
  public Integer pFu;
  private String userName;
  
  static
  {
    AppMethodBeat.i(162208);
    pFw = new a.a((byte)0);
    b localb = b.pFy;
    pFv = b.cgV();
    AppMethodBeat.o(162208);
  }
  
  public final void BU(int paramInt)
  {
    AppMethodBeat.i(162205);
    aK(paramInt, this.ilP);
    AppMethodBeat.o(162205);
  }
  
  public final void BV(int paramInt)
  {
    AppMethodBeat.i(162207);
    g.yxI.f(18916, new Object[] { this.pFs, this.pFu, Integer.valueOf(paramInt) });
    AppMethodBeat.o(162207);
  }
  
  public final void a(bv parambv, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(162204);
    p.h(parambv, "msg");
    p.h(paramString1, "name");
    p.h(paramString2, "keyWord");
    if (parambv.VZ() == 1)
    {
      parambv = Integer.valueOf(1);
      this.pFq = parambv;
      if (!paramBoolean) {
        break label95;
      }
      this.pFr = paramString1;
      this.userName = "";
    }
    for (this.pFt = Integer.valueOf(2);; this.pFt = Integer.valueOf(1))
    {
      this.ilP = paramString2;
      this.pFs = Long.valueOf(ch.aDa());
      AppMethodBeat.o(162204);
      return;
      parambv = Integer.valueOf(2);
      break;
      label95:
      this.userName = paramString1;
      this.pFr = "";
    }
  }
  
  public final void aK(int paramInt, String paramString)
  {
    AppMethodBeat.i(162206);
    g.yxI.f(18914, new Object[] { paramString, this.pFq, this.userName, this.pFr, this.pFs, this.pFt, Integer.valueOf(paramInt) });
    AppMethodBeat.o(162206);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "getHolder", "()Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "plugin-eggspring_release"})
  static final class b
  {
    private static final a pFx;
    public static final b pFy;
    
    static
    {
      AppMethodBeat.i(162203);
      pFy = new b();
      pFx = new a((byte)0);
      AppMethodBeat.o(162203);
    }
    
    public static a cgV()
    {
      return pFx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.a
 * JD-Core Version:    0.7.0.1
 */