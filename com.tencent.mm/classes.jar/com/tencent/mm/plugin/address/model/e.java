package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.cqq;
import com.tencent.mm.protocal.protobuf.cqs;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private f callback;
  public boolean jrI;
  public String nickname;
  private b rr;
  public String username;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20777);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new cqs();
    ((b.a)localObject).hNN = new cqt();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
    ((b.a)localObject).funcId = 417;
    ((b.a)localObject).hNO = 202;
    ((b.a)localObject).respCmdId = 1000000202;
    this.rr = ((b.a)localObject).aDC();
    localObject = (cqs)this.rr.hNK.hNQ;
    ((cqs)localObject).paX = 0;
    ((cqs)localObject).Hjr = paramString1;
    ((cqs)localObject).duW = paramString2;
    ((cqs)localObject).scene = paramInt;
    AppMethodBeat.o(20777);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(20779);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20779);
    return i;
  }
  
  public final int getType()
  {
    return 417;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(20778);
    ad.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (cqt)((b)paramq).hNL.hNQ;
      this.username = paramq.qmb;
      this.nickname = paramq.Hju;
      if (paramq.Hjt != 1) {
        break label198;
      }
    }
    for (;;)
    {
      this.jrI = bool;
      if (paramq.Hje.Hjh != null)
      {
        ad.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.Hje.Hjh.size());
        a.aUR();
        a.aUT().t(paramq.Hje.Hjh);
        a.aUR();
        a.aUT().aUV();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20778);
      return;
      label198:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.e
 * JD-Core Version:    0.7.0.1
 */