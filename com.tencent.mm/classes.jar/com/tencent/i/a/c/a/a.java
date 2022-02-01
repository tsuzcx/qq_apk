package com.tencent.i.a.c.a;

import com.tencent.i.a.c.b.f;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.d;
import com.tencent.i.a.h.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a
{
  protected com.tencent.i.a.a.c SqM;
  protected com.tencent.i.a.b.a SrE;
  private int SrF;
  protected h.a SrG;
  
  public a(com.tencent.i.a.a.c paramc, com.tencent.i.a.b.a parama)
  {
    this.SqM = paramc;
    this.SrE = parama;
    this.SrG = this.SrE.hqh();
  }
  
  protected static boolean a(com.tencent.i.a.c.b.a parama, int paramInt)
  {
    int i;
    if ((parama == null) || (parama.SrN == null) || (parama.SrN.isEmpty()) || (parama.SrN.get(0) == null)) {
      i = 1;
    }
    while (i != 0)
    {
      return true;
      f localf = (f)parama.SrN.get(0);
      if ((localf.kgc == null) || (localf.kgc.isEmpty()) || (localf.kgc.get(0) == null))
      {
        i = 1;
      }
      else
      {
        com.tencent.i.a.c.b.c localc = (com.tencent.i.a.c.b.c)localf.kgc.get(0);
        if ((localc.Ssd == null) || (localc.Ssd.isEmpty()) || (localc.Ssd.get(0) == null)) {
          i = 1;
        } else if ((localf.Ssn == null) || (localf.Ssn.isEmpty()) || (localf.Ssn.get(0) == null)) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
    parama = parama.toByteArray();
    return (parama != null) && (parama.length > paramInt);
  }
  
  protected static boolean b(HashMap<Integer, List<g>> paramHashMap, List<i> paramList)
  {
    return (paramHashMap == null) || (paramHashMap.isEmpty()) || (paramList == null) || (paramList.isEmpty());
  }
  
  protected final com.tencent.i.a.c.b.a a(com.tencent.i.a.c.b.c paramc, List<i> paramList, List<com.tencent.i.a.c.b.h> paramList1)
  {
    com.tencent.i.a.c.b.a locala = new com.tencent.i.a.c.b.a();
    locala.SrM = System.currentTimeMillis();
    f localf = new f();
    localf.Ssm = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramc);
    localf.kgc = localArrayList;
    this.SrF += 1;
    localf.RND = this.SrF;
    if ((paramList != null) && (!paramList.isEmpty())) {
      localf.Ssn = new ArrayList(paramList);
    }
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localf.Sso = new ArrayList(paramList1);
    }
    paramc = new ArrayList();
    paramc.add(localf);
    locala.SrN = paramc;
    return locala;
  }
  
  protected final void a(int paramInt, com.tencent.i.a.c.b.a parama, com.tencent.i.a.c.d.b paramb)
  {
    Object localObject;
    if (paramb != null)
    {
      localObject = new StringBuilder("[method: onCSReqCallBack ] errorCode : ").append(paramInt).append(" null == csReq? ");
      if (parama != null) {
        break label81;
      }
    }
    label81:
    for (boolean bool = true;; bool = false)
    {
      com.tencent.h.c.h.i("sensor_AbsDataHandle", bool);
      com.tencent.i.a.a.b.a.a(this.SqM, parama, this.SrG.Sqq);
      if ((parama != null) && (this.SrG != null)) {
        break;
      }
      paramb.b(paramInt, parama);
      return;
    }
    parama.SrL = this.SrG.zfX;
    parama.dkT = this.SrG.Sqp;
    com.tencent.i.a.c.b.b localb;
    if (this.SrG.Sqs != null)
    {
      if (parama.SrQ == null) {
        parama.SrQ = new ArrayList();
      }
      parama.SrQ.addAll(com.tencent.i.a.a.b.a.z(this.SrG.Sqs.hpX()));
      localObject = this.SrG.Sqs.hpY();
      localb = new com.tencent.i.a.c.b.b();
      if (localObject != null) {
        break label248;
      }
    }
    for (;;)
    {
      parama.SrS = localb;
      localObject = com.tencent.i.a.a.b.a.lu(this.SqM.mAppContext);
      if (((Map)localObject).isEmpty()) {
        break;
      }
      if (parama.SrV == null) {
        parama.SrV = new HashMap();
      }
      parama.SrV.putAll((Map)localObject);
      break;
      label248:
      localb.Sqg = ((com.tencent.i.a.a)localObject).Sqg;
      localb.Sqh = ((com.tencent.i.a.a)localObject).Sqh;
    }
  }
  
  public abstract void a(HashMap<Integer, List<g>> paramHashMap, List<i> paramList, List<com.tencent.i.a.c.b.h> paramList1, com.tencent.i.a.c.d.b paramb);
  
  public void dQn() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */