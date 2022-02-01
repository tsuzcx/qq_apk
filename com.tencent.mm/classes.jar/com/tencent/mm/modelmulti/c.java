package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.jq;
import com.tencent.mm.protocal.protobuf.jr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends n
  implements com.tencent.mm.network.k
{
  private List<String> aOE;
  private com.tencent.mm.al.g callback;
  private final int hld;
  private final int hle;
  private final int hlf;
  private final int hlg;
  private final int hlh;
  public List<String> hli;
  private int hlj;
  public int hlk;
  private int index;
  public int op;
  private com.tencent.mm.al.b rr;
  private int type;
  
  public c(List<String> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193546);
    this.hld = 1000;
    this.hle = 0;
    this.hlf = 1;
    this.hlg = 2;
    this.hlh = 3;
    this.hli = new LinkedList();
    this.aOE = paramList;
    this.type = 8388608;
    this.op = paramInt1;
    this.index = 0;
    this.hlk = paramList.size();
    this.hlj = paramInt2;
    AppMethodBeat.o(193546);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(193547);
    this.callback = paramg;
    paramg = new b.a();
    paramg.uri = "/cgi-bin/micromsg-bin/batchmodcontacttype";
    paramg.funcId = 3990;
    paramg.reqCmdId = 0;
    paramg.respCmdId = 0;
    paramg.gUU = new jq();
    paramg.gUV = new jr();
    this.rr = paramg.atI();
    paramg = (jq)this.rr.gUS.gUX;
    paramg.CEL = new LinkedList();
    int i = 0;
    while ((i < this.hlj) && (this.aOE.size() > 0))
    {
      bqk localbqk = new bqk();
      localbqk.mAQ = ((String)this.aOE.remove(0));
      localbqk.DOH = this.type;
      localbqk.DOI = this.op;
      paramg.CEL.add(localbqk);
      i += 1;
    }
    paramg.CEK = paramg.CEL.size();
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(193547);
    return i;
  }
  
  public final int getType()
  {
    return 3990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(193548);
    ad.i("MicroMsg.NetSceneBatchModContactType", "errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = ((jr)this.rr.gUT.gUX).CEN.iterator();
      paramInt1 = 0;
      while (paramq.hasNext())
      {
        paramArrayOfByte = (bql)paramq.next();
        if (paramArrayOfByte.Ret == 0)
        {
          com.tencent.mm.kernel.g.afC();
          af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramArrayOfByte.DOJ.mAQ);
          if ((localaf != null) && (com.tencent.mm.n.b.ls(localaf.field_type)))
          {
            if (paramArrayOfByte.DOJ.DOI == 1) {
              localaf.ZB();
            }
            for (;;)
            {
              com.tencent.mm.kernel.g.afC();
              ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(localaf.field_username, localaf);
              this.hli.add(localaf.field_username);
              break;
              localaf.ZC();
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
        if (this.aOE.size() > 0)
        {
          if (doScene(dispatcher(), this.callback) < 0)
          {
            ad.e("MicroMsg.NetSceneBatchModContactType", "onGYNetEnd : doScene fail");
            this.callback.onSceneEnd(3, -1, "", this);
          }
          AppMethodBeat.o(193548);
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
    AppMethodBeat.o(193548);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelmulti.c
 * JD-Core Version:    0.7.0.1
 */