package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.cmq;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public String dHz;
  public String dKb;
  public int kHC;
  public String nickname;
  public LinkedList<cmq> nvX;
  public int qel;
  public String qem;
  public int roomId;
  public int uLA;
  public int uLB;
  public int uLC;
  public int uLD;
  public boolean uLE;
  public boolean uLF;
  public boolean uLG;
  public boolean uLH;
  public int uLI;
  public int uLJ;
  public int uLK;
  public int uLL;
  public b uLM;
  public int uLN;
  public int uLO;
  public b uLP;
  public LinkedList<cmq> uLQ;
  public int uLR;
  public LinkedList<d> uLS;
  public String uLT;
  public String uLU;
  public String uLV;
  public int uLW;
  public boolean uLX;
  public long uLt;
  public long uLu;
  public int uLv;
  public int uLw;
  public int uLx;
  public int uLy;
  public String uLz;
  
  public c()
  {
    AppMethodBeat.i(25408);
    this.uLE = false;
    this.uLF = false;
    this.uLG = false;
    this.uLH = true;
    this.uLI = 0;
    this.nvX = new LinkedList();
    this.uLQ = new LinkedList();
    this.uLR = 999;
    this.uLS = new LinkedList();
    this.uLX = false;
    AppMethodBeat.o(25408);
  }
  
  public final int ddW()
  {
    AppMethodBeat.i(25409);
    if ((this.uLS != null) && (this.uLS.size() > 0))
    {
      i = ((d)this.uLS.get(0)).uLB;
      AppMethodBeat.o(25409);
      return i;
    }
    int i = this.uLB;
    AppMethodBeat.o(25409);
    return i;
  }
  
  public final int ddX()
  {
    AppMethodBeat.i(25410);
    if ((this.uLS != null) && (this.uLS.size() > 0))
    {
      i = ((d)this.uLS.get(0)).gAx;
      AppMethodBeat.o(25410);
      return i;
    }
    int i = this.kHC;
    AppMethodBeat.o(25410);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(25411);
    Object localObject1 = new StringBuilder("");
    ((StringBuilder)localObject1).append("IPCallInfo: ");
    ((StringBuilder)localObject1).append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[] { Integer.valueOf(this.roomId), Long.valueOf(this.uLt), Long.valueOf(this.uLu), Integer.valueOf(this.uLv), Integer.valueOf(this.uLA), Integer.valueOf(this.uLB), Integer.valueOf(this.uLC), Integer.valueOf(this.kHC), this.qem, Integer.valueOf(this.qel), Integer.valueOf(this.uLy) }));
    ((StringBuilder)localObject1).append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[] { this.dHz, this.uLU }));
    ((StringBuilder)localObject1).append("[addrList: ");
    Iterator localIterator = this.nvX.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (cmq)localIterator.next();
      ((StringBuilder)localObject1).append(String.format("{IP: %s, port: %d}", new Object[] { ((cmq)localObject2).GPW, Integer.valueOf(((cmq)localObject2).HfV) }));
    }
    ((StringBuilder)localObject1).append("]");
    ((StringBuilder)localObject1).append("\n");
    if ((this.uLS != null) && (this.uLS.size() > 0))
    {
      ((StringBuilder)localObject1).append("[userInfoList: ");
      localIterator = this.uLS.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.c
 * JD-Core Version:    0.7.0.1
 */