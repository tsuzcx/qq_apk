package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.g.b.a.fk;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWordsSync;", "", "()V", "requestRunning", "", "checkWordListUpdate", "", "updateWordList", "plugin-emojisdk_release"})
public final class i
{
  private static boolean fSP;
  public static final i fSQ;
  
  static
  {
    AppMethodBeat.i(209856);
    fSQ = new i();
    AppMethodBeat.o(209856);
  }
  
  public static void adf()
  {
    AppMethodBeat.i(209854);
    if (!ai.cin())
    {
      AppMethodBeat.o(209854);
      return;
    }
    com.tencent.mm.ac.c.b("EmojiSuggestWordsSync_checkWordListUpdate", (d.g.a.a)a.fSR);
    AppMethodBeat.o(209854);
  }
  
  public static void adg()
  {
    AppMethodBeat.i(209855);
    fk localfk = new fk();
    localfk.ke(bs.eWj());
    new com.tencent.mm.emoji.a.c().aBB().g((com.tencent.mm.vending.c.a)new b(localfk));
    AppMethodBeat.o(209855);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final a fSR;
    
    static
    {
      AppMethodBeat.i(209852);
      fSR = new a();
      AppMethodBeat.o(209852);
    }
    
    a()
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(fk paramfk) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.i
 * JD-Core Version:    0.7.0.1
 */