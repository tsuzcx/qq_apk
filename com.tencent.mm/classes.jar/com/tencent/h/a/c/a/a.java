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
  protected com.tencent.h.a.a.c ahWN;
  protected com.tencent.h.a.b.a ahXH;
  private int ahXI;
  protected h.a ahXJ;
  
  public a(com.tencent.h.a.a.c paramc, com.tencent.h.a.b.a parama)
  {
    this.ahWN = paramc;
    this.ahXH = parama;
    this.ahXJ = this.ahXH.kdk();
  }
  
  protected static boolean a(com.tencent.h.a.c.b.a parama, int paramInt)
  {
    int i;
    if ((parama == null) || (parama.ahXQ == null) || (parama.ahXQ.isEmpty()) || (parama.ahXQ.get(0) == null)) {
      i = 1;
    }
    while (i != 0)
    {
      return true;
      f localf = (f)parama.ahXQ.get(0);
      if ((localf.pUj == null) || (localf.pUj.isEmpty()) || (localf.pUj.get(0) == null))
      {
        i = 1;
      }
      else
      {
        com.tencent.h.a.c.b.c localc = (com.tencent.h.a.c.b.c)localf.pUj.get(0);
        if ((localc.ahYi == null) || (localc.ahYi.isEmpty()) || (localc.ahYi.get(0) == null)) {
          i = 1;
        } else if ((localf.ahYq == null) || (localf.ahYq.isEmpty()) || (localf.ahYq.get(0) == null)) {
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
    locala.ahXP = System.currentTimeMillis();
    f localf = new f();
    localf.ahYp = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramc);
    localf.pUj = localArrayList;
    this.ahXI += 1;
    localf.ahuQ = this.ahXI;
    if ((paramList != null) && (!paramList.isEmpty())) {
      localf.ahYq = new ArrayList(paramList);
    }
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localf.ahYr = new ArrayList(paramList1);
    }
    paramc = new ArrayList();
    paramc.add(localf);
    locala.ahXQ = paramc;
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
      com.tencent.h.a.a.b.a.a(this.ahWN, parama, this.ahXJ.ahWq);
      if ((parama != null) && (this.ahXJ != null)) {
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
      parama.ahXO = this.ahXJ.KFd;
      parama.hgj = this.ahXJ.ahWp;
      if (this.ahXJ.ahWs != null)
      {
        if (parama.ahXT == null) {
          parama.ahXT = new ArrayList();
        }
        parama.ahXT.addAll(com.tencent.h.a.a.b.a.z(this.ahXJ.ahWs.kcX()));
        localObject = this.ahXJ.ahWs.kcY();
        com.tencent.h.a.c.b.b localb = new com.tencent.h.a.c.b.b();
        if (localObject != null) {
          break label253;
        }
        parama.ahXV = localb;
      }
      localObject = com.tencent.h.a.a.b.a.oI(this.ahWN.mAppContext);
      if ((localObject != null) && (!((Map)localObject).isEmpty()))
      {
        if (parama.ahXY == null) {
          parama.ahXY = new HashMap();
        }
        parama.ahXY.putAll((Map)localObject);
      }
    }
    label253:
    throw null;
  }
  
  public abstract void a(HashMap<Integer, List<g>> paramHashMap, List<com.tencent.h.a.c.b.i> paramList, List<h> paramList1, com.tencent.h.a.c.d.b paramb);
  
  public void fzH() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */