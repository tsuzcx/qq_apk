package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ftx;
import com.tencent.mm.protocal.protobuf.fty;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class u
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private int pTf;
  private final c rr;
  private List<String> xOZ;
  
  public u(List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(108726);
    this.xOZ = new ArrayList();
    c.a locala = new c.a();
    locala.otE = new ftx();
    locala.otF = new fty();
    locala.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
    locala.funcId = 717;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xOZ = paramList;
    this.pTf = paramInt;
    AppMethodBeat.o(108726);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(108728);
    this.callback = paramh;
    ftx localftx = (ftx)c.b.b(this.rr.otB);
    localftx.YIq = this.pTf;
    if (this.xOZ != null)
    {
      Iterator localIterator = this.xOZ.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramh = str;
        if (!Util.isNullOrNil(str))
        {
          paramh = str;
          if (str.equals(String.valueOf(EmojiGroupInfo.aklD))) {
            paramh = "com.tencent.xin.emoticon.tusiji";
          }
        }
        localftx.abRZ.add(paramh);
        Log.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[] { paramh });
      }
      Log.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[] { Integer.valueOf(this.pTf), Integer.valueOf(this.xOZ.size()) });
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
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHV, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHY, Boolean.TRUE);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(165L, 0L, 1L, false);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108727);
      return;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acHV, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(165L, 1L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.u
 * JD-Core Version:    0.7.0.1
 */