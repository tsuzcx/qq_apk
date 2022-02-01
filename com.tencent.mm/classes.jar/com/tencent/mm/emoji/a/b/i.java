package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.f;
import com.tencent.mm.g.b.a.gj;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWordsSync;", "", "()V", "requestRunning", "", "checkWordListUpdate", "", "updateWordList", "plugin-emojisdk_release"})
public final class i
{
  private static boolean gmt;
  public static final i gmu;
  
  static
  {
    AppMethodBeat.i(218981);
    gmu = new i();
    AppMethodBeat.o(218981);
  }
  
  public static void afL()
  {
    AppMethodBeat.i(218979);
    if (!aj.cmR())
    {
      AppMethodBeat.o(218979);
      return;
    }
    com.tencent.mm.ad.c.b("EmojiSuggestWordsSync_checkWordListUpdate", (d.g.a.a)a.gmv);
    AppMethodBeat.o(218979);
  }
  
  public static void afM()
  {
    AppMethodBeat.i(218980);
    gj localgj = new gj();
    localgj.lQ(bt.flT());
    new com.tencent.mm.emoji.a.c().aED().g((com.tencent.mm.vending.c.a)new b(localgj));
    AppMethodBeat.o(218980);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    public static final a gmv;
    
    static
    {
      AppMethodBeat.i(218977);
      gmv = new a();
      AppMethodBeat.o(218977);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(gj paramgj) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.i
 * JD-Core Version:    0.7.0.1
 */