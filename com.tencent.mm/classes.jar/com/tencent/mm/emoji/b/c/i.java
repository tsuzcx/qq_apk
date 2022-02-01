package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.co.f;
import com.tencent.mm.emoji.b.c;
import com.tencent.mm.g.b.a.jz;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWordsSync;", "", "()V", "requestRunning", "", "checkWordListUpdate", "", "updateWordList", "plugin-emojisdk_release"})
public final class i
{
  private static boolean gZI;
  public static final i gZJ;
  
  static
  {
    AppMethodBeat.i(199956);
    gZJ = new i();
    AppMethodBeat.o(199956);
  }
  
  public static void avN()
  {
    AppMethodBeat.i(199954);
    if (!MMApplicationContext.isMainProcess())
    {
      AppMethodBeat.o(199954);
      return;
    }
    d.b("EmojiSuggestWordsSync_checkWordListUpdate", (kotlin.g.a.a)a.gZK);
    AppMethodBeat.o(199954);
  }
  
  public static void avO()
  {
    AppMethodBeat.i(199955);
    jz localjz = new jz();
    localjz.td(Util.nowMilliSecond());
    new c().aYI().g((com.tencent.mm.vending.c.a)new b(localjz));
    AppMethodBeat.o(199955);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final a gZK;
    
    static
    {
      AppMethodBeat.i(199952);
      gZK = new a();
      AppMethodBeat.o(199952);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(jz paramjz) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.i
 * JD-Core Version:    0.7.0.1
 */