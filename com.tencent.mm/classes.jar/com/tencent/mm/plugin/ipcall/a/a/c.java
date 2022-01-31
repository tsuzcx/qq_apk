package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.protocal.protobuf.bny;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
{
  public String cGY;
  public String cJk;
  public int hIJ;
  public LinkedList<bny> jCd;
  public int lGK;
  public String lGL;
  public int nMZ;
  public String nNA;
  public String nNB;
  public String nNC;
  public int nND;
  public boolean nNE;
  public long nNa;
  public long nNb;
  public int nNc;
  public int nNd;
  public int nNe;
  public int nNf;
  public String nNg;
  public int nNh;
  public int nNi;
  public int nNj;
  public int nNk;
  public boolean nNl;
  public boolean nNm;
  public boolean nNn;
  public boolean nNo;
  public int nNp;
  public int nNq;
  public int nNr;
  public int nNs;
  public b nNt;
  public int nNu;
  public int nNv;
  public b nNw;
  public LinkedList<bny> nNx;
  public int nNy;
  public LinkedList<d> nNz;
  public String nickname;
  
  public c()
  {
    AppMethodBeat.i(21793);
    this.nNl = false;
    this.nNm = false;
    this.nNn = false;
    this.nNo = true;
    this.nNp = 0;
    this.jCd = new LinkedList();
    this.nNx = new LinkedList();
    this.nNy = 999;
    this.nNz = new LinkedList();
    this.nNE = false;
    AppMethodBeat.o(21793);
  }
  
  public final int bJD()
  {
    AppMethodBeat.i(21794);
    if ((this.nNz != null) && (this.nNz.size() > 0))
    {
      i = ((d)this.nNz.get(0)).nNi;
      AppMethodBeat.o(21794);
      return i;
    }
    int i = this.nNi;
    AppMethodBeat.o(21794);
    return i;
  }
  
  public final int bJE()
  {
    AppMethodBeat.i(21795);
    if ((this.nNz != null) && (this.nNz.size() > 0))
    {
      i = ((d)this.nNz.get(0)).eHa;
      AppMethodBeat.o(21795);
      return i;
    }
    int i = this.hIJ;
    AppMethodBeat.o(21795);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(21796);
    Object localObject1 = new StringBuilder("");
    ((StringBuilder)localObject1).append("IPCallInfo: ");
    ((StringBuilder)localObject1).append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", new Object[] { Integer.valueOf(this.nMZ), Long.valueOf(this.nNa), Long.valueOf(this.nNb), Integer.valueOf(this.nNc), Integer.valueOf(this.nNh), Integer.valueOf(this.nNi), Integer.valueOf(this.nNj), Integer.valueOf(this.hIJ), this.lGL, Integer.valueOf(this.lGK), Integer.valueOf(this.nNf) }));
    ((StringBuilder)localObject1).append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", new Object[] { this.cGY, this.nNB }));
    ((StringBuilder)localObject1).append("[addrList: ");
    Iterator localIterator = this.jCd.iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (bny)localIterator.next();
      ((StringBuilder)localObject1).append(String.format("{IP: %s, port: %d}", new Object[] { ((bny)localObject2).xpV, Integer.valueOf(((bny)localObject2).xCi) }));
    }
    ((StringBuilder)localObject1).append("]");
    ((StringBuilder)localObject1).append("\n");
    if ((this.nNz != null) && (this.nNz.size() > 0))
    {
      ((StringBuilder)localObject1).append("[userInfoList: ");
      localIterator = this.nNz.iterator();
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
      AppMethodBeat.o(21796);
      return localObject1;
      ((StringBuilder)localObject1).append("userInfoList is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.a.c
 * JD-Core Version:    0.7.0.1
 */