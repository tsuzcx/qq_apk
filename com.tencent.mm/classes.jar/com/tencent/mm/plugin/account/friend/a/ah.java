package com.tencent.mm.plugin.account.friend.a;

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
import com.tencent.mm.protocal.protobuf.cdn;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ah
  extends q
  implements m
{
  private i callback;
  private LinkedList<cdn> kft;
  public String kfu;
  private final d rr;
  
  public ah(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(131123);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new cdo();
    ((d.a)localObject).iLO = new cdp();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
    ((d.a)localObject).funcId = 489;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    this.kft = new LinkedList();
    if (paramArrayList.size() > 0)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject = new cdn();
        ((cdn)localObject).KPA = ((String)paramArrayList.get(i));
        this.kft.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(131123);
  }
  
  public final cdp bop()
  {
    return (cdp)this.rr.iLL.iLR;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(131124);
    Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = parami;
    parami = (cdo)this.rr.iLK.iLR;
    parami.oTz = this.kft.size();
    parami.oTA = this.kft;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131124);
    return i;
  }
  
  public final int getType()
  {
    return 489;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131125);
    Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131125);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ah
 * JD-Core Version:    0.7.0.1
 */