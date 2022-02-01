package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.chq;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public String dvw;
  public String dxO;
  public int kmC;
  public LinkedList<chq> mVA;
  public String nickname;
  public int pAG;
  public String pAH;
  public int roomId;
  public long tIG;
  public long tIH;
  public int tII;
  public int tIJ;
  public int tIK;
  public int tIL;
  public String tIM;
  public int tIN;
  public int tIO;
  public int tIP;
  public int tIQ;
  public boolean tIR;
  public boolean tIS;
  public boolean tIT;
  public boolean tIU;
  public int tIV;
  public int tIW;
  public int tIX;
  public int tIY;
  public b tIZ;
  public int tJa;
  public int tJb;
  public b tJc;
  public LinkedList<chq> tJd;
  public int tJe;
  public LinkedList<d> tJf;
  public String tJg;
  public String tJh;
  public String tJi;
  public int tJj;
  public boolean tJk;
  
  public c()
  {
    AppMethodBeat.i(25408);
    this.tIR = false;
    this.tIS = false;
    this.tIT = false;
    this.tIU = true;
    this.tIV = 0;
    this.mVA = new LinkedList();
    this.tJd = new LinkedList();
    this.tJe = 999;
    this.tJf = new LinkedList();
    this.tJk = false;
    AppMethodBeat.o(25408);
  }
  
  public final int cUL()
  {
    AppMethodBeat.i(25409);
    if ((this.tJf != null) && (this.tJf.size() > 0))
    {
      i = ((d)this.tJf.get(0)).tIO;
      AppMethodBeat.o(25409);
      return i;
    }
    int i = this.tIO;
    AppMethodBeat.o(25409);
    return i;
  }
  
  public final int cUM()
  {
    AppMethodBeat.i(25410);
    if ((this.tJf != null) && (this.tJf.size() > 0))
    {
      i = ((d)this.tJf.get(0)).ggN;
      AppMethodBeat.o(25410);
      return i;
    }
    int i = this.kmC;
    AppMethodBeat.o(25410);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(25411);
    Object localObject1 = new StringBuilder("");
    ((StringBuilder)localObject1).append("IPCallInfo: ");
    ((StringBuilder)localObject1).append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[] { Integer.valueOf(this.roomId), Long.valueOf(this.tIG), Long.valueOf(this.tIH), Integer.valueOf(this.tII), Integer.valueOf(this.tIN), Integer.valueOf(this.tIO), Integer.valueOf(this.tIP), Integer.valueOf(this.kmC), this.pAH, Integer.valueOf(this.pAG), Integer.valueOf(this.tIL) }));
    ((StringBuilder)localObject1).append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[] { this.dvw, this.tJh }));
    ((StringBuilder)localObject1).append("[addrList: ");
    Iterator localIterator = this.mVA.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (chq)localIterator.next();
      ((StringBuilder)localObject1).append(String.format("{IP: %s, port: %d}", new Object[] { ((chq)localObject2).Fgt, Integer.valueOf(((chq)localObject2).FvP) }));
    }
    ((StringBuilder)localObject1).append("]");
    ((StringBuilder)localObject1).append("\n");
    if ((this.tJf != null) && (this.tJf.size() > 0))
    {
      ((StringBuilder)localObject1).append("[userInfoList: ");
      localIterator = this.tJf.iterator();
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