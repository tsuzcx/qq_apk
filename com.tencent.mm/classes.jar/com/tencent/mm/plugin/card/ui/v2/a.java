package com.tencent.mm.plugin.card.ui.v2;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "isInvalid", "", "(Z)V", "()Z", "setInvalid", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "Lkotlin/collections/ArrayList;", "getJumpList", "()Ljava/util/ArrayList;", "setJumpList", "(Ljava/util/ArrayList;)V", "licenseList", "getLicenseList", "setLicenseList", "licenseTitle", "getLicenseTitle", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "setLicenseTitle", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;)V", "medicareCard", "getMedicareCard", "setMedicareCard", "ticketList", "getTicketList", "setTicketList", "ticketTitle", "getTicketTitle", "setTicketTitle", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByCardId", "cardId", "", "getPosInLicenseListByCardId", "getPosInTicketListByCardId", "getRelativePosByType", "cardType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByCardId", "title", "setModelList", "Companion", "plugin-card_release"})
public final class a
  extends RecyclerView.a<d>
{
  public static final a.a oSP;
  private ArrayList<b> oSI;
  private ArrayList<b> oSJ;
  private ArrayList<b> oSK;
  private b oSL;
  private b oSM;
  private b oSN;
  private boolean oSO;
  
  static
  {
    AppMethodBeat.i(112523);
    oSP = new a.a((byte)0);
    AppMethodBeat.o(112523);
  }
  
  public a(boolean paramBoolean)
  {
    this.oSO = paramBoolean;
  }
  
  public final b AW(int paramInt)
  {
    AppMethodBeat.i(112517);
    Object localObject1 = this.oSK;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      localObject2 = this.oSI;
      if (localObject2 == null) {
        break label134;
      }
      localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
      label47:
      localObject3 = this.oSJ;
      if (localObject3 == null) {
        break label140;
      }
    }
    label134:
    label140:
    for (Object localObject3 = Integer.valueOf(((ArrayList)localObject3).size());; localObject3 = null)
    {
      ae.d("MicroMsg.CardTicketAdapter", "pos: %s, jSize: %s, tSize: %s, lSize: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, localObject3 });
      j = -1;
      if (this.oSL == null) {
        break label148;
      }
      if (paramInt != 0) {
        break label146;
      }
      localObject1 = this.oSL;
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
    localObject1 = this.oSK;
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
    localObject1 = this.oSI;
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
    if (this.oSM != null)
    {
      j += 1;
      i = j;
      if (paramInt == j)
      {
        localObject1 = this.oSM;
        AppMethodBeat.o(112517);
        return localObject1;
      }
    }
    localObject1 = this.oSJ;
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
    if ((this.oSN != null) && (paramInt == j + 1))
    {
      localObject1 = this.oSN;
      AppMethodBeat.o(112517);
      return localObject1;
    }
    AppMethodBeat.o(112517);
    return null;
  }
  
  public final void ZJ(String paramString)
  {
    AppMethodBeat.i(112519);
    p.h(paramString, "cardId");
    if (this.oSL != null) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = this.oSK;
      int j;
      Iterator localIterator;
      b localb;
      if (localObject != null)
      {
        i += ((ArrayList)localObject).size();
        localArrayList = this.oSI;
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
          localObject = localb.oSR;
          if (localObject != null) {}
          for (localObject = ((cii)localObject).FKu;; localObject = null)
          {
            if (!n.H((String)localObject, paramString, false)) {
              break label208;
            }
            localArrayList.remove(localb);
            ae.d("MicroMsg.CardTicketAdapter", "remove ticket: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if (localArrayList.isEmpty()) {
              if (this.oSK != null)
              {
                paramString = this.oSK;
                if (paramString == null) {
                  p.gkB();
                }
                if (!paramString.isEmpty()) {}
              }
              else
              {
                this.oSL = null;
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
      if (this.oSM != null) {
        i = j + 1;
      }
      ArrayList localArrayList = this.oSJ;
      if (localArrayList != null)
      {
        localIterator = ((Iterable)localArrayList).iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localb = (b)localIterator.next();
          localObject = localb.oSR;
          if (localObject != null) {}
          for (localObject = ((cii)localObject).FKu; n.H((String)localObject, paramString, false); localObject = null)
          {
            localArrayList.remove(localb);
            ae.d("MicroMsg.CardTicketAdapter", "remove license: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if ((localArrayList.isEmpty()) && (this.oSN == null)) {
              this.oSM = null;
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
  
  public final void ZK(String paramString)
  {
    AppMethodBeat.i(112521);
    p.h(paramString, "title");
    if (bu.isNullOrNil(paramString))
    {
      this.oSL = null;
      AppMethodBeat.o(112521);
      return;
    }
    if (this.oSL == null)
    {
      this.oSL = new b();
      localb = this.oSL;
      if (localb == null) {
        p.gkB();
      }
      localb.type = 0;
    }
    b localb = this.oSL;
    if (localb == null) {
      p.gkB();
    }
    localb.title = paramString;
    AppMethodBeat.o(112521);
  }
  
  public final void ZL(String paramString)
  {
    AppMethodBeat.i(112522);
    p.h(paramString, "title");
    if (bu.isNullOrNil(paramString))
    {
      this.oSM = null;
      AppMethodBeat.o(112522);
      return;
    }
    if (this.oSM == null)
    {
      this.oSM = new b();
      localb = this.oSM;
      if (localb == null) {
        p.gkB();
      }
      localb.type = 0;
    }
    b localb = this.oSM;
    if (localb == null) {
      p.gkB();
    }
    localb.title = paramString;
    AppMethodBeat.o(112522);
  }
  
  public final void a(ArrayList<b> paramArrayList1, ArrayList<b> paramArrayList2, ArrayList<b> paramArrayList3, b paramb)
  {
    AppMethodBeat.i(218408);
    this.oSK = paramArrayList1;
    this.oSI = paramArrayList2;
    this.oSJ = paramArrayList3;
    this.oSN = paramb;
    notifyDataSetChanged();
    AppMethodBeat.o(218408);
  }
  
  public final int cK(String paramString, int paramInt)
  {
    AppMethodBeat.i(112518);
    p.h(paramString, "cardId");
    Object localObject;
    Iterator localIterator;
    switch (paramInt)
    {
    default: 
      p.h(paramString, "cardId");
      localObject = this.oSJ;
      if (localObject != null)
      {
        localIterator = ((Iterable)localObject).iterator();
        paramInt = 0;
      }
      break;
    case 1: 
      while (localIterator.hasNext())
      {
        localObject = ((b)localIterator.next()).oSR;
        if (localObject != null) {}
        for (localObject = ((cii)localObject).FKu; p.i(localObject, paramString); localObject = null)
        {
          AppMethodBeat.o(112518);
          return paramInt;
          p.h(paramString, "cardId");
          localObject = this.oSK;
          int i;
          if (localObject != null)
          {
            paramInt = ((ArrayList)localObject).size() + 0;
            localObject = this.oSI;
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
              localObject = ((b)localIterator.next()).oSR;
              if (localObject != null) {}
              for (localObject = ((cii)localObject).FKu;; localObject = null)
              {
                if (!p.i(localObject, paramString)) {
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
    if (this.oSL != null) {
      j = 1;
    }
    ArrayList localArrayList = this.oSK;
    int i = j;
    if (localArrayList != null) {
      i = j + localArrayList.size();
    }
    localArrayList = this.oSI;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.oSM != null) {
      i = j + 1;
    }
    localArrayList = this.oSJ;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.oSN != null) {
      i = j + 1;
    }
    AppMethodBeat.o(112516);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(112515);
    b localb = AW(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */