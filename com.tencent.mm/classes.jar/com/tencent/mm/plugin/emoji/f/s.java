package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.emoji.b.n;
import com.tencent.mm.m.a;
import com.tencent.mm.m.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.protocal.protobuf.eni;
import com.tencent.mm.protocal.protobuf.enj;
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
  com.tencent.mm.ak.i callback;
  private EmojiInfo dEz;
  boolean gvP;
  private long iXv;
  boolean rdl;
  private final com.tencent.mm.ak.d rr;
  
  public s(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong)
  {
    this(paramString1, paramString2, paramEmojiInfo, paramLong, (byte)0);
  }
  
  private s(String paramString1, String paramString2, EmojiInfo paramEmojiInfo, long paramLong, byte paramByte)
  {
    AppMethodBeat.i(108723);
    this.gvP = true;
    this.rdl = false;
    this.iXv = 0L;
    boolean bool;
    Object localObject;
    aiz localaiz;
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramEmojiInfo != null))
    {
      bool = true;
      Assert.assertTrue(bool);
      this.iXv = paramLong;
      this.dEz = paramEmojiInfo;
      localObject = new com.tencent.mm.ak.d.a();
      ((com.tencent.mm.ak.d.a)localObject).iLN = new eni();
      ((com.tencent.mm.ak.d.a)localObject).iLO = new enj();
      ((com.tencent.mm.ak.d.a)localObject).uri = "/cgi-bin/micromsg-bin/sendemoji";
      ((com.tencent.mm.ak.d.a)localObject).funcId = 175;
      ((com.tencent.mm.ak.d.a)localObject).iLP = 68;
      ((com.tencent.mm.ak.d.a)localObject).respCmdId = 1000000068;
      this.rr = ((com.tencent.mm.ak.d.a)localObject).aXF();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.a(MMApplicationContext.getContext(), paramEmojiInfo);
      localObject = (eni)this.rr.iLK.iLR;
      localaiz = new aiz();
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", new Object[] { paramEmojiInfo.getMd5(), Integer.valueOf(paramEmojiInfo.field_size) });
      localaiz.MD5 = paramEmojiInfo.getMd5();
      localaiz.LsB = paramString1;
      localaiz.xNG = paramString2;
      localaiz.BsF = paramEmojiInfo.field_size;
      localaiz.Lsz = paramEmojiInfo.getContent();
      localaiz.oUv = paramEmojiInfo.field_type;
      localaiz.KHq = br.ajw();
      localaiz.LsC = 0;
      if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(paramString2)) {
        localaiz.LbN = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjT(paramString2);
      }
      if (!ab.Eq(paramString2)) {
        break label381;
      }
      paramByte = 2;
      label320:
      if (paramEmojiInfo.field_catalog != EmojiInfo.Uuu) {
        break label387;
      }
      localaiz.LsA = "56,2,".concat(String.valueOf(paramByte));
    }
    for (;;)
    {
      ((eni)localObject).LsE.add(localaiz);
      ((eni)localObject).Nlk = ((eni)localObject).LsE.size();
      AppMethodBeat.o(108723);
      return;
      bool = false;
      break;
      label381:
      paramByte = 1;
      break label320;
      label387:
      if (paramEmojiInfo.field_catalog == EmojiInfo.Uut) {
        localaiz.LsA = "56,1,".concat(String.valueOf(paramByte));
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(108724);
    this.callback = parami;
    aiz localaiz = (aiz)((eni)this.rr.iLK.iLR).LsE.get(0);
    if (this.gvP)
    {
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + localaiz.MD5);
      localaiz.Lsy = new SKBuiltinBuffer_t();
      localaiz.BsG = 0;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108724);
      return i;
    }
    int j = this.dEz.field_size - this.dEz.field_start;
    int i = j;
    if (j > 8192) {
      i = 8192;
    }
    if ((this.dEz.field_reserved4 & EmojiInfo.UuK) == EmojiInfo.UuK)
    {
      byte[] arrayOfByte = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.dEz);
      if (!Util.isNullOrNil(arrayOfByte))
      {
        parami = new byte[i];
        Log.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", new Object[] { Integer.valueOf(arrayOfByte.length), Integer.valueOf(i) });
        System.arraycopy(arrayOfByte, this.dEz.field_start, parami, 0, i);
      }
    }
    while ((com.tencent.mm.plugin.emoji.h.b.bt(parami) == EmojiInfo.Uul) && (this.gvP))
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
      this.dEz.hRy();
      AppMethodBeat.o(108724);
      return -1;
      Log.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
      parami = new byte[0];
      continue;
      parami = this.dEz.ht(this.dEz.field_start, i);
    }
    if ((parami == null) || (parami.length <= 0))
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
      AppMethodBeat.o(108724);
      return -1;
    }
    i = parami.length;
    localaiz.BsG = this.dEz.field_start;
    localaiz.Lsy = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cD(parami));
    if (com.tencent.mm.al.g.DQ(localaiz.xNG))
    {
      parami = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(this.iXv);
      localaiz.KHq = a.a.anC().o(parami);
      Log.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", new Object[] { localaiz.KHq });
    }
    Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.dEz.field_start + ", total:" + this.dEz.field_size + ", len:" + i);
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
    paramArrayOfByte = (eni)((com.tencent.mm.ak.d)params).iLK.iLR;
    params = (enj)((com.tencent.mm.ak.d)params).iLL.iLR;
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(params.LbO);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramArrayOfByte.LsE.size() != params.LsE.size())
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + params.LsE.size() + ", resp size:" + paramArrayOfByte.LsE.size());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108725);
      return;
    }
    paramString = (aja)params.LsE.get(0);
    if ((paramString.MD5 == null) || (!paramString.MD5.equals(this.dEz.getMd5())) || (paramString.BsG < this.dEz.field_start))
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + paramString.BsG + ", size=" + this.dEz.field_size);
      this.callback.onSceneEnd(4, -2, "", this);
      this.dEz.field_start = 0;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.M(this.dEz);
      AppMethodBeat.o(108725);
      return;
    }
    if (params.BaseResponse.Ret != 0)
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", new Object[] { Integer.valueOf(params.BaseResponse.Ret) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.Ret != 0)
    {
      Log.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd: respInfo Ret %s", new Object[] { Integer.valueOf(paramString.Ret) });
      this.callback.onSceneEnd(4, -2, "", this);
      AppMethodBeat.o(108725);
      return;
    }
    if (paramString.BsG >= paramString.BsF)
    {
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + paramString.LsD);
      params = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(this.iXv);
      Log.i("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", new Object[] { Long.valueOf(paramString.Brn), Integer.valueOf(ac.jOD) });
      if ((10007 == ac.jOC) && (ac.jOD != 0))
      {
        paramString.LsD = ac.jOD;
        ac.jOD = 0;
      }
      params.yF(paramString.Brn);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.iXv, params);
      paramString = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.blk(this.dEz.field_md5);
      if (paramString != null) {
        break label939;
      }
      paramString = this.dEz;
    }
    label939:
    for (;;)
    {
      paramString.field_start = 0;
      paramString.field_lastUseTime = System.currentTimeMillis();
      paramString.field_state = EmojiInfo.UuD;
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.M(paramString);
      if (params.dOQ()) {
        com.tencent.mm.modelstat.b.jmd.b(params, com.tencent.mm.ag.l.t(params));
      }
      for (;;)
      {
        this.callback.onSceneEnd(paramInt2, paramInt3, "", this);
        AppMethodBeat.o(108725);
        return;
        com.tencent.mm.modelstat.b.jmd.s(params);
      }
      if (n.avl())
      {
        if (this.rdl)
        {
          this.callback.onSceneEnd(4, -2, "", this);
          AppMethodBeat.o(108725);
          return;
        }
        new com.tencent.mm.emoji.d.f(this.dEz, false, new com.tencent.mm.emoji.d.d.a()
        {
          public final void A(int paramAnonymousInt, String paramAnonymousString)
          {
            AppMethodBeat.i(108722);
            if (paramAnonymousInt == 0)
            {
              s.this.rdl = true;
              s.this.gvP = true;
              if (s.this.doScene(s.this.dispatcher(), s.this.callback) < 0)
              {
                s.this.callback.onSceneEnd(3, -1, "", s.this);
                AppMethodBeat.o(108722);
              }
            }
            else
            {
              s.this.callback.onSceneEnd(4, -2, "", s.this);
            }
            AppMethodBeat.o(108722);
          }
        });
        AppMethodBeat.o(108725);
        return;
      }
      if (this.gvP) {
        this.gvP = false;
      }
      this.dEz.field_start = paramString.BsG;
      this.dEz.field_lastUseTime = System.currentTimeMillis();
      ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().OpN.M(this.dEz);
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
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.s
 * JD-Core Version:    0.7.0.1
 */