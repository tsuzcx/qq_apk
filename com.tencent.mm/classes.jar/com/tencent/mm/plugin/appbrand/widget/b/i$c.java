package com.tencent.mm.plugin.appbrand.widget.b;

import a.a.j;
import a.f.a.b;
import a.l;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter$ViewHolder;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "setItems", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class i$c
  extends RecyclerView.a<i.c.a>
{
  List<i.b> items;
  
  public i$c(List<i.b> paramList)
  {
    AppMethodBeat.i(102491);
    this.items = paramList;
    AppMethodBeat.o(102491);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(102489);
    int i = this.items.size();
    AppMethodBeat.o(102489);
    return i;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a$a
    implements View.OnClickListener
  {
    a$a(i.c.a parama, i.b paramb, int paramInt, b paramb1) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(102483);
      paramView = this.jjV;
      boolean bool = this.jjV.jjR;
      i.c.a.a(this.jjU, bool);
      Iterator localIterator;
      int i;
      if (!bool)
      {
        bool = true;
        paramView.jjR = bool;
        paramView = new ArrayList();
        localIterator = ((Iterable)this.jjU.items).iterator();
        i = 0;
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label171;
        }
        Object localObject = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          j.eaS();
        }
        localObject = (i.b)localObject;
        paramView.add(Integer.valueOf(i));
        if (this.euX != i)
        {
          if (localObject == null) {
            break label166;
          }
          if (((i.b)localObject).jjR == true)
          {
            ((i.b)localObject).jjR = false;
            paramView.add(Integer.valueOf(this.euX));
          }
        }
        i = j;
        continue;
        bool = false;
        break;
        label166:
        i = j;
      }
      label171:
      this.jjW.S(paramView);
      AppMethodBeat.o(102483);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.i.c
 * JD-Core Version:    0.7.0.1
 */