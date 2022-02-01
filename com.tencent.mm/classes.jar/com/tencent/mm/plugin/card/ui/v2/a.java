package com.tencent.mm.plugin.card.ui.v2;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.cyq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "isInvalid", "", "(Z)V", "()Z", "setInvalid", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "Lkotlin/collections/ArrayList;", "getJumpList", "()Ljava/util/ArrayList;", "setJumpList", "(Ljava/util/ArrayList;)V", "licenseList", "getLicenseList", "setLicenseList", "licenseTitle", "getLicenseTitle", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "setLicenseTitle", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;)V", "medicareCard", "getMedicareCard", "setMedicareCard", "ticketList", "getTicketList", "setTicketList", "ticketTitle", "getTicketTitle", "setTicketTitle", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "getModelByPos", "getPosByCardId", "cardId", "", "getPosInLicenseListByCardId", "getPosInTicketListByCardId", "getRelativePosByType", "cardType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByCardId", "title", "setModelList", "Companion", "plugin-card_release"})
public final class a
  extends RecyclerView.a<c>
{
  public static final a.a qgE;
  private b qgA;
  private b qgB;
  private b qgC;
  private boolean qgD;
  private ArrayList<b> qgx;
  private ArrayList<b> qgy;
  private ArrayList<b> qgz;
  
  static
  {
    AppMethodBeat.i(112523);
    qgE = new a.a((byte)0);
    AppMethodBeat.o(112523);
  }
  
  public a(boolean paramBoolean)
  {
    this.qgD = paramBoolean;
  }
  
  public final b EB(int paramInt)
  {
    AppMethodBeat.i(112517);
    Object localObject1 = this.qgz;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      localObject2 = this.qgx;
      if (localObject2 == null) {
        break label134;
      }
      localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
      label47:
      localObject3 = this.qgy;
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
      if (this.qgA == null) {
        break label148;
      }
      if (paramInt != 0) {
        break label146;
      }
      localObject1 = this.qgA;
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
    localObject1 = this.qgz;
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
    localObject1 = this.qgx;
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
    if (this.qgB != null)
    {
      j += 1;
      i = j;
      if (paramInt == j)
      {
        localObject1 = this.qgB;
        AppMethodBeat.o(112517);
        return localObject1;
      }
    }
    localObject1 = this.qgy;
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
    if ((this.qgC != null) && (paramInt == j + 1))
    {
      localObject1 = this.qgC;
      AppMethodBeat.o(112517);
      return localObject1;
    }
    AppMethodBeat.o(112517);
    return null;
  }
  
  public final void a(ArrayList<b> paramArrayList1, ArrayList<b> paramArrayList2, ArrayList<b> paramArrayList3, b paramb)
  {
    AppMethodBeat.i(201400);
    this.qgz = paramArrayList1;
    this.qgx = paramArrayList2;
    this.qgy = paramArrayList3;
    this.qgC = paramb;
    notifyDataSetChanged();
    AppMethodBeat.o(201400);
  }
  
  public final void ajO(String paramString)
  {
    AppMethodBeat.i(112519);
    p.h(paramString, "cardId");
    if (this.qgA != null) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = this.qgz;
      int j;
      Iterator localIterator;
      b localb;
      if (localObject != null)
      {
        i += ((ArrayList)localObject).size();
        localArrayList = this.qgx;
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
            break label219;
          }
          localb = (b)localIterator.next();
          localObject = localb.qgG;
          if (localObject != null) {}
          for (localObject = ((cyp)localObject).KDM;; localObject = null)
          {
            if (!n.I((String)localObject, paramString, false)) {
              break label212;
            }
            localArrayList.remove(localb);
            Log.d("MicroMsg.CardTicketAdapter", "remove ticket: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if (localArrayList.isEmpty()) {
              if (this.qgz != null)
              {
                paramString = this.qgz;
                if (paramString == null) {
                  p.hyc();
                }
                if (!paramString.isEmpty()) {}
              }
              else
              {
                this.qgA = null;
              }
            }
            notifyDataSetChanged();
            AppMethodBeat.o(112519);
            return;
            break;
          }
          label212:
          j += 1;
        }
        label219:
        j = i + localArrayList.size();
      }
      i = j;
      if (this.qgB != null) {
        i = j + 1;
      }
      ArrayList localArrayList = this.qgy;
      if (localArrayList != null)
      {
        localIterator = ((Iterable)localArrayList).iterator();
        j = 0;
        while (localIterator.hasNext())
        {
          localb = (b)localIterator.next();
          localObject = localb.qgG;
          if (localObject != null) {}
          for (localObject = ((cyp)localObject).KDM; n.I((String)localObject, paramString, false); localObject = null)
          {
            localArrayList.remove(localb);
            Log.d("MicroMsg.CardTicketAdapter", "remove license: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
            if ((localArrayList.isEmpty()) && (this.qgC == null)) {
              this.qgB = null;
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
  
  public final void ajP(String paramString)
  {
    AppMethodBeat.i(112521);
    p.h(paramString, "title");
    if (Util.isNullOrNil(paramString))
    {
      this.qgA = null;
      AppMethodBeat.o(112521);
      return;
    }
    if (this.qgA == null)
    {
      this.qgA = new b();
      localb = this.qgA;
      if (localb == null) {
        p.hyc();
      }
      localb.type = 0;
    }
    b localb = this.qgA;
    if (localb == null) {
      p.hyc();
    }
    localb.title = paramString;
    AppMethodBeat.o(112521);
  }
  
  public final void ajQ(String paramString)
  {
    AppMethodBeat.i(112522);
    p.h(paramString, "title");
    if (Util.isNullOrNil(paramString))
    {
      this.qgB = null;
      AppMethodBeat.o(112522);
      return;
    }
    if (this.qgB == null)
    {
      this.qgB = new b();
      localb = this.qgB;
      if (localb == null) {
        p.hyc();
      }
      localb.type = 0;
    }
    b localb = this.qgB;
    if (localb == null) {
      p.hyc();
    }
    localb.title = paramString;
    AppMethodBeat.o(112522);
  }
  
  public final int cQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(112518);
    p.h(paramString, "cardId");
    Object localObject;
    Iterator localIterator;
    switch (paramInt)
    {
    default: 
      p.h(paramString, "cardId");
      localObject = this.qgy;
      if (localObject != null)
      {
        localIterator = ((Iterable)localObject).iterator();
        paramInt = 0;
      }
      break;
    case 1: 
      while (localIterator.hasNext())
      {
        localObject = ((b)localIterator.next()).qgG;
        if (localObject != null) {}
        for (localObject = ((cyp)localObject).KDM; p.j(localObject, paramString); localObject = null)
        {
          AppMethodBeat.o(112518);
          return paramInt;
          p.h(paramString, "cardId");
          localObject = this.qgz;
          int i;
          if (localObject != null)
          {
            paramInt = ((ArrayList)localObject).size() + 0;
            localObject = this.qgx;
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
                break label243;
              }
              localObject = ((b)localIterator.next()).qgG;
              if (localObject != null) {}
              for (localObject = ((cyp)localObject).KDM;; localObject = null)
              {
                if (!p.j(localObject, paramString)) {
                  break label236;
                }
                AppMethodBeat.o(112518);
                return i + paramInt;
                paramInt = 0;
                break;
              }
              label236:
              i += 1;
            }
          }
          label243:
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
    if (this.qgA != null) {
      j = 1;
    }
    ArrayList localArrayList = this.qgz;
    int i = j;
    if (localArrayList != null) {
      i = j + localArrayList.size();
    }
    localArrayList = this.qgx;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.qgB != null) {
      i = j + 1;
    }
    localArrayList = this.qgy;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.qgC != null) {
      i = j + 1;
    }
    AppMethodBeat.o(112516);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(201399);
    b localb = EB(paramInt);
    if (localb != null)
    {
      Object localObject2 = localb.title;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = localb.qgG;
      if (localObject2 != null)
      {
        localObject3 = ((cyp)localObject2).KDM;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = "";
      }
      Object localObject3 = localb.qgF;
      if (localObject3 != null)
      {
        localObject4 = ((cyq)localObject3).MDE;
        localObject3 = localObject4;
        if (localObject4 != null) {}
      }
      else
      {
        localObject3 = "";
      }
      Object localObject4 = localb.qgH;
      if (localObject4 != null)
      {
        String str = ((cnf)localObject4).Mtz;
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
        AppMethodBeat.o(201399);
        return l;
      }
      long l = ((String)localObject1 + paramInt + localb.type).hashCode();
      AppMethodBeat.o(201399);
      return l;
    }
    Log.e("MicroMsg.CardTicketAdapter", "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " }");
    AppMethodBeat.o(201399);
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(112515);
    b localb = EB(paramInt);
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