package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.emoji.c.d.a;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.x;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.protocal.protobuf.dtl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import junit.framework.Assert;

public final class r
  extends n
  implements k
{
  com.tencent.mm.ak.f callback;
  private EmojiInfo dnk;
  boolean fQG;
  private long icx;
  boolean pMR;
  private final com.tencent.mm.ak.b rr;
  
  public r(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong)
  {
    this(paramString1, paramString2, paramEmojiInfo, paramLong, (byte)0);
  }
  
  private r(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong, byte paramByte)
  {
    AppMethodBeat.i(108723);
    this.fQG = true;
    this.pMR = false;
    this.icx = 0L;
    boolean bool;
    Object localObject;
    agq localagq;
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramEmojiInfo != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.icx = paramLong;
      this.dnk = paramEmojiInfo;
      localObject = new b.a();
      ((b.a)localObject).hQF = new dtk();
      ((b.a)localObject).hQG = new dtl();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendemoji";
      ((b.a)localObject).funcId = 175;
      ((b.a)localObject).hQH = 68;
      ((b.a)localObject).respCmdId = 1000000068;
      this.rr = ((b.a)localObject).aDS();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.a(ak.getContext(), paramEmojiInfo);
      localObject = (dtk)this.rr.hQD.hQJ;
      localagq = new agq();
      ae.i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", new Object[] { paramEmojiInfo.Lj(), Integer.valueOf(paramEmojiInfo.field_size) });
      localagq.MD5 = paramEmojiInfo.Lj();
      localagq.GwV = paramString1;
      localagq.uvF = paramString2;
      localagq.xsB = paramEmojiInfo.field_size;
      localagq.GwT = paramEmojiInfo.getContent();
      localagq.nJA = paramEmojiInfo.field_type;
      localagq.FNL = bn.We();
      localagq.GwW = 0;
      if (((s)com.tencent.mm.kernel.g.ad(s.class)).ifAddTicketByActionFlag(paramString2)) {
        localagq.Ghk = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().aUV(paramString2);
      }
      if (!x.wb(paramString2)) {
        break label381;
      }
      paramByte = 2;
      label320:
      if (paramEmojiInfo.field_catalog != EmojiInfo.OzZ) {
        break label387;
      }
      localagq.GwU = "56,2,".concat(String.valueOf(paramByte));
    }
    for (;;)
    {
      ((dtk)localObject).GwY.add(localagq);
      ((dtk)localObject).HZd = ((dtk)localObject).GwY.size();
      AppMethodBeat.o(108723);
      return;
      bool = false;
      break;
      label381:
      paramByte = 1;
      break label320;
      label387:
      if (paramEmojiInfo.field_catalog == EmojiInfo.OzY) {
        localagq.GwU = "56,1,".concat(String.valueOf(paramByte));
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(108724);
    this.callback = paramf;
    agq localagq = (agq)((dtk)this.rr.hQD.hQJ).GwY.get(0);
    if (this.fQG)
    {
      ae.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + localagq.MD5);
      localagq.GwS = new SKBuiltinBuffer_t();
      localagq.xsC = 0;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108724);
      return i;
    }
    int j = this.dnk.field_size - this.dnk.field_start;
    int i = j;
    if (j > 8192) {
      i = 8192;
    }
    if ((this.dnk.field_reserved4 & EmojiInfo.OAp) == EmojiInfo.OAp)
    {
      byte[] arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dnk);
      if (!bu.cF(arrayOfByte))
      {
        paramf = new byte[i];
        ae.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
        System.arraycopy(arrayOfByte, this.dnk.field_start, paramf, 0, i);
      }
    }
    while ((com.tencent.mm.plugin.emoji.h.b.bc(paramf) == EmojiInfo.OzQ) && (this.fQG))
    {
      ae.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
      this.dnk.fxo();
      AppMethodBeat.o(108724);
      return -1;
      ae.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
      paramf = new byte[0];
      continue;
      paramf = this.dnk.jD(this.dnk.field_start, i);
    }
    if ((paramf == null) || (paramf.length <= 0))
    {
      ae.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
      AppMethodBeat.o(108724);
      return -1;
    }
    i = paramf.length;
    localagq.xsC = this.dnk.field_start;
    localagq.GwS = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cm(paramf));
    if (com.tencent.mm.al.g.vz(localagq.uvF))
    {
      paramf = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(this.icx);
      localagq.FNL = a.a.ZP().o(paramf);
      ae.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[] { localagq.FNL });
    }
    ae.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.dnk.field_start + ", total:" + this.dnk.field_size + ", len:" + i);
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108724);
    return i;
  }
  
  public final int getType()
  {
    return 175;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108725);
    ae.i("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramArrayOfByte = (dtk)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    paramq = (dtl)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((s)com.tencent.mm.kernel.g.ad(s.class)).setEnSendMsgActionFlag(paramq.Ghl);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramArrayOfByte.GwY.size() != paramq.GwY.size())
    {
      ae.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + paramq.GwY.size() + ", resp size:" + paramArrayOfByte.GwY.size());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    paramString = (agr)paramq.GwY.get(0);
    if ((paramString.MD5 == null) || (!paramString.MD5.equals(this.dnk.Lj())) || (paramString.xsC < this.dnk.field_start))
    {
      ae.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + paramString.xsC + ", size=" + this.dnk.field_size);
      this.callback.onSceneEnd(4, -2, "", this);
      this.dnk.field_start = 0;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.L(this.dnk);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramq.BaseResponse.Ret != 0)
    {
      ae.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[] { Integer.valueOf(paramq.BaseResponse.Ret) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.Ret != 0)
    {
      ae.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd: respInfo Ret %s", new Object[] { Integer.valueOf(paramString.Ret) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.xsC >= paramString.xsB)
    {
      ae.i("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + paramString.GwX);
      paramq = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(this.icx);
      ae.i("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramString.xrk), Integer.valueOf(ac.iRI) });
      if ((10007 == ac.iRH) && (ac.iRI != 0))
      {
        paramString.GwX = ac.iRI;
        ac.iRI = 0;
      }
      paramq.qM(paramString.xrk);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().a(this.icx, paramq);
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.aWl(this.dnk.field_md5);
      if (paramString != null) {
        break label939;
      }
      paramString = this.dnk;
    }
    label939:
    for (;;)
    {
      paramString.field_start = 0;
      paramString.field_lastUseTime = System.currentTimeMillis();
      paramString.field_state = EmojiInfo.OAi;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.L(paramString);
      if (paramq.cVH()) {
        com.tencent.mm.modelstat.b.iqT.b(paramq, com.tencent.mm.ah.l.r(paramq));
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108725);
        return;
        com.tencent.mm.modelstat.b.iqT.q(paramq);
      }
      if (m.afx())
      {
        if (this.pMR)
        {
          this.callback.onSceneEnd(4, -2, "", this);
          AppMethodBeat.o(108725);
          return;
        }
        new com.tencent.mm.emoji.c.f(this.dnk, false, new d.a()
        {
          public final void y(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(108722);
            if (paramAnonymousInt == 0)
            {
              r.this.pMR = true;
              r.this.fQG = true;
              if (r.this.doScene(r.this.dispatcher(), r.this.callback) < 0)
              {
                r.this.callback.onSceneEnd(3, -1, "", r.this);
                AppMethodBeat.o(108722);
              }
            }
            else
            {
              r.this.callback.onSceneEnd(4, -2, "", r.this);
            }
            AppMethodBeat.o(108722);
          }
        });
        AppMethodBeat.o(108725);
        return;
      }
      if (this.fQG) {
        this.fQG = false;
      }
      this.dnk.field_start = paramString.xsC;
      this.dnk.field_lastUseTime = System.currentTimeMillis();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.L(this.dnk);
      if (doScene(dispatcher(), this.callback) < 0) {
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(108725);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 256;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.r
 * JD-Core Version:    0.7.0.1
 */