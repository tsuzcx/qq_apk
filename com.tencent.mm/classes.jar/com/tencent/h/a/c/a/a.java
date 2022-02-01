package com.tencent.h.a.c.a;

import com.tencent.h.a.c.b.f;
import com.tencent.h.a.c.b.g;
import com.tencent.h.a.c.b.h;
import com.tencent.h.a.d;
import com.tencent.h.a.h.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a
{
  protected com.tencent.h.a.a.c ZSp;
  protected com.tencent.h.a.b.a ZTh;
  private int ZTi;
  protected h.a ZTj;
  
  public a(com.tencent.h.a.a.c paramc, com.tencent.h.a.b.a parama)
  {
    this.ZSp = paramc;
    this.ZTh = parama;
    this.ZTj = this.ZTh.itO();
  }
  
  protected static boolean a(com.tencent.h.a.c.b.a parama, int paramInt)
  {
    int i;
    if ((parama == null) || (parama.ZTq == null) || (parama.ZTq.isEmpty()) || (parama.ZTq.get(0) == null)) {
      i = 1;
    }
    while (i != 0)
    {
      return true;
      f localf = (f)parama.ZTq.get(0);
      if ((localf.mXB == null) || (localf.mXB.isEmpty()) || (localf.mXB.get(0) == null))
      {
        i = 1;
      }
      else
      {
        com.tencent.h.a.c.b.c localc = (com.tencent.h.a.c.b.c)localf.mXB.get(0);
        if ((localc.ZTI == null) || (localc.ZTI.isEmpty()) || (localc.ZTI.get(0) == null)) {
          i = 1;
        } else if ((localf.ZTQ == null) || (localf.ZTQ.isEmpty()) || (localf.ZTQ.get(0) == null)) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    parama = parama.toByteArray();
    return (parama != null) && (parama.length > paramInt);
  }
  
  protected static boolean b(HashMap<Integer, List<g>> paramHashMap, List<com.tencent.h.a.c.b.i> paramList)
  {
    return (paramHashMap == null) || (paramHashMap.isEmpty()) || (paramList == null) || (paramList.isEmpty());
  }
  
  protected final com.tencent.h.a.c.b.a a(com.tencent.h.a.c.b.c paramc, List<com.tencent.h.a.c.b.i> paramList, List<h> paramList1)
  {
    com.tencent.h.a.c.b.a locala = new com.tencent.h.a.c.b.a();
    locala.ZTp = System.currentTimeMillis();
    f localf = new f();
    localf.ZTP = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramc);
    localf.mXB = localArrayList;
    this.ZTi += 1;
    localf.Zqj = this.ZTi;
    if ((paramList != null) && (!paramList.isEmpty())) {
      localf.ZTQ = new ArrayList(paramList);
    }
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localf.ZTR = new ArrayList(paramList1);
    }
    paramc = new ArrayList();
    paramc.add(localf);
    locala.ZTq = paramc;
    return locala;
  }
  
  protected final void a(int paramInt, com.tencent.h.a.c.b.a parama, com.tencent.h.a.c.d.b paramb)
  {
    Object localObject;
    boolean bool;
    if (paramb != null)
    {
      localObject = new StringBuilder("[method: onCSReqCallBack ] errorCode : ").append(paramInt).append(" null == csReq? ");
      if (parama != null) {
        break label81;
      }
      bool = true;
      com.tencent.g.c.i.i("sensor_AbsDataHandle", bool);
      com.tencent.h.a.a.b.a.a(this.ZSp, parama, this.ZTj.ZRT);
      if ((parama != null) && (this.ZTj != null)) {
        break label87;
      }
    }
    for (;;)
    {
      paramb.b(paramInt, parama);
      return;
      label81:
      bool = false;
      break;
      label87:
      parama.ZTo = this.ZTj.ELa;
      parama.fcB = this.ZTj.ZRS;
      if (this.ZTj.ZRV != null)
      {
        if (parama.ZTt == null) {
          parama.ZTt = new ArrayList();
        }
        parama.ZTt.addAll(com.tencent.h.a.a.b.a.w(this.ZTj.ZRV.itC()));
        localObject = this.ZTj.ZRV.itD();
        com.tencent.h.a.c.b.b localb = new com.tencent.h.a.c.b.b();
        if (localObject != null) {
          break label248;
        }
        parama.ZTv = localb;
      }
      localObject = com.tencent.h.a.a.b.a.ms(this.ZSp.mAppContext);
      if (!((Map)localObject).isEmpty())
      {
        if (parama.ZTy == null) {
          parama.ZTy = new HashMap();
        }
        parama.ZTy.putAll((Map)localObject);
      }
    }
    label248:
    throw null;
  }
  
  public abstract void a(HashMap<Integer, List<g>> paramHashMap, List<com.tencent.h.a.c.b.i> paramList, List<h> paramList1, com.tencent.h.a.c.d.b paramb);
  
  public void esN() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */