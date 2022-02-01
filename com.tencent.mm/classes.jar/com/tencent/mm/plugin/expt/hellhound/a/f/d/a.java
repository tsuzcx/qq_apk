package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  /* Error */
  static void a(cbl paramcbl)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 7
    //   5: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnonnull +12 -> 21
    //   12: ldc 7
    //   14: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: invokestatic 19	com/tencent/mm/plugin/expt/hellhound/a/f/d/a:b	(Lcom/tencent/mm/protocal/protobuf/cbl;)V
    //   25: ldc 7
    //   27: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: goto -13 -> 17
    //   33: astore_0
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	paramcbl	cbl
    // Exception table:
    //   from	to	target	type
    //   3	8	33	finally
    //   12	17	33	finally
    //   21	30	33	finally
  }
  
  private static void b(cbl paramcbl)
  {
    AppMethodBeat.i(122171);
    try
    {
      b.o("mmkv_key_hell_PFLOW", paramcbl.toByteArray());
      AppMethodBeat.o(122171);
      return;
    }
    catch (Exception paramcbl)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellPageFlowDao", paramcbl, "HellPageFlowDao.writeBack crash: %s", new Object[] { paramcbl.getMessage() });
      AppMethodBeat.o(122171);
    }
  }
  
  public static cbl cQH()
  {
    try
    {
      AppMethodBeat.i(122170);
      cbl localcbl2 = cQI();
      cbl localcbl1 = localcbl2;
      if (localcbl2 == null)
      {
        localcbl1 = new cbl();
        b(localcbl1);
      }
      AppMethodBeat.o(122170);
      return localcbl1;
    }
    finally {}
  }
  
  private static cbl cQI()
  {
    AppMethodBeat.i(122172);
    byte[] arrayOfByte = b.getBytes("mmkv_key_hell_PFLOW");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122172);
      return null;
    }
    cbl localcbl = new cbl();
    try
    {
      localcbl.parseFrom(arrayOfByte);
      AppMethodBeat.o(122172);
      return localcbl;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellPageFlowDao", localException, "HellPageFlowDao.read crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(122172);
    }
    return null;
  }
  
  public static void reset()
  {
    try
    {
      AppMethodBeat.i(122173);
      long l = System.currentTimeMillis();
      b.o("mmkv_key_hell_PFLOW", new byte[0]);
      Log.i("HABBYGE-MALI.HellPageFlowDao", "HellPageFlowDao-reset-time: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(122173);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.d.a
 * JD-Core Version:    0.7.0.1
 */