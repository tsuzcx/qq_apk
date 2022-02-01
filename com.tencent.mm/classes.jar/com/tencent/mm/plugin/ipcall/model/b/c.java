package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.cnk;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public String cUB;
  public String dLq;
  public int kKR;
  public LinkedList<cnk> nBs;
  public String nickname;
  public int qkQ;
  public String qkR;
  public int roomId;
  public int uXA;
  public int uXB;
  public b uXC;
  public LinkedList<cnk> uXD;
  public int uXE;
  public LinkedList<d> uXF;
  public String uXG;
  public String uXH;
  public String uXI;
  public int uXJ;
  public boolean uXK;
  public long uXg;
  public long uXh;
  public int uXi;
  public int uXj;
  public int uXk;
  public int uXl;
  public String uXm;
  public int uXn;
  public int uXo;
  public int uXp;
  public int uXq;
  public boolean uXr;
  public boolean uXs;
  public boolean uXt;
  public boolean uXu;
  public int uXv;
  public int uXw;
  public int uXx;
  public int uXy;
  public b uXz;
  
  public c()
  {
    AppMethodBeat.i(25408);
    this.uXr = false;
    this.uXs = false;
    this.uXt = false;
    this.uXu = true;
    this.uXv = 0;
    this.nBs = new LinkedList();
    this.uXD = new LinkedList();
    this.uXE = 999;
    this.uXF = new LinkedList();
    this.uXK = false;
    AppMethodBeat.o(25408);
  }
  
  public final int dgO()
  {
    AppMethodBeat.i(25409);
    if ((this.uXF != null) && (this.uXF.size() > 0))
    {
      i = ((d)this.uXF.get(0)).uXo;
      AppMethodBeat.o(25409);
      return i;
    }
    int i = this.uXo;
    AppMethodBeat.o(25409);
    return i;
  }
  
  public final int dgP()
  {
    AppMethodBeat.i(25410);
    if ((this.uXF != null) && (this.uXF.size() > 0))
    {
      i = ((d)this.uXF.get(0)).gDe;
      AppMethodBeat.o(25410);
      return i;
    }
    int i = this.kKR;
    AppMethodBeat.o(25410);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(25411);
    Object localObject1 = new StringBuilder("");
    ((StringBuilder)localObject1).append("IPCallInfo: ");
    ((StringBuilder)localObject1).append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[] { Integer.valueOf(this.roomId), Long.valueOf(this.uXg), Long.valueOf(this.uXh), Integer.valueOf(this.uXi), Integer.valueOf(this.uXn), Integer.valueOf(this.uXo), Integer.valueOf(this.uXp), Integer.valueOf(this.kKR), this.qkR, Integer.valueOf(this.qkQ), Integer.valueOf(this.uXl) }));
    ((StringBuilder)localObject1).append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[] { this.cUB, this.uXH }));
    ((StringBuilder)localObject1).append("[addrList: ");
    Iterator localIterator = this.nBs.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (cnk)localIterator.next();
      ((StringBuilder)localObject1).append(String.format("{IP: %s, port: %d}", new Object[] { ((cnk)localObject2).Hjx, Integer.valueOf(((cnk)localObject2).Hzv) }));
    }
    ((StringBuilder)localObject1).append("]");
    ((StringBuilder)localObject1).append("\n");
    if ((this.uXF != null) && (this.uXF.size() > 0))
    {
      ((StringBuilder)localObject1).append("[userInfoList: ");
      localIterator = this.uXF.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (d)localIterator.next();
        ((StringBuilder)localObject1).append("{");
        ((StringBuilder)localObject1).append(((d)localObject2).toString());
        ((StringBuilder)localObject1).append("}");
      }
      ((StringBuilder)localObject1).append("]");
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).toString();
      AppMethodBeat.o(25411);
      return localObject1;
      ((StringBuilder)localObject1).append("userInfoList is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.c
 * JD-Core Version:    0.7.0.1
 */