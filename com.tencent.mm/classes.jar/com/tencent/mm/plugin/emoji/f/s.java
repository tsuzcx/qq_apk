package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends m
  implements k
{
  private f callback;
  private int gxQ;
  private List<String> liZ;
  private final b rr;
  
  public s(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(53153);
    this.liZ = new ArrayList();
    b.a locala = new b.a();
    locala.fsX = new cop();
    locala.fsY = new coq();
    locala.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
    locala.funcId = 717;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.liZ = paramList;
    this.gxQ = paramInt;
    AppMethodBeat.o(53153);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(53155);
    this.callback = paramf;
    cop localcop = (cop)this.rr.fsV.fta;
    localcop.OpCode = this.gxQ;
    if (this.liZ != null)
    {
      Iterator localIterator = this.liZ.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramf = str;
        if (!bo.isNullOrNil(str))
        {
          paramf = str;
          if (str.equals(String.valueOf(EmojiGroupInfo.yPd))) {
            paramf = "com.tencent.xin.emoticon.tusiji";
          }
        }
        localcop.xXt.add(paramf);
        ab.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[] { paramf });
      }
      ab.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[] { Integer.valueOf(this.gxQ), Integer.valueOf(this.liZ.size()) });
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53155);
    return i;
  }
  
  public final int getType()
  {
    return 717;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53154);
    ab.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.RL().Ru().set(ac.a.yxN, Long.valueOf(System.currentTimeMillis()));
      g.RL().Ru().set(ac.a.yxQ, Boolean.TRUE);
      h.qsU.idkeyStat(165L, 0L, 1L, false);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(53154);
      return;
      g.RL().Ru().set(ac.a.yxN, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      h.qsU.idkeyStat(165L, 1L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.s
 * JD-Core Version:    0.7.0.1
 */