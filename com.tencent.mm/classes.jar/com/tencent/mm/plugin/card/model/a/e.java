package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vending.c.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"})
public final class e
  extends j<aui>
{
  private static final String TAG = "MicroMsg.CgiGetCardEntranceStyle";
  public static final a nXM;
  
  static
  {
    AppMethodBeat.i(112392);
    nXM = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardEntranceStyle";
    AppMethodBeat.o(112392);
  }
  
  public e()
  {
    AppMethodBeat.i(112391);
    auh localauh = new auh();
    aui localaui = new aui();
    a((cpx)localauh, (cqk)localaui, 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
    ac.i(TAG, "do get card entrance style");
    AppMethodBeat.o(112391);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "triggerGetCardEntrance", "", "force", "", "plugin-card_release"})
  public static final class a
  {
    public static void bQE()
    {
      AppMethodBeat.i(206241);
      ac.i(e.access$getTAG$cp(), "trigger get card entrance: %s", new Object[] { Boolean.TRUE });
      Object localObject = g.agR();
      k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).agA().get(ah.a.GSq, Long.valueOf(0L));
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(206241);
        throw ((Throwable)localObject);
      }
      ((Long)localObject).longValue();
      System.currentTimeMillis();
      localObject = g.agR();
      k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).agA().set(ah.a.GSq, Long.valueOf(System.currentTimeMillis()));
      new e().aBB().h((a)a.nXN);
      AppMethodBeat.o(206241);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      public static final a nXN;
      
      static
      {
        AppMethodBeat.i(112390);
        nXN = new a();
        AppMethodBeat.o(112390);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.e
 * JD-Core Version:    0.7.0.1
 */