package com.tencent.mm.plugin.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class a<T extends c>
{
  public BKGLoaderManager pMY;
  
  public a()
  {
    AppMethodBeat.i(108744);
    b.a locala = new b.a();
    locala.pMZ = 1;
    locala.pNa = 10;
    com.tencent.mm.av.a.e.a locala1 = new com.tencent.mm.av.a.e.a();
    locala.pNb = new b.b(locala.pMZ, locala.pMZ, locala1);
    a(new b(locala));
    AppMethodBeat.o(108744);
  }
  
  /* Error */
  private void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 54
    //   4: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 56	com/tencent/mm/plugin/emoji/sync/a:pMY	Lcom/tencent/mm/plugin/emoji/sync/BKGLoaderManager;
    //   11: ifnonnull +23 -> 34
    //   14: aload_0
    //   15: new 58	com/tencent/mm/plugin/emoji/sync/BKGLoaderManager
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 60	com/tencent/mm/plugin/emoji/sync/BKGLoaderManager:<init>	(Lcom/tencent/mm/plugin/emoji/sync/b;)V
    //   23: putfield 56	com/tencent/mm/plugin/emoji/sync/a:pMY	Lcom/tencent/mm/plugin/emoji/sync/BKGLoaderManager;
    //   26: ldc 54
    //   28: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: ldc 62
    //   36: ldc 64
    //   38: invokestatic 69	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: ldc 54
    //   43: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: goto -15 -> 31
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	a
    //   0	54	1	paramb	b
    // Exception table:
    //   from	to	target	type
    //   2	31	49	finally
    //   34	46	49	finally
  }
  
  public final void Q(ArrayList<c> paramArrayList)
  {
    AppMethodBeat.i(108746);
    this.pMY.cT(paramArrayList);
    AppMethodBeat.o(108746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a
 * JD-Core Version:    0.7.0.1
 */