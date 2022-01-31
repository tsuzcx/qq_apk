package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.protocal.protobuf.cpk;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  implements com.tencent.mm.plugin.label.a.b
{
  ArrayList<String> nXQ;
  ArrayList<String> nXR;
  private f nXS;
  String username;
  
  public b()
  {
    AppMethodBeat.i(22489);
    this.nXS = new b.1(this);
    AppMethodBeat.o(22489);
  }
  
  static void i(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(22500);
    if (paramArrayList == null) {}
    for (Object localObject1 = "";; localObject1 = paramArrayList.toString())
    {
      ab.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact] username:%s,list:%s", new Object[] { paramString, localObject1 });
      if ((!bo.isNullOrNil(paramString)) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
        break;
      }
      ab.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
      AppMethodBeat.o(22500);
      return;
    }
    Object localObject2 = "";
    localObject1 = localObject2;
    if (paramArrayList != null)
    {
      localObject1 = localObject2;
      if (paramArrayList.size() > 0) {
        localObject1 = c.cd(e.bKU().aj(paramArrayList));
      }
    }
    paramArrayList = new LinkedList();
    localObject2 = new cpk();
    ((cpk)localObject2).wOV = ((String)localObject1);
    ((cpk)localObject2).jJA = paramString;
    paramArrayList.add(localObject2);
    paramString = new d(paramArrayList);
    aw.Rc().a(paramString, 0);
    AppMethodBeat.o(22500);
  }
  
  public final String RN(String paramString)
  {
    AppMethodBeat.i(22491);
    paramString = e.bKU().RN(paramString);
    AppMethodBeat.o(22491);
    return paramString;
  }
  
  public final String RO(String paramString)
  {
    AppMethodBeat.i(22492);
    paramString = e.bKU().RO(paramString);
    AppMethodBeat.o(22492);
    return paramString;
  }
  
  public final List<String> RP(String paramString)
  {
    AppMethodBeat.i(22496);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
      AppMethodBeat.o(22496);
      return null;
    }
    paramString = paramString.split(",");
    if ((paramString != null) && (paramString.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(Arrays.asList(paramString));
      AppMethodBeat.o(22496);
      return localArrayList;
    }
    AppMethodBeat.o(22496);
    return null;
  }
  
  public final void a(k.a parama)
  {
    AppMethodBeat.i(22493);
    e.bKU().add(parama);
    AppMethodBeat.o(22493);
  }
  
  public final void ahN()
  {
    AppMethodBeat.i(22490);
    e.bKU().ahN();
    AppMethodBeat.o(22490);
  }
  
  public final void b(k.a parama)
  {
    AppMethodBeat.i(22494);
    e.bKU().remove(parama);
    AppMethodBeat.o(22494);
  }
  
  public final List<String> bKQ()
  {
    AppMethodBeat.i(22495);
    ai localai = e.bKU();
    long l = bo.aoy();
    ArrayList localArrayList1 = localai.dwH();
    if (localArrayList1 == null)
    {
      AppMethodBeat.o(22495);
      return null;
    }
    localai.dwI();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      ArrayList localArrayList3 = (ArrayList)localai.yMe.get(Integer.valueOf(((af)localArrayList1.get(i)).field_labelID));
      if ((localArrayList3 != null) && (localArrayList3.size() > 0)) {
        localArrayList2.add(((af)localArrayList1.get(i)).field_labelName);
      }
      i += 1;
    }
    ab.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[] { Long.valueOf(bo.hl(l)), Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()), bo.dtY() });
    AppMethodBeat.o(22495);
    return localArrayList2;
  }
  
  final void bKR()
  {
    AppMethodBeat.i(22499);
    this.username = null;
    this.nXQ = null;
    this.nXR = null;
    aw.Rc().b(635, this.nXS);
    aw.Rc().b(638, this.nXS);
    AppMethodBeat.o(22499);
  }
  
  public final String cb(List<String> paramList)
  {
    AppMethodBeat.i(22497);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ab.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
      AppMethodBeat.o(22497);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)paramList.get(i));
      if (i < j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(22497);
    return paramList;
  }
  
  public final void cc(List<String> paramList)
  {
    AppMethodBeat.i(22501);
    paramList = new a(paramList);
    aw.Rc().a(paramList, 0);
    AppMethodBeat.o(22501);
  }
  
  public final void eY(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(22498);
      ab.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", new Object[] { String.valueOf(paramString1), String.valueOf(paramString2) });
      if (bo.isNullOrNil(paramString2))
      {
        ab.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
        AppMethodBeat.o(22498);
      }
      for (;;)
      {
        return;
        paramString2 = (ArrayList)RP(paramString2);
        if ((paramString2 != null) && (!paramString2.isEmpty())) {
          break;
        }
        ab.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
        AppMethodBeat.o(22498);
      }
      this.username = paramString1;
    }
    finally {}
    this.nXQ = paramString2;
    int j = paramString2.size();
    this.nXR = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        af localaf = e.bKU().arm((String)paramString2.get(i));
        if ((localaf != null) && (localaf.field_isTemporary)) {
          this.nXR.add(paramString2.get(i));
        }
      }
      else
      {
        aw.Rc().a(635, this.nXS);
        aw.Rc().a(638, this.nXS);
        if ((this.nXR == null) || (this.nXR.isEmpty()))
        {
          i(paramString1, paramString2);
          bKR();
          AppMethodBeat.o(22498);
          break;
        }
        ab.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[] { this.nXR.toString() });
        paramString1 = new a(this.nXR);
        aw.Rc().a(paramString1, 0);
        AppMethodBeat.o(22498);
        break;
      }
      i += 1;
    }
  }
  
  public final void j(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(22502);
    Object localObject1 = new HashMap();
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    if (paramList1.size() > 0)
    {
      paramList1 = paramList1.iterator();
      paramList2 = paramList2.iterator();
      while (paramList1.hasNext())
      {
        localObject2 = (String)paramList1.next();
        Object localObject3 = bo.P(((String)paramList2.next()).split(","));
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            String str1 = (String)((Iterator)localObject3).next();
            Object localObject4;
            String str2;
            if (((Map)localObject1).containsKey(str1))
            {
              localObject4 = (String)((Map)localObject1).get(str1);
              str2 = c.eZ((String)localObject4, (String)localObject2);
              if (!str2.equalsIgnoreCase((String)localObject4)) {
                ((Map)localObject1).put(str1, str2);
              }
            }
            else
            {
              aw.aaz();
              localObject4 = com.tencent.mm.model.c.YA().arw(str1);
              if (localObject4 != null)
              {
                localObject4 = ((aq)localObject4).field_contactLabelIds;
                str2 = c.eZ((String)localObject4, (String)localObject2);
                if (!str2.equalsIgnoreCase((String)localObject4)) {
                  ((Map)localObject1).put(str1, str2);
                }
              }
            }
          }
        }
      }
    }
    paramList1 = ((Map)localObject1).entrySet().iterator();
    while (paramList1.hasNext())
    {
      localObject1 = (Map.Entry)paramList1.next();
      paramList2 = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (String)((Map.Entry)localObject1).getValue();
      localObject2 = new cpk();
      ((cpk)localObject2).jJA = paramList2;
      ((cpk)localObject2).wOV = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (localLinkedList.size() > 0)
    {
      paramList1 = new d(localLinkedList);
      aw.Rc().a(paramList1, 0);
    }
    AppMethodBeat.o(22502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b
 * JD-Core Version:    0.7.0.1
 */