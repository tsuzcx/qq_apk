package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ayf;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class s
  extends n
  implements k
{
  private f callback;
  Object data;
  Map<String, String> hVp;
  public b rr;
  
  public s(LinkedList<pu> paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(124310);
    this.hVp = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (pu)((Iterator)localObject1).next();
      Object localObject3 = ((pu)localObject2).Gdt;
      localObject2 = ((pu)localObject2).FZx;
      if ((localObject2 != null) && (localObject3 != null) && (((LinkedList)localObject3).size() > 0))
      {
        localObject3 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          this.hVp.put(str, localObject2);
        }
      }
    }
    localObject1 = new b.a();
    ((b.a)localObject1).hQF = new ayf();
    ((b.a)localObject1).hQG = new ayg();
    ((b.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
    ((b.a)localObject1).funcId = 1353;
    ((b.a)localObject1).hQH = 0;
    ((b.a)localObject1).respCmdId = 0;
    this.rr = ((b.a)localObject1).aDS();
    ((ayf)this.rr.hQD.hQJ).GPc = paramLinkedList;
    this.data = paramObject;
    AppMethodBeat.o(124310);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(124312);
    this.callback = paramf;
    ae.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(124312);
    return i;
  }
  
  public final int getType()
  {
    return 1353;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124311);
    ae.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.al.a.s
 * JD-Core Version:    0.7.0.1
 */