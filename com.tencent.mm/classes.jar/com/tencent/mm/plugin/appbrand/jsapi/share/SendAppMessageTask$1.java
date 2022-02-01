package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.qo;
import com.tencent.mm.f.b.a.qo.a;
import com.tencent.mm.f.b.a.qo.b;
import com.tencent.mm.f.b.a.qo.c;
import com.tencent.mm.f.b.a.qo.d;
import com.tencent.mm.f.b.a.qo.e;
import com.tencent.mm.protocal.protobuf.eht;
import com.tencent.mm.protocal.protobuf.esg;
import com.tencent.mm.protocal.protobuf.fnk;
import com.tencent.mm.protocal.protobuf.fns;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class SendAppMessageTask$1
  implements aa.a
{
  SendAppMessageTask$1(SendAppMessageTask paramSendAppMessageTask, LinkedList paramLinkedList, k.b paramb, int paramInt, byte[] paramArrayOfByte, StringBuilder paramStringBuilder) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(46796);
    Log.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (fnk)d.c.b(paramd.lBS);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (!Util.isNullOrNil(paramString.ULP)))
    {
      paramq = paramString.ULP;
      this.pqF.pqB = new ArrayList();
      paramInt1 = 0;
      if (paramInt1 < this.pqC.size())
      {
        label120:
        a locala;
        qo localqo;
        if (paramInt1 < paramq.size())
        {
          paramString = (fns)paramq.get(paramInt1);
          this.pqD.loG = paramString.UjS;
          this.pqF.pqB.add(new ShareInfo(paramString.UjS, paramString.UMd));
          locala = (a)this.pqD.ar(a.class);
          locala.lkc = paramString.ULL;
          locala.lkp = paramString.ULO;
          if ((paramString.ULL) && (paramString.UMe != null))
          {
            locala.lkd = paramString.UMe.content;
            locala.lke = paramString.UMe.UjM;
            locala.lkf = paramString.UMe.UjN;
            locala.lkg = paramString.UMe.UjO;
            locala.lkh = paramString.UMe.UjP;
            locala.lki = paramString.UMe.UjR;
            locala.lkk = paramString.UMe.state;
            locala.lkj = paramString.UMe.UjQ;
            localqo = new qo().Hv(this.pqF.appId).Hw(this.pqF.path).Hx(paramString.UjS).Hy((String)this.pqC.get(paramInt1));
            if (!((String)this.pqC.get(paramInt1)).toLowerCase().endsWith("@chatroom")) {
              break label551;
            }
          }
        }
        label551:
        for (paramd = qo.c.hld;; paramd = qo.c.hle)
        {
          localqo.hkJ = paramd;
          localqo.hkK = qo.b.hkX;
          localqo.gnP = this.iWM;
          paramd = localqo.Hz(this.pqF.fvd);
          paramd.hkO = qo.a.pj(this.pqF.serviceType + 1000);
          paramd = paramd.aoX();
          paramd.hkM = qo.d.hlh;
          paramd.hkN = qo.e.hll;
          paramd.bpa();
          if ((paramString.ULN) && (paramString.UMf != null) && (paramString.UMf.Uua)) {
            locala.lkm = paramString.UMf.Uub;
          }
          SendAppMessageTask.a(this.pqF, this.pqD, this.lid, (String)this.pqC.get(paramInt1), this.pqE, this.iWM);
          paramInt1 += 1;
          break;
          paramString = new fns();
          break label120;
        }
      }
    }
    else
    {
      if (this.pqD.loC == 3) {
        this.pqD.loC = 2;
      }
      paramString = this.pqC.iterator();
      while (paramString.hasNext())
      {
        paramd = (String)paramString.next();
        SendAppMessageTask.a(this.pqF, this.pqD, this.lid, paramd, this.pqE, this.iWM);
      }
    }
    SendAppMessageTask.a(this.pqF);
    AppMethodBeat.o(46796);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask.1
 * JD-Core Version:    0.7.0.1
 */