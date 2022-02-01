package com.tencent.mm.plugin.card.ui.v2;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "isInvalid", "", "(Z)V", "()Z", "setInvalid", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "Lkotlin/collections/ArrayList;", "getJumpList", "()Ljava/util/ArrayList;", "setJumpList", "(Ljava/util/ArrayList;)V", "licenseList", "getLicenseList", "setLicenseList", "licenseTitle", "getLicenseTitle", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "setLicenseTitle", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;)V", "medicareCard", "getMedicareCard", "setMedicareCard", "ticketList", "getTicketList", "setTicketList", "ticketTitle", "getTicketTitle", "setTicketTitle", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByCardId", "cardId", "", "getPosInLicenseListByCardId", "getPosInTicketListByCardId", "getRelativePosByType", "cardType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByCardId", "title", "setModelList", "Companion", "plugin-card_release"})
public final class a
  extends RecyclerView.a<d>
{
  public static final a.a oMn;
  private ArrayList<b> oMg;
  private ArrayList<b> oMh;
  private ArrayList<b> oMi;
  private b oMj;
  private b oMk;
  private b oMl;
  private boolean oMm;
  
  static
  {
    AppMethodBeat.i(112523);
    oMn = new a.a((byte)0);
    AppMethodBeat.o(112523);
  }
  
  public a(boolean paramBoolean)
  {
    this.oMm = paramBoolean;
  }
  
  public final b AK(int paramInt)
  {
    AppMethodBeat.i(112517);
    Object localObject1 = this.oMi;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      localObject2 = this.oMg;
      if (localObject2 == null) {
        break label134;
      }
      localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
      label47:
      localObject3 = this.oMh;
      if (localObject3 == null) {
        break label140;
      }
    }
    label134:
    label140:
    for (Object localObject3 = Integer.valueOf(((ArrayList)localObject3).size());; localObject3 = null)
    {
      ad.d("MicroMsg.CardTicketAdapter", "pos: %s, jSize: %s, tSize: %s, lSize: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, localObject3 });
      j = -1;
      if (this.oMj == null) {
        break label148;
      }
      if (paramInt != 0) {
        break label146;
      }
      localObject1 = this.oMj;
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
    localObject1 = this.oMi;
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
    localObject1 = this.oMg;
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
    if (this.oMk != null)
    {
      j += 1;
      i = j;
      if (paramInt == j)
      {
        localObject1 = this.oMk;
        AppMethodBeat.o(112517);
        return localObject1;
      }
    }
    localObject1 = this.oMh;
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
    if ((this.oMl != null) && (paramInt == j + 1))
    {
      localObject1 = this.oMl;
      AppMethodBeat.o(112517);
      return localObject1;
    }
    AppMethodBeat.o(112517);
    return null;
  }
  
  public final void YS(String paramString)
  {
    AppMethodBeat.i(112519);
    p.h(paramString, "cardId");
    if (this.oMj != null) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = this.oMi;
      int j;
      Iterator localIterator;
      b localb;
      if (localObject != null)
      {
        i += ((ArrayList)localObject).size();
        localArrayList = this.oMg;
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
          localObject = localb.oMp;
          if (localObject != null) {}
          for (localObject = ((cho)localObject).FrW;; localObject = null)
          {
            if (!n.H((String)localObject, paramString, false)) {
              break label208;
            }
            localArrayList.remove(localb);
            ad.d("MicroMsg.CardTicketAdapter", "remove ticket: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if (localArrayList.isEmpty()) {
              if (this.oMi != null)
              {
                paramString = this.oMi;
                if (paramString == null) {
                  p.gfZ();
                }
                if (!paramString.isEmpty()) {}
              }
              else
              {
                this.oMj = null;
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
      if (this.oMk != null) {
        i = j + 1;
      }
      ArrayList localArrayList = this.oMh;
      if (localArrayList != null)
      {
        localIterator = ((Iterable)localArrayList).iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localb = (b)localIterator.next();
          localObject = localb.oMp;
          if (localObject != null) {}
          for (localObject = ((cho)localObject).FrW; n.H((String)localObject, paramString, false); localObject = null)
          {
            localArrayList.remove(localb);
            ad.d("MicroMsg.CardTicketAdapter", "remove license: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if ((localArrayList.isEmpty()) && (this.oMl == null)) {
              this.oMk = null;
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
  
  public final void YT(String paramString)
  {
    AppMethodBeat.i(112521);
    p.h(paramString, "title");
    if (bt.isNullOrNil(paramString))
    {
      this.oMj = null;
      AppMethodBeat.o(112521);
      return;
    }
    if (this.oMj == null)
    {
      this.oMj = new b();
      localb = this.oMj;
      if (localb == null) {
        p.gfZ();
      }
      localb.type = 0;
    }
    b localb = this.oMj;
    if (localb == null) {
      p.gfZ();
    }
    localb.title = paramString;
    AppMethodBeat.o(112521);
  }
  
  public final void YU(String paramString)
  {
    AppMethodBeat.i(112522);
    p.h(paramString, "title");
    if (bt.isNullOrNil(paramString))
    {
      this.oMk = null;
      AppMethodBeat.o(112522);
      return;
    }
    if (this.oMk == null)
    {
      this.oMk = new b();
      localb = this.oMk;
      if (localb == null) {
        p.gfZ();
      }
      localb.type = 0;
    }
    b localb = this.oMk;
    if (localb == null) {
      p.gfZ();
    }
    localb.title = paramString;
    AppMethodBeat.o(112522);
  }
  
  public final void a(ArrayList<b> paramArrayList1, ArrayList<b> paramArrayList2, ArrayList<b> paramArrayList3, b paramb)
  {
    AppMethodBeat.i(215447);
    this.oMi = paramArrayList1;
    this.oMg = paramArrayList2;
    this.oMh = paramArrayList3;
    this.oMl = paramb;
    notifyDataSetChanged();
    AppMethodBeat.o(215447);
  }
  
  public final int cG(String paramString, int paramInt)
  {
    AppMethodBeat.i(112518);
    p.h(paramString, "cardId");
    Object localObject;
    Iterator localIterator;
    switch (paramInt)
    {
    default: 
      p.h(paramString, "cardId");
      localObject = this.oMh;
      if (localObject != null)
      {
        localIterator = ((Iterable)localObject).iterator();
        paramInt = 0;
      }
      break;
    case 1: 
      while (localIterator.hasNext())
      {
        localObject = ((b)localIterator.next()).oMp;
        if (localObject != null) {}
        for (localObject = ((cho)localObject).FrW; p.i(localObject, paramString); localObject = null)
        {
          AppMethodBeat.o(112518);
          return paramInt;
          p.h(paramString, "cardId");
          localObject = this.oMi;
          int i;
          if (localObject != null)
          {
            paramInt = ((ArrayList)localObject).size() + 0;
            localObject = this.oMg;
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
              localObject = ((b)localIterator.next()).oMp;
              if (localObject != null) {}
              for (localObject = ((cho)localObject).FrW;; localObject = null)
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
    if (this.oMj != null) {
      j = 1;
    }
    ArrayList localArrayList = this.oMi;
    int i = j;
    if (localArrayList != null) {
      i = j + localArrayList.size();
    }
    localArrayList = this.oMg;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.oMk != null) {
      i = j + 1;
    }
    localArrayList = this.oMh;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.oMl != null) {
      i = j + 1;
    }
    AppMethodBeat.o(112516);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(112515);
    b localb = AK(paramInt);
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