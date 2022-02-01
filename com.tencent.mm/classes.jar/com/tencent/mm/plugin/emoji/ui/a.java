package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.aj;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.panel.a.ab;
import com.tencent.mm.emoji.panel.a.i;
import com.tencent.mm.emoji.panel.a.s;
import com.tencent.mm.emoji.panel.a.u;
import com.tencent.mm.emoji.panel.a.v;
import com.tencent.mm.emoji.panel.a.w;
import com.tencent.mm.emoji.panel.a.x;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.plugin.m.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "talkName", "", "(Ljava/lang/String;)V", "gifAutoPlay", "", "maxBindViewPosition", "", "getMaxBindViewPosition", "()I", "setMaxBindViewPosition", "(I)V", "getTalkName", "()Ljava/lang/String;", "addEmojiStoreEntry", "", "getGifAutoPlay", "getItemViewType", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBottomData", "setData", "list", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "setEmptyData", "setErrorNetwork", "setGifAutoPlay", "play", "setLoadData", "setResultHead", "Companion", "plugin-emojisdk_release"})
public final class a
  extends i
{
  public static final a uJN;
  public boolean jMH;
  private int uJL;
  private final String uJM;
  
  static
  {
    AppMethodBeat.i(226053);
    uJN = new a((byte)0);
    AppMethodBeat.o(226053);
  }
  
  public a(String paramString)
  {
    this.uJM = paramString;
    this.jMH = true;
  }
  
  public final void a(s<?> params, int paramInt)
  {
    AppMethodBeat.i(226050);
    p.k(params, "holder");
    if (getItemViewType(paramInt) == 202) {
      ((ab)params).jMH = this.jMH;
    }
    if (paramInt > this.uJL) {
      this.uJL = paramInt;
    }
    super.a(params, paramInt);
    AppMethodBeat.o(226050);
  }
  
  public final void cVY()
  {
    AppMethodBeat.i(226033);
    a(0, (ae)new aj(200));
    AppMethodBeat.o(226033);
  }
  
  public final s<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(226046);
    p.k(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    case 202: 
    default: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_emoji, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new ab(paramViewGroup, this.jMH, this.jLP);
      AppMethodBeat.o(226046);
      return paramViewGroup;
    case 200: 
      paramViewGroup = localLayoutInflater.inflate(a.h.emoji_panel_item_search_head, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new u(paramViewGroup, this.jLP);
      AppMethodBeat.o(226046);
      return paramViewGroup;
    case 204: 
      paramViewGroup = localLayoutInflater.inflate(a.h.emoji_panel_item_search_result_head, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new w(paramViewGroup);
      AppMethodBeat.o(226046);
      return paramViewGroup;
    case 201: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_bottom, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new com.tencent.mm.emoji.panel.a.t(paramViewGroup, this.jLP);
      AppMethodBeat.o(226046);
      return paramViewGroup;
    case 203: 
      paramViewGroup = localLayoutInflater.inflate(a.h.emoji_panel_item_search_tips, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new x(paramViewGroup, this.jLP, a.g.result_tv, a.j.emoji_search_empty_tip, true);
      AppMethodBeat.o(226046);
      return paramViewGroup;
    case 206: 
      paramViewGroup = localLayoutInflater.inflate(a.h.emoji_panel_item_search_tips, paramViewGroup, false);
      p.j(paramViewGroup, "itemView");
      paramViewGroup = (s)new x(paramViewGroup, null, a.g.result_tv, a.j.emoji_search_network_disconnect, false);
      AppMethodBeat.o(226046);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(a.h.emoji_panel_item_search_loading, paramViewGroup, false);
    p.j(paramViewGroup, "itemView");
    paramViewGroup = (s)new v(paramViewGroup);
    AppMethodBeat.o(226046);
    return paramViewGroup;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(226052);
    if (rF(paramInt) == null)
    {
      AppMethodBeat.o(226052);
      return 200;
    }
    if ((rF(paramInt) instanceof h))
    {
      localObject = rF(paramInt);
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
        AppMethodBeat.o(226052);
        throw ((Throwable)localObject);
      }
      paramInt = ((h)localObject).jJc;
      AppMethodBeat.o(226052);
      return paramInt;
    }
    Object localObject = rF(paramInt);
    if (localObject == null) {
      p.iCn();
    }
    paramInt = ((ae)localObject).type;
    AppMethodBeat.o(226052);
    return paramInt;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchAdapter$Companion;", "", "()V", "TAG", "", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.a
 * JD-Core Version:    0.7.0.1
 */