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
  private b sPY;
  
  public r()
  {
    AppMethodBeat.i(55772);
    this.listeners = new LinkedList();
    Object localObject = new e(n.cJt());
    if (!((e)localObject).exists()) {
      ((e)localObject).mkdirs();
    }
    this.path = (n.cJt() + "trackroominfolist.info");
    this.handler = new ap(Looper.getMainLooper());
    if (this.sPY == null)
    {
      if (!i.eK(this.path))
      {
        this.sPY = new b();
        AppMethodBeat.o(55772);
        return;
      }
      try
      {
        localObject = i.aR(this.path, 0, -1);
        this.sPY = ((b)new b().parseFrom((byte[])localObject));
        AppMethodBeat.o(55772);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.TrackRoomListMgr", localException, "", new Object[0]);
        this.sPY = new b();
      }
    }
    AppMethodBeat.o(55772);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(182049);
    ad.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[] { Integer.valueOf(paramb.sOs.size()) });
    if (paramb.sOs.isEmpty())
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
  
  private void ag(final String paramString1, final String paramString2, final String paramString3)
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
          localc.zB(paramString1);
          AppMethodBeat.o(55771);
        }
      });
    }
    AppMethodBeat.o(55778);
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
        localObject = this.sPY.sOs.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.location.a.a locala = (com.tencent.mm.plugin.location.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.sPY.sOs.remove(locala);
            a(this.sPY);
            ag(paramString1, paramString3, paramString4);
            AppMethodBeat.o(55777);
            return;
          }
          locala.dqL = paramLinkedList;
          locala.sOr = paramString2;
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
      ((com.tencent.mm.plugin.location.a.a)localObject).dqL = paramLinkedList;
      ((com.tencent.mm.plugin.location.a.a)localObject).sOr = paramString2;
      ((com.tencent.mm.plugin.location.a.a)localObject).latitude = paramDouble1;
      ((com.tencent.mm.plugin.location.a.a)localObject).longitude = paramDouble2;
      this.sPY.sOs.add(localObject);
      label262:
      a(this.sPY);
      ag(paramString1, paramString3, paramString4);
      AppMethodBeat.o(55777);
    }
  }
  
  public final void aBU()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(55784);
        LinkedList localLinkedList = new LinkedList();
        if ((this.sPY.sOs != null) && (!this.sPY.sOs.isEmpty()))
        {
          localObject2 = (com.tencent.mm.plugin.location.a.a[])this.sPY.sOs.toArray(new com.tencent.mm.plugin.location.a.a[0]);
          int k = localObject2.length;
          j = 0;
          if (j < k)
          {
            Object localObject3 = localObject2[j];
            if (bt.gL(localObject3.dqL)) {
              break label227;
            }
            int i = 1;
            Iterator localIterator = localObject3.dqL.iterator();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              ad.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
              if (!str.equals(u.aqG())) {
                break label224;
              }
              ad.i("MicroMsg.TrackRoomListMgr", "reset list info and remove self location info");
              i = 0;
              break label224;
            }
            if (i == 0) {
              break label227;
            }
            localLinkedList.add(localObject3);
            break label227;
          }
        }
        Object localObject2 = new b();
        ((b)localObject2).sOs = localLinkedList;
        ((b)localObject2).sOt = this.sPY.sOt;
        a((b)localObject2);
        AppMethodBeat.o(55784);
        return;
      }
      finally {}
      label224:
      continue;
      label227:
      j += 1;
    }
  }
  
  public final boolean aCk()
  {
    AppMethodBeat.i(55781);
    String str;
    do
    {
      Iterator localIterator = this.sPY.sOs.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (com.tencent.mm.plugin.location.a.a)localIterator.next();
        ad.d("MicroMsg.TrackRoomListMgr", "info :" + ((com.tencent.mm.plugin.location.a.a)localObject).dqL.size());
        localObject = ((com.tencent.mm.plugin.location.a.a)localObject).dqL.iterator();
      }
      str = (String)((Iterator)localObject).next();
      ad.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
    } while (!str.equals(u.aqG()));
    ad.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
    AppMethodBeat.o(55781);
    return true;
    AppMethodBeat.o(55781);
    return false;
  }
  
  public final String aCl()
  {
    if (this.sPY != null) {
      return this.sPY.sOt;
    }
    return "";
  }
  
  /* Error */
  public final com.tencent.mm.plugin.location.a.a aeU(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 284
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 82	com/tencent/mm/plugin/location/model/r:sPY	Lcom/tencent/mm/plugin/location/a/b;
    //   12: getfield 122	com/tencent/mm/plugin/location/a/b:sOs	Ljava/util/LinkedList;
    //   15: invokevirtual 198	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore_3
    //   19: aload_3
    //   20: invokeinterface 164 1 0
    //   25: ifeq +36 -> 61
    //   28: aload_3
    //   29: invokeinterface 168 1 0
    //   34: checkcast 200	com/tencent/mm/plugin/location/a/a
    //   37: astore_2
    //   38: aload_2
    //   39: getfield 203	com/tencent/mm/plugin/location/a/a:username	Ljava/lang/String;
    //   42: aload_1
    //   43: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq -27 -> 19
    //   49: ldc_w 284
    //   52: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: aload_2
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: aconst_null
    //   62: astore_1
    //   63: ldc_w 284
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
  
  public final void aeV(String paramString)
  {
    AppMethodBeat.i(55783);
    if (this.sPY != null) {
      this.sPY.sOt = paramString;
    }
    a(this.sPY);
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
  
  public final boolean bo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55782);
    boolean bool = zz(paramString1).contains(paramString2);
    AppMethodBeat.o(55782);
    return bool;
  }
  
  public final boolean zA(String paramString)
  {
    AppMethodBeat.i(55780);
    if (zz(paramString).size() > 0)
    {
      AppMethodBeat.o(55780);
      return true;
    }
    AppMethodBeat.o(55780);
    return false;
  }
  
  /* Error */
  public final LinkedList<String> zz(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 302
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 82	com/tencent/mm/plugin/location/model/r:sPY	Lcom/tencent/mm/plugin/location/a/b;
    //   12: getfield 122	com/tencent/mm/plugin/location/a/b:sOs	Ljava/util/LinkedList;
    //   15: invokevirtual 198	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface 164 1 0
    //   25: ifeq +45 -> 70
    //   28: aload_2
    //   29: invokeinterface 168 1 0
    //   34: checkcast 200	com/tencent/mm/plugin/location/a/a
    //   37: astore_3
    //   38: aload_3
    //   39: getfield 203	com/tencent/mm/plugin/location/a/a:username	Ljava/lang/String;
    //   42: aload_1
    //   43: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq -27 -> 19
    //   49: aload_3
    //   50: getfield 218	com/tencent/mm/plugin/location/a/a:dqL	Ljava/util/LinkedList;
    //   53: invokevirtual 197	java/util/LinkedList:clone	()Ljava/lang/Object;
    //   56: checkcast 32	java/util/LinkedList
    //   59: astore_1
    //   60: ldc_w 302
    //   63: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    //   70: new 32	java/util/LinkedList
    //   73: dup
    //   74: invokespecial 33	java/util/LinkedList:<init>	()V
    //   77: astore_1
    //   78: ldc_w 302
    //   81: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: goto -18 -> 66
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	r
    //   0	92	1	paramString	String
    //   18	11	2	localIterator	Iterator
    //   37	13	3	locala	com.tencent.mm.plugin.location.a.a
    // Exception table:
    //   from	to	target	type
    //   2	19	87	finally
    //   19	66	87	finally
    //   70	84	87	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.r
 * JD-Core Version:    0.7.0.1
 */