package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.a.hl.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.w;
import java.util.LinkedList;

final class c$1
  extends com.tencent.mm.sdk.b.c<hl>
{
  c$1(c paramc)
  {
    AppMethodBeat.i(16456);
    this.__eventId = hl.class.getName().hashCode();
    AppMethodBeat.o(16456);
  }
  
  private static boolean a(hl paramhl)
  {
    AppMethodBeat.i(16457);
    long l2 = System.currentTimeMillis();
    for (;;)
    {
      bi localbi;
      try
      {
        Object localObject1 = ((j)g.E(j.class)).bPL();
        if (!((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).SW(paramhl.cwx.username))
        {
          localObject2 = new w();
          ((w)localObject2).field_username = paramhl.cwx.username;
          if (paramhl.cwx.cwy <= paramhl.cwx.cwA)
          {
            l1 = paramhl.cwx.cwA;
            ((w)localObject2).field_lastPushSeq = l1;
            ((w)localObject2).field_lastLocalSeq = paramhl.cwx.cwA;
            ((w)localObject2).field_lastPushCreateTime = paramhl.cwx.cwz;
            ((w)localObject2).field_lastLocalCreateTime = paramhl.cwx.cwB;
            l1 = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).a((w)localObject2, true);
            localObject1 = com.tencent.mm.ui.chatting.j.b.zPL;
            com.tencent.mm.ui.chatting.j.b.dLc();
            ab.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] ret:%s,chatRoomId:%s lastPushSeq:%s lastPushCreateTime:%s lastLocalSeq:%s lastLocalCreateTime:%s", new Object[] { Long.valueOf(l1), paramhl.cwx.username, Long.valueOf(paramhl.cwx.cwy), Long.valueOf(paramhl.cwx.cwz), Long.valueOf(paramhl.cwx.cwA), Long.valueOf(paramhl.cwx.cwB) });
            return true;
          }
          l1 = paramhl.cwx.cwy;
          continue;
        }
        Object localObject2 = paramhl.cwx.username;
        localbi = ((j)g.E(j.class)).bPQ().Tn((String)localObject2);
        l1 = paramhl.cwx.cwy;
        long l3 = paramhl.cwx.cwz;
        paramhl = ((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).SY((String)localObject2);
        long l4 = paramhl.field_lastLocalSeq;
        long l5 = paramhl.field_lastLocalCreateTime;
        long l6 = paramhl.field_lastPushSeq;
        long l7 = paramhl.field_lastPushCreateTime;
        ab.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] isGetChatroom! %s conPushSeq:%s conPushCreateTime:%s localSeq:%s localCreateTime:%s pushSeq:%s pushCreateTime:%s", new Object[] { localObject2, Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7) });
        if ((localbi != null) && (localbi.field_msgId != 0L))
        {
          long l8 = localbi.field_msgSeq;
          if (l8 > l4)
          {
            paramhl.field_lastLocalSeq = l8;
            paramhl.field_lastLocalCreateTime = localbi.field_createTime;
            com.tencent.mm.j.a.a.c localc = new com.tencent.mm.j.a.a.c();
            localc.elA = (1L + l4);
            localc.elC = (l5 + 1L);
            localc.elB = (l8 - 1L);
            localc.elD = (l7 - 1L);
            if (paramhl.field_seqBlockInfo == null) {
              paramhl.field_seqBlockInfo = new d();
            }
            paramhl.field_seqBlockInfo.elE.addLast(localc);
            ab.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage local seq is smaller than MsgInfoStg local seq! ret:[%s]", new Object[] { Long.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).b(paramhl)) });
          }
          if (l6 < l1) {
            ab.i("MicroMsg.GetChatroomMsgReceiver", "[GetChatRoomWrapEvent#callback] fix chatroomMsgSeqStorage push seq is smaller than conversation seq! ret:[%s,%s] [%s,%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).Y((String)localObject2, l1)), Boolean.valueOf(((com.tencent.mm.plugin.messenger.foundation.a.a.b)localObject1).aa((String)localObject2, l3)), Long.valueOf(localbi.field_msgSeq), Long.valueOf(l4) });
          }
          return true;
        }
        if (localbi == null)
        {
          bool = true;
          if (localbi != null) {
            break label747;
          }
          l1 = -1L;
          ab.w("MicroMsg.GetChatroomMsgReceiver", "lastMsgInfo is null? %s lastMsgInfo id:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
          continue;
        }
        boolean bool = false;
      }
      finally
      {
        ab.i("MicroMsg.GetChatroomMsgReceiver", "handle GetChatRoomWrapEvent cost:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
        AppMethodBeat.o(16457);
      }
      continue;
      label747:
      long l1 = localbi.field_msgId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.aq.c.1
 * JD-Core Version:    0.7.0.1
 */