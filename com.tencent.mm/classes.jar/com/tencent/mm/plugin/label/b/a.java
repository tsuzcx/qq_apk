package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.protocal.protobuf.azf;
import com.tencent.mm.protocal.protobuf.cc;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends m
  implements k
{
  private f callback;
  private LinkedList<azf> nXX;
  private final b rr;
  
  public a(String paramString)
  {
    AppMethodBeat.i(22520);
    this.nXX = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cc();
    ((b.a)localObject).fsY = new cd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).funcId = 635;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    if (!bo.isNullOrNil(paramString))
    {
      localObject = new azf();
      ((azf)localObject).xoB = paramString;
      this.nXX.add(localObject);
    }
    AppMethodBeat.o(22520);
  }
  
  public a(List<String> paramList)
  {
    AppMethodBeat.i(22521);
    this.nXX = new LinkedList();
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cc();
    ((b.a)localObject).fsY = new cd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addcontactlabel";
    ((b.a)localObject).funcId = 635;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        localObject = new azf();
        ((azf)localObject).xoB = ((String)paramList.get(i));
        this.nXX.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(22521);
  }
  
  public final cd bKW()
  {
    return (cd)this.rr.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(22522);
    ab.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
    this.callback = paramf;
    cc localcc = (cc)this.rr.fsV.fta;
    if ((this.nXX != null) && (this.nXX.size() > 0))
    {
      localcc.woA = this.nXX;
      localcc.woz = this.nXX.size();
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(22522);
      return i;
    }
    ab.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
    paramf.onSceneEnd(3, -1, "[doScene]empty contact list.", this);
    AppMethodBeat.o(22522);
    return 0;
  }
  
  public final int getType()
  {
    return 635;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22523);
    ab.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = bKW();
    if (paramq != null)
    {
      paramq = paramq.woA;
      paramArrayOfByte = new ArrayList();
      int i = paramq.size();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        azf localazf = (azf)paramq.get(paramInt1);
        af localaf = new af();
        localaf.field_labelID = localazf.xoC;
        localaf.field_labelName = localazf.xoB;
        localaf.field_labelPYFull = g.wq(localazf.xoB);
        localaf.field_labelPYShort = g.wr(localazf.xoB);
        localaf.field_isTemporary = false;
        paramArrayOfByte.add(localaf);
        paramInt1 += 1;
      }
      com.tencent.mm.plugin.label.e.bKU().ey(paramArrayOfByte);
      com.tencent.mm.plugin.label.e.bKU().ez(paramArrayOfByte);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(22523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.a
 * JD-Core Version:    0.7.0.1
 */