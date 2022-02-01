package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "(Landroid/content/Context;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgItemOpListener;)V", "value", "", "exampleTitle", "getExampleTitle", "()Ljava/lang/String;", "setExampleTitle", "(Ljava/lang/String;)V", "mList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "fillInfoIcon", "", "holder", "item", "position", "", "fillSubscribeCheckBox", "filling", "getItem", "getItemCount", "getList", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setList", "list", "Companion", "SubscribeMsgItemOpListener", "SubscribeMsgListItemViewHolder", "plugin-comm_release"})
public final class a
  extends RecyclerView.a<c>
{
  public static final a.a jBG;
  private final Context context;
  String jAi;
  ArrayList<SubscribeMsgTmpItem> jBE;
  private final b jBF;
  
  static
  {
    AppMethodBeat.i(149734);
    jBG = new a.a((byte)0);
    AppMethodBeat.o(149734);
  }
  
  public a(Context paramContext, b paramb)
  {
    AppMethodBeat.i(223417);
    this.context = paramContext;
    this.jBF = paramb;
    this.jBE = new ArrayList();
    this.jAi = "";
    AppMethodBeat.o(223417);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(149732);
    int i = this.jBE.size();
    AppMethodBeat.o(149732);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onCheckBoxStatusChanged", "", "check", "onItemInfoClick", "view", "Landroid/view/View;", "plugin-comm_release"})
  public static abstract interface b
  {
    public abstract boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem);
    
    public abstract void b(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "infoIcon", "Landroid/widget/ImageView;", "getInfoIcon", "()Landroid/widget/ImageView;", "setInfoIcon", "(Landroid/widget/ImageView;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "topLine", "getTopLine", "()Landroid/view/View;", "setTopLine", "plugin-comm_release"})
  public static final class c
    extends RecyclerView.v
  {
    CheckBox checkBox;
    TextView hbb;
    ImageView jBH;
    View jBI;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(149725);
      this.checkBox = ((CheckBox)paramView.findViewById(2131298639));
      this.hbb = ((TextView)paramView.findViewById(2131308741));
      this.jBH = ((ImageView)paramView.findViewById(2131308738));
      this.jBI = paramView.findViewById(2131309322);
      AppMethodBeat.o(149725);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama, a.c paramc, SubscribeMsgTmpItem paramSubscribeMsgTmpItem) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149729);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillSubscribeCheckBox$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = this.jBM.checkBox;
      p.g(paramView, "holder.checkBox");
      localObject = this.jBM.checkBox;
      p.g(localObject, "holder.checkBox");
      if (!((CheckBox)localObject).isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        paramView = a.a(this.jBJ);
        localObject = this.jBK;
        CheckBox localCheckBox = this.jBM.checkBox;
        p.g(localCheckBox, "holder.checkBox");
        paramView.b((SubscribeMsgTmpItem)localObject, localCheckBox.isChecked());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillSubscribeCheckBox$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149729);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a
 * JD-Core Version:    0.7.0.1
 */