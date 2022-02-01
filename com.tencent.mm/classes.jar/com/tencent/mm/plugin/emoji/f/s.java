package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dty;
import com.tencent.mm.protocal.protobuf.dtz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private int jgW;
  private List<String> pMT;
  private final b rr;
  
  public s(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(108726);
    this.pMT = new ArrayList();
    b.a locala = new b.a();
    locala.hQF = new dty();
    locala.hQG = new dtz();
    locala.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
    locala.funcId = 717;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pMT = paramList;
    this.jgW = paramInt;
    AppMethodBeat.o(108726);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108728);
    this.callback = paramf;
    dty localdty = (dty)this.rr.hQD.hQJ;
    localdty.OpCode = this.jgW;
    if (this.pMT != null)
    {
      Iterator localIterator = this.pMT.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramf = str;
        if (!bu.isNullOrNil(str))
        {
          paramf = str;
          if (str.equals(String.valueOf(EmojiGroupInfo.OzR))) {
            paramf = "com.tencent.xin.emoticon.tusiji";
          }
        }
        localdty.HZD.add(paramf);
        ae.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[] { paramf });
      }
      ae.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[] { Integer.valueOf(this.jgW), Integer.valueOf(this.pMT.size()) });
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
    ae.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKK, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKN, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(165L, 0L, 1L, false);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108727);
      return;
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IKK, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(165L, 1L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.s
 * JD-Core Version:    0.7.0.1
 */