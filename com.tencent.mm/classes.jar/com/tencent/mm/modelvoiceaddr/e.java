package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ftn;
import com.tencent.mm.protocal.protobuf.fto;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.y;
import java.util.List;

public final class e
  extends a
  implements m
{
  private com.tencent.mm.am.h callback;
  private int encodeType;
  private String filename;
  private long oNa;
  private int oUy;
  MTimerHandler orP;
  private boolean pdm;
  private boolean pfn;
  private String[] pfp;
  private int retCode;
  private c rr;
  
  public e(String paramString, int paramInt)
  {
    AppMethodBeat.i(148531);
    this.retCode = 0;
    this.pdm = false;
    this.oUy = 0;
    this.filename = null;
    this.oNa = -1L;
    this.pfn = false;
    this.encodeType = 0;
    this.pfp = new String[0];
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148530);
        long l = y.bEl(e.a(e.this));
        Log.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.aPX() + " onTimerExpired: file:" + e.a(e.this) + " nowlen:" + l + " oldoff:" + e.b(e.this) + " isFin:" + e.c(e.this));
        if ((l - e.b(e.this) < 3300L) && (!e.c(e.this)))
        {
          AppMethodBeat.o(148530);
          return true;
        }
        if (e.this.doScene(e.d(e.this), e.e(e.this)) == -1)
        {
          e.a(e.this, com.tencent.mm.compatible.util.f.getLine() + 40000);
          e.e(e.this).onSceneEnd(3, -1, "doScene failed", e.this);
        }
        AppMethodBeat.o(148530);
        return false;
      }
    }, true);
    this.oNa = Util.nowMilliSecond().hashCode();
    this.filename = paramString;
    this.encodeType = paramInt;
    AppMethodBeat.o(148531);
  }
  
  public final void bPq()
  {
    this.pdm = true;
  }
  
  public final String[] bPr()
  {
    return this.pfp;
  }
  
  public final long bPs()
  {
    return this.oNa;
  }
  
  public final int bPt()
  {
    return this.retCode;
  }
  
  public final List<String> bPu()
  {
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(148532);
    this.callback = paramh;
    int k = (int)y.bEl(this.filename);
    Log.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %d, isFin: %b", new Object[] { this.filename, Integer.valueOf(k), Integer.valueOf(this.oUy), Boolean.valueOf(this.pdm) });
    if (k <= 0)
    {
      Log.e("MicroMsg.NetSceneVoiceInput", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
    }
    int j = k - this.oUy;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneVoiceInput", "read file: %s, filelen: %d, oldoff: %b, isFin:%b, endFlag: %b", new Object[] { this.filename, Integer.valueOf(k), Boolean.valueOf(this.pdm), Boolean.valueOf(this.pdm), Boolean.valueOf(this.pfn) });
      paramh = y.bi(this.filename, this.oUy, i);
      if (paramh != null) {
        break;
      }
      Log.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.aPX() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148532);
      return -1;
      if ((j < 3300) && (!this.pdm))
      {
        Log.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.aPX() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.pdm);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        AppMethodBeat.o(148532);
        return -1;
      }
      i = j;
      if (this.pdm)
      {
        this.pfn = true;
        i = j;
      }
    }
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ftn();
    ((c.a)localObject).otF = new fto();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((c.a)localObject).funcId = 349;
    ((c.a)localObject).otG = 158;
    ((c.a)localObject).respCmdId = 1000000158;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ftn)c.b.b(this.rr.otB);
    ((ftn)localObject).UserName = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
    ((ftn)localObject).NkQ = new gol().df(paramh);
    Log.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.aPX() + " read file:" + this.filename + " readlen:" + paramh.length + " datalen:" + ((ftn)localObject).NkQ.aaxD.toByteArray().length + " dataiLen:" + ((ftn)localObject).NkQ.abwJ + " md5:" + com.tencent.mm.b.g.getMessageDigest(paramh) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((ftn)localObject).NkQ.aaxD.toByteArray()));
    ((ftn)localObject).YYs = this.oUy;
    ((ftn)localObject).abRF = this.oNa;
    if (this.pfn) {}
    for (int i = 1;; i = 0)
    {
      ((ftn)localObject).oOu = i;
      ((ftn)localObject).abRG = 0;
      ((ftn)localObject).YIH = 0;
      ((ftn)localObject).abRH = this.encodeType;
      ((ftn)localObject).YIE = 0;
      Log.d("MicroMsg.NetSceneVoiceInput", "clientId " + this.oNa);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148532);
      return i;
    }
  }
  
  public final int getType()
  {
    return 349;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148534);
    Log.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (ftn)c.b.b(((c)params).otB);
    params = (fto)c.c.b(((c)params).otC);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.aPX() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    Log.d("MicroMsg.NetSceneVoiceInput", com.tencent.mm.compatible.util.f.aPX() + " onGYNetEnd  file:" + this.filename + " endflag:" + params.oOu);
    if (paramArrayOfByte.oOu == 1)
    {
      if ((params.abRI != null) && (params.abRI.aaxD != null)) {
        this.pfp = new String[] { params.abRI.aaxD.ZV() };
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148534);
      return;
    }
    paramInt1 = paramArrayOfByte.YYs;
    this.oUy = (paramArrayOfByte.NkQ.abwJ + paramInt1);
    if (this.pdm) {}
    for (long l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneVoiceInput", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.orP.startTimer(l);
      AppMethodBeat.o(148534);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(148533);
    this.callback.onSceneEnd(3, com.tencent.mm.compatible.util.f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.e
 * JD-Core Version:    0.7.0.1
 */