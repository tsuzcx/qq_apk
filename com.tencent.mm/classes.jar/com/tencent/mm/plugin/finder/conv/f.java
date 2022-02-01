package com.tencent.mm.plugin.finder.conv;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationFirstFixAdapter;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "finderConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getFinderConversation", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "setFinderConversation", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversation;)V", "fixedConversationList", "", "getFixedConversationList", "()Ljava/util/List;", "setFixedConversationList", "(Ljava/util/List;)V", "isOneFixed", "", "getConversation", "index", "", "getDelta", "getFixedConversation", "getItem", "position", "getItemCount", "notifyConvItemChanged", "", "notifyConvItemInserted", "notifyConvItemRangeInserted", "positionStart", "itemCount", "notifyConvItemRangeRemoved", "notifyConvItemRemoved", "onBindViewHolder", "holder", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$ConversationHolder;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends c
{
  private final boolean AFL = true;
  public b AFM;
  private List<b> AFN;
  private final String TAG = "ConversationFirstFixAdapter";
  
  private final b Nf(int paramInt)
  {
    b localb = null;
    AppMethodBeat.i(336029);
    Object localObject = this.AFN;
    if (localObject == null) {}
    label53:
    label81:
    label84:
    while (localb == null)
    {
      localObject = new b();
      AppMethodBeat.o(336029);
      return localObject;
      int i;
      if ((paramInt >= 0) && (paramInt < ((List)localObject).size()))
      {
        i = 1;
        if (i == 0) {
          break label81;
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label84;
        }
        localb = (b)((List)localObject).get(paramInt);
        break;
        i = 0;
        break label53;
        localObject = null;
      }
    }
    AppMethodBeat.o(336029);
    return localb;
  }
  
  private final int dWO()
  {
    AppMethodBeat.i(336023);
    List localList = this.AFN;
    if (localList == null)
    {
      AppMethodBeat.o(336023);
      return 1;
    }
    int i = localList.size();
    AppMethodBeat.o(336023);
    return i;
  }
  
  public final b MZ(int paramInt)
  {
    AppMethodBeat.i(336048);
    if ((paramInt >= 0) && (paramInt < dWO()))
    {
      if (this.AFL)
      {
        localb = this.AFM;
        if (localb == null)
        {
          localb = new b();
          AppMethodBeat.o(336048);
          return localb;
        }
        AppMethodBeat.o(336048);
        return localb;
      }
      localb = Nf(paramInt);
      AppMethodBeat.o(336048);
      return localb;
    }
    b localb = super.MZ(paramInt - dWO());
    AppMethodBeat.o(336048);
    return localb;
  }
  
  public final void Na(int paramInt)
  {
    AppMethodBeat.i(336063);
    super.Na(dWO() + paramInt);
    AppMethodBeat.o(336063);
  }
  
  public final void Nb(int paramInt)
  {
    AppMethodBeat.i(336068);
    if (paramInt >= 0)
    {
      super.Nb(dWO() + paramInt);
      AppMethodBeat.o(336068);
      return;
    }
    super.Nb(1);
    AppMethodBeat.o(336068);
  }
  
  public final void Nc(int paramInt)
  {
    AppMethodBeat.i(336080);
    super.Nc(dWO() + paramInt);
    AppMethodBeat.o(336080);
  }
  
  public final b Ne(int paramInt)
  {
    AppMethodBeat.i(336086);
    if ((paramInt >= 0) && (paramInt < dWO()))
    {
      if (this.AFL)
      {
        localb = this.AFM;
        AppMethodBeat.o(336086);
        return localb;
      }
      localb = Nf(paramInt);
      AppMethodBeat.o(336086);
      return localb;
    }
    b localb = (b)this.vEn.get(paramInt - dWO());
    AppMethodBeat.o(336086);
    return localb;
  }
  
  public final void a(BasePrivateMsgConvListFragment.b paramb, int paramInt)
  {
    AppMethodBeat.i(336056);
    s.u(paramb, "holder");
    super.a(paramb, paramInt);
    if (paramInt == 0) {
      ((ImageView)paramb.caK.findViewById(e.e.avatarIv)).setImageResource(e.d.finder_msg_sys_icon);
    }
    AppMethodBeat.o(336056);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(336039);
    int i = super.getItemCount();
    int j = dWO();
    AppMethodBeat.o(336039);
    return i + j;
  }
  
  public final void hq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(336074);
    super.hq(dWO() + paramInt1, paramInt2);
    AppMethodBeat.o(336074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.f
 * JD-Core Version:    0.7.0.1
 */