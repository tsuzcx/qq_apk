package com.tencent.mm.plugin.card.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.are;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vending.c.a;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle;", "Lcom/tencent/mm/plugin/card/model/v2/CommonCardCgi;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "()V", "Companion", "plugin-card_release"})
public final class e
  extends j<are>
{
  private static final String TAG = "MicroMsg.CgiGetCardEntranceStyle";
  public static final a nuM;
  
  static
  {
    AppMethodBeat.i(112392);
    nuM = new a((byte)0);
    TAG = "MicroMsg.CgiGetCardEntranceStyle";
    AppMethodBeat.o(112392);
  }
  
  public e()
  {
    AppMethodBeat.i(112391);
    ard localard = new ard();
    are localare = new are();
    a((ckq)localard, (cld)localare, 2793, "/cgi-bin/mmpay-bin/mktgetcardentrancestyle");
    ad.i(TAG, "do get card entrance style");
    AppMethodBeat.o(112391);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/model/v2/CgiGetCardEntranceStyle$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "triggerGetCardEntrance", "", "force", "", "plugin-card_release"})
  public static final class a
  {
    public static void bJr()
    {
      AppMethodBeat.i(192667);
      ad.i(e.access$getTAG$cp(), "trigger get card entrance: %s", new Object[] { Boolean.TRUE });
      Object localObject = g.afB();
      k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.Fuw, Long.valueOf(0L));
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.Long");
        AppMethodBeat.o(192667);
        throw ((Throwable)localObject);
      }
      ((Long)localObject).longValue();
      System.currentTimeMillis();
      localObject = g.afB();
      k.g(localObject, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject).afk().set(ae.a.Fuw, Long.valueOf(System.currentTimeMillis()));
      new e().auK().h((a)a.nuN);
      AppMethodBeat.o(192667);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardEntranceStyleResponse;", "kotlin.jvm.PlatformType", "call"})
    static final class a<_Ret, _Var>
      implements a<_Ret, _Var>
    {
      public static final a nuN;
      
      static
      {
        AppMethodBeat.i(112390);
        nuN = new a();
        AppMethodBeat.o(112390);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.a.e
 * JD-Core Version:    0.7.0.1
 */