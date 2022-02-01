package com.tencent.mm.plugin.emoji.ui.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.emoji.panel.a.c;
import com.tencent.mm.emoji.panel.a.g;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.panel.a.q;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.b;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/adapter/EmojiCustomAdapter;", "Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemAdapter;", "()V", "mode", "Lcom/tencent/mm/plugin/emoji/ui/EmojiCustomUI$Mode;", "getMode", "()Lcom/tencent/mm/plugin/emoji/ui/EmojiCustomUI$Mode;", "setMode", "(Lcom/tencent/mm/plugin/emoji/ui/EmojiCustomUI$Mode;)V", "selectedList", "Ljava/util/LinkedList;", "", "onCreateViewHolder", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "updateSelected", "", "list", "", "EmojiCustomAddViewHolder", "EmojiCustomLoadingViewHolder", "EmojiCustomSyncingViewHolder", "EmojiCustomViewHolder", "UIAction", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends g
{
  EmojiCustomUI.b xUT;
  private final LinkedList<String> xUU;
  
  public a()
  {
    AppMethodBeat.i(270375);
    this.xUT = EmojiCustomUI.b.xSi;
    this.xUU = new LinkedList();
    AppMethodBeat.o(270375);
  }
  
  public final void b(EmojiCustomUI.b paramb)
  {
    AppMethodBeat.i(270384);
    s.u(paramb, "<set-?>");
    this.xUT = paramb;
    AppMethodBeat.o(270384);
  }
  
  public final q<?> f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(270393);
    s.u(paramViewGroup, "parent");
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramViewGroup.getContext());
    switch (paramInt)
    {
    default: 
      paramViewGroup = localLayoutInflater.inflate(h.f.emoji_custom_grid_item, paramViewGroup, false);
      s.s(paramViewGroup, "inflater.inflate(R.layou…grid_item, parent, false)");
      paramViewGroup = (q)new c(paramViewGroup, this.mkY);
      AppMethodBeat.o(270393);
      return paramViewGroup;
    case 100: 
      paramViewGroup = localLayoutInflater.inflate(h.f.emoji_custom_item_syncing, paramViewGroup, false);
      s.s(paramViewGroup, "inflater.inflate(R.layou…m_syncing, parent, false)");
      paramViewGroup = (q)new a.b(paramViewGroup, this.mkY);
      AppMethodBeat.o(270393);
      return paramViewGroup;
    case 8: 
      paramViewGroup = localLayoutInflater.inflate(h.f.emoji_panel_item_load_more, paramViewGroup, false);
      s.s(paramViewGroup, "inflater.inflate(R.layou…load_more, parent, false)");
      paramViewGroup = (q)new c(paramViewGroup, this.mkY);
      AppMethodBeat.o(270393);
      return paramViewGroup;
    }
    paramViewGroup = localLayoutInflater.inflate(h.f.emoji_custom_add, paramViewGroup, false);
    s.s(paramViewGroup, "inflater.inflate(R.layou…ustom_add, parent, false)");
    paramViewGroup = (q)new a.a(paramViewGroup, this.mkY);
    AppMethodBeat.o(270393);
    return paramViewGroup;
  }
  
  public final void ff(List<String> paramList)
  {
    AppMethodBeat.i(270387);
    s.u(paramList, "list");
    this.xUU.clear();
    this.xUU.addAll((Collection)paramList);
    AppMethodBeat.o(270387);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/adapter/EmojiCustomAdapter$EmojiCustomViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Lcom/tencent/mm/plugin/emoji/ui/adapter/EmojiCustomAdapter;Landroid/view/View;Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "onBind", "", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends q<h>
  {
    private CheckBox checkBox;
    private ImageView dpM;
    
    public c(n paramn)
    {
      super(localn);
      AppMethodBeat.i(270378);
      this$1 = paramn.findViewById(h.e.image);
      if (a.this == null)
      {
        this$1 = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(270378);
        throw a.this;
      }
      this.dpM = ((ImageView)a.this);
      this$1 = paramn.findViewById(h.e.checked);
      s.s(a.this, "itemView.findViewById(R.id.checked)");
      this.checkBox = ((CheckBox)a.this);
      AppMethodBeat.o(270378);
    }
    
    public final void a(ae paramae)
    {
      AppMethodBeat.i(270382);
      s.u(paramae, "item");
      super.a(paramae);
      if (a.this.xUT == EmojiCustomUI.b.xSj) {
        this.checkBox.setVisibility(0);
      }
      for (;;)
      {
        paramae = this.checkBox;
        Object localObject = a.a(a.this);
        ae localae = aVT();
        s.checkNotNull(localae);
        paramae.setChecked(((LinkedList)localObject).contains(((h)localae).mgK.getMd5()));
        paramae = (h)aVT();
        if (paramae == null) {
          break label155;
        }
        if (paramae.miu == 3) {
          break;
        }
        localObject = e.mgl;
        e.a(paramae.mgK, this.dpM);
        AppMethodBeat.o(270382);
        return;
        this.checkBox.setVisibility(8);
      }
      paramae = e.mgl;
      e.cX((View)this.dpM);
      this.dpM.setImageResource(h.d.emoji_download_icon);
      label155:
      AppMethodBeat.o(270382);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.a.a
 * JD-Core Version:    0.7.0.1
 */