package com.tencent.mm.plugin.brandservice.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ai.z;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bxm;
import com.tencent.mm.protocal.c.bxn;
import com.tencent.mm.protocal.c.ds;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.protocal.c.ik;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.r;
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
  private final b dmK;
  private f dmL;
  
  public l(LinkedList<ik> paramLinkedList)
  {
    b.a locala = new b.a();
    locala.ecH = new bxm();
    locala.ecI = new bxn();
    locala.uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_comment_reward_stat";
    locala.ecG = 2571;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bxm)this.dmK.ecE.ecN).tNC = paramLinkedList;
    y.d("MicroMsg.NetSceneTimelineGetCommentReward", "NetSceneTimelineGetCommentReward %d", new Object[] { Integer.valueOf(paramLinkedList.size()) });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    y.d("MicroMsg.NetSceneTimelineGetCommentReward", "do scene");
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneTimelineGetCommentReward", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramString = (bxn)this.dmK.ecF.ecN;
      if (paramString != null)
      {
        paramq = new HashMap();
        if (!bk.dk(paramString.sxo))
        {
          paramArrayOfByte = paramString.sxo.iterator();
          Object localObject1;
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (ds)paramArrayOfByte.next();
            y.d("MicroMsg.NetSceneTimelineGetCommentReward", "client_msg_id=%d, fans_read_cnt=%d", new Object[] { Long.valueOf(((ds)localObject1).sxm), Integer.valueOf(((ds)localObject1).sxn) });
            if ((((ds)localObject1).sxm > 0L) && (((ds)localObject1).sxn > 0))
            {
              if (!paramq.containsKey(Long.valueOf(((ds)localObject1).sxm))) {
                paramq.put(Long.valueOf(((ds)localObject1).sxm), new dt());
              }
              ((dt)paramq.get(Long.valueOf(((ds)localObject1).sxm))).sxo.add(localObject1);
            }
          }
          paramq = paramq.entrySet().iterator();
          paramArrayOfByte = new LinkedList();
          while (paramq.hasNext())
          {
            Object localObject2 = (Map.Entry)paramq.next();
            localObject1 = (dt)((Map.Entry)localObject2).getValue();
            localObject2 = z.ME().D(((Long)((Map.Entry)localObject2).getKey()).longValue(), "msgId");
            if (localObject2 != null)
            {
              ((com.tencent.mm.storage.q)localObject2).field_appMsgStatInfoProto = ((dt)localObject1);
              paramArrayOfByte.add(localObject2);
            }
          }
          z.ME().h(paramArrayOfByte, true);
        }
        if (paramString.tND > 0) {
          com.tencent.mm.plugin.brandservice.ui.b.a.iiR = paramString.tND;
        }
      }
    }
  }
  
  public final int getType()
  {
    return 2571;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.l
 * JD-Core Version:    0.7.0.1
 */