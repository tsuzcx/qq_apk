package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.ah;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.emoji.panel.a.r;
import com.tencent.mm.emoji.panel.a.s;
import com.tencent.mm.emoji.panel.a.u;
import com.tencent.mm.emoji.panel.a.v;
import com.tencent.mm.emoji.panel.a.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emoji/ui/EmojiSearchAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "talkName", "", "(Ljava/lang/String;)V", "gifAutoPlay", "", "maxBindViewPosition", "", "getMaxBindViewPosition", "()I", "setMaxBindViewPosition", "(I)V", "getTalkName", "()Ljava/lang/String;", "addEmojiStoreEntry", "", "getGifAutoPlay", "getItemViewType", "position", "onBindViewHolder", "holder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setBottomData", "setData", "list", "", "Lcom/tencent/mm/protocal/protobuf/RecommendEmoji;", "setEmptyData", "setErrorNetwork", "setGifAutoPlay", "play", "setLoadData", "setResultHead", "Companion", "plugin-emojisdk_release"})
public final class a
  extends com.tencent.mm.emoji.panel.a.h
{
  public static final a.a rgE;
  public boolean hbx;
  private int rgC;
  private final String rgD;
  
  static
  {
    AppMethodBeat.i(200043);
    rgE = new a.a((byte)0);
    AppMethodBeat.o(200043);
  }
  
  public a(String paramString)
  {
    this.rgD = paramString;
    this.hbx = true;
  }
  
  public final void a(q<?> paramq, int paramInt)
  {
    AppMethodBeat.i(200040);
    p.h(paramq, "holder");
    if (getItemViewType(paramInt) == 202) {
      ((z)paramq).hbx = this.hbx;
    }
    if (paramInt > this.rgC) {
      this.rgC = paramInt;
    }
    super.a(paramq, paramInt);
    AppMethodBeat.o(200040);
  }
  
  public final void cHr()
  {
    AppMethodBeat.i(200037);
    a(0, (ac)new ah(200));
    AppMethodBeat.o(200037);
  }
  
  public final q<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(200038);
    p.h(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    case 202: 
    default: 
      paramViewGroup = localLayoutInflater.inflate(2131496339, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new z(paramViewGroup, this.hbx, this.haK);
      AppMethodBeat.o(200038);
      return paramViewGroup;
    case 200: 
      paramViewGroup = localLayoutInflater.inflate(2131493933, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new s(paramViewGroup, this.haK);
      AppMethodBeat.o(200038);
      return paramViewGroup;
    case 204: 
      paramViewGroup = localLayoutInflater.inflate(2131493935, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new u(paramViewGroup);
      AppMethodBeat.o(200038);
      return paramViewGroup;
    case 201: 
      paramViewGroup = localLayoutInflater.inflate(2131496338, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new r(paramViewGroup, this.haK);
      AppMethodBeat.o(200038);
      return paramViewGroup;
    case 203: 
      paramViewGroup = localLayoutInflater.inflate(2131493936, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new v(paramViewGroup, this.haK, 2131758585, true);
      AppMethodBeat.o(200038);
      return paramViewGroup;
    case 206: 
      paramViewGroup = localLayoutInflater.inflate(2131493936, paramViewGroup, false);
      p.g(paramViewGroup, "itemView");
      paramViewGroup = (q)new v(paramViewGroup, null, 2131758587, false);
      AppMethodBeat.o(200038);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(2131493934, paramViewGroup, false);
    p.g(paramViewGroup, "itemView");
    paramViewGroup = (q)new com.tencent.mm.emoji.panel.a.t(paramViewGroup);
    AppMethodBeat.o(200038);
    return paramViewGroup;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(200042);
    if (pm(paramInt) == null)
    {
      AppMethodBeat.o(200042);
      return 200;
    }
    if ((pm(paramInt) instanceof com.tencent.mm.emoji.b.b.h))
    {
      localObject = pm(paramInt);
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.emoji.model.panel.EmojiItem");
        AppMethodBeat.o(200042);
        throw ((Throwable)localObject);
      }
      paramInt = ((com.tencent.mm.emoji.b.b.h)localObject).gYc;
      AppMethodBeat.o(200042);
      return paramInt;
    }
    Object localObject = pm(paramInt);
    if (localObject == null) {
      p.hyc();
    }
    paramInt = ((ac)localObject).type;
    AppMethodBeat.o(200042);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.a
 * JD-Core Version:    0.7.0.1
 */