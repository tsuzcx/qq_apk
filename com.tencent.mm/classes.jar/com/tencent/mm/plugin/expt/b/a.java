package com.tencent.mm.plugin.expt.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.h.a.ey;
import com.tencent.mm.h.b.a.ax;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.expt.c.d;
import com.tencent.mm.plugin.expt.ui.ExptDebugUI;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.a.a
{
  private static a jIh;
  private int dDr = 0;
  private int ebR = 0;
  public d jIi;
  public com.tencent.mm.plugin.expt.c.c jIj;
  private com.tencent.mm.a.f<Integer, com.tencent.mm.plugin.expt.c.a> jIk = new com.tencent.mm.a.f(20);
  private com.tencent.mm.a.f<String, Integer> jIl = new com.tencent.mm.a.f(20);
  private int jIm = 0;
  private com.tencent.mm.sdk.b.c jIn = new a.1(this);
  private n jIo = new a.2(this);
  private com.tencent.mm.ah.f jIp = new a.3(this);
  
  private String a(a.a parama, String paramString)
  {
    if (parama == null) {
      return paramString;
    }
    long l = bk.UZ();
    String str = parama.name();
    Object localObject1 = (Integer)this.jIl.get(str);
    int i;
    if (localObject1 != null) {
      i = ((Integer)localObject1).intValue();
    }
    for (;;)
    {
      localObject1 = new ax();
      Object localObject2 = a(i, true, (ax)localObject1);
      if ((localObject2 == null) || (((HashMap)localObject2).size() <= 0)) {
        break;
      }
      localObject2 = (String)((HashMap)localObject2).get(str);
      if (!bk.bl((String)localObject2))
      {
        ((ax)localObject1).cqD = str;
        ((ax)localObject1).cqE = ((String)localObject2);
        ((ax)localObject1).QX();
      }
      y.i("MicroMsg.ExptService", "API Got Expt result[%s] exptId[%d] key[%s %s] defStr[%s] cost[%d]", new Object[] { localObject2, Integer.valueOf(i), parama, str, paramString, Long.valueOf(bk.cp(l)) });
      if (bk.bl((String)localObject2)) {
        break;
      }
      return localObject2;
      i = this.jIj.BY(str);
      if (i > 0) {
        this.jIl.put(str, Integer.valueOf(i));
      }
    }
  }
  
  public static a aMZ()
  {
    if (jIh == null) {
      jIh = new a();
    }
    return jIh;
  }
  
  protected static void aNa()
  {
    com.tencent.mm.sdk.b.a.udP.m(new ey());
  }
  
  public static void aNb()
  {
    g.Dk().a(new b(), 0);
  }
  
  public final void BW(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.ExptService", "receive expt xml but content is null");
      return;
    }
    com.tencent.mm.plugin.expt.c.a locala = new com.tencent.mm.plugin.expt.c.a();
    ArrayList localArrayList;
    boolean bool;
    if (locala.BX(paramString)) {
      if (locala.field_exptSeq < 0)
      {
        h.nFQ.a(863L, 3L, 1L, false);
        localArrayList = new ArrayList();
        localArrayList.add(Integer.valueOf(locala.field_exptId));
        if (bh(localArrayList) > 0)
        {
          bool = true;
          aNa();
        }
      }
    }
    for (;;)
    {
      y.i("MicroMsg.ExptService", "received expt xml dbFlag[%b] [%s] ", new Object[] { Boolean.valueOf(bool), paramString });
      return;
      bool = false;
      break;
      h.nFQ.a(863L, 4L, 1L, false);
      localArrayList = new ArrayList();
      localArrayList.add(locala);
      if (bg(localArrayList) > 0)
      {
        bool = true;
        break;
      }
      bool = false;
      break;
      bool = false;
    }
  }
  
  public final int a(a.a parama)
  {
    parama = a(parama, "");
    if (bk.bl(parama)) {
      return 10;
    }
    return bk.getInt(parama, 10);
  }
  
  public final HashMap<String, String> a(int paramInt, boolean paramBoolean, ax paramax)
  {
    if (this.jIi == null)
    {
      y.e("MicroMsg.ExptService", "Expt service is not init here! exptId[%d]", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    long l1 = bk.UZ();
    Object localObject2 = null;
    Object localObject3 = null;
    com.tencent.mm.plugin.expt.c.a locala = qB(paramInt);
    Object localObject1;
    if ((locala == null) || (bk.bl(locala.field_exptContent)))
    {
      y.w("MicroMsg.ExptService", "expt item is null or expt content is null.");
      localObject1 = localObject2;
      paramax = localObject3;
      if (localObject1 == null) {
        break label356;
      }
    }
    label287:
    label356:
    for (localObject2 = localObject1;; localObject2 = Integer.valueOf(0))
    {
      y.i("MicroMsg.ExptService", "get expt [%d] map[%s] expt[%s] cost[%d]", new Object[] { Integer.valueOf(paramInt), localObject2, paramax, Long.valueOf(bk.cp(l1)) });
      return localObject1;
      localObject1 = locala.field_exptContent;
      if (paramBoolean)
      {
        boolean bool = false;
        if (locala.field_exptSeq < 0) {
          paramBoolean = false;
        }
        for (;;)
        {
          y.d("MicroMsg.ExptItem", "expt item is ready[%b] [%s]", new Object[] { Boolean.valueOf(paramBoolean), locala.toString() });
          if (paramBoolean) {
            break label287;
          }
          y.w("MicroMsg.ExptService", "expt time is invalid time[%d %d] seq[%d]", new Object[] { Long.valueOf(locala.field_startTime), Long.valueOf(locala.field_endTime), Integer.valueOf(locala.field_exptSeq) });
          paramax = (ax)localObject1;
          localObject1 = localObject2;
          break;
          long l2 = bk.UX();
          paramBoolean = bool;
          if (l2 >= locala.field_startTime) {
            if (locala.field_endTime > 0L)
            {
              paramBoolean = bool;
              if (l2 > locala.field_endTime) {}
            }
            else
            {
              paramBoolean = true;
            }
          }
        }
      }
      localObject2 = locala.aNj();
      if (paramax != null)
      {
        paramax.cqz = locala.field_exptId;
        paramax.cqA = locala.field_groupId;
        paramax.cqB = locala.field_exptSeq;
        paramax.aX(locala.field_startTime).aY(locala.field_endTime);
      }
      paramax = (ax)localObject1;
      localObject1 = localObject2;
      break;
    }
  }
  
  public final boolean a(a.a parama, boolean paramBoolean)
  {
    parama = a(parama, "");
    if (bk.bl(parama)) {
      return paramBoolean;
    }
    if (paramBoolean) {}
    for (int i = 1; bk.getInt(parama, i) != 0; i = 0) {
      return true;
    }
    return false;
  }
  
  final void aMY()
  {
    try
    {
      this.jIk.clear();
      this.jIl.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int bg(List<com.tencent.mm.plugin.expt.c.a> paramList)
  {
    if (paramList.size() <= 0) {
      return 0;
    }
    Object localObject = this.jIi.bl(paramList);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    int k;
    label126:
    int j;
    label211:
    int i;
    if (localObject != null)
    {
      k = ((List)localObject).size();
      Iterator localIterator1 = ((List)localObject).iterator();
      while (localIterator1.hasNext())
      {
        com.tencent.mm.plugin.expt.c.a locala = (com.tencent.mm.plugin.expt.c.a)localIterator1.next();
        this.jIk.put(Integer.valueOf(locala.field_exptId), locala);
        localObject = locala.aNj();
        if (localObject != null)
        {
          Iterator localIterator2 = ((HashMap)localObject).keySet().iterator();
          String str;
          if (localIterator2.hasNext())
          {
            str = (String)localIterator2.next();
            localObject = this.jIj.BZ(str);
            if (localObject == null) {
              break label211;
            }
            if (((com.tencent.mm.plugin.expt.c.b)localObject).field_exptId == locala.field_exptId) {
              break label346;
            }
            localLinkedList1.add(localObject);
          }
          for (;;)
          {
            this.jIl.put(((com.tencent.mm.plugin.expt.c.b)localObject).field_exptKey, Integer.valueOf(((com.tencent.mm.plugin.expt.c.b)localObject).field_exptId));
            break label126;
            break;
            localObject = new com.tencent.mm.plugin.expt.c.b();
            ((com.tencent.mm.plugin.expt.c.b)localObject).field_exptId = locala.field_exptId;
            ((com.tencent.mm.plugin.expt.c.b)localObject).field_exptKey = str;
            localLinkedList2.add(localObject);
          }
        }
      }
      j = this.jIj.bi(localLinkedList2);
      i = this.jIj.bj(localLinkedList1);
    }
    for (;;)
    {
      y.i("MicroMsg.ExptService", "replace ExptIds args[%d] db[%d] exptMap insert[list:%d  db:%d], update[list:%d db:%d]", new Object[] { Integer.valueOf(paramList.size()), Integer.valueOf(k), Integer.valueOf(localLinkedList2.size()), Integer.valueOf(j), Integer.valueOf(localLinkedList1.size()), Integer.valueOf(i) });
      return k;
      label346:
      break;
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  public final int bh(List<Integer> paramList)
  {
    int i = this.jIi.bh(paramList);
    y.i("MicroMsg.ExptService", "delete expt ids deleteCount[%d] deleteMapCount[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jIj.bk(paramList)) });
    aMY();
    return i;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    y.i("MicroMsg.ExptService", "onAccountInitialized, %d", new Object[] { Integer.valueOf(hashCode()) });
    y.v("MicroMsg.ExptService", "add listener ");
    if (ae.cqV())
    {
      com.tencent.mm.sdk.b.a.udP.b(this.jIn);
      g.Dk().a(2738, this.jIp);
      ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("expt", this.jIo);
    }
  }
  
  public final void onAccountRelease()
  {
    y.i("MicroMsg.ExptService", "onAccountRelease");
    aMY();
    com.tencent.mm.sdk.b.a.udP.d(this.jIn);
    g.Dk().b(2738, this.jIp);
    ((com.tencent.mm.plugin.messenger.foundation.a.p)g.t(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("expt", this.jIo);
  }
  
  public final void p(Context paramContext, Intent paramIntent)
  {
    paramIntent.setClass(paramContext, ExptDebugUI.class);
    paramContext.startActivity(paramIntent);
  }
  
  public final com.tencent.mm.plugin.expt.c.a qB(int paramInt)
  {
    Object localObject = (com.tencent.mm.plugin.expt.c.a)this.jIk.get(Integer.valueOf(paramInt));
    if (localObject != null) {}
    com.tencent.mm.plugin.expt.c.a locala;
    do
    {
      return localObject;
      locala = this.jIi.qD(paramInt);
      localObject = locala;
    } while (locala == null);
    this.jIk.put(Integer.valueOf(paramInt), locala);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.a
 * JD-Core Version:    0.7.0.1
 */