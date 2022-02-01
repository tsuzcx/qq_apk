package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.bp;
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
  ArrayList<String> uVV;
  ArrayList<String> uVW;
  private f uVX;
  String username;
  
  public b()
  {
    AppMethodBeat.i(26112);
    this.uVX = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(26111);
        ad.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
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
            b.h(b.this.username, b.this.uVV);
            AppMethodBeat.o(26111);
            return;
          }
          b.this.dfk();
          ad.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
          AppMethodBeat.o(26111);
          return;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
          if ((b.this.uVW == null) || (b.this.uVW.isEmpty())) {
            break label281;
          }
        }
        label281:
        for (paramAnonymousInt1 = b.this.uVW.size();; paramAnonymousInt1 = 0)
        {
          if ((b.this.uVV != null) && (!b.this.uVV.isEmpty())) {}
          for (paramAnonymousInt2 = b.this.uVV.size() - paramAnonymousInt1;; paramAnonymousInt2 = 0)
          {
            if ((paramAnonymousInt1 > 0) || (paramAnonymousInt2 > 0))
            {
              ad.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              g.yhR.f(11220, new Object[] { u.aAm(), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), Integer.valueOf(0) });
            }
            b.this.dfk();
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
      ad.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact] username:%s,list:%s", new Object[] { paramString, localObject1 });
      if ((!bt.isNullOrNil(paramString)) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
        break;
      }
      ad.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
      AppMethodBeat.o(26123);
      return;
    }
    Object localObject2 = "";
    localObject1 = localObject2;
    if (paramArrayList != null)
    {
      localObject1 = localObject2;
      if (paramArrayList.size() > 0) {
        localObject1 = c.el(e.dfn().aP(paramArrayList));
      }
    }
    paramArrayList = new LinkedList();
    localObject2 = new dtz();
    ((dtz)localObject2).Gca = ((String)localObject1);
    ((dtz)localObject2).nDo = paramString;
    paramArrayList.add(localObject2);
    paramString = new d(paramArrayList);
    ba.aiU().a(paramString, 0);
    AppMethodBeat.o(26123);
  }
  
  public final void a(k.a parama)
  {
    AppMethodBeat.i(26116);
    e.dfn().add(parama);
    AppMethodBeat.o(26116);
  }
  
  public final String aol(String paramString)
  {
    AppMethodBeat.i(26114);
    paramString = e.dfn().aol(paramString);
    AppMethodBeat.o(26114);
    return paramString;
  }
  
  public final String aom(String paramString)
  {
    AppMethodBeat.i(26115);
    paramString = e.dfn().aom(paramString);
    AppMethodBeat.o(26115);
    return paramString;
  }
  
  public final List<String> aon(String paramString)
  {
    AppMethodBeat.i(26119);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
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
  
  public final void aox()
  {
    AppMethodBeat.i(26113);
    e.dfn().aox();
    AppMethodBeat.o(26113);
  }
  
  public final void b(k.a parama)
  {
    AppMethodBeat.i(26117);
    e.dfn().remove(parama);
    AppMethodBeat.o(26117);
  }
  
  public final List<String> dfj()
  {
    AppMethodBeat.i(26118);
    ar localar = e.dfn();
    long l = bt.flT();
    ArrayList localArrayList1 = localar.fqp();
    if (localArrayList1 == null)
    {
      AppMethodBeat.o(26118);
      return null;
    }
    localar.fqq();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      ArrayList localArrayList3 = (ArrayList)localar.IJY.get(Integer.valueOf(((ao)localArrayList1.get(i)).field_labelID));
      if ((localArrayList3 != null) && (localArrayList3.size() > 0)) {
        localArrayList2.add(((ao)localArrayList1.get(i)).field_labelName);
      }
      i += 1;
    }
    ad.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[] { Long.valueOf(bt.Df(l)), Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()), bt.flS() });
    AppMethodBeat.o(26118);
    return localArrayList2;
  }
  
  final void dfk()
  {
    AppMethodBeat.i(26122);
    this.username = null;
    this.uVV = null;
    this.uVW = null;
    ba.aiU().b(635, this.uVX);
    ba.aiU().b(638, this.uVX);
    AppMethodBeat.o(26122);
  }
  
  public final String ej(List<String> paramList)
  {
    AppMethodBeat.i(26120);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ad.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
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
  
  public final void ek(List<String> paramList)
  {
    AppMethodBeat.i(26124);
    paramList = new a(paramList);
    ba.aiU().a(paramList, 0);
    AppMethodBeat.o(26124);
  }
  
  public final void hC(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(26121);
      ad.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", new Object[] { String.valueOf(paramString1), String.valueOf(paramString2) });
      if (bt.isNullOrNil(paramString2))
      {
        ad.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
        AppMethodBeat.o(26121);
      }
      for (;;)
      {
        return;
        paramString2 = (ArrayList)aon(paramString2);
        if ((paramString2 != null) && (!paramString2.isEmpty())) {
          break;
        }
        ad.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
        AppMethodBeat.o(26121);
      }
      this.username = paramString1;
    }
    finally {}
    this.uVV = paramString2;
    int j = paramString2.size();
    this.uVW = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        ao localao = e.dfn().aTb((String)paramString2.get(i));
        if ((localao != null) && (localao.field_isTemporary)) {
          this.uVW.add(paramString2.get(i));
        }
      }
      else
      {
        ba.aiU().a(635, this.uVX);
        ba.aiU().a(638, this.uVX);
        if ((this.uVW == null) || (this.uVW.isEmpty()))
        {
          h(paramString1, paramString2);
          dfk();
          AppMethodBeat.o(26121);
          break;
        }
        ad.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[] { this.uVW.toString() });
        paramString1 = new a(this.uVW);
        ba.aiU().a(paramString1, 0);
        AppMethodBeat.o(26121);
        break;
      }
      i += 1;
    }
  }
  
  public final void n(List<String> paramList1, List<String> paramList2)
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
        Object localObject3 = bt.U(((String)paramList2.next()).split(","));
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
              str2 = c.hD((String)localObject4, (String)localObject2);
              if (!str2.equalsIgnoreCase((String)localObject4)) {
                ((Map)localObject1).put(str1, str2);
              }
            }
            else
            {
              ba.aBQ();
              localObject4 = com.tencent.mm.model.c.azp().Bf(str1);
              if (localObject4 != null)
              {
                localObject4 = ((aw)localObject4).field_contactLabelIds;
                str2 = c.hD((String)localObject4, (String)localObject2);
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
      localObject2 = new dtz();
      ((dtz)localObject2).nDo = paramList2;
      ((dtz)localObject2).Gca = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (localLinkedList.size() > 0)
    {
      paramList1 = new d(localLinkedList);
      ba.aiU().a(paramList1, 0);
    }
    AppMethodBeat.o(26125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b
 * JD-Core Version:    0.7.0.1
 */