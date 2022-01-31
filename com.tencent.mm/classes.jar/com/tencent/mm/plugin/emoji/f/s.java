package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.h;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.bf;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cav;
import com.tencent.mm.protocal.c.caw;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.ux;
import com.tencent.mm.protocal.c.uy;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import junit.framework.Assert;

public final class s
  extends m
  implements k
{
  private EmojiInfo bHd;
  private final com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  private long enx = 0L;
  private boolean iZB = true;
  
  public s(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong)
  {
    this(paramString1, paramString2, paramEmojiInfo, paramLong, (byte)0);
  }
  
  private s(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong, byte paramByte)
  {
    boolean bool;
    Object localObject;
    ux localux;
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramEmojiInfo != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.enx = paramLong;
      this.bHd = paramEmojiInfo;
      localObject = new b.a();
      ((b.a)localObject).ecH = new cav();
      ((b.a)localObject).ecI = new caw();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendemoji";
      ((b.a)localObject).ecG = 175;
      ((b.a)localObject).ecJ = 68;
      ((b.a)localObject).ecK = 1000000068;
      this.dmK = ((b.a)localObject).Kt();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().uBb.a(com.tencent.mm.sdk.platformtools.ae.getContext(), paramEmojiInfo);
      localObject = (cav)this.dmK.ecE.ecN;
      localux = new ux();
      localux.sRE = paramEmojiInfo.Wv();
      localux.sRI = paramString1;
      localux.kWm = paramString2;
      localux.ndf = paramEmojiInfo.field_size;
      localux.sRG = paramEmojiInfo.getContent();
      localux.hQR = paramEmojiInfo.field_type;
      localux.svK = bf.HR();
      localux.sRJ = 0;
      if (com.tencent.mm.model.s.fn(paramString2)) {
        paramByte = 2;
      }
      if (paramEmojiInfo.field_catalog != EmojiInfo.uCY) {
        break label307;
      }
      localux.sRH = ("56,2," + paramByte);
    }
    for (;;)
    {
      ((cav)localObject).sRL.add(localux);
      ((cav)localObject).tPY = ((cav)localObject).sRL.size();
      return;
      bool = false;
      break;
      label307:
      if (paramEmojiInfo.field_catalog == EmojiInfo.uCX) {
        localux.sRH = ("56,1," + paramByte);
      }
    }
  }
  
  protected final int Ka()
  {
    return 256;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    ux localux = (ux)((cav)this.dmK.ecE.ecN).sRL.get(0);
    if (this.iZB)
    {
      y.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + localux.sRE);
      localux.sRF = new bmk();
      localux.ndg = 0;
      return a(parame, this.dmK, this);
    }
    int j = this.bHd.field_size - this.bHd.field_start;
    int i = j;
    if (j > 8192) {
      i = 8192;
    }
    if ((this.bHd.field_reserved4 & EmojiInfo.uDo) == EmojiInfo.uDo)
    {
      byte[] arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.bHd);
      if (!bk.bE(arrayOfByte))
      {
        paramf = new byte[i];
        y.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
        System.arraycopy(arrayOfByte, this.bHd.field_start, paramf, 0, i);
      }
    }
    while ((com.tencent.mm.plugin.emoji.h.b.aj(paramf) == EmojiInfo.uCP) && (this.iZB))
    {
      y.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
      this.bHd.cwA();
      return -1;
      y.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
      paramf = new byte[0];
      continue;
      paramf = this.bHd.fh(this.bHd.field_start, i);
    }
    if ((paramf == null) || (paramf.length <= 0))
    {
      y.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
      return -1;
    }
    i = paramf.length;
    localux.ndg = this.bHd.field_start;
    localux.sRF = new bmk().b(com.tencent.mm.bv.b.bk(paramf));
    if (com.tencent.mm.ai.f.eW(localux.kWm))
    {
      localux.svK = com.tencent.mm.ai.a.e.lv(((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.enx).czr);
      y.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[] { localux.svK });
    }
    y.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.bHd.field_start + ", total:" + this.bHd.field_size + ", len:" + i);
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed errtype:" + paramInt2 + " errcode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    do
    {
      return;
      paramArrayOfByte = (cav)((com.tencent.mm.ah.b)paramq).ecE.ecN;
      paramq = (caw)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      if (paramArrayOfByte.sRL.size() != paramq.sRL.size())
      {
        y.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + paramq.sRL.size() + ", resp size:" + paramArrayOfByte.sRL.size());
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      paramString = (uy)paramq.sRL.get(0);
      if ((paramString.sRE == null) || (!paramString.sRE.equals(this.bHd.Wv())) || (paramString.ndg < this.bHd.field_start))
      {
        y.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + paramString.ndg + ", size=" + this.bHd.field_size);
        this.dmL.onSceneEnd(4, -2, "", this);
        this.bHd.field_start = 0;
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().uBb.r(this.bHd);
        return;
      }
      if (paramq.tFx.sze != 0)
      {
        y.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[] { Integer.valueOf(paramq.tFx.sze) });
        this.dmL.onSceneEnd(4, -2, "", this);
        return;
      }
      if (this.iZB) {
        this.iZB = false;
      }
      if (paramString.ndg >= paramString.ndf)
      {
        y.d("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + paramString.sRK);
        paramq = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(this.enx);
        y.d("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramString.ndp), Integer.valueOf(com.tencent.mm.platformtools.ae.eSQ) });
        if ((10007 == com.tencent.mm.platformtools.ae.eSP) && (com.tencent.mm.platformtools.ae.eSQ != 0))
        {
          paramString.sRK = com.tencent.mm.platformtools.ae.eSQ;
          com.tencent.mm.platformtools.ae.eSQ = 0;
        }
        paramq.bf(paramString.ndp);
        ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().a(this.enx, paramq);
        this.bHd.field_start = 0;
        this.bHd.field_lastUseTime = System.currentTimeMillis();
        this.bHd.field_state = EmojiInfo.uDh;
        ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().uBb.r(this.bHd);
        if (paramq.aVK()) {
          com.tencent.mm.modelstat.b.eBD.a(paramq, h.g(paramq));
        }
        for (;;)
        {
          this.dmL.onSceneEnd(paramInt2, paramInt3, "", this);
          return;
          com.tencent.mm.modelstat.b.eBD.f(paramq);
        }
      }
      this.bHd.field_start = paramString.ndg;
      this.bHd.field_lastUseTime = System.currentTimeMillis();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().uBb.r(this.bHd);
    } while (a(this.edc, this.dmL) >= 0);
    this.dmL.onSceneEnd(3, -1, "", this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 175;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.s
 * JD-Core Version:    0.7.0.1
 */