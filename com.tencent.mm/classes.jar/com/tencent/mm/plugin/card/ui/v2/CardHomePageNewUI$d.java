package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH;", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;", "(Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI;)V", "appendUnderList", "", "model", "Lcom/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$CardListModel;", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByMerchantId", "merchantId", "", "moveStoreToUnderList", "", "element", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "onBindViewHolder", "holder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByMId", "removeTitleSection", "replaceModelByMId", "mchInfo", "plugin-card_release"})
public final class CardHomePageNewUI$d
  extends RecyclerView.a<CardHomePageNewUI.e>
{
  private int Il(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(89189);
    j.q(paramString, "merchantId");
    if (CardHomePageNewUI.g(this.kzs) != null) {}
    for (int i = 1;; i = 0)
    {
      if (CardHomePageNewUI.f(this.kzs) != null) {
        i += 1;
      }
      for (;;)
      {
        Iterator localIterator = ((Iterable)CardHomePageNewUI.a(this.kzs)).iterator();
        int j = 0;
        Object localObject;
        while (localIterator.hasNext())
        {
          localObject = ((CardHomePageNewUI.a)localIterator.next()).kzm;
          if (localObject != null) {}
          for (localObject = ((on)localObject).wEJ; j.e(localObject, paramString); localObject = null)
          {
            AppMethodBeat.o(89189);
            return i + j;
          }
          j += 1;
        }
        i = CardHomePageNewUI.a(this.kzs).size() + i - 1;
        if (CardHomePageNewUI.c(this.kzs) != null) {
          i += 1;
        }
        for (;;)
        {
          localIterator = ((Iterable)CardHomePageNewUI.b(this.kzs)).iterator();
          j = k;
          while (localIterator.hasNext())
          {
            localObject = ((CardHomePageNewUI.a)localIterator.next()).kzm;
            if (localObject != null) {}
            for (localObject = ((on)localObject).wEJ; j.e(localObject, paramString); localObject = null)
            {
              AppMethodBeat.o(89189);
              return i + j + 1;
            }
            j += 1;
          }
          AppMethodBeat.o(89189);
          return -1;
        }
      }
    }
  }
  
  public final void Ik(String paramString)
  {
    AppMethodBeat.i(89188);
    j.q(paramString, "merchantId");
    Iterator localIterator = CardHomePageNewUI.a(this.kzs).iterator();
    CardHomePageNewUI.a locala;
    Object localObject;
    while (localIterator.hasNext())
    {
      locala = (CardHomePageNewUI.a)localIterator.next();
      localObject = locala.kzm;
      if (localObject != null) {}
      for (localObject = ((on)localObject).wEJ; j.e(localObject, paramString); localObject = null)
      {
        CardHomePageNewUI.a(this.kzs).remove(locala);
        CardHomePageNewUI.i(this.kzs).getAdapter().notifyDataSetChanged();
        AppMethodBeat.o(89188);
        return;
      }
    }
    localIterator = CardHomePageNewUI.b(this.kzs).iterator();
    while (localIterator.hasNext())
    {
      locala = (CardHomePageNewUI.a)localIterator.next();
      localObject = locala.kzm;
      if (localObject != null) {}
      for (localObject = ((on)localObject).wEJ; j.e(localObject, paramString); localObject = null)
      {
        CardHomePageNewUI.b(this.kzs).remove(locala);
        if (CardHomePageNewUI.b(this.kzs).size() == 0)
        {
          CardHomePageNewUI.d(this.kzs);
          CardHomePageNewUI.i(this.kzs).getAdapter().notifyDataSetChanged();
        }
        AppMethodBeat.o(89188);
        return;
      }
    }
    AppMethodBeat.o(89188);
  }
  
  public final void a(String paramString, on paramon)
  {
    AppMethodBeat.i(89190);
    j.q(paramString, "merchantId");
    j.q(paramon, "mchInfo");
    Iterator localIterator = CardHomePageNewUI.a(this.kzs).iterator();
    CardHomePageNewUI.a locala;
    Object localObject;
    int i;
    while (localIterator.hasNext())
    {
      locala = (CardHomePageNewUI.a)localIterator.next();
      localObject = locala.kzm;
      if (localObject != null) {}
      for (localObject = ((on)localObject).wEJ; j.e(localObject, paramString); localObject = null)
      {
        locala.kzm = paramon;
        i = Il(paramString);
        if (i >= 0) {
          CardHomePageNewUI.i(this.kzs).getAdapter().c(i, Boolean.TRUE);
        }
        AppMethodBeat.o(89190);
        return;
      }
    }
    localIterator = CardHomePageNewUI.b(this.kzs).iterator();
    while (localIterator.hasNext())
    {
      locala = (CardHomePageNewUI.a)localIterator.next();
      localObject = locala.kzm;
      if (localObject != null) {}
      for (localObject = ((on)localObject).wEJ; j.e(localObject, paramString); localObject = null)
      {
        locala.kzm = paramon;
        i = Il(paramString);
        if (i >= 0) {
          CardHomePageNewUI.i(this.kzs).getAdapter().c(i, Boolean.TRUE);
        }
        AppMethodBeat.o(89190);
        return;
      }
    }
    AppMethodBeat.o(89190);
  }
  
  public final int getItemCount()
  {
    int n = 1;
    int i1 = 0;
    AppMethodBeat.i(89183);
    ArrayList localArrayList = CardHomePageNewUI.a(this.kzs);
    int i;
    int j;
    if (localArrayList != null)
    {
      i = localArrayList.size();
      localArrayList = CardHomePageNewUI.b(this.kzs);
      if (localArrayList == null) {
        break label132;
      }
      j = localArrayList.size();
      label51:
      if (CardHomePageNewUI.c(this.kzs) == null) {
        break label149;
      }
    }
    label132:
    label149:
    for (int k = 1;; k = 0)
    {
      if (CardHomePageNewUI.e(this.kzs) != null) {}
      for (int m = 1;; m = 0)
      {
        if (CardHomePageNewUI.f(this.kzs) != null) {}
        for (;;)
        {
          localArrayList = CardHomePageNewUI.g(this.kzs);
          if (localArrayList != null) {
            i1 = localArrayList.size();
          }
          AppMethodBeat.o(89183);
          return i + j + k + m + n + i1;
          i = 0;
          break;
          j = 0;
          break label51;
          n = 0;
        }
      }
    }
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(89184);
    CardHomePageNewUI.a locala = to(paramInt);
    if (locala != null)
    {
      paramInt = locala.type;
      AppMethodBeat.o(89184);
      return paramInt;
    }
    AppMethodBeat.o(89184);
    return 3;
  }
  
  public final CardHomePageNewUI.a to(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(89187);
    Object localObject1 = CardHomePageNewUI.a(this.kzs);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      localObject2 = CardHomePageNewUI.a(this.kzs);
      if (localObject2 == null) {
        break label159;
      }
      localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
      label56:
      if (CardHomePageNewUI.c(this.kzs) == null) {
        break label165;
      }
    }
    label159:
    label165:
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.CardHomePageNewUI", "pos: %s, sSize: %s, uSize: %s, title: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, Boolean.valueOf(bool) });
      localObject1 = CardHomePageNewUI.g(this.kzs);
      if (localObject1 == null) {
        break label177;
      }
      if (paramInt + 0 >= ((ArrayList)localObject1).size()) {
        break label171;
      }
      localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt + 0);
      AppMethodBeat.o(89187);
      return localObject1;
      localObject1 = null;
      break;
      localObject2 = null;
      break label56;
    }
    label171:
    j = ((ArrayList)localObject1).size();
    label177:
    localObject1 = CardHomePageNewUI.f(this.kzs);
    int i = j;
    if (localObject1 != null)
    {
      if (paramInt == j)
      {
        AppMethodBeat.o(89187);
        return localObject1;
      }
      i = j + 1;
    }
    localObject1 = CardHomePageNewUI.a(this.kzs);
    j = i;
    if (localObject1 != null)
    {
      if (paramInt - i < ((ArrayList)localObject1).size())
      {
        localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt - i);
        AppMethodBeat.o(89187);
        return localObject1;
      }
      j = ((ArrayList)localObject1).size() - 1;
    }
    i = j;
    if (CardHomePageNewUI.c(this.kzs) != null)
    {
      j += 1;
      i = j;
      if (paramInt == j)
      {
        localObject1 = CardHomePageNewUI.c(this.kzs);
        AppMethodBeat.o(89187);
        return localObject1;
      }
    }
    localObject1 = CardHomePageNewUI.b(this.kzs);
    if ((localObject1 != null) && (paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
    {
      localObject1 = (CardHomePageNewUI.a)((ArrayList)localObject1).get(paramInt - i - 1);
      AppMethodBeat.o(89187);
      return localObject1;
    }
    AppMethodBeat.o(89187);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.d
 * JD-Core Version:    0.7.0.1
 */