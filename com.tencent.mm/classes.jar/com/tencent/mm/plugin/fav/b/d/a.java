package com.tencent.mm.plugin.fav.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.yj;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.protocal.protobuf.yl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends q
  implements m
{
  private i callback;
  private d iUB;
  
  public a(ane paramane)
  {
    AppMethodBeat.i(101581);
    this.callback = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new yj();
    ((d.a)localObject).iLO = new yk();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((d.a)localObject).funcId = 405;
    ((d.a)localObject).iLP = 196;
    ((d.a)localObject).respCmdId = 1000000196;
    this.iUB = ((d.a)localObject).aXF();
    localObject = (yj)this.iUB.iLK.iLR;
    ((yj)localObject).Ljy = paramane;
    ((yj)localObject).Scene = 2;
    Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", new Object[] { Integer.valueOf(paramane.KGZ) });
    AppMethodBeat.o(101581);
  }
  
  public a(List<amr> paramList)
  {
    AppMethodBeat.i(101580);
    this.callback = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new yj();
    ((d.a)localObject).iLO = new yk();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((d.a)localObject).funcId = 405;
    ((d.a)localObject).iLP = 196;
    ((d.a)localObject).respCmdId = 1000000196;
    this.iUB = ((d.a)localObject).aXF();
    localObject = (yj)this.iUB.iLK.iLR;
    ((yj)localObject).Ljx = new LinkedList();
    ((yj)localObject).Ljx.addAll(paramList);
    ((yj)localObject).Scene = 1;
    Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(101580);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(101582);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(101582);
    return i;
  }
  
  public final int getType()
  {
    return 405;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(101583);
    Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (yk)((d)params).iLL.iLR;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(101583);
      return;
    }
    params = params.Ljz.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (yl)params.next();
      Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", new Object[] { Integer.valueOf(paramArrayOfByte.KGZ), Integer.valueOf(paramArrayOfByte.Ret) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(101583);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.d.a
 * JD-Core Version:    0.7.0.1
 */