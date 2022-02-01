package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bd.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  implements com.tencent.mm.bd.a
{
  private b Kdz;
  private MMHandler handler;
  private List<c> listeners;
  private final String path;
  
  public p()
  {
    AppMethodBeat.i(55772);
    this.listeners = new LinkedList();
    Object localObject = new u(SubCoreLocation.fUE());
    if (!((u)localObject).jKS()) {
      ((u)localObject).jKY();
    }
    this.path = (SubCoreLocation.fUE() + "trackroominfolist.info");
    this.handler = new MMHandler(Looper.getMainLooper());
    if (this.Kdz == null)
    {
      if (!y.ZC(this.path))
      {
        this.Kdz = new b();
        AppMethodBeat.o(55772);
        return;
      }
      try
      {
        localObject = y.bi(this.path, 0, -1);
        this.Kdz = ((b)new b().parseFrom((byte[])localObject));
        AppMethodBeat.o(55772);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.TrackRoomListMgr", localException, "", new Object[0]);
        this.Kdz = new b();
      }
    }
    AppMethodBeat.o(55772);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(182049);
    Log.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", new Object[] { Integer.valueOf(paramb.KbT.size()) });
    if (paramb.KbT.isEmpty())
    {
      y.deleteFile(this.path);
      AppMethodBeat.o(182049);
      return true;
    }
    try
    {
      paramb = paramb.toByteArray();
      y.f(this.path, paramb, paramb.length);
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
  
  private void aF(final String paramString1, final String paramString2, final String paramString3)
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
          localc.Pz(paramString1);
          AppMethodBeat.o(55771);
        }
      });
    }
    AppMethodBeat.o(55778);
  }
  
  public final LinkedList<String> Px(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(55775);
        Iterator localIterator = this.Kdz.KbT.iterator();
        if (localIterator.hasNext())
        {
          com.tencent.mm.plugin.location.a.a locala = (com.tencent.mm.plugin.location.a.a)localIterator.next();
          if (locala.username.equals(paramString))
          {
            if (v.Iw(paramString))
            {
              paramString = locala;
              if (paramString != null) {
                a(paramString.username, null, 0.0D, 0.0D, "", "", "");
              }
              paramString = new LinkedList();
              AppMethodBeat.o(55775);
              return paramString;
            }
            paramString = (LinkedList)locala.hSk.clone();
            AppMethodBeat.o(55775);
          }
        }
        else
        {
          paramString = null;
        }
      }
      finally {}
    }
  }
  
  public final boolean Py(String paramString)
  {
    AppMethodBeat.i(55780);
    if (Px(paramString).size() > 0)
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
        localObject = this.Kdz.KbT.iterator();
        if (((Iterator)localObject).hasNext())
        {
          com.tencent.mm.plugin.location.a.a locala = (com.tencent.mm.plugin.location.a.a)((Iterator)localObject).next();
          if (!locala.username.equals(paramString1)) {
            continue;
          }
          if (bool)
          {
            this.Kdz.KbT.remove(locala);
            a(this.Kdz);
            aF(paramString1, paramString3, paramString4);
            AppMethodBeat.o(55777);
            return;
          }
          locala.hSk = paramLinkedList;
          locala.KbS = paramString2;
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
      ((com.tencent.mm.plugin.location.a.a)localObject).hSk = paramLinkedList;
      ((com.tencent.mm.plugin.location.a.a)localObject).KbS = paramString2;
      ((com.tencent.mm.plugin.location.a.a)localObject).latitude = paramDouble1;
      ((com.tencent.mm.plugin.location.a.a)localObject).longitude = paramDouble2;
      this.Kdz.KbT.add(localObject);
      label262:
      a(this.Kdz);
      aF(paramString1, paramString3, paramString4);
      AppMethodBeat.o(55777);
    }
  }
  
  /* Error */
  public final com.tencent.mm.plugin.location.a.a aKe(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 250
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 82	com/tencent/mm/plugin/location/model/p:Kdz	Lcom/tencent/mm/plugin/location/a/b;
    //   11: getfield 122	com/tencent/mm/plugin/location/a/b:KbT	Ljava/util/LinkedList;
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
    //   48: ldc 250
    //   50: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_2
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: areturn
    //   59: aconst_null
    //   60: astore_1
    //   61: ldc 250
    //   63: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void aKf(String paramString)
  {
    AppMethodBeat.i(55783);
    if (this.Kdz != null) {
      this.Kdz.KbU = paramString;
    }
    a(this.Kdz);
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
  
  public final boolean bNE()
  {
    AppMethodBeat.i(55781);
    String str;
    do
    {
      Iterator localIterator = this.Kdz.KbT.iterator();
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (com.tencent.mm.plugin.location.a.a)localIterator.next();
        Log.d("MicroMsg.TrackRoomListMgr", "info :" + ((com.tencent.mm.plugin.location.a.a)localObject).hSk.size());
        localObject = ((com.tencent.mm.plugin.location.a.a)localObject).hSk.iterator();
      }
      str = (String)((Iterator)localObject).next();
      Log.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
    } while (!str.equals(z.bAM()));
    Log.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
    AppMethodBeat.o(55781);
    return true;
    AppMethodBeat.o(55781);
    return false;
  }
  
  public final String bNF()
  {
    if (this.Kdz != null) {
      return this.Kdz.KbU;
    }
    return "";
  }
  
  public final void bNo()
  {
    for (;;)
    {
      int j;
      try
      {
        AppMethodBeat.i(55784);
        LinkedList localLinkedList = new LinkedList();
        if ((this.Kdz.KbT != null) && (!this.Kdz.KbT.isEmpty()))
        {
          localObject2 = (com.tencent.mm.plugin.location.a.a[])this.Kdz.KbT.toArray(new com.tencent.mm.plugin.location.a.a[0]);
          int k = localObject2.length;
          j = 0;
          if (j < k)
          {
            Object localObject3 = localObject2[j];
            if (Util.isNullOrNil(localObject3.hSk)) {
              break label230;
            }
            int i = 1;
            Iterator localIterator = localObject3.hSk.iterator();
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              Log.d("MicroMsg.TrackRoomListMgr", "member :".concat(String.valueOf(str)));
              if (!str.equals(z.bAM())) {
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
        ((b)localObject2).KbT = localLinkedList;
        ((b)localObject2).KbU = this.Kdz.KbU;
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
  
  public final boolean bQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(55782);
    boolean bool = Px(paramString1).contains(paramString2);
    AppMethodBeat.o(55782);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.p
 * JD-Core Version:    0.7.0.1
 */