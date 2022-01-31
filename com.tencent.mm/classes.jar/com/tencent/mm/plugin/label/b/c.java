package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.protocal.protobuf.ajg;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends m
  implements k
{
  private f callback;
  private final b rr;
  
  public c()
  {
    AppMethodBeat.i(22527);
    b.a locala = new b.a();
    locala.fsX = new ajg();
    locala.fsY = new ajh();
    locala.uri = "/cgi-bin/micromsg-bin/getcontactlabellist";
    locala.funcId = 639;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(22527);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(22529);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(22529);
    return i;
  }
  
  public final int getType()
  {
    return 639;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(22528);
    ab.d("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(209408, Long.valueOf(System.currentTimeMillis()));
      paramq = (ajh)this.rr.fsW.fta;
      if ((paramq != null) && (paramq.woA != null))
      {
        paramq = paramq.woA;
        paramArrayOfByte = new ArrayList();
        int j = paramq.size();
        paramInt1 = i;
        while (paramInt1 < j)
        {
          azf localazf = (azf)paramq.get(paramInt1);
          af localaf = new af();
          localaf.field_labelID = localazf.xoC;
          localaf.field_labelName = localazf.xoB;
          localaf.field_labelPYFull = g.wq(localazf.xoB);
          localaf.field_labelPYShort = g.wr(localazf.xoB);
          paramArrayOfByte.add(localaf);
          paramInt1 += 1;
        }
        com.tencent.mm.plugin.label.e.bKU().ez(paramArrayOfByte);
        com.tencent.mm.plugin.label.e.bKU().eA(com.tencent.mm.plugin.label.e.bKU().eB(paramArrayOfByte));
      }
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(22528);
      return;
      ab.w("MicroMsg.Label.NetSceneGetContactLabelList", "cpan[onGYNetEnd] getcontactlabellist fail.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.c
 * JD-Core Version:    0.7.0.1
 */