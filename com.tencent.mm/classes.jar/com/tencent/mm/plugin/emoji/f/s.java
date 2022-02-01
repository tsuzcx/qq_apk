package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.dnk;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  private int iKU;
  private List<String> pcF;
  private final b rr;
  
  public s(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(108726);
    this.pcF = new ArrayList();
    b.a locala = new b.a();
    locala.hvt = new dnk();
    locala.hvu = new dnl();
    locala.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
    locala.funcId = 717;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.pcF = paramList;
    this.iKU = paramInt;
    AppMethodBeat.o(108726);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(108728);
    this.callback = paramg;
    dnk localdnk = (dnk)this.rr.hvr.hvw;
    localdnk.OpCode = this.iKU;
    if (this.pcF != null)
    {
      Iterator localIterator = this.pcF.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramg = str;
        if (!bs.isNullOrNil(str))
        {
          paramg = str;
          if (str.equals(String.valueOf(EmojiGroupInfo.Jsp))) {
            paramg = "com.tencent.xin.emoticon.tusiji";
          }
        }
        localdnk.FVc.add(paramg);
        ac.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[] { paramg });
      }
      ac.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[] { Integer.valueOf(this.iKU), Integer.valueOf(this.pcF.size()) });
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
    ac.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDV, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDY, Boolean.TRUE);
      h.wUl.idkeyStat(165L, 0L, 1L, false);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108727);
      return;
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GDV, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      h.wUl.idkeyStat(165L, 1L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.s
 * JD-Core Version:    0.7.0.1
 */