package com.tencent.mm.plugin.card.ui.v2;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dnd;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "isInvalid", "", "(Z)V", "()Z", "setInvalid", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "Lkotlin/collections/ArrayList;", "getJumpList", "()Ljava/util/ArrayList;", "setJumpList", "(Ljava/util/ArrayList;)V", "licenseList", "getLicenseList", "setLicenseList", "licenseTitle", "getLicenseTitle", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "setLicenseTitle", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;)V", "medicareCard", "getMedicareCard", "setMedicareCard", "ticketList", "getTicketList", "setTicketList", "ticketTitle", "getTicketTitle", "setTicketTitle", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "getModelByPos", "getPosByCardId", "cardId", "", "getPosInLicenseListByCardId", "getPosInTicketListByCardId", "getRelativePosByType", "cardType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByCardId", "title", "setModelList", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<c>
{
  public static final a.a wGv;
  private b wGA;
  private b wGB;
  private boolean wGC;
  private ArrayList<b> wGw;
  private ArrayList<b> wGx;
  private ArrayList<b> wGy;
  private b wGz;
  
  static
  {
    AppMethodBeat.i(112523);
    wGv = new a.a((byte)0);
    AppMethodBeat.o(112523);
  }
  
  public a(boolean paramBoolean)
  {
    this.wGC = paramBoolean;
  }
  
  public final b IG(int paramInt)
  {
    AppMethodBeat.i(112517);
    Object localObject1 = this.wGy;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = this.wGw;
      if (localObject2 != null) {
        break label120;
      }
      localObject2 = null;
      label33:
      localObject3 = this.wGx;
      if (localObject3 != null) {
        break label133;
      }
    }
    label133:
    for (Object localObject3 = null;; localObject3 = Integer.valueOf(((ArrayList)localObject3).size()))
    {
      Log.d("MicroMsg.CardTicketAdapter", "pos: %s, jSize: %s, tSize: %s, lSize: %s", new Object[] { Integer.valueOf(paramInt), localObject1, localObject2, localObject3 });
      j = -1;
      if (this.wGz == null) {
        break label148;
      }
      if (paramInt != 0) {
        break label146;
      }
      localObject1 = this.wGz;
      AppMethodBeat.o(112517);
      return localObject1;
      localObject1 = Integer.valueOf(((ArrayList)localObject1).size());
      break;
      label120:
      localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
      break label33;
    }
    label146:
    int j = 0;
    label148:
    localObject1 = this.wGy;
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
    localObject1 = this.wGw;
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
    if (this.wGA != null)
    {
      j += 1;
      i = j;
      if (paramInt == j)
      {
        localObject1 = this.wGA;
        AppMethodBeat.o(112517);
        return localObject1;
      }
    }
    localObject1 = this.wGx;
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
    if ((this.wGB != null) && (paramInt == j + 1))
    {
      localObject1 = this.wGB;
      AppMethodBeat.o(112517);
      return localObject1;
    }
    AppMethodBeat.o(112517);
    return null;
  }
  
  public final void a(ArrayList<b> paramArrayList1, ArrayList<b> paramArrayList2, ArrayList<b> paramArrayList3, b paramb)
  {
    AppMethodBeat.i(294243);
    this.wGy = paramArrayList1;
    this.wGw = paramArrayList2;
    this.wGx = paramArrayList3;
    this.wGB = paramb;
    this.bZE.notifyChanged();
    AppMethodBeat.o(294243);
  }
  
  public final void alf(String paramString)
  {
    AppMethodBeat.i(112519);
    s.u(paramString, "cardId");
    if (this.wGz != null) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = this.wGy;
      if (localObject != null) {
        i += ((ArrayList)localObject).size();
      }
      for (;;)
      {
        ArrayList localArrayList = this.wGw;
        int j = i;
        Iterator localIterator;
        if (localArrayList != null)
        {
          localIterator = localArrayList.iterator();
          j = 0;
        }
        for (;;)
        {
          b localb;
          if (localIterator.hasNext())
          {
            localb = (b)localIterator.next();
            localObject = localb.wGE;
            if (localObject == null) {}
            for (localObject = null; n.T((String)localObject, paramString, false); localObject = ((eal)localObject).YBH)
            {
              localArrayList.remove(localb);
              Log.d("MicroMsg.CardTicketAdapter", "remove ticket: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
              if (localArrayList.isEmpty()) {
                if (this.wGy != null)
                {
                  paramString = this.wGy;
                  s.checkNotNull(paramString);
                  if (!paramString.isEmpty()) {}
                }
                else
                {
                  this.wGz = null;
                }
              }
              this.bZE.notifyChanged();
              AppMethodBeat.o(112519);
              return;
            }
          }
          j = i + localArrayList.size();
          i = j;
          if (this.wGA != null) {
            i = j + 1;
          }
          localArrayList = this.wGx;
          if (localArrayList != null)
          {
            localIterator = localArrayList.iterator();
            j = 0;
          }
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localb = (b)localIterator.next();
              localObject = localb.wGE;
              if (localObject == null) {}
              for (localObject = null; n.T((String)localObject, paramString, false); localObject = ((eal)localObject).YBH)
              {
                localArrayList.remove(localb);
                Log.d("MicroMsg.CardTicketAdapter", "remove license: %s, %s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
                if ((localArrayList.isEmpty()) && (this.wGB == null)) {
                  this.wGA = null;
                }
                this.bZE.notifyChanged();
                AppMethodBeat.o(112519);
                return;
              }
            }
            AppMethodBeat.o(112519);
            return;
            j += 1;
          }
          j += 1;
        }
      }
    }
  }
  
  public final void alg(String paramString)
  {
    AppMethodBeat.i(112521);
    s.u(paramString, "title");
    if (Util.isNullOrNil(paramString))
    {
      this.wGz = null;
      AppMethodBeat.o(112521);
      return;
    }
    if (this.wGz == null)
    {
      this.wGz = new b();
      localb = this.wGz;
      s.checkNotNull(localb);
      localb.type = 0;
    }
    b localb = this.wGz;
    s.checkNotNull(localb);
    localb.title = paramString;
    AppMethodBeat.o(112521);
  }
  
  public final void alh(String paramString)
  {
    AppMethodBeat.i(112522);
    s.u(paramString, "title");
    if (Util.isNullOrNil(paramString))
    {
      this.wGA = null;
      AppMethodBeat.o(112522);
      return;
    }
    if (this.wGA == null)
    {
      this.wGA = new b();
      localb = this.wGA;
      s.checkNotNull(localb);
      localb.type = 0;
    }
    b localb = this.wGA;
    s.checkNotNull(localb);
    localb.title = paramString;
    AppMethodBeat.o(112522);
  }
  
  public final int dL(String paramString, int paramInt)
  {
    AppMethodBeat.i(112518);
    s.u(paramString, "cardId");
    Object localObject;
    if (paramInt == 1)
    {
      s.u(paramString, "cardId");
      localObject = this.wGy;
      if (localObject == null) {
        break label240;
      }
    }
    label240:
    for (paramInt = ((ArrayList)localObject).size() + 0;; paramInt = 0)
    {
      localObject = this.wGw;
      Iterator localIterator;
      int i;
      if (localObject != null)
      {
        localIterator = ((ArrayList)localObject).iterator();
        i = 0;
      }
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = ((b)localIterator.next()).wGE;
          if (localObject == null) {}
          for (localObject = null; s.p(localObject, paramString); localObject = ((eal)localObject).YBH)
          {
            AppMethodBeat.o(112518);
            return i + paramInt;
          }
        }
        AppMethodBeat.o(112518);
        return 0;
        s.u(paramString, "cardId");
        localObject = this.wGx;
        if (localObject != null)
        {
          localIterator = ((ArrayList)localObject).iterator();
          paramInt = 0;
        }
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = ((b)localIterator.next()).wGE;
            if (localObject == null) {}
            for (localObject = null; s.p(localObject, paramString); localObject = ((eal)localObject).YBH)
            {
              AppMethodBeat.o(112518);
              return paramInt;
            }
          }
          AppMethodBeat.o(112518);
          return 0;
          paramInt += 1;
        }
        i += 1;
      }
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(112516);
    int j = 0;
    if (this.wGz != null) {
      j = 1;
    }
    ArrayList localArrayList = this.wGy;
    int i = j;
    if (localArrayList != null) {
      i = j + localArrayList.size();
    }
    localArrayList = this.wGw;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.wGA != null) {
      i = j + 1;
    }
    localArrayList = this.wGx;
    j = i;
    if (localArrayList != null) {
      j = i + localArrayList.size();
    }
    i = j;
    if (this.wGB != null) {
      i = j + 1;
    }
    AppMethodBeat.o(112516);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(294197);
    b localb = IG(paramInt);
    if (localb != null)
    {
      Object localObject1 = localb.title;
      Object localObject4 = localObject1;
      if (localObject1 == null) {
        localObject4 = "";
      }
      localObject1 = localb.wGE;
      Object localObject2;
      label73:
      Object localObject3;
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject2 = localb.wGD;
        if (localObject2 != null) {
          break label189;
        }
        localObject2 = "";
        localObject3 = localb.wGF;
        if (localObject3 != null) {
          break label213;
        }
        localObject3 = "";
        label90:
        localObject1 = (String)localObject4 + (String)localObject1 + (String)localObject2 + (String)localObject3;
        localObject2 = (CharSequence)localObject1;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label237;
        }
      }
      label189:
      label213:
      label237:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label242;
        }
        l = localb.hashCode();
        AppMethodBeat.o(294197);
        return l;
        localObject2 = ((eal)localObject1).YBH;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "";
        break;
        localObject3 = ((eam)localObject2).abfJ;
        localObject2 = localObject3;
        if (localObject3 != null) {
          break label73;
        }
        localObject2 = "";
        break label73;
        String str = ((dnd)localObject3).aaUm;
        localObject3 = str;
        if (str != null) {
          break label90;
        }
        localObject3 = "";
        break label90;
      }
      label242:
      long l = ((String)localObject1 + paramInt + localb.type).hashCode();
      AppMethodBeat.o(294197);
      return l;
    }
    Log.e("MicroMsg.CardTicketAdapter", "[getItemId] position=" + paramInt + " itemCount=" + getItemCount() + " }");
    AppMethodBeat.o(294197);
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(112515);
    b localb = IG(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.a
 * JD-Core Version:    0.7.0.1
 */