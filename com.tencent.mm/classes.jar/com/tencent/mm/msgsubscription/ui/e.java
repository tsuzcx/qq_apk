package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.util.c;
import com.tencent.mm.plugin.comm.c.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter;", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "(Landroid/content/Context;Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter$SubscribeMsgItemOpListener;)V", "fillInfoIcon", "", "holder", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "position", "", "fillSubscribeCheckBox", "filling", "getItem", "getItemCount", "getList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "SubscribeMsgListItemViewHolder", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a<b>
{
  public static final e.a plg;
  private final Context context;
  private final a.a plh;
  
  static
  {
    AppMethodBeat.i(149734);
    plg = new e.a((byte)0);
    AppMethodBeat.o(149734);
  }
  
  public e(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(236545);
    this.context = paramContext;
    this.plh = parama;
    AppMethodBeat.o(236545);
  }
  
  private static final void a(b paramb, e parame, SubscribeMsgTmpItem paramSubscribeMsgTmpItem, View paramView)
  {
    AppMethodBeat.i(236554);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramb);
    localb.cH(parame);
    localb.cH(paramSubscribeMsgTmpItem);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$holder");
    s.u(parame, "this$0");
    s.u(paramSubscribeMsgTmpItem, "$item");
    paramView = paramb.checkBox;
    if (!paramb.checkBox.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      parame.plh.a(paramSubscribeMsgTmpItem, paramb.checkBox.isChecked());
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(236554);
      return;
    }
  }
  
  private static final void a(e parame, SubscribeMsgTmpItem paramSubscribeMsgTmpItem, View paramView)
  {
    AppMethodBeat.i(236560);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parame);
    localb.cH(paramSubscribeMsgTmpItem);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    s.u(paramSubscribeMsgTmpItem, "$item");
    paramView = c.pmT;
    c.a(parame.context, parame.pjA, paramSubscribeMsgTmpItem);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236560);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(149732);
    int i = this.pkR.size();
    AppMethodBeat.o(149732);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgListAdapter$SubscribeMsgListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "infoIcon", "Landroid/widget/ImageView;", "getInfoIcon", "()Landroid/widget/ImageView;", "setInfoIcon", "(Landroid/widget/ImageView;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "topLine", "getTopLine", "()Landroid/view/View;", "setTopLine", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.v
  {
    CheckBox checkBox;
    TextView mll;
    ImageView pli;
    View plj;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(149725);
      this.checkBox = ((CheckBox)paramView.findViewById(c.e.checkbox));
      this.mll = ((TextView)paramView.findViewById(c.e.subscribe_msg_title));
      this.pli = ((ImageView)paramView.findViewById(c.e.subscribe_msg_info));
      this.plj = paramView.findViewById(c.e.top_line);
      AppMethodBeat.o(149725);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.e
 * JD-Core Version:    0.7.0.1
 */