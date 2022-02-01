package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.plugin.comm.c.e;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter;", "Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgListItemViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgSecondaryMenuListener;", "(Landroid/content/Context;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgSecondaryMenuListener;)V", "filling", "", "holder", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "position", "", "getItem", "getItemCount", "getList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "SubscribeMsgListItemViewHolder", "SubscribeMsgSecondaryMenuListener", "plugin-comm_release"})
public final class e
  extends a<b>
{
  public static final e.a mtn;
  private final Context context;
  private final c mtm;
  
  static
  {
    AppMethodBeat.i(233274);
    mtn = new e.a((byte)0);
    AppMethodBeat.o(233274);
  }
  
  public e(Context paramContext, c paramc)
  {
    AppMethodBeat.i(233272);
    this.context = paramContext;
    this.mtm = paramc;
    AppMethodBeat.o(233272);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(233271);
    int i = this.mrs.size();
    AppMethodBeat.o(233271);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgListItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "status", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getStatus", "()Landroid/widget/TextView;", "setStatus", "(Landroid/widget/TextView;)V", "title", "getTitle", "setTitle", "topLine", "getTopLine", "()Landroid/view/View;", "setTopLine", "plugin-comm_release"})
  public static final class b
    extends RecyclerView.v
  {
    TextView jMg;
    View mrE;
    TextView mto;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(217643);
      this.jMg = ((TextView)paramView.findViewById(c.e.subscribe_msg_title));
      this.mto = ((TextView)paramView.findViewById(c.e.status));
      this.mrE = paramView.findViewById(c.e.top_line);
      AppMethodBeat.o(217643);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$SubscribeMsgSecondaryMenuListener;", "", "getSubscribeState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onClick", "", "position", "", "plugin-comm_release"})
  public static abstract interface c
  {
    public abstract void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, int paramInt);
    
    public abstract boolean c(SubscribeMsgTmpItem paramSubscribeMsgTmpItem);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(e parame, SubscribeMsgTmpItem paramSubscribeMsgTmpItem, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(239620);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$filling$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      e.a(this.mtp).a(this.mrG, this.jEN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgSecondaryMenuListAdapter$filling$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(239620);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.e
 * JD-Core Version:    0.7.0.1
 */