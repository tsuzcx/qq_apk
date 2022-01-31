package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.l.a.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.t;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.coc;
import com.tencent.mm.protocal.protobuf.zl;
import com.tencent.mm.protocal.protobuf.zm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import junit.framework.Assert;

public final class r
  extends m
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ai.f callback;
  private EmojiInfo cos;
  private long fDU;
  private boolean lis;
  private final com.tencent.mm.ai.b rr;
  
  public r(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong)
  {
    this(paramString1, paramString2, paramEmojiInfo, paramLong, (byte)0);
  }
  
  private r(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong, byte paramByte)
  {
    AppMethodBeat.i(53150);
    this.lis = true;
    this.fDU = 0L;
    boolean bool;
    Object localObject;
    zl localzl;
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramEmojiInfo != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.fDU = paramLong;
      this.cos = paramEmojiInfo;
      localObject = new b.a();
      ((b.a)localObject).fsX = new cob();
      ((b.a)localObject).fsY = new coc();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendemoji";
      ((b.a)localObject).funcId = 175;
      ((b.a)localObject).reqCmdId = 68;
      ((b.a)localObject).respCmdId = 1000000068;
      this.rr = ((b.a)localObject).ado();
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.a(ah.getContext(), paramEmojiInfo);
      localObject = (cob)this.rr.fsV.fta;
      localzl = new zl();
      ab.i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", new Object[] { paramEmojiInfo.Al(), Integer.valueOf(paramEmojiInfo.field_size) });
      localzl.wQr = paramEmojiInfo.Al();
      localzl.wQv = paramString1;
      localzl.nul = paramString2;
      localzl.pIx = paramEmojiInfo.field_size;
      localzl.wQt = paramEmojiInfo.getContent();
      localzl.jKs = paramEmojiInfo.field_type;
      localzl.woU = bh.aaQ();
      localzl.wQw = 0;
      if (!t.lA(paramString2)) {
        break label335;
      }
      paramByte = 2;
      label274:
      if (paramEmojiInfo.field_catalog != EmojiInfo.yPl) {
        break label341;
      }
      localzl.wQu = "56,2,".concat(String.valueOf(paramByte));
    }
    for (;;)
    {
      ((cob)localObject).wQy.add(localzl);
      ((cob)localObject).xWT = ((cob)localObject).wQy.size();
      AppMethodBeat.o(53150);
      return;
      bool = false;
      break;
      label335:
      paramByte = 1;
      break label274;
      label341:
      if (paramEmojiInfo.field_catalog == EmojiInfo.yPk) {
        localzl.wQu = "56,1,".concat(String.valueOf(paramByte));
      }
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(53151);
    this.callback = paramf;
    zl localzl = (zl)((cob)this.rr.fsV.fta).wQy.get(0);
    if (this.lis)
    {
      ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + localzl.wQr);
      localzl.wQs = new SKBuiltinBuffer_t();
      localzl.pIy = 0;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(53151);
      return i;
    }
    int j = this.cos.field_size - this.cos.field_start;
    int i = j;
    if (j > 8192) {
      i = 8192;
    }
    if ((this.cos.field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx)
    {
      byte[] arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l(this.cos);
      if (!bo.ce(arrayOfByte))
      {
        paramf = new byte[i];
        ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
        System.arraycopy(arrayOfByte, this.cos.field_start, paramf, 0, i);
      }
    }
    while ((com.tencent.mm.plugin.emoji.h.b.aG(paramf) == EmojiInfo.yPc) && (this.lis))
    {
      ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
      this.cos.dzo();
      AppMethodBeat.o(53151);
      return -1;
      ab.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
      paramf = new byte[0];
      continue;
      paramf = this.cos.ho(this.cos.field_start, i);
    }
    if ((paramf == null) || (paramf.length <= 0))
    {
      ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
      AppMethodBeat.o(53151);
      return -1;
    }
    i = paramf.length;
    localzl.pIy = this.cos.field_start;
    localzl.wQs = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bv.b.bL(paramf));
    if (com.tencent.mm.aj.f.lg(localzl.nul))
    {
      paramf = ((j)g.E(j.class)).bPQ().kB(this.fDU);
      localzl.woU = a.a.Ky().h(paramf);
      ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[] { localzl.woU });
    }
    ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.cos.field_start + ", total:" + this.cos.field_size + ", len:" + i);
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53151);
    return i;
  }
  
  public final int getType()
  {
    return 175;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53152);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53152);
      return;
    }
    paramArrayOfByte = (cob)((com.tencent.mm.ai.b)paramq).fsV.fta;
    paramq = (coc)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (paramArrayOfByte.wQy.size() != paramq.wQy.size())
    {
      ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + paramq.wQy.size() + ", resp size:" + paramArrayOfByte.wQy.size());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53152);
      return;
    }
    paramString = (zm)paramq.wQy.get(0);
    if ((paramString.wQr == null) || (!paramString.wQr.equals(this.cos.Al())) || (paramString.pIy < this.cos.field_start))
    {
      ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + paramString.pIy + ", size=" + this.cos.field_size);
      this.callback.onSceneEnd(4, -2, "", this);
      this.cos.field_start = 0;
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.K(this.cos);
      AppMethodBeat.o(53152);
      return;
    }
    if (paramq.BaseResponse.Ret != 0)
    {
      ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[] { Integer.valueOf(paramq.BaseResponse.Ret) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(53152);
      return;
    }
    if (this.lis) {
      this.lis = false;
    }
    if (paramString.pIy >= paramString.pIx)
    {
      ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + paramString.wQx);
      paramq = ((j)g.E(j.class)).bPQ().kB(this.fDU);
      ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramString.pIG), Integer.valueOf(ae.gkL) });
      if ((10007 == ae.gkK) && (ae.gkL != 0))
      {
        paramString.wQx = ae.gkL;
        ae.gkL = 0;
      }
      paramq.fP(paramString.pIG);
      ((j)g.E(j.class)).bPQ().a(this.fDU, paramq);
      this.cos.field_start = 0;
      this.cos.field_lastUseTime = System.currentTimeMillis();
      this.cos.field_state = EmojiInfo.yPu;
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.K(this.cos);
      if (paramq.bCn()) {
        com.tencent.mm.modelstat.b.fRu.a(paramq, com.tencent.mm.af.k.k(paramq));
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(53152);
        return;
        com.tencent.mm.modelstat.b.fRu.j(paramq);
      }
    }
    this.cos.field_start = paramString.pIy;
    this.cos.field_lastUseTime = System.currentTimeMillis();
    ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.K(this.cos);
    if (doScene(dispatcher(), this.callback) < 0) {
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(53152);
  }
  
  public final int securityLimitCount()
  {
    return 256;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.r
 * JD-Core Version:    0.7.0.1
 */