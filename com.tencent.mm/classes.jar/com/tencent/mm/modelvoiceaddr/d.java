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
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fza;
import com.tencent.mm.protocal.protobuf.fzb;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends a
  implements m
{
  private com.tencent.mm.am.h callback;
  private String filename;
  private long oNa;
  private int oUy;
  MTimerHandler orP;
  private boolean pdm;
  private boolean pfn;
  private int pfo;
  private String[] pfp;
  private int retCode;
  private c rr;
  
  public d(String paramString, int paramInt)
  {
    AppMethodBeat.i(148526);
    this.retCode = 0;
    this.oUy = 0;
    this.filename = null;
    this.oNa = -1L;
    this.pfn = false;
    this.pdm = false;
    this.pfp = new String[0];
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148525);
        long l = y.bEl(d.a(d.this));
        Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.aPX() + " onTimerExpired: file:" + d.a(d.this) + " nowlen:" + l + " oldoff:" + d.b(d.this) + " isFin:" + d.c(d.this));
        if ((l - d.b(d.this) < 3300L) && (!d.c(d.this)))
        {
          AppMethodBeat.o(148525);
          return true;
        }
        if (d.this.doScene(d.d(d.this), d.e(d.this)) == -1)
        {
          d.a(d.this, com.tencent.mm.compatible.util.f.getLine() + 40000);
          d.e(d.this).onSceneEnd(3, -1, "doScene failed", d.this);
        }
        AppMethodBeat.o(148525);
        return false;
      }
    }, true);
    this.oNa = Util.nowMilliSecond();
    this.filename = paramString;
    this.pfo = paramInt;
    AppMethodBeat.o(148526);
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
    AppMethodBeat.i(148527);
    this.callback = paramh;
    long l = y.bEl(this.filename);
    Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.aPX() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.oUy + " isFin:" + this.pdm);
    if (l <= 0L)
    {
      Log.e("MicroMsg.NetSceneVoiceAddr", "read failed :" + this.filename);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
    }
    int j = (int)(l - this.oUy);
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.aPX() + " read file:" + this.filename + " filelen:" + l + " oldoff:" + this.oUy + " isFin:" + this.pdm + " endFlag:" + this.pfn);
      paramh = y.bi(this.filename, this.oUy, i);
      if (paramh != null) {
        break;
      }
      Log.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.aPX() + " read failed :" + this.filename + " read:" + i);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
      AppMethodBeat.o(148527);
      return -1;
      if ((j < 3300) && (!this.pdm))
      {
        Log.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.aPX() + " read failed :" + this.filename + "can read:" + j + " isfinish:" + this.pdm);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 40000);
        AppMethodBeat.o(148527);
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
    ((c.a)localObject).otE = new fza();
    ((c.a)localObject).otF = new fzb();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/voiceaddr";
    ((c.a)localObject).funcId = 206;
    ((c.a)localObject).otG = 94;
    ((c.a)localObject).respCmdId = 1000000094;
    this.rr = ((c.a)localObject).bEF();
    localObject = (fza)c.b.b(this.rr.otB);
    ((fza)localObject).NkQ = new gol().df(paramh);
    Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.aPX() + " read file:" + this.filename + " readlen:" + paramh.length + " datalen:" + ((fza)localObject).NkQ.aaxD.toByteArray().length + " dataiLen:" + ((fza)localObject).NkQ.abwJ + " md5:" + com.tencent.mm.b.g.getMessageDigest(paramh) + " datamd5:" + com.tencent.mm.b.g.getMessageDigest(((fza)localObject).NkQ.aaxD.toByteArray()));
    ((fza)localObject).UserName = ((String)com.tencent.mm.kernel.h.baE().ban().d(2, ""));
    ((fza)localObject).YYs = this.oUy;
    ((fza)localObject).abRF = this.oNa;
    if (this.pfn) {}
    for (int i = 1;; i = 0)
    {
      ((fza)localObject).oOu = i;
      ((fza)localObject).abRG = 0;
      ((fza)localObject).YIH = 0;
      ((fza)localObject).abRH = 0;
      ((fza)localObject).YIE = 0;
      ((fza)localObject).abWy = this.pfo;
      Log.d("MicroMsg.NetSceneVoiceAddr", "clientId " + this.oNa);
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(148527);
      return i;
    }
  }
  
  public final int getType()
  {
    return 206;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148529);
    Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.aPX() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    paramArrayOfByte = (fza)c.b.b(((c)params).otB);
    params = (fzb)c.c.b(((c)params).otC);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.aPX() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    Log.d("MicroMsg.NetSceneVoiceAddr", com.tencent.mm.compatible.util.f.aPX() + " onGYNetEnd  file:" + this.filename + " endflag:" + params.oOu + " lst:" + params.YFl);
    if (paramArrayOfByte.oOu == 1)
    {
      this.pfp = new String[params.YFl.size()];
      paramInt1 = 0;
      while (paramInt1 < params.YFl.size())
      {
        this.pfp[paramInt1] = ((etl)params.YFl.get(paramInt1)).abwM;
        paramInt1 += 1;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148529);
      return;
    }
    paramInt1 = paramArrayOfByte.YYs;
    this.oUy = (paramArrayOfByte.NkQ.abwJ + paramInt1);
    if (this.pdm) {}
    for (long l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneVoiceAddr", "onGYNetEnd file:" + this.filename + " delay:" + l);
      this.orP.startTimer(l);
      AppMethodBeat.o(148529);
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
    AppMethodBeat.i(148528);
    this.callback.onSceneEnd(3, com.tencent.mm.compatible.util.f.getLine() + 40000, "ecurityCheckError", this);
    AppMethodBeat.o(148528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.d
 * JD-Core Version:    0.7.0.1
 */