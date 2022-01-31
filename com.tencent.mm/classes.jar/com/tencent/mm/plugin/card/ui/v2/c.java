package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import a.l.m;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "isInvalid", "", "(Z)V", "()Z", "setInvalid", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "Lkotlin/collections/ArrayList;", "getJumpList", "()Ljava/util/ArrayList;", "setJumpList", "(Ljava/util/ArrayList;)V", "licenseList", "getLicenseList", "setLicenseList", "licenseTitle", "getLicenseTitle", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "setLicenseTitle", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;)V", "ticketList", "getTicketList", "setTicketList", "ticketTitle", "getTicketTitle", "setTicketTitle", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByCardId", "cardId", "", "getPosInLicenseListByCardId", "getPosInTicketListByCardId", "getRelativePosByType", "cardType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByCardId", "title", "setModelList", "Companion", "plugin-card_release"})
public final class c
  extends RecyclerView.a<f>
{
  public static final c.a kAz;
  private ArrayList<d> kAt;
  private ArrayList<d> kAu;
  private ArrayList<d> kAv;
  private d kAw;
  private d kAx;
  private boolean kAy;
  
  static
  {
    AppMethodBeat.i(89297);
    kAz = new c.a((byte)0);
    AppMethodBeat.o(89297);
  }
  
  public c(boolean paramBoolean)
  {
    this.kAy = paramBoolean;
  }
  
  public final void In(String paramString)
  {
    AppMethodBeat.i(89293);
    j.q(paramString, "cardId");
    if (this.kAw != null) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = this.kAv;
      int j;
      Iterator localIterator;
      d locald;
      if (localObject != null)
      {
        i += ((ArrayList)localObject).size();
        localArrayList = this.kAt;
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
          locald = (d)localIterator.next();
          localObject = locald.kAB;
          if (localObject != null) {}
          for (localObject = ((bkj)localObject).wmm;; localObject = null)
          {
            if (!m.I((String)localObject, paramString, false)) {
              break label208;
            }
            localArrayList.remove(locald);
            ab.d("MicroMsg.CardTicketAdapter", "remove ticket: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if (localArrayList.isEmpty()) {
              if (this.kAv != null)
              {
                paramString = this.kAv;
                if (paramString == null) {
                  j.ebi();
                }
                if (!paramString.isEmpty()) {}
              }
              else
              {
                this.kAw = null;
              }
            }
            notifyDataSetChanged();
            AppMethodBeat.o(89293);
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
      if (this.kAx != null) {
        i = j + 1;
      }
      ArrayList localArrayList = this.kAu;
      if (localArrayList != null)
      {
        localIterator = ((Iterable)localArrayList).iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          locald = (d)localIterator.next();
          localObject = locald.kAB;
          if (localObject != null) {}
          for (localObject = ((bkj)localObject).wmm; m.I((String)localObject, paramString, false); localObject = null)
          {
            localArrayList.remove(locald);
            ab.d("MicroMsg.CardTicketAdapter", "remove license: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if (localArrayList.isEmpty()) {
              this.kAx = null;
            }
            notifyDataSetChanged();
            AppMethodBeat.o(89293);
            return;
          }
          j += 1;
        }
        AppMethodBeat.o(89293);
        return;
      }
      AppMethodBeat.o(89293);
      return;
    }
  }
  
  public final void Io(String paramString)
  {
    AppMethodBeat.i(89295);
    j.q(paramString, "title");
    if (bo.isNullOrNil(paramString))
    {
      this.kAw = null;
      AppMethodBeat.o(89295);
      return;
    }
    if (this.kAw == null)
    {
      this.kAw = new d();
      locald = this.kAw;
      if (locald == null) {
        j.ebi();
      }
      locald.type = 0;
    }
    d locald = this.kAw;
    if (locald == null) {
      j.ebi();
    }
    locald.title = paramString;
    AppMethodBeat.o(89295);
  }
  
  public final void Ip(String paramString)
  {
    AppMethodBeat.i(89296);
    j.q(paramString, "title");
    if (bo.isNullOrNil(paramString))
    {
      this.kAx = null;
      AppMethodBeat.o(89296);
      return;
    }
    if (this.kAx == null)
    {
      this.kAx = new d();
      locald = this.kAx;
      if (locald == null) {
        j.ebi();
      }
      locald.type = 0;
    }
    d locald = this.kAx;
    if (locald == null) {
      j.ebi();
    }
    locald.title = paramString;
    AppMethodBeat.o(89296);
  }
  
  public final void a(ArrayList<d> paramArrayList1, ArrayList<d> paramArrayList2, ArrayList<d> paramArrayList3)
  {
    AppMethodBeat.i(89294);
    this.kAv = paramArrayList1;
    this.kAt = paramArrayList2;
    this.kAu = paramArrayList3;
    notifyDataSetChanged();
    AppMethodBeat.o(89294);
  }
  
  public final int bP(String paramString, int paramInt)
  {
    AppMethodBeat.i(89292);
    j.q(paramString, "cardId");
    Object localObject;
    Iterator localIterator;
    switch (paramInt)
    {
    default: 
      j.q(paramString, "cardId");
      localObject = this.kAu;
      if (localObject != null)
      {
        localIterator = ((Iterable)localObject).iterator();
        paramInt = 0;
      }
      break;
    case 1: 
      while (localIterator.hasNext())
      {
        localObject = ((d)localIterator.next()).kAB;
        if (localObject != null) {}
        for (localObject = ((bkj)localObject).wmm; j.e(localObject, paramString); localObject = null)
        {
          AppMethodBeat.o(89292);
          return paramInt;
          j.q(paramString, "cardId");
          localObject = this.kAv;
          int i;
          if (localObject != null)
          {
            paramInt = ((ArrayList)localObject).size() + 0;
            localObject = this.kAt;
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
              localObject = ((d)localIterator.next()).kAB;
              if (localObject != null) {}
              for (localObject = ((bkj)localObject).wmm;; localObject = null)
              {
                if (!j.e(localObject, paramString)) {
                  break label234;
                }
                AppMethodBeat.o(89292);
                return i + paramInt;
                paramInt = 0;
                break;
              }
              label234:
              i += 1;
            }
          }
          label241:
          AppMethodBeat.o(89292);
          return 0;
        }
        paramInt += 1;
      }
    }
    AppMethodBeat.o(89292);
    return 0;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(89290);
    int j = 0;
    if (this.kAw != null) {
      j = 1;
    }
    ArrayList localArrayList = this.kAv;
    int i = j;
    if (localArrayList != null) {
      i = j + localArrayList.size();
    }
    localArrayList = this.kAt;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.kAx != null) {
      i = j + 1;
    }
    localArrayList = this.kAu;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    AppMethodBeat.o(89290);
    return j;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(89289);
    d locald = ts(paramInt);
    if (locald != null)
    {
      paramInt = locald.type;
      AppMethodBeat.o(89289);
      return paramInt;
    }
    AppMethodBeat.o(89289);
    return -1;
  }
  
  public final d ts(int paramInt)
  {
    AppMethodBeat.i(89291);
    Object localObject1 = this.kAv;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      localObject2 = this.kAt;
      if (localObject2 == null) {
        break label137;
      }
      localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
      label48:
      localObject3 = this.kAu;
      if (localObject3 == null) {
        break label143;
      }
    }
    label137:
    label143:
    for (Object localObject3 = Integer.valueOf(((ArrayList)localObject3).size());; localObject3 = null)
    {
      ab.d("MicroMsg.CardTicketAdapter", "pos: %s, jSize: %s, tSize: %s, lSize: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, localObject3 });
      j = -1;
      if (this.kAw == null) {
        break label151;
      }
      if (paramInt != 0) {
        break label149;
      }
      localObject1 = this.kAw;
      AppMethodBeat.o(89291);
      return localObject1;
      localObject1 = null;
      break;
      localObject2 = null;
      break label48;
    }
    label149:
    int j = 0;
    label151:
    localObject1 = this.kAv;
    int i = j;
    if (localObject1 != null)
    {
      if ((paramInt > j) && (paramInt <= ((ArrayList)localObject1).size() + j))
      {
        localObject1 = (d)((ArrayList)localObject1).get(paramInt - j - 1);
        AppMethodBeat.o(89291);
        return localObject1;
      }
      i = j + ((ArrayList)localObject1).size();
    }
    localObject1 = this.kAt;
    j = i;
    if (localObject1 != null)
    {
      if ((paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
      {
        localObject1 = (d)((ArrayList)localObject1).get(paramInt - i - 1);
        AppMethodBeat.o(89291);
        return localObject1;
      }
      j = i + ((ArrayList)localObject1).size();
    }
    i = j;
    if (this.kAx != null)
    {
      j += 1;
      i = j;
      if (paramInt == j)
      {
        localObject1 = this.kAx;
        AppMethodBeat.o(89291);
        return localObject1;
      }
    }
    localObject1 = this.kAu;
    if ((localObject1 != null) && (paramInt > i) && (paramInt <= ((ArrayList)localObject1).size() + i))
    {
      localObject1 = (d)((ArrayList)localObject1).get(paramInt - i - 1);
      AppMethodBeat.o(89291);
      return localObject1;
    }
    AppMethodBeat.o(89291);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.c
 * JD-Core Version:    0.7.0.1
 */