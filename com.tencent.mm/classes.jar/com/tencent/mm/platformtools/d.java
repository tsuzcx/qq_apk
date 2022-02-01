package com.tencent.mm.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import i.a.a.a.a.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<TT;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/platformtools/BaseProtoPage;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "", "()V", "TAG", "", "filePath", "clearPage", "", "constructor", "readFromFile", "Ljava/util/LinkedList;", "writeToFile", "dataList", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d<T extends com.tencent.mm.bx.a>
{
  private final String TAG = "MicroMsg.BaseProtoPage";
  private String filePath;
  
  protected final void RY(String paramString)
  {
    AppMethodBeat.i(169171);
    s.u(paramString, "filePath");
    this.filePath = paramString;
    AppMethodBeat.o(169171);
  }
  
  public final LinkedList<T> bTt()
  {
    AppMethodBeat.i(169173);
    Object localObject4 = this.filePath;
    Object localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("filePath");
      localObject1 = null;
    }
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e(this.TAG, "file path [%s] is invalid!");
      AppMethodBeat.o(169173);
      return null;
    }
    Object localObject5;
    for (;;)
    {
      try
      {
        localObject4 = this.filePath;
        localObject1 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("filePath");
          localObject1 = null;
        }
        if (!y.ZC((String)localObject1))
        {
          localObject5 = this.TAG;
          localObject6 = new StringBuilder("file ");
          localObject4 = this.filePath;
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            s.bIx("filePath");
            localObject1 = null;
          }
          Log.i((String)localObject5, (String)localObject1 + " is not exist!");
          return null;
        }
        try
        {
          localObject1 = this.filePath;
          if (localObject1 == null)
          {
            s.bIx("filePath");
            localObject1 = null;
            localObject5 = this.filePath;
            localObject4 = localObject5;
            if (localObject5 == null)
            {
              s.bIx("filePath");
              localObject4 = null;
            }
            localObject1 = y.bi((String)localObject1, 0, (int)y.bEl((String)localObject4));
            localObject4 = i.a.a.a.a.a.kFU();
            localObject5 = new i.a.a.a.a((byte[])localObject1, (b)localObject4);
            localObject6 = ((i.a.a.a.a)localObject5).aMP(((i.a.a.a.a)localObject5).kFS());
            localObject5 = new LinkedList();
            s.s(localObject6, "listLst");
            localObject6 = ((Iterable)localObject6).iterator();
            if (!((Iterator)localObject6).hasNext()) {
              break;
            }
            localObject7 = (byte[])((Iterator)localObject6).next();
            localObject8 = getClass().getGenericSuperclass();
            if (localObject8 != null) {
              continue;
            }
            localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
            AppMethodBeat.o(169173);
            throw ((Throwable)localObject1);
          }
        }
        catch (Exception localException)
        {
          Log.e(this.TAG, s.X("parse proto from file occur error: ", localException.getMessage()));
          return null;
        }
        continue;
        localObject8 = ((java.lang.reflect.ParameterizedType)localObject8).getActualTypeArguments()[0];
        if (localObject8 == null)
        {
          NullPointerException localNullPointerException = new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
          AppMethodBeat.o(169173);
          throw localNullPointerException;
        }
      }
      finally
      {
        AppMethodBeat.o(169173);
      }
      Object localObject8 = ((Class)localObject8).newInstance();
      if (localObject8 == null)
      {
        localObject3 = new NullPointerException("null cannot be cast to non-null type T of com.tencent.mm.platformtools.BaseProtoPage.readFromFile$lambda-2$lambda-1");
        AppMethodBeat.o(169173);
        throw ((Throwable)localObject3);
      }
      localObject8 = (com.tencent.mm.bx.a)localObject8;
      s.checkNotNull(localObject7);
      localObject7 = new i.a.a.a.a((byte[])localObject7, (b)localObject4);
      for (boolean bool = true; bool; bool = ((com.tencent.mm.bx.a)localObject8).populateBuilderWithField((i.a.a.a.a)localObject7, (com.tencent.mm.bx.a)localObject8, com.tencent.mm.bx.a.getNextFieldNumber((i.a.a.a.a)localObject7))) {}
      ((LinkedList)localObject5).add(localObject8);
    }
    Object localObject6 = this.TAG;
    Object localObject7 = new StringBuilder("read ").append(((LinkedList)localObject5).size()).append(" items (total size ").append(localObject3.length).append(") from file ");
    localObject4 = this.filePath;
    Object localObject3 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("filePath");
      localObject3 = null;
    }
    Log.i((String)localObject6, (String)localObject3);
    AppMethodBeat.o(169173);
    return localObject5;
  }
  
  /* Error */
  public final void bTu()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc 230
    //   6: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 56	com/tencent/mm/platformtools/d:filePath	Ljava/lang/String;
    //   13: astore 4
    //   15: aload 4
    //   17: astore_1
    //   18: aload 4
    //   20: ifnonnull +10 -> 30
    //   23: ldc 48
    //   25: invokestatic 67	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
    //   28: aconst_null
    //   29: astore_1
    //   30: aload_1
    //   31: invokestatic 73	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   34: ifeq +62 -> 96
    //   37: aload_0
    //   38: getfield 37	com/tencent/mm/platformtools/d:TAG	Ljava/lang/String;
    //   41: astore_3
    //   42: new 88	java/lang/StringBuilder
    //   45: dup
    //   46: ldc 232
    //   48: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   51: astore 4
    //   53: aload_0
    //   54: getfield 56	com/tencent/mm/platformtools/d:filePath	Ljava/lang/String;
    //   57: astore_1
    //   58: aload_1
    //   59: ifnonnull +34 -> 93
    //   62: ldc 48
    //   64: invokestatic 67	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: aload 4
    //   72: aload_1
    //   73: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 234
    //   78: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 81	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: ldc 230
    //   89: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: return
    //   93: goto -24 -> 69
    //   96: aload_0
    //   97: monitorenter
    //   98: aload_0
    //   99: getfield 56	com/tencent/mm/platformtools/d:filePath	Ljava/lang/String;
    //   102: astore_1
    //   103: aload_1
    //   104: ifnonnull +23 -> 127
    //   107: ldc 48
    //   109: invokestatic 67	kotlin/g/b/s:bIx	(Ljava/lang/String;)V
    //   112: aload_3
    //   113: astore_1
    //   114: aload_1
    //   115: invokestatic 237	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   118: pop
    //   119: aload_0
    //   120: monitorexit
    //   121: ldc 230
    //   123: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: return
    //   127: goto -13 -> 114
    //   130: astore_1
    //   131: aload_0
    //   132: monitorexit
    //   133: ldc 230
    //   135: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	d
    //   17	98	1	localObject1	Object
    //   130	9	1	localObject2	Object
    //   3	65	2	localObject3	Object
    //   1	112	3	str	String
    //   13	58	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   98	103	130	finally
    //   107	112	130	finally
    //   114	119	130	finally
  }
  
  public final void s(LinkedList<T> paramLinkedList)
  {
    Object localObject2 = null;
    AppMethodBeat.i(169172);
    s.u(paramLinkedList, "dataList");
    Object localObject3 = this.filePath;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("filePath");
      localObject1 = null;
    }
    if (Util.isNullOrNil((String)localObject1))
    {
      Log.e(this.TAG, "file path [%s] is invalid!");
      AppMethodBeat.o(169172);
      return;
    }
    try
    {
      localObject3 = this.filePath;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("filePath");
        localObject1 = null;
      }
      localObject1 = new u((String)localObject1);
      if (!y.ZC(((u)localObject1).jKO())) {
        y.bDX(((u)localObject1).jKO());
      }
      localObject3 = this.filePath;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("filePath");
        localObject1 = null;
      }
      if (!y.ZC((String)localObject1))
      {
        localObject4 = this.TAG;
        localObject3 = this.filePath;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("filePath");
          localObject1 = null;
        }
        Log.i((String)localObject4, s.X("create new file ", localObject1));
        localObject3 = this.filePath;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("filePath");
          localObject1 = null;
        }
        y.bEp((String)localObject1);
      }
      try
      {
        int i = i.a.a.a.c(1, 8, paramLinkedList);
        localObject4 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder("write ").append(paramLinkedList.size()).append(" items (total size ").append(i).append(") to file ");
        localObject3 = this.filePath;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("filePath");
          localObject1 = null;
        }
        Log.i((String)localObject4, (String)localObject1);
        localObject3 = new byte[i];
        localObject1 = new i.a.a.c.a((byte[])localObject3);
        ((i.a.a.c.a)localObject1).e(1, 8, paramLinkedList);
        ((i.a.a.c.a)localObject1).kGd();
        localObject1 = this.filePath;
        paramLinkedList = (LinkedList<T>)localObject1;
        if (localObject1 == null)
        {
          s.bIx("filePath");
          paramLinkedList = null;
        }
        y.f(paramLinkedList, (byte[])localObject3, localObject3.length);
      }
      catch (IOException localIOException)
      {
        localObject3 = this.TAG;
        localObject4 = new StringBuilder("write to file ");
        paramLinkedList = this.filePath;
        if (paramLinkedList != null) {
          break label415;
        }
        s.bIx("filePath");
        paramLinkedList = localObject2;
        for (;;)
        {
          Log.e((String)localObject3, paramLinkedList + " occur error: " + localIOException.getMessage());
          paramLinkedList = ah.aiuX;
          break;
        }
      }
      return;
    }
    finally
    {
      Object localObject4;
      label415:
      AppMethodBeat.o(169172);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.d
 * JD-Core Version:    0.7.0.1
 */