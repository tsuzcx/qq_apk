package com.tencent.mm.emoji.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/search/EmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "local", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "remote", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "checkMatch", "", "desc", "", "distinctResult", "", "", "newList", "", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "sessionId", "Companion", "plugin-emojisdk_release"})
public final class b
  extends a
{
  public static final b.a gox;
  private final e gou;
  public final f gov;
  private final LinkedList<l> gow;
  
  static
  {
    AppMethodBeat.i(188573);
    gox = new b.a((byte)0);
    AppMethodBeat.o(188573);
  }
  
  public b(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    super(paramb);
    AppMethodBeat.i(188572);
    this.gou = new e();
    this.gov = new f(paramb);
    this.gow = new LinkedList();
    AppMethodBeat.o(188572);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements d.g.a.a<z>
  {
    public b(b paramb, String paramString, j.b paramb1)
    {
      super();
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$localCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
    public static final class a
      implements j.b
    {
      a(LinkedList paramLinkedList, b.b.b paramb) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(188569);
        p.h(paramList, "emojiList");
        p.h(paramm, "wordInfo");
        ae.i(k.aeP(), "onResult: local " + paramList.size());
        if (!this.goB.goy.cKL)
        {
          AppMethodBeat.o(188569);
          return;
        }
        this.goC.addAll((Collection)paramList);
        b.b(this.goB.goy).a(this.goB.goz, (j.b)this.goD);
        AppMethodBeat.o(188569);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$remoteCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
    public static final class b
      implements j.b
    {
      b(boolean paramBoolean, LinkedList paramLinkedList) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(188570);
        p.h(paramList, "emojiList");
        p.h(paramm, "wordInfo");
        ae.i(k.aeP(), "onResult: remote " + paramList.size());
        if (!this.goB.goy.cKL)
        {
          AppMethodBeat.o(188570);
          return;
        }
        Object localObject1;
        Iterator localIterator;
        long l1;
        label287:
        Object localObject2;
        long l2;
        if (this.goE)
        {
          localObject1 = new LinkedList((Collection)paramList);
          ((LinkedList)localObject1).addAll((Collection)this.goC);
          localIterator = ((Iterable)localObject1).iterator();
          if (!localIterator.hasNext()) {
            localObject1 = null;
          }
          do
          {
            localObject1 = (l)localObject1;
            if (localObject1 != null)
            {
              ((l)localObject1).goV = 1;
              b.c(this.goB.goy).add(localObject1);
            }
            b.d((List)b.c(this.goB.goy), paramList);
            b.d((List)b.c(this.goB.goy), (List)this.goC);
            paramList = this.goB.goA;
            if (paramList != null) {
              paramList.a((List)b.c(this.goB.goy), paramm);
            }
            paramList = d.goH;
            d.U((List)b.c(this.goB.goy));
            AppMethodBeat.o(188570);
            return;
            localObject1 = localIterator.next();
          } while (!localIterator.hasNext());
          l1 = ((l)localObject1).glt.field_lastUseTime;
          localObject2 = localIterator.next();
          l2 = ((l)localObject2).glt.field_lastUseTime;
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
            localIterator = ((Iterable)this.goC).iterator();
            if (!localIterator.hasNext()) {
              localObject1 = null;
            }
            for (;;)
            {
              localObject1 = (l)localObject1;
              if (localObject1 != null)
              {
                ((l)localObject1).goV = 1;
                b.c(this.goB.goy).add(localObject1);
              }
              b.d((List)b.c(this.goB.goy), (List)this.goC);
              b.d((List)b.c(this.goB.goy), paramList);
              break;
              localObject1 = localIterator.next();
              if (localIterator.hasNext())
              {
                l1 = ((l)localObject1).glt.field_lastUseTime;
                localObject2 = localIterator.next();
                l2 = ((l)localObject2).glt.field_lastUseTime;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.c.b
 * JD-Core Version:    0.7.0.1
 */