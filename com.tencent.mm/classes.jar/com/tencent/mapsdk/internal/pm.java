package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class pm
  implements es
{
  private ArrayList<es> a;
  
  public pm()
  {
    AppMethodBeat.i(225843);
    this.a = new ArrayList();
    AppMethodBeat.o(225843);
  }
  
  public final void a()
  {
    AppMethodBeat.i(225879);
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      ((es)this.a.get(i)).a();
      i -= 1;
    }
    AppMethodBeat.o(225879);
  }
  
  public final void a(es parames)
  {
    try
    {
      AppMethodBeat.i(225851);
      if ((parames != null) && (!this.a.contains(parames))) {
        this.a.add(parames);
      }
      AppMethodBeat.o(225851);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 51
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_2
    //   17: iload_2
    //   18: iflt +41 -> 59
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_2
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: invokeinterface 53 2 0
    //   38: ifeq +14 -> 52
    //   41: iconst_1
    //   42: istore_3
    //   43: ldc 51
    //   45: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: iload_3
    //   51: ireturn
    //   52: iload_2
    //   53: iconst_1
    //   54: isub
    //   55: istore_2
    //   56: goto -39 -> 17
    //   59: iconst_0
    //   60: istore_3
    //   61: ldc 51
    //   63: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -18 -> 48
    //   69: astore 4
    //   71: aload_0
    //   72: monitorexit
    //   73: aload 4
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	pm
    //   0	76	1	paramFloat	float
    //   16	40	2	i	int
    //   42	19	3	bool	boolean
    //   69	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	69	finally
    //   21	41	69	finally
    //   43	48	69	finally
    //   61	66	69	finally
  }
  
  /* Error */
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 55
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_3
    //   17: iload_3
    //   18: iflt +44 -> 62
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_3
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: fload_2
    //   34: invokeinterface 57 3 0
    //   39: ifeq +16 -> 55
    //   42: iconst_1
    //   43: istore 4
    //   45: ldc 55
    //   47: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 4
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: isub
    //   58: istore_3
    //   59: goto -42 -> 17
    //   62: iconst_0
    //   63: istore 4
    //   65: ldc 55
    //   67: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -20 -> 50
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	pm
    //   0	80	1	paramFloat1	float
    //   0	80	2	paramFloat2	float
    //   16	43	3	i	int
    //   43	21	4	bool	boolean
    //   73	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	73	finally
    //   21	42	73	finally
    //   45	50	73	finally
    //   65	70	73	finally
  }
  
  /* Error */
  public final boolean a(android.graphics.PointF paramPointF1, android.graphics.PointF paramPointF2, double paramDouble1, double paramDouble2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 59
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore 7
    //   18: iload 7
    //   20: iflt +50 -> 70
    //   23: aload_0
    //   24: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   27: iload 7
    //   29: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   32: checkcast 6	com/tencent/mapsdk/internal/es
    //   35: aload_1
    //   36: aload_2
    //   37: dload_3
    //   38: dload 5
    //   40: invokeinterface 61 7 0
    //   45: ifeq +16 -> 61
    //   48: iconst_1
    //   49: istore 8
    //   51: ldc 59
    //   53: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aload_0
    //   57: monitorexit
    //   58: iload 8
    //   60: ireturn
    //   61: iload 7
    //   63: iconst_1
    //   64: isub
    //   65: istore 7
    //   67: goto -49 -> 18
    //   70: iconst_0
    //   71: istore 8
    //   73: ldc 59
    //   75: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: goto -22 -> 56
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	pm
    //   0	86	1	paramPointF1	android.graphics.PointF
    //   0	86	2	paramPointF2	android.graphics.PointF
    //   0	86	3	paramDouble1	double
    //   0	86	5	paramDouble2	double
    //   16	50	7	i	int
    //   49	23	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	81	finally
    //   23	48	81	finally
    //   51	56	81	finally
    //   73	78	81	finally
  }
  
  /* Error */
  public final boolean a(android.graphics.PointF paramPointF1, android.graphics.PointF paramPointF2, float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 63
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore 4
    //   18: iload 4
    //   20: iflt +48 -> 68
    //   23: aload_0
    //   24: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   27: iload 4
    //   29: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   32: checkcast 6	com/tencent/mapsdk/internal/es
    //   35: aload_1
    //   36: aload_2
    //   37: fload_3
    //   38: invokeinterface 65 4 0
    //   43: ifeq +16 -> 59
    //   46: iconst_1
    //   47: istore 5
    //   49: ldc 63
    //   51: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: aload_0
    //   55: monitorexit
    //   56: iload 5
    //   58: ireturn
    //   59: iload 4
    //   61: iconst_1
    //   62: isub
    //   63: istore 4
    //   65: goto -47 -> 18
    //   68: iconst_0
    //   69: istore 5
    //   71: ldc 63
    //   73: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -22 -> 54
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	pm
    //   0	84	1	paramPointF1	android.graphics.PointF
    //   0	84	2	paramPointF2	android.graphics.PointF
    //   0	84	3	paramFloat	float
    //   16	48	4	i	int
    //   47	23	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	18	79	finally
    //   23	46	79	finally
    //   49	54	79	finally
    //   71	76	79	finally
  }
  
  public final void b(es parames)
  {
    try
    {
      AppMethodBeat.i(225857);
      this.a.remove(parames);
      AppMethodBeat.o(225857);
      return;
    }
    finally
    {
      parames = finally;
      throw parames;
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 72
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_1
    //   17: iload_1
    //   18: iflt +40 -> 58
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_1
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: invokeinterface 74 1 0
    //   37: ifeq +14 -> 51
    //   40: iconst_1
    //   41: istore_2
    //   42: ldc 72
    //   44: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_2
    //   50: ireturn
    //   51: iload_1
    //   52: iconst_1
    //   53: isub
    //   54: istore_1
    //   55: goto -38 -> 17
    //   58: iconst_0
    //   59: istore_2
    //   60: ldc 72
    //   62: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -18 -> 47
    //   68: astore_3
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	pm
    //   16	39	1	i	int
    //   41	19	2	bool	boolean
    //   68	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	68	finally
    //   21	40	68	finally
    //   42	47	68	finally
    //   60	65	68	finally
  }
  
  /* Error */
  public final boolean b(float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 75
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_2
    //   17: iload_2
    //   18: iflt +41 -> 59
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_2
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: invokeinterface 77 2 0
    //   38: ifeq +14 -> 52
    //   41: iconst_1
    //   42: istore_3
    //   43: ldc 75
    //   45: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_0
    //   49: monitorexit
    //   50: iload_3
    //   51: ireturn
    //   52: iload_2
    //   53: iconst_1
    //   54: isub
    //   55: istore_2
    //   56: goto -39 -> 17
    //   59: iconst_0
    //   60: istore_3
    //   61: ldc 75
    //   63: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -18 -> 48
    //   69: astore 4
    //   71: aload_0
    //   72: monitorexit
    //   73: aload 4
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	pm
    //   0	76	1	paramFloat	float
    //   16	40	2	i	int
    //   42	19	3	bool	boolean
    //   69	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	69	finally
    //   21	41	69	finally
    //   43	48	69	finally
    //   61	66	69	finally
  }
  
  /* Error */
  public final boolean b(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 78
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_3
    //   17: iload_3
    //   18: iflt +44 -> 62
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_3
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: fload_2
    //   34: invokeinterface 80 3 0
    //   39: ifeq +16 -> 55
    //   42: iconst_1
    //   43: istore 4
    //   45: ldc 78
    //   47: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 4
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: isub
    //   58: istore_3
    //   59: goto -42 -> 17
    //   62: ldc 82
    //   64: invokestatic 87	com/tencent/mapsdk/internal/kh:a	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   71: invokevirtual 34	java/util/ArrayList:size	()I
    //   74: iconst_1
    //   75: isub
    //   76: istore_3
    //   77: iload_3
    //   78: iflt +26 -> 104
    //   81: aload_0
    //   82: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   85: iload_3
    //   86: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   89: checkcast 6	com/tencent/mapsdk/internal/es
    //   92: invokeinterface 40 1 0
    //   97: iload_3
    //   98: iconst_1
    //   99: isub
    //   100: istore_3
    //   101: goto -24 -> 77
    //   104: iconst_0
    //   105: istore 4
    //   107: ldc 78
    //   109: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: goto -62 -> 50
    //   115: astore 5
    //   117: aload_0
    //   118: monitorexit
    //   119: aload 5
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	pm
    //   0	122	1	paramFloat1	float
    //   0	122	2	paramFloat2	float
    //   16	85	3	i	int
    //   43	63	4	bool	boolean
    //   115	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	115	finally
    //   21	42	115	finally
    //   45	50	115	finally
    //   62	77	115	finally
    //   81	97	115	finally
    //   107	112	115	finally
  }
  
  /* Error */
  public final boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 89
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_1
    //   17: iload_1
    //   18: iflt +40 -> 58
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_1
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: invokeinterface 91 1 0
    //   37: ifeq +14 -> 51
    //   40: iconst_1
    //   41: istore_2
    //   42: ldc 89
    //   44: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_2
    //   50: ireturn
    //   51: iload_1
    //   52: iconst_1
    //   53: isub
    //   54: istore_1
    //   55: goto -38 -> 17
    //   58: iconst_0
    //   59: istore_2
    //   60: ldc 89
    //   62: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -18 -> 47
    //   68: astore_3
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	pm
    //   16	39	1	i	int
    //   41	19	2	bool	boolean
    //   68	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	68	finally
    //   21	40	68	finally
    //   42	47	68	finally
    //   60	65	68	finally
  }
  
  /* Error */
  public final boolean c(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 92
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_3
    //   17: iload_3
    //   18: iflt +44 -> 62
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_3
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: fload_2
    //   34: invokeinterface 94 3 0
    //   39: ifeq +16 -> 55
    //   42: iconst_1
    //   43: istore 4
    //   45: ldc 92
    //   47: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 4
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: isub
    //   58: istore_3
    //   59: goto -42 -> 17
    //   62: iconst_0
    //   63: istore 4
    //   65: ldc 92
    //   67: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -20 -> 50
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	pm
    //   0	80	1	paramFloat1	float
    //   0	80	2	paramFloat2	float
    //   16	43	3	i	int
    //   43	21	4	bool	boolean
    //   73	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	73	finally
    //   21	42	73	finally
    //   45	50	73	finally
    //   65	70	73	finally
  }
  
  /* Error */
  public final boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 96
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_1
    //   17: iload_1
    //   18: iflt +40 -> 58
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_1
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: invokeinterface 98 1 0
    //   37: ifeq +14 -> 51
    //   40: iconst_1
    //   41: istore_2
    //   42: ldc 96
    //   44: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_0
    //   48: monitorexit
    //   49: iload_2
    //   50: ireturn
    //   51: iload_1
    //   52: iconst_1
    //   53: isub
    //   54: istore_1
    //   55: goto -38 -> 17
    //   58: iconst_0
    //   59: istore_2
    //   60: ldc 96
    //   62: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: goto -18 -> 47
    //   68: astore_3
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_3
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	pm
    //   16	39	1	i	int
    //   41	19	2	bool	boolean
    //   68	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	68	finally
    //   21	40	68	finally
    //   42	47	68	finally
    //   60	65	68	finally
  }
  
  /* Error */
  public final boolean d(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 99
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_3
    //   17: iload_3
    //   18: iflt +44 -> 62
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_3
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: fload_2
    //   34: invokeinterface 101 3 0
    //   39: ifeq +16 -> 55
    //   42: iconst_1
    //   43: istore 4
    //   45: ldc 99
    //   47: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 4
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: isub
    //   58: istore_3
    //   59: goto -42 -> 17
    //   62: iconst_0
    //   63: istore 4
    //   65: ldc 99
    //   67: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -20 -> 50
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	pm
    //   0	80	1	paramFloat1	float
    //   0	80	2	paramFloat2	float
    //   16	43	3	i	int
    //   43	21	4	bool	boolean
    //   73	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	73	finally
    //   21	42	73	finally
    //   45	50	73	finally
    //   65	70	73	finally
  }
  
  /* Error */
  public final boolean e(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 103
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_3
    //   17: iload_3
    //   18: iflt +44 -> 62
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_3
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: fload_2
    //   34: invokeinterface 105 3 0
    //   39: ifeq +16 -> 55
    //   42: iconst_1
    //   43: istore 4
    //   45: ldc 103
    //   47: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 4
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: isub
    //   58: istore_3
    //   59: goto -42 -> 17
    //   62: iconst_0
    //   63: istore 4
    //   65: ldc 103
    //   67: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -20 -> 50
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	pm
    //   0	80	1	paramFloat1	float
    //   0	80	2	paramFloat2	float
    //   16	43	3	i	int
    //   43	21	4	bool	boolean
    //   73	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	73	finally
    //   21	42	73	finally
    //   45	50	73	finally
    //   65	70	73	finally
  }
  
  /* Error */
  public final boolean f(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 107
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_3
    //   17: iload_3
    //   18: iflt +44 -> 62
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_3
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: fload_2
    //   34: invokeinterface 109 3 0
    //   39: ifeq +16 -> 55
    //   42: iconst_1
    //   43: istore 4
    //   45: ldc 107
    //   47: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 4
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: isub
    //   58: istore_3
    //   59: goto -42 -> 17
    //   62: iconst_0
    //   63: istore 4
    //   65: ldc 107
    //   67: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -20 -> 50
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	pm
    //   0	80	1	paramFloat1	float
    //   0	80	2	paramFloat2	float
    //   16	43	3	i	int
    //   43	21	4	bool	boolean
    //   73	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	73	finally
    //   21	42	73	finally
    //   45	50	73	finally
    //   65	70	73	finally
  }
  
  /* Error */
  public final boolean g(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 111
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_3
    //   17: iload_3
    //   18: iflt +44 -> 62
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_3
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: fload_2
    //   34: invokeinterface 113 3 0
    //   39: ifeq +16 -> 55
    //   42: iconst_1
    //   43: istore 4
    //   45: ldc 111
    //   47: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 4
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: isub
    //   58: istore_3
    //   59: goto -42 -> 17
    //   62: iconst_0
    //   63: istore 4
    //   65: ldc 111
    //   67: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -20 -> 50
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	pm
    //   0	80	1	paramFloat1	float
    //   0	80	2	paramFloat2	float
    //   16	43	3	i	int
    //   43	21	4	bool	boolean
    //   73	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	73	finally
    //   21	42	73	finally
    //   45	50	73	finally
    //   65	70	73	finally
  }
  
  /* Error */
  public final boolean h(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 115
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_3
    //   17: iload_3
    //   18: iflt +44 -> 62
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_3
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: fload_2
    //   34: invokeinterface 117 3 0
    //   39: ifeq +16 -> 55
    //   42: iconst_1
    //   43: istore 4
    //   45: ldc 115
    //   47: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 4
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: isub
    //   58: istore_3
    //   59: goto -42 -> 17
    //   62: iconst_0
    //   63: istore 4
    //   65: ldc 115
    //   67: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -20 -> 50
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	pm
    //   0	80	1	paramFloat1	float
    //   0	80	2	paramFloat2	float
    //   16	43	3	i	int
    //   43	21	4	bool	boolean
    //   73	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	73	finally
    //   21	42	73	finally
    //   45	50	73	finally
    //   65	70	73	finally
  }
  
  /* Error */
  public final boolean i(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 118
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_3
    //   17: iload_3
    //   18: iflt +44 -> 62
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_3
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: fload_2
    //   34: invokeinterface 120 3 0
    //   39: ifeq +16 -> 55
    //   42: iconst_1
    //   43: istore 4
    //   45: ldc 118
    //   47: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 4
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: isub
    //   58: istore_3
    //   59: goto -42 -> 17
    //   62: iconst_0
    //   63: istore 4
    //   65: ldc 118
    //   67: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -20 -> 50
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	pm
    //   0	80	1	paramFloat1	float
    //   0	80	2	paramFloat2	float
    //   16	43	3	i	int
    //   43	21	4	bool	boolean
    //   73	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	73	finally
    //   21	42	73	finally
    //   45	50	73	finally
    //   65	70	73	finally
  }
  
  /* Error */
  public final boolean j(float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 122
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   11: invokevirtual 34	java/util/ArrayList:size	()I
    //   14: iconst_1
    //   15: isub
    //   16: istore_3
    //   17: iload_3
    //   18: iflt +44 -> 62
    //   21: aload_0
    //   22: getfield 25	com/tencent/mapsdk/internal/pm:a	Ljava/util/ArrayList;
    //   25: iload_3
    //   26: invokevirtual 38	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   29: checkcast 6	com/tencent/mapsdk/internal/es
    //   32: fload_1
    //   33: fload_2
    //   34: invokeinterface 124 3 0
    //   39: ifeq +16 -> 55
    //   42: iconst_1
    //   43: istore 4
    //   45: ldc 122
    //   47: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 4
    //   54: ireturn
    //   55: iload_3
    //   56: iconst_1
    //   57: isub
    //   58: istore_3
    //   59: goto -42 -> 17
    //   62: iconst_0
    //   63: istore 4
    //   65: ldc 122
    //   67: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: goto -20 -> 50
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	pm
    //   0	80	1	paramFloat1	float
    //   0	80	2	paramFloat2	float
    //   16	43	3	i	int
    //   43	21	4	bool	boolean
    //   73	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	73	finally
    //   21	42	73	finally
    //   45	50	73	finally
    //   65	70	73	finally
  }
  
  public final boolean k(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(226000);
    int i = this.a.size() - 1;
    while (i >= 0)
    {
      if (((es)this.a.get(i)).k(paramFloat1, paramFloat2))
      {
        AppMethodBeat.o(226000);
        return true;
      }
      i -= 1;
    }
    AppMethodBeat.o(226000);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pm
 * JD-Core Version:    0.7.0.1
 */