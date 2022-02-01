package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.b.e;
import com.tencent.mm.protocal.protobuf.fve;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bx;
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
  ArrayList<String> JTX;
  ArrayList<String> JTY;
  private com.tencent.mm.am.h JTZ;
  String username;
  
  public b()
  {
    AppMethodBeat.i(26112);
    this.JTZ = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(26111);
        Log.e("MicroMsg.Label.ContactLabelManagerImpl", "onSceneEnd");
        switch (paramAnonymousp.getType())
        {
        case 636: 
        case 637: 
        default: 
          AppMethodBeat.o(26111);
          return;
        case 635: 
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            b.m(b.this.username, b.this.JTX);
            AppMethodBeat.o(26111);
            return;
          }
          b.this.fSX();
          Log.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact lable faild");
          AppMethodBeat.o(26111);
          return;
        }
        if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0)) {
          if ((b.this.JTY == null) || (b.this.JTY.isEmpty())) {
            break label281;
          }
        }
        label281:
        for (paramAnonymousInt1 = b.this.JTY.size();; paramAnonymousInt1 = 0)
        {
          if ((b.this.JTX != null) && (!b.this.JTX.isEmpty())) {}
          for (paramAnonymousInt2 = b.this.JTX.size() - paramAnonymousInt1;; paramAnonymousInt2 = 0)
          {
            if ((paramAnonymousInt1 > 0) || (paramAnonymousInt2 > 0))
            {
              Log.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
              com.tencent.mm.plugin.report.service.h.OAn.b(11220, new Object[] { z.bAM(), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(0), Integer.valueOf(0) });
            }
            b.this.fSX();
            break;
          }
        }
      }
    };
    AppMethodBeat.o(26112);
  }
  
  static void m(String paramString, ArrayList<String> paramArrayList)
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
        localObject1 = c.iF(d.fTa().bY(paramArrayList));
      }
    }
    paramArrayList = new LinkedList();
    localObject2 = new fve();
    ((fve)localObject2).ZqN = ((String)localObject1);
    ((fve)localObject2).UserName = paramString;
    paramArrayList.add(localObject2);
    paramString = new e(paramArrayList);
    bh.aZW().a(paramString, 0);
    AppMethodBeat.o(26123);
  }
  
  public final void G(List<String> paramList1, List<String> paramList2)
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
              str2 = c.jQ((String)localObject4, (String)localObject2);
              if (!str2.equalsIgnoreCase((String)localObject4)) {
                ((Map)localObject1).put(str1, str2);
              }
            }
            else
            {
              bh.bCz();
              localObject4 = com.tencent.mm.model.c.bzA().JE(str1);
              if (localObject4 != null)
              {
                localObject4 = ((com.tencent.mm.autogen.b.az)localObject4).field_contactLabelIds;
                str2 = c.jQ((String)localObject4, (String)localObject2);
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
      localObject2 = new fve();
      ((fve)localObject2).UserName = paramList2;
      ((fve)localObject2).ZqN = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (localLinkedList.size() > 0)
    {
      paramList1 = new e(localLinkedList);
      bh.aZW().a(paramList1, 0);
    }
    AppMethodBeat.o(26125);
  }
  
  public final void a(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(26116);
    d.fTa().add(paramIOnStorageChange);
    AppMethodBeat.o(26116);
  }
  
  public final String aJG(String paramString)
  {
    AppMethodBeat.i(26114);
    paramString = d.fTa().aJG(paramString);
    AppMethodBeat.o(26114);
    return paramString;
  }
  
  public final String aJH(String paramString)
  {
    AppMethodBeat.i(26115);
    paramString = d.fTa().aJH(paramString);
    AppMethodBeat.o(26115);
    return paramString;
  }
  
  public final List<String> aJI(String paramString)
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
  
  public final void b(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(26117);
    d.fTa().remove(paramIOnStorageChange);
    AppMethodBeat.o(26117);
  }
  
  public final void bja()
  {
    AppMethodBeat.i(26113);
    d.fTa().bja();
    AppMethodBeat.o(26113);
  }
  
  public final List<String> fSW()
  {
    AppMethodBeat.i(26118);
    com.tencent.mm.storage.az localaz = d.fTa();
    long l = Util.nowMilliSecond();
    ArrayList localArrayList1 = localaz.iZO();
    ArrayList localArrayList2 = new ArrayList();
    if (localArrayList1 == null)
    {
      AppMethodBeat.o(26118);
      return localArrayList2;
    }
    localaz.iZQ();
    if (localaz.adig == null)
    {
      AppMethodBeat.o(26118);
      return localArrayList2;
    }
    int i = 0;
    while (i < localArrayList1.size())
    {
      ArrayList localArrayList3 = (ArrayList)localaz.adig.get(Integer.valueOf(((aw)localArrayList1.get(i)).field_labelID));
      if ((localArrayList3 != null) && (localArrayList3.size() > 0)) {
        localArrayList2.add(((aw)localArrayList1.get(i)).field_labelName);
      }
      i += 1;
    }
    Log.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[] { Long.valueOf(Util.milliSecondsToNow(l)), Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()), Util.getStack() });
    AppMethodBeat.o(26118);
    return localArrayList2;
  }
  
  final void fSX()
  {
    AppMethodBeat.i(26122);
    this.username = null;
    this.JTX = null;
    this.JTY = null;
    bh.aZW().b(635, this.JTZ);
    bh.aZW().b(638, this.JTZ);
    AppMethodBeat.o(26122);
  }
  
  public final String iD(List<String> paramList)
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
  
  public final void iE(List<String> paramList)
  {
    AppMethodBeat.i(26124);
    paramList = new a(paramList);
    bh.aZW().a(paramList, 0);
    AppMethodBeat.o(26124);
  }
  
  public final void jP(String paramString1, String paramString2)
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
        paramString2 = (ArrayList)aJI(paramString2);
        if ((paramString2 != null) && (!paramString2.isEmpty())) {
          break;
        }
        Log.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
        AppMethodBeat.o(26121);
      }
      this.username = paramString1;
    }
    finally {}
    this.JTX = paramString2;
    int j = paramString2.size();
    this.JTY = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        aw localaw = d.fTa().bxl((String)paramString2.get(i));
        if ((localaw != null) && (localaw.field_isTemporary)) {
          this.JTY.add((String)paramString2.get(i));
        }
      }
      else
      {
        bh.aZW().a(635, this.JTZ);
        bh.aZW().a(638, this.JTZ);
        if ((this.JTY == null) || (this.JTY.isEmpty()))
        {
          m(paramString1, paramString2);
          fSX();
          AppMethodBeat.o(26121);
          break;
        }
        Log.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[] { this.JTY.toString() });
        paramString1 = new a(this.JTY);
        bh.aZW().a(paramString1, 0);
        AppMethodBeat.o(26121);
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b
 * JD-Core Version:    0.7.0.1
 */