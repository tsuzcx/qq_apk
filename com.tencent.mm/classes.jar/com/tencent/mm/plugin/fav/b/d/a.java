package com.tencent.mm.plugin.fav.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.protocal.protobuf.wz;
import com.tencent.mm.protocal.protobuf.xa;
import com.tencent.mm.protocal.protobuf.xb;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private f callback;
  private b hZD;
  
  public a(akq paramakq)
  {
    AppMethodBeat.i(101581);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new wz();
    ((b.a)localObject).hQG = new xa();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((b.a)localObject).funcId = 405;
    ((b.a)localObject).hQH = 196;
    ((b.a)localObject).respCmdId = 1000000196;
    this.hZD = ((b.a)localObject).aDS();
    localObject = (wz)this.hZD.hQD.hQJ;
    ((wz)localObject).GoN = paramakq;
    ((wz)localObject).Scene = 2;
    ae.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", new Object[] { Integer.valueOf(paramakq.FNu) });
    AppMethodBeat.o(101581);
  }
  
  public a(List<akd> paramList)
  {
    AppMethodBeat.i(101580);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new wz();
    ((b.a)localObject).hQG = new xa();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((b.a)localObject).funcId = 405;
    ((b.a)localObject).hQH = 196;
    ((b.a)localObject).respCmdId = 1000000196;
    this.hZD = ((b.a)localObject).aDS();
    localObject = (wz)this.hZD.hQD.hQJ;
    ((wz)localObject).GoM = new LinkedList();
    ((wz)localObject).GoM.addAll(paramList);
    ((wz)localObject).Scene = 1;
    ae.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(101580);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(101582);
    this.callback = paramf;
    int i = dispatch(parame, this.hZD, this);
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
    ae.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (xa)((b)paramq).hQE.hQJ;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(101583);
      return;
    }
    paramq = paramq.GoO.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (xb)paramq.next();
      ae.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", new Object[] { Integer.valueOf(paramArrayOfByte.FNu), Integer.valueOf(paramArrayOfByte.Ret) });
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
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.d.a
 * JD-Core Version:    0.7.0.1
 */