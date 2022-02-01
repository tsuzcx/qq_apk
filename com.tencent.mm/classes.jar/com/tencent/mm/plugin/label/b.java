package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ezd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bv;
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
  ArrayList<String> Edc;
  ArrayList<String> Edd;
  private i Ede;
  String username;
  
  public b()
  {
    AppMethodBeat.i(26112);
    this.Ede = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(26111);
        Log.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
        switch (paramAnonymousq.getType())
        {
        case 636: 
        case 637: 
        default: 
          AppMethodBeat.o(26111);
          return;
        case 635: 
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            b.l(b.this.username, b.this.Edc);
            AppMethodBeat.o(26111);
            return;
          }
          b.this.eLa();
          Log.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
          AppMethodBeat.o(26111);
          return;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
          if ((b.this.Edd == null) || (b.this.Edd.isEmpty())) {
            break label281;
          }
        }
        label281:
        for (paramAnonymousInt1 = b.this.Edd.size();; paramAnonymousInt1 = 0)
        {
          if ((b.this.Edc != null) && (!b.this.Edc.isEmpty())) {}
          for (paramAnonymousInt2 = b.this.Edc.size() - paramAnonymousInt1;; paramAnonymousInt2 = 0)
          {
            if ((paramAnonymousInt1 > 0) || (paramAnonymousInt2 > 0))
            {
              Log.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              h.IzE.a(11220, new Object[] { z.bcZ(), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), Integer.valueOf(0) });
            }
            b.this.eLa();
            break;
          }
        }
      }
    };
    AppMethodBeat.o(26112);
  }
  
  static void l(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(26123);
    if (paramArrayList == null) {}
    for (Object localObject1 = "";; localObject1 = paramArrayList.toString())
    {
      Log.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact] username:%s,list:%s", new Object[] { paramString, localObject1 });
      if ((!Util.isNullOrNil(paramString)) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
        break;
      }
      Log.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
      AppMethodBeat.o(26123);
      return;
    }
    Object localObject2 = "";
    localObject1 = localObject2;
    if (paramArrayList != null)
    {
      localObject1 = localObject2;
      if (paramArrayList.size() > 0) {
        localObject1 = c.fI(e.eLd().bx(paramArrayList));
      }
    }
    paramArrayList = new LinkedList();
    localObject2 = new ezd();
    ((ezd)localObject2).SrJ = ((String)localObject1);
    ((ezd)localObject2).UserName = paramString;
    paramArrayList.add(localObject2);
    paramString = new d(paramArrayList);
    bh.aGY().a(paramString, 0);
    AppMethodBeat.o(26123);
  }
  
  public final void a(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(26116);
    e.eLd().add(paramIOnStorageChange);
    AppMethodBeat.o(26116);
  }
  
  public final String aMN(String paramString)
  {
    AppMethodBeat.i(26114);
    paramString = e.eLd().aMN(paramString);
    AppMethodBeat.o(26114);
    return paramString;
  }
  
  public final String aMO(String paramString)
  {
    AppMethodBeat.i(26115);
    paramString = e.eLd().aMO(paramString);
    AppMethodBeat.o(26115);
    return paramString;
  }
  
  public final List<String> aMP(String paramString)
  {
    AppMethodBeat.i(26119);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
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
  
  public final void aPn()
  {
    AppMethodBeat.i(26113);
    e.eLd().aPn();
    AppMethodBeat.o(26113);
  }
  
  public final void b(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(26117);
    e.eLd().remove(paramIOnStorageChange);
    AppMethodBeat.o(26117);
  }
  
  public final List<String> eKZ()
  {
    AppMethodBeat.i(26118);
    com.tencent.mm.storage.ax localax = e.eLd();
    long l = Util.nowMilliSecond();
    ArrayList localArrayList1 = localax.hyh();
    if (localArrayList1 == null)
    {
      AppMethodBeat.o(26118);
      return null;
    }
    localax.hyi();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      ArrayList localArrayList3 = (ArrayList)localax.VEt.get(Integer.valueOf(((au)localArrayList1.get(i)).field_labelID));
      if ((localArrayList3 != null) && (localArrayList3.size() > 0)) {
        localArrayList2.add(((au)localArrayList1.get(i)).field_labelName);
      }
      i += 1;
    }
    Log.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()), Util.getStack() });
    AppMethodBeat.o(26118);
    return localArrayList2;
  }
  
  final void eLa()
  {
    AppMethodBeat.i(26122);
    this.username = null;
    this.Edc = null;
    this.Edd = null;
    bh.aGY().b(635, this.Ede);
    bh.aGY().b(638, this.Ede);
    AppMethodBeat.o(26122);
  }
  
  public final String fG(List<String> paramList)
  {
    AppMethodBeat.i(26120);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
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
  
  public final void fH(List<String> paramList)
  {
    AppMethodBeat.i(26124);
    paramList = new a(paramList);
    bh.aGY().a(paramList, 0);
    AppMethodBeat.o(26124);
  }
  
  public final void iF(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(26121);
      Log.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", new Object[] { String.valueOf(paramString1), String.valueOf(paramString2) });
      if (Util.isNullOrNil(paramString2))
      {
        Log.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
        AppMethodBeat.o(26121);
      }
      for (;;)
      {
        return;
        paramString2 = (ArrayList)aMP(paramString2);
        if ((paramString2 != null) && (!paramString2.isEmpty())) {
          break;
        }
        Log.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
        AppMethodBeat.o(26121);
      }
      this.username = paramString1;
    }
    finally {}
    this.Edc = paramString2;
    int j = paramString2.size();
    this.Edd = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        au localau = e.eLd().bvY((String)paramString2.get(i));
        if ((localau != null) && (localau.field_isTemporary)) {
          this.Edd.add(paramString2.get(i));
        }
      }
      else
      {
        bh.aGY().a(635, this.Ede);
        bh.aGY().a(638, this.Ede);
        if ((this.Edd == null) || (this.Edd.isEmpty()))
        {
          l(paramString1, paramString2);
          eLa();
          AppMethodBeat.o(26121);
          break;
        }
        Log.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[] { this.Edd.toString() });
        paramString1 = new a(this.Edd);
        bh.aGY().a(paramString1, 0);
        AppMethodBeat.o(26121);
        break;
      }
      i += 1;
    }
  }
  
  public final void s(List<String> paramList1, List<String> paramList2)
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
        Object localObject3 = Util.stringsToList(((String)paramList2.next()).split(","));
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
              str2 = c.iG((String)localObject4, (String)localObject2);
              if (!str2.equalsIgnoreCase((String)localObject4)) {
                ((Map)localObject1).put(str1, str2);
              }
            }
            else
            {
              bh.beI();
              localObject4 = com.tencent.mm.model.c.bbL().RG(str1);
              if (localObject4 != null)
              {
                localObject4 = ((com.tencent.mm.f.c.ax)localObject4).field_contactLabelIds;
                str2 = c.iG((String)localObject4, (String)localObject2);
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
      localObject2 = new ezd();
      ((ezd)localObject2).UserName = paramList2;
      ((ezd)localObject2).SrJ = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (localLinkedList.size() > 0)
    {
      paramList1 = new d(localLinkedList);
      bh.aGY().a(paramList1, 0);
    }
    AppMethodBeat.o(26125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b
 * JD-Core Version:    0.7.0.1
 */