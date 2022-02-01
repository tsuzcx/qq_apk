package com.tencent.mm.plugin.emoji.h;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Vector;

public final class a<T extends d>
{
  public c uGy;
  
  public a()
  {
    AppMethodBeat.i(108744);
    b.a locala = new b.a();
    locala.uGA = 1;
    locala.uGB = 10;
    com.tencent.mm.ay.a.e.a locala1 = new com.tencent.mm.ay.a.e.a();
    locala.uGC = new b.b(locala.uGA, locala.uGA, locala1);
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
    //   8: getfield 56	com/tencent/mm/plugin/emoji/h/a:uGy	Lcom/tencent/mm/plugin/emoji/h/c;
    //   11: ifnonnull +23 -> 34
    //   14: aload_0
    //   15: new 58	com/tencent/mm/plugin/emoji/h/c
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 60	com/tencent/mm/plugin/emoji/h/c:<init>	(Lcom/tencent/mm/plugin/emoji/h/b;)V
    //   23: putfield 56	com/tencent/mm/plugin/emoji/h/a:uGy	Lcom/tencent/mm/plugin/emoji/h/c;
    //   26: ldc 54
    //   28: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: ldc 62
    //   36: ldc 64
    //   38: invokestatic 69	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  public final void X(ArrayList<d<?>> paramArrayList)
  {
    AppMethodBeat.i(108746);
    this.uGy.dh(paramArrayList);
    AppMethodBeat.o(108746);
  }
  
  public final void c(com.tencent.mm.emoji.sync.a parama)
  {
    AppMethodBeat.i(258199);
    this.uGy.e(parama);
    AppMethodBeat.o(258199);
  }
  
  public final void cVk()
  {
    AppMethodBeat.i(258194);
    h.ZvG.be(new a.1(this));
    AppMethodBeat.o(258194);
  }
  
  public final int cVl()
  {
    AppMethodBeat.i(258196);
    c localc = this.uGy;
    if (localc.uGP != null)
    {
      int i = localc.uGP.size();
      AppMethodBeat.o(258196);
      return i;
    }
    AppMethodBeat.o(258196);
    return 0;
  }
  
  public final void d(com.tencent.mm.emoji.sync.a parama)
  {
    AppMethodBeat.i(258200);
    this.uGy.f(parama);
    AppMethodBeat.o(258200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.h.a
 * JD-Core Version:    0.7.0.1
 */