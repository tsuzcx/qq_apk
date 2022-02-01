package com.tencent.mm.plugin.game.chatroom.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.ReceiveChatroomMsgResponse;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.plugin.game.chatroom.c.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;

public final class c
  implements com.tencent.mm.am.h
{
  private a IkG;
  private b.c IkH;
  private o IkR;
  private boolean mIsRunning = false;
  public boolean szN = false;
  
  public c(b.c paramc, a parama)
  {
    this.IkH = paramc;
    this.IkG = parama;
  }
  
  /* Error */
  private void e(String paramString1, long paramLong, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 49
    //   4: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 26	com/tencent/mm/plugin/game/chatroom/h/c:mIsRunning	Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: getfield 24	com/tencent/mm/plugin/game/chatroom/h/c:szN	Z
    //   18: ifne +42 -> 60
    //   21: ldc 51
    //   23: ldc 53
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 26	com/tencent/mm/plugin/game/chatroom/h/c:mIsRunning	Z
    //   35: invokestatic 59	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_0
    //   42: getfield 24	com/tencent/mm/plugin/game/chatroom/h/c:szN	Z
    //   45: invokestatic 59	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: aastore
    //   49: invokestatic 64	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: ldc 49
    //   54: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 26	com/tencent/mm/plugin/game/chatroom/h/c:mIsRunning	Z
    //   65: aload_0
    //   66: new 66	com/tencent/mm/plugin/game/chatroom/c/o
    //   69: dup
    //   70: aload_1
    //   71: lload_2
    //   72: aload 4
    //   74: aload_0
    //   75: invokevirtual 70	java/lang/Object:hashCode	()I
    //   78: invokespecial 73	com/tencent/mm/plugin/game/chatroom/c/o:<init>	(Ljava/lang/String;JLjava/lang/String;I)V
    //   81: putfield 75	com/tencent/mm/plugin/game/chatroom/h/c:IkR	Lcom/tencent/mm/plugin/game/chatroom/c/o;
    //   84: invokestatic 81	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   87: aload_0
    //   88: getfield 75	com/tencent/mm/plugin/game/chatroom/h/c:IkR	Lcom/tencent/mm/plugin/game/chatroom/c/o;
    //   91: iconst_0
    //   92: invokevirtual 86	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   95: pop
    //   96: ldc 49
    //   98: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: goto -44 -> 57
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	c
    //   0	109	1	paramString1	String
    //   0	109	2	paramLong	long
    //   0	109	4	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	21	104	finally
    //   21	57	104	finally
    //   60	101	104	finally
  }
  
  public final void aFB(String paramString)
  {
    try
    {
      AppMethodBeat.i(275789);
      this.szN = true;
      Log.i("GameChatRoom.ReceiveChatRoomMsgKeepAliveService", "startKeepAlive chatroomName：%s, seq: %d", new Object[] { paramString, Long.valueOf(0L) });
      com.tencent.mm.kernel.h.aZW().a(4302, this);
      e(paramString, 0L, "");
      AppMethodBeat.o(275789);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void fCJ()
  {
    try
    {
      AppMethodBeat.i(275798);
      Log.i("GameChatRoom.ReceiveChatRoomMsgKeepAliveService", "stopKeepAlive");
      this.szN = false;
      this.IkG = null;
      com.tencent.mm.kernel.h.aZW().b(4302, this);
      if (this.IkR != null) {
        com.tencent.mm.kernel.h.aZW().a(this.IkR);
      }
      AppMethodBeat.o(275798);
      return;
    }
    finally {}
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(275813);
    final ReceiveChatroomMsgRequest localReceiveChatroomMsgRequest;
    int i;
    if (paramp.getType() == 4302)
    {
      if (((o)paramp).DD != hashCode())
      {
        Log.i("GameChatRoom.ReceiveChatRoomMsgKeepAliveService", "instanceId is diff");
        AppMethodBeat.o(275813);
        return;
      }
      localReceiveChatroomMsgRequest = (ReceiveChatroomMsgRequest)c.b.b(((o)paramp).mtC.otB);
      paramp = (ReceiveChatroomMsgResponse)c.c.b(((o)paramp).mtC.otC);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramp == null)) {
        break label251;
      }
      localReceiveChatroomMsgRequest.seq = paramp.next_seq;
      localReceiveChatroomMsgRequest.version = paramp.next_version;
      if (this.IkG == null) {
        break label263;
      }
      this.IkG.a(this.IkH, paramp);
      i = 0;
    }
    for (;;)
    {
      Log.i("GameChatRoom.ReceiveChatRoomMsgKeepAliveService", "hashcode = %d, chatroom:%s, newSeq:%d, nextVersion:%s, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(hashCode()), localReceiveChatroomMsgRequest.chatroom_name, Long.valueOf(localReceiveChatroomMsgRequest.seq), localReceiveChatroomMsgRequest.version, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = com.tencent.threadpool.h.ahAA;
      paramp = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(275750);
          c.a(c.this);
          c.a(c.this, localReceiveChatroomMsgRequest.chatroom_name, localReceiveChatroomMsgRequest.seq, localReceiveChatroomMsgRequest.version);
          AppMethodBeat.o(275750);
        }
      };
      if (i != 0) {}
      for (long l = 2000L;; l = 0L)
      {
        paramString.p(paramp, l);
        AppMethodBeat.o(275813);
        return;
        label251:
        i = 1;
        break;
      }
      label263:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.c
 * JD-Core Version:    0.7.0.1
 */