package com.tencent.mm.plugin.game.chatroom.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.LocalMyChatRoom;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.plugin.game.chatroom.c.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class b
  implements com.tencent.mm.an.i
{
  private a CuI;
  private b.a CuJ;
  private boolean mIsRunning = false;
  private boolean puH = true;
  
  public b(b.a parama, a parama1)
  {
    this.CuJ = parama;
    this.CuI = parama1;
  }
  
  public final void evE()
  {
    AppMethodBeat.i(212469);
    Log.i("GameChatRoom.GetMyChatRoomKeepAliveService", "stopKeepAlive");
    this.puH = false;
    this.CuI = null;
    com.tencent.mm.kernel.h.aGY().b(4989, this);
    AppMethodBeat.o(212469);
  }
  
  /* Error */
  public final void g(java.util.List<String> paramList, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 70
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 24	com/tencent/mm/plugin/game/chatroom/g/b:mIsRunning	Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: getfield 22	com/tencent/mm/plugin/game/chatroom/g/b:puH	Z
    //   18: ifne +42 -> 60
    //   21: ldc 50
    //   23: ldc 72
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 24	com/tencent/mm/plugin/game/chatroom/g/b:mIsRunning	Z
    //   35: invokestatic 78	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_0
    //   42: getfield 22	com/tencent/mm/plugin/game/chatroom/g/b:puH	Z
    //   45: invokestatic 78	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: aastore
    //   49: invokestatic 81	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: ldc 70
    //   54: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: iconst_1
    //   62: putfield 24	com/tencent/mm/plugin/game/chatroom/g/b:mIsRunning	Z
    //   65: new 83	com/tencent/mm/plugin/game/chatroom/c/g
    //   68: dup
    //   69: aload_1
    //   70: aload_2
    //   71: aload_3
    //   72: aload_0
    //   73: invokevirtual 87	java/lang/Object:hashCode	()I
    //   76: invokespecial 90	com/tencent/mm/plugin/game/chatroom/c/g:<init>	(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;I)V
    //   79: astore_1
    //   80: invokestatic 63	com/tencent/mm/kernel/h:aGY	()Lcom/tencent/mm/an/t;
    //   83: aload_1
    //   84: iconst_0
    //   85: invokevirtual 93	com/tencent/mm/an/t:a	(Lcom/tencent/mm/an/q;I)Z
    //   88: pop
    //   89: ldc 70
    //   91: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: goto -37 -> 57
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	b
    //   0	102	1	paramList	java.util.List<String>
    //   0	102	2	paramString1	String
    //   0	102	3	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	21	97	finally
    //   21	57	97	finally
    //   60	94	97	finally
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(212477);
    final GetMyChatroomRequest localGetMyChatroomRequest;
    int i;
    if (paramq.getType() == 4989)
    {
      if (((g)paramq).mInstanceId != hashCode())
      {
        Log.i("GameChatRoom.GetMyChatRoomKeepAliveService", "instanceId is diff");
        AppMethodBeat.o(212477);
        return;
      }
      localGetMyChatroomRequest = (GetMyChatroomRequest)d.b.b(((g)paramq).jTk.lBR);
      paramq = (GetMyChatroomResponse)d.c.b(((g)paramq).jTk.lBS);
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramq == null) || (Util.nullAsNil(localGetMyChatroomRequest.version).equals(paramq.next_version))) {
        break label309;
      }
      localGetMyChatroomRequest.version = paramq.next_version;
      if ((this.CuI == null) || (paramq.my_chatroom_info_list == null)) {
        break label321;
      }
      LocalMyChatRoom localLocalMyChatRoom = new LocalMyChatRoom();
      localLocalMyChatRoom.my_chatroom_info_list.addAll(paramq.my_chatroom_info_list);
      Log.d("GameChatRoom.GetMyChatRoomKeepAliveService", "before reorder size:%d, after reorder size:%d", new Object[] { Integer.valueOf(paramq.my_chatroom_info_list.size()), Integer.valueOf(localLocalMyChatRoom.my_chatroom_info_list.size()) });
      this.CuI.a(this.CuJ, localLocalMyChatRoom);
      i = 0;
    }
    for (;;)
    {
      Log.i("GameChatRoom.GetMyChatRoomKeepAliveService", "hashcode = %d, newVersion:%s, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(hashCode()), localGetMyChatroomRequest.version, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = com.tencent.e.h.ZvG;
      paramq = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(212032);
          b.a(b.this);
          b.a(b.this, localGetMyChatroomRequest.chatroom_name_list, localGetMyChatroomRequest.first_chatroom_name, localGetMyChatroomRequest.version);
          AppMethodBeat.o(212032);
        }
      };
      if (i != 0) {}
      for (long l = 2000L;; l = 0L)
      {
        paramString.o(paramq, l);
        AppMethodBeat.o(212477);
        return;
        label309:
        i = 1;
        break;
      }
      label321:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.g.b
 * JD-Core Version:    0.7.0.1
 */