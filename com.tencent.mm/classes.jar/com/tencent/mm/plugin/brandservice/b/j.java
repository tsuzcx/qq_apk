package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends m
  implements k
{
  private f callback;
  private final com.tencent.mm.ai.b rr;
  
  public j(List<me> paramList)
  {
    AppMethodBeat.i(13852);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cai();
    ((b.a)localObject).fsY = new caj();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/setapplist";
    ((b.a)localObject).funcId = 386;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cai)this.rr.fsV.fta;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      me localme = (me)paramList.next();
      ah localah = new ah();
      localah.jJA = localme.userName;
      localLinkedList.add(localah);
    }
    ((cai)localObject).jJu = localLinkedList.size();
    ((cai)localObject).jJv = localLinkedList;
    ab.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList.toString() });
    AppMethodBeat.o(13852);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(13854);
    this.callback = paramf;
    ab.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(13854);
    return i;
  }
  
  public final int getType()
  {
    return 386;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13853);
    ab.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (caj)this.rr.fsW.fta;
      ab.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[] { Integer.valueOf(paramq.wYJ) });
      com.tencent.mm.plugin.brandservice.b.i(196610, Integer.valueOf(paramq.wYJ));
      com.tencent.mm.plugin.brandservice.b.i(196611, Boolean.FALSE);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(13853);
      return;
      com.tencent.mm.plugin.brandservice.b.i(196611, Boolean.TRUE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.j
 * JD-Core Version:    0.7.0.1
 */