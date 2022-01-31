package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.c.bfs;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public String bYR;
  public String caK;
  public int goN;
  public LinkedList<bfs> hID = new LinkedList();
  public int jxl;
  public String jxm;
  public int lpD;
  public long lpE;
  public long lpF;
  public int lpG;
  public int lpH;
  public int lpI;
  public int lpJ;
  public String lpK;
  public int lpL;
  public int lpM;
  public int lpN;
  public int lpO;
  public boolean lpP = false;
  public boolean lpQ = false;
  public boolean lpR = false;
  public boolean lpS = true;
  public int lpT = 0;
  public int lpU;
  public int lpV;
  public int lpW;
  public b lpX;
  public int lpY;
  public int lpZ;
  public b lqa;
  public LinkedList<bfs> lqb = new LinkedList();
  public int lqc = 999;
  public LinkedList<d> lqd = new LinkedList();
  public String lqe;
  public String lqf;
  public String lqg;
  public int lqh;
  public boolean lqi = false;
  public String nickname;
  
  public final int bcw()
  {
    if ((this.lqd != null) && (this.lqd.size() > 0)) {
      return ((d)this.lqd.get(0)).lpM;
    }
    return this.lpM;
  }
  
  public final int bcx()
  {
    if ((this.lqd != null) && (this.lqd.size() > 0)) {
      return ((d)this.lqd.get(0)).dJB;
    }
    return this.goN;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("IPCallInfo: ");
    localStringBuilder.append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[] { Integer.valueOf(this.lpD), Long.valueOf(this.lpE), Long.valueOf(this.lpF), Integer.valueOf(this.lpG), Integer.valueOf(this.lpL), Integer.valueOf(this.lpM), Integer.valueOf(this.lpN), Integer.valueOf(this.goN), this.jxm, Integer.valueOf(this.jxl), Integer.valueOf(this.lpJ) }));
    localStringBuilder.append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[] { this.bYR, this.lqf }));
    localStringBuilder.append("[addrList: ");
    Iterator localIterator = this.hID.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (bfs)localIterator.next();
      localStringBuilder.append(String.format("{IP: %s, port: %d}", new Object[] { ((bfs)localObject).tpY, Integer.valueOf(((bfs)localObject).tAA) }));
    }
    localStringBuilder.append("]");
    localStringBuilder.append("\n");
    if ((this.lqd != null) && (this.lqd.size() > 0))
    {
      localStringBuilder.append("[userInfoList: ");
      localIterator = this.lqd.iterator();
      while (localIterator.hasNext())
      {
        localObject = (d)localIterator.next();
        localStringBuilder.append("{");
        localStringBuilder.append(((d)localObject).toString());
        localStringBuilder.append("}");
      }
      localStringBuilder.append("]");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("userInfoList is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a.c
 * JD-Core Version:    0.7.0.1
 */