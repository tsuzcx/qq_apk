package com.tencent.mm.plugin.emoji.ui.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.panel.a.d;
import com.tencent.mm.emoji.panel.a.i;
import com.tencent.mm.emoji.panel.a.s;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.b;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/ui/adapter/EmojiCustomAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "()V", "mode", "Lcom/tencent/mm/plugin/emoji/ui/EmojiCustomUI$Mode;", "getMode", "()Lcom/tencent/mm/plugin/emoji/ui/EmojiCustomUI$Mode;", "setMode", "(Lcom/tencent/mm/plugin/emoji/ui/EmojiCustomUI$Mode;)V", "selectedList", "Ljava/util/LinkedList;", "", "onCreateViewHolder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "updateSelected", "", "list", "", "EmojiCustomAddViewHolder", "EmojiCustomLoadingViewHolder", "EmojiCustomSyncingViewHolder", "EmojiCustomViewHolder", "UIAction", "plugin-emoji_release"})
public final class a
  extends i
{
  EmojiCustomUI.b uMr;
  private final LinkedList<String> uMs;
  
  public a()
  {
    AppMethodBeat.i(256557);
    this.uMr = EmojiCustomUI.b.uJs;
    this.uMs = new LinkedList();
    AppMethodBeat.o(256557);
  }
  
  public final void b(EmojiCustomUI.b paramb)
  {
    AppMethodBeat.i(256551);
    kotlin.g.b.p.k(paramb, "<set-?>");
    this.uMr = paramb;
    AppMethodBeat.o(256551);
  }
  
  public final void dj(List<String> paramList)
  {
    AppMethodBeat.i(256553);
    kotlin.g.b.p.k(paramList, "list");
    this.uMs.clear();
    this.uMs.addAll((Collection)paramList);
    AppMethodBeat.o(256553);
  }
  
  public final s<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(256555);
    kotlin.g.b.p.k(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      paramViewGroup = localLayoutInflater.inflate(i.f.emoji_custom_grid_item, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "inflater.inflate(R.layou…grid_item, parent, false)");
      paramViewGroup = (s)new c(paramViewGroup, this.jLP);
      AppMethodBeat.o(256555);
      return paramViewGroup;
    case 100: 
      paramViewGroup = localLayoutInflater.inflate(i.f.emoji_custom_item_syncing, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "inflater.inflate(R.layou…m_syncing, parent, false)");
      paramViewGroup = (s)new a.b(paramViewGroup, this.jLP);
      AppMethodBeat.o(256555);
      return paramViewGroup;
    case 8: 
      paramViewGroup = localLayoutInflater.inflate(i.f.emoji_panel_item_load_more, paramViewGroup, false);
      kotlin.g.b.p.j(paramViewGroup, "inflater.inflate(R.layou…load_more, parent, false)");
      paramViewGroup = (s)new d(paramViewGroup, this.jLP);
      AppMethodBeat.o(256555);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(i.f.emoji_custom_add, paramViewGroup, false);
    kotlin.g.b.p.j(paramViewGroup, "inflater.inflate(R.layou…ustom_add, parent, false)");
    paramViewGroup = (s)new a.a(paramViewGroup, this.jLP);
    AppMethodBeat.o(256555);
    return paramViewGroup;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emoji/ui/adapter/EmojiCustomAdapter$EmojiCustomViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Lcom/tencent/mm/plugin/emoji/ui/adapter/EmojiCustomAdapter;Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emoji_release"})
  public final class c
    extends s<h>
  {
    private ImageView bwJ;
    private CheckBox checkBox;
    
    public c(com.tencent.mm.emoji.panel.a.p paramp)
    {
      super(localp);
      AppMethodBeat.i(256100);
      this$1 = paramp.findViewById(i.e.image);
      if (a.this == null)
      {
        this$1 = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(256100);
        throw a.this;
      }
      this.bwJ = ((ImageView)a.this);
      this$1 = paramp.findViewById(i.e.checked);
      kotlin.g.b.p.j(a.this, "itemView.findViewById(R.id.checked)");
      this.checkBox = ((CheckBox)a.this);
      AppMethodBeat.o(256100);
    }
    
    public final void a(ae paramae)
    {
      AppMethodBeat.i(256099);
      kotlin.g.b.p.k(paramae, "item");
      super.a(paramae);
      if (a.this.uMr == EmojiCustomUI.b.uJt) {
        this.checkBox.setVisibility(0);
      }
      for (;;)
      {
        paramae = this.checkBox;
        Object localObject = a.a(a.this);
        ae localae = this.jMr;
        if (localae == null) {
          kotlin.g.b.p.iCn();
        }
        paramae.setChecked(((LinkedList)localObject).contains(((h)localae).jHh.getMd5()));
        paramae = (h)this.jMr;
        if (paramae == null) {
          break label164;
        }
        if (paramae.jJc == 3) {
          break;
        }
        localObject = e.jGI;
        e.a(paramae.jHh, this.bwJ);
        AppMethodBeat.o(256099);
        return;
        this.checkBox.setVisibility(8);
      }
      paramae = e.jGI;
      e.cD((View)this.bwJ);
      this.bwJ.setImageResource(i.d.emoji_download_icon);
      AppMethodBeat.o(256099);
      return;
      label164:
      AppMethodBeat.o(256099);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.a.a
 * JD-Core Version:    0.7.0.1
 */