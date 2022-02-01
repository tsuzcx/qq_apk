package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.dvq;
import com.tencent.mm.protocal.protobuf.dvr;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n
  extends q
  implements m
{
  private i callback;
  private final d rr;
  
  public n(List<qw> paramList)
  {
    AppMethodBeat.i(5593);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dvq();
    ((d.a)localObject).iLO = new dvr();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/setapplist";
    ((d.a)localObject).funcId = 386;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (dvq)this.rr.iLK.iLR;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qw localqw = (qw)paramList.next();
      al localal = new al();
      localal.UserName = localqw.userName;
      localLinkedList.add(localal);
    }
    ((dvq)localObject).oTz = localLinkedList.size();
    ((dvq)localObject).oTA = localLinkedList;
    Log.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", new Object[] { Integer.valueOf(localLinkedList.size()), localLinkedList.toString() });
    AppMethodBeat.o(5593);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(5595);
    this.callback = parami;
    Log.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(5595);
    return i;
  }
  
  public final int getType()
  {
    return 386;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5594);
    Log.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (dvr)this.rr.iLL.iLR;
      Log.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", new Object[] { Integer.valueOf(params.LSe) });
      b.k(196610, Integer.valueOf(params.LSe));
      b.k(196611, Boolean.FALSE);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(5594);
      return;
      b.k(196611, Boolean.TRUE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.n
 * JD-Core Version:    0.7.0.1
 */