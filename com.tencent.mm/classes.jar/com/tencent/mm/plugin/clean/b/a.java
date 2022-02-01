package com.tencent.mm.plugin.clean.b;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements Runnable
{
  private static final Long duN;
  private static final Long qps;
  private long cacheSize;
  private boolean isStop;
  List<Runnable> pQl;
  private long qpt;
  private long qpu;
  private long qpv;
  private HashMap<String, Long> qpw;
  private HashSet<String> qpx;
  private a qpy;
  LinkedList<String> qpz;
  
  static
  {
    AppMethodBeat.i(22768);
    duN = Long.valueOf(604800000L);
    qps = Long.valueOf(7776000000L);
    AppMethodBeat.o(22768);
  }
  
  public a(a parama)
  {
    AppMethodBeat.i(231653);
    this.isStop = false;
    this.qpz = new LinkedList();
    this.pQl = new ArrayList();
    this.isStop = false;
    this.qpy = parama;
    this.qpw = new HashMap();
    this.qpx = new HashSet();
    AppMethodBeat.o(231653);
  }
  
  private long H(File paramFile)
  {
    AppMethodBeat.i(231654);
    long l1 = 0L;
    long l2;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      l2 = l1;
      if (paramFile != null)
      {
        int m = paramFile.length;
        int i = 0;
        l2 = l1;
        if (i < m)
        {
          File[] arrayOfFile = paramFile[i];
          String str = arrayOfFile.getAbsolutePath() + File.separator;
          long l3;
          if (str.endsWith("/MicroMsg/")) {
            if (arrayOfFile.isDirectory())
            {
              arrayOfFile = arrayOfFile.listFiles();
              l2 = l1;
              if (arrayOfFile != null)
              {
                int n = arrayOfFile.length;
                int j = 0;
                l2 = l1;
                if (j < n)
                {
                  Object localObject = arrayOfFile[j];
                  if (((File)localObject).getName().length() >= 32) {
                    if (((File)localObject).isDirectory())
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
                          l2 = I(localFile);
                          l1 += l2;
                          Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", new Object[] { bgQ(), localFile.getAbsolutePath(), Util.getSizeMB(l2) });
                          k += 1;
                        }
                      }
                    }
                    else
                    {
                      l3 = I(new File(str));
                      l2 = l1 + l3;
                      Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", new Object[] { bgQ(), ((File)localObject).getAbsolutePath(), Util.getSizeMB(l3) });
                    }
                  }
                  for (;;)
                  {
                    j += 1;
                    l1 = l2;
                    break;
                    l3 = I((File)localObject);
                    l2 = l1 + l3;
                    Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", new Object[] { bgQ(), ((File)localObject).getAbsolutePath(), Util.getSizeMB(l3) });
                  }
                }
              }
            }
            else
            {
              l3 = I(new File(str));
              l2 = l1 + l3;
              Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", new Object[] { bgQ(), str, Util.getSizeMB(l3) });
            }
          }
          for (;;)
          {
            i += 1;
            l1 = l2;
            break;
            l3 = I(new File(str));
            l2 = l1 + l3;
            Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", new Object[] { bgQ(), str, Util.getSizeMB(l3) });
          }
        }
      }
    }
    else
    {
      l2 = I(paramFile);
      Log.i("MicroMsg.CleanCalcLogic", "%s data path[%s] size[%s]", new Object[] { bgQ(), paramFile.getAbsolutePath(), Util.getSizeMB(l2) });
    }
    AppMethodBeat.o(231654);
    return l2;
  }
  
  private long I(File paramFile)
  {
    AppMethodBeat.i(231655);
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        l1 = 0L;
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          long l2 = I(arrayOfFile[i]);
          if (l2 == -1L)
          {
            AppMethodBeat.o(231655);
            return -1L;
          }
          l1 += l2;
          i += 1;
        }
        AppMethodBeat.o(231655);
        return l1;
      }
    }
    long l1 = paramFile.length();
    AppMethodBeat.o(231655);
    return l1;
  }
  
  private long J(File paramFile)
  {
    AppMethodBeat.i(231657);
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        l = 0L;
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          l += J(arrayOfFile[i]);
          i += 1;
        }
        AppMethodBeat.o(231657);
        return l;
      }
    }
    else
    {
      this.cacheSize += paramFile.length();
      l = paramFile.length();
      AppMethodBeat.o(231657);
      return l;
    }
    this.cacheSize += paramFile.length();
    long l = paramFile.length();
    AppMethodBeat.o(231657);
    return l;
  }
  
  private int a(HashSet<String> paramHashSet1, HashSet<String> paramHashSet2)
  {
    AppMethodBeat.i(231656);
    Object localObject1 = new HashSet();
    HashSet localHashSet = new HashSet();
    int i;
    Object localObject2;
    if (com.tencent.mm.loader.j.b.aKD().equals(com.tencent.mm.loader.j.b.aKE()))
    {
      ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.aKJ());
      localHashSet.add(com.tencent.mm.loader.j.b.aKJ() + g.aAh().hqJ + File.separator);
      localHashSet.add(com.tencent.mm.loader.j.b.aKJ() + g.aAh().hqH + File.separator);
      Log.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path SDCARD_ROOT[%s] DEFAULT_SDCARD_ROOT[%s], acc[%s], oldacc[%s]", new Object[] { bgQ(), com.tencent.mm.loader.j.b.aKD(), com.tencent.mm.loader.j.b.aKE(), g.aAh().hqJ, g.aAh().hqH });
      i = 1;
      localObject2 = com.tencent.mm.loader.j.b.aKD() + "/Cache/";
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
            Log.d("MicroMsg.CleanCalcLogic", "%s getMicroMsgPaths filePath[%s]", new Object[] { bgQ(), str.getAbsolutePath() });
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
                        localObject2 = new File(com.tencent.mm.loader.j.b.aKD() + File.separator);
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
                            ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.aKD() + File.separator);
                          }
                        }
                        ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.aKI());
                        localHashSet.add(com.tencent.mm.loader.j.b.aKJ() + g.aAh().hqJ + File.separator);
                        localHashSet.add(com.tencent.mm.loader.j.b.aKJ() + g.aAh().hqH + File.separator);
                        localHashSet.add(com.tencent.mm.loader.j.b.aKI() + g.aAh().hqJ + File.separator);
                        localHashSet.add(com.tencent.mm.loader.j.b.aKI() + g.aAh().hqH + File.separator);
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
                  this.qpx.add(localObject3);
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
    AppMethodBeat.o(231656);
    return i;
  }
  
  private String bgQ()
  {
    AppMethodBeat.i(22762);
    String str = hashCode();
    AppMethodBeat.o(22762);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(22763);
    long l3 = Util.currentTicks();
    if (this.isStop)
    {
      Log.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[] { bgQ() });
      AppMethodBeat.o(22763);
      return;
    }
    Object localObject2 = new HashSet();
    HashSet localHashSet = new HashSet();
    a((HashSet)localObject2, localHashSet);
    Object localObject1 = com.tencent.mm.loader.j.b.aKD() + "/Cache/";
    int j = ((HashSet)localObject2).size();
    localObject2 = ((HashSet)localObject2).iterator();
    int i = 0;
    String str;
    label146:
    long l1;
    long l2;
    long l4;
    double d;
    if (((Iterator)localObject2).hasNext())
    {
      str = (String)((Iterator)localObject2).next();
      if (this.isStop) {
        Log.e("MicroMsg.CleanCalcLogic", "run stop.");
      }
    }
    else
    {
      this.qpu = com.tencent.mm.plugin.f.b.crW().crX().csg();
      l1 = H(new File(com.tencent.mm.loader.j.b.aKA()));
      if (this.qpt <= 0L)
      {
        this.qpt = 1L;
        h.CyF.idkeyStat(714L, 60L, 1L, false);
      }
      g.aAi();
      l2 = s.boW(g.aAh().azO());
      Log.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%s] dataSize[%s] dbSize[%s], acc[%s] otherAcc[%s]", new Object[] { bgQ(), Long.valueOf(Util.ticksToNow(l3)), Util.getSizeMB(this.qpt), Util.getSizeMB(l1), Util.getSizeMB(l2), Util.getSizeMB(this.qpu), Util.getSizeMB(this.qpv) });
      d.cyM();
      l3 = d.cyN();
      d.cyM();
      l4 = d.cyO();
      i = (int)(this.qpt * 100L / l3);
      j = (int)(this.qpu * 100L / this.qpt);
      int k = (int)(this.qpv * 100L / this.qpt);
      long l5 = this.qpt - this.qpu - this.qpv;
      int m = (int)(100L * l5 / this.qpt);
      localObject1 = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
      long l6 = ((MultiProcessMMKV)localObject1).getLong("CleanCalcMidImg", 0L);
      long l7 = ((MultiProcessMMKV)localObject1).getLong("CleanCalcHevcImg", 0L);
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append(this.cacheSize).append(",");
      ((StringBuffer)localObject1).append(this.qpt).append(",");
      ((StringBuffer)localObject1).append(i).append(",");
      ((StringBuffer)localObject1).append(l3 - l4).append(",");
      ((StringBuffer)localObject1).append(l4).append(",");
      ((StringBuffer)localObject1).append(l3).append(",");
      ((StringBuffer)localObject1).append(l2).append(",");
      ((StringBuffer)localObject1).append(this.qpu).append(",");
      ((StringBuffer)localObject1).append(j).append(",");
      ((StringBuffer)localObject1).append(this.qpv).append(",");
      ((StringBuffer)localObject1).append(k).append(",");
      ((StringBuffer)localObject1).append(l5).append(",");
      ((StringBuffer)localObject1).append(m).append(",");
      ((StringBuffer)localObject1).append("0,");
      ((StringBuffer)localObject1).append(l1).append(",");
      ((StringBuffer)localObject1).append(l6).append(",");
      ((StringBuffer)localObject1).append(l7);
      localObject1 = ((StringBuffer)localObject1).toString();
      Log.i("MicroMsg.CleanCalcLogic", "rpt content %s", new Object[] { localObject1 });
      this.pQl.add(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(231652);
          ((f)g.af(f.class)).buk();
          AppMethodBeat.o(231652);
        }
      });
      h.CyF.kvStat(14762, (String)localObject1);
      l3 = this.qpt;
      l4 = this.qpu;
      d = l4 / l3;
      if (l3 <= 17179869184L) {
        break label1214;
      }
      i = 7;
      label750:
      if (d <= 0.5D) {
        break label1262;
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
      h.CyF.b((ArrayList)localObject1, true);
      d.cyM().qpK = this.qpt;
      d.cyM().dataSize = l1;
      d.cyM().qpu = (this.qpu + l2);
      d.cyM().cacheSize = this.cacheSize;
      d.cyM().qpv = this.qpv;
      d.cyM().qpL = this.qpw;
      d.cyM().qpM = localHashSet;
      d.cyM().pQk = this.qpz;
      d.cyM().pQl = this.pQl;
      if (this.qpy != null) {
        this.qpy.j(this.qpt, this.qpu + l2, this.cacheSize);
      }
      stop();
      AppMethodBeat.o(22763);
      return;
      if (i >= j) {
        break label146;
      }
      if (Util.isNullOrNil(str)) {
        break;
      }
      if ((str.endsWith("/sns/")) || (str.endsWith("/music")) || (str.equals(localObject1))) {
        this.qpz.add(str);
      }
      for (l1 = J(new File(str));; l1 = I(new File(str)))
      {
        this.qpw.put(str, Long.valueOf(l1));
        Log.i("MicroMsg.CleanCalcLogic", "%s path[%s] size[%s]", new Object[] { bgQ(), str, Util.getSizeMB(l1) });
        this.qpt += l1;
        if (localHashSet.contains(str)) {
          this.qpv = (l1 + this.qpv);
        }
        i += 1;
        if (this.qpy != null) {
          this.qpy.fn(i, j);
        }
        break;
      }
      label1214:
      if (l3 > 8589934592L)
      {
        i = 6;
        break label750;
      }
      if (l3 > 2147483648L)
      {
        i = 5;
        break label750;
      }
      if (l3 > 536870912L)
      {
        i = 4;
        break label750;
      }
      i = 3;
      break label750;
      label1262:
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
    this.qpy = null;
  }
  
  public static abstract interface a
  {
    public abstract void fn(int paramInt1, int paramInt2);
    
    public abstract void j(long paramLong1, long paramLong2, long paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.a
 * JD-Core Version:    0.7.0.1
 */