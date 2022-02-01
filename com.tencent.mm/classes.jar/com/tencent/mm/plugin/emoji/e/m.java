package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.god;
import com.tencent.mm.protocal.protobuf.goe;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bl;

public class m
  extends p
  implements com.tencent.mm.network.m
{
  private int bHI;
  private com.tencent.mm.am.h callback;
  private int mScene;
  private final c rr;
  public String xOk;
  
  public m(String paramString, int paramInt)
  {
    this(paramString, paramInt, -1);
  }
  
  public m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108699);
    this.xOk = paramString;
    this.mScene = paramInt1;
    this.bHI = paramInt2;
    paramString = new c.a();
    paramString.otE = new god();
    paramString.otF = new goe();
    paramString.uri = "/cgi-bin/micromsg-bin/getemotiondetail";
    paramString.funcId = 412;
    paramString.otG = 211;
    paramString.respCmdId = 1000000211;
    this.rr = paramString.bEF();
    AppMethodBeat.o(108699);
  }
  
  public final aoi dAD()
  {
    AppMethodBeat.i(108702);
    new aoi();
    aoi localaoi = ((goe)c.c.b(this.rr.otC)).akkU;
    AppMethodBeat.o(108702);
    return localaoi;
  }
  
  public int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(108700);
    Log.i("MicroMsg.emoji.NetSceneGetEmotionDetail", "ProductID:%s, Scene:%d, Version:%d", new Object[] { this.xOk, Integer.valueOf(this.mScene), Integer.valueOf(this.bHI) });
    this.callback = paramh;
    paramh = (god)c.b.b(this.rr.otB);
    paramh.ProductID = this.xOk;
    paramh.IJG = this.mScene;
    paramh.crz = this.bHI;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108700);
    return i;
  }
  
  public int getType()
  {
    return 412;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
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
      ((d)com.tencent.mm.kernel.h.az(d.class)).getEmojiStorageMgr().adjz.a(this.xOk, (goe)c.c.b(this.rr.otC), LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108701);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.m
 * JD-Core Version:    0.7.0.1
 */