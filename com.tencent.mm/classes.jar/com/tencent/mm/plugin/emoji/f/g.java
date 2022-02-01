package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.a.dr;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ajq;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.exm;
import com.tencent.mm.protocal.protobuf.exn;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.LinkedList;

public final class g
  extends q
  implements m
{
  private i callback;
  private EmojiInfo fxn;
  private long jID;
  private boolean jab;
  private final com.tencent.mm.an.d rr;
  private int uFH;
  
  public g(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108674);
    this.jab = true;
    this.uFH = 256;
    this.jID = System.currentTimeMillis();
    Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.jID);
    this.fxn = paramEmojiInfo;
    paramEmojiInfo = new d.a();
    paramEmojiInfo.lBU = new ajq();
    paramEmojiInfo.lBV = new ajr();
    paramEmojiInfo.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
    paramEmojiInfo.funcId = 703;
    paramEmojiInfo.lBW = 0;
    paramEmojiInfo.respCmdId = 0;
    this.rr = paramEmojiInfo.bgN();
    paramEmojiInfo = (ajq)d.b.b(this.rr.lBR);
    exm localexm = new exm();
    if (this.fxn != null)
    {
      com.tencent.mm.plugin.report.service.h.IzE.p(164L, 13L, 1L);
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", new Object[] { this.fxn.getMd5() });
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.a(MMApplicationContext.getContext(), this.fxn);
      localexm.MD5 = this.fxn.getMd5();
      localexm.HmZ = this.fxn.field_size;
      paramEmojiInfo.Sud.add(localexm);
      this.uFH = (this.fxn.field_size / 8192 * 2);
    }
    AppMethodBeat.o(108674);
  }
  
  private void cVa()
  {
    AppMethodBeat.i(108677);
    this.fxn.field_start = 0;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.M(this.fxn);
    AppMethodBeat.o(108677);
  }
  
  private void e(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108678);
    if ((paramEmojiInfo != null) && (!Util.isNullOrNil(paramEmojiInfo.getMd5())))
    {
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[] { paramEmojiInfo.getMd5(), Boolean.valueOf(paramBoolean) });
      dr localdr = new dr();
      localdr.fzh.md5 = paramEmojiInfo.getMd5();
      localdr.fzh.fvK = 0;
      localdr.fzh.success = paramBoolean;
      EventCenter.instance.publish(localdr);
      long l = System.currentTimeMillis() - this.jID;
      Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + l + " size " + paramEmojiInfo.field_size + " rate " + paramEmojiInfo.field_size / l);
    }
    AppMethodBeat.o(108678);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int j = -1;
    AppMethodBeat.i(108675);
    this.callback = parami;
    exm localexm = (exm)((ajq)d.b.b(this.rr.lBR)).Sud.get(0);
    int i;
    if (this.jab)
    {
      Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + localexm.MD5);
      localexm.Hna = 0;
      i = this.fxn.field_size + 0;
      if (i <= 8192) {
        break label731;
      }
      i = 8192;
    }
    label731:
    for (;;)
    {
      byte[] arrayOfByte;
      if ((this.fxn.field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM)
      {
        arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.fxn);
        if (!Util.isNullOrNil(arrayOfByte))
        {
          parami = new byte[i];
          Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
          System.arraycopy(arrayOfByte, 0, parami, 0, i);
        }
      }
      while ((parami == null) || (parami.length <= 0))
      {
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
        AppMethodBeat.o(108675);
        return -1;
        Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
        parami = new byte[0];
        continue;
        parami = this.fxn.oH(0, i);
      }
      localexm.Hna = 0;
      localexm.UxN = new b(parami);
      int k = parami.length;
      int m = localexm.UxN.UH.length;
      if (this.fxn == null)
      {
        i = -1;
        if (this.fxn != null) {
          break label365;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) });
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(108675);
        return i;
        i = this.fxn.field_start;
        break;
        label365:
        j = this.fxn.field_size;
      }
      if ((this.fxn == null) || (this.fxn.field_start == 0))
      {
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
        AppMethodBeat.o(108675);
        return -1;
      }
      i = this.fxn.field_size - this.fxn.field_start;
      if (i > 8192) {
        i = 8192;
      }
      for (;;)
      {
        if ((this.fxn.field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM)
        {
          arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.fxn);
          if (!Util.isNullOrNil(arrayOfByte))
          {
            parami = new byte[i];
            Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
            System.arraycopy(arrayOfByte, this.fxn.field_start, parami, 0, i);
          }
        }
        while ((parami == null) || (parami.length <= 0))
        {
          Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
          AppMethodBeat.o(108675);
          return -1;
          Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
          parami = new byte[0];
          continue;
          parami = this.fxn.oH(this.fxn.field_start, i);
        }
        i = parami.length;
        localexm.Hna = this.fxn.field_start;
        localexm.UxN = new b(parami);
        Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[] { Integer.valueOf(parami.length), Integer.valueOf(localexm.UxN.UH.length) });
        Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.fxn.field_start + ", total:" + this.fxn.field_size + ", len:" + i);
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(108675);
        return i;
      }
    }
  }
  
  public final int getType()
  {
    return 703;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108676);
    Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + paramInt2 + " errcode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      cVa();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.fxn, false);
      AppMethodBeat.o(108676);
      return;
    }
    ajq localajq = (ajq)d.b.b(((com.tencent.mm.an.d)params).lBR);
    paramArrayOfByte = (ajr)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if (localajq.Sud.size() != paramArrayOfByte.Sud.size())
    {
      Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + localajq.Sud.size() + ", resp size:" + paramArrayOfByte.Sud.size());
      cVa();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.fxn, false);
      AppMethodBeat.o(108676);
      return;
    }
    params = null;
    paramString = params;
    if (paramArrayOfByte.Sud != null)
    {
      paramString = params;
      if (paramArrayOfByte.Sud.size() > 0) {
        paramString = (exn)paramArrayOfByte.Sud.get(0);
      }
    }
    int i;
    if ((paramString == null) || (paramString.MD5 == null) || (!paramString.MD5.equals(this.fxn.getMd5())) || (paramString.Hna < this.fxn.field_start))
    {
      params = paramString.MD5;
      i = paramString.HmZ;
      if (paramString == null)
      {
        paramInt1 = -1;
        if (this.fxn != null) {
          break label431;
        }
        paramInt2 = -1;
        label331:
        if (this.fxn != null) {
          break label442;
        }
      }
      label431:
      label442:
      for (paramInt3 = -1;; paramInt3 = this.fxn.field_size)
      {
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d", new Object[] { params, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        cVa();
        this.callback.onSceneEnd(4, -2, "", this);
        e(this.fxn, false);
        AppMethodBeat.o(108676);
        return;
        paramInt1 = paramString.Hna;
        break;
        paramInt2 = this.fxn.field_start;
        break label331;
      }
    }
    if ((paramString != null) && (this.fxn != null) && (paramString.CqV != 0) && (paramString.Hna == paramString.HmZ) && (paramString.Hna > 0))
    {
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[] { this.fxn.getMd5(), Integer.valueOf(paramString.CqV), Integer.valueOf(paramString.Hna), Integer.valueOf(paramString.HmZ) });
      cVa();
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      AppMethodBeat.o(108676);
      return;
    }
    if ((paramArrayOfByte.BaseResponse.CqV != 0) || ((paramString != null) && (paramString.CqV != 0)))
    {
      i = paramArrayOfByte.BaseResponse.CqV;
      if (paramString == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.CqV)
      {
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        cVa();
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108676);
        return;
      }
    }
    if (this.jab) {
      this.jab = false;
    }
    if (paramString.Hna >= paramString.HmZ)
    {
      this.fxn.field_start = 0;
      this.fxn.field_state = EmojiInfo.ZuF;
      this.fxn.field_needupload = EmojiInfo.ZuK;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.M(this.fxn);
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      e(this.fxn, true);
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
      AppMethodBeat.o(108676);
      return;
    }
    Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[] { Integer.valueOf(paramString.Hna) });
    this.fxn.field_start = paramString.Hna;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.M(this.fxn);
    if (doScene(dispatcher(), this.callback) < 0)
    {
      this.callback.onSceneEnd(3, -1, "", this);
      e(this.fxn, false);
    }
    AppMethodBeat.o(108676);
  }
  
  public final int securityLimitCount()
  {
    return this.uFH;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.g
 * JD-Core Version:    0.7.0.1
 */