package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.efr;
import com.tencent.mm.protocal.protobuf.efs;
import com.tencent.mm.protocal.protobuf.fqo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.q.a;
import org.b.d.i;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  private int oLN;
  private c rr;
  
  public m(int paramInt, String paramString)
  {
    AppMethodBeat.i(20546);
    this.oLN = 0;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new efr();
    ((c.a)localObject).otF = new efs();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
    ((c.a)localObject).funcId = 1804;
    this.rr = ((c.a)localObject).bEF();
    efr localefr = (efr)c.b.b(this.rr.otB);
    localefr.aatG = paramInt;
    localefr.aatI = paramString;
    if ((paramInt & 0x10) > 0)
    {
      a locala = new a();
      localObject = new fqo();
      if (locala.afPW == null) {
        break label185;
      }
      paramString = (String)localObject;
      if (!Util.isNullOrNil(locala.afPW.token))
      {
        ((fqo)localObject).abQw = locala.afPW.token;
        ((fqo)localObject).abQx = locala.afPW.aaTQ;
      }
    }
    label185:
    for (paramString = (String)localObject;; paramString = null)
    {
      localefr.abld = paramString;
      this.oLN = paramInt;
      AppMethodBeat.o(20546);
      return;
    }
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(20548);
    Log.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(20548);
    return i;
  }
  
  public final int getType()
  {
    return 1804;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20547);
    Log.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20547);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(20547);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelmulti.m
 * JD-Core Version:    0.7.0.1
 */