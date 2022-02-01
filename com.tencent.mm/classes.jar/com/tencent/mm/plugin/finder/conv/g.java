package com.tencent.mm.plugin.finder.conv;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationFirstFixAdapter;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "finderConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getFinderConversation", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "setFinderConversation", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversation;)V", "fixedConversationList", "", "getFixedConversationList", "()Ljava/util/List;", "setFixedConversationList", "(Ljava/util/List;)V", "isOneFixed", "", "getConversation", "index", "", "getDelta", "getFixedConversation", "getItem", "position", "getItemCount", "notifyConvItemChanged", "", "notifyConvItemInserted", "notifyConvItemRangeInserted", "positionStart", "itemCount", "notifyConvItemRangeRemoved", "notifyConvItemRemoved", "onBindViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/conv/ConversationHolder;", "plugin-finder_release"})
public final class g
  extends d
{
  private final String TAG = "ConversationFirstFixAdapter";
  private final boolean tyH = true;
  public c tyI;
  private List<c> tyJ;
  
  private final c Iq(int paramInt)
  {
    AppMethodBeat.i(242741);
    Object localObject = this.tyJ;
    int i;
    if (localObject != null)
    {
      if ((paramInt < 0) || (paramInt >= ((List)localObject).size())) {
        break label73;
      }
      i = 1;
      if (i == 0) {
        break label78;
      }
    }
    for (;;)
    {
      if (localObject != null)
      {
        c localc = (c)((List)localObject).get(paramInt);
        localObject = localc;
        if (localc != null) {}
      }
      else
      {
        localObject = new c();
      }
      AppMethodBeat.o(242741);
      return localObject;
      label73:
      i = 0;
      break;
      label78:
      localObject = null;
    }
  }
  
  private final int cZx()
  {
    AppMethodBeat.i(242740);
    List localList = this.tyJ;
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(242740);
      return i;
    }
    AppMethodBeat.o(242740);
    return 1;
  }
  
  public final void Il(int paramInt)
  {
    AppMethodBeat.i(242734);
    super.Il(cZx() + paramInt);
    AppMethodBeat.o(242734);
  }
  
  public final void Im(int paramInt)
  {
    AppMethodBeat.i(242735);
    if (paramInt >= 0)
    {
      super.Im(cZx() + paramInt);
      AppMethodBeat.o(242735);
      return;
    }
    super.Im(1);
    AppMethodBeat.o(242735);
  }
  
  public final void In(int paramInt)
  {
    AppMethodBeat.i(242737);
    super.In(cZx() + paramInt);
    AppMethodBeat.o(242737);
  }
  
  public final c Io(int paramInt)
  {
    AppMethodBeat.i(242731);
    c localc1;
    if ((paramInt >= 0) && (paramInt < cZx()))
    {
      if (this.tyH)
      {
        c localc2 = this.tyI;
        localc1 = localc2;
        if (localc2 == null)
        {
          localc1 = new c();
          AppMethodBeat.o(242731);
          return localc1;
        }
      }
      else
      {
        localc1 = Iq(paramInt);
        AppMethodBeat.o(242731);
        return localc1;
      }
    }
    else {
      localc1 = super.Io(paramInt - cZx());
    }
    AppMethodBeat.o(242731);
    return localc1;
  }
  
  public final c Ip(int paramInt)
  {
    AppMethodBeat.i(242739);
    if ((paramInt >= 0) && (paramInt < cZx()))
    {
      if (this.tyH)
      {
        localc = this.tyI;
        AppMethodBeat.o(242739);
        return localc;
      }
      localc = Iq(paramInt);
      AppMethodBeat.o(242739);
      return localc;
    }
    c localc = (c)this.ppH.get(paramInt - cZx());
    AppMethodBeat.o(242739);
    return localc;
  }
  
  public final void a(a parama, int paramInt)
  {
    AppMethodBeat.i(242732);
    p.h(parama, "holder");
    super.a(parama, paramInt);
    if (paramInt == 0)
    {
      parama = parama.aus;
      p.g(parama, "holder.itemView");
      ((ImageView)parama.findViewById(2131297121)).setImageResource(2131232669);
    }
    AppMethodBeat.o(242732);
  }
  
  public final void fY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242736);
    super.fY(cZx() + paramInt1, paramInt2);
    AppMethodBeat.o(242736);
  }
  
  public final void fZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242738);
    super.fZ(cZx() + paramInt1, paramInt2);
    AppMethodBeat.o(242738);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(242730);
    int i = super.getItemCount();
    int j = cZx();
    AppMethodBeat.o(242730);
    return i + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.g
 * JD-Core Version:    0.7.0.1
 */