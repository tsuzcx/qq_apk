package com.tencent.mm.plugin.clean.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class a
  implements Runnable
{
  private static final Long cfe;
  private static final Long kGq;
  private boolean isStop;
  private long kGr;
  private long kGs;
  private long kGt;
  private long kGu;
  private HashMap<String, Long> kGv;
  private HashSet<String> kGw;
  private c kGx;
  
  static
  {
    AppMethodBeat.i(18659);
    cfe = Long.valueOf(604800000L);
    kGq = Long.valueOf(7776000000L);
    AppMethodBeat.o(18659);
  }
  
  public a(c paramc)
  {
    AppMethodBeat.i(18652);
    this.isStop = false;
    this.isStop = false;
    this.kGx = paramc;
    this.kGv = new HashMap();
    this.kGw = new HashSet();
    AppMethodBeat.o(18652);
  }
  
  private long Jc(String paramString)
  {
    AppMethodBeat.i(18655);
    Object localObject = new com.tencent.mm.vfs.b(paramString);
    if (((com.tencent.mm.vfs.b)localObject).isDirectory())
    {
      String[] arrayOfString = ((com.tencent.mm.vfs.b)localObject).list();
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
            l2 = Jc((String)localObject);
            if (l2 != -1L) {
              break;
            }
            AppMethodBeat.o(18655);
            return -1L;
            localObject = "/".concat(String.valueOf(localObject));
          }
          l1 += l2;
          i += 1;
        }
        AppMethodBeat.o(18655);
        return l1;
      }
    }
    long l1 = ((com.tencent.mm.vfs.b)localObject).length();
    AppMethodBeat.o(18655);
    return l1;
  }
  
  private long Jd(String paramString)
  {
    long l = 0L;
    int i = 0;
    AppMethodBeat.i(18657);
    Object localObject = new com.tencent.mm.vfs.b(paramString);
    if (((com.tencent.mm.vfs.b)localObject).isDirectory())
    {
      localObject = ((com.tencent.mm.vfs.b)localObject).list();
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          String str = localObject[i];
          l += Jd(paramString + "/" + str);
          i += 1;
        }
        AppMethodBeat.o(18657);
        return l;
      }
    }
    else if (System.currentTimeMillis() - ((com.tencent.mm.vfs.b)localObject).lastModified() > cfe.longValue())
    {
      ab.i("MicroMsg.CleanCalcLogic", "Clean 7 days file in sns rootPath=%s", new Object[] { paramString });
      l = com.tencent.mm.vfs.e.avI(paramString);
      if (((com.tencent.mm.vfs.b)localObject).delete()) {
        this.kGu += l;
      }
      AppMethodBeat.o(18657);
      return 0L;
    }
    l = com.tencent.mm.vfs.e.avI(paramString);
    AppMethodBeat.o(18657);
    return l;
  }
  
  private long Je(String paramString)
  {
    long l = 0L;
    int i = 0;
    AppMethodBeat.i(18658);
    Object localObject = new com.tencent.mm.vfs.b(paramString);
    if (((com.tencent.mm.vfs.b)localObject).isDirectory())
    {
      localObject = ((com.tencent.mm.vfs.b)localObject).list();
      if (localObject != null)
      {
        int j = localObject.length;
        while (i < j)
        {
          String str = localObject[i];
          l += Je(paramString + "/" + str);
          i += 1;
        }
        AppMethodBeat.o(18658);
        return l;
      }
    }
    else if (System.currentTimeMillis() - ((com.tencent.mm.vfs.b)localObject).lastModified() > kGq.longValue())
    {
      ab.i("MicroMsg.CleanCalcLogic", "Clean 90 days file in music rootPath=%s", new Object[] { paramString });
      l = com.tencent.mm.vfs.e.avI(paramString);
      if (((com.tencent.mm.vfs.b)localObject).delete()) {
        this.kGu += l;
      }
      AppMethodBeat.o(18658);
      return 0L;
    }
    l = com.tencent.mm.vfs.e.avI(paramString);
    AppMethodBeat.o(18658);
    return l;
  }
  
  private int a(List<String> paramList, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(18656);
    String str1 = g.RL().eHQ;
    String str2 = g.RL().eHR;
    ab.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path root[%s] acc[%s]", new Object[] { bas(), str1, str2 });
    int j = 0;
    int i = 0;
    Object localObject = new com.tencent.mm.vfs.b(str1);
    int k = j;
    if (((com.tencent.mm.vfs.b)localObject).isDirectory())
    {
      String[] arrayOfString = ((com.tencent.mm.vfs.b)localObject).list();
      k = j;
      if (arrayOfString != null)
      {
        int m = arrayOfString.length;
        j = 0;
        k = i;
        if (j < m)
        {
          localObject = arrayOfString[j];
          String str3 = str1 + (String)localObject + "/";
          ab.d("MicroMsg.CleanCalcLogic", "%s sub file path[%s] sub[%s]", new Object[] { bas(), str3, localObject });
          if (new com.tencent.mm.vfs.b(str3).isDirectory()) {
            if (((String)localObject).length() >= 32) {
              if (!bo.isEqual(str2, str3))
              {
                paramHashSet.add(str3);
                paramList.add(str3);
                i += 1;
                this.kGw.add(localObject);
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
              aw.aaz();
              paramList.add(com.tencent.mm.model.c.YP());
              aw.aaz();
              paramList.add(com.tencent.mm.model.c.getAccSnsPath());
              aw.aaz();
              paramList.add(com.tencent.mm.model.c.YU());
              break;
            }
            paramList.add(str3);
            i += 1;
            continue;
            paramList.add(str3);
            i += 1;
          }
        }
      }
    }
    AppMethodBeat.o(18656);
    return k;
  }
  
  private String bas()
  {
    AppMethodBeat.i(18653);
    String str = hashCode();
    AppMethodBeat.o(18653);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(18654);
    long l2 = bo.yB();
    if (this.isStop)
    {
      ab.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[] { bas() });
      AppMethodBeat.o(18654);
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
      if (!bo.isNullOrNil(str))
      {
        if (str.endsWith("/sns/")) {
          l1 = Jd(str);
        }
        for (;;)
        {
          this.kGv.put(str, Long.valueOf(l1));
          ab.d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", new Object[] { bas(), str, Long.valueOf(l1) });
          this.kGr += l1;
          if (localHashSet.contains(str)) {
            this.kGt = (l1 + this.kGt);
          }
          i += 1;
          if (this.kGx != null) {
            this.kGx.dW(i, j);
          }
          break;
          if (str.endsWith("/music")) {
            l1 = Je(str);
          } else {
            l1 = Jc(str);
          }
        }
      }
    }
    this.kGs = com.tencent.mm.plugin.f.b.bak().bal().bav();
    this.kGr += this.kGs;
    if (this.kGr <= 0L)
    {
      this.kGr = 1L;
      h.qsU.idkeyStat(714L, 60L, 1L, false);
    }
    ab.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] acc[%d] otherAcc[%d]", new Object[] { bas(), Long.valueOf(bo.av(l2)), Long.valueOf(this.kGr), Long.valueOf(this.kGs), Long.valueOf(this.kGt) });
    localObject = this.kGw;
    if (this.kGx != null) {
      this.kGx.a(this.kGr, this.kGs, this.kGt, (HashSet)localObject, this.kGv);
    }
    j.bhb();
    long l1 = j.bgJ();
    j.bhb();
    l2 = j.bgK();
    i = (int)(this.kGr * 100L / l1);
    j = (int)(this.kGs * 100L / this.kGr);
    int k = (int)(this.kGt * 100L / this.kGr);
    long l3 = this.kGr - this.kGs - this.kGt;
    int m = (int)(100L * l3 / this.kGr);
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.kGu).append(",");
    ((StringBuffer)localObject).append(this.kGr).append(",");
    ((StringBuffer)localObject).append(i).append(",");
    ((StringBuffer)localObject).append(l1 - l2).append(",");
    ((StringBuffer)localObject).append(l2).append(",");
    ((StringBuffer)localObject).append(l1).append(",");
    ((StringBuffer)localObject).append(this.kGs).append(",");
    ((StringBuffer)localObject).append(j).append(",");
    ((StringBuffer)localObject).append(this.kGt).append(",");
    ((StringBuffer)localObject).append(k).append(",");
    ((StringBuffer)localObject).append(l3).append(",");
    ((StringBuffer)localObject).append(m);
    localObject = ((StringBuffer)localObject).toString();
    ab.i("MicroMsg.CleanCalcLogic", "rpt content %s", new Object[] { localObject });
    h.qsU.kvStat(14762, (String)localObject);
    stop();
    AppMethodBeat.o(18654);
  }
  
  public final void stop()
  {
    this.isStop = true;
    this.kGx = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.a
 * JD-Core Version:    0.7.0.1
 */