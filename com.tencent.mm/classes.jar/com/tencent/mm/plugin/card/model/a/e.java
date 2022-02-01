package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vending.c.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"})
public final class e
  extends j<bkg>
{
  private static final String TAG = "MicroMsg.CgiGetCardEntranceStyle";
  public static final a pVr;
  
  static
  {
    AppMethodBeat.i(112392);
    pVr = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardEntranceStyle";
    AppMethodBeat.o(112392);
  }
  
  public e()
  {
    AppMethodBeat.i(112391);
    bkf localbkf = new bkf();
    bkg localbkg = new bkg();
    a((dop)localbkf, (dpc)localbkg, 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
    Log.i(TAG, "do get card entrance style");
    AppMethodBeat.o(112391);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "triggerGetCardEntrance", "", "force", "", "plugin-card_release"})
  public static final class a
  {
    public static void cup()
    {
      AppMethodBeat.i(201370);
      Log.i(e.access$getTAG$cp(), "trigger get card entrance: %s", new Object[] { Boolean.TRUE });
      Object localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).azQ().get(ar.a.Oia, Long.valueOf(0L));
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(201370);
        throw ((Throwable)localObject);
      }
      ((Long)localObject).longValue();
      System.currentTimeMillis();
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).azQ().set(ar.a.Oia, Long.valueOf(System.currentTimeMillis()));
      new e().aYI().h((a)a.pVs);
      AppMethodBeat.o(201370);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      public static final a pVs;
      
      static
      {
        AppMethodBeat.i(112390);
        pVs = new a();
        AppMethodBeat.o(112390);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.e
 * JD-Core Version:    0.7.0.1
 */