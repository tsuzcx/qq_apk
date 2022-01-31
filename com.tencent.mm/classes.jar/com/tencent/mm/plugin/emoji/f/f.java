package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.a.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.protocal.protobuf.zn;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private EmojiInfo cos;
  private long ewN;
  private boolean lis;
  private int lit;
  private final com.tencent.mm.ai.b rr;
  
  public f(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(53102);
    this.lis = true;
    this.lit = 256;
    this.ewN = System.currentTimeMillis();
    ab.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.ewN);
    this.cos = paramEmojiInfo;
    paramEmojiInfo = new b.a();
    paramEmojiInfo.fsX = new zn();
    paramEmojiInfo.fsY = new zo();
    paramEmojiInfo.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
    paramEmojiInfo.funcId = 703;
    paramEmojiInfo.reqCmdId = 0;
    paramEmojiInfo.respCmdId = 0;
    this.rr = paramEmojiInfo.ado();
    paramEmojiInfo = (zn)this.rr.fsV.fta;
    cnz localcnz = new cnz();
    if (this.cos != null)
    {
      h.qsU.j(164L, 13L, 1L);
      ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", new Object[] { this.cos.Al() });
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.a(ah.getContext(), this.cos);
      localcnz.wQr = this.cos.Al();
      localcnz.pIx = this.cos.field_size;
      paramEmojiInfo.wQy.add(localcnz);
      this.lit = (this.cos.field_size / 8192 * 2);
    }
    AppMethodBeat.o(53102);
  }
  
  private void blB()
  {
    AppMethodBeat.i(53105);
    this.cos.field_start = 0;
    ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.J(this.cos);
    AppMethodBeat.o(53105);
  }
  
  private void d(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(53106);
    if ((paramEmojiInfo != null) && (!bo.isNullOrNil(paramEmojiInfo.Al())))
    {
      ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[] { paramEmojiInfo.Al(), Boolean.valueOf(paramBoolean) });
      cy localcy = new cy();
      localcy.cqp.cqq = paramEmojiInfo.Al();
      localcy.cqp.coO = 0;
      localcy.cqp.success = paramBoolean;
      a.ymk.l(localcy);
      long l = System.currentTimeMillis() - this.ewN;
      ab.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + l + " size " + paramEmojiInfo.field_size + " rate " + paramEmojiInfo.field_size / l);
    }
    AppMethodBeat.o(53106);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    int j = -1;
    AppMethodBeat.i(53103);
    this.callback = paramf;
    cnz localcnz = (cnz)((zn)this.rr.fsV.fta).wQy.get(0);
    int i;
    if (this.lis)
    {
      ab.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + localcnz.wQr);
      localcnz.pIy = 0;
      i = this.cos.field_size + 0;
      if (i <= 8192) {
        break label731;
      }
      i = 8192;
    }
    label731:
    for (;;)
    {
      byte[] arrayOfByte;
      if ((this.cos.field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx)
      {
        arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l(this.cos);
        if (!bo.ce(arrayOfByte))
        {
          paramf = new byte[i];
          ab.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
          System.arraycopy(arrayOfByte, 0, paramf, 0, i);
        }
      }
      while ((paramf == null) || (paramf.length <= 0))
      {
        ab.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
        AppMethodBeat.o(53103);
        return -1;
        ab.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
        paramf = new byte[0];
        continue;
        paramf = this.cos.ho(0, i);
      }
      localcnz.pIy = 0;
      localcnz.xWN = new com.tencent.mm.bv.b(paramf);
      int k = paramf.length;
      int m = localcnz.xWN.pW.length;
      if (this.cos == null)
      {
        i = -1;
        if (this.cos != null) {
          break label365;
        }
      }
      for (;;)
      {
        ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) });
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(53103);
        return i;
        i = this.cos.field_start;
        break;
        label365:
        j = this.cos.field_size;
      }
      if ((this.cos == null) || (this.cos.field_start == 0))
      {
        ab.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
        AppMethodBeat.o(53103);
        return -1;
      }
      i = this.cos.field_size - this.cos.field_start;
      if (i > 8192) {
        i = 8192;
      }
      for (;;)
      {
        if ((this.cos.field_reserved4 & EmojiInfo.APx) == EmojiInfo.APx)
        {
          arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().l(this.cos);
          if (!bo.ce(arrayOfByte))
          {
            paramf = new byte[i];
            ab.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
            System.arraycopy(arrayOfByte, this.cos.field_start, paramf, 0, i);
          }
        }
        while ((paramf == null) || (paramf.length <= 0))
        {
          ab.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
          AppMethodBeat.o(53103);
          return -1;
          ab.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
          paramf = new byte[0];
          continue;
          paramf = this.cos.ho(this.cos.field_start, i);
        }
        i = paramf.length;
        localcnz.pIy = this.cos.field_start;
        localcnz.xWN = new com.tencent.mm.bv.b(paramf);
        ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[] { Integer.valueOf(paramf.length), Integer.valueOf(localcnz.xWN.pW.length) });
        ab.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.cos.field_start + ", total:" + this.cos.field_size + ", len:" + i);
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(53103);
        return i;
      }
    }
  }
  
  public final int getType()
  {
    return 703;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53104);
    ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + paramInt2 + " errcode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      blB();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      d(this.cos, false);
      AppMethodBeat.o(53104);
      return;
    }
    zn localzn = (zn)((com.tencent.mm.ai.b)paramq).fsV.fta;
    paramArrayOfByte = (zo)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if (localzn.wQy.size() != paramArrayOfByte.wQy.size())
    {
      ab.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + localzn.wQy.size() + ", resp size:" + paramArrayOfByte.wQy.size());
      blB();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      d(this.cos, false);
      AppMethodBeat.o(53104);
      return;
    }
    paramq = null;
    paramString = paramq;
    if (paramArrayOfByte.wQy != null)
    {
      paramString = paramq;
      if (paramArrayOfByte.wQy.size() > 0) {
        paramString = (coa)paramArrayOfByte.wQy.get(0);
      }
    }
    int i;
    if ((paramString == null) || (paramString.wQr == null) || (!paramString.wQr.equals(this.cos.Al())) || (paramString.pIy < this.cos.field_start))
    {
      paramq = paramString.wQr;
      i = paramString.pIx;
      if (paramString == null)
      {
        paramInt1 = -1;
        if (this.cos != null) {
          break label431;
        }
        paramInt2 = -1;
        label331:
        if (this.cos != null) {
          break label442;
        }
      }
      label431:
      label442:
      for (paramInt3 = -1;; paramInt3 = this.cos.field_size)
      {
        ab.e("MicroMsg.emoji.NetSceneEmojiUpload", "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d", new Object[] { paramq, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        blB();
        this.callback.onSceneEnd(4, -2, "", this);
        d(this.cos, false);
        AppMethodBeat.o(53104);
        return;
        paramInt1 = paramString.pIy;
        break;
        paramInt2 = this.cos.field_start;
        break label331;
      }
    }
    if ((paramString != null) && (this.cos != null) && (paramString.Ret != 0) && (paramString.pIy == paramString.pIx) && (paramString.pIy > 0))
    {
      ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[] { this.cos.Al(), Integer.valueOf(paramString.Ret), Integer.valueOf(paramString.pIy), Integer.valueOf(paramString.pIx) });
      blB();
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      AppMethodBeat.o(53104);
      return;
    }
    if ((paramArrayOfByte.BaseResponse.Ret != 0) || ((paramString != null) && (paramString.Ret != 0)))
    {
      i = paramArrayOfByte.BaseResponse.Ret;
      if (paramString == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.Ret)
      {
        ab.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        blB();
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(53104);
        return;
      }
    }
    if (this.lis) {
      this.lis = false;
    }
    if (paramString.pIy >= paramString.pIx)
    {
      this.cos.field_start = 0;
      this.cos.field_state = EmojiInfo.yPu;
      this.cos.field_needupload = EmojiInfo.yPz;
      ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.J(this.cos);
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      d(this.cos, true);
      ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
      AppMethodBeat.o(53104);
      return;
    }
    ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[] { Integer.valueOf(paramString.pIy) });
    this.cos.field_start = paramString.pIy;
    ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().yNn.J(this.cos);
    if (doScene(dispatcher(), this.callback) < 0)
    {
      this.callback.onSceneEnd(3, -1, "", this);
      d(this.cos, false);
    }
    AppMethodBeat.o(53104);
  }
  
  public final int securityLimitCount()
  {
    return this.lit;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.f
 * JD-Core Version:    0.7.0.1
 */