package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.di;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.agj;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.dsj;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private EmojiInfo dmi;
  private boolean fOA;
  private long gkt;
  private int pFF;
  private final com.tencent.mm.al.b rr;
  
  public f(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108674);
    this.fOA = true;
    this.pFF = 256;
    this.gkt = System.currentTimeMillis();
    ad.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.gkt);
    this.dmi = paramEmojiInfo;
    paramEmojiInfo = new b.a();
    paramEmojiInfo.hNM = new agj();
    paramEmojiInfo.hNN = new agk();
    paramEmojiInfo.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
    paramEmojiInfo.funcId = 703;
    paramEmojiInfo.hNO = 0;
    paramEmojiInfo.respCmdId = 0;
    this.rr = paramEmojiInfo.aDC();
    paramEmojiInfo = (agj)this.rr.hNK.hNQ;
    dsj localdsj = new dsj();
    if (this.dmi != null)
    {
      com.tencent.mm.plugin.report.service.g.yhR.n(164L, 13L, 1L);
      ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", new Object[] { this.dmi.Lb() });
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.a(aj.getContext(), this.dmi);
      localdsj.MD5 = this.dmi.Lb();
      localdsj.xcK = this.dmi.field_size;
      paramEmojiInfo.Ger.add(localdsj);
      this.pFF = (this.dmi.field_size / 8192 * 2);
    }
    AppMethodBeat.o(108674);
  }
  
  private void chc()
  {
    AppMethodBeat.i(108677);
    this.dmi.field_start = 0;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.K(this.dmi);
    AppMethodBeat.o(108677);
  }
  
  private void e(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108678);
    if ((paramEmojiInfo != null) && (!bt.isNullOrNil(paramEmojiInfo.Lb())))
    {
      ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[] { paramEmojiInfo.Lb(), Boolean.valueOf(paramBoolean) });
      di localdi = new di();
      localdi.dod.md5 = paramEmojiInfo.Lb();
      localdi.dod.dkM = 0;
      localdi.dod.success = paramBoolean;
      a.IbL.l(localdi);
      long l = System.currentTimeMillis() - this.gkt;
      ad.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + l + " size " + paramEmojiInfo.field_size + " rate " + paramEmojiInfo.field_size / l);
    }
    AppMethodBeat.o(108678);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    int j = -1;
    AppMethodBeat.i(108675);
    this.callback = paramf;
    dsj localdsj = (dsj)((agj)this.rr.hNK.hNQ).Ger.get(0);
    int i;
    if (this.fOA)
    {
      ad.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + localdsj.MD5);
      localdsj.xcL = 0;
      i = this.dmi.field_size + 0;
      if (i <= 8192) {
        break label731;
      }
      i = 8192;
    }
    label731:
    for (;;)
    {
      byte[] arrayOfByte;
      if ((this.dmi.field_reserved4 & EmojiInfo.Ofi) == EmojiInfo.Ofi)
      {
        arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dmi);
        if (!bt.cC(arrayOfByte))
        {
          paramf = new byte[i];
          ad.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
          System.arraycopy(arrayOfByte, 0, paramf, 0, i);
        }
      }
      while ((paramf == null) || (paramf.length <= 0))
      {
        ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
        AppMethodBeat.o(108675);
        return -1;
        ad.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
        paramf = new byte[0];
        continue;
        paramf = this.dmi.lG(0, i);
      }
      localdsj.xcL = 0;
      localdsj.HFi = new com.tencent.mm.bx.b(paramf);
      int k = paramf.length;
      int m = localdsj.HFi.zr.length;
      if (this.dmi == null)
      {
        i = -1;
        if (this.dmi != null) {
          break label365;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) });
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(108675);
        return i;
        i = this.dmi.field_start;
        break;
        label365:
        j = this.dmi.field_size;
      }
      if ((this.dmi == null) || (this.dmi.field_start == 0))
      {
        ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
        AppMethodBeat.o(108675);
        return -1;
      }
      i = this.dmi.field_size - this.dmi.field_start;
      if (i > 8192) {
        i = 8192;
      }
      for (;;)
      {
        if ((this.dmi.field_reserved4 & EmojiInfo.Ofi) == EmojiInfo.Ofi)
        {
          arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dmi);
          if (!bt.cC(arrayOfByte))
          {
            paramf = new byte[i];
            ad.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
            System.arraycopy(arrayOfByte, this.dmi.field_start, paramf, 0, i);
          }
        }
        while ((paramf == null) || (paramf.length <= 0))
        {
          ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
          AppMethodBeat.o(108675);
          return -1;
          ad.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
          paramf = new byte[0];
          continue;
          paramf = this.dmi.lG(this.dmi.field_start, i);
        }
        i = paramf.length;
        localdsj.xcL = this.dmi.field_start;
        localdsj.HFi = new com.tencent.mm.bx.b(paramf);
        ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[] { Integer.valueOf(paramf.length), Integer.valueOf(localdsj.HFi.zr.length) });
        ad.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.dmi.field_start + ", total:" + this.dmi.field_size + ", len:" + i);
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(108675);
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
    AppMethodBeat.i(108676);
    ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + paramInt2 + " errcode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      chc();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.dmi, false);
      AppMethodBeat.o(108676);
      return;
    }
    agj localagj = (agj)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    paramArrayOfByte = (agk)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if (localagj.Ger.size() != paramArrayOfByte.Ger.size())
    {
      ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + localagj.Ger.size() + ", resp size:" + paramArrayOfByte.Ger.size());
      chc();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.dmi, false);
      AppMethodBeat.o(108676);
      return;
    }
    paramq = null;
    paramString = paramq;
    if (paramArrayOfByte.Ger != null)
    {
      paramString = paramq;
      if (paramArrayOfByte.Ger.size() > 0) {
        paramString = (dsk)paramArrayOfByte.Ger.get(0);
      }
    }
    int i;
    if ((paramString == null) || (paramString.MD5 == null) || (!paramString.MD5.equals(this.dmi.Lb())) || (paramString.xcL < this.dmi.field_start))
    {
      paramq = paramString.MD5;
      i = paramString.xcK;
      if (paramString == null)
      {
        paramInt1 = -1;
        if (this.dmi != null) {
          break label431;
        }
        paramInt2 = -1;
        label331:
        if (this.dmi != null) {
          break label442;
        }
      }
      label431:
      label442:
      for (paramInt3 = -1;; paramInt3 = this.dmi.field_size)
      {
        ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d", new Object[] { paramq, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        chc();
        this.callback.onSceneEnd(4, -2, "", this);
        e(this.dmi, false);
        AppMethodBeat.o(108676);
        return;
        paramInt1 = paramString.xcL;
        break;
        paramInt2 = this.dmi.field_start;
        break label331;
      }
    }
    if ((paramString != null) && (this.dmi != null) && (paramString.Ret != 0) && (paramString.xcL == paramString.xcK) && (paramString.xcL > 0))
    {
      ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[] { this.dmi.Lb(), Integer.valueOf(paramString.Ret), Integer.valueOf(paramString.xcL), Integer.valueOf(paramString.xcK) });
      chc();
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      AppMethodBeat.o(108676);
      return;
    }
    if ((paramArrayOfByte.BaseResponse.Ret != 0) || ((paramString != null) && (paramString.Ret != 0)))
    {
      i = paramArrayOfByte.BaseResponse.Ret;
      if (paramString == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.Ret)
      {
        ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        chc();
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108676);
        return;
      }
    }
    if (this.fOA) {
      this.fOA = false;
    }
    if (paramString.xcL >= paramString.xcK)
    {
      this.dmi.field_start = 0;
      this.dmi.field_state = EmojiInfo.Ofb;
      this.dmi.field_needupload = EmojiInfo.Ofg;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.K(this.dmi);
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      e(this.dmi, true);
      ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
      AppMethodBeat.o(108676);
      return;
    }
    ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[] { Integer.valueOf(paramString.xcL) });
    this.dmi.field_start = paramString.xcL;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().ILn.K(this.dmi);
    if (doScene(dispatcher(), this.callback) < 0)
    {
      this.callback.onSceneEnd(3, -1, "", this);
      e(this.dmi, false);
    }
    AppMethodBeat.o(108676);
  }
  
  public final int securityLimitCount()
  {
    return this.pFF;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.f
 * JD-Core Version:    0.7.0.1
 */