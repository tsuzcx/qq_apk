package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.l;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.emoji.b.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bs;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.exq;
import com.tencent.mm.protocal.protobuf.exr;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.LinkedList;
import junit.framework.Assert;

public final class s
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  private EmojiInfo fxn;
  private boolean jab;
  private long lNP;
  private final com.tencent.mm.an.d rr;
  private boolean uGr;
  
  public s(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong)
  {
    this(paramString1, paramString2, paramEmojiInfo, paramLong, (byte)0);
  }
  
  private s(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong, byte paramByte)
  {
    AppMethodBeat.i(108723);
    this.jab = true;
    this.uGr = false;
    this.lNP = 0L;
    boolean bool;
    Object localObject;
    ajo localajo;
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramEmojiInfo != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.lNP = paramLong;
      this.fxn = paramEmojiInfo;
      localObject = new com.tencent.mm.an.d.a();
      ((com.tencent.mm.an.d.a)localObject).lBU = new exq();
      ((com.tencent.mm.an.d.a)localObject).lBV = new exr();
      ((com.tencent.mm.an.d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendemoji";
      ((com.tencent.mm.an.d.a)localObject).funcId = 175;
      ((com.tencent.mm.an.d.a)localObject).lBW = 68;
      ((com.tencent.mm.an.d.a)localObject).respCmdId = 1000000068;
      this.rr = ((com.tencent.mm.an.d.a)localObject).bgN();
      ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.a(MMApplicationContext.getContext(), paramEmojiInfo);
      localObject = (exq)d.b.b(this.rr.lBR);
      localajo = new ajo();
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", new Object[] { paramEmojiInfo.getMd5(), Integer.valueOf(paramEmojiInfo.field_size) });
      localajo.MD5 = paramEmojiInfo.getMd5();
      localajo.Sua = paramString1;
      localajo.CRQ = paramString2;
      localajo.HmZ = paramEmojiInfo.field_size;
      localajo.StY = paramEmojiInfo.getContent();
      localajo.rWu = paramEmojiInfo.field_type;
      localajo.RII = bs.apc();
      localajo.Sub = 0;
      if (((v)h.ag(v.class)).ifAddTicketByActionFlag(paramString2)) {
        localajo.ScZ = ((n)h.ae(n.class)).bbL().bws(paramString2);
      }
      if (!ab.Lj(paramString2)) {
        break label381;
      }
      paramByte = 2;
      label320:
      if (paramEmojiInfo.field_catalog != EmojiInfo.YCC) {
        break label387;
      }
      localajo.StZ = "56,2,".concat(String.valueOf(paramByte));
    }
    for (;;)
    {
      ((exq)localObject).Sud.add(localajo);
      ((exq)localObject).UxV = ((exq)localObject).Sud.size();
      AppMethodBeat.o(108723);
      return;
      bool = false;
      break;
      label381:
      paramByte = 1;
      break label320;
      label387:
      if (paramEmojiInfo.field_catalog == EmojiInfo.YCB) {
        localajo.StZ = "56,1,".concat(String.valueOf(paramByte));
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(108724);
    this.callback = parami;
    ajo localajo = (ajo)((exq)d.b.b(this.rr.lBR)).Sud.get(0);
    if (this.jab)
    {
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + localajo.MD5);
      localajo.StX = new eae();
      localajo.Hna = 0;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108724);
      return i;
    }
    int j = this.fxn.field_size - this.fxn.field_start;
    int i = j;
    if (j > 8192) {
      i = 8192;
    }
    if ((this.fxn.field_reserved4 & EmojiInfo.ZuM) == EmojiInfo.ZuM)
    {
      byte[] arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.fxn);
      if (!Util.isNullOrNil(arrayOfByte))
      {
        parami = new byte[i];
        Log.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
        System.arraycopy(arrayOfByte, this.fxn.field_start, parami, 0, i);
      }
    }
    while ((com.tencent.mm.plugin.emoji.i.b.bH(parami) == EmojiInfo.YCt) && (this.jab))
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
      this.fxn.hBq();
      AppMethodBeat.o(108724);
      return -1;
      Log.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
      parami = new byte[0];
      continue;
      parami = this.fxn.oH(this.fxn.field_start, i);
    }
    if ((parami == null) || (parami.length <= 0))
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
      AppMethodBeat.o(108724);
      return -1;
    }
    i = parami.length;
    localajo.Hna = this.fxn.field_start;
    localajo.StX = new eae().g(com.tencent.mm.cd.b.cU(parami));
    if (com.tencent.mm.ao.g.KI(localajo.CRQ))
    {
      parami = ((n)h.ae(n.class)).eSe().Oq(this.lNP);
      localajo.RII = a.a.atD().o(parami);
      Log.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[] { localajo.RII });
    }
    Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.fxn.field_start + ", total:" + this.fxn.field_size + ", len:" + i);
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108724);
    return i;
  }
  
  public final int getType()
  {
    return 175;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108725);
    Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3);
    paramArrayOfByte = (exq)d.b.b(((com.tencent.mm.an.d)params).lBR);
    params = (exr)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((v)h.ag(v.class)).setEnSendMsgActionFlag(params.Sda);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramArrayOfByte.Sud.size() != params.Sud.size())
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + params.Sud.size() + ", resp size:" + paramArrayOfByte.Sud.size());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    paramString = (ajp)params.Sud.get(0);
    if ((paramString.MD5 == null) || (!paramString.MD5.equals(this.fxn.getMd5())) || (paramString.Hna < this.fxn.field_start))
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + paramString.Hna + ", size=" + this.fxn.field_size);
      this.callback.onSceneEnd(4, -2, "", this);
      this.fxn.field_start = 0;
      ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.N(this.fxn);
      AppMethodBeat.o(108725);
      return;
    }
    if (params.BaseResponse.CqV != 0)
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[] { Integer.valueOf(params.BaseResponse.CqV) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.CqV != 0)
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd: respInfo Ret %s", new Object[] { Integer.valueOf(paramString.CqV) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.Hna >= paramString.HmZ)
    {
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + paramString.Suc);
      params = ((n)h.ae(n.class)).eSe().Oq(this.lNP);
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramString.HlH), Integer.valueOf(ac.mFN) });
      if ((10007 == ac.mFM) && (ac.mFN != 0))
      {
        paramString.Suc = ac.mFN;
        ac.mFN = 0;
      }
      params.EG(paramString.HlH);
      ((n)h.ae(n.class)).eSe().a(this.lNP, params);
      paramString = ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.bxK(this.fxn.field_md5);
      if (paramString != null) {
        break label939;
      }
      paramString = this.fxn;
    }
    label939:
    for (;;)
    {
      paramString.field_start = 0;
      paramString.field_lastUseTime = System.currentTimeMillis();
      paramString.field_state = EmojiInfo.ZuF;
      ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.N(paramString);
      if (params.erk()) {
        com.tencent.mm.modelstat.b.mcf.d(params, l.v(params));
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108725);
        return;
        com.tencent.mm.modelstat.b.mcf.u(params);
      }
      if (o.aCg())
      {
        if (this.uGr)
        {
          this.callback.onSceneEnd(4, -2, "", this);
          AppMethodBeat.o(108725);
          return;
        }
        new com.tencent.mm.emoji.d.f(this.fxn, false, new com.tencent.mm.emoji.d.d.a()
        {
          public final void B(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(108722);
            if (paramAnonymousInt == 0)
            {
              s.a(s.this);
              s.b(s.this);
              if (s.this.doScene(s.c(s.this), s.d(s.this)) < 0)
              {
                s.d(s.this).onSceneEnd(3, -1, "", s.this);
                AppMethodBeat.o(108722);
              }
            }
            else
            {
              s.d(s.this).onSceneEnd(4, -2, "", s.this);
            }
            AppMethodBeat.o(108722);
          }
        });
        AppMethodBeat.o(108725);
        return;
      }
      if (this.jab) {
        this.jab = false;
      }
      this.fxn.field_start = paramString.Hna;
      this.fxn.field_lastUseTime = System.currentTimeMillis();
      ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFH.N(this.fxn);
      if (doScene(dispatcher(), this.callback) < 0) {
        this.callback.onSceneEnd(3, -1, "", this);
      }
      AppMethodBeat.o(108725);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 256;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.s
 * JD-Core Version:    0.7.0.1
 */