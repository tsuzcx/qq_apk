package com.tencent.mm.emoji.sync;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bb.a;
import com.tencent.mm.vending.c.a;
import d.g.b.q;
import d.l;
import d.z;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "designerUin", "", "(I)V", "TAG", "", "cgiTask", "Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "getDesignerUin", "()I", "call", "", "uniqueId", "CgiGetDesignerTask", "plugin-emojisdk_release"})
public final class b
  extends c
{
  private final String TAG;
  final int gmg;
  private final a grl;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(183974);
    this.gmg = paramInt;
    this.TAG = "MicroMsg.EmojiDesignerTask";
    this.grl = new a(this.gmg, (d.g.a.b)new b(this));
    AppMethodBeat.o(183974);
  }
  
  public final String aeW()
  {
    AppMethodBeat.i(183973);
    int i = this.gmg;
    AppMethodBeat.o(183973);
    return String.valueOf(i);
  }
  
  public final void call()
  {
    AppMethodBeat.i(183972);
    ae.i(this.TAG, "call: " + this.gmg);
    this.grl.agq();
    AppMethodBeat.o(183972);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/sync/EmojiDesignerTask$CgiGetDesignerTask;", "", "designerUin", "", "callback", "Lkotlin/Function1;", "", "", "(ILkotlin/jvm/functions/Function1;)V", "TAG", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "dbList", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getDesignerUin", "()I", "packList", "Ljava/util/LinkedList;", "reqBuff", "", "finish", "getNext", "start", "plugin-emojisdk_release"})
  public static final class a
  {
    final String TAG;
    final d.g.a.b<Boolean, z> glc;
    private final int gmg;
    byte[] gmh;
    final LinkedList<String> grm;
    private final bb grn;
    
    public a(int paramInt, d.g.a.b<? super Boolean, z> paramb)
    {
      AppMethodBeat.i(183969);
      this.gmg = paramInt;
      this.glc = paramb;
      this.TAG = "MicroMsg.EmojiDesignerTask";
      this.grm = new LinkedList();
      paramb = bb.a.JfB;
      this.grn = bb.a.abA(this.gmg);
      AppMethodBeat.o(183969);
    }
    
    final void agq()
    {
      AppMethodBeat.i(183968);
      new e(this.gmg, this.gmh).aET().g((a)new b.a.a(this));
      AppMethodBeat.o(183968);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<Boolean, z>
  {
    b(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.sync.b
 * JD-Core Version:    0.7.0.1
 */