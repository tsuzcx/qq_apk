package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.dpd;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;

public final class ac
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  public long hTj;
  public b rr;
  
  public ac(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt2)
  {
    this(paramInt1, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramInt2, true);
  }
  
  public ac(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    AppMethodBeat.i(43059);
    this.hTj = 0L;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dpc();
    ((b.a)localObject).hvu = new dpd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/newverifypasswd";
    ((b.a)localObject).funcId = 384;
    ((b.a)localObject).reqCmdId = 182;
    ((b.a)localObject).respCmdId = 1000000182;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dpc)this.rr.hvr.hvw;
    ((dpc)localObject).OpCode = paramInt1;
    ((dpc)localObject).FHb = paramInt2;
    ((dpc)localObject).FWu = bs.aLt(paramString1);
    ((dpc)localObject).DYS = bs.aLs(paramString1);
    ((dpc)localObject).EVt = new crm().aJV(paramString2);
    ((dpc)localObject).FWv = new crm().aJV(paramString3);
    ((dpc)localObject).DYW = new crm().aJV(paramString4);
    if ((paramInt1 == 5) || (paramInt1 == 2))
    {
      this.hTj = new p(u.axv()).longValue();
      if (paramBoolean1)
      {
        paramString1 = com.tencent.mm.kernel.g.agP().afQ().e(this.hTj, paramString3);
        ((dpc)localObject).DWx = new SKBuiltinBuffer_t().setBuffer(paramString1);
      }
    }
    else
    {
      paramString1 = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(47, null));
      ((dpc)localObject).DYX = new SKBuiltinBuffer_t().setBuffer(bs.aLu(paramString1));
      paramInt2 = ((dpc)localObject).OpCode;
      if (((dpc)localObject).DWx != null) {
        break label387;
      }
      paramInt1 = -1;
      label301:
      if (((dpc)localObject).DWx != null) {
        break label399;
      }
    }
    label387:
    label399:
    for (paramString1 = "null";; paramString1 = bs.aLJ(bs.cu(((dpc)localObject).DWx.getBufferToBytes())))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneVerifyPswd", "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt1), paramString1 });
      AppMethodBeat.o(43059);
      return;
      paramString1 = com.tencent.mm.kernel.g.agP().afQ().a(this.hTj, bs.aLt(paramString1), paramBoolean2);
      break;
      paramInt1 = ((dpc)localObject).DWx.getILen();
      break label301;
    }
  }
  
  public ac(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(1, paramString1, paramString2, paramString3, paramString4, false, 0);
  }
  
  public final String aEr()
  {
    AppMethodBeat.i(43061);
    try
    {
      String str = ((dpd)this.rr.hvs.hvw).Ewu;
      AppMethodBeat.o(43061);
      return str;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", localException, "", new Object[0]);
      AppMethodBeat.o(43061);
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(43060);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(43060);
    return i;
  }
  
  public final int getType()
  {
    return 384;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43062);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (dpc)this.rr.hvr.hvw;
    paramq = (dpd)this.rr.hvs.hvw;
    if ((paramq.DTC != null) && (paramq.DTC.getILen() > 0)) {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.agP().afQ().a(this.hTj, com.tencent.mm.platformtools.z.a(paramq.DTC))), Integer.valueOf(paramq.DTC.getILen()) });
    }
    int i;
    label269:
    int j;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.agR().agA().set(77830, paramq.Ewu);
      com.tencent.mm.kernel.g.agR().agA().set(32, paramArrayOfByte.FWu);
      com.tencent.mm.kernel.g.agR().agA().set(33, paramArrayOfByte.DYS);
      com.tencent.mm.kernel.g.agR().agA().set(46, bs.cx(com.tencent.mm.platformtools.z.a(paramq.DTI)));
      paramArrayOfByte = bs.cx(com.tencent.mm.platformtools.z.a(paramArrayOfByte.DYX));
      com.tencent.mm.kernel.g.agR().agA().set(47, paramArrayOfByte);
      com.tencent.mm.kernel.g.agR().ghx.set(18, paramArrayOfByte);
      com.tencent.mm.kernel.g.agR().agA().set(-1535680990, paramq.DTH);
      if (paramq.DTI == null)
      {
        paramInt1 = 0;
        if (paramq.DTH != null) {
          break label348;
        }
        i = 0;
        if (paramq.Ewu != null) {
          break label361;
        }
        j = 0;
        label280:
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(j) });
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(43062);
      return;
      paramInt1 = paramq.DTI.getILen();
      break;
      label348:
      i = paramq.DTH.length();
      break label269;
      label361:
      j = paramq.Ewu.length();
      break label280;
      if (paramInt2 == 4)
      {
        com.tencent.mm.kernel.g.agR().agA().set(32, "");
        com.tencent.mm.kernel.g.agR().agA().set(33, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ac
 * JD-Core Version:    0.7.0.1
 */