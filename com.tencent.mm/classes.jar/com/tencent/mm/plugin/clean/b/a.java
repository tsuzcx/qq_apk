package com.tencent.mm.plugin.clean.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements Runnable
{
  private static final Long dcP;
  private static final Long oTS;
  private long cacheSize;
  private boolean isStop;
  private long oTT;
  private long oTU;
  private long oTV;
  private HashMap<String, Long> oTW;
  private HashSet<String> oTX;
  private a oTY;
  LinkedList<String> oTZ;
  
  static
  {
    AppMethodBeat.i(22768);
    dcP = Long.valueOf(604800000L);
    oTS = Long.valueOf(7776000000L);
    AppMethodBeat.o(22768);
  }
  
  public a(a parama)
  {
    AppMethodBeat.i(193174);
    this.isStop = false;
    this.oTZ = new LinkedList();
    this.isStop = false;
    this.oTY = parama;
    this.oTW = new HashMap();
    this.oTX = new HashSet();
    AppMethodBeat.o(193174);
  }
  
  private long H(File paramFile)
  {
    AppMethodBeat.i(193175);
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
          long l2 = H(arrayOfFile[i]);
          if (l2 == -1L)
          {
            AppMethodBeat.o(193175);
            return -1L;
          }
          l1 += l2;
          i += 1;
        }
        AppMethodBeat.o(193175);
        return l1;
      }
    }
    long l1 = paramFile.length();
    AppMethodBeat.o(193175);
    return l1;
  }
  
  private long I(File paramFile)
  {
    AppMethodBeat.i(193177);
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
          l += I(arrayOfFile[i]);
          i += 1;
        }
        AppMethodBeat.o(193177);
        return l;
      }
    }
    else
    {
      this.cacheSize += paramFile.length();
      l = paramFile.length();
      AppMethodBeat.o(193177);
      return l;
    }
    this.cacheSize += paramFile.length();
    long l = paramFile.length();
    AppMethodBeat.o(193177);
    return l;
  }
  
  private int a(HashSet<String> paramHashSet1, HashSet<String> paramHashSet2)
  {
    AppMethodBeat.i(193176);
    Object localObject1 = new HashSet();
    HashSet localHashSet = new HashSet();
    int k;
    Object localObject2;
    File[] arrayOfFile;
    int j;
    int i;
    label274:
    Object localObject3;
    if (com.tencent.mm.loader.j.b.arO().equals(com.tencent.mm.loader.j.b.arP()))
    {
      ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.arU());
      localHashSet.add(com.tencent.mm.loader.j.b.arU() + com.tencent.mm.kernel.g.ajC().gBp + File.separator);
      localHashSet.add(com.tencent.mm.loader.j.b.arU() + com.tencent.mm.kernel.g.ajC().gBn + File.separator);
      ad.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path SDCARD_ROOT[%s] DEFAULT_SDCARD_ROOT[%s], acc[%s], oldacc[%s]", new Object[] { boQ(), com.tencent.mm.loader.j.b.arO(), com.tencent.mm.loader.j.b.arP(), com.tencent.mm.kernel.g.ajC().gBp, com.tencent.mm.kernel.g.ajC().gBn });
      k = 1;
      localObject2 = com.tencent.mm.loader.j.b.arO() + "/Cache/";
      paramHashSet1.add(localObject2);
      ((HashSet)localObject1).remove(localObject2);
      localObject2 = ((HashSet)localObject1).iterator();
      int m;
      do
      {
        do
        {
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject1 = new File((String)((Iterator)localObject2).next());
          } while (!((File)localObject1).isDirectory());
          arrayOfFile = ((File)localObject1).listFiles();
        } while (arrayOfFile == null);
        m = arrayOfFile.length;
        j = 0;
        i = k;
        k = i;
      } while (j >= m);
      localObject3 = arrayOfFile[j];
      ad.d("MicroMsg.CleanCalcLogic", "%s getMicroMsgPaths filePath[%s]", new Object[] { boQ(), ((File)localObject3).getAbsolutePath() });
      if (!((File)localObject3).isDirectory()) {
        break label856;
      }
      localObject1 = ((File)localObject3).getName();
      localObject3 = ((File)localObject3).getAbsolutePath() + File.separator;
      if (((String)localObject1).length() < 32) {
        break label842;
      }
      if (!localHashSet.contains(localObject3)) {
        break label811;
      }
      if (!((String)localObject3).endsWith(File.separator)) {
        break label780;
      }
      localObject1 = (String)localObject3 + "music";
      label411:
      paramHashSet1.add(localObject1);
      ba.aBQ();
      paramHashSet1.add(c.azF());
      ba.aBQ();
      paramHashSet1.add(c.getAccSnsPath());
      ba.aBQ();
      paramHashSet1.add(c.azK());
    }
    for (;;)
    {
      j += 1;
      break label274;
      localObject2 = new File(com.tencent.mm.loader.j.b.arO() + File.separator);
      if (((File)localObject2).isDirectory())
      {
        localObject2 = ((File)localObject2).listFiles();
        if (localObject2 != null)
        {
          j = localObject2.length;
          i = 0;
          if (i < j)
          {
            arrayOfFile = localObject2[i];
            if (arrayOfFile.isDirectory()) {
              ((HashSet)localObject1).add(arrayOfFile.getAbsolutePath() + File.separator);
            }
            for (;;)
            {
              i += 1;
              break;
              ((HashSet)localObject1).add(arrayOfFile.getAbsolutePath());
            }
          }
        }
        else
        {
          ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.arO() + File.separator);
        }
      }
      ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.arT());
      localHashSet.add(com.tencent.mm.loader.j.b.arU() + com.tencent.mm.kernel.g.ajC().gBp + File.separator);
      localHashSet.add(com.tencent.mm.loader.j.b.arU() + com.tencent.mm.kernel.g.ajC().gBn + File.separator);
      localHashSet.add(com.tencent.mm.loader.j.b.arT() + com.tencent.mm.kernel.g.ajC().gBp + File.separator);
      localHashSet.add(com.tencent.mm.loader.j.b.arT() + com.tencent.mm.kernel.g.ajC().gBn + File.separator);
      break;
      label780:
      localObject1 = (String)localObject3 + File.separator + "music";
      break label411;
      label811:
      paramHashSet2.add(localObject3);
      paramHashSet1.add(localObject3);
      i += 1;
      this.oTX.add(localObject1);
      continue;
      label842:
      paramHashSet1.add(localObject3);
      i += 1;
      continue;
      label856:
      paramHashSet1.add(((File)localObject3).getAbsolutePath());
      i += 1;
    }
    AppMethodBeat.o(193176);
    return k;
  }
  
  private String boQ()
  {
    AppMethodBeat.i(22762);
    String str = hashCode();
    AppMethodBeat.o(22762);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(22763);
    long l2 = bt.HI();
    if (this.isStop)
    {
      ad.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[] { boQ() });
      AppMethodBeat.o(22763);
      return;
    }
    Object localObject2 = new HashSet();
    HashSet localHashSet = new HashSet();
    a((HashSet)localObject2, localHashSet);
    Object localObject1 = com.tencent.mm.loader.j.b.arO() + "/Cache/";
    int j = ((HashSet)localObject2).size();
    localObject2 = ((HashSet)localObject2).iterator();
    int i = 0;
    String str;
    label771:
    do
    {
      if (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (!this.isStop) {
          break label771;
        }
        ad.e("MicroMsg.CleanCalcLogic", "run stop.");
      }
      while (i >= j)
      {
        this.oTU = com.tencent.mm.plugin.f.b.bSU().bSV().bTd();
        this.oTT += this.oTU;
        l1 = H(new File(com.tencent.mm.loader.j.b.arL()));
        if (this.oTT <= 0L)
        {
          this.oTT = 1L;
          com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(714L, 60L, 1L, false);
        }
        com.tencent.mm.kernel.g.ajD();
        long l3 = i.aYo(com.tencent.mm.kernel.g.ajC().ajj());
        ad.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] dataSize[%d] dbSize[%d], acc[%d] otherAcc[%d]", new Object[] { boQ(), Long.valueOf(bt.aO(l2)), Long.valueOf(this.oTT), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(this.oTU), Long.valueOf(this.oTV) });
        d.bZI();
        l2 = d.bZJ();
        d.bZI();
        long l4 = d.bZK();
        i = (int)(this.oTT * 100L / l2);
        j = (int)(this.oTU * 100L / this.oTT);
        int k = (int)(this.oTV * 100L / this.oTT);
        long l5 = this.oTT - this.oTU - this.oTV;
        int m = (int)(100L * l5 / this.oTT);
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append(this.cacheSize).append(",");
        ((StringBuffer)localObject1).append(this.oTT).append(",");
        ((StringBuffer)localObject1).append(i).append(",");
        ((StringBuffer)localObject1).append(l2 - l4).append(",");
        ((StringBuffer)localObject1).append(l4).append(",");
        ((StringBuffer)localObject1).append(l2).append(",");
        ((StringBuffer)localObject1).append(l3).append(",");
        ((StringBuffer)localObject1).append(this.oTU).append(",");
        ((StringBuffer)localObject1).append(j).append(",");
        ((StringBuffer)localObject1).append(this.oTV).append(",");
        ((StringBuffer)localObject1).append(k).append(",");
        ((StringBuffer)localObject1).append(l5).append(",");
        ((StringBuffer)localObject1).append(m).append(",");
        ((StringBuffer)localObject1).append("0");
        localObject1 = ((StringBuffer)localObject1).toString();
        ad.i("MicroMsg.CleanCalcLogic", "rpt content %s， data:%d", new Object[] { localObject1, Long.valueOf(l1) });
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(14762, (String)localObject1);
        d.bZI().oUj = this.oTT;
        d.bZI().dataSize = l1;
        d.bZI().oTU = (this.oTU + l3);
        d.bZI().cacheSize = this.cacheSize;
        d.bZI().oTV = this.oTV;
        d.bZI().oUk = this.oTW;
        d.bZI().oUl = localHashSet;
        d.bZI().owa = this.oTZ;
        if (this.oTY != null) {
          this.oTY.j(this.oTT, l3 + this.oTU, this.cacheSize);
        }
        stop();
        AppMethodBeat.o(22763);
        return;
      }
    } while (bt.isNullOrNil(str));
    if ((str.endsWith("/sns/")) || (str.endsWith("/music")) || (str.equals(localObject1))) {
      this.oTZ.add(str);
    }
    for (long l1 = I(new File(str));; l1 = H(new File(str)))
    {
      this.oTW.put(str, Long.valueOf(l1));
      ad.d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", new Object[] { boQ(), str, Long.valueOf(l1) });
      this.oTT += l1;
      if (localHashSet.contains(str)) {
        this.oTV = (l1 + this.oTV);
      }
      i += 1;
      if (this.oTY != null) {
        this.oTY.eZ(i, j);
      }
      break;
    }
  }
  
  public final void stop()
  {
    this.isStop = true;
    this.oTY = null;
  }
  
  public static abstract interface a
  {
    public abstract void eZ(int paramInt1, int paramInt2);
    
    public abstract void j(long paramLong1, long paramLong2, long paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.a
 * JD-Core Version:    0.7.0.1
 */