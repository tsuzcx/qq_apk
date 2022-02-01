package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.df;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aea;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private EmojiInfo daO;
  private long fQT;
  private boolean fvt;
  private int pbV;
  private final com.tencent.mm.ak.b rr;
  
  public f(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108674);
    this.fvt = true;
    this.pbV = 256;
    this.fQT = System.currentTimeMillis();
    ac.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.fQT);
    this.daO = paramEmojiInfo;
    paramEmojiInfo = new b.a();
    paramEmojiInfo.hvt = new aea();
    paramEmojiInfo.hvu = new aeb();
    paramEmojiInfo.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
    paramEmojiInfo.funcId = 703;
    paramEmojiInfo.reqCmdId = 0;
    paramEmojiInfo.respCmdId = 0;
    this.rr = paramEmojiInfo.aAz();
    paramEmojiInfo = (aea)this.rr.hvr.hvw;
    dms localdms = new dms();
    if (this.daO != null)
    {
      h.wUl.n(164L, 13L, 1L);
      ac.i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", new Object[] { this.daO.JC() });
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.a(ai.getContext(), this.daO);
      localdms.MD5 = this.daO.JC();
      localdms.vTH = this.daO.field_size;
      paramEmojiInfo.EwO.add(localdms);
      this.pbV = (this.daO.field_size / 8192 * 2);
    }
    AppMethodBeat.o(108674);
  }
  
  private void ccy()
  {
    AppMethodBeat.i(108677);
    this.daO.field_start = 0;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.L(this.daO);
    AppMethodBeat.o(108677);
  }
  
  private void e(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108678);
    if ((paramEmojiInfo != null) && (!bs.isNullOrNil(paramEmojiInfo.JC())))
    {
      ac.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[] { paramEmojiInfo.JC(), Boolean.valueOf(paramBoolean) });
      df localdf = new df();
      localdf.dcH.md5 = paramEmojiInfo.JC();
      localdf.dcH.cZu = 0;
      localdf.dcH.success = paramBoolean;
      a.GpY.l(localdf);
      long l = System.currentTimeMillis() - this.fQT;
      ac.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + l + " size " + paramEmojiInfo.field_size + " rate " + paramEmojiInfo.field_size / l);
    }
    AppMethodBeat.o(108678);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    int j = -1;
    AppMethodBeat.i(108675);
    this.callback = paramg;
    dms localdms = (dms)((aea)this.rr.hvr.hvw).EwO.get(0);
    int i;
    if (this.fvt)
    {
      ac.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + localdms.MD5);
      localdms.vTI = 0;
      i = this.daO.field_size + 0;
      if (i <= 8192) {
        break label731;
      }
      i = 8192;
    }
    label731:
    for (;;)
    {
      byte[] arrayOfByte;
      if ((this.daO.field_reserved4 & EmojiInfo.Kgm) == EmojiInfo.Kgm)
      {
        arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.daO);
        if (!bs.cv(arrayOfByte))
        {
          paramg = new byte[i];
          ac.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
          System.arraycopy(arrayOfByte, 0, paramg, 0, i);
        }
      }
      while ((paramg == null) || (paramg.length <= 0))
      {
        ac.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
        AppMethodBeat.o(108675);
        return -1;
        ac.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
        paramg = new byte[0];
        continue;
        paramg = this.daO.jn(0, i);
      }
      localdms.vTI = 0;
      localdms.FUu = new com.tencent.mm.bw.b(paramg);
      int k = paramg.length;
      int m = localdms.FUu.xy.length;
      if (this.daO == null)
      {
        i = -1;
        if (this.daO != null) {
          break label365;
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) });
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(108675);
        return i;
        i = this.daO.field_start;
        break;
        label365:
        j = this.daO.field_size;
      }
      if ((this.daO == null) || (this.daO.field_start == 0))
      {
        ac.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
        AppMethodBeat.o(108675);
        return -1;
      }
      i = this.daO.field_size - this.daO.field_start;
      if (i > 8192) {
        i = 8192;
      }
      for (;;)
      {
        if ((this.daO.field_reserved4 & EmojiInfo.Kgm) == EmojiInfo.Kgm)
        {
          arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.daO);
          if (!bs.cv(arrayOfByte))
          {
            paramg = new byte[i];
            ac.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
            System.arraycopy(arrayOfByte, this.daO.field_start, paramg, 0, i);
          }
        }
        while ((paramg == null) || (paramg.length <= 0))
        {
          ac.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
          AppMethodBeat.o(108675);
          return -1;
          ac.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
          paramg = new byte[0];
          continue;
          paramg = this.daO.jn(this.daO.field_start, i);
        }
        i = paramg.length;
        localdms.vTI = this.daO.field_start;
        localdms.FUu = new com.tencent.mm.bw.b(paramg);
        ac.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[] { Integer.valueOf(paramg.length), Integer.valueOf(localdms.FUu.xy.length) });
        ac.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.daO.field_start + ", total:" + this.daO.field_size + ", len:" + i);
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
    ac.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + paramInt2 + " errcode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ccy();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.daO, false);
      AppMethodBeat.o(108676);
      return;
    }
    aea localaea = (aea)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    paramArrayOfByte = (aeb)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if (localaea.EwO.size() != paramArrayOfByte.EwO.size())
    {
      ac.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + localaea.EwO.size() + ", resp size:" + paramArrayOfByte.EwO.size());
      ccy();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.daO, false);
      AppMethodBeat.o(108676);
      return;
    }
    paramq = null;
    paramString = paramq;
    if (paramArrayOfByte.EwO != null)
    {
      paramString = paramq;
      if (paramArrayOfByte.EwO.size() > 0) {
        paramString = (dmt)paramArrayOfByte.EwO.get(0);
      }
    }
    int i;
    if ((paramString == null) || (paramString.MD5 == null) || (!paramString.MD5.equals(this.daO.JC())) || (paramString.vTI < this.daO.field_start))
    {
      paramq = paramString.MD5;
      i = paramString.vTH;
      if (paramString == null)
      {
        paramInt1 = -1;
        if (this.daO != null) {
          break label431;
        }
        paramInt2 = -1;
        label331:
        if (this.daO != null) {
          break label442;
        }
      }
      label431:
      label442:
      for (paramInt3 = -1;; paramInt3 = this.daO.field_size)
      {
        ac.e("MicroMsg.emoji.NetSceneEmojiUpload", "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d", new Object[] { paramq, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        ccy();
        this.callback.onSceneEnd(4, -2, "", this);
        e(this.daO, false);
        AppMethodBeat.o(108676);
        return;
        paramInt1 = paramString.vTI;
        break;
        paramInt2 = this.daO.field_start;
        break label331;
      }
    }
    if ((paramString != null) && (this.daO != null) && (paramString.Ret != 0) && (paramString.vTI == paramString.vTH) && (paramString.vTI > 0))
    {
      ac.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[] { this.daO.JC(), Integer.valueOf(paramString.Ret), Integer.valueOf(paramString.vTI), Integer.valueOf(paramString.vTH) });
      ccy();
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
        ac.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        ccy();
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108676);
        return;
      }
    }
    if (this.fvt) {
      this.fvt = false;
    }
    if (paramString.vTI >= paramString.vTH)
    {
      this.daO.field_start = 0;
      this.daO.field_state = EmojiInfo.Kgf;
      this.daO.field_needupload = EmojiInfo.Kgk;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.L(this.daO);
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      e(this.daO, true);
      ac.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
      AppMethodBeat.o(108676);
      return;
    }
    ac.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[] { Integer.valueOf(paramString.vTI) });
    this.daO.field_start = paramString.vTI;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().GXZ.L(this.daO);
    if (doScene(dispatcher(), this.callback) < 0)
    {
      this.callback.onSceneEnd(3, -1, "", this);
      e(this.daO, false);
    }
    AppMethodBeat.o(108676);
  }
  
  public final int securityLimitCount()
  {
    return this.pbV;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.f
 * JD-Core Version:    0.7.0.1
 */