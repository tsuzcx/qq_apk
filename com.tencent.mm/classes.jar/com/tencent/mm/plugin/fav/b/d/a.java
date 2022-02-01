package com.tencent.mm.plugin.fav.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private g callback;
  private b hEg;
  
  public a(ahq paramahq)
  {
    AppMethodBeat.i(101581);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ux();
    ((b.a)localObject).hvu = new uy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((b.a)localObject).funcId = 405;
    ((b.a)localObject).reqCmdId = 196;
    ((b.a)localObject).respCmdId = 1000000196;
    this.hEg = ((b.a)localObject).aAz();
    localObject = (ux)this.hEg.hvr.hvw;
    ((ux)localObject).Epc = paramahq;
    ((ux)localObject).Scene = 2;
    ac.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", new Object[] { Integer.valueOf(paramahq.DPH) });
    AppMethodBeat.o(101581);
  }
  
  public a(List<ahd> paramList)
  {
    AppMethodBeat.i(101580);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ux();
    ((b.a)localObject).hvu = new uy();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((b.a)localObject).funcId = 405;
    ((b.a)localObject).reqCmdId = 196;
    ((b.a)localObject).respCmdId = 1000000196;
    this.hEg = ((b.a)localObject).aAz();
    localObject = (ux)this.hEg.hvr.hvw;
    ((ux)localObject).Epb = new LinkedList();
    ((ux)localObject).Epb.addAll(paramList);
    ((ux)localObject).Scene = 1;
    ac.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(101580);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(101582);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(101582);
    return i;
  }
  
  public final int getType()
  {
    return 405;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101583);
    ac.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (uy)((b)paramq).hvs.hvw;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(101583);
      return;
    }
    paramq = paramq.Epd.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (uz)paramq.next();
      ac.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", new Object[] { Integer.valueOf(paramArrayOfByte.DPH), Integer.valueOf(paramArrayOfByte.Ret) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(101583);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.d.a
 * JD-Core Version:    0.7.0.1
 */