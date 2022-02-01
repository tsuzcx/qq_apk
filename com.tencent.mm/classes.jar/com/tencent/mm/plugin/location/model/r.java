package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  implements com.tencent.mm.bi.a
{
  private aq handler;
  private List<c> listeners;
  private final String path;
  private b vnf;
  
  public r()
  {
    AppMethodBeat.i(55772);
    this.listeners = new LinkedList();
    Object localObject = new k(n.djj());
    if (!((k)localObject).exists()) {
      ((k)localObject).mkdirs();
    }
    this.path = (n.djj() + "trackroominfolist.info");
    this.handler = new aq(Looper.getMainLooper());
    if (this.vnf == null)
    {
      if (!o.fB(this.path))
      {
        this.vnf = new b();
        AppMethodBeat.o(55772);
        return;
      }
      try
      {
        localObject = o.bb(this.path, 0, -1);
        this.vnf = ((b)new b().parseFrom((byte[])localObject));
        AppMethodBeat.o(55772);
        return;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.TrackRoomListMgr", localException, "", new Object[0]);
        this.vnf = new b();
      }
    }
    AppMethodBeat.o(55772);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(182049);
    ae.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[] { Integer.valueOf(paramb.vlz.size()) });
    if (paramb.vlz.isEmpty())
    {
      o.deleteFile(this.path);
      AppMethodBeat.o(182049);
      return true;
    }
    try
    {
      paramb = paramb.toByteArray();
      o.f(this.path, paramb, paramb.length);
      AppMethodBeat.o(182049);
      return true;
    }
    catch (Exception paramb)
    {
      ae.printErrStackTrace("MicroMsg.TrackRoomListMgr", paramb, "", new Object[0]);
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
          localc.Hn(paramString1);
          AppMethodBeat.o(55771);
        }
      });
    }
    AppMethodBeat.o(55778);
  }
  
  /* Error */
  public final LinkedList<String> Hl(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 180
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 82	com/tencent/mm/plugin/location/model/r:vnf	Lcom/tencent/mm/plugin/location/a/b;
    //   11: getfield 122	com/tencent/mm/plugin/location/a/b:vlz	Ljava/util/LinkedList;
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
    //   49: getfield 195	com/tencent/mm/plugin/location/a/a:dBp	Ljava/util/LinkedList;
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
  
  public final boolean Hm(String paramString)
  {
    AppMethodBeat.i(55780);
    if (Hl(paramString).size() > 0)
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
        ae.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", new Object[] { paramString1, Integer.valueOf(((LinkedList)localObject).size()), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
        paramLinkedList = (LinkedList)((LinkedList)localObject).clone();
        boolean bool = paramLinkedList.isEmpty();
        localObject = this.vnf.vlz.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.location.a.a locala = (com.tencent.mm.plugin.location.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.vnf.vlz.remove(locala);
            a(this.vnf);
            ao(paramString1, paramString3, paramString4);
            AppMethodBeat.o(55777);
            return;
          }
          locala.dBp = paramLinkedList;
          locala.vly = paramString2;
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
      ((com.tencent.mm.plugin.location.a.a)localObject).dBp = paramLinkedList;
      ((com.tencent.mm.plugin.location.a.a)localObject).vly = paramString2;
      ((com.tencent.mm.plugin.location.a.a)localObject).latitude = paramDouble1;
      ((com.tencent.mm.plugin.location.a.a)localObject).longitude = paramDouble2;
      this.vnf.vlz.add(localObject);
      label262:
      a(this.vnf);
      ao(paramString1, paramString3, paramString4);
      AppMethodBeat.o(55777);
    }
  }
  
  public final boolean aMI()
  {
    AppMethodBeat.i(55781);
    String str;
    do
    {
      Iterator localIterator = this.vnf.vlz.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (com.tencent.mm.plugin.location.a.a)localIterator.next();
        ae.d("MicroMsg.TrackRoomListMgr", "info :" + ((com.tencent.mm.plugin.location.a.a)localObject).dBp.size());
        localObject = ((com.tencent.mm.plugin.location.a.a)localObject).dBp.iterator();
      }
      str = (String)((Iterator)localObject).next();
      ae.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
    } while (!str.equals(v.aAC()));
    ae.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
    AppMethodBeat.o(55781);
    return true;
    AppMethodBeat.o(55781);
    return false;
  }
  
  public final String aMJ()
  {
    if (this.vnf != null) {
      return this.vnf.vlA;
    }
    return "";
  }
  
  public final void aMr()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(55784);
        LinkedList localLinkedList = new LinkedList();
        if ((this.vnf.vlz != null) && (!this.vnf.vlz.isEmpty()))
        {
          localObject2 = (com.tencent.mm.plugin.location.a.a[])this.vnf.vlz.toArray(new com.tencent.mm.plugin.location.a.a[0]);
          int k = localObject2.length;
          j = 0;
          if (j < k)
          {
            Object localObject3 = localObject2[j];
            if (bu.ht(localObject3.dBp)) {
              break label229;
            }
            int i = 1;
            Iterator localIterator = localObject3.dBp.iterator();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              ae.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
              if (!str.equals(v.aAC())) {
                break label226;
              }
              ae.i("MicroMsg.TrackRoomListMgr", "reset list info and remove self location info");
              i = 0;
              break label226;
            }
            if (i == 0) {
              break label229;
            }
            localLinkedList.add(localObject3);
            break label229;
          }
        }
        Object localObject2 = new b();
        ((b)localObject2).vlz = localLinkedList;
        ((b)localObject2).vlA = this.vnf.vlA;
        a((b)localObject2);
        AppMethodBeat.o(55784);
        return;
      }
      finally {}
      label226:
      continue;
      label229:
      j += 1;
    }
  }
  
  /* Error */
  public final com.tencent.mm.plugin.location.a.a apG(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 292
    //   5: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 82	com/tencent/mm/plugin/location/model/r:vnf	Lcom/tencent/mm/plugin/location/a/b;
    //   12: getfield 122	com/tencent/mm/plugin/location/a/b:vlz	Ljava/util/LinkedList;
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
  
  public final void apH(String paramString)
  {
    AppMethodBeat.i(55783);
    if (this.vnf != null) {
      this.vnf.vlA = paramString;
    }
    a(this.vnf);
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
    boolean bool = Hl(paramString1).contains(paramString2);
    AppMethodBeat.o(55782);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.r
 * JD-Core Version:    0.7.0.1
 */