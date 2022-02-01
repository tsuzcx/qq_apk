package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.protocal.protobuf.doy;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public long DPJ;
  public long DPK;
  public int DPL;
  public int DPM;
  public int DPN;
  public int DPO;
  public String DPP;
  public int DPQ;
  public int DPR;
  public int DPS;
  public int DPT;
  public boolean DPU;
  public boolean DPV;
  public boolean DPW;
  public boolean DPX;
  public int DPY;
  public int DPZ;
  public int DQa;
  public int DQb;
  public b DQc;
  public int DQd;
  public int DQe;
  public b DQf;
  public LinkedList<doy> DQg;
  public int DQh;
  public LinkedList<d> DQi;
  public String DQj;
  public String DQk;
  public String DQl;
  public boolean DQm;
  public String fXl;
  public String fcD;
  public String nickname;
  public int oLS;
  public int phoneType;
  public LinkedList<doy> rOm;
  public int roomId;
  public int vht;
  public String vhu;
  
  public c()
  {
    AppMethodBeat.i(25408);
    this.DPU = false;
    this.DPV = false;
    this.DPW = false;
    this.DPX = true;
    this.DPY = 0;
    this.rOm = new LinkedList();
    this.DQg = new LinkedList();
    this.DQh = 999;
    this.DQi = new LinkedList();
    this.DQm = false;
    AppMethodBeat.o(25408);
  }
  
  public final int eJG()
  {
    AppMethodBeat.i(25409);
    if ((this.DQi != null) && (this.DQi.size() > 0))
    {
      i = ((d)this.DQi.get(0)).DPR;
      AppMethodBeat.o(25409);
      return i;
    }
    int i = this.DPR;
    AppMethodBeat.o(25409);
    return i;
  }
  
  public final int eJH()
  {
    AppMethodBeat.i(25410);
    if ((this.DQi != null) && (this.DQi.size() > 0))
    {
      i = ((d)this.DQi.get(0)).kbN;
      AppMethodBeat.o(25410);
      return i;
    }
    int i = this.oLS;
    AppMethodBeat.o(25410);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(25411);
    Object localObject1 = new StringBuilder("");
    ((StringBuilder)localObject1).append("IPCallInfo: ");
    ((StringBuilder)localObject1).append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[] { Integer.valueOf(this.roomId), Long.valueOf(this.DPJ), Long.valueOf(this.DPK), Integer.valueOf(this.DPL), Integer.valueOf(this.DPQ), Integer.valueOf(this.DPR), Integer.valueOf(this.DPS), Integer.valueOf(this.oLS), this.vhu, Integer.valueOf(this.vht), Integer.valueOf(this.DPO) }));
    ((StringBuilder)localObject1).append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[] { this.fcD, this.DQk }));
    ((StringBuilder)localObject1).append("[addrList: ");
    Iterator localIterator = this.rOm.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (doy)localIterator.next();
      ((StringBuilder)localObject1).append(String.format("{IP: %s, port: %d}", new Object[] { ((doy)localObject2).TVX, Integer.valueOf(((doy)localObject2).TVY) }));
    }
    ((StringBuilder)localObject1).append("]");
    ((StringBuilder)localObject1).append("\n");
    if ((this.DQi != null) && (this.DQi.size() > 0))
    {
      ((StringBuilder)localObject1).append("[userInfoList: ");
      localIterator = this.DQi.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.c
 * JD-Core Version:    0.7.0.1
 */