package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.g.b.v.a;
import d.l;
import d.y;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/search/EmojiSuggest;", "Lcom/tencent/mm/emoji/model/search/AbsEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "local", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestLocal;", "remote", "Lcom/tencent/mm/emoji/model/search/EmojiSuggestMatchWord;", "remoteAfterLocal", "", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "distinctResult", "", "", "newList", "", "searchSuggest", "content", "", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "chatId", "sessionId", "Companion", "plugin-emojisdk_release"})
public final class b
  extends a
{
  public static final a fOM;
  public final d fOJ;
  public final e fOK;
  private final LinkedList<h> fOL;
  
  static
  {
    AppMethodBeat.i(193399);
    fOM = new a((byte)0);
    AppMethodBeat.o(193399);
  }
  
  public b(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb)
  {
    super(paramb);
    AppMethodBeat.i(193398);
    this.fOJ = new d();
    this.fOK = new e(paramb);
    this.fOL = new LinkedList();
    AppMethodBeat.o(193398);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/search/EmojiSuggest$Companion;", "", "()V", "MaxResultSize", "", "RemoteValidTime", "", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(b paramb, Object paramObject, v.a parama, f.b paramb1) {}
    
    public final void run()
    {
      AppMethodBeat.i(193395);
      ad.i(g.abb(), "searchSuggest: callback delay");
      if (!this.fON.cBX)
      {
        AppMethodBeat.o(193395);
        return;
      }
      synchronized (this.fOO)
      {
        if (!this.fOP.Jhs)
        {
          this.fOP.Jhs = true;
          localObject2 = this.fOQ;
          if (localObject2 != null) {
            ((f.b)localObject2).ac((List)b.a(this.fON));
          }
        }
        Object localObject2 = y.JfV;
        AppMethodBeat.o(193395);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$localCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "plugin-emojisdk_release"})
  public static final class c
    implements f.b
  {
    public c(Object paramObject, v.a parama1, v.a parama2, v.a parama3, f.b paramb) {}
    
    public final void ac(List<h> paramList)
    {
      AppMethodBeat.i(193396);
      k.h(paramList, "emojiList");
      ad.i(g.abb(), "onResult: local " + paramList.size());
      if (!this.fON.cBX)
      {
        AppMethodBeat.o(193396);
        return;
      }
      synchronized (this.fOO)
      {
        this.fOR.Jhs = true;
        b.d((List)b.a(this.fON), paramList);
        if ((this.fOS.Jhs) && (!this.fOP.Jhs))
        {
          this.fOP.Jhs = true;
          paramList = this.fOQ;
          if (paramList != null) {
            paramList.ac((List)b.a(this.fON));
          }
        }
        paramList = y.JfV;
        AppMethodBeat.o(193396);
        return;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/model/search/EmojiSuggest$searchSuggest$remoteCallback$1", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "onResult", "", "emojiList", "", "Lcom/tencent/mm/emoji/model/search/SuggestEmojiItem;", "plugin-emojisdk_release"})
  public static final class d
    implements f.b
  {
    public d(Object paramObject, v.a parama1, v.a parama2, v.a parama3, f.b paramb) {}
    
    public final void ac(List<h> paramList)
    {
      AppMethodBeat.i(193397);
      k.h(paramList, "emojiList");
      ad.i(g.abb(), "onResult: remote " + paramList.size());
      if (!this.fON.cBX)
      {
        AppMethodBeat.o(193397);
        return;
      }
      synchronized (this.fOO)
      {
        this.fOS.Jhs = true;
        b.d((List)b.a(this.fON), paramList);
        if ((!this.fOP.Jhs) && (this.fOR.Jhs))
        {
          this.fOP.Jhs = true;
          paramList = this.fOQ;
          if (paramList != null) {
            paramList.ac((List)b.a(this.fON));
          }
        }
        paramList = y.JfV;
        AppMethodBeat.o(193397);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.b
 * JD-Core Version:    0.7.0.1
 */