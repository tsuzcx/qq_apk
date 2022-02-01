package com.tencent.mm.plugin.fav.model.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends p
  implements m
{
  private h callback;
  private c oDw;
  
  public a(ary paramary)
  {
    AppMethodBeat.i(101581);
    this.callback = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aam();
    ((c.a)localObject).otF = new aan();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((c.a)localObject).funcId = 405;
    ((c.a)localObject).otG = 196;
    ((c.a)localObject).respCmdId = 1000000196;
    this.oDw = ((c.a)localObject).bEF();
    localObject = (aam)c.b.b(this.oDw.otB);
    ((aam)localObject).ZiZ = paramary;
    ((aam)localObject).IJG = 2;
    Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", new Object[] { Integer.valueOf(paramary.YFt) });
    AppMethodBeat.o(101581);
  }
  
  public a(List<arl> paramList)
  {
    AppMethodBeat.i(101580);
    this.callback = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new aam();
    ((c.a)localObject).otF = new aan();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/checkfavitem";
    ((c.a)localObject).funcId = 405;
    ((c.a)localObject).otG = 196;
    ((c.a)localObject).respCmdId = 1000000196;
    this.oDw = ((c.a)localObject).bEF();
    localObject = (aam)c.b.b(this.oDw.otB);
    ((aam)localObject).ZiY = new LinkedList();
    ((aam)localObject).ZiY.addAll(paramList);
    ((aam)localObject).IJG = 1;
    Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", new Object[] { Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(101580);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(101582);
    this.callback = paramh;
    int i = dispatch(paramg, this.oDw, this);
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
    params = (aan)c.c.b(((c)params).otC);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(101583);
      return;
    }
    params = params.Zja.iterator();
    while (params.hasNext())
    {
      paramArrayOfByte = (aao)params.next();
      Log.i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", new Object[] { Integer.valueOf(paramArrayOfByte.YFt), Integer.valueOf(paramArrayOfByte.Idd) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(101583);
  }
  
  public final int securityLimitCount()
  {
    return 10;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.model.c.a
 * JD-Core Version:    0.7.0.1
 */