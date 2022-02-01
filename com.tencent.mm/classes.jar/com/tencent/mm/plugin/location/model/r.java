package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements com.tencent.mm.bi.a
{
  private ao handler;
  private List<c> listeners;
  private final String path;
  private b tYl;
  
  public r()
  {
    AppMethodBeat.i(55772);
    this.listeners = new LinkedList();
    Object localObject = new e(n.cWY());
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    this.path = (n.cWY() + "trackroominfolist.info");
    this.handler = new ao(Looper.getMainLooper());
    if (this.tYl == null)
    {
      if (!i.eA(this.path))
      {
        this.tYl = new b();
        AppMethodBeat.o(55772);
        return;
      }
      try
      {
        localObject = i.aU(this.path, 0, -1);
        this.tYl = ((b)new b().parseFrom((byte[])localObject));
        AppMethodBeat.o(55772);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.TrackRoomListMgr", localException, "", new Object[0]);
        this.tYl = new b();
      }
    }
    AppMethodBeat.o(55772);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(182049);
    ac.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[] { Integer.valueOf(paramb.tWF.size()) });
    if (paramb.tWF.isEmpty())
    {
      i.deleteFile(this.path);
      AppMethodBeat.o(182049);
      return true;
    }
    try
    {
      paramb = paramb.toByteArray();
      i.f(this.path, paramb, paramb.length);
      AppMethodBeat.o(182049);
      return true;
    }
    catch (Exception paramb)
    {
      ac.printErrStackTrace("MicroMsg.TrackRoomListMgr", paramb, "", new Object[0]);
      AppMethodBeat.o(182049);
    }
    return false;
  }
  
  private void ah(final String paramString1, final String paramString2, final String paramString3)
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
          localc.DG(paramString1);
          AppMethodBeat.o(55771);
        }
      });
    }
    AppMethodBeat.o(55778);
  }
  
  /* Error */
  public final LinkedList<String> DE(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 180
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 82	com/tencent/mm/plugin/location/model/r:tYl	Lcom/tencent/mm/plugin/location/a/b;
    //   11: getfield 122	com/tencent/mm/plugin/location/a/b:tWF	Ljava/util/LinkedList;
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
    //   49: getfield 195	com/tencent/mm/plugin/location/a/a:dow	Ljava/util/LinkedList;
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
  
  public final boolean DF(String paramString)
  {
    AppMethodBeat.i(55780);
    if (DE(paramString).size() > 0)
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
        ac.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", new Object[] { paramString1, Integer.valueOf(((LinkedList)localObject).size()), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
        paramLinkedList = (LinkedList)((LinkedList)localObject).clone();
        boolean bool = paramLinkedList.isEmpty();
        localObject = this.tYl.tWF.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.location.a.a locala = (com.tencent.mm.plugin.location.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.tYl.tWF.remove(locala);
            a(this.tYl);
            ah(paramString1, paramString3, paramString4);
            AppMethodBeat.o(55777);
            return;
          }
          locala.dow = paramLinkedList;
          locala.tWE = paramString2;
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
      ((com.tencent.mm.plugin.location.a.a)localObject).dow = paramLinkedList;
      ((com.tencent.mm.plugin.location.a.a)localObject).tWE = paramString2;
      ((com.tencent.mm.plugin.location.a.a)localObject).latitude = paramDouble1;
      ((com.tencent.mm.plugin.location.a.a)localObject).longitude = paramDouble2;
      this.tYl.tWF.add(localObject);
      label262:
      a(this.tYl);
      ah(paramString1, paramString3, paramString4);
      AppMethodBeat.o(55777);
    }
  }
  
  public final void aIK()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(55784);
        LinkedList localLinkedList = new LinkedList();
        if ((this.tYl.tWF != null) && (!this.tYl.tWF.isEmpty()))
        {
          localObject2 = (com.tencent.mm.plugin.location.a.a[])this.tYl.tWF.toArray(new com.tencent.mm.plugin.location.a.a[0]);
          int k = localObject2.length;
          j = 0;
          if (j < k)
          {
            Object localObject3 = localObject2[j];
            if (bs.gY(localObject3.dow)) {
              break label228;
            }
            int i = 1;
            Iterator localIterator = localObject3.dow.iterator();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              ac.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
              if (!str.equals(u.axw())) {
                break label225;
              }
              ac.i("MicroMsg.TrackRoomListMgr", "reset list info and remove self location info");
              i = 0;
              break label225;
            }
            if (i == 0) {
              break label228;
            }
            localLinkedList.add(localObject3);
            break label228;
          }
        }
        Object localObject2 = new b();
        ((b)localObject2).tWF = localLinkedList;
        ((b)localObject2).tWG = this.tYl.tWG;
        a((b)localObject2);
        AppMethodBeat.o(55784);
        return;
      }
      finally {}
      label225:
      continue;
      label228:
      j += 1;
    }
  }
  
  public final boolean aJa()
  {
    AppMethodBeat.i(55781);
    String str;
    do
    {
      Iterator localIterator = this.tYl.tWF.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (com.tencent.mm.plugin.location.a.a)localIterator.next();
        ac.d("MicroMsg.TrackRoomListMgr", "info :" + ((com.tencent.mm.plugin.location.a.a)localObject).dow.size());
        localObject = ((com.tencent.mm.plugin.location.a.a)localObject).dow.iterator();
      }
      str = (String)((Iterator)localObject).next();
      ac.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
    } while (!str.equals(u.axw()));
    ac.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
    AppMethodBeat.o(55781);
    return true;
    AppMethodBeat.o(55781);
    return false;
  }
  
  public final String aJb()
  {
    if (this.tYl != null) {
      return this.tYl.tWG;
    }
    return "";
  }
  
  /* Error */
  public final com.tencent.mm.plugin.location.a.a ajO(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 292
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 82	com/tencent/mm/plugin/location/model/r:tYl	Lcom/tencent/mm/plugin/location/a/b;
    //   12: getfield 122	com/tencent/mm/plugin/location/a/b:tWF	Ljava/util/LinkedList;
    //   15: invokevirtual 181	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore_3
    //   19: aload_3
    //   20: invokeinterface 164 1 0
    //   25: ifeq +36 -> 61
    //   28: aload_3
    //   29: invokeinterface 168 1 0
    //   34: checkcast 183	com/tencent/mm/plugin/location/a/a
    //   37: astore_2
    //   38: aload_2
    //   39: getfield 186	com/tencent/mm/plugin/location/a/a:username	Ljava/lang/String;
    //   42: aload_1
    //   43: invokevirtual 192	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq -27 -> 19
    //   49: ldc_w 292
    //   52: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_2
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: aconst_null
    //   62: astore_1
    //   63: ldc_w 292
    //   66: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -12 -> 57
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	r
    //   0	77	1	paramString	String
    //   37	19	2	locala	com.tencent.mm.plugin.location.a.a
    //   18	11	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	19	72	finally
    //   19	55	72	finally
    //   63	69	72	finally
  }
  
  public final void ajP(String paramString)
  {
    AppMethodBeat.i(55783);
    if (this.tYl != null) {
      this.tYl.tWG = paramString;
    }
    a(this.tYl);
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
  
  public final boolean bw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55782);
    boolean bool = DE(paramString1).contains(paramString2);
    AppMethodBeat.o(55782);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.r
 * JD-Core Version:    0.7.0.1
 */