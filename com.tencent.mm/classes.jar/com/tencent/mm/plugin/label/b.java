package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.doi;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bj;
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
  ArrayList<String> tTt;
  ArrayList<String> tTu;
  private g tTv;
  String username;
  
  public b()
  {
    AppMethodBeat.i(26112);
    this.tTv = new g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(26111);
        ac.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
        switch (paramAnonymousn.getType())
        {
        case 636: 
        case 637: 
        default: 
          AppMethodBeat.o(26111);
          return;
        case 635: 
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            b.h(b.this.username, b.this.tTt);
            AppMethodBeat.o(26111);
            return;
          }
          b.this.cVZ();
          ac.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
          AppMethodBeat.o(26111);
          return;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
          if ((b.this.tTu == null) || (b.this.tTu.isEmpty())) {
            break label281;
          }
        }
        label281:
        for (paramAnonymousInt1 = b.this.tTu.size();; paramAnonymousInt1 = 0)
        {
          if ((b.this.tTt != null) && (!b.this.tTt.isEmpty())) {}
          for (paramAnonymousInt2 = b.this.tTt.size() - paramAnonymousInt1;; paramAnonymousInt2 = 0)
          {
            if ((paramAnonymousInt1 > 0) || (paramAnonymousInt2 > 0))
            {
              ac.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              h.wUl.f(11220, new Object[] { u.axw(), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), Integer.valueOf(0) });
            }
            b.this.cVZ();
            break;
          }
        }
      }
    };
    AppMethodBeat.o(26112);
  }
  
  static void h(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(26123);
    if (paramArrayList == null) {}
    for (Object localObject1 = "";; localObject1 = paramArrayList.toString())
    {
      ac.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact] username:%s,list:%s", new Object[] { paramString, localObject1 });
      if ((!bs.isNullOrNil(paramString)) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
        break;
      }
      ac.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
      AppMethodBeat.o(26123);
      return;
    }
    Object localObject2 = "";
    localObject1 = localObject2;
    if (paramArrayList != null)
    {
      localObject1 = localObject2;
      if (paramArrayList.size() > 0) {
        localObject1 = c.dY(e.cWc().aS(paramArrayList));
      }
    }
    paramArrayList = new LinkedList();
    localObject2 = new doi();
    ((doi)localObject2).EuG = ((String)localObject1);
    ((doi)localObject2).ncR = paramString;
    paramArrayList.add(localObject2);
    paramString = new d(paramArrayList);
    az.agi().a(paramString, 0);
    AppMethodBeat.o(26123);
  }
  
  public final void a(k.a parama)
  {
    AppMethodBeat.i(26116);
    e.cWc().add(parama);
    AppMethodBeat.o(26116);
  }
  
  public final String ajA(String paramString)
  {
    AppMethodBeat.i(26115);
    paramString = e.cWc().ajA(paramString);
    AppMethodBeat.o(26115);
    return paramString;
  }
  
  public final List<String> ajB(String paramString)
  {
    AppMethodBeat.i(26119);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
      AppMethodBeat.o(26119);
      return null;
    }
    paramString = paramString.split(",");
    if ((paramString != null) && (paramString.length > 0))
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(Arrays.asList(paramString));
      AppMethodBeat.o(26119);
      return localArrayList;
    }
    AppMethodBeat.o(26119);
    return null;
  }
  
  public final String ajz(String paramString)
  {
    AppMethodBeat.i(26114);
    paramString = e.cWc().ajz(paramString);
    AppMethodBeat.o(26114);
    return paramString;
  }
  
  public final void alK()
  {
    AppMethodBeat.i(26113);
    e.cWc().alK();
    AppMethodBeat.o(26113);
  }
  
  public final void b(k.a parama)
  {
    AppMethodBeat.i(26117);
    e.cWc().remove(parama);
    AppMethodBeat.o(26117);
  }
  
  public final List<String> cVY()
  {
    AppMethodBeat.i(26118);
    an localan = e.cWc();
    long l = bs.eWj();
    ArrayList localArrayList1 = localan.fam();
    if (localArrayList1 == null)
    {
      AppMethodBeat.o(26118);
      return null;
    }
    localan.fan();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      ArrayList localArrayList3 = (ArrayList)localan.GWL.get(Integer.valueOf(((ak)localArrayList1.get(i)).field_labelID));
      if ((localArrayList3 != null) && (localArrayList3.size() > 0)) {
        localArrayList2.add(((ak)localArrayList1.get(i)).field_labelName);
      }
      i += 1;
    }
    ac.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[] { Long.valueOf(bs.Ap(l)), Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()), bs.eWi() });
    AppMethodBeat.o(26118);
    return localArrayList2;
  }
  
  final void cVZ()
  {
    AppMethodBeat.i(26122);
    this.username = null;
    this.tTt = null;
    this.tTu = null;
    az.agi().b(635, this.tTv);
    az.agi().b(638, this.tTv);
    AppMethodBeat.o(26122);
  }
  
  public final String dW(List<String> paramList)
  {
    AppMethodBeat.i(26120);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ac.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
      AppMethodBeat.o(26120);
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
    AppMethodBeat.o(26120);
    return paramList;
  }
  
  public final void dX(List<String> paramList)
  {
    AppMethodBeat.i(26124);
    paramList = new a(paramList);
    az.agi().a(paramList, 0);
    AppMethodBeat.o(26124);
  }
  
  public final void hq(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(26121);
      ac.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", new Object[] { String.valueOf(paramString1), String.valueOf(paramString2) });
      if (bs.isNullOrNil(paramString2))
      {
        ac.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
        AppMethodBeat.o(26121);
      }
      for (;;)
      {
        return;
        paramString2 = (ArrayList)ajB(paramString2);
        if ((paramString2 != null) && (!paramString2.isEmpty())) {
          break;
        }
        ac.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
        AppMethodBeat.o(26121);
      }
      this.username = paramString1;
    }
    finally {}
    this.tTt = paramString2;
    int j = paramString2.size();
    this.tTu = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        ak localak = e.cWc().aNj((String)paramString2.get(i));
        if ((localak != null) && (localak.field_isTemporary)) {
          this.tTu.add(paramString2.get(i));
        }
      }
      else
      {
        az.agi().a(635, this.tTv);
        az.agi().a(638, this.tTv);
        if ((this.tTu == null) || (this.tTu.isEmpty()))
        {
          h(paramString1, paramString2);
          cVZ();
          AppMethodBeat.o(26121);
          break;
        }
        ac.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[] { this.tTu.toString() });
        paramString1 = new a(this.tTu);
        az.agi().a(paramString1, 0);
        AppMethodBeat.o(26121);
        break;
      }
      i += 1;
    }
  }
  
  public final void m(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(26125);
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
        Object localObject3 = bs.S(((String)paramList2.next()).split(","));
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
              str2 = c.hr((String)localObject4, (String)localObject2);
              if (!str2.equalsIgnoreCase((String)localObject4)) {
                ((Map)localObject1).put(str1, str2);
              }
            }
            else
            {
              az.ayM();
              localObject4 = com.tencent.mm.model.c.awB().aNt(str1);
              if (localObject4 != null)
              {
                localObject4 = ((av)localObject4).field_contactLabelIds;
                str2 = c.hr((String)localObject4, (String)localObject2);
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
      localObject2 = new doi();
      ((doi)localObject2).ncR = paramList2;
      ((doi)localObject2).EuG = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (localLinkedList.size() > 0)
    {
      paramList1 = new d(localLinkedList);
      az.agi().a(paramList1, 0);
    }
    AppMethodBeat.o(26125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b
 * JD-Core Version:    0.7.0.1
 */