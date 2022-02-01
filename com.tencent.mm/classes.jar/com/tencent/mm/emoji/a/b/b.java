package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/search/EmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "local", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "remote", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "checkMatch", "", "desc", "", "distinctResult", "", "", "newList", "", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "sessionId", "Companion", "plugin-emojisdk_release"})
public final class b
  extends a
{
  public static final b.a fSx;
  private final e fSu;
  public final f fSv;
  private final LinkedList<l> fSw;
  
  static
  {
    AppMethodBeat.i(209834);
    fSx = new b.a((byte)0);
    AppMethodBeat.o(209834);
  }
  
  public b(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    super(paramb);
    AppMethodBeat.i(209833);
    this.fSu = new e();
    this.fSv = new f(paramb);
    this.fSw = new LinkedList();
    AppMethodBeat.o(209833);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public b(b paramb, String paramString, j.b paramb1)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$localCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
    public static final class a
      implements j.b
    {
      a(LinkedList paramLinkedList, b.b.b paramb) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(209830);
        d.g.b.k.h(paramList, "emojiList");
        d.g.b.k.h(paramm, "wordInfo");
        ac.i(k.abZ(), "onResult: local " + paramList.size());
        if (!this.fSB.fSy.czg)
        {
          AppMethodBeat.o(209830);
          return;
        }
        this.fSC.addAll((Collection)paramList);
        b.b(this.fSB.fSy).a(this.fSB.fSz, (j.b)this.fSD);
        AppMethodBeat.o(209830);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$remoteCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
    public static final class b
      implements j.b
    {
      b(boolean paramBoolean, LinkedList paramLinkedList) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(209831);
        d.g.b.k.h(paramList, "emojiList");
        d.g.b.k.h(paramm, "wordInfo");
        ac.i(k.abZ(), "onResult: remote " + paramList.size());
        if (!this.fSB.fSy.czg)
        {
          AppMethodBeat.o(209831);
          return;
        }
        Object localObject1;
        Iterator localIterator;
        long l1;
        label287:
        Object localObject2;
        long l2;
        if (this.fSE)
        {
          localObject1 = new LinkedList((Collection)paramList);
          ((LinkedList)localObject1).addAll((Collection)this.fSC);
          localIterator = ((Iterable)localObject1).iterator();
          if (!localIterator.hasNext()) {
            localObject1 = null;
          }
          do
          {
            localObject1 = (l)localObject1;
            if (localObject1 != null)
            {
              ((l)localObject1).fSV = 1;
              b.c(this.fSB.fSy).add(localObject1);
            }
            b.d((List)b.c(this.fSB.fSy), paramList);
            b.d((List)b.c(this.fSB.fSy), (List)this.fSC);
            paramList = this.fSB.fSA;
            if (paramList != null) {
              paramList.a((List)b.c(this.fSB.fSy), paramm);
            }
            paramList = d.fSH;
            d.T((List)b.c(this.fSB.fSy));
            AppMethodBeat.o(209831);
            return;
            localObject1 = localIterator.next();
          } while (!localIterator.hasNext());
          l1 = ((l)localObject1).fPB.field_lastUseTime;
          localObject2 = localIterator.next();
          l2 = ((l)localObject2).fPB.field_lastUseTime;
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
            localIterator = ((Iterable)this.fSC).iterator();
            if (!localIterator.hasNext()) {
              localObject1 = null;
            }
            for (;;)
            {
              localObject1 = (l)localObject1;
              if (localObject1 != null)
              {
                ((l)localObject1).fSV = 1;
                b.c(this.fSB.fSy).add(localObject1);
              }
              b.d((List)b.c(this.fSB.fSy), (List)this.fSC);
              b.d((List)b.c(this.fSB.fSy), paramList);
              break;
              localObject1 = localIterator.next();
              if (localIterator.hasNext())
              {
                l1 = ((l)localObject1).fPB.field_lastUseTime;
                localObject2 = localIterator.next();
                l2 = ((l)localObject2).fPB.field_lastUseTime;
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
 * Qualified Name:     com.tencent.mm.emoji.a.b.b
 * JD-Core Version:    0.7.0.1
 */