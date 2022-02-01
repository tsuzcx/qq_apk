package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class s
  extends q
  implements m
{
  private i callback;
  Object data;
  Map<String, String> iQC;
  public d rr;
  
  public s(LinkedList<qv> paramLinkedList, Object paramObject)
  {
    AppMethodBeat.i(124310);
    this.iQC = new HashMap();
    Object localObject1 = paramLinkedList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (qv)((Iterator)localObject1).next();
      Object localObject3 = ((qv)localObject2).KXK;
      localObject2 = ((qv)localObject2).KTt;
      if ((localObject2 != null) && (localObject3 != null) && (((LinkedList)localObject3).size() > 0))
      {
        localObject3 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          this.iQC.put(str, localObject2);
        }
      }
    }
    localObject1 = new d.a();
    ((d.a)localObject1).iLN = new bjp();
    ((d.a)localObject1).iLO = new bjq();
    ((d.a)localObject1).uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
    ((d.a)localObject1).funcId = 1353;
    ((d.a)localObject1).iLP = 0;
    ((d.a)localObject1).respCmdId = 0;
    this.rr = ((d.a)localObject1).aXF();
    ((bjp)this.rr.iLK.iLR).LTi = paramLinkedList;
    this.data = paramObject;
    AppMethodBeat.o(124310);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(124312);
    this.callback = parami;
    Log.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124312);
    return i;
  }
  
  public final int getType()
  {
    return 1353;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124311);
    Log.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.s
 * JD-Core Version:    0.7.0.1
 */