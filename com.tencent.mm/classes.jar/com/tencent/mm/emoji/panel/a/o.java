package com.tencent.mm.emoji.panel.a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.v;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.m.a.g;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupSyncItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "attachListener", "com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$attachListener$1", "Lcom/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$attachListener$1;", "callback", "com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$callback$1", "Lcom/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$callback$1;", "link", "kotlin.jvm.PlatformType", "getLink", "()Landroid/view/View;", "syncContent", "getSyncContent", "syncing", "getSyncing", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "updateSyncView", "plugin-emojisdk_release"})
public final class o
  extends s<v>
{
  private final View jMh;
  final View jMi;
  private final View jMj;
  private final o.b jMk;
  private final o.a jMl;
  
  public o(View paramView, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(227471);
    this.jMh = paramView.findViewById(a.g.emoji_panel_item_sync_content);
    this.jMi = paramView.findViewById(a.g.emoji_panel_item_sync_link);
    this.jMj = paramView.findViewById(a.g.emoji_panel_item_sync_syncing);
    this.jMk = new o.b(this);
    this.jMl = new o.a(this);
    paramView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this.jMl);
    paramView.setOnClickListener(null);
    this.jMi.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(223561);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = this.jMm.jMi;
        kotlin.g.b.p.j(paramAnonymousView, "link");
        c.b(paramAnonymousView.getContext(), "emoji", ".ui.EmojiMineUI", new Intent());
        a.a(this, "com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(223561);
      }
    });
    AppMethodBeat.o(227471);
  }
  
  private final void aCS()
  {
    AppMethodBeat.i(227468);
    Object localObject = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr();
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginEmoji::class.java).emojiMgr");
    if (((com.tencent.mm.pluginsdk.b.d)localObject).cUv())
    {
      localObject = this.jMh;
      kotlin.g.b.p.j(localObject, "syncContent");
      ((View)localObject).setVisibility(8);
      localObject = this.jMi;
      kotlin.g.b.p.j(localObject, "link");
      ((View)localObject).setVisibility(8);
      localObject = this.jMj;
      kotlin.g.b.p.j(localObject, "syncing");
      ((View)localObject).setVisibility(0);
      AppMethodBeat.o(227468);
      return;
    }
    localObject = this.jMh;
    kotlin.g.b.p.j(localObject, "syncContent");
    ((View)localObject).setVisibility(0);
    localObject = this.jMi;
    kotlin.g.b.p.j(localObject, "link");
    ((View)localObject).setVisibility(0);
    localObject = this.jMj;
    kotlin.g.b.p.j(localObject, "syncing");
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(227468);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(227464);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    aCS();
    AppMethodBeat.o(227464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.o
 * JD-Core Version:    0.7.0.1
 */