package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dtb;
import com.tencent.mm.protocal.protobuf.dtc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends n
  implements k
{
  private f callback;
  private int jed;
  private List<String> pGp;
  private final b rr;
  
  public s(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(108726);
    this.pGp = new ArrayList();
    b.a locala = new b.a();
    locala.hNM = new dtb();
    locala.hNN = new dtc();
    locala.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
    locala.funcId = 717;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pGp = paramList;
    this.jed = paramInt;
    AppMethodBeat.o(108726);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108728);
    this.callback = paramf;
    dtb localdtb = (dtb)this.rr.hNK.hNQ;
    localdtb.OpCode = this.jed;
    if (this.pGp != null)
    {
      Iterator localIterator = this.pGp.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramf = str;
        if (!bt.isNullOrNil(str))
        {
          paramf = str;
          if (str.equals(String.valueOf(EmojiGroupInfo.OeK))) {
            paramf = "com.tencent.xin.emoticon.tusiji";
          }
        }
        localdtb.HFQ.add(paramf);
        ad.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[] { paramf });
      }
      ad.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[] { Integer.valueOf(this.jed), Integer.valueOf(this.pGp.size()) });
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
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqo, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqr, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(165L, 0L, 1L, false);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108727);
      return;
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.Iqo, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(165L, 1L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.s
 * JD-Core Version:    0.7.0.1
 */