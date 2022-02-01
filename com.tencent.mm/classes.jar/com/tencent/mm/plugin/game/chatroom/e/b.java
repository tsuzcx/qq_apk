package com.tencent.mm.plugin.game.chatroom.e;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/chatroom/db/GameChatRoomContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/game/chatroom/db/GameChatRoomContact;", "storage", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getStorage", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "getContact", "Lcom/tencent/mm/plugin/game/chatroom/callback/IGameChatRoomContact;", "userName", "", "", "userNameList", "", "insertContact", "", "contact", "replaceContact", "", "updateContact", "Companion", "game-chatroom_release"})
public final class b
  extends MAutoStorage<a>
{
  public static final a CuE;
  public static final String[] SQL_CREATE;
  private final ISQLiteDatabase AkA;
  
  static
  {
    AppMethodBeat.i(211091);
    CuE = new a((byte)0);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.lqK, "GameChatRoomContact") };
    AppMethodBeat.o(211091);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.lqK, "GameChatRoomContact", a.INDEX_CREATE);
    AppMethodBeat.i(211090);
    this.AkA = paramISQLiteDatabase;
    AppMethodBeat.o(211090);
  }
  
  private final int b(a parama)
  {
    AppMethodBeat.i(211088);
    ContentValues localContentValues = parama.convertTo();
    int i = this.AkA.update("GameChatRoomContact", localContentValues, "userName=?", new String[] { parama.getUserName() });
    Log.i("GameChatRoom.GameChatRoomContactStorage", "updateContact[" + i + "] " + parama.print());
    if (i > 0) {
      doNotify("single", 3, parama.getUserName());
    }
    AppMethodBeat.o(211088);
    return i;
  }
  
  private final int c(a parama)
  {
    AppMethodBeat.i(211089);
    ContentValues localContentValues = parama.convertTo();
    int i = (int)this.AkA.insert("GameChatRoomContact", "userName", localContentValues);
    Log.i("GameChatRoom.GameChatRoomContactStorage", "insertContact[" + i + "] " + parama.print());
    if (i > 0) {
      doNotify("single", 2, parama.getUserName());
    }
    AppMethodBeat.o(211089);
    return i;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(211087);
    p.k(parama, "contact");
    if (parama.getUserName() == null)
    {
      AppMethodBeat.o(211087);
      return false;
    }
    parama.field_updateTime = cm.bfE();
    String str = parama.getUserName();
    p.j(str, "contact.userName");
    if (aIR(str) == null) {}
    for (int i = c(parama); i > 0; i = b(parama))
    {
      AppMethodBeat.o(211087);
      return true;
    }
    AppMethodBeat.o(211087);
    return false;
  }
  
  /* Error */
  public final com.tencent.mm.plugin.game.chatroom.b.c aIR(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 182
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 147
    //   10: invokestatic 81	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 113	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 184
    //   19: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokestatic 190	com/tencent/mm/storagebase/h:Mi	(Ljava/lang/String;)Ljava/lang/String;
    //   26: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 90	com/tencent/mm/plugin/game/chatroom/e/b:AkA	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_2
    //   40: invokeinterface 194 4 0
    //   45: checkcast 196	java/io/Closeable
    //   48: astore_3
    //   49: aload_3
    //   50: checkcast 198	android/database/Cursor
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +50 -> 107
    //   60: aload 4
    //   62: invokeinterface 202 1 0
    //   67: iconst_1
    //   68: if_icmpne +69 -> 137
    //   71: new 58	com/tencent/mm/plugin/game/chatroom/e/a
    //   74: dup
    //   75: invokespecial 204	com/tencent/mm/plugin/game/chatroom/e/a:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: aload 4
    //   82: invokevirtual 208	com/tencent/mm/plugin/game/chatroom/e/a:convertFrom	(Landroid/database/Cursor;)V
    //   85: getstatic 214	kotlin/x:aazN	Lkotlin/x;
    //   88: astore 4
    //   90: aload_3
    //   91: aconst_null
    //   92: invokestatic 219	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   95: aload_1
    //   96: checkcast 221	com/tencent/mm/plugin/game/chatroom/b/c
    //   99: astore_1
    //   100: ldc 182
    //   102: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_1
    //   106: areturn
    //   107: aconst_null
    //   108: astore_1
    //   109: goto -24 -> 85
    //   112: astore_2
    //   113: ldc 182
    //   115: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_2
    //   119: athrow
    //   120: astore_1
    //   121: aload_3
    //   122: aload_2
    //   123: invokestatic 219	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   126: ldc 182
    //   128: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: goto -13 -> 121
    //   137: aconst_null
    //   138: astore_1
    //   139: goto -54 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	b
    //   0	142	1	paramString	String
    //   1	1	2	localObject1	Object
    //   112	11	2	localThrowable	java.lang.Throwable
    //   48	74	3	localCloseable	java.io.Closeable
    //   53	36	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	55	112	java/lang/Throwable
    //   60	85	112	java/lang/Throwable
    //   85	90	112	java/lang/Throwable
    //   113	120	120	finally
    //   49	55	133	finally
    //   60	85	133	finally
    //   85	90	133	finally
  }
  
  /* Error */
  public final java.util.Map<String, com.tencent.mm.plugin.game.chatroom.b.c> fr(java.util.List<String> paramList)
  {
    // Byte code:
    //   0: ldc 224
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 225
    //   8: invokestatic 81	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: new 113	java/lang/StringBuilder
    //   14: dup
    //   15: ldc 227
    //   17: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: invokestatic 233	com/tencent/mm/plugin/game/chatroom/e:fq	(Ljava/util/List;)Ljava/lang/String;
    //   24: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore_2
    //   31: new 235	java/util/HashMap
    //   34: dup
    //   35: invokespecial 236	java/util/HashMap:<init>	()V
    //   38: astore_1
    //   39: aload_0
    //   40: getfield 90	com/tencent/mm/plugin/game/chatroom/e/b:AkA	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   43: aload_2
    //   44: aconst_null
    //   45: iconst_2
    //   46: invokeinterface 194 4 0
    //   51: checkcast 196	java/io/Closeable
    //   54: astore_3
    //   55: aload_3
    //   56: checkcast 198	android/database/Cursor
    //   59: astore_2
    //   60: aload_2
    //   61: invokeinterface 202 1 0
    //   66: ifeq +96 -> 162
    //   69: aload_2
    //   70: ldc 238
    //   72: invokestatic 171	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   75: aload_2
    //   76: invokeinterface 241 1 0
    //   81: ifne +81 -> 162
    //   84: new 58	com/tencent/mm/plugin/game/chatroom/e/a
    //   87: dup
    //   88: invokespecial 204	com/tencent/mm/plugin/game/chatroom/e/a:<init>	()V
    //   91: astore 4
    //   93: aload 4
    //   95: aload_2
    //   96: invokevirtual 208	com/tencent/mm/plugin/game/chatroom/e/a:convertFrom	(Landroid/database/Cursor;)V
    //   99: aload_1
    //   100: checkcast 243	java/util/Map
    //   103: astore 5
    //   105: aload 4
    //   107: getfield 247	com/tencent/mm/plugin/game/chatroom/e/a:field_userName	Ljava/lang/String;
    //   110: astore 6
    //   112: aload 6
    //   114: ldc 248
    //   116: invokestatic 171	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   119: aload 5
    //   121: aload 6
    //   123: aload 4
    //   125: invokeinterface 252 3 0
    //   130: pop
    //   131: aload_2
    //   132: invokeinterface 255 1 0
    //   137: pop
    //   138: goto -69 -> 69
    //   141: astore_2
    //   142: ldc 224
    //   144: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_2
    //   148: athrow
    //   149: astore_1
    //   150: aload_3
    //   151: aload_2
    //   152: invokestatic 219	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   155: ldc 224
    //   157: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: aload_1
    //   161: athrow
    //   162: getstatic 214	kotlin/x:aazN	Lkotlin/x;
    //   165: astore_2
    //   166: aload_3
    //   167: aconst_null
    //   168: invokestatic 219	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   171: aload_1
    //   172: checkcast 243	java/util/Map
    //   175: astore_1
    //   176: ldc 224
    //   178: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_1
    //   182: areturn
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_2
    //   186: goto -36 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	b
    //   0	189	1	paramList	java.util.List<String>
    //   30	102	2	localObject	Object
    //   141	11	2	localThrowable	java.lang.Throwable
    //   165	21	2	localx	kotlin.x
    //   54	113	3	localCloseable	java.io.Closeable
    //   91	33	4	locala	a
    //   103	17	5	localMap	java.util.Map
    //   110	12	6	str	String
    // Exception table:
    //   from	to	target	type
    //   55	69	141	java/lang/Throwable
    //   69	138	141	java/lang/Throwable
    //   162	166	141	java/lang/Throwable
    //   142	149	149	finally
    //   55	69	183	finally
    //   69	138	183	finally
    //   162	166	183	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/game/chatroom/db/GameChatRoomContactStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TAG", "game-chatroom_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.e.b
 * JD-Core Version:    0.7.0.1
 */