package com.tencent.mm.plugin.game.chatroom.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomRequest;
import com.tencent.mm.plugin.game.autogen.chatroom.GetMyChatroomResponse;
import com.tencent.mm.plugin.game.autogen.chatroom.LocalMyChatRoom;
import com.tencent.mm.plugin.game.chatroom.b.c;
import com.tencent.mm.plugin.game.chatroom.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class b
  implements com.tencent.mm.am.h
{
  public a IkG;
  private b.c IkH;
  private com.tencent.mm.plugin.game.chatroom.c.i IkL;
  private String IkM;
  private String IkN;
  private List<String> IkO;
  private boolean mIsPause;
  private boolean mIsRunning;
  public int mScene;
  private boolean szN;
  
  public b(b.c paramc, a parama)
  {
    AppMethodBeat.i(275747);
    this.szN = false;
    this.mIsPause = false;
    this.mIsRunning = false;
    this.mScene = 2;
    this.IkO = new LinkedList();
    this.IkH = paramc;
    this.IkG = parama;
    AppMethodBeat.o(275747);
  }
  
  /* Error */
  private void f(List<String> paramList, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 72
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 44	com/tencent/mm/plugin/game/chatroom/h/b:mIsRunning	Z
    //   11: ifne +10 -> 21
    //   14: aload_0
    //   15: getfield 40	com/tencent/mm/plugin/game/chatroom/h/b:szN	Z
    //   18: ifne +42 -> 60
    //   21: ldc 74
    //   23: ldc 76
    //   25: iconst_2
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 44	com/tencent/mm/plugin/game/chatroom/h/b:mIsRunning	Z
    //   35: invokestatic 82	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_0
    //   42: getfield 40	com/tencent/mm/plugin/game/chatroom/h/b:szN	Z
    //   45: invokestatic 82	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: aastore
    //   49: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: ldc 72
    //   54: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_0
    //   61: aload_3
    //   62: putfield 89	com/tencent/mm/plugin/game/chatroom/h/b:IkN	Ljava/lang/String;
    //   65: aload_0
    //   66: getfield 51	com/tencent/mm/plugin/game/chatroom/h/b:IkO	Ljava/util/List;
    //   69: invokeinterface 94 1 0
    //   74: aload_1
    //   75: ifnull +14 -> 89
    //   78: aload_0
    //   79: getfield 51	com/tencent/mm/plugin/game/chatroom/h/b:IkO	Ljava/util/List;
    //   82: aload_1
    //   83: invokeinterface 98 2 0
    //   88: pop
    //   89: aload_0
    //   90: iconst_1
    //   91: putfield 44	com/tencent/mm/plugin/game/chatroom/h/b:mIsRunning	Z
    //   94: aload_0
    //   95: new 100	com/tencent/mm/plugin/game/chatroom/c/i
    //   98: dup
    //   99: aload_1
    //   100: aload_2
    //   101: aload_3
    //   102: aload_0
    //   103: getfield 46	com/tencent/mm/plugin/game/chatroom/h/b:mScene	I
    //   106: aload_0
    //   107: invokevirtual 104	java/lang/Object:hashCode	()I
    //   110: invokespecial 107	com/tencent/mm/plugin/game/chatroom/c/i:<init>	(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;II)V
    //   113: putfield 109	com/tencent/mm/plugin/game/chatroom/h/b:IkL	Lcom/tencent/mm/plugin/game/chatroom/c/i;
    //   116: invokestatic 115	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   119: aload_0
    //   120: getfield 109	com/tencent/mm/plugin/game/chatroom/h/b:IkL	Lcom/tencent/mm/plugin/game/chatroom/c/i;
    //   123: iconst_0
    //   124: invokevirtual 120	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   127: pop
    //   128: ldc 72
    //   130: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: goto -76 -> 57
    //   136: astore_1
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	b
    //   0	141	1	paramList	List<String>
    //   0	141	2	paramString1	String
    //   0	141	3	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	21	136	finally
    //   21	57	136	finally
    //   60	74	136	finally
    //   78	89	136	finally
    //   89	133	136	finally
  }
  
  /* Error */
  public final void aFA(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 125
    //   4: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokestatic 131	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   12: putfield 71	com/tencent/mm/plugin/game/chatroom/h/b:IkM	Ljava/lang/String;
    //   15: ldc 74
    //   17: ldc 133
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: aastore
    //   27: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: getfield 40	com/tencent/mm/plugin/game/chatroom/h/b:szN	Z
    //   34: ifne +48 -> 82
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 40	com/tencent/mm/plugin/game/chatroom/h/b:szN	Z
    //   42: ldc 74
    //   44: ldc 135
    //   46: iconst_0
    //   47: anewarray 4	java/lang/Object
    //   50: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: invokestatic 115	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   56: sipush 4989
    //   59: aload_0
    //   60: invokevirtual 141	com/tencent/mm/am/s:a	(ILcom/tencent/mm/am/h;)V
    //   63: aload_0
    //   64: aconst_null
    //   65: aload_0
    //   66: getfield 71	com/tencent/mm/plugin/game/chatroom/h/b:IkM	Ljava/lang/String;
    //   69: ldc 143
    //   71: invokespecial 66	com/tencent/mm/plugin/game/chatroom/h/b:f	(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V
    //   74: ldc 125
    //   76: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: ldc 74
    //   84: ldc 145
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: ldc 125
    //   95: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: goto -19 -> 79
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	this	b
    //   0	106	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	79	101	finally
    //   82	98	101	finally
  }
  
  public final void fCJ()
  {
    try
    {
      AppMethodBeat.i(275799);
      Log.i("GameChatRoom.GetMyChatRoomKeepAliveService", "stopKeepAlive");
      this.IkG = null;
      this.szN = false;
      this.mIsPause = false;
      this.mIsRunning = false;
      this.IkM = "";
      this.IkN = "";
      this.mScene = 2;
      this.IkO.clear();
      com.tencent.mm.kernel.h.aZW().b(4989, this);
      if (this.IkL != null) {
        com.tencent.mm.kernel.h.aZW().a(this.IkL);
      }
      AppMethodBeat.o(275799);
      return;
    }
    finally {}
  }
  
  public final void fCK()
  {
    try
    {
      AppMethodBeat.i(275785);
      Log.i("GameChatRoom.GetMyChatRoomKeepAliveService", "pauseKeepAlive");
      this.mIsPause = true;
      this.mIsRunning = false;
      if (this.IkL != null) {
        com.tencent.mm.kernel.h.aZW().a(this.IkL);
      }
      AppMethodBeat.o(275785);
      return;
    }
    finally {}
  }
  
  public final void fCL()
  {
    try
    {
      AppMethodBeat.i(275790);
      Log.i("GameChatRoom.GetMyChatRoomKeepAliveService", "resumeKeepAlive");
      if ((this.mIsPause) && (this.szN))
      {
        f(this.IkO, this.IkM, this.IkN);
        this.mIsPause = false;
      }
      AppMethodBeat.o(275790);
      return;
    }
    finally {}
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(275814);
    final GetMyChatroomRequest localGetMyChatroomRequest;
    int i;
    if (paramp.getType() == 4989)
    {
      if (((com.tencent.mm.plugin.game.chatroom.c.i)paramp).DD != hashCode())
      {
        Log.i("GameChatRoom.GetMyChatRoomKeepAliveService", "instanceId is diff");
        AppMethodBeat.o(275814);
        return;
      }
      localGetMyChatroomRequest = (GetMyChatroomRequest)c.b.b(((com.tencent.mm.plugin.game.chatroom.c.i)paramp).mtC.otB);
      paramp = ((com.tencent.mm.plugin.game.chatroom.c.i)paramp).fCB();
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramp == null) || (Util.nullAsNil(localGetMyChatroomRequest.version).equals(paramp.next_version))) {
        break label310;
      }
      localGetMyChatroomRequest.version = paramp.next_version;
      if ((this.IkG == null) || (paramp.my_chatroom_info_list == null)) {
        break label322;
      }
      LocalMyChatRoom localLocalMyChatRoom = new LocalMyChatRoom();
      localLocalMyChatRoom.my_chatroom_info_list.addAll(paramp.my_chatroom_info_list);
      localLocalMyChatRoom.my_chatroom_notice = paramp.my_chatroom_notice;
      Log.d("GameChatRoom.GetMyChatRoomKeepAliveService", "before reorder size:%d, after reorder size:%d", new Object[] { Integer.valueOf(paramp.my_chatroom_info_list.size()), Integer.valueOf(localLocalMyChatRoom.my_chatroom_info_list.size()) });
      this.IkG.a(this.IkH, localLocalMyChatRoom);
      i = 0;
    }
    for (;;)
    {
      Log.i("GameChatRoom.GetMyChatRoomKeepAliveService", "hashcode = %d, newVersion:%s, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(hashCode()), localGetMyChatroomRequest.version, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      paramString = com.tencent.threadpool.h.ahAA;
      paramp = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(275751);
          b.a(b.this);
          b.a(b.this, localGetMyChatroomRequest.chatroom_name_list, b.b(b.this), localGetMyChatroomRequest.version);
          AppMethodBeat.o(275751);
        }
      };
      if (i != 0) {}
      for (long l = 2000L;; l = 0L)
      {
        paramString.p(paramp, l);
        AppMethodBeat.o(275814);
        return;
        label310:
        i = 1;
        break;
      }
      label322:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.h.b
 * JD-Core Version:    0.7.0.1
 */