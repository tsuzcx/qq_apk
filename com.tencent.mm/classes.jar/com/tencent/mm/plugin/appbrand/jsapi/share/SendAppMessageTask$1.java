package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.g.b.a.gr;
import com.tencent.mm.g.b.a.gr.a;
import com.tencent.mm.g.b.a.gr.b;
import com.tencent.mm.g.b.a.gr.c;
import com.tencent.mm.g.b.a.gr.d;
import com.tencent.mm.g.b.a.gr.e;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.protocal.protobuf.dcj;
import com.tencent.mm.protocal.protobuf.duf;
import com.tencent.mm.protocal.protobuf.dun;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class SendAppMessageTask$1
  implements x.a
{
  SendAppMessageTask$1(SendAppMessageTask paramSendAppMessageTask, LinkedList paramLinkedList, k.b paramb, int paramInt, byte[] paramArrayOfByte, StringBuilder paramStringBuilder) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, n paramn)
  {
    AppMethodBeat.i(46796);
    ad.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (duf)paramb.gUT.gUX;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (!bt.gL(paramString.EIH)))
    {
      paramn = paramString.EIH;
      this.kkU.kkQ = new ArrayList();
      paramInt1 = 0;
      if (paramInt1 < this.kkR.size())
      {
        label120:
        a locala;
        gr localgr;
        if (paramInt1 < paramn.size())
        {
          paramString = (dun)paramn.get(paramInt1);
          this.kkS.gJK = paramString.EkG;
          this.kkU.kkQ.add(new ShareInfo(paramString.EkG, paramString.EIS));
          locala = (a)this.kkS.ao(a.class);
          locala.gFp = paramString.EIE;
          if ((paramString.EIE) && (paramString.EIT != null))
          {
            locala.gFq = paramString.EIT.content;
            locala.gFr = paramString.EIT.EkA;
            locala.gFs = paramString.EIT.EkB;
            locala.gFt = paramString.EIT.EkC;
            locala.gFu = paramString.EIT.EkD;
            locala.gFv = paramString.EIT.EkF;
            locala.gFx = paramString.EIT.state;
            locala.gFw = paramString.EIT.EkE;
            localgr = new gr().mr(this.kkU.appId).ms(this.kkU.path).mt(paramString.EkG).mu((String)this.kkR.get(paramInt1));
            if (!((String)this.kkR.get(paramInt1)).toLowerCase().endsWith("@chatroom")) {
              break label542;
            }
          }
        }
        label542:
        for (paramb = gr.c.eiF;; paramb = gr.c.eiG)
        {
          localgr.eil = paramb;
          localgr.eim = gr.b.eiz;
          localgr.dKe = this.fpl;
          paramb = localgr.mv(this.kkU.dbt);
          paramb.eiq = gr.a.jy(this.kkU.cIB + 1000);
          paramb = paramb.Sm();
          paramb.eio = gr.d.eiJ;
          paramb.eip = gr.e.eiN;
          paramb.aBj();
          if ((paramString.EIG) && (paramString.EIU != null) && (paramString.EIU.EtP)) {
            locala.gFz = paramString.EIU.EtQ;
          }
          SendAppMessageTask.a(this.kkU, this.kkS, this.gDz, (String)this.kkR.get(paramInt1), this.kkT, this.fpl);
          paramInt1 += 1;
          break;
          paramString = new dun();
          break label120;
        }
      }
    }
    else
    {
      if (this.kkS.gJG == 3) {
        this.kkS.gJG = 2;
      }
      paramString = this.kkR.iterator();
      while (paramString.hasNext())
      {
        paramb = (String)paramString.next();
        SendAppMessageTask.a(this.kkU, this.kkS, this.gDz, paramb, this.kkT, this.fpl);
      }
    }
    SendAppMessageTask.a(this.kkU);
    AppMethodBeat.o(46796);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask.1
 * JD-Core Version:    0.7.0.1
 */