package com.tencent.mm.emoji.a.b;

import com.tencent.mm.vending.e.b;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/search/EmojiSuggestMatchWord;", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest;", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "TAG", "", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "sessionId", "username", "searchSuggest", "", "content", "callback", "Lcom/tencent/mm/emoji/model/search/IEmojiSuggest$SuggestCallback;", "setRequestInfo", "", "chatId", "plugin-emojisdk_release"})
public final class e
  implements f
{
  public final String TAG;
  public final b<com.tencent.mm.vending.e.a> fOI;
  public String sessionId;
  public String username;
  
  public e(b<com.tencent.mm.vending.e.a> paramb)
  {
    this.fOI = paramb;
    this.TAG = "MicroMsg.EmojiSuggestMatchWord";
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RecommendPanelEmojiResponse;", "kotlin.jvm.PlatformType", "call", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  public static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    public a(e parame, f.b paramb) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.e
 * JD-Core Version:    0.7.0.1
 */