package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bl;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "", "()V", "aid", "", "Ljava/lang/Integer;", "chatRoomId", "", "chattingType", "keyWord", "senderType", "timeStamp", "", "Ljava/lang/Long;", "userName", "eggRpt", "", "action", "keyWords", "initEggRptMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "isGroup", "", "name", "luckyBagRptAction", "luckyBagRptLoadingTimeMs", "timeMs", "luckyBagRptVideoInfo", "duration", "count", "sum", "setLuckyBagRptAid", "(Ljava/lang/Integer;)V", "Companion", "SingletonHolder", "plugin-eggspring_release"})
public final class a
{
  private static final a orH;
  public static final a orI;
  private String hpg;
  private Integer orC;
  private String orD;
  public Long orE;
  private Integer orF;
  public Integer orG;
  private String userName;
  
  static
  {
    AppMethodBeat.i(162208);
    orI = new a((byte)0);
    b localb = b.orK;
    orH = b.bTN();
    AppMethodBeat.o(162208);
  }
  
  public final void Ai(int paramInt)
  {
    AppMethodBeat.i(162205);
    aG(paramInt, this.hpg);
    AppMethodBeat.o(162205);
  }
  
  public final void Aj(int paramInt)
  {
    AppMethodBeat.i(162207);
    h.vKh.f(18916, new Object[] { this.orE, this.orG, Integer.valueOf(paramInt) });
    AppMethodBeat.o(162207);
  }
  
  public final void a(bl parambl, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(162204);
    k.h(parambl, "msg");
    k.h(paramString1, "name");
    k.h(paramString2, "keyWord");
    if (parambl.SH() == 1)
    {
      parambl = Integer.valueOf(1);
      this.orC = parambl;
      if (!paramBoolean) {
        break label95;
      }
      this.orD = paramString1;
      this.userName = "";
    }
    for (this.orF = Integer.valueOf(2);; this.orF = Integer.valueOf(1))
    {
      this.hpg = paramString2;
      this.orE = Long.valueOf(ce.asQ());
      AppMethodBeat.o(162204);
      return;
      parambl = Integer.valueOf(2);
      break;
      label95:
      this.userName = paramString1;
      this.orD = "";
    }
  }
  
  public final void aG(int paramInt, String paramString)
  {
    AppMethodBeat.i(162206);
    h.vKh.f(18914, new Object[] { paramString, this.orC, this.userName, this.orD, this.orE, this.orF, Integer.valueOf(paramInt) });
    AppMethodBeat.o(162206);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt$Companion;", "", "()V", "RECEIVER", "", "SENDER", "TYPE_GROUP", "TYPE_SINGLE", "instance", "Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "getInstance", "()Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "plugin-eggspring_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/eggspring/SpringEggRpt$SingletonHolder;", "", "()V", "holder", "Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "getHolder", "()Lcom/tencent/mm/plugin/eggspring/SpringEggRpt;", "plugin-eggspring_release"})
  static final class b
  {
    private static final a orJ;
    public static final b orK;
    
    static
    {
      AppMethodBeat.i(162203);
      orK = new b();
      orJ = new a((byte)0);
      AppMethodBeat.o(162203);
    }
    
    public static a bTN()
    {
      return orJ;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.a
 * JD-Core Version:    0.7.0.1
 */