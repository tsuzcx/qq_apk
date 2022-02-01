package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.protocal.protobuf.jw;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private List<String> aPu;
  private com.tencent.mm.ak.g callback;
  private final int hLG;
  private final int hLH;
  private final int hLI;
  private final int hLJ;
  private final int hLK;
  public List<String> hLL;
  private int hLM;
  public int hLN;
  private int index;
  public int op;
  private com.tencent.mm.ak.b rr;
  private int type;
  
  public c(List<String> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209602);
    this.hLG = 1000;
    this.hLH = 0;
    this.hLI = 1;
    this.hLJ = 2;
    this.hLK = 3;
    this.hLL = new LinkedList();
    this.aPu = paramList;
    this.type = 8388608;
    this.op = paramInt1;
    this.index = 0;
    this.hLN = paramList.size();
    this.hLM = paramInt2;
    AppMethodBeat.o(209602);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(209603);
    this.callback = paramg;
    paramg = new b.a();
    paramg.uri = "/cgi-bin/micromsg-bin/batchmodcontacttype";
    paramg.funcId = 3990;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    paramg.hvt = new jw();
    paramg.hvu = new jx();
    this.rr = paramg.aAz();
    paramg = (jw)this.rr.hvr.hvw;
    paramg.DXl = new LinkedList();
    int i = 0;
    while ((i < this.hLM) && (this.aPu.size() > 0))
    {
      bvb localbvb = new bvb();
      localbvb.ncR = ((String)this.aPu.remove(0));
      localbvb.FkY = this.type;
      localbvb.FkZ = this.op;
      paramg.DXl.add(localbvb);
      i += 1;
    }
    paramg.DXk = paramg.DXl.size();
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(209603);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209604);
    ac.i("MicroMsg.NetSceneBatchModContactType", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((jx)this.rr.hvs.hvw).DXn.iterator();
      paramInt1 = 0;
      while (paramq.hasNext())
      {
        paramArrayOfByte = (bvc)paramq.next();
        if (paramArrayOfByte.Ret == 0)
        {
          com.tencent.mm.kernel.g.agS();
          ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramArrayOfByte.Fla.ncR);
          if ((localai != null) && (com.tencent.mm.n.b.ln(localai.field_type)))
          {
            if (paramArrayOfByte.Fla.FkZ == 1) {
              localai.aaw();
            }
            for (;;)
            {
              com.tencent.mm.kernel.g.agS();
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(localai.field_username, localai);
              this.hLL.add(localai.field_username);
              break;
              localai.aax();
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
        if (this.aPu.size() > 0)
        {
          if (doScene(dispatcher(), this.callback) < 0)
          {
            ac.e("MicroMsg.NetSceneBatchModContactType", "onGYNetEnd : doScene fail");
            this.callback.onSceneEnd(3, -1, "", this);
          }
          AppMethodBeat.o(209604);
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
    AppMethodBeat.o(209604);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.c
 * JD-Core Version:    0.7.0.1
 */