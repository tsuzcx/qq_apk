package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.protocal.protobuf.ehs;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public long Hnt;
  public long JGV;
  public int JGW;
  public int JGX;
  public int JGY;
  public int JGZ;
  public String JHa;
  public int JHb;
  public int JHc;
  public int JHd;
  public int JHe;
  public boolean JHf;
  public boolean JHg;
  public boolean JHh;
  public boolean JHi;
  public int JHj;
  public int JHk;
  public int JHl;
  public int JHm;
  public b JHn;
  public int JHo;
  public int JHp;
  public b JHq;
  public LinkedList<ehs> JHr;
  public int JHs;
  public LinkedList<d> JHt;
  public String JHu;
  public String JHv;
  public String JHw;
  public boolean JHx;
  public String hgl;
  public String idl;
  public String nickname;
  public int phoneType;
  public int rPN;
  public int roomId;
  public LinkedList<ehs> uZA;
  public int ytv;
  public String ytw;
  
  public c()
  {
    AppMethodBeat.i(25408);
    this.JHf = false;
    this.JHg = false;
    this.JHh = false;
    this.JHi = true;
    this.JHj = 0;
    this.uZA = new LinkedList();
    this.JHr = new LinkedList();
    this.JHs = 999;
    this.JHt = new LinkedList();
    this.JHx = false;
    AppMethodBeat.o(25408);
  }
  
  public final int fRH()
  {
    AppMethodBeat.i(25409);
    if ((this.JHt != null) && (this.JHt.size() > 0))
    {
      i = ((d)this.JHt.get(0)).JHc;
      AppMethodBeat.o(25409);
      return i;
    }
    int i = this.JHc;
    AppMethodBeat.o(25409);
    return i;
  }
  
  public final int fRI()
  {
    AppMethodBeat.i(25410);
    if ((this.JHt != null) && (this.JHt.size() > 0))
    {
      i = ((d)this.JHt.get(0)).mBT;
      AppMethodBeat.o(25410);
      return i;
    }
    int i = this.rPN;
    AppMethodBeat.o(25410);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(25411);
    Object localObject1 = new StringBuilder("");
    ((StringBuilder)localObject1).append("IPCallInfo: ");
    ((StringBuilder)localObject1).append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[] { Integer.valueOf(this.roomId), Long.valueOf(this.Hnt), Long.valueOf(this.JGV), Integer.valueOf(this.JGW), Integer.valueOf(this.JHb), Integer.valueOf(this.JHc), Integer.valueOf(this.JHd), Integer.valueOf(this.rPN), this.ytw, Integer.valueOf(this.ytv), Integer.valueOf(this.JGZ) }));
    ((StringBuilder)localObject1).append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[] { this.hgl, this.JHv }));
    ((StringBuilder)localObject1).append("[addrList: ");
    Iterator localIterator = this.uZA.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (ehs)localIterator.next();
      ((StringBuilder)localObject1).append(String.format("{IP: %s, port: %d}", new Object[] { ((ehs)localObject2).abmM, Integer.valueOf(((ehs)localObject2).abmN) }));
    }
    ((StringBuilder)localObject1).append("]");
    ((StringBuilder)localObject1).append("\n");
    if ((this.JHt != null) && (this.JHt.size() > 0))
    {
      ((StringBuilder)localObject1).append("[userInfoList: ");
      localIterator = this.JHt.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.b.c
 * JD-Core Version:    0.7.0.1
 */