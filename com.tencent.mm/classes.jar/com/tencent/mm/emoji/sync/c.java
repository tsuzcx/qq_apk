package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cw.f;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bg.a;
import com.tencent.mm.vending.c.a;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "designerUin", "", "(I)V", "TAG", "", "cgiTask", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "getDesignerUin", "()I", "call", "", "uniqueId", "CgiGetDesignerTask", "plugin-emojisdk_release"})
public final class c
  extends com.tencent.mm.loader.g.c
{
  private final String TAG;
  final int jHU;
  private final a jND;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(183974);
    this.jHU = paramInt;
    this.TAG = "MicroMsg.EmojiDesignerTask";
    this.jND = new a(this.jHU, (b)new b(this));
    AppMethodBeat.o(183974);
  }
  
  public final String aBG()
  {
    AppMethodBeat.i(183973);
    int i = this.jHU;
    AppMethodBeat.o(183973);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(183972);
    Log.i(this.TAG, "call: " + this.jHU);
    this.jND.aDf();
    AppMethodBeat.o(183972);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "", "designerUin", "", "callback", "Lkotlin/Function1;", "", "", "(ILkotlin/jvm/functions/Function1;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "dbList", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getDesignerUin", "()I", "packList", "Ljava/util/LinkedList;", "reqBuff", "", "finish", "getNext", "start", "plugin-emojisdk_release"})
  public static final class a
  {
    final String TAG;
    final b<Boolean, x> callback;
    private final int jHU;
    byte[] jHV;
    final LinkedList<String> jNE;
    private final bg jNF;
    
    public a(int paramInt, b<? super Boolean, x> paramb)
    {
      AppMethodBeat.i(183969);
      this.jHU = paramInt;
      this.callback = paramb;
      this.TAG = "MicroMsg.EmojiDesignerTask";
      this.jNE = new LinkedList();
      paramb = bg.a.VFn;
      this.jNF = bg.a.asF(this.jHU);
      AppMethodBeat.o(183969);
    }
    
    final void aDf()
    {
      AppMethodBeat.i(183968);
      new e(this.jHU, this.jHV).bhW().g((a)new c.a.a(this));
      AppMethodBeat.o(183968);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "invoke"})
  static final class b
    extends q
    implements b<Boolean, x>
  {
    b(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.c
 * JD-Core Version:    0.7.0.1
 */