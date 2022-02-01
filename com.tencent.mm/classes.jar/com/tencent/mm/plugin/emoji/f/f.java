package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ags;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.protocal.protobuf.dth;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private EmojiInfo dnk;
  private boolean fQG;
  private long gmN;
  private int pMj;
  private final com.tencent.mm.ak.b rr;
  
  public f(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108674);
    this.fQG = true;
    this.pMj = 256;
    this.gmN = System.currentTimeMillis();
    ae.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.gmN);
    this.dnk = paramEmojiInfo;
    paramEmojiInfo = new b.a();
    paramEmojiInfo.hQF = new ags();
    paramEmojiInfo.hQG = new agt();
    paramEmojiInfo.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
    paramEmojiInfo.funcId = 703;
    paramEmojiInfo.hQH = 0;
    paramEmojiInfo.respCmdId = 0;
    this.rr = paramEmojiInfo.aDS();
    paramEmojiInfo = (ags)this.rr.hQD.hQJ;
    dtg localdtg = new dtg();
    if (this.dnk != null)
    {
      com.tencent.mm.plugin.report.service.g.yxI.n(164L, 13L, 1L);
      ae.i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", new Object[] { this.dnk.Lj() });
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.a(ak.getContext(), this.dnk);
      localdtg.MD5 = this.dnk.Lj();
      localdtg.xsB = this.dnk.field_size;
      paramEmojiInfo.GwY.add(localdtg);
      this.pMj = (this.dnk.field_size / 8192 * 2);
    }
    AppMethodBeat.o(108674);
  }
  
  private void cis()
  {
    AppMethodBeat.i(108677);
    this.dnk.field_start = 0;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.K(this.dnk);
    AppMethodBeat.o(108677);
  }
  
  private void e(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108678);
    if ((paramEmojiInfo != null) && (!bu.isNullOrNil(paramEmojiInfo.Lj())))
    {
      ae.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[] { paramEmojiInfo.Lj(), Boolean.valueOf(paramBoolean) });
      dj localdj = new dj();
      localdj.dpi.md5 = paramEmojiInfo.Lj();
      localdj.dpi.dlO = 0;
      localdj.dpi.success = paramBoolean;
      a.IvT.l(localdj);
      long l = System.currentTimeMillis() - this.gmN;
      ae.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + l + " size " + paramEmojiInfo.field_size + " rate " + paramEmojiInfo.field_size / l);
    }
    AppMethodBeat.o(108678);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    int j = -1;
    AppMethodBeat.i(108675);
    this.callback = paramf;
    dtg localdtg = (dtg)((ags)this.rr.hQD.hQJ).GwY.get(0);
    int i;
    if (this.fQG)
    {
      ae.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + localdtg.MD5);
      localdtg.xsC = 0;
      i = this.dnk.field_size + 0;
      if (i <= 8192) {
        break label731;
      }
      i = 8192;
    }
    label731:
    for (;;)
    {
      byte[] arrayOfByte;
      if ((this.dnk.field_reserved4 & EmojiInfo.OAp) == EmojiInfo.OAp)
      {
        arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dnk);
        if (!bu.cF(arrayOfByte))
        {
          paramf = new byte[i];
          ae.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
          System.arraycopy(arrayOfByte, 0, paramf, 0, i);
        }
      }
      while ((paramf == null) || (paramf.length <= 0))
      {
        ae.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
        AppMethodBeat.o(108675);
        return -1;
        ae.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
        paramf = new byte[0];
        continue;
        paramf = this.dnk.jD(0, i);
      }
      localdtg.xsC = 0;
      localdtg.HYV = new com.tencent.mm.bw.b(paramf);
      int k = paramf.length;
      int m = localdtg.HYV.zr.length;
      if (this.dnk == null)
      {
        i = -1;
        if (this.dnk != null) {
          break label365;
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) });
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(108675);
        return i;
        i = this.dnk.field_start;
        break;
        label365:
        j = this.dnk.field_size;
      }
      if ((this.dnk == null) || (this.dnk.field_start == 0))
      {
        ae.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
        AppMethodBeat.o(108675);
        return -1;
      }
      i = this.dnk.field_size - this.dnk.field_start;
      if (i > 8192) {
        i = 8192;
      }
      for (;;)
      {
        if ((this.dnk.field_reserved4 & EmojiInfo.OAp) == EmojiInfo.OAp)
        {
          arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dnk);
          if (!bu.cF(arrayOfByte))
          {
            paramf = new byte[i];
            ae.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
            System.arraycopy(arrayOfByte, this.dnk.field_start, paramf, 0, i);
          }
        }
        while ((paramf == null) || (paramf.length <= 0))
        {
          ae.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
          AppMethodBeat.o(108675);
          return -1;
          ae.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
          paramf = new byte[0];
          continue;
          paramf = this.dnk.jD(this.dnk.field_start, i);
        }
        i = paramf.length;
        localdtg.xsC = this.dnk.field_start;
        localdtg.HYV = new com.tencent.mm.bw.b(paramf);
        ae.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[] { Integer.valueOf(paramf.length), Integer.valueOf(localdtg.HYV.zr.length) });
        ae.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.dnk.field_start + ", total:" + this.dnk.field_size + ", len:" + i);
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
    ae.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + paramInt2 + " errcode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      cis();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.dnk, false);
      AppMethodBeat.o(108676);
      return;
    }
    ags localags = (ags)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    paramArrayOfByte = (agt)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if (localags.GwY.size() != paramArrayOfByte.GwY.size())
    {
      ae.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + localags.GwY.size() + ", resp size:" + paramArrayOfByte.GwY.size());
      cis();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.dnk, false);
      AppMethodBeat.o(108676);
      return;
    }
    paramq = null;
    paramString = paramq;
    if (paramArrayOfByte.GwY != null)
    {
      paramString = paramq;
      if (paramArrayOfByte.GwY.size() > 0) {
        paramString = (dth)paramArrayOfByte.GwY.get(0);
      }
    }
    int i;
    if ((paramString == null) || (paramString.MD5 == null) || (!paramString.MD5.equals(this.dnk.Lj())) || (paramString.xsC < this.dnk.field_start))
    {
      paramq = paramString.MD5;
      i = paramString.xsB;
      if (paramString == null)
      {
        paramInt1 = -1;
        if (this.dnk != null) {
          break label431;
        }
        paramInt2 = -1;
        label331:
        if (this.dnk != null) {
          break label442;
        }
      }
      label431:
      label442:
      for (paramInt3 = -1;; paramInt3 = this.dnk.field_size)
      {
        ae.e("MicroMsg.emoji.NetSceneEmojiUpload", "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d", new Object[] { paramq, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        cis();
        this.callback.onSceneEnd(4, -2, "", this);
        e(this.dnk, false);
        AppMethodBeat.o(108676);
        return;
        paramInt1 = paramString.xsC;
        break;
        paramInt2 = this.dnk.field_start;
        break label331;
      }
    }
    if ((paramString != null) && (this.dnk != null) && (paramString.Ret != 0) && (paramString.xsC == paramString.xsB) && (paramString.xsC > 0))
    {
      ae.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[] { this.dnk.Lj(), Integer.valueOf(paramString.Ret), Integer.valueOf(paramString.xsC), Integer.valueOf(paramString.xsB) });
      cis();
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
        ae.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        cis();
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108676);
        return;
      }
    }
    if (this.fQG) {
      this.fQG = false;
    }
    if (paramString.xsC >= paramString.xsB)
    {
      this.dnk.field_start = 0;
      this.dnk.field_state = EmojiInfo.OAi;
      this.dnk.field_needupload = EmojiInfo.OAn;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.K(this.dnk);
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      e(this.dnk, true);
      ae.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
      AppMethodBeat.o(108676);
      return;
    }
    ae.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[] { Integer.valueOf(paramString.xsC) });
    this.dnk.field_start = paramString.xsC;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().JfU.K(this.dnk);
    if (doScene(dispatcher(), this.callback) < 0)
    {
      this.callback.onSceneEnd(3, -1, "", this);
      e(this.dnk, false);
    }
    AppMethodBeat.o(108676);
  }
  
  public final int securityLimitCount()
  {
    return this.pMj;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.f
 * JD-Core Version:    0.7.0.1
 */