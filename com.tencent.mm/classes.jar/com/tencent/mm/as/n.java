package com.tencent.mm.as;

import android.graphics.Bitmap;
import com.tencent.mm.a.b;
import com.tencent.mm.a.f;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.g.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class n
{
  private static n epB;
  public c epA = new c();
  public ConcurrentHashMap<Long, n.e> epC = new ConcurrentHashMap();
  private ArrayList<Long> epD = new ArrayList();
  ArrayList<n.e> epE = new ArrayList();
  ConcurrentHashMap<Long, n.d> epz = new ConcurrentHashMap();
  
  public static n OA()
  {
    if (epB == null) {}
    try
    {
      if (epB == null) {
        epB = new n();
      }
      return epB;
    }
    finally {}
  }
  
  private boolean OB()
  {
    if ((this.epE.size() > 0) && (g.a.bwY().nFM <= 2))
    {
      y.i("MicroMsg.SendImgSpeeder", "cpu core is low ,do not use multi mode");
      return false;
    }
    return true;
  }
  
  private static int h(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (q.g(paramString1, paramString2, paramBoolean)) {
      return 1;
    }
    return 0;
  }
  
  private boolean mi(String paramString)
  {
    Iterator localIterator = this.epE.iterator();
    while (localIterator.hasNext()) {
      if (((n.e)localIterator.next()).epQ.equals(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean, int paramInt3)
  {
    if (mi(paramString1)) {
      return;
    }
    int i = h(paramString1, paramString2, paramBoolean);
    PString localPString = new PString();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    Object localObject2;
    Object localObject1;
    b localb2;
    b localb1;
    if (OB())
    {
      localObject2 = this.epA.iO(1);
      localObject1 = this.epA.iO(2);
      localb2 = ((n.b)localObject2).epM;
      localb1 = ((n.b)localObject1).epM;
      localObject1 = ((n.b)localObject1).epN;
    }
    for (String str1 = ((n.b)localObject2).epN;; str1 = null)
    {
      g localg = o.OJ();
      if (!com.tencent.mm.vfs.e.bK(paramString1))
      {
        y.e("MicroMsg.ImgInfoStorage", "file not exit:%s", new Object[] { paramString1 });
        localObject2 = new n.e();
        ((n.e)localObject2).epQ = paramString1;
        ((n.e)localObject2).ent = i;
        ((n.e)localObject2).source = paramInt1;
        ((n.e)localObject2).bQN = paramInt2;
        ((n.e)localObject2).epR = ((String)localObject1);
        ((n.e)localObject2).epU = localPString;
        ((n.e)localObject2).epW = localPInt2;
        ((n.e)localObject2).epV = localPInt1;
        ((n.e)localObject2).epS = str1;
        ((n.e)localObject2).epY = localb1;
        ((n.e)localObject2).epX = localb2;
        if (epB.OB()) {
          n.a.a((n.e)localObject2);
        }
        ((n.e)localObject2).toUserName = paramString2;
        this.epE.add(localObject2);
        y.i("MicroMsg.SendImgSpeeder", "summersafecdn img path %s has prebuild, user:%s", new Object[] { paramString1, paramString2 });
        return;
      }
      if (bk.bl((String)localObject1)) {}
      for (localObject2 = g.Ou();; localObject2 = localObject1)
      {
        localObject2 = "THUMBNAIL_DIRPATH://th_" + (String)localObject2;
        String str2 = localg.b((String)localObject2, "th_", "", false);
        localPString.value = ((String)localObject2);
        long l = bk.UZ();
        Bitmap localBitmap = localg.a(paramString1, i, paramInt2, localPInt1, localPInt2, false, null, null);
        localObject2 = (String)localg.enX.get(paramString1);
        if (localObject2 != null) {}
        for (localObject2 = (Bitmap)localg.enW.get(localObject2);; localObject2 = null)
        {
          Object localObject3;
          if (localObject2 != null)
          {
            localObject3 = localObject2;
            if (!((Bitmap)localObject2).isRecycled()) {}
          }
          else
          {
            localObject3 = localg.a(paramString1, true, com.tencent.mm.cb.a.getDensity(ae.getContext()), false, false, true, paramInt3, true, localBitmap);
            localg.enX.put(paramString1, str2);
          }
          if (localObject3 != null) {
            localg.enW.f(str2, localObject3);
          }
          y.i("MicroMsg.ImgInfoStorage", "test decode thumb img:%d", new Object[] { Long.valueOf(bk.cp(l)) });
          break;
        }
      }
      localb1 = null;
      localb2 = null;
      localObject1 = null;
    }
  }
  
  public final void a(ArrayList<String> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    y.i("MicroMsg.SendImgSpeeder", "summersafecdn sendThumbImg fileSize:%d, compressImg[%b], source[%d], user:%s", new Object[] { Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), paramString });
    Object localObject1 = this.epE.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (n.e)((Iterator)localObject1).next();
      if ((!paramArrayList.contains(((n.e)localObject2).epQ)) || ((!bk.bl(((n.e)localObject2).toUserName)) && (!((n.e)localObject2).toUserName.equalsIgnoreCase(paramString))) || ((!bk.bl(paramString)) && (!paramString.equalsIgnoreCase(((n.e)localObject2).toUserName)))) {
        ((Iterator)localObject1).remove();
      } else {
        ((n.e)localObject2).ent = h(((n.e)localObject2).epQ, paramString, paramBoolean);
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    String str;
    while (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      Iterator localIterator = this.epE.iterator();
      while (localIterator.hasNext())
      {
        n.e locale = (n.e)localIterator.next();
        if (locale.epQ.equals(str)) {
          ((ArrayList)localObject1).add(locale);
        }
      }
    }
    this.epE.clear();
    this.epE.addAll((Collection)localObject1);
    localObject1 = new ArrayList();
    if (paramArrayList.size() == 9)
    {
      com.tencent.mm.plugin.report.service.g.wI(18);
      paramArrayList = paramArrayList.iterator();
    }
    for (;;)
    {
      if (!paramArrayList.hasNext()) {
        break label475;
      }
      localObject2 = (String)paramArrayList.next();
      if ((localObject2 == null) || (((String)localObject2).equals("")) || (!com.tencent.mm.vfs.e.bK((String)localObject2)))
      {
        y.d("MicroMsg.SendImgSpeeder", " doSendImage : filePath is null or empty");
        continue;
        if (paramArrayList.size() == 1)
        {
          boolean bool = aq.isWifi(ae.getContext());
          com.tencent.mm.plugin.report.service.g.wI(25);
          if (!bool) {
            break;
          }
          if (q.g((String)paramArrayList.get(0), paramString, paramBoolean))
          {
            com.tencent.mm.plugin.report.service.g.wI(23);
            break;
          }
          com.tencent.mm.plugin.report.service.g.wI(21);
          break;
        }
        com.tencent.mm.plugin.report.service.g.wI(24);
        break;
      }
      if (com.tencent.mm.sdk.platformtools.o.Za((String)localObject2)) {
        y.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add filePath:%s filesize:%d", new Object[] { localObject2, Long.valueOf(com.tencent.mm.vfs.e.aeQ((String)localObject2)) });
      } else if (!mi((String)localObject2)) {
        ((ArrayList)localObject1).add(localObject2);
      }
    }
    label475:
    paramArrayList = ((ArrayList)localObject1).iterator();
    while (paramArrayList.hasNext()) {
      a(paramInt1, paramInt2, (String)paramArrayList.next(), paramString, paramBoolean, paramInt3);
    }
    paramArrayList = new ArrayList();
    long l1 = com.tencent.mm.kernel.g.DP().dKu.eV(Thread.currentThread().getId());
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().Hv("SendImgSpeeder");
    paramInt1 = 1;
    paramInt2 = 0;
    while (paramInt2 < this.epE.size())
    {
      localObject1 = (n.e)this.epE.get(paramInt2);
      if (com.tencent.mm.sdk.platformtools.o.Za(((n.e)localObject1).epQ))
      {
        y.i("MicroMsg.SendImgSpeeder", "[cpan] is gif coutinue. did not add to msg table");
        paramInt2 += 1;
      }
      else
      {
        localObject2 = new bi();
        ((bi)localObject2).setType(s.hX(paramString));
        ((bi)localObject2).ec(paramString);
        ((bi)localObject2).fA(1);
        ((bi)localObject2).setStatus(1);
        ((bi)localObject2).ed(((n.e)localObject1).epU.value);
        ((bi)localObject2).fK(((n.e)localObject1).epV.value);
        ((bi)localObject2).fL(((n.e)localObject1).epW.value);
        str = bf.HR();
        if (((str != null) && (!str.equals(((cs)localObject2).czr))) || ((str == null) && (((cs)localObject2).czr != null))) {
          ((bi)localObject2).cY(str);
        }
        a.a.yf().c((bi)localObject2);
        ((bi)localObject2).bg(bd.iK(((cs)localObject2).field_talker));
        paramArrayList.add(localObject2);
        long l2 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().T((bi)localObject2);
        if (l2 >= 0L) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          Assert.assertTrue(paramBoolean);
          ((n.e)localObject1).bIt = l2;
          this.epC.put(Long.valueOf(((n.e)localObject1).bIt), localObject1);
          this.epD.add(Long.valueOf(((n.e)localObject1).bIt));
          paramInt1 = 0;
          break;
        }
      }
    }
    this.epE.clear();
    if (l1 > 0L) {
      com.tencent.mm.kernel.g.DP().dKu.hI(l1);
    }
    if (paramInt1 != 0) {
      ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().Hw("SendImgSpeeder");
    }
  }
  
  public final boolean ca(long paramLong)
  {
    return this.epz.containsKey(Long.valueOf(paramLong));
  }
  
  public final n.d cb(long paramLong)
  {
    return (n.d)this.epz.get(Long.valueOf(paramLong));
  }
  
  public final ArrayList<String> mg(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (!bk.bl(paramString))
    {
      Iterator localIterator = this.epC.values().iterator();
      while (localIterator.hasNext())
      {
        n.e locale = (n.e)localIterator.next();
        if (paramString.equals(locale.toUserName)) {
          localArrayList.add(locale.epQ);
        }
      }
    }
    return localArrayList;
  }
  
  public final ArrayList<Integer> mh(String paramString)
  {
    Object localObject1 = this.epC.values();
    Object localObject2 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      n.e locale = (n.e)((Iterator)localObject2).next();
      PString localPString = new PString();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      locale.epT = o.OJ().a(locale.epQ, locale.ent, locale.source, locale.bQN, localPString, localPInt1, localPInt2, locale.epR, locale.epS, locale.bIt, locale.epX, locale.epY, locale.epZ);
      bi localbi = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(locale.bIt);
      if (bk.bl(localbi.field_imgPath))
      {
        localbi.ed(localPString.value);
        localbi.fK(localPInt1.value);
        localbi.fL(localPInt2.value);
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(locale.bIt, localbi);
      }
    }
    if (!bk.bl(paramString))
    {
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (n.e)((Iterator)localObject1).next();
        if (!paramString.equals(((n.e)localObject2).toUserName))
        {
          this.epC.remove(Long.valueOf(((n.e)localObject2).bIt));
          this.epD.remove(Long.valueOf(((n.e)localObject2).bIt));
          y.e("MicroMsg.SendImgSpeeder", "fatal!! Send user mis-match, want:%s, fact:%s", new Object[] { paramString, ((n.e)localObject2).toUserName });
        }
      }
    }
    paramString = new ArrayList();
    int i = 0;
    while (i < this.epD.size())
    {
      paramString.add(Integer.valueOf((int)((n.e)this.epC.get(this.epD.get(i))).epT));
      i += 1;
    }
    this.epC.clear();
    this.epD.clear();
    y.i("MicroMsg.SendImgSpeeder", "syncImgData, id size %d", new Object[] { Integer.valueOf(paramString.size()) });
    return paramString;
  }
  
  public static final class c
  {
    public LinkedList<n.b> epO = new LinkedList();
    public LinkedList<n.b> epP = new LinkedList();
    
    private void OE()
    {
      for (;;)
      {
        int i;
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.epO.size())
          {
            localStringBuilder.append(((n.b)this.epO.get(i)).epN);
            if (i != this.epO.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            y.d("MicroMsg.SendImgSpeeder", "sync big des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.g.DP().Dz().o(348176, localStringBuilder.toString());
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    private void OF()
    {
      for (;;)
      {
        int i;
        try
        {
          StringBuilder localStringBuilder = new StringBuilder();
          i = 0;
          if (i < this.epP.size())
          {
            localStringBuilder.append(((n.b)this.epP.get(i)).epN);
            if (i != this.epP.size() - 1) {
              localStringBuilder.append("-");
            }
          }
          else
          {
            y.d("MicroMsg.SendImgSpeeder", "sync thumb des to file %s ", new Object[] { localStringBuilder.toString() });
            com.tencent.mm.kernel.g.DP().Dz().o(348177, localStringBuilder.toString());
            return;
          }
        }
        finally {}
        i += 1;
      }
    }
    
    public static n.b mj(String paramString)
    {
      n.b localb = new n.b((byte)0);
      if (bk.bl(paramString)) {}
      for (localb.epN = g.Ou();; localb.epN = paramString)
      {
        paramString = o.OJ().b(localb.epN, "", ".jpg", false);
        if (ml(paramString)) {
          break;
        }
        return null;
      }
      localb.epM = new b(paramString);
      return localb;
    }
    
    public static n.b mk(String paramString)
    {
      n.b localb = new n.b((byte)0);
      if (bk.bl(paramString)) {}
      for (localb.epN = g.Ou();; localb.epN = paramString)
      {
        paramString = o.OJ();
        String str = localb.epN;
        paramString = paramString.b("THUMBNAIL_DIRPATH://th_" + str, "th_", "", false);
        if (ml(paramString)) {
          break;
        }
        return null;
      }
      localb.epM = new b(paramString);
      return localb;
    }
    
    private static boolean ml(String paramString)
    {
      if (com.tencent.mm.vfs.e.aeQ(paramString) > 0L)
      {
        y.e("MicroMsg.SendImgSpeeder", "file has exist %s", new Object[] { paramString });
        return false;
      }
      return true;
    }
    
    public final void OD()
    {
      int j = 0;
      try
      {
        int i = this.epO.size();
        int k;
        n.b localb;
        if (i <= 0)
        {
          k = 5 - i;
          i = 0;
          while (i < k)
          {
            localb = mj(null);
            this.epO.add(localb);
            i += 1;
          }
          y.i("MicroMsg.SendImgSpeeder", "add big File pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.epO.size()) });
          OE();
        }
        i = this.epP.size();
        if (i <= 0)
        {
          k = 5 - i;
          i = j;
          while (i < k)
          {
            localb = mk(null);
            this.epP.add(localb);
            i += 1;
          }
          OF();
          y.i("MicroMsg.SendImgSpeeder", "add big thumb pool added size %d , all size %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.epP.size()) });
        }
        return;
      }
      finally {}
    }
    
    public final n.b iO(int paramInt)
    {
      n.b localb1 = null;
      if (paramInt == 1) {}
      for (;;)
      {
        try
        {
          if (this.epO.size() > 0)
          {
            localb1 = (n.b)this.epO.remove();
            OE();
            OD();
            return localb1;
          }
          localb1 = mj(null);
          continue;
          if (paramInt == 2) {
            if (this.epP.size() > 0)
            {
              localb1 = (n.b)this.epP.remove();
              OF();
            }
            else
            {
              n.b localb2 = mk(null);
            }
          }
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.as.n
 * JD-Core Version:    0.7.0.1
 */