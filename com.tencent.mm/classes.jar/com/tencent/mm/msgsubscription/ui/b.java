package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.util.c;
import com.tencent.mm.plugin.comm.c.e;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter;", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "(Landroid/content/Context;Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter$SubscribeMsgItemOpListener;)V", "fillInfoIcon", "", "holder", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "position", "", "fillSubscribeCheckBox", "filling", "getItem", "getItemCount", "getList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "SubscribeMsgListItemViewHolder", "plugin-comm_release"})
public final class b
  extends a<b>
{
  public static final b.a mrC;
  private final Context context;
  private final a.a mrB;
  
  static
  {
    AppMethodBeat.i(149734);
    mrC = new b.a((byte)0);
    AppMethodBeat.o(149734);
  }
  
  public b(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(224650);
    this.context = paramContext;
    this.mrB = parama;
    AppMethodBeat.o(224650);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(149732);
    int i = this.mrs.size();
    AppMethodBeat.o(149732);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "infoIcon", "Landroid/widget/ImageView;", "getInfoIcon", "()Landroid/widget/ImageView;", "setInfoIcon", "(Landroid/widget/ImageView;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "topLine", "getTopLine", "()Landroid/view/View;", "setTopLine", "plugin-comm_release"})
  public static final class b
    extends RecyclerView.v
  {
    CheckBox checkBox;
    TextView jMg;
    ImageView mrD;
    View mrE;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(149725);
      this.checkBox = ((CheckBox)paramView.findViewById(c.e.checkbox));
      this.jMg = ((TextView)paramView.findViewById(c.e.subscribe_msg_title));
      this.mrD = ((ImageView)paramView.findViewById(c.e.subscribe_msg_info));
      this.mrE = paramView.findViewById(c.e.top_line);
      AppMethodBeat.o(149725);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(b paramb, SubscribeMsgTmpItem paramSubscribeMsgTmpItem) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149728);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillInfoIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = c.mty;
      c.a(b.b(this.mrF), this.mrF.mpO, this.mrG);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillInfoIcon$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(149728);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(b paramb, b.b paramb1, SubscribeMsgTmpItem paramSubscribeMsgTmpItem) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149729);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillSubscribeCheckBox$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = this.mrH.checkBox;
      p.j(paramView, "holder.checkBox");
      localObject = this.mrH.checkBox;
      p.j(localObject, "holder.checkBox");
      if (!((CheckBox)localObject).isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        paramView = b.a(this.mrF);
        localObject = this.mrG;
        CheckBox localCheckBox = this.mrH.checkBox;
        p.j(localCheckBox, "holder.checkBox");
        paramView.a((SubscribeMsgTmpItem)localObject, localCheckBox.isChecked());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillSubscribeCheckBox$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149729);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b
 * JD-Core Version:    0.7.0.1
 */