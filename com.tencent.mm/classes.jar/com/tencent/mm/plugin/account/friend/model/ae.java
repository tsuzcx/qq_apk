package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dct;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ae
  extends p
  implements m
{
  private h callback;
  public String pTA;
  public LinkedList<dct> pTz;
  private final c rr;
  
  public ae(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(131123);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dcu();
    ((c.a)localObject).otF = new dcv();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
    ((c.a)localObject).funcId = 489;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    this.pTz = new LinkedList();
    if (paramArrayList.size() > 0)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject = new dct();
        ((dct)localObject).YNO = ((String)paramArrayList.get(i));
        this.pTz.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(131123);
  }
  
  public final dcv bXm()
  {
    AppMethodBeat.i(304791);
    dcv localdcv = (dcv)c.c.b(this.rr.otC);
    AppMethodBeat.o(304791);
    return localdcv;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(131124);
    Log.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = paramh;
    paramh = (dcu)c.b.b(this.rr.otB);
    paramh.vgN = this.pTz.size();
    paramh.vgO = this.pTz;
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
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ae
 * JD-Core Version:    0.7.0.1
 */