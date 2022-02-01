package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.ccn;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public String dAc;
  public String dxK;
  public int jMb;
  public LinkedList<ccn> mty;
  public String nickname;
  public int oXv;
  public String oXw;
  public int roomId;
  public long sAY;
  public long sAZ;
  public String sBA;
  public int sBB;
  public boolean sBC;
  public int sBa;
  public int sBb;
  public int sBc;
  public int sBd;
  public String sBe;
  public int sBf;
  public int sBg;
  public int sBh;
  public int sBi;
  public boolean sBj;
  public boolean sBk;
  public boolean sBl;
  public boolean sBm;
  public int sBn;
  public int sBo;
  public int sBp;
  public int sBq;
  public b sBr;
  public int sBs;
  public int sBt;
  public b sBu;
  public LinkedList<ccn> sBv;
  public int sBw;
  public LinkedList<d> sBx;
  public String sBy;
  public String sBz;
  
  public c()
  {
    AppMethodBeat.i(25408);
    this.sBj = false;
    this.sBk = false;
    this.sBl = false;
    this.sBm = true;
    this.sBn = 0;
    this.mty = new LinkedList();
    this.sBv = new LinkedList();
    this.sBw = 999;
    this.sBx = new LinkedList();
    this.sBC = false;
    AppMethodBeat.o(25408);
  }
  
  public final int cHA()
  {
    AppMethodBeat.i(25409);
    if ((this.sBx != null) && (this.sBx.size() > 0))
    {
      i = ((d)this.sBx.get(0)).sBg;
      AppMethodBeat.o(25409);
      return i;
    }
    int i = this.sBg;
    AppMethodBeat.o(25409);
    return i;
  }
  
  public final int cHB()
  {
    AppMethodBeat.i(25410);
    if ((this.sBx != null) && (this.sBx.size() > 0))
    {
      i = ((d)this.sBx.get(0)).gch;
      AppMethodBeat.o(25410);
      return i;
    }
    int i = this.jMb;
    AppMethodBeat.o(25410);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(25411);
    Object localObject1 = new StringBuilder("");
    ((StringBuilder)localObject1).append("IPCallInfo: ");
    ((StringBuilder)localObject1).append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[] { Integer.valueOf(this.roomId), Long.valueOf(this.sAY), Long.valueOf(this.sAZ), Integer.valueOf(this.sBa), Integer.valueOf(this.sBf), Integer.valueOf(this.sBg), Integer.valueOf(this.sBh), Integer.valueOf(this.jMb), this.oXw, Integer.valueOf(this.oXv), Integer.valueOf(this.sBd) }));
    ((StringBuilder)localObject1).append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[] { this.dxK, this.sBz }));
    ((StringBuilder)localObject1).append("[addrList: ");
    Iterator localIterator = this.mty.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (ccn)localIterator.next();
      ((StringBuilder)localObject1).append(String.format("{IP: %s, port: %d}", new Object[] { ((ccn)localObject2).DKe, Integer.valueOf(((ccn)localObject2).DYT) }));
    }
    ((StringBuilder)localObject1).append("]");
    ((StringBuilder)localObject1).append("\n");
    if ((this.sBx != null) && (this.sBx.size() > 0))
    {
      ((StringBuilder)localObject1).append("[userInfoList: ");
      localIterator = this.sBx.iterator();
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