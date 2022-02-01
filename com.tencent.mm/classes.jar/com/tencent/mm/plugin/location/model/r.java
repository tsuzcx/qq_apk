package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements com.tencent.mm.bi.a
{
  private MMHandler handler;
  private List<c> listeners;
  private final String path;
  private b yGW;
  
  public r()
  {
    AppMethodBeat.i(55772);
    this.listeners = new LinkedList();
    Object localObject = new o(n.ecU());
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
    }
    this.path = (n.ecU() + "trackroominfolist.info");
    this.handler = new MMHandler(Looper.getMainLooper());
    if (this.yGW == null)
    {
      if (!s.YS(this.path))
      {
        this.yGW = new b();
        AppMethodBeat.o(55772);
        return;
      }
      try
      {
        localObject = s.aW(this.path, 0, -1);
        this.yGW = ((b)new b().parseFrom((byte[])localObject));
        AppMethodBeat.o(55772);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.TrackRoomListMgr", localException, "", new Object[0]);
        this.yGW = new b();
      }
    }
    AppMethodBeat.o(55772);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(182049);
    Log.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[] { Integer.valueOf(paramb.yFr.size()) });
    if (paramb.yFr.isEmpty())
    {
      s.deleteFile(this.path);
      AppMethodBeat.o(182049);
      return true;
    }
    try
    {
      paramb = paramb.toByteArray();
      s.f(this.path, paramb, paramb.length);
      AppMethodBeat.o(182049);
      return true;
    }
    catch (Exception paramb)
    {
      Log.printErrStackTrace("MicroMsg.TrackRoomListMgr", paramb, "", new Object[0]);
      AppMethodBeat.o(182049);
    }
    return false;
  }
  
  private void ax(final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(55778);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      final c localc = (c)localIterator.next();
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(55771);
          localc.Qa(paramString1);
          AppMethodBeat.o(55771);
        }
      });
    }
    AppMethodBeat.o(55778);
  }
  
  /* Error */
  public final LinkedList<String> PY(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 180
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 82	com/tencent/mm/plugin/location/model/r:yGW	Lcom/tencent/mm/plugin/location/a/b;
    //   11: getfield 122	com/tencent/mm/plugin/location/a/b:yFr	Ljava/util/LinkedList;
    //   14: invokevirtual 181	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   17: astore_2
    //   18: aload_2
    //   19: invokeinterface 164 1 0
    //   24: ifeq +44 -> 68
    //   27: aload_2
    //   28: invokeinterface 168 1 0
    //   33: checkcast 183	com/tencent/mm/plugin/location/a/a
    //   36: astore_3
    //   37: aload_3
    //   38: getfield 186	com/tencent/mm/plugin/location/a/a:username	Ljava/lang/String;
    //   41: aload_1
    //   42: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq -27 -> 18
    //   48: aload_3
    //   49: getfield 195	com/tencent/mm/plugin/location/a/a:dTe	Ljava/util/LinkedList;
    //   52: invokevirtual 198	java/util/LinkedList:clone	()Ljava/lang/Object;
    //   55: checkcast 32	java/util/LinkedList
    //   58: astore_1
    //   59: ldc 180
    //   61: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: areturn
    //   68: new 32	java/util/LinkedList
    //   71: dup
    //   72: invokespecial 33	java/util/LinkedList:<init>	()V
    //   75: astore_1
    //   76: ldc 180
    //   78: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: goto -17 -> 64
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	r
    //   0	89	1	paramString	String
    //   17	11	2	localIterator	Iterator
    //   36	13	3	locala	com.tencent.mm.plugin.location.a.a
    // Exception table:
    //   from	to	target	type
    //   2	18	84	finally
    //   18	64	84	finally
    //   68	81	84	finally
  }
  
  public final boolean PZ(String paramString)
  {
    AppMethodBeat.i(55780);
    if (PY(paramString).size() > 0)
    {
      AppMethodBeat.o(55780);
      return true;
    }
    AppMethodBeat.o(55780);
    return false;
  }
  
  public final void a(c paramc)
  {
    try
    {
      AppMethodBeat.i(55773);
      this.listeners.add(paramc);
      AppMethodBeat.o(55773);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public final void a(String paramString1, LinkedList<String> paramLinkedList, double paramDouble1, double paramDouble2, String paramString2, String paramString3, String paramString4)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(55777);
        localObject = paramLinkedList;
        if (paramLinkedList == null) {
          localObject = new LinkedList();
        }
        Log.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", new Object[] { paramString1, Integer.valueOf(((LinkedList)localObject).size()), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
        paramLinkedList = (LinkedList)((LinkedList)localObject).clone();
        boolean bool = paramLinkedList.isEmpty();
        localObject = this.yGW.yFr.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.location.a.a locala = (com.tencent.mm.plugin.location.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.yGW.yFr.remove(locala);
            a(this.yGW);
            ax(paramString1, paramString3, paramString4);
            AppMethodBeat.o(55777);
            return;
          }
          locala.dTe = paramLinkedList;
          locala.yFq = paramString2;
          locala.latitude = paramDouble1;
          locala.longitude = paramDouble2;
          continue;
        }
        if (bool) {
          break label262;
        }
      }
      finally {}
      Object localObject = new com.tencent.mm.plugin.location.a.a();
      ((com.tencent.mm.plugin.location.a.a)localObject).username = paramString1;
      ((com.tencent.mm.plugin.location.a.a)localObject).dTe = paramLinkedList;
      ((com.tencent.mm.plugin.location.a.a)localObject).yFq = paramString2;
      ((com.tencent.mm.plugin.location.a.a)localObject).latitude = paramDouble1;
      ((com.tencent.mm.plugin.location.a.a)localObject).longitude = paramDouble2;
      this.yGW.yFr.add(localObject);
      label262:
      a(this.yGW);
      ax(paramString1, paramString3, paramString4);
      AppMethodBeat.o(55777);
    }
  }
  
  /* Error */
  public final com.tencent.mm.plugin.location.a.a aCZ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 243
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 82	com/tencent/mm/plugin/location/model/r:yGW	Lcom/tencent/mm/plugin/location/a/b;
    //   11: getfield 122	com/tencent/mm/plugin/location/a/b:yFr	Ljava/util/LinkedList;
    //   14: invokevirtual 181	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   17: astore_3
    //   18: aload_3
    //   19: invokeinterface 164 1 0
    //   24: ifeq +35 -> 59
    //   27: aload_3
    //   28: invokeinterface 168 1 0
    //   33: checkcast 183	com/tencent/mm/plugin/location/a/a
    //   36: astore_2
    //   37: aload_2
    //   38: getfield 186	com/tencent/mm/plugin/location/a/a:username	Ljava/lang/String;
    //   41: aload_1
    //   42: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq -27 -> 18
    //   48: ldc 243
    //   50: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: areturn
    //   59: aconst_null
    //   60: astore_1
    //   61: ldc 243
    //   63: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -11 -> 55
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	r
    //   0	74	1	paramString	String
    //   36	18	2	locala	com.tencent.mm.plugin.location.a.a
    //   17	11	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	18	69	finally
    //   18	53	69	finally
    //   61	66	69	finally
  }
  
  public final void aDa(String paramString)
  {
    AppMethodBeat.i(55783);
    if (this.yGW != null) {
      this.yGW.yFs = paramString;
    }
    a(this.yGW);
    AppMethodBeat.o(55783);
  }
  
  public final void b(c paramc)
  {
    try
    {
      AppMethodBeat.i(55774);
      this.listeners.remove(paramc);
      AppMethodBeat.o(55774);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public final boolean bB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55782);
    boolean bool = PY(paramString1).contains(paramString2);
    AppMethodBeat.o(55782);
    return bool;
  }
  
  public final boolean bgJ()
  {
    AppMethodBeat.i(55781);
    String str;
    do
    {
      Iterator localIterator = this.yGW.yFr.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (com.tencent.mm.plugin.location.a.a)localIterator.next();
        Log.d("MicroMsg.TrackRoomListMgr", "info :" + ((com.tencent.mm.plugin.location.a.a)localObject).dTe.size());
        localObject = ((com.tencent.mm.plugin.location.a.a)localObject).dTe.iterator();
      }
      str = (String)((Iterator)localObject).next();
      Log.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
    } while (!str.equals(z.aTY()));
    Log.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
    AppMethodBeat.o(55781);
    return true;
    AppMethodBeat.o(55781);
    return false;
  }
  
  public final String bgK()
  {
    if (this.yGW != null) {
      return this.yGW.yFs;
    }
    return "";
  }
  
  public final void bgs()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(55784);
        LinkedList localLinkedList = new LinkedList();
        if ((this.yGW.yFr != null) && (!this.yGW.yFr.isEmpty()))
        {
          localObject2 = (com.tencent.mm.plugin.location.a.a[])this.yGW.yFr.toArray(new com.tencent.mm.plugin.location.a.a[0]);
          int k = localObject2.length;
          j = 0;
          if (j < k)
          {
            Object localObject3 = localObject2[j];
            if (Util.isNullOrNil(localObject3.dTe)) {
              break label230;
            }
            int i = 1;
            Iterator localIterator = localObject3.dTe.iterator();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              Log.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
              if (!str.equals(z.aTY())) {
                break label227;
              }
              Log.i("MicroMsg.TrackRoomListMgr", "reset list info and remove self location info");
              i = 0;
              break label227;
            }
            if (i == 0) {
              break label230;
            }
            localLinkedList.add(localObject3);
            break label230;
          }
        }
        Object localObject2 = new b();
        ((b)localObject2).yFr = localLinkedList;
        ((b)localObject2).yFs = this.yGW.yFs;
        a((b)localObject2);
        AppMethodBeat.o(55784);
        return;
      }
      finally {}
      label227:
      continue;
      label230:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.r
 * JD-Core Version:    0.7.0.1
 */