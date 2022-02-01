package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements com.tencent.mm.bj.a
{
  private ap handler;
  private List<c> listeners;
  private final String path;
  private b vaU;
  
  public r()
  {
    AppMethodBeat.i(55772);
    this.listeners = new LinkedList();
    Object localObject = new e(n.dgk());
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    this.path = (n.dgk() + "trackroominfolist.info");
    this.handler = new ap(Looper.getMainLooper());
    if (this.vaU == null)
    {
      if (!i.fv(this.path))
      {
        this.vaU = new b();
        AppMethodBeat.o(55772);
        return;
      }
      try
      {
        localObject = i.aY(this.path, 0, -1);
        this.vaU = ((b)new b().parseFrom((byte[])localObject));
        AppMethodBeat.o(55772);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.TrackRoomListMgr", localException, "", new Object[0]);
        this.vaU = new b();
      }
    }
    AppMethodBeat.o(55772);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(182049);
    ad.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[] { Integer.valueOf(paramb.uZo.size()) });
    if (paramb.uZo.isEmpty())
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
      ad.printErrStackTrace("MicroMsg.TrackRoomListMgr", paramb, "", new Object[0]);
      AppMethodBeat.o(182049);
    }
    return false;
  }
  
  private void ao(final String paramString1, final String paramString2, final String paramString3)
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
          localc.GL(paramString1);
          AppMethodBeat.o(55771);
        }
      });
    }
    AppMethodBeat.o(55778);
  }
  
  /* Error */
  public final LinkedList<String> GJ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 180
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 82	com/tencent/mm/plugin/location/model/r:vaU	Lcom/tencent/mm/plugin/location/a/b;
    //   11: getfield 122	com/tencent/mm/plugin/location/a/b:uZo	Ljava/util/LinkedList;
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
    //   49: getfield 195	com/tencent/mm/plugin/location/a/a:dAk	Ljava/util/LinkedList;
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
  
  public final boolean GK(String paramString)
  {
    AppMethodBeat.i(55780);
    if (GJ(paramString).size() > 0)
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
        ad.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", new Object[] { paramString1, Integer.valueOf(((LinkedList)localObject).size()), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
        paramLinkedList = (LinkedList)((LinkedList)localObject).clone();
        boolean bool = paramLinkedList.isEmpty();
        localObject = this.vaU.uZo.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.location.a.a locala = (com.tencent.mm.plugin.location.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.vaU.uZo.remove(locala);
            a(this.vaU);
            ao(paramString1, paramString3, paramString4);
            AppMethodBeat.o(55777);
            return;
          }
          locala.dAk = paramLinkedList;
          locala.uZn = paramString2;
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
      ((com.tencent.mm.plugin.location.a.a)localObject).dAk = paramLinkedList;
      ((com.tencent.mm.plugin.location.a.a)localObject).uZn = paramString2;
      ((com.tencent.mm.plugin.location.a.a)localObject).latitude = paramDouble1;
      ((com.tencent.mm.plugin.location.a.a)localObject).longitude = paramDouble2;
      this.vaU.uZo.add(localObject);
      label262:
      a(this.vaU);
      ao(paramString1, paramString3, paramString4);
      AppMethodBeat.o(55777);
    }
  }
  
  public final void aLU()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(55784);
        LinkedList localLinkedList = new LinkedList();
        if ((this.vaU.uZo != null) && (!this.vaU.uZo.isEmpty()))
        {
          localObject2 = (com.tencent.mm.plugin.location.a.a[])this.vaU.uZo.toArray(new com.tencent.mm.plugin.location.a.a[0]);
          int k = localObject2.length;
          j = 0;
          if (j < k)
          {
            Object localObject3 = localObject2[j];
            if (bt.hj(localObject3.dAk)) {
              break label228;
            }
            int i = 1;
            Iterator localIterator = localObject3.dAk.iterator();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              ad.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
              if (!str.equals(u.aAm())) {
                break label225;
              }
              ad.i("MicroMsg.TrackRoomListMgr", "reset list info and remove self location info");
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
        ((b)localObject2).uZo = localLinkedList;
        ((b)localObject2).uZp = this.vaU.uZp;
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
  
  public final boolean aMk()
  {
    AppMethodBeat.i(55781);
    String str;
    do
    {
      Iterator localIterator = this.vaU.uZo.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (com.tencent.mm.plugin.location.a.a)localIterator.next();
        ad.d("MicroMsg.TrackRoomListMgr", "info :" + ((com.tencent.mm.plugin.location.a.a)localObject).dAk.size());
        localObject = ((com.tencent.mm.plugin.location.a.a)localObject).dAk.iterator();
      }
      str = (String)((Iterator)localObject).next();
      ad.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
    } while (!str.equals(u.aAm()));
    ad.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
    AppMethodBeat.o(55781);
    return true;
    AppMethodBeat.o(55781);
    return false;
  }
  
  public final String aMl()
  {
    if (this.vaU != null) {
      return this.vaU.uZp;
    }
    return "";
  }
  
  /* Error */
  public final com.tencent.mm.plugin.location.a.a aoB(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 292
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 82	com/tencent/mm/plugin/location/model/r:vaU	Lcom/tencent/mm/plugin/location/a/b;
    //   12: getfield 122	com/tencent/mm/plugin/location/a/b:uZo	Ljava/util/LinkedList;
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
  
  public final void aoC(String paramString)
  {
    AppMethodBeat.i(55783);
    if (this.vaU != null) {
      this.vaU.uZp = paramString;
    }
    a(this.vaU);
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
  
  public final boolean bx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55782);
    boolean bool = GJ(paramString1).contains(paramString2);
    AppMethodBeat.o(55782);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.r
 * JD-Core Version:    0.7.0.1
 */