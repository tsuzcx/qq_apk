package com.tencent.mm.plugin.finder.conv;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationFirstFixAdapter;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversationAdapter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "finderConversation", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "getFinderConversation", "()Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "setFinderConversation", "(Lcom/tencent/mm/plugin/finder/conv/FinderConversation;)V", "fixedConversationList", "", "getFixedConversationList", "()Ljava/util/List;", "setFixedConversationList", "(Ljava/util/List;)V", "isOneFixed", "", "getConversation", "index", "", "getDelta", "getFixedConversation", "getItem", "position", "getItemCount", "notifyConvItemChanged", "", "notifyConvItemInserted", "notifyConvItemRangeInserted", "positionStart", "itemCount", "notifyConvItemRangeRemoved", "notifyConvItemRemoved", "onBindViewHolder", "holder", "Lcom/tencent/mm/plugin/finder/conv/ConversationHolder;", "plugin-finder_release"})
public final class h
  extends e
{
  private final String TAG = "ConversationFirstFixAdapter";
  private final boolean xgt = true;
  public d xgu;
  private List<d> xgv;
  
  private final d Mb(int paramInt)
  {
    AppMethodBeat.i(265574);
    Object localObject = this.xgv;
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
        d locald = (d)((List)localObject).get(paramInt);
        localObject = locald;
        if (locald != null) {}
      }
      else
      {
        localObject = new d();
      }
      AppMethodBeat.o(265574);
      return localObject;
      label73:
      i = 0;
      break;
      label78:
      localObject = null;
    }
  }
  
  private final int dpn()
  {
    AppMethodBeat.i(265573);
    List localList = this.xgv;
    if (localList != null)
    {
      int i = localList.size();
      AppMethodBeat.o(265573);
      return i;
    }
    AppMethodBeat.o(265573);
    return 1;
  }
  
  public final void LW(int paramInt)
  {
    AppMethodBeat.i(265567);
    super.LW(dpn() + paramInt);
    AppMethodBeat.o(265567);
  }
  
  public final void LX(int paramInt)
  {
    AppMethodBeat.i(265568);
    if (paramInt >= 0)
    {
      super.LX(dpn() + paramInt);
      AppMethodBeat.o(265568);
      return;
    }
    super.LX(1);
    AppMethodBeat.o(265568);
  }
  
  public final void LY(int paramInt)
  {
    AppMethodBeat.i(265570);
    super.LY(dpn() + paramInt);
    AppMethodBeat.o(265570);
  }
  
  public final d LZ(int paramInt)
  {
    AppMethodBeat.i(265564);
    d locald1;
    if ((paramInt >= 0) && (paramInt < dpn()))
    {
      if (this.xgt)
      {
        d locald2 = this.xgu;
        locald1 = locald2;
        if (locald2 == null)
        {
          locald1 = new d();
          AppMethodBeat.o(265564);
          return locald1;
        }
      }
      else
      {
        locald1 = Mb(paramInt);
        AppMethodBeat.o(265564);
        return locald1;
      }
    }
    else {
      locald1 = super.LZ(paramInt - dpn());
    }
    AppMethodBeat.o(265564);
    return locald1;
  }
  
  public final d Ma(int paramInt)
  {
    AppMethodBeat.i(265572);
    if ((paramInt >= 0) && (paramInt < dpn()))
    {
      if (this.xgt)
      {
        locald = this.xgu;
        AppMethodBeat.o(265572);
        return locald;
      }
      locald = Mb(paramInt);
      AppMethodBeat.o(265572);
      return locald;
    }
    d locald = (d)this.syG.get(paramInt - dpn());
    AppMethodBeat.o(265572);
    return locald;
  }
  
  public final void a(a parama, int paramInt)
  {
    AppMethodBeat.i(265565);
    p.k(parama, "holder");
    super.a(parama, paramInt);
    if (paramInt == 0)
    {
      parama = parama.amk;
      p.j(parama, "holder.itemView");
      ((ImageView)parama.findViewById(b.f.avatarIv)).setImageResource(b.e.finder_msg_sys_icon);
    }
    AppMethodBeat.o(265565);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(265563);
    int i = super.getItemCount();
    int j = dpn();
    AppMethodBeat.o(265563);
    return i + j;
  }
  
  public final void gw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(265569);
    super.gw(dpn() + paramInt1, paramInt2);
    AppMethodBeat.o(265569);
  }
  
  public final void gx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(265571);
    super.gx(dpn() + paramInt1, paramInt2);
    AppMethodBeat.o(265571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.h
 * JD-Core Version:    0.7.0.1
 */