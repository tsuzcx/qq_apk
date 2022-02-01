package com.tencent.mm.plugin.choosemsgfile.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  public int mMaxCount;
  private Map<Long, MsgFile> opP;
  public boolean opQ;
  private Set<Long> opR;
  
  public a()
  {
    AppMethodBeat.i(123349);
    this.mMaxCount = 2147483647;
    this.opP = new ConcurrentHashMap();
    this.opR = new HashSet();
    AppMethodBeat.o(123349);
  }
  
  public final boolean a(long paramLong, MsgFile paramMsgFile)
  {
    AppMethodBeat.i(123354);
    if (paramLong == -1L)
    {
      ac.e("MicroMsg.ChooseMsgFileHelper", "msgid is invalid");
      AppMethodBeat.o(123354);
      return false;
    }
    if (paramMsgFile == null)
    {
      ac.e("MicroMsg.ChooseMsgFileHelper", "msgFile is null");
      AppMethodBeat.o(123354);
      return false;
    }
    if (bs.isNullOrNil(paramMsgFile.filePath))
    {
      ac.e("MicroMsg.ChooseMsgFileHelper", "filePath is invalid");
      AppMethodBeat.o(123354);
      return false;
    }
    if (bj())
    {
      ac.e("MicroMsg.ChooseMsgFileHelper", "exceed max:%d", new Object[] { Integer.valueOf(this.mMaxCount) });
      AppMethodBeat.o(123354);
      return false;
    }
    if (this.opP == null)
    {
      ac.e("MicroMsg.ChooseMsgFileHelper", "msgIdToMsgFile is null, return");
      AppMethodBeat.o(123354);
      return false;
    }
    ac.i("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath put msgId:%d filePath:%s", new Object[] { Long.valueOf(paramLong), paramMsgFile });
    this.opP.put(Long.valueOf(paramLong), paramMsgFile);
    AppMethodBeat.o(123354);
    return true;
  }
  
  public final boolean bUX()
  {
    AppMethodBeat.i(123353);
    if (this.opP == null)
    {
      ac.e("MicroMsg.ChooseMsgFileHelper", "isChange() msgIdToMsgFile is null, return");
      AppMethodBeat.o(123353);
      return false;
    }
    if ((this.opP.size() == this.mMaxCount - 1) || (this.opP.size() == this.mMaxCount))
    {
      AppMethodBeat.o(123353);
      return true;
    }
    AppMethodBeat.o(123353);
    return false;
  }
  
  public final ArrayList<MsgFile> bUY()
  {
    AppMethodBeat.i(123358);
    if ((this.opP == null) || (this.opP.size() == 0))
    {
      ac.e("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath is null, return");
      AppMethodBeat.o(123358);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.opP.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((MsgFile)localIterator.next());
    }
    AppMethodBeat.o(123358);
    return localArrayList;
  }
  
  /* Error */
  public final boolean bUZ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 148
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 38	com/tencent/mm/plugin/choosemsgfile/b/d/a:opR	Ljava/util/Set;
    //   11: ifnull +26 -> 37
    //   14: aload_0
    //   15: getfield 38	com/tencent/mm/plugin/choosemsgfile/b/d/a:opR	Ljava/util/Set;
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
  
  public final boolean bj()
  {
    AppMethodBeat.i(123352);
    if (this.opP == null)
    {
      ac.e("MicroMsg.ChooseMsgFileHelper", "isInvalid() msgIdToMsgFile is null, return");
      AppMethodBeat.o(123352);
      return false;
    }
    if (this.opP.size() >= this.mMaxCount)
    {
      AppMethodBeat.o(123352);
      return true;
    }
    AppMethodBeat.o(123352);
    return false;
  }
  
  public final int getSelectCount()
  {
    AppMethodBeat.i(123357);
    if (this.opP == null)
    {
      AppMethodBeat.o(123357);
      return 0;
    }
    int i = this.opP.size();
    AppMethodBeat.o(123357);
    return i;
  }
  
  public final void init(int paramInt)
  {
    try
    {
      AppMethodBeat.i(123350);
      ac.i("MicroMsg.ChooseMsgFileHelper", "init count:%d", new Object[] { Integer.valueOf(paramInt) });
      this.mMaxCount = paramInt;
      this.opP.clear();
      AppMethodBeat.o(123350);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean rC(long paramLong)
  {
    AppMethodBeat.i(123355);
    if (paramLong == -1L)
    {
      ac.e("MicroMsg.ChooseMsgFileHelper", "msgid is invalid");
      AppMethodBeat.o(123355);
      return false;
    }
    if (this.opP == null)
    {
      ac.e("MicroMsg.ChooseMsgFileHelper", "msgIdToMsgFile is null, return");
      AppMethodBeat.o(123355);
      return false;
    }
    ac.i("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath remove msgId:%d", new Object[] { Long.valueOf(paramLong) });
    this.opP.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(123355);
    return true;
  }
  
  public final boolean rD(long paramLong)
  {
    AppMethodBeat.i(123356);
    if (this.opP == null)
    {
      AppMethodBeat.o(123356);
      return false;
    }
    boolean bool = this.opP.containsKey(Long.valueOf(paramLong));
    AppMethodBeat.o(123356);
    return bool;
  }
  
  public final void rE(long paramLong)
  {
    try
    {
      AppMethodBeat.i(123359);
      if (this.opR != null) {
        this.opR.add(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(123359);
      return;
    }
    finally {}
  }
  
  public final void rF(long paramLong)
  {
    try
    {
      AppMethodBeat.i(123360);
      if (this.opR != null) {
        this.opR.remove(Long.valueOf(paramLong));
      }
      AppMethodBeat.o(123360);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean rG(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 187
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 38	com/tencent/mm/plugin/choosemsgfile/b/d/a:opR	Ljava/util/Set;
    //   11: ifnull +30 -> 41
    //   14: aload_0
    //   15: getfield 38	com/tencent/mm/plugin/choosemsgfile/b/d/a:opR	Ljava/util/Set;
    //   18: lload_1
    //   19: invokestatic 97	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: invokeinterface 190 2 0
    //   27: ifeq +14 -> 41
    //   30: iconst_1
    //   31: istore_3
    //   32: ldc 187
    //   34: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_3
    //   40: ireturn
    //   41: iconst_0
    //   42: istore_3
    //   43: ldc 187
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
  
  public final void uninit()
  {
    try
    {
      AppMethodBeat.i(123351);
      ac.i("MicroMsg.ChooseMsgFileHelper", "uninit");
      this.opP.clear();
      this.opP = null;
      this.opR.clear();
      this.opR = null;
      AppMethodBeat.o(123351);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.d.a
 * JD-Core Version:    0.7.0.1
 */