package com.tencent.mm.emoji.panel.a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.v;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.m.a.g;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/GroupSyncItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "attachListener", "com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$attachListener$1", "Lcom/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$attachListener$1;", "callback", "com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$callback$1", "Lcom/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$callback$1;", "link", "kotlin.jvm.PlatformType", "getLink", "()Landroid/view/View;", "syncContent", "getSyncContent", "syncing", "getSyncing", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "updateSyncView", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends q<v>
{
  private final View mlm;
  private final View mln;
  private final View mlo;
  private final b mlp;
  private final a mlq;
  
  public m(View paramView, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(242427);
    this.mlm = paramView.findViewById(a.g.emoji_panel_item_sync_content);
    this.mln = paramView.findViewById(a.g.emoji_panel_item_sync_link);
    this.mlo = paramView.findViewById(a.g.emoji_panel_item_sync_syncing);
    this.mlp = new b(this);
    this.mlq = new a(this);
    paramView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this.mlq);
    paramView.setOnClickListener(null);
    this.mln.setOnClickListener(new m..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(242427);
  }
  
  private static final void a(m paramm, View paramView)
  {
    AppMethodBeat.i(242433);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramm);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramm, "this$0");
    c.b(paramm.mln.getContext(), "emoji", ".ui.EmojiMineUI", new Intent());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(242433);
  }
  
  private final void aVQ()
  {
    AppMethodBeat.i(242431);
    if (((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzC())
    {
      this.mlm.setVisibility(8);
      this.mln.setVisibility(8);
      this.mlo.setVisibility(0);
      AppMethodBeat.o(242431);
      return;
    }
    this.mlm.setVisibility(0);
    this.mln.setVisibility(0);
    this.mlo.setVisibility(8);
    AppMethodBeat.o(242431);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(242443);
    s.u(paramae, "item");
    super.a(paramae);
    aVQ();
    AppMethodBeat.o(242443);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$attachListener$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements View.OnAttachStateChangeListener
  {
    a(m paramm) {}
    
    public final void onViewAttachedToWindow(View paramView)
    {
      AppMethodBeat.i(242475);
      ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a((com.tencent.mm.emoji.sync.a)m.b(this.mlr));
      AppMethodBeat.o(242475);
    }
    
    public final void onViewDetachedFromWindow(View paramView)
    {
      AppMethodBeat.i(242479);
      ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().b((com.tencent.mm.emoji.sync.a)m.b(this.mlr));
      AppMethodBeat.o(242479);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/panel/adapter/GroupSyncViewHolder$callback$1", "Lcom/tencent/mm/emoji/sync/BKGLoaderStateCallBack;", "onLoaderStateChange", "", "onOneTaskFinish", "type", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.emoji.sync.a
  {
    b(m paramm) {}
    
    public final void aVR()
    {
      AppMethodBeat.i(242476);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.mlr));
      AppMethodBeat.o(242476);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(m paramm)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.m
 * JD-Core Version:    0.7.0.1
 */