package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/egg/EmojiAnimViewPool;", "", "()V", "holderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "Lkotlin/collections/ArrayList;", "getHolderList", "()Ljava/util/ArrayList;", "createHolder", "msgId", "", "findHolder", "key", "", "recyclerHolder", "", "holder", "plugin-emojisdk_release"})
public final class d
{
  public final ArrayList<c> jGk;
  
  public d()
  {
    AppMethodBeat.i(226348);
    this.jGk = new ArrayList();
    AppMethodBeat.o(226348);
  }
  
  public final c LE(String paramString)
  {
    AppMethodBeat.i(226345);
    p.k(paramString, "key");
    Iterator localIterator = ((Iterable)this.jGk).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!p.h(((c)localObject).jFO, paramString));
    for (paramString = localObject;; paramString = null)
    {
      paramString = (c)paramString;
      AppMethodBeat.o(226345);
      return paramString;
    }
  }
  
  public final c aBo()
  {
    AppMethodBeat.i(226344);
    c localc = new c();
    this.jGk.add(localc);
    AppMethodBeat.o(226344);
    return localc;
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(226347);
    p.k(paramc, "holder");
    this.jGk.remove(paramc);
    AppMethodBeat.o(226347);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */