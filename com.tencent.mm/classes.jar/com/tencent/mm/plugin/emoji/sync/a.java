package com.tencent.mm.plugin.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class a<T extends d>
{
  public c xPe;
  
  public a()
  {
    AppMethodBeat.i(108744);
    b.a locala = new b.a();
    locala.xPg = 1;
    locala.xPh = 10;
    com.tencent.mm.modelimage.loader.d.a locala1 = new com.tencent.mm.modelimage.loader.d.a();
    locala.xPi = new b.b(locala.xPg, locala.xPg, locala1);
    a(new b(locala));
    AppMethodBeat.o(108744);
  }
  
  /* Error */
  private void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 56
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 58	com/tencent/mm/plugin/emoji/sync/a:xPe	Lcom/tencent/mm/plugin/emoji/sync/c;
    //   11: ifnonnull +23 -> 34
    //   14: aload_0
    //   15: new 60	com/tencent/mm/plugin/emoji/sync/c
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 62	com/tencent/mm/plugin/emoji/sync/c:<init>	(Lcom/tencent/mm/plugin/emoji/sync/b;)V
    //   23: putfield 58	com/tencent/mm/plugin/emoji/sync/a:xPe	Lcom/tencent/mm/plugin/emoji/sync/c;
    //   26: ldc 56
    //   28: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: ldc 64
    //   36: ldc 66
    //   38: invokestatic 71	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: ldc 56
    //   43: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void ab(ArrayList<d<?>> paramArrayList)
  {
    AppMethodBeat.i(108746);
    this.xPe.fd(paramArrayList);
    AppMethodBeat.o(108746);
  }
  
  public final void c(com.tencent.mm.emoji.sync.a parama)
  {
    AppMethodBeat.i(269797);
    this.xPe.e(parama);
    AppMethodBeat.o(269797);
  }
  
  public final void d(com.tencent.mm.emoji.sync.a parama)
  {
    AppMethodBeat.i(269801);
    this.xPe.f(parama);
    AppMethodBeat.o(269801);
  }
  
  public final void dAK()
  {
    AppMethodBeat.i(269787);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269795);
        Object localObject = l.aUF().aUH();
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRJ, 20);
        Iterator localIterator = ((List)localObject).iterator();
        while (localIterator.hasNext())
        {
          EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)localIterator.next();
          if ((localEmojiGroupInfo.field_sync != 2) && (!Util.isEqual(localEmojiGroupInfo.field_productID, String.valueOf(EmojiGroupInfo.aklD))))
          {
            if (Util.isEqual(localEmojiGroupInfo.field_productID, String.valueOf(EmojiGroupInfo.aklD))) {}
            for (localObject = new com.tencent.mm.plugin.emoji.sync.a.b("com.tencent.xin.emoticon.tusiji");; localObject = new com.tencent.mm.plugin.emoji.sync.a.a(localEmojiGroupInfo.field_productID))
            {
              if (localEmojiGroupInfo.field_idx >= i) {
                break label166;
              }
              localArrayList2.add(localObject);
              break;
            }
            label166:
            localArrayList1.add(localObject);
          }
        }
        a.this.xPe.dAM();
        a.this.xPe.fe(localArrayList2);
        a.this.xPe.fd(localArrayList1);
        if (!a.this.xPe.xPp) {
          a.this.xPe.dAN();
        }
        AppMethodBeat.o(269795);
      }
    });
    AppMethodBeat.o(269787);
  }
  
  public final int dAL()
  {
    AppMethodBeat.i(269794);
    c localc = this.xPe;
    if (localc.xPv != null)
    {
      int i = localc.xPv.size();
      AppMethodBeat.o(269794);
      return i;
    }
    AppMethodBeat.o(269794);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.sync.a
 * JD-Core Version:    0.7.0.1
 */