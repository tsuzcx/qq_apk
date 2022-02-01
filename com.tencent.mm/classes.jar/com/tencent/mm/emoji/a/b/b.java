package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/search/EmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "local", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "remote", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestRemote;", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "checkMatch", "", "desc", "", "distinctResult", "", "", "newList", "", "searchSuggest", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "sessionId", "Companion", "plugin-emojisdk_release"})
public final class b
  extends a
{
  public static final b.a gmb;
  private final e glY;
  public final f glZ;
  private final LinkedList<l> gma;
  
  static
  {
    AppMethodBeat.i(218959);
    gmb = new b.a((byte)0);
    AppMethodBeat.o(218959);
  }
  
  public b(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    super(paramb);
    AppMethodBeat.i(218958);
    this.glY = new e();
    this.glZ = new f(paramb);
    this.gma = new LinkedList();
    AppMethodBeat.o(218958);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements d.g.a.a<z>
  {
    public b(b paramb, String paramString, j.b paramb1)
    {
      super();
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$localCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
    public static final class a
      implements j.b
    {
      a(LinkedList paramLinkedList, b.b.b paramb) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(218955);
        p.h(paramList, "emojiList");
        p.h(paramm, "wordInfo");
        ad.i(k.aeD(), "onResult: local " + paramList.size());
        if (!this.gmf.gmc.cKc)
        {
          AppMethodBeat.o(218955);
          return;
        }
        this.gmg.addAll((Collection)paramList);
        b.b(this.gmf.gmc).a(this.gmf.gmd, (j.b)this.gmh);
        AppMethodBeat.o(218955);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$1$remoteCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "wordInfo", "Lcom/tencent/mm/emoji/model/search/SuggestWordInfo;", "plugin-emojisdk_release"})
    public static final class b
      implements j.b
    {
      b(boolean paramBoolean, LinkedList paramLinkedList) {}
      
      public final void a(List<l> paramList, m paramm)
      {
        AppMethodBeat.i(218956);
        p.h(paramList, "emojiList");
        p.h(paramm, "wordInfo");
        ad.i(k.aeD(), "onResult: remote " + paramList.size());
        if (!this.gmf.gmc.cKc)
        {
          AppMethodBeat.o(218956);
          return;
        }
        Object localObject1;
        Iterator localIterator;
        long l1;
        label287:
        Object localObject2;
        long l2;
        if (this.gmi)
        {
          localObject1 = new LinkedList((Collection)paramList);
          ((LinkedList)localObject1).addAll((Collection)this.gmg);
          localIterator = ((Iterable)localObject1).iterator();
          if (!localIterator.hasNext()) {
            localObject1 = null;
          }
          do
          {
            localObject1 = (l)localObject1;
            if (localObject1 != null)
            {
              ((l)localObject1).gmz = 1;
              b.c(this.gmf.gmc).add(localObject1);
            }
            b.d((List)b.c(this.gmf.gmc), paramList);
            b.d((List)b.c(this.gmf.gmc), (List)this.gmg);
            paramList = this.gmf.gme;
            if (paramList != null) {
              paramList.a((List)b.c(this.gmf.gmc), paramm);
            }
            paramList = d.gml;
            d.U((List)b.c(this.gmf.gmc));
            AppMethodBeat.o(218956);
            return;
            localObject1 = localIterator.next();
          } while (!localIterator.hasNext());
          l1 = ((l)localObject1).gjb.field_lastUseTime;
          localObject2 = localIterator.next();
          l2 = ((l)localObject2).gjb.field_lastUseTime;
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
            localIterator = ((Iterable)this.gmg).iterator();
            if (!localIterator.hasNext()) {
              localObject1 = null;
            }
            for (;;)
            {
              localObject1 = (l)localObject1;
              if (localObject1 != null)
              {
                ((l)localObject1).gmz = 1;
                b.c(this.gmf.gmc).add(localObject1);
              }
              b.d((List)b.c(this.gmf.gmc), (List)this.gmg);
              b.d((List)b.c(this.gmf.gmc), paramList);
              break;
              localObject1 = localIterator.next();
              if (localIterator.hasNext())
              {
                l1 = ((l)localObject1).gjb.field_lastUseTime;
                localObject2 = localIterator.next();
                l2 = ((l)localObject2).gjb.field_lastUseTime;
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