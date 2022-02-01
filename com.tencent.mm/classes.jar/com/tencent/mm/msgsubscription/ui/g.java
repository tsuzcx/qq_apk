package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.comm.c.e;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter;", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgListItemViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgSecondaryMenuListener;", "(Landroid/content/Context;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgSecondaryMenuListener;)V", "filling", "", "holder", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "position", "", "getItem", "getItemCount", "getList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "SubscribeMsgListItemViewHolder", "SubscribeMsgSecondaryMenuListener", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a<b>
{
  public static final g.a pmI;
  private final Context context;
  private final c pmJ;
  
  static
  {
    AppMethodBeat.i(236566);
    pmI = new g.a((byte)0);
    AppMethodBeat.o(236566);
  }
  
  public g(Context paramContext, c paramc)
  {
    AppMethodBeat.i(236552);
    this.context = paramContext;
    this.pmJ = paramc;
    AppMethodBeat.o(236552);
  }
  
  private static final void a(g paramg, SubscribeMsgTmpItem paramSubscribeMsgTmpItem, int paramInt, View paramView)
  {
    AppMethodBeat.i(236558);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramg);
    localb.cH(paramSubscribeMsgTmpItem);
    localb.sc(paramInt);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramg, "this$0");
    s.u(paramSubscribeMsgTmpItem, "$item");
    paramg.pmJ.a(paramSubscribeMsgTmpItem, paramInt);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236558);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(236572);
    int i = this.pkR.size();
    AppMethodBeat.o(236572);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "status", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getStatus", "()Landroid/widget/TextView;", "setStatus", "(Landroid/widget/TextView;)V", "title", "getTitle", "setTitle", "topLine", "getTopLine", "()Landroid/view/View;", "setTopLine", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.v
  {
    TextView mll;
    View plj;
    TextView pmK;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(236616);
      this.mll = ((TextView)paramView.findViewById(c.e.subscribe_msg_title));
      this.pmK = ((TextView)paramView.findViewById(c.e.status));
      this.plj = paramView.findViewById(c.e.top_line);
      AppMethodBeat.o(236616);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgSecondaryMenuListener;", "", "getSubscribeState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onClick", "", "position", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, int paramInt);
    
    public abstract boolean c(SubscribeMsgTmpItem paramSubscribeMsgTmpItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.g
 * JD-Core Version:    0.7.0.1
 */