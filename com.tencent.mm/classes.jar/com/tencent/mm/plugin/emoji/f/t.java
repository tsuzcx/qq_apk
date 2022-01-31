package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cbj;
import com.tencent.mm.protocal.c.cbk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class t
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private int fgi;
  private List<String> jai = new ArrayList();
  
  public t(List<String> paramList, int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new cbj();
    locala.ecI = new cbk();
    locala.uri = "/cgi-bin/micromsg-bin/mmuploadmypanellist";
    locala.ecG = 717;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.jai = paramList;
    this.fgi = paramInt;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    cbj localcbj = (cbj)this.dmK.ecE.ecN;
    localcbj.ssq = this.fgi;
    if (this.jai != null)
    {
      Iterator localIterator = this.jai.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramf = str;
        if (!bk.bl(str))
        {
          paramf = str;
          if (str.equals(String.valueOf(EmojiGroupInfo.uCQ))) {
            paramf = "com.tencent.xin.emoticon.tusiji";
          }
        }
        localcbj.tQy.add(paramf);
        y.d("MicroMsg.emoji.NetSceneUploadMyPanelList", "product id is:%s", new Object[] { paramf });
      }
      y.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "opcode is:%d mProductIdList size:%s", new Object[] { Integer.valueOf(this.fgi), Integer.valueOf(this.jai.size()) });
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.emoji.NetSceneUploadMyPanelList", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.DP().Dz().c(ac.a.unW, Long.valueOf(System.currentTimeMillis()));
      g.DP().Dz().c(ac.a.unZ, Boolean.valueOf(true));
      h.nFQ.a(165L, 0L, 1L, false);
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      g.DP().Dz().c(ac.a.unW, Long.valueOf(System.currentTimeMillis() - 86400000L + 3600000L));
      h.nFQ.a(165L, 1L, 1L, false);
    }
  }
  
  public final int getType()
  {
    return 717;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.t
 * JD-Core Version:    0.7.0.1
 */