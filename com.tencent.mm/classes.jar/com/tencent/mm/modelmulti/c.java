package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bzq;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements k
{
  private List<String> aZO;
  private f callback;
  private final int ieA;
  private final int ieB;
  private final int ieC;
  private final int ieD;
  private final int ieE;
  public List<String> ieF;
  private int ieG;
  public int ieH;
  private int index;
  public int op;
  private com.tencent.mm.al.b rr;
  private int type;
  
  public c(List<String> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217575);
    this.ieA = 1000;
    this.ieB = 0;
    this.ieC = 1;
    this.ieD = 2;
    this.ieE = 3;
    this.ieF = new LinkedList();
    this.aZO = paramList;
    this.type = 8388608;
    this.op = paramInt1;
    this.index = 0;
    this.ieH = paramList.size();
    this.ieG = paramInt2;
    AppMethodBeat.o(217575);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(217576);
    this.callback = paramf;
    paramf = new b.a();
    paramf.uri = "/cgi-bin/micromsg-bin/batchmodcontacttype";
    paramf.funcId = 3990;
    paramf.hNO = 0;
    paramf.respCmdId = 0;
    paramf.hNM = new kf();
    paramf.hNN = new kg();
    this.rr = paramf.aDC();
    paramf = (kf)this.rr.hNK.hNQ;
    paramf.FCH = new LinkedList();
    int i = 0;
    while ((i < this.ieG) && (this.aZO.size() > 0))
    {
      bzq localbzq = new bzq();
      localbzq.nDo = ((String)this.aZO.remove(0));
      localbzq.GUG = this.type;
      localbzq.GUH = this.op;
      paramf.FCH.add(localbzq);
      i += 1;
    }
    paramf.FCG = paramf.FCH.size();
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(217576);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(217577);
    ad.i("MicroMsg.NetSceneBatchModContactType", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((kg)this.rr.hNL.hNQ).FCJ.iterator();
      paramInt1 = 0;
      while (paramq.hasNext())
      {
        paramArrayOfByte = (bzr)paramq.next();
        if (paramArrayOfByte.Ret == 0)
        {
          g.ajD();
          am localam = ((l)g.ab(l.class)).azp().Bf(paramArrayOfByte.GUI.nDo);
          if ((localam != null) && (com.tencent.mm.o.b.lM(localam.field_type)))
          {
            if (paramArrayOfByte.GUI.GUH == 1) {
              localam.acY();
            }
            for (;;)
            {
              g.ajD();
              ((l)g.ab(l.class)).azp().c(localam.field_username, localam);
              this.ieF.add(localam.field_username);
              break;
              localam.acZ();
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
            ad.e("MicroMsg.NetSceneBatchModContactType", "onGYNetEnd : doScene fail");
            this.callback.onSceneEnd(3, -1, "", this);
          }
          AppMethodBeat.o(217577);
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
    AppMethodBeat.o(217577);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.c
 * JD-Core Version:    0.7.0.1
 */