package com.tencent.mm.plugin.clean.c;

import android.database.Cursor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.clean.c.a.a.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class c
  implements a.a, Runnable
{
  private static final Long cfe;
  private static final int kGC;
  private static final Long kGq;
  private long endTime;
  private com.tencent.mm.sdk.platformtools.ak faV;
  public boolean isStop;
  private com.tencent.mm.plugin.clean.c.a.b kGD;
  private g kGE;
  private int kGF;
  private int kGG;
  private ConcurrentHashMap<String, b> kGH;
  private long kGI;
  private long kGJ;
  private HashSet<String> kGK;
  private HashSet<String> kGL;
  private boolean kGM;
  private int[] kGN;
  private long kGs;
  private long kGt;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(18693);
    cfe = Long.valueOf(604800000L);
    kGq = Long.valueOf(7776000000L);
    aw.aaz();
    kGC = com.tencent.mm.model.c.getAccPath().length() - 1;
    AppMethodBeat.o(18693);
  }
  
  public c(com.tencent.mm.plugin.clean.c.a.b paramb, g paramg)
  {
    AppMethodBeat.i(18679);
    this.kGF = 0;
    this.kGG = 0;
    this.startTime = 0L;
    this.endTime = 0L;
    this.faV = new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper());
    this.kGK = new HashSet();
    this.kGL = new HashSet();
    this.kGM = true;
    this.kGN = new int[10];
    this.kGH = new ConcurrentHashMap();
    this.kGE = paramg;
    this.kGD = paramb;
    AppMethodBeat.o(18679);
  }
  
  private static ArrayList<String> Jf(String paramString)
  {
    AppMethodBeat.i(18686);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new com.tencent.mm.vfs.b(paramString);
    if (((com.tencent.mm.vfs.b)localObject).isDirectory())
    {
      localObject = ((com.tencent.mm.vfs.b)localObject).list();
      int j;
      int i;
      if ((localObject != null) && (localObject.length > 0))
      {
        j = localObject.length;
        i = 0;
      }
      while (i < j)
      {
        String str = localObject[i];
        localArrayList.add(paramString + "/" + str);
        i += 1;
        continue;
        localArrayList.add(paramString);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(18686);
      return localArrayList;
      localArrayList.add(paramString);
    }
  }
  
  private void bgH()
  {
    AppMethodBeat.i(18682);
    this.endTime = System.currentTimeMillis();
    ab.i("MicroMsg.CleanController", "totalUserTime:%d", new Object[] { Long.valueOf(bgI()) });
    if ((this.kGE != null) && (!this.isStop))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.kGH.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((b)localIterator.next());
      }
      Collections.sort(localArrayList);
      Collections.reverse(localArrayList);
      this.faV.post(new c.1(this, localArrayList));
    }
    AppMethodBeat.o(18682);
  }
  
  private long bgI()
  {
    return this.endTime - this.startTime;
  }
  
  public static long bgJ()
  {
    AppMethodBeat.i(18683);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.eQx);
      l = localStatFs.getBlockCount();
      int i = localStatFs.getBlockSize();
      l = i * l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l = 0L;
      }
      AppMethodBeat.o(18683);
    }
    if (l <= 0L)
    {
      AppMethodBeat.o(18683);
      return 1L;
    }
    return l;
  }
  
  public static long bgK()
  {
    AppMethodBeat.i(18684);
    long l;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.eQx);
      l = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      l = i * l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l = 0L;
      }
      AppMethodBeat.o(18684);
    }
    if (l <= 0L)
    {
      AppMethodBeat.o(18684);
      return 1L;
    }
    return l;
  }
  
  private static ArrayList<String> bgL()
  {
    AppMethodBeat.i(18685);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new LinkedList();
    Object localObject2 = t.fll;
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      ((LinkedList)localObject1).add(localObject2[i]);
      i += 1;
    }
    aw.aaz();
    localObject1 = com.tencent.mm.model.c.YF().c(t.flc, (List)localObject1, "*");
    if (((Cursor)localObject1).moveToFirst()) {
      do
      {
        localObject2 = new com.tencent.mm.storage.ak();
        ((com.tencent.mm.storage.ak)localObject2).convertFrom((Cursor)localObject1);
        if (!bo.isNullOrNil(((au)localObject2).field_username))
        {
          aw.aaz();
          if (!ad.Nt(com.tencent.mm.model.c.YA().arw(((au)localObject2).field_username).field_verifyFlag)) {
            localArrayList.add(((au)localObject2).field_username);
          }
        }
      } while ((((Cursor)localObject1).moveToNext()) && (!((Cursor)localObject1).isAfterLast()));
    }
    ((Cursor)localObject1).close();
    AppMethodBeat.o(18685);
    return localArrayList;
  }
  
  /* Error */
  private void ip(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 18687
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: lload_1
    //   9: lconst_0
    //   10: lcmp
    //   11: ifge +43 -> 54
    //   14: ldc 199
    //   16: ldc_w 558
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: lload_1
    //   26: invokestatic 60	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   29: aastore
    //   30: invokestatic 561	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 323	com/tencent/mm/plugin/clean/c/c:kGJ	J
    //   38: ldc2_w 562
    //   41: ladd
    //   42: putfield 323	com/tencent/mm/plugin/clean/c/c:kGJ	J
    //   45: sipush 18687
    //   48: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 323	com/tencent/mm/plugin/clean/c/c:kGJ	J
    //   59: lload_1
    //   60: ladd
    //   61: putfield 323	com/tencent/mm/plugin/clean/c/c:kGJ	J
    //   64: sipush 18687
    //   67: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -19 -> 51
    //   73: astore_3
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_3
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	c
    //   0	78	1	paramLong	long
    //   73	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	73	finally
    //   14	51	73	finally
    //   54	70	73	finally
  }
  
  public final void a(com.tencent.mm.plugin.clean.c.a.a parama)
  {
    AppMethodBeat.i(18681);
    if ((parama instanceof c.a)) {
      ab.d("MicroMsg.CleanController", "AnalyseTask is finish [%d] cost[%s]", new Object[] { Integer.valueOf(parama.hashCode()), parama.alu() });
    }
    for (;;)
    {
      d.ysm.remove(this);
      this.isStop = true;
      this.kGG += 1;
      if ((this.kGE != null) && (!this.isStop)) {
        this.faV.post(new c.2(this));
      }
      if (this.kGG == this.kGF) {
        bgH();
      }
      AppMethodBeat.o(18681);
      return;
      ab.d("MicroMsg.CleanController", "ScanSpaceTask is finish [%d] cost[%s]", new Object[] { Integer.valueOf(parama.hashCode()), parama.alu() });
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(18680);
    ab.i("MicroMsg.CleanController", "Start to run clean controller");
    this.startTime = System.currentTimeMillis();
    long l = bo.yB();
    Object localObject2 = com.tencent.mm.compatible.util.e.eQz;
    ab.v("MicroMsg.CleanController", "root path: %s", new Object[] { localObject2 });
    Object localObject1 = new StringBuilder("mm");
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RJ();
    Object localObject3 = com.tencent.mm.a.g.w(com.tencent.mm.kernel.a.getUin().getBytes());
    localObject1 = new ArrayList();
    Object localObject4 = new com.tencent.mm.vfs.b((String)localObject2);
    if (((com.tencent.mm.vfs.b)localObject4).isDirectory())
    {
      localObject4 = ((com.tencent.mm.vfs.b)localObject4).list();
      if (localObject4 != null)
      {
        j = localObject4.length;
        i = 0;
        if (i < j)
        {
          String str = localObject4[i];
          Object localObject5 = (String)localObject2 + str;
          if (str.length() >= 32)
          {
            ab.v("MicroMsg.CleanController", "add subfile list: %s uinPath %s ", new Object[] { str, localObject3 });
            localObject5 = Jf((String)localObject5);
            if (((ArrayList)localObject1).size() > 0)
            {
              if (!((String)localObject3).equals(str))
              {
                ab.i("MicroMsg.CleanController", "add other acc tmp path %s", new Object[] { str });
                this.kGK.add(str);
              }
              ((ArrayList)localObject1).addAll(0, (Collection)localObject5);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((ArrayList)localObject1).addAll((Collection)localObject5);
            continue;
            ab.v("MicroMsg.CleanController", "subfile: %s", new Object[] { str });
            if (((ArrayList)localObject1).size() > 0) {
              ((ArrayList)localObject1).add(0, localObject5);
            } else {
              ((ArrayList)localObject1).add(localObject5);
            }
          }
        }
      }
    }
    else
    {
      ip(com.tencent.mm.vfs.e.avI((String)localObject2));
    }
    int k = -1;
    int j = -1;
    int i = 0;
    while (i < ((ArrayList)localObject1).size())
    {
      localObject2 = (String)((ArrayList)localObject1).get(i);
      if (((String)localObject2).contains("image2")) {
        k = i;
      }
      if (((String)localObject2).contains("voice2")) {
        j = i;
      }
      i += 1;
    }
    if (j != -1) {
      ((ArrayList)localObject1).add(0, (String)((ArrayList)localObject1).remove(j));
    }
    if (k != -1) {
      ((ArrayList)localObject1).add(0, (String)((ArrayList)localObject1).remove(k));
    }
    ab.d("MicroMsg.CleanController", "scan is finish [%s]", new Object[] { Long.valueOf(bo.av(l)) });
    l = bo.yB();
    localObject2 = bgL();
    ab.d("MicroMsg.CleanController", "user is finish [%s]", new Object[] { Long.valueOf(bo.av(l)) });
    this.kGF = (((ArrayList)localObject1).size() + ((ArrayList)localObject2).size());
    if (this.kGF == 0)
    {
      ab.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=0");
      bgH();
      AppMethodBeat.o(18680);
      return;
    }
    ab.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=%d", new Object[] { Integer.valueOf(this.kGF) });
    i = 0;
    while ((!this.isStop) && (i < ((ArrayList)localObject1).size()))
    {
      localObject3 = (String)((ArrayList)localObject1).get(i);
      ab.d("MicroMsg.CleanController", "while loop index=%d | filePath=%s", new Object[] { Integer.valueOf(i), localObject3 });
      localObject4 = new c.b(this, (String)localObject3);
      while (!this.kGD.b((com.tencent.mm.plugin.clean.c.a.a)localObject4)) {
        try
        {
          Thread.sleep(2147483647L);
        }
        catch (InterruptedException localInterruptedException2) {}
      }
      ab.d("MicroMsg.CleanController", "Start task： filePath＝%s", new Object[] { localObject3 });
      i += 1;
    }
    i = 0;
    while ((!this.isStop) && (i < ((ArrayList)localObject2).size()))
    {
      localObject1 = (String)((ArrayList)localObject2).get(i);
      ab.d("MicroMsg.CleanController", "while loop index=%d | username=%s", new Object[] { Integer.valueOf(i), localObject1 });
      localObject3 = new c.a(this, (String)localObject1);
      while (!this.kGD.b((com.tencent.mm.plugin.clean.c.a.a)localObject3)) {
        try
        {
          Thread.sleep(2147483647L);
        }
        catch (InterruptedException localInterruptedException1) {}
      }
      ab.d("MicroMsg.CleanController", "Start task： user＝%s", new Object[] { localObject1 });
      i += 1;
    }
    AppMethodBeat.o(18680);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.c
 * JD-Core Version:    0.7.0.1
 */