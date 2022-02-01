package com.tencent.mm.plugin.clean.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements Runnable
{
  private static final Long cRz;
  private static final Long oqx;
  private long cacheSize;
  private boolean isStop;
  private long oqA;
  private HashMap<String, Long> oqB;
  private HashSet<String> oqC;
  private a oqD;
  LinkedList<String> oqE;
  private long oqy;
  private long oqz;
  
  static
  {
    AppMethodBeat.i(22768);
    cRz = Long.valueOf(604800000L);
    oqx = Long.valueOf(7776000000L);
    AppMethodBeat.o(22768);
  }
  
  public a(a parama)
  {
    AppMethodBeat.i(195964);
    this.isStop = false;
    this.oqE = new LinkedList();
    this.isStop = false;
    this.oqD = parama;
    this.oqB = new HashMap();
    this.oqC = new HashSet();
    AppMethodBeat.o(195964);
  }
  
  private long VZ(String paramString)
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
            l2 = VZ((String)localObject);
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
  
  private long Wa(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(195965);
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
          l += Wa(paramString + "/" + str);
          i += 1;
        }
        AppMethodBeat.o(195965);
        return l;
      }
    }
    else
    {
      this.cacheSize += i.aSp(paramString);
      AppMethodBeat.o(195965);
      return 0L;
    }
    l = i.aSp(paramString);
    AppMethodBeat.o(195965);
    return l;
  }
  
  private int a(List<String> paramList, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(22765);
    String str1 = g.agR().ghB;
    String str2 = g.agR().ghC;
    String str3 = str1 + g.agR().ghD + '/';
    ac.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path root[%s] acc[%s]", new Object[] { blf(), str1, str2 });
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
          ac.d("MicroMsg.CleanCalcLogic", "%s sub file path[%s] sub[%s]", new Object[] { blf(), str4, localObject });
          if (new com.tencent.mm.vfs.e(str4).isDirectory()) {
            if (((String)localObject).length() >= 32) {
              if ((!bs.lr(str2, str4)) && (!bs.lr(str3, str4)))
              {
                paramHashSet.add(str4);
                paramList.add(str4);
                i += 1;
                this.oqC.add(localObject);
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
              az.ayM();
              paramList.add(c.awQ());
              az.ayM();
              paramList.add(c.getAccSnsPath());
              az.ayM();
              paramList.add(c.awV());
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
  
  private String blf()
  {
    AppMethodBeat.i(22762);
    String str = hashCode();
    AppMethodBeat.o(22762);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(22763);
    long l2 = bs.Gn();
    if (this.isStop)
    {
      ac.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[] { blf() });
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
      if (!bs.isNullOrNil(str))
      {
        if (str.endsWith("/sns/"))
        {
          this.oqE.add(str);
          l1 = Wa(str);
        }
        for (;;)
        {
          this.oqB.put(str, Long.valueOf(l1));
          ac.d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", new Object[] { blf(), str, Long.valueOf(l1) });
          this.oqy += l1;
          if (localHashSet.contains(str)) {
            this.oqA = (l1 + this.oqA);
          }
          i += 1;
          if (this.oqD != null) {
            this.oqD.eV(i, j);
          }
          break;
          if (str.endsWith("/music"))
          {
            this.oqE.add(str);
            l1 = Wa(str);
          }
          else
          {
            l1 = VZ(str);
          }
        }
      }
    }
    this.oqz = com.tencent.mm.plugin.f.b.bOp().bOq().bOy();
    this.oqy += this.oqz;
    if (this.oqy <= 0L)
    {
      this.oqy = 1L;
      h.wUl.idkeyStat(714L, 60L, 1L, false);
    }
    ac.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] acc[%d] otherAcc[%d]", new Object[] { blf(), Long.valueOf(bs.aO(l2)), Long.valueOf(this.oqy), Long.valueOf(this.oqz), Long.valueOf(this.oqA) });
    d.bVd();
    long l1 = d.bVe();
    d.bVd();
    l2 = d.bVf();
    i = (int)(this.oqy * 100L / l1);
    j = (int)(this.oqz * 100L / this.oqy);
    int k = (int)(this.oqA * 100L / this.oqy);
    long l3 = this.oqy - this.oqz - this.oqA;
    int m = (int)(100L * l3 / this.oqy);
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cacheSize).append(",");
    ((StringBuffer)localObject).append(this.oqy).append(",");
    ((StringBuffer)localObject).append(i).append(",");
    ((StringBuffer)localObject).append(l1 - l2).append(",");
    ((StringBuffer)localObject).append(l2).append(",");
    ((StringBuffer)localObject).append(l1).append(",");
    ((StringBuffer)localObject).append(this.oqz).append(",");
    ((StringBuffer)localObject).append(j).append(",");
    ((StringBuffer)localObject).append(this.oqA).append(",");
    ((StringBuffer)localObject).append(k).append(",");
    ((StringBuffer)localObject).append(l3).append(",");
    ((StringBuffer)localObject).append(m).append(",");
    ((StringBuffer)localObject).append("0");
    localObject = ((StringBuffer)localObject).toString();
    ac.i("MicroMsg.CleanCalcLogic", "rpt content %s", new Object[] { localObject });
    h.wUl.kvStat(14762, (String)localObject);
    d.bVd().oqy = this.oqy;
    d.bVd().oqz = this.oqz;
    d.bVd().cacheSize = this.cacheSize;
    d.bVd().oqA = this.oqA;
    d.bVd().oqO = this.oqB;
    d.bVd().oqP = localHashSet;
    d.bVd().nSF = this.oqE;
    if (this.oqD != null) {
      this.oqD.j(this.oqy, this.oqz, this.cacheSize);
    }
    stop();
    AppMethodBeat.o(22763);
  }
  
  public final void stop()
  {
    this.isStop = true;
    this.oqD = null;
  }
  
  public static abstract interface a
  {
    public abstract void eV(int paramInt1, int paramInt2);
    
    public abstract void j(long paramLong1, long paramLong2, long paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.a
 * JD-Core Version:    0.7.0.1
 */