package com.tencent.mm.as;

import android.os.HandlerThread;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public final class i
  implements com.tencent.mm.ah.f, com.tencent.mm.ah.g
{
  private static Set<Integer> eoB = new HashSet();
  private Queue<e> bDS = new LinkedList();
  private boolean bDW = false;
  private boolean bDX = false;
  int bDY = 0;
  private long bDZ = 0L;
  g.a bEc = new g.a();
  private am bEd;
  private LinkedList<l> eoC = new LinkedList();
  public i.a eoD = null;
  private boolean eoE = false;
  private l.a eoF = new i.1(this);
  
  public i()
  {
    com.tencent.mm.kernel.g.DQ();
    this.bEd = new am(com.tencent.mm.kernel.g.DS().mnU.getLooper(), new i.5(this), false);
    if (com.tencent.mm.kernel.g.DO().dJT != null) {
      com.tencent.mm.kernel.g.DO().dJT.a(110, this);
    }
    this.eoC.clear();
    this.eoE = false;
  }
  
  private void a(l paraml)
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new i.2(this, paraml));
  }
  
  public static boolean iJ(int paramInt)
  {
    return eoB.add(Integer.valueOf(paramInt));
  }
  
  public static boolean iK(int paramInt)
  {
    return eoB.remove(Integer.valueOf(paramInt));
  }
  
  public static void iL(int paramInt)
  {
    y.w("MicroMsg.ImgService", "setImgError, %d", new Object[] { Integer.valueOf(paramInt) });
    e locale = o.OJ().iH(paramInt);
    if ((locale == null) || (locale.enp <= 0L)) {}
    for (;;)
    {
      return;
      Object localObject = o.OJ().iI((int)locale.enp);
      if (localObject != null)
      {
        ((e)localObject).setStatus(-1);
        ((e)localObject).bcw = 264;
        o.OJ().a((int)((e)localObject).enp, (e)localObject);
      }
      for (localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(((e)localObject).enx); ((cs)localObject).field_msgId == locale.enx; localObject = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(locale.enx))
      {
        ((bi)localObject).setStatus(5);
        com.tencent.mm.plugin.report.f.nEG.a(111L, 31L, 1L, true);
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a((int)((cs)localObject).field_msgId, (bi)localObject);
        return;
        locale.setStatus(-1);
        locale.bcw = 264;
        o.OJ().a(paramInt, locale);
      }
    }
  }
  
  private void uB()
  {
    this.bDS.clear();
    this.bDX = false;
    y.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.bEc.zJ());
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    paramm = (l)paramm;
    if ((this.eoD != null) && (paramm != null) && (paramm.bFH != null)) {
      this.eoD.b(paramm.bFH.field_msgId, paramInt1, paramInt2);
    }
  }
  
  public final void a(String paramString1, String paramString2, ArrayList<String> paramArrayList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (q.g(str, paramString2, paramBoolean)) {}
      for (int i = 1;; i = 0)
      {
        y.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i) });
        a(new l(paramString1, paramString2, str, i, this, paramInt1, this.eoF, paramInt2));
        break;
      }
    }
  }
  
  public final void a(ArrayList<Integer> paramArrayList, String paramString1, String paramString2, ArrayList<String> paramArrayList1, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Iterator localIterator = paramArrayList1.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int k = ((Integer)paramArrayList.get(i)).intValue();
      if (q.g(str, paramString2, paramBoolean)) {}
      for (int j = 1;; j = 0)
      {
        paramArrayList1 = "";
        e locale = o.OJ().iH(k);
        if (locale != null) {
          paramArrayList1 = locale.enA;
        }
        paramArrayList1 = new l(k, paramString1, paramString2, str, j, this, paramInt1, paramArrayList1, "", paramInt2);
        paramArrayList1.epl = new l.b(paramArrayList1, this.eoF);
        a(paramArrayList1);
        i += 1;
        break;
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    i.a locala;
    long l;
    if ((paramm instanceof l))
    {
      paramString = (l)paramm;
      if ((this.eoD != null) && (paramString != null) && (paramString.bFH != null))
      {
        locala = this.eoD;
        l = paramString.bFH.field_msgId;
        if (paramString.bFH.field_status == 5) {
          break label124;
        }
      }
    }
    label124:
    for (boolean bool = true;; bool = false)
    {
      locala.h(l, bool);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DS().O(new i.3(this, paramm));
      return;
    }
  }
  
  public final void run()
  {
    com.tencent.mm.kernel.g.DQ();
    com.tencent.mm.kernel.g.DS().O(new i.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.as.i
 * JD-Core Version:    0.7.0.1
 */