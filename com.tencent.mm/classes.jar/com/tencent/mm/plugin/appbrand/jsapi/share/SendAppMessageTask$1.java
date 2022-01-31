package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.a;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.g.b.a.dd;
import com.tencent.mm.g.b.a.dd.a;
import com.tencent.mm.g.b.a.dd.b;
import com.tencent.mm.g.b.a.dd.c;
import com.tencent.mm.g.b.a.dd.d;
import com.tencent.mm.g.b.a.dd.e;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.protocal.protobuf.czx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class SendAppMessageTask$1
  implements w.a
{
  SendAppMessageTask$1(SendAppMessageTask paramSendAppMessageTask, LinkedList paramLinkedList, j.b paramb, int paramInt, byte[] paramArrayOfByte, StringBuilder paramStringBuilder) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(131460);
    ab.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (czp)paramb.fsW.fta;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (!bo.es(paramString.ygq)))
    {
      paramb = paramString.ygq;
      this.ial.iah = new ArrayList();
      paramInt1 = 0;
      if (paramInt1 < this.iai.size())
      {
        if (paramInt1 < paramb.size())
        {
          paramString = (czx)paramb.get(paramInt1);
          label120:
          this.iaj.fjd = paramString.xMI;
          this.ial.iah.add(new ShareInfo(paramString.xMI, paramString.ygD));
          paramm = (a)this.iaj.R(a.class);
          paramm.fff = paramString.ygo;
          if ((paramString.ygo) && (paramString.ygE != null))
          {
            paramm.ffg = paramString.ygE.content;
            paramm.ffh = paramString.ygE.xMC;
            paramm.ffi = paramString.ygE.xMD;
            paramm.ffj = paramString.ygE.xME;
            paramm.ffk = paramString.ygE.xMF;
            paramm.ffl = paramString.ygE.xMH;
            paramm.ffn = paramString.ygE.state;
            paramm.ffm = paramString.ygE.xMG;
            paramm = new dd().iu(this.ial.appId).iv(this.ial.path).iw(paramString.xMI).ix((String)this.iai.get(paramInt1));
            if (!((String)this.iai.get(paramInt1)).toLowerCase().endsWith("@chatroom")) {
              break label497;
            }
          }
        }
        label497:
        for (paramString = dd.c.deK;; paramString = dd.c.deL)
        {
          paramm.deq = paramString;
          paramm.der = dd.b.deE;
          paramm.cRG = this.fwD;
          paramString = paramm.iy(this.ial.cmF);
          paramString.dev = dd.a.hn(this.ial.fmF + 1000);
          paramString = paramString.Hl();
          paramString.det = dd.d.deO;
          paramString.deu = dd.e.deS;
          paramString.ake();
          SendAppMessageTask.a(this.ial, this.iaj, this.fdr, (String)this.iai.get(paramInt1), this.iak, this.fwD);
          paramInt1 += 1;
          break;
          paramString = new czx();
          break label120;
        }
      }
    }
    else
    {
      if (this.iaj.fiZ == 3) {
        this.iaj.fiZ = 2;
      }
      paramString = this.iai.iterator();
      while (paramString.hasNext())
      {
        paramb = (String)paramString.next();
        SendAppMessageTask.a(this.ial, this.iaj, this.fdr, paramb, this.iak, this.fwD);
      }
    }
    SendAppMessageTask.a(this.ial);
    AppMethodBeat.o(131460);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask.1
 * JD-Core Version:    0.7.0.1
 */