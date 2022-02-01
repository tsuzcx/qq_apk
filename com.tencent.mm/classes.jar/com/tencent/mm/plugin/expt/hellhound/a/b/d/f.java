package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a KIv;
  
  static
  {
    AppMethodBeat.i(205302);
    KIv = new a((byte)0);
    AppMethodBeat.o(205302);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao$Companion;", "", "()V", "MMKV_KEY", "", "MMKV_KEY_WITHOUT_78EVENT", "TAG", "read", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "readWith78Event", "reset", "", "resetWith78Event", "write", "pageStatistics", "writeWith78Event", "plugin-expt_release"})
  public static final class a
  {
    public final void a(ebj paramebj)
    {
      try
      {
        AppMethodBeat.i(205296);
        k.h(paramebj, "pageStatistics");
        try
        {
          b.o("hell_pge_sttics_d", paramebj.toByteArray());
          AppMethodBeat.o(205296);
        }
        catch (Exception paramebj)
        {
          for (;;)
          {
            ad.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)paramebj, "PageStatisticsDao writeBack, exception: " + paramebj.getMessage(), new Object[0]);
            AppMethodBeat.o(205296);
          }
        }
        return;
      }
      finally {}
    }
    
    public final void b(ebj paramebj)
    {
      try
      {
        AppMethodBeat.i(205299);
        k.h(paramebj, "pageStatistics");
        try
        {
          b.o("hell_pge_sttics_d2", paramebj.toByteArray());
          AppMethodBeat.o(205299);
        }
        catch (Exception paramebj)
        {
          for (;;)
          {
            ad.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)paramebj, "PageStatisticsDao writeBack, exception: " + paramebj.getMessage(), new Object[0]);
            AppMethodBeat.o(205299);
          }
        }
        return;
      }
      finally {}
    }
    
    /* Error */
    public final ebj fRM()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 103
      //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: ldc 54
      //   11: invokestatic 107	com/tencent/mm/plugin/expt/hellhound/core/a/b:getBytes	(Ljava/lang/String;)[B
      //   14: astore_3
      //   15: aload_3
      //   16: ifnull +13 -> 29
      //   19: aload_3
      //   20: arraylength
      //   21: ifne +84 -> 105
      //   24: iconst_1
      //   25: istore_1
      //   26: goto +79 -> 105
      //   29: ldc 103
      //   31: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: aconst_null
      //   35: astore_2
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_2
      //   39: areturn
      //   40: new 56	com/tencent/mm/protocal/protobuf/ebj
      //   43: dup
      //   44: invokespecial 108	com/tencent/mm/protocal/protobuf/ebj:<init>	()V
      //   47: astore_2
      //   48: aload_2
      //   49: aload_3
      //   50: invokevirtual 112	com/tencent/mm/protocal/protobuf/ebj:parseFrom	([B)Lcom/tencent/mm/bx/a;
      //   53: pop
      //   54: ldc 103
      //   56: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   59: goto -23 -> 36
      //   62: astore_2
      //   63: aload_0
      //   64: monitorexit
      //   65: aload_2
      //   66: athrow
      //   67: astore_2
      //   68: ldc 70
      //   70: aload_2
      //   71: checkcast 72	java/lang/Throwable
      //   74: new 74	java/lang/StringBuilder
      //   77: dup
      //   78: ldc 114
      //   80: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   83: aload_2
      //   84: invokevirtual 83	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   87: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   93: iconst_0
      //   94: anewarray 4	java/lang/Object
      //   97: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   100: aconst_null
      //   101: astore_2
      //   102: goto -48 -> 54
      //   105: iload_1
      //   106: ifeq -66 -> 40
      //   109: goto -80 -> 29
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	112	0	this	a
      //   1	105	1	i	int
      //   35	14	2	localebj	ebj
      //   62	4	2	localObject1	Object
      //   67	17	2	localException	Exception
      //   101	1	2	localObject2	Object
      //   14	36	3	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   4	15	62	finally
      //   19	24	62	finally
      //   29	34	62	finally
      //   40	48	62	finally
      //   48	54	62	finally
      //   54	59	62	finally
      //   68	100	62	finally
      //   48	54	67	java/lang/Exception
    }
    
    /* Error */
    public final ebj fRN()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 116
      //   6: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: ldc 100
      //   11: invokestatic 107	com/tencent/mm/plugin/expt/hellhound/core/a/b:getBytes	(Ljava/lang/String;)[B
      //   14: astore_3
      //   15: aload_3
      //   16: ifnull +13 -> 29
      //   19: aload_3
      //   20: arraylength
      //   21: ifne +84 -> 105
      //   24: iconst_1
      //   25: istore_1
      //   26: goto +79 -> 105
      //   29: ldc 116
      //   31: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: aconst_null
      //   35: astore_2
      //   36: aload_0
      //   37: monitorexit
      //   38: aload_2
      //   39: areturn
      //   40: new 56	com/tencent/mm/protocal/protobuf/ebj
      //   43: dup
      //   44: invokespecial 108	com/tencent/mm/protocal/protobuf/ebj:<init>	()V
      //   47: astore_2
      //   48: aload_2
      //   49: aload_3
      //   50: invokevirtual 112	com/tencent/mm/protocal/protobuf/ebj:parseFrom	([B)Lcom/tencent/mm/bx/a;
      //   53: pop
      //   54: ldc 116
      //   56: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   59: goto -23 -> 36
      //   62: astore_2
      //   63: aload_0
      //   64: monitorexit
      //   65: aload_2
      //   66: athrow
      //   67: astore_2
      //   68: ldc 70
      //   70: aload_2
      //   71: checkcast 72	java/lang/Throwable
      //   74: new 74	java/lang/StringBuilder
      //   77: dup
      //   78: ldc 114
      //   80: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   83: aload_2
      //   84: invokevirtual 83	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   87: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   93: iconst_0
      //   94: anewarray 4	java/lang/Object
      //   97: invokestatic 96	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   100: aconst_null
      //   101: astore_2
      //   102: goto -48 -> 54
      //   105: iload_1
      //   106: ifeq -66 -> 40
      //   109: goto -80 -> 29
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	112	0	this	a
      //   1	105	1	i	int
      //   35	14	2	localebj	ebj
      //   62	4	2	localObject1	Object
      //   67	17	2	localException	Exception
      //   101	1	2	localObject2	Object
      //   14	36	3	arrayOfByte	byte[]
      // Exception table:
      //   from	to	target	type
      //   4	15	62	finally
      //   19	24	62	finally
      //   29	34	62	finally
      //   40	48	62	finally
      //   48	54	62	finally
      //   54	59	62	finally
      //   68	100	62	finally
      //   48	54	67	java/lang/Exception
    }
    
    public final void fRO()
    {
      try
      {
        AppMethodBeat.i(205301);
        b.o("hell_pge_sttics_d2", new byte[0]);
        AppMethodBeat.o(205301);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public final void reset()
    {
      try
      {
        AppMethodBeat.i(205298);
        b.o("hell_pge_sttics_d", new byte[0]);
        AppMethodBeat.o(205298);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.f
 * JD-Core Version:    0.7.0.1
 */