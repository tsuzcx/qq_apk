package com.tencent.mm.plugin.fav.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.age;
import com.tencent.mm.protocal.protobuf.agr;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends n
  implements k
{
  private g callback;
  private b hdD;
  
  public a(agr paramagr)
  {
    AppMethodBeat.i(101581);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new un();
    ((b.a)localObject).gUV = new uo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((b.a)localObject).funcId = 405;
    ((b.a)localObject).reqCmdId = 196;
    ((b.a)localObject).respCmdId = 1000000196;
    this.hdD = ((b.a)localObject).atI();
    localObject = (un)this.hdD.gUS.gUX;
    ((un)localObject).CWt = paramagr;
    ((un)localObject).Scene = 2;
    ad.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", new Object[] { Integer.valueOf(paramagr.Cxl) });
    AppMethodBeat.o(101581);
  }
  
  public a(List<age> paramList)
  {
    AppMethodBeat.i(101580);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new un();
    ((b.a)localObject).gUV = new uo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((b.a)localObject).funcId = 405;
    ((b.a)localObject).reqCmdId = 196;
    ((b.a)localObject).respCmdId = 1000000196;
    this.hdD = ((b.a)localObject).atI();
    localObject = (un)this.hdD.gUS.gUX;
    ((un)localObject).CWs = new LinkedList();
    ((un)localObject).CWs.addAll(paramList);
    ((un)localObject).Scene = 1;
    ad.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(101580);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(101582);
    this.callback = paramg;
    int i = dispatch(parame, this.hdD, this);
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
    ad.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (uo)((b)paramq).gUT.gUX;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(101583);
      return;
    }
    paramq = paramq.CWu.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (up)paramq.next();
      ad.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", new Object[] { Integer.valueOf(paramArrayOfByte.Cxl), Integer.valueOf(paramArrayOfByte.Ret) });
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
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.d.a
 * JD-Core Version:    0.7.0.1
 */