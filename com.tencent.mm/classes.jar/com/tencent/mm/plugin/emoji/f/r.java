package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.emoji.c.d.a;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.w;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import junit.framework.Assert;

public final class r
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.al.g callback;
  private EmojiInfo ddq;
  boolean frM;
  private long hgs;
  boolean ozd;
  private final com.tencent.mm.al.b rr;
  
  public r(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong)
  {
    this(paramString1, paramString2, paramEmojiInfo, paramLong, (byte)0);
  }
  
  private r(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong, byte paramByte)
  {
    AppMethodBeat.i(108723);
    this.frM = true;
    this.ozd = false;
    this.hgs = 0L;
    boolean bool;
    Object localObject;
    acz localacz;
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramEmojiInfo != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.hgs = paramLong;
      this.ddq = paramEmojiInfo;
      localObject = new b.a();
      ((b.a)localObject).gUU = new dhh();
      ((b.a)localObject).gUV = new dhi();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendemoji";
      ((b.a)localObject).funcId = 175;
      ((b.a)localObject).reqCmdId = 68;
      ((b.a)localObject).respCmdId = 1000000068;
      this.rr = ((b.a)localObject).atI();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.a(aj.getContext(), paramEmojiInfo);
      localObject = (dhh)this.rr.gUS.gUX;
      localacz = new acz();
      ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", new Object[] { paramEmojiInfo.JS(), Integer.valueOf(paramEmojiInfo.field_size) });
      localacz.MD5 = paramEmojiInfo.JS();
      localacz.DdF = paramString1;
      localacz.sdP = paramString2;
      localacz.uKQ = paramEmojiInfo.field_size;
      localacz.DdD = paramEmojiInfo.getContent();
      localacz.mBH = paramEmojiInfo.field_type;
      localacz.CxC = bk.SM();
      localacz.DdG = 0;
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(paramString2)) {
        localacz.COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(paramString2);
      }
      if (!w.pF(paramString2)) {
        break label381;
      }
      paramByte = 2;
      label320:
      if (paramEmojiInfo.field_catalog != EmojiInfo.LBV) {
        break label387;
      }
      localacz.DdE = "56,2,".concat(String.valueOf(paramByte));
    }
    for (;;)
    {
      ((dhh)localObject).DdI.add(localacz);
      ((dhh)localObject).ExA = ((dhh)localObject).DdI.size();
      AppMethodBeat.o(108723);
      return;
      bool = false;
      break;
      label381:
      paramByte = 1;
      break label320;
      label387:
      if (paramEmojiInfo.field_catalog == EmojiInfo.LBU) {
        localacz.DdE = "56,1,".concat(String.valueOf(paramByte));
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(108724);
    this.callback = paramg;
    acz localacz = (acz)((dhh)this.rr.gUS.gUX).DdI.get(0);
    if (this.frM)
    {
      ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + localacz.MD5);
      localacz.DdC = new SKBuiltinBuffer_t();
      localacz.uKR = 0;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108724);
      return i;
    }
    int j = this.ddq.field_size - this.ddq.field_start;
    int i = j;
    if (j > 8192) {
      i = 8192;
    }
    if ((this.ddq.field_reserved4 & EmojiInfo.LCl) == EmojiInfo.LCl)
    {
      byte[] arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.ddq);
      if (!bt.cw(arrayOfByte))
      {
        paramg = new byte[i];
        ad.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
        System.arraycopy(arrayOfByte, this.ddq.field_start, paramg, 0, i);
      }
    }
    while ((com.tencent.mm.plugin.emoji.h.b.aW(paramg) == EmojiInfo.LBM) && (this.frM))
    {
      ad.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
      this.ddq.fZN();
      AppMethodBeat.o(108724);
      return -1;
      ad.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
      paramg = new byte[0];
      continue;
      paramg = this.ddq.lk(this.ddq.field_start, i);
    }
    if ((paramg == null) || (paramg.length <= 0))
    {
      ad.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
      AppMethodBeat.o(108724);
      return -1;
    }
    i = paramg.length;
    localacz.uKR = this.ddq.field_start;
    localacz.DdC = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bx.b.cd(paramg));
    if (com.tencent.mm.am.f.pc(localacz.sdP))
    {
      paramg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.hgs);
      localacz.CxC = a.a.Wh().o(paramg);
      ad.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[] { localacz.CxC });
    }
    ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.ddq.field_start + ", total:" + this.ddq.field_size + ", len:" + i);
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108724);
    return i;
  }
  
  public final int getType()
  {
    return 175;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108725);
    ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramArrayOfByte = (dhh)((com.tencent.mm.al.b)paramq).gUS.gUX;
    paramq = (dhi)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.COU);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramArrayOfByte.DdI.size() != paramq.DdI.size())
    {
      ad.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + paramq.DdI.size() + ", resp size:" + paramArrayOfByte.DdI.size());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    paramString = (ada)paramq.DdI.get(0);
    if ((paramString.MD5 == null) || (!paramString.MD5.equals(this.ddq.JS())) || (paramString.uKR < this.ddq.field_start))
    {
      ad.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + paramString.uKR + ", size=" + this.ddq.field_size);
      this.callback.onSceneEnd(4, -2, "", this);
      this.ddq.field_start = 0;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.M(this.ddq);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramq.BaseResponse.Ret != 0)
    {
      ad.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[] { Integer.valueOf(paramq.BaseResponse.Ret) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.uKR >= paramString.uKQ)
    {
      ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + paramString.DdH);
      paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().rm(this.hgs);
      ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramString.uKZ), Integer.valueOf(ab.hVD) });
      if ((10007 == ab.hVC) && (ab.hVD != 0))
      {
        paramString.DdH = ab.hVD;
        ab.hVD = 0;
      }
      paramq.kX(paramString.uKZ);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().a(this.hgs, paramq);
      this.ddq.field_start = 0;
      this.ddq.field_lastUseTime = System.currentTimeMillis();
      this.ddq.field_state = EmojiInfo.LCe;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.M(this.ddq);
      if (paramq.cxB()) {
        com.tencent.mm.modelstat.b.huc.b(paramq, com.tencent.mm.ai.l.r(paramq));
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108725);
        return;
        com.tencent.mm.modelstat.b.huc.q(paramq);
      }
    }
    if (com.tencent.mm.emoji.a.l.abG())
    {
      if (this.ozd)
      {
        this.callback.onSceneEnd(4, -2, "", this);
        AppMethodBeat.o(108725);
        return;
      }
      new com.tencent.mm.emoji.c.f(this.ddq, false, new d.a()
      {
        public final void y(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(108722);
          if (paramAnonymousInt == 0)
          {
            r.this.ozd = true;
            r.this.frM = true;
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
    if (this.frM) {
      this.frM = false;
    }
    this.ddq.field_start = paramString.uKR;
    this.ddq.field_lastUseTime = System.currentTimeMillis();
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.M(this.ddq);
    if (doScene(dispatcher(), this.callback) < 0) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(108725);
  }
  
  public final int securityLimitCount()
  {
    return 256;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.r
 * JD-Core Version:    0.7.0.1
 */