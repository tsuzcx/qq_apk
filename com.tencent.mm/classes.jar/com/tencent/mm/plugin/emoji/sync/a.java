package com.tencent.mm.plugin.emoji.sync;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

public final class a<T extends d>
{
  public BKGLoaderManager jan;
  
  public a()
  {
    b.a locala = new b.a();
    locala.jav = 1;
    locala.eqJ = 10;
    com.tencent.mm.as.a.e.a locala1 = new com.tencent.mm.as.a.e.a();
    locala.jax = new b.b(locala.jav, locala.jav, TimeUnit.MILLISECONDS, locala1, new b.c(locala.eqJ, "bkg_loader_"));
    a(new b(locala));
  }
  
  /* Error */
  private void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	com/tencent/mm/plugin/emoji/sync/a:jan	Lcom/tencent/mm/plugin/emoji/sync/BKGLoaderManager;
    //   6: ifnonnull +18 -> 24
    //   9: aload_0
    //   10: new 62	com/tencent/mm/plugin/emoji/sync/BKGLoaderManager
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 64	com/tencent/mm/plugin/emoji/sync/BKGLoaderManager:<init>	(Lcom/tencent/mm/plugin/emoji/sync/b;)V
    //   18: putfield 60	com/tencent/mm/plugin/emoji/sync/a:jan	Lcom/tencent/mm/plugin/emoji/sync/BKGLoaderManager;
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: ldc 66
    //   26: ldc 68
    //   28: invokestatic 74	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: goto -10 -> 21
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	a
    //   0	39	1	paramb	b
    // Exception table:
    //   from	to	target	type
    //   2	21	34	finally
    //   24	31	34	finally
  }
  
  public final a.a aIm()
  {
    BKGLoaderManager localBKGLoaderManager = this.jan;
    if ((localBKGLoaderManager.jaB) && (localBKGLoaderManager.jaG)) {
      return a.a.jas;
    }
    if ((BKGLoaderManager.aHa()) && (!localBKGLoaderManager.jaB) && (i.getEmojiStorageMgr().uBb.cwQ() > 0)) {
      return a.a.jaq;
    }
    if ((!aq.isConnected(ae.getContext())) && (!localBKGLoaderManager.jaB) && (i.getEmojiStorageMgr().uBb.cwQ() > 0)) {
      return a.a.jar;
    }
    if (aq.isConnected(ae.getContext()))
    {
      if ((localBKGLoaderManager.jaB) && (localBKGLoaderManager.bqV)) {
        return a.a.jap;
      }
      if (localBKGLoaderManager.jaE) {
        return a.a.jat;
      }
    }
    return a.a.jao;
  }
  
  public final void fd(boolean paramBoolean)
  {
    this.jan.bqV = paramBoolean;
  }
  
  public final void u(ArrayList<d> paramArrayList)
  {
    BKGLoaderManager localBKGLoaderManager = this.jan;
    localBKGLoaderManager.jaA = false;
    if (localBKGLoaderManager.jaJ == null) {
      localBKGLoaderManager.jaJ = new Vector();
    }
    if (paramArrayList.size() > 0)
    {
      int j = paramArrayList.size();
      int i = 0;
      if (i < j)
      {
        d locald = (d)paramArrayList.get(i);
        if ((locald != null) && (!localBKGLoaderManager.jaJ.contains(locald))) {
          localBKGLoaderManager.jaJ.add(locald);
        }
        for (;;)
        {
          i += 1;
          break;
          y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", new Object[] { locald.getKey() });
        }
      }
    }
  }
  
  public final void v(ArrayList<d> paramArrayList)
  {
    BKGLoaderManager localBKGLoaderManager = this.jan;
    if (localBKGLoaderManager.jaL == null) {
      localBKGLoaderManager.jaL = new Vector();
    }
    if (paramArrayList.size() > 0)
    {
      int j = paramArrayList.size();
      int i = 0;
      if (i < j)
      {
        Object localObject = (d)paramArrayList.get(i);
        if ((localBKGLoaderManager.jaH != null) && (localBKGLoaderManager.jaH.equals(localObject))) {
          if (localObject == null)
          {
            localObject = "task is null";
            label91:
            y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] currentTask equals task is has exist:%s", new Object[] { localObject });
          }
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = ((d)localObject).getKey();
          break label91;
          if ((localObject == null) || (localBKGLoaderManager.jaL.contains(localObject))) {
            break label156;
          }
          localBKGLoaderManager.jaL.add(localObject);
        }
        label156:
        if (localObject == null) {}
        for (localObject = "task is null";; localObject = ((d)localObject).getKey())
        {
          y.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", new Object[] { localObject });
          break;
        }
      }
    }
  }
  
  public final void w(ArrayList<String> paramArrayList)
  {
    BKGLoaderManager localBKGLoaderManager = this.jan;
    if (paramArrayList == null) {}
    ArrayList localArrayList;
    Object localObject;
    for (int i = 0;; i = paramArrayList.size())
    {
      y.i("MicroMsg.BKGLoader.BKGLoaderManager", "cleanUploadTasks size%s", new Object[] { Integer.valueOf(i) });
      if ((localBKGLoaderManager.jaK == null) || (paramArrayList == null) || (localBKGLoaderManager.jaK.size() <= 0) || (paramArrayList.size() <= 0)) {
        return;
      }
      localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (String)paramArrayList.next();
        if (!bk.bl((String)localObject))
        {
          Iterator localIterator = localBKGLoaderManager.jaK.iterator();
          while (localIterator.hasNext())
          {
            d locald = (d)localIterator.next();
            if ((!bk.bl(locald.getKey())) && (locald.getKey().equalsIgnoreCase((String)localObject))) {
              localArrayList.add(locald);
            }
          }
        }
      }
    }
    if ((localBKGLoaderManager.jaK != null) && (localBKGLoaderManager.jaK.size() > 0) && (localArrayList.size() > 0))
    {
      paramArrayList = localArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (d)paramArrayList.next();
        localBKGLoaderManager.jaK.remove(localObject);
        y.i("MicroMsg.BKGLoader.BKGLoaderManager", "clean upload task :%s", new Object[] { ((d)localObject).getKey() });
      }
    }
    localArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a
 * JD-Core Version:    0.7.0.1
 */