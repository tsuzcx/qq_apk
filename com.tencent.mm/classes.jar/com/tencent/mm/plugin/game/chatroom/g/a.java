package com.tencent.mm.plugin.game.chatroom.g;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomRealtimeInfoRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetChatroomRealtimeInfoResponse;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.plugin.game.chatroom.c.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
  implements com.tencent.mm.an.i
{
  public com.tencent.mm.plugin.game.chatroom.b.a CuI;
  private b.a CuJ;
  private boolean mIsRunning = false;
  public boolean puH = false;
  
  public a(b.a parama, com.tencent.mm.plugin.game.chatroom.b.a parama1)
  {
    this.CuJ = parama;
    this.CuI = parama1;
  }
  
  /* Error */
  public final void hM(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 47
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 24	com/tencent/mm/plugin/game/chatroom/g/a:mIsRunning	Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: getfield 22	com/tencent/mm/plugin/game/chatroom/g/a:puH	Z
    //   18: ifne +42 -> 60
    //   21: ldc 49
    //   23: ldc 51
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 24	com/tencent/mm/plugin/game/chatroom/g/a:mIsRunning	Z
    //   35: invokestatic 57	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_0
    //   42: getfield 22	com/tencent/mm/plugin/game/chatroom/g/a:puH	Z
    //   45: invokestatic 57	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: aastore
    //   49: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: ldc 47
    //   54: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: ldc 49
    //   62: ldc 64
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
    //   76: invokestatic 67	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: aload_0
    //   80: iconst_1
    //   81: putfield 24	com/tencent/mm/plugin/game/chatroom/g/a:mIsRunning	Z
    //   84: new 69	com/tencent/mm/plugin/game/chatroom/c/e
    //   87: dup
    //   88: aload_1
    //   89: aload_2
    //   90: aload_0
    //   91: invokevirtual 73	java/lang/Object:hashCode	()I
    //   94: invokespecial 76	com/tencent/mm/plugin/game/chatroom/c/e:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   97: astore_1
    //   98: invokestatic 82	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   101: aload_1
    //   102: iconst_0
    //   103: invokevirtual 87	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;I)Z
    //   106: pop
    //   107: ldc 47
    //   109: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: goto -55 -> 57
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	a
    //   0	120	1	paramString1	String
    //   0	120	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	21	115	finally
    //   21	57	115	finally
    //   60	112	115	finally
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(211132);
    final GetChatroomRealtimeInfoRequest localGetChatroomRealtimeInfoRequest;
    int i;
    if (paramq.getType() == 4316)
    {
      if (((e)paramq).mInstanceId != hashCode())
      {
        Log.i("GameChatRoom.GetChatRoomRealtimeInfoKeepAliveService", "instanceId is diff");
        AppMethodBeat.o(211132);
        return;
      }
      localGetChatroomRealtimeInfoRequest = (GetChatroomRealtimeInfoRequest)d.b.b(((e)paramq).jTk.lBR);
      paramq = (GetChatroomRealtimeInfoResponse)d.c.b(((e)paramq).jTk.lBS);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramq == null) || (Util.nullAsNil(localGetChatroomRealtimeInfoRequest.version).equals(paramq.next_version))) {
        break label237;
      }
      localGetChatroomRealtimeInfoRequest.version = paramq.next_version;
      if (this.CuI == null) {
        break label249;
      }
      this.CuI.a(this.CuJ, paramq);
      i = 0;
    }
    for (;;)
    {
      Log.i("GameChatRoom.GetChatRoomRealtimeInfoKeepAliveService", "taskCallback, chatroom:%s, newVersion:%s, errType = %d, errCode = %d, errMsg = %s", new Object[] { localGetChatroomRealtimeInfoRequest.chatroom_name, localGetChatroomRealtimeInfoRequest.version, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = h.ZvG;
      paramq = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(211952);
          a.a(a.this);
          a.a(a.this, localGetChatroomRealtimeInfoRequest.chatroom_name, localGetChatroomRealtimeInfoRequest.version);
          AppMethodBeat.o(211952);
        }
      };
      if (i != 0) {}
      for (long l = 2000L;; l = 0L)
      {
        paramString.o(paramq, l);
        AppMethodBeat.o(211132);
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
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.g.a
 * JD-Core Version:    0.7.0.1
 */