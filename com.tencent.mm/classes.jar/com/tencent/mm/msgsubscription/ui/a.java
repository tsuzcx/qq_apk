package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$CheckBoxStateChangedListener;", "(Landroid/content/Context;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$CheckBoxStateChangedListener;)V", "value", "", "exampleTitle", "getExampleTitle", "()Ljava/lang/String;", "setExampleTitle", "(Ljava/lang/String;)V", "mList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "fillInfoIcon", "", "holder", "item", "position", "", "fillSubscribeCheckBox", "filling", "getItem", "getItemCount", "getList", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setList", "list", "CheckBoxStateChangedListener", "Companion", "SubscribeMsgListItemViewHolder", "plugin-comm_release"})
public final class a
  extends RecyclerView.a<c>
{
  public static final a.b iFC;
  private final Context context;
  String iDR;
  ArrayList<SubscribeMsgTmpItem> iFA;
  private final a iFB;
  
  static
  {
    AppMethodBeat.i(149734);
    iFC = new a.b((byte)0);
    AppMethodBeat.o(149734);
  }
  
  public a(Context paramContext, a parama)
  {
    AppMethodBeat.i(149733);
    this.context = paramContext;
    this.iFB = parama;
    this.iFA = new ArrayList();
    this.iDR = "";
    AppMethodBeat.o(149733);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(149732);
    int i = this.iFA.size();
    AppMethodBeat.o(149732);
    return i;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$CheckBoxStateChangedListener;", "", "getState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onChanged", "", "check", "plugin-comm_release"})
  public static abstract interface a
  {
    public abstract void b(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean);
    
    public abstract boolean c(SubscribeMsgTmpItem paramSubscribeMsgTmpItem);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "infoIcon", "Landroid/widget/ImageView;", "getInfoIcon", "()Landroid/widget/ImageView;", "setInfoIcon", "(Landroid/widget/ImageView;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "topLine", "getTopLine", "()Landroid/view/View;", "setTopLine", "plugin-comm_release"})
  public static final class c
    extends RecyclerView.w
  {
    TextView gqi;
    CheckBox iFD;
    ImageView iFE;
    View iFF;
    
    public c(View paramView)
    {
      super();
      AppMethodBeat.i(149725);
      this.iFD = ((CheckBox)paramView.findViewById(2131298255));
      this.gqi = ((TextView)paramView.findViewById(2131305524));
      this.iFE = ((ImageView)paramView.findViewById(2131305521));
      this.iFF = paramView.findViewById(2131306012);
      AppMethodBeat.o(149725);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama, a.c paramc, SubscribeMsgTmpItem paramSubscribeMsgTmpItem) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149729);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$fillSubscribeCheckBox$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      paramView = this.iFJ.iFD;
      p.g(paramView, "holder.checkBox");
      localObject = this.iFJ.iFD;
      p.g(localObject, "holder.checkBox");
      if (!((CheckBox)localObject).isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.setChecked(bool);
        paramView = a.a(this.iFG);
        localObject = this.iFH;
        CheckBox localCheckBox = this.iFJ.iFD;
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