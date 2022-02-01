package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ah
  extends n
  implements k
{
  private f callback;
  private LinkedList<bqa> jew;
  public String jex;
  private final b rr;
  
  public ah(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(131123);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bqb();
    ((b.a)localObject).hNN = new bqc();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
    ((b.a)localObject).funcId = 489;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    this.jew = new LinkedList();
    if (paramArrayList.size() > 0)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject = new bqa();
        ((bqa)localObject).FDu = ((String)paramArrayList.get(i));
        this.jew.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(131123);
  }
  
  public final bqc aTe()
  {
    return (bqc)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(131124);
    ad.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = paramf;
    paramf = (bqb)this.rr.hNK.hNQ;
    paramf.nDi = this.jew.size();
    paramf.nDj = this.jew;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131124);
    return i;
  }
  
  public final int getType()
  {
    return 489;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131125);
    ad.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
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