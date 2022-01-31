package com.tencent.mm.plugin.clean.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class a
  implements Runnable
{
  private static final Long iBi = Long.valueOf(604800000L);
  private static final Long iBj = Long.valueOf(7776000000L);
  private long iBk;
  private long iBl;
  private long iBm;
  private long iBn;
  private HashMap<String, Long> iBo;
  private HashSet<String> iBp;
  private c iBq;
  private boolean isStop = false;
  
  public a(c paramc)
  {
    this.iBq = paramc;
    this.iBo = new HashMap();
    this.iBp = new HashSet();
  }
  
  private int a(List<String> paramList, HashSet<String> paramHashSet)
  {
    String str1 = g.DP().dKs;
    String str2 = g.DP().dKt;
    y.i("MicroMsg.CleanCalcLogic", "%s get MicroMsg path root[%s] acc[%s]", new Object[] { ayL(), str1, str2 });
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
          y.d("MicroMsg.CleanCalcLogic", "%s sub file path[%s] sub[%s]", new Object[] { ayL(), str3, localObject });
          if (new com.tencent.mm.vfs.b(str3).isDirectory()) {
            if (((String)localObject).length() >= 32) {
              if (!bk.isEqual(str2, str3))
              {
                paramHashSet.add(str3);
                paramList.add(str3);
                i += 1;
                this.iBp.add(localObject);
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
              au.Hx();
              paramList.add(com.tencent.mm.model.c.FL());
              au.Hx();
              paramList.add(com.tencent.mm.model.c.getAccSnsPath());
              au.Hx();
              paramList.add(com.tencent.mm.model.c.FQ());
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
    return k;
  }
  
  private String ayL()
  {
    return hashCode();
  }
  
  private long zm(String paramString)
  {
    Object localObject = new com.tencent.mm.vfs.b(paramString);
    if (((com.tencent.mm.vfs.b)localObject).isDirectory())
    {
      String[] arrayOfString = ((com.tencent.mm.vfs.b)localObject).list();
      if (arrayOfString != null)
      {
        long l1 = 0L;
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
            l2 = zm((String)localObject);
            if (l2 != -1L) {
              break;
            }
            return -1L;
            localObject = "/" + (String)localObject;
          }
          l1 += l2;
          i += 1;
        }
        return l1;
      }
    }
    return ((com.tencent.mm.vfs.b)localObject).length();
  }
  
  private long zn(String paramString)
  {
    long l1 = 0L;
    int i = 0;
    Object localObject = new com.tencent.mm.vfs.b(paramString);
    long l2;
    if (((com.tencent.mm.vfs.b)localObject).isDirectory())
    {
      localObject = ((com.tencent.mm.vfs.b)localObject).list();
      if (localObject != null)
      {
        int j = localObject.length;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          String str = localObject[i];
          l1 += zn(paramString + "/" + str);
          i += 1;
        }
      }
    }
    else if (System.currentTimeMillis() - ((com.tencent.mm.vfs.b)localObject).lastModified() > iBi.longValue())
    {
      y.i("MicroMsg.CleanCalcLogic", "Clean 7 days file in sns rootPath=%s", new Object[] { paramString });
      long l3 = com.tencent.mm.vfs.e.aeQ(paramString);
      l2 = l1;
      if (((com.tencent.mm.vfs.b)localObject).delete())
      {
        this.iBn += l3;
        l2 = l1;
      }
      return l2;
    }
    return com.tencent.mm.vfs.e.aeQ(paramString);
  }
  
  private long zo(String paramString)
  {
    long l1 = 0L;
    int i = 0;
    Object localObject = new com.tencent.mm.vfs.b(paramString);
    long l2;
    if (((com.tencent.mm.vfs.b)localObject).isDirectory())
    {
      localObject = ((com.tencent.mm.vfs.b)localObject).list();
      if (localObject != null)
      {
        int j = localObject.length;
        for (;;)
        {
          l2 = l1;
          if (i >= j) {
            break;
          }
          String str = localObject[i];
          l1 += zo(paramString + "/" + str);
          i += 1;
        }
      }
    }
    else if (System.currentTimeMillis() - ((com.tencent.mm.vfs.b)localObject).lastModified() > iBj.longValue())
    {
      y.i("MicroMsg.CleanCalcLogic", "Clean 90 days file in music rootPath=%s", new Object[] { paramString });
      long l3 = com.tencent.mm.vfs.e.aeQ(paramString);
      l2 = l1;
      if (((com.tencent.mm.vfs.b)localObject).delete())
      {
        this.iBn += l3;
        l2 = l1;
      }
      return l2;
    }
    return com.tencent.mm.vfs.e.aeQ(paramString);
  }
  
  public final void run()
  {
    long l2 = bk.UZ();
    if (this.isStop)
    {
      y.i("MicroMsg.CleanCalcLogic", "%s start run but stop", new Object[] { ayL() });
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
      if (!bk.bl(str))
      {
        if (str.endsWith("/sns/")) {
          l1 = zn(str);
        }
        for (;;)
        {
          this.iBo.put(str, Long.valueOf(l1));
          y.d("MicroMsg.CleanCalcLogic", "%s path[%s] size[%d]", new Object[] { ayL(), str, Long.valueOf(l1) });
          this.iBk += l1;
          if (localHashSet.contains(str)) {
            this.iBm = (l1 + this.iBm);
          }
          i += 1;
          if (this.iBq != null) {
            this.iBq.cy(i, j);
          }
          break;
          if (str.endsWith("/music")) {
            l1 = zo(str);
          } else {
            l1 = zm(str);
          }
        }
      }
    }
    this.iBl = com.tencent.mm.plugin.h.b.ayE().ayF().ayO();
    this.iBk += this.iBl;
    if (this.iBk <= 0L)
    {
      this.iBk = 1L;
      h.nFQ.a(714L, 60L, 1L, false);
    }
    y.i("MicroMsg.CleanCalcLogic", "%s scan finish cost[%d] micromsg[%d] acc[%d] otherAcc[%d]", new Object[] { ayL(), Long.valueOf(bk.cp(l2)), Long.valueOf(this.iBk), Long.valueOf(this.iBl), Long.valueOf(this.iBm) });
    localObject = this.iBp;
    if (this.iBq != null) {
      this.iBq.a(this.iBk, this.iBl, this.iBm, (HashSet)localObject, this.iBo);
    }
    j.aEb();
    long l1 = j.aDI();
    j.aEb();
    l2 = j.aDJ();
    i = (int)(this.iBk * 100L / l1);
    j = (int)(this.iBl * 100L / this.iBk);
    int k = (int)(this.iBm * 100L / this.iBk);
    long l3 = this.iBk - this.iBl - this.iBm;
    int m = (int)(100L * l3 / this.iBk);
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iBn).append(",");
    ((StringBuffer)localObject).append(this.iBk).append(",");
    ((StringBuffer)localObject).append(i).append(",");
    ((StringBuffer)localObject).append(l1 - l2).append(",");
    ((StringBuffer)localObject).append(l2).append(",");
    ((StringBuffer)localObject).append(l1).append(",");
    ((StringBuffer)localObject).append(this.iBl).append(",");
    ((StringBuffer)localObject).append(j).append(",");
    ((StringBuffer)localObject).append(this.iBm).append(",");
    ((StringBuffer)localObject).append(k).append(",");
    ((StringBuffer)localObject).append(l3).append(",");
    ((StringBuffer)localObject).append(m);
    localObject = ((StringBuffer)localObject).toString();
    y.i("MicroMsg.CleanCalcLogic", "rpt content %s", new Object[] { localObject });
    h.nFQ.aC(14762, (String)localObject);
    stop();
  }
  
  public final void stop()
  {
    this.isStop = true;
    this.iBq = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.b.a
 * JD-Core Version:    0.7.0.1
 */