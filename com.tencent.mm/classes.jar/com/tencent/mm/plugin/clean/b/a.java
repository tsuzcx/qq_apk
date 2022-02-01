package com.tencent.mm.plugin.clean.b;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.FileSystem.b;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.k.f;
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
  private long wRs;
  private long wRt;
  private long wRu;
  private HashMap<String, Long> wRv;
  private HashSet<String> wRw;
  private a wRx;
  LinkedList<String> wRy;
  private long wbD;
  List<Runnable> wbE;
  private final boolean wbF;
  
  public a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(271843);
    this.isStop = false;
    this.wRy = new LinkedList();
    this.wbE = new ArrayList();
    this.isStop = false;
    this.wRx = parama;
    this.wRv = new HashMap();
    this.wRw = new HashSet();
    this.wbF = paramBoolean;
    AppMethodBeat.o(271843);
  }
  
  private long E(File paramFile)
  {
    AppMethodBeat.i(271845);
    long l1 = 0L;
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null)
      {
        AppMethodBeat.o(271845);
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
                    l2 = G(localFile);
                    l1 += l2;
                    this.wRv.put(localFile.getAbsolutePath(), Long.valueOf(l2));
                    k += 1;
                  }
                }
              }
              else
              {
                l3 = G((File)localObject);
                l2 = l1 + l3;
                this.wRv.put(((File)localObject).getAbsolutePath(), Long.valueOf(l3));
              }
              j += 1;
              l1 = l2;
            }
          }
        }
        else
        {
          l3 = G(arrayOfFile);
          l2 = l1 + l3;
          this.wRv.put(arrayOfFile.getAbsolutePath(), Long.valueOf(l3));
        }
        i += 1;
        l1 = l2;
      }
    }
    long l2 = F(paramFile);
    this.wRv.put(paramFile.getAbsolutePath(), Long.valueOf(l2));
    AppMethodBeat.o(271845);
    return l2;
  }
  
  private static long F(File paramFile)
  {
    AppMethodBeat.i(271847);
    try
    {
      paramFile = Os.stat(paramFile.getPath());
      if (paramFile == null)
      {
        AppMethodBeat.o(271847);
        return 0L;
      }
      long l = paramFile.st_blocks;
      AppMethodBeat.o(271847);
      return l * 512L;
    }
    catch (ErrnoException paramFile)
    {
      AppMethodBeat.o(271847);
    }
    return 0L;
  }
  
  private long G(File paramFile)
  {
    AppMethodBeat.i(271848);
    long l1 = F(paramFile);
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
            l2 = l1 + G(localFile);
          }
          i += 1;
          l1 = l2;
        }
      }
    }
    AppMethodBeat.o(271848);
    return l2;
  }
  
  private int a(HashSet<String> paramHashSet1, HashSet<String> paramHashSet2)
  {
    AppMethodBeat.i(271849);
    Object localObject1 = new HashSet();
    HashSet localHashSet = new HashSet();
    int i;
    Object localObject2;
    if (com.tencent.mm.loader.i.b.bmt().equals(com.tencent.mm.loader.i.b.bmu()))
    {
      ((HashSet)localObject1).add(com.tencent.mm.loader.i.b.bmz());
      localHashSet.add(com.tencent.mm.loader.i.b.bmz() + com.tencent.mm.kernel.h.baE().mCM + File.separator);
      localHashSet.add(com.tencent.mm.loader.i.b.bmz() + com.tencent.mm.kernel.h.baE().mCK + File.separator);
      Log.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path SDCARD_ROOT[%s] DEFAULT_SDCARD_ROOT[%s], acc[%s], oldacc[%s]", new Object[] { bNL(), com.tencent.mm.loader.i.b.bmt(), com.tencent.mm.loader.i.b.bmu(), com.tencent.mm.kernel.h.baE().mCM, com.tencent.mm.kernel.h.baE().mCK });
      i = 1;
      localObject2 = com.tencent.mm.loader.i.b.bmt() + "/cache/";
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
            Log.d("MicroMsg.CleanCalcLogic", "%s getMicroMsgPaths filePath[%s]", new Object[] { bNL(), str.getAbsolutePath() });
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
                        localObject2 = new File(com.tencent.mm.loader.i.b.bmt() + File.separator);
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
                            ((HashSet)localObject1).add(com.tencent.mm.loader.i.b.bmt() + File.separator);
                          }
                        }
                        ((HashSet)localObject1).add(com.tencent.mm.loader.i.b.bmy());
                        localHashSet.add(com.tencent.mm.loader.i.b.bmz() + com.tencent.mm.kernel.h.baE().mCM + File.separator);
                        localHashSet.add(com.tencent.mm.loader.i.b.bmz() + com.tencent.mm.kernel.h.baE().mCK + File.separator);
                        localHashSet.add(com.tencent.mm.loader.i.b.bmy() + com.tencent.mm.kernel.h.baE().mCM + File.separator);
                        localHashSet.add(com.tencent.mm.loader.i.b.bmy() + com.tencent.mm.kernel.h.baE().mCK + File.separator);
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
                  this.wRw.add(localObject3);
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
    AppMethodBeat.o(271849);
    return i;
  }
  
  private String bNL()
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
      Log.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[] { bNL() });
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
    label123:
    long l2;
    label208:
    long l1;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (this.isStop) {
        Log.e("MicroMsg.CleanCalcLogic", "run stop.");
      }
    }
    else
    {
      this.wRt = com.tencent.mm.plugin.calcwx.a.diz().diA().diK();
      l2 = E(new File(com.tencent.mm.loader.i.b.bmq()));
      if (this.wRs <= 0L)
      {
        this.wRs = 1L;
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(714L, 60L, 1L, false);
      }
      com.tencent.mm.kernel.h.baF();
      localObject1 = com.tencent.mm.kernel.h.baE().bal();
      if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
        break label390;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label442;
      }
      l1 = ((j)localObject1).agxf;
      label220:
      if (!this.wbF) {
        break label448;
      }
    }
    label390:
    label442:
    label448:
    for (localObject1 = com.tencent.mm.vfs.b.NO(true);; localObject1 = com.tencent.mm.vfs.b.jKd())
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (j)((Iterator)localObject1).next();
        if (this.isStop) {
          break;
        }
        this.wbD += ((j)localObject2).agxf;
      }
      if (i >= j) {
        break label123;
      }
      if (Util.isNullOrNil((String)localObject2)) {
        break;
      }
      l1 = G(new File((String)localObject2));
      this.wRv.put(localObject2, Long.valueOf(l1));
      this.wRs += l1;
      if (localHashSet.contains(localObject2)) {
        this.wRu = (l1 + this.wRu);
      }
      i += 1;
      if (this.wRx != null) {
        this.wRx.onProgress(i, j);
      }
      break;
      localObject1 = ah.parseUri((String)localObject1);
      localObject1 = k.kMs().a((Uri)localObject1, null);
      if (!((k.f)localObject1).boj())
      {
        localObject1 = null;
        break label208;
      }
      localObject1 = ((k.f)localObject1).agxM.bDV(((k.f)localObject1).path);
      break label208;
      l1 = 0L;
      break label220;
    }
    Log.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%s] dataSize[%s] dbSize[%s] acc[%s] otherAcc[%s] cacheSize[%s]", new Object[] { bNL(), Long.valueOf(Util.ticksToNow(l3)), Util.getSizeMB(this.wRs), Util.getSizeMB(l2), Util.getSizeMB(l1), Util.getSizeMB(this.wRt), Util.getSizeMB(this.wRu), Util.getSizeMB(this.wbD) });
    d.dqN();
    l3 = d.dqO();
    d.dqN();
    long l4 = d.dqP();
    i = (int)(this.wRs * 100L / l3);
    j = (int)(this.wRt * 100L / this.wRs);
    int k = (int)(this.wRu * 100L / this.wRs);
    long l5 = this.wRs - this.wRt - this.wRu;
    int m = (int)(100L * l5 / this.wRs);
    localObject1 = MultiProcessMMKV.getMMKV("CleanCalcMMKV");
    long l6 = ((MultiProcessMMKV)localObject1).getLong("CleanCalcMidImg", 0L);
    long l7 = ((MultiProcessMMKV)localObject1).getLong("CleanCalcHevcImg", 0L);
    localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append(this.wbD).append(",");
    ((StringBuffer)localObject1).append(this.wRs).append(",");
    ((StringBuffer)localObject1).append(i).append(",");
    ((StringBuffer)localObject1).append(l3 - l4).append(",");
    ((StringBuffer)localObject1).append(l4).append(",");
    ((StringBuffer)localObject1).append(l3).append(",");
    ((StringBuffer)localObject1).append(this.wRt).append(",");
    ((StringBuffer)localObject1).append(j).append(",");
    ((StringBuffer)localObject1).append(this.wRu).append(",");
    ((StringBuffer)localObject1).append(k).append(",");
    ((StringBuffer)localObject1).append(l5).append(",");
    ((StringBuffer)localObject1).append(m).append(",");
    ((StringBuffer)localObject1).append("0,");
    ((StringBuffer)localObject1).append(l2).append(",");
    ((StringBuffer)localObject1).append(l6).append(",");
    ((StringBuffer)localObject1).append(l7).append(',');
    double d;
    if (this.wbF)
    {
      i = 1;
      ((StringBuffer)localObject1).append(i);
      localObject1 = ((StringBuffer)localObject1).toString();
      Log.i("MicroMsg.CleanCalcLogic", "rpt content %s", new Object[] { localObject1 });
      this.wbE.add(new a.1(this));
      com.tencent.mm.plugin.report.service.h.OAn.kvStat(14762, (String)localObject1);
      l3 = this.wRs;
      l4 = this.wRt;
      d = l4 / l3;
      if (l3 <= 17179869184L) {
        break label1340;
      }
      i = 7;
      label1006:
      if (d <= 0.5D) {
        break label1388;
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
      com.tencent.mm.plugin.report.service.h.OAn.b((ArrayList)localObject1, true);
      localObject1 = this.wRv;
      localObject2 = new ArrayList(((HashMap)localObject1).entrySet());
      if (!((HashMap)localObject1).isEmpty()) {
        Collections.sort((List)localObject2, new a.2(this));
      }
      Log.i("MicroMsg.CleanCalcLogic", "clean path size:\n%s", new Object[] { com.tencent.mm.plugin.clean.a.eT((List)localObject2) });
      d.dqN().wRJ = this.wRs;
      d.dqN().cWt = l2;
      d.dqN().wRt = (this.wRt + l1);
      d.dqN().wbD = this.wbD;
      d.dqN().wRu = this.wRu;
      d.dqN().tbH = ((List)localObject2);
      d.dqN().wRK = localHashSet;
      d.dqN().wbC = this.wRy;
      d.dqN().wbE = this.wbE;
      if (this.wRx != null) {
        this.wRx.l(this.wRs, this.wRt + l1, this.wbD);
      }
      stop();
      AppMethodBeat.o(22763);
      return;
      i = 0;
      break;
      label1340:
      if (l3 > 8589934592L)
      {
        i = 6;
        break label1006;
      }
      if (l3 > 2147483648L)
      {
        i = 5;
        break label1006;
      }
      if (l3 > 536870912L)
      {
        i = 4;
        break label1006;
      }
      i = 3;
      break label1006;
      label1388:
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
    this.wRx = null;
  }
  
  public static abstract interface a
  {
    public abstract void l(long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void onProgress(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.a
 * JD-Core Version:    0.7.0.1
 */