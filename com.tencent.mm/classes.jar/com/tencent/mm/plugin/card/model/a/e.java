package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"})
public final class e
  extends j<brp>
{
  private static final String TAG = "MicroMsg.CgiGetCardEntranceStyle";
  public static final a trs;
  
  static
  {
    AppMethodBeat.i(112392);
    trs = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardEntranceStyle";
    AppMethodBeat.o(112392);
  }
  
  public e()
  {
    AppMethodBeat.i(112391);
    bro localbro = new bro();
    brp localbrp = new brp();
    a((dyl)localbro, (dyy)localbrp, 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
    Log.i(TAG, "do get card entrance style");
    AppMethodBeat.o(112391);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "triggerGetCardEntrance", "", "force", "", "plugin-card_release"})
  public static final class a
  {
    public static void cHR()
    {
      AppMethodBeat.i(245740);
      Log.i(e.access$getTAG$cp(), "trigger get card entrance: %s", new Object[] { Boolean.TRUE });
      Object localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.Vwq, Long.valueOf(0L));
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(245740);
        throw ((Throwable)localObject);
      }
      ((Long)localObject).longValue();
      System.currentTimeMillis();
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.f)localObject).aHp().set(ar.a.Vwq, Long.valueOf(System.currentTimeMillis()));
      new e().bhW().h((a)a.trt);
      AppMethodBeat.o(245740);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      public static final a trt;
      
      static
      {
        AppMethodBeat.i(112390);
        trt = new a();
        AppMethodBeat.o(112390);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.e
 * JD-Core Version:    0.7.0.1
 */