package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.emoji.e.d.a;
import com.tencent.mm.j.a;
import com.tencent.mm.j.a.a;
import com.tencent.mm.message.l;
import com.tencent.mm.model.bt;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.ftj;
import com.tencent.mm.protocal.protobuf.ftk;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import junit.framework.Assert;

public final class t
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private EmojiInfo hBS;
  private boolean lBW;
  private long oGz;
  private final c rr;
  private boolean xOX;
  
  public t(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong)
  {
    this(paramString1, paramString2, paramEmojiInfo, paramLong, (byte)0);
  }
  
  private t(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong, byte paramByte)
  {
    AppMethodBeat.i(108723);
    this.lBW = true;
    this.xOX = false;
    this.oGz = 0L;
    boolean bool;
    Object localObject;
    amv localamv;
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramEmojiInfo != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.oGz = paramLong;
      this.hBS = paramEmojiInfo;
      localObject = new c.a();
      ((c.a)localObject).otE = new ftj();
      ((c.a)localObject).otF = new ftk();
      ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/sendemoji";
      ((c.a)localObject).funcId = 175;
      ((c.a)localObject).otG = 68;
      ((c.a)localObject).respCmdId = 1000000068;
      this.rr = ((c.a)localObject).bEF();
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.a(MMApplicationContext.getContext(), paramEmojiInfo);
      localObject = (ftj)c.b.b(this.rr.otB);
      localamv = new amv();
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", new Object[] { paramEmojiInfo.getMd5(), Integer.valueOf(paramEmojiInfo.field_size) });
      localamv.MD5 = paramEmojiInfo.getMd5();
      localamv.ZtO = paramString1;
      localamv.IMg = paramString2;
      localamv.NkN = paramEmojiInfo.field_size;
      localamv.ZtM = paramEmojiInfo.getContent();
      localamv.vhJ = paramEmojiInfo.field_type;
      localamv.YFJ = bt.bCQ();
      localamv.ZtP = 0;
      if (((v)com.tencent.mm.kernel.h.az(v.class)).ifAddTicketByActionFlag(paramString2)) {
        localamv.ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(paramString2);
      }
      if (!au.bwE(paramString2)) {
        break label378;
      }
      paramByte = 2;
      label317:
      if (paramEmojiInfo.field_catalog != EmojiInfo.aklL) {
        break label384;
      }
      localamv.ZtN = "56,2,".concat(String.valueOf(paramByte));
    }
    for (;;)
    {
      ((ftj)localObject).ZtR.add(localamv);
      ((ftj)localObject).abRC = ((ftj)localObject).ZtR.size();
      AppMethodBeat.o(108723);
      return;
      bool = false;
      break;
      label378:
      paramByte = 1;
      break label317;
      label384:
      if (paramEmojiInfo.field_catalog == EmojiInfo.aklK) {
        localamv.ZtN = "56,1,".concat(String.valueOf(paramByte));
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(108724);
    this.callback = paramh;
    amv localamv = (amv)((ftj)c.b.b(this.rr.otB)).ZtR.get(0);
    if (this.lBW)
    {
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + localamv.MD5);
      localamv.ZtL = new gol();
      localamv.NkO = 0;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108724);
      return i;
    }
    int j = this.hBS.field_size - this.hBS.field_start;
    int i = j;
    if (j > 8192) {
      i = 8192;
    }
    if ((this.hBS.field_reserved4 & EmojiInfo.akmb) == EmojiInfo.akmb)
    {
      byte[] arrayOfByte = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().a(this.hBS);
      if (!Util.isNullOrNil(arrayOfByte))
      {
        paramh = new byte[i];
        Log.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
        System.arraycopy(arrayOfByte, this.hBS.field_start, paramh, 0, i);
      }
    }
    while ((com.tencent.mm.plugin.emoji.g.d.bH(paramh) == EmojiInfo.aklC) && (this.lBW))
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
      this.hBS.kMa();
      AppMethodBeat.o(108724);
      return -1;
      Log.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
      paramh = new byte[0];
      continue;
      paramh = this.hBS.qH(this.hBS.field_start, i);
    }
    if ((paramh == null) || (paramh.length <= 0))
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
      AppMethodBeat.o(108724);
      return -1;
    }
    i = paramh.length;
    localamv.NkO = this.hBS.field_start;
    localamv.ZtL = new gol().m(com.tencent.mm.bx.b.cX(paramh));
    if (com.tencent.mm.an.g.Dn(localamv.IMg))
    {
      paramh = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.oGz);
      localamv.YFJ = a.a.aOb().o(paramh);
      Log.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[] { localamv.YFJ });
    }
    Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.hBS.field_start + ", total:" + this.hBS.field_size + ", len:" + i);
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108724);
    return i;
  }
  
  public final int getType()
  {
    return 175;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108725);
    Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramArrayOfByte = (ftj)c.b.b(((c)params).otB);
    params = (ftk)c.c.b(((c)params).otC);
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((v)com.tencent.mm.kernel.h.az(v.class)).setEnSendMsgActionFlag(params.ZaS);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramArrayOfByte.ZtR.size() != params.ZtR.size())
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + params.ZtR.size() + ", resp size:" + paramArrayOfByte.ZtR.size());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    paramString = (amw)params.ZtR.get(0);
    if ((paramString.MD5 == null) || (!paramString.MD5.equals(this.hBS.getMd5())) || (paramString.NkO < this.hBS.field_start))
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + paramString.NkO + ", size=" + this.hBS.field_size);
      this.callback.onSceneEnd(4, -2, "", this);
      this.hBS.field_start = 0;
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.N(this.hBS);
      AppMethodBeat.o(108725);
      return;
    }
    if (params.BaseResponse.Idd != 0)
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[] { Integer.valueOf(params.BaseResponse.Idd) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.Idd != 0)
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd: respInfo Ret %s", new Object[] { Integer.valueOf(paramString.Idd) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.NkO >= paramString.NkN)
    {
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + paramString.ZtQ);
      params = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.oGz);
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramString.Njv), Integer.valueOf(z.pCn) });
      if ((10007 == z.pCm) && (z.pCn != 0))
      {
        paramString.ZtQ = z.pCn;
        z.pCn = 0;
      }
      params.gX(paramString.Njv);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.oGz, params);
      paramString = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.bza(this.hBS.field_md5);
      if (paramString != null) {
        break label838;
      }
      paramString = this.hBS;
    }
    label838:
    for (;;)
    {
      paramString.field_start = 0;
      paramString.field_lastUseTime = System.currentTimeMillis();
      paramString.field_state = EmojiInfo.aklU;
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.N(paramString);
      if (params.fxR()) {
        com.tencent.mm.modelstat.b.oUZ.d(params, l.v(params));
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108725);
        return;
        com.tencent.mm.modelstat.b.oUZ.u(params);
      }
      if (this.xOX)
      {
        this.callback.onSceneEnd(4, -2, "", this);
        AppMethodBeat.o(108725);
        return;
      }
      new com.tencent.mm.emoji.e.f(this.hBS, false, new d.a()
      {
        public final void onResult(int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(108722);
          if (paramAnonymousInt == 0)
          {
            t.a(t.this);
            t.b(t.this);
            if (t.this.doScene(t.c(t.this), t.d(t.this)) < 0)
            {
              t.d(t.this).onSceneEnd(3, -1, "", t.this);
              AppMethodBeat.o(108722);
            }
          }
          else
          {
            t.d(t.this).onSceneEnd(4, -2, "", t.this);
          }
          AppMethodBeat.o(108722);
        }
      });
      AppMethodBeat.o(108725);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 256;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.t
 * JD-Core Version:    0.7.0.1
 */