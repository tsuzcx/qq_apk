package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.x.a;
import com.tencent.mm.g.b.a.ij;
import com.tencent.mm.g.b.a.ij.a;
import com.tencent.mm.g.b.a.ij.b;
import com.tencent.mm.g.b.a.ij.c;
import com.tencent.mm.g.b.a.ij.d;
import com.tencent.mm.g.b.a.ij.e;
import com.tencent.mm.protocal.protobuf.cyh;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.protocal.protobuf.dzw;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    ac.i("MicroMsg.SendAppMessageTask", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    paramString = (dzw)paramb.hvs.hvw;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString != null) && (!bs.gY(paramString.GfT)))
    {
      paramn = paramString.GfT;
      this.kMm.kMi = new ArrayList();
      paramInt1 = 0;
      if (paramInt1 < this.kMj.size())
      {
        label120:
        a locala;
        ij localij;
        if (paramInt1 < paramn.size())
        {
          paramString = (eae)paramn.get(paramInt1);
          this.kMk.hkk = paramString.FHE;
          this.kMm.kMi.add(new ShareInfo(paramString.FHE, paramString.Gge));
          locala = (a)this.kMk.ao(a.class);
          locala.hfQ = paramString.GfQ;
          if ((paramString.GfQ) && (paramString.Ggf != null))
          {
            locala.hfR = paramString.Ggf.content;
            locala.hfS = paramString.Ggf.FHy;
            locala.hfT = paramString.Ggf.FHz;
            locala.hfU = paramString.Ggf.FHA;
            locala.hfV = paramString.Ggf.FHB;
            locala.hfW = paramString.Ggf.FHD;
            locala.hfY = paramString.Ggf.state;
            locala.hfX = paramString.Ggf.FHC;
            localij = new ij().px(this.kMm.appId).py(this.kMm.path).pz(paramString.FHE).pA((String)this.kMj.get(paramInt1));
            if (!((String)this.kMj.get(paramInt1)).toLowerCase().endsWith("@chatroom")) {
              break label542;
            }
          }
        }
        label542:
        for (paramb = ij.c.ekJ;; paramb = ij.c.ekK)
        {
          localij.ekp = paramb;
          localij.ekq = ij.b.ekD;
          localij.dHY = this.fsL;
          paramb = localij.pB(this.kMm.cYP);
          paramb.eku = ij.a.jw(this.kMm.cFI + 1000);
          paramb = paramb.Tf();
          paramb.eks = ij.d.ekN;
          paramb.ekt = ij.e.ekR;
          paramb.aHZ();
          if ((paramString.GfS) && (paramString.Ggg != null) && (paramString.Ggg.FQR)) {
            locala.hga = paramString.Ggg.FQS;
          }
          SendAppMessageTask.a(this.kMm, this.kMk, this.hea, (String)this.kMj.get(paramInt1), this.kMl, this.fsL);
          paramInt1 += 1;
          break;
          paramString = new eae();
          break label120;
        }
      }
    }
    else
    {
      if (this.kMk.hkg == 3) {
        this.kMk.hkg = 2;
      }
      paramString = this.kMj.iterator();
      while (paramString.hasNext())
      {
        paramb = (String)paramString.next();
        SendAppMessageTask.a(this.kMm, this.kMk, this.hea, paramb, this.kMl, this.fsL);
      }
    }
    SendAppMessageTask.a(this.kMm);
    AppMethodBeat.o(46796);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.SendAppMessageTask.1
 * JD-Core Version:    0.7.0.1
 */