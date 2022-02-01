package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.l;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.emoji.a.m;
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
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.protocal.protobuf.adz;
import com.tencent.mm.protocal.protobuf.dmw;
import com.tencent.mm.protocal.protobuf.dmx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import junit.framework.Assert;

public final class r
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.ak.g callback;
  private EmojiInfo daO;
  boolean fvt;
  private long hGV;
  boolean pcD;
  private final com.tencent.mm.ak.b rr;
  
  public r(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong)
  {
    this(paramString1, paramString2, paramEmojiInfo, paramLong, (byte)0);
  }
  
  private r(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong, byte paramByte)
  {
    AppMethodBeat.i(108723);
    this.fvt = true;
    this.pcD = false;
    this.hGV = 0L;
    boolean bool;
    Object localObject;
    ady localady;
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramEmojiInfo != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.hGV = paramLong;
      this.daO = paramEmojiInfo;
      localObject = new b.a();
      ((b.a)localObject).hvt = new dmw();
      ((b.a)localObject).hvu = new dmx();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendemoji";
      ((b.a)localObject).funcId = 175;
      ((b.a)localObject).reqCmdId = 68;
      ((b.a)localObject).respCmdId = 1000000068;
      this.rr = ((b.a)localObject).aAz();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.a(ai.getContext(), paramEmojiInfo);
      localObject = (dmw)this.rr.hvr.hvw;
      localady = new ady();
      ac.i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", new Object[] { paramEmojiInfo.JC(), Integer.valueOf(paramEmojiInfo.field_size) });
      localady.MD5 = paramEmojiInfo.JC();
      localady.EwL = paramString1;
      localady.tlJ = paramString2;
      localady.vTH = paramEmojiInfo.field_size;
      localady.EwJ = paramEmojiInfo.getContent();
      localady.ndI = paramEmojiInfo.field_type;
      localady.DPY = bk.TG();
      localady.EwM = 0;
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(paramString2)) {
        localady.EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(paramString2);
      }
      if (!w.sQ(paramString2)) {
        break label381;
      }
      paramByte = 2;
      label320:
      if (paramEmojiInfo.field_catalog != EmojiInfo.Jsx) {
        break label387;
      }
      localady.EwK = "56,2,".concat(String.valueOf(paramByte));
    }
    for (;;)
    {
      ((dmw)localObject).EwO.add(localady);
      ((dmw)localObject).FUC = ((dmw)localObject).EwO.size();
      AppMethodBeat.o(108723);
      return;
      bool = false;
      break;
      label381:
      paramByte = 1;
      break label320;
      label387:
      if (paramEmojiInfo.field_catalog == EmojiInfo.Jsw) {
        localady.EwK = "56,1,".concat(String.valueOf(paramByte));
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(108724);
    this.callback = paramg;
    ady localady = (ady)((dmw)this.rr.hvr.hvw).EwO.get(0);
    if (this.fvt)
    {
      ac.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + localady.MD5);
      localady.EwI = new SKBuiltinBuffer_t();
      localady.vTI = 0;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108724);
      return i;
    }
    int j = this.daO.field_size - this.daO.field_start;
    int i = j;
    if (j > 8192) {
      i = 8192;
    }
    if ((this.daO.field_reserved4 & EmojiInfo.Kgm) == EmojiInfo.Kgm)
    {
      byte[] arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.daO);
      if (!bs.cv(arrayOfByte))
      {
        paramg = new byte[i];
        ac.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
        System.arraycopy(arrayOfByte, this.daO.field_start, paramg, 0, i);
      }
    }
    while ((com.tencent.mm.plugin.emoji.h.b.aV(paramg) == EmojiInfo.Jso) && (this.fvt))
    {
      ac.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
      this.daO.fdq();
      AppMethodBeat.o(108724);
      return -1;
      ac.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
      paramg = new byte[0];
      continue;
      paramg = this.daO.jn(this.daO.field_start, i);
    }
    if ((paramg == null) || (paramg.length <= 0))
    {
      ac.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
      AppMethodBeat.o(108724);
      return -1;
    }
    i = paramg.length;
    localady.vTI = this.daO.field_start;
    localady.EwI = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cc(paramg));
    if (com.tencent.mm.al.f.so(localady.tlJ))
    {
      paramg = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.hGV);
      localady.DPY = a.a.Xf().o(paramg);
      ac.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[] { localady.DPY });
    }
    ac.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.daO.field_start + ", total:" + this.daO.field_size + ", len:" + i);
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
    ac.i("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramArrayOfByte = (dmw)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    paramq = (dmx)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.EhF);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramArrayOfByte.EwO.size() != paramq.EwO.size())
    {
      ac.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + paramq.EwO.size() + ", resp size:" + paramArrayOfByte.EwO.size());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    paramString = (adz)paramq.EwO.get(0);
    if ((paramString.MD5 == null) || (!paramString.MD5.equals(this.daO.JC())) || (paramString.vTI < this.daO.field_start))
    {
      ac.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + paramString.vTI + ", size=" + this.daO.field_size);
      this.callback.onSceneEnd(4, -2, "", this);
      this.daO.field_start = 0;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.M(this.daO);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramq.BaseResponse.Ret != 0)
    {
      ac.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[] { Integer.valueOf(paramq.BaseResponse.Ret) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.Ret != 0)
    {
      ac.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd: respInfo Ret %s", new Object[] { Integer.valueOf(paramString.Ret) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.vTI >= paramString.vTH)
    {
      ac.i("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + paramString.EwN);
      paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().vP(this.hGV);
      ac.i("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramString.vTQ), Integer.valueOf(ab.ivH) });
      if ((10007 == ab.ivG) && (ab.ivH != 0))
      {
        paramString.EwN = ab.ivH;
        ab.ivH = 0;
      }
      paramq.oz(paramString.vTQ);
      ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().a(this.hGV, paramq);
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.aOT(this.daO.field_md5);
      if (paramString != null) {
        break label939;
      }
      paramString = this.daO;
    }
    label939:
    for (;;)
    {
      paramString.field_start = 0;
      paramString.field_lastUseTime = System.currentTimeMillis();
      paramString.field_state = EmojiInfo.Kgf;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.M(paramString);
      if (paramq.cKN()) {
        com.tencent.mm.modelstat.b.hUE.b(paramq, l.r(paramq));
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108725);
        return;
        com.tencent.mm.modelstat.b.hUE.q(paramq);
      }
      if (m.acF())
      {
        if (this.pcD)
        {
          this.callback.onSceneEnd(4, -2, "", this);
          AppMethodBeat.o(108725);
          return;
        }
        new com.tencent.mm.emoji.c.f(this.daO, false, new d.a()
        {
          public final void y(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(108722);
            if (paramAnonymousInt == 0)
            {
              r.this.pcD = true;
              r.this.fvt = true;
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
      if (this.fvt) {
        this.fvt = false;
      }
      this.daO.field_start = paramString.vTI;
      this.daO.field_lastUseTime = System.currentTimeMillis();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.M(this.daO);
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
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.r
 * JD-Core Version:    0.7.0.1
 */