package com.tencent.mm.plugin.card.ui.v2;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Iterator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "isInvalid", "", "(Z)V", "()Z", "setInvalid", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "Lkotlin/collections/ArrayList;", "getJumpList", "()Ljava/util/ArrayList;", "setJumpList", "(Ljava/util/ArrayList;)V", "licenseList", "getLicenseList", "setLicenseList", "licenseTitle", "getLicenseTitle", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "setLicenseTitle", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;)V", "ticketList", "getTicketList", "setTicketList", "ticketTitle", "getTicketTitle", "setTicketTitle", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByCardId", "cardId", "", "getPosInLicenseListByCardId", "getPosInTicketListByCardId", "getRelativePosByType", "cardType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByCardId", "title", "setModelList", "Companion", "plugin-card_release"})
public final class a
  extends RecyclerView.a<d>
{
  public static final a.a oiS;
  private ArrayList<b> oiM;
  private ArrayList<b> oiN;
  private ArrayList<b> oiO;
  private b oiP;
  private b oiQ;
  private boolean oiR;
  
  static
  {
    AppMethodBeat.i(112523);
    oiS = new a.a((byte)0);
    AppMethodBeat.o(112523);
  }
  
  public a(boolean paramBoolean)
  {
    this.oiR = paramBoolean;
  }
  
  public final b Ab(int paramInt)
  {
    AppMethodBeat.i(112517);
    Object localObject1 = this.oiO;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      localObject2 = this.oiM;
      if (localObject2 == null) {
        break label134;
      }
      localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
      label47:
      localObject3 = this.oiN;
      if (localObject3 == null) {
        break label140;
      }
    }
    label134:
    label140:
    for (Object localObject3 = Integer.valueOf(((ArrayList)localObject3).size());; localObject3 = null)
    {
      ac.d("MicroMsg.CardTicketAdapter", "pos: %s, jSize: %s, tSize: %s, lSize: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, localObject3 });
      j = -1;
      if (this.oiP == null) {
        break label148;
      }
      if (paramInt != 0) {
        break label146;
      }
      localObject1 = this.oiP;
      AppMethodBeat.o(112517);
      return localObject1;
      localObject1 = null;
      break;
      localObject2 = null;
      break label47;
    }
    label146:
    int j = 0;
    label148:
    localObject1 = this.oiO;
    int i = j;
    if (localObject1 != null)
    {
      if ((paramInt > j) && (paramInt <= ((ArrayList)localObject1).size() + j))
      {
        localObject1 = (b)((ArrayList)localObject1).get(paramInt - j - 1);
        AppMethodBeat.o(112517);
        return localObject1;
      }
      i = j + ((ArrayList)localObject1).size();
    }
    localObject1 = this.oiM;
    j = i;
    if (localObject1 != null)
    {
      if ((paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
      {
        localObject1 = (b)((ArrayList)localObject1).get(paramInt - i - 1);
        AppMethodBeat.o(112517);
        return localObject1;
      }
      j = i + ((ArrayList)localObject1).size();
    }
    i = j;
    if (this.oiQ != null)
    {
      j += 1;
      i = j;
      if (paramInt == j)
      {
        localObject1 = this.oiQ;
        AppMethodBeat.o(112517);
        return localObject1;
      }
    }
    localObject1 = this.oiN;
    if ((localObject1 != null) && (paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
    {
      localObject1 = (b)((ArrayList)localObject1).get(paramInt - i - 1);
      AppMethodBeat.o(112517);
      return localObject1;
    }
    AppMethodBeat.o(112517);
    return null;
  }
  
  public final void Vj(String paramString)
  {
    AppMethodBeat.i(112519);
    k.h(paramString, "cardId");
    if (this.oiP != null) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = this.oiO;
      int j;
      Iterator localIterator;
      b localb;
      if (localObject != null)
      {
        i += ((ArrayList)localObject).size();
        localArrayList = this.oiM;
        j = i;
        if (localArrayList != null)
        {
          localIterator = ((Iterable)localArrayList).iterator();
          j = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label215;
          }
          localb = (b)localIterator.next();
          localObject = localb.oiU;
          if (localObject != null) {}
          for (localObject = ((ccu)localObject).DMR;; localObject = null)
          {
            if (!n.I((String)localObject, paramString, false)) {
              break label208;
            }
            localArrayList.remove(localb);
            ac.d("MicroMsg.CardTicketAdapter", "remove ticket: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if (localArrayList.isEmpty()) {
              if (this.oiO != null)
              {
                paramString = this.oiO;
                if (paramString == null) {
                  k.fOy();
                }
                if (!paramString.isEmpty()) {}
              }
              else
              {
                this.oiP = null;
              }
            }
            notifyDataSetChanged();
            AppMethodBeat.o(112519);
            return;
            break;
          }
          label208:
          j += 1;
        }
        label215:
        j = i + localArrayList.size();
      }
      i = j;
      if (this.oiQ != null) {
        i = j + 1;
      }
      ArrayList localArrayList = this.oiN;
      if (localArrayList != null)
      {
        localIterator = ((Iterable)localArrayList).iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localb = (b)localIterator.next();
          localObject = localb.oiU;
          if (localObject != null) {}
          for (localObject = ((ccu)localObject).DMR; n.I((String)localObject, paramString, false); localObject = null)
          {
            localArrayList.remove(localb);
            ac.d("MicroMsg.CardTicketAdapter", "remove license: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if (localArrayList.isEmpty()) {
              this.oiQ = null;
            }
            notifyDataSetChanged();
            AppMethodBeat.o(112519);
            return;
          }
          j += 1;
        }
        AppMethodBeat.o(112519);
        return;
      }
      AppMethodBeat.o(112519);
      return;
    }
  }
  
  public final void Vk(String paramString)
  {
    AppMethodBeat.i(112521);
    k.h(paramString, "title");
    if (bs.isNullOrNil(paramString))
    {
      this.oiP = null;
      AppMethodBeat.o(112521);
      return;
    }
    if (this.oiP == null)
    {
      this.oiP = new b();
      localb = this.oiP;
      if (localb == null) {
        k.fOy();
      }
      localb.type = 0;
    }
    b localb = this.oiP;
    if (localb == null) {
      k.fOy();
    }
    localb.title = paramString;
    AppMethodBeat.o(112521);
  }
  
  public final void Vl(String paramString)
  {
    AppMethodBeat.i(112522);
    k.h(paramString, "title");
    if (bs.isNullOrNil(paramString))
    {
      this.oiQ = null;
      AppMethodBeat.o(112522);
      return;
    }
    if (this.oiQ == null)
    {
      this.oiQ = new b();
      localb = this.oiQ;
      if (localb == null) {
        k.fOy();
      }
      localb.type = 0;
    }
    b localb = this.oiQ;
    if (localb == null) {
      k.fOy();
    }
    localb.title = paramString;
    AppMethodBeat.o(112522);
  }
  
  public final void a(ArrayList<b> paramArrayList1, ArrayList<b> paramArrayList2, ArrayList<b> paramArrayList3)
  {
    AppMethodBeat.i(112520);
    this.oiO = paramArrayList1;
    this.oiM = paramArrayList2;
    this.oiN = paramArrayList3;
    notifyDataSetChanged();
    AppMethodBeat.o(112520);
  }
  
  public final int cD(String paramString, int paramInt)
  {
    AppMethodBeat.i(112518);
    k.h(paramString, "cardId");
    Object localObject;
    Iterator localIterator;
    switch (paramInt)
    {
    default: 
      k.h(paramString, "cardId");
      localObject = this.oiN;
      if (localObject != null)
      {
        localIterator = ((Iterable)localObject).iterator();
        paramInt = 0;
      }
      break;
    case 1: 
      while (localIterator.hasNext())
      {
        localObject = ((b)localIterator.next()).oiU;
        if (localObject != null) {}
        for (localObject = ((ccu)localObject).DMR; k.g(localObject, paramString); localObject = null)
        {
          AppMethodBeat.o(112518);
          return paramInt;
          k.h(paramString, "cardId");
          localObject = this.oiO;
          int i;
          if (localObject != null)
          {
            paramInt = ((ArrayList)localObject).size() + 0;
            localObject = this.oiM;
            if (localObject != null)
            {
              localIterator = ((Iterable)localObject).iterator();
              i = 0;
            }
          }
          else
          {
            for (;;)
            {
              if (!localIterator.hasNext()) {
                break label241;
              }
              localObject = ((b)localIterator.next()).oiU;
              if (localObject != null) {}
              for (localObject = ((ccu)localObject).DMR;; localObject = null)
              {
                if (!k.g(localObject, paramString)) {
                  break label234;
                }
                AppMethodBeat.o(112518);
                return i + paramInt;
                paramInt = 0;
                break;
              }
              label234:
              i += 1;
            }
          }
          label241:
          AppMethodBeat.o(112518);
          return 0;
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(112518);
    return 0;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(112516);
    int j = 0;
    if (this.oiP != null) {
      j = 1;
    }
    ArrayList localArrayList = this.oiO;
    int i = j;
    if (localArrayList != null) {
      i = j + localArrayList.size();
    }
    localArrayList = this.oiM;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.oiQ != null) {
      i = j + 1;
    }
    localArrayList = this.oiN;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    AppMethodBeat.o(112516);
    return j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(112515);
    b localb = Ab(paramInt);
    if (localb != null)
    {
      paramInt = localb.type;
      AppMethodBeat.o(112515);
      return paramInt;
    }
    AppMethodBeat.o(112515);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */