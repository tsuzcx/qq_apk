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

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/search/EmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "local", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "remote", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "checkMatch", "", "desc", "", "distinctResult", "", "", "newList", "", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "sessionId", "Companion", "plugin-emojisdk_release"})
public final class b
  extends a
{
  public static final b.a jKr;
  private final e jKo;
  public final f jKp;
  private final LinkedList<l> jKq;
  
  static
  {
    AppMethodBeat.i(226730);
    jKr = new b.a((byte)0);
    AppMethodBeat.o(226730);
  }
  
  public b(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    super(paramb);
    AppMethodBeat.i(226727);
    this.jKo = new e();
    this.jKp = new f(paramb);
    this.jKq = new LinkedList();
    AppMethodBeat.o(226727);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    public b(b paramb, String paramString, j.b paramb1)
    {
      super();
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$localCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
    public static final class a
      implements j.b
    {
      a(LinkedList paramLinkedList, b.b.b paramb) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(230434);
        p.k(paramList, "emojiList");
        p.k(paramm, "wordInfo");
        Log.i(k.aBy(), "onResult: local " + paramList.size());
        if (!this.jKv.jKs.dfl)
        {
          AppMethodBeat.o(230434);
          return;
        }
        this.jKw.addAll((Collection)paramList);
        b.b(this.jKv.jKs).a(this.jKv.jKt, (j.b)this.jKx);
        AppMethodBeat.o(230434);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$remoteCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
    public static final class b
      implements j.b
    {
      b(boolean paramBoolean, LinkedList paramLinkedList) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(225876);
        p.k(paramList, "emojiList");
        p.k(paramm, "wordInfo");
        Log.i(k.aBy(), "onResult: remote " + paramList.size());
        if (!this.jKv.jKs.dfl)
        {
          AppMethodBeat.o(225876);
          return;
        }
        Object localObject1;
        Iterator localIterator;
        long l1;
        label287:
        Object localObject2;
        long l2;
        if (this.jKy)
        {
          localObject1 = new LinkedList((Collection)paramList);
          ((LinkedList)localObject1).addAll((Collection)this.jKw);
          localIterator = ((Iterable)localObject1).iterator();
          if (!localIterator.hasNext()) {
            localObject1 = null;
          }
          do
          {
            localObject1 = (l)localObject1;
            if (localObject1 != null)
            {
              ((l)localObject1).jKP = 1;
              b.c(this.jKv.jKs).add(localObject1);
            }
            b.d((List)b.c(this.jKv.jKs), paramList);
            b.d((List)b.c(this.jKv.jKs), (List)this.jKw);
            paramList = this.jKv.jKu;
            if (paramList != null) {
              paramList.a((List)b.c(this.jKv.jKs), paramm);
            }
            paramList = d.jKB;
            d.Z((List)b.c(this.jKv.jKs));
            AppMethodBeat.o(225876);
            return;
            localObject1 = localIterator.next();
          } while (!localIterator.hasNext());
          l1 = ((l)localObject1).jHh.field_lastUseTime;
          localObject2 = localIterator.next();
          l2 = ((l)localObject2).jHh.field_lastUseTime;
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
            localIterator = ((Iterable)this.jKw).iterator();
            if (!localIterator.hasNext()) {
              localObject1 = null;
            }
            for (;;)
            {
              localObject1 = (l)localObject1;
              if (localObject1 != null)
              {
                ((l)localObject1).jKP = 1;
                b.c(this.jKv.jKs).add(localObject1);
              }
              b.d((List)b.c(this.jKv.jKs), (List)this.jKw);
              b.d((List)b.c(this.jKv.jKs), paramList);
              break;
              localObject1 = localIterator.next();
              if (localIterator.hasNext())
              {
                l1 = ((l)localObject1).jHh.field_lastUseTime;
                localObject2 = localIterator.next();
                l2 = ((l)localObject2).jHh.field_lastUseTime;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.c.b
 * JD-Core Version:    0.7.0.1
 */