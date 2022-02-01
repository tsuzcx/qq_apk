package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.de;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.dhe;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private EmojiInfo ddq;
  private long fNi;
  private boolean frM;
  private int oyv;
  private final com.tencent.mm.al.b rr;
  
  public f(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108674);
    this.frM = true;
    this.oyv = 256;
    this.fNi = System.currentTimeMillis();
    ad.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.fNi);
    this.ddq = paramEmojiInfo;
    paramEmojiInfo = new b.a();
    paramEmojiInfo.gUU = new adb();
    paramEmojiInfo.gUV = new adc();
    paramEmojiInfo.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
    paramEmojiInfo.funcId = 703;
    paramEmojiInfo.reqCmdId = 0;
    paramEmojiInfo.respCmdId = 0;
    this.rr = paramEmojiInfo.atI();
    paramEmojiInfo = (adb)this.rr.gUS.gUX;
    dhd localdhd = new dhd();
    if (this.ddq != null)
    {
      h.vKh.m(164L, 13L, 1L);
      ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", new Object[] { this.ddq.JS() });
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.a(aj.getContext(), this.ddq);
      localdhd.MD5 = this.ddq.JS();
      localdhd.uKQ = this.ddq.field_size;
      paramEmojiInfo.DdI.add(localdhd);
      this.oyv = (this.ddq.field_size / 8192 * 2);
    }
    AppMethodBeat.o(108674);
  }
  
  private void bVl()
  {
    AppMethodBeat.i(108677);
    this.ddq.field_start = 0;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.L(this.ddq);
    AppMethodBeat.o(108677);
  }
  
  private void e(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108678);
    if ((paramEmojiInfo != null) && (!bt.isNullOrNil(paramEmojiInfo.JS())))
    {
      ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[] { paramEmojiInfo.JS(), Boolean.valueOf(paramBoolean) });
      de localde = new de();
      localde.dfm.md5 = paramEmojiInfo.JS();
      localde.dfm.dbV = 0;
      localde.dfm.success = paramBoolean;
      a.ESL.l(localde);
      long l = System.currentTimeMillis() - this.fNi;
      ad.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + l + " size " + paramEmojiInfo.field_size + " rate " + paramEmojiInfo.field_size / l);
    }
    AppMethodBeat.o(108678);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    int j = -1;
    AppMethodBeat.i(108675);
    this.callback = paramg;
    dhd localdhd = (dhd)((adb)this.rr.gUS.gUX).DdI.get(0);
    int i;
    if (this.frM)
    {
      ad.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + localdhd.MD5);
      localdhd.uKR = 0;
      i = this.ddq.field_size + 0;
      if (i <= 8192) {
        break label731;
      }
      i = 8192;
    }
    label731:
    for (;;)
    {
      byte[] arrayOfByte;
      if ((this.ddq.field_reserved4 & EmojiInfo.LCl) == EmojiInfo.LCl)
      {
        arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.ddq);
        if (!bt.cw(arrayOfByte))
        {
          paramg = new byte[i];
          ad.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
          System.arraycopy(arrayOfByte, 0, paramg, 0, i);
        }
      }
      while ((paramg == null) || (paramg.length <= 0))
      {
        ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
        AppMethodBeat.o(108675);
        return -1;
        ad.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
        paramg = new byte[0];
        continue;
        paramg = this.ddq.lk(0, i);
      }
      localdhd.uKR = 0;
      localdhd.Exs = new com.tencent.mm.bx.b(paramg);
      int k = paramg.length;
      int m = localdhd.Exs.wA.length;
      if (this.ddq == null)
      {
        i = -1;
        if (this.ddq != null) {
          break label365;
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) });
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(108675);
        return i;
        i = this.ddq.field_start;
        break;
        label365:
        j = this.ddq.field_size;
      }
      if ((this.ddq == null) || (this.ddq.field_start == 0))
      {
        ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
        AppMethodBeat.o(108675);
        return -1;
      }
      i = this.ddq.field_size - this.ddq.field_start;
      if (i > 8192) {
        i = 8192;
      }
      for (;;)
      {
        if ((this.ddq.field_reserved4 & EmojiInfo.LCl) == EmojiInfo.LCl)
        {
          arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.ddq);
          if (!bt.cw(arrayOfByte))
          {
            paramg = new byte[i];
            ad.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
            System.arraycopy(arrayOfByte, this.ddq.field_start, paramg, 0, i);
          }
        }
        while ((paramg == null) || (paramg.length <= 0))
        {
          ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
          AppMethodBeat.o(108675);
          return -1;
          ad.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
          paramg = new byte[0];
          continue;
          paramg = this.ddq.lk(this.ddq.field_start, i);
        }
        i = paramg.length;
        localdhd.uKR = this.ddq.field_start;
        localdhd.Exs = new com.tencent.mm.bx.b(paramg);
        ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[] { Integer.valueOf(paramg.length), Integer.valueOf(localdhd.Exs.wA.length) });
        ad.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.ddq.field_start + ", total:" + this.ddq.field_size + ", len:" + i);
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
      bVl();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.ddq, false);
      AppMethodBeat.o(108676);
      return;
    }
    adb localadb = (adb)((com.tencent.mm.al.b)paramq).gUS.gUX;
    paramArrayOfByte = (adc)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if (localadb.DdI.size() != paramArrayOfByte.DdI.size())
    {
      ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + localadb.DdI.size() + ", resp size:" + paramArrayOfByte.DdI.size());
      bVl();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.ddq, false);
      AppMethodBeat.o(108676);
      return;
    }
    paramq = null;
    paramString = paramq;
    if (paramArrayOfByte.DdI != null)
    {
      paramString = paramq;
      if (paramArrayOfByte.DdI.size() > 0) {
        paramString = (dhe)paramArrayOfByte.DdI.get(0);
      }
    }
    int i;
    if ((paramString == null) || (paramString.MD5 == null) || (!paramString.MD5.equals(this.ddq.JS())) || (paramString.uKR < this.ddq.field_start))
    {
      paramq = paramString.MD5;
      i = paramString.uKQ;
      if (paramString == null)
      {
        paramInt1 = -1;
        if (this.ddq != null) {
          break label431;
        }
        paramInt2 = -1;
        label331:
        if (this.ddq != null) {
          break label442;
        }
      }
      label431:
      label442:
      for (paramInt3 = -1;; paramInt3 = this.ddq.field_size)
      {
        ad.e("MicroMsg.emoji.NetSceneEmojiUpload", "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d", new Object[] { paramq, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        bVl();
        this.callback.onSceneEnd(4, -2, "", this);
        e(this.ddq, false);
        AppMethodBeat.o(108676);
        return;
        paramInt1 = paramString.uKR;
        break;
        paramInt2 = this.ddq.field_start;
        break label331;
      }
    }
    if ((paramString != null) && (this.ddq != null) && (paramString.Ret != 0) && (paramString.uKR == paramString.uKQ) && (paramString.uKR > 0))
    {
      ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[] { this.ddq.JS(), Integer.valueOf(paramString.Ret), Integer.valueOf(paramString.uKR), Integer.valueOf(paramString.uKQ) });
      bVl();
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
        bVl();
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108676);
        return;
      }
    }
    if (this.frM) {
      this.frM = false;
    }
    if (paramString.uKR >= paramString.uKQ)
    {
      this.ddq.field_start = 0;
      this.ddq.field_state = EmojiInfo.LCe;
      this.ddq.field_needupload = EmojiInfo.LCj;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.L(this.ddq);
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      e(this.ddq, true);
      ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
      AppMethodBeat.o(108676);
      return;
    }
    ad.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[] { Integer.valueOf(paramString.uKR) });
    this.ddq.field_start = paramString.uKR;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().FyY.L(this.ddq);
    if (doScene(dispatcher(), this.callback) < 0)
    {
      this.callback.onSceneEnd(3, -1, "", this);
      e(this.ddq, false);
    }
    AppMethodBeat.o(108676);
  }
  
  public final int securityLimitCount()
  {
    return this.oyv;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.f
 * JD-Core Version:    0.7.0.1
 */