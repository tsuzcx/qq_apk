package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.kw;
import com.tencent.mm.protocal.protobuf.kx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements m
{
  private List<String> aZK;
  private i callback;
  private int index;
  private final int jcn;
  private final int jco;
  private final int jcp;
  private final int jcq;
  private final int jcr;
  public List<String> jcs;
  private int jct;
  public int jcu;
  public int op;
  private d rr;
  private int type;
  
  public c(List<String> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187474);
    this.jcn = 1000;
    this.jco = 0;
    this.jcp = 1;
    this.jcq = 2;
    this.jcr = 3;
    this.jcs = new LinkedList();
    this.aZK = paramList;
    this.type = paramInt1;
    this.op = paramInt2;
    this.index = 0;
    this.jcu = paramList.size();
    this.jct = paramInt3;
    AppMethodBeat.o(187474);
  }
  
  public final List<String> bdH()
  {
    return this.jcs;
  }
  
  public final kx bdI()
  {
    return (kx)this.rr.iLL.iLR;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(187475);
    this.callback = parami;
    parami = new d.a();
    parami.uri = "/cgi-bin/micromsg-bin/batchmodcontacttype";
    parami.funcId = 3990;
    parami.iLP = 0;
    parami.respCmdId = 0;
    parami.iLN = new kw();
    parami.iLO = new kx();
    this.rr = parami.aXF();
    parami = (kw)this.rr.iLK.iLR;
    parami.KON = new LinkedList();
    int i = 0;
    while ((i < this.jct) && (this.aZK.size() > 0))
    {
      cpm localcpm = new cpm();
      localcpm.UserName = ((String)this.aZK.remove(0));
      localcpm.MvC = this.type;
      localcpm.MvD = this.op;
      parami.KON.add(localcpm);
      i += 1;
    }
    parami.KOM = parami.KON.size();
    if ((this.type == 134217728) || (this.type == 33554432)) {
      parami.scene = 1;
    }
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(187475);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187476);
    Log.i("MicroMsg.NetSceneBatchModContactType", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    label253:
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = ((kx)this.rr.iLL.iLR).KOP.iterator();
      paramInt1 = 0;
      while (params.hasNext())
      {
        paramArrayOfByte = (cpn)params.next();
        if (paramArrayOfByte.Ret == 0)
        {
          com.tencent.mm.kernel.g.aAi();
          as localas = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramArrayOfByte.MvE.UserName);
          if ((localas != null) && (com.tencent.mm.contact.c.oR(localas.field_type)))
          {
            switch (paramArrayOfByte.MvE.MvC)
            {
            }
            for (;;)
            {
              com.tencent.mm.kernel.g.aAi();
              ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().c(localas.field_username, localas);
              this.jcs.add(localas.field_username);
              break;
              if (paramArrayOfByte.MvE.MvD == 1)
              {
                localas.arh();
                if (paramArrayOfByte.MvE.MvD != 1) {
                  break label298;
                }
                localas.arj();
              }
              for (;;)
              {
                if (paramArrayOfByte.MvE.MvD != 1) {
                  break label306;
                }
                localas.arl();
                break;
                localas.ari();
                break label253;
                label298:
                localas.ark();
              }
              label306:
              localas.arm();
            }
          }
        }
        else
        {
          paramInt1 += 1;
        }
      }
      i = paramInt1;
      if (paramInt1 == 0)
      {
        i = paramInt1;
        if (this.aZK.size() > 0)
        {
          if (doScene(dispatcher(), this.callback) < 0)
          {
            Log.e("MicroMsg.NetSceneBatchModContactType", "onGYNetEnd : doScene fail");
            this.callback.onSceneEnd(3, -1, "", this);
          }
          AppMethodBeat.o(187476);
        }
      }
    }
    else
    {
      i = 0;
    }
    params = this.callback;
    if (i > 0) {
      paramInt3 = -3500;
    }
    params.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(187476);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.c
 * JD-Core Version:    0.7.0.1
 */