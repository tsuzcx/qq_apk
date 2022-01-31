package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.mm.ae.a;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.h.b.a.aw;
import com.tencent.mm.h.b.a.aw.a;
import com.tencent.mm.h.b.a.aw.b;
import com.tencent.mm.h.b.a.aw.c;
import com.tencent.mm.h.b.a.aw.d;
import com.tencent.mm.protocal.c.brv;
import com.tencent.mm.protocal.c.cly;
import com.tencent.mm.protocal.c.cmg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class SendAppMessageTask$1
  implements w.a
{
  SendAppMessageTask$1(SendAppMessageTask paramSendAppMessageTask, LinkedList paramLinkedList, g.a parama, int paramInt, byte[] paramArrayOfByte, StringBuilder paramStringBuilder) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    y.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (cly)paramb.ecF.ecN;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (!bk.dk(paramString.tYU)))
    {
      paramb = paramString.tYU;
      this.gBT.gBO = new ArrayList();
      paramInt1 = 0;
      if (paramInt1 < this.gBP.size())
      {
        if (paramInt1 < paramb.size())
        {
          paramString = (cmg)paramb.get(paramInt1);
          label115:
          this.gBQ.dTe = paramString.tIu;
          this.gBT.gBO.add(new ShareInfo(paramString.tIu, paramString.tZh));
          if ((paramString.tYS) && (paramString.tZi != null))
          {
            paramm = (a)this.gBQ.A(a.class);
            paramm.dPH = paramString.tZi.content;
            paramm.dPI = paramString.tZi.tIo;
            paramm.dPJ = paramString.tZi.tIp;
            paramm.dPK = paramString.tZi.tIq;
            paramm.dPL = paramString.tZi.tIr;
            paramm.dPM = paramString.tZi.tIt;
            paramm.dPO = paramString.tZi.state;
            paramm.dPN = paramString.tZi.tIs;
            paramm = new aw();
            paramm.ckG = this.gBT.appId;
            paramm.cpZ = this.gBT.path;
            paramm.cqb = paramString.tIu;
            paramm.cqc = ((String)this.gBP.get(paramInt1));
            if (!((String)this.gBP.get(paramInt1)).toLowerCase().endsWith("@chatroom")) {
              break label473;
            }
          }
        }
        label473:
        for (paramString = aw.b.cqo;; paramString = aw.b.cqp)
        {
          paramm.cqd = paramString;
          paramm.cqe = aw.a.cqi;
          paramm.cic = this.egz;
          paramm.cqf = this.gBT.bFv;
          paramString = paramm.ve();
          paramString.cqg = aw.c.cqs;
          paramString.cqh = aw.d.cqw;
          paramString.QX();
          SendAppMessageTask.a(this.gBT, this.gBQ, this.gBR, (String)this.gBP.get(paramInt1), this.gBS, this.egz);
          paramInt1 += 1;
          break;
          paramString = new cmg();
          break label115;
        }
      }
    }
    else
    {
      if (this.gBQ.dTa == 3) {
        this.gBQ.dTa = 2;
      }
      paramString = this.gBP.iterator();
      while (paramString.hasNext())
      {
        paramb = (String)paramString.next();
        SendAppMessageTask.a(this.gBT, this.gBQ, this.gBR, paramb, this.gBS, this.egz);
      }
    }
    SendAppMessageTask.a(this.gBT);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask.1
 * JD-Core Version:    0.7.0.1
 */