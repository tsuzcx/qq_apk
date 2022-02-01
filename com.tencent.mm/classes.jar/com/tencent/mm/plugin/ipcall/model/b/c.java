package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.dfe;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public String dkV;
  public String edf;
  public int lPy;
  public String nickname;
  public LinkedList<dfe> oMr;
  public int phoneType;
  public int rBL;
  public String rBM;
  public int roomId;
  public long ypH;
  public long ypI;
  public int ypJ;
  public int ypK;
  public int ypL;
  public int ypM;
  public String ypN;
  public int ypO;
  public int ypP;
  public int ypQ;
  public int ypR;
  public boolean ypS;
  public boolean ypT;
  public boolean ypU;
  public boolean ypV;
  public int ypW;
  public int ypX;
  public int ypY;
  public int ypZ;
  public b yqa;
  public int yqb;
  public int yqc;
  public b yqd;
  public LinkedList<dfe> yqe;
  public int yqf;
  public LinkedList<d> yqg;
  public String yqh;
  public String yqi;
  public String yqj;
  public boolean yqk;
  
  public c()
  {
    AppMethodBeat.i(25408);
    this.ypS = false;
    this.ypT = false;
    this.ypU = false;
    this.ypV = true;
    this.ypW = 0;
    this.oMr = new LinkedList();
    this.yqe = new LinkedList();
    this.yqf = 999;
    this.yqg = new LinkedList();
    this.yqk = false;
    AppMethodBeat.o(25408);
  }
  
  public final int eaI()
  {
    AppMethodBeat.i(25409);
    if ((this.yqg != null) && (this.yqg.size() > 0))
    {
      i = ((d)this.yqg.get(0)).ypP;
      AppMethodBeat.o(25409);
      return i;
    }
    int i = this.ypP;
    AppMethodBeat.o(25409);
    return i;
  }
  
  public final int eaJ()
  {
    AppMethodBeat.i(25410);
    if ((this.yqg != null) && (this.yqg.size() > 0))
    {
      i = ((d)this.yqg.get(0)).hpS;
      AppMethodBeat.o(25410);
      return i;
    }
    int i = this.lPy;
    AppMethodBeat.o(25410);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(25411);
    Object localObject1 = new StringBuilder("");
    ((StringBuilder)localObject1).append("IPCallInfo: ");
    ((StringBuilder)localObject1).append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[] { Integer.valueOf(this.roomId), Long.valueOf(this.ypH), Long.valueOf(this.ypI), Integer.valueOf(this.ypJ), Integer.valueOf(this.ypO), Integer.valueOf(this.ypP), Integer.valueOf(this.ypQ), Integer.valueOf(this.lPy), this.rBM, Integer.valueOf(this.rBL), Integer.valueOf(this.ypM) }));
    ((StringBuilder)localObject1).append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[] { this.dkV, this.yqi }));
    ((StringBuilder)localObject1).append("[addrList: ");
    Iterator localIterator = this.oMr.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (dfe)localIterator.next();
      ((StringBuilder)localObject1).append(String.format("{IP: %s, port: %d}", new Object[] { ((dfe)localObject2).MpA, Integer.valueOf(((dfe)localObject2).MKe) }));
    }
    ((StringBuilder)localObject1).append("]");
    ((StringBuilder)localObject1).append("\n");
    if ((this.yqg != null) && (this.yqg.size() > 0))
    {
      ((StringBuilder)localObject1).append("[userInfoList: ");
      localIterator = this.yqg.iterator();
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