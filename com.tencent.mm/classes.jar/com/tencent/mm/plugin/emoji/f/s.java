package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dhv;
import com.tencent.mm.protocal.protobuf.dhw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  private int ikN;
  private List<String> ozf;
  private final b rr;
  
  public s(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(108726);
    this.ozf = new ArrayList();
    b.a locala = new b.a();
    locala.gUU = new dhv();
    locala.gUV = new dhw();
    locala.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
    locala.funcId = 717;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.ozf = paramList;
    this.ikN = paramInt;
    AppMethodBeat.o(108726);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(108728);
    this.callback = paramg;
    dhv localdhv = (dhv)this.rr.gUS.gUX;
    localdhv.OpCode = this.ikN;
    if (this.ozf != null)
    {
      Iterator localIterator = this.ozf.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramg = str;
        if (!bt.isNullOrNil(str))
        {
          paramg = str;
          if (str.equals(String.valueOf(EmojiGroupInfo.LBN))) {
            paramg = "com.tencent.xin.emoticon.tusiji";
          }
        }
        localdhv.Eya.add(paramg);
        ad.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[] { paramg });
      }
      ad.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[] { Integer.valueOf(this.ikN), Integer.valueOf(this.ozf.size()) });
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108728);
    return i;
  }
  
  public final int getType()
  {
    return 717;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108727);
    ad.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgh, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgk, Boolean.TRUE);
      h.vKh.idkeyStat(165L, 0L, 1L, false);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108727);
      return;
      com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fgh, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      h.vKh.idkeyStat(165L, 1L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.s
 * JD-Core Version:    0.7.0.1
 */