package com.tencent.mm.plugin.game.chatroom.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomRealtimeInfoRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomRealtimeInfoResponse;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.plugin.game.chatroom.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;

public final class a
  implements com.tencent.mm.am.h
{
  private com.tencent.mm.plugin.game.chatroom.b.a IkG;
  private b.c IkH;
  private g IkI;
  private boolean mIsRunning = false;
  public boolean szN = false;
  
  public a(b.c paramc, com.tencent.mm.plugin.game.chatroom.b.a parama)
  {
    this.IkH = paramc;
    this.IkG = parama;
  }
  
  /* Error */
  private void iR(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 49
    //   4: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 26	com/tencent/mm/plugin/game/chatroom/h/a:mIsRunning	Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: getfield 24	com/tencent/mm/plugin/game/chatroom/h/a:szN	Z
    //   18: ifne +42 -> 60
    //   21: ldc 51
    //   23: ldc 53
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 26	com/tencent/mm/plugin/game/chatroom/h/a:mIsRunning	Z
    //   35: invokestatic 59	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_0
    //   42: getfield 24	com/tencent/mm/plugin/game/chatroom/h/a:szN	Z
    //   45: invokestatic 59	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: aastore
    //   49: invokestatic 64	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: ldc 49
    //   54: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: ldc 51
    //   62: ldc 66
    //   64: iconst_2
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload_2
    //   75: aastore
    //   76: invokestatic 69	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: aload_0
    //   80: iconst_1
    //   81: putfield 26	com/tencent/mm/plugin/game/chatroom/h/a:mIsRunning	Z
    //   84: aload_0
    //   85: new 71	com/tencent/mm/plugin/game/chatroom/c/g
    //   88: dup
    //   89: aload_1
    //   90: aload_2
    //   91: aload_0
    //   92: invokevirtual 75	java/lang/Object:hashCode	()I
    //   95: invokespecial 78	com/tencent/mm/plugin/game/chatroom/c/g:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   98: putfield 80	com/tencent/mm/plugin/game/chatroom/h/a:IkI	Lcom/tencent/mm/plugin/game/chatroom/c/g;
    //   101: invokestatic 86	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   104: aload_0
    //   105: getfield 80	com/tencent/mm/plugin/game/chatroom/h/a:IkI	Lcom/tencent/mm/plugin/game/chatroom/c/g;
    //   108: iconst_0
    //   109: invokevirtual 91	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   112: pop
    //   113: ldc 49
    //   115: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: goto -61 -> 57
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	a
    //   0	126	1	paramString1	String
    //   0	126	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	21	121	finally
    //   21	57	121	finally
    //   60	118	121	finally
  }
  
  public final void fCJ()
  {
    try
    {
      AppMethodBeat.i(275775);
      Log.i("GameChatRoom.GetChatRoomRealtimeInfoKeepAliveService", "stopKeepAlive");
      this.szN = false;
      this.IkG = null;
      com.tencent.mm.kernel.h.aZW().b(4316, this);
      if (this.IkI != null) {
        com.tencent.mm.kernel.h.aZW().a(this.IkI);
      }
      AppMethodBeat.o(275775);
      return;
    }
    finally {}
  }
  
  public final void iQ(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(275770);
      this.szN = true;
      Log.i("GameChatRoom.GetChatRoomRealtimeInfoKeepAliveService", "startKeepAlive chatroomName：%s, version: %s", new Object[] { paramString1, paramString2 });
      com.tencent.mm.kernel.h.aZW().a(4316, this);
      iR(paramString1, paramString2);
      AppMethodBeat.o(275770);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(275788);
    final GetChatroomRealtimeInfoRequest localGetChatroomRealtimeInfoRequest;
    int i;
    if (paramp.getType() == 4316)
    {
      if (((g)paramp).DD != hashCode())
      {
        Log.i("GameChatRoom.GetChatRoomRealtimeInfoKeepAliveService", "instanceId is diff");
        AppMethodBeat.o(275788);
        return;
      }
      localGetChatroomRealtimeInfoRequest = (GetChatroomRealtimeInfoRequest)c.b.b(((g)paramp).mtC.otB);
      paramp = (GetChatroomRealtimeInfoResponse)c.c.b(((g)paramp).mtC.otC);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramp == null) || (Util.nullAsNil(localGetChatroomRealtimeInfoRequest.version).equals(paramp.next_version))) {
        break label237;
      }
      localGetChatroomRealtimeInfoRequest.version = paramp.next_version;
      if (this.IkG == null) {
        break label249;
      }
      this.IkG.a(this.IkH, paramp);
      i = 0;
    }
    for (;;)
    {
      Log.i("GameChatRoom.GetChatRoomRealtimeInfoKeepAliveService", "taskCallback, chatroom:%s, newVersion:%s, errType = %d, errCode = %d, errMsg = %s", new Object[] { localGetChatroomRealtimeInfoRequest.chatroom_name, localGetChatroomRealtimeInfoRequest.version, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = com.tencent.threadpool.h.ahAA;
      paramp = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(275756);
          a.a(a.this);
          a.a(a.this, localGetChatroomRealtimeInfoRequest.chatroom_name, localGetChatroomRealtimeInfoRequest.version);
          AppMethodBeat.o(275756);
        }
      };
      if (i != 0) {}
      for (long l = 2000L;; l = 0L)
      {
        paramString.p(paramp, l);
        AppMethodBeat.o(275788);
        return;
        label237:
        i = 1;
        break;
      }
      label249:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.a
 * JD-Core Version:    0.7.0.1
 */