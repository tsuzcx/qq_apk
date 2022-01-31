package com.tencent.mm.plugin.choosemsgfile.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<Long, MsgFile> kFP;
  public boolean kFQ;
  private Set<Long> kFR;
  public int mMaxCount;
  
  public a()
  {
    AppMethodBeat.i(54378);
    this.mMaxCount = 2147483647;
    this.kFP = new ConcurrentHashMap();
    this.kFR = new HashSet();
    AppMethodBeat.o(54378);
  }
  
  public final boolean a(long paramLong, MsgFile paramMsgFile)
  {
    AppMethodBeat.i(54383);
    if (paramLong == -1L)
    {
      ab.e("MicroMsg.ChooseMsgFileHelper", "msgid is invalid");
      AppMethodBeat.o(54383);
      return false;
    }
    if (paramMsgFile == null)
    {
      ab.e("MicroMsg.ChooseMsgFileHelper", "msgFile is null");
      AppMethodBeat.o(54383);
      return false;
    }
    if (bo.isNullOrNil(paramMsgFile.filePath))
    {
      ab.e("MicroMsg.ChooseMsgFileHelper", "filePath is invalid");
      AppMethodBeat.o(54383);
      return false;
    }
    if (jU())
    {
      ab.e("MicroMsg.ChooseMsgFileHelper", "exceed max:%d", new Object[] { Integer.valueOf(this.mMaxCount) });
      AppMethodBeat.o(54383);
      return false;
    }
    if (this.kFP == null)
    {
      ab.e("MicroMsg.ChooseMsgFileHelper", "msgIdToMsgFile is null, return");
      AppMethodBeat.o(54383);
      return false;
    }
    ab.i("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath put msgId:%d filePath:%s", new Object[] { Long.valueOf(paramLong), paramMsgFile });
    this.kFP.put(Long.valueOf(paramLong), paramMsgFile);
    AppMethodBeat.o(54383);
    return true;
  }
  
  public final boolean bgB()
  {
    AppMethodBeat.i(54382);
    if (this.kFP == null)
    {
      ab.e("MicroMsg.ChooseMsgFileHelper", "isChange() msgIdToMsgFile is null, return");
      AppMethodBeat.o(54382);
      return false;
    }
    if ((this.kFP.size() == this.mMaxCount - 1) || (this.kFP.size() == this.mMaxCount))
    {
      AppMethodBeat.o(54382);
      return true;
    }
    AppMethodBeat.o(54382);
    return false;
  }
  
  public final ArrayList<MsgFile> bgC()
  {
    AppMethodBeat.i(54387);
    if ((this.kFP == null) || (this.kFP.size() == 0))
    {
      ab.e("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath is null, return");
      AppMethodBeat.o(54387);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.kFP.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((MsgFile)localIterator.next());
    }
    AppMethodBeat.o(54387);
    return localArrayList;
  }
  
  /* Error */
  public final boolean bgD()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 148
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 38	com/tencent/mm/plugin/choosemsgfile/b/d/a:kFR	Ljava/util/Set;
    //   11: ifnull +26 -> 37
    //   14: aload_0
    //   15: getfield 38	com/tencent/mm/plugin/choosemsgfile/b/d/a:kFR	Ljava/util/Set;
    //   18: invokeinterface 151 1 0
    //   23: ifle +14 -> 37
    //   26: iconst_1
    //   27: istore_1
    //   28: ldc 148
    //   30: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_1
    //   36: ireturn
    //   37: iconst_0
    //   38: istore_1
    //   39: ldc 148
    //   41: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: goto -11 -> 33
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	a
    //   27	12	1	bool	boolean
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	47	finally
    //   28	33	47	finally
    //   39	44	47	finally
  }
  
  public final int getSelectCount()
  {
    AppMethodBeat.i(54386);
    if (this.kFP == null)
    {
      AppMethodBeat.o(54386);
      return 0;
    }
    int i = this.kFP.size();
    AppMethodBeat.o(54386);
    return i;
  }
  
  public final boolean ii(long paramLong)
  {
    AppMethodBeat.i(54384);
    if (paramLong == -1L)
    {
      ab.e("MicroMsg.ChooseMsgFileHelper", "msgid is invalid");
      AppMethodBeat.o(54384);
      return false;
    }
    if (this.kFP == null)
    {
      ab.e("MicroMsg.ChooseMsgFileHelper", "msgIdToMsgFile is null, return");
      AppMethodBeat.o(54384);
      return false;
    }
    ab.i("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath remove msgId:%d", new Object[] { Long.valueOf(paramLong) });
    this.kFP.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(54384);
    return true;
  }
  
  public final boolean ij(long paramLong)
  {
    AppMethodBeat.i(54385);
    if (this.kFP == null)
    {
      AppMethodBeat.o(54385);
      return false;
    }
    boolean bool = this.kFP.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(54385);
    return bool;
  }
  
  public final void ik(long paramLong)
  {
    try
    {
      AppMethodBeat.i(54388);
      if (this.kFR != null) {
        this.kFR.add(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(54388);
      return;
    }
    finally {}
  }
  
  public final void il(long paramLong)
  {
    try
    {
      AppMethodBeat.i(54389);
      if (this.kFR != null) {
        this.kFR.remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(54389);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean im(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 177
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 38	com/tencent/mm/plugin/choosemsgfile/b/d/a:kFR	Ljava/util/Set;
    //   11: ifnull +30 -> 41
    //   14: aload_0
    //   15: getfield 38	com/tencent/mm/plugin/choosemsgfile/b/d/a:kFR	Ljava/util/Set;
    //   18: lload_1
    //   19: invokestatic 97	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: invokeinterface 180 2 0
    //   27: ifeq +14 -> 41
    //   30: iconst_1
    //   31: istore_3
    //   32: ldc 177
    //   34: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_3
    //   40: ireturn
    //   41: iconst_0
    //   42: istore_3
    //   43: ldc 177
    //   45: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: goto -11 -> 37
    //   51: astore 4
    //   53: aload_0
    //   54: monitorexit
    //   55: aload 4
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	a
    //   0	58	1	paramLong	long
    //   31	12	3	bool	boolean
    //   51	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	51	finally
    //   32	37	51	finally
    //   43	48	51	finally
  }
  
  public final void init(int paramInt)
  {
    try
    {
      AppMethodBeat.i(54379);
      ab.i("MicroMsg.ChooseMsgFileHelper", "init count:%d", new Object[] { Integer.valueOf(paramInt) });
      this.mMaxCount = paramInt;
      this.kFP.clear();
      AppMethodBeat.o(54379);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean jU()
  {
    AppMethodBeat.i(54381);
    if (this.kFP == null)
    {
      ab.e("MicroMsg.ChooseMsgFileHelper", "isInvalid() msgIdToMsgFile is null, return");
      AppMethodBeat.o(54381);
      return false;
    }
    if (this.kFP.size() >= this.mMaxCount)
    {
      AppMethodBeat.o(54381);
      return true;
    }
    AppMethodBeat.o(54381);
    return false;
  }
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(54380);
      ab.i("MicroMsg.ChooseMsgFileHelper", "uninit");
      this.kFP.clear();
      this.kFP = null;
      this.kFR.clear();
      this.kFR = null;
      AppMethodBeat.o(54380);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.d.a
 * JD-Core Version:    0.7.0.1
 */