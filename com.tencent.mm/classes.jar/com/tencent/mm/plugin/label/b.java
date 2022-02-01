package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.duw;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bq;
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
  String username;
  ArrayList<String> vhI;
  ArrayList<String> vhJ;
  private f vhK;
  
  public b()
  {
    AppMethodBeat.i(26112);
    this.vhK = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(26111);
        ae.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
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
            b.h(b.this.username, b.this.vhI);
            AppMethodBeat.o(26111);
            return;
          }
          b.this.dic();
          ae.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
          AppMethodBeat.o(26111);
          return;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
          if ((b.this.vhJ == null) || (b.this.vhJ.isEmpty())) {
            break label281;
          }
        }
        label281:
        for (paramAnonymousInt1 = b.this.vhJ.size();; paramAnonymousInt1 = 0)
        {
          if ((b.this.vhI != null) && (!b.this.vhI.isEmpty())) {}
          for (paramAnonymousInt2 = b.this.vhI.size() - paramAnonymousInt1;; paramAnonymousInt2 = 0)
          {
            if ((paramAnonymousInt1 > 0) || (paramAnonymousInt2 > 0))
            {
              ae.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              g.yxI.f(11220, new Object[] { v.aAC(), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), Integer.valueOf(0) });
            }
            b.this.dic();
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
      ae.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact] username:%s,list:%s", new Object[] { paramString, localObject1 });
      if ((!bu.isNullOrNil(paramString)) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
        break;
      }
      ae.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
      AppMethodBeat.o(26123);
      return;
    }
    Object localObject2 = "";
    localObject1 = localObject2;
    if (paramArrayList != null)
    {
      localObject1 = localObject2;
      if (paramArrayList.size() > 0) {
        localObject1 = c.ep(e.dif().aQ(paramArrayList));
      }
    }
    paramArrayList = new LinkedList();
    localObject2 = new duw();
    ((duw)localObject2).GuH = ((String)localObject1);
    ((duw)localObject2).nIJ = paramString;
    paramArrayList.add(localObject2);
    paramString = new d(paramArrayList);
    bc.ajj().a(paramString, 0);
    AppMethodBeat.o(26123);
  }
  
  public final void a(k.a parama)
  {
    AppMethodBeat.i(26116);
    e.dif().add(parama);
    AppMethodBeat.o(26116);
  }
  
  public final void aoM()
  {
    AppMethodBeat.i(26113);
    e.dif().aoM();
    AppMethodBeat.o(26113);
  }
  
  public final String apn(String paramString)
  {
    AppMethodBeat.i(26114);
    paramString = e.dif().apn(paramString);
    AppMethodBeat.o(26114);
    return paramString;
  }
  
  public final String apo(String paramString)
  {
    AppMethodBeat.i(26115);
    paramString = e.dif().apo(paramString);
    AppMethodBeat.o(26115);
    return paramString;
  }
  
  public final List<String> app(String paramString)
  {
    AppMethodBeat.i(26119);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
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
  
  public final void b(k.a parama)
  {
    AppMethodBeat.i(26117);
    e.dif().remove(parama);
    AppMethodBeat.o(26117);
  }
  
  public final List<String> dib()
  {
    AppMethodBeat.i(26118);
    as localas = e.dif();
    long l = bu.fpO();
    ArrayList localArrayList1 = localas.fup();
    if (localArrayList1 == null)
    {
      AppMethodBeat.o(26118);
      return null;
    }
    localas.fuq();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      ArrayList localArrayList3 = (ArrayList)localas.JeF.get(Integer.valueOf(((ap)localArrayList1.get(i)).field_labelID));
      if ((localArrayList3 != null) && (localArrayList3.size() > 0)) {
        localArrayList2.add(((ap)localArrayList1.get(i)).field_labelName);
      }
      i += 1;
    }
    ae.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[] { Long.valueOf(bu.DD(l)), Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()), bu.fpN() });
    AppMethodBeat.o(26118);
    return localArrayList2;
  }
  
  final void dic()
  {
    AppMethodBeat.i(26122);
    this.username = null;
    this.vhI = null;
    this.vhJ = null;
    bc.ajj().b(635, this.vhK);
    bc.ajj().b(638, this.vhK);
    AppMethodBeat.o(26122);
  }
  
  public final String en(List<String> paramList)
  {
    AppMethodBeat.i(26120);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      ae.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
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
  
  public final void eo(List<String> paramList)
  {
    AppMethodBeat.i(26124);
    paramList = new a(paramList);
    bc.ajj().a(paramList, 0);
    AppMethodBeat.o(26124);
  }
  
  public final void hJ(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(26121);
      ae.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", new Object[] { String.valueOf(paramString1), String.valueOf(paramString2) });
      if (bu.isNullOrNil(paramString2))
      {
        ae.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
        AppMethodBeat.o(26121);
      }
      for (;;)
      {
        return;
        paramString2 = (ArrayList)app(paramString2);
        if ((paramString2 != null) && (!paramString2.isEmpty())) {
          break;
        }
        ae.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
        AppMethodBeat.o(26121);
      }
      this.username = paramString1;
    }
    finally {}
    this.vhI = paramString2;
    int j = paramString2.size();
    this.vhJ = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        ap localap = e.dif().aUC((String)paramString2.get(i));
        if ((localap != null) && (localap.field_isTemporary)) {
          this.vhJ.add(paramString2.get(i));
        }
      }
      else
      {
        bc.ajj().a(635, this.vhK);
        bc.ajj().a(638, this.vhK);
        if ((this.vhJ == null) || (this.vhJ.isEmpty()))
        {
          h(paramString1, paramString2);
          dic();
          AppMethodBeat.o(26121);
          break;
        }
        ae.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[] { this.vhJ.toString() });
        paramString1 = new a(this.vhJ);
        bc.ajj().a(paramString1, 0);
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
        Object localObject3 = bu.U(((String)paramList2.next()).split(","));
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
              str2 = c.hK((String)localObject4, (String)localObject2);
              if (!str2.equalsIgnoreCase((String)localObject4)) {
                ((Map)localObject1).put(str1, str2);
              }
            }
            else
            {
              bc.aCg();
              localObject4 = com.tencent.mm.model.c.azF().BH(str1);
              if (localObject4 != null)
              {
                localObject4 = ((aw)localObject4).field_contactLabelIds;
                str2 = c.hK((String)localObject4, (String)localObject2);
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
      localObject2 = new duw();
      ((duw)localObject2).nIJ = paramList2;
      ((duw)localObject2).GuH = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (localLinkedList.size() > 0)
    {
      paramList1 = new d(localLinkedList);
      bc.ajj().a(paramList1, 0);
    }
    AppMethodBeat.o(26125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b
 * JD-Core Version:    0.7.0.1
 */