package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.emoji.a.m;
import com.tencent.mm.emoji.c.d.a;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.w;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.agi;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.protocal.protobuf.dso;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import junit.framework.Assert;

public final class r
  extends n
  implements k
{
  com.tencent.mm.al.f callback;
  private EmojiInfo dmi;
  boolean fOA;
  private long hZF;
  boolean pGn;
  private final com.tencent.mm.al.b rr;
  
  public r(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong)
  {
    this(paramString1, paramString2, paramEmojiInfo, paramLong, (byte)0);
  }
  
  private r(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong, byte paramByte)
  {
    AppMethodBeat.i(108723);
    this.fOA = true;
    this.pGn = false;
    this.hZF = 0L;
    boolean bool;
    Object localObject;
    agh localagh;
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramEmojiInfo != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.hZF = paramLong;
      this.dmi = paramEmojiInfo;
      localObject = new b.a();
      ((b.a)localObject).hNM = new dsn();
      ((b.a)localObject).hNN = new dso();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendemoji";
      ((b.a)localObject).funcId = 175;
      ((b.a)localObject).hNO = 68;
      ((b.a)localObject).respCmdId = 1000000068;
      this.rr = ((b.a)localObject).aDC();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.a(aj.getContext(), paramEmojiInfo);
      localObject = (dsn)this.rr.hNK.hNQ;
      localagh = new agh();
      ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", new Object[] { paramEmojiInfo.Lb(), Integer.valueOf(paramEmojiInfo.field_size) });
      localagh.MD5 = paramEmojiInfo.Lb();
      localagh.Geo = paramString1;
      localagh.uki = paramString2;
      localagh.xcK = paramEmojiInfo.field_size;
      localagh.Gem = paramEmojiInfo.getContent();
      localagh.nEf = paramEmojiInfo.field_type;
      localagh.Fvn = bl.VW();
      localagh.Gep = 0;
      if (((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).ifAddTicketByActionFlag(paramString2)) {
        localagh.FOL = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTu(paramString2);
      }
      if (!w.vF(paramString2)) {
        break label381;
      }
      paramByte = 2;
      label320:
      if (paramEmojiInfo.field_catalog != EmojiInfo.OeS) {
        break label387;
      }
      localagh.Gen = "56,2,".concat(String.valueOf(paramByte));
    }
    for (;;)
    {
      ((dsn)localObject).Ger.add(localagh);
      ((dsn)localObject).HFq = ((dsn)localObject).Ger.size();
      AppMethodBeat.o(108723);
      return;
      bool = false;
      break;
      label381:
      paramByte = 1;
      break label320;
      label387:
      if (paramEmojiInfo.field_catalog == EmojiInfo.OeR) {
        localagh.Gen = "56,1,".concat(String.valueOf(paramByte));
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(108724);
    this.callback = paramf;
    agh localagh = (agh)((dsn)this.rr.hNK.hNQ).Ger.get(0);
    if (this.fOA)
    {
      ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + localagh.MD5);
      localagh.Gel = new SKBuiltinBuffer_t();
      localagh.xcL = 0;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108724);
      return i;
    }
    int j = this.dmi.field_size - this.dmi.field_start;
    int i = j;
    if (j > 8192) {
      i = 8192;
    }
    if ((this.dmi.field_reserved4 & EmojiInfo.Ofi) == EmojiInfo.Ofi)
    {
      byte[] arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dmi);
      if (!bt.cC(arrayOfByte))
      {
        paramf = new byte[i];
        ad.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
        System.arraycopy(arrayOfByte, this.dmi.field_start, paramf, 0, i);
      }
    }
    while ((com.tencent.mm.plugin.emoji.h.b.bd(paramf) == EmojiInfo.OeJ) && (this.fOA))
    {
      ad.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
      this.dmi.fOv();
      AppMethodBeat.o(108724);
      return -1;
      ad.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
      paramf = new byte[0];
      continue;
      paramf = this.dmi.lG(this.dmi.field_start, i);
    }
    if ((paramf == null) || (paramf.length <= 0))
    {
      ad.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
      AppMethodBeat.o(108724);
      return -1;
    }
    i = paramf.length;
    localagh.xcL = this.dmi.field_start;
    localagh.Gel = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bx.b.cj(paramf));
    if (com.tencent.mm.am.g.vd(localagh.uki))
    {
      paramf = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(this.hZF);
      localagh.Fvn = a.a.ZG().o(paramf);
      ad.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[] { localagh.Fvn });
    }
    ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.dmi.field_start + ", total:" + this.dmi.field_size + ", len:" + i);
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
    ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramArrayOfByte = (dsn)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    paramq = (dso)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.r)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.r.class)).setEnSendMsgActionFlag(paramq.FOM);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramArrayOfByte.Ger.size() != paramq.Ger.size())
    {
      ad.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + paramq.Ger.size() + ", resp size:" + paramArrayOfByte.Ger.size());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    paramString = (agi)paramq.Ger.get(0);
    if ((paramString.MD5 == null) || (!paramString.MD5.equals(this.dmi.Lb())) || (paramString.xcL < this.dmi.field_start))
    {
      ad.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + paramString.xcL + ", size=" + this.dmi.field_size);
      this.callback.onSceneEnd(4, -2, "", this);
      this.dmi.field_start = 0;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.L(this.dmi);
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
    if (paramString.Ret != 0)
    {
      ad.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd: respInfo Ret %s", new Object[] { Integer.valueOf(paramString.Ret) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.xcL >= paramString.xcK)
    {
      ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + paramString.Geq);
      paramq = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(this.hZF);
      ad.i("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramString.xbt), Integer.valueOf(ac.iOO) });
      if ((10007 == ac.iON) && (ac.iOO != 0))
      {
        paramString.Geq = ac.iOO;
        ac.iOO = 0;
      }
      paramq.qz(paramString.xbt);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().a(this.hZF, paramq);
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.aUK(this.dmi.field_md5);
      if (paramString != null) {
        break label939;
      }
      paramString = this.dmi;
    }
    label939:
    for (;;)
    {
      paramString.field_start = 0;
      paramString.field_lastUseTime = System.currentTimeMillis();
      paramString.field_state = EmojiInfo.Ofb;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.L(paramString);
      if (paramq.cTc()) {
        com.tencent.mm.modelstat.b.inZ.b(paramq, com.tencent.mm.ai.l.r(paramq));
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108725);
        return;
        com.tencent.mm.modelstat.b.inZ.q(paramq);
      }
      if (m.afj())
      {
        if (this.pGn)
        {
          this.callback.onSceneEnd(4, -2, "", this);
          AppMethodBeat.o(108725);
          return;
        }
        new com.tencent.mm.emoji.c.f(this.dmi, false, new d.a()
        {
          public final void y(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(108722);
            if (paramAnonymousInt == 0)
            {
              r.this.pGn = true;
              r.this.fOA = true;
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
      if (this.fOA) {
        this.fOA = false;
      }
      this.dmi.field_start = paramString.xcL;
      this.dmi.field_lastUseTime = System.currentTimeMillis();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.L(this.dmi);
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
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.r
 * JD-Core Version:    0.7.0.1
 */