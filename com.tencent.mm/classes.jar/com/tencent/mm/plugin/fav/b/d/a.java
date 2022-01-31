package com.tencent.mm.plugin.fav.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.protocal.protobuf.rw;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends m
  implements k
{
  private f callback;
  private b fBd;
  
  public a(act paramact)
  {
    AppMethodBeat.i(5322);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new rv();
    ((b.a)localObject).fsY = new rw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((b.a)localObject).funcId = 405;
    ((b.a)localObject).reqCmdId = 196;
    ((b.a)localObject).respCmdId = 1000000196;
    this.fBd = ((b.a)localObject).ado();
    localObject = (rv)this.fBd.fsV.fta;
    ((rv)localObject).wKg = paramact;
    ((rv)localObject).Scene = 2;
    ab.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", new Object[] { Integer.valueOf(paramact.woD) });
    AppMethodBeat.o(5322);
  }
  
  public a(List<acg> paramList)
  {
    AppMethodBeat.i(5321);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new rv();
    ((b.a)localObject).fsY = new rw();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((b.a)localObject).funcId = 405;
    ((b.a)localObject).reqCmdId = 196;
    ((b.a)localObject).respCmdId = 1000000196;
    this.fBd = ((b.a)localObject).ado();
    localObject = (rv)this.fBd.fsV.fta;
    ((rv)localObject).wKf = new LinkedList();
    ((rv)localObject).wKf.addAll(paramList);
    ((rv)localObject).Scene = 1;
    ab.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(5321);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(5323);
    this.callback = paramf;
    int i = dispatch(parame, this.fBd, this);
    AppMethodBeat.o(5323);
    return i;
  }
  
  public final int getType()
  {
    return 405;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(5324);
    ab.i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (rw)((b)paramq).fsW.fta;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(5324);
      return;
    }
    paramq = paramq.wKh.iterator();
    while (paramq.hasNext())
    {
      paramArrayOfByte = (rx)paramq.next();
      ab.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", new Object[] { Integer.valueOf(paramArrayOfByte.woD), Integer.valueOf(paramArrayOfByte.Ret) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(5324);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.d.a
 * JD-Core Version:    0.7.0.1
 */