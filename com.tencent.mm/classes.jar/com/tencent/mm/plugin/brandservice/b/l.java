package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.bv.a;
import com.tencent.mm.cm.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.protocal.protobuf.cka;
import com.tencent.mm.protocal.protobuf.ckb;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.2;
import com.tencent.mm.storage.r.3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class l
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private final b rr;
  
  public l(LinkedList<kd> paramLinkedList)
  {
    AppMethodBeat.i(13858);
    b.a locala = new b.a();
    locala.fsX = new cka();
    locala.fsY = new ckb();
    locala.uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_comment_reward_stat";
    locala.funcId = 2571;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    ((cka)this.rr.fsV.fta).xUd = paramLinkedList;
    ab.d("MicroMsg.NetSceneTimelineGetCommentReward", "NetSceneTimelineGetCommentReward %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
    AppMethodBeat.o(13858);
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(13860);
    this.callback = paramf;
    ab.d("MicroMsg.NetSceneTimelineGetCommentReward", "do scene");
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(13860);
    return i;
  }
  
  public final int getType()
  {
    return 2571;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(13859);
    ab.i("MicroMsg.NetSceneTimelineGetCommentReward", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = (ckb)this.rr.fsW.fta;
      if (paramString != null)
      {
        paramq = new HashMap();
        if (!bo.es(paramString.wqW))
        {
          paramArrayOfByte = paramString.wqW.iterator();
          Object localObject1;
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (et)paramArrayOfByte.next();
            ab.d("MicroMsg.NetSceneTimelineGetCommentReward", "client_msg_id=%d, fans_read_cnt=%d", new Object[] { Long.valueOf(((et)localObject1).wqU), Integer.valueOf(((et)localObject1).wqV) });
            if ((((et)localObject1).wqU > 0L) && (((et)localObject1).wqV > 0))
            {
              if (!paramq.containsKey(Long.valueOf(((et)localObject1).wqU))) {
                paramq.put(Long.valueOf(((et)localObject1).wqU), new eu());
              }
              ((eu)paramq.get(Long.valueOf(((et)localObject1).wqU))).wqW.add(localObject1);
            }
          }
          paramArrayOfByte = paramq.entrySet().iterator();
          paramq = new LinkedList();
          while (paramArrayOfByte.hasNext())
          {
            Object localObject2 = (Map.Entry)paramArrayOfByte.next();
            localObject1 = (eu)((Map.Entry)localObject2).getValue();
            localObject2 = z.afo().C(((Long)((Map.Entry)localObject2).getKey()).longValue(), "msgId");
            if ((localObject2 != null) && (!c.b(((com.tencent.mm.storage.q)localObject2).field_appMsgStatInfoProto, (a)localObject1)))
            {
              ((com.tencent.mm.storage.q)localObject2).field_appMsgStatInfoProto = ((eu)localObject1);
              paramq.add(localObject2);
            }
          }
          paramArrayOfByte = z.afo();
          if (!bo.es(paramq)) {
            g.dTg().h(new r.3(paramArrayOfByte, paramq)).b(new r.2(paramArrayOfByte, paramq));
          }
        }
        if (paramString.xUe > 0) {
          com.tencent.mm.plugin.brandservice.ui.b.a.kiQ = paramString.xUe;
        }
      }
    }
    AppMethodBeat.o(13859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.l
 * JD-Core Version:    0.7.0.1
 */