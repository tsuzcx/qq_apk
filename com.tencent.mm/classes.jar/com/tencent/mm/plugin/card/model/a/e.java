package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ayf;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vending.c.a;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"})
public final class e
  extends j<ayg>
{
  private static final String TAG = "MicroMsg.CgiGetCardEntranceStyle";
  public static final a oBg;
  
  static
  {
    AppMethodBeat.i(112392);
    oBg = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardEntranceStyle";
    AppMethodBeat.o(112392);
  }
  
  public e()
  {
    AppMethodBeat.i(112391);
    ayf localayf = new ayf();
    ayg localayg = new ayg();
    a((cvc)localayf, (cvp)localayg, 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
    ad.i(TAG, "do get card entrance style");
    AppMethodBeat.o(112391);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "triggerGetCardEntrance", "", "force", "", "plugin-card_release"})
  public static final class a
  {
    public static void bVj()
    {
      AppMethodBeat.i(215436);
      ad.i(e.access$getTAG$cp(), "trigger get card entrance: %s", new Object[] { Boolean.TRUE });
      Object localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).ajl().get(al.a.IEV, Long.valueOf(0L));
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(215436);
        throw ((Throwable)localObject);
      }
      ((Long)localObject).longValue();
      System.currentTimeMillis();
      localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).ajl().set(al.a.IEV, Long.valueOf(System.currentTimeMillis()));
      new e().aED().h((a)a.oBh);
      AppMethodBeat.o(215436);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      public static final a oBh;
      
      static
      {
        AppMethodBeat.i(112390);
        oBh = new a();
        AppMethodBeat.o(112390);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.e
 * JD-Core Version:    0.7.0.1
 */