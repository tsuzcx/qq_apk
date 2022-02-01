package com.tencent.mm.emoji.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/search/EmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "local", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "remote", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "checkMatch", "", "desc", "", "distinctResult", "", "", "newList", "", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "sessionId", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  public static final b.a mjE;
  private final e mjF;
  private final f mjG;
  private final LinkedList<l> mjH;
  
  static
  {
    AppMethodBeat.i(242697);
    mjE = new b.a((byte)0);
    AppMethodBeat.o(242697);
  }
  
  public b(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    super(paramb);
    AppMethodBeat.i(242679);
    this.mjF = new e();
    this.mjG = new f(paramb);
    this.mjH = new LinkedList();
    AppMethodBeat.o(242679);
  }
  
  public final void a(final String paramString, final j.b paramb)
  {
    AppMethodBeat.i(242701);
    s.u(paramString, "desc");
    d locald = d.mjQ;
    d.rG(0);
    com.tencent.mm.ae.d.d("EmojiSuggest_searchSuggest", (kotlin.g.a.a)new b(this, paramString, paramb));
    AppMethodBeat.o(242701);
  }
  
  public final void ay(String paramString1, String paramString2)
  {
    AppMethodBeat.i(242698);
    s.u(paramString2, "sessionId");
    f localf = this.mjG;
    s.u(paramString2, "sessionId");
    localf.username = paramString1;
    localf.sessionId = paramString2;
    AppMethodBeat.o(242698);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b paramb, String paramString, j.b paramb1)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$localCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements j.b
    {
      a(b paramb, LinkedList<l> paramLinkedList, String paramString, b.b.b paramb1) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(242664);
        s.u(paramList, "emojiList");
        s.u(paramm, "wordInfo");
        Log.i(k.aUw(), s.X("onResult: local ", Integer.valueOf(paramList.size())));
        if (!this.mjI.fez)
        {
          AppMethodBeat.o(242664);
          return;
        }
        this.mjL.addAll((Collection)paramList);
        b.b(this.mjI).a(this.mjJ, (j.b)this.mjM);
        AppMethodBeat.o(242664);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$remoteCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements j.b
    {
      b(b paramb, boolean paramBoolean, LinkedList<l> paramLinkedList, j.b paramb1) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(242665);
        s.u(paramList, "emojiList");
        s.u(paramm, "wordInfo");
        Log.i(k.aUw(), s.X("onResult: remote ", Integer.valueOf(paramList.size())));
        if (!this.mjI.fez)
        {
          AppMethodBeat.o(242665);
          return;
        }
        Object localObject1;
        Iterator localIterator;
        long l1;
        label259:
        Object localObject2;
        long l2;
        if (this.mjN)
        {
          localObject1 = new LinkedList((Collection)paramList);
          ((LinkedList)localObject1).addAll((Collection)this.mjL);
          localIterator = ((Iterable)localObject1).iterator();
          if (!localIterator.hasNext()) {
            localObject1 = null;
          }
          do
          {
            localObject1 = (l)localObject1;
            if (localObject1 != null)
            {
              ((l)localObject1).mkb = 1;
              b.c(this.mjI).add(localObject1);
            }
            b.i((List)b.c(this.mjI), paramList);
            b.i((List)b.c(this.mjI), (List)this.mjL);
            paramList = this.mjK;
            if (paramList != null) {
              paramList.a((List)b.c(this.mjI), paramm);
            }
            paramList = d.mjQ;
            d.by((List)b.c(this.mjI));
            AppMethodBeat.o(242665);
            return;
            localObject1 = localIterator.next();
          } while (!localIterator.hasNext());
          l1 = ((l)localObject1).mgK.field_lastUseTime;
          localObject2 = localIterator.next();
          l2 = ((l)localObject2).mgK.field_lastUseTime;
          if (l1 >= l2) {
            break label495;
          }
          l1 = l2;
          localObject1 = localObject2;
        }
        label490:
        label495:
        for (;;)
        {
          if (!localIterator.hasNext())
          {
            break;
            localIterator = ((Iterable)this.mjL).iterator();
            if (!localIterator.hasNext()) {
              localObject1 = null;
            }
            for (;;)
            {
              localObject1 = (l)localObject1;
              if (localObject1 != null)
              {
                ((l)localObject1).mkb = 1;
                b.c(this.mjI).add(localObject1);
              }
              b.i((List)b.c(this.mjI), (List)this.mjL);
              b.i((List)b.c(this.mjI), paramList);
              break;
              localObject1 = localIterator.next();
              if (localIterator.hasNext())
              {
                l1 = ((l)localObject1).mgK.field_lastUseTime;
                localObject2 = localIterator.next();
                l2 = ((l)localObject2).mgK.field_lastUseTime;
                if (l1 < l2)
                {
                  l1 = l2;
                  localObject1 = localObject2;
                }
                for (;;)
                {
                  if (!localIterator.hasNext()) {
                    break label490;
                  }
                  break;
                }
              }
            }
          }
          break label259;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.c.b
 * JD-Core Version:    0.7.0.1
 */