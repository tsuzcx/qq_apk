package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ajb;
import com.tencent.mm.protocal.protobuf.ajc;
import com.tencent.mm.protocal.protobuf.ene;
import com.tencent.mm.protocal.protobuf.enf;
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
  private EmojiInfo dEz;
  private long gXF;
  private boolean gvP;
  private int rcC;
  private final com.tencent.mm.ak.d rr;
  
  public g(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108674);
    this.gvP = true;
    this.rcC = 256;
    this.gXF = System.currentTimeMillis();
    Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.gXF);
    this.dEz = paramEmojiInfo;
    paramEmojiInfo = new d.a();
    paramEmojiInfo.iLN = new ajb();
    paramEmojiInfo.iLO = new ajc();
    paramEmojiInfo.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
    paramEmojiInfo.funcId = 703;
    paramEmojiInfo.iLP = 0;
    paramEmojiInfo.respCmdId = 0;
    this.rr = paramEmojiInfo.aXF();
    paramEmojiInfo = (ajb)this.rr.iLK.iLR;
    ene localene = new ene();
    if (this.dEz != null)
    {
      h.CyF.n(164L, 13L, 1L);
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", new Object[] { this.dEz.getMd5() });
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.a(MMApplicationContext.getContext(), this.dEz);
      localene.MD5 = this.dEz.getMd5();
      localene.BsF = this.dEz.field_size;
      paramEmojiInfo.LsE.add(localene);
      this.rcC = (this.dEz.field_size / 8192 * 2);
    }
    AppMethodBeat.o(108674);
  }
  
  private void cGr()
  {
    AppMethodBeat.i(108677);
    this.dEz.field_start = 0;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(this.dEz);
    AppMethodBeat.o(108677);
  }
  
  private void e(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108678);
    if ((paramEmojiInfo != null) && (!Util.isNullOrNil(paramEmojiInfo.getMd5())))
    {
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[] { paramEmojiInfo.getMd5(), Boolean.valueOf(paramBoolean) });
      dm localdm = new dm();
      localdm.dGw.md5 = paramEmojiInfo.getMd5();
      localdm.dGw.dDe = 0;
      localdm.dGw.success = paramBoolean;
      EventCenter.instance.publish(localdm);
      long l = System.currentTimeMillis() - this.gXF;
      Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + l + " size " + paramEmojiInfo.field_size + " rate " + paramEmojiInfo.field_size / l);
    }
    AppMethodBeat.o(108678);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int j = -1;
    AppMethodBeat.i(108675);
    this.callback = parami;
    ene localene = (ene)((ajb)this.rr.iLK.iLR).LsE.get(0);
    int i;
    if (this.gvP)
    {
      Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + localene.MD5);
      localene.BsG = 0;
      i = this.dEz.field_size + 0;
      if (i <= 8192) {
        break label731;
      }
      i = 8192;
    }
    label731:
    for (;;)
    {
      byte[] arrayOfByte;
      if ((this.dEz.field_reserved4 & EmojiInfo.UuK) == EmojiInfo.UuK)
      {
        arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dEz);
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
        parami = this.dEz.ht(0, i);
      }
      localene.BsG = 0;
      localene.Nlc = new b(parami);
      int k = parami.length;
      int m = localene.Nlc.zy.length;
      if (this.dEz == null)
      {
        i = -1;
        if (this.dEz != null) {
          break label365;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) });
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(108675);
        return i;
        i = this.dEz.field_start;
        break;
        label365:
        j = this.dEz.field_size;
      }
      if ((this.dEz == null) || (this.dEz.field_start == 0))
      {
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
        AppMethodBeat.o(108675);
        return -1;
      }
      i = this.dEz.field_size - this.dEz.field_start;
      if (i > 8192) {
        i = 8192;
      }
      for (;;)
      {
        if ((this.dEz.field_reserved4 & EmojiInfo.UuK) == EmojiInfo.UuK)
        {
          arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dEz);
          if (!Util.isNullOrNil(arrayOfByte))
          {
            parami = new byte[i];
            Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
            System.arraycopy(arrayOfByte, this.dEz.field_start, parami, 0, i);
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
          parami = this.dEz.ht(this.dEz.field_start, i);
        }
        i = parami.length;
        localene.BsG = this.dEz.field_start;
        localene.Nlc = new b(parami);
        Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[] { Integer.valueOf(parami.length), Integer.valueOf(localene.Nlc.zy.length) });
        Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.dEz.field_start + ", total:" + this.dEz.field_size + ", len:" + i);
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
      cGr();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.dEz, false);
      AppMethodBeat.o(108676);
      return;
    }
    ajb localajb = (ajb)((com.tencent.mm.ak.d)params).iLK.iLR;
    paramArrayOfByte = (ajc)((com.tencent.mm.ak.d)params).iLL.iLR;
    if (localajb.LsE.size() != paramArrayOfByte.LsE.size())
    {
      Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + localajb.LsE.size() + ", resp size:" + paramArrayOfByte.LsE.size());
      cGr();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.dEz, false);
      AppMethodBeat.o(108676);
      return;
    }
    params = null;
    paramString = params;
    if (paramArrayOfByte.LsE != null)
    {
      paramString = params;
      if (paramArrayOfByte.LsE.size() > 0) {
        paramString = (enf)paramArrayOfByte.LsE.get(0);
      }
    }
    int i;
    if ((paramString == null) || (paramString.MD5 == null) || (!paramString.MD5.equals(this.dEz.getMd5())) || (paramString.BsG < this.dEz.field_start))
    {
      params = paramString.MD5;
      i = paramString.BsF;
      if (paramString == null)
      {
        paramInt1 = -1;
        if (this.dEz != null) {
          break label431;
        }
        paramInt2 = -1;
        label331:
        if (this.dEz != null) {
          break label442;
        }
      }
      label431:
      label442:
      for (paramInt3 = -1;; paramInt3 = this.dEz.field_size)
      {
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d", new Object[] { params, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        cGr();
        this.callback.onSceneEnd(4, -2, "", this);
        e(this.dEz, false);
        AppMethodBeat.o(108676);
        return;
        paramInt1 = paramString.BsG;
        break;
        paramInt2 = this.dEz.field_start;
        break label331;
      }
    }
    if ((paramString != null) && (this.dEz != null) && (paramString.Ret != 0) && (paramString.BsG == paramString.BsF) && (paramString.BsG > 0))
    {
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[] { this.dEz.getMd5(), Integer.valueOf(paramString.Ret), Integer.valueOf(paramString.BsG), Integer.valueOf(paramString.BsF) });
      cGr();
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
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        cGr();
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108676);
        return;
      }
    }
    if (this.gvP) {
      this.gvP = false;
    }
    if (paramString.BsG >= paramString.BsF)
    {
      this.dEz.field_start = 0;
      this.dEz.field_state = EmojiInfo.UuD;
      this.dEz.field_needupload = EmojiInfo.UuI;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(this.dEz);
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      e(this.dEz, true);
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
      AppMethodBeat.o(108676);
      return;
    }
    Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[] { Integer.valueOf(paramString.BsG) });
    this.dEz.field_start = paramString.BsG;
    ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.L(this.dEz);
    if (doScene(dispatcher(), this.callback) < 0)
    {
      this.callback.onSceneEnd(3, -1, "", this);
      e(this.dEz, false);
    }
    AppMethodBeat.o(108676);
  }
  
  public final int securityLimitCount()
  {
    return this.rcC;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.g
 * JD-Core Version:    0.7.0.1
 */