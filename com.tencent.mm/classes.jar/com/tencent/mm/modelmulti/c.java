package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
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
  private List<String> aJh;
  private i callback;
  private int index;
  private final int lSN;
  private final int lSO;
  private final int lSP;
  private final int lSQ;
  private final int lSR;
  public List<String> lSS;
  private int lST;
  public int op;
  private com.tencent.mm.an.d rr;
  private int total;
  private int type;
  
  public c(List<String> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187836);
    this.lSN = 1000;
    this.lSO = 0;
    this.lSP = 1;
    this.lSQ = 2;
    this.lSR = 3;
    this.lSS = new LinkedList();
    this.aJh = paramList;
    this.type = paramInt1;
    this.op = paramInt2;
    this.index = 0;
    this.total = paramList.size();
    this.lST = paramInt3;
    AppMethodBeat.o(187836);
  }
  
  public final List<String> bnb()
  {
    return this.lSS;
  }
  
  public final int bnc()
  {
    AppMethodBeat.i(187846);
    int i = this.total;
    int j = this.lSS.size();
    AppMethodBeat.o(187846);
    return i - j;
  }
  
  public final kn bnd()
  {
    AppMethodBeat.i(187849);
    kn localkn = (kn)d.c.b(this.rr.lBS);
    AppMethodBeat.o(187849);
    return localkn;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(187840);
    this.callback = parami;
    parami = new d.a();
    parami.uri = "/cgi-bin/micromsg-bin/batchmodcontacttype";
    parami.funcId = 3990;
    parami.lBW = 0;
    parami.respCmdId = 0;
    parami.lBU = new km();
    parami.lBV = new kn();
    this.rr = parami.bgN();
    parami = (km)d.b.b(this.rr.lBR);
    parami.RPL = new LinkedList();
    int i = 0;
    while ((i < this.lST) && (this.aJh.size() > 0))
    {
      cyc localcyc = new cyc();
      localcyc.UserName = ((String)this.aJh.remove(0));
      localcyc.TGA = this.type;
      localcyc.TGB = this.op;
      parami.RPL.add(localcyc);
      i += 1;
    }
    parami.RPK = parami.RPL.size();
    if ((this.type == 134217728) || (this.type == 33554432)) {
      parami.scene = 1;
    }
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(187840);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(187842);
    Log.i("MicroMsg.NetSceneBatchModContactType", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    label253:
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = ((kn)d.c.b(this.rr.lBS)).RPN.iterator();
      paramInt1 = 0;
      while (params.hasNext())
      {
        paramArrayOfByte = (cyd)params.next();
        if (paramArrayOfByte.CqV == 0)
        {
          h.aHH();
          as localas = ((n)h.ae(n.class)).bbL().RG(paramArrayOfByte.TGC.UserName);
          if ((localas != null) && (com.tencent.mm.contact.d.rk(localas.field_type)))
          {
            switch (paramArrayOfByte.TGC.TGA)
            {
            }
            for (;;)
            {
              h.aHH();
              ((n)h.ae(n.class)).bbL().c(localas.field_username, localas);
              this.lSS.add(localas.field_username);
              break;
              if (paramArrayOfByte.TGC.TGB == 1)
              {
                localas.axH();
                if (paramArrayOfByte.TGC.TGB != 1) {
                  break label298;
                }
                localas.axJ();
              }
              for (;;)
              {
                if (paramArrayOfByte.TGC.TGB != 1) {
                  break label306;
                }
                localas.axL();
                break;
                localas.axI();
                break label253;
                label298:
                localas.axK();
              }
              label306:
              localas.axM();
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
        if (this.aJh.size() > 0)
        {
          if (doScene(dispatcher(), this.callback) < 0)
          {
            Log.e("MicroMsg.NetSceneBatchModContactType", "onGYNetEnd : doScene fail");
            this.callback.onSceneEnd(3, -1, "", this);
          }
          AppMethodBeat.o(187842);
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
    AppMethodBeat.o(187842);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.c
 * JD-Core Version:    0.7.0.1
 */