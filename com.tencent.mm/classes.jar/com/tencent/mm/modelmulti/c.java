package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private List<String> aZO;
  private f callback;
  private final int ihs;
  private final int iht;
  private final int ihu;
  private final int ihv;
  private final int ihw;
  public List<String> ihx;
  private int ihy;
  public int ihz;
  private int index;
  public int op;
  private b rr;
  private int type;
  
  public c(List<String> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211744);
    this.ihs = 1000;
    this.iht = 0;
    this.ihu = 1;
    this.ihv = 2;
    this.ihw = 3;
    this.ihx = new LinkedList();
    this.aZO = paramList;
    this.type = 8388608;
    this.op = paramInt1;
    this.index = 0;
    this.ihz = paramList.size();
    this.ihy = paramInt2;
    AppMethodBeat.o(211744);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(211745);
    this.callback = paramf;
    paramf = new b.a();
    paramf.uri = "/cgi-bin/micromsg-bin/batchmodcontacttype";
    paramf.funcId = 3990;
    paramf.hQH = 0;
    paramf.respCmdId = 0;
    paramf.hQF = new kf();
    paramf.hQG = new kg();
    this.rr = paramf.aDS();
    paramf = (kf)this.rr.hQD.hQJ;
    paramf.FVc = new LinkedList();
    int i = 0;
    while ((i < this.ihy) && (this.aZO.size() > 0))
    {
      cak localcak = new cak();
      localcak.nIJ = ((String)this.aZO.remove(0));
      localcak.Hoh = this.type;
      localcak.Hoi = this.op;
      paramf.FVc.add(localcak);
      i += 1;
    }
    paramf.FVb = paramf.FVc.size();
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(211745);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211746);
    ae.i("MicroMsg.NetSceneBatchModContactType", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((kg)this.rr.hQE.hQJ).FVe.iterator();
      paramInt1 = 0;
      while (paramq.hasNext())
      {
        paramArrayOfByte = (cal)paramq.next();
        if (paramArrayOfByte.Ret == 0)
        {
          g.ajS();
          an localan = ((l)g.ab(l.class)).azF().BH(paramArrayOfByte.Hoj.nIJ);
          if ((localan != null) && (com.tencent.mm.contact.c.lO(localan.field_type)))
          {
            if (paramArrayOfByte.Hoj.Hoi == 1) {
              localan.adk();
            }
            for (;;)
            {
              g.ajS();
              ((l)g.ab(l.class)).azF().c(localan.field_username, localan);
              this.ihx.add(localan.field_username);
              break;
              localan.adl();
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
        if (this.aZO.size() > 0)
        {
          if (doScene(dispatcher(), this.callback) < 0)
          {
            ae.e("MicroMsg.NetSceneBatchModContactType", "onGYNetEnd : doScene fail");
            this.callback.onSceneEnd(3, -1, "", this);
          }
          AppMethodBeat.o(211746);
        }
      }
    }
    else
    {
      i = 0;
    }
    paramq = this.callback;
    if (i > 0) {
      paramInt3 = -3500;
    }
    paramq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(211746);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.c
 * JD-Core Version:    0.7.0.1
 */