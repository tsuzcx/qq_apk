package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.ayw;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vending.c.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"})
public final class e
  extends j<ayw>
{
  private static final String TAG = "MicroMsg.CgiGetCardEntranceStyle";
  public static final a oHI;
  
  static
  {
    AppMethodBeat.i(112392);
    oHI = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardEntranceStyle";
    AppMethodBeat.o(112392);
  }
  
  public e()
  {
    AppMethodBeat.i(112391);
    ayv localayv = new ayv();
    ayw localayw = new ayw();
    a((cvw)localayv, (cwj)localayw, 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
    ae.i(TAG, "do get card entrance style");
    AppMethodBeat.o(112391);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "triggerGetCardEntrance", "", "force", "", "plugin-card_release"})
  public static final class a
  {
    public static void bWy()
    {
      AppMethodBeat.i(218397);
      ae.i(e.access$getTAG$cp(), "trigger get card entrance: %s", new Object[] { Boolean.TRUE });
      Object localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).ajA().get(am.a.IZv, Long.valueOf(0L));
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(218397);
        throw ((Throwable)localObject);
      }
      ((Long)localObject).longValue();
      System.currentTimeMillis();
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajA().set(am.a.IZv, Long.valueOf(System.currentTimeMillis()));
      new e().aET().h((a)a.oHJ);
      AppMethodBeat.o(218397);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      public static final a oHJ;
      
      static
      {
        AppMethodBeat.i(112390);
        oHJ = new a();
        AppMethodBeat.o(112390);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.e
 * JD-Core Version:    0.7.0.1
 */