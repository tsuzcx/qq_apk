package com.tencent.mm.plugin.clean.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
  private static final Long ddR;
  private static final Long pau;
  private long cacheSize;
  private boolean isStop;
  List<Runnable> oCC;
  private a paA;
  LinkedList<String> paB;
  private long pav;
  private long paw;
  private long pax;
  private HashMap<String, Long> pay;
  private HashSet<String> paz;
  
  static
  {
    AppMethodBeat.i(22768);
    ddR = Long.valueOf(604800000L);
    pau = Long.valueOf(7776000000L);
    AppMethodBeat.o(22768);
  }
  
  public a(a parama)
  {
    AppMethodBeat.i(186433);
    this.isStop = false;
    this.paB = new LinkedList();
    this.oCC = new ArrayList();
    this.isStop = false;
    this.paA = parama;
    this.pay = new HashMap();
    this.paz = new HashSet();
    AppMethodBeat.o(186433);
  }
  
  private long H(File paramFile)
  {
    AppMethodBeat.i(186434);
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
            AppMethodBeat.o(186434);
            return -1L;
          }
          l1 += l2;
          i += 1;
        }
        AppMethodBeat.o(186434);
        return l1;
      }
    }
    long l1 = paramFile.length();
    AppMethodBeat.o(186434);
    return l1;
  }
  
  private long I(File paramFile)
  {
    AppMethodBeat.i(186436);
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
        AppMethodBeat.o(186436);
        return l;
      }
    }
    else
    {
      this.cacheSize += paramFile.length();
      l = paramFile.length();
      AppMethodBeat.o(186436);
      return l;
    }
    this.cacheSize += paramFile.length();
    long l = paramFile.length();
    AppMethodBeat.o(186436);
    return l;
  }
  
  private int a(HashSet<String> paramHashSet1, HashSet<String> paramHashSet2)
  {
    AppMethodBeat.i(186435);
    Object localObject1 = new HashSet();
    HashSet localHashSet = new HashSet();
    int k;
    Object localObject2;
    File[] arrayOfFile;
    int j;
    int i;
    label274:
    Object localObject3;
    if (com.tencent.mm.loader.j.b.asd().equals(com.tencent.mm.loader.j.b.ase()))
    {
      ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.asj());
      localHashSet.add(com.tencent.mm.loader.j.b.asj() + com.tencent.mm.kernel.g.ajR().gDW + File.separator);
      localHashSet.add(com.tencent.mm.loader.j.b.asj() + com.tencent.mm.kernel.g.ajR().gDU + File.separator);
      ae.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path SDCARD_ROOT[%s] DEFAULT_SDCARD_ROOT[%s], acc[%s], oldacc[%s]", new Object[] { bpA(), com.tencent.mm.loader.j.b.asd(), com.tencent.mm.loader.j.b.ase(), com.tencent.mm.kernel.g.ajR().gDW, com.tencent.mm.kernel.g.ajR().gDU });
      k = 1;
      localObject2 = com.tencent.mm.loader.j.b.asd() + "/Cache/";
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
      ae.d("MicroMsg.CleanCalcLogic", "%s getMicroMsgPaths filePath[%s]", new Object[] { bpA(), ((File)localObject3).getAbsolutePath() });
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
      bc.aCg();
      paramHashSet1.add(c.azV());
      bc.aCg();
      paramHashSet1.add(c.getAccSnsPath());
      bc.aCg();
      paramHashSet1.add(c.aAa());
    }
    for (;;)
    {
      j += 1;
      break label274;
      localObject2 = new File(com.tencent.mm.loader.j.b.asd() + File.separator);
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
          ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.asd() + File.separator);
        }
      }
      ((HashSet)localObject1).add(com.tencent.mm.loader.j.b.asi());
      localHashSet.add(com.tencent.mm.loader.j.b.asj() + com.tencent.mm.kernel.g.ajR().gDW + File.separator);
      localHashSet.add(com.tencent.mm.loader.j.b.asj() + com.tencent.mm.kernel.g.ajR().gDU + File.separator);
      localHashSet.add(com.tencent.mm.loader.j.b.asi() + com.tencent.mm.kernel.g.ajR().gDW + File.separator);
      localHashSet.add(com.tencent.mm.loader.j.b.asi() + com.tencent.mm.kernel.g.ajR().gDU + File.separator);
      break;
      label780:
      localObject1 = (String)localObject3 + File.separator + "music";
      break label411;
      label811:
      paramHashSet2.add(localObject3);
      paramHashSet1.add(localObject3);
      i += 1;
      this.paz.add(localObject1);
      continue;
      label842:
      paramHashSet1.add(localObject3);
      i += 1;
      continue;
      label856:
      paramHashSet1.add(((File)localObject3).getAbsolutePath());
      i += 1;
    }
    AppMethodBeat.o(186435);
    return k;
  }
  
  private String bpA()
  {
    AppMethodBeat.i(22762);
    String str = hashCode();
    AppMethodBeat.o(22762);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(22763);
    long l2 = bu.HQ();
    if (this.isStop)
    {
      ae.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[] { bpA() });
      AppMethodBeat.o(22763);
      return;
    }
    Object localObject2 = new HashSet();
    HashSet localHashSet = new HashSet();
    a((HashSet)localObject2, localHashSet);
    Object localObject1 = com.tencent.mm.loader.j.b.asd() + "/Cache/";
    int j = ((HashSet)localObject2).size();
    localObject2 = ((HashSet)localObject2).iterator();
    int i = 0;
    String str;
    label800:
    do
    {
      if (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        if (!this.isStop) {
          break label800;
        }
        ae.e("MicroMsg.CleanCalcLogic", "run stop.");
      }
      while (i >= j)
      {
        this.paw = com.tencent.mm.plugin.f.b.bUj().bUk().bUs();
        this.pav += this.paw;
        l1 = H(new File(com.tencent.mm.loader.j.b.asa()));
        if (this.pav <= 0L)
        {
          this.pav = 1L;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(714L, 60L, 1L, false);
        }
        com.tencent.mm.kernel.g.ajS();
        long l3 = o.aZR(com.tencent.mm.kernel.g.ajR().ajy());
        ae.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] dataSize[%d] dbSize[%d], acc[%d] otherAcc[%d]", new Object[] { bpA(), Long.valueOf(bu.aO(l2)), Long.valueOf(this.pav), Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(this.paw), Long.valueOf(this.pax) });
        d.caX();
        l2 = d.caY();
        d.caX();
        long l4 = d.caZ();
        i = (int)(this.pav * 100L / l2);
        j = (int)(this.paw * 100L / this.pav);
        int k = (int)(this.pax * 100L / this.pav);
        long l5 = this.pav - this.paw - this.pax;
        int m = (int)(100L * l5 / this.pav);
        localObject1 = new StringBuffer();
        ((StringBuffer)localObject1).append(this.cacheSize).append(",");
        ((StringBuffer)localObject1).append(this.pav).append(",");
        ((StringBuffer)localObject1).append(i).append(",");
        ((StringBuffer)localObject1).append(l2 - l4).append(",");
        ((StringBuffer)localObject1).append(l4).append(",");
        ((StringBuffer)localObject1).append(l2).append(",");
        ((StringBuffer)localObject1).append(l3).append(",");
        ((StringBuffer)localObject1).append(this.paw).append(",");
        ((StringBuffer)localObject1).append(j).append(",");
        ((StringBuffer)localObject1).append(this.pax).append(",");
        ((StringBuffer)localObject1).append(k).append(",");
        ((StringBuffer)localObject1).append(l5).append(",");
        ((StringBuffer)localObject1).append(m).append(",");
        ((StringBuffer)localObject1).append("0");
        localObject1 = ((StringBuffer)localObject1).toString();
        ae.i("MicroMsg.CleanCalcLogic", "rpt content %s， data:%d", new Object[] { localObject1, Long.valueOf(l1) });
        this.oCC.add(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186432);
            ((f)com.tencent.mm.kernel.g.ab(f.class)).aYV();
            AppMethodBeat.o(186432);
          }
        });
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(14762, (String)localObject1);
        d.caX().paM = this.pav;
        d.caX().dataSize = l1;
        d.caX().paw = (this.paw + l3);
        d.caX().cacheSize = this.cacheSize;
        d.caX().pax = this.pax;
        d.caX().paN = this.pay;
        d.caX().paO = localHashSet;
        d.caX().oCB = this.paB;
        d.caX().oCC = this.oCC;
        if (this.paA != null) {
          this.paA.j(this.pav, l3 + this.paw, this.cacheSize);
        }
        stop();
        AppMethodBeat.o(22763);
        return;
      }
    } while (bu.isNullOrNil(str));
    if ((str.endsWith("/sns/")) || (str.endsWith("/music")) || (str.equals(localObject1))) {
      this.paB.add(str);
    }
    for (long l1 = I(new File(str));; l1 = H(new File(str)))
    {
      this.pay.put(str, Long.valueOf(l1));
      ae.d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", new Object[] { bpA(), str, Long.valueOf(l1) });
      this.pav += l1;
      if (localHashSet.contains(str)) {
        this.pax = (l1 + this.pax);
      }
      i += 1;
      if (this.paA != null) {
        this.paA.fa(i, j);
      }
      break;
    }
  }
  
  public final void stop()
  {
    this.isStop = true;
    this.paA = null;
  }
  
  public static abstract interface a
  {
    public abstract void fa(int paramInt1, int paramInt2);
    
    public abstract void j(long paramLong1, long paramLong2, long paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.a
 * JD-Core Version:    0.7.0.1
 */