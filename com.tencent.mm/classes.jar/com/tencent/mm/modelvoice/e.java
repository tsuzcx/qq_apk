package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.w;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public final class e
  extends n
  implements k
{
  private static au iwc;
  private static List<c> iwd;
  private com.tencent.mm.al.f callback;
  private String dDy;
  public String fileName;
  private av hMj;
  private String iwb;
  private boolean iwe;
  private boolean iwf;
  public int retCode;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(148415);
    iwc = null;
    iwd = new ArrayList();
    AppMethodBeat.o(148415);
  }
  
  public e(r paramr)
  {
    AppMethodBeat.i(148408);
    this.retCode = 0;
    this.iwe = false;
    this.iwf = false;
    this.hMj = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(148404);
        if (e.this.doScene(e.a(e.this), e.b(e.this)) == -1) {
          e.b(e.this).onSceneEnd(3, -1, "doScene failed", e.this);
        }
        AppMethodBeat.o(148404);
        return false;
      }
    }, false);
    if (paramr != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      this.fileName = paramr.fileName;
      if (this.fileName == null) {
        break label141;
      }
    }
    label141:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.iwb = paramr.iwb;
      this.dDy = paramr.dDy;
      ad.i("MicroMsg.NetSceneDownloadVoice", "NetSceneDownloadVoice[%s]:  file[%s] voiceFormat[%s] user[%s]", new Object[] { toString(), this.fileName, this.iwb, this.dDy });
      AppMethodBeat.o(148408);
      return;
      bool = false;
      break;
    }
  }
  
  public static void a(au paramau)
  {
    if (iwc == null) {
      iwc = paramau;
    }
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(148405);
    if (!iwd.contains(paramc)) {
      iwd.add(paramc);
    }
    AppMethodBeat.o(148405);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(148406);
    iwd.remove(paramc);
    AppMethodBeat.o(148406);
  }
  
  private void doNotify()
  {
    AppMethodBeat.i(148407);
    final bu localbu = s.HZ(this.fileName);
    if (localbu != null)
    {
      if (iwc != null) {
        iwc.a(localbu);
      }
      Iterator localIterator = iwd.iterator();
      while (localIterator.hasNext()) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148403);
            this.iwg.Y(localbu);
            AppMethodBeat.o(148403);
          }
        });
      }
    }
    AppMethodBeat.o(148407);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(148409);
    this.callback = paramf;
    if (this.fileName == null)
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    paramf = s.Ia(this.fileName);
    if ((paramf == null) || (!paramf.aNB()))
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    ad.i("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " netTimes:" + paramf.iug);
    if (!s.HQ(this.fileName))
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "checkVoiceNetTimes Failed file:" + this.fileName);
      s.Hp(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    int i = paramf.isJ - paramf.iua;
    if (i <= 0)
    {
      if (paramf.status == 5)
      {
        this.iwf = true;
        ad.e("MicroMsg.NetSceneDownloadVoice", "doScene file:" + this.fileName + " Net:" + paramf.isJ + " Local:" + paramf.iua);
        this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
        AppMethodBeat.o(148409);
        return -1;
      }
      s.a(this.fileName, paramf.iua, null);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(148409);
      return -1;
    }
    if (paramf.hMP == paramf.isJ) {
      this.iwe = true;
    }
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new afh();
    ((b.a)localObject).hNN = new afi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/downloadvoice";
    ((b.a)localObject).funcId = 128;
    ((b.a)localObject).hNO = 20;
    ((b.a)localObject).respCmdId = 1000000020;
    this.rr = ((b.a)localObject).aDC();
    localObject = (afh)this.rr.hNK.hNQ;
    ((afh)localObject).Fwt = paramf.clientId;
    ((afh)localObject).xbt = paramf.dAY;
    ((afh)localObject).FIg = i;
    ((afh)localObject).FMu = paramf.iua;
    if (w.vF(this.dDy))
    {
      ((afh)localObject).FuL = this.dDy;
      ((afh)localObject).Gdr = paramf.ixo;
    }
    ad.i("MicroMsg.NetSceneDownloadVoice", "[%s]doScene req.ClientMsgId:%s req.MsgId:%d req.NewMsgId:%d, req.Length:%d req.Offset:%d req.ChatRoomName:%s req.MasterBufId %d", new Object[] { toString(), ((afh)localObject).Fwt, Integer.valueOf(((afh)localObject).xbr), Long.valueOf(((afh)localObject).xbt), Integer.valueOf(((afh)localObject).FIg), Integer.valueOf(((afh)localObject).FMu), ((afh)localObject).FuL, Long.valueOf(((afh)localObject).Gdr) });
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(148409);
    return i;
  }
  
  public final int getType()
  {
    return 128;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(148413);
    ad.i("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd[" + toString() + "] file:" + this.fileName + " + id:" + paramInt1 + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (afi)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if (paramArrayOfByte.Gds == 1)
    {
      ad.v("MicroMsg.NetSceneDownloadVoice", this.fileName + " cancelFlag = 1");
      s.HV(this.fileName);
      AppMethodBeat.o(148413);
      return;
    }
    if (paramInt3 == -22)
    {
      s.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      g.yhR.idkeyStat(111L, 231L, 1L, false);
      s.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      g.yhR.idkeyStat(111L, 230L, 1L, false);
      ad.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3 + " resp:" + paramq.getRespObj().getRetCode());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    ad.d("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + " Recv:" + paramArrayOfByte.xcN.getILen() + " fileOff:" + paramArrayOfByte.FMu);
    if (paramArrayOfByte.xcN.getBuffer() == null)
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd get recv Buffer null");
      s.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramq = paramArrayOfByte.xcN.getBuffer().toByteArray();
    if (paramq.length == 0)
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Recv Buf ZERO length ");
      s.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    paramInt1 = s.bA(this.iwb, this.fileName).write(paramq, paramq.length, paramArrayOfByte.FMu);
    if (paramInt1 < 0)
    {
      ad.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd Write Failed File:" + this.fileName + " ret:" + paramInt1);
      s.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    s.a(this.fileName, paramq, paramq.length);
    ad.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd : file:" + this.fileName + " filesize:" + paramInt1 + " voiceFormat:" + this.iwb);
    paramInt1 = s.a(this.fileName, paramInt1, null);
    ad.i("MicroMsg.NetSceneDownloadVoice", "OnRecvEnd[" + toString() + "] : file:%s ret:%s", new Object[] { this.fileName, Integer.valueOf(paramInt1) });
    if (paramInt1 < 0)
    {
      g.yhR.idkeyStat(111L, 229L, 1L, false);
      ad.e("MicroMsg.NetSceneDownloadVoice", "onGYNetEnd file:" + this.fileName + "updateAfterRecv Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    if (paramInt1 == 1)
    {
      doNotify();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(148413);
      return;
    }
    long l = 1000L;
    if (this.iwe) {
      l = 0L;
    }
    this.hMj.az(l, l);
    AppMethodBeat.o(148413);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final boolean securityLimitCountReach()
  {
    AppMethodBeat.i(148412);
    boolean bool = super.securityLimitCountReach();
    if (bool) {
      g.yhR.idkeyStat(111L, 232L, 1L, false);
    }
    AppMethodBeat.o(148412);
    return bool;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(148410);
    paramq = (afh)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    if ((paramq.xbt == 0L) || (paramq.Fwt == null) || (paramq.Fwt.length() == 0) || (paramq.FIg <= 0) || (paramq.FMu < 0))
    {
      s.Hp(this.fileName);
      paramq = n.b.hOq;
      AppMethodBeat.o(148410);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(148410);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(148411);
    g.yhR.idkeyStat(111L, 233L, 1L, false);
    s.Hp(this.fileName);
    AppMethodBeat.o(148411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.e
 * JD-Core Version:    0.7.0.1
 */