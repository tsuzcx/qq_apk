package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eye;
import com.tencent.mm.protocal.protobuf.eyf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends q
  implements m
{
  private i callback;
  private int mWz;
  private final d rr;
  private List<String> uGt;
  
  public t(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(108726);
    this.uGt = new ArrayList();
    d.a locala = new d.a();
    locala.lBU = new eye();
    locala.lBV = new eyf();
    locala.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
    locala.funcId = 717;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.uGt = paramList;
    this.mWz = paramInt;
    AppMethodBeat.o(108726);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108728);
    this.callback = parami;
    eye localeye = (eye)d.b.b(this.rr.lBR);
    localeye.RLe = this.mWz;
    if (this.uGt != null)
    {
      Iterator localIterator = this.uGt.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        parami = str;
        if (!Util.isNullOrNil(str))
        {
          parami = str;
          if (str.equals(String.valueOf(EmojiGroupInfo.YCu))) {
            parami = "com.tencent.xin.emoticon.tusiji";
          }
        }
        localeye.Uyv.add(parami);
        Log.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[] { parami });
      }
      Log.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[] { Integer.valueOf(this.mWz), Integer.valueOf(this.uGt.size()) });
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108728);
    return i;
  }
  
  public final int getType()
  {
    return 717;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108727);
    Log.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgG, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgJ, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(165L, 0L, 1L, false);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108727);
      return;
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgG, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(165L, 1L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.t
 * JD-Core Version:    0.7.0.1
 */