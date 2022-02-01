package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.emoji.panel.a.g;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emoji.panel.a.r;
import com.tencent.mm.emoji.panel.a.t;
import com.tencent.mm.emoji.panel.a.u;
import com.tencent.mm.emoji.panel.a.v;
import com.tencent.mm.emoji.panel.a.z;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.eng;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "talkName", "", "(Ljava/lang/String;)V", "gifAutoPlay", "", "maxBindViewPosition", "", "getMaxBindViewPosition", "()I", "setMaxBindViewPosition", "(I)V", "getTalkName", "()Ljava/lang/String;", "addEmojiStoreEntry", "", "getGifAutoPlay", "getItemViewType", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBottomData", "setData", "list", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "setEmptyData", "setErrorNetwork", "setGifAutoPlay", "play", "setLoadData", "setResultHead", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends g
{
  public static final a.a xSB;
  public boolean mlE;
  private final String mpr;
  private int xSC;
  
  static
  {
    AppMethodBeat.i(270344);
    xSB = new a.a((byte)0);
    AppMethodBeat.o(270344);
  }
  
  public a(String paramString)
  {
    this.mpr = paramString;
    this.mlE = true;
  }
  
  public final void a(q<?> paramq, int paramInt)
  {
    AppMethodBeat.i(270362);
    kotlin.g.b.s.u(paramq, "holder");
    if (getItemViewType(paramInt) == 202) {
      ((z)paramq).mlE = this.mlE;
    }
    if (paramInt > this.xSC) {
      this.xSC = paramInt;
    }
    super.a(paramq, paramInt);
    AppMethodBeat.o(270362);
  }
  
  public final q<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(270359);
    kotlin.g.b.s.u(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    case 202: 
    default: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_emoji, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new z(paramViewGroup, this.mlE, this.mkY);
      AppMethodBeat.o(270359);
      return paramViewGroup;
    case 200: 
      paramViewGroup = localLayoutInflater.inflate(a.h.emoji_panel_item_search_head, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new com.tencent.mm.emoji.panel.a.s(paramViewGroup, this.mkY);
      AppMethodBeat.o(270359);
      return paramViewGroup;
    case 204: 
      paramViewGroup = localLayoutInflater.inflate(a.h.emoji_panel_item_search_result_head, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new u(paramViewGroup);
      AppMethodBeat.o(270359);
      return paramViewGroup;
    case 201: 
      paramViewGroup = localLayoutInflater.inflate(a.h.similar_emoji_panel_item_bottom, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new r(paramViewGroup, this.mkY);
      AppMethodBeat.o(270359);
      return paramViewGroup;
    case 203: 
      paramViewGroup = localLayoutInflater.inflate(a.h.emoji_panel_item_search_tips, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new v(paramViewGroup, this.mkY, a.g.result_tv, a.j.emoji_search_empty_tip, true);
      AppMethodBeat.o(270359);
      return paramViewGroup;
    case 206: 
      paramViewGroup = localLayoutInflater.inflate(a.h.emoji_panel_item_search_tips, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "itemView");
      paramViewGroup = (q)new v(paramViewGroup, null, a.g.result_tv, a.j.emoji_search_network_disconnect, false);
      AppMethodBeat.o(270359);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(a.h.emoji_panel_item_search_loading, paramViewGroup, false);
    kotlin.g.b.s.s(paramViewGroup, "itemView");
    paramViewGroup = (q)new t(paramViewGroup);
    AppMethodBeat.o(270359);
    return paramViewGroup;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(270365);
    if (rH(paramInt) == null)
    {
      AppMethodBeat.o(270365);
      return 200;
    }
    if ((rH(paramInt) instanceof h))
    {
      localObject = rH(paramInt);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
        AppMethodBeat.o(270365);
        throw ((Throwable)localObject);
      }
      paramInt = ((h)localObject).miu;
      AppMethodBeat.o(270365);
      return paramInt;
    }
    Object localObject = rH(paramInt);
    kotlin.g.b.s.checkNotNull(localObject);
    paramInt = ((ae)localObject).type;
    AppMethodBeat.o(270365);
    return paramInt;
  }
  
  public final void setData(List<? extends eng> paramList)
  {
    AppMethodBeat.i(270350);
    kotlin.g.b.s.u(paramList, "list");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      eng localeng = (eng)((Iterator)localObject).next();
      EmojiInfo localEmojiInfo = new EmojiInfo();
      d.a(localeng.abrK, localEmojiInfo, localeng.abrL);
      if ((localeng.type & 0x1) == 0) {
        localEmojiInfo.akmd = 1;
      }
      if (((localeng.type & 0x1) == 0) && ((localeng.type & 0x10) == 0)) {
        localEmojiInfo.pay = 1;
      }
      localEmojiInfo.field_catalog = EmojiInfo.aklG;
      localEmojiInfo.field_groupId = localeng.abrK.ProductID;
      paramList.add(new h(localEmojiInfo, 202));
    }
    bz((List)paramList);
    AppMethodBeat.o(270350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.a
 * JD-Core Version:    0.7.0.1
 */