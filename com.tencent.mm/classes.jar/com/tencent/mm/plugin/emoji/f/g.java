package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.a.cv;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cat;
import com.tencent.mm.protocal.c.cau;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;

public final class g
  extends m
  implements k
{
  private EmojiInfo bHd;
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  private boolean iZB = true;
  private int iZC = 256;
  private long iZh = System.currentTimeMillis();
  
  public g(EmojiInfo paramEmojiInfo)
  {
    y.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.iZh);
    this.bHd = paramEmojiInfo;
    paramEmojiInfo = new b.a();
    paramEmojiInfo.ecH = new uz();
    paramEmojiInfo.ecI = new va();
    paramEmojiInfo.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
    paramEmojiInfo.ecG = 703;
    paramEmojiInfo.ecJ = 0;
    paramEmojiInfo.ecK = 0;
    this.dmK = paramEmojiInfo.Kt();
    paramEmojiInfo = (uz)this.dmK.ecE.ecN;
    cat localcat = new cat();
    if (this.bHd != null)
    {
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().uBb.a(ae.getContext(), this.bHd);
      localcat.sRE = this.bHd.Wv();
      localcat.ndf = this.bHd.field_size;
      paramEmojiInfo.sRL.add(localcat);
      this.iZC = (this.bHd.field_size / 8192 * 2);
    }
  }
  
  private void aIc()
  {
    this.bHd.field_start = 0;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().uBb.q(this.bHd);
  }
  
  private void e(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    if ((paramEmojiInfo != null) && (!bk.bl(paramEmojiInfo.Wv())))
    {
      y.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[] { paramEmojiInfo.Wv(), Boolean.valueOf(paramBoolean) });
      cv localcv = new cv();
      localcv.bIV.bIW = paramEmojiInfo.Wv();
      localcv.bIV.bHz = 0;
      localcv.bIV.success = paramBoolean;
      a.udP.m(localcv);
      long l = System.currentTimeMillis() - this.iZh;
      y.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + l + " size " + paramEmojiInfo.field_size + " rate " + paramEmojiInfo.field_size / l);
    }
  }
  
  protected final int Ka()
  {
    return this.iZC;
  }
  
  public final int a(e parame, f paramf)
  {
    int j = -1;
    this.dmL = paramf;
    cat localcat = (cat)((uz)this.dmK.ecE.ecN).sRL.get(0);
    byte[] arrayOfByte;
    if (this.iZB)
    {
      y.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + localcat.sRE);
      localcat.ndg = 0;
      int k = this.bHd.field_size + 0;
      i = k;
      if (k > 8192) {
        i = 8192;
      }
      if ((this.bHd.field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo)
      {
        arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.bHd);
        if (!bk.bE(arrayOfByte))
        {
          paramf = new byte[i];
          y.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
          System.arraycopy(arrayOfByte, 0, paramf, 0, i);
        }
      }
      while ((paramf == null) || (paramf.length <= 0))
      {
        y.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
        return -1;
        y.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
        paramf = new byte[0];
        continue;
        paramf = this.bHd.fh(0, i);
      }
      localcat.ndg = 0;
      localcat.tPS = new com.tencent.mm.bv.b(paramf);
      k = paramf.length;
      int m = localcat.tPS.oY.length;
      if (this.bHd == null)
      {
        i = -1;
        if (this.bHd != null) {
          break label349;
        }
      }
      for (;;)
      {
        y.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) });
        return a(parame, this.dmK, this);
        i = this.bHd.field_start;
        break;
        label349:
        j = this.bHd.field_size;
      }
    }
    if ((this.bHd == null) || (this.bHd.field_start == 0))
    {
      y.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
      return -1;
    }
    j = this.bHd.field_size - this.bHd.field_start;
    int i = j;
    if (j > 8192) {
      i = 8192;
    }
    if ((this.bHd.field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo)
    {
      arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.bHd);
      if (!bk.bE(arrayOfByte))
      {
        paramf = new byte[i];
        y.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
        System.arraycopy(arrayOfByte, this.bHd.field_start, paramf, 0, i);
      }
    }
    while ((paramf == null) || (paramf.length <= 0))
    {
      y.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
      return -1;
      y.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
      paramf = new byte[0];
      continue;
      paramf = this.bHd.fh(this.bHd.field_start, i);
    }
    i = paramf.length;
    localcat.ndg = this.bHd.field_start;
    localcat.tPS = new com.tencent.mm.bv.b(paramf);
    y.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[] { Integer.valueOf(paramf.length), Integer.valueOf(localcat.tPS.oY.length) });
    y.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.bHd.field_start + ", total:" + this.bHd.field_size + ", len:" + i);
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + paramInt2 + " errcode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      aIc();
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.bHd, false);
    }
    label313:
    do
    {
      return;
      uz localuz = (uz)((com.tencent.mm.ah.b)paramq).ecE.ecN;
      paramArrayOfByte = (va)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      if (localuz.sRL.size() != paramArrayOfByte.sRL.size())
      {
        y.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + localuz.sRL.size() + ", resp size:" + paramArrayOfByte.sRL.size());
        aIc();
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        e(this.bHd, false);
        return;
      }
      paramq = null;
      paramString = paramq;
      if (paramArrayOfByte.sRL != null)
      {
        paramString = paramq;
        if (paramArrayOfByte.sRL.size() > 0) {
          paramString = (cau)paramArrayOfByte.sRL.get(0);
        }
      }
      int i;
      if ((paramString == null) || (paramString.sRE == null) || (!paramString.sRE.equals(this.bHd.Wv())) || (paramString.ndg < this.bHd.field_start))
      {
        paramq = paramString.sRE;
        i = paramString.ndf;
        if (paramString == null)
        {
          paramInt1 = -1;
          if (this.bHd != null) {
            break label407;
          }
          paramInt2 = -1;
          if (this.bHd != null) {
            break label418;
          }
        }
        for (paramInt3 = -1;; paramInt3 = this.bHd.field_size)
        {
          y.e("MicroMsg.emoji.NetSceneEmojiUpload", "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d", new Object[] { paramq, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          aIc();
          this.dmL.onSceneEnd(4, -2, "", this);
          e(this.bHd, false);
          return;
          paramInt1 = paramString.ndg;
          break;
          paramInt2 = this.bHd.field_start;
          break label313;
        }
      }
      if ((paramString != null) && (this.bHd != null) && (paramString.sze != 0) && (paramString.ndg == paramString.ndf) && (paramString.ndg > 0))
      {
        y.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[] { this.bHd.Wv(), Integer.valueOf(paramString.sze), Integer.valueOf(paramString.ndg), Integer.valueOf(paramString.ndf) });
        aIc();
        this.dmL.onSceneEnd(paramInt2, paramInt3, "", this);
        return;
      }
      if ((paramArrayOfByte.tFx.sze != 0) || ((paramString != null) && (paramString.sze != 0)))
      {
        i = paramArrayOfByte.tFx.sze;
        if (paramString == null) {}
        for (paramInt1 = -1;; paramInt1 = paramString.sze)
        {
          y.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
          aIc();
          this.dmL.onSceneEnd(paramInt2, paramInt3, "", this);
          return;
        }
      }
      if (this.iZB) {
        this.iZB = false;
      }
      if (paramString.ndg >= paramString.ndf)
      {
        this.bHd.field_start = 0;
        this.bHd.field_state = EmojiInfo.uDh;
        this.bHd.field_needupload = EmojiInfo.uDm;
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().uBb.q(this.bHd);
        this.dmL.onSceneEnd(paramInt2, paramInt3, "", this);
        e(this.bHd, true);
        y.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
        return;
      }
      y.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[] { Integer.valueOf(paramString.ndg) });
      this.bHd.field_start = paramString.ndg;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().uBb.q(this.bHd);
    } while (a(this.edc, this.dmL) >= 0);
    label407:
    label418:
    this.dmL.onSceneEnd(3, -1, "", this);
    e(this.bHd, false);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 703;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.g
 * JD-Core Version:    0.7.0.1
 */