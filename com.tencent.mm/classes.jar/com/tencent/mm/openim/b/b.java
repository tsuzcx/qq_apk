package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.dc;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
  extends n
  implements k
{
  private f callback;
  public String iHA;
  private final com.tencent.mm.al.b rr;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151180);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new db();
    ((b.a)localObject).hNN = new dc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimcontact";
    ((b.a)localObject).funcId = 667;
    this.rr = ((b.a)localObject).aDC();
    this.iHA = paramString1;
    localObject = (db)this.rr.hNK.hNQ;
    ((db)localObject).iHA = paramString1;
    ((db)localObject).Fvw = paramString2;
    ad.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "tp_username: %s, antispam_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(151180);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(151182);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(151182);
    return i;
  }
  
  public final int getType()
  {
    return 667;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151181);
    ad.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.iHA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.b
 * JD-Core Version:    0.7.0.1
 */