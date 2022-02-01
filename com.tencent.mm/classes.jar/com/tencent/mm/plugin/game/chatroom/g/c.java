package com.tencent.mm.plugin.game.chatroom.g;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgResponse;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.plugin.game.chatroom.c.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
  implements com.tencent.mm.an.i
{
  public a CuI;
  private b.a CuJ;
  private boolean mIsRunning = false;
  public boolean puH = false;
  
  public c(b.a parama, a parama1)
  {
    this.CuJ = parama;
    this.CuI = parama1;
  }
  
  /* Error */
  public final void ay(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 47
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 24	com/tencent/mm/plugin/game/chatroom/g/c:mIsRunning	Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: getfield 22	com/tencent/mm/plugin/game/chatroom/g/c:puH	Z
    //   18: ifne +42 -> 60
    //   21: ldc 49
    //   23: ldc 51
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 24	com/tencent/mm/plugin/game/chatroom/g/c:mIsRunning	Z
    //   35: invokestatic 57	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_0
    //   42: getfield 22	com/tencent/mm/plugin/game/chatroom/g/c:puH	Z
    //   45: invokestatic 57	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: aastore
    //   49: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: ldc 47
    //   54: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 24	com/tencent/mm/plugin/game/chatroom/g/c:mIsRunning	Z
    //   65: new 64	com/tencent/mm/plugin/game/chatroom/c/l
    //   68: dup
    //   69: aload_1
    //   70: lload_2
    //   71: aload_0
    //   72: invokevirtual 68	java/lang/Object:hashCode	()I
    //   75: invokespecial 71	com/tencent/mm/plugin/game/chatroom/c/l:<init>	(Ljava/lang/String;JI)V
    //   78: astore_1
    //   79: invokestatic 77	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   82: aload_1
    //   83: iconst_0
    //   84: invokevirtual 82	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;I)Z
    //   87: pop
    //   88: ldc 47
    //   90: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: goto -36 -> 57
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	c
    //   0	101	1	paramString	String
    //   0	101	2	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   2	21	96	finally
    //   21	57	96	finally
    //   60	93	96	finally
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(210691);
    final ReceiveChatroomMsgRequest localReceiveChatroomMsgRequest;
    int i;
    if (paramq.getType() == 4302)
    {
      if (((l)paramq).mInstanceId != hashCode())
      {
        Log.i("GameChatRoom.ReceiveChatRoomMsgKeepAliveService", "instanceId is diff");
        AppMethodBeat.o(210691);
        return;
      }
      localReceiveChatroomMsgRequest = (ReceiveChatroomMsgRequest)d.b.b(((l)paramq).jTk.lBR);
      paramq = (ReceiveChatroomMsgResponse)d.c.b(((l)paramq).jTk.lBS);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramq == null)) {
        break label232;
      }
      localReceiveChatroomMsgRequest.seq = paramq.next_seq;
      if (this.CuI == null) {
        break label244;
      }
      this.CuI.a(this.CuJ, paramq);
      i = 0;
    }
    for (;;)
    {
      Log.i("GameChatRoom.ReceiveChatRoomMsgKeepAliveService", "hashcode = %d, chatroom:%s, newSeq:%d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(hashCode()), localReceiveChatroomMsgRequest.chatroom_name, Long.valueOf(localReceiveChatroomMsgRequest.seq), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = h.ZvG;
      paramq = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(210925);
          c.a(c.this);
          c.a(c.this, localReceiveChatroomMsgRequest.chatroom_name, localReceiveChatroomMsgRequest.seq);
          AppMethodBeat.o(210925);
        }
      };
      if (i != 0) {}
      for (long l = 2000L;; l = 0L)
      {
        paramString.o(paramq, l);
        AppMethodBeat.o(210691);
        return;
        label232:
        i = 1;
        break;
      }
      label244:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.g.c
 * JD-Core Version:    0.7.0.1
 */