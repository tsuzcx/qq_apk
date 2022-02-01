package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/egg/EmojiAnimViewPool;", "", "()V", "holderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/emoji/egg/EmojiAnimViewHolder;", "Lkotlin/collections/ArrayList;", "getHolderList", "()Ljava/util/ArrayList;", "createHolder", "msgId", "", "findHolder", "key", "", "recyclerHolder", "", "holder", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public final ArrayList<c> mfR;
  
  public d()
  {
    AppMethodBeat.i(242292);
    this.mfR = new ArrayList();
    AppMethodBeat.o(242292);
  }
  
  public final c Ek(String paramString)
  {
    AppMethodBeat.i(242302);
    s.u(paramString, "key");
    Iterator localIterator = ((Iterable)this.mfR).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!s.p(((c)localObject).mfC, paramString));
    for (paramString = localObject;; paramString = null)
    {
      paramString = (c)paramString;
      AppMethodBeat.o(242302);
      return paramString;
    }
  }
  
  public final c aUm()
  {
    AppMethodBeat.i(242296);
    c localc = new c();
    this.mfR.add(localc);
    AppMethodBeat.o(242296);
    return localc;
  }
  
  public final void e(c paramc)
  {
    AppMethodBeat.i(242305);
    s.u(paramc, "holder");
    this.mfR.remove(paramc);
    AppMethodBeat.o(242305);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.d
 * JD-Core Version:    0.7.0.1
 */