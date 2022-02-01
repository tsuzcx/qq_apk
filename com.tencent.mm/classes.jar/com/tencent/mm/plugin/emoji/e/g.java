package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.eb;
import com.tencent.mm.bx.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.ftf;
import com.tencent.mm.protocal.protobuf.ftg;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.f;
import java.util.LinkedList;

public final class g
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private EmojiInfo hBS;
  private boolean lBW;
  private long moe;
  private final c rr;
  private int xOj;
  
  public g(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(108674);
    this.lBW = true;
    this.xOj = 256;
    this.moe = System.currentTimeMillis();
    Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.moe);
    this.hBS = paramEmojiInfo;
    paramEmojiInfo = new c.a();
    paramEmojiInfo.otE = new amx();
    paramEmojiInfo.otF = new amy();
    paramEmojiInfo.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
    paramEmojiInfo.funcId = 703;
    paramEmojiInfo.otG = 0;
    paramEmojiInfo.respCmdId = 0;
    this.rr = paramEmojiInfo.bEF();
    paramEmojiInfo = (amx)c.b.b(this.rr.otB);
    ftf localftf = new ftf();
    if (this.hBS != null)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(164L, 13L, 1L);
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", new Object[] { this.hBS.getMd5() });
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.a(MMApplicationContext.getContext(), this.hBS);
      localftf.MD5 = this.hBS.getMd5();
      localftf.NkN = this.hBS.field_size;
      paramEmojiInfo.ZtR.add(localftf);
      this.xOj = (this.hBS.field_size / 8192 * 2);
    }
    AppMethodBeat.o(108674);
  }
  
  private void dAz()
  {
    AppMethodBeat.i(108677);
    this.hBS.field_start = 0;
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.M(this.hBS);
    AppMethodBeat.o(108677);
  }
  
  private void e(EmojiInfo paramEmojiInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(108678);
    if ((paramEmojiInfo != null) && (!Util.isNullOrNil(paramEmojiInfo.getMd5())))
    {
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", new Object[] { paramEmojiInfo.getMd5(), Boolean.valueOf(paramBoolean) });
      eb localeb = new eb();
      localeb.hDQ.md5 = paramEmojiInfo.getMd5();
      localeb.hDQ.hAf = 0;
      localeb.hDQ.success = paramBoolean;
      localeb.publish();
      long l = System.currentTimeMillis() - this.moe;
      Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + l + " size " + paramEmojiInfo.field_size + " rate " + paramEmojiInfo.field_size / l);
    }
    AppMethodBeat.o(108678);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    int j = -1;
    AppMethodBeat.i(108675);
    this.callback = paramh;
    ftf localftf = (ftf)((amx)c.b.b(this.rr.otB)).ZtR.get(0);
    int i;
    if (this.lBW)
    {
      Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + localftf.MD5);
      localftf.NkO = 0;
      i = this.hBS.field_size + 0;
      if (i <= 8192) {
        break label731;
      }
      i = 8192;
    }
    label731:
    for (;;)
    {
      byte[] arrayOfByte;
      if ((this.hBS.field_reserved4 & EmojiInfo.akmb) == EmojiInfo.akmb)
      {
        arrayOfByte = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(this.hBS);
        if (!Util.isNullOrNil(arrayOfByte))
        {
          paramh = new byte[i];
          Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
          System.arraycopy(arrayOfByte, 0, paramh, 0, i);
        }
      }
      while ((paramh == null) || (paramh.length <= 0))
      {
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
        AppMethodBeat.o(108675);
        return -1;
        Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
        paramh = new byte[0];
        continue;
        paramh = this.hBS.qH(0, i);
      }
      localftf.NkO = 0;
      localftf.abRu = new b(paramh);
      int k = paramh.length;
      int m = localftf.abRu.Op.length;
      if (this.hBS == null)
      {
        i = -1;
        if (this.hBS != null) {
          break label365;
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j) });
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(108675);
        return i;
        i = this.hBS.field_start;
        break;
        label365:
        j = this.hBS.field_size;
      }
      if ((this.hBS == null) || (this.hBS.field_start == 0))
      {
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
        AppMethodBeat.o(108675);
        return -1;
      }
      i = this.hBS.field_size - this.hBS.field_start;
      if (i > 8192) {
        i = 8192;
      }
      for (;;)
      {
        if ((this.hBS.field_reserved4 & EmojiInfo.akmb) == EmojiInfo.akmb)
        {
          arrayOfByte = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(this.hBS);
          if (!Util.isNullOrNil(arrayOfByte))
          {
            paramh = new byte[i];
            Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
            System.arraycopy(arrayOfByte, this.hBS.field_start, paramh, 0, i);
          }
        }
        while ((paramh == null) || (paramh.length <= 0))
        {
          Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
          AppMethodBeat.o(108675);
          return -1;
          Log.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
          paramh = new byte[0];
          continue;
          paramh = this.hBS.qH(this.hBS.field_start, i);
        }
        i = paramh.length;
        localftf.NkO = this.hBS.field_start;
        localftf.abRu = new b(paramh);
        Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", new Object[] { Integer.valueOf(paramh.length), Integer.valueOf(localftf.abRu.Op.length) });
        Log.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.hBS.field_start + ", total:" + this.hBS.field_size + ", len:" + i);
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
      dAz();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.hBS, false);
      AppMethodBeat.o(108676);
      return;
    }
    amx localamx = (amx)c.b.b(((c)params).otB);
    paramArrayOfByte = (amy)c.c.b(((c)params).otC);
    if (localamx.ZtR.size() != paramArrayOfByte.ZtR.size())
    {
      Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + localamx.ZtR.size() + ", resp size:" + paramArrayOfByte.ZtR.size());
      dAz();
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      e(this.hBS, false);
      AppMethodBeat.o(108676);
      return;
    }
    params = null;
    paramString = params;
    if (paramArrayOfByte.ZtR != null)
    {
      paramString = params;
      if (paramArrayOfByte.ZtR.size() > 0) {
        paramString = (ftg)paramArrayOfByte.ZtR.get(0);
      }
    }
    int i;
    if ((paramString == null) || (paramString.MD5 == null) || (!paramString.MD5.equals(this.hBS.getMd5())) || (paramString.NkO < this.hBS.field_start))
    {
      params = paramString.MD5;
      i = paramString.NkN;
      if (paramString == null)
      {
        paramInt1 = -1;
        if (this.hBS != null) {
          break label431;
        }
        paramInt2 = -1;
        label331:
        if (this.hBS != null) {
          break label442;
        }
      }
      label431:
      label442:
      for (paramInt3 = -1;; paramInt3 = this.hBS.field_size)
      {
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d", new Object[] { params, Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
        dAz();
        this.callback.onSceneEnd(4, -2, "", this);
        e(this.hBS, false);
        AppMethodBeat.o(108676);
        return;
        paramInt1 = paramString.NkO;
        break;
        paramInt2 = this.hBS.field_start;
        break label331;
      }
    }
    if ((paramString != null) && (this.hBS != null) && (paramString.Idd != 0) && (paramString.NkO == paramString.NkN) && (paramString.NkO > 0))
    {
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", new Object[] { this.hBS.getMd5(), Integer.valueOf(paramString.Idd), Integer.valueOf(paramString.NkO), Integer.valueOf(paramString.NkN) });
      dAz();
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      AppMethodBeat.o(108676);
      return;
    }
    if ((paramArrayOfByte.BaseResponse.Idd != 0) || ((paramString != null) && (paramString.Idd != 0)))
    {
      i = paramArrayOfByte.BaseResponse.Idd;
      if (paramString == null) {}
      for (paramInt1 = -1;; paramInt1 = paramString.Idd)
      {
        Log.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt1) });
        dAz();
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108676);
        return;
      }
    }
    if (this.lBW) {
      this.lBW = false;
    }
    if (paramString.NkO >= paramString.NkN)
    {
      this.hBS.field_start = 0;
      this.hBS.field_state = EmojiInfo.aklU;
      this.hBS.field_needupload = EmojiInfo.aklZ;
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.M(this.hBS);
      this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
      e(this.hBS, true);
      Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
      AppMethodBeat.o(108676);
      return;
    }
    Log.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", new Object[] { Integer.valueOf(paramString.NkO) });
    this.hBS.field_start = paramString.NkO;
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.M(this.hBS);
    if (doScene(dispatcher(), this.callback) < 0)
    {
      this.callback.onSceneEnd(3, -1, "", this);
      e(this.hBS, false);
    }
    AppMethodBeat.o(108676);
  }
  
  public final int securityLimitCount()
  {
    return this.xOj;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.g
 * JD-Core Version:    0.7.0.1
 */