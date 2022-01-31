package com.tencent.mm.plugin.label;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.label.b.a;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.protocal.c.cce;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  ArrayList<String> lAF;
  ArrayList<String> lAG;
  private f lAH = new b.1(this);
  String username;
  
  static void g(String paramString, ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (Object localObject1 = "";; localObject1 = paramArrayList.toString())
    {
      y.d("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveContact] username:%s,list:%s", new Object[] { paramString, localObject1 });
      if ((!bk.bl(paramString)) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
        break;
      }
      y.e("MicroMsg.Label.ContactLabelManagerImpl", "add contact label faild.");
      return;
    }
    Object localObject2 = "";
    localObject1 = localObject2;
    if (paramArrayList != null)
    {
      localObject1 = localObject2;
      if (paramArrayList.size() > 0) {
        localObject1 = c.bG(e.bdz().ad(paramArrayList));
      }
    }
    paramArrayList = new LinkedList();
    localObject2 = new cce();
    ((cce)localObject2).sQu = ((String)localObject1);
    ((cce)localObject2).hPY = paramString;
    paramArrayList.add(localObject2);
    paramString = new d(paramArrayList);
    au.Dk().a(paramString, 0);
  }
  
  public final String Gk(String paramString)
  {
    return e.bdz().Gk(paramString);
  }
  
  public final String Gl(String paramString)
  {
    return e.bdz().Gl(paramString);
  }
  
  public final List<String> Gm(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.Label.ContactLabelManagerImpl", "labels is null.");
    }
    do
    {
      return null;
      paramString = paramString.split(",");
    } while ((paramString == null) || (paramString.length <= 0));
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(Arrays.asList(paramString));
    return localArrayList;
  }
  
  public final void a(j.a parama)
  {
    e.bdz().c(parama);
  }
  
  public final void b(j.a parama)
  {
    e.bdz().d(parama);
  }
  
  public final String bE(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      y.w("MicroMsg.Label.ContactLabelManagerImpl", "labelList is empty");
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
    return localStringBuilder.toString();
  }
  
  public final void bF(List<String> paramList)
  {
    paramList = new a(paramList);
    au.Dk().a(paramList, 0);
  }
  
  public final void bdu()
  {
    e.bdz().bdu();
  }
  
  public final List<String> bdv()
  {
    ai localai = e.bdz();
    long l = bk.UY();
    ArrayList localArrayList1 = localai.cui();
    if (localArrayList1 == null) {
      return null;
    }
    localai.cuj();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      ArrayList localArrayList3 = (ArrayList)localai.uzV.get(Integer.valueOf(((af)localArrayList1.get(i)).field_labelID));
      if ((localArrayList3 != null) && (localArrayList3.size() > 0)) {
        localArrayList2.add(((af)localArrayList1.get(i)).field_labelName);
      }
      i += 1;
    }
    y.i("MicroMsg.Label.ContactLabelStorage", "getAllLabelHasContact time:%s all:%s hascontact:%s stack:%s", new Object[] { Long.valueOf(bk.co(l)), Integer.valueOf(localArrayList1.size()), Integer.valueOf(localArrayList2.size()), bk.csb() });
    return localArrayList2;
  }
  
  final void bdw()
  {
    this.username = null;
    this.lAF = null;
    this.lAG = null;
    au.Dk().b(635, this.lAH);
    au.Dk().b(638, this.lAH);
  }
  
  public final void dG(String paramString1, String paramString2)
  {
    try
    {
      y.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] user:%s labels:%s", new Object[] { paramString1, paramString2 });
      if (bk.bl(paramString2)) {
        y.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labels is null.");
      }
      for (;;)
      {
        return;
        paramString2 = (ArrayList)Gm(paramString2);
        if ((paramString2 != null) && (!paramString2.isEmpty())) {
          break;
        }
        y.w("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel] labelList is null.");
      }
      this.username = paramString1;
    }
    finally {}
    this.lAF = paramString2;
    int j = paramString2.size();
    this.lAG = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        af localaf = e.bdz().abb((String)paramString2.get(i));
        if ((localaf != null) && (localaf.field_isTemporary)) {
          this.lAG.add(paramString2.get(i));
        }
      }
      else
      {
        au.Dk().a(635, this.lAH);
        au.Dk().a(638, this.lAH);
        if ((this.lAG == null) || (this.lAG.isEmpty()))
        {
          g(paramString1, paramString2);
          bdw();
          break;
        }
        y.i("MicroMsg.Label.ContactLabelManagerImpl", "cpan[saveStrangerLabel]addList:%s", new Object[] { this.lAG.toString() });
        paramString1 = new a(this.lAG);
        au.Dk().a(paramString1, 0);
        break;
      }
      i += 1;
    }
  }
  
  public final void h(List<String> paramList1, List<String> paramList2)
  {
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
        Object localObject3 = bk.G(((String)paramList2.next()).split(","));
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
              str2 = c.dH((String)localObject4, (String)localObject2);
              if (!str2.equalsIgnoreCase((String)localObject4)) {
                ((Map)localObject1).put(str1, str2);
              }
            }
            else
            {
              au.Hx();
              localObject4 = com.tencent.mm.model.c.Fw().abl(str1);
              if (localObject4 != null)
              {
                localObject4 = ((ao)localObject4).field_contactLabelIds;
                str2 = c.dH((String)localObject4, (String)localObject2);
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
      localObject2 = new cce();
      ((cce)localObject2).hPY = paramList2;
      ((cce)localObject2).sQu = ((String)localObject1);
      localLinkedList.add(localObject2);
    }
    if (localLinkedList.size() > 0)
    {
      paramList1 = new d(localLinkedList);
      au.Dk().a(paramList1, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b
 * JD-Core Version:    0.7.0.1
 */