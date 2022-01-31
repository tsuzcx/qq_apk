package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.c;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  implements com.tencent.mm.bh.a
{
  private List<c> aTm;
  private ak handler;
  private com.tencent.mm.plugin.location.a.b oby;
  private final String path;
  
  public p()
  {
    AppMethodBeat.i(113397);
    this.aTm = new LinkedList();
    Object localObject = new com.tencent.mm.vfs.b(l.bLu());
    if (!((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).mkdirs();
    }
    this.path = (l.bLu() + "trackroominfolist.info");
    this.handler = new ak(Looper.getMainLooper());
    if (this.oby == null)
    {
      if (!e.cN(this.path))
      {
        this.oby = new com.tencent.mm.plugin.location.a.b();
        AppMethodBeat.o(113397);
        return;
      }
      try
      {
        localObject = e.i(this.path, 0, -1);
        this.oby = ((com.tencent.mm.plugin.location.a.b)new com.tencent.mm.plugin.location.a.b().parseFrom((byte[])localObject));
        AppMethodBeat.o(113397);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.TrackRoomListMgr", localException, "", new Object[0]);
        this.oby = new com.tencent.mm.plugin.location.a.b();
      }
    }
    AppMethodBeat.o(113397);
  }
  
  private void Y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(113403);
    Iterator localIterator = this.aTm.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      this.handler.post(new p.1(this, localc, paramString1, paramString2, paramString3));
    }
    AppMethodBeat.o(113403);
  }
  
  private boolean bLE()
  {
    AppMethodBeat.i(113404);
    ab.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[] { Integer.valueOf(this.oby.nZS.size()) });
    if (this.oby.nZS.isEmpty())
    {
      e.deleteFile(this.path);
      AppMethodBeat.o(113404);
      return true;
    }
    try
    {
      byte[] arrayOfByte = this.oby.toByteArray();
      e.b(this.path, arrayOfByte, arrayOfByte.length);
      AppMethodBeat.o(113404);
      return true;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.TrackRoomListMgr", localException, "", new Object[0]);
      AppMethodBeat.o(113404);
    }
    return false;
  }
  
  /* Error */
  public final com.tencent.mm.plugin.location.a.a Sa(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 178
    //   4: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 80	com/tencent/mm/plugin/location/model/p:oby	Lcom/tencent/mm/plugin/location/a/b;
    //   11: getfield 147	com/tencent/mm/plugin/location/a/b:nZS	Ljava/util/LinkedList;
    //   14: invokevirtual 179	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   17: astore_3
    //   18: aload_3
    //   19: invokeinterface 124 1 0
    //   24: ifeq +35 -> 59
    //   27: aload_3
    //   28: invokeinterface 128 1 0
    //   33: checkcast 181	com/tencent/mm/plugin/location/a/a
    //   36: astore_2
    //   37: aload_2
    //   38: getfield 184	com/tencent/mm/plugin/location/a/a:username	Ljava/lang/String;
    //   41: aload_1
    //   42: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq -27 -> 18
    //   48: ldc 178
    //   50: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: areturn
    //   59: aconst_null
    //   60: astore_1
    //   61: ldc 178
    //   63: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -11 -> 55
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	p
    //   0	74	1	paramString	String
    //   36	18	2	locala	com.tencent.mm.plugin.location.a.a
    //   17	11	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	18	69	finally
    //   18	53	69	finally
    //   61	66	69	finally
  }
  
  public final void Sb(String paramString)
  {
    AppMethodBeat.i(113408);
    if (this.oby != null) {
      this.oby.nZT = paramString;
    }
    bLE();
    AppMethodBeat.o(113408);
  }
  
  public final void a(c paramc)
  {
    try
    {
      AppMethodBeat.i(113398);
      this.aTm.add(paramc);
      AppMethodBeat.o(113398);
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
        AppMethodBeat.i(113402);
        localObject = paramLinkedList;
        if (paramLinkedList == null) {
          localObject = new LinkedList();
        }
        ab.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", new Object[] { paramString1, Integer.valueOf(((LinkedList)localObject).size()), Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
        paramLinkedList = (LinkedList)((LinkedList)localObject).clone();
        boolean bool = paramLinkedList.isEmpty();
        localObject = this.oby.nZS.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.location.a.a locala = (com.tencent.mm.plugin.location.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.oby.nZS.remove(locala);
            bLE();
            Y(paramString1, paramString3, paramString4);
            AppMethodBeat.o(113402);
            return;
          }
          locala.cAC = paramLinkedList;
          locala.nZR = paramString2;
          locala.latitude = paramDouble1;
          locala.longitude = paramDouble2;
          continue;
        }
        if (bool) {
          break label258;
        }
      }
      finally {}
      Object localObject = new com.tencent.mm.plugin.location.a.a();
      ((com.tencent.mm.plugin.location.a.a)localObject).username = paramString1;
      ((com.tencent.mm.plugin.location.a.a)localObject).cAC = paramLinkedList;
      ((com.tencent.mm.plugin.location.a.a)localObject).nZR = paramString2;
      ((com.tencent.mm.plugin.location.a.a)localObject).latitude = paramDouble1;
      ((com.tencent.mm.plugin.location.a.a)localObject).longitude = paramDouble2;
      this.oby.nZS.add(localObject);
      label258:
      bLE();
      Y(paramString1, paramString3, paramString4);
      AppMethodBeat.o(113402);
    }
  }
  
  public final boolean aY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(113407);
    boolean bool = uN(paramString1).contains(paramString2);
    AppMethodBeat.o(113407);
    return bool;
  }
  
  public final boolean ale()
  {
    AppMethodBeat.i(113406);
    String str;
    do
    {
      Iterator localIterator = this.oby.nZS.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (com.tencent.mm.plugin.location.a.a)localIterator.next();
        ab.d("MicroMsg.TrackRoomListMgr", "info :" + ((com.tencent.mm.plugin.location.a.a)localObject).cAC.size());
        localObject = ((com.tencent.mm.plugin.location.a.a)localObject).cAC.iterator();
      }
      str = (String)((Iterator)localObject).next();
      ab.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
    } while (!str.equals(r.Zn()));
    ab.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
    AppMethodBeat.o(113406);
    return true;
    AppMethodBeat.o(113406);
    return false;
  }
  
  public final String alf()
  {
    if (this.oby != null) {
      return this.oby.nZT;
    }
    return "";
  }
  
  public final void b(c paramc)
  {
    try
    {
      AppMethodBeat.i(113399);
      this.aTm.remove(paramc);
      AppMethodBeat.o(113399);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  /* Error */
  public final LinkedList<String> uN(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 282
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 80	com/tencent/mm/plugin/location/model/p:oby	Lcom/tencent/mm/plugin/location/a/b;
    //   12: getfield 147	com/tencent/mm/plugin/location/a/b:nZS	Ljava/util/LinkedList;
    //   15: invokevirtual 179	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   18: astore_2
    //   19: aload_2
    //   20: invokeinterface 124 1 0
    //   25: ifeq +45 -> 70
    //   28: aload_2
    //   29: invokeinterface 128 1 0
    //   34: checkcast 181	com/tencent/mm/plugin/location/a/a
    //   37: astore_3
    //   38: aload_3
    //   39: getfield 184	com/tencent/mm/plugin/location/a/a:username	Ljava/lang/String;
    //   42: aload_1
    //   43: invokevirtual 190	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq -27 -> 19
    //   49: aload_3
    //   50: getfield 225	com/tencent/mm/plugin/location/a/a:cAC	Ljava/util/LinkedList;
    //   53: invokevirtual 217	java/util/LinkedList:clone	()Ljava/lang/Object;
    //   56: checkcast 30	java/util/LinkedList
    //   59: astore_1
    //   60: ldc_w 282
    //   63: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: areturn
    //   70: new 30	java/util/LinkedList
    //   73: dup
    //   74: invokespecial 31	java/util/LinkedList:<init>	()V
    //   77: astore_1
    //   78: ldc_w 282
    //   81: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: goto -18 -> 66
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	p
    //   0	92	1	paramString	String
    //   18	11	2	localIterator	Iterator
    //   37	13	3	locala	com.tencent.mm.plugin.location.a.a
    // Exception table:
    //   from	to	target	type
    //   2	19	87	finally
    //   19	66	87	finally
    //   70	84	87	finally
  }
  
  public final boolean uO(String paramString)
  {
    AppMethodBeat.i(113405);
    if (uN(paramString).size() > 0)
    {
      AppMethodBeat.o(113405);
      return true;
    }
    AppMethodBeat.o(113405);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.p
 * JD-Core Version:    0.7.0.1
 */