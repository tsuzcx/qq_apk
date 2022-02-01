package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.protocal.protobuf.evy;
import com.tencent.mm.protocal.protobuf.evz;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends p
  implements m
{
  private h callback;
  private String psB;
  public evx psC;
  public String psD;
  private final c rr;
  
  public q(String paramString)
  {
    AppMethodBeat.i(151215);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new evy();
    ((c.a)localObject).otF = new evz();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    ((c.a)localObject).funcId = 372;
    this.rr = ((c.a)localObject).bEF();
    Log.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { this.psB });
    localObject = (evy)c.b.b(this.rr.otB);
    ((evy)localObject).abyA = "";
    ((evy)localObject).hRk = paramString;
    ((evy)localObject).abyB = 1;
    AppMethodBeat.o(151215);
  }
  
  public q(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(235851);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new evy();
    ((c.a)localObject).otF = new evz();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/searchopenimcontact";
    ((c.a)localObject).funcId = 372;
    this.rr = ((c.a)localObject).bEF();
    Log.i("MicroMsg.NetSceneSearchOpenIMContact", "search tpQrcode [%s]", new Object[] { paramString });
    localObject = (evy)c.b.b(this.rr.otB);
    if (paramBoolean)
    {
      ((evy)localObject).abyC = paramString;
      AppMethodBeat.o(235851);
      return;
    }
    this.psB = paramString;
    ((evy)localObject).abyA = paramString;
    AppMethodBeat.o(235851);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151217);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151217);
    return i;
  }
  
  public final int getType()
  {
    return 372;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151218);
    Log.i("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == -2034)) {
        this.psD = ((evz)c.c.b(this.rr.otC)).url;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(151218);
      return;
    }
    this.psC = ((evz)c.c.b(this.rr.otC)).abyD;
    params = new j();
    params.username = this.psC.UserName;
    params.osN = this.psC.ZhO;
    params.osM = this.psC.ZhP;
    params.eQp = -1;
    Log.d("MicroMsg.NetSceneSearchOpenIMContact", "onGYNetEnd search setImageFlag %s b[%s] s[%s]", new Object[] { params.getUsername(), params.bFw(), params.bFx() });
    params.jZY = 3;
    params.gX(true);
    com.tencent.mm.modelavatar.q.bFE().b(params);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(151218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.q
 * JD-Core Version:    0.7.0.1
 */