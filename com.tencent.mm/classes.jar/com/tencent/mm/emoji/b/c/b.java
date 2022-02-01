package com.tencent.mm.emoji.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/search/EmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "local", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "remote", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "checkMatch", "", "desc", "", "distinctResult", "", "", "newList", "", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "sessionId", "Companion", "plugin-emojisdk_release"})
public final class b
  extends a
{
  public static final b.a gZq;
  private final e gZn;
  public final f gZo;
  private final LinkedList<l> gZp;
  
  static
  {
    AppMethodBeat.i(199934);
    gZq = new b.a((byte)0);
    AppMethodBeat.o(199934);
  }
  
  public b(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    super(paramb);
    AppMethodBeat.i(199933);
    this.gZn = new e();
    this.gZo = new f(paramb);
    this.gZp = new LinkedList();
    AppMethodBeat.o(199933);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(b paramb, String paramString, j.b paramb1)
    {
      super();
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$localCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
    public static final class a
      implements j.b
    {
      a(LinkedList paramLinkedList, b.b.b paramb) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(199930);
        p.h(paramList, "emojiList");
        p.h(paramm, "wordInfo");
        Log.i(k.auD(), "onResult: local " + paramList.size());
        if (!this.gZu.gZr.dbi)
        {
          AppMethodBeat.o(199930);
          return;
        }
        this.gZv.addAll((Collection)paramList);
        b.b(this.gZu.gZr).a(this.gZu.gZs, (j.b)this.gZw);
        AppMethodBeat.o(199930);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$remoteCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
    public static final class b
      implements j.b
    {
      b(boolean paramBoolean, LinkedList paramLinkedList) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(199931);
        p.h(paramList, "emojiList");
        p.h(paramm, "wordInfo");
        Log.i(k.auD(), "onResult: remote " + paramList.size());
        if (!this.gZu.gZr.dbi)
        {
          AppMethodBeat.o(199931);
          return;
        }
        Object localObject1;
        Iterator localIterator;
        long l1;
        label287:
        Object localObject2;
        long l2;
        if (this.gZx)
        {
          localObject1 = new LinkedList((Collection)paramList);
          ((LinkedList)localObject1).addAll((Collection)this.gZv);
          localIterator = ((Iterable)localObject1).iterator();
          if (!localIterator.hasNext()) {
            localObject1 = null;
          }
          do
          {
            localObject1 = (l)localObject1;
            if (localObject1 != null)
            {
              ((l)localObject1).gZO = 1;
              b.c(this.gZu.gZr).add(localObject1);
            }
            b.d((List)b.c(this.gZu.gZr), paramList);
            b.d((List)b.c(this.gZu.gZr), (List)this.gZv);
            paramList = this.gZu.gZt;
            if (paramList != null) {
              paramList.a((List)b.c(this.gZu.gZr), paramm);
            }
            paramList = d.gZA;
            d.ac((List)b.c(this.gZu.gZr));
            AppMethodBeat.o(199931);
            return;
            localObject1 = localIterator.next();
          } while (!localIterator.hasNext());
          l1 = ((l)localObject1).gWm.field_lastUseTime;
          localObject2 = localIterator.next();
          l2 = ((l)localObject2).gWm.field_lastUseTime;
          if (l1 >= l2) {
            break label532;
          }
          l1 = l2;
          localObject1 = localObject2;
        }
        label527:
        label532:
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            break;
            localIterator = ((Iterable)this.gZv).iterator();
            if (!localIterator.hasNext()) {
              localObject1 = null;
            }
            for (;;)
            {
              localObject1 = (l)localObject1;
              if (localObject1 != null)
              {
                ((l)localObject1).gZO = 1;
                b.c(this.gZu.gZr).add(localObject1);
              }
              b.d((List)b.c(this.gZu.gZr), (List)this.gZv);
              b.d((List)b.c(this.gZu.gZr), paramList);
              break;
              localObject1 = localIterator.next();
              if (localIterator.hasNext())
              {
                l1 = ((l)localObject1).gWm.field_lastUseTime;
                localObject2 = localIterator.next();
                l2 = ((l)localObject2).gWm.field_lastUseTime;
                if (l1 < l2)
                {
                  l1 = l2;
                  localObject1 = localObject2;
                }
                for (;;)
                {
                  if (!localIterator.hasNext()) {
                    break label527;
                  }
                  break;
                }
              }
            }
          }
          break label287;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.b
 * JD-Core Version:    0.7.0.1
 */