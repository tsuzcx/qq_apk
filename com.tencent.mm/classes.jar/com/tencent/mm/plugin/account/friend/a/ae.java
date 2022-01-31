package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.awu;
import com.tencent.mm.protocal.protobuf.awv;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ae
  extends m
  implements k
{
  private f callback;
  private LinkedList<awt> gyi;
  public String gyj;
  private final b rr;
  
  public ae(ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(108462);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new awu();
    ((b.a)localObject).fsY = new awv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
    ((b.a)localObject).funcId = 489;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    this.gyi = new LinkedList();
    if (paramArrayList.size() > 0)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject = new awt();
        ((awt)localObject).wvt = ((String)paramArrayList.get(i));
        this.gyi.add(localObject);
        i += 1;
      }
    }
    AppMethodBeat.o(108462);
  }
  
  public final awv aqF()
  {
    return (awv)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108463);
    ab.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.callback = paramf;
    paramf = (awu)this.rr.fsV.fta;
    paramf.jJu = this.gyi.size();
    paramf.jJv = this.gyi;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108463);
    return i;
  }
  
  public final int getType()
  {
    return 489;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108464);
    ab.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108464);
      return;
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ae
 * JD-Core Version:    0.7.0.1
 */