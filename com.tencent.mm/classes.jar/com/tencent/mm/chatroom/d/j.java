package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.protocal.protobuf.adm;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends n
  implements k
{
  private f callback;
  public List<String> dBf;
  private b rr;
  
  public j(String paramString, List<String> paramList, int paramInt)
  {
    AppMethodBeat.i(12467);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new adc();
    ((b.a)localObject).hQG = new add();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/delchatroommember";
    ((b.a)localObject).funcId = 179;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (adc)this.rr.hQD.hQJ;
    ((adc)localObject).FNj = paramString;
    paramString = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      adm localadm = new adm();
      localadm.GuK = z.Jw(str);
      paramString.add(localadm);
    }
    ((adc)localObject).FNl = paramString;
    ((adc)localObject).fNf = paramString.size();
    ((adc)localObject).Scene = paramInt;
    this.dBf = paramList;
    AppMethodBeat.o(12467);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(12468);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(12468);
    return i;
  }
  
  public final int getType()
  {
    return 179;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12469);
    updateDispatchId(paramInt1);
    ae.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    paramq = (adc)this.rr.hQD.hQJ;
    paramArrayOfByte = (add)this.rr.hQE.hQJ;
    if (this.rr.hQE.getRetCode() != 0)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(12469);
      return;
    }
    r.a(paramq.FNj, paramArrayOfByte);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(12469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.d.j
 * JD-Core Version:    0.7.0.1
 */