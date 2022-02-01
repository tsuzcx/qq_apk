package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.cw.f;
import com.tencent.mm.emoji.b.c;
import com.tencent.mm.f.b.a.mi;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWordsSync;", "", "()V", "requestRunning", "", "checkWordListUpdate", "", "updateWordList", "plugin-emojisdk_release"})
public final class i
{
  private static boolean jKJ;
  public static final i jKK;
  
  static
  {
    AppMethodBeat.i(229401);
    jKK = new i();
    AppMethodBeat.o(229401);
  }
  
  public static void aCJ()
  {
    AppMethodBeat.i(229394);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(229394);
      return;
    }
    d.b("EmojiSuggestWordsSync_checkWordListUpdate", (kotlin.g.a.a)a.jKL);
    AppMethodBeat.o(229394);
  }
  
  public static void aCK()
  {
    AppMethodBeat.i(229397);
    mi localmi = new mi();
    localmi.xe(Util.nowMilliSecond());
    new c().bhW().g((com.tencent.mm.vending.c.a)new b(localmi));
    AppMethodBeat.o(229397);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final a jKL;
    
    static
    {
      AppMethodBeat.i(228853);
      jKL = new a();
      AppMethodBeat.o(228853);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(mi parammi) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.i
 * JD-Core Version:    0.7.0.1
 */