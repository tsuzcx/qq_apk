package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/egg/EmojiAnimViewPool;", "", "()V", "holderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "Lkotlin/collections/ArrayList;", "getHolderList", "()Ljava/util/ArrayList;", "createHolder", "msgId", "", "recyclerHolder", "", "holder", "plugin-emojisdk_release"})
public final class d
{
  public final ArrayList<c> gVo;
  
  public d()
  {
    AppMethodBeat.i(199885);
    this.gVo = new ArrayList();
    AppMethodBeat.o(199885);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(199884);
    p.h(paramc, "holder");
    this.gVo.remove(paramc);
    AppMethodBeat.o(199884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */