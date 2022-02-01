package com.tencent.mm.plugin.card.ui.v2;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "isInvalid", "", "(Z)V", "()Z", "setInvalid", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "Lkotlin/collections/ArrayList;", "getJumpList", "()Ljava/util/ArrayList;", "setJumpList", "(Ljava/util/ArrayList;)V", "licenseList", "getLicenseList", "setLicenseList", "licenseTitle", "getLicenseTitle", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "setLicenseTitle", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;)V", "medicareCard", "getMedicareCard", "setMedicareCard", "ticketList", "getTicketList", "setTicketList", "ticketTitle", "getTicketTitle", "setTicketTitle", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "getModelByPos", "getPosByCardId", "cardId", "", "getPosInLicenseListByCardId", "getPosInTicketListByCardId", "getRelativePosByType", "cardType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByCardId", "title", "setModelList", "Companion", "plugin-card_release"})
public final class a
  extends RecyclerView.a<c>
{
  public static final a.a tCA;
  private ArrayList<b> tCt;
  private ArrayList<b> tCu;
  private ArrayList<b> tCv;
  private b tCw;
  private b tCx;
  private b tCy;
  private boolean tCz;
  
  static
  {
    AppMethodBeat.i(112523);
    tCA = new a.a((byte)0);
    AppMethodBeat.o(112523);
  }
  
  public a(boolean paramBoolean)
  {
    this.tCz = paramBoolean;
  }
  
  public final b Id(int paramInt)
  {
    AppMethodBeat.i(112517);
    Object localObject1 = this.tCv;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      localObject2 = this.tCt;
      if (localObject2 == null) {
        break label134;
      }
      localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
      label47:
      localObject3 = this.tCu;
      if (localObject3 == null) {
        break label140;
      }
    }
    label134:
    label140:
    for (Object localObject3 = Integer.valueOf(((ArrayList)localObject3).size());; localObject3 = null)
    {
      Log.d("MicroMsg.CardTicketAdapter", "pos: %s, jSize: %s, tSize: %s, lSize: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, localObject3 });
      j = -1;
      if (this.tCw == null) {
        break label148;
      }
      if (paramInt != 0) {
        break label146;
      }
      localObject1 = this.tCw;
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
    localObject1 = this.tCv;
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
    localObject1 = this.tCt;
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
    if (this.tCx != null)
    {
      j += 1;
      i = j;
      if (paramInt == j)
      {
        localObject1 = this.tCx;
        AppMethodBeat.o(112517);
        return localObject1;
      }
    }
    localObject1 = this.tCu;
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
    if ((this.tCy != null) && (paramInt == j + 1))
    {
      localObject1 = this.tCy;
      AppMethodBeat.o(112517);
      return localObject1;
    }
    AppMethodBeat.o(112517);
    return null;
  }
  
  public final void a(ArrayList<b> paramArrayList1, ArrayList<b> paramArrayList2, ArrayList<b> paramArrayList3, b paramb)
  {
    AppMethodBeat.i(246273);
    this.tCv = paramArrayList1;
    this.tCt = paramArrayList2;
    this.tCu = paramArrayList3;
    this.tCy = paramb;
    notifyDataSetChanged();
    AppMethodBeat.o(246273);
  }
  
  public final void arB(String paramString)
  {
    AppMethodBeat.i(112519);
    p.k(paramString, "cardId");
    if (this.tCw != null) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = this.tCv;
      int j;
      Iterator localIterator;
      b localb;
      if (localObject != null)
      {
        i += ((ArrayList)localObject).size();
        localArrayList = this.tCt;
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
          localObject = localb.tCC;
          if (localObject != null) {}
          for (localObject = ((dib)localObject).RFf;; localObject = null)
          {
            if (!n.L((String)localObject, paramString, false)) {
              break label208;
            }
            localArrayList.remove(localb);
            Log.d("MicroMsg.CardTicketAdapter", "remove ticket: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if (localArrayList.isEmpty()) {
              if (this.tCv != null)
              {
                paramString = this.tCv;
                if (paramString == null) {
                  p.iCn();
                }
                if (!paramString.isEmpty()) {}
              }
              else
              {
                this.tCw = null;
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
      if (this.tCx != null) {
        i = j + 1;
      }
      ArrayList localArrayList = this.tCu;
      if (localArrayList != null)
      {
        localIterator = ((Iterable)localArrayList).iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localb = (b)localIterator.next();
          localObject = localb.tCC;
          if (localObject != null) {}
          for (localObject = ((dib)localObject).RFf; n.L((String)localObject, paramString, false); localObject = null)
          {
            localArrayList.remove(localb);
            Log.d("MicroMsg.CardTicketAdapter", "remove license: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if ((localArrayList.isEmpty()) && (this.tCy == null)) {
              this.tCx = null;
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
  
  public final void arC(String paramString)
  {
    AppMethodBeat.i(112521);
    p.k(paramString, "title");
    if (Util.isNullOrNil(paramString))
    {
      this.tCw = null;
      AppMethodBeat.o(112521);
      return;
    }
    if (this.tCw == null)
    {
      this.tCw = new b();
      localb = this.tCw;
      if (localb == null) {
        p.iCn();
      }
      localb.type = 0;
    }
    b localb = this.tCw;
    if (localb == null) {
      p.iCn();
    }
    localb.title = paramString;
    AppMethodBeat.o(112521);
  }
  
  public final void arD(String paramString)
  {
    AppMethodBeat.i(112522);
    p.k(paramString, "title");
    if (Util.isNullOrNil(paramString))
    {
      this.tCx = null;
      AppMethodBeat.o(112522);
      return;
    }
    if (this.tCx == null)
    {
      this.tCx = new b();
      localb = this.tCx;
      if (localb == null) {
        p.iCn();
      }
      localb.type = 0;
    }
    b localb = this.tCx;
    if (localb == null) {
      p.iCn();
    }
    localb.title = paramString;
    AppMethodBeat.o(112522);
  }
  
  public final int dk(String paramString, int paramInt)
  {
    AppMethodBeat.i(112518);
    p.k(paramString, "cardId");
    Object localObject;
    Iterator localIterator;
    switch (paramInt)
    {
    default: 
      p.k(paramString, "cardId");
      localObject = this.tCu;
      if (localObject != null)
      {
        localIterator = ((Iterable)localObject).iterator();
        paramInt = 0;
      }
      break;
    case 1: 
      while (localIterator.hasNext())
      {
        localObject = ((b)localIterator.next()).tCC;
        if (localObject != null) {}
        for (localObject = ((dib)localObject).RFf; p.h(localObject, paramString); localObject = null)
        {
          AppMethodBeat.o(112518);
          return paramInt;
          p.k(paramString, "cardId");
          localObject = this.tCv;
          int i;
          if (localObject != null)
          {
            paramInt = ((ArrayList)localObject).size() + 0;
            localObject = this.tCt;
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
              localObject = ((b)localIterator.next()).tCC;
              if (localObject != null) {}
              for (localObject = ((dib)localObject).RFf;; localObject = null)
              {
                if (!p.h(localObject, paramString)) {
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
    if (this.tCw != null) {
      j = 1;
    }
    ArrayList localArrayList = this.tCv;
    int i = j;
    if (localArrayList != null) {
      i = j + localArrayList.size();
    }
    localArrayList = this.tCt;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.tCx != null) {
      i = j + 1;
    }
    localArrayList = this.tCu;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.tCy != null) {
      i = j + 1;
    }
    AppMethodBeat.o(112516);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(246271);
    b localb = Id(paramInt);
    if (localb != null)
    {
      Object localObject2 = localb.title;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = localb.tCC;
      if (localObject2 != null)
      {
        localObject3 = ((dib)localObject2).RFf;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      Object localObject3 = localb.tCB;
      if (localObject3 != null)
      {
        localObject4 = ((dic)localObject3).TPn;
        localObject3 = localObject4;
        if (localObject4 != null) {}
      }
      else
      {
        localObject3 = "";
      }
      Object localObject4 = localb.tCD;
      if (localObject4 != null)
      {
        String str = ((cvx)localObject4).TEF;
        localObject4 = str;
        if (str != null) {}
      }
      else
      {
        localObject4 = "";
      }
      localObject1 = (String)localObject1 + (String)localObject2 + (String)localObject3 + (String)localObject4;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        l = localb.hashCode();
        AppMethodBeat.o(246271);
        return l;
      }
      long l = ((String)localObject1 + paramInt + localb.type).hashCode();
      AppMethodBeat.o(246271);
      return l;
    }
    Log.e("MicroMsg.CardTicketAdapter", "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " }");
    AppMethodBeat.o(246271);
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(112515);
    b localb = Id(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */