package com.tencent.mm.plugin.clean.b;

import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements Runnable
{
  private boolean isStop;
  private long sXm;
  List<Runnable> sXn;
  private long tOc;
  private long tOd;
  private long tOe;
  private HashMap<String, Long> tOf;
  private HashSet<String> tOg;
  private a tOh;
  LinkedList<String> tOi;
  
  public a(a parama)
  {
    AppMethodBeat.i(284703);
    this.isStop = false;
    this.tOi = new LinkedList();
    this.sXn = new ArrayList();
    this.isStop = false;
    this.tOh = parama;
    this.tOf = new HashMap();
    this.tOg = new HashSet();
    AppMethodBeat.o(284703);
  }
  
  private static long A(File paramFile)
  {
    AppMethodBeat.i(284706);
    try
    {
      paramFile = Os.stat(paramFile.getPath());
      if (paramFile == null)
      {
        AppMethodBeat.o(284706);
        return 0L;
      }
      long l = paramFile.st_blocks;
      AppMethodBeat.o(284706);
      return l * 512L;
    }
    catch (ErrnoException paramFile)
    {
      AppMethodBeat.o(284706);
    }
    return 0L;
  }
  
  private long B(File paramFile)
  {
    AppMethodBeat.i(284708);
    long l1 = A(paramFile);
    long l2 = l1;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      l2 = l1;
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          File localFile = paramFile[i];
          l2 = l1;
          if (localFile != null) {
            l2 = l1 + B(localFile);
          }
          i += 1;
          l1 = l2;
        }
      }
    }
    AppMethodBeat.o(284708);
    return l2;
  }
  
  private int a(HashSet<String> paramHashSet1, HashSet<String> paramHashSet2)
  {
    AppMethodBeat.i(284709);
    Object localObject1 = new HashSet();
    HashSet localHashSet = new HashSet();
    int i;
    Object localObject2;
    if (com.tencent.mm.loader.j.b.aSF().equals(com.tencent.mm.loader.j.b.aSG()))
    {
      ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.aSL());
      localHashSet.add(com.tencent.mm.loader.j.b.aSL() + com.tencent.mm.kernel.h.aHG().kcE + File.separator);
      localHashSet.add(com.tencent.mm.loader.j.b.aSL() + com.tencent.mm.kernel.h.aHG().kcC + File.separator);
      Log.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path SDCARD_ROOT[%s] DEFAULT_SDCARD_ROOT[%s], acc[%s], oldacc[%s]", new Object[] { bqf(), com.tencent.mm.loader.j.b.aSF(), com.tencent.mm.loader.j.b.aSG(), com.tencent.mm.kernel.h.aHG().kcE, com.tencent.mm.kernel.h.aHG().kcC });
      i = 1;
      localObject2 = com.tencent.mm.loader.j.b.aSF() + "/Cache/";
      paramHashSet1.add(localObject2);
      ((HashSet)localObject1).remove(localObject2);
      localObject1 = ((HashSet)localObject1).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label877;
      }
      localObject2 = new File((String)((Iterator)localObject1).next());
      if (((File)localObject2).isDirectory())
      {
        localObject2 = ((File)localObject2).listFiles();
        if (localObject2 != null)
        {
          int n = localObject2.length;
          int k = 0;
          int j = i;
          i = j;
          if (k < n)
          {
            String str = localObject2[k];
            Log.d("MicroMsg.CleanCalcLogic", "%s getMicroMsgPaths filePath[%s]", new Object[] { bqf(), str.getAbsolutePath() });
            if (str.isDirectory())
            {
              Object localObject3 = str.getName();
              str = str.getAbsolutePath() + File.separator;
              if (((String)localObject3).length() >= 32) {
                if (localHashSet.contains(str))
                {
                  localObject3 = new File(str).listFiles();
                  i = j;
                  if (localObject3 != null)
                  {
                    int i1 = localObject3.length;
                    int m = 0;
                    label407:
                    i = j;
                    if (m < i1)
                    {
                      str = localObject3[m];
                      if (str.isDirectory()) {
                        paramHashSet1.add(str.getAbsolutePath() + File.separator);
                      }
                      for (;;)
                      {
                        m += 1;
                        break label407;
                        localObject2 = new File(com.tencent.mm.loader.j.b.aSF() + File.separator);
                        if (((File)localObject2).isDirectory())
                        {
                          localObject2 = ((File)localObject2).listFiles();
                          if (localObject2 != null)
                          {
                            j = localObject2.length;
                            i = 0;
                            if (i < j)
                            {
                              localObject3 = localObject2[i];
                              if (((File)localObject3).isDirectory()) {
                                ((HashSet)localObject1).add(((File)localObject3).getAbsolutePath() + File.separator);
                              }
                              for (;;)
                              {
                                i += 1;
                                break;
                                ((HashSet)localObject1).add(((File)localObject3).getAbsolutePath());
                              }
                            }
                          }
                          else
                          {
                            ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.aSF() + File.separator);
                          }
                        }
                        ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.aSK());
                        localHashSet.add(com.tencent.mm.loader.j.b.aSL() + com.tencent.mm.kernel.h.aHG().kcE + File.separator);
                        localHashSet.add(com.tencent.mm.loader.j.b.aSL() + com.tencent.mm.kernel.h.aHG().kcC + File.separator);
                        localHashSet.add(com.tencent.mm.loader.j.b.aSK() + com.tencent.mm.kernel.h.aHG().kcE + File.separator);
                        localHashSet.add(com.tencent.mm.loader.j.b.aSK() + com.tencent.mm.kernel.h.aHG().kcC + File.separator);
                        break;
                        paramHashSet1.add(str.getAbsolutePath());
                      }
                    }
                  }
                }
                else
                {
                  paramHashSet2.add(str);
                  paramHashSet1.add(str);
                  i = j + 1;
                  this.tOg.add(localObject3);
                }
              }
            }
            for (;;)
            {
              k += 1;
              j = i;
              break;
              paramHashSet1.add(str);
              i = j + 1;
              continue;
              paramHashSet1.add(str.getAbsolutePath());
              i = j + 1;
            }
          }
        }
      }
    }
    label877:
    AppMethodBeat.o(284709);
    return i;
  }
  
  private String bqf()
  {
    AppMethodBeat.i(22762);
    String str = hashCode();
    AppMethodBeat.o(22762);
    return str;
  }
  
  private long z(File paramFile)
  {
    AppMethodBeat.i(284705);
    long l1 = 0L;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null)
      {
        AppMethodBeat.o(284705);
        return 0L;
      }
      int m = paramFile.length;
      int i = 0;
      for (;;)
      {
        l2 = l1;
        if (i >= m) {
          break;
        }
        File[] arrayOfFile = paramFile[i];
        long l3;
        if (((arrayOfFile.getAbsolutePath() + File.separator).endsWith("/MicroMsg/")) && (arrayOfFile.isDirectory()))
        {
          arrayOfFile = arrayOfFile.listFiles();
          l2 = l1;
          if (arrayOfFile != null)
          {
            int n = arrayOfFile.length;
            int j = 0;
            for (;;)
            {
              l2 = l1;
              if (j >= n) {
                break;
              }
              Object localObject = arrayOfFile[j];
              if ((((File)localObject).getName().length() >= 32) && (((File)localObject).isDirectory()))
              {
                localObject = ((File)localObject).listFiles();
                l2 = l1;
                if (localObject != null)
                {
                  int i1 = localObject.length;
                  int k = 0;
                  for (;;)
                  {
                    l2 = l1;
                    if (k >= i1) {
                      break;
                    }
                    File localFile = localObject[k];
                    l2 = B(localFile);
                    l1 += l2;
                    this.tOf.put(localFile.getAbsolutePath(), Long.valueOf(l2));
                    k += 1;
                  }
                }
              }
              else
              {
                l3 = B((File)localObject);
                l2 = l1 + l3;
                this.tOf.put(((File)localObject).getAbsolutePath(), Long.valueOf(l3));
              }
              j += 1;
              l1 = l2;
            }
          }
        }
        else
        {
          l3 = B(arrayOfFile);
          l2 = l1 + l3;
          this.tOf.put(arrayOfFile.getAbsolutePath(), Long.valueOf(l3));
        }
        i += 1;
        l1 = l2;
      }
    }
    long l2 = A(paramFile);
    this.tOf.put(paramFile.getAbsolutePath(), Long.valueOf(l2));
    AppMethodBeat.o(284705);
    return l2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(22763);
    long l3 = Util.currentTicks();
    if (this.isStop)
    {
      Log.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[] { bqf() });
      AppMethodBeat.o(22763);
      return;
    }
    Object localObject1 = new HashSet();
    HashSet localHashSet = new HashSet();
    a((HashSet)localObject1, localHashSet);
    int j = ((HashSet)localObject1).size();
    localObject1 = ((HashSet)localObject1).iterator();
    int i = 0;
    Object localObject2;
    label122:
    long l2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (this.isStop) {
        Log.e("MicroMsg.CleanCalcLogic", "run stop.");
      }
    }
    else
    {
      this.tOd = com.tencent.mm.plugin.h.a.cFg().cFh().cFr();
      l2 = z(new File(com.tencent.mm.loader.j.b.aSC()));
      if (this.tOc <= 0L)
      {
        this.tOc = 1L;
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(714L, 60L, 1L, false);
      }
      com.tencent.mm.kernel.h.aHH();
      localObject1 = u.bBU(com.tencent.mm.kernel.h.aHG().aHn());
      if (localObject1 == null) {
        break label364;
      }
    }
    label364:
    for (long l1 = ((com.tencent.mm.vfs.f)localObject1).YCh;; l1 = 0L)
    {
      localObject1 = com.tencent.mm.vfs.b.ieZ().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.mm.vfs.f)((Iterator)localObject1).next();
        if (this.isStop) {
          break;
        }
        this.sXm += ((com.tencent.mm.vfs.f)localObject2).YCh;
      }
      if (i >= j) {
        break label122;
      }
      if (Util.isNullOrNil((String)localObject2)) {
        break;
      }
      l1 = B(new File((String)localObject2));
      this.tOf.put(localObject2, Long.valueOf(l1));
      this.tOc += l1;
      if (localHashSet.contains(localObject2)) {
        this.tOe = (l1 + this.tOe);
      }
      i += 1;
      if (this.tOh != null) {
        this.tOh.fK(i, j);
      }
      break;
    }
    Log.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%s] dataSize[%s] dbSize[%s] acc[%s] otherAcc[%s] cacheSize[%s]", new Object[] { bqf(), Long.valueOf(Util.ticksToNow(l3)), Util.getSizeMB(this.tOc), Util.getSizeMB(l2), Util.getSizeMB(l1), Util.getSizeMB(this.tOd), Util.getSizeMB(this.tOe), Util.getSizeMB(this.sXm) });
    d.cNh();
    l3 = d.cNi();
    d.cNh();
    long l4 = d.cNj();
    i = (int)(this.tOc * 100L / l3);
    j = (int)(this.tOd * 100L / this.tOc);
    int k = (int)(this.tOe * 100L / this.tOc);
    long l5 = this.tOc - this.tOd - this.tOe;
    int m = (int)(100L * l5 / this.tOc);
    localObject1 = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
    long l6 = ((MultiProcessMMKV)localObject1).getLong("CleanCalcMidImg", 0L);
    long l7 = ((MultiProcessMMKV)localObject1).getLong("CleanCalcHevcImg", 0L);
    localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append(this.sXm).append(",");
    ((StringBuffer)localObject1).append(this.tOc).append(",");
    ((StringBuffer)localObject1).append(i).append(",");
    ((StringBuffer)localObject1).append(l3 - l4).append(",");
    ((StringBuffer)localObject1).append(l4).append(",");
    ((StringBuffer)localObject1).append(l3).append(",");
    ((StringBuffer)localObject1).append(this.tOd).append(",");
    ((StringBuffer)localObject1).append(j).append(",");
    ((StringBuffer)localObject1).append(this.tOe).append(",");
    ((StringBuffer)localObject1).append(k).append(",");
    ((StringBuffer)localObject1).append(l5).append(",");
    ((StringBuffer)localObject1).append(m).append(",");
    ((StringBuffer)localObject1).append("0,");
    ((StringBuffer)localObject1).append(l2).append(",");
    ((StringBuffer)localObject1).append(l6).append(",");
    ((StringBuffer)localObject1).append(l7);
    localObject1 = ((StringBuffer)localObject1).toString();
    Log.i("MicroMsg.CleanCalcLogic", "rpt content %s", new Object[] { localObject1 });
    this.sXn.add(new a.1(this));
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(14762, (String)localObject1);
    l3 = this.tOc;
    l4 = this.tOd;
    double d = l4 / l3;
    if (l3 > 17179869184L)
    {
      i = 7;
      if (d <= 0.5D) {
        break label1276;
      }
      j = 11;
    }
    for (;;)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(new IDKey(1613L, 0L, l3 / 1024L / 1024L));
      ((ArrayList)localObject1).add(new IDKey(1613L, 1L, l4 / 1024L / 1024L));
      ((ArrayList)localObject1).add(new IDKey(1613, 2, 1));
      ((ArrayList)localObject1).add(new IDKey(1613, i, 1));
      ((ArrayList)localObject1).add(new IDKey(1613, j, 1));
      com.tencent.mm.plugin.report.service.h.IzE.b((ArrayList)localObject1, true);
      localObject1 = this.tOf;
      localObject2 = new ArrayList(((HashMap)localObject1).entrySet());
      if (!((HashMap)localObject1).isEmpty()) {
        Collections.sort((List)localObject2, new a.2(this));
      }
      Log.i("MicroMsg.CleanCalcLogic", "clean path size:\n%s", new Object[] { com.tencent.mm.plugin.clean.a.cY((List)localObject2) });
      d.cNh().tOt = this.tOc;
      d.cNh().bcy = l2;
      d.cNh().tOd = (this.tOd + l1);
      d.cNh().sXm = this.sXm;
      d.cNh().tOe = this.tOe;
      d.cNh().pWR = ((List)localObject2);
      d.cNh().tOu = localHashSet;
      d.cNh().sXl = this.tOi;
      d.cNh().sXn = this.sXn;
      if (this.tOh != null) {
        this.tOh.k(this.tOc, this.tOd + l1, this.sXm);
      }
      stop();
      AppMethodBeat.o(22763);
      return;
      if (l3 > 8589934592L)
      {
        i = 6;
        break;
      }
      if (l3 > 2147483648L)
      {
        i = 5;
        break;
      }
      if (l3 > 536870912L)
      {
        i = 4;
        break;
      }
      i = 3;
      break;
      label1276:
      if (d > 0.2D) {
        j = 10;
      } else if (d > 0.1D) {
        j = 9;
      } else {
        j = 8;
      }
    }
  }
  
  public final void stop()
  {
    this.isStop = true;
    this.tOh = null;
  }
  
  public static abstract interface a
  {
    public abstract void fK(int paramInt1, int paramInt2);
    
    public abstract void k(long paramLong1, long paramLong2, long paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.a
 * JD-Core Version:    0.7.0.1
 */