package com.tencent.mm.emoji.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestWordsSync;", "", "()V", "requestRunning", "", "checkWordListUpdate", "", "updateWordList", "plugin-emojisdk_release"})
public final class i
{
  private static boolean goP;
  public static final i goQ;
  
  static
  {
    AppMethodBeat.i(188595);
    goQ = new i();
    AppMethodBeat.o(188595);
  }
  
  public static void afZ()
  {
    AppMethodBeat.i(188593);
    if (!ak.coh())
    {
      AppMethodBeat.o(188593);
      return;
    }
    com.tencent.mm.ac.c.b("EmojiSuggestWordsSync_checkWordListUpdate", (d.g.a.a)a.goR);
    AppMethodBeat.o(188593);
  }
  
  public static void aga()
  {
    AppMethodBeat.i(188594);
    gl localgl = new gl();
    localgl.mb(bu.fpO());
    new com.tencent.mm.emoji.a.c().aET().g((com.tencent.mm.vending.c.a)new b(localgl));
    AppMethodBeat.o(188594);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    public static final a goR;
    
    static
    {
      AppMethodBeat.i(188591);
      goR = new a();
      AppMethodBeat.o(188591);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetEmotionWordListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(gl paramgl) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c.i
 * JD-Core Version:    0.7.0.1
 */