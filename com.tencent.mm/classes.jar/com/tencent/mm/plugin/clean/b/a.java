package com.tencent.mm.plugin.clean.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements Runnable
{
  private static final Long cUc;
  private static final Long nNv;
  private long cacheSize;
  private boolean isStop;
  private HashSet<String> nNA;
  private a nNB;
  LinkedList<String> nNC;
  private long nNw;
  private long nNx;
  private long nNy;
  private HashMap<String, Long> nNz;
  
  static
  {
    AppMethodBeat.i(22768);
    cUc = Long.valueOf(604800000L);
    nNv = Long.valueOf(7776000000L);
    AppMethodBeat.o(22768);
  }
  
  public a(a parama)
  {
    AppMethodBeat.i(191158);
    this.isStop = false;
    this.nNC = new LinkedList();
    this.isStop = false;
    this.nNB = parama;
    this.nNz = new HashMap();
    this.nNA = new HashSet();
    AppMethodBeat.o(191158);
  }
  
  private long RN(String paramString)
  {
    AppMethodBeat.i(22764);
    Object localObject = new com.tencent.mm.vfs.e(paramString);
    if (((com.tencent.mm.vfs.e)localObject).isDirectory())
    {
      String[] arrayOfString = ((com.tencent.mm.vfs.e)localObject).list();
      if (arrayOfString != null)
      {
        l1 = 0L;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          localObject = arrayOfString[i];
          StringBuilder localStringBuilder = new StringBuilder().append(paramString);
          if (paramString.endsWith("/")) {}
          long l2;
          for (;;)
          {
            l2 = RN((String)localObject);
            if (l2 != -1L) {
              break;
            }
            AppMethodBeat.o(22764);
            return -1L;
            localObject = "/".concat(String.valueOf(localObject));
          }
          l1 += l2;
          i += 1;
        }
        AppMethodBeat.o(22764);
        return l1;
      }
    }
    long l1 = ((com.tencent.mm.vfs.e)localObject).length();
    AppMethodBeat.o(22764);
    return l1;
  }
  
  private long RO(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(191159);
    Object localObject = new com.tencent.mm.vfs.e(paramString);
    if (((com.tencent.mm.vfs.e)localObject).isDirectory())
    {
      localObject = ((com.tencent.mm.vfs.e)localObject).list();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          String str = localObject[i];
          l += RO(paramString + "/" + str);
          i += 1;
        }
        AppMethodBeat.o(191159);
        return l;
      }
    }
    else
    {
      this.cacheSize += i.aMN(paramString);
      AppMethodBeat.o(191159);
      return 0L;
    }
    l = i.aMN(paramString);
    AppMethodBeat.o(191159);
    return l;
  }
  
  private int a(List<String> paramList, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(22765);
    String str1 = g.afB().gcV;
    String str2 = g.afB().gcW;
    String str3 = str1 + g.afB().gcX + '/';
    ad.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path root[%s] acc[%s]", new Object[] { bel(), str1, str2 });
    int j = 0;
    int i = 0;
    Object localObject = new com.tencent.mm.vfs.e(str1);
    int k = j;
    if (((com.tencent.mm.vfs.e)localObject).isDirectory())
    {
      String[] arrayOfString = ((com.tencent.mm.vfs.e)localObject).list();
      k = j;
      if (arrayOfString != null)
      {
        int m = arrayOfString.length;
        j = 0;
        k = i;
        if (j < m)
        {
          localObject = arrayOfString[j];
          String str4 = str1 + (String)localObject + "/";
          ad.d("MicroMsg.CleanCalcLogic", "%s sub file path[%s] sub[%s]", new Object[] { bel(), str4, localObject });
          if (new com.tencent.mm.vfs.e(str4).isDirectory()) {
            if (((String)localObject).length() >= 32) {
              if ((!bt.kU(str2, str4)) && (!bt.kU(str3, str4)))
              {
                paramHashSet.add(str4);
                paramList.add(str4);
                i += 1;
                this.nNA.add(localObject);
              }
            }
          }
          for (;;)
          {
            j += 1;
            break;
            if (str2.endsWith("/")) {}
            for (localObject = str2 + "music";; localObject = str2 + "/music")
            {
              paramList.add(localObject);
              az.arV();
              paramList.add(c.aqb());
              az.arV();
              paramList.add(c.getAccSnsPath());
              az.arV();
              paramList.add(c.aqg());
              break;
            }
            paramList.add(str4);
            i += 1;
            continue;
            paramList.add(str4);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(22765);
    return k;
  }
  
  private String bel()
  {
    AppMethodBeat.i(22762);
    String str = hashCode();
    AppMethodBeat.o(22762);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(22763);
    long l2 = bt.GC();
    if (this.isStop)
    {
      ad.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[] { bel() });
      AppMethodBeat.o(22763);
      return;
    }
    Object localObject = new ArrayList();
    HashSet localHashSet = new HashSet();
    a((List)localObject, localHashSet);
    int j = ((List)localObject).size();
    int i = 0;
    while ((!this.isStop) && (i < j))
    {
      String str = (String)((List)localObject).get(i);
      if (!bt.isNullOrNil(str))
      {
        if (str.endsWith("/sns/"))
        {
          this.nNC.add(str);
          l1 = RO(str);
        }
        for (;;)
        {
          this.nNz.put(str, Long.valueOf(l1));
          ad.d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", new Object[] { bel(), str, Long.valueOf(l1) });
          this.nNw += l1;
          if (localHashSet.contains(str)) {
            this.nNy = (l1 + this.nNy);
          }
          i += 1;
          if (this.nNB != null) {
            this.nNB.eS(i, j);
          }
          break;
          if (str.endsWith("/music"))
          {
            this.nNC.add(str);
            l1 = RO(str);
          }
          else
          {
            l1 = RN(str);
          }
        }
      }
    }
    this.nNx = com.tencent.mm.plugin.f.b.bHc().bHd().bHl();
    this.nNw += this.nNx;
    if (this.nNw <= 0L)
    {
      this.nNw = 1L;
      h.vKh.idkeyStat(714L, 60L, 1L, false);
    }
    ad.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] acc[%d] otherAcc[%d]", new Object[] { bel(), Long.valueOf(bt.aS(l2)), Long.valueOf(this.nNw), Long.valueOf(this.nNx), Long.valueOf(this.nNy) });
    d.bNS();
    long l1 = d.bNT();
    d.bNS();
    l2 = d.bNU();
    i = (int)(this.nNw * 100L / l1);
    j = (int)(this.nNx * 100L / this.nNw);
    int k = (int)(this.nNy * 100L / this.nNw);
    long l3 = this.nNw - this.nNx - this.nNy;
    int m = (int)(100L * l3 / this.nNw);
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cacheSize).append(",");
    ((StringBuffer)localObject).append(this.nNw).append(",");
    ((StringBuffer)localObject).append(i).append(",");
    ((StringBuffer)localObject).append(l1 - l2).append(",");
    ((StringBuffer)localObject).append(l2).append(",");
    ((StringBuffer)localObject).append(l1).append(",");
    ((StringBuffer)localObject).append(this.nNx).append(",");
    ((StringBuffer)localObject).append(j).append(",");
    ((StringBuffer)localObject).append(this.nNy).append(",");
    ((StringBuffer)localObject).append(k).append(",");
    ((StringBuffer)localObject).append(l3).append(",");
    ((StringBuffer)localObject).append(m).append(",");
    ((StringBuffer)localObject).append("0");
    localObject = ((StringBuffer)localObject).toString();
    ad.i("MicroMsg.CleanCalcLogic", "rpt content %s", new Object[] { localObject });
    h.vKh.kvStat(14762, (String)localObject);
    d.bNS().nNw = this.nNw;
    d.bNS().nNx = this.nNx;
    d.bNS().cacheSize = this.cacheSize;
    d.bNS().nNy = this.nNy;
    d.bNS().nNM = this.nNz;
    d.bNS().nNN = localHashSet;
    d.bNS().npF = this.nNC;
    if (this.nNB != null) {
      this.nNB.i(this.nNw, this.nNx, this.cacheSize);
    }
    stop();
    AppMethodBeat.o(22763);
  }
  
  public final void stop()
  {
    this.isStop = true;
    this.nNB = null;
  }
  
  public static abstract interface a
  {
    public abstract void eS(int paramInt1, int paramInt2);
    
    public abstract void i(long paramLong1, long paramLong2, long paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.a
 * JD-Core Version:    0.7.0.1
 */