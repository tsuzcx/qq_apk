package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.bud;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bj;

public final class m
  extends q
  implements com.tencent.mm.network.m
{
  private int aan;
  private i callback;
  private int mScene;
  private final com.tencent.mm.an.d rr;
  public String uFI;
  
  public m(String paramString, int paramInt)
  {
    this(paramString, paramInt, -1);
  }
  
  public m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108699);
    this.uFI = paramString;
    this.mScene = paramInt1;
    this.aan = paramInt2;
    paramString = new d.a();
    paramString.lBU = new buc();
    paramString.lBV = new bud();
    paramString.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
    paramString.funcId = 412;
    paramString.lBW = 211;
    paramString.respCmdId = 1000000211;
    this.rr = paramString.bgN();
    AppMethodBeat.o(108699);
  }
  
  public final akb cVe()
  {
    AppMethodBeat.i(108702);
    new akb();
    akb localakb = ((bud)d.c.b(this.rr.lBS)).VHU;
    AppMethodBeat.o(108702);
    return localakb;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108700);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[] { this.uFI, Integer.valueOf(this.mScene), Integer.valueOf(this.aan) });
    this.callback = parami;
    parami = (buc)d.b.b(this.rr.lBR);
    parami.ProductID = this.uFI;
    parami.CPw = this.mScene;
    parami.rWt = this.aan;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108700);
    return i;
  }
  
  public final int getType()
  {
    return 412;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108701);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    if ((paramInt2 != 0) && (paramInt3 != 0) && (paramInt3 != 5))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108701);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ((com.tencent.mm.plugin.emoji.b.d)h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().VFL.a(this.uFI, (bud)d.c.b(this.rr.lBS), LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.m
 * JD-Core Version:    0.7.0.1
 */